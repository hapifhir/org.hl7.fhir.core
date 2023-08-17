package org.hl7.fhir.r5.test.utils;

import org.apache.commons.io.IOUtils;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CompareUtilitiesTests implements ResourceLoaderTests {

  public static final Path ROOT_TEST_PATH = Paths.get("testUtilities");
  public static final Path ROOT_XML_TEST_PATH = ROOT_TEST_PATH.resolve("xml");
  public static final Path ROOT_JSON_TEST_PATH = ROOT_TEST_PATH.resolve("json");


  public String getResourceAsString(String path) throws IOException {
    InputStream inputStream = getResourceAsInputStream(path);
    String contents = IOUtils.toString(inputStream, java.nio.charset.StandardCharsets.UTF_8);
    return contents.trim();
  }

  private static Stream<Arguments> getCompareXMLParams() {
      return Stream.of(
        Arguments.of("expected.xml", "expected.xml", null),
        Arguments.of("expected.xml", "actualDiffText.xml", "actualDiffText.xml.error"),
        Arguments.of("expected.xml", "actualMissingAttribute.xml", "actualMissingAttribute.xml.error"),
        Arguments.of("expected.xml", "actualDiffAttribute.xml", "actualDiffAttribute.xml.error"),
        Arguments.of("expected.xml", "actualDiffNodeType.xml", "actualDiffNodeType.xml.error"),
        Arguments.of("expected.xml", "actualDiffTextEmpty.xml", "actualDiffTextEmpty.xml.error"),
        Arguments.of("expected.xml", "actualExtraNode.xml", "actualExtraNode.xml.error"),
        Arguments.of("expected.xml", "actualMissingNode.xml", "actualMissingNode.xml.error"),
        Arguments.of("expected.xml", "actualDiffNamespace.xml", "actualDiffNamespace.xml.error"),
        Arguments.of("expected.xml", "actualDiffLocalName.xml", "actualDiffLocalName.xml.error")
        );
  }

  private static String normalizeNewlines(String input) {
    return input.replaceAll("\\r\\n?", "\n");
  }

  @ParameterizedTest
  @MethodSource("getCompareXMLParams")
  public void testCompareXML(String expectedFileName, String actualFileName, String expectedOutputFileName) throws Exception {
    final String expectedXMLPath = ROOT_XML_TEST_PATH.resolve(expectedFileName).toString();
    final String actualXMLPath = ROOT_XML_TEST_PATH.resolve(actualFileName).toString();

    ClassLoader classLoader = CompareUtilitiesTests.class.getClassLoader();

    InputStream expectedXMLStream = classLoader.getResourceAsStream(expectedXMLPath);
    InputStream actualXMLStream = classLoader.getResourceAsStream(actualXMLPath);

    final String actualOutput = CompareUtilities.checkXMLIsSame(expectedXMLStream, actualXMLStream);

    if (expectedOutputFileName == null) {
      assertNull(actualOutput);
    } else {
      final String expectedOutputPath = ROOT_XML_TEST_PATH.resolve(expectedOutputFileName).toString();
      String expectedOutput = normalizeNewlines(getResourceAsString(expectedOutputPath));
      assertEquals(expectedOutput, normalizeNewlines(actualOutput));
    }
  }

 private static Stream<Arguments> getCompareJSONParams() {
     return Stream.of(
       Arguments.of("expected.json", "expected.json", null),
       Arguments.of("expected.json", "actualDiffValue.json", "actualDiffValue.json.error"),
       Arguments.of("expected.json", "actualDiffType.json", "actualDiffType.json.error"),
       Arguments.of("expected.json", "actualDiffArrayContent.json", "actualDiffArrayContent.json.error"),
       Arguments.of("expected.json", "actualDiffBoolean.json", "actualDiffBoolean.json.error"),
       Arguments.of("expected.json", "actualMissingProperty.json", "actualMissingProperty.json.error"),
       Arguments.of("expected.json", "actualDiffArraySize.json", "actualDiffArraySize.json.error"),
       Arguments.of("expected.json", "actualDiffNumber.json", "actualDiffNumber.json.error"),
       Arguments.of("expected.json", "actualMissingSubProperty.json", "actualMissingSubProperty.json.error"),
       Arguments.of("expected.json", "actualExtraProperty.json", "actualExtraProperty.json.error")
       );
 }

 @ParameterizedTest
 @MethodSource("getCompareJSONParams")
 public void testCompareJSON(String expectedFileName, String actualFileName, String expectedOutputFileName) throws IOException {
   final String expectedJSONPath = ROOT_JSON_TEST_PATH.resolve(expectedFileName).toString();
   final String actualJSONPath = ROOT_JSON_TEST_PATH.resolve(actualFileName).toString();

   final String actualOutput = CompareUtilities.checkJsonSrcIsSame(getResourceAsString(expectedJSONPath), getResourceAsString(actualJSONPath), false, null);
   if (expectedOutputFileName == null) {
     assertNull(actualOutput);
   } else {
     final String expectedOutputPath = ROOT_JSON_TEST_PATH.resolve(expectedOutputFileName).toString();
     String expectedOutput = normalizeNewlines(getResourceAsString(expectedOutputPath));
     assertEquals(expectedOutput, normalizeNewlines(actualOutput));
   }
 }
}
