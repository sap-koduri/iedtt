package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		try {
			String query = "insert into defect (description,identifiedBy,assignedTo,defectDate,status,rca,eta) values (?,?,?,?,?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, defect.getDescription());
			pstmt.setString(2, defect.getIdentifiedBy());
			pstmt.setString(3, defect.getAssignedTo());
			pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(defect.getDefectDate()));
			pstmt.setString(3, defect.getStatus());
			pstmt.setString(3, defect.getRca());
			pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(defect.getEta()));
			System.err.println("Prepared Statement for Create Defect after bind variables set:\n\t" + pstmt.toString());
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs != null && rs.next()){
				Integer defectId= rs.getInt(1);
				System.out.println("Generated Defect Id: " + defectId);
				response.setStatus("Success");
				response.setStatusMessage("Defect Created Successfully.\n defect id is : "+ defectId);
				defect.setId(defectId);
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
		String identifiedBy = (String)request.getParameter("status");
		defect.setIdentifiedBy(identifiedBy);
		String assignedTo = (String)request.getParameter("assignedTo");
		defect.setAssignedTo(assignedTo);
		Date defectDate = new Date((String)request.getParameter("defectDate"));
		defect.setDefectDate(defectDate);
		String status = (String)request.getParameter("status");
		defect.setStatus(status);
		String rca = (String)request.getParameter("rca");
		defect.setRca(rca);
		Date eta = new Date((String)request.getParameter("eta"));
		defect.setEta(eta);
		return defect;
		
	}
}
