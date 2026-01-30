package org.hl7.fhir.validation.tests;

import org.junit.jupiter.api.*;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class FhirValidatorHttpServiceTest {

  private static final int TEST_PORT = 18080;
  private static final String BASE_URL = "http://localhost:" + TEST_PORT;

  private FhirValidatorHttpService service;
  private HttpClient httpClient;

  // Sample test data
  private static final String SAMPLE_PATIENT_JSON = "{\n" +
    "  \"resourceType\": \"Patient\",\n" +
    "  \"name\": [{\n" +
    "    \"family\": \"Doe\",\n" +
    "    \"given\": [\"John\"]\n" +
    "  }]\n" +
    "}\n";

  private static final String SAMPLE_PATIENT_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    "<Patient xmlns=\"http://hl7.org/fhir\">\n" +
    "  <name>\n" +
    "    <family value=\"Doe\"/>\n" +
    "    <given value=\"John\"/>\n" +
    "  </name>\n" +
    "</Patient>\n";

  private ValidationEngine getValidationEngine() throws IOException, URISyntaxException {
    return new ValidationEngine.ValidationEngineBuilder().fromSource(VersionUtilities.packageForVersion("r4"));
  }

  private ValidationEngine getValidationEngineWithIG() throws IOException, URISyntaxException {
    ValidationEngine validationEngine = getValidationEngine();
    validationEngine.getIgLoader().loadIg(validationEngine.getIgs(), validationEngine.getBinaries(),"hl7.fhir.us.core#5.0.1", false);
    return validationEngine;

  }

  void setUpService(ValidationEngine validationEngine) throws URISyntaxException, IOException, InterruptedException {
    // Initialize ValidationEngine
    validationEngine.getContext().setAllowLoadingDuplicates(true);

    // Connect to terminology server
    validationEngine.connectToTSServer("https://tx.fhir.org/r4", null, FhirPublication.fromCode(validationEngine.getVersion()), true);
    service = new FhirValidatorHttpService(validationEngine, TEST_PORT);
    service.startServer();
    httpClient = HttpClient.newBuilder()
      .connectTimeout(Duration.ofSeconds(10))
      .build();
    // Wait for server to start
    Thread.sleep(100);
  }

  @AfterEach
  void tearDown() {
    if (service != null) {
      service.stop();
    }
  }

  @Test
  @DisplayName("Service starts successfully")
  void testServiceStarts() throws Exception {
    setUpService(getValidationEngine());
    // If we get here without exceptions, the service started successfully
    assertTrue(true);
  }

  @Test
  @DisplayName("Validate Resource - JSON Success")
  void testValidateResourceJsonSuccess() throws Exception {
    setUpService(getValidationEngine());

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource?resourceIdRule=OPTIONAL&anyExtensionsAllowed=true&bpWarnings=Ignore&displayOption=Ignore"))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
      .header("Content-Type", "application/fhir+json")
      .header("Accept", "application/fhir+json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    assertEquals(200, response.statusCode());
    assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+json"));

    String ss = response.body().toString();
    assertEquals(ss, "{\"resourceType\":\"OperationOutcome\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p class=\\\"res-header-id\\\"><b>OperationOutcome </b></p><p>All OK</p><table class=\\\"grid\\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td></tr><tr><td>Information</td><td/><td>Informational Note</td><td>All OK</td><td/></tr></table></div>\"},\"issue\":[{\"severity\":\"information\",\"code\":\"informational\",\"details\":{\"text\":\"All OK\"}}]}");
  }

  @Test
  @DisplayName("Validate Resource - XML Success")
  void testValidateResourceXmlSuccess() throws Exception {
    setUpService(getValidationEngine());

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource?resourceIdRule=REQUIRED&anyExtensionsAllowed=false&bpWarnings=Warning&displayOption=Check"))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_XML))
      .header("Content-Type", "application/fhir+xml")
      .header("Accept", "application/fhir+xml")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    assertEquals(200, response.statusCode());
    assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+xml"));


    String ss = response.body().toString();
    assertEquals(ss, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><OperationOutcome xmlns=\"http://hl7.org/fhir\"><text><status value=\"generated\"/><div xmlns=\"http://www.w3.org/1999/xhtml\"><p class=\"res-header-id\"><b>OperationOutcome </b></p><table class=\"grid\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td><td><b>Source</b></td></tr><tr><td>Error</td><td>Patient</td><td>Invalid Content</td><td>Resource requires an id, but none is present</td><td/><td>InstanceValidator</td></tr><tr><td>Warning</td><td>Patient</td><td>Validation rule failed</td><td>Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)</td><td/><td>InstanceValidator</td></tr></table></div></text><issue><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line\"><valueInteger value=\"2\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col\"><valueInteger value=\"38\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source\"><valueString value=\"InstanceValidator\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id\"><valueCode value=\"Resource_RES_ID_Missing\"/></extension><severity value=\"error\"/><code value=\"invalid\"/><details><text value=\"Resource requires an id, but none is present\"/></details><expression value=\"Patient\"/></issue><issue><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line\"><valueInteger value=\"2\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col\"><valueInteger value=\"38\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source\"><valueString value=\"InstanceValidator\"/></extension><extension url=\"http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id\"><valueCode value=\"http://hl7.org/fhir/StructureDefinition/DomainResource#dom-6\"/></extension><severity value=\"warning\"/><code value=\"invariant\"/><details><text value=\"Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)\"/></details><expression value=\"Patient\"/></issue></OperationOutcome>");
  }

  @Test
  @DisplayName("Validate Resource - With Profiles")
  void testValidateResourceWithProfiles() throws Exception {
    setUpService(getValidationEngine());
    String profilesParam = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient";

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource?profiles=" + java.net.URLEncoder.encode(profilesParam, "UTF-8")))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
      .header("Content-Type", "application/fhir+json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    assertEquals(500, response.statusCode());

    String ss = response.body().toString();
    assertEquals("{\"resourceType\":\"OperationOutcome\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">Validation failed: Unable to resolve profile http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient</div>\"},\"issue\":[{\"severity\":\"error\",\"code\":\"exception\",\"details\":{\"text\":\"Validation failed: Unable to resolve profile http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient\"}}]}", ss);
  }

  @Test
  @DisplayName("Validate Resource - With Profiles (setup properly)")
  void testValidateResourceWithProfilesSuccess() throws Exception {
    setUpService(getValidationEngineWithIG());

    String profilesParam = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient";
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource?profiles=http%3A%2F%2Fhl7.org%2Ffhir%2Fus%2Fcore%2FStructureDefinition%2Fus-core-patient"))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
      .header("Content-Type", "application/fhir+json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    assertEquals(200, response.statusCode());

    String ss = response.body().toString();
    assertEquals("{\"resourceType\":\"OperationOutcome\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p class=\\\"res-header-id\\\"><b>OperationOutcome </b></p><table class=\\\"grid\\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td><td><b>Source</b></td></tr><tr><td>Error</td><td>Patient</td><td>Structural Issue</td><td>Patient.identifier: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)</td><td/><td>InstanceValidator</td></tr><tr><td>Error</td><td>Patient</td><td>Structural Issue</td><td>Patient.gender: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)</td><td/><td>InstanceValidator</td></tr></table></div>\"},\"issue\":[{\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line\",\"valueInteger\":1},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col\",\"valueInteger\":2},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source\",\"valueString\":\"InstanceValidator\"},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id\",\"valueCode\":\"Validation_VAL_Profile_Minimum\"}],\"severity\":\"error\",\"code\":\"structure\",\"details\":{\"text\":\"Patient.identifier: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)\"},\"expression\":[\"Patient\"]},{\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line\",\"valueInteger\":1},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col\",\"valueInteger\":2},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source\",\"valueString\":\"InstanceValidator\"},{\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id\",\"valueCode\":\"Validation_VAL_Profile_Minimum\"}],\"severity\":\"error\",\"code\":\"structure\",\"details\":{\"text\":\"Patient.gender: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)\"},\"expression\":[\"Patient\"]}]}", ss);
  }

  @Test
  @DisplayName("Validate Resource - All Parameters")
  void testValidateResourceAllParameters() throws Exception {
    setUpService(getValidationEngine());
    
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource" +
        "&resourceIdRule=PROHIBITED" +
        "&anyExtensionsAllowed=false" +
        "&bpWarnings=Error" +
        "&displayOption=CheckCaseAndSpace"))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
      .header("Content-Type", "application/fhir+json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    String ss = response.body().toString();
    assertEquals(200, response.statusCode());
    assertEquals("{\"resourceType\":\"OperationOutcome\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p class=\\\"res-header-id\\\"><b>OperationOutcome </b></p><p>All OK</p><table class=\\\"grid\\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td></tr><tr><td>Information</td><td/><td>Informational Note</td><td>All OK</td><td/></tr></table></div>\"},\"issue\":[{\"severity\":\"information\",\"code\":\"informational\",\"details\":{\"text\":\"All OK\"}}]}", ss);
  }
  
  @Test
  @DisplayName("Parameter Parsing - Invalid Enum Values")
  void testParameterParsingInvalidEnums() throws Exception {
    setUpService(getValidationEngine());

    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(BASE_URL + "/validateResource" +
        "?resourceIdRule=INVALID" +
        "&bpWarnings=INVALID" +
        "&displayOption=INVALID"))
      .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
      .header("Content-Type", "application/fhir+json")
      .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // Assert
    assertEquals(400, response.statusCode());
    String ss = response.body().toString();
    assertEquals("{\"resourceType\":\"OperationOutcome\",\"text\":{\"status\":\"generated\",\"div\":\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">Operation failed: No enum constant org.hl7.fhir.r5.utils.validation.constants.IdStatus.INVALID</div>\"},\"issue\":[{\"severity\":\"error\",\"code\":\"exception\",\"details\":{\"text\":\"Operation failed: No enum constant org.hl7.fhir.r5.utils.validation.constants.IdStatus.INVALID\"}}]}", ss);
  }


}