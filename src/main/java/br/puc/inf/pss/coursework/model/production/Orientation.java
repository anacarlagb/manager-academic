package br.puc.inf.pss.coursework.model.production;

import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

public class Orientation extends AcademicProduction{

	
	
	
	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return advisor.isCollaboratorType(CollaboratorType.PROFESSOR);
	}

}
