<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<html>
	<head>
		<t:head />
		<script type="text/javascript"
			src="html/js/validateStudentForm.js"></script>
		<script language="JavaScript">
		window.onload = function(){
			document.studentForm.onsubmit = validateStudentForm;	
		}
		</script>
		<link rel="stylesheet" href="html/css/editStudent.css" type="text/css"></link>
		<style>
		.main-top{
			height:60px;
		}
		</style>
		<script type="text/javascript">
		function preImg(source, targetId) { 
            var imgPre = document.getElementById(targetId);	
            imgPre.src = source; 

        } 
		</script>
	</head>
	<body>
		<t:menu />
		<div class="main-top">
			<span class="title">个人信息</span>
			<br />
			<span class="tip">个人信息查看与修改</span>
		</div>
		<div class="main-body">
			<form name="studentForm" method="POST" action="correctImg.do" enctype="multipart/form-data" accept="image/*">
				<table class="main-table" cellpadding="0" cellspacing="0" align="center">
					<tr >
						<td width="100" height="240" rowspan="5" colspan="2">
							<center><img id="photo" src="http://localhost:8080${stuImg.imgPath }"  height="200px" />
							<input  name="stufile" type="file" onchange="preImg(this.value,'photo');"/></center>
						</td>
						<td colspan="1">
							 学号：
						</td>
						<td colspan="1">
							 <input name="student.stuNumber" type="hidden" value="${student.stuNumber}"/>
							 ${student.stuNumber}
						</td>
						<td  colspan="1">
							 姓名：
						</td>
						<td colspan="1">
							 <input name="student.username" type="text" value="${student.username }"/>
						</td>
					</tr>
					<tr >
						<td  colspan="1">
							 籍贯：
						</td>
						<td colspan="1">
							 <input name="student.city" type="text" value="${student.city }">
						</td>
						<td  colspan="1">
							 性别：
						</td>
						<td colspan="1">
							<input name="student.gender" type="hidden" value="${student.gender }"/>
							 <c:if test="${student.gender eq \"1\" }">
							 	男
							 </c:if>
							 <c:if test="${student.gender eq \"0\" }">
							 	女
							 </c:if>
							 
						</td>
					</tr>
					<tr >
						<td  colspan="1">
							 身份证：
						</td>
						<td colspan="3" >
							 <input name="student.identityID" type="text" value="${student.identityID}"/>
						</td>
					</tr>
					<tr >
						<td colspan="1">
							 手机：
						</td>
						<td colspan="1">
							 <input name="student.phone" type="text" value="${student.phone}"/>
						</td>
						<td  colspan="1">
							 邮箱：
						</td>
						<td colspan="1">
						 	<input name="student.email" type="text" value="${student.email }"/>
						</td>
					</tr>
					<tr >
						<td  colspan="1">
							 地址：
						</td>
						<td colspan="3" >
							<input name="student.address" type="text" value="${student.address}"/>
						</td>
					</tr>
					<tr >
						<td colspan="6" class="ctrl-button">
								<input type="submit" value="修改">
								&nbsp;&nbsp;
								<input type="reset" value="返 回" onclick="history.back(-1);">
						</td>
					</tr>
					<tr >
						<td colspan="6" class="note">							
							<span class="title">注 意 事 项 ：</span><br/>
							1. 请仔细核对学生个人的信息，确认所输入的信息是正确的，如果本次输入错了，还可以继续修改；<br/>
							2.<span class="tip">*</span> 为必填项，如果全部正确输入后,按“修 改”按钮进行创建。
									
						</td>
					</tr>

				</table>
			</form>
		</div>
		<t:foot />
	</body>
</html>