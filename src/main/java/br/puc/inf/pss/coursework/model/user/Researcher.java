package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

public class Researcher extends Collaborator{

	public Researcher(String iD, 
						String name, 
						String email,
						Date startDate, 
						CollaboratorType collaboratorType) {
		super(iD, name, email, startDate, collaboratorType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		return true;
	}

}
