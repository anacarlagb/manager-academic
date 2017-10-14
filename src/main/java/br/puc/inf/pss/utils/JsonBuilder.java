package br.puc.inf.pss.utils;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

import br.puc.inf.pss.coursework.model.production.AcademicProduction;
import br.puc.inf.pss.coursework.model.project.ResearchProject;
import br.puc.inf.pss.coursework.model.user.Collaborator;

public class JsonBuilder {

	public static JSONObject buildProjects(List<ResearchProject> projects) {
	
		JSONObject projectsJson = new JSONObject();
	    
	    JSONArray projectsArray = new JSONArray();
		for (ResearchProject project : projects) {
			try {
				JSONObject projectJson = new JSONObject();
				projectJson.put("id", project.getId());
				projectJson.put("title", project.getTitle());
				projectsArray.put(projectJson);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			projectsJson.put("projects", projectsArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return projectsJson;
		

	}

	public static JSONObject buildProductions(List<AcademicProduction> productions) {
		// TODO Auto-generated method stub
		JSONObject productionsJson = new JSONObject();
	    
	    JSONArray productionsArray = new JSONArray();
		for (AcademicProduction production : productions) {
			try {
				JSONObject productionJson = new JSONObject();
				productionJson.put("id", production.getId());
				productionJson.put("title", production.getTitle());
				productionJson.put("year", production.getYear());
				productionJson.put("type", production.getAcademicProductionType());
				
				String authors = "";
				for(Collaborator author: production.getAuthors()) {
					authors += author.name + "; ";
				}

				productionJson.put("authors", authors);
				productionsArray.put(productionJson);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			productionsJson.put("productions", productionsArray);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productionsJson;
	}

}
