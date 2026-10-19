package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.StringType;
import org.junit.jupiter.api.Test;

/**
 * Every closure test names the same closure table, so each run puts its own suffix on the name:
 * two runs against one server at the same time then build separate tables.
 */
class TxTesterClosureTableTests {

  @Test
  void theTableNameGetsTheRunSuffix() {
    Parameters p = new Parameters();
    p.addParameter().setName("name").setValue(new StringType("55e02fcb-d7a6-46db-94b4-3c3a4b619f7c"));
    p.addParameter().setName("concept").setValue(new Coding("http://hl7.org/fhir/test/CodeSystem/simple", "code2a", null));

    TxTester.useRunClosureTable(p, "run-1");

    assertEquals("55e02fcb-d7a6-46db-94b4-3c3a4b619f7c-run-1", p.getParameterValue("name").primitiveValue());
    assertEquals("code2a", ((Coding) p.getParameterValue("concept")).getCode());
  }

  @Test
  void theNameStaysShortEnoughForAServer() {
    String fixed = "55e02fcb-d7a6-46db-94b4-3c3a4b619f7c";
    String tooLong = "x".repeat(70);
    Parameters a = new Parameters();
    a.addParameter().setName("name").setValue(new StringType(fixed));
    Parameters b = new Parameters();
    b.addParameter().setName("name").setValue(new StringType(tooLong));

    TxTester.useRunClosureTable(a, "1a2b3c4d");
    TxTester.useRunClosureTable(b, "1a2b3c4d");

    assertEquals(fixed + "-1a2b3c4d", a.getParameterValue("name").primitiveValue());
    String cut = b.getParameterValue("name").primitiveValue();
    assertEquals(TxTester.CLOSURE_NAME_MAX_LENGTH, cut.length());
    assertTrue(cut.endsWith("-1a2b3c4d"));
  }

  @Test
  void twoRunsUseTwoTables() {
    Parameters a = new Parameters();
    a.addParameter().setName("name").setValue(new StringType("t"));
    Parameters b = new Parameters();
    b.addParameter().setName("name").setValue(new StringType("t"));

    TxTester.useRunClosureTable(a, "run-1");
    TxTester.useRunClosureTable(b, "run-2");

    assertEquals("t-run-1", a.getParameterValue("name").primitiveValue());
    assertEquals("t-run-2", b.getParameterValue("name").primitiveValue());
  }
}
