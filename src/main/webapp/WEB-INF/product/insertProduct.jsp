<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
	<script type="text/JavaScript" src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
			CKEDITOR.replace('TextArea1');
	</script>
    <style type="text/css">
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
<form id="signupForm" action="cproduct/insertProduct/${vo.keywordsauid }" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
         <input type="hidden" name="id" value="${product.id }">
         <input type="hidden" name="id" value="${product.pid }">
         <input type="hidden" name="shopid" value="${product.shopid }">
         <input type="hidden" name="shopname" value="${product.shopname }">
    	<tr>
		         <td  class="tableleft">产品名称</td>
		       	<td><input type="text" name="pname" placeholder="如：温商贷" value="${product.pname}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">平均收益水平</td>
		       	<td><input type="text" name="level" placeholder="如：12%-17.8%" value="${product.level}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">举例金额</td>
		       	<td><input type="text" name="minmoney" placeholder="如：1000" value="${product.minmoney}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">举例收益</td>
		       	<td><input type="text" name="example" placeholder="如：17.8" value="${product.example}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">举例年化</td>
		       	<td><input type="text" name="xnh" placeholder="如：190" value="${product.xnh}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">举例期限</td>
		       	<td><input type="text" name="qx" placeholder="举例期限以天为单位，如：30" value="${product.qx}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">产品排序</td>
		       	<td><input type="text" name="sort" placeholder="如：100" value="${product.sort}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">特别说明</td>
		       	<td><textarea id="TextArea1" class="ckeditor" cols="30" rows="2" name="context">${product.context}</textarea> 
		       </td>
    	</tr>
    	<tr>
         <td  class="tableleft">投资类型</td>
        	<td>
        	<input type="radio" name="typestz" id="typestz1" value="1" <c:if test="${product.typestz==1}">checked="checked"</c:if>/> 首投
        	<input type="radio" name="typestz" id="typestz2" value="2" <c:if test="${product.typestz==2}">checked="checked"</c:if>/> 复投
        	</td>
    	</tr> 
    	<tr>
         <td  class="tableleft">盈利类型</td>
        	<td>
        	<input type="radio" name="typesyl" id="radio1" value="1" <c:if test="${product.typesyl==1}">checked="checked"</c:if>/> 稳健
	        <input type="radio" name="typesyl" id="radio2" value="2" <c:if test="${product.typesyl==2}">checked="checked"</c:if>/> 高返
            <input type="radio" name="typesyl" id="radio3" value="3" <c:if test="${product.typesyl==3}">checked="checked"</c:if>/> 信用
        	</td>
    	</tr>
    	<tr>
		         <td  class="tableleft">造假人数</td>
		       	<td><input type="text" name="people" placeholder="如：100" value="${product.people}"/></td>
		       
    	</tr>
    	<tr>
         <td  class="tableleft">角标</td>
        	<td>
        	<input type="radio" name="jb" id="jb1" value="1" <c:if test="${product.jb==1}">checked="checked"</c:if>/> 无
        	<input type="radio" name="jb" id="jb2" value="2" <c:if test="${product.jb==2}">checked="checked"</c:if>/> 爆款
        	<input type="radio" name="jb" id="jb3" value="3" <c:if test="${product.jb==3}">checked="checked"</c:if>/> 活动
        	<input type="radio" name="jb" id="jb4" value="4" <c:if test="${product.jb==4}">checked="checked"</c:if>/> 推荐
        	</td>
    	</tr> 
    	<tr>
         <td  class="tableleft">手机端首页推荐</td>
        	<td>
        	<input type="radio" name="appurl" id="appurl1" value="1" <c:if test="${product.appurl==1}">checked="checked"</c:if>/> 不推荐	
        	<input type="radio" name="appurl" id="appurl2" value="2" <c:if test="${product.appurl==2}">checked="checked"</c:if>/> 推荐
        	</td>
    	</tr> 
    	<tr>
		   		<td>
		            <button type="submit" class="btn btn-primary" type="button">保存</button> 
		        </td>
    	</tr>
</table>
</form>
<script>
function Number(){
	var num = "${shop.channel}";
	if(num==null || num==""){
		return;
	}else{
	var numbers = document.getElementById("schannel").children; //获取select下拉框的所有值
		for(var opt in numbers){
	        if(numbers[opt].value==num){
	        	numbers[opt].selected="selected";
	            return;
	        }
	    }
    }
}
$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	pname:{
                required: true,
       		 },
       		level:{
                required: true,
      		 },
      		minmoney:{
      			 required: true,
      			 number:true,
      		 },
      		example:{
      			required: true,
      			number:true,
     		 },
     		ynh:{
      			required: true,
     		 }, 
     		qx:{
      			required: true,
      			number:true,
      			
     		 }, 
     		sort:{
      			required: true,
      			number:true,
     		 }, 
     		describe:{
      			required:true,
     		 },  
     		people:{
      			required: true,
      			number:true,
     		 },  
     		schedule:{
      			required: true,
      			number:true,
     		 },
     		 zhnh:{
      			required: true,
      			
     		 }  
        },
	        messages:{
	        	pname:{
	                required:"请输入名字",
	        },
	        	level:{
	            	required:"请输入收益",
	    	},
	    		minmoney:{
	            	required:"请输入金额",
	            	number:"请输入数字金额",
	    	},
	    		example:{
            		required:"请输入数字",
            		number:"请输入数字",
	    	},
	    		ynh:{
        			required:"请输如年化",
    		},
    			qx:{
	    			required:"请输入天数",
	    			number:"请输入数字"
	    			
			},
				sort:{
	    			required:"请输入排序",
	    			number:"请输入数字排序",
			},
				describe:{
	    			required:"请输入信息",
			},
				people:{
	    			required:"请输入信息",
	    			number:"请输入数字人数",
			},
				schedule:{
					required:"请输入信息",
					number:"请输入数字",
			},
			zhnh:{
					required:"请输入信息",		
			}
	   }
    });
});
</script>
</body>
</html>
