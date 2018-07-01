<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<t:head />
<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
<script language="javascript" src="html/js/manageStudent.js"></script>
<script >

</script>
</head>
<body>
	<t:menu />
	<div class="main-top">
		<span class="title">学生成績一览表</span>
	</div>
	<div class="main-body">
		<form action="" name="courseForm">
		<table class="main-table" cellpadding="0" cellspacing="0"
			align="center">
			<tr class="title">
				<td>学号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>籍贯</td>
				<td>身份证号</td>
				<td>电子邮件</td>
				<td>成績</td>
			</tr>
			<c:forEach items="${stuList}" var="stu">
				<tr>
					<td><c:out value="${stu.stuNumber}"></c:out></td>
					<td><c:out value="${stu.username}" /></td>
					<td><c:if test="${stu.gender eq '1'}">男</c:if> <c:if
							test="${stu.gender eq '0'}">女</c:if></td>
					<td><c:out value="${stu.city}" /></td>
					<td><c:out value="${stu.identityID}" /></td>
					<td><c:out value="${stu.email}" /></td>
					<td><c:out value="${stu.postID }"/></td>
				</tr>
			</c:forEach>

			<tr class="ctrl-button">

				<td colspan=8>
				<span class="title">注 意 事 项 ：</span>
							"<span class="title">-1</span>" 表示成績未錄入；<br/>
							
				</td>
			</tr>
		</table>
		</form>
	</div>
	<t:foot />
</body>
</html>