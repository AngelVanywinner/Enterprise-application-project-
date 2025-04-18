<%@ page import="coursemanage.Course" %>
<%
    Course course = (Course)request.getAttribute("course");
%>
<html>
<head><title>Edit Course</title></head>
<body>
    <h2>Edit Course</h2>
    <form action="CourseServlet?action=UPDATE" method="post">
        <input type="hidden" name="id" value="<%= course.getId() %>">
        Name: <input type="text" name="name" value="<%= course.getName() %>"><br>
        Instructor: <input type="text" name="instructor" value="<%= course.getInstructor() %>"><br>
        Duration: <input type="text" name="duration" value="<%= course.getDuration() %>"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
