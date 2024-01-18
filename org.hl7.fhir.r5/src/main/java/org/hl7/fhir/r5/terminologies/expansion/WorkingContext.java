package org.hl7.fhir.r5.terminologies.expansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;

class WorkingContext {
  private List<ValueSetExpansionContainsComponent> codes = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private List<ValueSetExpansionContainsComponent> roots = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private Map<String, ValueSetExpansionContainsComponent> map = new HashMap<String, ValueSet.ValueSetExpansionContainsComponent>();
  private Set<String> excludeKeys = new HashSet<String>();
  private Set<String> excludeSystems = new HashSet<String>();
  
  private boolean canBeHeirarchy = true;
  private Integer offsetParam;
  private Integer countParam; // allowed count. Because of internal processing, we allow more 
  private int total; // running count. This might be more than actually seen if we call out to an external server and only get the first 1000 codes
  private boolean noTotal; // we lost count of the correct total
  
  public List<ValueSetExpansionContainsComponent> getCodes() {
    return codes;
  }

  public List<ValueSetExpansionContainsComponent> getRoots() {
    return roots;
  }

  public Map<String, ValueSetExpansionContainsComponent> getMap() {
    return map;
  }

  public Set<String> getExcludeKeys() {
    return excludeKeys;
  }

  public Set<String> getExcludeSystems() {
    return excludeSystems;
  }

  public boolean isCanBeHeirarchy() {
    return canBeHeirarchy;
  }

  public void setCanBeHeirarchy(boolean canBeHeirarchy) {
    this.canBeHeirarchy = canBeHeirarchy;
  }
  
  public boolean hasOffsetParam() {
    return offsetParam != null;
  }
  
  public int getOffsetParam() {
    return offsetParam == null ? 0 : offsetParam;
  }
  
  public void setOffsetParam(int offsetParam) {
    this.offsetParam = offsetParam;
  }
  
  public boolean hasCountParam() {
    return countParam != null;
  }
  
  public int getCountParam() {
    return countParam == null ? 0 : countParam;
  }
  
  public void setCountParam(int countParam) {
    this.countParam = countParam;
  }
  
  public int getTotal() {
    return total;
  }

  public void incTotal() {
    total++;
  }

  public void incTotal(int amount) {
    total += amount;
  }

  public boolean isNoTotal() {
    return noTotal;
  }

  public void setNoTotal(boolean noTotal) {
    this.noTotal = noTotal;
  }
  
}