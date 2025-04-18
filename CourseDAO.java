package coursemanage;

import java.sql.*;
import java.util.*;

public class CourseDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructor"),
                        rs.getString("duration")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public void insertCourse(Course course) {
        String sql = "INSERT INTO courses(name, instructor, duration) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setString(2, course.getInstructor());
            stmt.setString(3, course.getDuration());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Course getCourseById(int id) {
        Course course = null;
        String sql = "SELECT * FROM courses WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("instructor"),
                        rs.getString("duration")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return course;
    }

    public void updateCourse(Course course) {
        String sql = "UPDATE courses SET name=?, instructor=?, duration=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, course.getName());
            stmt.setString(2, course.getInstructor());
            stmt.setString(3, course.getDuration());
            stmt.setInt(4, course.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int id) {
        String sql = "DELETE FROM courses WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
