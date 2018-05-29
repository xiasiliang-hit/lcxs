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
	<script type="text/JavaScript" src="ckeditor/ckeditor.js"></script>
	<script type="text/javascript">
			CKEDITOR.replace('TextArea1');
			CKEDITOR.replace('TextArea2');
	</script>
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
<form id="signupForm" action="cred/bindingRed/" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
       <input type="hidden" name="vid" value="">
  	
    <tr>
         <td  class="tableleft">红包名称</td>
         <td>
		 <select name="redname" id="redname">
		 	<option>请选择红包</option>
		 	<c:forEach items="${list}" var="s">
		 	<option  value="${s.redname}">${s.redname}</option>
		 	</c:forEach>
		 </select>        
		 </td>
    </tr>
    <tr>
     <td  class="tableleft">
            <button type="submit" class="btn btn-primary" >发送红包</button>
     </td>
     <td></td>
    </tr>    
</table>
</form>
</body>
<script>
</script>
</html>
