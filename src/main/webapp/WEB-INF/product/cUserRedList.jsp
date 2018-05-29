<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
<form class="form-inline definewidth m20" action="cred/findUserAll" method="post">
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入红包名称" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
     	<th>红包名</th>
        <th>红包领取天数</th>
        <th>红包金钱</th>
        <th>红包领取条件</th>
        <th>红包使用条件</th>
        <th>使用说明</th>
        <th>红包是否生效</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list}" var="u">
	     <tr>
        	  <td>${u.redname}</td>
        	  <td>${u.days}</td>
        	  <td>${u.redmoney}</td>
        	  <td>${u.redname}</td>
        	  <td>${u.context}</td>
        	  <td>${u.redname}</td>
        	  <td>${u.type==0?'未使用':'已使用'}</td>
        </tr>	
        </c:forEach>
</table>
<%--<form action="cred/findUserAll" id="pager" name="pager" method="post">--%>
   <%--<input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">--%>
   <%--<input type="hidden" name="keywords" value="${vo.keywords }">  --%>
    <%--<input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">--%>
<%--</form>--%>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
<script type="text/javascript">


</script>
</html>
