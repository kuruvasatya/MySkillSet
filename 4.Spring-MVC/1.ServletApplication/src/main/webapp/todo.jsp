<html>
<body>
as soon as you run the tomcat, and give the below url, you will be to see the content of this file
http://localhost:8080/1.ServletApplication/todo.jsp

1. server gets request to find /todo.jsp, and server check if there is any static file with the name
2. since the static file is present server sends this page to the client
3. else if page is not present (todo.jsp is not present) then server check if there is any servlet that 
can take responsibility of the request

This is todo
</body>
</html>