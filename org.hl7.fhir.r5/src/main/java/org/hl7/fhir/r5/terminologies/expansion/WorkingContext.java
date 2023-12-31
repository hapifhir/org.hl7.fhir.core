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
  private int offset;
  private boolean offs;
  private int count;
  private int total;
  
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
  
  public int getOffset() {
    return offset;
  }
  
  public void setOffset(int offset) {
    this.offs = true;
    this.offset = offset;
  }
  
  public boolean hasOffset() {
    return offs;
  }
  
  public int getCount() {
    return count;
  }
  
  public void setCount(int count) {
    this.count = count;
  }
  
  public int getTotal() {
    return total;
  }
  
  public void setTotal(int total) {
    this.total = total;
  }

  public void incTotal() {
    total++;
  }
  
}