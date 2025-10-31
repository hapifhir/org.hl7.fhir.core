package org.hl7.fhir.r5.terminologies.expansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
class WorkingContext {
  private List<ValueSetExpansionContainsComponent> codes = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private List<ValueSetExpansionContainsComponent> roots = new ArrayList<ValueSet.ValueSetExpansionContainsComponent>();
  private Map<String, ValueSetExpansionContainsComponent> map = new HashMap<String, ValueSet.ValueSetExpansionContainsComponent>();
  private Map<String, ValueSetExpansionContainsComponent> rootMap = new HashMap<String, ValueSet.ValueSetExpansionContainsComponent>();
  private Set<String> excludeKeys = new HashSet<String>();
  private Set<String> excludeSystems = new HashSet<String>();
  
  private boolean canBeHierarchy = true;
  private Integer offsetParam;
  private Integer countParam; // allowed count. Because of internal processing, we allow more 
  
  // running count. This might be more than actually seen if we call out to an external server and only get the first 1000 codes
  private int extraCount;
  private List<String> countIncompleteSystems = new ArrayList<>(); // because we saw some of something we depend on, and then we lose control if we see anything else in the same system 
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

  public Map<String, ValueSetExpansionContainsComponent> getRootMap() {
    return rootMap;
  }

  public Set<String> getExcludeKeys() {
    return excludeKeys;
  }

  public Set<String> getExcludeSystems() {
    return excludeSystems;
  }

  public boolean isCanBeHierarchy() {
    return canBeHierarchy;
  }

  public void setCanBeHierarchy(boolean canBeHierarchy) {
    this.canBeHierarchy = canBeHierarchy;
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
  
  public int getExtraCount() {
    return extraCount;
  }

  public void incExtraCount() {
    extraCount++;
  }

  public void incExtraCount(int amount) {
    extraCount += amount;
  }

  public void resetExtraCount() {
    extraCount = 0;
  }
  
  public boolean isNoTotal() {
    return noTotal;
  }

  public void setNoTotal(boolean noTotal) {
    this.noTotal = noTotal;
  }

  public int getCount() {
    return codes.size();
  }

  public int getStatedTotal() {
    return codes.size() + extraCount;
  }

  public List<String> getCountIncompleteSystems() {
    return countIncompleteSystems;
  }

}