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
    <link rel="stylesheet" type="text/css" href="Css/calendar-blue.css"/>
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="layer-v3.1.1/layer/layer.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/calendar.js"></script>
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
<form class="form-inline definewidth m20" action="ts/getTsInfo/${vo.vid}" method="post">
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入手机号或者姓名" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>推手邀请码</th>
        <th>电话号码</th>
     	<th>支付宝</th>
        <th>真实姓名</th>
        <th>未打款金额</th>
        <th>已打款金额</th>
        <th>邀请人数</th>
        <th>上次打款时间</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list}" var="u">
	     <tr>
              <td>${u.tsid} </td>
              <td>${u.phone}</td>
        	  <td>${u.ailpay}</td>
        	  <td>${u.realname}</td>
        	  <td>${u.ljmoney}</td>
        	  <td>${u.dkmoney}</td>
        	  <td>${u.yqren}</td>
        	  <td>${u.nexttime}</td>
             <td>
                 <a  onclick="details(${u.tsid})" href="javascript:;">打款</a>
             </td>
         </tr>
        </c:forEach>
</table>
<form action="ts/getTsInfo/${vo.vid}" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
<script>
    function details(tsid){
        layer.open({
            type: 2,
            title:  false,
            shadeClose: true,
            shade: 0.8,
            area: ['500px', '90%'],
            content: '<%=path%>/ts/passMoney/'+tsid //iframe的url
        });
    };
    </script>
</body>
</html>
