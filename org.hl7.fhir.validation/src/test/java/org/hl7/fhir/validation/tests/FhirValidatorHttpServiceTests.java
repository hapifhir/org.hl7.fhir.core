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

    /**
     * Two-group FML that exercises a dependent group invocation with named arguments.
     * In R4 the parsed SM emits {@code dependent.variable: ["a","b"]};
     * in R5 it emits {@code dependent.parameter: [{valueId:"a"},{valueId:"b"}]}.
     * Used by the version-format round-trip tests.
     */
    private static final String FML_WITH_DEPENDENT =
        "map \"http://example.org/StructureMap/PassThrough\" = \"PassThrough\"\n" +
        "\n" +
        "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientSrc as source\n" +
        "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientTgt as target\n" +
        "\n" +
        "group PassThrough(source s : PatientSrc, target t : PatientTgt) {\n" +
        "  s as src then InnerCopy(src, t) \"outer\";\n" +
        "}\n" +
        "\n" +
        "group InnerCopy(source src : PatientSrc, target tgt : PatientTgt) {\n" +
        "  src.id as v -> tgt.id = v \"copyId\";\n" +
        "}\n";

    @Test
    @DisplayName("FML - parse output uses the engine's runtime FHIR version (R4 emits 'variable' on dependent, not 'parameter')")
    void testFmlParseEmitsRuntimeVersion() throws Exception {
      // The test engine is R4 (hl7.fhir.r4.core#4.0.1). The parsed StructureMap
      // must round-trip through an R4 JSON parser without losing dependent data —
      // i.e. its dependent invocation must be encoded as `variable: [...]` (the R4 form),
      // NOT as `parameter: [...]` (R5-only).
      setUpService(getValidationEngine());

      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/fml?name=PassThrough"))
          .POST(HttpRequest.BodyPublishers.ofString(FML_WITH_DEPENDENT))
          .header("Content-Type", "text/plain")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, resp.statusCode(), "parse: " + resp.body());

      // The whole point: dependent encoded in R4 form, not R5.
      // R4 uses dependent.variable (string list); R5 uses dependent.parameter (typed list).
      // Walk into the JSON to inspect just the dependent (R4 SM target transforms also use
      // 'parameter' so a body-wide substring check is too coarse).
      org.hl7.fhir.utilities.json.model.JsonObject sm =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resp.body());
      org.hl7.fhir.utilities.json.model.JsonObject outerGroup = sm.getJsonArray("group").get(0).asJsonObject();
      org.hl7.fhir.utilities.json.model.JsonObject outerRule  = outerGroup.getJsonArray("rule").get(0).asJsonObject();
      org.hl7.fhir.utilities.json.model.JsonObject dependent  = outerRule.getJsonArray("dependent").get(0).asJsonObject();
      assertTrue(dependent.has("variable"),
        "R4-mode parse must emit dependent.variable (R4 form): " + dependent.toString());
      assertFalse(dependent.has("parameter"),
        "R4-mode parse must NOT emit dependent.parameter (R5-only) — would silently lose data: " + dependent.toString());
      assertEquals(2, dependent.getJsonArray("variable").size(),
        "dependent.variable must carry both args (src, t): " + dependent.toString());
    }

    @Test
    @DisplayName("LoadResource - R5-format StructureMap on an R4 validator triggers a version-loss warning in the descriptor")
    void testLoadResourceWarnsOnVersionMismatch() throws Exception {
      // Hand-craft an R5-format StructureMap JSON (dependent.parameter, the R5-only form)
      // and POST it to a R4 validator. The /loadResource endpoint should still accept it
      // (the R4 parser will just drop the unknown fields), but flag the data loss in the
      // descriptor so the caller doesn't waste a debugging session like we did.
      setUpService(getValidationEngine());

      String r5SmJson =
        "{"
      + "\"resourceType\":\"StructureMap\","
      + "\"id\":\"r5-shaped\","
      + "\"url\":\"http://example.org/StructureMap/r5-shaped\","
      + "\"name\":\"R5Shaped\","
      + "\"status\":\"draft\","
      + "\"group\":[{"
      + "\"name\":\"outer\","
      + "\"input\":[{\"name\":\"s\",\"mode\":\"source\"},{\"name\":\"t\",\"mode\":\"target\"}],"
      + "\"rule\":[{"
      + "\"name\":\"callInner\","
      + "\"source\":[{\"context\":\"s\"}],"
      + "\"dependent\":[{"
      + "\"name\":\"inner\","
      + "\"parameter\":[{\"valueId\":\"s\"},{\"valueId\":\"t\"}]"
      + "}]}]}]}";

      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(r5SmJson))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, resp.statusCode(), "load: " + resp.body());

      org.hl7.fhir.utilities.json.model.JsonObject body =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resp.body());
      assertEquals(1, body.asInteger("loaded"));
      String descriptor = body.getJsonArray("resources").get(0).asString();
      assertTrue(descriptor.contains("warning"),
        "R5-format SM on R4 validator must surface a warning: " + descriptor);
      assertTrue(descriptor.contains("R5-only") || descriptor.contains("parameter"),
        "warning must mention the R5-only field that caused the mismatch: " + descriptor);
    }

    @Test
    @DisplayName("LoadResource - a freshly parsed FML round-trips back into the same validator with NO warning")
    void testLoadResourceRoundTripsParsedFml() throws Exception {
      // The two fixes together (parse emits R4-format on R4 + loader warns on R5-only fields)
      // must compose: parse FML → get a StructureMap → POST it back → no warning, no skipped.
      setUpService(getValidationEngine());

      HttpResponse<String> parseResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/fml?name=PassThrough"))
          .POST(HttpRequest.BodyPublishers.ofString(FML_WITH_DEPENDENT))
          .header("Content-Type", "text/plain")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, parseResp.statusCode());

      HttpResponse<String> loadResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(parseResp.body()))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, loadResp.statusCode(), "load: " + loadResp.body());

      org.hl7.fhir.utilities.json.model.JsonObject body =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(loadResp.body());
      String descriptor = body.getJsonArray("resources").get(0).asString();
      assertFalse(descriptor.contains("warning"),
        "round-trip parse→load must NOT warn — parse output is already in the right version format: " + descriptor);
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

    /**
     * Companion to {@link #testFmlParseEmitsRuntimeVersion} and
     * {@link #testItbLoadResourceReplaceUpdatesExisting} — the $package operation
     * was the third place where StructureMap serialisation could leak R5 shapes
     * to an R4 caller (the Bundle was always composed by the R5 parser regardless
     * of {@code -version}). The fix is now applied so the whole Bundle (including
     * every nested StructureMap walked by {@code ResourceDependencyWalker}) goes
     * through {@code VersionConvertorFactory_40_50.convertResource} before serialisation.
     *
     * <p>This test parses a 2-group FML (the outer group invokes the inner via
     * {@code then InnerCopy(src, t)} — a dependent with 2 valueId params),
     * registers the resulting StructureMap, packages it, then asserts that the
     * StructureMap inside the returned Bundle has R4 {@code dependent.variable} —
     * NOT R5 {@code dependent.parameter}. Failure mode the test guards against:
     * the bundled SM has empty {@code dependent.variable} → transform later fails
     * with the misleading "has N but invocation has 0 variables" error.
     */
    @Test
    @DisplayName("ITB Package - bundled StructureMaps use R4 dependent.variable on R4 validator")
    void testItbPackageEmitsRuntimeVersionForBundledStructureMaps() throws Exception {
      setUpService(getValidationEngine());

      // 1. Parse a 2-group FML — the outer rule invokes the inner via 'then InnerCopy(src, t)'
      String smJson = parseFmlViaItb(FML_WITH_DEPENDENT);

      // 2. Register the parsed SM (use replace=true so re-runs are idempotent)
      itbLoadResource(smJson, true);

      // 3. Package it by canonical URL. includeRuleReferences=true exercises the
      //    walker code path that follows rule-level references — the path the bug
      //    report identifies as also leaking R5 shape.
      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "package");
      org.hl7.fhir.utilities.json.model.JsonArray input = new org.hl7.fhir.utilities.json.model.JsonArray();
      input.add(anyContent("resource", "http://example.org/StructureMap/PassThrough"));
      input.add(anyContent("includeRuleReferences", "true"));
      input.add(anyContent("targetFormat", "json"));
      body.add("input", input);

      HttpResponse<String> pkgResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/itb/package/process"))
          .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
          .header("Content-Type", "application/json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, pkgResp.statusCode(), "package: " + pkgResp.body());

      org.hl7.fhir.utilities.json.model.JsonObject envelope =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(pkgResp.body());
      String bundleJson = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el : envelope.getJsonArray("output")) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("bundle".equals(ac.asString("name"))) bundleJson = ac.asString("value");
      }
      assertTrue(bundleJson != null && !bundleJson.isEmpty(), "package must return a bundle");

      org.hl7.fhir.utilities.json.model.JsonObject bundle =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(bundleJson);
      assertEquals("Bundle", bundle.asString("resourceType"));

      // 4. Walk every StructureMap entry. For each, every rule.dependent must use
      //    R4 'variable[]', NOT R5 'parameter[]'. This is the heart of the bug
      //    report: any entry that comes through with 'parameter' but no 'variable'
      //    would re-trigger "has N but invocation has 0 variables" downstream.
      int smCount = 0;
      int depCount = 0;
      for (org.hl7.fhir.utilities.json.model.JsonElement entryEl : bundle.getJsonArray("entry")) {
        org.hl7.fhir.utilities.json.model.JsonObject resource = entryEl.asJsonObject().getJsonObject("resource");
        if (!"StructureMap".equals(resource.asString("resourceType"))) continue;
        smCount++;
        org.hl7.fhir.utilities.json.model.JsonArray groups = resource.getJsonArray("group");
        if (groups == null) continue;
        for (org.hl7.fhir.utilities.json.model.JsonElement groupEl : groups) {
          for (org.hl7.fhir.utilities.json.model.JsonElement ruleEl : groupEl.asJsonObject().getJsonArray("rule")) {
            org.hl7.fhir.utilities.json.model.JsonObject rule = ruleEl.asJsonObject();
            if (!rule.has("dependent")) continue;
            for (org.hl7.fhir.utilities.json.model.JsonElement depEl : rule.getJsonArray("dependent")) {
              org.hl7.fhir.utilities.json.model.JsonObject dep = depEl.asJsonObject();
              depCount++;
              assertFalse(dep.has("parameter"),
                "$package output must NOT contain R5 dependent.parameter on R4 validator — found in "
                  + resource.asString("url") + " rule " + rule.asString("name") + ": " + dep);
              assertTrue(dep.has("variable") && dep.getJsonArray("variable").size() > 0,
                "$package output must carry R4 dependent.variable[...] (non-empty) — got: " + dep);
            }
          }
        }
      }
      assertTrue(smCount > 0,  "package must include at least one StructureMap in the bundle");
      assertTrue(depCount > 0, "test FML has dependent invocations — bundled SM must contain at least one");
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

    // ─── Ad-hoc resource loading (/loadResource) tests ───

    /** Two CodeSystems in a `collection` Bundle — used to verify Bundle-iteration semantics. */
    private static final String SAMPLE_COLLECTION_BUNDLE =
        "{\"resourceType\":\"Bundle\",\"type\":\"collection\",\"entry\":["
      + "{\"resource\":{\"resourceType\":\"CodeSystem\",\"id\":\"lr-cs1\","
      + "\"url\":\"http://example.org/CodeSystem/lr-cs1\",\"version\":\"1.0.0\","
      + "\"status\":\"active\",\"content\":\"complete\","
      + "\"concept\":[{\"code\":\"x\",\"display\":\"X\"}]}},"
      + "{\"resource\":{\"resourceType\":\"CodeSystem\",\"id\":\"lr-cs2\","
      + "\"url\":\"http://example.org/CodeSystem/lr-cs2\","
      + "\"status\":\"active\",\"content\":\"complete\","
      + "\"concept\":[{\"code\":\"y\",\"display\":\"Y\"}]}}"
      + "]}";

    @Test
    @DisplayName("LoadResource - parse FML then register the resulting StructureMap on the server")
    void testLoadResourceEndToEnd() throws Exception {
      setUpService(getValidationEngine());

      // 1. parse FML to a StructureMap JSON
      HttpResponse<String> parseResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/fml?name=IdentityTest"))
          .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_FML))
          .header("Content-Type", "text/plain")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, parseResp.statusCode(), "parse: " + parseResp.body());
      String smJson = parseResp.body();

      // 2. register the parsed SM on the running validator
      HttpResponse<String> loadResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(smJson))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, loadResp.statusCode(), "load: " + loadResp.body());
      org.hl7.fhir.utilities.json.model.JsonObject loadBody =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(loadResp.body());
      assertEquals(1, loadBody.asInteger("loaded"));
      org.hl7.fhir.utilities.json.model.JsonArray loadedRes = loadBody.getJsonArray("resources");
      assertEquals(1, loadedRes.size());
      assertTrue(loadedRes.get(0).asString().contains("StructureMap"));
      assertTrue(loadedRes.get(0).asString().contains("http://example.org/StructureMap/IdentityTest"));

      // 3. confirm the validator can now resolve the registered SM by its canonical URL.
      // We hit /transform with the SM URL — the SM must be found in context. Whether the
      // engine successfully completes the actual transformation is a separate concern
      // (it depends on snapshot infrastructure not relevant here); the failure mode we
      // explicitly do NOT want is "Unable to find map ..." which signals registration didn't take.
      String patient = "{\"resourceType\":\"Patient\",\"id\":\"abc\"}";
      String mapParam = java.net.URLEncoder.encode("http://example.org/StructureMap/IdentityTest", "UTF-8");
      HttpResponse<String> xfmResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/transform?map=" + mapParam))
          .POST(HttpRequest.BodyPublishers.ofString(patient))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertFalse(xfmResp.body().contains("Unable to find map"),
        "After /loadResource the validator must be able to resolve the SM by canonical URL: " + xfmResp.body());
    }

    @Test
    @DisplayName("LoadResource - registers every entry of a `collection` Bundle")
    void testLoadResourceBundle() throws Exception {
      setUpService(getValidationEngine());

      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_COLLECTION_BUNDLE))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, resp.statusCode(), "body: " + resp.body());
      org.hl7.fhir.utilities.json.model.JsonObject body =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resp.body());
      assertEquals(2, body.asInteger("loaded"), "Both entries must be registered");
      org.hl7.fhir.utilities.json.model.JsonArray arr = body.getJsonArray("resources");
      assertEquals(2, arr.size());
      assertTrue(arr.get(0).asString().contains("CodeSystem"));
      assertTrue(arr.get(1).asString().contains("CodeSystem"));
    }

    /**
     * Authoring loop scenario — a developer iterates on an FML mapping and resubmits
     * the resulting StructureMap repeatedly under the SAME canonical URL. Without an
     * opt-in flag the server returns {@code (skipped, already in context)} on every
     * re-submission, which forces the author to bump {@code StructureMap.version} on
     * every edit just to get the change to take.
     * <p>
     * Intended behaviour: {@code POST /loadResource?replace=true} drops any existing
     * resource with the same canonical URL before registering the new one, so a same-
     * URL re-submission overwrites in place. This test fails today on purpose — it
     * pins the contract we want.
     */
    @Test
    @DisplayName("LoadResource - replace=true overwrites an existing StructureMap (same URL, authoring loop)")
    void testLoadResourceReplaceUpdatesExisting() throws Exception {
      setUpService(getValidationEngine());

      // 1. Parse the original FML to a StructureMap JSON and register it.
      HttpResponse<String> parse1 = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/fml?name=IdentityTest"))
          .POST(HttpRequest.BodyPublishers.ofString(SAMPLE_FML))
          .header("Content-Type", "text/plain")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, parse1.statusCode(), "first parse: " + parse1.body());

      HttpResponse<String> load1 = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(parse1.body()))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, load1.statusCode(), "first load: " + load1.body());
      assertFalse(load1.body().contains("skipped"),
        "first registration must succeed (the URL is fresh): " + load1.body());

      // 2. Author a modified FML — same URL, different group body. This is the authoring
      //    flow: the user is iterating on the mapping and does not want to keep bumping
      //    StructureMap.version just to get each edit picked up.
      String modifiedFml =
          "map \"http://example.org/StructureMap/IdentityTest\" = \"IdentityTest\"\n" +
          "\n" +
          "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientSrc as source\n" +
          "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientTgt as target\n" +
          "\n" +
          "group IdentityTest(source src : PatientSrc, target tgt : PatientTgt) {\n" +
          "  src.id -> tgt.id;\n" +
          "  src.gender -> tgt.gender;\n" +
          "}\n";

      HttpResponse<String> parse2 = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/fml?name=IdentityTest"))
          .POST(HttpRequest.BodyPublishers.ofString(modifiedFml))
          .header("Content-Type", "text/plain")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, parse2.statusCode(), "second parse: " + parse2.body());

      // 3. Re-register WITH replace=true — must overwrite, not skip.
      HttpResponse<String> load2 = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource?replace=true"))
          .POST(HttpRequest.BodyPublishers.ofString(parse2.body()))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, load2.statusCode(), "second load: " + load2.body());

      org.hl7.fhir.utilities.json.model.JsonObject load2Body =
        org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(load2.body());
      assertEquals(1, load2Body.asInteger("loaded"),
        "replace=true must register the same-URL StructureMap: " + load2.body());
      String desc = load2Body.getJsonArray("resources").get(0).asString();
      assertFalse(desc.contains("skipped"),
        "replace=true must overwrite, not skip — got: " + desc);
      // The descriptor itself ideally reports the replacement; not strict on wording,
      // just verify it isn't a "skipped" outcome and that it references the SM.
      assertTrue(desc.contains("StructureMap"),
        "descriptor must reference the StructureMap: " + desc);
      assertTrue(desc.contains("http://example.org/StructureMap/IdentityTest"),
        "descriptor must reference the canonical URL: " + desc);

      // 4. Confirm the validator's context now resolves to the new mapping. The modified
      //    SM has a `gender` rule that the original did not; running /transform on a
      //    Patient that has `gender` should not lose it. Whether the transform engine
      //    succeeds end-to-end depends on snapshot infrastructure we don't control here,
      //    but the failure mode we explicitly check against is "Unable to find map ..."
      //    which would signal registration didn't take.
      String patient = "{\"resourceType\":\"Patient\",\"id\":\"abc\",\"gender\":\"female\"}";
      String mapParam = java.net.URLEncoder.encode(
        "http://example.org/StructureMap/IdentityTest", "UTF-8");
      HttpResponse<String> xfmResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/transform?map=" + mapParam))
          .POST(HttpRequest.BodyPublishers.ofString(patient))
          .header("Content-Type", "application/fhir+json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertFalse(xfmResp.body().contains("Unable to find map"),
        "After replace=true, the validator must resolve the new SM by canonical URL: " + xfmResp.body());
    }

    @Test
    @DisplayName("LoadResource - missing body returns 400")
    void testLoadResourceMissingBody() throws Exception {
      setUpService(getValidationEngine());

      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/loadResource"))
          .POST(HttpRequest.BodyPublishers.ofString(""))
          .build(),
        HttpResponse.BodyHandlers.ofString());

      assertEquals(400, resp.statusCode());
      assertTrue(resp.body().contains("Missing request body"));
    }

    @Test
    @DisplayName("LoadResource - GET method not allowed")
    void testLoadResourceGetNotAllowed() throws Exception {
      setUpService(getValidationEngine());

      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder().uri(URI.create(BASE_URL + "/loadResource")).GET().build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(405, resp.statusCode());
    }

    @Test
    @DisplayName("ITB LoadResource - register a StructureMap via the GITB endpoint")
    void testItbLoadResource() throws Exception {
      setUpService(getValidationEngine());

      // 1. parse FML via the GITB transform-parse op
      org.hl7.fhir.utilities.json.model.JsonObject parseBody = new org.hl7.fhir.utilities.json.model.JsonObject();
      parseBody.add("operation", "parse");
      org.hl7.fhir.utilities.json.model.JsonArray pin = new org.hl7.fhir.utilities.json.model.JsonArray();
      pin.add(anyContent("content", SAMPLE_FML));
      parseBody.add("input", pin);
      HttpResponse<String> parseResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/itb/transform/process"))
          .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(parseBody)))
          .header("Content-Type", "application/json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, parseResp.statusCode(), "parse: " + parseResp.body());
      String smJson = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el :
           org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(parseResp.body()).getJsonArray("output")) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("structureMap".equals(ac.asString("name"))) smJson = ac.asString("value");
      }
      assertTrue(smJson != null && !smJson.isEmpty());

      // 2. register via the GITB loadResource op
      org.hl7.fhir.utilities.json.model.JsonObject loadBody = new org.hl7.fhir.utilities.json.model.JsonObject();
      loadBody.add("operation", "loadResource");
      org.hl7.fhir.utilities.json.model.JsonArray lin = new org.hl7.fhir.utilities.json.model.JsonArray();
      lin.add(anyContent("content", smJson));
      loadBody.add("input", lin);
      HttpResponse<String> loadResp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/itb/loadResource/process"))
          .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(loadBody)))
          .header("Content-Type", "application/json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, loadResp.statusCode(), "load: " + loadResp.body());
      String loadedCount = null;
      String loadedRes = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el :
           org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(loadResp.body()).getJsonArray("output")) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("loaded".equals(ac.asString("name")))    loadedCount = ac.asString("value");
        if ("resources".equals(ac.asString("name"))) loadedRes   = ac.asString("value");
      }
      assertEquals("1", loadedCount, "GITB output 'loaded' must be 1");
      assertTrue(loadedRes != null && loadedRes.contains("StructureMap"),
        "GITB output 'resources' must reference the registered StructureMap: " + loadedRes);
    }

    /**
     * Same authoring loop as {@link #testLoadResourceReplaceUpdatesExisting} but via the GITB
     * endpoint that the transform-workbench (and any GITB client) uses. {@code replace=true}
     * on the second {@code /itb/loadResource/process} call must overwrite the existing
     * StructureMap rather than report {@code (skipped, already in context)}.
     */
    @Test
    @DisplayName("ITB LoadResource - replace=true overwrites an existing StructureMap (authoring loop)")
    void testItbLoadResourceReplaceUpdatesExisting() throws Exception {
      setUpService(getValidationEngine());

      String smJson1 = parseFmlViaItb(SAMPLE_FML);

      // 1. First registration — fresh URL, no replace flag needed.
      String[] r1 = itbLoadResource(smJson1, false);
      assertEquals("1", r1[0], "first load count: " + r1[1]);
      assertFalse(r1[1].contains("skipped"),
        "first registration must not be skipped: " + r1[1]);

      // 2. Modify FML — same URL, different group body.
      String modifiedFml =
          "map \"http://example.org/StructureMap/IdentityTest\" = \"IdentityTest\"\n" +
          "\n" +
          "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientSrc as source\n" +
          "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias PatientTgt as target\n" +
          "\n" +
          "group IdentityTest(source src : PatientSrc, target tgt : PatientTgt) {\n" +
          "  src.id -> tgt.id;\n" +
          "  src.gender -> tgt.gender;\n" +
          "}\n";
      String smJson2 = parseFmlViaItb(modifiedFml);

      // 3. Re-register WITHOUT replace — must be skipped (current default behaviour).
      String[] r2 = itbLoadResource(smJson2, false);
      assertEquals("1", r2[0]);
      assertTrue(r2[1].contains("skipped"),
        "default behaviour without replace must skip: " + r2[1]);

      // 4. Re-register WITH replace=true — must overwrite.
      String[] r3 = itbLoadResource(smJson2, true);
      assertEquals("1", r3[0]);
      assertFalse(r3[1].contains("skipped"),
        "replace=true must overwrite, not skip — got: " + r3[1]);
      assertTrue(r3[1].contains("StructureMap"),
        "descriptor must reference the StructureMap: " + r3[1]);
    }

    /** Parse an FML string via {@code POST /itb/transform/process} and return the StructureMap JSON. */
    private String parseFmlViaItb(String fml) throws Exception {
      org.hl7.fhir.utilities.json.model.JsonObject parseBody = new org.hl7.fhir.utilities.json.model.JsonObject();
      parseBody.add("operation", "parse");
      org.hl7.fhir.utilities.json.model.JsonArray pin = new org.hl7.fhir.utilities.json.model.JsonArray();
      pin.add(anyContent("content", fml));
      parseBody.add("input", pin);
      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/itb/transform/process"))
          .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(parseBody)))
          .header("Content-Type", "application/json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, resp.statusCode(), "FML parse: " + resp.body());
      for (org.hl7.fhir.utilities.json.model.JsonElement el :
           org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resp.body()).getJsonArray("output")) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("structureMap".equals(ac.asString("name"))) return ac.asString("value");
      }
      throw new AssertionError("FML parse output had no 'structureMap' value");
    }

    /** POST a resource to {@code /itb/loadResource/process}. Returns [loadedCount, resourcesList]. */
    private String[] itbLoadResource(String smJson, boolean replace) throws Exception {
      org.hl7.fhir.utilities.json.model.JsonObject body = new org.hl7.fhir.utilities.json.model.JsonObject();
      body.add("operation", "loadResource");
      org.hl7.fhir.utilities.json.model.JsonArray lin = new org.hl7.fhir.utilities.json.model.JsonArray();
      lin.add(anyContent("content", smJson));
      if (replace) lin.add(anyContent("replace", "true"));
      body.add("input", lin);
      HttpResponse<String> resp = httpClient.send(
        HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/itb/loadResource/process"))
          .POST(HttpRequest.BodyPublishers.ofString(org.hl7.fhir.utilities.json.parser.JsonParser.compose(body)))
          .header("Content-Type", "application/json")
          .build(),
        HttpResponse.BodyHandlers.ofString());
      assertEquals(200, resp.statusCode(), "load: " + resp.body());
      String count = null, list = null;
      for (org.hl7.fhir.utilities.json.model.JsonElement el :
           org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(resp.body()).getJsonArray("output")) {
        org.hl7.fhir.utilities.json.model.JsonObject ac = el.asJsonObject();
        if ("loaded".equals(ac.asString("name")))    count = ac.asString("value");
        if ("resources".equals(ac.asString("name"))) list  = ac.asString("value");
      }
      return new String[] { count, list == null ? "" : list };
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