package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;

import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.StringType;
import org.junit.jupiter.api.Test;

/**
 * Every closure test names the same closure table, so each run replaces the name with its own
 * UUID: two runs against one server at the same time then build separate tables.
 */
class TxTesterClosureTableTests {

  private static Parameters request(String name) {
    Parameters p = new Parameters();
    p.addParameter().setName("name").setValue(new StringType(name));
    p.addParameter().setName("concept").setValue(new Coding("http://hl7.org/fhir/test/CodeSystem/simple", "code2a", null));
    return p;
  }

  @Test
  void theNameIsReplacedAndNothingElse() {
    Parameters p = request("55e02fcb-d7a6-46db-94b4-3c3a4b619f7c");
    String run = UUID.randomUUID().toString();

    TxTester.useRunClosureTable(p, run);

    assertEquals(run, p.getParameterValue("name").primitiveValue());
    assertEquals("code2a", ((Coding) p.getParameterValue("concept")).getCode());
  }

  @Test
  void twoRunsUseTwoTables() {
    TxTester a = new TxTester(null, "http://example.org/fhir", false, null, null);
    TxTester b = new TxTester(null, "http://example.org/fhir", false, null, null);
    Parameters pa = request("t");
    Parameters pb = request("t");

    TxTester.useRunClosureTable(pa, a.closureTableName());
    TxTester.useRunClosureTable(pb, b.closureTableName());

    assertNotEquals(pa.getParameterValue("name").primitiveValue(), pb.getParameterValue("name").primitiveValue());
    UUID.fromString(pa.getParameterValue("name").primitiveValue());
  }
}
