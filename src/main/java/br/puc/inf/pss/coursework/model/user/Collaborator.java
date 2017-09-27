package br.puc.inf.pss.coursework.model.user;

import java.util.Date;
import java.util.List;

import br.puc.inf.pss.coursework.service.manager.Alocation;
import br.puc.inf.pss.model.project.ResearchProject;


public abstract class Collaborator implements Alocation{
     
	
	private String ID;
	private String name;
	private String email;
	private Date startDate;
	private CollaboratorType collaboratorType;
	private List<ResearchProject> projects;
	
	public enum CollaboratorType {
		PROFESSOR, DEGREE_STUDENT, MASTER_STUDENT,PHD_STUDENT,RESEARCHER
	};
	
	
	
	public boolean isCollaboratorType(CollaboratorType collaboratorType) {
		
		return this.collaboratorType.equals(collaboratorType);
	}



	public List<ResearchProject> getProjects() {
		return projects;
	}
	
	
	
	
}
