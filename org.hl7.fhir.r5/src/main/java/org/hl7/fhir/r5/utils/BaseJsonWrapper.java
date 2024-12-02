package org.hl7.fhir.r5.utils;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;

// this class exists to allow the Liquid Engine to be used against raw JSON

public class BaseJsonWrapper extends Base {

  private static final long serialVersionUID = 1L;
  private JsonElement j;
  
  public BaseJsonWrapper(JsonElement j) {
    super();
    this.j = j;
  }

  @Override
  public String fhirType() {
    switch (j.type()) {
    case BOOLEAN: return "boolean";
    case NUMBER: return "decimal";
    case OBJECT: return "Object";
    case STRING: return "string";
    default:
      throw new Error("Shouldn't get here");
    }
  }

  @Override
  public String getIdBase() {
    if (j.isJsonObject()) {
      return j.asJsonObject().asString("id");
    } else {
      return null;
    }
  }

  @Override
  public void setIdBase(String value) {
    throw new Error("BaseJsonWrapper is read only");
  }

  @Override
  public Base copy() {
    throw new Error("BaseJsonWrapper is read only");
  }

  @Override
  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }

  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    if (j.isJsonObject() && j.asJsonObject().has(name)) {
      JsonElement e = j.asJsonObject().get(name);
      if (e.isJsonArray()) {
        JsonArray a = e.asJsonArray();
        Base[] l = new Base[a.size()];
        for (int i = 0; i < a.size(); i++) {
          l[i] = new BaseJsonWrapper(a.get(i));
        }
        return l;        
      } else {
        Base[] l = new Base[1];
        l[0] = new BaseJsonWrapper(e);
        return l;
      }
    } else {
      return super.getProperty(hash, name, checkValid);
    }
  }

  @Override
  public String toString() {
    if (j.isJsonPrimitive()) {
      return j.asString();
    } else {
      return super.toString();
    }
  }
  
  
}
