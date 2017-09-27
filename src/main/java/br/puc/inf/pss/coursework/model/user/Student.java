package br.puc.inf.pss.coursework.model.user;

import br.puc.inf.pss.coursework.service.manager.Alocation;

public class Student extends Collaborator implements Alocation {

     public String orientadorId;

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		
		
		return true;
	}
     
}