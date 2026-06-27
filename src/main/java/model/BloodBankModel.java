package model;

public class BloodBankModel {
	
	private String bloodGroupInsert;
	private int quantityInsert;
	private String hospitalId;
    private String hospitalName; 
    private int bloodbankid;

	
	
	 public BloodBankModel() {} 
	    
	    public BloodBankModel(String BloodGroupInsert, int QuantityInsert, String hospitalId) {
	        this.hospitalId = hospitalId;
	        this.bloodGroupInsert = BloodGroupInsert;
	        this.quantityInsert = QuantityInsert;
	    }

	   
		public String getBloodGroupInsert() { return bloodGroupInsert; }
	    public int getQuantityInsert() { return quantityInsert; }
	    public String getHospitalId() { return hospitalId; }

		public void setHospitalId(String hospitalId) {
			this.hospitalId = hospitalId;
		}

		public String getHospitalName() {
			return hospitalName;
		}

		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}

	public void setBloodGroupInsert(String BloodGroupInsert) {
		this.bloodGroupInsert = BloodGroupInsert;
	}
	
	public void setQuantityInsert(int QuantityInsert) {
		this.quantityInsert = QuantityInsert;
	}

	public int getBloodbankid() {
		return bloodbankid;
	}

	public void setBloodbankid(int bloodbankid) {
		this.bloodbankid = bloodbankid;
	}

	
}