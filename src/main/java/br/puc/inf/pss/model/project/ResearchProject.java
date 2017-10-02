package br.puc.inf.pss.model.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.service.manager.Alocation;

public class ResearchProject{
	
	private String ID;
	private String title;
	private Date startDate;
	private Date endDate;
	private String fundingInstitutionName;
	private Double fundingValue;
	private String goal;
	private String description;
	private List<Collaborator> collaborators;
	private List<AcademicProduction> publications;
	private StatusResearchProject status;
	
	
	
	public ResearchProject(String ID, 
			               String title, 
						   Date startDate,  
						   Date endDate,
						   String fundingInstitutionName, 
						   Double fundingValue, 
						   String goal, 
						   String description,
						   List<Collaborator> collaborators,
						   StatusResearchProject status) {

		this.ID = ID;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fundingInstitutionName = fundingInstitutionName;
		this.fundingValue = fundingValue;
		this.goal = goal;
		this.description = description;
		this.collaborators = collaborators;
		this.status = status;
	
	
	}

		

	public StatusResearchProject getStatus() {
		return status;
	}
	
	public void setStatus(StatusResearchProject status) {
		this.status = status;
	}
	
	public void addPublication(AcademicProduction publication) {
	
		if(status.equals(StatusResearchProject.IN_PROGRESS)) {
		   publications.add(publication);
		   status = StatusResearchProject.CONCLUDED;
		}
		
		
			
	}
	
	
	public List<Collaborator> alocateCollaborators(List<Collaborator> collaboratorsList) {
		// TODO Auto-generated method stub
		
		boolean hasProfessor = false;
		List<Collaborator> tempCollaborators = new ArrayList<>();
		
		//validation collaborators
		for(Collaborator collaborator: collaboratorsList) {
			
			  if(collaborator.isCollaboratorType(CollaboratorType.DEGREE_STUDENT)){
				
				  if(collaborator.validateAlocation()) {
					 tempCollaborators.add(collaborator); 
				 }
			  }
			  else {
				  tempCollaborators.add(collaborator);
				  if(collaborator.isCollaboratorType(CollaboratorType.PROFESSOR)) {
					  hasProfessor = true;
				  }
				  
			  }

		}
		
		//if collaborators are valid, so add list
		if(hasProfessor) {
			collaborators.addAll(tempCollaborators);
		}
		
		
		return collaborators;
	    	
	}


	public List<AcademicProduction> getPublications() {
		return publications;
	}


	public boolean isElaboration() {
		// TODO Auto-generated method stub
		
		return (title == null || title.isEmpty())     
			  ||startDate == null 
			  ||endDate == null   
			  ||fundingInstitutionName == null
			  ||fundingValue  == null
			  ||(goal == null || goal.isEmpty())
			  ||(description == null || description.isEmpty())
			  ||(collaborators == null || collaborators.isEmpty());
		    

		
	}




	public List<Collaborator> getCollaborators() {
		return collaborators;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}



	
	
	
}
