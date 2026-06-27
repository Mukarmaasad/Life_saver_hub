package model;

/**
 * 
 */
public class registrationModel {
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	private String phoneNo;
	private String city;
	private String address;
	private String bloodGroup;
	private String gender;
	private String email;
	private String donationdate;
	private Integer id;
	private String status;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public registrationModel() {}
	
		public registrationModel(String dateOfBirth,String phoneNo, String city,String address,String bloodGroup,String gender,String firstname, Integer id, String donationdate) {
		this.dateOfBirth = dateOfBirth;
        this.phoneNo = phoneNo;
        this.city = city;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
        this.firstname = firstname;
        this.donationdate = donationdate;

        this.id = id;
		}
	
	
	public String getDateOfBirth() { return dateOfBirth;}
	public String getPhoneNo() { return phoneNo; }
	public String getCity() { return city; }
	public String getAddress() { return address; }
	public String getBloodGroup() { return bloodGroup; }
	public String getEmail() { return email; }
	
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDonationdate() {
		return donationdate;
	}

	public void setDonationdate(String donationdate) {
		this.donationdate = donationdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
		
}
