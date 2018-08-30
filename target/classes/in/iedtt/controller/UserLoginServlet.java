package in.iedtt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.UserDao;
import in.iedtt.entity.Response;
import in.iedtt.entity.User;

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("################################################# User Login called ########################################");
		UserDao userDao = new UserDao();
		User user = userDao.getUserForLogin(request);
		Response loginResponse = userDao.findUserByEmailIdAndPassword(user);
		System.out.println(loginResponse);
		request.setAttribute("response", loginResponse);
		//Login fail case
		if(!loginResponse.getStatus().equalsIgnoreCase("Success")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./index.jsp");
	        requestDispatcher.forward(request, response);
		}else {
			String userId = ((User)loginResponse.getResponseObject()).getEmailId();
			request.getSession().setAttribute("userId", userId);
			Response findAllUsers = userDao.findAllUsers();
			request.getSession().setAttribute("findAllUsers", findAllUsers);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./home.jsp");
	        requestDispatcher.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
