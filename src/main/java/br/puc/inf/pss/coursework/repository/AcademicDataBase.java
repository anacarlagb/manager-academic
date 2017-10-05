package br.puc.inf.pss.coursework.repository;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.production.Orientation;
import br.puc.inf.pss.coursework.model.production.Publication;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.project.StatusResearchProject;
import br.puc.inf.pss.coursework.model.user.Collaborator;
import br.puc.inf.pss.coursework.model.user.Collaborator.CollaboratorType;
import br.puc.inf.pss.coursework.model.user.DegreeStudent;
import br.puc.inf.pss.coursework.model.user.MasterStudent;
import br.puc.inf.pss.coursework.model.user.PHDStudent;
import br.puc.inf.pss.coursework.model.user.Teacher;

public class AcademicDataBase {
	 
	
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
	  public ResearchProject proj55 = null;
	  
	  public AcademicProduction publ1 = null;
	  public AcademicProduction publ2 = null;
	  public AcademicProduction publ3 = null;
	  public AcademicProduction publ4 = null;
	  public AcademicProduction publ5 = null;
	  public AcademicProduction publ6 = null;
	  public AcademicProduction publ7 = null;
	  public AcademicProduction publ8 = null;
	 
	  
	  public AcademicProduction ori9 = null;
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
		phd9 = new PHDStudent("1009", "Bia", "bia@email.br",dataPHD9,CollaboratorType.PHD_STUDENT, "100", "Integral");

		tea10 = new Teacher("100", "Prof. Carlos", "carlos@email.br", null, CollaboratorType.PROFESSOR);	
		tea11 = new Teacher("101", "Prof. Arnaldo", "arnaldo@email.br", null, CollaboratorType.PROFESSOR);
		tea12 = new Teacher("102", "Prof. Paulo", "paulo@email.br", null, CollaboratorType.PROFESSOR);

		//Projects
		Collaborator[] cols1 = {tea10, tea11, deg2, deg3, mas5, mas6, mas7, phd8, phd9};
		List<Collaborator> cols1List = new ArrayList<>();
		cols1List.addAll(Arrays.asList(cols1));
		proj1 = new ResearchProject("20", 
				"Engenharia de Software para Sistemas Multi-Agentes (ESMA)", 
				dataProj1Start, dataProj1End, "FPCL",
				300.000,
				"O objetivo geral deste projeto é desenvolver os fundamentos e as tecnologias da ESSMA",
				"Pesquisar, aplicar e avaliar técnicas de desenvolvimento de software para sistemas multi-agentes..",
			    cols1List,
				StatusResearchProject.IN_PROGRESS);
	
		Collaborator[] cols2 = {tea11, tea10, deg1, deg2, mas4, mas7, phd8};
		List<Collaborator> cols2List = new ArrayList<>();
		cols2List.addAll(Arrays.asList(cols2));
		proj2 = new ResearchProject("30",
				"Engenharia de Software Orientada a Aspectos (ESOA)", 
		         dataProj2Start, dataProj2End, "FPCL", 
		         190.000,
		         "O objetivo geral deste projeto é desenvolver os fundamentos e as tecnologias da ESOA.",
		         "Pesquisar, aplicar e avaliar técnicas de desenvolvimento de software orientado à aspectos..", 
		         cols2List, 
		         StatusResearchProject.CONCLUDED);
	
		
		Collaborator[] cols3 = {tea12, tea11, deg1, deg3, mas5, mas6, mas7, phd9};
		List<Collaborator> cols3List = new ArrayList<>();
		cols3List.addAll(Arrays.asList(cols3));
		proj3 = new ResearchProject("40", 
				"Qualidade de Software",
				dataProj3Start, dataProj3End, "FPCL", 
				100.000,
				"O objetivo deste projeto é desenvolver os fundamentos e as tecnologias para desenvolvimento de software com qualidade.", 
				"Pesquisar, aplicar e avaliar técnicas para qualidade em desenvolvimento de software.", 
				cols3List,
				StatusResearchProject.IN_ELABORATION);
	
		Collaborator[] cols4 = {tea12, tea11, deg1, deg3, mas5, mas6, mas7, phd9};
		List<Collaborator> cols4List = new ArrayList<>();
		cols4List.addAll(Arrays.asList(cols4));
		proj4 = new ResearchProject("50",
				"Model-driven Software Product Lines Development", 
				null, null, "FPCL",
				500.000,
				"O objetivo deste projeto é elaborar técnicas de engenharia de software dirigadas a modelos para o desenvolvimento de linhas de produtos de software.",
				"Pesquisar, aplicar e avaliar técnicas para o desenvolvimento de linhas de produtos de software.",
				cols4List,
				StatusResearchProject.IN_ELABORATION);
	
		Collaborator[] cols5 = {deg1, deg3, mas5, mas6, mas7, phd9};
		List<Collaborator> cols5List = new ArrayList<>();
		cols5List.addAll(Arrays.asList(cols5));
		proj5 = new ResearchProject("60",
			   "Self-organizing Multi-agent Systems",
			   dataProj5Start, dataProj5End, "FPCL",
			   150.000,
			   "O objetivo deste projeto é desenvolver sistemas multi-agentes autoorganizáveis.",
			   "Pesquisar, aplicar e avaliar técnicas para o desenvolvimento de sistemas multi-agentes auto-organizáveis.",
			   cols5List,
			   StatusResearchProject.IN_ELABORATION);
		
		Collaborator[] cols55 = {tea10, deg1, deg3, mas5, mas6, mas7, phd9};
		List<Collaborator> cols55List = new ArrayList<>();
		cols55List.addAll(Arrays.asList(cols55));
		proj55 = new ResearchProject("61",
			   "Self-organizing Multi-agent Systems",
			   dataProj5Start, dataProj5End, "FPCL",
			   150.000,
			   "O objetivo deste projeto é desenvolver sistemas multi-agentes autoorganizáveis.",
			   "Pesquisar, aplicar e avaliar técnicas para o desenvolvimento de sistemas multi-agentes auto-organizáveis.",
			   cols55List,
			   StatusResearchProject.IN_ELABORATION);
	
		//Publications
		Collaborator[] cols11 = {mas4, phd8, tea10};
		List<Collaborator> cols11List = new ArrayList<>();
		cols11List.addAll(Arrays.asList(cols11));
		publ1 = new Publication(null,
				"Abordagem Quantitativa para Desenvolvimento de Software Orientado a Aspectos", 
			     cols11List,
				"SBQS", 2006, "30", null);
	
		Collaborator[] cols12 = {deg1, phd9, tea11};
		List<Collaborator> cols12List = new ArrayList<>();
		cols12List.addAll(Arrays.asList(cols12));
		publ2 = new Publication(null, 
				"Refactoring Product Lines",
				cols12List,
				"GPCE", 2007, null, null);

	
		Collaborator[] cols13 = {mas6, tea12};
		List<Collaborator> cols13List = new ArrayList<>();
		cols13List.addAll(Arrays.asList(cols13));
		publ3 = new Publication(null, 
				"Tratamento de Exceções Sensível ao Contexto",
				cols13List,
				"SBES", 2006, null, null);
	
		Collaborator[] cols14 = {mas6, mas7, tea12};
		List<Collaborator> cols14List = new ArrayList<>();
		cols14List.addAll(Arrays.asList(cols14));
		publ4 = new Publication(null,
				"Integrating MAS in a component-based groupware environment",
				cols14List, 
				"AOSE", 2006, "20", null);
	
		Collaborator[] cols15 = {deg1, phd9, tea10};
		List<Collaborator> cols15List = new ArrayList<>();
		cols15List.addAll(Arrays.asList(cols15));
		publ5 = new Publication(null,
				"Reputation Model Based on Testimonies",
				cols15List,
				"AAMAS", 2006, "20", null);
	
		Collaborator[] cols16 = {phd8};
		List<Collaborator> cols16List = new ArrayList<>();
		cols16List.addAll(Arrays.asList(cols16));
		publ6 = new Publication(null, 
				"Extensions on Interaction Laws in Open Multi-Agent Systems",
				cols16List, 
				"SEAS", 2005, null, null);
	
		Collaborator[] cols17 = {mas4, tea10};
		List<Collaborator> cols17List = new ArrayList<>();
		cols17List.addAll(Arrays.asList(cols17));
	    publ7 = new Publication(null,
				"Aspect-oriented Patterns",
				cols17List,
				"FLOP", 2006, "30", null);
	
	    Collaborator[] cols18 = {tea12, mas7};
		List<Collaborator> cols18List = new ArrayList<>();
		cols18List.addAll(Arrays.asList(cols18));
		publ8 = new Publication(null, 
				"Classifying and Describing Agent Contracts and Norms",
				cols18List,
				"AAMAS", 2005, "20", null);
	
		
		//Orientations
		Collaborator[] cols19 = {tea10, deg1};
		List<Collaborator> cols19List = new ArrayList<>();
		cols19List.addAll(Arrays.asList(cols19));
		ori9 = new Orientation(null,
				"Trablho de Conclusão de Curso: Usabilidade no Portal do Banco do Brasil",
		        tea10, deg1, cols19List, null );
	
		Collaborator[] cols20 = {tea10, mas4};
		List<Collaborator> cols20List = new ArrayList<>();
		cols20List.addAll(Arrays.asList(cols20));
		ori10 = new Orientation(null, 
				"Framework para o Cálculo de Reputação de Agentes",
				tea10, mas4,cols20List, null );
	
		Collaborator[] cols21 = {tea12, mas5};
		List<Collaborator> cols21List = new ArrayList<>();
		cols21List.addAll(Arrays.asList(cols21));
		ori11 = new Orientation(null,
				"Arquitetura para Catálogos de Objetos baseado em Ontologias",
				tea12, mas5,cols21List, null );
	
		Collaborator[] cols22 = {tea12, mas7};
		List<Collaborator> cols22List = new ArrayList<>();
		cols22List.addAll(Arrays.asList(cols22));
		ori12 = new Orientation(null, 
				 "Framework para Smart Cards", 
				 tea12, mas7,cols22List, null);
	
		Collaborator[] cols23 = {tea10, phd9};
		List<Collaborator> cols23List = new ArrayList<>();
		cols23List.addAll(Arrays.asList(cols23));
		ori13 = new Orientation(null,
				"Linguagem de Modelagem para Sistemas baseados em Agentes", 
				tea10, phd9,cols23List, null);
		
		
		Collaborator[] cols24 = {phd8, phd9};
		List<Collaborator> cols24List = new ArrayList<>();
		cols24List.addAll(Arrays.asList(cols24));
		ori14 = new Orientation(null,
				"Linguagem de Modelagem para Sistemas baseados em Agentes", 
				phd8, phd9,cols24List, null);

	}
      
   








	
	
}
