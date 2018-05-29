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
<form class="form-inline definewidth m20" action="ccase/findOldById/${vo.keywordsauid } " method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入方案名称" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>方案序号</th>
        <th>方案名</th>
     	<th>期限</th>
        <th>项目</th>
        <th>金额</th>
        <th>返利</th>
        <th>利息</th>
        <th>红包</th>
        <th>体验金</th>
        <th>状态</th>
        <th>创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
              <td>${u.cid}</td>
              <td>${u.casename }</td>
        	  <td>${u.dtime}</td>
        	  <td>${u.project}</td>
        	  <td>${u.money}</td>
        	  <td>${u.interest }</td>
        	  <td>${u.rebate }</td>
        	  <td>${u.red }</td>
        	  <td>${u.experience }  </td>
        	   <td>${u.status==1?'正常':'冻结' }</td>
        	  <td>${u.ctime}</td>
        	  
            <td>
                <a href="ccase/upByid/${u.id}/${vo.keywordsauid }"   onclick="return confirm('确定恢复?');">恢复</a>  
            </td>
        </tr>	
        </c:forEach>
</table>
<form action="ccase/findOldById/${vo.keywordsauid }" id="pager" name="pager" method="post">
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
