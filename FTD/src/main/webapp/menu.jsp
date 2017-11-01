<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script language='javascript'>
	var curopenItem = '1';
</script>
<script language="javascript" type="text/javascript"
	src="skin/js/frame/menu.js"></script>
<base target="main" />
</head>
<body target="main">
	<table width='99%' height="100%" border='0' cellspacing='0'
		cellpadding='0'>
		<tr>
			<td style='padding-left: 3px; padding-top: 8px' valign="top">
				<!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'>
						<b>项目管理</b>
					</dt>
					<dd style='display: block' class='sitem' id='items1_1'>
						<ul class='sitemu'>

							<li><a href='projectListAction' target='main'>基本信息管理</a></li>
							<li><a href='projectNeedListAction' target='main'>需求分析管理</a></li>
							<li><a href='projectModelListAction' target='main'>模块管理</a></li>
							<li><a href='projectFunctionListAction' target='main'>功能管理</a></li>
							<li><a href='projectFileListAction' target='main'>附件管理</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End --> <!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'>
						<b>任务管理</b>
					</dt>
					<dd style='display: none' class='sitem' id='items2_1'>
						<ul class='sitemu'>
							<li><a href='jump2AddTaskAction' target='main'>创建任务</a></li>
							<li><a href='taskListAction' target='main'>任务信息</a></li>
							<li><a href='lookMyTaskAction' target='main'>我的任务</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End --> <!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items3_1")'>
						<b>信息箱</b>
					</dt>
					<dd style='display: none' class='sitem' id='items3_1'>
						<ul class='sitemu'>
							<li><a href='message-seed.jsp' target='main'>发信息</a></li>
							<li><a href='message.jsp' target='main'>发件箱</a></li>
							<li><a href='message-give.jsp' target='main'>收件箱</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End --> <!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items4_1")'>
						<b>客户信息管理</b>
					</dt>
					<dd style='display: none' class='sitem' id='items4_1'>
						<ul class='sitemu'>
							<li><a href='customerListAction' target='main'>客户信息</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End --> <!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items5_1")'>
						<b>权限管理</b>
					</dt>
					<dd style='display: none' class='sitem' id='items5_1'>
						<ul class='sitemu'>
							<li><a href='userInfoListAction' target='main'>人员管理</a></li>
							<li><a href='roleListAction' target='main'>角色管理</a></li>
							<li><a href='resourceListAction' target='main'>菜单资源管理</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End --> <!-- Item  Strat -->
				<dl class='bitem'>
					<dt onClick='showHide("items6_1")'>
						<b>我的信息</b>
					</dt>
					<dd style='display: none' class='sitem' id='items6_1'>
						<ul class='sitemu'>
							<li><a href='info.jsp' target='main'>信息查看</a></li>
							<li><a href='modpassword.jsp' target='main'>修改密码</a></li>
						</ul>
					</dd>
				</dl> <!-- Item  End -->

			</td>
		</tr>
	</table>
</body>
</html>