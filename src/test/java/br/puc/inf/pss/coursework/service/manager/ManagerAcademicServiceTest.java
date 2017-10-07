package br.puc.inf.pss.coursework.service.manager;

import org.junit.Test;

import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.project.StatusResearchProject;
import br.puc.inf.pss.coursework.model.report.AcademicReport;
import br.puc.inf.pss.coursework.model.report.CollaboratorReport;
import br.puc.inf.pss.coursework.model.report.ReportUtils;
import br.puc.inf.pss.coursework.model.user.Collaborator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import org.junit.Before;


public class ManagerAcademicServiceTest {

	
	ManagerAcademicDataTest managerData = new ManagerAcademicDataTest();
	
	@Before
    public void init() {
		managerData.init();
		
		
	   ManagerAcademicService.manager.addColaborator(managerData.deg1);
	   ManagerAcademicService.manager.addColaborator(managerData.deg2);
	   ManagerAcademicService.manager.addColaborator(managerData.deg3);
	   
	   ManagerAcademicService.manager.addColaborator(managerData.mas4);
	   ManagerAcademicService.manager.addColaborator(managerData.mas5);
	   ManagerAcademicService.manager.addColaborator(managerData.mas6);
	   ManagerAcademicService.manager.addColaborator(managerData.mas7);
	   
	   ManagerAcademicService.manager.addColaborator(managerData.phd8);
	   ManagerAcademicService.manager.addColaborator(managerData.phd9);
	   
	   ManagerAcademicService.manager.addColaborator(managerData.tea10);
	   ManagerAcademicService.manager.addColaborator(managerData.tea11);
	   ManagerAcademicService.manager.addColaborator(managerData.tea12);
	   
	   assertEquals(12, ManagerAcademicService.manager.getCollaborators().size());
	}
	
	
	
	
	@Test
	public void sholdElaborateProject1() {
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		
		
		assertEquals(1, ManagerAcademicService.manager.getProjects().size());
      
		ResearchProject project = ManagerAcademicService.manager.findProject(managerData.proj1.getId());
		
	    assertEquals(project, managerData.proj1);
	    
	    assertEquals(project.getStatus(), StatusResearchProject.IN_PROGRESS);
	    assertEquals(project.getCollaborators().size(), 9);
	    
	    Collaborator col1 = ManagerAcademicService.manager.findCollaborator("100"); 
	    assertEquals(col1.getProjects().get(0).getId(), managerData.proj1.getId());
	    
	    
	}
	
	
	@Test
	public void sholdElaborateProject2() {
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		
		assertEquals(2, ManagerAcademicService.manager.getProjects().size());
		
		ResearchProject project2 = ManagerAcademicService.manager.findProject(managerData.proj2.getId());
		
		assertEquals(project2.getStatus(), StatusResearchProject.IN_PROGRESS);
		assertEquals(project2.getCollaborators().size(), 7);
	    
		Collaborator col1 = ManagerAcademicService.manager.findCollaborator(managerData.deg2.getId()); 
		assertEquals(2, col1.getProjects().size());
		assertEquals(StatusResearchProject.IN_PROGRESS, col1.getProjects().get(0).getStatus());
		assertEquals(StatusResearchProject.IN_PROGRESS, col1.getProjects().get(1).getStatus());
		
	    
	    
	}
	
	
	@Test
	public void sholdElaborateProject3() {
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj3);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj4);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj5);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj55);
		
		assertEquals(5, ManagerAcademicService.manager.getProjects().size());
		
		ResearchProject project2 = ManagerAcademicService.manager.findProject(managerData.proj2.getId());
		ResearchProject project3 = ManagerAcademicService.manager.findProject(managerData.proj3.getId());
		ResearchProject project4 = ManagerAcademicService.manager.findProject(managerData.proj4.getId());
		ResearchProject project5 = ManagerAcademicService.manager.findProject(managerData.proj5.getId());
		ResearchProject project55 = ManagerAcademicService.manager.findProject(managerData.proj55.getId());
		
		
		assertEquals(project2.getStatus(), StatusResearchProject.IN_PROGRESS);
		assertEquals(project3.getStatus(), StatusResearchProject.IN_PROGRESS);
		assertEquals(project4.getStatus(), StatusResearchProject.IN_ELABORATION);
		assertEquals(project5.getStatus(), StatusResearchProject.IN_ELABORATION);
		assertEquals(project55.getStatus(), StatusResearchProject.IN_PROGRESS);
		
		assertEquals(project4.getCollaborators().size(), 8);
		assertEquals(project5.getCollaborators().size(), 6);
		assertEquals(project55.getCollaborators().size(), 6);
		
		Collaborator col1 = ManagerAcademicService.manager.findCollaborator(managerData.deg1.getId()); 
        col1.getProjects();
		
		assertEquals(4, col1.getProjects().size());
		
		assertEquals(StatusResearchProject.IN_PROGRESS, col1.getProjects().get(0).getStatus());
		assertEquals(StatusResearchProject.IN_PROGRESS, col1.getProjects().get(1).getStatus());
		assertEquals(StatusResearchProject.IN_ELABORATION, col1.getProjects().get(2).getStatus());
		assertEquals(StatusResearchProject.IN_ELABORATION, col1.getProjects().get(3).getStatus());
	      
	}
	
	@Test
	public void shouldAddPublication() {
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj3);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj4);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj5);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj55);
		
		
		ResearchProject proj = ManagerAcademicService.manager.findProject("30");
		assertEquals(StatusResearchProject.IN_PROGRESS, proj.getStatus());
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ1);
		
		proj = ManagerAcademicService.manager.findProject("30");
		
		assertEquals(1, ManagerAcademicService.manager.getProductions().size());
		
		assertEquals(StatusResearchProject.CONCLUDED, proj.getStatus());
		
		assertEquals(1, proj.getProductions().size());
		
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori10);
		
		
	   
		assertEquals(2, ManagerAcademicService.manager.getProductions().size());
		
		Collaborator tea10 = ManagerAcademicService.manager.findCollaborator(managerData.tea10.getId());
		assertEquals(2, tea10.getProductions().size());
		//assertEquals(managerData.ori10.getId(), tea10.getProductions().get(0).getId());
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori14);
		assertEquals(2, ManagerAcademicService.manager.getProductions().size());
		
	}
	
	@Test
	public void sortStartDateCollaborator() {
		
		List<Collaborator> cols = ReportUtils.orderDescendingList(ManagerAcademicService.manager.getCollaborators());
		
		for(Collaborator col: cols) {
			
			System.out.println(col.getStartDate().toString());
		}
		
	
	}
	
	
	@Test
	public void shouldCollaboratorReport() {
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj3);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj4);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj5);
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ4);
		
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj55);
		
		
		
		CollaboratorReport report = 
				ManagerAcademicService.manager.generateCollaboratorReport(managerData.deg3.getId());
		
		assertEquals(1, report.projectsConcluded.size());
		assertEquals(2, report.projectsInProgress.size());
		assertEquals(2, report.projectsInElaboration.size());
		
		assertEquals("Mário", report.name);
		
		assertEquals(1, report.projectsConcluded.get(0).getProductions().size());
		
		// "Data 02/10/2010"
		assertEquals("61", report.projectsInProgress.get(0).getId());
		// "Data 02/10/2009"
		assertEquals("40", report.projectsInProgress.get(1).getId());
		
	
	}
	
	@Test
	public void shouldGenerateProjectReport() {
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj3);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj4);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj5);
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ1);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ2);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ3);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ4);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ5);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ6);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ7);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ8);
		
		
		ResearchProject project = ManagerAcademicService.manager.generateResearchProjectReport(managerData.proj1.getId());
		
		assertEquals(9, project.getCollaborators().size());
	    assertEquals("Engenharia de Software para Sistemas Multi-Agentes (ESMA)", project.getTitle());
		//assertEquals(3, project.getProductions().size());
		
		//assertEquals(2006, project.getProductions().get(0).getYear());
		//assertEquals(2005, project.getProductions().get(2).getYear());
	} 
	
	@Test
	public void shouldGenerateAcademicReport() {
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj1);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj2);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj3);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj4);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj5);
		ManagerAcademicService.manager.elaborateResearchProject(managerData.proj55);
		
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ1);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ2);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ3);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ4);
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ5);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ6);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ7);
		ManagerAcademicService.manager.addAcademicProduction(managerData.publ8);
		
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori9);
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori10);
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori11);
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori12);
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori13);
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori14);
		
		
		AcademicReport academicReport = ManagerAcademicService.manager.generateAcademicReport();
		
		assertEquals(12, academicReport.totalCollaborators);
		assertEquals(6, academicReport.totalProjects);
		assertEquals(2 ,academicReport.totalProjectsInElaboration);
		assertEquals(2 ,academicReport.totalProjectsInProgress);
		assertEquals(2 ,academicReport.totalProjectsConcluded);
		
		assertEquals(8, academicReport.totalPublicationProduction);
		assertEquals(5, academicReport.totalOrientationProduction);
		
		
		
		
		
		
	}
	
	
	
}
