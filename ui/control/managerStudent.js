function saveStudent() {
    
	var advisorIndex = document.getElementById("advisors").selectedIndex;
    var advisors = document.getElementById("advisors").options;
    var advisorId = advisors[advisorIndex].value;
    
	var advisor;
	
	
	for(var j in collaboratorsReportByType.collaborators){
		if(collaboratorsReportByType.collaborators[j].id ==  advisorId){
			advisor = collaboratorsReportByType.collaborators[j];
					
		}
	}
	collaborator.advisor = advisor;
	collaborator.productions = [];
	collaborator.projects = [];
	collaborator.startDate = null;
	var collaboratorJson = JSON.stringify(collaborator);
	alert(collaboratorJson);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/collaborator", true); // false for synchronous request
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(collaboratorJson);

	
}

function generateDegreeStudent(email, name, startDate){	
	collaborator.id = "";
	collaborator.email = email;
	collaborator.name = name;
//	collaborator.startDate = startDate;
	collaborator.type = "DEGREE_STUDENT";
	collaborator.collaboratorType = "DEGREE_STUDENT"; 
	
	var degreeTextHtml = "<br>Selecione o orientador:" ;
	collaboratorsReportByType = getCollaboratorsByType("PROFESSOR");
	
	degreeTextHtml += "<select id=\"advisors\">";

	for(var j in collaboratorsReportByType.collaborators){
		degreeTextHtml +="<option value=" + collaboratorsReportByType.collaborators[j].id + ">"+  collaboratorsReportByType.collaborators[j].name + "</option>";
		
	}
	
	degreeTextHtml += "</select>";
	degreeTextHtml += "<button onclick=\"saveStudent()\">Salvar</button>";
    document.getElementById("demo").innerHTML =  degreeTextHtml;
	
}

function generateMasterStudent(email, name, startDate){
	
}

function generatePHDStudent(email, name, startDate){
	
}