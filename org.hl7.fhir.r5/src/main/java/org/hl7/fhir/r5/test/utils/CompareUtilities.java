package org.hl7.fhir.r5.test.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.utilities.*;

import org.hl7.fhir.utilities.settings.FhirSettings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareUtilities extends BaseTestingUtilities {

  private static final boolean SHOW_DIFF = true;

  public static String createNotEqualMessage(final String message, final String expected, final String actual) {
    return new StringBuilder()
      .append(message).append('\n')
      .append("Expected :").append(expected).append('\n')
      .append("Actual  :").append(actual).toString();
  }

  public static String checkXMLIsSame(InputStream expected, InputStream actual) throws Exception {
    String result = compareXml(expected, actual);
    return result;
  }

  public static String checkXMLIsSame(String expected, String actual) throws Exception {
    String result = compareXml(expected, actual);
    if (result != null && SHOW_DIFF) {
      String diff = getDiffTool();
      if (new File(diff).exists() || Utilities.isToken(diff)) {
        Runtime.getRuntime().exec(new String[]{diff, expected, actual});
      }
    }
    return result;
  }

  private static String getDiffTool() throws IOException {
    if (FhirSettings.hasDiffToolPath()) {
      return FhirSettings.getDiffToolPath();
    } else if (System.getenv("ProgramFiles") != null) { 
      return Utilities.path(System.getenv("ProgramFiles"), "WinMerge", "WinMergeU.exe");
    } else {
      return null;
    }
  }

  private static String compareXml(InputStream expected, InputStream actual) throws Exception {
    return compareElements("", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private static String compareXml(String expected, String actual) throws Exception {
    return compareElements("", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private static String compareElements(String path, Element expectedElement, Element actualElement) {
    if (!namespacesMatch(expectedElement.getNamespaceURI(), actualElement.getNamespaceURI()))
      return createNotEqualMessage("Namespaces differ at " + path, expectedElement.getNamespaceURI(), actualElement.getNamespaceURI());
    if (!expectedElement.getLocalName().equals(actualElement.getLocalName()))
      return createNotEqualMessage("Names differ at " + path ,  expectedElement.getLocalName(), actualElement.getLocalName());
    path = path + "/" + expectedElement.getLocalName();
    String s = compareAttributes(path, expectedElement.getAttributes(), actualElement.getAttributes());
    if (!Utilities.noString(s))
      return s;
    s = compareAttributes(path, expectedElement.getAttributes(), actualElement.getAttributes());
    if (!Utilities.noString(s))
      return s;

    Node expectedChild = expectedElement.getFirstChild();
    Node actualChild = actualElement.getFirstChild();
    expectedChild = skipBlankText(expectedChild);
    actualChild = skipBlankText(actualChild);
    while (expectedChild != null && actualChild != null) {
      if (expectedChild.getNodeType() != actualChild.getNodeType())
        return createNotEqualMessage("node type mismatch in children of " + path, Short.toString(expectedElement.getNodeType()), Short.toString(actualElement.getNodeType()));
      if (expectedChild.getNodeType() == Node.TEXT_NODE) {
        if (!normalise(expectedChild.getTextContent()).equals(normalise(actualChild.getTextContent())))
          return createNotEqualMessage("Text differs at " + path, normalise(expectedChild.getTextContent()).toString(), normalise(actualChild.getTextContent()).toString());
      } else if (expectedChild.getNodeType() == Node.ELEMENT_NODE) {
        s = compareElements(path, (Element) expectedChild, (Element) actualChild);
        if (!Utilities.noString(s))
          return s;
      }

      expectedChild = skipBlankText(expectedChild.getNextSibling());
      actualChild = skipBlankText(actualChild.getNextSibling());
    }
    if (expectedChild != null)
      return "node mismatch - more nodes in actual in children of " + path;
    if (actualChild != null)
      return "node mismatch - more nodes in expected in children of " + path;
    return null;
  }

  private static boolean namespacesMatch(String ns1, String ns2) {
    return ns1 == null ? ns2 == null : ns1.equals(ns2);
  }

  private static Object normalise(String text) {
    String result = text.trim().replace('\r', ' ').replace('\n', ' ').replace('\t', ' ');
    while (result.contains("  "))
      result = result.replace("  ", " ");
    return result;
  }

  private static String compareAttributes(String path, NamedNodeMap expected, NamedNodeMap actual) {
    for (int i = 0; i < expected.getLength(); i++) {

      Node expectedNode = expected.item(i);
      String expectedNodeName = expectedNode.getNodeName();
      if (!(expectedNodeName.equals("xmlns") || expectedNodeName.startsWith("xmlns:"))) {
        Node actualNode = actual.getNamedItem(expectedNodeName);
        if (actualNode == null)
          return "Attributes differ at " + path + ": missing attribute " + expectedNodeName;
        if (!normalise(expectedNode.getTextContent()).equals(normalise(actualNode.getTextContent()))) {
          byte[] b1 = unBase64(expectedNode.getTextContent());
          byte[] b2 = unBase64(actualNode.getTextContent());
          if (!sameBytes(b1, b2))
            return createNotEqualMessage("Attributes differ at " + path, normalise(expectedNode.getTextContent()).toString(), normalise(actualNode.getTextContent()).toString()) ;
        }
      }
    }
    return null;
  }

  private static boolean sameBytes(byte[] b1, byte[] b2) {
    if (b1.length == 0 || b2.length == 0)
      return false;
    if (b1.length != b2.length)
      return false;
    for (int i = 0; i < b1.length; i++)
      if (b1[i] != b2[i])
        return false;
    return true;
  }

  private static byte[] unBase64(String text) {
    return Base64.decodeBase64(text);
  }

  private static Node skipBlankText(Node node) {
    while (node != null && (((node.getNodeType() == Node.TEXT_NODE) && StringUtils.isWhitespace(node.getTextContent())) || (node.getNodeType() == Node.COMMENT_NODE)))
      node = node.getNextSibling();
    return node;
  }

  private static Document loadXml(String fn) throws Exception {
    return loadXml(new FileInputStream(fn));
  }

  private static Document loadXml(InputStream fn) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
    factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    factory.setXIncludeAware(false);
    factory.setExpandEntityReferences(false);

    factory.setNamespaceAware(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    return builder.parse(fn);
  }

  public static String checkJsonSrcIsSame(String expected, String actual) throws JsonSyntaxException, FileNotFoundException, IOException {
    return checkJsonSrcIsSame(expected, actual, true);
  }

  public static String checkJsonSrcIsSame(String expectedString, String actualString, boolean showDiff) throws JsonSyntaxException, FileNotFoundException, IOException {
    String result = compareJsonSrc(expectedString, actualString);
    if (result != null && SHOW_DIFF && showDiff) {
      String diff = null;
      if (System.getProperty("os.name").contains("Linux"))
        diff = Utilities.path("/", "usr", "bin", "meld");
      else if (System.getenv("ProgramFiles(X86)") != null) {
        if (Utilities.checkFile("WinMerge", Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge"), "\\WinMergeU.exe", null))
          diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge", "WinMergeU.exe");
        else if (Utilities.checkFile("WinMerge", Utilities.path(System.getenv("ProgramFiles(X86)"), "Meld"), "\\Meld.exe", null))
          diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "Meld", "Meld.exe");
      }
      if (diff == null || diff.isEmpty())
        return result;

      List<String> command = new ArrayList<String>();
      String expected = Utilities.path("[tmp]", "expected" + expectedString.hashCode() + ".json");
      String actual = Utilities.path("[tmp]", "actual" + actualString.hashCode() + ".json");
      TextFile.stringToFile(expectedString, expected);
      TextFile.stringToFile(actualString, actual);
      command.add(diff);
      if (diff.toLowerCase().contains("meld"))
        command.add("--newtab");
      command.add(expected);
      command.add(actual);

      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(new CSFile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }

  public static String checkJsonIsSame(String expected, String actual) throws JsonSyntaxException, FileNotFoundException, IOException {
    String result = compareJson(expected, actual);
    if (result != null && SHOW_DIFF) {
      String diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge", "WinMergeU.exe");
      List<String> command = new ArrayList<String>();
      command.add("\"" + diff + "\" \"" + expected +  "\" \"" + actual + "\"");

      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(new CSFile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }

  private static String compareJsonSrc(String expected, String actual) throws JsonSyntaxException, FileNotFoundException, IOException {
    JsonObject actualJsonObject = (JsonObject) new com.google.gson.JsonParser().parse(actual);
    JsonObject expectedJsonObject = (JsonObject) new com.google.gson.JsonParser().parse(expected);
    return compareObjects("", expectedJsonObject, actualJsonObject);
  }

  private static String compareJson(String expected, String actual) throws JsonSyntaxException, FileNotFoundException, IOException {
    JsonObject actualJsonObject = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.fileToString(actual));
    JsonObject expectedJsonObject = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.fileToString(expected));
    return compareObjects("", expectedJsonObject, actualJsonObject);
  }

  private static String compareObjects(String path, JsonObject expectedJsonObject, JsonObject actualJsonObject) {
    for (Map.Entry<String, JsonElement> en : actualJsonObject.entrySet()) {
      String n = en.getKey();
      if (!n.equals("fhir_comments") && !n.equals("$optional$")) {
        if (expectedJsonObject.has(n)) {
          String s = compareNodes(path + '.' + n, expectedJsonObject.get(n), en.getValue());
          if (!Utilities.noString(s))
            return s;
        } else
          return "properties differ at " + path + ": missing property " + n;
      }
    }
    for (Map.Entry<String, JsonElement> en : expectedJsonObject.entrySet()) {
      String n = en.getKey();
      if (!n.equals("fhir_comments") && !n.equals("$optional$")) {
        if (!actualJsonObject.has(n))
          return "properties differ at " + path + ": missing property " + n;
      }
    }
    return null;
  }

  private static String compareNodes(String path, JsonElement expectedJsonElement, JsonElement actualJsonElement) {
    if (actualJsonElement.getClass() != expectedJsonElement.getClass())
      return createNotEqualMessage("properties differ at " + path, expectedJsonElement.getClass().getName(), actualJsonElement.getClass().getName());
    else if (actualJsonElement instanceof JsonPrimitive) {
      JsonPrimitive actualJsonPrimitive = (JsonPrimitive) actualJsonElement;
      JsonPrimitive expectedJsonPrimitive = (JsonPrimitive) expectedJsonElement;
      if (actualJsonPrimitive.isBoolean() && expectedJsonPrimitive.isBoolean()) {
        if (actualJsonPrimitive.getAsBoolean() != expectedJsonPrimitive.getAsBoolean())
          return createNotEqualMessage("boolean property values differ at " + path , expectedJsonPrimitive.getAsString(), actualJsonPrimitive.getAsString());
      } else if (actualJsonPrimitive.isString() && expectedJsonPrimitive.isString()) {
        String actualJsonString = actualJsonPrimitive.getAsString();
        String expectedJsonString = expectedJsonPrimitive.getAsString();
        if (!(actualJsonString.contains("<div") && expectedJsonString.contains("<div")))
          if (!matches(actualJsonString, expectedJsonString))
            if (!sameBytes(unBase64(actualJsonString), unBase64(expectedJsonString)))
              return createNotEqualMessage("string property values differ at " + path, expectedJsonString, actualJsonString);
      } else if (actualJsonPrimitive.isNumber() && expectedJsonPrimitive.isNumber()) {
        if (!actualJsonPrimitive.getAsString().equals(expectedJsonPrimitive.getAsString()))
          return createNotEqualMessage("number property values differ at " + path, expectedJsonPrimitive.getAsString(), actualJsonPrimitive.getAsString());
      } else
        return createNotEqualMessage("property types differ at " + path, expectedJsonPrimitive.getAsString(), actualJsonPrimitive.getAsString());
    } else if (actualJsonElement instanceof JsonObject) {
      String s = compareObjects(path, (JsonObject) expectedJsonElement, (JsonObject) actualJsonElement);
      if (!Utilities.noString(s))
        return s;
    } else if (actualJsonElement instanceof JsonArray) {
      JsonArray actualArray = (JsonArray) actualJsonElement;
      JsonArray expectedArray = (JsonArray) expectedJsonElement;
      int expectedMin = countExpectedMin(expectedArray);

      if (actualArray.size() > expectedArray.size() || actualArray.size() < expectedMin)
        return createNotEqualMessage("array properties count differs at " + path, Integer.toString(expectedArray.size()), Integer.toString(actualArray.size()));
      int c = 0;
      for (int i = 0; i < expectedArray.size(); i++) {
        if (c >= actualArray.size()) {
          if (i == expectedArray.size() - 1 && isOptional(expectedArray.get(i))) {
            return null; // this is OK 
          } else {
            return "One or more array items did not match at "+path;
          }
        }
        String s = compareNodes(path + "[" + Integer.toString(i) + "]", expectedArray.get(i), actualArray.get(c));
        if (!Utilities.noString(s) && !isOptional(expectedArray.get(i))) {
          return s;
        }
        if (Utilities.noString(s)) {
          c++;
        }
      }
    } else if (actualJsonElement instanceof JsonNull) {

    } else
      return "unhandled property " + actualJsonElement.getClass().getName();
    return null;
  }

  private static boolean isOptional(JsonElement e) {
    return e.isJsonObject() && e.getAsJsonObject().has("$optional$");
  }

  private static int countExpectedMin(JsonArray array) {
    int count = array.size();
    for (JsonElement e : array) {
      if (isOptional(e)) {
        count--;
      }
    }
    return count;
  }

  private static boolean matches(String actualJsonString, String expectedJsonString) {
    if (expectedJsonString.startsWith("$") && expectedJsonString.endsWith("$")) {
      if (expectedJsonString.startsWith("$choice:")) {
        return Utilities.existsInList(actualJsonString, readChoices(expectedJsonString));

      } else {
        switch (expectedJsonString) {
        case "$$" : return true;
        case "$instant$": return actualJsonString.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))");
        case "$uuid$": return actualJsonString.matches("urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
        default: 
          throw new Error("Unhandled template: "+expectedJsonString);
        }
      }
    } else {
      return actualJsonString.equals(expectedJsonString);
    }
  }

  private static List<String> readChoices(String s) {
    List<String> list = new ArrayList<>();
    s = s.substring(8, s.length()-1);
    for (String p : s.split("\\|")) {
      list.add(p);
    }
    return list;
  }

  public static String checkTextIsSame(String expected, String actual) throws JsonSyntaxException, FileNotFoundException, IOException {
    return checkTextIsSame(expected, actual, true);
  }

  public static String checkTextIsSame(String expectedString, String actualString, boolean showDiff) throws JsonSyntaxException, FileNotFoundException, IOException {
    String result = compareText(expectedString, actualString);
    if (result != null && SHOW_DIFF && showDiff) {
      String diff = null;
      if (System.getProperty("os.name").contains("Linux"))
        diff = Utilities.path("/", "usr", "bin", "meld");
      else {
        if (Utilities.checkFile("WinMerge", Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge"), "\\WinMergeU.exe", null))
          diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge", "WinMergeU.exe");
        else if (Utilities.checkFile("WinMerge", Utilities.path(System.getenv("ProgramFiles(X86)"), "Meld"), "\\Meld.exe", null))
          diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "Meld", "Meld.exe");
      }
      if (diff == null || diff.isEmpty())
        return result;

      List<String> command = new ArrayList<String>();
      String actual = Utilities.path("[tmp]", "actual" + actualString.hashCode() + ".json");
      String expected = Utilities.path("[tmp]", "expected" + expectedString.hashCode() + ".json");
      TextFile.stringToFile(expectedString, expected);
      TextFile.stringToFile(actualString, actual);
      command.add(diff);
      if (diff.toLowerCase().contains("meld"))
        command.add("--newtab");
      command.add(expected);
      command.add(actual);

      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(new CSFile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }


  private static String compareText(String expectedString, String actualString) {
    for (int i = 0; i < Integer.min(expectedString.length(), actualString.length()); i++) {
      if (expectedString.charAt(i) != actualString.charAt(i))
        return createNotEqualMessage("Strings differ at character " + Integer.toString(i), String.valueOf(expectedString.charAt(i)), String.valueOf(actualString.charAt(i)));
    }
    if (expectedString.length() != actualString.length())
      return createNotEqualMessage("Strings differ in length but match to the end of the shortest.", Integer.toString(expectedString.length()), Integer.toString(actualString.length()));
    return null;
  }

}
