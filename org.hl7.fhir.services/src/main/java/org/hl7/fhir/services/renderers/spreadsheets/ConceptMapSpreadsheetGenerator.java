package org.hl7.fhir.services.renderers.spreadsheets;

import org.apache.poi.ss.usermodel.Sheet;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.ConceptMap;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.services.renderers.RendererFactory;


public class ConceptMapSpreadsheetGenerator extends CanonicalSpreadsheetGenerator {

  
  public ConceptMapSpreadsheetGenerator(IWorkerContext context, RendererFactory renderer) {
    super(context, renderer);
  }

  public boolean canGenerate(ConceptMap cm) {
    return true;
  }

  public ConceptMapSpreadsheetGenerator renderConceptMap(ConceptMap cm) {
    addConceptMapMetadata(renderCanonicalResource(cm, false), cm);
    int i = 0;
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      renderGroup(grp, i);
      i++;
    }
    return this;
  }

  private void addConceptMapMetadata(Sheet sheet, ConceptMap cm) {
    if (cm.hasSourceScope()) {
      addMetadataRow(sheet, "Source", cm.getSourceScope().primitiveValue());
    }
    if (cm.hasTargetScope()) {
      addMetadataRow(sheet, "Target", cm.getTargetScope().primitiveValue());
    }    
  }

  private void renderGroup(ConceptMapGroupComponent grp, int i) {
    Sheet sheet = makeSheet("Mapping Table "+Integer.toString(i));
    addHeaders(sheet, "Source", "Display", "Relationship", "Target", "Display");
    addRow(sheet, grp.getSource(), "", "", grp.getTarget(), "");
    for (SourceElementComponent s : grp.getElementList()) {
      for (TargetElementComponent t : s.getTargetList()) {
        addRow(sheet, s.getCode(), s.getDisplay(), t.getRelationshipElement().asStringValue(), t.getCode(), t.getDisplay());        
      }
    }    
  }

}
