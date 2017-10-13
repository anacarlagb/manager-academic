package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.service.manager.Alocation;

public class Student extends Collaborator implements Alocation {

	
	
	protected Collaborator advisor;
	
	@JsonIgnore
	protected PeriodType periodType;
	
	public enum PeriodType{
		INTEGRAL,PARTIAL;
	}
	
	@JsonCreator
    public Student(@JsonProperty("iD") String iD,
    		       @JsonProperty("name") String name,
    		       @JsonProperty("email") String email,
    		       @JsonProperty("startDate") Date startDate, 
    		       @JsonProperty("collaboratorType") CollaboratorType collaboratorType,
    		       @JsonProperty("advisor") Collaborator advisor,
    		       @JsonProperty("periodType") PeriodType periodType) {
		
    	super(iD, name, email, startDate, collaboratorType);
		
    	this.advisor = advisor;
    	this.periodType = periodType;
		
	}

	

	@Override
	public boolean validateAlocation() {
		// TODO Auto-generated method stub
		
		
		return true;
	}

	
}