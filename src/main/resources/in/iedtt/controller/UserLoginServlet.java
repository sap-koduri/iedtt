package in.iedtt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.ProjectDao;
import in.iedtt.dao.UserDao;
import in.iedtt.entity.Project;
import in.iedtt.entity.Response;
import in.iedtt.entity.User;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("################################################# User Login called ########################################");
		System.out.println("Network address : Remote -> " + request.getRemoteAddr()  + " Local -> :  "+request.getLocalAddr());
		UserDao userDao = new UserDao();
		User user = userDao.getUserForLogin(request);
		Response loginResponse = userDao.findUserByEmailIdAndPassword(user);
		System.out.println(loginResponse);
		request.setAttribute("response", loginResponse);
		if(!loginResponse.getStatus().equalsIgnoreCase("Success")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
	        requestDispatcher.forward(request, response);
		}else {
			String userId = ((User)loginResponse.getResponseObject()).getEmailId();
			request.getSession().setAttribute("userId", userId);
			Response findAllUsers = userDao.findAllUsers();
			request.getSession().setAttribute("findAllUsers", findAllUsers);
			ProjectDao projectDao = new ProjectDao();
			List<Project> allProjects = projectDao.getAllProjects();
			request.getSession().setAttribute("allProjects", allProjects);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./home.jsp");
	        requestDispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
