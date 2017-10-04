package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

public class Orientation extends AcademicProduction{

	
	private Collaborator advisor;
	private Collaborator student;
	
	
	 public Orientation(String iD,
						String title,
						Collaborator advisor,
						Collaborator student,
						List<Collaborator> authors,
						String idResearchProject) {
		
		super(iD, title, authors, idResearchProject, null, AcademicProductionType.ORIENTATION);
		
		this.advisor = advisor;
		this.student = student;
	}

	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return advisor.isCollaboratorType(CollaboratorType.PROFESSOR);
	}

}
