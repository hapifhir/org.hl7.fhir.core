package org.hl7.fhir.convertors.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

class VersionConvertorContextTest {

  @Test
  void pathFollowsInitAndClose() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    Object convertor = new Object();
    assertThrows(FHIRException.class, context::getPath);

    context.init(convertor, "Bundle");
    assertEquals("Bundle", context.getPath());
    context.init(new Object(), "Patient");
    assertEquals("Bundle.Patient", context.getPath());
    context.init(convertor, "Extension.value");
    assertEquals("Bundle.Patient.Extension.value", context.getPath());
    assertSame(convertor, context.getVersionConvertor());

    context.close("Extension.value");
    assertEquals("Bundle.Patient", context.getPath());
    context.close("Patient");
    assertEquals("Bundle", context.getPath());
    context.close("Bundle");
    assertThrows(FHIRException.class, context::getPath);
    assertNull(context.getVersionConvertor());
  }

  @Test
  void closingTheWrongPathStillPopsIt() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    context.init(new Object(), "Bundle");
    context.init(new Object(), "Patient");
    assertThrows(FHIRException.class, () -> context.close("Observation"));
    assertEquals("Bundle", context.getPath());
  }

  @Test
  void closingWithNothingOpen() {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    assertThrows(FHIRException.class, () -> context.close("Bundle"));
  }

  @Test
  void eachThreadHasItsOwnPath() throws InterruptedException {
    VersionConvertorContext<Object> context = new VersionConvertorContext<>();
    context.init(new Object(), "Bundle");
    String[] other = new String[1];
    Thread t = new Thread(() -> {
      context.init(new Object(), "Patient");
      other[0] = context.getPath();
      context.close("Patient");
    });
    t.start();
    t.join();
    assertEquals("Patient", other[0]);
    assertEquals("Bundle", context.getPath());
  }
}
