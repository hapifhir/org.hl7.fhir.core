package org.hl7.fhir.dstu3.test.support.client;

import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.dstu3.support.utils.client.FHIRToolingClient;
import org.hl7.fhir.dstu3.support.utils.client.network.Client;
import org.hl7.fhir.dstu3.support.utils.client.network.ResourceRequest;
import org.hl7.fhir.utilities.http.HTTPHeader;
import org.hl7.fhir.utilities.http.HTTPRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FhirToolingClientTest {
  String TX_ADDR = "http://tx.fhir.org";

  HTTPHeader h1 = new HTTPHeader("header1", "value1");
  HTTPHeader h2 = new HTTPHeader("header2", "value2");
  HTTPHeader h3 = new HTTPHeader("header3", "value3");

  HTTPHeader agentHeader = new HTTPHeader("User-Agent", "fhir/test-cases");

  private Client mockClient;
  private FHIRToolingClient toolingClient;

  @Captor
  private ArgumentCaptor<Iterable<HTTPHeader>> headersArgumentCaptor;


  @BeforeEach
  void setUp() throws IOException, URISyntaxException {
    MockitoAnnotations.openMocks(this);
    mockClient = Mockito.mock(Client.class);
    ResourceRequest<Resource> resourceResourceRequest = new ResourceRequest<>(generateBundle(), 200, "");

    // GET
    Mockito.when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
      ArgumentMatchers.any(), Mockito.anyString(), Mockito.anyLong())).thenReturn(resourceResourceRequest);
    Mockito
      .when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
        ArgumentMatchers.any(), Mockito.eq("TerminologyCapabilities"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new Parameters(), 200, "location"));
    Mockito
      .when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
        ArgumentMatchers.any(), Mockito.eq("CapabilitiesStatement"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new CapabilityStatement(), 200, "location"));
    Mockito
      .when(mockClient.issueGetResourceRequest(Mockito.any(URI.class), Mockito.anyString(),
        ArgumentMatchers.any(), Mockito.eq("CapabilitiesStatement-Quick"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new CapabilityStatement(), 200, "location"));

    // PUT
    Mockito.when(mockClient.issuePutRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
      ArgumentMatchers.any(), Mockito.anyString(), Mockito.anyLong())).thenReturn(resourceResourceRequest);
    // POST
    Mockito.when(mockClient.issuePostRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
      ArgumentMatchers.any(), Mockito.anyString(), Mockito.anyLong())).thenReturn(resourceResourceRequest);
    Mockito
      .when(mockClient.issuePostRequest(Mockito.any(URI.class), Mockito.any(byte[].class), Mockito.anyString(),
        ArgumentMatchers.any(), Mockito.contains("validate"), Mockito.anyLong()))
      .thenReturn(new ResourceRequest<>(new OperationOutcome(), 200, "location"));
    // BUNDLE REQ
    Mockito
      .when(mockClient.executeBundleRequest(Mockito.any(HTTPRequest.class), Mockito.anyString(),
        ArgumentMatchers.any(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyLong()))
      .thenReturn(generateBundle());
    toolingClient = new FHIRToolingClient(TX_ADDR, "fhir/test-cases");
    toolingClient.setClient(mockClient);
  }

  private List<HTTPHeader> getHeaders() {
    return new ArrayList<>(Arrays.asList(h1, h2, h3));
  }

  private List<HTTPHeader> getHeadersWithAgent() {
    return new ArrayList<>(Arrays.asList(h1, h2, h3, agentHeader));
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
    bundle.addEntry().setFullUrl(patient.getIdElement().getValue()).setResource(patient).getRequest().setUrl("Patient")
      .setIfNoneExist("identifier=http://acme.org/mrns|12345").setMethod(Bundle.HTTPVerb.POST);

    return bundle;
  }

  private Patient generatePatient() {
    // Create a patient object
    Patient patient = new Patient();
    patient.addIdentifier().setSystem("http://acme.org/mrns").setValue("12345");
    patient.addName().setFamily("Jameson").addGiven("J").addGiven("Jonah");
    patient.setGender(Enumerations.AdministrativeGender.MALE);

    // Give the patient a temporary UUID so that other resources in
    // the transaction can refer to it
    patient.setId(IdType.newRandomUuid());
    return patient;
  }

  private Observation generateObservation() {
    // Create an observation object
    Observation observation = new Observation();
    observation.getCode().addCoding().setSystem("http://loinc.org").setCode("789-8")
      .setDisplay("Erythrocytes [#/volume] in Blood by Automated count");
    observation.setValue(new Quantity().setValue(4.12).setUnit("10 trillion/L").setSystem("http://unitsofmeasure.org")
      .setCode("10*12/L"));
    return observation;
  }

  private void checkHeaders(Iterable<HTTPHeader> argumentCaptorValue) {
    List<HTTPHeader> capturedHeaders = new ArrayList<>();
    argumentCaptorValue.forEach(capturedHeaders::add);

    getHeadersWithAgent().forEach(header -> {
      assertTrue(capturedHeaders.contains(header));
    });
  }

  @Test
  void getTerminologyCapabilities() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getTerminologyCapabilities();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCapabilitiesStatement() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCapabilitiesStatement();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCapabilitiesStatementQuick() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCapabilitiesStatementQuick();
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void read() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.read(Patient.class, "id");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void vread() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.vread(Patient.class, "id", "version");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void getCanonical() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.getCanonical(Patient.class, "canonicalURL");
    Mockito.verify(mockClient).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(),
      headersArgumentCaptor.capture(), ArgumentMatchers.anyString(), ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void update() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.update(generatePatient());
    Mockito.verify(mockClient).issuePutRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.any(byte[].class),
      ArgumentMatchers.anyString(), headersArgumentCaptor.capture(), ArgumentMatchers.anyString(),
      ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }

  @Test
  void validate() throws IOException {
    toolingClient.setClientHeaders(getHeaders());
    toolingClient.validate(Patient.class, generatePatient(), "id");
    Mockito.verify(mockClient).issuePostRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.any(byte[].class),
      ArgumentMatchers.anyString(), headersArgumentCaptor.capture(), ArgumentMatchers.anyString(),
      ArgumentMatchers.anyLong());

    Iterable<HTTPHeader> argumentCaptorValue = headersArgumentCaptor.getValue();
    checkHeaders(argumentCaptorValue);
  }
}
