function reportacademic(){
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/report", false); // false for synchronous request
	xmlHttp.send(null);
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

function formatDate(inputStr) {
    var timestamp = parseInt(inputStr, 10);
    var date = new Date(timestamp);
    return date.getDate() + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear();
}

function reportbycollaborator(){
	
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborator/" + "100" + "/report", false); // false for synchronous request
	xmlHttp.send(null);
	var text = xmlHttp.responseText;
	var collaboratorReportJson = JSON.parse(text);
	
	
	var reportCollaborator = "<b>Relatório Por Colaborador</b> <ul>" +
    "<li> Nome: " + collaboratorReportJson.name + "</li> " +
	"<li> Email: " + collaboratorReportJson.email + "</li> " +
	"<li> Projetos de Pesquisa em Progresso: </li>" ;
	var projetsInProgress = "";
	var projectsInProgress = collaboratorReportJson.projectsInProgress;
	
	for(var i  in projectsInProgress){
		
		startDate = formatDate(projectsInProgress[i].startDate);
		endDate = formatDate(projectsInProgress[i].endDate);
		projetsInProgress += "<br>Título:" + projectsInProgress[i].title +
							 "<br>Objetivo:" + projectsInProgress[i].goal +
						     "<br>Descrição:" + projectsInProgress[i].description +
							 "<br>Instituição Financiadora:" + projectsInProgress[i].fundingInstitutionName +
							 "<br>Valor Financiado:" + projectsInProgress[i].fundingValue + 
							 "<br> Data Inicial: " + startDate +
							 "<br> Data Final: " + endDate;
	}
	
	reportCollaborator += projetsInProgress;
	
	
//	reportCollaborator+= "<li> Projetos de Pesquisa em Elaboração: " + collaboratorReportJson.projectsInElaboration + "</li> ";
//	
//	reportCollaborator+= "<li> Projetos de Pesquisa Concluídos: " + collaboratorReportJson.projectsConcluded + "</li> "
//	 
	 document.getElementById("demo").innerHTML = reportCollaborator;
}


function reportbyproduction(){
	
}


function addcollaborator(){
	
}


function addproject(){
	
}


function addproduction(){
	
}






















