package br.puc.inf.pss.controller;

import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;
import com.fasterxml.jackson.databind.JsonNode;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.report.AcademicReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorReport;
import br.puc.inf.pss.coursework.model.report.ResearchProjectReport;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicService;
import br.puc.inf.pss.utils.JsonParser;

@Path("app/user/:userId")
public class ManagerAcademicController {

	public static JsonParser json = new JsonParser();
	
	@POST
    @Path("/collaborator")
	public Result addCollaborator(@Body String bodyCollaborator) {
		 
		JsonNode collaboratorAsJson = json.parse(bodyCollaborator);
		Collaborator collaborator = json.fromJson(collaboratorAsJson, Collaborator.class);
	
		ManagerAcademicService.manager.addColaborator(collaborator);
		return Results.ok(201);
	}
	
	@POST
    @Path("/project")
	public Result elaborateResearchProject(@Body String bodyProject) {
		JsonNode projectAsJson = json.parse(bodyProject);
		ResearchProject project = json.fromJson(projectAsJson, ResearchProject.class);
		
		ManagerAcademicService.manager.elaborateResearchProject(project);
		
		return Results.ok(201);
	}
	
	@POST
    @Path("/project")
	public Result addAcademicProduction(@Body String bodyProduction) {
		JsonNode productionAsJson = json.parse(bodyProduction);
		AcademicProduction production = json.fromJson(productionAsJson, AcademicProduction.class);
		
		ManagerAcademicService.manager.addAcademicProduction(production);
		
		return Results.ok(201);
	}
	
	@GET
	@Path("/collaborator/:collaboratorId/report")
	public Result generateCollaboratorReport(String userId, String collaboratorId) {
		
		CollaboratorReport report = ManagerAcademicService.manager
				                                          .generateCollaboratorReport(collaboratorId);
		
		return Results.json(report);
	}
	
	@GET
	@Path("/project/:projectId/report")
	public Result generateResearchProjectReport(String userId, String projectId) {
		
		ResearchProject projectReport = ManagerAcademicService.manager
				                                       .generateResearchProjectReport(projectId);
		
		return Results.json(projectReport);
	}
	
	@GET
	@Path("/report")
	public Result generateAcademicReport() {
		
	   AcademicReport report = ManagerAcademicService.manager.generateAcademicReport();
	   return Results.json(report);
	}
	
	
}

