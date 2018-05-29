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
    <link rel="stylesheet" type="text/css" href="Css/calendar-blue.css"/>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
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
<form class="form-inline definewidth m20" action="receipt/queryAll/3" method="post" id="form">
<input type="hidden" name="" id="real" value="${staff.realname }">
<input type="hidden" name="ctimepx" id="ctimepx" value="${vo.ctimepx}"> 
<input type="hidden" name="ttimepx" id="ttimepx" value="${vo.ttimepx}">   
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
    <input type="text"   name="time_end" id="J_time_end" style="margin-top:20px;height:24px;width:150px;font-size:15px;" onblur="end()">
    <input type="button" class="btn btn-success"  id="sub" style="margin-top:10px;" value="按日期查询" >
    <input type="button"  class="btn btn-success" id="selectteacher" style="margin-top:10px;" value="按日期导出">
    <shiro:hasPermission name="RECEIPT_ALL">
    <div style="float: right; padding: 20px 30px 0px 0px">
    <a href="javascript:;" onclick="qx()">全选</a>
	<a href="javascript:;" onclick="fx()">反选</a>
	<a href="javascript:;" onclick="pltg()">批量通过</a>
	</div>
	</shiro:hasPermission>
</div>
<table class="table table-bordered table-hover definewidth m10" id="sample-table">
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
        <th id="tzsj">投资时间<img style="width: 16px;height:16px;" src="images/pximg.png"></th>
        <th id="tjsj">提交时间<img style="width: 16px;height:16px;" src="images/pximg.png"></th>
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
        	  <td>未审核</td>
            <td style="width: 100px">
            	<input type="checkbox" name="gg" value="${u.rid}">
            	<a href="javascript:;" onclick="details(${u.rid})">详情</a>
            	<shiro:hasPermission name="RECEIPT_ALL">
            	<a href="javascript:;" onclick="notice(${u.rid},${u.jmoney})">通过</a> 
            	<a href="javascript:;" onclick="reject(${u.rid})">驳回</a>  
                <a href="javascript:;" onclick="dereceipt(${u.rid})">删除</a>  
                </shiro:hasPermission>
            </td>
        </tr>	
        </c:forEach>
</table>
<form action="receipt/queryAll/3" id="pager" name="pager" method="post">
   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
   <input type="hidden" name="keywords" value="${vo.keywords }">  
    <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
</form>
<div class="inline pull-right page" align="center">
  <%@include file="../../pageBar.jsp" %>
</div>
</body>
<script>
var real =$("#real").val();
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

function qx() {
    var box=document.getElementById('sample-table');
    var rd=box.getElementsByTagName('input');
    for(var i=0;i<rd.length;i++){
        rd[i].checked=true
    }
}

function fx() {
    var box=document.getElementById('sample-table');
    var rd=box.getElementsByTagName('input');
    for(var i=0;i<rd.length;i++){
        rd[i].checked=false
    }
}
$("#tzsj").click(function(){
	var a=$("#ctimepx").val();
	$("#ctimepx").val(Number(a)+1);
	$("#ttimepx").val("0");
	document.getElementById("form").submit();
})
$("#tjsj").click(function(){
	var a=$("#ttimepx").val();
	$("#ttimepx").val(Number(a)+1);
	$("#ctimepx").val("0");
	document.getElementById("form").submit();
})

function pltg(){
		layer.open({
            type: 1
            ,title: '是否要通过审核' 
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确认', '取消']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content:''
            ,yes:function(index,layero){
				var chk_value =[];
				$('input[name="gg"]:checked').each(function(){
			        chk_value.push($(this).val());
			    });
			    chk_value.push(real);
			    $.ajax({
			            type: "Post",
			            contentType: "application/json; charset=utf-8",
			            url: "receipt/listUpdateToReceipt",
			            data: JSON.stringify(chk_value),
			            success: function(data){
			            	var dataObj=eval("("+data+")");
			  		  		if(dataObj.code==1){
			  		  		layer.msg('批量通过成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							  location.reload();
							});
			  		  		}else{
			  		  			layer.msg('批量通过失败!',{
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
		window.location.href="receipt/excelDowloadreceipt/"+3+"/"+start+"/"+end;
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
   window.location.href="receipt/queryAnyDayOfReceipt/"+start+"/"+end+"/"+3;
 });
   function details(rid){
		    layer.open({
			  type: 2,
			  title: false,
			  shadeClose: true,
			  shade: 0.8,
			  area: ['500px', '90%'],
			  content: '<%=path%>/receipt/queryByRid/'+rid //iframe的url
			})
		  }
		  
	function notice(rrid,jmoney){
        layer.open({
            type: 1
            ,title: '是否要通过审核' 
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确认', '取消']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content:'<div style="line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"> <div  style="padding: 15px; margin-bottom: 5px;"><label >填写通过备注</label><input id="context" type="text"  placeholder="可不填" style="margin: 0; padding: 0 10px;"></div><div  style="padding:0 15px 15px 15px; margin-bottom: 5px;"><label >方案返利</label><input id="money" type="text"  value="'+jmoney+'" style="margin: 0; padding: 0 10px;"></div></div>'
            ,yes:function(index,layero){
           		var con = $('#context').val();
                var lastMoney = $('#money').val();
                var receipt={
                	rid:rrid,
                	context:con,
                	jmoney:lastMoney,
                	auditor:real
                }
                 $.ajax({
		             type: "Post",
		             contentType: "application/json; charset=utf-8",
		             url: "receipt/passReceipt",
		             data: JSON.stringify(receipt),
		             success: function(data){
		             var dataObj=eval("("+data+")");
	    		  		if(dataObj.code==1){
	    		  		layer.msg('设置成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							  location.reload();
							});
	    		  		}else{
	    		  			layer.msg('设置失败!',{
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
    
    function reject(rrid){
    	layer.open({
            type: 1
            ,title: '确认要驳回该回单吗？' 
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确认', '取消']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content:'<div style="line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="form-group" style="padding: 15px; margin-bottom: 5px;"><label >填写驳回理由</label><input id="reason" type="text" class="form-control" placeholder="请输入" style="margin: 0; padding: 0 20px;"></div></div>'
            ,yes:function(index,layero){
           		var con = $('#reason').val();
                var receipt={
                	rid:rrid,
                	context:con,
                	auditor:real
                }
                 $.ajax({
		             type: "Post",
		             contentType: "application/json; charset=utf-8",
		             url: "receipt/rejectReceipt",
		             data: JSON.stringify(receipt),
		             success: function(data){
		             var dataObj=eval("("+data+")");
	    		  		if(dataObj.code==1){
	    		  		layer.msg('驳回成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							  location.reload();
							});
	    		  		}else{
	    		  			layer.msg('驳回失败!',{
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
    
    function dereceipt(rrid){
    	layer.open({
            type: 1
            ,title: '确认删除该回单吗？' 
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,btn: ['确认', '取消']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content:'<div style="line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;"><div class="form-group" style="padding: 15px; margin-bottom: 5px;"><label >填写删除理由</label><input id="reason" type="text" class="form-control" placeholder="请输入" style="margin: 0; padding: 0 20px;"></div></div>'
            ,yes:function(index,layero){
           		var con = $('#reason').val();
                var receipt={
                	rid:rrid,
                	context:con,
                	auditor:real
                }
                 $.ajax({
		             type: "Post",
		             contentType: "application/json; charset=utf-8",
		             url: "receipt/deleteReceipt",
		             data: JSON.stringify(receipt),
		             success: function(data){
		             var dataObj=eval("("+data+")");
	    		  		if(dataObj.code==1){
	    		  		layer.msg('删除成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							  location.reload();
							});
	    		  		}else{
	    		  			layer.msg('删除失败!',{
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
</html>
