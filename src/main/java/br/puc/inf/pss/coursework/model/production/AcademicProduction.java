package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

public abstract class AcademicProduction {

	private String ID;
	protected String title;
	protected List<Collaborator> authors;

	protected String idResearchProject;
	protected Collaborator advisor;
	protected List<Collaborator> collaborators;
	protected int year;
	protected AcademicProductionType academicProductionType;
	
	
	
	
	public AcademicProduction(String iD, 
							  String title,
							  List<Collaborator> collaborators,
							  String idResearchProject,
							  Collaborator advisor, 
							  AcademicProductionType academicProductionType) {
		
		ID = String.valueOf(System.currentTimeMillis());
		
		this.title = title;
		this.authors = collaborators;
		this.idResearchProject = idResearchProject;
		this.advisor = advisor;
		this.academicProductionType = academicProductionType;
		
	}





	public enum AcademicProductionType {
		PUBLICATION, ORIENTATION;
	};
	
	public int getYear() {
		return year;
	}
	
	
	
	
	
	
	
	public String getIdResearchProject() {
		return idResearchProject;
	}
   
	public String getId() {
		return ID;
	}




	public boolean isAcademicProductionType(AcademicProductionType productionType) {
		// TODO Auto-generated method stub
		return academicProductionType.equals(productionType);
	}
	
	
	
	





	public List<Collaborator> getAuthors() {
		return authors;
	}





	public abstract boolean validProduction(); 
	
	
	
}
