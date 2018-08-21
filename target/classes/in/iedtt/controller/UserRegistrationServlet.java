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
import in.iedtt.entity.UserProfile;

public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegistrationServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("********************* User Registration go called **************************************************");
		UserDao userDao = new UserDao();
		UserProfile userProfile = userDao.getRegistrationUser(request);
		User user = userDao.getUserForRegistration(request);
		userDao.userRegistration(user);
		Response userRegistrationResponse = userDao.userProfileRegistration(userProfile);
		request.setAttribute("response", userRegistrationResponse);
		System.out.println("************************* userRegistrationResponse ************************************************");
		System.out.println(userRegistrationResponse);
		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
         requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
