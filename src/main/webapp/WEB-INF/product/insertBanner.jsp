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
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/ajaxfileupload.js"></script>
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
    <style type="text/css">
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
<form id="signupForm" action="cbanner/insertBanner" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
       <input type="hidden" name="id" value="${banner.id}">
    <tr>
         <td  class="tableleft">标题</td>
        <td><input type="text" name="title" placeholder="请输入标题" value="${banner.title}"/></td>
    </tr>
    <tr>
         <td  class="tableleft">排序</td>
       	<td><input type="text" name="sort" placeholder="请输入排序，排序越高排名越靠前" value="${banner.sort}"/></td>
    </tr>
     <tr>
         <td  class="tableleft">类型</td>
		       <td>
        			<input type="radio" name="type" id="type1" value="1" <c:if test="${banner.type==1}">checked="checked"</c:if>/> PC端
        			<input type="radio" name="type" id="type2" value="2" <c:if test="${banner.type==2}">checked="checked"</c:if>/> 手机端
        		</td>
    </tr> 
    <tr>
         <td  class="tableleft">图片</td> 
        <td>
         <div class="div1">
    		<div class="div2">上传图片</div>
         <input type ="file"  class="file_input" id="ImportPicInput" name="myfile"/>
         </div>  
         <input  type="hidden" name="picture" id="logo" value="${banner.picture}"/>
		<img  src="${banner.picture}" id ="imgInit"/>
      	</td> 	
    </tr>    
    <tr>
         <td  class="tableleft">地址url</td>
        <td><input type="text" name="link" placeholder="请输入地址url" value="${banner.link}"/> 
        </td>
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
$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	title:{
                 required: true,
       		 },
      		sort:{
      			required: true,
      		 },
      		link:{
      			required:true,
        },
	        messages:{
	        	title:{
	                required:"请输入信息",
	                
	        },
	    		sort:{
	            	required:"请输入信息",
	    	},
			
				link:{
					required:"请输入链接",
	        }
	        }}
    });
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
</script>
</html>
