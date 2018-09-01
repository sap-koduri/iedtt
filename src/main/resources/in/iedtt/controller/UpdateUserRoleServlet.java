package in.iedtt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.UserDao;
import in.iedtt.entity.Response;
import in.iedtt.entity.User;

/**
 * Servlet implementation class UpdateUserRoleServlet
 */
public class UpdateUserRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserRoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		User user = new User();
		String emailId = (String)request.getParameter("users");
		user.setEmailId(emailId);
		
		String role = (String)request.getParameter("role");
		user.setRole(role );
		
		UserDao dao= new UserDao();
		Response resp = dao.updateUserRole(user);
		
		request.setAttribute("response", resp);
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
