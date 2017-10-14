var collaborator = {};
var collaboratorsReportByType = [];
var collaboratorsText  = "";
var collaboratorId;


function addcollaborator(){
	
	var collaboratorTextHtml =  "<br>Id:  <input  id=\"insertedId\" />";
	collaboratorTextHtml += "<br>Nome:  <input  id=\"insertedName\" />" ;
	collaboratorTextHtml += "<br>Email:  <input  id=\"insertedEmail\" />" ;
	collaboratorTextHtml += "<br>Data Inicial:  <input  id=\"insertedStartDate\" />" ;
	collaboratorTextHtml += "<br>Selecione o tipo do colaborador:"
	collaboratorTextHtml += "<br> <input type=\"radio\" name=\"degree\" onclick=\"generateDegreeStudent(insertedId.value, insertedEmail.value, insertedName.value, insertedStartDate.value)\"> Estudante de Graduação<br>" +
							"<br> <input type=\"radio\" name=\"master\" onclick=\"generateMasterStudent(insertedId.value, insertedEmail.value, insertedName.value, insertedStartDate.value)\"> Estudante de Mestrado<br>" +
							"<br> <input type=\"radio\" name=\"phd\"    onclick=\"generatePHDStudent(insertedId.value, insertedEmail.value, insertedName.value, insertedStartDate.value)\"> Estudante de Doutorado<br>" +
							"<br> <input type=\"radio\" name=\"professor\" onclick=\"generateProfessor(insertedId.value, insertedEmail.value, insertedName.value, insertedStartDate.value)\"> Professor<br>" +
							"<br> <input type=\"radio\" name=\"researcher\" onclick=\"generateResearcher(insertedId.value, insertedEmail.value, insertedName.value, insertedStartDate.value)\"> Pesquisador<br>";
	
	document.getElementById("demo").innerHTML =  collaboratorTextHtml;
	
	
	
	
}

function getCollaborators(type){
    
	collaboratorsReportByType = getCollaboratorsByType(type);
	
	collaboratorsText += "<select id=\"collaborators\">";

	for(var j in collaboratorsReportByType.collaborators){
		collaboratorsText +="<option value=" + collaboratorsReportByType.collaborators[j].id + ">"+  collaboratorsReportByType.collaborators[j].name + "</option>";
		
	}
	
	collaboratorsText += "</select>";
	return collaboratorsText;
	
}

function getCollaboratorsByType(type){
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborators?type=" + type, false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	
	var collaborators = JSON.parse(text);
	return collaborators;
}

function getCollaboratorId(){
	
	var collaboratorIndex = document.getElementById("collaborators").selectedIndex;
    var collaborators = document.getElementById("collaborators").options;
   
    collaboratorId = collaborators[collaboratorIndex].value;
    alert(collaboratorId);
}