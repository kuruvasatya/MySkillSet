<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	result is 
	<%
		int c = (int) request.getAttribute("c");
		out.println("result is: " + c);
	%>
</body>
</html>