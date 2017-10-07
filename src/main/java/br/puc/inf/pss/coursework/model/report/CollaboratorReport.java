package br.puc.inf.pss.coursework.model.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.model.project.ResearchProject;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class CollaboratorReport {
	
	public final String id;
	public final String name;
	public final String email;
	
	
	public final List<ResearchProject> projectsInProgress;
	public final List<ResearchProject> projectsInElaboration;
	public final List<ResearchProject> projectsConcluded;
	

	
	public CollaboratorReport(@JsonProperty("id") String id, 
			                  @JsonProperty("name") String name,
			                  @JsonProperty("email") String email,
			                  @JsonProperty("projectsInProgress") List<ResearchProject> projectsInProgress,
			                  @JsonProperty("projectInElaboration") List<ResearchProject> projectInElaboration,
			                  @JsonProperty("projectConcluded") List<ResearchProject> projectsConcluded) {

		this.id = (id == null || id.isEmpty()) ? 
				  String.valueOf(System.currentTimeMillis()) : 
			      id;
		this.name = name;
		this.email = email;
		this.projectsInProgress = projectsInProgress;
		this.projectsInElaboration = projectInElaboration;
		this.projectsConcluded = projectsConcluded;
	}
	
	
}
