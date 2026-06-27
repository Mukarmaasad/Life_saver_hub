package model;

public class BloodBankofhospitalModel {

	    private String bloodType;
	    private int quantity;
		private int hospitalId;
	    private String hospitalName;
	    private int bloodbankid;// New field
; 
	    
	    
public BloodBankofhospitalModel() {} 
	    
	    public BloodBankofhospitalModel(String bloodType, int quantity, int hospitalId, int bloodbankid) {
	        this.hospitalId = hospitalId;
	        this.bloodType = bloodType;
	        this.quantity = quantity;
	        this.bloodbankid = bloodbankid;

	    }

	    
	    
		public int getHospitalId() {
			return hospitalId;
		}
		public void setHospitalId(int hospitalId) {
			this.hospitalId = hospitalId;
		}
		public String getHospitalName() {
			return hospitalName;
		}
		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}
		public String getBloodType() {
			return bloodType;
		}
		public void setBloodType(String bloodType) {
			this.bloodType = bloodType;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getBloodbankid() {
			return bloodbankid;
		}

		public void setBloodbankid(int bloodbankid) {
			this.bloodbankid = bloodbankid;
		}

}
