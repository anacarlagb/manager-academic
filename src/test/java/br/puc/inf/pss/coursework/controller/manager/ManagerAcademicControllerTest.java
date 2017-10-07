package br.puc.inf.pss.coursework.controller.manager;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jooby.test.Client;
import org.jooby.test.JoobyRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.goebl.david.Webb;

import br.puc.inf.pss.App;
import br.puc.inf.pss.AppTest;
import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.report.AcademicReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorReport;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicDataTest;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicService;
import br.puc.inf.pss.utils.JsonParser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;


public class ManagerAcademicControllerTest{
	
	
    ManagerAcademicDataTest managerData = new ManagerAcademicDataTest();
    JsonParser json = new JsonParser();
    

    /**
     * One app/server for all the test of this class. If you want to start/stop a new server per test,
     * remove the static modifier and replace the {@link ClassRule} annotation with {@link Rule}.
     */
    @ClassRule
    public static JoobyRule app = new JoobyRule(new App());

    @Rule
    public Client server = new Client("http://localhost:8080");
    
    DefaultHttpClient httpClient = new DefaultHttpClient();
    HttpResponse response;
	String serverName = "http://localhost:8080";
	
    public String toString(InputStream in) throws IOException {
    	int ch;
    	StringBuilder sb = new StringBuilder();
    	while((ch = in.read()) != -1 ) {
    		sb.append((char) ch);
    	}
    	return sb.toString();
    	
    }
	@Test
	public void shouldAddCollaborator() throws Exception {
		managerData.init();
		
		HttpPost postRequest = new HttpPost(serverName + "/app/user/" + "ardafsd"+"/collaborator");
		StringEntity input = new StringEntity(json.toJson(managerData.tea12).toString());
		input.setContentType("application/json");
		postRequest.setEntity(input);
		
		response = httpClient.execute(postRequest);
		
		
		String addedCollaboratorAsText = toString(response.getEntity().getContent());
		JsonNode addedCollaboratorAsJson = json.parse(addedCollaboratorAsText);
		
		assertEquals(addedCollaboratorAsJson.get("id").asInt(), 102);
		assertEquals(addedCollaboratorAsJson.get("name").asText(), "Prof. Paulo");
		assertEquals(addedCollaboratorAsJson.get("email").asText(), "paulo@email.br");
		assertEquals(addedCollaboratorAsJson.get("collaboratorType").asText(), "PROFESSOR");

	}
	

	@Test
	public void shouldElaborateResearchProject() throws Exception {
		managerData.init();
		
		 ResearchProject proj1 = managerData.proj1;
		 //TODO Notifications : Aluno não pode ser incluido e projeto sem professor
		 
		HttpPost postRequest = new HttpPost(serverName + "/app/user/" + "ardafsd"+"/project");
		StringEntity input = new StringEntity(json.toJson(proj1).toString());
		input.setContentType("application/json");
		postRequest.setEntity(input);
		
		response = httpClient.execute(postRequest);
		
		
		String addedProjectAsText = toString(response.getEntity().getContent());
		JsonNode addedProjectAsJson = json.parse(addedProjectAsText);
		ResearchProject addedProj = json.fromJson(addedProjectAsJson, ResearchProject.class);
		
		assertEquals(addedProj.getId(), proj1.getId());
		assertEquals(addedProj.getTitle(), proj1.getTitle());
		assertEquals(addedProj.getCollaborators().size(), 9);
	}
	
	@Test
	public void shouldAddAcademicProduction() throws Exception {
		managerData.init();
		
		//Mudar o status do projeto para concluido
		//Exception - Orientacao tem advisor professor
		 AcademicProduction prod = managerData.publ1;
	
		 //TODO Notifications : Aluno não pode ser incluido e projeto sem professor
		 
		HttpPost postRequest = new HttpPost(serverName + "/app/user/" + "ardafsd"+"/production");
		StringEntity input = new StringEntity(json.toJson(prod).toString());
		input.setContentType("application/json");
		postRequest.setEntity(input);
		
		response = httpClient.execute(postRequest);
		
		
		String addedProductionAsText = toString(response.getEntity().getContent());
		JsonNode addedProductionAsJson = json.parse(addedProductionAsText);
		AcademicProduction addedProd = json.fromJson(addedProductionAsJson, AcademicProduction.class);
		
		assertEquals(addedProd.getId(), prod.getId());
		assertEquals(addedProd.getYear(), 2006);
		assertEquals(addedProd.getAuthors().size(), 3);
		assertEquals(addedProd.getIdResearchProject(), "30");
		
	}
	
	@Test
	public void shouldGenerateCollaboratorReport() throws Exception {
		
		String collaboratorId = "1001";

		HttpGet getRequest = new HttpGet(serverName + "/app/user/" + "ardafsd"+"/collaborator/" + collaboratorId + "/report");
		getRequest.addHeader("Content-Type", "application/json");
		response = httpClient.execute(getRequest);
		
		
		String collaboratorReportAsText = toString(response.getEntity().getContent());
		
		JsonNode collaboratorReportAsJson = json.parse(collaboratorReportAsText);
		CollaboratorReport collaboratorReport = json.fromJson(collaboratorReportAsJson, CollaboratorReport.class);
	
		assertEquals(collaboratorReport.email, "maria@email.br");
		assertEquals(collaboratorReport.name, "Maria");
		assertEquals(collaboratorReport.projectsInProgress.size(), 1);
		
	}
	
	@Test
	public void shouldGenerateResearchProjectReport() throws Exception {
		String projectId = "30";

		HttpGet getRequest = new HttpGet(serverName + "/app/user/" + "ardafsd"+"/project/" + projectId + "/report");
		getRequest.addHeader("Content-Type", "application/json");
		response = httpClient.execute(getRequest);
		
		
		String projectReportAsText = toString(response.getEntity().getContent());
		
		JsonNode projectReportAsJson = json.parse(projectReportAsText);
		ResearchProject projectReport = json.fromJson(projectReportAsJson, ResearchProject.class);
	
		assertEquals(projectReport.getId(),projectId);
		assertEquals(projectReport.getCollaborators().size(), 7);
		
	}
	
	@Test
	public void shouldGenerateAcademicReport() throws Exception {
		HttpGet getRequest = new HttpGet(serverName + "/app/user/" + "ardafsd"+"/report");
		getRequest.addHeader("Content-Type", "application/json");
		response = httpClient.execute(getRequest);
		
        String academicReportAsText = toString(response.getEntity().getContent());
		
		JsonNode academicAsJson = json.parse(academicReportAsText);
		AcademicReport academicReport = json.fromJson(academicAsJson, AcademicReport.class);
		
		
		assertEquals(academicReport.totalCollaborators, 11);
		assertEquals(academicReport.totalProjects, 1);
	}

}
