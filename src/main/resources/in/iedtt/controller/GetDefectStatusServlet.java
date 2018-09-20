package in.iedtt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.iedtt.dao.DefectDao;

/**
 * Servlet implementation class GetDefectStatusServlet
 */
public class GetDefectStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDefectStatusServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DefectDao dao = new DefectDao();
		String resp = "";
		String moduleName = (String) request.getParameter("moduleName");
		String projectName = (String) request.getParameter("projectName");
		String status = (String) request.getParameter("status");
		String toDate = (String) request.getParameter("toDate");
		String fromDate = (String) request.getParameter("fromDate");
		HashMap<String, Integer> defectsReport = dao.getDefectsReport(fromDate, toDate, status, projectName,
				moduleName);
		int newCount = defectsReport.get("New") == null ? 0: defectsReport.get("New"); 
		resp += "New:" +newCount+";";
		int openCount = defectsReport.get("Open") == null ? 0: defectsReport.get("Open");
		resp +=  "Open:" + openCount+";";
		int fixedCount = defectsReport.get("Fixed") == null ? 0: defectsReport.get("Fixed");
		resp +=  "Fixed:" + fixedCount+";";
		int reTestCount = defectsReport.get("ReTest") == null ? 0: defectsReport.get("ReTest");
		resp +=  "ReTest:" + reTestCount+";";
		int closedCount = defectsReport.get("Closed") == null ? 0: defectsReport.get("Closed");
		resp +=  "Closed:" + closedCount;
		System.out.println("Defect Status count : \n" + resp);
		PrintWriter out = response.getWriter();
		out.write(resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
