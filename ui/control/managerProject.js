function addproject(){
	
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

