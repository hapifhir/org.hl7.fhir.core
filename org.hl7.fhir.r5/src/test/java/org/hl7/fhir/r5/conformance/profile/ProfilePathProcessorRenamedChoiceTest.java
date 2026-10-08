package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
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

  private static final String SYSTOLIC = "8480-6";

  @ParameterizedTest
  @ValueSource(strings = {"Observation", "Observation.component:SystolicBP"})
  void renamedChoiceAddsOneTypeSlicer(String parentId) {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext("5.0.0");
    StructureDefinition observation = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/Observation");
    boolean inSlice = !parentId.equals("Observation");
    String path = inSlice ? "Observation.component" : "Observation";

    StructureDefinition base = profile("base", observation.getUrl());
    if (inSlice) {
      ElementDefinition component = add(base, "Observation.component", "Observation.component", null);
      component.getSlicing().addDiscriminator().setType(DiscriminatorType.VALUE).setPath("code");
      component.getSlicing().setRules(SlicingRules.OPEN);
      add(base, parentId, path, "SystolicBP");
      add(base, parentId + ".code", path + ".code", null).setPattern(new CodeableConcept(new Coding("http://loinc.org", SYSTOLIC, null)));
    }
    add(base, parentId + ".value[x]", path + ".value[x]", null).addType().setCode("Quantity");
    add(base, parentId + ".value[x].unit", path + ".value[x].unit", null).setMustSupport(true);
    generateSnapshot(context, observation, base);

    StructureDefinition derived = profile("derived", base.getUrl());
    if (inSlice) {
      add(derived, parentId, path, "SystolicBP");
    }
    add(derived, parentId + ".valueQuantity", path + ".valueQuantity", null).setMustSupport(true);
    List<ValidationMessage> messages = generateSnapshot(context, base, derived);

    int slicers = 0;
    for (ElementDefinition ed : derived.getSnapshot().getElement()) {
      if (ed.getId().equals(parentId + ".value[x]")) {
        slicers++;
      }
    }
    assertEquals(1, slicers, "there should be exactly one " + parentId + ".value[x]");
    assertTrue(findById(derived, parentId + ".value[x]").hasSlicing());
    ElementDefinition slice = findById(derived, parentId + ".value[x]:valueQuantity");
    assertNotNull(slice);
    assertTrue(slice.getMustSupport(), "the valueQuantity slice should carry the constraint");
    for (ValidationMessage m : messages) {
      assertTrue(m.getLevel() != IssueSeverity.ERROR && m.getLevel() != IssueSeverity.FATAL, m.summary());
    }
  }

  private ElementDefinition findById(StructureDefinition sd, String id) {
    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (id.equals(ed.getId())) {
        return ed;
      }
    }
    return null;
  }

  private List<ValidationMessage> generateSnapshot(IWorkerContext context, StructureDefinition base, StructureDefinition sd) {
    List<ValidationMessage> messages = new ArrayList<>();
    ProfileUtilities pu = new ProfileUtilities(context, messages, null);
    pu.setNewSlicingProcessing(true);
    pu.generateSnapshot(base, sd, sd.getUrl(), "http://example.org", sd.getName());
    return messages;
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
