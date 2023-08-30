package org.hl7.fhir.r4b.utils.client;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.internal.http2.Header;
import org.hl7.fhir.r4b.model.*;
import org.hl7.fhir.r4b.utils.client.network.Client;
import org.hl7.fhir.r4b.utils.client.network.ResourceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

class FHIRToolingClientTest {

  String TX_ADDR = "http://tx.fhir.org";

  Header h1 = new Header("header1", "value1");
  Header h2 = new Header("header2", "value2");
  Header h3 = new Header("header3", "value3");

  private Client mockClient;
  private FHIRToolingClient toolingClient;

  @BeforeEach
  void setUp() throws IOException, URISyntaxException {
    mockClient = Mockito.mock(Client.class);
    ResourceRequest<Resource> resourceResourceRequest = new ResourceRequest<>(generateBundle(), 200, "");

    //GET
    Mockito.when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.anyString(), Mockito.anyLong()))
      .thenReturn(resourceResourceRequest);
    Mockito.when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.eq("TerminologyCapabilities"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new TerminologyCapabilities(), 200, "location"));
    Mockito.when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.eq("CapabilitiesStatement"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new CapabilityStatement(), 200, "location"));
    Mockito.when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.eq("CapabilitiesStatement-Quick"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new CapabilityStatement(), 200, "location"));

    //PUT
    Mockito.when(mockClient.issuePutRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.anyString(), Mockito.anyLong()))
      .thenReturn(resourceResourceRequest);
    //POST
    Mockito.when(mockClient.issuePostRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.anyString(), Mockito.anyLong()))
      .thenReturn(resourceResourceRequest);
    Mockito.when(mockClient.issuePostRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.contains("validate"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new OperationOutcome(), 200, "location"));
    //BUNDLE REQ
    Mockito.when(mockClient.executeBundleRequest(Mockito.any(Request.Builder.class), Mockito.anyString(),
      Mockito.any(Headers.class), Mockito.anyString(), Mockito.anyInt(), Mockito.anyLong()))
      .thenReturn(generateBundle());
    toolingClient = new FHIRToolingClient(TX_ADDR, "fhir/test-cases");
    toolingClient.setClient(mockClient);
  }

  private ArrayList<Header> getHeaders() {
    return new ArrayList<>(Arrays.asList(h1, h2, h3));
  }

  private Bundle generateBundle() {
    Patient patient = generatePatient();
    Observation observation = generateObservation();

    // The observation refers to the patient using the ID, which is already
    // set to a temporary UUID
    observation.setSubject(new Reference(patient.getIdElement().getValue()));

    // Create a bundle that will be used as a transaction
    Bundle bundle = new Bundle();

    // Add the patient as an entry.
    bundle.addEntry()
      .setFullUrl(patient.getIdElement().getValue())
      .setResource(patient)
      .getRequest()
      .setUrl("Patient")
      .setIfNoneExist("identifier=http://acme.org/mrns|12345")
      .setMethod(Bundle.HTTPVerb.POST);

    return bundle;
  }

  private Patient generatePatient() {
    // Create a patient object
    Patient patient = new Patient();
    patient.addIdentifier()
      .setSystem("http://acme.org/mrns")
      .setValue("12345");
    patient.addName()
      .setFamily("Jameson")
      .addGiven("J")
      .addGiven("Jonah");
    patient.setGender(Enumerations.AdministrativeGender.MALE);

    // Give the patient a temporary UUID so that other resources in
    // the transaction can refer to it
    patient.setId(IdType.newRandomUuid());
    return patient;
  }

  private Observation generateObservation() {
    // Create an observation object
    Observation observation = new Observation();
    observation
      .getCode()
      .addCoding()
      .setSystem("http://loinc.org")
      .setCode("789-8")
      .setDisplay("Erythrocytes [#/volume] in Blood by Automated count");
    observation.setValue(
      new Quantity()
        .setValue(4.12)
        .setUnit("10 trillion/L")
        .setSystem("http://unitsofmeasure.org")
        .setCode("10*12/L"));
    return observation;
  }

  private void checkHeaders(Headers argumentCaptorValue) {
    getHeaders().forEach(header -> {
//      System.out.println("Checking header <" + header.component1().utf8() + ", " + header.component2().utf8() + ">");
      Assertions.assertEquals(argumentCaptorValue.get(header.component1().utf8()), header.component2().utf8());
    });
  }

  @Test
  void getTerminologyCapabilities() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getTerminologyCapabilities();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCapabilitiesStatement() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCapabilitiesStatement();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCapabilitiesStatementQuick() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCapabilitiesStatementQuick();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void read() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.read(Patient.class, "id");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void vread() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.vread(Patient.class, "id", "version");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCanonical() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCanonical(Patient.class, "canonicalURL");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void update() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.update(generatePatient());
    Mockito.verify(mockClient).issuePutRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.any(byte[].class),
      ArgumentMatchers.anyString(), headersArgumentCaptor.capture(), ArgumentMatchers.anyString(),
      ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void validate() throws IOException {
    ArgumentCaptor<Headers> headersArgumentCaptor = ArgumentCaptor.forClass(Headers.class);
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.validate(Patient.class, generatePatient(), "id");
    Mockito.verify(mockClient).issuePostRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.any(byte[].class),
      ArgumentMatchers.anyString(), headersArgumentCaptor.capture(), ArgumentMatchers.anyString(),
      ArgumentMatchers.anyLong());

    Headers argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }
}