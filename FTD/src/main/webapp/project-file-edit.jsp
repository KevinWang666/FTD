<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑附件</title>
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
						<td>当前位置:项目管理>>编辑附件</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" method="post" action="updateProjectFileAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑附件&nbsp;</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="fileID" name="fileID" value="${projectFile.fileID }">
				</td>
			</tr>
			<tr>
				<td>
					<input type="hidden" id="uploaddate" name="uploaddate" value="${projectFile.uploaddate }">
				</td>
			</tr>
			
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">所属项目：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="hidden" id="pfile.project.projectID" name="pfile.project.projectID" value="${projectFile.project.projectID }">
					${projectFile.project.projectName }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">附件名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input id="filename" name="filename" type="text"
					value="${projectFile.filename }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">附件信息描述：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="fileDesc" name="fileDesc"
					value="${projectFile.fileDesc }" /></td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">附件1：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 这里需要重写 -->
					帐户管理功能分析图.jpg<input
					type="file" />&nbsp;&nbsp;&nbsp;<a>添加</a>&nbsp;&nbsp;&nbsp;<a>删除</a>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea id="comments" name="comments"
						rows=10 cols=130>${projectFile.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
					<input type="submit" class="coolbg" value="保存"> 
				 	<a href="projectFileListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>