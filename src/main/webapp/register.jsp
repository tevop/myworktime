<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/register.action">
		��  ��  ����<input type="text" name="name"><br>
		��        �룺<input type="text" name="pass"><br>
		ȷ�����룺<input type="text" name="repass"><br>
		<input type="submit" value="�ύ">
	</form>
</body>
</html>