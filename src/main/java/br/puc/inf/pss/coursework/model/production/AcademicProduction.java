package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public abstract class AcademicProduction {

	public String ID;
	private String title;
	private List<Collaborator> authors;
	private String conferenceName;
	private String conferenceLocal;
	private int year;
	private String idResearchProject;
	private AcademicProduction academicProduction;
	
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





	public abstract void validProduction(); 
	
	
	
}
