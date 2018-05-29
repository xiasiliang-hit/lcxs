<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
 <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <link rel="stylesheet" type="text/css" href="Css/calendar-blue.css"/>
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/ajaxfileupload.js"></script>
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
	<script type="text/javascript" src="Js/calendar.js"></script>
	<script type="text/JavaScript" src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
			CKEDITOR.replace('TextArea1');
			CKEDITOR.replace('TextArea2');
	</script>
    <style type="text/css">
     #ctime{   
         width:33px;   
         height:16px;   
         background:url(Css/calendar.png) no-repeat right;   
         cursor:pointer; 
         } 
     .div1 {
        position: relative;
    }

    .div2 {
        width: 100px;
        height: 26px;
        background: #2178fc;
        color: #fff;
        text-align: center;
        line-height: 26px;
    }

    .file_input {
        width: 200px;/*因为file-input在部分浏览器中会自带一个输入框，需要双击才可以点击上传,放大后将其定位到div外面就好啦*/
        height: 36px;
        position: absolute;
        left: -100px;
        top: 0;
        z-index:1;
        -moz-opacity: 0;
        -ms-opacity: 0;
        -webkit-opacity: 0;
        opacity: 0;  /*css属性——opcity不透明度，取值0-1*/
        filter: alpha(opacity=0); /*兼容IE8及以下--filter属性是IE特有的，它还有很多其它滤镜效果，而filter: alpha(opacity=0); 兼容IE8及以下的IE浏览器(如果你的电脑IE是8以下的版本，使用某些效果是可能会有一个允许ActiveX的提示,注意点一下就ok啦)*/
        cursor: pointer;
    }
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
        /***错误提示样式***/ 
		form.cmxform label.error, label.error { 
		color: red; 
		font-style: italic; 
		} 
    </style>
</head>
<body>
<form id="signupForm" action="cshop/insert" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
       <input type="hidden" name="id" value="${shop.id}">
  		<input type="hidden" name="shopid" value="${shop.shopid}">
    <tr>
         <td  class="tableleft">商户名称</td>
        <td><input type="text" name="shopname" placeholder="请输入商户名称" value="${shop.shopname}"/></td>
    </tr>
    <tr>
         <td  class="tableleft">商户联系号码</td>
       	<td><input type="text" name="shopphone" placeholder="请输入商户联系号码" value="${shop.shopphone}"/></td>
       	<span style="color: #ff0000;">${massage }</span>
    </tr>
     <tr>
         <td  class="tableleft">注册资本</td>
         <td><input type="text" name="regcap" placeholder="请输入注册资本" value="${shop.regcap}"/></td>
    </tr> 
    <tr>
         <td  class="tableleft">商户背景</td> 
        <td><input type="text" name="background" placeholder="请输入商户背景" value="${shop.background}"/> 
        </td>	
    </tr>    
    <tr>
         <td  class="tableleft">渠道来源</td>
         <td>
		 <select name="channel" id="schannel">
		 	<option></option>
		 	<c:forEach items="${pageModel.list}" var="s">
		 	<option  value="${s.cname}"  <c:if test="${s.cname==shop.channel}">selected="selected"</c:if>>${s.cname}</option>		 	</c:forEach>
		 </select>        
		 </td>
    </tr> 
    <tr>
         <td  class="tableleft">石墨链接</td>
        <td><input type="text" name="smurl" placeholder="请输入有效石墨链接" value="${shop.smurl}"/> 
        </td>
    </tr>
    <tr>
         <td  class="tableleft">平台链接</td>
        <td><input type="text" name="shopurl" placeholder="请输入有效平台链接" value="${shop.shopurl}"/> 
        </td>
    </tr>
    <tr>
         <td  class="tableleft">商户地址</td>
        <td><input type="text" name="address" placeholder="请输入商户地址" value="${shop.address}"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">融资背景</td>
        <td><input type="text" name="financing" placeholder="请输入融资背景" value="${shop.financing}"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">风险评分</td>
        <td><input type="text" name="risk" placeholder="请输入风险评分" value="${shop.risk}"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">所在地区</td>
        <td><input type="text" name="area" placeholder="请输入所在地区" value="${shop.area}"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">推荐理由</td>
        <td><textarea id="TextArea1" class="ckeditor" cols="30" rows="2" name="recommend" placeholder="请输入推荐理由" >${shop.recommend}</textarea> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">商户排序简介</td>
        <td><textarea id="TextArea2" class="ckeditor" cols="30" rows="2" name="context" placeholder="请输入商户排序简介" >${shop.context}</textarea> 
        </td>
    </tr> 
     <tr>
         <td  class="tableleft">标签</td>
        <td><input type="text" name="tag" placeholder="请输入标签" value="${shop.tag}"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">排序</td>
        <td><input type="text" name="sort" placeholder="请输入排序，排序越高排名越靠前" value="${shop.sort}"/> 
        </td>
    </tr>
     <tr>
         <td  class="tableleft">logo地址</td>
         <td>
         <div class="div1">
    		<div class="div2">上传logo</div>
         <input type ="file"  class="file_input" id="ImportPicInput" name="myfile"/>
         </div>  
         <input  type="hidden" name="logo" id="logo" value="${shop.logo}"/>
		<img  src="${shop.logo}" id ="imgInit"  width="20%" height="20%" />
      	</td> 
    </tr> 
    <tr>
         <td  class="tableleft">pc返利链接</td>
        <td><input type="text" name="pcurl" placeholder="请输入有效返利链接" value="${shop.pcurl}" style="width:300px;"/> 
        </td>
    </tr> 
    <tr>
         <td  class="tableleft">app返利链接</td>
        <td><input type="text" name="appurl" placeholder="请输入有效返利链接" value="${shop.appurl}" style="width:300px;"/> 
        </td>
    </tr> 
    <tr>
		      <td width="10%" class="tableleft">上线时间</td>
		      <td><input type="text" name="ctime" id="ctime" style="margin-top:10px; height:24px;width:150px;font-size:15px;" value="${shop.ctime}"></td>
    </tr>
   
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
        </td>
    </tr>
</table>
</form>
</body>
<script>
Calendar.setup({
    inputField : "ctime",
    ifFormat   : "%Y-%m-%d",
    showsTime  : false,
    timeFormat : "24"
});
$("#ImportPicInput").change(function() {

        updatelogo();
    });
function updatelogo(){
	 $.ajaxFileUpload({
          url: 'img/addImg', //用于文件上传的服务器端请求地址
          secureuri: false, //是否需要安全协议，一般设置为false
          fileElementId: 'ImportPicInput', //文件上传域的ID
          dataType: 'json', //返回值类型 一般设置为json
          success: function (data){
              var dataObj=eval("("+data+")");
		  		if(dataObj.code==0){
		  			alert(dataObj.msg);
		  		}
		  		if(dataObj.code==1){
		  			alert(dataObj.msg);
		  		}
		  		if(dataObj.code==2){
		  			alert(dataObj.msg);
		  		}
		  		if(dataObj.code==3){
		  			var url=dataObj.url;
		  			document.getElementById("imgInit").src=url;	 
		  			document.getElementById("logo").value=url;	 
		  		}
          },error:function(e){
                alert("错误！！");
            }
      })
} 
$(function () {
  		 CKEDITOR.replace('TextArea1', { height: '150px' });
  		 CKEDITOR.replace('TextArea2', { height: '150px' });
	});


$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	shopname:{
                 required: true,
       		 },
      		regcap:{
      			required: true,
      			number:true,
      		 },
      		background:{
      			required:true,
     		 },
     		financing:{
      			required:true,
     		 }, 
     		risk:{
      			required:true,
      			number:true,
     		 }, 
     		area:{
      			required:true,
     		 },  
     		recommend:{
      			required:true,
     		 },  
     		context:{
      			required:true,
     		 },  
     		sort:{
      			required:true,
      			number:true,
     		 },  
     		tag:{
      			required:true,
     		 },  
     		more:{
      			required:true,
     		 }, 
     		pcurl:{
      			required:true,
     		 },  
     		appurl:{
      			required:true,
     		 },  
        },
	        messages:{
	        	shopname:{
	                required:"请输入信息",
	                
	        },
	    		regcap:{
	            	required:"请输入金额",
	            	number:"请输入数字金额",
	    	},
	    		background:{
            		required:"请输入信息",
	    	},
    			financing:{
	    			required:"请输入信息",
			},
				risk:{
	    			required:"请输入信息",
	    			number:"请输入数字评分",
			},
				area:{
	    			required:"请输入信息",
			},
				recommend:{
	    			required:"请输入信息",
			},
				context:{
					required:"请输入信息",
			},
				tag:{
					required:"请输入信息",
			},
				sort:{
					required:"请输入信息",
					number:"请输入数字排序",
			},
				more:{
					required:"请输入链接",
			},
				pcurl:{
					required:"请输入链接",
			},
				appurl:{
					required:"请输入链接",
			}
	   }
    });
});

</script>
</html>
