<%-- 
    Document   : userView
    Created on : Oct 6, 2024, 7:34:09 PM
    Author     : TRUNG NHAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Danh Sach Nguoi Dung</h1>
        <table border="1">
            <tr>
                <td>username</td>
                <td>password</td>
                <td>Action</td>
            </tr>        
            <c:forEach var="u" items="${data}">
                <c:set var="id" value="${u.username}"/>
                <tr>
                    <td>${id}/></td>
                    <td>${u.password}</td>
                    <td>
                        <a href="deleteUser?username=${u.id}" onclick="return confirm('Are you sure')">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
