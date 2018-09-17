package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import in.iedtt.entity.Defect;
import in.iedtt.entity.Response;
import in.iedtt.util.DBUtil;

public class DefectDao {
	
	public Response logDefect(Defect defect) {
		Response response = new Response();
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Defect creation Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "insert into defects (description,identified_by,assigned_to,defect_date,status,rca,eta,project_name,module_name) values (?,?,?,?,?,?,?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, defect.getDescription());
			pstmt.setString(2, defect.getIdentifiedBy());
			pstmt.setString(3, defect.getAssignedTo());
			pstmt.setString(4, defect.getDefectDate());
			pstmt.setString(5, defect.getStatus());
			pstmt.setString(6, defect.getRca());
			if(defect.getEta() == null) {
				pstmt.setString(7,null);
			}else {
				pstmt.setString(7,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(defect.getEta()));
			}
			pstmt.setString(8, defect.getProjectName());
			pstmt.setString(9, defect.getModuleName());
			System.err.println("Prepared Statement for Create Defect after bind variables set:\n\t" + pstmt.toString());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				Integer defectId= rs.getInt(1);
				System.out.println("Generated Defect Id: " + defectId);
				response.setStatus("Success");
				response.setStatusMessage("Defect Created Successfully. defect id is : "+ defectId);
				defect.setId(defectId);
				response.setResponseObject(defect);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Defect Post Fail");
			}
		} catch (SQLException e) {
			response.setStatus("Exception");
			response.setStatusMessage("Defect Post Error");
			e.printStackTrace();
		} finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception ex){}
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Defect creation response %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(response);
		return response;
	}
	
	public Defect getNewDefect(HttpServletRequest request) {
		Defect defect = new Defect();
		
		String defectId = (String)request.getParameter("defectId");
		if(defectId != null) {
			Integer id = Integer.valueOf(defectId);
			defect.setId(id);
		}
		String description = (String)request.getParameter("description");
		defect.setDescription(description);
		String identifiedBy = (String)request.getParameter("identifiedBy");
		defect.setIdentifiedBy(identifiedBy);
		String assignedTo = (String)request.getParameter("assignedTo");
		defect.setAssignedTo(assignedTo);
		String ddate=(String)request.getParameter("defectDate");
		
		defect.setDefectDate(ddate);
		String status = (String)request.getParameter("status");
		defect.setStatus(status);
		String rca = (String)request.getParameter("rca");
		defect.setRca(rca);
		String eDate = (String)request.getParameter("eta");
		defect.setEta(eDate);
		
		String projectName =  (String)request.getParameter("projectName");
		defect.setProjectName(projectName);
		String moduleName =  (String)request.getParameter("moduleName");
		defect.setModuleName(moduleName);
		return defect;
		
	}
	public Response getAllDefects() {
		Response response = new Response();
		List<Defect> defects = new ArrayList<Defect>();
		String query = "select * from defects";
		defects = parseDefects(DBUtil.getData(query));
		if(defects.size() ==0) {
			response.setStatus("noDataFound");
			response.setStatusMessage("getAllDefects fail");
			response.setResponseObject(defects);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("getAllDefects success");
		}
		response.setResponseObject(defects);
		System.out.println("getAllDefects Response : " + response);
		return response;
	}

	public Response getDefectById(int defectId) {
		Response response = new Response();
		List<Defect> defects = new ArrayList<Defect>();
		String query = "select * from defects where id = " + defectId;
		defects = parseDefects(DBUtil.getData(query));
		if(defects.size() ==0) {
			response.setStatus("noDataFound");
			response.setStatusMessage("getAllDefects fail");
			response.setResponseObject(defects);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("getAllDefects success");
		}
		response.setResponseObject(defects);
		System.out.println("getAllDefects Response : " + response);
		return response;
	}
	
	private List<Defect> parseDefects(ResultSet rs) {
		List<Defect> defects = new ArrayList<Defect>();
		try {
			while(null != rs && rs.next()) {
				Defect defect = new Defect();
				defect.setId(rs.getInt(1));
				defect.setDescription(rs.getString(2));
				defect.setStatus(rs.getString(3));
				defect.setIdentifiedBy(rs.getString(4));
				defect.setAssignedTo(rs.getString(5));
				defect.setEta(rs.getString(6));
				defect.setDefectDate(rs.getString(7));
				defect.setRca(rs.getString(8));
				defect.setProjectName(rs.getString(9));
				defect.setModuleName(rs.getString(10));
				defects.add(defect);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return defects;
	}
	public Response updateDefect(Defect defect) {
		Response response = new Response();
		PreparedStatement pstmt = null;
		Connection connection = null;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% updateDefect Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "update defects set assigned_to=?,status=?,rca=?,eta=? where id = ?";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, defect.getAssignedTo());
			pstmt.setString(2, defect.getStatus());
			pstmt.setString(3, defect.getRca());
			if(defect.getEta() == null) {
				pstmt.setString(4,null);
			}else {
				pstmt.setString(4,defect.getEta());
			}
			pstmt.setInt(5, defect.getId());
			System.err.println("Prepared Statement for updateDefect after bind variables set:\n\t" + pstmt.toString());
			int executeUpdateResponse = pstmt.executeUpdate();
			if(executeUpdateResponse != 0 ){
				response.setStatus("Success");
				response.setStatusMessage("Defect Update Successfully. ");
				response.setResponseObject(defect);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Defect Post Fail");
			}
		} catch (SQLException e) {
			response.setStatus("Exception");
			response.setStatusMessage("Defect Post Error");
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null) pstmt.close();
			} catch(Exception ex){}
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Defect creation response %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(response);
		return response;
	}
	
	public HashMap<String, Integer> getDefectsReport(String fromDate, String toDate, String status, String projectName, String moduleName){
		HashMap<String, Integer> report = new HashMap<String, Integer>();
		boolean isWhereAdded = false;
		String query = "SELECT status , COUNT(*) FROM defects GROUP BY status ";
		if(!fromDate.isEmpty() && !toDate.isEmpty()) {
			isWhereAdded = true;
			query += "where defect_date >= " + fromDate + " and defect_date <= " + toDate+" ";
		}
		if(!status.isEmpty()) {
			if(isWhereAdded) {
				query += "";
			}
		}
		
		
		return report;
	}
	
	public static void main(String[] args) {
		DefectDao dao  = new DefectDao();
		System.out.println(dao.getAllDefects());
	}
}
