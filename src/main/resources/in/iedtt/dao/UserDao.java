package in.iedtt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import in.iedtt.entity.Response;
import in.iedtt.entity.User;
import in.iedtt.entity.UserProfile;
import in.iedtt.util.DBUtil;

public class UserDao {
	
	public Response findUserByEmailIdAndPassword(User user) {
		Response response = new Response();
		String query = "select * from user where email_id ='" + user.getEmailId() +"' and password = '"+user.getPassword()+"'";
		user = parseUser(DBUtil.getData(query));
		if(null == user) {
			response.setStatus("Fail");
			response.setStatusMessage("Please verify credentials");
			response.setResponseObject(user);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("Login success");
			response.setResponseObject(user);
		}
		System.out.println("Login Response : " + response);
		return response;
	}
	
	public Response userRegistration(User user) {
		Response response = new Response();
		String query ="insert into user values('"+user.getEmailId()+"','"+user.getPassword()+"','"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getDatOfRegistration())+"','"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getLastLogin())+"',true)";
		int saveDBResponse = DBUtil.insert(query);
		if(saveDBResponse == 0) {
			response.setStatus("Fail");
			response.setStatusMessage("Please verify details");
			response.setResponseObject(user);
		}else 	if(saveDBResponse == -1) {
			response.setStatus("Error");
			response.setStatusMessage("Internal server error");
			response.setResponseObject(user);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("Registration success");
			response.setResponseObject(user);
		}
		System.out.println("User Registration Response : " + response);
		return response;
	}
	
	public Response userProfileRegistration(UserProfile userProfile) {
		Response response = new Response();
		String query = "insert into user_profile values ('"+
													 userProfile.getEmailId()+"','"+
													 userProfile.getFirstName()+"','"+
													 userProfile.getLastName()+"','"+
													 userProfile.getGender()+"','"+
													 userProfile.getMobile()+"','"+
													 userProfile.getSecretQuestion1()+"','"+
													 userProfile.getSecretQuestionAnswer1()+"','"+
													 userProfile.getSecretQuestion2()+"','"+
													 userProfile.getSecretQuestionAnswer2()+"',"+
													 userProfile.getIsUserProfileActive()
												+")";
		int saveDBResponse = DBUtil.insert(query);
		if(saveDBResponse == 0) {
			response.setStatus("Fail");
			response.setStatusMessage("Please verify details");
			response.setResponseObject(userProfile);
		}else 	if(saveDBResponse == -1) {
			response.setStatus("Error");
			response.setStatusMessage("Internal server error");
			response.setResponseObject(userProfile);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("Registration success");
			response.setResponseObject(userProfile);
		}
		System.out.println("User Profile Registration Response : " + response);
		return response;
	}
	private User parseUser(ResultSet rs) {
		User user = null;
		try {
			if(null != rs && rs.next()) {
				user  = new User();
				user.setEmailId(rs.getString(1));
				user.setDatOfRegistration(rs.getTimestamp(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public Response findAllUsers(User user) {
		Response response = new Response();
		List<String> users = null;
		String query = "select email_id from user";
		users = parseUserIds(DBUtil.getData(query));
		if(users.size() ==0) {
			response.setStatus("Fail");
			response.setStatusMessage("findAllUsers fail");
			response.setResponseObject(users);
		}else {
			response.setStatus("Success");
			response.setStatusMessage("findAllUsers success");
		}
		response.setResponseObject(users);
		System.out.println("findAllUsers Response : " + response);
		return response;
	}

	private List<String> parseUserIds(ResultSet rs) {
		List<String> users = new ArrayList<String>();
		try {
			while(null != rs && rs.next()) {
				users.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public UserProfile getRegistrationUser(HttpServletRequest request) {
		UserProfile userProfile = new UserProfile();
		String firstName=(String)request.getParameter("firstName");
		userProfile.setFirstName(firstName);
		String lastName=(String)request.getParameter("lastName");
		userProfile.setLastName(lastName);
		String gender = (String)request.getParameter("gender");
		userProfile.setGender(gender);
		String mobile = (String)request.getParameter("mobile");
		userProfile.setMobile(mobile);
		String emailId = (String)request.getParameter("emailId");
		userProfile.setEmailId(emailId);
		String secretQuestion1 = (String)request.getParameter("securityQuestion1");
		userProfile.setSecretQuestion1(secretQuestion1);
		String secretQuestionAnswer1 = (String)request.getParameter("securityQuestionAnswer1");
		userProfile.setSecretQuestionAnswer1(secretQuestionAnswer1);
		String secretQuestion2 = (String)request.getParameter("securityQuestion2");
		userProfile.setSecretQuestion2(secretQuestion2);
		String secretQuestionAnswer2 = (String)request.getParameter("securityQuestionAnswer2");
		userProfile.setSecretQuestionAnswer2(secretQuestionAnswer2);
		userProfile.setIsUserProfileActive(true);
		return userProfile;
		
	}
	public User getUserForRegistration(HttpServletRequest request) {
		User user = new User();
		String emailId =  (String)request.getParameter("emailId");
		user.setEmailId(emailId);
		String password = (String)request.getParameter("password");
		user.setPassword(password);
		Date datOfRegistration =  new Date();
		user.setDatOfRegistration(datOfRegistration);
		Date lastLogin =  new Date();
		user.setLastLogin(lastLogin);
		user.setUserActive(true);
		return user;
	}
	public User getUserForLogin(HttpServletRequest request) {
		User user = new User();
		String emailId =  (String)request.getParameter("loginId");
		user.setEmailId(emailId);
		String password = (String)request.getParameter("pwd");
		user.setPassword(password);
		return user;
	}
}
