package org.hl7.fhir.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Parameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidationEngineExpansionParametersTest {

  static final String JSON_CONTENT = "{\"resourceType\":\"Parameters\",\"parameter\":[{\"name\":\"displayLanguage\",\"valueCode\":\"en-US\"}]}";

  static final String XML_CONTENT = "<Parameters xmlns=\"http://hl7.org/fhir\"><parameter><name value=\"displayLanguage\"/><valueCode value=\"en-US\"/></parameter></Parameters>";

  static Stream<Arguments> parseableContent() {
    return Stream.of(
      Arguments.of("json content, json fileType", JSON_CONTENT, "json"),
      Arguments.of("json content, no fileType", JSON_CONTENT, null),
      Arguments.of("json content, unrecognized fileType", JSON_CONTENT, "not-a-format"),
      Arguments.of("xml content, xml fileType", XML_CONTENT, "xml"),
      Arguments.of("xml content, no fileType", XML_CONTENT, null),
      Arguments.of("xml content, unrecognized fileType", XML_CONTENT, "not-a-format")
    );
  }

  @DisplayName("Expansion parameters are parsed from in-memory content")
  @ParameterizedTest(name = "{0}")
  @MethodSource("parseableContent")
  void parsesContent(String description, String content, String fileType) {
    Parameters parameters = ValidationEngine.parseExpansionParameters(bytes(content), "exp-params", fileType);

    assertEquals(1, parameters.getParameter().size());
    assertEquals("en-US", parameters.getParameterValue("displayLanguage").primitiveValue());
  }

  @DisplayName("Unparseable content reports both the xml and the json failure")
  @Test
  void unparseableContentReportsBothFormats() {
    FHIRException e = assertThrows(FHIRException.class,
      () -> ValidationEngine.parseExpansionParameters(bytes("not a resource"), "exp-params", null));

    assertTrue(e.getMessage().contains("exp-params"), e.getMessage());
    assertTrue(e.getMessage().contains("xml"), e.getMessage());
    assertTrue(e.getMessage().contains("json"), e.getMessage());
  }

  @DisplayName("When the fileType names a format, only that format is reported as failing (xml)")
  @Test
  void declaredFormatIsTheOnlyOneTriedXml() {
    FHIRException e = assertThrows(FHIRException.class,
      () -> ValidationEngine.parseExpansionParameters(bytes(JSON_CONTENT), "exp-params.xml", "xml"));

    assertTrue(e.getMessage().contains("exp-params.xml"), e.getMessage());
    assertTrue(e.getMessage().contains("as xml"), e.getMessage());
  }

  @DisplayName("When the fileType names a format, only that format is reported as failing (json)")
  @Test
  void declaredFormatIsTheOnlyOneTriedJson() {
    FHIRException e = assertThrows(FHIRException.class,
      () -> ValidationEngine.parseExpansionParameters(bytes(XML_CONTENT), "exp-params.json", "json"));

    assertTrue(e.getMessage().contains("exp-params.json"), e.getMessage());
    assertTrue(e.getMessage().contains("as json"), e.getMessage());
  }

  @DisplayName("A file on the local filesystem is read and handed to the content based overload")
  @Test
  void readsFileFromDisk(@TempDir Path tempDir) throws IOException {
    Path file = tempDir.resolve("exp-params.json");
    Files.write(file, bytes(JSON_CONTENT));

    ValidationEngine engine = mock(ValidationEngine.class);
    doCallRealMethod().when(engine).loadExpansionParameters(anyString());

    engine.loadExpansionParameters(file.toString());

    verify(engine).loadExpansionParameters(eq(bytes(JSON_CONTENT)), eq(file.toString()), isNull());
  }

  @DisplayName("An unreadable file reports the path that could not be read")
  @Test
  void unreadableFileReportsPath(@TempDir Path tempDir) {
    String missing = tempDir.resolve("does-not-exist.json").toString();

    ValidationEngine engine = mock(ValidationEngine.class);
    doCallRealMethod().when(engine).loadExpansionParameters(anyString());

    FHIRException e = assertThrows(FHIRException.class, () -> engine.loadExpansionParameters(missing));

    assertTrue(e.getMessage().contains(missing), e.getMessage());
  }

  private static byte[] bytes(String content) {
    return content.getBytes(StandardCharsets.UTF_8);
  }
}
