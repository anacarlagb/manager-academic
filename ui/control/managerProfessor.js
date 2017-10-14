function generateProfessor(id, email, name, startDate){
	collaborator.id = id;
	collaborator.email = email;
	collaborator.name = name;
	collaborator.startDate = new Date(startDate);
	collaborator.type = "PROFESSOR";
	collaborator.collaboratorType = "PROFESSOR";
	
	collaborator.productions = [];
	collaborator.projects = [];
	var collaboratorJson = JSON.stringify(collaborator);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/collaborator", true); // false for synchronous request
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(collaboratorJson);
	

	xmlHttp.onload = function () {
		
		 if(xmlHttp.status == 200){
			 alert("Professor cadastrado com sucesso!!");
		 }
		 
	};
}