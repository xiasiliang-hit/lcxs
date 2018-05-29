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
	<script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
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
<form id="signupForm" action="staff/addOrUpdateStaff" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
	<input type="hidden" name="sid" value="${employee.sid}">
  		<tr>
         <td  class="tableleft">权限</td>
        <td>
        <input type="radio" name="stype" value="1" <c:if test="${employee.stype==1}">checked="checked"</c:if>/> 管理员
        <input type="radio" name="stype" value="2" <c:if test="${employee.stype==2}">checked="checked"</c:if>/> 客服
        <input type="radio" name="stype" value="3" <c:if test="${employee.stype==3}">checked="checked"</c:if>/> 运营 
        <input type="radio" name="stype" value="4" <c:if test="${employee.stype==4}">checked="checked"</c:if>/> IT 
        <input type="radio" name="stype" value="5" <c:if test="${employee.stype==5}">checked="checked"</c:if>/> 财务
        </td>
    </tr> 	
    <tr>
        <td  class="tableleft">员工姓名</td>
        <td><input type="text" name="realname" value="${employee.realname}"/></td>
    </tr>
    <tr>
         <td  class="tableleft">手机号码</td> 
        <td><input type="text" name="phone" value="${employee.phone}"/> 
        </td>	
    </tr>    
    <tr>
         <td  class="tableleft">员工描述</td>
        <td><input type="text" name="context" value="${employee.context}">
        </td>
    </tr> 
    <c:if test="${employee.sid==null}">
    	<tr>
         <td  class="tableleft">员工密码</td>
        <td><input type="text" name="password">
        </td>
    </tr> 
    </c:if>
    <tr>
         <td  class="tableleft">客服QQ</td>
        <td><input type="text" name="kfqq" value="${employee.kfqq}" placeholder="如果不是客服可以不填">
        </td>
    </tr>
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" >保存</button>
        </td>
    </tr>
</table>
</form>
<script>
	$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	stype:{
                required: true,
       		 },
        	phone:{
                required: true,
       		 },
       		realname:{
                required: true, 
      		 },
      		 password:{
      		 	required: true,
      		 }
        },
	        messages:{
	        	stype:{
	                required:"请选择员工类型",  
	        },
	        	phone:{
	                required:"请输入手机号码",
	        },
	        	realname:{
	            	required:"名字不能为空",
	    	},
	    		password:{
	            	required:"密码不能为空",
	    	},
	        }
    });
});
</script>
</body>
</html>