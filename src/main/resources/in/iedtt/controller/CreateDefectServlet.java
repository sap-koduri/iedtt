package in.iedtt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectDao;
import in.iedtt.dao.UserDao;
import in.iedtt.entity.Defect;
import in.iedtt.entity.Response;

public class CreateDefectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CreateDefectServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Defect creation Requested %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		Defect defect = new Defect();
		DefectDao defectDao = new DefectDao();
		UserDao userDao = new UserDao();
		defect = defectDao.getNewDefect(request);
		Response logDefectResponse = defectDao.logDefect(defect);
		
		request.setAttribute("response", logDefectResponse);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./home.jsp");
		
	    requestDispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}