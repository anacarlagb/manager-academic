package br.puc.inf.pss.coursework.service.manager;

import org.junit.Test;

import junit.framework.Assert;

public class ManagerAcademicServiceTest {

	
	ManagerAcademicDataTest managerData = new ManagerAcademicDataTest();
	
	
	
	@Test
	public void sholdAddCollaborator() {
	   ManagerAcademicService.manager.addColaborator(managerData.deg1);
	   ManagerAcademicService.manager.addColaborator(managerData.deg2);
	   ManagerAcademicService.manager.addColaborator(managerData.deg3);
	   
	   ManagerAcademicService.manager.addColaborator(managerData.mas4);
	   ManagerAcademicService.manager.addColaborator(managerData.mas5);
	   ManagerAcademicService.manager.addColaborator(managerData.mas6);
	   ManagerAcademicService.manager.addColaborator(managerData.mas7);
	   
	   ManagerAcademicService.manager.addColaborator(managerData.phd8);
	   ManagerAcademicService.manager.addColaborator(managerData.phd9);
	   
	   
	   Assert.assertEquals(ManagerAcademicService.manager.getCollaborators().size(), 9);
	 }
	
}
