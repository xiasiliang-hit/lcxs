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
<form id="signupForm" action="message/addOrUpdate" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
	<input type="hidden" name="id" value="${message.id}">
    <tr>
        <td  class="tableleft">消息标题</td>
        <td><input type="text" name="title" value="${message.title}"/></td>
    </tr>
    <tr>
         <td  class="tableleft">消息内容</td>
        <td><textarea id="TextArea1" class="ckeditor" cols="30" rows="2" name="context" >${message.context}</textarea>
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
        	title:{
                required: true,
       		 },
        	content:{
                required: true,
       		 },
        },
	        messages:{
	        	title:{
	                required:"请填写消息标题",
	        },
	        	content:{
	                required:"请填写消息内容",
	        },
	        }
    });
});
</script>
</body>
</html>