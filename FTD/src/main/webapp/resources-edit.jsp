<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑菜单资源</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript">
	function defaultValue(){
		var sels = document.form2["res.parent.resourceID"];
		for (var i = 0; i < sels.length; i++) {
			if (${resource.parent.resourceID} == sels[i].value) {
				sels[i].selected = "selected";
			}
		}
	}
</script>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif' onload="defaultValue()">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>编辑菜单资源</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- action还没写 -->
	<form name="form2" method="post" action="resourceUpdateAction" >

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑菜单资源&nbsp;</td>
			</tr>
			<tr><td>
			<input type="hidden" id="resourceID" name="resourceID"
					value="${resource.resourceID }">
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">菜单资源编号：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" id="resourceNumber" name="resourceNumber" value="${resource.resourceNumber }" readonly="readonly">
					</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">菜单资源名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="resourceName" name="resourceName"
					value="${resource.resourceName }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">父菜单：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 这里需要查询所有的菜单资源 --> 
					<select id="res.parent.resourceID" name="res.parent.resourceID">
						<option value="">顶级菜单</option>
						<c:forEach items="${parentList }" var="item">
							<option value="${item.resourceID }">${item.resourceName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">菜单资源路径：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="resourcePath" name="resourcePath"
					value="${resource.resourcePath }" /></td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea id="comments" name="comments"
						rows=10 cols=130>${resource.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
					<input type="submit" class="coolbg" value="保存">
					<a href="resourceListAction"
					class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>