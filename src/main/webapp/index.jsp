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
	<s:form method="post" action="login">
		<s:textfield  name="name" label="用  户  名：" />
		<s:password name="pass" label="密        码：" />
		<s:submit value="提交" />
	</s:form>
		<button onclick="window.location='register.jsp'">注册</button>
</body>
</html>