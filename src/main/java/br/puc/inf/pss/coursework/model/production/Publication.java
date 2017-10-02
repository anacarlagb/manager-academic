package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public class Publication extends AcademicProduction{

	
	protected String conferenceName;
	protected int year;
	
	public Publication(String iD, 
			           String title,
			           List<Collaborator> authors,
			           String conferenceName,
			           int year,
			           String idResearchProject,
			           Collaborator advisor) {
		
		super(iD, title, authors, idResearchProject, advisor);
		this.conferenceName = conferenceName;
		this.year = year;
	}

	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
