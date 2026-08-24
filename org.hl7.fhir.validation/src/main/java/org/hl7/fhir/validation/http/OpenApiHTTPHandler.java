package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Serves the OpenAPI 3.0 specification as JSON at /openapi.json.
 */
class OpenApiHTTPHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    byte[] responseBytes = OPENAPI_SPEC.getBytes(StandardCharsets.UTF_8);
    exchange.getResponseHeaders().set("Content-Type", "application/json");
    exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
    exchange.sendResponseHeaders(200, responseBytes.length);
    try (OutputStream os = exchange.getResponseBody()) {
      os.write(responseBytes);
    }
  }

  private static final String OPENAPI_SPEC = "{\n" +
    "  \"openapi\": \"3.0.3\",\n" +
    "  \"info\": {\n" +
    "    \"title\": \"FHIR Validator HTTP Service\",\n" +
    "    \"description\": \"REST API for the HL7 FHIR Validator engine. Provides validation, format conversion, FHIRPath evaluation, test data generation, StructureMap operations, version conversion, and more.\",\n" +
    "    \"version\": \"1.0.0\",\n" +
    "    \"contact\": {\n" +
    "      \"name\": \"HL7 FHIR Core Team\",\n" +
    "      \"url\": \"https://github.com/hapifhir/org.hl7.fhir.core\"\n" +
    "    }\n" +
    "  },\n" +
    "  \"servers\": [\n" +
    "    { \"url\": \"http://localhost:8080\", \"description\": \"Local development server\" }\n" +
    "  ],\n" +
    "  \"paths\": {\n" +

    // /validateResource
    "    \"/validateResource\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Validation\"],\n" +
    "        \"summary\": \"Validate a FHIR resource\",\n" +
    "        \"description\": \"Validates a FHIR resource (JSON or XML) against base FHIR specification and optionally against one or more profiles.\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"profiles\", \"in\": \"query\", \"description\": \"Comma-separated list of profile canonical URLs to validate against\", \"schema\": { \"type\": \"string\" } },\n" +
    "          { \"name\": \"resourceIdRule\", \"in\": \"query\", \"description\": \"How to handle resource IDs\", \"schema\": { \"type\": \"string\", \"enum\": [\"OPTIONAL\", \"REQUIRED\", \"PROHIBITED\"], \"default\": \"OPTIONAL\" } },\n" +
    "          { \"name\": \"anyExtensionsAllowed\", \"in\": \"query\", \"description\": \"Whether unknown extensions are allowed\", \"schema\": { \"type\": \"boolean\", \"default\": true } },\n" +
    "          { \"name\": \"bpWarnings\", \"in\": \"query\", \"description\": \"Best practice warning level\", \"schema\": { \"type\": \"string\", \"enum\": [\"Ignore\", \"Hint\", \"Warning\", \"Error\"], \"default\": \"Ignore\" } },\n" +
    "          { \"name\": \"displayOption\", \"in\": \"query\", \"description\": \"How to check display values\", \"schema\": { \"type\": \"string\", \"enum\": [\"Ignore\", \"Check\", \"CheckCaseAndSpace\", \"CheckCase\", \"CheckSpace\"], \"default\": \"Ignore\" } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to validate\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Validation result\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } }, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Invalid parameters\" },\n" +
    "          \"500\": { \"description\": \"Validation engine error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /fhirpath
    "    \"/fhirpath\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"FHIRPath\"],\n" +
    "        \"summary\": \"Evaluate a FHIRPath expression\",\n" +
    "        \"description\": \"Evaluates a FHIRPath expression against a FHIR resource and returns the result as a Parameters resource.\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"expression\", \"in\": \"query\", \"required\": true, \"description\": \"The FHIRPath expression to evaluate\", \"schema\": { \"type\": \"string\" }, \"example\": \"Patient.name.family\" }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to evaluate the expression against\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Evaluation result as a Parameters resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing expression parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"FHIRPath evaluation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /matchetype
    "    \"/matchetype\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Testing\"],\n" +
    "        \"summary\": \"Compare a resource against a matchetype pattern\",\n" +
    "        \"description\": \"Compares an actual FHIR resource against an expected matchetype pattern. The pattern can use wildcards like $string$, $date$, $uuid$ for flexible matching.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"JSON wrapper with 'resource' (actual) and 'matchetype' (expected pattern)\",\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"resource\", \"matchetype\"],\n" +
    "                \"properties\": {\n" +
    "                  \"resource\": { \"type\": \"object\", \"description\": \"The actual FHIR resource\" },\n" +
    "                  \"matchetype\": { \"type\": \"object\", \"description\": \"The expected pattern with optional wildcards\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": {\n" +
    "                \"resource\": { \"resourceType\": \"Patient\", \"name\": [{ \"family\": \"Doe\" }] },\n" +
    "                \"matchetype\": { \"resourceType\": \"Patient\", \"name\": [{ \"family\": \"$string$\" }] }\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Comparison result (OperationOutcome with 'All OK' or error issues)\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } } } },\n" +
    "          \"400\": { \"description\": \"Missing resource or matchetype field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Comparison engine error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /testdata
    "    \"/testdata\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Testing\"],\n" +
    "        \"summary\": \"Generate test data from a FHIR profile\",\n" +
    "        \"description\": \"Generates conformant test data for a given FHIR profile. Supports custom data mappings and can return single resources or Bundles.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"JSON object specifying the profile and optional data/mappings\",\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"profile\"],\n" +
    "                \"properties\": {\n" +
    "                  \"profile\": { \"type\": \"string\", \"description\": \"Canonical URL of the profile\" },\n" +
    "                  \"data\": { \"type\": \"array\", \"description\": \"Array of data rows (column name -> value)\", \"items\": { \"type\": \"object\" } },\n" +
    "                  \"mappings\": { \"type\": \"array\", \"description\": \"Array of path-to-expression mappings\", \"items\": { \"type\": \"object\", \"properties\": { \"path\": { \"type\": \"string\" }, \"expression\": { \"type\": \"string\" }, \"parts\": { \"type\": \"array\" } } } },\n" +
    "                  \"bundle\": { \"type\": \"string\", \"description\": \"Set to 'true' to return a Bundle\", \"enum\": [\"true\", \"false\"] },\n" +
    "                  \"format\": { \"type\": \"string\", \"description\": \"Output format\", \"enum\": [\"json\", \"xml\"], \"default\": \"json\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": {\n" +
    "                \"profile\": \"http://hl7.org/fhir/StructureDefinition/Patient\",\n" +
    "                \"data\": [{ \"familyName\": \"Doe\", \"givenName\": \"John\" }],\n" +
    "                \"mappings\": [\n" +
    "                  { \"path\": \"Patient.name.family\", \"expression\": \"column('familyName')\" },\n" +
    "                  { \"path\": \"Patient.name.given\", \"expression\": \"column('givenName')\" }\n" +
    "                ]\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Generated FHIR resource(s)\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing profile field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Generation error (e.g. profile not found)\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /loadIG
    "    \"/loadIG\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Configuration\"],\n" +
    "        \"summary\": \"Load an Implementation Guide\",\n" +
    "        \"description\": \"Dynamically loads an IG package into the validation engine. Supports package registry references (id#version), URLs to .tgz packages, and local file paths.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"content\": {\n" +
    "            \"application/json\": {\n" +
    "              \"schema\": {\n" +
    "                \"type\": \"object\",\n" +
    "                \"required\": [\"ig\"],\n" +
    "                \"properties\": {\n" +
    "                  \"ig\": { \"type\": \"string\", \"description\": \"IG source: package#version, URL, or file path\" }\n" +
    "                }\n" +
    "              },\n" +
    "              \"example\": { \"ig\": \"hl7.fhir.us.core#5.0.1\" }\n" +
    "            }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"IG loaded successfully\", \"content\": { \"application/fhir+json\": { \"schema\": { \"$ref\": \"#/components/schemas/OperationOutcome\" } } } },\n" +
    "          \"400\": { \"description\": \"Missing ig field\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Failed to load IG\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /convert
    "    \"/convert\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Conversion\"],\n" +
    "        \"summary\": \"Convert a FHIR resource between JSON and XML\",\n" +
    "        \"description\": \"Converts a FHIR resource from one format to another. The input format is determined by Content-Type and the output format by the Accept header.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to convert\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Converted resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Conversion error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /snapshot
    "    \"/snapshot\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Profile Operations\"],\n" +
    "        \"summary\": \"Generate a snapshot for a StructureDefinition\",\n" +
    "        \"description\": \"Takes a StructureDefinition with a differential and generates the full snapshot. The input must be a StructureDefinition resource.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"A StructureDefinition resource (with differential)\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"StructureDefinition with snapshot populated\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Snapshot generation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /narrative
    "    \"/narrative\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Resource Operations\"],\n" +
    "        \"summary\": \"Generate a narrative for a FHIR resource\",\n" +
    "        \"description\": \"Generates a human-readable narrative (text.div) for a FHIR resource and returns the resource with the narrative populated.\",\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to generate a narrative for\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Resource with narrative populated in text.div\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Narrative generation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /transform
    "    \"/transform\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"StructureMap\"],\n" +
    "        \"summary\": \"Apply a StructureMap transformation\",\n" +
    "        \"description\": \"Applies a StructureMap transformation to a FHIR resource. The map must already be loaded (e.g. via /loadIG or part of base spec).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"map\", \"in\": \"query\", \"required\": true, \"description\": \"Canonical URL of the StructureMap to apply\", \"schema\": { \"type\": \"string\" } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to transform\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Transformed resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing map parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Transformation error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /version
    "    \"/version\": {\n" +
    "      \"post\": {\n" +
    "        \"tags\": [\"Conversion\"],\n" +
    "        \"summary\": \"Convert a resource between FHIR versions\",\n" +
    "        \"description\": \"Converts a FHIR resource from one FHIR version to another (e.g. R4 to R5). The resource must have a 'url' element for native conversion. Supported target versions: 1.0 (DSTU2), 3.0 (STU3), 4.0 (R4), 4.3 (R4B), 5.0 (R5).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"targetVersion\", \"in\": \"query\", \"required\": true, \"description\": \"Target FHIR version\", \"schema\": { \"type\": \"string\", \"enum\": [\"1.0\", \"3.0\", \"4.0\", \"4.3\", \"5.0\"] } }\n" +
    "        ],\n" +
    "        \"requestBody\": {\n" +
    "          \"required\": true,\n" +
    "          \"description\": \"The FHIR resource to convert\",\n" +
    "          \"content\": {\n" +
    "            \"application/fhir+json\": { \"schema\": { \"type\": \"object\" } },\n" +
    "            \"application/fhir+xml\": { \"schema\": { \"type\": \"string\" } }\n" +
    "          }\n" +
    "        },\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Converted resource in target version\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing targetVersion parameter\" },\n" +
    "          \"405\": { \"description\": \"Method not allowed (only POST)\" },\n" +
    "          \"500\": { \"description\": \"Version conversion error\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /compile
    "    \"/compile\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"StructureMap\"],\n" +
    "        \"summary\": \"Fetch and compile a StructureMap\",\n" +
    "        \"description\": \"Fetches a StructureMap by its canonical URL and returns the compiled resource. The map must be loaded in the engine (e.g. via /loadIG).\",\n" +
    "        \"parameters\": [\n" +
    "          { \"name\": \"url\", \"in\": \"query\", \"required\": true, \"description\": \"Canonical URL of the StructureMap\", \"schema\": { \"type\": \"string\" } }\n" +
    "        ],\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"The compiled StructureMap resource\", \"content\": { \"application/fhir+json\": {}, \"application/fhir+xml\": {} } },\n" +
    "          \"400\": { \"description\": \"Missing url parameter\" },\n" +
    "          \"500\": { \"description\": \"Compilation error or map not found\" }\n" +
    "        }\n" +
    "      }\n" +
    "    },\n" +

    // /stop
    "    \"/stop\": {\n" +
    "      \"get\": {\n" +
    "        \"tags\": [\"Configuration\"],\n" +
    "        \"summary\": \"Stop the HTTP server\",\n" +
    "        \"description\": \"Gracefully shuts down the FHIR Validator HTTP Service.\",\n" +
    "        \"responses\": {\n" +
    "          \"200\": { \"description\": \"Server stopping\" }\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +

    "  },\n" +
    "  \"components\": {\n" +
    "    \"schemas\": {\n" +
    "      \"OperationOutcome\": {\n" +
    "        \"type\": \"object\",\n" +
    "        \"description\": \"FHIR OperationOutcome resource containing validation results or error details\",\n" +
    "        \"properties\": {\n" +
    "          \"resourceType\": { \"type\": \"string\", \"enum\": [\"OperationOutcome\"] },\n" +
    "          \"issue\": {\n" +
    "            \"type\": \"array\",\n" +
    "            \"items\": {\n" +
    "              \"type\": \"object\",\n" +
    "              \"properties\": {\n" +
    "                \"severity\": { \"type\": \"string\", \"enum\": [\"fatal\", \"error\", \"warning\", \"information\"] },\n" +
    "                \"code\": { \"type\": \"string\" },\n" +
    "                \"details\": { \"type\": \"object\", \"properties\": { \"text\": { \"type\": \"string\" } } },\n" +
    "                \"expression\": { \"type\": \"array\", \"items\": { \"type\": \"string\" } }\n" +
    "              }\n" +
    "            }\n" +
    "          }\n" +
    "        }\n" +
    "      }\n" +
    "    }\n" +
    "  }\n" +
    "}\n";
}
