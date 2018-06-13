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
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="ibox ">
                <div class="ibox-content">
                    <div class="tab-content">
                        <div id="contact-1" class="tab-pane active">
                            <div class="row m-b-lg">
                                <div class="col-lg-12 text-center">
                                    <h2>${news.title }</h2>
                                    <div class="m-b-sm">
                                        <img alt="image" class="img-circle" src="${news.imgurl }">
                                    </div>
                                </div>
                                <div class="col-lg-12" style="padding: 0px 0px 0px 70px">
                                    <h4>新闻摘要</h4>
                                    ${news.remark}
                                </div>
                                <div class="col-lg-12" style="padding: 0px 0px 0px 70px">
                                    <h4>新闻内容</h4>
                                    ${news.context}
                                </div>

                            </div>
                            <div class="client-detail">
                                <div class="full-height-scroll">
                                    <ul class="list-group clear-list">
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${news.source} </span> <i class="fa ">新闻来源</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right">${news.type==1?"先生原创":news.type==2?"行业资讯":"活动资讯"}</span><i class="fa ">新闻类别</i>
                                        </li>
                                        <li class="list-group-item fist-item">
                                            <span class="pull-right"> ${news.praise }</span> <i class="fa ">点赞数</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${news.collection } </span> <i class="fa ">收藏数</i>
                                        </li>
                                        <li class="list-group-item">
                                            <span class="pull-right"> ${news.ntime } </span> <i class="fa ">新闻时间</i>
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
        <div class="col-sm-1"></div>
    </div>
</div>
</body>
</html>