<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑角色信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript">
	function show(){
		//获取所有checkbox
		var allRes = document.form2.resourceList ;
		var roleRes = document.form2.roleResources;
		
		for (var i = 0; i < allRes.length; i++) {
			for (var j = 0; j < roleRes.length; j++) {
				if (allRes[i].value == roleRes[j].value) {
					allRes[i].checked = "checked";
				}
			}
		}
	}
	
</script>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif' onload="show()">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>编辑角色</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" method="post" action="updateRoleAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑角色&nbsp;</td>
			</tr>
			<tr>
				<td>
				<!-- 隐藏ID -->
				<input type="hidden" id="roleID" name="roleID"
					value="${role.roleID }"></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色编号：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" readonly="readonly" id="roleNumber"
					name="roleNumber" value="${role.roleNumber }">
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">角色名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="roleName" name="roleName" value="${role.roleName }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">状态：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 默认值还未设置 --> <select id="status" name="status">
						<option value="启用">启用</option>
						<option value="禁用">禁用</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">赋菜单资源：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 遍历输出该所有菜单资源，勾选该角色应该包含的 --> 
					<c:forEach items="${resourceList }"
						var="res">
						<c:if test="${res.parent == null}">
							<input type="checkbox" value="${res.resourceID }"  name="resourceList" />${res.resourceName }<br />
						<c:forEach items="${resourceList }" var="subRes">
								<c:if test="${subRes.parent.resourceID == res.resourceID}">
									&nbsp;&nbsp;&nbsp;<input type="checkbox"  value="${subRes.resourceID }"  name="resourceList" />${subRes.resourceName} <br />
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
					<!-- 遍历该角色的菜单资源,隐藏起来查询用 --> 
					<c:forEach items="${role.resources }"
						var="res">
							<input type="hidden" value="${res.resourceID }"  name="roleResources" /><br />
					</c:forEach>
				</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea
						id="comments" name="comments" rows=10 cols=130>${role.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; <input
					type="submit" class="coolbg" value="保存" /> <a
					href="roleListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>