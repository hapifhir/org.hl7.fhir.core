package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.util.ArrayList;
import java.util.List;

public class StructureMapAnalysis {
  public List<StructureDefinition> profiles = new ArrayList<StructureDefinition>();
  public XhtmlNode summary;

  public List<StructureDefinition> getProfiles() {
    return profiles;
  }

  public XhtmlNode getSummary() {
    return summary;
  }
}
