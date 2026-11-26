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

  /**
   * QuestionnaireResponse: item.item and item.answer.item are contentReferences, so have no type; walking into them
   * (as rendering the -expansion view of a profile does) mustn't give them one
   */
  @ParameterizedTest
  @ValueSource(strings = {"Observation", "Questionnaire", "QuestionnaireResponse", "Extension"})
  void walkingAProfileAddsNoTypes(String type) {
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    StructureDefinition sd = ctxt.fetchTypeDefinition(type).copy();
    assertEquals(List.of(), emptyTypes(sd));
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition(sd);
    walk(pe, 4);
    assertEquals(List.of(), emptyTypes(sd));
  }

  /**
   * Not just types: walking a profile 4 levels deep changes nothing at all, in the profile or in any of the definitions
   * of the types it walks into, which are the context's own (shared by everything that uses the context). Each is
   * compared before and after by shape(), which sees what a getter adds (a type, slicing, a binding, a base) even when
   * it's empty: JSON and XML leave out an empty object, so comparing them doesn't
   */
  @ParameterizedTest
  @ValueSource(strings = {"QuestionnaireResponse", "Questionnaire", "Observation", "Bundle", "Extension"})
  void walkingAProfileChangesNoDefinition(String type) {
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    StructureDefinition sd = ctxt.fetchTypeDefinition(type).copy();
    java.util.Map<String, String> before = definitions(ctxt);
    java.util.Map<String, String> sdBefore = elements(sd, "");
    PEDefinition pe = new PEBuilder(ctxt, PEElementPropertiesPolicy.EXTENSION, true).buildPEDefinition(sd);
    walk(pe, 4);
    assertEquals(List.of(), changed(sdBefore, elements(sd, "")), "changed in the profile");
    assertEquals(List.of(), changed(before, definitions(ctxt)), "changed in the context's definitions");
  }

  /** the keys whose values aren't the same (the elements that changed) */
  private static List<String> changed(java.util.Map<String, String> before, java.util.Map<String, String> after) {
    List<String> res = new ArrayList<>();
    for (java.util.Map.Entry<String, String> e : before.entrySet()) {
      if (!e.getValue().equals(after.get(e.getKey()))) {
        res.add(e.getKey());
      }
    }
    return res;
  }

  /** the snapshot elements of sd, as shape() gives them, by id (after prefix) */
  private static java.util.Map<String, String> elements(StructureDefinition sd, String prefix) {
    java.util.Map<String, String> res = new java.util.TreeMap<>();
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      res.put(prefix + ed.getId(), shape(ed));
    }
    return res;
  }

  /** the snapshot elements of the base definitions (types and resources) in the context, by versioned url#id */
  private static java.util.Map<String, String> definitions(IWorkerContext ctxt) {
    java.util.Map<String, String> res = new java.util.TreeMap<>();
    for (StructureDefinition sd : ctxt.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getDerivation() == StructureDefinition.TypeDerivationRule.SPECIALIZATION) {
        res.putAll(elements(sd, sd.getVersionedUrl() + "#"));
      }
    }
    return res;
  }

  /** everything in base, empty objects included, as name[count]{...} */
  private static String shape(org.hl7.fhir.r5.model.Base base) {
    StringBuilder b = new StringBuilder();
    shape(b, base);
    return b.toString();
  }

  private static void shape(StringBuilder b, org.hl7.fhir.r5.model.Base base) {
    for (org.hl7.fhir.r5.model.Property p : base.children()) {
      if (p.hasValues()) {
        b.append(p.getName()).append('[').append(p.getValues().size()).append("]{");
        for (org.hl7.fhir.r5.model.Base v : p.getValues()) {
          if (v == null) {
            b.append("null,");
          } else if (v.isPrimitive()) {
            b.append(v.primitiveValue()).append(',');
          } else {
            shape(b, v);
          }
        }
        b.append('}');
      }
    }
  }
}
