<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看角色信息</title>
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
						<td>当前位置:权限管理>>查看角色信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- action还没写 -->
	<form name="form2">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;查看角色信息&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${role.roleNumber }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${role.roleName }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">${role.status }</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 需要遍历该角色的所有菜单资源 --> 
					<c:forEach items="${role.resources }"
						var="res">
						<c:if test="${res.parent == null}">
							<input type="checkbox" value="${res.resourceID }"  name="resources" checked />${res.resourceName }<br />
						<c:forEach items="${role.resources }" var="subRes">
								<c:if test="${subRes.parent.resourceID == res.resourceID}">
									&nbsp;&nbsp;&nbsp;<input type="checkbox"  value="${subRes.resourceID }" name="resources" checked="checked" />${subRes.resourceName} <br />
								</c:if>
							</c:forEach>
						</c:if>

					</c:forEach>

				</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';">${role.comments }</td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; <a
					href="roleListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>