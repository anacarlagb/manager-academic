package br.puc.inf.pss.coursework.service.manager;


import java.util.ArrayList;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.AcademicProduction.AcademicProductionType;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.model.project.ResearchProject;
import br.puc.inf.pss.model.project.StatusResearchProject;


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
	public void addColaborator(Collaborator colaborator) {
	 	collaborators.add(colaborator);
	}
	
	
    /**
     * Add project to database
     * First, add  valid elaboration, after add project in database
     * After valid collaborator, if collaborators are valid
     * 
     * */
    public void elaborateResearchProject(ResearchProject project) {
    	
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

	private void addProjectInCollaborators(List<Collaborator> allocatedCollaborators, ResearchProject researchProject) {
		// TODO Auto-generated method stub
		
		
		
		for(Collaborator allocatedCollaborator :allocatedCollaborators) {
			
			
			for(Collaborator collaborator : collaborators) {
				
				if(collaborator.getId().equals(allocatedCollaborator.getId())) {
					collaborator.addResearchProject(researchProject);
				}
			}
		
		}
	
		
	}

//	private List<Collaborator> getCollaboratorsListById(List<String> collaboratorsId) {
//		// TODO Auto-generated method stub
//		
//		List<Collaborator> collaboratorsList = new ArrayList<>();
//		for(String collaboratorId : collaboratorsId) {
//			
//			Collaborator collaborator = findCollaborator(collaboratorId);
//			collaboratorsList.add(collaborator);
//		}
//		return collaboratorsList;
//	}


	/**
	 * Add production to database 
	 * Valid if publication is valid, for example orientation only advisor professor
	 * and save idPublication in Project (if exists) and in Collaborators
	 * If exist project, so change status project to concluded 
	 * */
    public void addAcademicProduction(AcademicProduction production) {//TODO - constructor with basic data
		
    
    	if(production.validProduction()) {
    		productions.add(production);
    		
    		if(production.getIdResearchProject() != null) {
    			addProductionInProject(production.getIdResearchProject(), production);
    			
    		}
    		
    		addProductionInCollaborator(production, production.getAuthors());
    	}
    	
    	
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
				productions = project.getPublications();
			}
		}
		
		return productions;
		
	}

	
	private boolean hasPublicationsByProject(String researchProjectId) {
		// TODO Auto-generated method stub
		for(AcademicProduction publication: productions) {
			
			
	       if(publication.getIdResearchProject().equals(researchProjectId)) {
	    	   return true;
	       }		
		}
		return false;
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
    
    
	public AcademicProductionReport generateAcademicReport() {
		return null;
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
	
	
	
	
}
