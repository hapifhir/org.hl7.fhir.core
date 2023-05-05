package org.hl7.fhir.r5.terminologies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.model.Enumerations.FHIRVersion;

public class TerminologyServerDetails {
  public enum ServerAuthorizationMethod {
    OPEN,
    TOKEN, 
    SMART_ON_FHIR
  }
  private String name;
  private ServerAuthorizationMethod auth;
  private Map<FHIRVersion, String> endpoints = new HashMap<>();
  private List<String> codeSystems = new ArrayList<>();
  
  public boolean handlesSystem(String uri, String version) {
    for (String s : codeSystems) {
      if (s.contains("|")) {
        String u = s.substring(0, s.lastIndexOf("|"));
        String v = s.substring(s.lastIndexOf("|")+1);
        if (v.equals(version) && (s.equals(uri) || uri.matches(s))) {
          return true;
        }
      } else {
        if (s.equals(uri) || uri.matches(s)) {
          return true;
        }
      }
    }
    return false;
  }

  public String getName() {
    return name;
  }

  public ServerAuthorizationMethod getAuth() {
    return auth;
  }

  public Map<FHIRVersion, String> getEndpoints() {
    return endpoints;
  }

  public List<String> getCodeSystems() {
    return codeSystems;
  }
  
  
}
