package br.puc.inf.pss.utils;



//
// Source code recreated from a .class file by Framework Play
//
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by clip on 23/09/15.
 * @author : Ana Carla
 */
public class JsonParser {

  private ObjectMapper mapper;

  public JsonParser() {
    this.mapper = new ObjectMapper();
  }

  public JsonParser(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  public <A> A fromJson(JsonNode objectJson, Class<A> object) {
    try {
      return mapper.treeToValue(objectJson, object);
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


  public JsonNode toJson(Object object) {
    return mapper.valueToTree(object);
  }

  public JsonNode parse(String objectString) {
    try{
      return (JsonNode) mapper.readValue(objectString, JsonNode.class);
    }catch (Throwable var2) {
      throw new RuntimeException(var2);
    }
  }
  public <A> A parse(String stringJson, Class<A> object) {
    try {
      JsonNode jsonNode = toJson(stringJson);
      return mapper.treeToValue(jsonNode, object);
    }catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
