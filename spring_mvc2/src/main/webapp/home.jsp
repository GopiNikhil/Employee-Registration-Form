<%@page import="spring_mvc2.dto.Employee"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>
<h1>Login Successfull</h1>
<%
List<Employee> list = (List<Employee>) request.getAttribute("list");
for(Employee e : list){
%>

<table border="2">
   
    <tr>
        <td>EMP Id</td>
        <td>EMP Name</td>
        <td>EMP Email</td>
        <td>EMP Phone</td>
 
    </tr>
    <tr>
        <td><%=e.getId() %></td>
        <td><%=e.getName() %></td>
        <td><%=e.getEmail() %></td>
        <td><%=e.getPhone() %></td>
         <td>
        <a href="update?id=<%=e.getId()%>">
			<button>
			Update
			</button>
		</a>
        </td>
        <td>
        <a href="delete?id=<%=e.getId()%>">
			<button>
			Delete
			</button>
		</a>
		</td>
    </tr>
</table>

<%} %>

</body>
</html>