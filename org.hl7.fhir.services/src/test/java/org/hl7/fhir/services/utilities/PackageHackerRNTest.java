package org.hl7.fhir.services.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.PackageInformation;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.UriType;
import org.hl7.fhir.model.core.UrlType;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PackageHackerRNTest {

  /**
   * the shape of quantity-confidenceInterval as published: sub-extension slices with no url
   */
  private StructureDefinition makeExtension(boolean withDiffUrl) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl("http://hl7.org/fhir/StructureDefinition/quantity-confidenceInterval");
    sd.setType("Extension");
    for (String n : new String[] {"confidence", "interval"}) {
      addElement(sd.getDifferential().getElementList(), "Extension.extension:"+n, "Extension.extension");
      if (withDiffUrl) {
        addElement(sd.getDifferential().getElementList(), "Extension.extension:"+n+".url", "Extension.extension.url");
      }
      addElement(sd.getDifferential().getElementList(), "Extension.extension:"+n+".value[x]", "Extension.extension.value[x]");
      addElement(sd.getSnapshot().getElementList(), "Extension.extension:"+n, "Extension.extension");
      addElement(sd.getSnapshot().getElementList(), "Extension.extension:"+n+".url", "Extension.extension.url");
      addElement(sd.getSnapshot().getElementList(), "Extension.extension:"+n+".value[x]", "Extension.extension.value[x]");
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
    PackageHackerRN.fixSubExtensionUrl(sd, name);
    PackageHackerRN.fixSubExtensionUrl(sd, name); // idempotent

    ElementDefinition diffUrl = null;
    int sliceIndex = -1;
    int urlIndex = -1;
    int urlCount = 0;
    for (int i = 0; i < sd.getDifferential().getElementList().size(); i++) {
      ElementDefinition ed = sd.getDifferential().getElementList().get(i);
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

    for (ElementDefinition ed : sd.getSnapshot().getElementList()) {
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
      addElement(sd.getDifferential().getElementList(), "Extension", "Extension");
      sd.getDifferential().getElementList().get(0).setMax("1");
    }
    addElement(sd.getDifferential().getElementList(), "Extension.extension:htmlid", "Extension.extension");
    sd.getDifferential().getElementList().get(sd.getDifferential().getElementList().size()-1).setMax("*");
    addElement(sd.getSnapshot().getElementList(), "Extension", "Extension");
    sd.getSnapshot().getElementList().get(0).setMax("1");
    addElement(sd.getSnapshot().getElementList(), "Extension.extension:data", "Extension.extension");
    sd.getSnapshot().getElementList().get(1).setMax("1");

    PackageHackerRN.fixRootMax(sd, "*");

    assertEquals("*", sd.getSnapshot().getElementList().get(0).getMax());
    assertEquals("1", sd.getSnapshot().getElementList().get(1).getMax());
    if (inDiff) {
      assertEquals("*", sd.getDifferential().getElementList().get(0).getMax());
    } else {
      assertEquals(1, sd.getDifferential().getElementList().size()); // doesn't add a root element to the differential
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
    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElementList(), sd.getSnapshot().getElementList())) {
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
    Extension before = sd.getSnapshot().getElementList().get(0).getTypeFirstRep().getExtensionByUrl(ExtensionDefinitions.EXT_FHIR_TYPE);

    PackageHackerRN.fixLoadedResource(sd);
    PackageHackerRN.fixLoadedResource(sd); // idempotent

    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElementList(), sd.getSnapshot().getElementList())) {
      TypeRefComponent t = list.get(0).getTypeFirstRep();
      assertEquals("http://hl7.org/fhirpath/System.String", t.getCode());
      assertEquals(1, t.getExtensionsByUrl(ExtensionDefinitions.EXT_FHIR_TYPE).size());
      assertEquals("id", t.getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
      assertEquals("string", list.get(1).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
    }
    if ("id".equals(fhirType)) {
      // already right: nothing is written (#2470 - shared definitions must not be modified)
      assertSame(before, sd.getSnapshot().getElementList().get(0).getTypeFirstRep().getExtensionByUrl(ExtensionDefinitions.EXT_FHIR_TYPE));
    }
  }

  /**
   * DSTU2 and STU3 give Resource.id the type 'id' itself, with no fhir-type extension: that's right, and isn't
   * touched (the fix is for R4 and later, which give it as System.String)
   */
  @Test
  void leavesResourceIdTypedAsIdAlone() {
    StructureDefinition sd = makeResourceWithId(null);
    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElementList(), sd.getSnapshot().getElementList())) {
      list.get(0).getTypeFirstRep().setCode("id");
    }

    PackageHackerRN.fixLoadedResource(sd);

    for (List<ElementDefinition> list : List.of(sd.getDifferential().getElementList(), sd.getSnapshot().getElementList())) {
      TypeRefComponent t = list.get(0).getTypeFirstRep();
      assertEquals("id", t.getCode());
      assertFalse(t.hasExtension(ExtensionDefinitions.EXT_FHIR_TYPE));
    }
  }

  @Test
  void fixPackageResourceAppliesRegistrationAndLoadHacks() {
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://terminology.hl7.org/CodeSystem/v2-0391|2.6");
    cs.setVersion("2.6");
    PackageHackerRN.fixPackageResource(cs, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    assertEquals("http://terminology.hl7.org/CodeSystem/v2-0391-2.6", cs.getUrl());
    assertEquals("2.6", cs.getVersion());

    StructureDefinition sd = makeResourceWithId("string");
    PackageHackerRN.fixPackageResource(sd, new PackageInformation("hl7.fhir.r4.core", "4.0.1", "4.0.1", new Date()));
    assertEquals("id", sd.getSnapshot().getElementList().get(0).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
    assertEquals("http://example.org/StructureDefinition/test-patient", sd.getUrl());
  }

  @Test
  void fixPackageResourceWithoutPackageInformation() {
    // no package information: only the load hacks apply
    CodeSystem cs = new CodeSystem();
    cs.setUrl("http://terminology.hl7.org/CodeSystem/v2-0391|2.6");
    PackageHackerRN.fixPackageResource(cs, null);
    assertEquals("http://terminology.hl7.org/CodeSystem/v2-0391|2.6", cs.getUrl());

    StructureDefinition sd = makeResourceWithId("string");
    PackageHackerRN.fixPackageResource(sd, null);
    assertEquals("id", sd.getSnapshot().getElementList().get(0).getTypeFirstRep().getExtensionString(ExtensionDefinitions.EXT_FHIR_TYPE));
  }
}
