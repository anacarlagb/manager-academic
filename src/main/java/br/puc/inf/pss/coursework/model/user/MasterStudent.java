package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MasterStudent extends Student{

	
	String courseRegimeType;
	
	@JsonCreator
	public MasterStudent(@JsonProperty("id") String id, 
			             @JsonProperty("name") String name,
			             @JsonProperty("email") String email,
			             @JsonProperty("startDate") Date startDate,
			             @JsonProperty("collaboratorType") CollaboratorType collaboratorType, 
			             @JsonProperty("advisorId") String advisorId, 
			             @JsonProperty("courseRegimeType") String courseRegimeType) {
		super(id, name, email, startDate, collaboratorType, advisorId);
		this.courseRegimeType = courseRegimeType;
	}

	
}
