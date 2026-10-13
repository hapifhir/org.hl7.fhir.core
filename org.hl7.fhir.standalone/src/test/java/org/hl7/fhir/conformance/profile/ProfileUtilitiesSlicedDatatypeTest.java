package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Test;

class ProfileUtilitiesSlicedDatatypeTest {

  @Test
  void expandsDatatypeChildrenOfNewResliceWithoutReprocessingParent() throws Exception {
    SimpleWorkerContext context = context("ContactPoint", "BasePatient");
    StructureDefinition base = resource("BasePatient");
    StructureDefinition derived = resource("ReslicedPatient");

    List<ValidationMessage> messages = new ArrayList<>();
    new ProfileUtilities(context, messages, null).generateSnapshot(base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());

    ElementDefinition reslice = snapshotElement(derived, "Patient.telecom:phone/work");
    assertEquals(1, reslice.getMin());
    assertEquals("1", reslice.getMax());
    assertEquals("phone/work", reslice.getSliceName());
    assertEquals("phone", snapshotElement(derived, "Patient.telecom:phone/work.system").getFixed().primitiveValue());
    assertEquals("work", snapshotElement(derived, "Patient.telecom:phone/work.use").getFixed().primitiveValue());
    assertEquals(1, snapshotElement(derived, "Patient.telecom:phone/work.value").getMin());
    snapshotElement(derived, "Patient.telecom:phone");
    assertTrue(messages.stream().noneMatch(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL), messages.toString());
  }

  @Test
  void expandsNewExtensionUnderContentReferenceWithoutInfiniteRecursion() throws Exception {
    SimpleWorkerContext context = context("Extension", "LabelExtension", "BaseComposition");
    StructureDefinition base = resource("BaseComposition");
    StructureDefinition labelExtension = resource("LabelExtension");
    StructureDefinition derived = resource("NestedComposition");

    List<ValidationMessage> messages = new ArrayList<>();
    new ProfileUtilities(context, messages, null).generateSnapshot(base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());

    ElementDefinition labelSnapshot = snapshotElement(derived, "Composition.section:summary.section:details.extension:label");
    assertEquals(1, labelSnapshot.getMin());
    assertEquals("1", labelSnapshot.getMax());
    assertEquals(labelExtension.getUrl(), labelSnapshot.getTypeFirstRep().getProfileList().get(0).getValue());
    ElementDefinition valueSnapshot = derived.getSnapshot().getElementList().stream()
        .filter(e -> e.getId().startsWith("Composition.section:summary.section:details.extension:label.value"))
        .findFirst().orElse(null);
    assertNotNull(valueSnapshot);
    assertEquals(1, valueSnapshot.getMin());
    assertNotNull(valueSnapshot.getFixed());
    assertEquals("Nested section label", valueSnapshot.getFixed().primitiveValue());
    assertEquals("0", snapshotElement(derived, "Composition.section:summary.section:details.extension:label.extension").getMax());
    assertEquals("Summary", snapshotElement(derived, "Composition.section:summary.title").getFixed().primitiveValue());
    assertEquals("Details", snapshotElement(derived, "Composition.section:summary.section:details.title").getFixed().primitiveValue());
    assertTrue(messages.stream().noneMatch(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL), messages.toString());
  }

  @Test
  void expandsContentReferenceAfterResettingDatatypeRedirectors() throws Exception {
    SimpleWorkerContext context = context("Extension", "RecursiveExtension", "BaseComposition");
    StructureDefinition base = resource("BaseComposition");
    StructureDefinition derived = resource("NestedExtensionComposition");

    List<ValidationMessage> messages = new ArrayList<>();
    new ProfileUtilities(context, messages, null).generateSnapshot(base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());

    String childId = "Composition.section:summary.section:details.extension:label.extension";
    assertEquals(1, snapshotElement(derived, childId).getMin());
    assertEquals("1", snapshotElement(derived, childId).getMax());
    assertEquals("0", snapshotElement(derived, childId + ".extension").getMax());
    assertEquals("child", snapshotElement(derived, childId + ".url").getFixed().primitiveValue());
    assertEquals("Nested extension value", snapshotElement(derived, childId + ".value[x]").getFixed().primitiveValue());
    assertEquals("Details", snapshotElement(derived, "Composition.section:summary.section:details.title").getFixed().primitiveValue());
    assertTrue(messages.stream().noneMatch(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL), messages.toString());
  }

  private SimpleWorkerContext context(String... names) throws Exception {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    for (String name : names) {
      context.cacheResource(resource(name));
    }
    return context;
  }

  private StructureDefinition resource(String name) throws Exception {
    try (InputStream input = getClass().getResourceAsStream("/snapshot-datatype-recursion/" + name + ".json")) {
      assertNotNull(input, name);
      return (StructureDefinition) new JsonParser(ModelContext.fullCoreContext()).parse(input);
    }
  }

  private ElementDefinition snapshotElement(StructureDefinition sd, String id) {
    ElementDefinition ed = sd.getSnapshot().getElementList().stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
    assertNotNull(ed, id);
    return ed;
  }
}
