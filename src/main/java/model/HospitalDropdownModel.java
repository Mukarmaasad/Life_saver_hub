package model;

public class HospitalDropdownModel {

	
    private String hospitalId;
	private String hospitalName;
	
	
	 public HospitalDropdownModel() {} 
	    
	    public HospitalDropdownModel(String hospitalName, String hospitalId) {
	     
	        this.hospitalName = hospitalName;
	        this.hospitalId = hospitalId;
	    }

	
	
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	

}
