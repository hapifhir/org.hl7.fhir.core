package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Test;

/**
 * The FHIR version of the server under test decides which client is used and which version gated
 * tests run, so TxTester refuses to run without it. These cover the two probes' interpretation -
 * the refusal itself needs a server, so it is not covered here.
 */
class TxTesterVersionTests {

  private JsonObject json(String src) throws Exception {
    return JsonParser.parseObject(src);
  }

  @Test
  void versionFromVersionsReadsParametersDefault() throws Exception {
    List<String> issues = new ArrayList<>();
    String v = TxTester.versionFromVersions(json("{\"resourceType\":\"Parameters\",\"parameter\":["+
        "{\"name\":\"version\",\"valueString\":\"4.0\"},{\"name\":\"default\",\"valueString\":\"5.0\"}]}"), issues);
    assertEquals("5.0", v);
    assertTrue(issues.isEmpty());
  }

  @Test
  void versionFromVersionsReadsBareDefault() throws Exception {
    List<String> issues = new ArrayList<>();
    assertEquals("4.0.1", TxTester.versionFromVersions(json("{\"versions\":[\"4.0.1\"],\"default\":\"4.0.1\"}"), issues));
    assertTrue(issues.isEmpty());
  }

  @Test
  void versionFromVersionsReportsParametersWithNoDefault() throws Exception {
    List<String> issues = new ArrayList<>();
    assertNull(TxTester.versionFromVersions(json("{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"version\",\"valueString\":\"4.0\"}]}"), issues));
    assertEquals(1, issues.size());
    assertTrue(issues.get(0).contains("default"));
  }

  @Test
  void versionFromVersionsReportsUnrecognisedResponse() throws Exception {
    List<String> issues = new ArrayList<>();
    assertNull(TxTester.versionFromVersions(json("{\"resourceType\":\"OperationOutcome\"}"), issues));
    assertEquals(1, issues.size());
    assertTrue(issues.get(0).contains("Unable to interpret"));
  }

  @Test
  void versionFromMetadataReadsCapabilityStatement() throws Exception {
    List<String> issues = new ArrayList<>();
    assertEquals("4.0.1", TxTester.versionFromMetadata(json("{\"resourceType\":\"CapabilityStatement\",\"fhirVersion\":\"4.0.1\"}"), issues));
    assertTrue(issues.isEmpty());
  }

  @Test
  void versionFromMetadataNamesTheWrongResourceType() throws Exception {
    List<String> issues = new ArrayList<>();
    assertNull(TxTester.versionFromMetadata(json("{\"resourceType\":\"TerminologyCapabilities\",\"status\":\"active\"}"), issues));
    assertEquals(1, issues.size());
    assertTrue(issues.get(0).contains("TerminologyCapabilities"));
    assertTrue(issues.get(0).contains("mode=terminology"));
  }

  @Test
  void versionFromMetadataReportsCapabilityStatementWithNoVersion() throws Exception {
    List<String> issues = new ArrayList<>();
    assertNull(TxTester.versionFromMetadata(json("{\"resourceType\":\"CapabilityStatement\",\"status\":\"active\"}"), issues));
    assertEquals(1, issues.size());
    assertTrue(issues.get(0).contains("no fhirVersion"));
  }
}
