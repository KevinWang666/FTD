<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户信息</title>
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
						<td>当前位置:客户信息管理>>添加客户信息</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<!-- action还未写 -->
	<form name="form2" action="customerAddAction">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="customerName" name="customerName" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="contact" name="contact"/></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="address" name="address"
					size="60" /></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="cellphone" name="cellphone"/></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input type="text" id="landline" name="landline"/></td>
			</tr>
			<tr>
				<td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
				<td align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea id="intro" name="intro"
						rows=15 cols=130></textarea></td>
			</tr>

			<tr>
				<td align="right" bgcolor="#FAFAF1">备注：</td>
				<td colspan=3 align='left' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';"><textarea id="comments" name="comments"
						rows=10 cols=130></textarea></td>
			</tr>

			<tr bgcolor="#FAFAF1">
				<td height="28" colspan=4 align=center>&nbsp; 
				<!-- 这里需要访问action -->
				<input type="submit" value="保存" class="coolbg" />
				<a href="customerListAction" class="coolbg">返回</a>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>