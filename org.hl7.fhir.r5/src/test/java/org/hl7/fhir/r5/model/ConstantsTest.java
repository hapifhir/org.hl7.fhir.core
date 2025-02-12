package org.hl7.fhir.r5.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConstantsTest {

  @Test
  public void testUrlRegex() {
    String testUrl1 = "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/Patient/263778";
    String testUrl2 =
        "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/Patient/263778/_history/1";
    String testUrl3 = "http://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/Patient/263778";
    String testUrl4 =
        "http://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/Patient/263778/_history/1";
    String invalidUrl =
        "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/InvalidResource/263778";

    assertTrue(testUrl1.matches(Constants.URI_REGEX));
    assertTrue(testUrl2.matches(Constants.URI_REGEX));
    assertTrue(testUrl3.matches(Constants.URI_REGEX));
    assertTrue(testUrl4.matches(Constants.URI_REGEX));
    assertFalse(invalidUrl.matches(Constants.URI_REGEX));
  }

  @Test
  public void testUrlRegexXver() {
    String testUrl1 = "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/r5/Patient/263778";
    String testUrl2 =
        "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/r5/Patient/263778/_history/1";
    String testUrl3 = "http://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/r5/Patient/263778";
    String testUrl4 =
        "http://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/r5/Patient/263778/_history/1";
    String invalidUrl =
        "https://rd-vm01.rd.dtcs.local/iM1AS_QO999/api/v1/fhir/r5/InvalidResource/263778";

    // Mock IWorkerContext to return resource names
    IWorkerContext context = Mockito.mock(IWorkerContext.class);
    Mockito.when(context.getResourceNames())
        .thenReturn(List.of("Patient", "Observation", "Condition"));

    // Generate regex
    String regexXver =
        Constants.URI_REGEX_XVER.replace(
            "$$", CommaSeparatedStringBuilder.join("|", context.getResourceNames()));

    // Test URL matching
    assertTrue(testUrl1.matches(regexXver));
    assertTrue(testUrl2.matches(regexXver));
    assertTrue(testUrl3.matches(regexXver));
    assertTrue(testUrl4.matches(regexXver));
    assertFalse(invalidUrl.matches(regexXver));
  }
}
