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
    <script type="text/javascript" src="layer-v3.1.1/layer/layer.js"></script>
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
<form class="form-inline definewidth m20" action="user/invite" method="post">    
    关键字：
    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入手机号或者姓名" value="${vo.keywords }">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<th>用户编号</th>
        <th>用户手机号</th>
        <th>支付宝姓名</th>
        <th>未打取金额</th>
        <th>已打取金额</th>
        <th>邀请人数</th>
        <th>上次打款时间</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
	     	  <td class="_vid">${u.vid} </td>
              <td>${u.phone} </td>
              <td>${u.realname}</td>
        	  <td id="_ljm">${u.ljmoney}</td>
        	  <td id="_dkm">${u.dkmoney}</td>
        	  <td>${u.count}</td>
        	  <td>${u.mtime}</td>
        	  <shiro:hasPermission name="FRIENDS_ALL">
        	  <td>
        	  	<a href="javascript:;" onclick="payMoney(${u.vid})">打款</a>
        	  	<a href="user/getFriendInfo/${u.vid}">详情</a>
        	  </td>
        	  </shiro:hasPermission>
        </tr>	
        </c:forEach>
</table>
<form action="user/invite" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
<script>
	 function payMoney(vid){
    	layer.open({
            type: 1
            ,title: '确认打款吗？' 
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确认', '取消']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content:'<div style="line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="form-group" style="padding: 15px; margin-bottom: 5px;"><label >填写打款金额</label><input id="ydkmoney" type="text" class="form-control" placeholder="请输入" style="margin: 0; padding: 0 20px;"></div></div>'
            ,yes:function(index,layero){
            	var ydk = $('#ydkmoney').val();
                var invi={
                	userid:vid,
                	dkmoney:ydk,
                }
                 $.ajax({
		             type: "Post",
		             contentType: "application/json; charset=utf-8",
		             url: "user/payMoneyForUser",
		             data: JSON.stringify(invi),
		             success: function(data){
		             var dataObj=eval("("+data+")");
	    		  		if(dataObj.code==1){


	    		  		layer.msg('打款成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							  location.reload();
							});
	    		  		}else{
	    		  			layer.msg('打款金额不能比未领取金额大!',{
	    		  			  icon: 5,
							  time: 1000
							}, function(){
							  location.reload();
							});
	    		  		}
	               	 },
	                 error:function(e){
	                    alert("错误！！");
                	 }
           	 }
            )
            	layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        }
    )}
</script>
</body>
</html>
