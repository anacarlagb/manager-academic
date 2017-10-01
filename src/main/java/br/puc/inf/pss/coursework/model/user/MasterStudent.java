package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

public class MasterStudent extends Student{

	
	String courseRegimeType;
	
	
	public MasterStudent(String iD, 
							String name,
							String email,
							Date startDate,
							CollaboratorType collaboratorType, 
							String advisorId, 
							String courseRegimeType) {
		super(iD, name, email, startDate, collaboratorType, advisorId);
		this.courseRegimeType = courseRegimeType;
	}

	
}
