package in.iedtt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.iedtt.dao.DefectDao;
import in.iedtt.entity.Response;

/**
 * Servlet implementation class DefectsListServlet
 */
public class DefectsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefectsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("################################################# DefectsListServlet called ########################################");
		DefectDao defectDao = new DefectDao();
		Response resp = defectDao.getAllDefects();
		request.setAttribute("response",resp);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./defectsList.jsp");
        requestDispatcher.forward(request, response);
        System.out.println("################################################# DefectsListServlet Response ########################################");
        System.err.println(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
