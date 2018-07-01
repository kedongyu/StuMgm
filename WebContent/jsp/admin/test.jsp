<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
		function preImg(source, targetId) { 
            var imgPre = document.getElementById(targetId);	
            imgPre.src = source; 

        } 
		</script>
<body>
	<form name="studentForm" method="POST" action="correctImg.do" enctype="multipart/form-data" accept="image/*"> 
		<center>
			<img id="photo" src="" height="200px" /> <input name="stufile"
				type="file" onchange="preImg(this.value,'photo');" />
		</center>
		<input type="submit" value="submit">
	</form>
</body>
</html>