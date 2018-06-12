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
    <script type="text/javascript" src="Js/jquery.js"></script>
    <script type="text/javascript" src="Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="Js/bootstrap.js"></script>
    <script type="text/javascript" src="Js/ckform.js"></script>
    <script type="text/javascript" src="Js/common.js"></script>
    <script src="Js/jquery.validate.js" type="text/javascript"></script>
	<script src="Js/jquery.metadata.js" type="text/javascript"></script>
	<script src="Js/messages_cn.js" type="text/javascript"></script>
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
         /***错误提示样式***/ 
		form.cmxform label.error, label.error { 
		color: red; 
		font-style: italic; 
		} 
    </style>
</head>
<body >
<form id="signupForm" action="ccase/insertCase/${vo.keywordsauid}" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
         <input type="hidden" name="id" value="${pcase.id }">
        
         <tr>
         		<td  class="tableleft">投资标的名称</td>
        		<td><input type="text" name="casename" placeholder="请输入方案名称" value="${pcase.casename}"/></td>
    	</tr>
    	<tr>
		         <td  class="tableleft">期限</td>
		       	 <td><input type="text" name="dtime" id="dtime" placeholder="如：90"value="${pcase.dtime}"/></td>
		        
    	</tr>
    	
    	<tr>
         		 <td  class="tableleft">返利类型</td>
        		 <td>
			        <input type="radio"  name="cid" value="1" <c:if test="${pcase.cid==1}">checked="checked"</c:if>/> 按固定金额
			        <input type="radio"  name="cid" value="2" <c:if test="${pcase.cid==2}">checked="checked"</c:if>/> 按比例返利
		         </td>
    	</tr>
    	<tr>
		         <td  class="tableleft">返利金额/返利比例</td>
		       	<td><input type="text" name="experience" id="experience" placeholder="如：0" value="${pcase.experience}"/></td>
		       
    	</tr>
    	
    	<tr>
		         <td  class="tableleft">金额</td>
		         <td><input type="text" name="money" id="money" placeholder="如：5000" value="${pcase.money}"/></td>
		       
    	</tr>
    	
    	<tr>
        	 	<td  class="tableleft">原年化</td>
        		<td><input type="text" name="ybh" id="ybh" placeholder="如：10" value="${pcase.ybh}"/></td>
    	</tr> 		
    	<tr>
		         <td  class="tableleft">红包</td>
		         <td><input type="text" name="red" id="red" placeholder="如：10" value="${pcase.red}"/></td>
        </tr> 
    	
    	<tr>
		         <td  class="tableleft">其它</td>
		       	<td><input type="text" name="other" id="other" placeholder="如：0" value="${pcase.other}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">返利（自动计算）</td>
		       	 <td><input type="text" name="interest" id="interest" placeholder="如：95" value="${pcase.interest}"/></td>
		       
    	</tr>
    	<tr>
		         <td  class="tableleft">利息（自动计算）</td>
		       	<td><input type="text" name="rebate"  id="rebate" placeholder="如：127" value="${pcase.rebate}"/></td>
		       
    	</tr>
    	<tr>
    	
        		 <td  class="tableleft">总收益（自动计算）</td>
        		 <td><input type="text" name="tincome" id="tincome" placeholder="如：127" value="${pcase.tincome}"/></td>
    	</tr> 
    	
    	<tr>
		         <td  class="tableleft">综合年化（自动计算）</td>
		       	 <td><input type="text" name="zincome" id="zincome" placeholder="如：10" value="${pcase.zincome}"/></td>
		       
    	</tr>
    	<tr>
        		 <td  class="tableleft">返利周期</td>
        	     <td><input type="text" name="ftime" placeholder="如：1" value="${pcase.ftime}"/></td>
    	</tr> 
    	<tr>
         		<td  class="tableleft">拿货价格类型</td>
         		 <td>
			        <input type="radio"  name="tprice" value="1" <c:if test="${pcase.tprice==1}">checked="checked"</c:if>/> 固定金额
			        <input type="radio"  name="tprice" value="2" <c:if test="${pcase.tprice==2}">checked="checked"</c:if>/> 比例价格
		         </td>
    	</tr> 
    	<tr>
         		<td  class="tableleft">固定价格/比例价格</td>
        		<td><input type="text" name="texttime" placeholder="如：1" value="${pcase.texttime}"/></td>
    	</tr> 
    	<tr>
		         <td  class="tableleft">保障比例</td>value
			     <td>
	        			<input type="text" name="top" value="${pcase.top}" />
	             </td>
    	</tr>
    	
    	<tr>
		   		<td>
		            <button type="submit" class="btn btn-primary">保存</button> 
		        </td>
    	</tr>
</table>
</form>
<script>
var op=1;
		$("#interest").focus(function(){
			var cid=$("input[name='cid']:checked").val();//返利类型
				if(cid==null||cid==""){
					$("#interest").blur();
					alert("请选择返利类型！")
					return false;
				}
            var red = $("#red").val();//红包
            var experience = $("#experience").val();//返利金额
	            if(experience==null||experience==""){
					$("#interest").blur();
					alert("请填写返利金额！")
					return false;
				}
            var other = $("#other").val();//其它
            var rebate = $("#rebate").val();//利息
            var money=$("#money").val();//金额
             if(money==null||money==""){
					$("#interest").blur();
					alert("请填写金额！")
					return false;
				}
            if(cid==1){
            	var fl=experience;
            }else{
            	var fl=(money*experience/100);
            	fl=fl.toFixed(2);
            }
              $("#interest").val(fl);
			//返利=利息+返利金额+红包+其它
		}) 
	
        $("#rebate").focus(function () {

         
			var dtime=$("#dtime").val();
			var dd=dtime.split('天');
			var qq=dd[0];
			if(dtime==null||dtime==""){
				$("#rebate").blur();
				alert("期限不能为空！")
				return false;
			}
            var money = $("#money").val();
            if (money == null || money == "") {
                $("#rebate").blur();
             alert("金额不能为空！");
                return false;
            }
            var interest = $("#interest").val();
            var red = $("#red").val();
            var experience = $("#experience").val();
            var other = $("#other").val();
            var tincome = $("#tincome").val();
            var ybh = $("#ybh").val();
            ybh=ybh/100;
            if (ybh== null || ybh == "") {
                $("#rebate").blur();
             alert("年化不能为空！");
                return false;
            }
            var ftime = $("#ftime").val();
            var texttime = $("#texttime").val();

            var lx = (money * ybh /360*qq );
            // var lx = (aMoney * ynh / t  );
            //        利息=投资金额×原年化/12×投资期限（月）
//        利息=投资金额×原年化/365×投资期限（日）

              lx=lx.toFixed(2);

            
            $("#rebate").val(lx);



        });

      
        
         $("#tincome").focus(function () {

            var dtime = $("#dtime").val();
          	var dd=dtime.split('天');
			var qq=dd[0];
            var money = $("#money").val();
            var interest = $("#interest").val();
            var red = $("#red").val();
            var experience = $("#experience").val();
            var other = $("#other").val();
            var ybh = $("#ybh").val();

           var ftime = $("#ftime").val();
           var texttime = $("#texttime").val();

            var rebate = $("#rebate").val();
            
            if (interest == null || interest == "") {
                $("#tincome").blur();
               alert("返利不能为空！");
                return false;
            }
            if (red == null || red == "") {
                $("#tincome").blur();
               alert("红包不能为空！");
                return false;
            }
            if (experience == null || experience == "") {
                $("#tincome").blur();
               alert("体验金不能为空！");
                return false;
            }
            if (rebate == null || rebate == "") {
                $("#tincome").blur();
               alert("利息体验金不能为空！"
                );
                return false;
            }
            interest=Number(interest);//返利
            red=Number(red);//红包
            experience=Number(experience);
            other=Number(other);//其它
            rebate=Number(rebate);//利息
            var tincome = (interest+red+rebate+other) ; //总收益
            tincome=tincome.toFixed(2);
            $("#tincome").val(tincome);


        });
        
        
          $("#zincome").focus(function () {

            var dtime = $("#dtime").val();
          	var dd=dtime.split('天');
			var qq=dd[0];
            var money = $("#money").val();
              if (money == null || money == "") {
                $("#zincome").blur();
             alert("金额不能为空！"

                );
                return false;
            }
            var interest = $("#interest").val();
            var red = $("#red").val();
            var experience = $("#experience").val();
            var other = $("#other").val();
            var ybh = $("#ybh").val();

            var ftime = $("#ftime").val();
            var texttime = $("#texttime").val();

            var rebate = $("#rebate").val();
			var tincome=$("#tincome").val();
            if (tincome == null || tincome == "") {
                $("#zincome").blur();
              alert("总收益不能为空！");
                return false;
            }


            var zhsy = tincome / money / qq*360*100;
            zhsy=zhsy.toFixed(2);
            $("#zincome").val(zhsy);

        });
        
        
        
        
$(document).ready(function() {
    $("#signupForm").validate({
        rules: {
       		casename:{
                required: true,
      		 },
      		dtime:{
      			required: true,
      		 },
      		money:{
      			required: true,
      			number:true,
     		 },
     		interest:{
     			required: true,
      			number:true,
     		 }, 
     		rebate:{
     			required: true,
      			number:true,
     		 }, 
     		red:{
      			required:true,
     		 }, 
     		experience:{
     			required: true,
      			number:true,
     		 },  
     		other:{
      			required:true,
     		 },  
     		tincome:{
     			required: true,
      			number:true,
     		 },  
     		ybh:{
      			required:true,
     		 },  
     		zincome:{
      			required:true,
     		 },  
     		ftime:{
     			required: true,
      			number:true,
     		 }, 
     		tprice:{
     			required: true,
      			number:true,
     		 },  
     		texttime:{
      			required:true,
     		 },  
        },
	        messages:{
	        	casename:{
	            	required:"请输入名字",
	    	},
	    		dtime:{
	    			required:"请输入期限",
	    	},
	    		money:{
	    			required:"请输入金额",
            		number:"请输入数字金额",
	    	},
	    		interest:{
	    			required:"请输入信息",
        			number:"请输入数字",
    		},
    			rebate:{
    				required:"请输入数字",
	    			number:"请输入数字",
			},
				red:{
	    			required:"请输入信息",
			},
				experience:{
					required:"请输入信息",
	    			number:"请输入金额",
			},
				other:{
	    			required:"请输入信息",
			},
				tincome:{
					required:"请输入信息",
					number:"请输入数字",
			},
				ybh:{
					required:"请输入信息",
			},
				zincome:{
					required:"请输入信息",
			},
				ftime:{
					required:"请输入信息",
					number:"请输入天数",
			},
				tprice:{
					required:"请输入信息",
					number:"请输入金额",
			},
				texttime:{
					required:"请输入信息",
			}
	   }
    });
});
</script>
</body>
</html>
