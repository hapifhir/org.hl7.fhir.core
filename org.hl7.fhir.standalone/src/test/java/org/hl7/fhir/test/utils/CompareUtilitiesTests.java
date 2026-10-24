package org.hl7.fhir.test.utils;

import org.apache.commons.io.IOUtils;

import org.hl7.fhir.services.testing.CompareUtilities;
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

    final String actualOutput = new CompareUtilities().checkXMLIsSame(expectedFileName, expectedXMLStream, actualXMLStream);

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

   final String actualOutput = new CompareUtilities().checkJsonSrcIsSame(expectedFileName, getResourceAsString(expectedJSONPath), getResourceAsString(actualJSONPath), false);
   if (expectedOutputFileName == null) {
     assertNull(actualOutput);
   } else {
     final String expectedOutputPath = ROOT_JSON_TEST_PATH.resolve(expectedOutputFileName).toString();
     String expectedOutput = normalizeNewlines(getResourceAsString(expectedOutputPath));
     assertEquals(expectedOutput, normalizeNewlines(actualOutput));
   }
 }

 private static Stream<Arguments> getCollectAllParams() {
   return Stream.of(
     // every property difference in an object is reported, not just the first
     Arguments.of("""
         {"a": "x", "b": 1, "c": true}
         """, """
         {"a": "y", "b": 2, "c": true}
         """, 0, """
         string property values differ at .a
         Expected:"x" for t
         Actual  :"y"
         number property values differ at .b
         Expected:"1" for t
         Actual  :"2"
         """),
     Arguments.of("""
         {"a": "x", "b": 1}
         """, """
         {"a": "x", "z": 1}
         """, 0, """
         properties differ at : unexpected property z
         properties differ at : missing property b
         """),
     // an array stops at its first failing item - every difference inside that item is reported,
     // the items after it are not - but the array's container carries on
     Arguments.of("""
         {
           "p": [
             {"n": "a", "v": 1},
             {"n": "b", "v": 2, "w": 3},
             {"n": "c", "v": 9}
           ],
           "after": "x"
         }
         """, """
         {
           "p": [
             {"n": "a", "v": 1},
             {"n": "b", "v": 5, "w": 4},
             {"n": "c", "v": 8}
           ],
           "after": "y"
         }
         """, 0, """
         number property values differ at .p[1].v
         Expected:"2" for t
         Actual  :"5"
         number property values differ at .p[1].w
         Expected:"3" for t
         Actual  :"4"
         string property values differ at .after
         Expected:"x" for t
         Actual  :"y"
         """),
     Arguments.of("""
         {"p": [1, 2], "q": "x"}
         """, """
         {"p": [1], "q": "y"}
         """, 0, """
         array item count differs at .p
         Expected:"2" for t
         Actual  :"1"
         string property values differ at .q
         Expected:"x" for t
         Actual  :"y"
         """),
     // a type mismatch stops that node, not the comparison
     Arguments.of("""
         {"a": {"b": 1}, "c": 2}
         """, """
         {"a": [1], "c": 3}
         """, 0, """
         properties differ at .a
         Expected:"org.hl7.fhir.utilities.json.model.JsonObject" for t
         Actual  :"org.hl7.fhir.utilities.json.model.JsonArray"
         number property values differ at .c
         Expected:"2" for t
         Actual  :"3"
         """),
     // probing an optional item is not a difference
     Arguments.of("""
         {
           "p": [
             {"$optional$": true, "n": "o"},
             {"n": "a"}
           ],
           "q": 1
         }
         """, """
         {"p": [{"n": "a"}], "q": 1}
         """, 0, null),
     Arguments.of("""
         {"a": [{"b": "$string$"}]}
         """, """
         {"a": [{"b": "q"}]}
         """, 0, null),
     // the cap
     Arguments.of("""
         {"a": 1, "b": 1, "c": 1}
         """, """
         {"a": 2, "b": 2, "c": 2}
         """, 2, """
         number property values differ at .a
         Expected:"1" for t
         Actual  :"2"
         number property values differ at .b
         Expected:"1" for t
         Actual  :"2"
         (stopped after 2 differences)
         """)
   );
 }

 @ParameterizedTest
 @MethodSource("getCollectAllParams")
 void testCompareJSONCollectAll(String expected, String actual, int max, String expectedOutput) throws IOException {
   CompareUtilities cu = new CompareUtilities().setCollectAll(true);
   if (max > 0) {
     cu.setMaxErrors(max);
   }
   // the expected outputs are text blocks, which end with a newline
   if (expectedOutput != null) {
     expectedOutput = expectedOutput.stripTrailing();
   }
   String output = cu.checkJsonSrcIsSame("t", expected, actual, false);
   if (expectedOutput == null) {
     assertNull(output);
   } else {
     assertEquals(expectedOutput, normalizeNewlines(output));
   }
   // with collect-all off, the result is exactly the first of those differences, as before
   String first = new CompareUtilities().checkJsonSrcIsSame("t", expected, actual, false);
   if (expectedOutput == null) {
     assertNull(first);
   } else {
     assertEquals(true, expectedOutput.startsWith(normalizeNewlines(first)));
   }
 }
}
