package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public abstract class AcademicProduction {

	public String ID;
	protected String title;
	protected List<Collaborator> authors;
	protected String conferenceName;
	protected String conferenceLocal;
	protected int year;
	protected String idResearchProject;
	protected AcademicProduction academicProduction;
	protected Collaborator advisor;
	
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
