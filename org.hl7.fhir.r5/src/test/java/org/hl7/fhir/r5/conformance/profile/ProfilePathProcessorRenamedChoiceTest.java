package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * A profile constrains a choice element by its renamed path (e.g. valueQuantity) where the base has
 * already narrowed value[x] to that one type and has expanded its children (the way the R4 bp profile does
 * for component:SystolicBP.value[x]). The type slicer must only be added once - some children of value[x]
 * (e.g. value[x].id) have shorter paths than valueQuantity, and that used to stop the search for the existing
 * slicer early, so a second slicer was added, and the validator failed with "Slice encountered midway through set".
 */
class ProfilePathProcessorRenamedChoiceTest {

  private static final String CODE = "8480-6";

  @ParameterizedTest
  @ValueSource(strings = {"Observation", "Observation.component:SystolicBP"})
  void renamedChoiceAddsOneTypeSlicer(String parentId) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext("5.0.0");
    StructureDefinition observation = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Observation");
    String path = parentId.equals("Observation") ? "Observation" : "Observation.component";

    StructureDefinition base = profile("base", observation.getUrl());
    if (!parentId.equals("Observation")) {
      ElementDefinition component = add(base, "Observation.component", "Observation.component", null);
      component.getSlicing().addDiscriminator().setType(DiscriminatorType.VALUE).setPath("code");
      component.getSlicing().setRules(SlicingRules.OPEN);
      add(base, parentId, path, "SystolicBP");
      add(base, parentId + ".code", path + ".code", null).setPattern(new CodeableConcept(new Coding("http://loinc.org", CODE, null)));
    }
    add(base, parentId + ".value[x]", path + ".value[x]", null).addType().setCode("Quantity");
    add(base, parentId + ".value[x].unit", path + ".value[x].unit", null).setMustSupport(true);
    generateSnapshot(context, observation, base);

    StructureDefinition derived = profile("derived", base.getUrl());
    if (!parentId.equals("Observation")) {
      add(derived, parentId, path, "SystolicBP");
    }
    add(derived, parentId + ".valueQuantity", path + ".valueQuantity", null).setMustSupport(true);
    generateSnapshot(context, base, derived);

    List<ElementDefinition> slicers = new ArrayList<>();
    for (ElementDefinition ed : derived.getSnapshot().getElement()) {
      if (ed.getId().equals(parentId + ".value[x]")) {
        slicers.add(ed);
      }
    }
    assertEquals(1, slicers.size(), "there should be exactly one " + parentId + ".value[x]");
    assertTrue(slicers.get(0).hasSlicing());
    ElementDefinition slice = findById(derived, parentId + ".value[x]:valueQuantity");
    assertTrue(slice != null && slice.getMustSupport(), "the valueQuantity slice should carry the constraint");
  }

  private ElementDefinition findById(StructureDefinition sd, String id) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (id.equals(ed.getId())) {
        return ed;
      }
    }
    return null;
  }

  private void generateSnapshot(IWorkerContext context, StructureDefinition base, StructureDefinition sd) {
    ProfileUtilities pu = new ProfileUtilities(context, new ArrayList<>(), null);
    pu.setNewSlicingProcessing(true);
    pu.generateSnapshot(base, sd, sd.getUrl(), "http://example.org", sd.getName());
  }

  private StructureDefinition profile(String id, String baseUrl) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl("http://example.org/StructureDefinition/" + id);
    sd.setName(id);
    sd.setType("Observation");
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    sd.setBaseDefinition(baseUrl);
    add(sd, "Observation", "Observation", null);
    return sd;
  }

  private ElementDefinition add(StructureDefinition sd, String id, String path, String sliceName) {
    ElementDefinition ed = sd.getDifferential().addElement();
    ed.setId(id);
    ed.setPath(path);
    if (sliceName != null) {
      ed.setSliceName(sliceName);
    }
    return ed;
  }
}
