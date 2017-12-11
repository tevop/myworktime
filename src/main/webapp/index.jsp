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
		用  户  名：<input type="text" name="name"><br>
		密        码：<input type="text" name="pass"><br>
		<input type="submit" value="提交">
	</form>
		<button onclick="window.location='register.jsp'">注册</button>
		<%=request.getContextPath()%>
</body>
</html>