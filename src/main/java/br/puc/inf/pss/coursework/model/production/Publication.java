package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public class Publication {

	public String ID;
	private String title;
	private List<Collaborator> authors;
	private String conferenceName;
	private int year;
	private String idResearchProject;
	
	
	
	
	public String getIdResearchProject() {
		return idResearchProject;
	} 
	
	
	
}
