package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class NpmPackageIndexBuilderTest {

  @Test
  void testBuildWithoutDb() throws Exception {
    final var builder = new NpmPackageIndexBuilder();
    builder.start(null);

    final var cs = "{\"resourceType\":\"CapabilityStatement\",\"id\":\"base2\",\"meta\":{\"lastUpdated\":\"2019-11-01T09:29:23.356+11:00\"},\"url\":\"http://hl7.org/fhir/CapabilityStatement/base2\",\"version\":\"4.0.1\",\"name\":\"Base FHIR Capability Statement (Empty)\",\"status\":\"draft\",\"experimental\":true,\"date\":\"2019-11-01T09:29:23+11:00\",\"publisher\":\"FHIR Project Team\",\"contact\":[{\"telecom\":[{\"system\":\"url\",\"value\":\"http://hl7.org/fhir\"}]}],\"description\":\"This is the base Capability Statement for FHIR. It represents a server that provides the none of the functionality defined by FHIR. It is provided to use as a template for system designers to build their own Capability Statements from. A capability statement has to contain something, so this contains a read of a Capability Statement\",\"kind\":\"capability\",\"software\":{\"name\":\"Insert your software name here...\"},\"fhirVersion\":\"4.0.1\",\"format\":[\"xml\",\"json\"],\"rest\":[{\"mode\":\"server\",\"documentation\":\"An empty Capability Statement\",\"security\":{\"cors\":true,\"service\":[{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/restful-security-service\",\"code\":\"SMART-on-FHIR\",\"display\":\"SMART-on-FHIR\"}],\"text\":\"See http://docs.smarthealthit.org/\"}],\"description\":\"This is the Capability Statement to declare that the server supports SMART-on-FHIR. See the SMART-on-FHIR docs for the extension that would go with such a server\"},\"resource\":[{\"type\":\"CapabilityStatement\",\"interaction\":[{\"code\":\"read\",\"documentation\":\"Read CapabilityStatement Resource\"}]}]}]}";
    builder.seeFile("CapabilityStatement-base2.json", cs.getBytes(StandardCharsets.UTF_8));

    final var codeSystem = "{\"resourceType\":\"CodeSystem\",\"id\":\"action-type\"," +
      "\"meta\":{\"lastUpdated\":\"2019-11-01T09:29:23.356+11:00\"},\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/structuredefinition-wg\",\"valueCode\":\"cds\"},{\"url\":\"http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status\",\"valueCode\":\"trial-use\"},{\"url\":\"http://hl7.org/fhir/StructureDefinition/structuredefinition-fmm\",\"valueInteger\":2}],\"url\":\"http://terminology.hl7.org/CodeSystem/action-type\",\"identifier\":[{\"system\":\"urn:ietf:rfc:3986\",\"value\":\"urn:oid:2.16.840.1.113883.4.642.4.1246\"}],\"version\":\"4.0.1\",\"name\":\"ActionType\",\"title\":\"ActionType\",\"status\":\"draft\",\"experimental\":false,\"date\":\"2019-11-01T09:29:23+11:00\",\"publisher\":\"HL7 (FHIR Project)\",\"contact\":[{\"telecom\":[{\"system\":\"url\",\"value\":\"http://hl7.org/fhir\"},{\"system\":\"email\",\"value\":\"fhir@lists.hl7.org\"}]}],\"description\":\"The type of action to be performed.\",\"caseSensitive\":true,\"valueSet\":\"http://hl7.org/fhir/ValueSet/action-type\",\"content\":\"complete\",\"concept\":[{\"code\":\"create\",\"display\":\"Create\",\"definition\":\"The action is to create a new resource.\"},{\"code\":\"update\",\"display\":\"Update\",\"definition\":\"The action is to update an existing resource.\"},{\"code\":\"remove\",\"display\":\"Remove\",\"definition\":\"The action is to remove an existing resource.\"},{\"code\":\"fire-event\",\"display\":\"Fire Event\",\"definition\":\"The action is to fire a specific event.\"}]}";
    builder.seeFile("CodeSystem-action-type.json", codeSystem.getBytes(StandardCharsets.UTF_8));

    builder.seeFile("observation-spreadsheet.xml", getClass().getResourceAsStream("/observation-spreadsheet.xml").readAllBytes());
    builder.seeFile("settings-example.json",
                    getClass().getResourceAsStream("/settings/settings-example.json").readAllBytes());
    builder.seeFile("tgz-normal.tgz",
                    getClass().getResourceAsStream("/npm/tar/tgz-normal.tgz").readAllBytes());


    final var result = builder.build();
    final var json = JsonParser.parseObject(result);
    assertEquals(2, json.getJsonNumber("index-version").getInteger());

    final var files = json.getJsonArray("files");
    assertEquals(2, files.size());

    var file = (JsonObject) files.get(0);
    assertEquals("CapabilityStatement-base2.json", file.getJsonString("filename").getValue());
    assertEquals("CapabilityStatement", file.getJsonString("resourceType").getValue());
    assertEquals("base2", file.getJsonString("id").getValue());
    assertEquals("http://hl7.org/fhir/CapabilityStatement/base2", file.getJsonString("url").getValue());
    assertEquals("4.0.1", file.getJsonString("version").getValue());
    assertEquals("capability", file.getJsonString("kind").getValue());
    assertFalse(file.has("supplements"));
    assertFalse(file.has("content"));
    assertFalse(file.has("valueSet"));
    assertFalse(file.has("derivation"));

    file = (JsonObject) files.get(1);
    assertEquals("CodeSystem-action-type.json", file.getJsonString("filename").getValue());
    assertEquals("CodeSystem", file.getJsonString("resourceType").getValue());
    assertEquals("action-type", file.getJsonString("id").getValue());
    assertEquals("http://terminology.hl7.org/CodeSystem/action-type", file.getJsonString("url").getValue());
    assertEquals("4.0.1", file.getJsonString("version").getValue());
    assertEquals("http://hl7.org/fhir/ValueSet/action-type", file.getJsonString("valueSet").getValue());
    assertEquals("complete", file.getJsonString("content").getValue());
    assertFalse(file.has("supplements"));
    assertFalse(file.has("kind"));
    assertFalse(file.has("derivation"));

  }

  // Media.type and Media.content are complex: they must not be indexed, and nothing inside them (e.g. content.id)
  // may be taken as a root property. Shape taken from US Core's Media-chest-xray example
  static final String MEDIA = "{\"resourceType\":\"Media\",\"id\":\"chest-xray\",\"status\":\"completed\","
    + "\"type\":{\"coding\":[{\"system\":\"http://terminology.hl7.org/CodeSystem/media-type\",\"code\":\"image\"}]},"
    + "\"modality\":{\"coding\":[{\"system\":\"http://snomed.info/sct\",\"version\":\"http://snomed.info/sct/731000124108\",\"code\":\"399208008\"}]},"
    + "\"subject\":{\"reference\":\"Patient/example\"},"
    + "\"content\":{\"id\":\"a1\",\"contentType\":\"image/jpeg\",\"url\":\"http://example.org/Binary/A12345\"}}";

  @Test
  void testComplexRootPropertiesAreNotIndexed() throws Exception {
    final var builder = new NpmPackageIndexBuilder();
    builder.start(null);
    builder.seeFile("Media-chest-xray.json", MEDIA.getBytes(StandardCharsets.UTF_8));
    // DocumentReference.content is an array, and the url inside it must not be taken
    builder.seeFile("DocumentReference-dr.json", ("{\"resourceType\":\"DocumentReference\",\"content\":[{\"attachment\":{\"url\":\"http://example.org/a\"}}],"
      + "\"id\":\"dr\",\"type\":{\"text\":\"note\"}}").getBytes(StandardCharsets.UTF_8));

    final var files = JsonParser.parseObject(builder.build()).getJsonArray("files");
    assertEquals(2, files.size());

    var file = (JsonObject) files.get(0);
    assertEquals("{\"filename\":\"Media-chest-xray.json\",\"resourceType\":\"Media\",\"id\":\"chest-xray\"}", JsonParser.compose(file, false));

    file = (JsonObject) files.get(1);
    assertEquals("{\"filename\":\"DocumentReference-dr.json\",\"resourceType\":\"DocumentReference\",\"id\":\"dr\"}", JsonParser.compose(file, false));
  }

  @Test
  void testUnreadableFileIsNotIndexed() throws Exception {
    final var builder = new NpmPackageIndexBuilder();
    builder.start(null);
    builder.seeFile("Patient-broken.json", "{\"resourceType\":\"Patient\",\"id\":\"broken\",\"name\":[".getBytes(StandardCharsets.UTF_8));
    builder.seeFile("Patient-ok.json", "{\"id\":\"ok\",\"resourceType\":\"Patient\"}".getBytes(StandardCharsets.UTF_8));

    final var files = JsonParser.parseObject(builder.build()).getJsonArray("files");
    assertEquals(1, files.size());
    assertEquals("{\"filename\":\"Patient-ok.json\",\"resourceType\":\"Patient\",\"id\":\"ok\"}", JsonParser.compose((JsonObject) files.get(0), false));
  }
}