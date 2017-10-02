package br.puc.inf.pss.coursework.service.manager;

import org.junit.Test;

import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.model.project.ResearchProject;
import br.puc.inf.pss.model.project.StatusResearchProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.apache.maven.project.artifact.ProjectArtifact;
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
		
		assertEquals(1, proj.getPublications().size());
		
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori10);
		
		
	   
		assertEquals(2, ManagerAcademicService.manager.getProductions().size());
		
		Collaborator tea10 = ManagerAcademicService.manager.findCollaborator(managerData.tea10.getId());
		assertEquals(1, tea10.getProductions().size());
		assertEquals(managerData.ori10.getId(), tea10.getProductions().get(0).getId());
		
		ManagerAcademicService.manager.addAcademicProduction(managerData.ori14);
		assertEquals(2, ManagerAcademicService.manager.getProductions().size());
		
	}
	
	
	
}
