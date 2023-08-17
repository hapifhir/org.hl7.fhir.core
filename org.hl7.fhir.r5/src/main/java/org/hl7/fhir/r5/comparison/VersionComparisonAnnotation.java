package org.hl7.fhir.r5.comparison;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.CanonicalResourceComparison;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;

public class VersionComparisonAnnotation {

  public enum AnotationType {
    NoChange, Added, Changed, Deleted;
  }

  public static final String USER_DATA_NAME = "version-annotation";

  private AnotationType type;
  private String original;  
  private Map<String, List<Base>> deletedChildren;
  private CanonicalResourceComparison<? extends CanonicalResource> comp;

  public VersionComparisonAnnotation(AnotationType type) {
    super();
    this.type = type;
  }

  public void added() {
    assert type == AnotationType.NoChange;
    type = AnotationType.Added;    
  }

  public void changed(Base orig) {
    assert type == AnotationType.NoChange;
    type = AnotationType.Changed;
    if (original != null && orig.isPrimitive() && orig.primitiveValue().length() < 120) { // arbitrary, but we don't a whack of markdown 
      this.original = orig.primitiveValue();
    }
  }

  public void deleted() {    
    assert type == AnotationType.NoChange;
    type = AnotationType.Deleted;


  }

  public void deleted(String name, Base other) {
    if (deletedChildren == null) {
      deletedChildren = new HashMap<>();
    }
    if (!deletedChildren.containsKey(name)) {
      deletedChildren.put(name, new ArrayList<>());
    }
    deletedChildren.get(name).add(other);    
  }

  public void comp(CanonicalResourceComparison<? extends CanonicalResource> comp) {
    assert this.comp == null;
    // TODO Auto-generated method stub
    if (!comp.noUpdates()) {
      type = AnotationType.Changed;
    }
    this.comp = comp;
  }

  public static String getUserDataName() {
    return USER_DATA_NAME;
  }

  public AnotationType getType() {
    return type;
  }

  public String getOriginal() {
    return original;
  }

  public Map<String, List<Base>> getDeletedChildren() {
    return deletedChildren;
  }

  public CanonicalResourceComparison<? extends CanonicalResource> getComp() {
    return comp;
  }


  public static boolean hasDeleted(Base base, String... names) {
    boolean result = false;
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      for (String name : names) {
        if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
          result = true;
        }
      }
    }
    return result;
  }

  public static List<Base> getDeleted(Base base, String... names) {
    List<Base> result = new ArrayList<>();
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      for (String name : names) {
        if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
          result.addAll(self.deletedChildren.get(name));
        }
      }
    }
    return result;
  }

  public static Base getDeletedItem(Base base, String name) {
    List<Base> result = new ArrayList<>();
    if (base.hasUserData(USER_DATA_NAME)) {
      VersionComparisonAnnotation self = (VersionComparisonAnnotation) base.getUserData(USER_DATA_NAME);
      if (self.deletedChildren != null && self.deletedChildren.containsKey(name))  {
        result.addAll(self.deletedChildren.get(name));
      }
    }
    return result.isEmpty() ? null : result.get(0);
  }

}