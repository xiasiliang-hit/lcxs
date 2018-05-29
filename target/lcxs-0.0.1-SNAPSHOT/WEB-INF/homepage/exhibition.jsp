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
    <style type="text/css">
    	#d1,#d2,#d3,#d4{
    		margin:20px;
    	}
    	.c1,.c2,.c3,.c4{
            position: relative;
            right: 20px;
            top: 0px;
    	}
    	div{border-radius:5px;}
    	.h1{
    		font-size:36px;
    	}
    	.gray-bg{
    		background-color: #f0f3f4;
    	}
    </style>
</head>
<body class="gray-bg">
    	<div>
    		<div id="d1" style="text-align:center;float: left;width: 20%;height: 100px; background-color: #fff;">
    			<ul class="c1" style="list-style:none">
    			<li style="color:#23b7e5"  class="h1">
    				${person}
    			</li>
    			<li style="color:#d6d3e6">
    				今日注册人数
    			</li>
    			</ul>
    		</div>
    		<div id="d2" style="text-align:center;float: left;width: 20%;height: 100px;background-color:#23b7e5;">
    			<ul class="c2" style="list-style:none">
    			<li style="color:#fff"   class="h1">
    				${AllPerson}
    			</li>
    			<li style="color:#d6d3e6">
    				总注册人数
    			</li>
    			</ul>
    		</div>
    		<div id="d3" style="text-align:center;float: left;width: 20%;height: 100px;background-color:#7266ba;">
    			<ul class="c3" style="list-style:none">
    			<li style="color:#fff"   class="h1">
    				${moneyPerson }
    			</li>
    			<li>
    				今日打款人数
    			</li>
    			</ul>
    		</div>
    		<div  id="d4" style="text-align:center;float: left;width: 20%;height: 100px;background-color:#E3E3E3;">
    			<ul class="c4" style="list-style:none">
    			<li  class="h1">
    				${money eq null?'0.0':money}
    			</li>
    			<li>
    				打款总金额
    			</li>
    			</ul>
    		</div>
    	</div>
</body>
</html>
