package in.iedtt.entity;

import java.io.Serializable;
public class UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emailId;
	private String firstName;
	private String gender;
	private boolean isUserProfileActive;
	private String lastName;
	private String mobile;
	private String secretQuestion1;
	private String secretQuestion2;
	private String secretQuestionAnswer1;
	private String secretQuestionAnswer2;

	public UserProfile() {
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean getIsUserProfileActive() {
		return this.isUserProfileActive;
	}

	public void setIsUserProfileActive(boolean isUserProfileActive) {
		this.isUserProfileActive = isUserProfileActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSecretQuestion1() {
		return this.secretQuestion1;
	}

	public void setSecretQuestion1(String secretQuestion1) {
		this.secretQuestion1 = secretQuestion1;
	}

	public String getSecretQuestion2() {
		return this.secretQuestion2;
	}

	public void setSecretQuestion2(String secretQuestion2) {
		this.secretQuestion2 = secretQuestion2;
	}

	public String getSecretQuestionAnswer1() {
		return this.secretQuestionAnswer1;
	}

	public void setSecretQuestionAnswer1(String secretQuestionAnswer1) {
		this.secretQuestionAnswer1 = secretQuestionAnswer1;
	}

	public String getSecretQuestionAnswer2() {
		return this.secretQuestionAnswer2;
	}

	public void setSecretQuestionAnswer2(String secretQuestionAnswer2) {
		this.secretQuestionAnswer2 = secretQuestionAnswer2;
	}

	@Override
	public String toString() {
		return "UserProfile [emailId=" + emailId + ", firstName=" + firstName + ", gender=" + gender
				+ ", isUserProfileActive=" + isUserProfileActive + ", lastName=" + lastName + ", mobile=" + mobile
				+ ", secretQuestion1=" + secretQuestion1 + ", secretQuestion2=" + secretQuestion2
				+ ", secretQuestionAnswer1=" + secretQuestionAnswer1 + ", secretQuestionAnswer2="
				+ secretQuestionAnswer2 + "]";
	}

}