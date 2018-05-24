<%--
  Created by IntelliJ IDEA.
  User: ATS2231
  Date: 5/18/2018
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<form:form id="loginForm" modelAttribute="login" action="loginProcess.htm" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="userName">Username: </form:label>
            </td>
            <td>
                <form:input path="userName" name="userName" id="userName" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="Password">Password:</form:label>
            </td>
            <td>
                <form:password path="Password" name="Password" id="password" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                 <input type="submit" value="Submit" />

            </td>
        </tr>
        <tr></tr>
        <!-- <tr>
            <td></td>
            <td><a href="home.jsp">Home</a>
            </td>
        </tr> -->
    </table>
</form:form>
<table align="center">
    <%--<tr>
        <td style="font-style: italic; color: red;">${message}</td>
    </tr>--%>
</table>
</body>
</html>
