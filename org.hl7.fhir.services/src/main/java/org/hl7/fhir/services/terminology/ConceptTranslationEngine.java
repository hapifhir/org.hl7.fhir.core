package org.hl7.fhir.services.terminology;

import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.*;

public class ConceptTranslationEngine {
  private final IWorkerContext context;

  public ConceptTranslationEngine(IWorkerContext worker) {
    this.context = worker;
  }

  public Parameters translateCode(String s, ConceptMap cm) {
    Parameters p = new Parameters();
    boolean matched = false;
    for (ConceptMap.ConceptMapGroupComponent grp : cm.getGroupList()) {
      for (ConceptMap.SourceElementComponent src : grp.getElementList()) {
        if (src.getCode().equals(s)) {
          for (ConceptMap.TargetElementComponent tgt : src.getTargetList()) {
            matched = true;
            Parameters.ParametersParameterComponent match = p.addParameter();
            match.setName("match");
            match.addPart().setName("relationship").setValue(new CodeType(tgt.getRelationship().toCode()));
            match.addPart().setName("concept").setValue(new Coding().setCode(tgt.getCode()).setSystem(grp.getTarget()));
            // todo: dependencies and products
          }
        }
      }
    }
    // todo: unmapped
    p.addParameter("result", matched);
    return p;
  }

  public Parameters translateCoding(Coding coding, ConceptMap cm) {
    Parameters p = new Parameters();
    boolean matched = false;
    for (ConceptMap.ConceptMapGroupComponent grp : cm.getGroupList()) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean sourceMatches = grp.getSourceElement().matches(coding.getSystem(), coding.getVersion());
      if (sourceMatches) {
        for (ConceptMap.SourceElementComponent src : grp.getElementList()) {
          if (src.getCode().equals(coding.getCode())) {
            for (ConceptMap.TargetElementComponent tgt : src.getTargetList()) {
              matched = true;
              Parameters.ParametersParameterComponent match = p.addParameter();
              match.setName("match");
              match.addPart().setName("relationship").setValue(new CodeType(tgt.getRelationship().toCode()));
              match.addPart().setName("concept").setValue(new Coding().setCode(tgt.getCode()).setSystem(grp.getTarget()));
              // todo: dependencies and products
            }
          }
        }
      }
    }
    // todo: unmapped
    p.addParameter("result", matched);
    return p;
  }
}
