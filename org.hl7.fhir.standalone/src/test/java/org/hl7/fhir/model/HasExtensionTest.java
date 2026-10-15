package org.hl7.fhir.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.BackboneElement;
import org.hl7.fhir.model.core.BackboneType;
import org.hl7.fhir.model.core.DomainResource;
import org.hl7.fhir.model.core.Element;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.HumanName;
import org.hl7.fhir.model.core.ImplementationGuide;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.Timing;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.tools.ExtensionConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HasExtensionTest {

  private static final String URL_A = "http://example.org/fhir/StructureDefinition/a";
  private static final String URL_B = "http://example.org/fhir/StructureDefinition/b";
  private static final String URL_C = "http://example.org/fhir/StructureDefinition/c";
  private static final String MISSING = "http://example.org/fhir/StructureDefinition/missing";
  private static final String OTHER_MISSING = "http://example.org/fhir/StructureDefinition/other-missing";

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "PATIENT"})
  void modifierOnlyUrlsMatchAllShapes(SubjectType type) {
    Subject subject = type.create();
    subject.addModifier(new Extension(URL_A));

    assertPresence(subject, URL_A, true);
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "PATIENT"})
  void ordinaryFallbackAndMissesRetainExpectedResults(SubjectType type) {
    Subject ordinary = type.create();
    ordinary.addOrdinary(new Extension(URL_A));
    Subject ordinaryWithModifier = type.create();
    ordinaryWithModifier.addOrdinary(new Extension(URL_A));
    ordinaryWithModifier.addModifier(new Extension(URL_B));
    Subject empty = type.create();
    Subject nonmatching = type.create();
    nonmatching.addOrdinary(new Extension(URL_B));
    nonmatching.addModifier(new Extension(URL_C));

    assertAll(
      () -> assertPresence(ordinary, URL_A, true),
      () -> assertPresence(ordinaryWithModifier, URL_A, true),
      () -> assertPresence(empty, URL_A, false),
      () -> assertPresence(nonmatching, URL_A, false),
      () -> assertMissingQueries(ordinary),
      () -> assertMissingQueries(ordinaryWithModifier),
      () -> assertMissingQueries(empty),
      () -> assertMissingQueries(nonmatching));
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "PATIENT"})
  void multipleUrlsAndDuplicatesUseAnyMatchSemantics(SubjectType type) {
    Subject mixed = type.create();
    mixed.addOrdinary(new Extension(URL_A));
    mixed.addModifier(new Extension(URL_B));
    Subject ordinaryDuplicates = type.create();
    ordinaryDuplicates.addOrdinary(new Extension(URL_A));
    ordinaryDuplicates.addOrdinary(new Extension(URL_A));
    Subject modifierDuplicates = type.create();
    modifierDuplicates.addModifier(new Extension(URL_A));
    modifierDuplicates.addModifier(new Extension(URL_A));
    Subject acrossLists = type.create();
    acrossLists.addOrdinary(new Extension(URL_A));
    acrossLists.addModifier(new Extension(URL_A));

    assertAll(
      () -> assertPresence(mixed, URL_A, true),
      () -> assertPresence(mixed, URL_B, true),
      () -> assertTrue(mixed.hasExtension(URL_A, URL_B)),
      () -> assertTrue(mixed.hasExtension(URL_B, URL_A)),
      () -> assertTrue(mixed.hasExtension(URL_A, URL_A)),
      () -> assertTrue(mixed.hasExtension(URL_B, URL_B)),
      () -> assertPresence(ordinaryDuplicates, URL_A, true),
      () -> assertPresence(modifierDuplicates, URL_A, true),
      () -> assertPresence(acrossLists, URL_A, true),
      () -> assertTrue(ordinaryDuplicates.hasExtension(URL_A, URL_A)),
      () -> assertTrue(modifierDuplicates.hasExtension(URL_A, URL_A)),
      () -> assertTrue(acrossLists.hasExtension(URL_A, URL_A)),
      () -> assertMissingQueries(mixed),
      () -> assertMissingQueries(ordinaryDuplicates),
      () -> assertMissingQueries(modifierDuplicates),
      () -> assertMissingQueries(acrossLists));
  }

  @Test
  void baseTypedCallsUseSpecializedScalarOverrides() {
    Patient.ContactComponent contact = new Patient.ContactComponent();
    contact.addModifierExtension(new Extension(URL_A));
    Element contactAsElement = contact;
    Patient.ContactComponent ordinaryContact = new Patient.ContactComponent();
    ordinaryContact.addExtension(new Extension(URL_A));
    Element ordinaryContactAsElement = ordinaryContact;

    Timing timing = new Timing();
    timing.addModifierExtension(new Extension(URL_A));
    Element timingAsElement = timing;
    Timing ordinaryTiming = new Timing();
    ordinaryTiming.addExtension(new Extension(URL_A));
    Element ordinaryTimingAsElement = ordinaryTiming;

    Patient patient = new Patient();
    patient.addModifierExtension(new Extension(URL_A));
    DomainResource patientAsResource = patient;
    Patient ordinaryPatient = new Patient();
    ordinaryPatient.addExtension(new Extension(URL_A));
    DomainResource ordinaryPatientAsResource = ordinaryPatient;

    assertAll(
      () -> assertAll("ContactComponent dispatch",
        () -> assertTrue(contact.hasExtension(URL_A)),
        () -> assertTrue(contactAsElement.hasExtension(URL_A)),
        () -> assertTrue(contact.hasExtension(new String[] {URL_A})),
        () -> assertTrue(contactAsElement.hasExtension(new String[] {URL_A})),
        () -> assertTrue(contact.hasExtension(MISSING, URL_A)),
        () -> assertTrue(contactAsElement.hasExtension(URL_A, MISSING)),
        () -> assertTrue(ordinaryContact.hasExtension(URL_A)),
        () -> assertTrue(ordinaryContactAsElement.hasExtension(URL_A)),
        () -> assertFalse(contact.hasExtension(MISSING)),
        () -> assertFalse(contactAsElement.hasExtension(MISSING))),
      () -> assertAll("Timing dispatch",
        () -> assertTrue(timing.hasExtension(URL_A)),
        () -> assertTrue(timingAsElement.hasExtension(URL_A)),
        () -> assertTrue(timing.hasExtension(new String[] {URL_A})),
        () -> assertTrue(timingAsElement.hasExtension(new String[] {URL_A})),
        () -> assertTrue(timing.hasExtension(MISSING, URL_A)),
        () -> assertTrue(timingAsElement.hasExtension(URL_A, MISSING)),
        () -> assertTrue(ordinaryTiming.hasExtension(URL_A)),
        () -> assertTrue(ordinaryTimingAsElement.hasExtension(URL_A)),
        () -> assertFalse(timing.hasExtension(MISSING)),
        () -> assertFalse(timingAsElement.hasExtension(MISSING))),
      () -> assertAll("Patient dispatch",
        () -> assertTrue(patient.hasExtension(URL_A)),
        () -> assertTrue(patientAsResource.hasExtension(URL_A)),
        () -> assertTrue(patient.hasExtension(new String[] {URL_A})),
        () -> assertTrue(patientAsResource.hasExtension(new String[] {URL_A})),
        () -> assertTrue(patient.hasExtension(MISSING, URL_A)),
        () -> assertTrue(patientAsResource.hasExtension(URL_A, MISSING)),
        () -> assertTrue(ordinaryPatient.hasExtension(URL_A)),
        () -> assertTrue(ordinaryPatientAsResource.hasExtension(URL_A)),
        () -> assertFalse(patient.hasExtension(MISSING)),
        () -> assertFalse(patientAsResource.hasExtension(MISSING))));
  }

  @Test
  void ordinaryElementControlKeepsBothUrlOverloads() {
    HumanName name = new HumanName();
    name.addExtension(new Extension(URL_A));

    assertAll(
      () -> assertTrue(name.hasExtension(URL_A)),
      () -> assertTrue(name.hasExtension(new String[] {URL_A})),
      () -> assertTrue(name.hasExtension(MISSING, URL_A)),
      () -> assertTrue(name.hasExtension(URL_A, MISSING)),
      () -> assertFalse(name.hasExtension(MISSING)),
      () -> assertFalse(name.hasExtension(new String[] {MISSING})),
      () -> assertFalse(name.hasExtension(MISSING, OTHER_MISSING)),
      () -> assertFalse(name.hasExtension(new String[0])));
  }

  @ParameterizedTest
  @ValueSource(classes = {Element.class, BackboneElement.class, BackboneType.class, DomainResource.class})
  void urlOwnersDeclareBothSignatures(Class<?> owner) {
    assertAll(
      () -> assertEquals(boolean.class, owner.getDeclaredMethod("hasExtension", String.class).getReturnType()),
      () -> {
        Method arrayMethod = owner.getDeclaredMethod("hasExtension", String[].class);
        assertEquals(boolean.class, arrayMethod.getReturnType());
        assertTrue(arrayMethod.isVarArgs());
      });
  }

  @ParameterizedTest
  @EnumSource(SubjectType.class)
  void presenceLookupsDoNotInitializeBackingLists(SubjectType type) throws ReflectiveOperationException {
    Subject subject = type.create();
    assertNull(subject.ordinaryBacking());
    assertNull(subject.modifierBacking());

    for (int i = 0; i < 3; i++) {
      assertPresence(subject, URL_A, false);
      assertMissingQueries(subject);
      assertNull(subject.ordinaryBacking());
      assertNull(subject.modifierBacking());
    }
  }

  @ParameterizedTest
  @MethodSource("populatedSubjects")
  void presenceLookupsDoNotChangePopulatedLists(SubjectType type, Population population)
      throws ReflectiveOperationException {
    Subject subject = type.create();
    if (population != Population.MODIFIER) {
      subject.addOrdinary(new Extension(URL_A));
      subject.addOrdinary(new Extension(URL_B));
    }
    if (population != Population.ORDINARY) {
      subject.addModifier(new Extension(URL_B));
      subject.addModifier(new Extension(URL_A));
    }
    ListSnapshot ordinary = new ListSnapshot(subject.ordinary());
    ListSnapshot modifiers = new ListSnapshot(subject.modifiers());
    Object ordinaryBacking = subject.ordinaryBacking();
    Object modifierBacking = subject.modifierBacking();
    if (population == Population.MODIFIER) {
      assertNull(ordinaryBacking);
    }
    if (population == Population.ORDINARY) {
      assertNull(modifierBacking);
    }

    for (int i = 0; i < 3; i++) {
      // Return values are covered separately; this test isolates lookup side effects.
      for (String url : new String[] {URL_A, URL_B, MISSING}) {
        subject.hasExtension(url);
        subject.hasExtension(new String[] {url});
        subject.hasExtension(MISSING, url);
        subject.hasExtension(url, MISSING);
      }
      subject.hasExtension(MISSING, OTHER_MISSING);
      subject.hasExtension(new String[0]);
      assertAll(
        () -> assertSame(ordinaryBacking, subject.ordinaryBacking()),
        () -> assertSame(modifierBacking, subject.modifierBacking()),
        () -> ordinary.assertUnchanged(subject.ordinary()),
        () -> modifiers.assertUnchanged(subject.modifiers()));
    }
  }

  @ParameterizedTest
  @EnumSource(SubjectType.class)
  void stringFallbackIgnoresModifierOnlyCandidates(SubjectType type) {
    Subject subject = type.create();
    if (type != SubjectType.HUMAN_NAME) {
      subject.addModifier(stringExtension(URL_A, "modifier"));
    }
    subject.addOrdinary(stringExtension(URL_B, "ordinary"));

    assertAll(
      () -> assertEquals("ordinary", subject.getExtensionString(new String[] {URL_A, URL_B})),
      () -> assertEquals("ordinary", subject.getExtensionString(URL_A, URL_B)),
      () -> assertNull(subject.getExtensionString(new String[] {URL_A})),
      () -> assertEquals("ordinary", subject.getExtensionString(new String[] {URL_B, URL_A})),
      () -> assertEquals("ordinary", subject.getExtensionString(URL_B, URL_A)));
  }

  @ParameterizedTest
  @EnumSource(SubjectType.class)
  void stringFallbackStopsAtFirstOrdinaryMatch(SubjectType type) {
    Subject subject = type.create();
    subject.addOrdinary(stringExtension(URL_B, "second"));
    subject.addOrdinary(stringExtension(URL_A, "first"));

    assertAll(
      () -> assertEquals("first", subject.getExtensionString(new String[] {URL_A, URL_B})),
      () -> assertEquals("first", subject.getExtensionString(URL_A, URL_B)),
      () -> assertEquals("second", subject.getExtensionString(new String[] {URL_B, URL_A})),
      () -> assertEquals("second", subject.getExtensionString(URL_B, URL_A)));

    if (type == SubjectType.PATIENT) {
      Subject valueless = type.create();
      valueless.addOrdinary(new Extension(URL_A));
      valueless.addOrdinary(stringExtension(URL_B, "later"));
      assertAll(
        () -> assertNull(valueless.getExtensionString(URL_A)),
        () -> assertNull(valueless.getExtensionString(new String[] {URL_A, URL_B})),
        () -> assertNull(valueless.getExtensionString(URL_A, URL_B)),
        () -> assertEquals("later", valueless.getExtensionString(URL_B, URL_A)));
    }
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "PATIENT"})
  void stringFallbackRetainsScalarGetterErrors(SubjectType type) {
    Subject duplicates = type.create();
    duplicates.addOrdinary(stringExtension(URL_A, "first"));
    duplicates.addOrdinary(stringExtension(URL_A, "duplicate"));
    duplicates.addOrdinary(stringExtension(URL_B, "later"));

    Subject nonprimitive = type.create();
    HumanName value = new HumanName().setText("nonempty nonprimitive value");
    assertFalse(value.isEmpty());
    nonprimitive.addOrdinary(new Extension(URL_A, value));
    nonprimitive.addOrdinary(stringExtension(URL_B, "later"));

    assertAll(
      () -> assertStringLookupFails(duplicates),
      () -> assertStringLookupFails(nonprimitive));

    if (type == SubjectType.CONTACT) {
      Subject acrossLists = type.create();
      acrossLists.addOrdinary(stringExtension(URL_A, "ordinary"));
      acrossLists.addModifier(stringExtension(URL_A, "modifier"));
      acrossLists.addOrdinary(stringExtension(URL_B, "later"));
      assertStringLookupFails(acrossLists);
    }
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "PATIENT"})
  void scalarStringGetterKeepsItsExistingCollectionScope(SubjectType type) {
    Subject subject = type.create();
    subject.addModifier(stringExtension(URL_A, "modifier"));
    subject.addOrdinary(stringExtension(URL_B, "ordinary"));

    assertAll(
      () -> assertEquals(type == SubjectType.CONTACT ? "modifier" : null, subject.getExtensionString(URL_A)),
      () -> assertEquals("ordinary", subject.getExtensionString(URL_B)),
      () -> assertNull(subject.getExtensionString(MISSING)));
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING"})
  void copyNewExtensionsChecksOrdinaryDestinationOnly(SubjectType type) {
    Subject subject = type.create();
    Element destination = (Element) subject.value;
    subject.addModifier(stringExtension(URL_A, "modifier"));
    HumanName source = new HumanName();
    Extension sourceExtension = stringExtension(URL_A, "source");
    source.addExtension(sourceExtension);
    ListSnapshot sourceBefore = new ListSnapshot(source.getExtensionsForRead());
    ListSnapshot modifiersBefore = new ListSnapshot(subject.modifiers());

    destination.copyNewExtensions(source, URL_A);

    assertEquals(1, destination.getExtensionsForRead().size());
    Extension copied = destination.getExtensionsForRead().get(0);
    assertAll(
      () -> assertEquals(URL_A, copied.getUrl()),
      () -> assertEquals("source", copied.getValue().primitiveValue()),
      () -> assertNotSame(sourceExtension, copied),
      () -> assertNotSame(sourceExtension.getValue(), copied.getValue()),
      () -> assertTrue(sourceExtension.equalsDeep(copied)),
      () -> sourceBefore.assertUnchanged(source.getExtensionsForRead()),
      () -> modifiersBefore.assertUnchanged(subject.modifiers()));
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "HUMAN_NAME"})
  void copyNewExtensionsRemainsFilteredAndIdempotent(SubjectType type) {
    Element destination = (Element) type.create().value;
    Extension existing = stringExtension(URL_A, "destination");
    destination.addExtension(existing);
    HumanName source = new HumanName();
    source.addExtension(stringExtension(URL_A, "replacement"));
    Extension firstNew = stringExtension(URL_B, "first new value");
    source.addExtension(firstNew);
    source.addExtension(stringExtension(URL_B, "duplicate new value"));
    source.addExtension(stringExtension(URL_C, "unrequested"));
    ListSnapshot sourceBefore = new ListSnapshot(source.getExtensionsForRead());

    destination.copyNewExtensions(source, URL_A, URL_B, MISSING);

    assertEquals(2, destination.getExtensionsForRead().size());
    Extension copied = destination.getExtensionsForRead().get(1);
    assertAll(
      () -> assertSame(existing, destination.getExtensionsForRead().get(0)),
      () -> assertEquals("destination", existing.getValue().primitiveValue()),
      () -> assertEquals(URL_B, copied.getUrl()),
      () -> assertEquals("first new value", copied.getValue().primitiveValue()),
      () -> assertNotSame(firstNew, copied),
      () -> assertFalse(destination.hasExtension(URL_C)),
      () -> assertFalse(destination.hasExtension(MISSING)));
    ListSnapshot destinationBeforeRepeat = new ListSnapshot(destination.getExtensionsForRead());

    destination.copyNewExtensions(source, URL_A, URL_B, MISSING);
    destination.copyNewExtensions(source, MISSING);
    destination.copyNewExtensions(source, new String[0]);

    assertAll(
      () -> destinationBeforeRepeat.assertUnchanged(destination.getExtensionsForRead()),
      () -> sourceBefore.assertUnchanged(source.getExtensionsForRead()));
  }

  @Test
  void fullPackageIdRetainsOrdinaryScopeEligibility() {
    ImplementationGuide noScope = new ImplementationGuide();
    noScope.setPackageId("pkg");
    ImplementationGuide modifierOnly = new ImplementationGuide();
    modifierOnly.setPackageId("pkg");
    modifierOnly.addModifierExtension(stringExtension(ExtensionConstants.EXT_PACKAGE_SCOPE, "scope"));
    ImplementationGuide ordinaryScope = new ImplementationGuide();
    ordinaryScope.setPackageId("pkg");
    ordinaryScope.addExtension(stringExtension(ExtensionConstants.EXT_PACKAGE_SCOPE, "scope"));

    assertAll(
      () -> assertEquals("pkg", noScope.getFullPackageId()),
      () -> assertEquals("pkg", modifierOnly.getFullPackageId()),
      // The array overload keeps this helper characterization independent of the scalar repair.
      () -> assertTrue(modifierOnly.hasExtension(new String[] {ExtensionConstants.EXT_PACKAGE_SCOPE})),
      () -> assertEquals("@scope/pkg", ordinaryScope.getFullPackageId()));

    ordinaryScope.addModifierExtension(stringExtension(URL_A, "unrelated"));
    assertEquals("@scope/pkg", ordinaryScope.getFullPackageId());
  }

  @ParameterizedTest
  @EnumSource(value = SubjectType.class, names = {"CONTACT", "TIMING", "HUMAN_NAME"})
  void presentationRetainsPrimitiveFallbackForModifierOnlyHolder(SubjectType type) {
    String renderedUrl = ExtensionDefinitions.EXT_RENDERED_VALUE;
    Subject modifierOnly = type.create();
    if (type != SubjectType.HUMAN_NAME) {
      modifierOnly.addModifier(stringExtension(renderedUrl, "modifier"));
    }
    StringType renderedPrimitive = new StringType("fallback");
    renderedPrimitive.addExtension(stringExtension(renderedUrl, "primitive rendered"));
    StringType rawPrimitive = new StringType("fallback");
    Element holder = (Element) modifierOnly.value;

    Subject ordinary = type.create();
    ordinary.addOrdinary(stringExtension(renderedUrl, "holder rendered"));
    Element ordinaryHolder = (Element) ordinary.value;
    Subject valueless = type.create();
    valueless.addOrdinary(new Extension(renderedUrl));
    Element valuelessHolder = (Element) valueless.value;

    assertAll(
      () -> assertEquals("primitive rendered", ExtensionUtilities.getPresentation(holder, renderedPrimitive)),
      () -> assertEquals("fallback", ExtensionUtilities.getPresentation(holder, rawPrimitive)),
      () -> assertEquals("holder rendered", ExtensionUtilities.getPresentation(ordinaryHolder, renderedPrimitive)),
      () -> assertEquals("holder rendered", ExtensionUtilities.getPresentation(ordinaryHolder, rawPrimitive)),
      () -> assertNull(ExtensionUtilities.getPresentation(valuelessHolder, renderedPrimitive)),
      () -> assertNull(ExtensionUtilities.getPresentation(valuelessHolder, rawPrimitive)));

    modifierOnly.addOrdinary(stringExtension(renderedUrl, "holder rendered"));
    // Once eligible, the existing reader still prefers a ContactComponent's same-URL modifier.
    String expected = type == SubjectType.CONTACT ? "modifier" : "holder rendered";
    assertAll(
      () -> assertEquals(expected, ExtensionUtilities.getPresentation(holder, renderedPrimitive)),
      () -> assertEquals(expected, ExtensionUtilities.getPresentation(holder, rawPrimitive)));
  }

  private static Extension stringExtension(String url, String value) {
    return new Extension(url, new StringType(value));
  }

  private static void assertPresence(Subject subject, String url, boolean expected) {
    assertAll(
      () -> assertEquals(expected, subject.hasExtension(url), "scalar URL"),
      () -> assertEquals(expected, subject.hasExtension(new String[] {url}), "explicit singleton array"),
      () -> assertEquals(expected, subject.hasExtension(MISSING, url), "miss then target"),
      () -> assertEquals(expected, subject.hasExtension(url, MISSING), "target then miss"));
  }

  private static void assertMissingQueries(Subject subject) {
    assertAll(
      () -> assertFalse(subject.hasExtension(MISSING)),
      () -> assertFalse(subject.hasExtension(new String[] {MISSING})),
      () -> assertFalse(subject.hasExtension(MISSING, OTHER_MISSING)),
      () -> assertFalse(subject.hasExtension(OTHER_MISSING, MISSING)),
      () -> assertFalse(subject.hasExtension(new String[0])));
  }

  private static void assertStringLookupFails(Subject subject) {
    assertAll(
      () -> assertThrows(FHIRException.class, () -> subject.getExtensionString(URL_A)),
      () -> assertThrows(FHIRException.class, () -> subject.getExtensionString(new String[] {URL_A})),
      () -> assertThrows(FHIRException.class, () -> subject.getExtensionString(new String[] {URL_A, URL_B})),
      () -> assertThrows(FHIRException.class, () -> subject.getExtensionString(URL_A, URL_B)));
  }

  static Stream<Arguments> populatedSubjects() {
    return Stream.of(SubjectType.values()).flatMap(type -> {
      Stream<Population> populations = type == SubjectType.HUMAN_NAME
        ? Stream.of(Population.ORDINARY) : Stream.of(Population.values());
      return populations.map(population -> Arguments.of(type, population));
    });
  }

  private enum Population {
    ORDINARY, MODIFIER, BOTH
  }

  private enum SubjectType {
    CONTACT, TIMING, PATIENT, HUMAN_NAME;

    private Subject create() {
      return new Subject(switch (this) {
        case CONTACT -> new Patient.ContactComponent();
        case TIMING -> new Timing();
        case PATIENT -> new Patient();
        case HUMAN_NAME -> new HumanName();
      });
    }
  }

  private static class ListSnapshot {
    private final List<Extension> list;
    private final List<Extension> entries;
    private final List<Extension> contents = new ArrayList<>();

    private ListSnapshot(List<Extension> list) {
      this.list = list;
      this.entries = new ArrayList<>(list);
      for (Extension entry : list) {
        contents.add(entry.copy(Base.COPY_ALL));
      }
    }

    private void assertUnchanged(List<Extension> actual) {
      if (!entries.isEmpty()) {
        assertSame(list, actual);
      }
      assertEquals(entries.size(), actual.size());
      for (int i = 0; i < entries.size(); i++) {
        assertSame(entries.get(i), actual.get(i));
        assertTrue(contents.get(i).equalsDeep(actual.get(i)), "extension contents at index " + i);
      }
    }
  }

  private static class Subject {
    private final Base value;

    private Subject(Base value) {
      this.value = value;
    }

    private void addOrdinary(Extension extension) {
      if (value instanceof Element element) {
        element.addExtension(extension);
      } else {
        ((DomainResource) value).addExtension(extension);
      }
    }

    private void addModifier(Extension extension) {
      if (value instanceof BackboneElement element) {
        element.addModifierExtension(extension);
      } else if (value instanceof BackboneType type) {
        type.addModifierExtension(extension);
      } else {
        ((DomainResource) value).addModifierExtension(extension);
      }
    }

    private boolean hasExtension(String url) {
      if (value instanceof Element element) {
        return element.hasExtension(url);
      }
      return ((DomainResource) value).hasExtension(url);
    }

    private boolean hasExtension(String[] urls) {
      // Pass the array intact; unwrapping it would accidentally test the scalar overload again.
      if (value instanceof Element element) {
        return element.hasExtension(urls);
      }
      return ((DomainResource) value).hasExtension(urls);
    }

    private boolean hasExtension(String first, String second) {
      if (value instanceof Element element) {
        return element.hasExtension(first, second);
      }
      return ((DomainResource) value).hasExtension(first, second);
    }

    private String getExtensionString(String url) {
      if (value instanceof Element element) {
        return element.getExtensionString(url);
      }
      return ((DomainResource) value).getExtensionString(url);
    }

    private String getExtensionString(String[] urls) {
      if (value instanceof Element element) {
        return element.getExtensionString(urls);
      }
      return ((DomainResource) value).getExtensionString(urls);
    }

    private String getExtensionString(String first, String second) {
      if (value instanceof Element element) {
        return element.getExtensionString(first, second);
      }
      return ((DomainResource) value).getExtensionString(first, second);
    }

    private List<Extension> ordinary() {
      if (value instanceof Element element) {
        return element.getExtensionsForRead();
      }
      return ((DomainResource) value).getExtensionsForRead();
    }

    private List<Extension> modifiers() {
      if (value instanceof BackboneElement element) {
        return element.getModifierExtensionsForRead();
      }
      if (value instanceof BackboneType type) {
        return type.getModifierExtensionsForRead();
      }
      if (value instanceof DomainResource resource) {
        return resource.getModifierExtensionsForRead();
      }
      return Collections.emptyList();
    }

    private Object ordinaryBacking() throws ReflectiveOperationException {
      Class<?> owner = value instanceof DomainResource ? DomainResource.class : Element.class;
      return backingField(owner, "extensionList");
    }

    private Object modifierBacking() throws ReflectiveOperationException {
      if (value instanceof BackboneElement) {
        return backingField(BackboneElement.class, "modifierExtensionList");
      }
      if (value instanceof BackboneType) {
        return backingField(BackboneType.class, "modifierExtensionList");
      }
      if (value instanceof DomainResource) {
        return backingField(DomainResource.class, "modifierExtensionList");
      }
      return null;
    }

    private Object backingField(Class<?> owner, String name) throws ReflectiveOperationException {
      Field field = owner.getDeclaredField(name);
      field.setAccessible(true);
      return field.get(value);
    }
  }
}
