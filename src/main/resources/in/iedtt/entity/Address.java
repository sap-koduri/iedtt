package in.iedtt.entity;

import java.io.Serializable;

public class Address implements Serializable  {
	private static final long serialVersionUID = 1L;

	private String addressId;
	private String city;
	private String country;
	private String doorNumber;
	private String locality;
	private String pincode;
	private String state;
	private String street;
	private String town;
	
	private boolean isNew = false;
	
	public Address() {
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public String getAddressId() {
		return this.addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDoorNumber() {
		return this.doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}


}