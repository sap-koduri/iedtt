package in.iedtt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.ProjectDao;
import in.iedtt.entity.Project;

/**
 * Servlet implementation class GetProjectModulesServlet
 */
public class GetProjectModulesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProjectModulesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjectDao projectDao = new ProjectDao();
		String projectModules = "<option value=\"\">Select</option>";
		String projectName = (String) request.getParameter("projectName");
		List<Project> modules = projectDao.getAllModulesByProjectName(projectName);
		if(modules!=null) {
			for(int i=0;i<modules.size();i++) {
				projectModules+="<option value=\""+modules.get(i).getModule()+"\">"+modules.get(i).getModule()+"</option>";
			}
		}
		PrintWriter out = response.getWriter();
	    out.write(projectModules);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
