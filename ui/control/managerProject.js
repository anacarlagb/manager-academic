var project = {};
var collaborators = [];
var authors = [];
function addproject(){
	
	
	var projectTextHtml =  "<br>Id:  <input  id=\"insertedId\" />";
	projectTextHtml += "<br>Título:  <input  id=\"insertedTitle\" />" ;
	projectTextHtml += "<br>Objetivo:  <input  id=\"insertedGoal\" />" ;
	projectTextHtml += "<br>Descrição:  <input  id=\"insertedDescription\" />" ;
	projectTextHtml += "<br>Data Inicial:  <input  id=\"insertedStartDate\" />" ;
	projectTextHtml += "<br>Data Final:  <input  id=\"insertedEndDate\" />" ;
	projectTextHtml += "<br>Instituição Financiadora:  <input  id=\"insertedFundingInstitution\" />" ;
	projectTextHtml += "<br>Valor financiado:  <input  id=\"insertedFundingInstitutionValue\" />" ;
	
	projectTextHtml += "<br><button onclick=\"generateProject(insertedId.value," +
			           "insertedTitle.value, insertedGoal.value," +
	                   "insertedDescription.value,  insertedStartDate.value, " +
					   "insertedEndDate.value,insertedFundingInstitution.value," +
					   "insertedFundingInstitutionValue.value)\">Próximo</button>"; 
	
	document.getElementById("demo").innerHTML =  projectTextHtml;
	
}


function getProjects(){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8080/app/user/lkfamks/projects", false); // false for synchronous request
	xmlHttp.send();
	var text = xmlHttp.responseText;
	
	var projectsJson = JSON.parse(text);
    var projectsText = "";
	projectsText += "<select id=\"projects\">";
    
	for(var j in projectsJson.projects){
		
		projectsText +="<option value=" + projectsJson.projects[j].id + ">"+  projectsJson.projects[j].title + "</option>";
		
	}
	
	projectsText += "</select>";
	return projectsText;

}

function generateProject(id, title,  goal, description,
        startDate, endDate, fundingInstitution, fundingInstitutionValue){
		
	project.id = id;
	project.title = title;
	project.goal = goal;
	project.description = description;
	project.startDate = new Date(startDate);
	project.endDate = new Date(endDate);
	project.fundingInstitutionName = fundingInstitution;
	project.fundingValue = fundingInstitutionValue;
	project.productions = [];
	var projectTextHtml = "<br>Selecione os colaboradores do projeto: </br><b>";
	var collaboratorsJson = getCollaboratorsByType("");
	collaborators = collaboratorsJson.collaborators;
	
	for(var j in collaboratorsJson.collaborators){

		projectTextHtml += "<input class=\"messageCheckbox\" type=\"checkbox\" value=\"" + collaboratorsJson.collaborators[j].id + "\"" 
						+  "name=\"collaborators\">" + collaboratorsJson.collaborators[j].name + "<br>";
	}
	projectTextHtml += "<input type=\"button\" onclick=\"getAuthors()\" value=\"Salvar\">";
	document.getElementById("demo").innerHTML =  projectTextHtml;
}

function getAuthors(){
	
	var collaborators = document.getElementsByName("collaborators");
    var len = collaborators.length;
    
    authors = [];
    for (var i=0; i<len; i++) {
    	
        if (collaborators[i].checked) {
            authors.push(collaborators[i].value);
            
        }
    }
    
    var projectAuthors = [];
    
	for(var j in authors){
		for(var i in collaborators){
    	   if(collaborators[i].id == authors[j]){    		   
    		   projectAuthors.push(collaborators[i]); 
    	   }  
		}
	}
	
	project.collaborators = projectAuthors;
	saveProject();
	
}


function saveProject(){
	
	var projectJson = JSON.stringify(project);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/project", true); 
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(projectJson);
	
	
	xmlHttp.onload = function () {
		
		 if(xmlHttp.status == 200){
			 alert("Projeto cadastrado com sucesso!!");
		 }
		 
	};
}
