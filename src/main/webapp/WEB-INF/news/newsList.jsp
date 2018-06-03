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
<form class="form-inline definewidth m20" action="news/findAll" method="post">
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入新闻标题" value="${vo.keywords }">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp;
    <button type="button" class="btn btn-success" id="addnew">新增新闻</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>新闻编号</th>
        <th>新闻标题</th>
        <th>新闻摘要</th>
        <th>新闻来源</th>
        <th>点赞数量</th>
        <th>收藏数量</th>
        <th>新闻时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${pageModel.list }" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.title}</td>
            <td>${u.context}</td>
            <td>${u.source}</td>
            <td>${u.praise}</td>
            <td>${u.collection}</td>
            <td>${u.ntime}</td>
            <td>
                <a href="cproduct/findByShopid/${u.id }">新闻详情</a>
                <a href="cshop/goToUpdate/${u.id }">编辑</a>
                <a href="news/deleteByNewsid/${u.id}"   onclick="return confirm('确定删除?');">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="cshop/findAll" id="pager" name="pager" method="post">
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


        $('#addnew').click(function(){

            window.location.href="<%=path%>/cshop/goToAdd";
        });

    });
    $(function () {


        $('#findold').click(function(){

            window.location.href="<%=path%>/cshopUpdate/findAll";
        });

    });
    $(function () {


        $('#findoldS').click(function(){

            window.location.href="<%=path%>/cshop/findOld";
        });

    });

</script>
</html>
