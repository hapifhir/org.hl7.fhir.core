package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class SourceElementComponentWrapper {
  private ConceptMap.ConceptMapGroupComponent group;
  private ConceptMap.SourceElementComponent comp;

  public SourceElementComponentWrapper(ConceptMap.ConceptMapGroupComponent group, ConceptMap.SourceElementComponent comp) {
    super();
    this.group = group;
    this.comp = comp;
  }

  public ConceptMap.ConceptMapGroupComponent getGroup() {
    return group;
  }

  public ConceptMap.SourceElementComponent getComp() {
    return comp;
  }
}
