package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			System.err.println(pstmt.toString());
			int resp = pstmt.executeUpdate();
			if(resp!=0) {
				response.setStatus("Success");
				response.setStatusMessage("Project added Successfully");
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
	
	public List<Project> getAllModulesByProjectName(String projectName){
		List<Project> projectModules = new ArrayList<Project>();
		Response response = new Response();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Get All Modules List By Project Name Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
			try {
				String query = "select * from project where project_name = ?" ;
				connection = DBUtil.getconnection();
				pstmt = connection.prepareStatement(query);
				pstmt.setString(1, projectName);
				
				System.out.println("*********************************************  Get All Modules List By Project Name  Query ***************************************************************");
				System.err.println(pstmt.toString());
				rs = pstmt.executeQuery();
				projectModules = parseResultSetForProjectModules(rs);
				response.setStatus("Success");
				response.setStatusMessage("Project Modules count is : " + projectModules.size());
				response.setResponseObject(projectModules);
			}catch (Exception e) {
				response.setStatus("Error");
				response.setStatusMessage("Exception occured in Get All Modules List By Project Name Method");
				response.setResponseObject(projectModules);
				e.printStackTrace();
			} finally {
				DBUtil.closeConnections(pstmt, rs);
			}
		return projectModules;
	}
	public List<Project> getAllProjects(){
		List<Project> projectsList = new ArrayList<Project>();
		Response response = new Response();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% Get All Projects Method called %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
			try {
				String query = "select distinct (project_name) from project" ;
				connection = DBUtil.getconnection();
				pstmt = connection.prepareStatement(query);
				System.out.println("*********************************************  Get All Projects  Query ***************************************************************");
				System.err.println(pstmt.toString());
				rs = pstmt.executeQuery();
				projectsList = parseResultSetForProjects(rs);
				response.setStatus("Success");
				response.setStatusMessage("Project Modules count is : " + projectsList.size());
				response.setResponseObject(projectsList);
			}catch (Exception e) {
				response.setStatus("Error");
				response.setStatusMessage("Exception occured in Get All Projects Method");
				response.setResponseObject(projectsList);
				e.printStackTrace();
			} finally {
				DBUtil.closeConnections(pstmt, rs);
			}
		return projectsList;
	}
	private List<Project> parseResultSetForProjectModules(ResultSet resultSet){

		List<Project> projectModules = new ArrayList<Project>();
			try {
				while(resultSet != null && resultSet.next()) {
					Project project = new Project();
					project.setProjectName(resultSet.getString(1));
					project.setProjectDescription(resultSet.getString(2));
					project.setModule(resultSet.getString(3));
					projectModules.add(project);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return projectModules;
	}
	private List<Project> parseResultSetForProjects(ResultSet resultSet){

		List<Project> projectModules = new ArrayList<Project>();
			try {
				while(resultSet != null && resultSet.next()) {
					Project project = new Project();
					project.setProjectName(resultSet.getString(1));
					projectModules.add(project);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return projectModules;
	}
}
