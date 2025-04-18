package coursemanage;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
    private CourseDAO courseDAO;

    public void init() {
        courseDAO = new CourseDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listCourses(request, response);
            } else {
                switch (action) {
                    case "NEW":
                        showNewForm(request, response);
                        break;
                    case "INSERT":
                        insertCourse(request, response);
                        break;
                    case "EDIT":
                        showEditForm(request, response);
                        break;
                    case "UPDATE":
                        updateCourse(request, response);
                        break;
                    case "DELETE":
                        deleteCourse(request, response);
                        break;
                    default:
                        listCourses(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> list = courseDAO.getAllCourses();
        request.setAttribute("courses", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Course existing = courseDAO.getCourseById(id);
        request.setAttribute("course", existing);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        String instructor = request.getParameter("instructor");
        String duration = request.getParameter("duration");

        Course newCourse = new Course(name, instructor, duration);
        courseDAO.insertCourse(newCourse);
        response.sendRedirect("CourseServlet");
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String instructor = request.getParameter("instructor");
        String duration = request.getParameter("duration");

        Course updatedCourse = new Course(id, name, instructor, duration);
        courseDAO.updateCourse(updatedCourse);
        response.sendRedirect("CourseServlet");
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        courseDAO.deleteCourse(id);
        response.sendRedirect("CourseServlet");
    }
}
