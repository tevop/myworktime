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
	<h1>add success</h1>
	<%=session.getAttribute("userName")%>
	<%-- List<UserEntity>遍历如下：--%>
	<s:property value="contents.get(0).getDate()" />
	<table width="242" height="256" border="1" cellpadding="1"
		cellspacing="1">
			<s:iterator value="contents" var="content" status="c">
				<tr>
					<td><s:property value="cost" /></td>
					<td><s:property value="comment" /></td>
					<td><s:property value="date" /></td>
				</tr>
			</s:iterator>
	</table>
</body>
 <form method="post" action="add">
		时	间（小时）：<input type="text" name="cost"><br>
		内		     容：<input type="text" name="comment"><br>
		<input type="submit" value="提交">
	</form>
</html>