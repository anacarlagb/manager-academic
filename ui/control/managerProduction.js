var production = {};
var advisor;
var student;
var advisors = [];
var student = [];
var collaborators = [];


function addproduction(){
	
	var productionTextHtml =  "<br>Id:  <input  id=\"insertedId\" />";
	productionTextHtml += "<br>Título:  <input  id=\"insertedTitle\" />" ;
	productionTextHtml += "<br>Ano:  <input  id=\"insertedYear\" />" ;
	
	productionTextHtml += "<br><button onclick=\"generateProduction(insertedId.value," +
			           "insertedTitle.value, insertedYear.value)\">Próximo</button>"; 
	
	document.getElementById("demo").innerHTML =  productionTextHtml;
}

function generateProduction(id, title, year){
	
	production.id = id;
	production.title = title;
	production.year = year;
	
	var projectsHTML = "<br>Deseja selecionar projeto:";
	 
	projectsHTML += "<br> <input type=\"radio\" name=\"sim\" onclick=\"getProjectToProduction()\">Sim<br>" +
	                "<br> <input type=\"radio\" name=\"nao\" onclick=\"getProductionType()\">Não<br>";
	
    document.getElementById("demo").innerHTML = projectsHTML;
	
	
}

function getProjectToProduction(){
	var projectsText = getProjects();
	
	var projectsHTML = "<br>Selecione o projeto:" + projectsText 
	+ "<button onclick=\"saveProjectToProduction()\">Salvar Projeto</button>";
    document.getElementById("demo").innerHTML = projectsHTML;
   
}

function saveProjectToProduction(){
	
	var projectIndex = document.getElementById("projects").selectedIndex;
    var projectList = document.getElementById("projects").options;
    
    var projectId = projectList[projectIndex].value;
    production.idResearchProject = projectId;
    getProductionType();
 
}

function getProductionType(){
   var productionHTML = "<br>Selecione o tipo de Produção Acadêmica:";
	
	productionHTML += "<br> <input type=\"radio\" name=\"publication\" onclick=\"getPublication()\">Publicação<br>" +
	                "<br> <input type=\"radio\" name=\"orientation\" onclick=\"getOrientation()\">Orientação<br>";
	
    document.getElementById("demo").innerHTML = productionHTML;
}





function getPublication(){
	
	production.academicProductionType = "PUBLICATION";
	var productionHTML = "<br>Selecione o orientador:</br>";
	
	var collaboratorsJson = getCollaboratorsByType("PROFESSOR");
	advisors = collaboratorsJson.collaborators;
	
	for(var j in collaboratorsJson.collaborators){
		
		productionHTML  += "<br><input class=\"messageCheckbox\" type=\"checkbox\" value=\"" 
						 + collaboratorsJson.collaborators[j].id + "\"" 
						 +  "name=\"collaborators\">" + collaboratorsJson.collaborators[j].name;
		
	}
	productionHTML += "<br><input type=\"button\" onclick=\"getAdvisorByPublication()\" value=\"Salvar\">";
	document.getElementById("demo").innerHTML = productionHTML;

}





function getAdvisorByPublication(){
	var collaborators = document.getElementsByName("collaborators");
    var len = collaborators.length;
    
    var advisorId;
    for(var i=0; i<len; i++){
    	if(collaborators[i].checked){
    		advisorId = collaborators[i].value; 
    	}
    }
    
    var advisor;
	for(var i in advisors){		
	   if(advisors[i].id == advisorId){    		   
		   advisor = advisors[i]; 
	   }  
	}
	
	
	production.advisor = advisor;
	getAuthorsByPublication();
	
}

function getAuthorsByPublication(){
	var productionHtml = "<br>Selecione os colaboradores da Publicação: </br><b>";
	var collaboratorsJson = getCollaboratorsByType("");
	collaborators = collaboratorsJson.collaborators;
	
	for(var j in collaboratorsJson.collaborators){

		productionHtml += "<input class=\"messageCheckbox\" type=\"checkbox\" value=\"" + collaboratorsJson.collaborators[j].id + "\"" 
						+  "name=\"collaborators\">" + collaboratorsJson.collaborators[j].name + "<br>";
	}
	productionHtml += "<input type=\"button\" onclick=\"saveAuthors()\" value=\"Salvar Publicação\">";
	document.getElementById("demo").innerHTML =  productionHtml;
} 

function saveAuthors(){
	var collaborators = document.getElementsByName("collaborators");
    var len = collaborators.length;
    
    var authors = [];
    for (var i=0; i<len; i++) {
    	
        if (collaborators[i].checked) {
        	
            authors.push(collaborators[i].value);
            
        }
    }
    
    var productionAuthors = [];
    
	for(var j in authors){
		for(var i in collaborators){
    	   if(collaborators[i].id == authors[j]){    		   
    		   productionAuthors.push(collaborators[i]); 
    	   }  
		}
	}
	
	production.authors = productionAuthors;
	saveProduction();
	
	
}

function getOrientation(){
    production.academicProductionType = "ORIENTATION";
 
	var productionHtml = "<br>Selecione o orientador: </br><b>";
	var advisorsJson = getCollaboratorsByType("PROFESSOR");
	
	
    advisors = advisorsJson.collaborators;
	
    for (var j in advisorsJson.collaborators) {

		productionHtml += "<input class=\"messageCheckbox\" type=\"checkbox\" value=\"" + advisorsJson.collaborators[j].id + "\"" 
				       + "name=\"advisors\">" + advisorsJson.collaborators[j].name + "<br>";
	}
    productionHtml += "<input type=\"button\" onclick=\"saveAdvisorByOrientation()\" value=\"Salvar Orientador\">";
	
	document.getElementById("demo").innerHTML = productionHtml;
  
}

function getStudentsByOrientation(){
	
	var productionHtml = "<br>Selecione o aluno: </br><b>";
	var degreeJson = getCollaboratorsByType("DEGREE_STUDENT");
	var masterJson = getCollaboratorsByType("MASTER_STUDENT");
	var phdJson = getCollaboratorsByType("PHD_STUDENT");

	students = [];
	students = students.concat(degreeJson.collaborators);
	students = students.concat(masterJson.collaborators);
	students = students.concat(phdJson.collaborators);
	
	for (var j in students) {

		productionHtml += "<input class=\"messageCheckbox\" type=\"checkbox\" value=\"" + students[j].id + "\"" 
				       +  "name=\"students\">" + students[j].name + "<br>";
	}
	productionHtml += "<input type=\"button\" onclick=\"saveStudentsByOrientation()\" value=\"Salvar Aluno\">";
	
	document.getElementById("demo").innerHTML = productionHtml;
}



function saveStudentsByOrientation(){
   var studentsList = document.getElementsByName("students");
   var len = studentsList.length;
   var studentId;
    
    for(var i=0; i<len; i++){ 	
    	if(studentsList[i].checked){
    		studentId = studentsList[i].value; 	
    		
    	}
    }
    
    var student;
	for(var i in students){
	   if(students[i].id == studentId){    		   
		   student = students[i];
	   }  
	}
	
	production.student = student;
	authors = [];

	
	authors.push(production.student);
	authors.push(production.advisor);
	
	production.authors = authors;
	
	saveProduction();
}

function saveAdvisorByOrientation(){
    var advisorsList = document.getElementsByName("advisors");
    var len = advisorsList.length;
    var advisorId;
    
    for(var i=0; i<len; i++){
    	if(advisorsList[i].checked){
    		advisorId = advisorsList[i].value; 
    	}
    }
    
    var advisor;
    
	for(var i in advisors){
			
	   if(advisors[i].id == advisorId){    		   
		   advisor = advisors[i]; 
	   }  
	}

	production.advisor = advisor;
	getStudentsByOrientation();
}





function saveProduction(){
	var productionJson = JSON.stringify(production);
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/app/user/lkfamks/production", true); 
	xmlHttp.setRequestHeader('Content-type', 'application/json');
	xmlHttp.send(productionJson);
	
	xmlHttp.onload = function () {
		
		 if(xmlHttp.status == 200){
			 alert("Produção Acadêmica cadastrado com sucesso!!");
		 }
		 
	};
}