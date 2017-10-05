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
	public Orientation(@JsonProperty("iD") String iD, 
			           @JsonProperty("title") String title,
			           @JsonProperty("advisor") Collaborator advisor, 
			           @JsonProperty("student") Collaborator student, 
			           @JsonProperty("authors") List<Collaborator> authors,
			           @JsonProperty("idResearchProject") String idResearchProject) {

		super(iD, title, authors, idResearchProject, null, AcademicProductionType.ORIENTATION);

		this.advisor = advisor;
		this.student = student;
	}

	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return advisor.isCollaboratorType(CollaboratorType.PROFESSOR);
	}

}
