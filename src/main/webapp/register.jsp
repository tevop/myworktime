<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red">
	<s:fielderror>
		<s:param>errorMessage</s:param>
	</s:fielderror>
	</font>
	<form method="post" action="register">
		用  户  名：<input type="text" name="name"><br>
		密        码：<input type="text" name="pass"><br>
		确认密码：<input type="text" name="repass"><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>