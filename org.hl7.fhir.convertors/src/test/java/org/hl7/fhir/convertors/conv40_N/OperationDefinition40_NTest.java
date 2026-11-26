package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.OperationDefinition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * R4 OperationDefinition has no copyright: R6's goes in a cross-version extension, but only when there is one
 */
class OperationDefinition40_NTest {

  private static final String COPYRIGHT_EXT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-OperationDefinition.copyright";

  private OperationDefinition operation() {
    OperationDefinition src = new OperationDefinition();
    src.setUrl("http://example.org/OperationDefinition/op");
    src.setName("Op");
    src.setStatus(Enumerations.PublicationStatus.DRAFT);
    src.setKind(OperationDefinition.OperationKind.OPERATION);
    src.setCode("op");
    src.setSystem(true);
    src.setType(false);
    src.setInstance(false);
    return src;
  }

  @Test
  @DisplayName("copyright goes in a cross-version extension")
  void testCopyright() {
    OperationDefinition src = operation();
    src.setCopyright("(c) Example");
    org.hl7.fhir.r4.model.OperationDefinition r4 = (org.hl7.fhir.r4.model.OperationDefinition) VersionConvertorFactory_40_N.convertResource(src);
    assertEquals("(c) Example", r4.getExtensionByUrl(COPYRIGHT_EXT).getValue().primitiveValue());
  }

  @Test
  @DisplayName("an empty copyright element makes no extension (the IG publisher's apply-copyright made one for IGs without a copyright)")
  void testEmptyCopyright() {
    OperationDefinition src = operation();
    src.getCopyrightElement(); // makes an empty one
    org.hl7.fhir.r4.model.OperationDefinition r4 = (org.hl7.fhir.r4.model.OperationDefinition) VersionConvertorFactory_40_N.convertResource(src);
    assertFalse(r4.hasExtension(COPYRIGHT_EXT));
  }
}
