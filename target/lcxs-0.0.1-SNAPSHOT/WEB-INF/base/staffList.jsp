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
<form class="form-inline definewidth m20" action="staff/findAll" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入手机号或者姓名" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <shiro:hasPermission name="STAFF_ALL">
    <button type="button" class="btn btn-success" id="addnew">新增员工</button>
    </shiro:hasPermission>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
     	<th>员工类型</th>
        <th>类型描述</th>
        <th>手机号码</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
            <td>${u.sid}</td>
              <td>${u.realname}</td>
        	  <td>
        	  	<c:if test="${u.stype ==1}">管理员</c:if>
        	  	<c:if test="${u.stype==2}">客服</c:if>
        	  	<c:if test="${u.stype==3}">运营</c:if>
        	  	<c:if test="${u.stype==4}">IT人员</c:if>
        	  	<c:if test="${u.stype==5}">财务</c:if>
        	  </td>
        	  <td>${u.context}</td>
        	  <td>${u.phone}</td>
        	  <shiro:hasPermission name="STAFF_ALL">
            <td> 
            	<a href="staff/goToUpdateStaff/${u.sid}">修改员工信息</a> 
                <a href="staff/deleteStaff/${u.sid}"  onclick="return confirm('确定删除?');">删除</a>
                <a href="javascript:;" onclick="change(${u.sid})">重置密码</a>
            </td>
            </shiro:hasPermission>
        </tr>	
        </c:forEach>
</table>
<form action="staff/findAll" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
  <script type="text/javascript" src="Js/layer/layer.js"></script>
  <script type="text/javascript">

function change(sid){
    layer.prompt({title: '请输入新密码', formType: 1}, function(pass, index){
	  layer.close(index);
	  var url="staff/change";
	  var param={"sid":sid,"pass":pass}
	     $.post(url,param,function(date){
	     	if(date.result==1){
	     		layer.msg('修改成功!', {
							  icon: 6,
							  time: 1000
							})
	     	}else{
	     		layer.msg('修改失败!', {
							  icon: 5,
							  time: 1000
							})
	     	}	
	     })
	  }) 
   }
$(function () {
    	

		$('#addnew').click(function(){
			
				window.location.href="<%=path%>/staff/goToAddStaff";
		 });

    });
</script>
</div>
</body>

</html>
