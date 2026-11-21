package org.hl7.fhir.r5.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.UrlType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PackageHackerR5Test {

  /**
   * the shape of quantity-confidenceInterval as published: sub-extension slices with no url
   */
  private StructureDefinition makeExtension(boolean withDiffUrl) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl("http://hl7.org/fhir/StructureDefinition/quantity-confidenceInterval");
    sd.setType("Extension");
    for (String n : new String[] {"confidence", "interval"}) {
      addElement(sd.getDifferential().getElement(), "Extension.extension:"+n, "Extension.extension");
      if (withDiffUrl) {
        addElement(sd.getDifferential().getElement(), "Extension.extension:"+n+".url", "Extension.extension.url");
      }
      addElement(sd.getDifferential().getElement(), "Extension.extension:"+n+".value[x]", "Extension.extension.value[x]");
      addElement(sd.getSnapshot().getElement(), "Extension.extension:"+n, "Extension.extension");
      addElement(sd.getSnapshot().getElement(), "Extension.extension:"+n+".url", "Extension.extension.url");
      addElement(sd.getSnapshot().getElement(), "Extension.extension:"+n+".value[x]", "Extension.extension.value[x]");
    }
    return sd;
  }

  private void addElement(java.util.List<ElementDefinition> list, String id, String path) {
    ElementDefinition ed = new ElementDefinition();
    ed.setId(id);
    ed.setPath(path);
    list.add(ed);
  }

  private static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of(false, "confidence"),
      Arguments.of(false, "interval"),
      Arguments.of(true, "confidence"),
      Arguments.of(true, "interval"));
  }

  @ParameterizedTest
  @MethodSource("cases")
  void fixesSubExtensionUrl(boolean withDiffUrl, String name) {
    StructureDefinition sd = makeExtension(withDiffUrl);
    PackageHackerR5.fixSubExtensionUrl(sd, name);
    PackageHackerR5.fixSubExtensionUrl(sd, name); // idempotent

    ElementDefinition diffUrl = null;
    int sliceIndex = -1;
    int urlIndex = -1;
    int urlCount = 0;
    for (int i = 0; i < sd.getDifferential().getElement().size(); i++) {
      ElementDefinition ed = sd.getDifferential().getElement().get(i);
      if (("Extension.extension:"+name).equals(ed.getId())) {
        sliceIndex = i;
      }
      if (("Extension.extension:"+name+".url").equals(ed.getId())) {
        diffUrl = ed;
        urlIndex = i;
        urlCount++;
      }
    }
    assertNotNull(diffUrl);
    assertEquals(1, urlCount);
    assertEquals(sliceIndex + 1, urlIndex);
    assertEquals("Extension.extension.url", diffUrl.getPath());
    assertEquals(name, ((UriType) diffUrl.getFixed()).getValue());

    for (ElementDefinition ed : sd.getSnapshot().getElement()) {
      if (("Extension.extension:"+name+".url").equals(ed.getId())) {
        assertEquals(name, ((UriType) ed.getFixed()).getValue());
      }
    }
  }

  @ParameterizedTest
  @MethodSource("rootMaxCases")
  void fixesRootMax(boolean inDiff) {
    // textLink as published (FHIR-59812): root max = 1
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl("http://hl7.org/fhir/StructureDefinition/textLink");
    sd.setType("Extension");
    if (inDiff) {
      addElement(sd.getDifferential().getElement(), "Extension", "Extension");
      sd.getDifferential().getElement().get(0).setMax("1");
    }
    addElement(sd.getDifferential().getElement(), "Extension.extension:htmlid", "Extension.extension");
    sd.getDifferential().getElement().get(sd.getDifferential().getElement().size()-1).setMax("*");
    addElement(sd.getSnapshot().getElement(), "Extension", "Extension");
    sd.getSnapshot().getElement().get(0).setMax("1");
    addElement(sd.getSnapshot().getElement(), "Extension.extension:data", "Extension.extension");
    sd.getSnapshot().getElement().get(1).setMax("1");

    PackageHackerR5.fixRootMax(sd, "*");

    assertEquals("*", sd.getSnapshot().getElement().get(0).getMax());
    assertEquals("1", sd.getSnapshot().getElement().get(1).getMax());
    if (inDiff) {
      assertEquals("*", sd.getDifferential().getElement().get(0).getMax());
    } else {
      assertEquals(1, sd.getDifferential().getElement().size()); // doesn't add a root element to the differential
    }
  }

  private static Stream<Arguments> rootMaxCases() {
    return Stream.of(Arguments.of(true), Arguments.of(false));
  }

  /**
   * an element based on Resource.id, with the fhir-type extension as R4 publishes it ('string'), with none, or already right
   */
  private StructureDefinition makeResourceWithId(String fhirType) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl("http://example.org/StructureDefinition/test-patient");
    sd.setType("Patient");
    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElement(), sd.getSnapshot().getElement())) {
      ElementDefinition ed = new ElementDefinition();
      ed.setId("Patient.id");
      ed.setPath("Patient.id");
      ed.getBase().setPath("Resource.id");
      TypeRefComponent t = ed.addType().setCode("http://hl7.org/fhirpath/System.String");
      if (fhirType != null) {
        t.addExtension(ExtensionDefinitions.EXT_FHIR_TYPE, new UrlType(fhirType));
      }
      list.add(ed);
      // Element.id is a string, and must stay that way
      ElementDefinition eid = new ElementDefinition();
      eid.setId("Patient.contact.id");
      eid.setPath("Patient.contact.id");
      eid.getBase().setPath("Element.id");
      eid.addType().setCode("http://hl7.org/fhirpath/System.String").addExtension(ExtensionDefinitions.EXT_FHIR_TYPE, new UrlType("string"));
      list.add(eid);
    }
    return sd;
  }

  private static Stream<Arguments> resourceIdCases() {
    return Stream.of(Arguments.of("string"), Arguments.of((String) null), Arguments.of("id"));
  }

  @ParameterizedTest
  @MethodSource("resourceIdCases")
  void fixesResourceIdType(String fhirType) {
    StructureDefinition sd = makeResourceWithId(fhirType);
    Extension before = sd.getSnapshot().getElement().get(0).getTypeFirstRep().getExtensionByUrl(ExtensionDefinitions.EXT_FHIR_TYPE);

    PackageHackerR5.fixLoadedResource(sd);
    PackageHackerR5.fixLoadedResource(sd); // idempotent

    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElement(), sd.getSnapshot().getElement())) {
      TypeRefComponent t = list.get(0).getTypeFirstRep();
      assertEquals("http://hl7.org/fhirpath/System.String", t.getCode());
      assertEquals(1, t.getExtensionsByUrl(ExtensionDefinitions.EXT_FHIR_TYPE).size());
      assertEquals("id", t.getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
      assertEquals("string", list.get(1).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
    }
    if ("id".equals(fhirType)) {
      // already right: nothing is written (#2470 - shared definitions must not be modified)
      assertSame(before, sd.getSnapshot().getElement().get(0).getTypeFirstRep().getExtensionByUrl(ExtensionDefinitions.EXT_FHIR_TYPE));
    }
  }

  @Test
  void fixPackageResourceAppliesRegistrationAndLoadHacks() {
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://terminology.hl7.org/CodeSystem/v2-0391|2.6");
    cs.setVersion("2.6");
    PackageHackerR5.fixPackageResource(cs, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    assertEquals("http://terminology.hl7.org/CodeSystem/v2-0391-2.6", cs.getUrl());
    assertEquals("2.6", cs.getVersion());

    StructureDefinition sd = makeResourceWithId("string");
    PackageHackerR5.fixPackageResource(sd, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    assertEquals("id", sd.getSnapshot().getElement().get(0).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
    assertEquals("http://example.org/StructureDefinition/test-patient", sd.getUrl());
  }

  @Test
  void fixPackageResourceWithoutPackageInformation() {
    // no package information: only the load hacks apply
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://terminology.hl7.org/CodeSystem/v2-0391|2.6");
    PackageHackerR5.fixPackageResource(cs, null);
    assertEquals("http://terminology.hl7.org/CodeSystem/v2-0391|2.6", cs.getUrl());

    StructureDefinition sd = makeResourceWithId("string");
    PackageHackerR5.fixPackageResource(sd, null);
    assertEquals("id", sd.getSnapshot().getElement().get(0).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
  }
}
