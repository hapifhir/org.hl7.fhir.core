package org.hl7.fhir.r5.comparison;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.CanonicalResourceComparer.CanonicalResourceComparison;
import org.hl7.fhir.r5.comparison.CapabilityStatementComparer.CapabilityStatementComparison;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.ResourceComparison;
import org.hl7.fhir.r5.comparison.StructureDefinitionComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.comparison.VersionComparisonAnnotation.AnotationType;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;

public class ComparisonSession {

  
  private Map<String, ResourceComparison> compares = new HashMap<>();
  private IWorkerContext contextLeft;
  private IWorkerContext contextRight;
  private String sessiondId;
  private int count;
  private boolean debug;
  private boolean annotate;
  private String title;
  private ProfileKnowledgeProvider pkpLeft;
  private ProfileKnowledgeProvider pkpRight;
  
  public ComparisonSession(IWorkerContext contextLeft, IWorkerContext contextRight, String title, ProfileKnowledgeProvider pkpLeft, ProfileKnowledgeProvider pkpRight) {
    super();
    this.contextLeft = contextLeft;
    this.contextRight = contextRight;
    this.sessiondId = UUID.randomUUID().toString().toLowerCase();
    this.title = title;
    this.pkpLeft = pkpLeft;
    this.pkpRight = pkpRight;
    debug = false;
  }
  
  public IWorkerContext getContextLeft() {
    return contextLeft;
  }
  
  public IWorkerContext getContextRight() {
    return contextRight;
  }
  
  public String getTitle() {
    return title;
  }

  public ResourceComparison compare(String left, Resource leftSource, String right, Resource rightSource) throws DefinitionException, FHIRFormatError, IOException {
    CanonicalResource l = (CanonicalResource) contextLeft.fetchResource(Resource.class, left, leftSource);
    if (l == null) {
      throw new DefinitionException("Unable to resolve "+left);
    }
    CanonicalResource r = (CanonicalResource) contextRight.fetchResource(Resource.class, right, rightSource);
    if (r == null) {
      throw new DefinitionException("Unable to resolve "+right);
    }
    return compare(l, r);
  }

  public ResourceComparison compare(CanonicalResource left, CanonicalResource right) throws DefinitionException, FHIRFormatError, IOException {
    if (left != null && right != null) {
      String key = key(left.getUrl(), left.getVersion(), right.getUrl(), right.getVersion());
      if (compares.containsKey(key)) {
        // if null then the comparison is in progress.
        // this can happen when profiles refer to each other
        return compares.get(key);
      }
      compares.put(key, null);
      try {
        if (left instanceof CodeSystem && right instanceof CodeSystem) {
          CodeSystemComparer cs = new CodeSystemComparer(this);
          CodeSystemComparison csc = cs.compare((CodeSystem) left, (CodeSystem) right);
          compares.put(key, csc);
          return csc;
        } else if (left instanceof ValueSet && right instanceof ValueSet) {
          ValueSetComparer cs = new ValueSetComparer(this);
          ValueSetComparison csc = cs.compare((ValueSet) left, (ValueSet) right);
          compares.put(key, csc);
          return csc;
        } else if (left instanceof StructureDefinition && right instanceof StructureDefinition) {
          StructureDefinitionComparer cs = new StructureDefinitionComparer(this, new ProfileUtilities(contextLeft, null, pkpLeft), new ProfileUtilities(contextRight, null, pkpRight));
          ProfileComparison csc = cs.compare((StructureDefinition) left, (StructureDefinition) right);
          compares.put(key, csc);
          return csc;
        } else if (left instanceof CapabilityStatement && right instanceof CapabilityStatement) {
          CapabilityStatementComparer cs = new CapabilityStatementComparer(this);
          CapabilityStatementComparison csc = cs.compare((CapabilityStatement) left, (CapabilityStatement) right);
          compares.put(key, csc);
          return csc;
        } else {
          throw new FHIRException("Unable to compare resources of type "+left.fhirType()+" and "+right.fhirType());
        }
      } catch (Throwable e) {
        if (debug) {
          e.printStackTrace();
        }
        ResourceComparer.PlaceHolderComparison csc = new ResourceComparer.PlaceHolderComparison(left, right, e);
        compares.put(key, csc);
        return csc;      
      }
    } else if (left != null) {
      markDeleted(null, left.fhirType(), left); // todo: waht?
      String key = key(left.getUrl(), left.getVersion(), left.getUrl(), left.getVersion());
      if (compares.containsKey(key)) {
        return compares.get(key);
      }
      ResourceComparer.PlaceHolderComparison csc = new ResourceComparer.PlaceHolderComparison(left, right);
      compares.put(key, csc);
      return csc;      
    } else {
      markAdded(right);
      String key = key(right.getUrl(), right.getVersion(), right.getUrl(), right.getVersion());
      if (compares.containsKey(key)) {
        return compares.get(key);
      }
      ResourceComparer.PlaceHolderComparison csc = new ResourceComparer.PlaceHolderComparison(left, right);
      compares.put(key, csc);
      return csc;      
    }
  }

  private String key(String urlL, String verL, String urlR, String verR) {
    return urlL+"|"+verL+"||"+urlR+"|"+verR;
  }
  
  public void identify(CanonicalResource res) {
    count++;
    res.setId(sessiondId+"-"+count);
    res.setUrl("http://hl7.org/fhir/comparison/"+res.fhirType()+"/"+res.getId());
  }

  public void identify(ResourceComparison res) {
    count++;
  }

  public boolean isDebug() {
    return debug;
  }

  public void setDebug(boolean debug) {
    this.debug = debug;
  }

  public Map<String, ResourceComparison> getCompares() {
    return compares;
  }

  public ProfileKnowledgeProvider getPkpLeft() {
    return pkpLeft;
  }
  
  public ProfileKnowledgeProvider getPkpRight() {
    return pkpRight;
  }

  public boolean isAnnotate() {
    return annotate;
  }

  public void setAnnotate(boolean annotate) {
    this.annotate = annotate;
  }

  private VersionComparisonAnnotation getAnnotation(Base b) {
    if (b == null) {
      return null;
    }
    if (b.hasUserData(VersionComparisonAnnotation.USER_DATA_NAME)) {
      return (VersionComparisonAnnotation) b.getUserData(VersionComparisonAnnotation.USER_DATA_NAME);
    } else {
      VersionComparisonAnnotation vca = new VersionComparisonAnnotation(AnotationType.NoChange);
      b.setUserData(VersionComparisonAnnotation.USER_DATA_NAME, vca);
      return vca;
    }
  }

  public void markAdded(Base focus) {
    if (isAnnotate()) {
      getAnnotation(focus).added();
    }
  }

  public void markChanged(Base focus, Base original) {
    if (isAnnotate()) {
      getAnnotation(focus).changed(original);
    }
  }

  public void markDeleted(Base parent, String name, Base other) {
    if (isAnnotate() && other != null) {
      VersionComparisonAnnotation annotation = getAnnotation(parent);
      if (annotation != null) {
        annotation.deleted(name, other);
      }
      annotation = getAnnotation(other);
      if (annotation != null) {
        annotation.deleted();
      }
    }
  }

  public void annotate(Base base, CanonicalResourceComparison<? extends CanonicalResource> comp) {
    if (isAnnotate()) {
      getAnnotation(base).comp(comp);
    }
  }
}