package model;

public class AddHospitalsModel {
	
	    private Integer hospitalid;

	    private String hospitalName;
	    private String contactno;
	    private String Daddress;

	    
	   public AddHospitalsModel() {} 
	    
	    public AddHospitalsModel(String hospitalName, String address, String contactno, Integer hospitalid) {
	     
	        this.hospitalName = hospitalName;
	        this.Daddress = address;
	        this.contactno = contactno;
	        this.hospitalid = hospitalid;
	    }

	    public String getHospitalName() { return hospitalName; }
	    public String getAddress() { return Daddress; }
	    public String getContactNo() { return contactno; }

	    
	    
		public Integer getHospitalid() {
			return hospitalid;
		}

		public void setHospitalid(Integer hospitalid) {
			this.hospitalid = hospitalid;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}


		public void setAddress(String address) {
			this.Daddress = address;
		}


		public void setContactNo(String contactno) {
			this.contactno = contactno;
		}
}



