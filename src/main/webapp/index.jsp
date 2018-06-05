<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
<link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="header"> 
	
		<div class="dl-title">
		</div>
		<div class="dl-log">
			欢迎您，<span class="dl-log-user">${staff.realname}</span>
			<a href="staff/logout" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">	
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">	
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
			<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">首页信息</div></li>
		<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-user">用户管理</div></li>
			<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-product">商户管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">财务管理</div></li>
					<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">红包管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">推手管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">新闻管理</div></li>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">
		</ul>
	</div>
	<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="assets/js/bui-min.js"></script>
	<script type="text/javascript" src="assets/js/common/main-min.js"></script>
	<script type="text/javascript" src="assets/js/config-min.js"></script>
	<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : '7',
				homePage : '2',
				menu : [ {
					text : '首页信息',
					items : [  {
						id : '2',
						text : '首页展示',
						href : 'homepage/query'
					},
					  {
						id : '3',
						text : '平台数据展示',
						href : 'homepage/shopDateList'
					},{
						id : '1',
						text : '活动数据',
						href : 'homepage/findCaseInfo'
					}
					]
				} ]
			}, {
				id : '6',
				homePage : '1',
				menu : [ {
					text : '用户管理',
					items : [ {
						id : '1', 
						text : '用户信息',
						href : 'user/findAll'
					},{
						id : '2',
						text : '员工信息',
						href : 'staff/findAll'
					},{
						id : '4',
						text : '用户绑卡',
						href : 'user/userBank'
					},{
						id : '5',
						text : '专属客户',
						href : 'staff/findUserByStaffSid/'+${staff.stype}+"/"+${staff.sid}
					}
					]
				} ]
			} ,{
				id : '1',
				homePage : '3',
				menu : [ {
					text : '商户管理',
					items : [ {
						id : '3', 
						text : '商户列表',
						href : 'cshop/findAll'
					},{
						id : '6',
						text : '产品信息',
						href : 'cproduct/findAll'
					},{
						id : '1', 
						text : '渠道管理',
						href : 'cchannel/queryAll'
					},{
						id : '4',
						text : '横幅信息',
						href : 'cbanner/findAll'
					},{
						id : '5',
						text : '公告信息',
						href : 'note/findAllNote'
					}
					]
				} ]
			},{
				id : '2',
				homePage : '3',
				menu : [ {
					text : '财务管理',
					items : [ {
						id : '3',
						text : '未审核回单',
						href : 'receipt/queryAll/'+3
					},{
						id : '2',
						text : '已通过回单',
						href : 'receipt/queryAll/'+1
					},{
						id : '4',
						text : '已打款回单',
						href : 'receipt/queryAll/'+4
					},{
						id : '5',
						text : '已驳回回单',
						href : 'receipt/queryAll/'+2
					},{
						id : '1',
						text : '已删除回单',
						href : 'receipt/queryAll/'+5
					}
					]
				}]
			},{
				id : '3',
				homePage : '1',
				menu : [ {
					text : '红包管理',
					items : [ {
						id : '1',
						text : '红包清单',
						href : 'cred/findAll'
					},{
						id : '3',
						text : '邀请红包',
						href : 'user/invite'
					}
					]
				}]
			},{
                id : '8',
                homePage : '1',
                menu : [ {
                    text : '推手管理',
                    items : [
                        {
                            id : '1',
                            text : '推手用户回单',
                            href : 'ts/getTsInfo'
                        }
                    ]
                }]
            },{
                id : '4',
                homePage : '1',
                menu : [ {
                    text : '新闻管理',
                    items : [ {
                        id : '1',
                        text : '新闻清单',
                        href : 'news/findAll'
                    }
                    ]
                }]
            }
			];
			new PageUtil.MainPage({
				modulesConfig : config
				
			});
		});
	</script>	
</body> 	
</html>