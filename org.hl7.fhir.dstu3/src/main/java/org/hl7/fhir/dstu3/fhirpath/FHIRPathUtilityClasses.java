package org.hl7.fhir.dstu3.fhirpath;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.dstu3.model.Base;
import org.hl7.fhir.exceptions.FHIRException;

public class FHIRPathUtilityClasses {


  public static class ExecutionContext {
    private Object appInfo;
    private Base resource;
    private Base context;
    private Base thisItem;
    private Map<String, Base> aliases;

    public ExecutionContext(Object appInfo, Base resource, Base context, Map<String, Base> aliases, Base thisItem) {
      this.appInfo = appInfo;
      this.context = context;
      this.resource = resource;
      this.aliases = aliases;
      this.thisItem = thisItem;
    }
    public Base getResource() {
      return resource;
    }
    public Base getThisItem() {
      return thisItem;
    }
    public void addAlias(String name, List<Base> focus) throws FHIRException {
      if (aliases == null)
        aliases = new HashMap<String, Base>();
      else
        aliases = new HashMap<String, Base>(aliases); // clone it, since it's going to change
      if (focus.size() > 1)
        throw new FHIRException("Attempt to alias a collection, not a singleton");
      aliases.put(name, focus.size() == 0 ? null : focus.get(0));
    }
    public Base getAlias(String name) {
      return aliases == null ? null : aliases.get(name);
    }
    public Object getAppInfo() {
      return appInfo;
    }
    public Base getContext() {
      return context;
    }
    public Map<String, Base> getAliases() {
      return aliases;
    }
    
  }

  public static class ExecutionTypeContext {
    private Object appInfo;
    private String resource;
    private String context;
    private TypeDetails thisItem;


    public ExecutionTypeContext(Object appInfo, String resource, String context, TypeDetails thisItem) {
      super();
      this.appInfo = appInfo;
      this.resource = resource;
      this.context = context;
      this.thisItem = thisItem;

    }
    public String getResource() {
      return resource;
    }
    public TypeDetails getThisItem() {
      return thisItem;
    }
    public Object getAppInfo() {
      return appInfo;
    }
    public String getContext() {
      return context;
    }
    
    
  }

  public static class FunctionDetails {
    private String description;
    private int minParameters;
    private int maxParameters;
    public FunctionDetails(String description, int minParameters, int maxParameters) {
      super();
      this.description = description;
      this.minParameters = minParameters;
      this.maxParameters = maxParameters;
    }
    public String getDescription() {
      return description;
    }
    public int getMinParameters() {
      return minParameters;
    }
    public int getMaxParameters() {
      return maxParameters;
    }

  }
}
