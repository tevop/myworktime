<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="login">
		��  ��  ����<input type="text" name="name"><br>
		��        �룺<input type="text" name="pass"><br>
		<input type="submit" value="�ύ">
	</form>
		<button onclick="window.location='register.jsp'">ע��</button>
		<%=request.getContextPath()%>
</body>
</html>