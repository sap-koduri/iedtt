package in.iedtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import in.iedtt.entity.Response;
import in.iedtt.entity.User;
import in.iedtt.entity.UserProfile;
import in.iedtt.util.DBUtil;
import in.iedtt.util.UserRoles;

public class UserDao {

	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	public Response findUserByEmailIdAndPassword(User user) {
		Response response = new Response();
		String query = "select * from user where email_id ='" + user.getEmailId() +"' and password = '"+user.getPassword()+"'";
		user = parseUser(DBUtil.getData(query));
		if(null == user) {
			response.setStatus("Fail");
			response.setStatusMessage("Please verify credentials");
			response.setResponseObject(user);
		}else {
			if(user.isUserActive() == false) {
				response.setStatus("inActive");
				response.setStatusMessage("User Login Success. But User is in active.");
			}else {
				response.setStatus("Success");
				response.setStatusMessage("Login success");
			}
			response.setResponseObject(user);
		}
		System.out.println("Login Response : " + response);
		return response;
	}

	public Response userRegistration(User user) {
		Response response = new Response();
		String query ="insert into user values (?,?,?,?,?,?,?)";
		
		try {
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,user.getEmailId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getDatOfRegistration()));
			pstmt.setString(4, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getDatOfRegistration()));
			pstmt.setBoolean(5,true);
			pstmt.setString(6,UserRoles.NEW_USER);
			pstmt.setInt(7,0);
			System.err.println("Prepared Statement for Create User after bind variables set:\n\t" + pstmt.toString());
			int userCreationResult = pstmt.executeUpdate();
			if(userCreationResult != 0) {
				response.setStatus("Success");
				response.setStatusMessage("Registration success");
				response.setResponseObject(user);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Please verify details");
				response.setResponseObject(user);
			}
		} catch (SQLException e) {
			response.setStatus("Error");
			response.setStatusMessage("Internal server error");
			response.setResponseObject(user);
			e.printStackTrace();
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
				user.setRole(rs.getString(6));
				user.setUserActive(rs.getBoolean(5));
				user.setTeam(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public Response findAllUsers() {
		Response response = new Response();
		PreparedStatement pstmt = null;
		Connection connection = null;
		List<UserProfile> users = null;
		ResultSet rs = null;
		String query = "select * from user_profile where is_user_profile_active = ?";
		connection = DBUtil.getconnection();
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setBoolean(1,true);
			System.err.println("Prepared Statement for findAllUsers after bind variables set:\n\t" + pstmt.toString());
			rs=pstmt.executeQuery();
			users = parseUserIds(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		;
		if(users.size() ==0) {
			response.setStatus("noDataFound");
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

	public HashMap<String, UserProfile> getUserProfilesMap() {
		HashMap<String, UserProfile> userProfilesMap = new HashMap<String, UserProfile>();
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String query = "select * from user_profile where is_user_profile_active = ?";
		connection = DBUtil.getconnection();
		try {
			pstmt = connection.prepareStatement(query);
			pstmt.setBoolean(1,true);
			System.err.println("Prepared Statement for findAllUsers after bind variables set:\n\t" + pstmt.toString());
			rs=pstmt.executeQuery();
	
			try {
				while(null != rs && rs.next()) {
					
					UserProfile profile = new UserProfile();
					profile.setEmailId(rs.getString(1));
					profile.setFirstName(rs.getString(2));
					profile.setLastName(rs.getString(3));
					profile.setGender(rs.getString(4));
					profile.setMobile(rs.getString(5));
					profile.setSecretQuestion1(rs.getString(6));
					profile.setSecretQuestionAnswer1(rs.getString(7));
					profile.setSecretQuestion2(rs.getString(8));
					profile.setSecretQuestionAnswer2(rs.getString(9));
					profile.setIsUserProfileActive(rs.getBoolean(10));
					userProfilesMap.put(profile.getEmailId(), profile);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("getUserProfilesMap Response : " + userProfilesMap);
		return userProfilesMap;
	}
	
	private List<UserProfile> parseUserIds(ResultSet rs) {
		List<UserProfile> users = new ArrayList<UserProfile>();
		try {
			while(null != rs && rs.next()) {
				UserProfile profile = new UserProfile();
				profile.setEmailId(rs.getString(1));
				profile.setFirstName(rs.getString(2));
				profile.setLastName(rs.getString(3));
				profile.setGender(rs.getString(4));
				profile.setMobile(rs.getString(5));
				profile.setSecretQuestion1(rs.getString(6));
				profile.setSecretQuestionAnswer1(rs.getString(7));
				profile.setSecretQuestion2(rs.getString(8));
				profile.setSecretQuestionAnswer2(rs.getString(9));
				profile.setIsUserProfileActive(rs.getBoolean(10));
				users.add(profile);
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

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		System.out.println(dao.findAllUsers());
	}

	public Response updateUserRole(User user) {
		Response response = new Response();
		String query ="update user set role = ? where email_id = ?";
		
		try {
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,user.getRole());
			pstmt.setString(2, user.getEmailId());

			System.err.println("Prepared Statement for Update User Role after bind variables set:\n\t" + pstmt.toString());
			int userCreationResult = pstmt.executeUpdate();
			if(userCreationResult != 0) {
				response.setStatus("Success");
				response.setStatusMessage("Role Update success");
				response.setResponseObject(user);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Role Update Fail");
				response.setResponseObject(user);
			}
		} catch (SQLException e) {
			response.setStatus("Error");
			response.setStatusMessage("Internal server error");
			response.setResponseObject(user);
			e.printStackTrace();
		}
		
		System.out.println("User Registration Response : " + response);
		return response;
	}

	public Response disableUser(String userId) {
		Response response = new Response();
		String query ="update user set is_user_active = ? where email_id = ?";
		
		try {
			connection = DBUtil.getconnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setBoolean(1, false);
			pstmt.setString(2,userId);

			System.err.println("Prepared Statement for Update User active after bind variables set:\n\t" + pstmt.toString());
			int userCreationResult = pstmt.executeUpdate();
			if(userCreationResult != 0) {
				
				query ="update user_profile set is_user_profile_active = ? where email_id = ?";
				pstmt = connection.prepareStatement(query);
				pstmt.setBoolean(1, false);
				pstmt.setString(2,userId);

				System.err.println("Prepared Statement for Update User active after bind variables set:\n\t" + pstmt.toString());
				
				response.setStatus("Success");
				response.setStatusMessage("Role Update success");
				response.setResponseObject(userId);
			}else {
				response.setStatus("Fail");
				response.setStatusMessage("Role Update Fail");
				response.setResponseObject(userId);
			}
		} catch (SQLException e) {
			response.setStatus("Error");
			response.setStatusMessage("Internal server error");
			response.setResponseObject(userId);
			e.printStackTrace();
		}
		
		System.out.println("User Registration Response : " + response);
		return response;
	}
}
