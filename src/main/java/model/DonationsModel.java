package model;



public class DonationsModel {

	private int Unitsofblood;
	private String hospitalid;
    private String hospitalName;
    private String firstname;
    private String lastname;
    private String bloodgroup;
    private String donationDate;

    private int userid;
  

	public DonationsModel() {} 
    
    public DonationsModel(String hospitalid,String hospitalName, int Unitsofblood ,int userid, String bloodgroup, String donationDate) {
        this.hospitalid = hospitalid;
        this.hospitalName = hospitalName;
        this.Unitsofblood = Unitsofblood;
        this.bloodgroup = bloodgroup;
        this.donationDate = donationDate;

        this.userid  = userid;
    }
    
    
    
    
	public int getUnitsofblood() {
		return Unitsofblood;
	}
	public void setUnitsofblood(int unitsofblood) {
		Unitsofblood = unitsofblood;
	}
	public String getHospitalid() {
		return hospitalid;
	}
	public void setHospitalid(String hospitalid) {
		this.hospitalid = hospitalid;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	  
    public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	
	
}
