package br.puc.inf.pss.coursework.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.service.manager.Alocation;
import br.puc.inf.pss.model.project.ResearchProject;


public abstract class Collaborator implements Alocation{
     
	
	private String ID;
	protected String name;
	protected String email;
	protected Date startDate;
	protected CollaboratorType collaboratorType;
	protected List<ResearchProject> projects;
	protected List<AcademicProduction> productions;
	
	
	public Collaborator(String id,
						String name, 
						String email,
						Date startDate, 
						CollaboratorType collaboratorType) {
		
		/*If id is empty, so create id, else assigns*/
		this.ID = (id == null || id.isEmpty()) ? 
				  String.valueOf(System.currentTimeMillis()) : 
			      id;
		
		this.name = name;
		this.email = email;
		this.startDate = startDate;
		this.collaboratorType = collaboratorType;
		this.projects = new ArrayList<>();
		this.productions = new ArrayList<>();
	}



	public enum CollaboratorType {
		PROFESSOR, DEGREE_STUDENT, MASTER_STUDENT,PHD_STUDENT,RESEARCHER
	};
	
	
	
	public boolean isCollaboratorType(CollaboratorType collaboratorType) {
		
		return this.collaboratorType.equals(collaboratorType);
	}



	public List<ResearchProject> getProjects() {
		return projects;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}



	public void addResearchProject(ResearchProject researchProject) {
		// TODO Auto-generated method stub
		projects.add(researchProject);
	}



	public void addPublication(AcademicProduction production) {
		// TODO Auto-generated method stub
		productions.add(production);
	}



	public List<AcademicProduction> getProductions() {
		// TODO Auto-generated method stub
		return productions;
	}
	
	
	
	
}
