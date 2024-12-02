package org.hl7.fhir.r5.utils;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;

// this class exists to allow the Liquid Engine to be used against raw JSON

public class BaseCSVWrapper extends Base {


  private static final long serialVersionUID = 1L;
  private List<String> columns;
  private List<String> values;
  private List<List<String>> rows;
  private String value; 

  private BaseCSVWrapper() {
    super();
  }
  
  public static BaseCSVWrapper forRows(List<String> columns, List<List<String>> rows) {
    BaseCSVWrapper self = new BaseCSVWrapper();
    self.columns = columns;
    self.rows = rows;
    return self;
  }

  public static BaseCSVWrapper forRow(List<String> columns, List<String> values) {
    BaseCSVWrapper self = new BaseCSVWrapper();
    self.columns = columns;
    self.values = values;
    return self;
  }

  public static BaseCSVWrapper forCell(String value) {
    BaseCSVWrapper self = new BaseCSVWrapper();
    self.value = value;
    return self;
  }
  
  @Override
  public String fhirType() {
    if (values != null || rows != null) {
      return "Object";
    } else if (Utilities.existsInList(value, "true", "false")) {
      return "boolean";
    } else if (Utilities.isInteger(value)) {
      return "integer";
    } else if (Utilities.isDecimal(value, true)) {
      return "decimal";
    } else if (Utilities.isAbsoluteUrl(value)) {
      return "url";
    } else {
      return "string";
    }
  }

  @Override
  public String getIdBase() {
    if (columns == null) {
      return null;
    }
    
    int i = columns.indexOf("id");
    if (i > -1) {
      return values.get(i);
    } else {
      return null;
    }
  }

  @Override
  public void setIdBase(String value) {
    throw new Error("BaseCSVWrapper is read only");
  }

  @Override
  public Base copy() {
    throw new Error("BaseCSVWrapper is read only");
  }

  @Override
  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }

  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    if (rows != null && "rows".equals(name)) {
      Base[] l = new Base[rows.size()];
      for (int i = 0; i < rows.size(); i++) {
        l[i] = BaseCSVWrapper.forRow(columns, rows.get(i));
      }
      return l;      
    }
    if (values != null) {
      int i = columns.indexOf(name);
      if (i > -1) {
        Base[] l = new Base[1];
        l[0] = BaseCSVWrapper.forCell(values.get(i));
        return l;
      }
    } 
    return super.getProperty(hash, name, checkValid);
  }

  @Override
  public String toString() {
    return value;
  }
  

  @Override  
  public boolean isPrimitive() {
    return value != null;
  }


  @Override 
  public String primitiveValue() {
    return value;
  }
}
