package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.model.user.Admin;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.DegreeStudent;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="academicProductionType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Publication.class, name = "PUBLICATION"),
    @JsonSubTypes.Type(value = Orientation.class, name = "ORIENTATION")
    
}) 
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public abstract class AcademicProduction {

	private String id;
	protected String title;
	protected List<Collaborator> authors;

	protected String idResearchProject;
	protected Collaborator advisor;
	protected int year;
	protected AcademicProductionType academicProductionType;
	
	
	
	
	@JsonCreator
	public AcademicProduction(@JsonProperty("id") String id, 
			                  @JsonProperty("title") String title,
			                  @JsonProperty("authors") List<Collaborator> authors,
			                  @JsonProperty("idResearchProject") String idResearchProject,
			                  @JsonProperty("advisor") Collaborator advisor, 
			                  @JsonProperty("year") int year,
			                  @JsonProperty("academicProductionType") AcademicProductionType academicProductionType) {
		
		this.id = (id == null || id.isEmpty()) ? 
				  String.valueOf(System.currentTimeMillis()) : 
			      id;
		
		this.title = title;
		this.authors = authors;
		this.idResearchProject = idResearchProject;
		this.advisor = advisor;
		this.year = year;
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
		return id;
	}
   
	@JsonIgnore
	public boolean isAcademicProductionType(AcademicProductionType productionType) {
		// TODO Auto-generated method stub
		return academicProductionType.equals(productionType);
	}
	
	public List<Collaborator> getAuthors() {
		return authors;
	}

	public abstract boolean validProduction();

	public String getTitle() {
		return title;
	}

	public AcademicProductionType getAcademicProductionType() {
		return academicProductionType;
	} 
	
	
	
	
	
}
