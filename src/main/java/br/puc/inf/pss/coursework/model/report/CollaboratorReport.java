package br.puc.inf.pss.coursework.model.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.model.project.ResearchProject;

public class CollaboratorReport {
	
	public final String name;
	public final String email;
	public final List<ResearchProject> projectsInProgress;
	public final List<ResearchProject> projectsInElaboration;
	public final List<ResearchProject> projectsConcluded;
	
	
	@JsonCreator
	public CollaboratorReport(@JsonProperty("name") String name,
			                  @JsonProperty("email") String email,
			                  @JsonProperty("projectsInProgress") List<ResearchProject> projectsInProgress,
			                  @JsonProperty("projectInElaboration") List<ResearchProject> projectInElaboration,
			                  @JsonProperty("projectConcluded") List<ResearchProject> projectsConcluded) {

		
		this.name = name;
		this.email = email;
		this.projectsInProgress = projectsInProgress;
		this.projectsInElaboration = projectInElaboration;
		this.projectsConcluded = projectsConcluded;
	}
}
