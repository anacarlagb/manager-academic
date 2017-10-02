package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public abstract class AcademicProduction {

	private String ID;
	protected String title;
	protected List<Collaborator> authors;

	protected String idResearchProject;
	protected Collaborator advisor;
	protected List<Collaborator> collaborators;
	
	
	
	
	
	public AcademicProduction(String iD, 
							  String title,
							  List<Collaborator> collaborators,
							  String idResearchProject,
							  Collaborator advisor) {
		
		ID = String.valueOf(System.currentTimeMillis());
		
		this.title = title;
		this.authors = authors;
		this.idResearchProject = idResearchProject;
		this.advisor = advisor;
	}





	public enum AcademicProductionType {
		PUBLICATION, ORIENTATION;
	};
	
	
	
	
	
	public String getIdResearchProject() {
		return idResearchProject;
	}





	public boolean isAcademicProductionType(AcademicProductionType orientation) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	





	public List<Collaborator> getAuthors() {
		return authors;
	}





	public abstract boolean validProduction(); 
	
	
	
}
