package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.service.manager.Alocation;

public class Student extends Collaborator implements Alocation {

	
	
	public String advisorId;
	
	@JsonCreator
    public Student(@JsonProperty("iD") String iD,
    		       @JsonProperty("name") String name,
    		       @JsonProperty("email") String email,
    		       @JsonProperty("startDate") Date startDate, 
    		       @JsonProperty("collaborator") CollaboratorType collaboratorType,
    		       @JsonProperty("advisorId") String advisorId) {
		
    	super(iD, name, email, startDate, collaboratorType);
		
    	this.advisorId = advisorId;
		
	}

	

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		
		
		return true;
	}
     
}