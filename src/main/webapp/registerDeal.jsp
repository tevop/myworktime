<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
	String name = request.getParameter("username");
	String pass = request.getParameter("pass");
	String rePass = request.getParameter("repass");
	Class.forName("com.mysql.jdbc.Driver");
	Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","123456");
	String sql = "select count(*) as count1 from user where name = ?";
	PreparedStatement ps = cnn.prepareStatement(sql);
	ps.setString(1, name);
	ResultSet rs = ps.executeQuery();
	rs.next();
	int count = rs.getInt(1);
	System.out.println("count is: " + count);
	
	if (count > 0) {
		System.out.println(rs.getString("count1"));
		//System.out.println(rs.getString(3));
		response.sendRedirect("registerFail.jsp");
		ps.close();
		cnn.close();
		return;
	}
	
	sql = "insert into user values(null, ?, ?)";
	ps = cnn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, pass);
	ps.executeUpdate();
	ps.close();
	cnn.close();
	response.sendRedirect("registerSuccess.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>

</body>
</html>