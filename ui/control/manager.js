function formatDate(inputStr) {
    var timestamp = parseInt(inputStr, 10);
    var date = new Date(timestamp);
    return date.getDate() + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear();
}

function reportacademic(){
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/report", false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	var academicReportJson = JSON.parse(text);
	
	
	var reportAcademic = "<b>Relatório Acadêmico</b> <ul>" +
    "<li> Total de Colaboradores: " + academicReportJson.totalCollaborators + "</li> " +
	"<li>  Total de Projetos de Pesquisa em Andamento: " + academicReportJson.totalProjectsInProgress + "</li> " +
	"<li>  Total de Projetos de Pesquisa em Elaboração: " + academicReportJson.totalProjectsInElaboration + "</li> " +
	"<li>  Total de Projetos de Pesquisa Concluídos: " + academicReportJson.totalProjectsConcluded + "</li> " +
	"<li>  Total de Projetos de Pesquisa: " + academicReportJson.totalProjects + "</li> " +
	"<li>  Total de Publicações: " + academicReportJson.totalPublicationProduction + "</li> " +
	"<li>  Total de Orientações: " + academicReportJson.totalOrientationProduction + "</ul>";
	 
	 document.getElementById("demo").innerHTML = reportAcademic;
 
}



function reportbycollaborator(){
	
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborator/" + "100" + "/report", false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	
	var collaboratorReportJson = JSON.parse(text);
	
	
	var reportCollaborator = "<b>Relatório Por Colaborador</b> <ul>" +
    "<li> Nome: " + collaboratorReportJson.name + "</li> " +
	"<li> Email: " + collaboratorReportJson.email + "</li> ";
	
	reportCollaborator+= "<li> Projetos de Pesquisa em Elaboração: " + collaboratorReportJson.projectsInElaboration.length + "</li> ";
	var projetsInElaborationText = "";
	var projectsInElaboration = collaboratorReportJson.projectsInElaboration;
	
	for(var i  in projectsInElaboration){
		
		startDate = formatDate(projectsInElaboration[i].startDate);
		endDate = formatDate(projectsInElaboration[i].endDate);
		projetsInElaborationText += "<br>Título:" + projectsInElaboration[i].title +
							 "<br>Objetivo:" + projectsInElaboration[i].goal +
						     "<br>Descrição:" + projectsInElaboration[i].description +
							 "<br>Instituição Financiadora:" + projectsInElaboration[i].fundingInstitutionName +
							 "<br>Valor Financiado:" + projectsInElaboration[i].fundingValue + 
							 "<br> Data Inicial: " + startDate +
							 "<br> Data Final: " + endDate;

	}
	reportCollaborator += projetsInElaborationText;
	
	reportCollaborator+= "<li> Projetos de Pesquisa em Progresso: " + collaboratorReportJson.projectsInProgress.length + "</li> ";
	var projetsInProgressText = "";
	var projectsInProgress = collaboratorReportJson.projectsInProgress;
	
	for(var i  in projectsInProgress){
		
		startDate = formatDate(projectsInProgress[i].startDate);
		endDate = formatDate(projectsInProgress[i].endDate);
		projetsInProgressText += "<br>Título:" + projectsInProgress[i].title +
							 "<br>Objetivo:" + projectsInProgress[i].goal +
						     "<br>Descrição:" + projectsInProgress[i].description +
							 "<br>Instituição Financiadora:" + projectsInProgress[i].fundingInstitutionName +
							 "<br>Valor Financiado:" + projectsInProgress[i].fundingValue + 
							 "<br> Data Inicial: " + startDate +
							 "<br> Data Final: " + endDate;

	}
	
	reportCollaborator += projetsInProgressText;
	
	
	reportCollaborator+= "<li> Projetos de Pesquisa Concluídos:" + collaboratorReportJson.projectsConcluded.length  + "</li> ";
	var projetsConcludedText = "";
	var projectsConcluded = collaboratorReportJson.projectsConcluded;
	
	for(var i  in projectsConcluded){
		
		startDate = formatDate(projectsConcluded[i].startDate);
		endDate = formatDate(projectsConcluded[i].endDate);
		projetsConcludedText += "<br>Título:" + projectsConcluded[i].title +
							 "<br>Objetivo:" + projectsConcluded[i].goal +
						     "<br>Descrição:" + projectsConcluded[i].description +
							 "<br>Instituição Financiadora:" + projectsConcluded[i].fundingInstitutionName +
							 "<br>Valor Financiado:" + projectsConcluded[i].fundingValue + 
							 "<br> Data Inicial: " + startDate +
							 "<br> Data Final: " + endDate;
		
		var productions = projectsConcluded[i].productions;
        
		for(var j in productions){		
			projetsConcludedText += "<br>Título:" + productions[j].title +
//								"<br>Orientador:" + productions[j].advisor.name +
								"<br>Ano:" + productions[j].year +
								"<br>Tipo de Produção:" + productions[j].academicProductionType;
		}
	}
	reportCollaborator += projetsConcludedText;
	document.getElementById("demo").innerHTML = reportCollaborator;
}


function reportbyproject(){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/project/" + "30" + "/report", false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	
	var projectReportJson = JSON.parse(text);
	
    var startDate = formatDate(projectReportJson.startDate);
	var endDate = formatDate(projectReportJson.endDate);
	
	var projectText = "<ul><b>Relatório Por Projeto</b> <ul>";
	projectText += "<br><b>Título:" + projectReportJson.title + "</b>" +
							 "<br>Objetivo:" + projectReportJson.goal +
						     "<br>Descrição:" + projectReportJson.description +
							 "<br>Instituição Financiadora:" + projectReportJson.fundingInstitutionName +
							 "<br>Valor Financiado:" + projectReportJson.fundingValue + 
							 "<br> Data Inicial: " + startDate +
							 "<br> Data Final: " + endDate;
	
        
	for(var j in projectReportJson.productions){
		projectText += "<li><b>Publicação :" + projectReportJson.productions[j].title + "</b></li>";
		projectText += "Ano:" + projectReportJson.productions[j].year +
					   "<br>Tipo de Produção:" + projectReportJson.productions[j].academicProductionType;
//								"<br>Orientador:" + productions[j].advisor.name;
	}
	
	document.getElementById("demo").innerHTML =  projectText;
}


function addcollaborator(){
	
	var collaboratorTextHtml = "<br>Nome:  <input  id=\"insertedName\" />" ;
	collaboratorTextHtml += "<br>Email:  <input  id=\"insertedEmail\" />" ;
	collaboratorTextHtml += "<br>Data Inicial:  <input  id=\"insertedStartDate\" />" ;
	collaboratorTextHtml += "<br>Selecione o tipo do colaborador:"
	collaboratorTextHtml += "<br> <input type=\"radio\" name=\"degree\" onclick=\"generateDegreeStudent(insertedEmail.value, insertedEmail.value, insertedStartDate.value)\"> Estudante de Graduação<br>" +
							"<br> <input type=\"radio\" name=\"master\" onclick=\"generateMasterStudent(insertedEmail.value, insertedEmail.value, insertedStartDate.value)\"> Estudante de Mestrado<br>" +
							"<br> <input type=\"radio\" name=\"phd\"    onclick=\"generatePHDStudent(insertedEmail.value, insertedEmail.value, insertedStartDate.value)\"> Estudante de Doutorado<br>" +
							"<br> <input type=\"radio\" name=\"professor\" onclick=\"generateProfessor(insertedEmail.value, insertedEmail.value, insertedStartDate.value)\"> Professor<br>" +
							"<br> <input type=\"radio\" name=\"vehicle\" onclick=\"generateResearcher(insertedEmail.value, insertedEmail.value, insertedStartDate.value)\"> Pesquisador<br>";
	
//	collaboratorTextHtml += "<button onclick=\"generateCollaborator(insertedEmail.value)\">Enviar</button>";
//	collaboratorTextHtml += "<button onclick=\"generateCollaborator(insertedEmail.value)\">Enviar</button>";
	document.getElementById("demo").innerHTML =  collaboratorTextHtml;
	
	
	
	
}


function addproject(){
	
}


function addproduction(){
	
}

function getCollaboratorsByType(type){
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborators?type=" + type, false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	
	var collaborators = JSON.parse(text);
	
	return collaborators;
}

var collaborator = {};
var collaboratorsReportByType = [];

function generateProfessor(email, name, startDate){
	
}

function generateResearcher(email, name, startDate){
	
}


























