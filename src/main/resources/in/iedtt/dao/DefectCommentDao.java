package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.iedtt.entity.DefectComment;
import in.iedtt.entity.Response;
import in.iedtt.util.DBUtil;

public class DefectCommentDao {
	
	public Response logComment(DefectComment comment) {

		Response response = new Response();
		PreparedStatement pstmt = null;
		Connection connection = null;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% log Comment Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "insert into defect_comments (defect_id,commentor,comment,date_time) values (?,?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, comment.getDefectId());
			pstmt.setString(2, comment.getCommentor());
			pstmt.setString(3, comment.getComment());
			pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			System.err.println("Prepared Statement for Create defect_comments after bind variables set:\n\t" + pstmt.toString());
			int executeUpdateResp = pstmt.executeUpdate();
			if(executeUpdateResp != 0){
				response.setStatus("Success");
				response.setStatusMessage("Comment Added Successfully.");
				response.setResponseObject(comment);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("defect_comments Post Fail");
			}
		} catch (SQLException e) {
			response.setStatus("Exception");
			response.setStatusMessage("defect_comments Post Error");
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null) pstmt.close();
			} catch(Exception ex){}
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% log Comment response %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(response);
		return response;
	
	}
	
	public List<DefectComment> getCommentsByDefectId(int defectId){
		List<DefectComment> comments = new ArrayList<DefectComment>();
		PreparedStatement pstmt = null;
		Connection connection = null;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% log Comment Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "select * from  defect_comments where defect_id = ?";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, defectId);
			System.err.println("Prepared Statement for Create Defect after bind variables set:\n\t" + pstmt.toString());
			ResultSet rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()) {
					DefectComment comment = new DefectComment();
					comment.setDefectId(rs.getInt(1));
					comment.setCommentor(rs.getString(2));
					comment.setComment(rs.getString(3));
					comment.setDate(rs.getString(4));
					comments.add(comment);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			try{
				if(pstmt != null) pstmt.close();
			} catch(Exception ex){}
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% log Comment response %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(comments);
		return comments;
	}
}
