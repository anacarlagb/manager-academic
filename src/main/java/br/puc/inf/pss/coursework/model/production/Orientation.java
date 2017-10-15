package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;

public class Orientation extends AcademicProduction{

	
	private Collaborator advisor;
	private Collaborator student;
	
	
	@JsonCreator
	public Orientation(@JsonProperty("id") String id, 
			           @JsonProperty("title") String title,
			           @JsonProperty("advisor") Collaborator advisor, 
			           @JsonProperty("student") Collaborator student, 
			           @JsonProperty("authors") List<Collaborator> authors,
			           @JsonProperty("idResearchProject") String idResearchProject,
			           @JsonProperty("year") int year, 
			           @JsonProperty("academicProductionType") AcademicProductionType academicProductionType) {

		super(id, title, authors, idResearchProject, null, year, AcademicProductionType.ORIENTATION);

		this.advisor = advisor;
		this.student = student;
	}

	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return advisor.isCollaboratorType(CollaboratorType.PROFESSOR);
	}

}
