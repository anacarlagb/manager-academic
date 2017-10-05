package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.puc.inf.pss.coursework.model.user.Admin;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.DegreeStudent;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="collaboratorType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Publication.class, name = "PUBLICATION"),
    @JsonSubTypes.Type(value = Orientation.class, name = "ORIENTATION")
    
})   
public abstract class AcademicProduction {

	private String ID;
	protected String title;
	protected List<Collaborator> authors;

	protected String idResearchProject;
	protected Collaborator advisor;
	protected List<Collaborator> collaborators;
	protected int year;
	protected AcademicProductionType academicProductionType;
	
	
	
	
	@JsonCreator
	public AcademicProduction(@JsonProperty("iD") String iD, 
			                  @JsonProperty("title") String title,
			                  @JsonProperty("collaborators") List<Collaborator> collaborators,
			                  @JsonProperty("idResearchProject") String idResearchProject,
			                  @JsonProperty("advisor") Collaborator advisor, 
			                  @JsonProperty("academicProductionType") AcademicProductionType academicProductionType) {
		
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
