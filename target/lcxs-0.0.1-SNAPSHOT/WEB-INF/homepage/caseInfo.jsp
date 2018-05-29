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
<form class="form-inline definewidth m20" action="homepage/findCaseInfo" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入方案名" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>方案名称</th>
        <th>入围人数</th>
     	<th>投资总额</th>
        <th>方案金发放总额</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list}" var="u">
	     <tr>
            <td>${u.name}</td>
              <td>${u.person}</td>
        	  <td><fmt:formatNumber value="${u.tmoney}" pattern="#0.0"/></td>
        	  <td>${u.jmoney}</td>
        </tr>	
        </c:forEach>
</table>
<form action="homepage/findCaseInfo" id="pager" name="pager" method="post">
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
  </script>
</div>
</body>
</html>
