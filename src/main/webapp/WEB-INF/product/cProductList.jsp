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
<form class="form-inline definewidth m20" action="cproduct/findAll" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入商户或产品名称" value="${vo.keywords}">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="findold">查看历史产品</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
      	<th  class="sorting"  style="width: 81px;">商户名</th>
        <th  class="sorting"  style="width: 100px;">产品名</th>
        <th  class="sorting"  style="width: 100px;">平均收益水平</th>
        <th  class="sorting"  style="width: 100px;">年收益率</th>
        <th  class="sorting_desc"  style="width: 15px;">创建时间</th>
        <th  class="sorting"  style="width: 100px;">状态</th>
        <th  class="sorting_disabled"  style="width: 100px;">操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
            <tr>
			    <td>${u.shopname}</td>
			    <td>${u.pname}</td>
			    <td>${u.level}</td>
				<td>${u.xnh }</td>
        	  	<td>${u.ctime}</td>
        	  	<td>上架</td>
            	<td> 
            		<%-- <a href="cproduct/goToAdd/${u.shopid }">新增该商户产品</a> --%>
				    <a href="ccase/findById/${u.pid }">查看方案</a>
				    <a href="cproduct/goToUpdate/${u.pid }">编辑</a>  
				    <a href="cproduct/deleteBypid/${u.pid}"   onclick="return confirm('确定下架?');">下架</a>  
            	</td>
        	</tr>	
        </c:forEach>
</table>
<form action="cproduct/findAll" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
<script type="text/javascript">
      $(function () {


		$('#findold').click(function(){
			
				window.location.href="<%=path%>/cproduct/findOld/"
		 });

    });
</script>
</html>
