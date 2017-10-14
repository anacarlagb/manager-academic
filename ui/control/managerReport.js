function reportcollaborator() {
	var collaboratorsText = getCollaborators("");

	var collaboratorsHTML = "<br>Selecione o colaborador:" + collaboratorsText
			+ "<button onclick=\"reportbycollaborator()\">Gerar Relatório</button>";

	document.getElementById("demo").innerHTML = collaboratorsHTML;
}

function reportproject(){
	
	var projectsText = getProjects();

	var projectsHTML = "<br>Selecione o projeto:" + projectsText
	+ "<button onclick=\"reportbyproject()\">Gerar Relatório</button>";

    document.getElementById("demo").innerHTML = projectsHTML;
	
}

function reportacademic() {

	var reportAcademic = "<b>Relatório Acadêmico</b> <ul>";
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/report", false); 
	xmlHttp.send();
	var text = xmlHttp.responseText;
	var academicReportJson = JSON.parse(text);

	reportAcademic += "<li> Total de Colaboradores: "
			+ academicReportJson.totalCollaborators + "</li> "
			+ "<li>  Total de Projetos de Pesquisa em Andamento: "
			+ academicReportJson.totalProjectsInProgress + "</li> "
			+ "<li>  Total de Projetos de Pesquisa em Elaboração: "
			+ academicReportJson.totalProjectsInElaboration + "</li> "
			+ "<li>  Total de Projetos de Pesquisa Concluídos: "
			+ academicReportJson.totalProjectsConcluded + "</li> "
			+ "<li>  Total de Projetos de Pesquisa: "
			+ academicReportJson.totalProjects + "</li> "
			+ "<li>  Total de Publicações: "
			+ academicReportJson.totalPublicationProduction + "</li> "
			+ "<li>  Total de Orientações: "
			+ academicReportJson.totalOrientationProduction + "</ul>";

	document.getElementById("demo").innerHTML = reportAcademic;

}

function reportbycollaborator() {

	
	var collaboratorIndex = document.getElementById("collaborators").selectedIndex;
    var collaborators = document.getElementById("collaborators").options;
   
    collaboratorId = collaborators[collaboratorIndex].value;
    
    
	var reportCollaborator = "<b>Relatório Por Colaborador</b> <ul>";
	
	if (collaboratorId != null && collaboratorId != "") {

		collaboratorId =  "\"" + collaboratorId +"\"";
		
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborator/" + collaboratorId + "/report", false); 
		xmlHttp.setRequestHeader('Content-type', 'application/json');
		xmlHttp.send();
		var text = xmlHttp.responseText;
	    

		var collaboratorReportJson = JSON.parse(text);

		reportCollaborator += "<li> Nome: " + collaboratorReportJson.name   + "</li> " +
		                      "<li> Email: " + collaboratorReportJson.email + "</li> ";

		
		
		xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/collaborator/" + collaboratorId + "/productions", false);
		xmlHttp.send();
		text = xmlHttp.responseText;
		var productionsJson = JSON.parse(text);
		var productionsText = "<ol>";
		
		for (var i in productionsJson.productions) {
			var typeProduction = "";
			if(productionsJson.productions[i].type == "PUBLICATION"){
				typeProduction = "Publicação";
			}
			else{
				typeProduction = "Orientação";
			}
			
			productionsText += "<li><b>Publicação :" + productionsJson.productions[i].title + "</b></li>";
			productionsText += "Ano:" + productionsJson.productions[i].year
					    +  "<br>Tipo de Produção:" + typeProduction
					    +  "<br>Autores:" + productionsJson.productions[i].authors;
		}
		productionsText += "</ol>";
		
		reportCollaborator += productionsText;
		reportCollaborator += "<li> Projetos de Pesquisa em Elaboração: "
				             + collaboratorReportJson.projectsInElaboration.length + "</li> ";
		
		var projetsInElaborationText = "";
		var projectsInElaboration = collaboratorReportJson.projectsInElaboration;

		for ( var i in projectsInElaboration) {

			startDate = formatDate(projectsInElaboration[i].startDate);
			endDate = formatDate(projectsInElaboration[i].endDate);
			
			projetsInElaborationText += "<br><b>Título:" + projectsInElaboration[i].title + "</b>"
					+ "<br>Objetivo:" + projectsInElaboration[i].goal
					+ "<br>Descrição:" + projectsInElaboration[i].description
					+ "<br>Instituição Financiadora:" + projectsInElaboration[i].fundingInstitutionName
					+ "<br>Valor Financiado:" + projectsInElaboration[i].fundingValue
					+ "<br> Data Inicial: " + startDate 
					+ "<br> Data Final: " + endDate;

		}
		reportCollaborator += projetsInElaborationText;

		reportCollaborator += "<li> Projetos de Pesquisa em Progresso: " + collaboratorReportJson.projectsInProgress.length + "</li> ";
		var projetsInProgressText = "";
		var projectsInProgress = collaboratorReportJson.projectsInProgress;

		for ( var i in projectsInProgress) {

			startDate = formatDate(projectsInProgress[i].startDate);
			endDate = formatDate(projectsInProgress[i].endDate);
			projetsInProgressText += "<br><b>Título:" + projectsInProgress[i].title + "</b>" 
			        + "<br>Objetivo:"  + projectsInProgress[i].goal 
			        + "<br>Descrição:" + projectsInProgress[i].description
					+ "<br>Instituição Financiadora:" + projectsInProgress[i].fundingInstitutionName
					+ "<br>Valor Financiado:" + projectsInProgress[i].fundingValue
					+ "<br> Data Inicial: " + startDate 
					+ "<br> Data Final: " + endDate;
		}

		reportCollaborator += projetsInProgressText;

		reportCollaborator += "<li> Projetos de Pesquisa Concluídos:" + collaboratorReportJson.projectsConcluded.length + "</li> ";
		var projetsConcludedText = "";
		var projectsConcluded = collaboratorReportJson.projectsConcluded;

		for ( var i in projectsConcluded) {

			startDate = formatDate(projectsConcluded[i].startDate);
			endDate = formatDate(projectsConcluded[i].endDate);
			projetsConcludedText += "<br><b>Título:" + projectsConcluded[i].title + "</b>"
					+ "<br>Objetivo:" + projectsConcluded[i].goal
					+ "<br>Descrição:" + projectsConcluded[i].description
					+ "<br>Instituição Financiadora:" + projectsConcluded[i].fundingInstitutionName
					+ "<br>Valor Financiado:" + projectsConcluded[i].fundingValue 
					+ "<br> Data Inicial: " + startDate 
					+ "<br> Data Final: " + endDate;

			
			var projectId = "\"" + projectsConcluded[i].id + "\"";
			xmlHttp = new XMLHttpRequest();
			xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/project/" + projectId + "/productions", false);
			xmlHttp.send();
			text = xmlHttp.responseText;
			var productionsJson = JSON.parse(text);
			projetsConcludedText += "<ol>";
			
			for (var i in productionsJson.productions) {
				var typeProduction = "";
				if(productionsJson.productions[i].type == "PUBLICATION"){
					typeProduction = "Publicação";
				}
				else{
					typeProduction = "Orientação";
				}
				
				projetsConcludedText += "<li><b>Publicação :" + productionsJson.productions[i].title + "</b></li>";
				projetsConcludedText += "Ano:" + productionsJson.productions[i].year
						    +  "<br>Tipo de Produção:" + typeProduction
						    +  "<br>Autores:" + productionsJson.productions[i].authors;
			}
			projetsConcludedText += "</ol>";
		}
		reportCollaborator += projetsConcludedText;
		document.getElementById("demo").innerHTML = reportCollaborator;
	}
}

function reportbyproject() {
	
	var projectIndex = document.getElementById("projects").selectedIndex;
    var projects = document.getElementById("projects").options;
   
    var projectId = projects[projectIndex].value;
    if (projectId != null && projectId != "") {

		projectId = "\"" + projectId + "\"";

		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/project/" + projectId + "/report", false);
		xmlHttp.send();
		var text = xmlHttp.responseText;
		
		var projectReportJson = JSON.parse(text);
		var startDate = formatDate(projectReportJson.startDate);
		var endDate = formatDate(projectReportJson.endDate);

		var projectText = "<ul><b>Relatório Por Projeto</b> <ul>";
		projectText += "<br><b>Título:" + projectReportJson.title + "</b>"
				+ "<br>Objetivo:" + projectReportJson.goal
				+ "<br>Descrição:" + projectReportJson.description
				+ "<br>Instituição Financiadora:" + projectReportJson.fundingInstitutionName
				+ "<br>Valor Financiado:" + projectReportJson.fundingValue
				+ "<br> Data Inicial: " + startDate 
				+ "<br> Data Final: " + endDate;

		
		xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/project/" + projectId + "/productions", false);
		xmlHttp.send();
		text = xmlHttp.responseText;
		var productionsJson = JSON.parse(text);
		projectText+= "<ol>";
		for (var i in productionsJson.productions) {
			var typeProduction = "";
			if(productionsJson.productions[i].type == "PUBLICATION"){
				typeProduction = "Publicação";
			}
			else{
				typeProduction = "Orientação";
			}
			
			projectText += "<li><b>Publicação :" + productionsJson.productions[i].title + "</b></li>";
			projectText += "Ano:" + productionsJson.productions[i].year
					    +  "<br>Tipo de Produção:" + typeProduction
					    +  "<br>Autores:" + productionsJson.productions[i].authors;
		}
		projectText+= "</ol>";

		document.getElementById("demo").innerHTML = projectText;
    }
}