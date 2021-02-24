<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>List User</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div>
    <div class="col-md-8">User List</div>
    <div class="col-md-2">
        <a href="add_user" class="btn btn-primary">Add User</a>
    </div>
</div>

<c:if test="${!empty users}">
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>User Name</th>
                <th>DOB</th>
                <th>Email</th>
                <th>Mobile No</th>
                <th>Gender</th>
                <th>Nationality</th>
                <th>Hobbies</th>
                <th>Address</th>
                <th>Comments</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.dob}</td>
                    <td>${user.email}</td>
                    <td>${user.mobileNo}</td>
                    <td>${user.gender}</td>
                    <td>${user.nationality}</td>
                    <td>${user.hobbies}</td>
                    <td>${user.address}</td>
                    <td>${user.comments}</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
                    <td><a href="edit_user?id=${user.id}">Edit</a>| <a
                            href="delete_user?id=${user.id}">Delete</a></td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
</body>
</html>