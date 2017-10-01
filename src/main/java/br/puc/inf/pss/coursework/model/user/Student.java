package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import br.puc.inf.pss.coursework.service.manager.Alocation;

public class Student extends Collaborator implements Alocation {

	
	
	public String advisorId;
	
     public Student(String iD,
		    		 String name,
		    		 String email,
		    		 Date startDate, 
		    		 CollaboratorType collaboratorType, String advisorId) {
		
    	super(iD, name, email, startDate, collaboratorType);
		
    	this.advisorId = advisorId;
		
	}

	

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		
		
		return true;
	}
     
}