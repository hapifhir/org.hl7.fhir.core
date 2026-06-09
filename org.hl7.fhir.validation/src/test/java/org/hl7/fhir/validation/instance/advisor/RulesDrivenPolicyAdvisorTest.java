package org.hl7.fhir.validation.instance.advisor;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.json.JsonException;
import org.junit.jupiter.api.Test;

class RulesDrivenPolicyAdvisorTest {

  @Test
  void jsonDrivenAdvisorSuppressesCompliesWithReasons() throws JsonException, IOException {
    String source = "{\n"
      + "  \"suppress-complies-with\": [\n"
      + "    \"http://example.org/Profile@Patient.name\",\n"
      + "    \"*@Observation.code\",\n"
      + "    \"http://example.org/Any@*\",\n"
      + "    \"http://example.org/ProfileOnly\"\n"
      + "  ]\n"
      + "}";

    JsonDrivenPolicyAdvisor advisor = new JsonDrivenPolicyAdvisor(baseAdvisor(), "advisor.json", source);

    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.name"));
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.birthDate"));
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Other", "Observation.code"));
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Any", "Patient.birthDate"));
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/ProfileOnly", "Patient.birthDate"));
  }

  @Test
  void textDrivenAdvisorSuppressesCompliesWithReasons() throws JsonException, IOException {
    String source = "- SOME_MESSAGE@Patient\n"
      + "= http://example.org/Profile@Patient.name\n"
      + "= http://example.org/Sub@Patient.name.*\n"
      + "= *@Observation.code\n";

    TextDrivenPolicyAdvisor advisor = new TextDrivenPolicyAdvisor(baseAdvisor(), "advisor.txt", source);

    assertTrue(advisor.isSuppressMessageId("Patient", "SOME_MESSAGE"));
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.name"));
    // consistent with messageId@path: a bare path matches only exactly, not sub-paths or slices
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.name.given"));
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.name:official.given"));
    // an explicit trailing wildcard matches sub-paths
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Sub", "Patient.name.given"));
    // but slices are not normalized, so the wildcard does not reach into a slice
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Sub", "Patient.name:official.given"));
    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Other", "Observation.code"));
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Profile", "Patient.birthDate"));
  }

  @Test
  void rulesDrivenAdvisorDelegatesToBaseAdvisor() {
    RulesDrivenPolicyAdvisor advisor = new RulesDrivenPolicyAdvisor(new DelegatingAdvisor());

    assertTrue(advisor.isSuppressCompliesWithReason("http://example.org/Base", "Patient.name"));
    assertFalse(advisor.isSuppressCompliesWithReason("http://example.org/Base", "Patient.birthDate"));
  }

  private static BasePolicyAdvisorForFullValidation baseAdvisor() {
    return new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.CHECK_VALID, null);
  }

  private static class DelegatingAdvisor extends BasePolicyAdvisorForFullValidation {

    private DelegatingAdvisor() {
      super(ReferenceValidationPolicy.CHECK_VALID, null);
    }

    public boolean isSuppressCompliesWithReason(String claimedProfileUrl, String elementPath) {
      return "http://example.org/Base".equals(claimedProfileUrl) && "Patient.name".equals(elementPath);
    }
  }
}
