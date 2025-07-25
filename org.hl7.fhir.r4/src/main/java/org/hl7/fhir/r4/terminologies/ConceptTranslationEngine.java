package org.hl7.fhir.r4.terminologies;

import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.model.*;

public class ConceptTranslationEngine {
  private final IWorkerContext context;

  public ConceptTranslationEngine(IWorkerContext worker) {
    this.context = worker;
  }

  public Parameters translateCode(String s, ConceptMap cm) {
    Parameters p = new Parameters();
    boolean matched = false;
    for (ConceptMap.ConceptMapGroupComponent grp : cm.getGroup()) {
      for (ConceptMap.SourceElementComponent src : grp.getElement()) {
        if (src.getCode().equals(s)) {
          for (ConceptMap.TargetElementComponent tgt : src.getTarget()) {
            matched = true;
            Parameters.ParametersParameterComponent match = p.addParameter();
            match.setName("match");
            match.addPart().setName("equivalence").setValue(new CodeType(tgt.getEquivalence().toCode()));
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
    for (ConceptMap.ConceptMapGroupComponent grp : cm.getGroup()) {
      if (grp.getSourceElement().equals(coding.getSystem())) {
        for (ConceptMap.SourceElementComponent src : grp.getElement()) {
          if (src.getCode().equals(coding.getCode())) {
            for (ConceptMap.TargetElementComponent tgt : src.getTarget()) {
              matched = true;
              Parameters.ParametersParameterComponent match = p.addParameter();
              match.setName("match");
              match.addPart().setName("equivalence").setValue(new CodeType(tgt.getEquivalence().toCode()));
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
