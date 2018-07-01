<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<t:head />
<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
<script language="javascript" src="html/js/manageStudent.js"></script>
<script >
function courseStudentInfo(form) {
	var cbxoption, studid, username;
	cbxoption = form.elements;
	var m = 0;
	for (i = 0; i < cbxoption.length; i++) {
		if ((cbxoption[i].tagName.toLowerCase() == "input")
				&& (cbxoption[i].type)
				&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
			if (cbxoption[i].checked) {
				m++;
				if (m > 1) {
					alert("一次只能選修一个课程的信息，请重选！");
					return;
				}
				studid = cbxoption[i].id;
			}
		}
	}

	if (m == 0) {
		alert("你没有选中需要修改的课程，请重选！");
		return;
	}
	else{
		location.href = "getCsStudentInfo.do?csId=${courseId}&stuId=" + studid;
	}
}
</script>
</head>
<body>
	<t:menu />
	<div class="main-top">
		<span class="title">課程学生一览表</span>
	</div>
	<div class="main-body">
		<form action="" name="courseForm">
		<table class="main-table" cellpadding="0" cellspacing="0"
			align="center">
			<tr class="title">
				<td></td>
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>籍贯</td>
				<td>身份证号</td>
				<td>电子邮件</td>
				<td>通讯地址</td>
			</tr>
			<c:forEach items="${stuList}" var="stu">
				<tr>
					<td><input type="checkbox" id="${stu.stuNumber}"
						value="${stu.stuNumber}"></td>
					<td><c:out value="${stu.stuNumber}"></c:out></td>
					<td><c:out value="${stu.username}" /></td>
					<td><c:if test="${stu.gender eq '1'}">男</c:if> <c:if
							test="${stu.gender eq '0'}">女</c:if></td>
					<td><c:out value="${stu.city}" /></td>
					<td><c:out value="${stu.identityID}" /></td>
					<td><c:out value="${stu.email}" /></td>
					<td><c:out value="${stu.address}" /></td>
				</tr>
			</c:forEach>

			<tr class="ctrl-button">

				<td colspan=8>
					<center>
						 <input type=button
							name="allnotcheck" value="全不选" onclick="uncheckall(courseForm);" />
						<input type="button" value="學生信息與成績錄入" onclick="courseStudentInfo(courseForm)" />
					
					</center>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<t:foot />
</body>
</html>