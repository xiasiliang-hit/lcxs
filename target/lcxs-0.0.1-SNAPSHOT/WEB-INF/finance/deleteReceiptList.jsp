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
         #J_time_start{   
         width:33px;   
         height:16px;   
         background:url(Css/calendar.png) no-repeat right;   
         cursor:pointer; 
         } 
         #J_time_end{   
         width:33px;   
         height:16px;   
         background:url(Css/calendar.png) no-repeat right;   
         cursor:pointer; 
         }  
    </style>
</head>
<body onload="getCurrentMonthFirst()">
<div style="float:left">
<form class="form-inline definewidth m20" action="receipt/queryAll/5" method="post">   
<div style="float: left;width: 20%">
    关键字：
    </div>
    <div style="float: left;width: 20%">
    <input type="text"  name="keywords" id="keywords"class="abc input-default" placeholder="请输入平台用户名或手机号" value="${vo.keywords }">&nbsp;&nbsp;
    </div>
    <div style="float: right;width: 20%">
    &nbsp;&nbsp;<button   type="submit" class="btn btn-primary">查询</button>
    </div>
</form>
</div>
<div style="margin: 20px 0px 0px 30px">
	<input type="text"   name="time_start" id="J_time_start" style="margin-top:20px; height:24px;width:150px;font-size:15px;" onblur="start()">
    -<input type="text"   name="time_end" id="J_time_end" style="margin-top:20px;height:24px;width:150px;font-size:15px;" onblur="end()">
    <input type="button" class="btn btn-success"  id="sub" style="margin-top:10px;" value="按日期查询" >
    <input type="button"  class="btn btn-success" id="selectteacher" style="margin-top:10px;" value="按日期导出">
</div>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>回单编号</th>
        <th>用户编号</th>
        <th>支付宝姓名</th>
        <th>投资产品</th>
        <th>平台用户名</th>
        <th>平台手机号</th>
        <th>投资期限</th>
        <th>投资金额</th>
        <th>总返利金</th>
        <th>方案返利</th>
        <th>红包</th>
        <th>拿货价格</th>
        <th>渠道来源</th>
        <th>投资时间</th>
        <th>提交时间</th>
        <th>审核时间</th>
        <th>备注</th>
        <th>审核人</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
       <c:forEach items="${pageModel.list }" var="u">
	     <tr>
            <td>${u.rid} </td>
            <td>${u.vid}</td>
            <td>${u.name}</td>
            <td>${u.productname}</td>
              <td>${u.realname}</td>
        	  <td>${u.phone}</td>
        	  <td>${u.dtime}</td>
        	  <td>${u.tmoney}</td>
        	  <td>${u.totalMoney}</td>
        	  <td>${u.jmoney}</td>
        	  <td>${u.redmoney}</td>
        	  <td>${u.tprice}</td>
        	  <td>${u.channel}</td>
        	  <td>${u.ttime}</td>
        	  <td>${u.ctime}</td>
        	  <td>${u.mtime}</td>
        	  <td>${u.context}</td>
        	  <td>${u.auditor }</td>
        	  <td>已删除</td>
            <td style="width:50px">
                <a href="javascript:;" onclick="details(${u.rid})">详情</a>
            </td>
        </tr>	
        </c:forEach>
</table>
<form action="receipt/queryAll/5" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
<script>

Calendar.setup({
    inputField : "J_time_start",
    ifFormat   : "%Y-%m-%d",
    showsTime  : false,
    timeFormat : "24"
});
Calendar.setup({
    inputField : "J_time_end",
    ifFormat   : "%Y-%m-%d",
    showsTime  : false,
    timeFormat : "24"
});
//给日历上默认值
function getCurrentMonthFirst(){
	 var date=new Date();
	 var year=date.getFullYear(); 
	 var month=date.getMonth()+1;
	 var day=date.getDate();
	 month =(month<10 ? "0"+month:month); 
	 var mydate = (year.toString()+"-"+month.toString()+"-"+day.toString());
	 document.getElementById("J_time_end").value=mydate;//把当前日期设置为input框中的默认值 yyyy-mm-dd
	 var lw = new Date(date - 1000 * 60 * 60 * 24 * 30);//最后一个数字30可改，30天的意思
	 var lastY = lw.getFullYear();
	 var lastM = lw.getMonth()+1;
	 var lastD = lw.getDate();
	 var startdate=lastY+"-"+(lastM<10 ? "0" + lastM : lastM)+"-"+(lastD<10 ? "0"+ lastD : lastD);//三十天之前日期
	 document.getElementById("J_time_start").value=startdate;
}

//excel导出方法
	$('#selectteacher').click(function(){
	var start=$("input[name='time_start']").val()
	var end=$("input[name='time_end']").val()
	startdate=Date.parse(new Date(start.replace(/-/g, "/")));  
	enddate=Date.parse(new Date(end.replace(/-/g, "/")));  
	var millTime=enddate-startdate;
		if(millTime < 0 || start==undefined || start==null || start=="" || end==null || end==undefined || end==""){
			alert("输入时间有误，请重新输入");
   			return;
        }
		window.location.href="receipt/excelDowloadreceipt/"+5+"/"+start+"/"+end;
	});

//查询方法
 $('#sub').click(function(){
 	var start=$("input[name='time_start']").val()
	var end=$("input[name='time_end']").val()
	startdate=Date.parse(new Date(start.replace(/-/g, "/")));  
	enddate=Date.parse(new Date(end.replace(/-/g, "/")));  
	var millTime=enddate-startdate;
   if(millTime < 0 || start==undefined || start==null || start=="" || end==null || end==undefined || end==""){
   	alert("输入时间有误，请重新输入");
   	return;
   }
   window.location.href="receipt/queryAnyDayOfReceipt/"+start+"/"+end+"/"+5;
 });
		 function details(rid){
		    layer.open({
			  type: 2,
			  title:  false,
			  shadeClose: true,
			  shade: 0.8,
			  area: ['500px', '90%'],
			  content: '<%=path%>/receipt/queryByRid/'+rid //iframe的url
			}); 
		  };
</script>
</html>
