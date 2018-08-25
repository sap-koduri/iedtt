package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
			String query = "insert into defects (description,identified_by,assigned_to,defect_date,status,rca,eta) values (?,?,?,?,?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, defect.getDescription());
			pstmt.setString(2, defect.getIdentifiedBy());
			pstmt.setString(3, defect.getAssignedTo());
			pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(defect.getDefectDate()));
			pstmt.setString(5, defect.getStatus());
			pstmt.setString(6, defect.getRca());
			pstmt.setString(7, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(defect.getEta()));
			System.err.println("Prepared Statement for Create Defect after bind variables set:\n\t" + pstmt.toString());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				Integer defectId= rs.getInt(1);
				System.out.println("Generated Defect Id: " + defectId);
				response.setStatus("Success");
				response.setStatusMessage("Defect Created Successfully.\n defect id is : "+ defectId);
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
	
	@SuppressWarnings("deprecation")
	public Defect getNewDefect(HttpServletRequest request) {
		Defect defect = new Defect();
		String description = (String)request.getParameter("description");
		defect.setDescription(description);
		String identifiedBy = (String)request.getParameter("identifiedBy");
		defect.setIdentifiedBy(identifiedBy);
		String assignedTo = (String)request.getParameter("assignedTo");
		defect.setAssignedTo(assignedTo);
		String ddate=(String)request.getParameter("defectDate");
		
		defect.setDefectDate(getFormatedDate(ddate));
		String status = (String)request.getParameter("status");
		defect.setStatus(status);
		String rca = (String)request.getParameter("rca");
		defect.setRca(rca);
		String eDate = (String)request.getParameter("eta");
		defect.setEta(getFormatedDate(eDate));
		return defect;
		
	}
	private Date getFormatedDate(String dateString) {
		DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date defectDate = null;
		try {
			defectDate = format.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Error in getFormatedDate : "+ e.getMessage()+" : dateString");
		}
		return defectDate;
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
				defect.setEta(rs.getTimestamp(6));
				defect.setDefectDate(rs.getTimestamp(7));
				defect.setRca(rs.getString(8));
				defects.add(defect);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return defects;
	}
	
	public static void main(String[] args) {
		DefectDao dao  = new DefectDao();
		System.out.println(dao.getAllDefects());
	}
}
