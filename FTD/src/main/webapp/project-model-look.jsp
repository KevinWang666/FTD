<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看模块信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:项目管理>>查看模块信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;查看模块&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.projectNeed.project.projectName }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.projectNeed.needName }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">模块名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.modelName }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.priority }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.simpleDesc }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${projectModel.detailDesc }</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';">${projectModel.comments }</td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; <a
					href="projectModelListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>