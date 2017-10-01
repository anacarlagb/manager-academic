package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

public class Admin extends Collaborator {

	
	public Admin(String iD,
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
		return false;
	}

}
