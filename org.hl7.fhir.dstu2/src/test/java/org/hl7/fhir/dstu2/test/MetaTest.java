package org.hl7.fhir.dstu2.test;

import org.hl7.fhir.dstu2.model.Coding;
import org.hl7.fhir.dstu2.model.Meta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MetaTest {
  public static String TEST_SYSTEM = "TEST_SYSTEM";
  public static String TEST_CODE = "TEST_CODE";

  @Test
  public void testMetaSecurity() {
    Meta meta = new Meta();
    Coding coding = meta.addSecurity().setSystem(TEST_SYSTEM).setCode(TEST_CODE);
    Assertions.assertTrue(meta.hasSecurity());
    Assertions.assertNotNull(meta.getSecurity());
    Assertions.assertNotNull(meta.getSecurity(TEST_SYSTEM, TEST_CODE));
    Assertions.assertEquals(1, meta.getSecurity().size());
    Assertions.assertEquals(meta.getSecurity().get(0), meta.getSecurity(TEST_SYSTEM, TEST_CODE));
    Assertions.assertEquals(coding, meta.getSecurity(TEST_SYSTEM, TEST_CODE));
  }
}
