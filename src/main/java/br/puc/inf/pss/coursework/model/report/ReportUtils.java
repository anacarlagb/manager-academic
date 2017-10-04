package br.puc.inf.pss.coursework.model.report;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.user.Collaborator;

public class ReportUtils {

	
	
	public static List<Collaborator> orderDescendingList(List<Collaborator> cols){
		
		Collections.sort(cols, new Comparator<Collaborator>() {
			
			@Override
			public int compare(Collaborator arg0, Collaborator arg1) {
				// TODO Auto-generated method stub
				if (arg0.getStartDate() == null || arg1.getStartDate() == null){
			                return 0;
		  		}
				else {
				    if (arg0.getStartDate().after(arg1.getStartDate()))
						return -1;
					else
						return 1;
			   }
			 }
		 });
		
		
		return cols;
	}
	
	
	
     public static List<ResearchProject> sortProjects(List<ResearchProject> projects){
		
		Collections.sort(projects, new Comparator<ResearchProject>() {
			
			@Override
			public int compare(ResearchProject arg0, ResearchProject arg1) {
				// TODO Auto-generated method stub
				if (arg0.getEndDate() == null || arg1.getEndDate() == null){
			                return 0;
		  		}
				else {
				    if (arg0.getEndDate().after(arg1.getEndDate())) {
				    	return -1;
				    }
					else {
						return 1;
					}
						
			   }
			 }
		 });
		
		
		return projects;
	}
     
     
     public static List<AcademicProduction> sortProductions(List<AcademicProduction> productions){
 		
 		Collections.sort(productions, new Comparator<AcademicProduction>() {
 			
 			@Override
 			public int compare(AcademicProduction arg0, AcademicProduction arg1) {
 				// TODO Auto-generated method stub
 				if(arg0.getYear() ==  arg0.getYear()) {
 					return 0;
 				}
 				if (arg0.getYear() > arg0.getYear()) {
			    	return -1;
			    }
				else {
					return 1;
				}
 						
 			 }
 		 });
 		
 		return productions;
 	} 
}
