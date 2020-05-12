package org.hl7.fhir.r5.comparison;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.comparison.CodeSystemComparer.CodeSystemComparison;
import org.hl7.fhir.r5.comparison.ProfileComparer.ProfileComparison;
import org.hl7.fhir.r5.comparison.ResourceComparer.ResourceComparison;
import org.hl7.fhir.r5.comparison.ValueSetComparer.ValueSetComparison;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;

public class ComparisonSession {

  private Map<String, ResourceComparison> compares = new HashMap<>();
  private IWorkerContext context;
  private String sessiondId;
  private int count;
  
  public ComparisonSession(IWorkerContext context) {
    super();
    this.context = context;
    this.sessiondId = UUID.randomUUID().toString().toLowerCase();
  }
  
  public IWorkerContext getContext() {
    return context;
  }

  public ResourceComparison compare(String left, String right) throws DefinitionException, FHIRFormatError, IOException {
    CanonicalResource l = (CanonicalResource) context.fetchResource(Resource.class, left);
    if (l == null) {
      throw new DefinitionException("Unable to resolve "+left);
    }
    CanonicalResource r = (CanonicalResource) context.fetchResource(Resource.class, right);
    if (r == null) {
      throw new DefinitionException("Unable to resolve "+right);
    }
    return compare(l, r);
  }

  public ResourceComparison compare(CanonicalResource left, CanonicalResource right) throws DefinitionException, FHIRFormatError, IOException {
    String key = key(left.getUrl(), left.getVersion(), right.getUrl(), right.getVersion());
    if (compares.containsKey(key)) {
      // if null then the comparison is in progress.
      // this can happen when profiles refer to each other
      return compares.get(key);
    }
    compares.put(key, null);
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
      ProfileComparer cs = new ProfileComparer(this);
      ProfileComparison csc = cs.compare((StructureDefinition) left, (StructureDefinition) right);
      compares.put(key, csc);
      return csc;
    } else {
      throw new FHIRException("Unable to compare ");
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
    res.setId(sessiondId+"-"+count);
    
  }
}