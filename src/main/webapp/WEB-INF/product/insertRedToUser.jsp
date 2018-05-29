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
    <link rel="stylesheet" type="text/css" href="Css/calendar-blue.css"/>
   <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
	<script type="text/javascript" src="Js/calendar.js"></script>
    <style type="text/css">
        #ctime{   
         width:33px;   
         height:16px;   
         background:url(Css/calendar.png) no-repeat right;   
         cursor:pointer; 
         } 
          #dtime{
         width:33px;   
         height:16px;   
         background:url(Css/calendar.png) no-repeat right;   
         cursor:pointer; 
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
<form id="signupForm" action="cred/insertRedToUser/${staff.sid}" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
         <input type="hidden" name="id" value="${userRed.id }">
         <input type="hidden" name="redid" value="${userRed.redid }">
         <tr>
         		<td width="10%" class="tableleft">红包标题</td>
        		<td><input type="text" name="redname" placeholder="请输入红包标题" value="${userRed.redname}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包金额</td>
		       	<td><input type="text" name="redmoney" placeholder="请输入红包金额" value="${userRed.redmoney}"/></td>
    	</tr>

		<tr>
			<td width="10%" class="tableleft">用户手机号</td>
			<td><input type="text" name="phone" placeholder="请输入用户手机号" value="${userBean.phone}"/></td>
		</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包使用条件</td>
		       	<td><input type="text" name="redcondition" placeholder="累计红包请输入正确的累计金额" value="${userRed.redcondition}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">领取后有效天数</td>
		       	<td><input type="text" name="days" placeholder="请输入领取后有效天数" value="${userRed.days}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包使用说明</td>
		       	<td><input type="text" name="context" placeholder="请输入红包使用说明" value="${userRed.context}"/></td>
    	</tr>
    	<tr>
		   		<td>
		            <button type="submit" class="btn btn-primary">发送</button>
		        </td>
    	</tr>
</table>
</form>


</body>
</html>
<script>




$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
        	redname:{
                required:true,
       		 },
       		redmoney:{
       			required: true,
                number:true,
      		 },
      		redcondition:{
       			required:true,
                number:true,
      		 },
      		 
      		lqtj:{
      			 required:true,
      		 },
      		days:{
      			required:true,
      			number:true,
     		 },
            phone:{
                required: true,
                number:true,
            },
        },
	        messages:{
	        	redname:{
	                required:"请输入名字",
	        },
	        	redmoney:{
	            	required:"请输入金额",
	            	number:"请输入数字金额",
	    	},
                phome:{
                    required:"用户手机号",
                },
	    		lqtj:{
	            	required:"请输入信息",
	    	},

	    		days:{
            		required:"请输入天数",
            		number:"请输入数字天数",
	    	},
	    	 redcondition:{
            		required:"累积红包需输入正确的累积金额",
            		number:"请输入数字",
	    	},

	   }
    });
});

</script>