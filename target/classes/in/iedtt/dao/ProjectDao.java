package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import in.iedtt.entity.Project;
import in.iedtt.entity.Response;
import in.iedtt.util.DBUtil;

public class ProjectDao {

	public Project readProjectDTO(HttpServletRequest request) {
		Project project = null;
		try {
			project = new Project();
			int projectId = (Integer) request.getAttribute("projectId");
			int module = (Integer) request.getAttribute("module");
			String projectName = (String) request.getAttribute("projectName");
			project.setModule(module);
			project.setProjectId(projectId);
			project.setProjectName(projectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return project;
	}

	public Response createProject(Project project) {
		Response response = new Response();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection connection = null;
		System.out.println(
				"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% createProject Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		try {
			String query = "insert into project (project_id,name,module) values (?,?,?)";
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				response.setStatus("Success");
				int projectId= rs.getInt(1);
				response.setStatusMessage("Project added Successfully\n project id : "+projectId);
				response.setResponseObject(project);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Project adding fail");
				response.setResponseObject(project);
			}
		} catch (Exception e) {
			response.setStatus("Error");
			response.setStatusMessage("Project addition occured Error");
			response.setResponseObject(project);
			e.printStackTrace();
		} finally {
			DBUtil.closeConnections(pstmt,rs);
		}
		return response;
	}
}
