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
	function editCourse(form) {
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

		location.href = "getCourseById.do?courseId=" + studid;
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
	function courseGrade(form) {
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

		location.href = "findCsGrade.do?csId=" + studid;
	}
</script>
<body>
	<t:menu />
	<div class="main-top">
		<span class="title">课程信息一览表</span>
	</div>
	<div class="main-body">
		<form name="courseForm" method="POST">

			<table class="main-table" cellpadding="0" cellspacing="0"
				align="center">
				<tr class="title">
					<td></td>
					<td>课程序号</td>
					<td>课程名称</td>
					<td>课程学分</td>
				</tr>
				<c:forEach items="${request.courseList}" var="course"
					varStatus="status">
					<tr>
						<td><input type="checkbox" id="${course.id}"
							value="${course.id}"></td>
						<td><c:out value="${status.count}"></c:out></td>
						<td><c:out value="${course.name}"></c:out></td>
						<td><c:out value="${course.credit}" /></td>
					</tr>
				</c:forEach>
					<c:if test="${empty courseList}">
						<tr>
							<td colspan=8>没有任何课程信息，请先添加!</td>
						</tr>
					</c:if>
						<tr class="ctrl-button">

							<td colspan=4>
								<center>
									<input type=button name="allcheck" value="全选"
										onclick="checkall(courseForm);" /> <input type=button
										name="allnotcheck" value="全不选"
										onclick="uncheckall(courseForm);" /> <input type=button
										name="delete" value="删除" onclick="deleteCourse(courseForm);" />
									<input type="button" value="修改课程信息" onclick="editCourse(courseForm)"/>
									<input type="button" value="课程成绩管理" onclick="courseMgm(courseForm)"/>
									<input type="button" value="课程成绩一覽表" onclick="courseGrade(courseForm)"/>
									
									<input type="button" value="新建课程" onclick="createCourse()" />
									
								</center>
							</td>
						</tr>
			</table>
			<input type=hidden name="courses" value="">
		</form>
	</div>
	<t:foot />
</body>
</html>