<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑用户信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript">

//修改每个选项框的默认显示值
function defaultValue(){
	var jobs = document.form2.job ;
	var sexs = document.form2.sex ;
	var roles = document.form2["ui.role.roleID"] ;
	
	for (var i = 0; i < jobs.length; i++) {
		if (jobs[i].value == "${user.job }") {
			jobs[i].selected="selected";
		}
	}
	
	for (var i = 0; i < sexs.length; i++) {
		if (sexs[i].value == "${user.sex }") {
			sexs[i].selected="selected";
		}
	}
	
	for (var i = 0; i < roles.length; i++) {
		if (roles[i].value == "${user.role.roleID }") {
			roles[i].checked="checked";
		}
	}
	
}

</script>

<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'
	onload="defaultValue()">

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:权限管理>>编辑用户</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" method="post" action="updateUserInfoAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑用户&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">职位：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="job" name="job">
						<!-- 还是在JS里面写吧。。。 -->
						<option value="初级开发工程师" >初级开发工程师</option>
						<option value="中级开发工程师">中级开发工程师</option>
						<option value="高级开发工程师">高级开发工程师</option>
						<option value="项目经理">项目经理</option>
						<option value="其它">其它</option>
					</select></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">姓名：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="username" name="username" value="${user.username }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">性别：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="sex" name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">年龄：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="age" name="age" value="${user.age }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="cellphone" name="cellphone"
					value="${user.cellphone }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">入职时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="hiredate" name="hiredate" value="${user.hiredate }" />
					&nbsp;&nbsp;&nbsp;格式：yyyy-MM-dd
					</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">身份证号码：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="identificationNumber" name="identificationNumber"
					value="${user.identificationNumber }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">赋角色：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 这里应该是只能选一个吧？ --> 
					<c:forEach items="${roleList }" var="item">
						<input type="radio" id="ui.role.roleID" name="ui.role.roleID"
							value="${item.roleID }" />${item.roleName }<br>
					</c:forEach>
				</td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea
						id="comments" name="comments" rows=10 cols=130>${user.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
				<input type="submit"  class="coolbg" value="保存" />
				
				<a href="userInfoListAction"
					class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>