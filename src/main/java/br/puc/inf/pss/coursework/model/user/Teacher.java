package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Teacher extends Collaborator{

	@JsonCreator
	public Teacher(@JsonProperty("id") String id, 
			       @JsonProperty("name") String name, 
			       @JsonProperty("email") String email, 
			       @JsonProperty("startDate") Date startDate, 
			       @JsonProperty("collaboratorType") CollaboratorType collaboratorType) {
		
		super(id, name, email, startDate, collaboratorType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		
		return true;
	}

}
