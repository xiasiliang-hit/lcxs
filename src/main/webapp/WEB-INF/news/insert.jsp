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
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script type="text/javascript" src="Js/ajaxfileupload.js"></script>
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
    <script src="Js/jquery.metadata.js" type="text/javascript"></script>
    <script src="Js/messages_cn.js" type="text/javascript"></script>
    <script type="text/javascript" src="Js/calendar.js"></script>
    <script type="text/JavaScript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        CKEDITOR.replace('TextArea1');
    </script>
    <style type="text/css">
        #ctime{
            width:33px;
            height:16px;
            background:url(Css/calendar.png) no-repeat right;
            cursor:pointer;
        }
        .div1 {
            position: relative;
        }

        .div2 {
            width: 100px;
            height: 26px;
            background: #2178fc;
            color: #fff;
            text-align: center;
            line-height: 26px;
        }

        .file_input {
            width: 200px;/*因为file-input在部分浏览器中会自带一个输入框，需要双击才可以点击上传,放大后将其定位到div外面就好啦*/
            height: 36px;
            position: absolute;
            left: -100px;
            top: 0;
            z-index:1;
            -moz-opacity: 0;
            -ms-opacity: 0;
            -webkit-opacity: 0;
            opacity: 0;  /*css属性——opcity不透明度，取值0-1*/
            filter: alpha(opacity=0); /*兼容IE8及以下--filter属性是IE特有的，它还有很多其它滤镜效果，而filter: alpha(opacity=0); 兼容IE8及以下的IE浏览器(如果你的电脑IE是8以下的版本，使用某些效果是可能会有一个允许ActiveX的提示,注意点一下就ok啦)*/
            cursor: pointer;
        }
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
        /***错误提示样式***/
        form.cmxform label.error, label.error {
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>
<form id="signupForm" action="news/insert" method="post" class="definewidth m20">
    <table class="table table-bordered table-hover definewidth m10">
        <input type="hidden" name="id" value="${news.id}">
        <tr>
            <td  class="tableleft">新闻标题</td>
            <td><input type="text" name="title" placeholder="请输入新闻标题" value="${news.title}"/></td>
        </tr>
        <tr>
            <td  class="tableleft">新闻来源</td>
            <td><input type="text" name="source" placeholder="请输入新闻来源" value="${news.source}"/></td>
        </tr>
        <tr>
            <td  class="tableleft">初始点赞数</td>
            <td><input type="text" name="praise" placeholder="请输入初始点赞数" value="${news.praise}"/></td>
        </tr>
        <tr>
            <td  class="tableleft">初始收藏数</td>
            <td><input type="text" name="collection" placeholder="请输入新闻来源" value="${news.collection}"/></td>
        </tr>
        <tr>
            <td  class="tableleft">新闻内容</td>
            <td><textarea id="TextArea1" class="ckeditor" cols="30" rows="2" name="context" placeholder="请输入新闻内容" >${news.context}</textarea>
            </td>
        </tr>
        <tr>
            <td  class="tableleft">新闻摘要</td>
            <td><textarea id="TextArea2" class="ckeditor" cols="30" rows="2" name="remark" placeholder="请输入新闻摘要" >${news.remark}</textarea>
            </td>
        </tr>
        <tr>
            <td  class="tableleft">新闻图片</td>
            <td>
                <div class="div1">
                    <div class="div2">上传图片</div>
                    <input type ="file"  class="file_input" id="ImportPicInput" name="myfile"/>
                </div>
                <input  type="hidden" name="imgurl" id="imgurl" value="${news.imgurl}"/>
                <img  src="${news.imgurl}" id ="imgInit"  width="50%" height="50%" />
            </td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">新闻时间</td>
            <td><input type="text" name="ntime" id="ntime" style="margin-top:10px; height:24px;width:150px;font-size:15px;" value="${news.ntime}"></td>
        </tr>
        <tr>
            <td class="tableleft">新闻类别</td>
            <td>
            <input type="radio"  name="type" value="1" <c:if test="${news.type==1}">checked="checked"</c:if>/> 先生原创
            <input type="radio"  name="type" value="2" <c:if test="${news.type==2}">checked="checked"</c:if>/> 行业资讯
            <input type="radio"  name="type" value="3" <c:if test="${news.type==3}">checked="checked"</c:if>/> 活动资讯
            </td>
        </tr>
        <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    Calendar.setup({
        inputField : "ntime",
        ifFormat   : "%Y-%m-%d",
        showsTime  : false,
        timeFormat : "24"
    });
    $("#ImportPicInput").change(function() {

        updatelogo();
    });
    function updatelogo(){
        $.ajaxFileUpload({
            url: 'img/addImg', //用于文件上传的服务器端请求地址
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'ImportPicInput', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data){
                var dataObj=eval("("+data+")");
                if(dataObj.code==0){
                    alert(dataObj.msg);
                }
                if(dataObj.code==1){
                    alert(dataObj.msg);
                }
                if(dataObj.code==2){
                    alert(dataObj.msg);
                }
                if(dataObj.code==3){
                    var url=dataObj.url;
                    document.getElementById("imgInit").src=url;
                    document.getElementById("imgurl").value=url;
                }
            },error:function(e){
                alert("错误！！");
            }
        })
    }
    $(function () {
        CKEDITOR.replace('TextArea1', { height: '150px' });
        CKEDITOR.replace('TextArea2', { height: '150px' });
    });


    $(document).ready(function() {
        $("#signupForm").validate({
            rules: {
                title:{
                    required: true,
                },
                source:{
                    required: true
                },
                context:{
                    required:true,
                },
                praise:{
                    required:true,
                    digits:true
                },
                collection:{
                    required:true,
                    digits:true
                },
                remark:{
                    required:true,
                }
            },
            messages:{
                title:{
                    required:"请输入信息",
                },
                source:{
                    required:"请输入来源"
                },
                context:{
                    required:"请输入信息",
                },
                praise:{
                    required:"请输入",
                    digits:"请输入数字点赞数",
                },
                collection:{
                    required:"请输入信息",
                    digits:"请输入数字收藏数",
                },
                remark:{
                    required:"请输入摘要",
                }
            }
        });
    });

</script>
</html>
