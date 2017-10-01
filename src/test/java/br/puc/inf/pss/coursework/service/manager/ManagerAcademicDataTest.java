package br.puc.inf.pss.coursework.service.manager;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.Orientation;
import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.model.user.DegreeStudent;
import br.puc.inf.pss.coursework.model.user.MasterStudent;
import br.puc.inf.pss.coursework.model.user.PHDStudent;
import br.puc.inf.pss.coursework.model.user.Teacher;
import br.puc.inf.pss.model.project.ResearchProject;
import br.puc.inf.pss.model.project.StatusResearchProject;
import edu.emory.mathcs.backport.java.util.Arrays;

public class ManagerAcademicDataTest {
	 
	
	  Date dataDeg1 = null;
	  Date dataDeg2 = null;
	  Date dataDeg3 = null;
	  public Collaborator deg1 = null;
	  public Collaborator deg2 = null;
	  public Collaborator deg3 = null;
	  
	  
	  Date dataMas4 = null;
	  Date dataMas5 = null;
	  Date dataMas6 = null;
	  Date dataMas7 = null;
	  public Collaborator mas4 = null;
	  public Collaborator mas5 = null;
	  public Collaborator mas6 = null;
	  public Collaborator mas7 = null;
	  
	  Date dataPHD8 = null;
	  Date dataPHD9 = null;
	  public Collaborator phd8 = null;
	  public Collaborator phd9 = null;
	  
	  public Collaborator tea10 = null;
	  public Collaborator tea11 = null;
	  public Collaborator tea12 = null;
	  
	  
	  Date dataProj1Start = null;
	  Date dataProj1End = null;
	  public ResearchProject proj1 = null;
	  
	  Date dataProj2Start = null;
	  Date dataProj2End = null;
	  public ResearchProject proj2 = null;
	  
	  Date dataProj3Start = null;
	  Date dataProj3End = null;
	  public ResearchProject proj3 = null;
	  
	  Date dataProj4Start = null;
	  Date dataProj4End = null;
	  public ResearchProject proj4 = null;
	  
	  Date dataProj5Start = null;
	  Date dataProj5End = null;
	  public ResearchProject proj5 = null;
	  
	  public AcademicProduction publ1 = null;
	  public AcademicProduction publ2 = null;
	  public AcademicProduction publ3 = null;
	  public AcademicProduction publ4 = null;
	  public AcademicProduction publ5 = null;
	  public AcademicProduction publ6 = null;
	  public AcademicProduction publ7 = null;
	  public AcademicProduction publ8 = null;
	  public AcademicProduction publ9 = null;
	  
	  public AcademicProduction ori10 = null;
	  public AcademicProduction ori11 = null;
	  public AcademicProduction ori12 = null;
	  public AcademicProduction ori13 = null;
	  public AcademicProduction ori14 = null;
	  
	public void init() {
	  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	  
		try {
			dataDeg1 = formatter.parse("01/03/2005");
	  		dataDeg2 = formatter.parse("01/03/2006"); 
	  		dataDeg3 = formatter.parse("01/03/2007");
	  		
	  		dataMas4 = formatter.parse("01/03/2006"); 
	  		dataMas5 = formatter.parse("01/06/2007"); 
	  		dataMas6 = formatter.parse("01/06/2007"); 
	  		dataMas7 = formatter.parse("01/03/2006"); 
	  		
	  	    dataPHD8  = formatter.parse("01/03/2005");
	  	    dataPHD9  = formatter.parse("01/06/2004");
	  	    
	  	    
	  	    dataProj1Start = formatter.parse("02/02/2003");
		    dataProj1End = formatter.parse("02/02/2010");
		  
		    dataProj2Start = formatter.parse("02/02/2005");
		    dataProj2End = formatter.parse("02/12/2011");
		  
		    dataProj3Start = formatter.parse("02/05/2006");
		    dataProj3End = formatter.parse("02/10/2009");
		  
		    dataProj5Start = formatter.parse("15/07/2008");
		    dataProj5End = formatter.parse("02/10/2010");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		//Degree Students
		 
		deg1 = new DegreeStudent("1001", "Maria", "maria@email.br", dataDeg1,CollaboratorType.DEGREE_STUDENT,"100");
		deg2 = new DegreeStudent("1002", "João", "joao@email.br", dataDeg2, CollaboratorType.DEGREE_STUDENT, "101");
		deg3 = new DegreeStudent("1003", "Mário", "mario@email.br", dataDeg3, CollaboratorType.DEGREE_STUDENT,"101");

		//Master Students
		mas4 = new MasterStudent("1004", "Soraia", "soraia@email.br", dataMas4,CollaboratorType.MASTER_STUDENT, "100", "Parcial");
		mas5 = new MasterStudent("1005", "Rafael", "rafael@email.br", dataMas5,CollaboratorType.MASTER_STUDENT, "102", "Parcial");
        mas6 = new MasterStudent("1006", "Marta", "marta@email.br", dataMas6,CollaboratorType.MASTER_STUDENT, "102", "Integral");
        mas7 = new MasterStudent("1007", "Daniel", "daniel@email.br", dataMas7,CollaboratorType.MASTER_STUDENT, "102", "Integral");

        //PHD Students
		phd8 = new PHDStudent("1008", "Michael", "michael@email.br", dataPHD8, CollaboratorType.PHD_STUDENT,"100", "Integral");
		phd9 = new PHDStudent("1009", "Bia", "bia@email.br",dataPHD9,CollaboratorType.DEGREE_STUDENT, "100", "Integral");

		tea10 = new Teacher("100", "Prof. Carlos", "carlos@email.br", null, CollaboratorType.TEACHER);	
		tea11 = new Teacher("101", "Prof. Arnaldo", "arnaldo@email.br", null, CollaboratorType.TEACHER);
		tea12 = new Teacher("102", "Prof. Paulo", "paulo@email.br", null, CollaboratorType.TEACHER);

		//Projects
		proj1 = new ResearchProject("20", 
				"Engenharia de Software para Sistemas Multi-Agentes (ESMA)", 
				dataProj1Start, dataProj1End, "FPCL",
				300.000,
				"O objetivo geral deste projeto é desenvolver os fundamentos e as tecnologias da ESSMA",
				"Pesquisar, aplicar e avaliar técnicas de desenvolvimento de software para sistemas multi-agentes..",
				Arrays.asList(new String[] {"100", "101", "1002", "1003", "1005", "1006", "1007", "1008", "1009"}),
				StatusResearchProject.IN_PROGRESS);
	
		proj2 = new ResearchProject("30",
				"Engenharia de Software Orientada a Aspectos (ESOA)", 
		         dataProj2Start, dataProj2End, "FPCL", 
		         190.000,
		         "O objetivo geral deste projeto é desenvolver os fundamentos e as tecnologias da ESOA.",
		         "Pesquisar, aplicar e avaliar técnicas de desenvolvimento de software orientado à aspectos..", 
		         Arrays.asList(new String[] {"101", "100", "1001", "1002", "1004", "1007", "1008"}), 
		         StatusResearchProject.CONCLUDED);
	
		proj3 = new ResearchProject("40", 
				"Qualidade de Software",
				dataProj3Start, dataProj3End, "FPCL", 
				100.000,
				"O objetivo deste projeto é desenvolver os fundamentos e as tecnologias para desenvolvimento de software com qualidade.", 
				"Pesquisar, aplicar e avaliar técnicas para qualidade em desenvolvimento de software.", 
				Arrays.asList( new String[] {"102", "101", "1001", "1003", "1005", "1006", "1007", "1009"}),
				StatusResearchProject.IN_ELABORATION);
	
		proj4 = new ResearchProject("50",
				"Model-driven Software Product Lines Development", 
				null, null, "FPCL",
				500.000,
				"O objetivo deste projeto é elaborar técnicas de engenharia de software dirigadas a modelos para o desenvolvimento de linhas de produtos de software.",
				"Pesquisar, aplicar e avaliar técnicas para o desenvolvimento de linhas de produtos de software.",
				Arrays.asList(new String[] {"102", "101", "1001", "1003", "1005", "1006", "1007", "1009"}),
				StatusResearchProject.IN_ELABORATION);
	
		proj5 = new ResearchProject("60",
			   "Self-organizing Multi-agent Systems",
			   dataProj5Start, dataProj5End, "FPCL",
			   150.000,
			   "O objetivo deste projeto é desenvolver sistemas multi-agentes autoorganizáveis.",
			   "Pesquisar, aplicar e avaliar técnicas para o desenvolvimento de sistemas multi-agentes auto-organizáveis.",
			   Arrays.asList(new String[] {"1001", "1003", "1005", "1006", "1007", "1009"}),
			   StatusResearchProject.IN_ELABORATION);
	
		//Publications
		publ1 = new Publication(null,
				"Abordagem Quantitativa para Desenvolvimento de Software Orientado a Aspectos", 
			     Arrays.asList(new String[] {"1004", "1008", "100"}),
				"SBQS", 2006, "30", null);
	
		publ2 = new Publication(null, 
				"Refactoring Product Lines",
				Arrays.asList(new String[] {"1001", "1009", "101"}),
				"GPCE", 2007, null, null);
	
		publ3 = new Publication(null, 
				"Tratamento de Exceções Sensível ao Contexto",
				Arrays.asList(new String[] {"1006", "1021"}),
						"SBES", 2006, null, null);
	
		publ4 = new Publication(null, 
				"Tratamento de Exceções Sensível ao Contexto",
				Arrays.asList(new String[] {"1006", "1021"}),
				"SBES", 2006, null, null);
	
		publ5 = new Publication(null,
				"Integrating MAS in a component-based groupware environment",
				Arrays.asList(new String[] {"1006", "1007", "102"}), 
				"AOSE", 2006, "20", null);
	
		publ6 = new Publication(null,
				"Reputation Model Based on Testimonies",
				Arrays.asList(new String[] {"1001", "1009", "100"}),
				"AAMAS", 2006, "20", null);
	
		publ7 = new Publication(null, 
				"Extensions on Interaction Laws in Open Multi-Agent Systems",
				Arrays.asList(new String[] {"1008"}), 
				"SEAS", 2005, null, null);
	
	    publ8 = new Publication(null,
				"Aspect-oriented Patterns",
				Arrays.asList(new String[] {"1004", "100"}),
				"FLOP", 2006, "30", null);
	
		publ9 = new Publication(null, 
				"Classifying and Describing Agent Contracts and Norms",
				Arrays.asList(new String[] {"1002", "1007"}),
				"AAMAS", 2005, "20", null);
	
		
		//Orientations
		ori10 = new Orientation(null,
				"Trablho de Conclusão de Curso: Usabilidade no Portal do Banco do Brasil",
		        "100", "1001", Arrays.asList(new String[] {"100", "1001"}), null );
	
		ori11 = new Orientation(null, 
				"Framework para o Cálculo de Reputação de Agentes",
				"100", "1004",Arrays.asList(new String[] {"100", "1004"}), null );
	
		ori12 = new Orientation(null,
				"Arquitetura para Catálogos de Objetos baseado em Ontologias",
				"102", "1005",Arrays.asList(new String[] {"102", "1005"}), null );
	
		ori13 = new Orientation(null, 
				 "Framework para Smart Cards", 
				 "102", "1007",Arrays.asList(new String[] {"102", "1007"}), null);
	
		ori14 = new Orientation(null,
				"Linguagem de Modelagem para Sistemas baseados em Agentes", 
				"100", "1009",Arrays.asList(new String[] {"100", "1009"}), null);

	}
      
   








	
	
}
