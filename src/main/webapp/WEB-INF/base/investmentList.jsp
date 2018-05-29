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
<form class="form-inline definewidth m20" action="user/getInvestmentTable/${vo.keywordsauid }" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入产品名称或平台名称" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>投资平台</th>
     	<th>投资金额</th>
        <th>投资时间</th>
        <th>返利金额</th>
        <th>红包金额</th>
        <th>状态</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr id="first">
              <td>${u.productname}</td>
        	  <td>${u.tmoney}</td>
        	  <td>${u.ttime}</td>
        	  <td>${u.jmoney}</td>
        	  <td>${u.redmoney}</td>
 			<c:if test="${u.status==1}">
				<td>通过</td> 			
 			</c:if>
 			<c:if test="${u.status==2}">
				<td>驳回</td> 			
 			</c:if>
 			<c:if test="${u.status==3}">
				<td>未审核</td> 			
 			</c:if>
 			<c:if test="${u.status==4}">
				<td>已打款</td> 			
 			</c:if>
 			<c:if test="${u.status==5}">
				<td>已删除</td> 			
 			</c:if>
        </tr>	
        </c:forEach>
</table>
<form action="user/getInvestmentTable/${vo.keywordsauid }" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>

</html>
