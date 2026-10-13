package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Test;

class ProfileUtilitiesInheritedReslicingTest {

  @Test
  void newReslicesPrecedeLaterConstrainedInheritedSibling() throws Exception {
    Fixture f = new Fixture();
    f.addPhoneReslicing();
    f.addReslice("phone/work", "work", 1);
    f.addReslice("phone/home", "home", 0);
    f.derived.getDifferential().addElement(element("Patient.telecom:email", "Patient.telecom", "email", 1, "1", "ContactPoint"));

    f.generate();

    assertEquals(List.of("phone", "phone/work", "phone/home", "email"), f.sliceNames());
    assertEquals(1, f.snapshot("Patient.telecom:phone/work").getMin());
    assertEquals("work", f.snapshot("Patient.telecom:phone/work.use").getFixed().primitiveValue());
    assertEquals("home", f.snapshot("Patient.telecom:phone/home.use").getFixed().primitiveValue());
    assertEquals(1, f.snapshot("Patient.telecom:email").getMin());
    assertEquals("1", f.snapshot("Patient.telecom:email").getMax());
    assertEquals("email", f.snapshot("Patient.telecom:email.system").getFixed().primitiveValue());
  }

  @Test
  void newReslicePrecedesUnconstrainedInheritedSibling() throws Exception {
    Fixture f = new Fixture();
    f.addPhoneReslicing();
    f.addReslice("phone/work", "work", 1);

    f.generate();

    assertEquals(List.of("phone", "phone/work", "email"), f.sliceNames());
    assertEquals("work", f.snapshot("Patient.telecom:phone/work.use").getFixed().primitiveValue());
    assertEquals(0, f.snapshot("Patient.telecom:email").getMin());
    assertEquals("email", f.snapshot("Patient.telecom:email.system").getFixed().primitiveValue());
  }

  @Test
  void stillRejectsReorderedInheritedSiblings() throws Exception {
    Fixture f = new Fixture();
    f.derived.getDifferential().addElement(element("Patient.telecom:email", "Patient.telecom", "email", 0, "*", "ContactPoint"));
    f.derived.getDifferential().addElement(element("Patient.telecom:phone", "Patient.telecom", "phone", 0, "*", "ContactPoint"));

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  @Test
  void stillRejectsNewTopLevelSliceBeforeLaterInheritedSibling() throws Exception {
    Fixture f = new Fixture();
    f.addPhoneReslicing();
    f.derived.getDifferential().addElement(element("Patient.telecom:fax", "Patient.telecom", "fax", 0, "*", "ContactPoint"));
    f.derived.getDifferential().addElement(element("Patient.telecom:email", "Patient.telecom", "email", 1, "1", "ContactPoint"));

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  @Test
  void stillRejectsResliceBeforeItsExplicitParent() throws Exception {
    Fixture f = new Fixture();
    f.addReslice("phone/work", "work", 1);
    f.addPhoneReslicing();
    f.derived.getDifferential().addElement(element("Patient.telecom:email", "Patient.telecom", "email", 1, "1", "ContactPoint"));

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  private static class Fixture {
    final SimpleWorkerContext context;
    final StructureDefinition base = definition("BasePatient");
    final StructureDefinition derived = definition("ReslicedPatient");

    Fixture() throws Exception {
      context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
      StructureDefinition contactPoint = definition("ContactPoint");
      contactPoint.setUrl("http://hl7.org/fhir/StructureDefinition/ContactPoint");
      contactPoint.setType("ContactPoint");
      contactPoint.setKind(StructureDefinitionKind.COMPLEXTYPE);
      contactPoint.setDerivation(TypeDerivationRule.SPECIALIZATION);
      contactPoint.getSnapshot().addElement(element("ContactPoint", "ContactPoint", null, 0, "*", null));
      contactPoint.getSnapshot().addElement(element("ContactPoint.system", "ContactPoint.system", null, 0, "1", "code"));
      contactPoint.getSnapshot().addElement(element("ContactPoint.use", "ContactPoint.use", null, 0, "1", "code"));
      context.cacheResource(contactPoint);
      base.getSnapshot().addElement(element("Patient", "Patient", null, 0, "*", null));
      ElementDefinition telecom = element("Patient.telecom", "Patient.telecom", null, 0, "*", "ContactPoint");
      telecom.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("system");
      base.getSnapshot().addElement(telecom);
      for (String slice : List.of("phone", "email")) {
        base.getSnapshot().addElement(element("Patient.telecom:" + slice, "Patient.telecom", slice, 0, "*", "ContactPoint"));
        ElementDefinition system = element("Patient.telecom:" + slice + ".system", "Patient.telecom.system", null, 1, "1", "code");
        system.setFixed(new CodeType(slice));
        base.getSnapshot().addElement(system);
        base.getSnapshot().addElement(element("Patient.telecom:" + slice + ".use", "Patient.telecom.use", null, 0, "1", "code"));
      }
      context.cacheResource(base);
      derived.setBaseDefinition(base.getUrl());
      derived.getDifferential().addElement(element("Patient", "Patient", null, 0, "*", null));
      derived.getDifferential().addElement(telecom.copy(Base.COPY_DATA));
    }

    void addPhoneReslicing() {
      ElementDefinition phone = element("Patient.telecom:phone", "Patient.telecom", "phone", 0, "*", "ContactPoint");
      phone.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("use");
      derived.getDifferential().addElement(phone);
    }

    void addReslice(String name, String use, int min) {
      derived.getDifferential().addElement(element("Patient.telecom:" + name, "Patient.telecom", name, min, "1", "ContactPoint"));
      ElementDefinition purpose = element("Patient.telecom:" + name + ".use", "Patient.telecom.use", null, 1, "1", "code");
      purpose.setFixed(new CodeType(use));
      derived.getDifferential().addElement(purpose);
    }

    void generate() {
      List<ValidationMessage> messages = new ArrayList<>();
      new ProfileUtilities(context, messages, null).generateSnapshot(base, derived, derived.getUrl(), "http://example.org/fhir", derived.getName());
      assertTrue(messages.stream().noneMatch(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL), messages.toString());
    }

    List<String> sliceNames() {
      return derived.getSnapshot().getElementList().stream().filter(e -> "Patient.telecom".equals(e.getPath()) && e.hasSliceName())
          .map(ElementDefinition::getSliceName).collect(Collectors.toList());
    }

    ElementDefinition snapshot(String id) {
      ElementDefinition ed = derived.getSnapshot().getElementList().stream().filter(e -> id.equals(e.getId())).findFirst().orElse(null);
      assertNotNull(ed, id);
      return ed;
    }
  }

  private static StructureDefinition definition(String name) {
    StructureDefinition sd = new StructureDefinition();
    sd.setId(name);
    sd.setUrl("http://example.org/fhir/StructureDefinition/" + name);
    sd.setName(name);
    sd.setStatus(PublicationStatus.DRAFT);
    sd.setType("Patient");
    sd.setKind(StructureDefinitionKind.RESOURCE);
    sd.setAbstract(false);
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    return sd;
  }

  private static ElementDefinition element(String id, String path, String slice, int min, String max, String type) {
    ElementDefinition ed = new ElementDefinition();
    ed.setId(id);
    ed.setPath(path);
    ed.setMin(min);
    ed.setMax(max);
    if (slice != null) ed.setSliceName(slice);
    if (type != null) ed.addType().setCode(type);
    return ed;
  }
}
