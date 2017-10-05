package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.project.StatusResearchProject;

public class DegreeStudent extends Student{
	
	
	
	@JsonCreator
	public DegreeStudent(@JsonProperty("ID") String ID, 
			             @JsonProperty("name") String name,
			             @JsonProperty("email") String email,
			             @JsonProperty("startDate") Date startDate, 
			             @JsonProperty("collaboratorType") CollaboratorType collaboratorType, 
			             @JsonProperty("advisorId") String advisorId) {
		
		super(ID, name, email, startDate, collaboratorType, advisorId);
		
	}

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		int inProgress = 0;
		
		
		for(ResearchProject project: projects) {
	     		
			if(project.getStatus().equals(StatusResearchProject.IN_PROGRESS)) {
				inProgress ++;
			}
			
		}
		
		//If projects in progress was more than 2, so student cannot be alocated 
		return inProgress < 2 ? true : false;
	}

}
