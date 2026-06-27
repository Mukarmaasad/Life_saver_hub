setPermissions();

function setPermissions(){
	let userModel = localStorage.getItem("userModel");
	let parsedModel = JSON.parse(userModel);
	if(!parsedModel.adminId){
		 document.getElementById("hospitaluser-tab").style.display = "none";
		 document.getElementById("hospitaluser").style.display = "none";
		  document.getElementById("Bloodbank").style.display = "none";
		 document.getElementById("Bloodbank-tab").style.display = "none";
		  document.getElementById("Hospitals-tab").style.display = "none";
		 document.getElementById("Hospitals").style.display = "none";

		 
	}else if (parsedModel.adminId == 2029) {
     
    }else {
        document.getElementById("hospitaluser-tab").style.display = "none";
        document.getElementById("hospitaluser").style.display = "none";
      
    }
	
	
}

