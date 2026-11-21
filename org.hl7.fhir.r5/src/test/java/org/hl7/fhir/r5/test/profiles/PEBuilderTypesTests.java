package org.hl7.fhir.r5.test.profiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.profilemodel.PEBuilder;
import org.hl7.fhir.r5.profilemodel.PEBuilder.PEElementPropertiesPolicy;
import org.hl7.fhir.r5.profilemodel.PEDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
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
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      for (TypeRefComponent tr : ed.getType()) {
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
    StructureDefinition sd = ctxt.fetchTypeDefinition(type).copy();
    assertEquals(List.of(), emptyTypes(sd));
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition(sd);
    walk(pe, 3);
    assertEquals(List.of(), emptyTypes(sd));
  }
}
