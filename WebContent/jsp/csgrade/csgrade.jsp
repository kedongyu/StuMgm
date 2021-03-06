<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
<head>
<t:head />
<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
</head>

<script language="javascript" src="html/js/manageStudent.js"></script>
<script>
	function createCourse() {
		location.href = './jsp/course/createCourse.jsp';
	}
	function deleteCourse(form) {
		var stuids;
		var cbxoption;
		var m = 0;

		cbxoption = form.elements;
		for (i = 0; i < cbxoption.length; i++) {
			if ((cbxoption[i].tagName.toLowerCase() == "input")
					&& (cbxoption[i].type)
					&& (cbxoption[i].type.toLowerCase() == "checkbox")) {
				if (cbxoption[i].checked) {
					m++;
					if (m == 1)
						stuids = cbxoption[i].id;
					else
						stuids += "," + cbxoption[i].id;
				}
			}
			form.courses.value = stuids;
		}
		if (m == 0) {
			alert("你没有选中需要删除的学生，请重选！");
			return;
		} else {
			if (!confirm("是否将选中的学生信息删除?")) {
				return;
			}
		}

		location.href = "delectCourse.do?courses=" + stuids;
	}
	function studyCourse(form) {
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
			location.href = "studyCourse.do?courseId=" + studid;
		}
	}
	function courseMgm(form) {
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
						alert("一次只能修改一个课程的信息，请重选！");
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

		location.href = "getCsStudentList.do?courseId=" + studid;
	}
	
</script>
<body>
	<t:menu />
	<div class="main-top">
		<span class="title">成绩一览表</span>
	</div>
	<div class="main-body">
		<form name="courseForm" method="POST">

			<table class="main-table" cellpadding="0" cellspacing="0"
				align="center">
				<tr class="title">
					<td>课程序号</td>
					<td>课程名称</td>
					<td>课程学分</td>
					<td>成績</td>
				</tr>
				<c:forEach items="${csList}" var="course"
					varStatus="status">
					<tr>
						<td><c:out value="${status.count}"></c:out></td>
						<td><c:out value="${course.name}"></c:out></td>
						<td><c:out value="${course.credit}" /></td>
						<td>
						<c:out value="${course.id }"/>
						
						</td>
					</tr>
				</c:forEach>
				<c:choose>
					<c:when test="${empty csList}">
						<tr>
							<td colspan=8>暫無任何课程信息!</td>
						</tr>
					</c:when>
				</c:choose>
					<tr >
						<td colspan="6" class="note">							
							<span class="title">注 意 事 项 ：</span>
							"<span class="title">-1</span>" 表示成績未錄入；<br/>
									
						</td>
					</tr>
			</table>
			<input type=hidden name="courses" value="">
		</form>
	</div>
	<t:foot />
</body>
</html>