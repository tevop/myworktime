<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<h1>add success</h1>
	<%-- List<UserEntity>遍历如下：--%>
	<table width="242" height="256" border="1" cellpadding="1"
		cellspacing="1">
		<s:iterator  value="users" var="user" status="u">
			<tr>
				<td><s:property value="#user.name" /></td>
				<td><s:property value="#user.pass" /></td>
				<td><s:property value="#user.id" /></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>