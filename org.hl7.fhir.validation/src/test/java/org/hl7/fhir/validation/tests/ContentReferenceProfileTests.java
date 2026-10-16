package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Bundle;
import org.hl7.fhir.model.core.Bundle.BundleType;
import org.hl7.fhir.model.core.Composition;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.context.ContextUtilities;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.ObjectConverter;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.type.StructureDefinitionValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ContentReferenceProfileTests {

  private static ValidationEngine engine;
  private static StructureDefinition guide;
  private static StructureDefinition otherGuide;
  private static StructureDefinition cyclicGuide;

  @BeforeAll
  static void setUp() throws Exception {
    engine = TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", "n/a", FhirPublication.R5, "5.0.0");

    StructureDefinition section = loadProfile("reusable-section");
    guide = loadProfile("guide");
    otherGuide = guide.copy(Base.COPY_NOTHING);
    otherGuide.setUrl(guide.getUrl() + "-other");
    cacheProfile(otherGuide);

    // A cycle on the same instance element must stop while retaining both profiles' rules.
    cyclicGuide = guide.copy(Base.COPY_NOTHING);
    cyclicGuide.setUrl(guide.getUrl() + "-cyclic");
    StructureDefinition cyclicSection = section.copy(Base.COPY_NOTHING);
    cyclicSection.setUrl(section.getUrl() + "-cyclic");
    cyclicGuide.getSnapshot().getElementById("Composition.section.section")
      .getExtensionByUrl(ExtensionDefinitions.EXT_CONTENT_PROFILE)
      .setValue(new UriType(cyclicSection.getUrl() + "#Composition.section"));
    cyclicSection.getSnapshot().getElementById("Composition.section")
      .addExtension(ExtensionDefinitions.EXT_CONTENT_PROFILE, new UriType(cyclicGuide.getUrl() + "#Composition.section.section"));
    cacheProfile(cyclicGuide);
    cacheProfile(cyclicSection);
  }

  @AfterAll
  static void tearDown() {
    engine = null;
    guide = null;
    otherGuide = null;
    cyclicGuide = null;
  }

  @Test
  void eachAlternativeReportsFailuresFromItsSharedContentProfile() throws Exception {
    Composition composition = composition(false, false);
    assertEquals(1, missingTitles(validate(composition, guide)));
    assertEquals(1, missingTitles(validate(composition, otherGuide)));

    StructureDefinition bundleProfile = (StructureDefinition) new JsonParser(engine.getContext().getModelContext()).parse("""
      {"resourceType":"StructureDefinition", "url":"http://example.org/StructureDefinition/bundle",
       "name":"BundleWithAlternatives", "status":"active", "kind":"resource", "abstract":false,
       "type":"Bundle", "baseDefinition":"http://hl7.org/fhir/StructureDefinition/Bundle", "derivation":"constraint",
       "differential":{"element":[{"id":"Bundle.entry.resource", "path":"Bundle.entry.resource",
         "type":[{"code":"Composition", "profile":["%s", "%s"]}]}]}}
      """.formatted(guide.getUrl(), otherGuide.getUrl()));
    cacheProfile(bundleProfile);
    Bundle bundle = new Bundle().setType(BundleType.COLLECTION);
    bundle.addEntry().setFullUrl("http://example.org/Composition/" + composition.getId()).setResource(composition);

    List<ValidationMessage> errors = validate(bundle, bundleProfile);
    assertTrue(errors.stream().anyMatch(e -> e.isError()
      && I18nConstants.BUNDLE_BUNDLE_ENTRY_MULTIPLE_PROFILES_NO_MATCH.equals(e.getMessageId())), errors.toString());
    assertEquals(2, missingTitles(errors), "both failed candidates must retain the referenced profile's error");
  }

  @Test
  void validatingTheSameParsedElementAgainStillReportsContentProfileFailures() throws Exception {
    InstanceValidator validator = engine.getValidator(FhirFormat.JSON);
    List<ValidationMessage> first = new ArrayList<>();
    Element element = validator.validate(null, first, composition(false, false), List.of(guide));
    List<ValidationMessage> second = new ArrayList<>();
    validator.validate(null, second, "Composition", element, List.of(guide));

    assertEquals(1, missingTitles(first));
    assertEquals(1, missingTitles(second));
  }

  @ParameterizedTest
  @CsvSource({"false,false", "true,false", "false,true", "true,true"})
  void cyclesTerminateWithoutSuppressingConstraints(boolean hasTitle, boolean hasEntry) throws Exception {
    List<ValidationMessage> errors = validate(composition(hasTitle, hasEntry), cyclicGuide);
    assertEquals(hasTitle ? 0 : 1, missingTitles(errors));
    long prohibitedEntries = errors.stream().filter(e -> e.isError()
      && I18nConstants.VALIDATION_VAL_PROFILE_MAXIMUM.equals(e.getMessageId())
      && e.getMessage().contains("Composition.section.section.entry")).count();
    assertEquals(hasEntry ? 1 : 0, prohibitedEntries);
    assertEquals((hasTitle ? 0 : 1) + (hasEntry ? 1 : 0),
      errors.stream().filter(ValidationMessage::isError).count(), errors.toString());
  }

  @ParameterizedTest
  @CsvSource({"Questionnaire.item,snapshot", "Questionnaire.missing,differential", ",snapshot"})
  void validatesDistinctSnapshotReferencesOnce(String differentialTarget, String errorLocation) throws Exception {
    StructureDefinition profile = (StructureDefinition) fixture("StructureDefinition-recursive-questionnaire");
    new ContextUtilities(engine.getContext()).generateSnapshot(profile);
    var differential = profile.getDifferential().getElementList().stream()
      .filter(e -> e.hasExtension(ExtensionDefinitions.EXT_CONTENT_PROFILE)).findFirst().orElseThrow();
    profile.getSnapshot().getElementById(differential.getId()).getExtensionByUrl(ExtensionDefinitions.EXT_CONTENT_PROFILE)
      .setValue(new UriType(profile.getUrl() + "#Questionnaire.missing"));
    if (differentialTarget == null) {
      differential.getExtension().removeIf(e -> ExtensionDefinitions.EXT_CONTENT_PROFILE.equals(e.getUrl()));
    } else {
      differential.getExtensionByUrl(ExtensionDefinitions.EXT_CONTENT_PROFILE)
        .setValue(new UriType(profile.getUrl() + "#" + differentialTarget));
    }

    Element source = new ObjectConverter(engine.getContext()).convert(profile);
    InstanceValidator.setParents(source);
    BaseValidator parent = new BaseValidator(engine.getContext(), new ValidatorSettings(), null, null);
    StructureDefinitionValidator validator = new StructureDefinitionValidator(parent, new FHIRPathEngine(engine.getContext()), true);
    List<ValidationMessage> messages = new ArrayList<>();
    validator.validateStructureDefinition(messages, source, new NodeStack(engine.getContext(), null, source, "en"));

    List<ValidationMessage> errors = messages.stream().filter(ValidationMessage::isError).toList();
    assertEquals(1, errors.size(), messages.toString());
    assertEquals(I18nConstants.CONTENT_REFERENCE_PROFILE_UNKNOWN_ELEMENT, errors.get(0).getMessageId());
    assertTrue(errors.get(0).getLocation().startsWith("StructureDefinition." + errorLocation + ".element["), errors.toString());
  }

  private List<ValidationMessage> validate(Resource resource, StructureDefinition profile) throws Exception {
    List<ValidationMessage> errors = new ArrayList<>();
    engine.getValidator(FhirFormat.JSON).validate(null, errors, resource, List.of(profile));
    return errors;
  }

  private long missingTitles(List<ValidationMessage> errors) {
    return errors.stream().filter(e -> e.isError()
      && I18nConstants.VALIDATION_VAL_PROFILE_MINIMUM.equals(e.getMessageId())
      && e.getMessage().contains("Composition.section.title")).count();
  }

  private Composition composition(boolean hasTitle, boolean hasEntry) throws Exception {
    Composition result = (Composition) fixture("composition-valid");
    var section = result.getSectionFirstRep().getSectionFirstRep();
    if (!hasTitle) {
      section.setTitle(null);
    }
    if (hasEntry) {
      section.addEntry().setDisplay("Example entry");
    }
    return result;
  }

  private static Resource fixture(String name) throws Exception {
    return new JsonParser(engine.getContext().getModelContext()).parse(
      TestingUtilities.loadTestResourceStream("validator", "content-reference-profile", name + ".json"));
  }

  private static StructureDefinition loadProfile(String name) throws Exception {
    StructureDefinition profile = (StructureDefinition) fixture("StructureDefinition-" + name);
    cacheProfile(profile);
    return profile;
  }

  private static void cacheProfile(StructureDefinition profile) {
    new ContextUtilities(engine.getContext()).generateSnapshot(profile);
    engine.getContext().getManager().cacheResource(profile);
  }
}
