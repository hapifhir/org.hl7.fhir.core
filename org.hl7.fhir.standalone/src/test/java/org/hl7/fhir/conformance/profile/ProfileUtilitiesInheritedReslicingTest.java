package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Test;

class ProfileUtilitiesInheritedReslicingTest {

  @Test
  void newReslicesPrecedeLaterConstrainedInheritedSibling() throws Exception {
    Fixture f = new Fixture("ConstrainedSibling");

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
    Fixture f = new Fixture("UnconstrainedSibling");

    f.generate();

    assertEquals(List.of("phone", "phone/work", "email"), f.sliceNames());
    assertEquals("work", f.snapshot("Patient.telecom:phone/work.use").getFixed().primitiveValue());
    assertEquals(0, f.snapshot("Patient.telecom:email").getMin());
    assertEquals("email", f.snapshot("Patient.telecom:email.system").getFixed().primitiveValue());
  }

  @Test
  void stillRejectsReorderedInheritedSiblings() throws Exception {
    Fixture f = new Fixture("ReorderedSiblings");

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  @Test
  void stillRejectsNewTopLevelSliceBeforeLaterInheritedSibling() throws Exception {
    Fixture f = new Fixture("NewTopLevelBeforeSibling");

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  @Test
  void stillRejectsResliceBeforeItsExplicitParent() throws Exception {
    Fixture f = new Fixture("ResliceBeforeExplicitParent");

    DefinitionException error = assertThrows(DefinitionException.class, f::generate);
    assertTrue(error.getMessage().contains("Named items are out of order in the slice"));
  }

  private static class Fixture {
    final SimpleWorkerContext context;
    final StructureDefinition base;
    final StructureDefinition derived;

    Fixture(String name) throws Exception {
      context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
      context.cacheResource(resource("ContactPoint"));
      base = resource("BasePatient");
      context.cacheResource(base);
      derived = resource(name);
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

  private static StructureDefinition resource(String name) throws Exception {
    try (InputStream input = ProfileUtilitiesInheritedReslicingTest.class.getResourceAsStream("/inherited-reslicing/" + name + ".json")) {
      assertNotNull(input, name);
      return (StructureDefinition) new JsonParser(ModelContext.fullCoreContext()).parse(input);
    }
  }
}
