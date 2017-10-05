package br.puc.inf.pss.coursework.controller.manager;

import static org.junit.Assert.assertEquals;

import org.apache.http.HttpResponse;
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
   
	
	
	@Test
	public void shouldAddCollaborator() throws Exception {
		managerData.init();
		
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost(
			"http://localhost:8080/app/user/" + "ardafsd"+"/collaborator");

		StringEntity input = new StringEntity(json.toJson(managerData.deg1).toString());
		input.setContentType("application/json");
		postRequest.setEntity(input);
		
		HttpResponse response = httpClient.execute(postRequest);

		
		

	}
	
	
	
	@Test
	public void shouldElaborateResearchProject() throws Exception {
		 ResearchProject proj1 = managerData.proj1;
		 
		 org.jooby.test.Client.Response jsonResponse = server.post("/app/user/:userId/project")
              .body(json.toJson(proj1).toString(), "String")
              .header("Content-Type", "application/json")
              .expect(201);
	}
	
	@Test
	public void shouldAddAcademicProduction() throws Exception {
		AcademicProduction prod = managerData.publ1;
		
		 org.jooby.test.Client.Response jsonResponse = server.post("/app/user/:userId/project")
	              .body(json.toJson(prod).toString(), "String")
	              .header("Content-Type", "application/json")
	              .expect(201);
		
	}
	
	@Test
	public void shouldGenerateCollaboratorReport() throws Exception {
		
		String idFake = "1001";
		Response test = get("app/user/" + idFake + "/collaborator/" + idFake +"/report");
		
		System.out.println(test.asString());
		
		
	}
	
	@Test
	public void shouldGenerateResearchProjectReport() throws Exception {
		org.jooby.test.Client.Response jsonResponse = server.get("/app/user/:userId/"
															   + "project/:projectId/report")
												            .header("Content-Type", "application/json")
												            .expect(200);
		
	}
	
	@Test
	public void shouldGenerateAcademicReport() throws Exception {
		org.jooby.test.Client.Response jsonResponse = server.get("/app/report")
											              .header("Content-Type", "application/json")
											              .expect(200);
	}

}
