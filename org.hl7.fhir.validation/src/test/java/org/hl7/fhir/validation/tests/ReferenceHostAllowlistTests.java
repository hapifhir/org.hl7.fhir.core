package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * {@link ValidationEngine#policyForReference} ignores references that are not on an HL7 or
 * FHIR Foundation host. That decision is made on the parsed host, not by substring - a URL
 * that merely mentions {@code hl7.org} in its path or query is not an HL7 host.
 */
class ReferenceHostAllowlistTests {

  @ParameterizedTest
  @DisplayName("HL7 and FHIR Foundation hosts, and their subdomains, qualify")
  @ValueSource(strings = {
    "http://hl7.org/fhir/StructureDefinition/Patient",
    "https://hl7.org/fhir/R4/patient.html",
    "https://terminology.hl7.org/CodeSystem/v3-ActCode",
    "http://www.hl7.org/fhir",
    "https://fhir.org/guides/example",
    "https://build.fhir.org/ig/HL7/fhir-ig/",
    "https://packages.fhir.org/hl7.fhir.r4.core/4.0.1",
    "HTTPS://HL7.ORG/FHIR"
  })
  void hl7AndFhirHostsQualify(String url) {
    assertTrue(ValidationEngine.isHl7OrFhirHost(url), url);
  }

  @ParameterizedTest
  @DisplayName("A URL that only mentions the name in its path or query does not qualify")
  @ValueSource(strings = {
    "https://attacker.example/?hl7.org",
    "https://attacker.example/hl7.org/fhir/StructureDefinition/Patient",
    "https://attacker.example/fhir.org",
    "https://simplifier.net/packages/hl7.org.something",
    "https://evilhl7.org/fhir",
    "https://fhir.org.attacker.example/",
    "https://hl7.org.attacker.example/"
  })
  void lookalikesDoNotQualify(String url) {
    assertFalse(ValidationEngine.isHl7OrFhirHost(url), url);
  }

  @ParameterizedTest
  @DisplayName("Relative references, non-URL schemes and garbage are not HL7 hosts")
  @ValueSource(strings = {
    "Patient/123",
    "#contained",
    "urn:uuid:5c8b5b77-9c5e-4a18-a0d6-4d4d4c2f0f2c",
    "urn:oid:2.16.840.1.113883",
    "hl7.org",
    "not a url at all",
    ""
  })
  void nonHostReferencesDoNotQualify(String url) {
    assertFalse(ValidationEngine.isHl7OrFhirHost(url), url);
  }

  @Test
  @DisplayName("null is not an HL7 host")
  void nullDoesNotQualify() {
    assertFalse(ValidationEngine.isHl7OrFhirHost(null));
  }
}
