package br.puc.inf.pss.model.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public void alocateColaborator(Collaborator collaborator) {
		participants.add(collaborator);
	}
	
	

	public StatusResearchProject getStatus() {
		return status;
	}
	
	public void setStatus(StatusResearchProject status) {
		this.status = status;
	}


	public boolean validateAlocation(List<Collaborator> collaborators) {
		// TODO Auto-generated method stub
		
		boolean hasProfessor;
		for(Collaborator collaborator: collaborators) {
			
			if(collaborator.isCollaboratorType(CollaboratorType.PROFESSOR)) {
			   hasProfessor = true;
			}
			else
			  if(collaborator.isCollaboratorType(CollaboratorType.DEGREE_STUDENT)){
				 collaborator.validateAlocation();
			  }
				
			
	
		}
	    return true;	
	}
	
	
	
	
	
	
	
	
}
