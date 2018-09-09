package in.iedtt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectDao;
import in.iedtt.entity.Response;

/**
 * Servlet implementation class UpdateDefectServlet
 */
public class UpdateDefectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDefectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DefectDao defectDao = new DefectDao();
		String id = request.getParameter("defectId");
		int defectId = Integer.valueOf(id);
		Response defectByIdResponse = defectDao.getDefectById(defectId);
		
		request.setAttribute("response", defectByIdResponse);
		request.getRequestDispatcher("./editDefect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
