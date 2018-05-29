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
<form class="form-inline definewidth m20" action="note/findAllNote" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入公告名称" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增公告</button>
</form>

<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>公告标题</th>
        <th>公告内容</th>
     	<th>创建时间</th>
        <th>类型</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list}" var="u">
	     <tr>
            <td>${u.title} </td>
              <td>${u.content}</td>
        	  <td>${u.ctime}</td>
        	  <td>
        	  	<c:if test="${u.type ==1}">公告</c:if>
        	  	<c:if test="${u.type==2}">帮助</c:if>
        	  </td>
        	  <td style="width:180px">
            	<a href="note/goToUpdate/${u.id}">编辑</a>  
                <a href="note/deleteNote/${u.id}"   onclick="return confirm('确定删除?');">删除</a> 
            </td>
        </tr>
        </c:forEach>
</table>
<form action="note/findAllNote" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
    <script type="text/javascript">
$(function () {
		$('#addnew').click(function(){
			window.location.href="<%=path%>/note/goToAdd";
		 });

    });
</script>
</div>
</body>
</html>
