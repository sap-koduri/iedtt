package in.iedtt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.ProjectDao;
import in.iedtt.entity.Project;
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportsServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDao projectDao = new ProjectDao();
		List<Project> allProjects = projectDao.getAllProjects();
		request.getSession().setAttribute("projects", allProjects);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./report.jsp");
        requestDispatcher.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
