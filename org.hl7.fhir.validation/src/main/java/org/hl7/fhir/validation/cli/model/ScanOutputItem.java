package org.hl7.fhir.validation.cli.model;

import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.StructureDefinition;

public class ScanOutputItem {
  private String ref;
  private ImplementationGuide ig;
  private StructureDefinition profile;
  private OperationOutcome outcome;
  private String id;

  public ScanOutputItem(String ref, ImplementationGuide ig, StructureDefinition profile, OperationOutcome outcome) {
    super();
    this.ref = ref;
    this.ig = ig;
    this.profile = profile;
    this.outcome = outcome;
  }

  public String getRef() {
    return ref;
  }

  public ImplementationGuide getIg() {
    return ig;
  }

  public StructureDefinition getProfile() {
    return profile;
  }

  public OperationOutcome getOutcome() {
    return outcome;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    if (profile != null)
      return "Validate " + ref + " against " + profile.present() + " (" + profile.getUrl() + ")";
    if (ig != null)
      return "Validate " + ref + " against global profile specified in " + ig.present() + " (" + ig.getUrl() + ")";
    return "Validate " + ref + " against FHIR Spec";
  }
}