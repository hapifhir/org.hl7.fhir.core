package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Test;

/** The expectation files on a FHIR 5.0.0 validator, the version they are written for. */
class MatchetypeExpectationFilesR5Test extends MatchetypeExpectationFilesTestBase {

  /** An expansion as an R4 server sends it: contains.property is R5-only, so R4 carries it as the cross-version extension. */
  private static final String R4_RESPONSE = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{"
    + "\"identifier\":\"urn:uuid:c0ffee00-0000-4000-8000-000000000001\",\"timestamp\":\"2026-01-01T00:00:00Z\","
    + "\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true}],"
    + "\"contains\":[{\"extension\":[{\"extension\":[{\"url\":\"code\",\"valueCode\":\"status\"},{\"url\":\"value\",\"valueCode\":\"retired\"}],"
    + "\"url\":\"http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.contains.property\"}],"
    + "\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"abstract\":true,\"inactive\":true,\"code\":\"code2\",\"display\":\"Display 2\"}]}}";

  /** The same expansion as the test set's R5-shaped expected file lists it. */
  private static final String R5_PATTERN = "{\"resourceType\":\"ValueSet\",\"status\":\"active\",\"expansion\":{"
    + "\"identifier\":\"$uuid$\",\"timestamp\":\"$instant$\","
    + "\"parameter\":[{\"name\":\"excludeNested\",\"valueBoolean\":true}],"
    + "\"contains\":[{\"system\":\"http://hl7.org/fhir/test/CodeSystem/simple\",\"abstract\":true,\"inactive\":true,\"code\":\"code2\",\"display\":\"Display 2\","
    + "\"property\":[{\"code\":\"status\",\"valueCode\":\"retired\"}]}]}}";

  @Override
  protected String corePackage() {
    return "hl7.fhir.r5.core#5.0.0";
  }

  @Override
  protected String fhirVersion() {
    return "5.0.0";
  }

  @Override
  protected int port() {
    return 18092;
  }

  @Override
  protected boolean definesR5Content() {
    return true;
  }

  /**
   * simple-cases / simple-expand-all against an R4 server: the terminology test runner
   * converts the R4 answer to R5 before comparing, which turns the cross-version extension
   * into the {@code property} the expected file lists. With {@code version} the service does
   * the same; without it the R4 answer is read as R5 and the property is missing.
   */
  @Test
  void r4ResponseComparesAgainstR5PatternWhenItsVersionIsGiven() throws Exception {
    JsonObject with = compare(R4_RESPONSE, R5_PATTERN, false, anyContent("version", "4.0.1"));
    assertEquals("SUCCESS", with.asString("result"), failures(with));

    JsonObject without = compare(R4_RESPONSE, R5_PATTERN, false, anyContent("version", "5.0.0"));
    assertEquals("FAILURE", without.asString("result"), failures(without));
    assertTrue(JsonParser.compose(without).contains("missing element property"), failures(without));
  }
}
