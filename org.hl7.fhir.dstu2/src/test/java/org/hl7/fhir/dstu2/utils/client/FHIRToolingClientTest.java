package org.hl7.fhir.dstu2.utils.client;

import org.hl7.fhir.dstu2.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class FHIRToolingClientTest {

  private final Address address = new Address()
    .setCity("Toronto")
    .setState("Ontario")
    .setCountry("Canada");
  private final HumanName humanName = new HumanName()
    .addGiven("Mark")
    .addFamily("Iantorno");
  private final Patient patient = new Patient()
    .addName(humanName)
    .addAddress(address)
    .setGender(Enumerations.AdministrativeGender.MALE);

  private ClientUtils mockClientUtils;
  private FHIRToolingClient toolingClient;

  @Captor
  private ArgumentCaptor<URI> uriArgumentCaptor;

  @BeforeEach
  public void beforeEach() throws URISyntaxException {
    MockitoAnnotations.openMocks(this);
    mockClientUtils = Mockito.mock(ClientUtils.class);

    toolingClient = new FHIRToolingClient("http://dummy-base-url.com", "dummy-user-agent") {
      @Override
      protected ClientUtils getClientUtils() {
        return mockClientUtils;
      }
    };

    /*
    Need to reset here. When initialized, the client makes a call to getConformanceStatementQuick, which messes with
    our expected calls.
    */
    reset(mockClientUtils);
  }

  @Test
  public void testGetTerminologyCapabilities() throws URISyntaxException {

    Parameters expectedCapabilities = new Parameters();
    expectedCapabilities.addParameter().setName("name").setValue(new StringType("dummyValue"));

    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(expectedCapabilities, 200, "location"));
    Parameters actualCapabilities = toolingClient.getTerminologyCapabilities();

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualCapabilities).isEqualTo(expectedCapabilities);

    assertThat(uriArgumentCaptor.getValue()).isEqualTo(new URI("http://dummy-base-url.com/metadata?mode=terminology"));
  }

  @Test
  public void testGetConformanceStatement() throws URISyntaxException {

    Conformance expectedConformance = new Conformance();
    expectedConformance.setCopyright("dummyCopyright");
    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(expectedConformance, 200, "location"));
    Conformance actualConformance = toolingClient.getConformanceStatement();

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualConformance).isEqualTo(expectedConformance);

    assertThat(uriArgumentCaptor.getValue()).isEqualTo(new URI("http://dummy-base-url.com/metadata"));
  }

  @Test
  public void testGetConformanceStatementQuick() throws URISyntaxException {

    Conformance expectedConformance = new Conformance();
    expectedConformance.setCopyright("dummyCopyright");
    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(expectedConformance, 200, "location"));
    Conformance actualConformance = toolingClient.getConformanceStatementQuick();

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualConformance).isEqualTo(expectedConformance);

    assertThat(uriArgumentCaptor.getValue()).isEqualTo(new URI("http://dummy-base-url.com/metadata?_summary=true"));
  }

  @Test
  void testRead() {
    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(patient, 200, "location"));
    Patient actualPatient = toolingClient.read(Patient.class, "id");

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualPatient).isEqualTo(patient);

    assertThat(uriArgumentCaptor.getValue().toString()).isEqualTo("http://dummy-base-url.com/Patient/id");
  }

  @Test
  void testVRead() {
    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(patient, 200, "location"));
    Patient actualPatient = toolingClient.vread(Patient.class, "id", "version");

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualPatient).isEqualTo(patient);

    assertThat(uriArgumentCaptor.getValue().toString()).isEqualTo("http://dummy-base-url.com/Patient/id/_history/version");
  }

  @Test
  void testCanonical() {
    Bundle bundle = new Bundle();
    bundle.addEntry().setResource(patient);
    when(mockClientUtils.issueGetResourceRequest(uriArgumentCaptor.capture(), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(bundle, 200, "location"));
    Patient actualPatient = toolingClient.getCanonical(Patient.class, "canonicalURL");

    Mockito.verify(mockClientUtils).issueGetResourceRequest(ArgumentMatchers.any(URI.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
    assertThat(actualPatient).isEqualTo(patient);

    assertThat(uriArgumentCaptor.getValue().toString()).isEqualTo("http://dummy-base-url.com/Patient?url=canonicalURL");
  }

  @Test
  void testUpdate() {
    final byte[] dummyBytes = "dummyBytes".getBytes();
    when(mockClientUtils.getResourceAsByteArray(any(Patient.class), anyBoolean(), anyBoolean())).thenReturn(dummyBytes);
    when(mockClientUtils.issuePutRequest(uriArgumentCaptor.capture(), Mockito.any(byte[].class), Mockito.anyString(), Mockito.isNull(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(patient, 200, "location"));
    Patient actualPatient = toolingClient.update(Patient.class, patient, "id");

    Mockito.verify(mockClientUtils).issuePutRequest(ArgumentMatchers.any(URI.class), Mockito.any(byte[].class), ArgumentMatchers.anyString(), ArgumentMatchers.isNull(),ArgumentMatchers.anyInt());
    assertThat(actualPatient).isEqualTo(patient);

    assertThat(uriArgumentCaptor.getValue().toString()).isEqualTo("http://dummy-base-url.com/Patient/id");
  }

  @Test
  void testValidate() {
    final byte[] dummyBytes = "dummyBytes".getBytes();
    final OperationOutcome expectedOutcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issueComponent = expectedOutcome.addIssue();
    issueComponent.setSeverity(OperationOutcome.IssueSeverity.ERROR);
    when(mockClientUtils.getResourceAsByteArray(any(Patient.class), anyBoolean(), anyBoolean())).thenReturn(dummyBytes);
    when(mockClientUtils.issuePostRequest(uriArgumentCaptor.capture(), Mockito.any(byte[].class), Mockito.anyString(), Mockito.anyInt()))
      .thenReturn(new ResourceRequest<>(expectedOutcome, 200, "location"));

    OperationOutcome actualOutcome = toolingClient.validate(Patient.class, patient, "id");
    assertThat(actualOutcome).isEqualTo(expectedOutcome);

    assertThat(uriArgumentCaptor.getValue().toString()).isEqualTo("http://dummy-base-url.com/Patient/$validate/id");
  }
}
