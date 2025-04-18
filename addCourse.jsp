<html>
<head><title>Add Course</title></head>
<body>
    <h2>Add Course</h2>
    <form action="CourseServlet?action=INSERT" method="post">
        Name: <input type="text" name="name"><br>
        Instructor: <input type="text" name="instructor"><br>
        Duration: <input type="text" name="duration"><br>
        <input type="submit" value="Save">
    </form>
</body>
</html>
