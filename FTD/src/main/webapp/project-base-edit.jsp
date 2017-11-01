<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑项目信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript" src="JS/jquery-1.4.2.js"></script>
<script type="text/javascript">

//修改每个选项框的默认显示值
function defaultValue(){
	var custIDs = document.form2["p.customer.customerID"] ;
	var userIDs = document.form2["p.user.userID"] ;
	
	for (var i = 0; i < custIDs.length; i++) {
		if (custIDs[i].value == "${project.customer.customerID }") {
			custIDs[i].selected="selected";
			changContact(custIDs[i].value);
		}
	}
	
	for (var i = 0; i < userIDs.length; i++) {
		if (userIDs[i].value == "${project.user.userID }") {
			userIDs[i].selected="selected";
		}
	}
	
}

//异步函数
function changContact(customerID){
	$.ajax({
		type: "post",
		url : "ajaxGetContactAction",
		data : {"custID" : customerID},
		dataType : "json",
		success : function (jsonObj){
			var con = document.form2.contact;
			con.value = jsonObj.toString();
		},
		error : function (){
			alert("出错啦！！！");
		}
	});
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
						<td>当前位置:项目管理>>编辑项目基本信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- action还没写 -->
	<form name="form2" method="post" action="updateProjectAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;编辑项目信息&nbsp;</td>
			</tr>
			<tr >
				<td> <input type="hidden" id="projectID" name="projectID" value="${project.projectID }"/>				
				</td>
			</tr>
			
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="projectName" name="projectName"
					value="${project.projectName }" /></td>
				<td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					<select id="p.customer.customerID" name="p.customer.customerID" onchange="changContact(this.value)">
						<option value="">请选择</option>
						<c:forEach items="${customerList }" var="item">
							<option value="${item.customerID }">${item.customerName }</option>
						</c:forEach>
					</select>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<input type="text" id="contact" name="contact" readonly="readonly"/></td>
				<td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					<select id="p.user.userID" name="p.user.userID">
						<option value="">请选择</option>
						<c:forEach items="${userInfoList }" var="item">
							<option value="${item.userID }">${item.truename }</option>
						</c:forEach>
					</select>
					
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="developerNumber" name="developerNumber"
					value="${project.developerNumber }">人</td>
				<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="pubdate" name="pubdate" value="${project.pubdate }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">最近修改时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="modifydate" name="modifydate"
					value="${project.modifydate }" readonly="readonly"/></td>
				<td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="cost" name="cost" value="${project.cost }" />万</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="level" name="level">
						<option value="紧急">紧急</option>
						<option value="一般">一般</option>
						<option value="暂缓">暂缓</option>
				</select></td>
				<td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="finishdate" name="finishdate"
					value="${project.finishdate }" /></td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea
						id="comments" name="comments" rows=15 cols=130>${project.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
				<input type="submit" class="coolbg" value="保存"> 
				<a href="projectListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>