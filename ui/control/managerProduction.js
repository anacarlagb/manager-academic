var production = {};

function addproduction(){

//	private String id;
//	protected String title;
//	protected List<Collaborator> authors;
//
//	protected String idResearchProject;
//	protected Collaborator advisor;
//	protected int year;
//	protected AcademicProductionType academicProductionType;
	
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
	 
	
	projectsHTML += "<br> <input type=\"radio\" name=\"sim\" onclick=\"getProject()\">Sim<br>" +
	                "<br> <input type=\"radio\" name=\"nao\" onclick=\"getProductionType()\">Não<br>";
	
    document.getElementById("demo").innerHTML = projectsHTML;
	
	
}

function getProject(){
	var projectsText = getProjects();
	
	var projectsHTML = "<br>Selecione o projeto:" + projectsText + "<button onclick=\"saveProject()\">Salvar Projeto</button>";
    document.getElementById("demo").innerHTML = projectsHTML;

	
}

function saveProject(){
		
}

function getProductionType(){
	
}





function getProductionType(){
	
}