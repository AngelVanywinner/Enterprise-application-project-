<%@ page import="coursemanage.Course" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Course Form</title></head>
<body>
    <h2>Course Form</h2>
    <%
        Course course = (Course) request.getAttribute("course");
        boolean edit = (course != null);
    %>
    <form action="CourseServlet" method="get">
        <input type="hidden" name="action" value="<%= edit ? "UPDATE" : "INSERT" %>">
        <% if (edit) { %>
            <input type="hidden" name="id" value="<%= course.getId() %>">
        <% } %>
        Name: <input type="text" name="name" value="<%= edit ? course.getName() : "" %>"><br>
        Instructor: <input type="text" name="instructor" value="<%= edit ? course.getInstructor() : "" %>"><br>
        Duration: <input type="text" name="duration" value="<%= edit ? course.getDuration() : "" %>"><br>
        <input type="submit" value="<%= edit ? "Update" : "Save" %>">
    </form>
</body>
</html>
