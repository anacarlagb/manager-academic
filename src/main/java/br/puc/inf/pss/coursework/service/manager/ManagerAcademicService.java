package br.puc.inf.pss.coursework.service.manager;


import java.util.ArrayList;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.model.project.ResearchProject;
import br.puc.inf.pss.model.project.StatusResearchProject;


public class ManagerAcademicService {

	private  List<ResearchProject> projects;
	private  List<Publication> publications;
	private  List<Collaborator> collaborators;
	
	private ManagerAcademicService() {
		this.collaborators = new ArrayList<>();
		this.projects = new ArrayList<>();
		this.publications = new ArrayList<>();
	}
	
	
	public void addColaborator(Collaborator colaborator) {
	 	collaborators.add(colaborator);
	}
	
    public void addAcademicProduction(AcademicProduction production) {
		publications.add(production);
	}
	
	public void addProject(ResearchProject project){
		projects.add(project);
	}
	
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
	
	public List<Publication> addPublicationInProject(String researchProjectId, 
			                            Publication publication) {
	
		List<Publication> publications = new ArrayList<>();
		
		for(ResearchProject project: projects) {
			if(project.ID == researchProjectId) {
			
				project.addPublication(publication);
				publications = project.getPublications();
			}
		}
		
		return publications;
		
	}
	
	public void updateAcademicProduction() {
		
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
		for(Publication publication: publications) {
			
			
	       if(publication.getIdResearchProject().equals(researchProjectId)) {
	    	   return true;
	       }		
		}
		return false;
	}
	
	


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
