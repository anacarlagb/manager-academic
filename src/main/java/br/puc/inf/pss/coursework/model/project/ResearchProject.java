package br.puc.inf.pss.coursework.model.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.report.ReportUtils;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.service.manager.Alocation;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class ResearchProject{
	
	private String id;
	private String title;
	private Date startDate;
	private Date endDate;
	private String fundingInstitutionName;
	private Double fundingValue;
	private String goal;
	private String description;
	private List<Collaborator> collaborators;
	private List<AcademicProduction> productions;
	private StatusResearchProject status;
	
	
    @JsonCreator	
	public ResearchProject(@JsonProperty("id") String id, 
			               @JsonProperty("title") String title, 
			               @JsonProperty("startDate") Date startDate,  
			               @JsonProperty("endDate") Date endDate,
			               @JsonProperty("fundingInstitutionName") String fundingInstitutionName, 
			               @JsonProperty("fundingValue") Double fundingValue, 
			               @JsonProperty("goal") String goal, 
			               @JsonProperty("description") String description,
			               @JsonProperty("collaborators") List<Collaborator> collaborators,
			               @JsonProperty("status") StatusResearchProject status) {

    	this.id = (id == null || id.isEmpty()) ? 
				  String.valueOf(System.currentTimeMillis()) : 
			      id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fundingInstitutionName = fundingInstitutionName;
		this.fundingValue = fundingValue;
		this.goal = goal;
		this.description = description;
		this.collaborators = collaborators;
		this.status = status;
		this.productions = new ArrayList<>();
	
	
	}

		

	public StatusResearchProject getStatus() {
		return status;
	}
	
	public void setStatus(StatusResearchProject status) {
		this.status = status;
	}
	
	public void addPublication(AcademicProduction publication) {
	
		if(status.equals(StatusResearchProject.IN_PROGRESS)) {
		   productions.add(publication);
		   status = StatusResearchProject.CONCLUDED;
		}
		
		
			
	}
	
	
	public List<Collaborator> alocateCollaborators(List<Collaborator> collaboratorsList) {
		// TODO Auto-generated method stub
		
		boolean hasProfessor = false;
		List<Collaborator> tempCollaborators = new ArrayList<>();
		
		//validation collaborators
		for(Collaborator collaborator: collaboratorsList) {
			
			  if(status.equals(StatusResearchProject.IN_PROGRESS)
					  && collaborator.isCollaboratorType(CollaboratorType.DEGREE_STUDENT)){
				
				  if(collaborator.validateAlocation()) {
					 tempCollaborators.add(collaborator); 
				 }
			  }else {
				  tempCollaborators.add(collaborator); 
			  }
			

		}
		
		//if collaborators are valid, so add list
	    collaborators.addAll(tempCollaborators);		
		return collaborators;
	    	
	}


	public List<AcademicProduction> getProductions() {
		return productions;
	}

    @JsonIgnore
	public boolean isElaboration() {
		// TODO Auto-generated method stub
		
		return (title == null || title.isEmpty())     
			  ||startDate == null 
			  ||endDate == null   
			  ||fundingInstitutionName == null
			  ||fundingValue  == null
			  ||(goal == null || goal.isEmpty())
			  ||(description == null || description.isEmpty())
			  ||(collaborators == null || collaborators.isEmpty())
			  || (!hasProfessor());
		    

		
	}




	public List<Collaborator> getCollaborators() {
		return collaborators;
	}



	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}



	public boolean hasProfessor() {
		// TODO Auto-generated method stub
		
	
		for (Collaborator collaborator : collaborators) {
			
			if(collaborator.isCollaboratorType(CollaboratorType.PROFESSOR)) {
				return true;
			}
		}
		return false;
	}



	public Date getEndDate() {
		return endDate;
	}



	public void sortProductions() {
		// TODO Auto-generated method stub
		ReportUtils.sortProductions(productions);
	}



	public String getTitle() {
		return title;
	}



	public Date getStartDate() {
		return startDate;
	}



	public String getFundingInstitutionName() {
		return fundingInstitutionName;
	}



	public Double getFundingValue() {
		return fundingValue;
	}



	public String getGoal() {
		return goal;
	}



	public String getDescription() {
		return description;
	}
	
	
	
	
	
	



	
	
	
}
