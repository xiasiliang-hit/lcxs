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
<body onload="Number()">
<form id="signupForm" action="cchannel/insert" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
		
       <input type="hidden" name="id" value="${channel.id}">
  		<input type="hidden" name="shopid" value="${channel.cid}">
    <tr>
         <td width="10%" class="tableleft">渠道名称</td>
        <td><input type="text" name="cname" placeholder="请输入渠道名称" value="${channel.cname}"/></td>
    </tr>
    <tr>
         <td width="10%" class="tableleft">联系人</td>
       	<td><input type="text" name="realname" placeholder="请输入联系人" value="${channel.realname}"/></td>
       	
    </tr>
     <tr>
         <td width="10%" class="tableleft">联系电话</td>
         <td><input type="text" name="phone" placeholder="请输入联系电话" value="${channel.phone}"/></td>
         <span style="color: #ff0000;">${massage }</span>
    </tr> 
    <tr>
         <td width="10%" class="tableleft">QQ号码</td> 
        <td><input type="text" name="qnumber" placeholder="请输入QQ号" value="${channel.qnumber}"/> 
        </td>	
    </tr> 
     <tr>
         <td width="10%" class="tableleft">微信号码</td> 
        <td><input type="text" name="wnumber" placeholder="请输入微信号" value="${channel.wnumber}"/> 
        </td>	
    </tr>  
    <input type="hidden" name="person" value="${staff.realname}"/> 
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button"  >保存</button> &nbsp;&nbsp;
        </td>
    </tr>
</table>
</form>
</body>
<script>
$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	cname:{
        		required:true,
       		 },
       		realname:{
                required:true,
      		 },
      		phone:{
                required: true,
      		 }
        },
	        messages:{
	        	cname:{
	                required:"请输入名字",
	        },
	        realname:{
	            	required:"请输入联系人名字",
	    	},
	    	phone:{
                required:"请输入手机号码",
	    	}
	 	   }
	     });
	 });

</script>
</html>
