package br.puc.inf.pss.coursework.model.report;

import java.util.List;

import br.puc.inf.pss.model.project.ResearchProject;

public class CollaboratorReport {
	
	public final String name;
	public final String email;
	public final List<ResearchProject> projectsInProgress;
	public final List<ResearchProject> projectsInElaboration;
	public final List<ResearchProject> projectsConcluded;
	
	
	
	public CollaboratorReport(String name,
			                  String email,
			                  List<ResearchProject> projectsInProgress,
			                  List<ResearchProject> projectInElaboration,
			                  List<ResearchProject> projectsConcluded) {

		
		this.name = name;
		this.email = email;
		this.projectsInProgress = projectsInProgress;
		this.projectsInElaboration = projectInElaboration;
		this.projectsConcluded = projectsConcluded;
	}
}
