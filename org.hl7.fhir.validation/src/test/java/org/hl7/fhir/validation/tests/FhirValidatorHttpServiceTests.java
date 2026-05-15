package org.hl7.fhir.validation.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.junit.jupiter.api.*;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FhirValidatorHttpServiceTest {

  @Test
  void testLoopbackConfiguredCorrectly() throws IOException {
    ValidationEngine validationEngine = mock(ValidationEngine.class);
    int port = 18080;
    FhirValidatorHttpService service = new FhirValidatorHttpService(validationEngine, true, port);
    service.startServer();
    assertThat(service.getInetAddress().getAddress()).isIn(InetAddress.getByName("127.0.0.1"));
    service.stop();
  }

  @Test
  void testNetworkAccessibleConfiguredCorrectly() throws IOException {
    ValidationEngine validationEngine = mock(ValidationEngine.class);
    int port = 18080;
    FhirValidatorHttpService service = new FhirValidatorHttpService(validationEngine, false, port);
    service.startServer();
    assertThat(service.getInetAddress().getAddress()).isIn(InetAddress.getByName("0:0:0:0:0:0:0:0"));
    service.stop();
  }

  @Nested
  @DisplayName("Instantiate a local server test it by making requests")
  class TestsThatCallAServer {
    private static final int TEST_PORT = 18080;
    private static final String BASE_URL = "http://localhost:" + TEST_PORT;
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private FhirValidatorHttpService service;
    private HttpClient httpClient;

    // Sample test data
    private static final String SAMPLE_PATIENT_JSON = """
      {
        "resourceType": "Patient",
        "name": [{
          "family": "Doe",
          "given": ["John"]
        }]
      }
      """;

    private static final String SAMPLE_PATIENT_XML = """
      <?xml version="1.0" encoding="UTF-8"?>
      <Patient xmlns="http://hl7.org/fhir">
        <name>
          <family value="Doe"/>
          <given value="John"/>
      </name>
      </Patient>
      """;

    private ValidationEngine getValidationEngine() throws IOException, URISyntaxException {
      return new ValidationEngine.ValidationEngineBuilder().fromSource(VersionUtilities.packageForVersion("r4"));
    }

    private ValidationEngine getValidationEngineWithIG() throws IOException, URISyntaxException {
      ValidationEngine validationEngine = getValidationEngine();
      validationEngine.getIgLoader().loadIg(validationEngine.getIgs(), validationEngine.getBinaries(), "hl7.fhir.us.core#5.0.1", false);
      return validationEngine;

    }

    void setUpService(ValidationEngine validationEngine) throws URISyntaxException, IOException, InterruptedException {
      // Initialize ValidationEngine
      validationEngine.getContext().setAllowLoadingDuplicates(true);

      // Connect to terminology server
      validationEngine.connectToTSServer("https://tx.fhir.org/r4", null, FhirPublication.fromCode(validationEngine.getVersion()), true);
      service = new FhirValidatorHttpService(validationEngine, true, TEST_PORT);
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
        .uri(URI.create(BASE_URL + "/validate?resourceIdRule=OPTIONAL&extension=any&bestPractice=Ignore&checkDisplay=Ignore"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+json"));

      String actual = response.body();
      String expected = """
        {
          "resourceType": "OperationOutcome",
          "text": {
            "status": "generated",
            "div": "<div xmlns=\\"http://www.w3.org/1999/xhtml\\"><p class=\\"res-header-id\\"><b>OperationOutcome </b></p><p>All OK</p><table class=\\"grid\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td></tr><tr><td>Information</td><td/><td>Informational Note</td><td>All OK</td><td/></tr></table></div>"
          },
          "issue": [
            {
              "severity": "information",
              "code": "informational",
              "details": {
                "text": "All OK"
              }
            }
          ]
        }
        """;
      assertEqualsPretty(expected, actual, this::prettyJSONFunction);
    }

    @Test
    @DisplayName("Validate Resource - XML Success")
    void testValidateResourceXmlSuccess() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate?resourceIdRule=REQUIRED&bestPractice=Warning&checkDisplay=Check"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_XML))
        .header("Content-Type", "application/fhir+xml")
        .header("Accept", "application/fhir+xml")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+xml"));


      String actual = response.body();
      String expected = """
        <?xml version="1.0" encoding="UTF-8"?>
        <OperationOutcome xmlns="http://hl7.org/fhir">
          <text>
            <status value="generated" />
            <div xmlns="http://www.w3.org/1999/xhtml">
              <p class="res-header-id">
                <b>OperationOutcome </b>
              </p>
              <table class="grid">
                <tr>
                  <td>
                    <b>Severity</b>
                  </td>
                  <td>
                    <b>Location</b>
                  </td>
                  <td>
                    <b>Code</b>
                  </td>
                  <td>
                    <b>Details</b>
                  </td>
                  <td>
                    <b>Diagnostics</b>
                  </td>
                  <td>
                    <b>Source</b>
                  </td>
                </tr>
                <tr>
                  <td>Error</td>
                  <td>Patient</td>
                  <td>Invalid Content</td>
                  <td>Resource requires an id, but none is present</td>
                  <td />
                  <td>InstanceValidator</td>
                </tr>
                <tr>
                  <td>Warning</td>
                  <td>Patient</td>
                  <td>Validation rule failed</td>
                  <td>Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)</td>
                  <td />
                  <td>InstanceValidator</td>
                </tr>
              </table>
            </div>
          </text>
          <issue>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line">
              <valueInteger value="2" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col">
              <valueInteger value="38" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source">
              <valueString value="InstanceValidator" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id">
              <valueCode value="Resource_RES_ID_Missing" />
            </extension>
            <severity value="error" />
            <code value="invalid" />
            <details>
              <text value="Resource requires an id, but none is present" />
            </details>
            <expression value="Patient" />
          </issue>
          <issue>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line">
              <valueInteger value="2" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col">
              <valueInteger value="38" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source">
              <valueString value="InstanceValidator" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id">
              <valueCode value="http://hl7.org/fhir/StructureDefinition/DomainResource#dom-6" />
            </extension>
            <extension url="http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-context">
               <valueString value="http://hl7.org/fhir/StructureDefinition/Patient|4.0.1"/>
            </extension>
            <severity value="warning" />
            <code value="invariant" />
            <details>
              <text
                value="Constraint failed: dom-6: 'A resource should have narrative for robust management' (defined in http://hl7.org/fhir/StructureDefinition/DomainResource) (Best Practice Recommendation)" />
            </details>
            <expression value="Patient" />
          </issue>
        </OperationOutcome>
        """;
      assertEqualsPretty(expected, actual, this::prettyXMLFunction);
    }

    @Test
    @DisplayName("Validate Resource - With Profiles")
    void testValidateResourceWithProfiles() throws Exception {
      setUpService(getValidationEngine());
      String profilesParam = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate?profile=" + java.net.URLEncoder.encode(profilesParam, "UTF-8")))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      assertEquals(500, response.statusCode());

      String actual = response.body();
      String expected = """
        {
          "resourceType": "OperationOutcome",
          "text": {
            "status": "generated",
            "div": "<div xmlns=\\"http://www.w3.org/1999/xhtml\\">Validation failed: Unable to resolve profile http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient</div>"
          },
          "issue": [
            {
              "severity": "error",
              "code": "exception",
              "details": {
                "text": "Validation failed: Unable to resolve profile http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient"
              }
            }
          ]
        }
        """;
      assertEqualsPretty(expected, actual, this::prettyJSONFunction);
    }

    @Test
    @DisplayName("Validate Resource - With Profiles (setup properly)")
    void testValidateResourceWithProfilesSuccess() throws Exception {
      setUpService(getValidationEngineWithIG());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate?bestPractice=Ignore&profile=http%3A%2F%2Fhl7.org%2Ffhir%2Fus%2Fcore%2FStructureDefinition%2Fus-core-patient"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      assertEquals(200, response.statusCode());

      String actual = response.body();
      String expected = """
        {
              "resourceType": "OperationOutcome",
              "text": {
                "status": "generated",
                "div": "<div xmlns=\\"http://www.w3.org/1999/xhtml\\"><p class=\\"res-header-id\\"><b>OperationOutcome </b></p><table class=\\"grid\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td><td><b>Source</b></td></tr><tr><td>Error</td><td>Patient</td><td>Structural Issue</td><td>Patient.identifier: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)</td><td/><td>InstanceValidator</td></tr><tr><td>Error</td><td>Patient</td><td>Structural Issue</td><td>Patient.gender: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)</td><td/><td>InstanceValidator</td></tr></table></div>"
              },
              "issue": [
                {
                  "extension": [
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line",
                      "valueInteger": 1
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col",
                      "valueInteger": 2
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source",
                      "valueString": "InstanceValidator"
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id",
                      "valueCode": "Validation_VAL_Profile_Minimum"
                    },
                    {
                       "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-context",
                        "valueString": "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1"
                     }
                  ],
                  "severity": "error",
                  "code": "structure",
                  "details": {
                    "text": "Patient.identifier: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)"
                  },
                  "expression": [
                    "Patient"
                  ]
                },
                {
                  "extension": [
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-line",
                      "valueInteger": 1
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-col",
                      "valueInteger": 2
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-source",
                      "valueString": "InstanceValidator"
                    },
                    {
                      "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id",
                      "valueCode": "Validation_VAL_Profile_Minimum"
                     },
                     {
                       "url": "http://hl7.org/fhir/StructureDefinition/operationoutcome-issue-context",
                       "valueString": "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1"
                     }
                  ],
                  "severity": "error",
                  "code": "structure",
                  "details": {
                    "text": "Patient.gender: minimum required = 1, but only found 0 (from http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient|5.0.1)"
                  },
                  "expression": [
                    "Patient"
                  ]
                }
              ]
            }
        """;
      assertEqualsPretty(expected, actual, this::prettyJSONFunction);
    }

    @Test
    @DisplayName("Validate Resource - All Parameters")
    void testValidateResourceAllParameters() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate?" +
          "&resourceIdRule=PROHIBITED" +
          "&bestPractice=Ignore" +
          "&checkDisplay=CheckCaseAndSpace"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      String actual = response.body();
      assertEquals(200, response.statusCode());
      String expected = """
        {
          "resourceType": "OperationOutcome",
          "text": {
            "status": "generated",
            "div": "<div xmlns=\\"http://www.w3.org/1999/xhtml\\"><p class=\\"res-header-id\\"><b>OperationOutcome </b></p><p>All OK</p><table class=\\"grid\\"><tr><td><b>Severity</b></td><td><b>Location</b></td><td><b>Code</b></td><td><b>Details</b></td><td><b>Diagnostics</b></td></tr><tr><td>Information</td><td/><td>Informational Note</td><td>All OK</td><td/></tr></table></div>"
          },
          "issue": [
            {
              "severity": "information",
              "code": "informational",
              "details": {
                "text": "All OK"
              }
            }
          ]
        }
        """;
      assertEqualsPretty(expected, actual, this::prettyJSONFunction);
    }

    @Test
    @DisplayName("FHIRPath - Evaluate expression on JSON resource")
    void testFhirPathEvaluationSuccess() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fhirpath?expression=" + java.net.URLEncoder.encode("Patient.name.family", "UTF-8")))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+json"));
      String body = response.body();
      assertTrue(body.contains("\"resourceType\":\"Parameters\""));
      assertTrue(body.contains("\"result\""));
      assertTrue(body.contains("Doe"));
    }

    @Test
    @DisplayName("FHIRPath - Missing expression parameter returns 400")
    void testFhirPathEvaluationMissingExpression() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fhirpath"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: expression"));
    }

    @Test
    @DisplayName("FHIRPath - Invalid expression returns 500")
    void testFhirPathEvaluationInvalidExpression() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fhirpath?expression=" + java.net.URLEncoder.encode("Patient.!!invalid!!", "UTF-8")))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(500, response.statusCode());
      assertTrue(response.body().contains("FHIRPath evaluation failed"));
    }

    @Test
    @DisplayName("FHIRPath - GET method not allowed")
    void testFhirPathGetMethodNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fhirpath?expression=Patient.name"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    @Test
    @DisplayName("Matchetype - Successful comparison")
    void testMatchetypeComparisonSuccess() throws Exception {
      setUpService(getValidationEngine());

      String body = "{\n" +
        "  \"resource\": " + SAMPLE_PATIENT_JSON + ",\n" +
        "  \"matchetype\": {\n" +
        "    \"resourceType\": \"Patient\",\n" +
        "    \"name\": [{\"family\": \"Doe\", \"given\": [\"John\"]}]\n" +
        "  }\n" +
        "}";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/matchetype"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("All OK"));
    }

    @Test
    @DisplayName("Matchetype - Failed comparison")
    void testMatchetypeComparisonFailure() throws Exception {
      setUpService(getValidationEngine());

      String body = "{\n" +
        "  \"resource\": " + SAMPLE_PATIENT_JSON + ",\n" +
        "  \"matchetype\": {\n" +
        "    \"resourceType\": \"Patient\",\n" +
        "    \"name\": [{\"family\": \"Smith\"}]\n" +
        "  }\n" +
        "}";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/matchetype"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("error"));
    }

    @Test
    @DisplayName("Matchetype - Missing fields returns 400")
    void testMatchetypeComparisonMissingFields() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ \"resource\": " + SAMPLE_PATIENT_JSON + " }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/matchetype"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("must contain both"));
    }

    @Test
    @DisplayName("Matchetype - GET method not allowed")
    void testMatchetypeGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/matchetype"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    @Test
    @DisplayName("TestData - Generate Patient from profile")
    void testTestDataGeneratePatient() throws Exception {
      setUpService(getValidationEngine());

      String body = "{\n" +
        "  \"profile\": \"http://hl7.org/fhir/StructureDefinition/Patient\",\n" +
        "  \"data\": [{\"name\": \"test\"}]\n" +
        "}";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/testdata"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("\"resourceType\""));
      assertTrue(response.body().contains("Patient"));
    }

    @Test
    @DisplayName("TestData - Missing profile returns 400")
    void testTestDataMissingProfile() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ \"data\": [{\"name\": \"test\"}] }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/testdata"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required field: profile"));
    }

    @Test
    @DisplayName("TestData - Unknown profile returns 500")
    void testTestDataUnknownProfile() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ \"profile\": \"http://example.org/fhir/StructureDefinition/NonExistent\" }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/testdata"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(500, response.statusCode());
      assertTrue(response.body().contains("Profile not found"));
    }

    @Test
    @DisplayName("TestData - GET method not allowed")
    void testTestDataGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/testdata"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    @Test
    @DisplayName("LoadIG - Load US Core IG dynamically")
    void testLoadIGSuccess() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ \"ig\": \"hl7.fhir.us.core#5.0.1\" }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/loadIg"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("IG loaded successfully"));

      // Now validate against the loaded profile - it should be available
      String profilesParam = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-patient";
      HttpRequest validateRequest = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate?profile=" + java.net.URLEncoder.encode(profilesParam, "UTF-8")))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> validateResponse = httpClient.send(validateRequest, HttpResponse.BodyHandlers.ofString());

      // Should get 200 (not 500 with "Unable to resolve profile") since the IG is now loaded
      assertEquals(200, validateResponse.statusCode());
      // Should have validation errors (Patient missing required US Core fields) but NOT "Unable to resolve profile"
      assertFalse(validateResponse.body().contains("Unable to resolve profile"));
    }

    @Test
    @DisplayName("LoadIG - Missing ig field returns 400")
    void testLoadIGMissingField() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/loadIg"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required field: ig"));
    }

    @Test
    @DisplayName("LoadIG - Invalid IG returns 500")
    void testLoadIGInvalid() throws Exception {
      setUpService(getValidationEngine());

      String body = "{ \"ig\": \"nonexistent.package#99.99.99\" }";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/loadIg"))
        .POST(HttpRequest.BodyPublishers.ofString(body))
        .header("Content-Type", "application/json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(500, response.statusCode());
      assertTrue(response.body().contains("Failed to load IG"));
    }

    @Test
    @DisplayName("LoadIG - GET method not allowed")
    void testLoadIGGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/loadIg"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── Convert endpoint tests ───

    @Test
    @DisplayName("Convert - JSON to XML")
    void testConvertJsonToXml() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/convert"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .header("Accept", "application/fhir+xml")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+xml"));
      assertTrue(response.body().contains("<Patient"));
      assertTrue(response.body().contains("Doe"));
    }

    @Test
    @DisplayName("Convert - XML to JSON")
    void testConvertXmlToJson() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/convert"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_XML))
        .header("Content-Type", "application/fhir+xml")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/fhir+json"));
      assertTrue(response.body().contains("Patient"));
      assertTrue(response.body().contains("Doe"));
    }

    @Test
    @DisplayName("Convert - GET method not allowed")
    void testConvertGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/convert"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── Snapshot endpoint tests ───

    @Test
    @DisplayName("Snapshot - Generate snapshot for StructureDefinition")
    void testSnapshotGeneration() throws Exception {
      setUpService(getValidationEngine());

      // Minimal StructureDefinition with a differential
      String sd = "{\n" +
        "  \"resourceType\": \"StructureDefinition\",\n" +
        "  \"id\": \"test-patient\",\n" +
        "  \"url\": \"http://example.org/fhir/StructureDefinition/test-patient\",\n" +
        "  \"name\": \"TestPatient\",\n" +
        "  \"status\": \"draft\",\n" +
        "  \"kind\": \"resource\",\n" +
        "  \"abstract\": false,\n" +
        "  \"type\": \"Patient\",\n" +
        "  \"baseDefinition\": \"http://hl7.org/fhir/StructureDefinition/Patient\",\n" +
        "  \"derivation\": \"constraint\",\n" +
        "  \"differential\": {\n" +
        "    \"element\": [{\n" +
        "      \"id\": \"Patient.name\",\n" +
        "      \"path\": \"Patient.name\",\n" +
        "      \"min\": 1\n" +
        "    }]\n" +
        "  }\n" +
        "}";

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/snapshot"))
        .POST(HttpRequest.BodyPublishers.ofString(sd))
        .header("Content-Type", "application/fhir+json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("snapshot"));
      assertTrue(response.body().contains("StructureDefinition"));
    }

    @Test
    @DisplayName("Snapshot - GET method not allowed")
    void testSnapshotGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/snapshot"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── Narrative endpoint tests ───

    @Test
    @DisplayName("Narrative - Generate narrative for Patient")
    void testNarrativeGeneration() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/narrative"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .header("Accept", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.body().contains("Patient"));
      // Narrative should include the text div
      assertTrue(response.body().contains("text"));
    }

    @Test
    @DisplayName("Narrative - GET method not allowed")
    void testNarrativeGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/narrative"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── Version endpoint tests ───

    @Test
    @DisplayName("Version - Missing targetVersion returns 400")
    void testVersionMissingTargetVersion() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/version"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: targetVersion"));
    }

    @Test
    @DisplayName("Version - GET method not allowed")
    void testVersionGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/version"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── Transform endpoint tests ───

    @Test
    @DisplayName("Transform - Missing map parameter returns 400")
    void testTransformMissingMap() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/transform"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: map"));
    }

    @Test
    @DisplayName("Transform - GET method not allowed")
    void testTransformGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/transform"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── FML parsing tests ───

    private static final String SAMPLE_FML =
        "map \"http://example.org/StructureMap/IdentityTest\" = \"IdentityTest\"\n" +
        "\n" +
        "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientSrc as source\n" +
        "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientTgt as target\n" +
        "\n" +
        "group IdentityTest(source src : PatientSrc, target tgt : PatientTgt) {\n" +
        "  src.id -> tgt.id;\n" +
        "}\n";

    @Test
    @DisplayName("FML - parse FML text to a StructureMap (legacy POST /fml)")
    void testFmlParseLegacy() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fml?name=IdentityTest"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_FML))
        .header("Content-Type", "text/plain")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());
      org.hl7.fhir.utilities.json.model.JsonObject sm =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      assertEquals("StructureMap", sm.asString("resourceType"));
      assertEquals("http://example.org/StructureMap/IdentityTest", sm.asString("url"));
      assertTrue(sm.has("group"), "parsed StructureMap should have a group");
    }

    @Test
    @DisplayName("FML - Missing body returns 400")
    void testFmlParseMissingBody() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fml"))
        .POST(HttpRequest.BodyPublishers.ofString(""))
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing request body"));
    }

    @Test
    @DisplayName("FML - GET method not allowed")
    void testFmlGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/fml"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    // ─── CRMI $package tests ───

    @Test
    @DisplayName("Package - bundle a canonical artifact and its dependencies (legacy GET /package)")
    void testPackageLegacy() throws Exception {
      setUpService(getValidationEngine());

      // A base CodeSystem — minimal canonical dependencies, fast + predictable.
      String url = java.net.URLEncoder.encode("http://hl7.org/fhir/administrative-gender", "UTF-8");
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/package?url=" + url))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());
      org.hl7.fhir.utilities.json.model.JsonObject bundle =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      assertEquals("Bundle", bundle.asString("resourceType"));
      assertEquals("collection", bundle.asString("type"));
      org.hl7.fhir.utilities.json.model.JsonArray entries = bundle.getJsonArray("entry");
      assertTrue(entries != null && entries.size() >= 1,
        "package Bundle should contain at least the root artifact");
    }

    @Test
    @DisplayName("Package - Missing url parameter returns 400")
    void testPackageMissingUrl() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/package"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: url"));
    }

    @Test
    @DisplayName("Package - POST method not allowed")
    void testPackagePostNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/package?url=x"))
        .POST(HttpRequest.BodyPublishers.ofString(""))
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    @Test
    @DisplayName("ITB Package - bundle a canonical artifact (GITB endpoint, real engine)")
    void testItbPackage() throws Exception {
      setUpService(getValidationEngine());

      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "package");
      org.hl7.fhir.utilities.json.model.JsonArray input = new org.hl7.fhir.utilities.json.model.JsonArray();
      input.add(anyContent("resource", "http://hl7.org/fhir/administrative-gender"));
      input.add(anyContent("targetFormat", "json"));
      body.add("input", input);

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/itb/package/process"))
        .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
        .header("Content-Type", "application/json")
        .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());

      org.hl7.fhir.utilities.json.model.JsonObject envelope =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      org.hl7.fhir.utilities.json.model.JsonArray output = envelope.getJsonArray("output");
      String bundleJson = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : output) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("bundle".equals(ac.asString("name"))) bundleJson = ac.asString("value");
      }
      assertTrue(bundleJson != null && !bundleJson.isEmpty(), "package output must include a non-empty bundle");
      org.hl7.fhir.utilities.json.model.JsonObject bundle =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(bundleJson);
      assertEquals("Bundle", bundle.asString("resourceType"));
      assertEquals("collection", bundle.asString("type"));
    }

    @Test
    @DisplayName("ITB Transform - parse FML to StructureMap (GITB endpoint, real engine)")
    void testItbTransformParseFml() throws Exception {
      setUpService(getValidationEngine());

      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "parse");
      org.hl7.fhir.utilities.json.model.JsonArray input = new org.hl7.fhir.utilities.json.model.JsonArray();
      input.add(anyContent("content", SAMPLE_FML));
      input.add(anyContent("name", "IdentityTest"));
      input.add(anyContent("targetFormat", "json"));
      body.add("input", input);

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/itb/transform/process"))
        .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
        .header("Content-Type", "application/json")
        .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());

      org.hl7.fhir.utilities.json.model.JsonObject envelope =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      org.hl7.fhir.utilities.json.model.JsonArray output = envelope.getJsonArray("output");
      String structureMap = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : output) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("structureMap".equals(ac.asString("name"))) structureMap = ac.asString("value");
      }
      assertTrue(structureMap != null && !structureMap.isEmpty(),
        "parse output must include a non-empty structureMap");
      org.hl7.fhir.utilities.json.model.JsonObject sm =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(structureMap);
      assertEquals("StructureMap", sm.asString("resourceType"));
      assertEquals("http://example.org/StructureMap/IdentityTest", sm.asString("url"));
    }

    // ─── Questionnaire endpoint tests ───

    @Test
    @DisplayName("Questionnaire - Generate from base Patient profile (legacy GET endpoint)")
    void testQuestionnaireGenerateLegacy() throws Exception {
      setUpService(getValidationEngine());

      String profile = java.net.URLEncoder.encode(
        "http://hl7.org/fhir/StructureDefinition/Patient", "UTF-8");
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/questionnaire?profile=" + profile))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());
      assertTrue(response.body().contains("\"resourceType\""));
      assertTrue(response.body().contains("Questionnaire"),
        "response should be a Questionnaire resource");
    }

    @Test
    @DisplayName("Questionnaire - select filter (FHIRPath expressions) still yields a valid Questionnaire")
    void testQuestionnaireSelectFilter() throws Exception {
      setUpService(getValidationEngine());

      String profile = java.net.URLEncoder.encode(
        "http://hl7.org/fhir/StructureDefinition/Patient", "UTF-8");
      // select = ["path = 'Patient.name'", "path = 'Patient.birthDate'"]
      String select = java.net.URLEncoder.encode(
        "[\"path = 'Patient.name'\",\"path = 'Patient.birthDate'\"]", "UTF-8");
      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/questionnaire?profile=" + profile + "&select=" + select))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());
      org.hl7.fhir.utilities.json.model.JsonObject q =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      assertEquals("Questionnaire", q.asString("resourceType"));
      assertTrue(q.has("item"), "selected Questionnaire should still have items");
    }

    @Test
    @DisplayName("Questionnaire - Missing profile parameter returns 400")
    void testQuestionnaireMissingProfile() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/questionnaire"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: profile"));
    }

    @Test
    @DisplayName("Questionnaire - POST method not allowed")
    void testQuestionnairePostNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/questionnaire?profile=x"))
        .POST(HttpRequest.BodyPublishers.ofString(""))
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(405, response.statusCode());
    }

    @Test
    @DisplayName("ITB Questionnaire - generate from base Patient profile (GITB endpoint, real engine)")
    void testItbQuestionnaireGenerate() throws Exception {
      setUpService(getValidationEngine());

      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "generate");
      org.hl7.fhir.utilities.json.model.JsonArray input = new org.hl7.fhir.utilities.json.model.JsonArray();
      input.add(anyContent("profile", "http://hl7.org/fhir/StructureDefinition/Patient"));
      input.add(anyContent("targetFormat", "json"));
      body.add("input", input);

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/itb/questionnaire/process"))
        .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
        .header("Content-Type", "application/json")
        .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(), "expected 200; body: " + response.body());

      org.hl7.fhir.utilities.json.model.JsonObject envelope =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      org.hl7.fhir.utilities.json.model.JsonArray output = envelope.getJsonArray("output");
      assertEquals(2, output.size(), "output should have [questionnaire, targetMime]");

      String questionnaireJson = null;
      String targetMime = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : output) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("questionnaire".equals(ac.asString("name"))) questionnaireJson = ac.asString("value");
        if ("targetMime".equals(ac.asString("name")))    targetMime = ac.asString("value");
      }
      assertEquals("application/fhir+json", targetMime);
      assertTrue(questionnaireJson != null && !questionnaireJson.isEmpty(),
        "questionnaire output must be a non-empty JSON string");

      org.hl7.fhir.utilities.json.model.JsonObject questionnaire =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(questionnaireJson);
      assertEquals("Questionnaire", questionnaire.asString("resourceType"));
      assertTrue(questionnaire.has("item"), "generated Questionnaire should have items");
    }

    @Test
    @DisplayName("ITB Transform - ICVP claim → IPS Bundle (real StructureMap, real engine)")
    void testItbTransformIcvpClaimToIps() throws Exception {
      // Boot a real engine + load the WHO ICVP IG (this brings in the StructureMap
      // and its imports). If the package can't be resolved (offline / mirror down),
      // skip rather than fail — this test is gated on network access to packages.fhir.org.
      ValidationEngine engine = getValidationEngine();
      engine.getContext().setAllowLoadingDuplicates(true);
      try {
        engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), "smart.who.int.icvp", false);
      } catch (Exception e) {
        org.junit.jupiter.api.Assumptions.assumeTrue(false,
          "Skipping: cannot load smart.who.int.icvp package (" + e.getMessage() + ")");
        return;
      }
      setUpService(engine);

      // The ICVP claim payload (compact field names per the ICVPMin logical model).
      String claim = "{"
        + "\"dob\":\"1994-10-13\","
        + "\"gn\":\"Parent/Antonio Rojas\","
        + "\"n\":\"Cristina Rodriguez\","
        + "\"ndt\":\"NI\",\"nid\":\"126008-7\",\"ntl\":\"CHL\",\"s\":\"male\","
        + "\"v\":{"
        +   "\"bo\":\"A1234\",\"cn\":\"Juan Castro\",\"dt\":\"2020-11-15\",\"is\":\"MINSALUD\","
        +   "\"vle\":\"2025-11-15\",\"vls\":\"2020-11-15\","
        +   "\"vp\":\"YellowFeverProductd2c75a15ed309658b3968519ddb31690\"}"
        + "}";

      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "transform");
      org.hl7.fhir.utilities.json.model.JsonArray input = new org.hl7.fhir.utilities.json.model.JsonArray();
      input.add(anyContent("content", claim));
      input.add(anyContent("map", "http://smart.who.int/icvp/StructureMap/ICVPClaimtoIPS"));
      input.add(anyContent("contentType", "application/fhir+json"));
      input.add(anyContent("targetFormat", "json"));
      body.add("input", input);

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/itb/transform/process"))
        .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
        .header("Content-Type", "application/json")
        .build();
      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode(),
        "expected 200; body was: " + response.body());

      org.hl7.fhir.utilities.json.model.JsonObject envelope =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(response.body());
      org.hl7.fhir.utilities.json.model.JsonArray output = envelope.getJsonArray("output");
      assertEquals(2, output.size(), "output should have [result, targetMime]");

      String resultJson = null;
      String targetMime = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : output) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("result".equals(ac.asString("name")))     resultJson = ac.asString("value");
        if ("targetMime".equals(ac.asString("name"))) targetMime = ac.asString("value");
      }
      assertEquals("application/fhir+json", targetMime);
      assertTrue(resultJson != null && !resultJson.isEmpty(), "result must be a non-empty JSON string");

      org.hl7.fhir.utilities.json.model.JsonObject bundle =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resultJson);
      assertEquals("Bundle", bundle.asString("resourceType"));
      assertEquals("document", bundle.asString("type"));
      org.hl7.fhir.utilities.json.model.JsonArray entries = bundle.getJsonArray("entry");
      assertTrue(entries.size() >= 3,
        "expected at least Composition + Immunization + Patient entries; got " + entries.size());

      // Walk the entries, locate the resources we care about, and assert the
      // invariant fields (UUIDs and ids vary every run and aren't asserted).
      org.hl7.fhir.utilities.json.model.JsonObject composition  = null;
      org.hl7.fhir.utilities.json.model.JsonObject immunization = null;
      org.hl7.fhir.utilities.json.model.JsonObject patient      = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : entries) {
        org.hl7.fhir.utilities.json.model.JsonObject res = el.asJsonObject().getJsonObject("resource");
        switch (res.asString("resourceType")) {
          case "Composition":  composition  = res; break;
          case "Immunization": immunization = res; break;
          case "Patient":      patient      = res; break;
          default: /* ignore others */
        }
      }
      assertTrue(composition  != null, "Bundle must contain a Composition");
      assertTrue(immunization != null, "Bundle must contain an Immunization");
      assertTrue(patient      != null, "Bundle must contain a Patient");

      // Patient — invariant fields driven by claim values
      org.hl7.fhir.utilities.json.model.JsonArray names = patient.getJsonArray("name");
      assertEquals("Cristina Rodriguez", names.get(0).asJsonObject().asString("text"));
      assertEquals("male",       patient.asString("gender"));
      assertEquals("1994-10-13", patient.asString("birthDate"));
      org.hl7.fhir.utilities.json.model.JsonArray contacts = patient.getJsonArray("contact");
      assertTrue(contacts.size() > 0, "Patient.contact should have the parent name");
      assertEquals("Parent/Antonio Rojas",
        contacts.get(0).asJsonObject().getJsonObject("name").asString("text"));

      // Immunization — vaccine code, lot, occurrence, ProductID extension
      assertEquals("completed", immunization.asString("status"));
      assertEquals("A1234", immunization.asString("lotNumber"));
      String occ = immunization.has("occurrenceString") ? immunization.asString("occurrenceString")
                                                        : immunization.asString("occurrenceDateTime");
      assertTrue(occ != null && occ.startsWith("2020-11-15"),
        "Immunization occurrence should start with 2020-11-15; got " + occ);
      org.hl7.fhir.utilities.json.model.JsonObject vaccineCoding =
        immunization.getJsonObject("vaccineCode").getJsonArray("coding").get(0).asJsonObject();
      assertEquals("YellowFever", vaccineCoding.asString("code"));

      // Composition — IPS document type code
      assertEquals("final", composition.asString("status"));
      org.hl7.fhir.utilities.json.model.JsonObject typeCoding =
        composition.getJsonObject("type").getJsonArray("coding").get(0).asJsonObject();
      assertEquals("http://loinc.org", typeCoding.asString("system"));
      assertEquals("60591-5",          typeCoding.asString("code"));
    }

    /** Build a single GITB AnyContent item with embeddingMethod=STRING. */
    private static org.hl7.fhir.utilities.json.model.JsonObject anyContent(String name, String value) {
      org.hl7.fhir.utilities.json.model.JsonObject ac = new org.hl7.fhir.utilities.json.model.JsonObject();
      ac.add("name", name);
      ac.add("value", value);
      ac.add("embeddingMethod", "STRING");
      return ac;
    }

    // ─── Compile endpoint tests ───

    @Test
    @DisplayName("Compile - Missing url parameter returns 400")
    void testCompileMissingUrl() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/compile"))
        .POST(HttpRequest.BodyPublishers.noBody())
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(400, response.statusCode());
      assertTrue(response.body().contains("Missing required query parameter: url"));
    }

    @Test
    @DisplayName("Compile - Unknown map returns 500")
    void testCompileUnknownMap() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/compile?url=" + java.net.URLEncoder.encode("http://example.org/fhir/StructureMap/nonexistent", "UTF-8")))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(500, response.statusCode());
      assertTrue(response.body().contains("Compile map failed"));
    }

    // ─── OpenAPI / Docs endpoint tests ───

    @Test
    @DisplayName("OpenAPI - Returns valid JSON spec")
    void testOpenApiSpec() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/openapi.json"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("application/json"));
      assertTrue(response.body().contains("\"openapi\""));
      assertTrue(response.body().contains("/validate"));
      assertTrue(response.body().contains("/fhirpath"));
      assertTrue(response.body().contains("/convert"));
      assertTrue(response.body().contains("/snapshot"));
      assertTrue(response.body().contains("/narrative"));
      assertTrue(response.body().contains("/transform"));
      assertTrue(response.body().contains("/version"));
      assertTrue(response.body().contains("/compile"));
    }

    @Test
    @DisplayName("Docs - Returns Swagger UI HTML page")
    void testDocsPage() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/docs"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("text/html"));
      assertTrue(response.body().contains("swagger-ui"));
      assertTrue(response.body().contains("openapi.json"));
    }

    @Test
    @DisplayName("Redoc - Returns Redoc HTML page")
    void testRedocPage() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/redoc"))
        .GET()
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      assertEquals(200, response.statusCode());
      assertTrue(response.headers().firstValue("Content-Type").orElse("").contains("text/html"));
      assertTrue(response.body().contains("redoc"));
      assertTrue(response.body().contains("openapi.json"));
    }

    @Test
    @DisplayName("Parameter Parsing - Invalid Enum Values")
    void testParameterParsingInvalidEnums() throws Exception {
      setUpService(getValidationEngine());

      HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(BASE_URL + "/validate" +
          "?resourceIdRule=INVALID" +
          "&bestPractice=INVALID" +
          "&checkDisplay=INVALID"))
        .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_PATIENT_JSON))
        .header("Content-Type", "application/fhir+json")
        .build();

      HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

      // Assert
      assertEquals(400, response.statusCode());
      String actual = response.body();
      String expected = """
          {
            "resourceType": "OperationOutcome",
            "text": {
              "status": "generated",
              "div": "<div xmlns=\\"http://www.w3.org/1999/xhtml\\">Operation failed: Unable to process param resourceIdRule=INVALID</div>"
            },
            "issue": [
              {
                "severity": "error",
                "code": "exception",
                "details": {
                  "text": "Operation failed: Unable to process param resourceIdRule=INVALID"
                }
              }
            ]
          }
        """;
      assertEqualsPretty(expected, actual, this::prettyJSONFunction);
    }

    //TODO make this available in a test utility so we can use it elsewhere. -dotasek
    private void assertEqualsPretty(String expected, String actual, Function<String, String> prettyFunction) {
      final String prettyExpected = prettyFunction.apply(expected);
      final String prettyActual = prettyFunction.apply(actual);
      assertEquals(prettyExpected, prettyActual);
    }

    //TODO make this available in a test utility so we can use it elsewhere. -dotasek
    private String prettyJSONFunction(String jsonString) {
      return gson.toJson(JsonParser.parseString(jsonString));
    }

    //TODO make this available in a test utility so we can use it elsewhere. -dotasek
    private String prettyXMLFunction(String xmlString) {
      Document doc = null;
      try {
        DocumentBuilderFactory dbf = XMLUtil.newXXEProtectedDocumentBuilderFactory();
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setNamespaceAware(false);
        dbf.setValidating(false);

        doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));

        TransformerFactory tf = org.hl7.fhir.utilities.xml.XMLUtil.newXXEProtectedTransformerFactory();

        javax.xml.transform.Transformer transformer = tf.newTransformer();

        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter writer = new StringWriter();

        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        return writer.toString();
      } catch (TransformerException | SAXException | IOException | ParserConfigurationException e) {
        throw new RuntimeException(e);
      }
    }
  }

}