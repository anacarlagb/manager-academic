package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.model.user.Student.PeriodType;

public class PHDStudent extends Student{


	@JsonCreator
	public PHDStudent(@JsonProperty("id") String id, 
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
