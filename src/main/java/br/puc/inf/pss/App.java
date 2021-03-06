package br.puc.inf.pss;

import org.jooby.Jooby;
import org.jooby.handlers.CorsHandler;

import br.puc.inf.pss.controller.ManagerAcademicController;
import br.puc.inf.pss.coursework.repository.AcademicDataBase;
import br.puc.inf.pss.coursework.service.manager.ManagerAcademicService;


/**
 * @author jooby generator
 */
public class App extends Jooby {

  {
		AcademicDataBase database = new AcademicDataBase();
		database.init();
		
	   ManagerAcademicService.manager.addColaborator(database.deg1);
	   ManagerAcademicService.manager.addColaborator(database.deg2);
	   ManagerAcademicService.manager.addColaborator(database.deg3);
	   
	   ManagerAcademicService.manager.addColaborator(database.mas4);
	   ManagerAcademicService.manager.addColaborator(database.mas5);
	   ManagerAcademicService.manager.addColaborator(database.mas6);
	   ManagerAcademicService.manager.addColaborator(database.mas7);
	   
	   ManagerAcademicService.manager.addColaborator(database.phd8);
	   ManagerAcademicService.manager.addColaborator(database.phd9);
	   
	   ManagerAcademicService.manager.addColaborator(database.tea10);
	   ManagerAcademicService.manager.addColaborator(database.tea11);
	   
	   ManagerAcademicService.manager.elaborateResearchProject(database.proj1);
	   ManagerAcademicService.manager.elaborateResearchProject(database.proj2);
	   ManagerAcademicService.manager.addAcademicProduction(database.publ1);
	 
	  
	   
	   use(ManagerAcademicController.class);
	   use("*", new CorsHandler());
	

  }

  public static void main(final String[] args) {
	  
	  
    run(App::new, args);
  }

}
