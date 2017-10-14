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
	collaborator.id = id;
	collaborator.email = email;
	collaborator.name = name;
	collaborator.startDate = new Date(startDate);
	collaborator.type = "MASTER_STUDENT";
	collaborator.collaboratorType = "MASTER_STUDENT"; 
	
	var masterTextHtml= "<select id=\"periodTypes\">";
    
	masterTextHtml += "<br>Selecione o regime de tempo:"  
	    +"<option value=PARTIAL>PARCIAL</option>" 
	    +"<option value=INTEGRAL>INTEGRAL</option>" 
		+"</select>";
    masterTextHtml += "<button onclick=\"getPeriodType()\">Próximo</button>";
	
    document.getElementById("demo").innerHTML =   masterTextHtml;
}

function generatePHDStudent(id, email, name, startDate){
	collaborator.id = id;
	collaborator.email = email;
	collaborator.name = name;
	collaborator.startDate = new Date(startDate);
	collaborator.type = "PHD_STUDENT";
	collaborator.collaboratorType = "PHD_STUDENT"; 
	
	var phdTextHtml= "<select id=\"periodTypes\">";
    
	phdTextHtml += "<br>Selecione o regime de tempo:"  
	    +"<option value=PARTIAL>PARCIAL</option>" 
	    +"<option value=INTEGRAL>INTEGRAL</option>" 
		+"</select>";
    phdTextHtml += "<button onclick=\"getPeriodType()\">Próximo</button>";
    
    document.getElementById("demo").innerHTML =   phdTextHtml;
}


function getPeriodType(){
	
	var periodIndex = document.getElementById("periodTypes").selectedIndex;
    var periodTypes = document.getElementById("periodTypes").options;
    var periodType = periodTypes[periodIndex].value;
    collaborator.periodType = periodType;
    getAdvisor();


}

function getAdvisor(){
	var advisorsText = getCollaborators("PROFESSOR");
	var advisorTextHtml = "<br>Selecione o orientador:"  
		+ advisorsText
		+ "<button onclick=\"saveStudent()\">Salvar</button>";

	document.getElementById("demo").innerHTML =  advisorTextHtml;
	
}











