<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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


    </style>
</head>
<body>
<div>
	
</div>
<form class="form-inline definewidth m20" action="user/getFriendInfo/${vo.vid}" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入手机号或者姓名" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>好友编号</th>
        <th>好友手机号</th>
     	<th>支付宝姓名</th>
        <th>注册时间</th>
        <th>总投资额</th>
        <th>(总返利+总红包)</th>
        <th>通过回单数</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
            <td>${u.vid} </td>
              <td>${u.phone}</td>
        	  <td>${u.realname}</td>
        	  <td>${u.ctime}</td>
        	  <td><fmt:formatNumber value="${u.totalMoney }" pattern="#0.0"/></td>
        	  <td>(  ${u.totalJMoney } +${u.totalRedMoney}  )</td>
        	  <td>${u.count}</td>
        </tr>
        </c:forEach>
        <tr>
        	<td>总计</td>
        	<td></td>
        	<td></td>
        	<td></td>
        	<td><fmt:formatNumber value="${vo.sum}" pattern="#0.0"/></td>
        	<td>(  ${vo.jsum}+${vo.rsum}  )</td>
        	<td>${vo.number}</td>
        </tr>
</table>
<form action="user/getFriendInfo/${vo.vid}" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
</html>
