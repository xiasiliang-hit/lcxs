<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<!-- saved from url=(0041)http://adm.cjlc.cn/shop/shopdetails/id/82 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="<%=basePath%>">
    <title> - 基本表单</title>
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="Css/ace.min.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />

    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
	<script type="text/javascript" src="Js/jquery.min.js"></script>
	<script type="text/javascript" src="Js/bootstrap.min.js"></script>
	<script type="text/javascript" src="Js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="Js/jquery.dataTables.bootstrap.js"></script>

    <style>
    body,.tab-content{overflow-x:hidden;}
        #allmap {width: 100%;height: 200px;overflow: hidden;margin:0;font-family:"微软雅黑";}
        .Info_style .product_infoc {
            float: left;
            line-height: 26px;
            margin: 10px 5px;
        }

        #cboxClose {
            background-color: #000;
            border: 2px solid #fff;
            border-radius: 32px;
            color: #fff;
            font-size: 21px;
            height: 28px;
            margin-left: 0;
            padding-bottom: 2px;
            right: -2px;
            top: -2px;
            width: 28px;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row animated fadeInRight">
        <div class="col-sm-4">
            <div class="ibox ">
                <div class="ibox-content">
                    <div class="tab-content">
                        <div id="contact-1" class="tab-pane active">
                            <div class="row m-b-lg">
                                <div class="col-lg-12 text-center">
                                    <h3>${shop.shopname }</h3>
                                    <div class="m-b-sm">
                                        <img alt="image" class="img-circle" src="${shop.logo }">
                                    </div>
                                </div>
                                <div class="col-lg-12" style="padding: 0px 0px 0px 70px">
                                    <h4>简介</h4>
                                    ${shop.context}
                                </div>
                            </div>
                            <div class="client-detail">
                                <div class="full-height-scroll">
                                    <ul class="list-group clear-list">
                                        <li class="list-group-item fist-item">
                                            <span class="pull-right"> ${shop.regcap }</span> <i class="fa ">注册资本</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.area } </span> <i class="fa ">所在地区</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.background } </span> <i class="fa ">平台背景</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.financing } </span> <i class="fa ">融资背景</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.recommend } </span> <i class="fa ">推荐理由</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.more } </span> <i class="fa ">企业域名</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.tag } </span> <i class="fa ">标签</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.sort } </span> <i class="fa ">权重</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> 
                                            	${shop.status==1?'上架':'下架' }
	        	 							</span> <i class="fa ">状态</i>
                                        </li>
                                        
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.mtime } </span> <i class="fa ">上线时间</i>
                                        </li>

                                        <li class="list-group-item">
                                            <span class="pull-right"> ${shop.ctime } </span> <i class="fa ">创建时间</i>
                                        </li>

                                    </ul>


                                    <hr>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-8">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div>
                        <div class="feed-activity-list" id="loglist">
                             <div class="ibox-content">
                              <div id="sample-table_wrapper" class="dataTables_wrapper no-footer">
                              <form class="form-inline definewidth m20" action="cproduct/findByShopid/${vo.keywordsauid }" method="post">    
								    关键字：
								    <input type="text" name="keywords" id="keywords"class="abc input-default" placeholder="请输入产品名称" value="${vo.keywords }">&nbsp;&nbsp;  
								    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
								    <button type="button" class="btn btn-success" id="addnew">新增产品</button>
								    <button type="button" class="btn btn-success" id="old">查看历史产品</button>
								</form>
								
								
								
                              <table class="table table-striped table-bordered table-hover dataTable no-footer" id="sample-table" role="grid" aria-describedby="sample-table_info" style="width:100%;">
                        <thead>
                        <tr>
                        <th  class="sorting"  style="width: 81px;">商户名</th>
                        <th  class="sorting"  style="width: 100px;">产品名</th>
                        <th  class="sorting"  style="width: 100px;">平均收益水平</th>
                        <th  class="sorting"  style="width: 100px;">年收益率</th>
                        <th  class="sorting"  style="width: 100px;">综合年化</th>
                        <th  class="sorting_desc"  style="width: 15px;">创建时间</th>
                        <th  class="sorting_disabled"  style="width: 100px;">操作</th>
                        </tr>
                        </thead>
                    <c:forEach items="${pageModel.list }" var="u">
                    	 <tr>
					        <td>${u.shopname}</td>
					       	<td>${u.pname}</td>
					       	<td>${u.level}</td>
					        <td>${u.xnh }</td>
					        <td>${u.zhnh }</td>
        	  				<td>${u.ctime}</td>
            				<td>
				            	<a href="ccase/findById/${u.pid }">查看方案</a>
				                <a href="cproduct/goToUpdate/${u.pid }">编辑</a>  
				                <a href="cproduct/deleteBypid/${u.pid}"   onclick="return confirm('确定下架?');">下架</a>  
            				</td>
        				</tr>	
                   	</c:forEach>
                    </table>
                    <form action="cproduct/findByShopid/${vo.keywordsauid }" id="pager" name="pager" method="post">
					   <input type="hidden" name="pageNum" id="pageNum" value="${pageModel.pageNum}">
					   <input type="hidden" name="keywords" value="${vo.keywords }">  
					   <input type="hidden" name="pageSize" id="pageSize" value="${pageModel.pageSize}">
					</form>
					<div class="inline pull-right page" >
					  <%@include file="../../pageBar.jsp" %>
					</div>
                </div>
          </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>
</div>
</body>
<script type="text/javascript">
$(function () {
    	

		$('#addnew').click(function(){
			
				window.location.href="<%=path%>/cproduct/goToAdd/"+${vo.keywordsauid};
		 });

    });
  $(function () {
    	

		$('#old').click(function(){
			
				window.location.href="<%=path%>/cproduct/findOldByShopid/"+${vo.keywordsauid};
		 });

    });  
</script>
</html>