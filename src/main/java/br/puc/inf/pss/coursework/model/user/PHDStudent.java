package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PHDStudent extends Student{

	@JsonCreator
	public PHDStudent(@JsonProperty("iD") String iD, 
			          @JsonProperty("name") String name,
			          @JsonProperty("email") String email,
			          @JsonProperty("startDate") Date startDate, 
			          @JsonProperty("collaboratorType") CollaboratorType collaboratorType, 
			          @JsonProperty("advisorId") String advisorId, 
			          @JsonProperty("courseRegimeType") String courseRegimeType) {
		super(iD, name, email, startDate, collaboratorType, null);
		// TODO Auto-generated constructor stub
	}

}
