package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import in.iedtt.entity.Project;
import in.iedtt.entity.Response;
import in.iedtt.util.DBUtil;

public class ProjectDao {
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	public Response createProject(Project project) {
		Response response = new Response();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% createProject Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "insert into project (project_name,description,module_name) values (?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, project.getProjectName());
			pstmt.setString(2, project.getProjectDescription());
			pstmt.setString(3, project.getModule());
			System.out.println("*********************************************  new Project Query ***************************************************************");
			
			int resp = pstmt.executeUpdate();
			if(resp!=0) {
				response.setStatus("Success");
				int projectId= rs.getInt(1);
				response.setStatusMessage("Project added Successfully\n project id : "+projectId);
				response.setResponseObject(project);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Project adding fail");
				response.setResponseObject(project);
			}
		}catch(MySQLIntegrityConstraintViolationException e) {
			response.setStatus("Fail");
			response.setStatusMessage("Duplicate Projecct name and Module name Error");
			response.setResponseObject(project);
			System.err.println(e.getLocalizedMessage());
		}catch (Exception e) {
			response.setStatus("Error");
			response.setStatusMessage("Project addition occured Error");
			response.setResponseObject(project);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnections(pstmt, rs);
		}
		return response;
	}
}
