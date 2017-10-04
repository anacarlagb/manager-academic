package br.puc.inf.pss.coursework.model.report;

public class AcademicReport {

	public final int  totalCollaborators;
	
	public final int totalProjectsInElaboration;
	public final int totalProjectsInProgress;
	public final int totalProjectsConcluded;
	public final int totalProjects;
	public final int totalPublicationProduction;
	public final int totalOrientationProduction;
	
	
	
  public AcademicReport(int totalCollaborators,
						int totalProjectsInElaboration, 
						int totalProjectsInProgress,
						int totalProjectsConcluded,
						int totalProjects, 
						int totalPublicationProduction,
						int totalOrientationProduction) {

		this.totalCollaborators = totalCollaborators;
		this.totalProjectsInElaboration = totalProjectsInElaboration;
		this.totalProjectsInProgress = totalProjectsInProgress;
		this.totalProjectsConcluded = totalProjectsConcluded;
		this.totalProjects = totalProjects;
		this.totalPublicationProduction = totalPublicationProduction;
		this.totalOrientationProduction = totalOrientationProduction;
	}
	
	
	
	
	
}
