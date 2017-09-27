package br.puc.inf.pss.model.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.service.manager.Alocation;

public class ResearchProject{
	
	public String ID;
	private String title;
	private Date startDate;
	private Date endDate;
	private String fundingInstitutionName;
	private Double fundingValue;
	private String goal;
	private String description;
	private List<Collaborator> participants;
	private List<Publication> publications;
	private StatusResearchProject status;
	
	
	
	public ResearchProject(String title, 
						   Date startDate, 
						   Date endDate, 
						   String fundingInstitutionName,
						   Double fundingValue, 
						   String goal, 
						   String description, 
						   StatusResearchProject status) {
	
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fundingInstitutionName = fundingInstitutionName;
		this.fundingValue = fundingValue;
		this.goal = goal;
		this.description = description;
		this.status = status;
		this.participants = new ArrayList<>();
	}

	
	

	public StatusResearchProject getStatus() {
		return status;
	}
	
	public void setStatus(StatusResearchProject status) {
		this.status = status;
	}
	
	public boolean addPublication(Publication publication) {
		if(status.equals(StatusResearchProject.IN_PROGRESS)) {
		   publications.add(publication);
		}
		
		return status.equals(StatusResearchProject.IN_PROGRESS);
		
		
	}
	

	public List<Collaborator> alocateCollaborator(List<Collaborator> collaborators) {
		// TODO Auto-generated method stub
		
		boolean hasProfessor = false;
		List<Collaborator> tempCollaboratorsList = new ArrayList<>();
		
		//validation collaborators
		for(Collaborator collaborator: collaborators) {
			
			if(collaborator.isCollaboratorType(CollaboratorType.PROFESSOR)) {
			   hasProfessor = true;
			   tempCollaboratorsList.add(collaborator);
			}
			else
			  if(collaborator.isCollaboratorType(CollaboratorType.DEGREE_STUDENT)){
				 
				  if(collaborator.validateAlocation()) {
					 tempCollaboratorsList.add(collaborator); 
				 }
			  }

		}
		
		//if collaborators are valid, so add list
		if(hasProfessor) {
			participants.addAll(tempCollaboratorsList);
		}
		
		
		return participants;
	    	
	}




	public List<Publication> getPublications() {
		return publications;
	}





	
	
	
	
	
	
	
	
}
