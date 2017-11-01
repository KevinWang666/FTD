<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<script type="text/javascript" src="JS/jquery-1.4.2.js"></script>
<script type="text/javascript">
//异步函数：根据项目返回对应需求列表
function changNeed(projectID){
	$.ajax({
		type: "post",
		url : "ajaxGetProjectNeedListAction",
		data : {"proID" : projectID},
		dataType : "json",
		success : function (jsonObj){
			//重写
			var needIDs = document.form2["needID"].options;
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
			var modelIDs = document.form2["modelID"].options;
			modelIDs.length = jsonObj.length + 1;
			$(jsonObj).each(function(i , proModel){
				modelIDs[i + 1].value =  proModel.modelID ;
				modelIDs[i + 1].text =  proModel.modelName ;
			});
		},
		error : function (jsonObj){
			alert("出错啦！！！");
		}
	});
}

//异步函数：根据模块返回功能列表
function changFunction(modelID){
	$.ajax({
		type: "post",
		url : "ajaxGetProjectFunctionListAction",
		data : {"modelID" : modelID},
		dataType : "json",
		success : function (jsonObj){
			//重写
			var functionIDs = document.form2["t.projectFunction.functionID"].options;
			functionIDs.length = jsonObj.length + 1;
			$(jsonObj).each(function(i , proFunction){
				functionIDs[i + 1].value =  proFunction.functionID ;
				functionIDs[i + 1].text =  proFunction.functionName ;
			});
		},
		error : function (jsonObj){
			alert("出错啦！！！");
		}
	});
}
</script>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

	<!--  快速转换位置按钮  -->
	<table width="98%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#D1DDAA" align="center">
		<tr>
			<td height="26" background="skin/images/newlinebg3.gif">
				<table width="58%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>当前位置:任务管理>>创建任务</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<form name="form2" method="post" action="addTaskAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 4个列表，异步级联 -->
					<select id="projectID" name="projectID" onchange="changNeed(this.value)">
						<option value="">请选择</option>
						<c:forEach items="${projectList }" var="item">
							<option value="${item.projectID }">${item.projectName }</option>
						</c:forEach>
					</select>- 
					<select id="needID" name="needID" onchange="changModel(this.value)" >
						<option value="">请选择</option>
						<c:forEach items="${projectNeedList }" var="item">
							<option value="${item.needID }">${item.needName }</option>
						</c:forEach>
					</select>- 
					<select id="modelID" name="modelID" onchange="changFunction(this.value)">
						<option value="">请选择</option>
						<c:forEach items="${projectModelList }" var="item">
							<option value="${item.modelID }">${item.modelName }</option>
						</c:forEach>
					</select>- 
					<select id="t.projectFunction.functionID" name="t.projectFunction.functionID">
						<option value="">请选择</option>
						<c:forEach items="${projectFunctionList }" var="item">
							<option value="${item.functionID }">${item.functionName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="taskname" name="taskname" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="startdate" name="startdate" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input
					type="text" id="finishdate" name="finishdate" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<!-- 用户列表 -->
					<select	id="t.exeUser.userID" name="t.exeUser.userID">
						<c:forEach items="${userInfoList }" var="item">
							<option value="${item.userID }">${item.truename }--${item.job }</option>
						</c:forEach>
					</select>
				</td>
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
				<td align="right" bgcolor="#FAFAF1">详细说明：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea
						id="desc" name="desc" rows=10 cols=130></textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
					<input type="submit" class="coolbg" value="保存">
					<a href="taskListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>

</body>
</html>