<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>  
<html>  
<head> 
	<base href="<%=basePath%>"> 
    <meta charset="utf-8"/>  
    <title>理财先生管理系统</title>  
    <script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>  
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
    <style>  
        body{   margin: 0;
            padding: 0;
            background: url("<%=path %>/images/login.jpg") no-repeat fixed;
            background-size: cover;
            -moz-background-size: cover;
            -webkit-background-size: cover;}
        *{padding: 0px;margin: 0px;}  
       		 .top_div{         	
            width: 100%;  
            height: 500px; 
       		 display:flex;
       		 font-size:22px;
            justify-content:center;
            align-items:center;
        }  
        .ipt{  
         background:#000;
            border: 1px solid #d3d3d3;  
            padding: 10px 10px;  
            width: 250px;  
            border-radius: 4px;  
            padding-left: 73px; 
 
            -webkit-box-shadow: inset 0 3px 3px rgba(0,0,0,.075);  
            box-shadow: inset 0 2px 2px rgba(0,0,0,.075);  
            -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;  
            -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;  
            transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s  
        }  
        .ipt:focus{  
            border-color: #66afe9;  
       	     outline: 0;  
            -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);  
            box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)  
        }        
       	 .denglu{  
          background:#000;
         width:400px;
         height: 250px;	
         margin: auto auto;
         boder:1px;
         border-radius:8px;
  		filter: alpha(opacity=0);
  		opacity: 0.5;
         text-align: center;
         margin-top: -300px;
          
        }  
        .login{
        background: #008ead;
        padding: 7px 80px;
        border-radius: 4px;
        border: 1px solid #1a7598;
        color: #FFF;
        font-weight: bold;
        } 
        .checkCode {
         background:#000;
		    cursor: pointer;
		     border: 1px solid #d3d3d3;
		     border-radius:4px;
		    text-align: center;
		    line-height: 26px;
		    width: 90px;
		    height: 35px;
	}   
	    .checkCode1 {	   
         background:#000;
		    cursor: pointer;
		     border: 1px solid #d3d3d3;
		     border-radius:4px;
		    text-align: center;
		    line-height: 26px;
		    width: 235px;
		    height: 35px;
		}    
		.footer{
			height:70px; 
			line-height:15px;
			position:fixed;
			bottom:0;
			width:100%;	
			text-align:center;
			color:#fff;
			font-family:Arial;
			font-size:12px; 
			letter-spacing:1px;
			  } 
    </style>  
</head>  
<body>  
<div class="top_div">
</div>
<div class="denglu">    
    <p style="padding: 15px 0px 10px 0px;position: relative;">
    <span style="color:#ffffff;font-size:21px ; font-weight:bold " >欢迎登陆理财先生后台管理系统</span>    
	</p> 
	  <span style="color:red;font-weight:bold ">${masg}</span>  
<form action="staff/login" method="post" id="form">  
    <p style="padding: 18px 0px 10px 0px;position: relative;">      	
     <input class="ipt" type="text" placeholder="请输入账号" name="phone" id="phone"style="color:#ffffff;">  
    </p> 
    <p style="padding: 18px 0px 10px 0px;position: relative;">      	
     <input class="ipt" type="password" placeholder="请输入密码" name="password" id="password" style="color:#ffffff;">  
    </p>  
    <div style="height: 50px;line-height: 70px;margin-top: 15px;border-top: 1px solid #e7e7e7 ;color:#ffffff;">        
           <input  type="submit" style="height: 45px; width:111px;color:#000 ;  border-radius:6px;font-weight:bold "	  value="登陆">  
    </div>     
</form> 
</div>
<script>  
function submitForm(){  
   document.getElementById("form").submit();  
}  
    function keyLogin(){  
         if (event.keyCode==13)  //回车键的键值为13  
         document.getElementById("form").submit();    
}  
    
    
</script>   
</body>  
</html>  