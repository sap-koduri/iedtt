package in.iedtt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.ProjectDao;
import in.iedtt.entity.Project;
import in.iedtt.entity.Response;

/**
 * Servlet implementation class ProjectRegistrationServlet
 */
public class ProjectRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Project project = new Project();
		ProjectDao dao = new ProjectDao();
		String projectName= (String) request.getParameter("projectName");
		String description = (String) request.getParameter("description");
		String module = (String) request.getParameter("module");
		project.setModule(module);
		project.setProjectName(projectName);
		project.setProjectDescription(description);
		Response createProjectResp = dao.createProject(project);
		
		request.setAttribute("response", createProjectResp);
		request.getRequestDispatcher("./adminPanel.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
