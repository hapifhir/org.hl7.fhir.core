package org.hl7.fhir.model;

import org.hl7.fhir.model.core.Constants;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
