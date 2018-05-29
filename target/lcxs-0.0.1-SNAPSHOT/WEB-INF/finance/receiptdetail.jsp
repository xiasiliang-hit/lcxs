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
    <title>- 基本表单</title>
</head>

<link rel="stylesheet" type="text/css" href="Css/detail/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="Css/detail/animate.css" />
<link rel="stylesheet" type="text/css" href="Css/detail/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="Css/detail/style.css" />
<style type="text/css">
    .col-sm-2{
        width: 200px;
    }
    a {
  color: #0088cc;
  text-decoration: none;
  padding : 2px 5px 2px 5px;
  border: 1px solid #bbb;
  background: linear-gradient(to bottom,#ffffff 0,#eeeeee 100%);
  -webkit-border-radius: 15px 15px 15px 15px;
}
    
    </style>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>回单管理-
                        <small>回单详情</small>
                    </h5>

                </div>
                <div class="ibox-content">
                    <form method="post" id="myForm" class="form-horizontal" action="">
                    <input type="hidden" value=${user.vid } name="vid">
                    <input type="hidden" value=${receipt.rid } name="rid">
                    <input type="hidden" name="auditor" value="${staff.realname }"> 
                    <input type="hidden" name="tmoney" value="${receipt.tmoney }"> 
                        <div class="form-group">
                            <label class="col-sm-2 control-label">活动平台注册用户名:</label>
                            <label style="padding-top: 7px;">${receipt.realname }</label>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">活动平台注册手机:</label>
                            <label style="padding-top: 7px;">${receipt.phone }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">支付宝账号:</label>
                            <label style="padding-top: 7px;">${user.alipay }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">支付宝账户名:</label>
                            <label style="padding-top: 7px;">${user.realname }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">开户行:</label>
                            <label style="padding-top: 7px;">${bank.obank }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">银行卡账户名:</label>
                                 <label  style="padding-top: 7px;">${bank.name }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">银行卡账号:</label>
                                 <label  style="padding-top: 7px;">${bank.cardid }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">开户行地址:</label>
                            <label style="padding-top: 7px;">${bank.address }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户投资金额:</label>
                            <label style="padding-top: 7px;">${receipt.tmoney }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户返利加红包:</label>
                            <label style="padding-top: 7px;">(${receipt.jmoney }+${receipt.redmoney})</label>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">投资时间:</label>
                                 <label style="padding-top: 7px;">${receipt.ttime }</label>
                          </div>
                        
                        <div class="form-group">
                            <label class="col-sm-2 control-label">提交时间:</label>
                                 <label style="padding-top: 7px;">${receipt.ctime }</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">最后审核时间:</label>
                                 <label style="padding-top: 7px;">${receipt.mtime }</label>
                        </div>
                         <c:if test="${receipt.status==4 }">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">打款时间:</label>
                                 <label style="padding-top: 7px;">${receipt.mtime }</label>
                        </div>
                        </c:if>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">购买金额:</label>
                                 <label style="padding-top: 7px;">${receipt.tmoney}</label>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">状态:</label>
                             <label style="padding-top: 7px;">
                             <c:if test="${receipt.status==1 }">
                             	已通过
                             </c:if>
                             <c:if test="${receipt.status==2 }">
                             	已驳回
                             </c:if>
                             <c:if test="${receipt.status==3 }">
                             	未审核
                             </c:if>
                             <c:if test="${receipt.status==4 }">
                             	已打款
                             </c:if>
                             <c:if test="${receipt.status==5 }">
                             	已删除
                             </c:if>
                             </label>
                        </div>
                        <div class="form-group">
	                            <label class="col-sm-2 control-label">备注:</label>
	                            <label style="padding-top: 7px;">${receipt.context }</label>
	                    </div>
                        <c:if test="${receipt.status==1}">
	                        <div class="form-group">
	                            <label class="col-sm-2 control-label">备注:</label>
	                             <textarea rows="10" cols="50" name="context"></textarea>
	                        </div>
	                        <div class="form-group" style="text-align: center;font-size: 20px">
	                            <a  href="javascript:;" onclick="makemoney()">打款</a>
	                        </div>
	                   	</c:if>
                    </form>
                 </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="layer-v3.1.1/layer/layer.js"></script>
<script>
	function makemoney(){
	var index = parent.layer.getFrameIndex(window.name);
		 layer.confirm('确认要打款吗？',function(index) {
         var form = new FormData(document.getElementById("myForm"));
         $.ajax({
                url:"receipt/moneyReceipt",
                type:"post",
                data:form,
                processData:false,
                contentType:false,
                success:function(data){
                	var dataObj=eval("("+data+")");
    		  		if(dataObj.code==1){
    		  		layer.msg('打款成功!', {
							  icon: 6,
							  time: 1000
							}, function(){
							parent.layer.close(index);
							parent.location.reload();
							});
    		  		}else{
    		  			layer.msg('打款失败!', {
							  icon: 6,
							  time: 1000
							}, function(){
							parent.layer.close(index);
							parent.location.reload();
							});
    		  		}
                },
                error:function(e){
                    alert("错误！！");
                }
            })  
		})
	}
</script>
</html>
