package org.hl7.fhir.services.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.UriType;
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
}
