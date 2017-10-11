function login(email,password){
	
	loginrequest(email, password);
	
}


function loginrequest(email, password){
	
	//request
   
	if(email == "admin" && password == "admin"){
	   window.location.href = "services/manager.html";
	}
}

