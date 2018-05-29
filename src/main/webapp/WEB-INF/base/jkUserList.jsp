<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
<form class="form-inline definewidth m20" action="" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="手机号-编号-支付宝-邀请码-被邀请码" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <input type="button"  class="btn btn-success" id="selectteacher"  value="导出用户">
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户编号</th>
        <th>手机号</th>
     	<th>支付宝姓名</th>
     	<th>支付宝账号</th>
        <th>总投资金额</th>
        <th>总返现金额</th>
        <th>注册时间</th>
        <th>个人邀请码</th>
        <th>邀请人邀请码</th>
        <th>已邀请人数</th>
        <th>投资清单</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
            <td>${u.vid}</td>
              <td>${u.phone}</td>
        	  <td>${u.realname}</td>
        	  <td>${u.alipay}</td>
        	  <td><fmt:formatNumber value="${u.totalMoney}" pattern="#0.0"/></td>
        	  <td>(${u.totalJMoney}+${u.totalRedMoney})</td>
        	  <td>${u.ctime}</td>
        	  <td>${u.owninvitation}</td>
        	  <td>${u.invitation}</td>
        	  <td>${u.count}</td>
        	  <shiro:hasPermission name="USER_ALL">
        	  <td><a href="user/getInvestmentTable/${u.vid}">查看</a></td>
            <td style="width:120px">
                <a href="user/deleteUser/${u.vid}"   onclick="return confirm('确定删除?');">删除</a> 
                <a href="javascript:;" onclick="changpwd(${u.vid})">重置密码</a> 
            </td>
            </shiro:hasPermission>
        </tr>	
        </c:forEach>
</table>
<form action="user/findAll" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
  <script type="text/javascript" src="Js/layer/layer.js"></script>
  <script>
   function changpwd(vid){
    layer.prompt({title: '请输入新密码', formType: 1}, function(pass, index){
	  layer.close(index);
	  var url="user/changePwd";
	  var param={"vid":vid,"pass":pass}
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

//excel导出方法
	$('#selectteacher').click(function(){
		window.location.href="user/excelDownloadUser";
	});
  </script>
</div>
</body>
</html>
