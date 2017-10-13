function saveStudent() {
    
	var advisorIndex = document.getElementById("collaborators").selectedIndex;
    var advisors = document.getElementById("collaborators").options;
    var advisorId = advisors[advisorIndex].value;
    
	var advisor = null;
	for(var j in collaboratorsReportByType.collaborators){
		if(collaboratorsReportByType.collaborators[j].id ==  advisorId){
			advisor = collaboratorsReportByType.collaborators[j];
					
		}
	}
	collaborator.advisor = advisor;
	collaborator.productions = [];
	collaborator.projects = [];
	var collaboratorJson = JSON.stringify(collaborator);
	alert(collaboratorJson);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/collaborator", true); // false for synchronous request
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(collaboratorJson);

	
}



function generateDegreeStudent(id, email, name, startDate){	
	collaborator.id = id;
	collaborator.email = email;
	collaborator.name = name;
	collaborator.startDate = new Date(startDate);
	collaborator.type = "DEGREE_STUDENT";
	collaborator.collaboratorType = "DEGREE_STUDENT"; 
	
	var advisorsText = getCollaborators("PROFESSOR");
	
	var degreeTextHtml = "<br>Selecione o orientador:"  
		+ advisorsText
		+ "<button onclick=\"saveStudent()\">Salvar</button>";
	
	
    document.getElementById("demo").innerHTML =  degreeTextHtml;
	
}

function generateMasterStudent(id, email, name, startDate){
	
}

function generatePHDStudent(id, email, name, startDate){
	
}