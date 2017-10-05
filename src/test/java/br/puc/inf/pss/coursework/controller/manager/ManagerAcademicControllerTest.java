package br.puc.inf.pss.coursework.controller.manager;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicDataTest;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicService;
import br.puc.inf.pss.utils.JsonParser;

public class ManagerAcademicControllerTest extends BaseTest{
	
	
    ManagerAcademicDataTest managerData = new ManagerAcademicDataTest();
    JsonParser json = new JsonParser();
    
	@Before
    public void init() {
		managerData.init();
		
	}
	
	
	@Test
	public void shouldAddCollaborator() throws Exception {
		
		Collaborator col = managerData.deg1; 
		 org.jooby.test.Client.Response jsonResponse = server.post("/app/user/:userId/collaborator")
               .body(json.toJson(col).toString(), "String")
               .header("Content-Type", "application/json")
               .expect(201);

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
		 org.jooby.test.Client.Response jsonResponse = server.get("/app/user/:userId/"
		 										                + "collaborator/:collaboratorId/report")
												              .header("Content-Type", "application/json")
												              .expect(200);
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
