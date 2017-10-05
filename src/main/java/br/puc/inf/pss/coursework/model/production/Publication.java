package br.puc.inf.pss.coursework.model.production;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public class Publication extends AcademicProduction{

	
	protected String conferenceName;
	protected int year;
	
	@JsonCreator
	public Publication(@JsonProperty("iD") String iD, 
			           @JsonProperty("title") String title,
			           @JsonProperty("authors") List<Collaborator> authors,
			           @JsonProperty("conferenceName") String conferenceName,
			           @JsonProperty("year") int year,
			           @JsonProperty("researchProjectId") String researchProjectId,
			           @JsonProperty("advisor") Collaborator advisor) {
		
		super(iD, title, authors, researchProjectId, advisor, AcademicProductionType.PUBLICATION);
		this.conferenceName = conferenceName;
		this.year = year;
	}

	@Override
	public boolean validProduction() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
