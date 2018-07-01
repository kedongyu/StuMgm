<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<t:head />
<script type="text/javascript" src="html/js/validateStudentForm.js"></script>
<script language="JavaScript">
	window.onload = function() {
		document.studentForm.onsubmit = validateStudentForm;
	}
</script>
<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
<style>
.main-top {
	height: 60px;
}
</style>
</head>
<body>
	<t:menu />
	<div class="main-top">
		<span class="title">學生信息與成績修改</span> <br /> <span class="tip">查看學生信息與成績錄入修改</span>
	</div>
	<div class="main-body">
		<form name="studentForm" method="POST" action="saveStuGrade.do">
			<input type="hidden" name="flag" value="update" />
			<table class="main-table" cellpadding="0" cellspacing="0"
				align="center">
				<tr>
					<td width="100" height="240" rowspan="6" colspan="2">
						<center>
							<img src="http://localhost:8080${stuImg.imgPath }" width="90"
								height="230" />
						</center>
					</td>
					<td colspan="1">学号：</td>
					<td colspan="1">${student.stuNumber}</td>
					<td colspan="1">姓名：</td>
					<td colspan="1">${student.username }</td>
				</tr>
				<tr>
					<td colspan="1">籍贯：</td>
					<td colspan="1">${student.city }</td>
					<td colspan="1">性别：</td>
					<td colspan="1"><c:if test="${student.gender eq \"1\" }">
							 	男
							 </c:if> <c:if test="${student.gender eq \"0\" }">
							 	女
							 </c:if></td>
				</tr>
				<tr>
					<td colspan="1">身份证：</td>
					<td colspan="3">${student.identityID}</td>
				</tr>
				<tr>
					<td colspan="1">手机：</td>
					<td colspan="1">${student.phone}</td>
					<td colspan="1">邮箱：</td>
					<td colspan="1">${student.email }</td>
				</tr>
				<tr>
					<td colspan="1">地址：</td>
					<td colspan="3">${student.address}</td>
				</tr>
				<tr>
					<td colspan="1">成績：</td>
					<td colspan="3">
						<input value="${stuGrade.stuNum}" name="stuGrade.stuNum" type="hidden">
						<input value="${stuGrade.csId}"name="stuGrade.csId" type="hidden"> 
						<input value="${stuGrade.grade}" name="stuGrade.grade" type="text">
					</td>
				</tr>
				<tr>
					<td colspan="6" class="ctrl-button"><input type="submit"
						value="保存成績"> &nbsp;&nbsp; <input type="reset"
						value="返 回" onclick="history.back(-1);"></td>
				</tr>
				<tr>
					<td colspan="6" class="note"><span class="title">注 意 事
							项 ：</span><br /></td>
				</tr>

			</table>
		</form>
	</div>
	<t:foot />
</body>
</html>