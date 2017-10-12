package br.puc.inf.pss.coursework.model.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.model.user.Collaborator;

public class CollaboratorsReport {
   
	public final String id;
	@JsonManagedReference 
	public final List<Collaborator> collaborators;
	
	@JsonCreator
	public CollaboratorsReport(@JsonProperty("id") String id,
			                   @JsonProperty("collaborators") List<Collaborator> collaborators) {
		this.id = (id == null || id.isEmpty()) ? 
				  String.valueOf(System.currentTimeMillis()) : 
			      id;
		this.collaborators = collaborators;
	}
	
	
}
