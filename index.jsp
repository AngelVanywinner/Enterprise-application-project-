<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Management</title>
</head>
<body>
    <h2>Course List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Instructor</th>
            <th>Duration</th>
            <th>Actions</th>
        </tr>
        <%
            List<Course> list = (List<Course>)request.getAttribute("courses");
            if (list != null) {
                for (Course c : list) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getTitle() %></td>
            <td><%= c.getInstructor() %></td>
            <td><%= c.getDuration() %></td>
            <td>
                <a href="edit?id=<%= c.getId() %>">Edit</a>
                <a href="delete?id=<%= c.getId() %>">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr><td colspan="5">No courses found.</td></tr>
        <% } %>
    </table>
</body>
</html>
