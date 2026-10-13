package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Test;

class ProfileUtilitiesSlicedDatatypeTest {

  @Test
  void expandsDatatypeChildrenOfNewResliceWithoutReprocessingParent() throws Exception {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    StructureDefinition contactPoint = definition("ContactPoint", "ContactPoint", StructureDefinitionKind.COMPLEXTYPE);
    contactPoint.setUrl("http://hl7.org/fhir/StructureDefinition/ContactPoint");
    contactPoint.getSnapshot().addElement(element("ContactPoint", "ContactPoint", null, 0, "*", null));
    contactPoint.getSnapshot().addElement(element("ContactPoint.system", "ContactPoint.system", null, 0, "1", "code"));
    contactPoint.getSnapshot().addElement(element("ContactPoint.value", "ContactPoint.value", null, 0, "1", "string"));
    contactPoint.getSnapshot().addElement(element("ContactPoint.use", "ContactPoint.use", null, 0, "1", "code"));
    context.cacheResource(contactPoint);

    StructureDefinition base = definition("BasePatient", "Patient", StructureDefinitionKind.RESOURCE);
    base.getSnapshot().addElement(element("Patient", "Patient", null, 0, "*", null));
    ElementDefinition telecom = element("Patient.telecom", "Patient.telecom", null, 0, "*", "ContactPoint");
    telecom.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("system");
    base.getSnapshot().addElement(telecom);
    // The inherited slice has not expanded the datatype's children yet.
    base.getSnapshot().addElement(element("Patient.telecom:phone", "Patient.telecom", "phone", 0, "*", "ContactPoint"));
    context.cacheResource(base);

    StructureDefinition derived = definition("ReslicedPatient", "Patient", StructureDefinitionKind.RESOURCE);
    derived.setDerivation(TypeDerivationRule.CONSTRAINT);
    derived.setBaseDefinition(base.getUrl());
    derived.getDifferential().addElement(element("Patient", "Patient", null, 0, "*", null));
    derived.getDifferential().addElement(telecom.copy(Base.COPY_DATA));
    ElementDefinition phone = element("Patient.telecom:phone", "Patient.telecom", "phone", 0, "*", "ContactPoint");
    phone.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("use");
    derived.getDifferential().addElement(phone);
    derived.getDifferential().addElement(element("Patient.telecom:phone/work", "Patient.telecom", "phone/work", 1, "1", "ContactPoint"));
    ElementDefinition system = element("Patient.telecom:phone/work.system", "Patient.telecom.system", null, 1, "1", "code");
    system.setFixed(new CodeType("phone"));
    derived.getDifferential().addElement(system);
    derived.getDifferential().addElement(element("Patient.telecom:phone/work.value", "Patient.telecom.value", null, 1, "1", "string"));
    ElementDefinition use = element("Patient.telecom:phone/work.use", "Patient.telecom.use", null, 1, "1", "code");
    use.setFixed(new CodeType("work"));
    derived.getDifferential().addElement(use);

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
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    StructureDefinition extensionType = definition("Extension", "Extension", StructureDefinitionKind.COMPLEXTYPE);
    extensionType.setUrl("http://hl7.org/fhir/StructureDefinition/Extension");
    extensionType.getSnapshot().addElement(element("Extension", "Extension", null, 0, "*", null));
    extensionType.getSnapshot().addElement(element("Extension.id", "Extension.id", null, 0, "1", "string"));
    ElementDefinition nestedExtension = element("Extension.extension", "Extension.extension", null, 0, "*", "Extension");
    nestedExtension.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
    extensionType.getSnapshot().addElement(nestedExtension);
    extensionType.getSnapshot().addElement(element("Extension.url", "Extension.url", null, 1, "1", "uri"));
    extensionType.getSnapshot().addElement(element("Extension.value[x]", "Extension.value[x]", null, 0, "1", "string"));
    context.cacheResource(extensionType);

    StructureDefinition labelExtension = definition("LabelExtension", "Extension", StructureDefinitionKind.COMPLEXTYPE);
    labelExtension.setDerivation(TypeDerivationRule.CONSTRAINT);
    labelExtension.setBaseDefinition(extensionType.getUrl());
    labelExtension.setSnapshot(extensionType.getSnapshot().copy(Base.COPY_DATA));
    labelExtension.getSnapshot().getElementList().get(2).setMax("0");
    labelExtension.getSnapshot().getElementList().get(3).setFixed(new UriType(labelExtension.getUrl()));
    labelExtension.getSnapshot().getElementList().get(4).setMin(1);
    context.cacheResource(labelExtension);

    StructureDefinition base = definition("BaseComposition", "Composition", StructureDefinitionKind.RESOURCE);
    base.getSnapshot().addElement(element("Composition", "Composition", null, 0, "*", null));
    base.getSnapshot().addElement(element("Composition.section", "Composition.section", null, 0, "*", "BackboneElement"));
    base.getSnapshot().addElement(element("Composition.section.id", "Composition.section.id", null, 0, "1", "string"));
    ElementDefinition extension = element("Composition.section.extension", "Composition.section.extension", null, 0, "*", "Extension");
    extension.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
    base.getSnapshot().addElement(extension);
    base.getSnapshot().addElement(element("Composition.section.title", "Composition.section.title", null, 0, "1", "string"));
    ElementDefinition recursiveSection = element("Composition.section.section", "Composition.section.section", null, 0, "*", null);
    // Expanding this reused backbone introduces a path redirection before the new extension is processed.
    recursiveSection.setContentReference("#Composition.section");
    base.getSnapshot().addElement(recursiveSection);
    context.cacheResource(base);

    StructureDefinition derived = definition("NestedComposition", "Composition", StructureDefinitionKind.RESOURCE);
    derived.setDerivation(TypeDerivationRule.CONSTRAINT);
    derived.setBaseDefinition(base.getUrl());
    derived.getDifferential().addElement(element("Composition", "Composition", null, 0, "*", null));
    ElementDefinition sections = element("Composition.section", "Composition.section", null, 0, "*", "BackboneElement");
    sections.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("title");
    derived.getDifferential().addElement(sections);
    derived.getDifferential().addElement(element("Composition.section:summary", "Composition.section", "summary", 0, "1", "BackboneElement"));
    ElementDefinition summaryTitle = element("Composition.section:summary.title", "Composition.section.title", null, 1, "1", "string");
    summaryTitle.setFixed(new StringType("Summary"));
    derived.getDifferential().addElement(summaryTitle);
    ElementDefinition subsections = element("Composition.section:summary.section", "Composition.section.section", null, 0, "*", null);
    subsections.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("title");
    derived.getDifferential().addElement(subsections);
    derived.getDifferential().addElement(element("Composition.section:summary.section:details", "Composition.section.section", "details", 0, "1", null));
    ElementDefinition label = element("Composition.section:summary.section:details.extension:label", "Composition.section.section.extension", "label", 1, "1", "Extension");
    label.getTypeFirstRep().addProfile(labelExtension.getUrl());
    derived.getDifferential().addElement(label);
    ElementDefinition labelValue = element("Composition.section:summary.section:details.extension:label.value[x]", "Composition.section.section.extension.value[x]", null, 1, "1", "string");
    labelValue.setFixed(new StringType("Nested section label"));
    derived.getDifferential().addElement(labelValue);
    ElementDefinition detailsTitle = element("Composition.section:summary.section:details.title", "Composition.section.section.title", null, 1, "1", "string");
    detailsTitle.setFixed(new StringType("Details"));
    derived.getDifferential().addElement(detailsTitle);

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

  private StructureDefinition definition(String name, String type, StructureDefinitionKind kind) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(name);
    sd.setUrl("http://example.org/fhir/StructureDefinition/" + name);
    sd.setName(name);
    sd.setStatus(PublicationStatus.DRAFT);
    sd.setType(type);
    sd.setKind(kind);
    sd.setAbstract(false);
    sd.setDerivation(TypeDerivationRule.SPECIALIZATION);
    return sd;
  }

  private ElementDefinition element(String id, String path, String slice, int min, String max, String type) {
    ElementDefinition ed = new ElementDefinition();
    ed.setId(id);
    ed.setPath(path);
    ed.setMin(min);
    ed.setMax(max);
    if (slice != null) {
      ed.setSliceName(slice);
    }
    if (type != null) {
      ed.addType().setCode(type);
    }
    return ed;
  }

  private ElementDefinition snapshotElement(StructureDefinition sd, String id) {
    ElementDefinition ed = sd.getSnapshot().getElementList().stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
    assertNotNull(ed, id);
    return ed;
  }
}
