package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class MasterStudent extends Student{

	
	@JsonCreator
	public MasterStudent(@JsonProperty("id") String id, 
			             @JsonProperty("name") String name,
			             @JsonProperty("email") String email,
			             @JsonProperty("startDate") Date startDate,
			             @JsonProperty("collaboratorType") CollaboratorType collaboratorType, 
			             @JsonProperty("advisor") Collaborator advisor, 
			             @JsonProperty("periodType") PeriodType periodType) {
		super(id, name, email, startDate, collaboratorType, advisor, periodType);
		this.periodType = periodType;
	}

	
}
