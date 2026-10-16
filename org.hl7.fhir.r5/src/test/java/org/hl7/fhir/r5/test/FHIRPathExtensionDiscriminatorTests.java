package org.hl7.fhir.r5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.TypedElementDefinition;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FHIRPathExtensionDiscriminatorTests {
  private static final String KIND_URL = "http://example.org/StructureDefinition/link-kind";
  private FHIRPathEngine engine;
  private StructureDefinition profile;

  @BeforeEach
  void setUp() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    StructureDefinition extension = new StructureDefinition();
    extension.setUrl(KIND_URL);
    extension.setType("Extension");
    extension.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Extension");
    extension.getSnapshot().addElement().setPath("Extension");
    context.cacheResource(extension);
    engine = new FHIRPathEngine(context);
    profile = new StructureDefinition();
    profile.setUrl("http://example.org/StructureDefinition/Patient");
    add("Patient", "Patient", null);
  }

  private ElementDefinition add(String id, String path, String slice) {
    ElementDefinition element = profile.getSnapshot().addElement();
    element.setId(id);
    element.setPath(path);
    if (slice != null) {
      element.setSliceName(slice);
    }
    return element;
  }

  private ElementDefinition link(String slice, boolean slicing) {
    String id = "Patient.link" + (slice == null ? "" : ":" + slice);
    ElementDefinition element = add(id, "Patient.link", slice);
    element.addType().setCode("BackboneElement");
    if (slicing) {
      element.getSlicing().setRules(SlicingRules.OPEN);
    }
    // A normal child prevents resolution from chasing the BackboneElement type.
    add(id + ".type", "Patient.link.type", null).addType().setCode("code");
    return element;
  }

  private ElementDefinition kind(ElementDefinition owner, String value) {
    String id = owner.getId() + ".extension:kind";
    ElementDefinition extension = add(id, "Patient.link.extension", "kind");
    extension.addType().setCode("Extension").addProfile(KIND_URL);
    ElementDefinition result = add(id + ".value[x]", "Patient.link.extension.value[x]", null);
    result.addType().setCode("code");
    if (value != null) {
      result.setFixed(new CodeType(value));
    }
    return result;
  }

  private ElementDefinition resolve(ElementDefinition element) {
    return engine.evaluateDefinition(engine.parse("extension('" + KIND_URL + "').value.ofType(code)"),
        profile, new TypedElementDefinition(element), profile, false).getElement();
  }

  @Test
  void resolvesUnconstrainedExtensionFromSlicingEntry() {
    ElementDefinition inherited = kind(link(null, true), null);
    ElementDefinition slice = link("added", false);
    assertSame(inherited, resolve(slice));
  }

  @Test
  void preservesSliceSpecificValue() {
    kind(link(null, true), "entry");
    ElementDefinition slice = link("added", false);
    ElementDefinition local = kind(slice, "local");
    assertSame(local, resolve(slice));
    assertEquals("local", resolve(slice).getFixed().primitiveValue());
  }

  @Test
  void resolvesResliceFromParentBeforeEntry() {
    kind(link(null, true), "entry");
    ElementDefinition inherited = kind(link("parent", true), "parent");
    ElementDefinition reslice = link("parent/child", false);
    assertSame(inherited, resolve(reslice));
  }

  @Test
  void resolvesNestedResliceThroughAncestors() {
    kind(link(null, true), "entry");
    ElementDefinition inherited = kind(link("parent", true), "parent");
    link("parent/child", true);
    ElementDefinition reslice = link("parent/child/grandchild", false);
    assertSame(inherited, resolve(reslice));
  }

  @Test
  void resolvesResliceFromEntryWhenParentDoesNotDefineExtension() {
    ElementDefinition inherited = kind(link(null, true), "entry");
    link("parent", true);
    ElementDefinition reslice = link("parent/child", false);
    assertSame(inherited, resolve(reslice));
  }

  @Test
  void doesNotUseUnrelatedSiblingSlice() {
    ElementDefinition inherited = kind(link(null, true), "entry");
    kind(link("sibling", true), "sibling");
    ElementDefinition slice = link("added", false);
    assertSame(inherited, resolve(slice));
  }

  @Test
  void doesNotConfuseSliceNamePrefixes() {
    ElementDefinition inherited = kind(link(null, true), "entry");
    kind(link("a", true), "a");
    link("ab", true);
    ElementDefinition reslice = link("ab/child", false);
    assertSame(inherited, resolve(reslice));
  }

  @Test
  void stillRejectsUnknownExtension() {
    link(null, true);
    ElementDefinition slice = link("added", false);
    assertThrows(FHIRException.class, () -> resolve(slice));
  }

  @Test
  void unslicedElementStillRejectsUnknownExtension() {
    ElementDefinition unsliced = link(null, false);
    assertThrows(FHIRException.class, () -> resolve(unsliced));
  }
}
