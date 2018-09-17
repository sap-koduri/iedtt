package in.iedtt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectDao;
import in.iedtt.entity.Defect;
import in.iedtt.entity.Response;
import in.iedtt.util.Mail;

/**
 * Servlet implementation class EditDefectServlet
 */
public class EditDefectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDefectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Defect Edit Requested %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		Defect defect = new Defect();
		DefectDao defectDao = new DefectDao();
		defect = defectDao.getNewDefect(request);
		Response updateDefectResp = defectDao.updateDefect(defect);
		request.getSession().setAttribute("response", updateDefectResp);
		defect = (Defect) updateDefectResp.getResponseObject();
		Mail.sendNotification(defect.getAssignedTo()+";" + defect.getIdentifiedBy(), "Defect ID : "+defect.getId(), defect.getDescription());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./home.jsp");
	    requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
