package in.iedtt.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emailId;
	private boolean isUserActive;
	private Date lastLogin;
	private String password;
	private Date datOfRegistration;
	private String role;
	private int team;

	public User() {
	}

	public User(String emailId, boolean isUserActive, Date lastLogin, String password, Date datOfRegistration,
			String role, int team) {
		super();
		this.emailId = emailId;
		this.isUserActive = isUserActive;
		this.lastLogin = lastLogin;
		this.password = password;
		this.datOfRegistration = datOfRegistration;
		this.role = role;
		this.team = team;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isUserActive() {
		return isUserActive;
	}

	public void setUserActive(boolean isUserActive) {
		this.isUserActive = isUserActive;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDatOfRegistration() {
		return datOfRegistration;
	}

	public void setDatOfRegistration(Date datOfRegistration) {
		this.datOfRegistration = datOfRegistration;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", isUserActive=" + isUserActive + ", lastLogin=" + lastLogin
				+ ", password=" + password + ", datOfRegistration=" + datOfRegistration + ", role=" + role + ", team="
				+ team + "]";
	}

	

}