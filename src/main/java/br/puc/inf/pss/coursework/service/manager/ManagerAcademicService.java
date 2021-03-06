package br.puc.inf.pss.coursework.service.manager;


import java.util.ArrayList;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.AcademicProduction.AcademicProductionType;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.project.StatusResearchProject;
import br.puc.inf.pss.coursework.model.report.AcademicReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorReport;
import br.puc.inf.pss.coursework.model.report.ReportUtils;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;


public class ManagerAcademicService {

	private  List<ResearchProject> projects;
	private  List<AcademicProduction> productions;
	private  List<Collaborator> collaborators;
	public static final ManagerAcademicService manager = new ManagerAcademicService();
	
	private ManagerAcademicService() {
		this.collaborators = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.productions = new ArrayList<>();
	}
	
	/**
	 * Add collaborattor to database  
	 * 
	 **/
	public Collaborator addColaborator(Collaborator collaborator) {
	 	collaborators.add(collaborator);
	 	
	 	return findCollaborator(collaborator.getId());
	}
	
	
    /**
     * Add project to database
     * First, add  valid elaboration, after add project in database
     * After valid collaborator, if collaborators are valid
     * 
     * */
    public ResearchProject elaborateResearchProject(ResearchProject project) {
    	
    	List<Collaborator> collaborators = new ArrayList<>();
    	
    	
    	if(project.isElaboration()) {
    		project.setStatus(StatusResearchProject.IN_ELABORATION);		
    	}
    	else {
    		project.setStatus(StatusResearchProject.IN_PROGRESS);
    	}
    
    	if(project.getCollaborators() != null) {
    		collaborators = new ArrayList<>(project.getCollaborators());
    		project.getCollaborators().clear();
   
    	}
    	
    	projects.add(project);
    	alocateColaboratorInProject(project.getId(), collaborators);
    	return findProject(project.getId());
    	
    }
    
	
	/**
	 * Allocate collaborators by project
	 * Valid collaborator, at least one professor 
	 * and degree students cannot more than two projects in progress
	 * Save IdProject in database for collaborators
	 * */
	public List<Collaborator> alocateColaboratorInProject(String researchProjectId,
														  List<Collaborator> collaborators) {
		
		
		ResearchProject researchProject = null;
		List<Collaborator> allocatedCollaborators = new ArrayList<>();
		
		//TODO - simplify collaborator
		for(int projectIndex = 0; projectIndex < projects.size(); projectIndex++) {
			researchProject = projects.get(projectIndex);
			
			if(researchProject.getId() == researchProjectId) {
				
				allocatedCollaborators = researchProject.alocateCollaborators(collaborators);
				
				projects.set(projectIndex, researchProject);
			}
		}
		
		//TODO - simplify project
		addProjectInCollaborators(allocatedCollaborators, researchProject);
		
		return allocatedCollaborators;
		
	}

	private void addProjectInCollaborators(List<Collaborator> allocatedCollaborators, 
										   ResearchProject researchProject) {
		// TODO Auto-generated method stub
		for(Collaborator allocatedCollaborator :allocatedCollaborators) {
			
			
			for(Collaborator collaborator : collaborators) {
				
				if(collaborator.getId().equals(allocatedCollaborator.getId())) {
					collaborator.addResearchProject(researchProject);
				}
			}
		
		}
	
		
	}

	/**
	 * Add production to database 
	 * Valid if publication is valid, for example orientation only advisor professor
	 * and save idPublication in Project (if exists) and in Collaborators
	 * If exist project, so change status project to concluded 
	 * */
    public AcademicProduction addAcademicProduction(AcademicProduction production) {//TODO - constructor with basic data
		
    
    	if(production.validProduction()) {
    		productions.add(production);
    		
    		if(production.getIdResearchProject() != null) {
    			addProductionInProject(production.getIdResearchProject(), production);
    			
    		}
    		
    		addProductionInCollaborator(production, production.getAuthors());
    	}
    	
    	return findProduction(production.getId());
	}
    
    
	private void addProductionInCollaborator(AcademicProduction production, List<Collaborator> authors) {
		// TODO Auto-generated method stub
		
		for(Collaborator author: authors) {
			
			for(Collaborator collaborator: collaborators ) {
				
				if(author.getId().equals(collaborator.getId())) {
					collaborator.addPublication(production);
				}
			}
		}
	}

	public List<AcademicProduction> addProductionInProject(String researchProjectId, 
			                            AcademicProduction production) {
	
		List<AcademicProduction> productions = new ArrayList<>();
		
		for(ResearchProject project: projects) {
			if(project.getId() == researchProjectId) {
				
				project.addPublication(production);
				productions = project.getProductions();
			}
			
		}
		
		return productions;
		
	}

	
   /*--------------------------------------------REPORTS ---------------------------------- */

    
	public ResearchProject findProject(String idProject) {
		
		for(ResearchProject researchProject : projects) {
    		if(researchProject.getId().equals(idProject)) {
    			return researchProject;
    		}
    		
    	}
		return null;
	}
	
    public Collaborator findCollaborator(String collaboratorId) {
		
    	for(Collaborator collaborator : collaborators) {
    		
    		if(collaborator.getId().equals(collaboratorId)) {
    			return collaborator;
    		}
    		
    	}
		return null;
	}
    
    public AcademicProduction findProduction(String productionId) {
		
    	for(AcademicProduction production : productions) {
    		
    		if(production.getId().equals(productionId)) {
    			return production;
    		}
    		
    	}
		return null;
	}
    
    public CollaboratorReport generateCollaboratorReport(String collaboratorId) {
    	
    	Collaborator collaborator = findCollaborator(collaboratorId);
    	CollaboratorReport report = null;
    	
    	if(collaborator != null) {
	    	List<ResearchProject> projectsInElaboration = new ArrayList<>();
	    	List<ResearchProject> projectsInProgress = new ArrayList<>();
	    	List<ResearchProject> projectsConcluded = new ArrayList<>();
	    	ReportUtils.sortProductions(collaborator.getProductions());
	    	
	    	for(ResearchProject project : collaborator.getProjects()) {
	    		
	    		project.sortProductions();
	    		if(project.getStatus().equals(StatusResearchProject.IN_PROGRESS)) {
	    			
	    			projectsInProgress.add(project);
	    		}
	    		else
	    			if(project.getStatus().equals(StatusResearchProject.IN_ELABORATION)) {
	    				projectsInElaboration.add(project);
	    			}
	    		else
	    			if(project.getStatus().equals(StatusResearchProject.CONCLUDED)) {
	    				projectsConcluded.add(project);
	    			}
	    			
	    	}
	    	
	    	projectsInElaboration = ReportUtils.sortProjects(projectsInElaboration);
	    	projectsInProgress = ReportUtils.sortProjects(projectsInProgress);
	    	projectsConcluded = ReportUtils.sortProjects(projectsConcluded);
	    	
	    	
	    	
	    	report = new CollaboratorReport(collaborator.getId(), 
	    			                        collaborator.getName(),
	    			                        collaborator.getEmail(),
	    			                        projectsInProgress,
	    			                        projectsInElaboration,
	    			                        projectsConcluded);
	    	
	    	
    	}
   
    	
    	
    	return report;
    	
    }
    
    public ResearchProject generateResearchProjectReport(String researchProjecId){
    
    	ResearchProject project = findProject(researchProjecId);
    	project.sortProductions();
    	
    	return project;
    }
    
	public AcademicReport generateAcademicReport() {
		
		AcademicReport academicReport = null;
		
		int totalProjectsInElaboration = 0;
		int totalProjectsInProgress = 0;
		int totalProjectsConcluded = 0;
		int totalPublicationProduction = 0;
		int totalOrientationProduction = 0;
		
		int totalProjects = projects.size();
		int totalCollaborators = collaborators.size();
		for (ResearchProject project : projects) {

			if (project.getStatus().equals(StatusResearchProject.IN_PROGRESS)) {
				totalProjectsInProgress ++;
				
			} else if (project.getStatus().equals(StatusResearchProject.IN_ELABORATION)) {
				totalProjectsInElaboration ++;
				
			} else if (project.getStatus().equals(StatusResearchProject.CONCLUDED)) {
				totalProjectsConcluded ++;
			}

		}
		for(AcademicProduction production : productions) {
			
			if(production.isAcademicProductionType(AcademicProductionType.PUBLICATION)) {
				totalPublicationProduction ++;
			}
			else 
				if(production.isAcademicProductionType(AcademicProductionType.ORIENTATION)) {
					totalOrientationProduction ++;
			}
		}
		
		academicReport = new AcademicReport(totalCollaborators,
				                           totalProjectsInElaboration, 
				                           totalProjectsInProgress,
				                           totalProjectsConcluded,
				                           totalProjects,
				                           totalPublicationProduction,
				                           totalOrientationProduction);
 
		
		return academicReport;
	}

	public List<ResearchProject> getProjects() {
		return projects;
	}

	public List<AcademicProduction> getProductions() {
		return productions;
	}

	public List<Collaborator> getCollaborators() {
		return collaborators;
	}

	public List<Collaborator> getCollaboratorsByType(CollaboratorType collaboratorType) {
		// TODO Auto-generated method stub
		
	   List<Collaborator> collaboratorsByType = new ArrayList<>();
	  
	   for(Collaborator collaborator : collaborators) {
		   if(collaborator.isCollaboratorType(collaboratorType)) {
			   collaboratorsByType.add(collaborator);
			   
		   }
	   }
		
		return collaboratorsByType;
	}

	public List<AcademicProduction> getProductionsByCollaborator(String collaboratorId) {
		// TODO Auto-generated method stub
		
		  for(Collaborator collaborator : collaborators) {
			   if(collaborator.getId().equals(collaboratorId)) {
				   ReportUtils.sortProductions(collaborator.getProductions());
				   return collaborator.getProductions();
				   
			   }
		   }
		
		return null;
	}
	
	
	
	
	
	
	
}
