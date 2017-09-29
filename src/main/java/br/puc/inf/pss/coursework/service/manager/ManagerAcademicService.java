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
	
	private ManagerAcademicService() {
		this.collaborators = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.productions = new ArrayList<>();
	}
	
	/**
	 * Add collaborattor to database  
	 * 
	 **/
	public void addColaborator(Collaborator colaborator) {//TODO - constructor with basic data
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
    	
    	project.setStatus(StatusResearchProject.IN_ELABORATION);
    	if(!project.isElaboration()) {
    		project.setStatus(StatusResearchProject.IN_PROGRESS);
    	}
    
    	if(project.getParticipants() != null) {
    		collaborators = project.getParticipants();
    		project.getParticipants().clear();
    	}
    	
    	projects.add(project);
    	alocateColaboratorInProject(project.ID, collaborators);
    	
    }
    
	
	/**
	 * Allocate collaborators by project
	 * Valid collaborator, at least one professor 
	 * and degree students cannot more than two projects in progress
	 * Save IdProject in database for collaborators
	 * */
	public List<Collaborator> alocateColaboratorInProject(String researchProjectId,
														  List<Collaborator> collaborators) {
		
		List<Collaborator> allocatedCollaborators = new ArrayList<>();
		for(ResearchProject project: projects) {
			if(project.ID == researchProjectId) {
				
				allocatedCollaborators = project.alocateCollaborator(collaborators);
			    
			}
		}
		
		return allocatedCollaborators;
		
	}

	/**
	 * Add production to database 
	 * Valid if publication is valid, for example orientation only advisor professor
	 * and save idPublication in Project (if exists) and in Collaborators
	 * If exist project, so change status project to concluded 
	 * */
    public void addAcademicProduction(AcademicProduction production) {//TODO - constructor with basic data
		
    	production.validProduction();
    	productions.add(production);
	}
    
    
	public List<AcademicProduction> addPublicationInProject(String researchProjectId, 
			                            AcademicProduction publication) {
	
		List<AcademicProduction> publications = new ArrayList<>();
		for(ResearchProject project: projects) {
			if(project.ID == researchProjectId) {
			
				project.addPublication(publication);
				publications = project.getPublications();
			}
		}
		
		return publications;
		
	}

	public void updateStatusResearchProject(String researchProjectId, StatusResearchProject statusUpdated) {
		for(ResearchProject project: projects) {
			if(project.ID == researchProjectId) {
				//mudar para elaboração, ou seja, constarem todas as informações básicas a respeito do projeto
				
				
				
				//para mudar para Em andamento, devem existir publicações associadas ao projeto
				if(statusUpdated.equals(StatusResearchProject.CONCLUDED) 
						&& hasPublicationsByProject(researchProjectId)) {
					project.setStatus(statusUpdated);
				}
				
				

				break;
			}
			
		}
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
		
		return null;
	}
	
    public ResearchProject findColaborator(String idProject) {
		
		return null;
	}
    
    
	public AcademicProductionReport generateAcademicReport() {
		return null;
	}
	
}
