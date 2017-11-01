<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript">
	function selAll() {
		var items = document.form2.projectIDs;
		for (var i = 0; i < items.length; i++) {
			items[i].checked = true;
		}
	}
	function inverse() {
		var items = document.form2.projectIDs;
		for (var i = 0; i < items.length; i++) {
			if (items[i].checked) {
				items[i].checked = false;
			} else {
				items[i].checked = true;
			}
		}
	}
</script>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif' >

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:项目管理>>基本信息管理</td>
						<td><input type='button' class="coolbg np"
							onClick="location='jump2AddProjectAction';" value='添加新项目' /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<!--  搜索表单  -->
	<form name='form3' action='' method='get'>
		<input type='hidden' name='dopost' value='' />
		<table width='98%' border='0' cellpadding='1' cellspacing='1'
			bgcolor='#CBD8AC' align="center" style="margin-top: 8px">
			<tr bgcolor='#EEF4EA'>
				<td background='skin/images/wbg.gif' align='center'>
					<table border='0' cellpadding='0' cellspacing='0'>
						<tr>
							<td width='90' align='center'>搜索条件：</td>
							<td width='160'><select name='cid' style='width: 150'>
									<option value=''>选择类型...</option>
									<option value='projectName'>项目名称</option>
									<option value='truename'>项目经理</option>
							</select></td>
							<td width='70'>关键字：</td>
							<td width='160'><input type='text' name='keyword' 
								style='width: 120px' /></td>
							<td width='110'><select name='orderby' style='width: 120px'>
									<option value=''>排序...</option>
									<option value='pubdate'>立项时间</option>
									<option value='finishdate'>计划完成时间</option>
							</select></td>
							<td>&nbsp;&nbsp;&nbsp;<input name="imageField" type="image"
								src="skin/images/frame/search.gif" width="45" height="20"
								border="0" class="np" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
	<!--  内容列表：   -->
	<form name="form2" method="post" action="deleteProjectAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="4%">选择</td>
				<td width="6%">序号</td>
				<td width="10%">项目名称</td>
				<td width="10%">客户公司名称</td>
				<td width="10%">客户方负责人</td>
				<td width="5%">项目经理</td>
				<td width="8%">开发人员数</td>
				<td width="6%">立项时间</td>
				<td width="8%">最近更新时间</td>
				<td width="8%">计划完成时间</td>
				<td width="8%">状态</td>
				<td width="10%">操作</td>
			</tr> 
			<!-- 代码 -->
			<c:forEach items="${projectList }" var="item">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td><input name="projectIDs" type="checkbox" id="projectIDs" value="${item.projectID }"
						class="np"></td>
					<td>${item.projectID }</td>
					<td align="center">${item.projectName }</td>
					<td>${item.customer.customerName }</td>
					<td>${item.customer.contact }</td>
					<td>${item.user.truename }</td>
					<td>${item.developerNumber }</td>
					<td>${item.pubdate }</td>
					<td>${item.modifydate }</td>
					<td>${item.finishdate }</td>
					<td>${item.status }</td>
					<td><a href="jump2UpdateProjectAction?projectID=${item.projectID }">编辑</a> | <a
						href="lookProjectAction?projectID=${item.projectID }">查看详情</a></td>
				</tr>
			</c:forEach>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="12">&nbsp; 
					<a href="javascript:selAll()" class="coolbg">全选</a> 
					<a href="javascript:inverse()" class="coolbg">反选</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="coolbg" value="删除"> 
					
					<!-- 导出Excel还没写 -->
					<a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="12" align="center">
					<!--翻页代码 : --> <a
					href="${pageContext.request.contextPath }/projectListAction?pagenum=1">首页</a> <a
					href="${pageContext.request.contextPath }/projectListAction?pagenum=${p.currentPage - 1}">上页</a>
					<a
					href="${pageContext.request.contextPath }/projectListAction?pagenum=${p.currentPage + 1}">下页</a>
					<a href="${pageContext.request.contextPath }/projectListAction?pagenum=${p.pages }">末页</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="12" align="center">共${p.rows }条数据，每页显示${p["PAGE_SIZE"] }
					共${p.pages }页，当前是第${p.currentPage }页</td>
			</tr>
		</table>

	</form>

</body>
</html>