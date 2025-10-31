package org.hl7.fhir.convertors.txClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.utilities.FhirPublication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

public class TerminologyClientFactoryTest {

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    List<Arguments> objects = new ArrayList<>();
    objects.addAll(getDefaultServerArgs("tx.fhir.org/r4", "tx.fhir.org", FhirPublication.R4));
    objects.addAll(getHttpAndHttpsArgs("tx.fhir.org", null, "tx.fhir.org/r4"));
    objects.addAll(getHttpAndHttpsArgs("tx.fhir.org/r4", null, "tx.fhir.org/r4"));
    objects.addAll(getDefaultServerArgs("tx.fhir.org/r3", "tx.fhir.org", FhirPublication.DSTU2016May));
    objects.addAll(getDefaultServerArgs("tx.fhir.org/r4", "tx.fhir.org", FhirPublication.R4B));
    objects.addAll(getDefaultServerArgs("tx.fhir.org/r5", "tx.fhir.org", FhirPublication.R5));
    objects.addAll(getDefaultServerArgs("tx.fhir.org/r3", "tx.fhir.org", FhirPublication.STU3));
    objects.addAll(getHttpAndHttpsArgs("someserver.org", FhirPublication.R4, "someserver.org"));
    objects.addAll(getHttpAndHttpsArgs("someserver.org", null, "someserver.org"));
    return objects.stream();
  }

  private static List<Arguments> getDefaultServerArgs(String explicitUrl, String baseUrl, FhirPublication fhirPublication) {
    List<Arguments> objects = new ArrayList<>();
    objects.addAll(getHttpAndHttpsArgs(baseUrl, fhirPublication, explicitUrl));
    objects.addAll(getHttpAndHttpsArgs(explicitUrl, fhirPublication, explicitUrl));
    return objects;
  }

  private static List<Arguments> getHttpAndHttpsArgs(String baseUrl, FhirPublication fhirPublication, String baseExpectedAddress) {
    return List.of(
      Arguments.of("https://" + baseUrl, fhirPublication, "https://" + baseExpectedAddress),
      Arguments.of("http://" + baseUrl, fhirPublication, "http://" + baseExpectedAddress)
    );
  }

  @ParameterizedTest
  @MethodSource("data")
  public void testMakeClient(String url, FhirPublication fhirPublication, String expectedAddress) throws URISyntaxException {
    ITerminologyClient terminologyClient = new TerminologyClientFactory(fhirPublication).makeClient("id", url, "dummyUserAgent", null);
    assertEquals(expectedAddress, terminologyClient.getAddress());
  }

  @Test
  public void testMakeClientDstu1Fails() throws URISyntaxException {
    assertThrows(Error.class, () -> {
        ITerminologyClient terminologyClient = new TerminologyClientFactory(FhirPublication.DSTU1).makeClient("id", "urldoesnotmatter", "dummyUserAgent", null);
      }
    );
  }

  @Test
  public void testMakeClientNullFails() throws URISyntaxException {
    assertThrows(Error.class, () -> {
        ITerminologyClient terminologyClient = new TerminologyClientFactory(FhirPublication.NULL).makeClient("id", "urldoesnotmatter", "dummyUserAgent", null);
      }
    );
  }
}
