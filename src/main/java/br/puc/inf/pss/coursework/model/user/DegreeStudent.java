package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.project.StatusResearchProject;

public class DegreeStudent extends Student{
	
	
	
	public DegreeStudent(String ID, 
							String name,
							String email,
							Date startDate, 
							CollaboratorType collaboratorType, 
							String advisorId) {
		
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
