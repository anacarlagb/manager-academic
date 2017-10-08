function login(email,password){
	loginrequest(email, password);
}


function loginrequest(email, password){
	
	//request
   
	if(email == "admin" && password == "admin"){
		 
		/*window.location.href = "services/manager.html";*/
		

		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/report", false); // false for synchronous request
		xmlHttp.send(null);
		var text = xmlHttp.responseText;
		var jsonReport = JSON.parse(text);
//		jsonReport.
		alert(jsonReport.totalCollaborators);
		
	}
}