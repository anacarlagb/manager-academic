package br.puc.inf.pss.coursework.model.user;

import br.puc.inf.pss.model.project.ResearchProject;
import br.puc.inf.pss.model.project.StatusResearchProject;

public class DegreeStudent extends Student{
	
	
	
	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		int inProgress = 0;
		for(ResearchProject project: getProjects()) {
			
			if(project.getStatus().equals(StatusResearchProject.IN_PROGRESS)) {
				inProgress ++;
			}
			
		}
		
		//If projects in progress was more than 2, so student cannot be alocated 
		return inProgress > 2 ? false : true;
	}

}