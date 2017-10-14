function generateResearcher(id, email, name, startDate){
	
	
	collaborator.id = id;
	collaborator.email = email;
	collaborator.name = name;
	collaborator.startDate = new Date(startDate);
	collaborator.type = "RESEARCHER";
	collaborator.collaboratorType = "RESEARCHER";

	collaborator.productions = [];
	collaborator.projects = [];
	var collaboratorJson = JSON.stringify(collaborator);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/collaborator", false); // false for synchronous request
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(collaboratorJson);
	
	xmlHttp.onload = function () {
		
		 if(xmlHttp.status == 200){
			 alert("Pesquisador cadastrado com sucesso!!");
		 }
		 
	};
	
}
