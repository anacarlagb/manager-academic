package br.puc.inf.pss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jooby.Result;
import org.jooby.Results;
import org.jooby.mvc.Body;
import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.report.AcademicReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorsReport;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicService;
import br.puc.inf.pss.utils.JsonBuilder;
import br.puc.inf.pss.utils.JsonParser;

@Path("app/user/:userId")
public class ManagerAcademicController {

	public static JsonParser json = new JsonParser();
	
	@POST
    @Path("/collaborator")
	public Result addCollaborator(String userId, @Body String bodyCollaborator) {
		
		JsonNode collaboratorAsJson = json.parse(bodyCollaborator);
		
		Collaborator collaborator = json.fromJson(collaboratorAsJson, Collaborator.class);
		
		
		collaborator = ManagerAcademicService.manager.addColaborator(collaborator);
		if(collaborator != null){
			return Results.ok(json.toJson(collaborator));
		}
		return Results.json(500);
	}
	
	@POST
    @Path("/project")
	public Result elaborateResearchProject(@Body String bodyProject) {
		JsonNode projectAsJson = json.parse(bodyProject);
		
		ResearchProject project = json.fromJson(projectAsJson, ResearchProject.class);
		
		project = ManagerAcademicService.manager.elaborateResearchProject(project);
		
		return Results.ok(json.toJson(project));
	}
	
	@POST
    @Path("/production")
	public Result addAcademicProduction(@Body String bodyProduction) {
		JsonNode productionAsJson = json.parse(bodyProduction);
		AcademicProduction production = json.fromJson(productionAsJson, AcademicProduction.class);
		
		production = ManagerAcademicService.manager.addAcademicProduction(production);
		
		return Results.ok(json.toJson(production));
	}
	
	@GET
	@Path("/collaborator/:collaboratorId/report")
	public Result generateCollaboratorReport(String userId, String collaboratorId) {
		
		if (collaboratorId != null && !collaboratorId.isEmpty()) {
			collaboratorId = collaboratorId.replaceAll("\"", "");
			
			CollaboratorReport report = ManagerAcademicService.manager.generateCollaboratorReport(collaboratorId);

			if (report != null) {
				JsonNode reportJson = json.toJson(report);
				return Results.ok(reportJson);
			}
		}
		return Results.with("Esse colaborador não existe");
	}
	
	@GET
	@Path("/project/:projectId/report")
	public Result generateResearchProjectReport(String userId, String projectId) {
		
		if (projectId != null && !projectId.isEmpty()) {
			projectId = projectId.replaceAll("\"", "");
			
			ResearchProject projectReport = ManagerAcademicService.manager.generateResearchProjectReport(projectId);
			if(projectReport != null) {
				JsonNode reportJson = json.toJson(projectReport);
				return Results.ok(reportJson);
			}
			
		}
		return Results.with("Esse projeto não existe");
	}
	
	@GET
	@Path("/report")
	public Result generateAcademicReport() {
	   AcademicReport report = ManagerAcademicService.manager.generateAcademicReport();
	   
	   JsonNode reportJson = json.toJson(report);
	   
	   return Results.ok(reportJson);
	}
	
	@GET
	@Path("/collaborators")
    public Result getCollaborators(String userId, Optional<String> type) throws JsonGenerationException, JsonMappingException, IOException {
		
		
		List<Collaborator> collaborators = new ArrayList<>();
		
		if(type.isPresent() && !type.get().isEmpty()) {
			
			try {
				CollaboratorType collaboratorType = CollaboratorType.valueOf(type.get().toUpperCase());
				collaborators = ManagerAcademicService.manager.getCollaboratorsByType(collaboratorType);
			
			} catch (IllegalArgumentException e) {
				Results.with("Esse tipo de colaborador não é válido.");
			}
		}
		else {
			
		    collaborators = ManagerAcademicService.manager.getCollaborators();
		    System.out.println(collaborators.size());
		}
		
		CollaboratorsReport collaboratorsReport = new CollaboratorsReport("", collaborators);

		JsonNode collaboratorsJson = json.toJson(collaboratorsReport);
		
		return Results.ok(collaboratorsJson);
	}
	
	@GET
	@Path("/projects")
	public Result getProjects(String userId) {
		List<ResearchProject> projects = ManagerAcademicService.manager.getProjects();
		
		if(projects != null) {
			JSONObject projectsJson = JsonBuilder.buildProjects(projects);
		    return Results.ok(projectsJson);
		}
		else {
			return Results.with("Não temos projetos cadastrados");
		}
	}
	
	
	@GET
	@Path("/collaborator/:collaboratorId/productions")
	public Result getProductionsByCollaborator(String userId, String collaboratorId) {
		if (collaboratorId != null && !collaboratorId.isEmpty()) {
			collaboratorId = collaboratorId.replaceAll("\"", "");
			
			List<AcademicProduction> productions = ManagerAcademicService.manager.getProductionsByCollaborator(collaboratorId);
			JSONObject productionsJson = JsonBuilder.buildProductions(productions);
			
			if(productionsJson != null) {
				return Results.ok(productionsJson);
			}
			
		}
		return Results.with("Esse projeto não existe");
	}
	
	
	
}


