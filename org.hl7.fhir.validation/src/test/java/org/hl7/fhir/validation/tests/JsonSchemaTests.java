package org.hl7.fhir.validation.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JsonSchemaTests {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  static private JsonSchema sFhir;
  static private JsonSchema sTest;

  public static final String TEST_SCHEMA = "{\r\n" +
    "  \"$schema\": \"http://json-schema.org/draft-06/schema#\",\r\n" +
    //     "  \"id\": \"http://hl7.org/fhir/test-json-schema/4.0\",\r\n"+
    "  \"description\": \"for unit tests\",\r\n" +
    "  \"discriminator\": {\r\n" +
    "    \"propertyName\": \"resourceType\",\r\n" +
    "    \"mapping\": {\r\n" +
    "      \"A\": \"#/definitions/A\",\r\n" +
    "      \"B\": \"#/definitions/B\"\r\n" +
    "    }\r\n" +
    "  },\r\n" +
    "  \"oneOf\": [\r\n" +
    "    {\r\n" +
    "      \"$ref\": \"#/definitions/A\"\r\n" +
    "    },\r\n" +
    "    {\r\n" +
    "      \"$ref\": \"#/definitions/B\"\r\n" +
    "    }\r\n" +
    "  ],\r\n" +
    "  \"definitions\": {\r\n" +
    "    \"boolean\": {\r\n" +
    "      \"pattern\": \"^true|false$\",\r\n" +
    "      \"type\": \"boolean\"\r\n" +
    "    },\r\n" +
    "    \"id\": {\r\n" +
    "      \"pattern\": \"^[A-Za-z0-9\\\\-\\\\.]{1,64}$\",\r\n" +
    "      \"type\": \"string\"\r\n" +
    "    },\r\n" +
    "    \"integer\": {\r\n" +
    "      \"pattern\": \"^-?([0]|([1-9][0-9]*))$\",\r\n" +
    "      \"type\": \"number\"\r\n" +
    "    },\r\n" +
    "    \"string\": {\r\n" +
    "      \"pattern\": \"^[ \\\\r\\\\n\\\\t\\\\S]+$\",\r\n" +
    "      \"type\": \"string\"\r\n" +
    "    },\r\n" +
    "    \"Element\": {\r\n" +
    "      \"properties\": {\r\n" +
    "        \"id\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        }\r\n" +
    "      },\r\n" +
    "      \"additionalProperties\": false\r\n" +
    "    },\r\n" +
    "    \"Coding\": {\r\n" +
    "      \"properties\": {\r\n" +
    "        \"id\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"system\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"version\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"code\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"display\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"userSelected\": {\r\n" +
    "          \"$ref\": \"#/definitions/boolean\"\r\n" +
    "        }\r\n" +
    "      },\r\n" +
    "      \"additionalProperties\": false\r\n" +
    "    },\r\n" +
    "    \"A\": {\r\n" +
    "      \"properties\": {\r\n" +
    "        \"resourceType\": {\r\n" +
    "          \"const\": \"A\"\r\n" +
    "        },\r\n" +
    "        \"id\": {\r\n" +
    "          \"$ref\": \"#/definitions/id\"\r\n" +
    "        }\r\n" +
    "      },\r\n" +
    "      \"required\": [\r\n" +
    "        \"resourceType\"\r\n" +
    "      ]\r\n" +
    "    },\r\n" +
    "    \"B\": {\r\n" +
    "      \"properties\": {\r\n" +
    "        \"resourceType\": {\r\n" +
    "          \"const\": \"B\"\r\n" +
    "        },\r\n" +
    "        \"code\": {\r\n" +
    "          \"$ref\": \"#/definitions/id\"\r\n" +
    "        },\r\n" +
    "        \"string\": {\r\n" +
    "          \"$ref\": \"#/definitions/string\"\r\n" +
    "        },\r\n" +
    "        \"integer\": {\r\n" +
    "          \"$ref\": \"#/definitions/integer\"\r\n" +
    "        },\r\n" +
    "        \"boolean\": {\r\n" +
    "          \"$ref\": \"#/definitions/boolean\"\r\n" +
    "        }\r\n" +
    "         \r\n" +
    "      },\r\n" +
    "      \"additionalProperties\": false,\r\n" +
    "      \"required\": [\r\n" +
    "        \"resourceType\", \"code\"\r\n" +
    "      ]\r\n" +
    "    }\r\n" +
    "  }\r\n" +
    "}\r\n";

  @BeforeEach
  public void setUp() throws Exception {
    if (sFhir == null) {
//      String path = TestUtilities.resourceNameToFile("fhir.schema.json"); // todo... what should this be?
//      String source = FileUtilities.fileToString(path);
//      JsonNode rawSchema = MAPPER.readTree(source);
//      sFhir = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V6).getSchema(rawSchema);
      JsonNode rawSchema = MAPPER.readTree(TEST_SCHEMA);
      sTest = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V6).getSchema(rawSchema);
    }
  }

  private boolean validateJson(String source, JsonSchema schema) throws IOException {
    JsonNode node = MAPPER.readTree(source);
    Set<ValidationMessage> messages = schema.validate(node);
    if (!messages.isEmpty()) {
      messages.forEach(m -> System.out.println(m.getMessage()));
      return false;
    }
    return true;
  }


  private void pass(String source, JsonSchema schema) throws FileNotFoundException, IOException {
    Assertions.assertTrue(validateJson(source, schema));
  }

  private void fail(String source, JsonSchema schema) throws FileNotFoundException, IOException {
    Assertions.assertFalse(validateJson(source, schema));
  }

  @Test
  public void testTestSchemaPass() throws FileNotFoundException, IOException {
    pass("{ \"resourceType\" : \"A\" }", sTest);
  }

//  
//  @Test
//  public void testEmptyPatient() throws FileNotFoundException, IOException {
//    pass("{ \"resourceType\" : \"Patient\", \"id\" : \"1\" }", sFhir);
//  }
//
//  @Test
//  public void testNonResource() throws FileNotFoundException, IOException {
//    fail("{ \"resourceType\" : \"Patient1\", \"id\" : \"1\" }", sFhir);
//  }
//
//  @Test
//  public void testSimpleInvalid() throws FileNotFoundException, IOException {
//    fail("{ \"resourceType\" : \"Patient\", \"n--id\" : \"1\" }", sFhir);
//  }


}