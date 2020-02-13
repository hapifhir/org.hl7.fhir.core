package org.hl7.fhir.dstu3.test;

import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Meta;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetaTest {
  public static String TEST_SYSTEM = "TEST_SYSTEM";
  public static String TEST_CODE = "TEST_CODE";

  @Test
  public void testMetaSecurity() {
    Meta meta = new Meta();
    Coding coding = meta.addSecurity().setSystem(TEST_SYSTEM).setCode(TEST_CODE);
    assertTrue(meta.hasSecurity());
    assertNotNull(meta.getSecurity());
    assertNotNull(meta.getSecurity(TEST_SYSTEM, TEST_CODE));
    assertEquals(1, meta.getSecurity().size());
    assertEquals(meta.getSecurity().get(0), meta.getSecurity(TEST_SYSTEM, TEST_CODE));
    assertEquals(meta.getSecurityFirstRep(), meta.getSecurity(TEST_SYSTEM, TEST_CODE));
    assertEquals(coding, meta.getSecurity(TEST_SYSTEM, TEST_CODE));
  }
}

