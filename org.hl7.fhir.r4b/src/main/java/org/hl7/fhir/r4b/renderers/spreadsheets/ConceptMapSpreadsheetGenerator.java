package org.hl7.fhir.r4b.renderers.spreadsheets;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.context.SimpleWorkerContext;
import org.hl7.fhir.r4b.model.ConceptMap;
import org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent;

public class ConceptMapSpreadsheetGenerator extends CanonicalSpreadsheetGenerator {

  public ConceptMapSpreadsheetGenerator(IWorkerContext context) {
    super(context);
  }

  public boolean canGenerate(ConceptMap cm) {
    return true;
  }

  public ConceptMapSpreadsheetGenerator renderConceptMap(ConceptMap cm) {
    addConceptMapMetadata(renderCanonicalResource(cm), cm);
    int i = 0;
    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      renderGroup(grp, i);
      i++;
    }
    return this;
  }

  private void addConceptMapMetadata(Sheet sheet, ConceptMap cm) {
    if (cm.hasSource()) {
      addMetadataRow(sheet, "Source", cm.getSource().primitiveValue());
    }
    if (cm.hasTarget()) {
      addMetadataRow(sheet, "Target", cm.getTarget().primitiveValue());
    }
  }

  private void renderGroup(ConceptMapGroupComponent grp, int i) {
    Sheet sheet = makeSheet("Mapping Table " + Integer.toString(i));
    addHeaders(sheet, "Source", "Display", "Relationship", "Target", "Display");
    addRow(sheet, grp.getSource(), "", "", grp.getTarget(), "");
    for (SourceElementComponent s : grp.getElement()) {
      for (TargetElementComponent t : s.getTarget()) {
        addRow(sheet, s.getCode(), s.getDisplay(), t.getEquivalenceElement().asStringValue(), t.getCode(),
            t.getDisplay());
      }
    }
  }

}
