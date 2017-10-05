package br.puc.inf.pss.coursework.model.report;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AcademicReport {

	public final int  totalCollaborators;
	
	public final int totalProjectsInElaboration;
	public final int totalProjectsInProgress;
	public final int totalProjectsConcluded;
	public final int totalProjects;
	public final int totalPublicationProduction;
	public final int totalOrientationProduction;
	
	

  @JsonCreator	
  public AcademicReport(@JsonProperty("totalCollaborators") int totalCollaborators,
		                @JsonProperty("totalProjectsInElaboration") int totalProjectsInElaboration, 
		                @JsonProperty("otalProjectsInProgress") int totalProjectsInProgress,
		                @JsonProperty("totalProjectsConcluded") int totalProjectsConcluded,
		                @JsonProperty("totalProjects") int totalProjects, 
		                @JsonProperty("totalPublicationProduction") int totalPublicationProduction,
		                @JsonProperty("totalOrientationProduction") int totalOrientationProduction) {

		this.totalCollaborators = totalCollaborators;
		this.totalProjectsInElaboration = totalProjectsInElaboration;
		this.totalProjectsInProgress = totalProjectsInProgress;
		this.totalProjectsConcluded = totalProjectsConcluded;
		this.totalProjects = totalProjects;
		this.totalPublicationProduction = totalPublicationProduction;
		this.totalOrientationProduction = totalOrientationProduction;
	}
	
	
	
	
	
}
