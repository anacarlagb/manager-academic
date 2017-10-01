package br.puc.inf.pss.coursework.model.user;

import java.util.Date;

public class PHDStudent extends Student{

	public PHDStudent(String iD, 
						String name,
						String email,
						Date startDate, 
						CollaboratorType collaboratorType, String advisor, String courseRegimeType) {
		super(iD, name, email, startDate, collaboratorType, null);
		// TODO Auto-generated constructor stub
	}

}
