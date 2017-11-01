<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑功能信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript" src="JS/jquery-1.4.2.js"></script>
<script type="text/javascript">

//修改每个选项框的默认显示值
function defaultValue(){
	var proIDs = document.form2["pf.projectModel.projectNeed.project.projectID"] ;
	var needIDs = document.form2["pf.projectModel.projectNeed.needID"] ;
	var modelDs = document.form2["pf.projectModel.modelID"] ;
	var priority = document.form2.priority ;
	
	for (var i = 0; i < proIDs.length; i++) {
		if (proIDs[i].value == "${projectFunction.projectModel.projectNeed.project.projectID }") {
			proIDs[i].selected="selected";
			changNeed(proIDs[i].value);
		}
	}
	
	for (var i = 0; i < needIDs.length; i++) {
		if (needIDs[i].value == "${projectFunction.projectModel.projectNeed.needID }") {
			needIDs[i].selected="selected";
			changModel(needIDs[i].value);
		}
	}
	
	for (var i = 0; i < modelDs.length; i++) {
		if (modelDs[i].value == "${projectFunction.projectModel.modelID }") {
			modelDs[i].selected="selected";
		}
	}
	
	for (var i = 0; i < priority.length; i++) {
		if (priority[i].value == "${projectFunction.priority }") {
			priority[i].selected="selected";
		}
	}
	
}

//异步函数：根据项目返回对应需求列表
function changNeed(projectID){
	$.ajax({
		type: "post",
		url : "ajaxGetProjectNeedListAction",
		data : {"proID" : projectID},
		dataType : "json",
		success : function (jsonObj){
			//重写
			var needIDs = document.form2["pf.projectModel.projectNeed.needID"].options;
			needIDs.length = jsonObj.length + 1;
			$(jsonObj).each(function(i , proNeed){
				needIDs[i + 1].value =  proNeed.needID ;
				needIDs[i + 1].text =  proNeed.needName ;
			});
		},
		error : function (){
			alert("出错啦！！！");
		}
	});
}
//异步函数：根据需求返回对应模块列表
function changModel(needID){
	$.ajax({
		type: "post",
		url : "ajaxGetProjectModelListAction",
		data : {"needID" : needID},
		dataType : "json",
		success : function (jsonObj){
			//重写
			var modelIDs = document.form2["pf.projectModel.modelID"].options;
			modelIDs.length = jsonObj.length + 1;
			$(jsonObj).each(function(i , proModel){
				modelIDs[i + 1].value =  proModel.modelID ;
				modelIDs[i + 1].text =  proModel.modelName ;
			});
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
						<td>当前位置:项目管理>>编辑功能信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" method="post" action="updateProjectFunctionAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;编辑功能&nbsp;</td>
			</tr>
			<tr>
			<td>
				<input type="hidden" id="functionID" name="functionID" value="${projectFunction.functionID }">
			</td>
			<td>
				<input type="hidden" id="startdate" name="startdate" value="${projectFunction.startdate }">
			</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 项目列表 -->
					<select id="pf.projectModel.projectNeed.project.projectID" name="pf.projectModel.projectNeed.project.projectID" onchange="changNeed(this.value)">
						<c:forEach items="${projectList }" var="item">
							<option value="${item.projectID }">${item.projectName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 需求列表 -->
					<select id="pf.projectModel.projectNeed.needID" name="pf.projectModel.projectNeed.needID" onchange="changModel(this.value)">
							<option value="">请选择</option>
						<c:forEach items="${projectNeedList }" var="item">
							<option value="${item.needID }">${item.needName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">选择模块：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 模块列表 -->
					<select id="pf.projectModel.modelID" name="pf.projectModel.modelID">
							<option value="">请选择</option>
						<c:forEach items="${projectModelList }" var="item">
							<option value="${item.modelID }">${item.modelName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">功能名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="functionName" name="functionName"
					value="${projectFunction.functionName }" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<select id="priority" name="priority">
						<option value="高">高</option>
						<option value="中">中</option>
						<option value="低">低</option>
						<option value="暂缓">暂缓</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea id="simpleDesc" name="simpleDesc"
						rows=10 cols=130>${projectFunction.simpleDesc }</textarea></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea id="detailDesc" name="detailDesc"
						rows=15 cols=130>${projectFunction.detailDesc }</textarea></td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea id="comments" name="comments"
						rows=10 cols=130>${projectFunction.comments }</textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
				<input type="submit" class="coolbg" value="保存"> 
				<a href="projectFuctionListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>