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
<form id="signupForm" action="cred/insertRed" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
         <input type="hidden" name="id" value="${red.id }">
         <input type="hidden" name="redid" value="${red.redid }">
         <tr>
         		<td width="10%" class="tableleft">红包标题</td>
        		<td><input type="text" name="redname" placeholder="请输入红包标题" value="${red.redname}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包金额</td>
		       	<td><input type="text" name="redmoney" placeholder="请输入红包金额" value="${red.redmoney}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包使用条件</td>
		       	<td><input type="text" name="redcondition" placeholder="累计红包请输入正确的累计金额" value="${red.redcondition}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包领取条件</td>
		       	<td><input type="text" name="lqtj" placeholder="请输入领取条件" value="${red.lqtj}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">领取后有效天数</td>
		       	<td><input type="text" name="days" placeholder="请输入领取后有效天数" value="${red.days}"/></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">活动开始时间</td>
		       	<td><input type="text" name="ctime" id="ctime" style="margin-top:10px; height:24px;width:150px;font-size:15px;" value="${red.ctime}"></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">活动截止时间</td>
		       	<td><input type="text" name="dtime" id="dtime" style="margin-top:10px; height:24px;width:150px;font-size:15px;" value="${red.dtime}"></td>
    	</tr>
    	<tr>
		         <td width="10%" class="tableleft">红包使用说明</td>
		       	<td><input type="text" name="context" placeholder="请输入红包使用说明" value="${red.context}"/></td>
    	</tr>
	<tr>
		<td width="10%" class="tableleft">红包类型</td>
		<td><input type="radio"  name="status" value="1" <c:if test="${red.status==1}">checked="checked"</c:if>/> 正常红包
		<input type="radio"  name="status" value="3" <c:if test="${red.status==3}">checked="checked"</c:if>/> 活动红包</td>
	</tr>
    	<tr>
		   		<td>
		            <button type="submit" class="btn btn-primary">保存</button> 
		        </td>
    	</tr>
</table>
</form>


</body>
</html>
<script>

Calendar.setup({
    inputField : "ctime",
    ifFormat   : "%Y-%m-%d",
    showsTime  : false,
    timeFormat : "24"
});
Calendar.setup({
    inputField : "dtime",
    ifFormat   : "%Y-%m-%d",
    showsTime  : false,
    timeFormat : "24"
});



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
     		dtime:{
      			required:true,
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
	    	dtime:{
	    		required:"请填入正确信息"
	    	},
	   }
    });
});

</script>