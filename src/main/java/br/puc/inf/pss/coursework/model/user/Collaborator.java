package br.puc.inf.pss.coursework.model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.service.manager.Alocation;

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Admin.class, name = "ADMIN"),
        @JsonSubTypes.Type(value = DegreeStudent.class, name = "DEGREE_STUDENT"),
        @JsonSubTypes.Type(value = MasterStudent.class, name = "MASTER_STUDENT"),
        @JsonSubTypes.Type(value = PHDStudent.class, name = "PHD_STUDENT"),
        @JsonSubTypes.Type(value = Researcher.class, name = "RESEARCHER"),
        @JsonSubTypes.Type(value = Teacher.class, name = "PROFESSOR")
})
public abstract class Collaborator implements Alocation{
     
	
	public final String id;
	public final String name;
	public final String email;
	public final Date startDate;
	private CollaboratorType collaboratorType;
	protected List<ResearchProject> projects;
	protected List<AcademicProduction> productions;
	
	@JsonCreator
	public Collaborator(@JsonProperty("id") String id,
			            @JsonProperty("name") String name, 
			            @JsonProperty("email") String email,
			            @JsonProperty("startDate") Date startDate, 
			            @JsonProperty("collaboratorType") CollaboratorType collaboratorType) {
		
		/*If id is empty, so create id, else assigns*/
		this.id = (id == null || id.isEmpty()) ? 
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
		ADMIN,PROFESSOR, DEGREE_STUDENT, MASTER_STUDENT,PHD_STUDENT,RESEARCHER
	};
	
	
	@JsonIgnore
	public boolean isCollaboratorType(CollaboratorType collaboratorType) {
		
		return this.collaboratorType.equals(collaboratorType);
	}



	public List<ResearchProject> getProjects() {
		return projects;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return id;
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



	public Date getStartDate() {
		// TODO Auto-generated method stub
		return startDate;
	}



	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}



	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}



	public CollaboratorType getCollaboratorType() {
		return collaboratorType;
	}



	public void setCollaboratorType(CollaboratorType collaboratorType) {
		this.collaboratorType = collaboratorType;
	}
	
	
	
	
}
