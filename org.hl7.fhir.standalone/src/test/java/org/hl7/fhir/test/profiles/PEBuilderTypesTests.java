package org.hl7.fhir.test.profiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.profilemodel.PEBuilder;
import org.hl7.fhir.services.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.services.profilemodel.PEDefinition;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Walking a profile reads it: it doesn't change it. getTypeFirstRep() adds an empty type to an element that has none
 * (the root, or one with a contentReference), and an empty type then appears in the definition wherever it goes next
 * (rendered, or written out)
 */
class PEBuilderTypesTests {

  private static void walk(PEDefinition pe, int depth) {
    if (depth > 0 && pe.types().size() == 1) {
      for (PEDefinition child : pe.children()) {
        walk(child, depth - 1);
      }
    }
  }

  private static List<String> emptyTypes(StructureDefinition sd) {
    List<String> res = new ArrayList<>();
    for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
      for (TypeRefComponent tr : ed.getTypeList()) {
        if (!tr.hasCode()) {
          res.add(ed.getId());
        }
      }
    }
    return res;
  }

  @ParameterizedTest
  @ValueSource(strings = {"Observation", "Questionnaire", "Extension"})
  void walkingAProfileAddsNoTypes(String type) {
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    StructureDefinition sd = ctxt.fetchTypeDefinition(type).copy(org.hl7.fhir.model.Base.COPY_NOTHING);
    assertEquals(List.of(), emptyTypes(sd));
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition(sd);
    walk(pe, 3);
    assertEquals(List.of(), emptyTypes(sd));
  }
}
