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
<form class="form-inline definewidth m20" action="cproduct/findOldByShopid/${vo.keywordsauid }" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入产品名称" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>商户名</th>
     	<th>产品名</th>
        <th>期数</th>
        <th>平均收益水平</th>
        <th>年收益率</th>
        <th>状态</th>
        <th>排序</th>
        <th>最高返利</th>
        <th>综合年化</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
              <td>${u.shopname}</td>
        	  <td>${u.pname}</td>
        	  <td>${u.schedule}</td>
        	  <td>${u.level}</td>
        	  <td>${u.ynh }</td>
        	  <td>${u.status==1?'上架':'下架' }</td>
        	  <td>${u.sort }</td>
        	  <td>${u.maxfl }  </td>
        	  <td>${u.zhnh }  </td>
        	  <td>${u.ctime}</td>
        	  
            <td>
            	<a href="cproduct/goToUpdate/${u.pid }">编辑</a>  
                <a href="cproduct/upBypid/${u.pid}"   onclick="return confirm('确定上架?');">上架</a>  
            </td>
        </tr>	
        </c:forEach>
</table>
<form action="cproduct/findOldByShopid/${vo.keywordsauid }" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
<script type="text/javascript">
    
</script>
</html>
