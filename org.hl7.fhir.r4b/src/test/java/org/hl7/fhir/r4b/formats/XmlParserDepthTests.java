package org.hl7.fhir.r4b.formats;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class XmlParserDepthTests {

  private static final String FHIR_NS = "xmlns=\"http://hl7.org/fhir\"";

  private static String nestedExtensions(int depth) {
    StringBuilder b = new StringBuilder("<Patient " + FHIR_NS + ">");
    b.append("<extension url=\"http://example.org/u\">".repeat(Math.max(0, depth)));
    b.append("<valueBoolean value=\"true\"/>");
    b.append("</extension>".repeat(Math.max(0, depth)));
    b.append("</Patient>");
    return b.toString();
  }

  private static String nestedParts(int depth) {
    StringBuilder b = new StringBuilder("<Parameters " + FHIR_NS + "><parameter><name value=\"p\"/>");
    b.append("<part><name value=\"p\"/>".repeat(Math.max(0, depth)));
    b.append("</part>".repeat(Math.max(0, depth)));
    b.append("</parameter></Parameters>");
    return b.toString();
  }

  private static String nestedResources(int depth) {
    StringBuilder b = new StringBuilder("<Parameters " + FHIR_NS + ">");
    b.append("<parameter><name value=\"p\"/><resource><Parameters>".repeat(Math.max(0, depth)));
    b.append("</Parameters></resource></parameter>".repeat(Math.max(0, depth)));
    b.append("</Parameters>");
    return b.toString();
  }

  private static Object parse(String xml) throws IOException, FHIRFormatError {
    return new XmlParser().parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
  }

  // Extension.extension may nest without limit in valid FHIR. The generated parser recurses once
  // per level (parseExtension -> parseExtensionContent -> parseDataTypeContent ->
  // parseElementContent -> parseExtension), so deep nesting must fail with a FHIRFormatError
  // rather than a StackOverflowError.
  @ParameterizedTest
  @ValueSource(ints = {600, 5000, 50000})
  void testDeeplyNestedExtensionsFailCleanly(int depth) {
    Assertions.assertThrowsExactly(FHIRFormatError.class, () -> parse(nestedExtensions(depth)));
  }

  // Same gap through a BackboneElement (Parameters.parameter.part), so the limit is not
  // extension-specific.
  @Test
  void testDeeplyNestedPartsFailCleanly() {
    Assertions.assertThrowsExactly(FHIRFormatError.class, () -> parse(nestedParts(50000)));
  }

  // Same gap through contained resources (Parameters.parameter.resource -> parseResourceContained).
  @Test
  void testDeeplyNestedResourcesFailCleanly() {
    Assertions.assertThrowsExactly(FHIRFormatError.class, () -> parse(nestedResources(50000)));
  }

  // Nesting comfortably below the limit must still parse, guarding against the cap being too tight.
  @Test
  void testModeratelyNestedExtensionsStillParse() throws IOException, FHIRFormatError {
    Patient p = (Patient) parse(nestedExtensions(100));
    Assertions.assertEquals(1, p.getExtension().size());
  }
}
