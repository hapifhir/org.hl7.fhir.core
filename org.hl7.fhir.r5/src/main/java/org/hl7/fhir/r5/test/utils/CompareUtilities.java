package org.hl7.fhir.r5.test.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.CSFile;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonPrimitive;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.utilities.xml.XMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import org.hl7.fhir.utilities.tests.BaseTestingUtilities;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompareUtilities extends BaseTestingUtilities {

  private static final boolean SHOW_DIFF = false;
  private JsonObject externals;

  public String createNotEqualMessage(String id, final String message, final String expected, final String actual) {
    return new StringBuilder()
        .append(message).append('\n')
        .append("Expected:").append(presentExpected(expected)).append(" for "+id).append('\n')
        .append("Actual  :").append("\""+actual+"\"").toString();
  }

  private String presentExpected(String expected) {
    if (expected == null) {
      return "null";
    } else if (expected.startsWith("$") && expected.endsWith("$")) {
      if (expected.startsWith("$choice:")) {
        return "Contains one of "+readChoices(expected.substring(8, expected.length()-1)).toString();
      } else if (expected.startsWith("$fragments:")) {
        List<String> fragments = readChoices(expected.substring(11, expected.length()-1));
        return "Contains all of "+fragments.toString();
      } else if (expected.startsWith("$external:")) {
        String[] cmd = expected.substring(1, expected.length() - 1).split(":");
        if (externals != null) {
          String s = externals.asString(cmd[1]);
          return "\""+s+"\" (Ext)";
        } else {
          List<String> fragments = readChoices(cmd[2]);
          return "Contains all of "+fragments.toString()+" (because no external string provided for "+cmd[1]+")";
        }
      } else {
        switch (expected) {
        case "$$" : return "$$";
        case "$instant$": return "\"An Instant\"";
        case "$uuid$": return "\"A Uuid\"";
        case "$id$": return "\"An Id\"";
        default: return "Unhandled template: "+expected;
        }
      }
    } else {
      return "\""+expected+"\"";
    }
  }

  public static String checkXMLIsSame(String id, InputStream expected, InputStream actual) throws Exception {
    CompareUtilities self = new CompareUtilities();
    String result = self.compareXml(id, expected, actual);
    return result;
  }

  public static String checkXMLIsSame(String id, String expected, String actual) throws Exception {
    CompareUtilities self = new CompareUtilities();
    String result = self.compareXml(id, expected, actual);
    if (result != null && SHOW_DIFF) {
      String diff = getDiffTool();
      if (diff != null && ManagedFileAccess.file(diff).exists() || Utilities.isToken(diff)) {
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

  private String compareXml(String id, InputStream expected, InputStream actual) throws Exception {
    return compareElements(id, "", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private String compareXml(String id, String expected, String actual) throws Exception {
    return compareElements(id, "", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private String compareElements(String id, String path, Element expectedElement, Element actualElement) {
    if (!namespacesMatch(expectedElement.getNamespaceURI(), actualElement.getNamespaceURI()))
      return createNotEqualMessage(id, "Namespaces differ at " + path, expectedElement.getNamespaceURI(), actualElement.getNamespaceURI());
    if (!expectedElement.getLocalName().equals(actualElement.getLocalName()))
      return createNotEqualMessage(id, "Names differ at " + path ,  expectedElement.getLocalName(), actualElement.getLocalName());
    path = path + "/" + expectedElement.getLocalName();
    String s = compareAttributes(id, path, expectedElement.getAttributes(), actualElement.getAttributes());
    if (!Utilities.noString(s))
      return s;
    s = compareAttributes(id, path, expectedElement.getAttributes(), actualElement.getAttributes());
    if (!Utilities.noString(s))
      return s;

    Node expectedChild = expectedElement.getFirstChild();
    Node actualChild = actualElement.getFirstChild();
    expectedChild = skipBlankText(expectedChild);
    actualChild = skipBlankText(actualChild);
    while (expectedChild != null && actualChild != null) {
      if (expectedChild.getNodeType() != actualChild.getNodeType())
        return createNotEqualMessage(id, "node type mismatch in children of " + path, Short.toString(expectedElement.getNodeType()), Short.toString(actualElement.getNodeType()));
      if (expectedChild.getNodeType() == Node.TEXT_NODE) {
        if (!normalise(expectedChild.getTextContent()).equals(normalise(actualChild.getTextContent())))
          return createNotEqualMessage(id, "Text differs at " + path, normalise(expectedChild.getTextContent()).toString(), normalise(actualChild.getTextContent()).toString());
      } else if (expectedChild.getNodeType() == Node.ELEMENT_NODE) {
        s = compareElements(id, path, (Element) expectedChild, (Element) actualChild);
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

  private boolean namespacesMatch(String ns1, String ns2) {
    return ns1 == null ? ns2 == null : ns1.equals(ns2);
  }

  private String normalise(String text) {
    String result = text.trim().replace('\r', ' ').replace('\n', ' ').replace('\t', ' ');
    while (result.contains("  "))
      result = result.replace("  ", " ");
    return result;
  }

  private String compareAttributes(String id, String path, NamedNodeMap expected, NamedNodeMap actual) {
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
            return createNotEqualMessage(id, "Attributes differ at " + path, normalise(expectedNode.getTextContent()).toString(), normalise(actualNode.getTextContent()).toString()) ;
        }
      }
    }
    return null;
  }

  private boolean sameBytes(byte[] b1, byte[] b2) {
    if (b1.length == 0 || b2.length == 0)
      return false;
    if (b1.length != b2.length)
      return false;
    for (int i = 0; i < b1.length; i++)
      if (b1[i] != b2[i])
        return false;
    return true;
  }

  private byte[] unBase64(String text) {
    return Base64.decodeBase64(text);
  }

  private Node skipBlankText(Node node) {
    while (node != null && (((node.getNodeType() == Node.TEXT_NODE) && StringUtils.isWhitespace(node.getTextContent())) || (node.getNodeType() == Node.COMMENT_NODE)))
      node = node.getNextSibling();
    return node;
  }

  private Document loadXml(String fn) throws Exception {
    return loadXml(ManagedFileAccess.inStream(fn));
  }

  private Document loadXml(InputStream fn) throws Exception {
    DocumentBuilderFactory factory = XMLUtil.newXXEProtectedDocumentBuilderFactory();
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

  public static String checkJsonSrcIsSame(String id, String expected, String actual, JsonObject externals) throws FileNotFoundException, IOException {
    return checkJsonSrcIsSame(id, expected, actual, true, externals);
  }

  public static String checkJsonSrcIsSame(String id, String expectedString, String actualString, boolean showDiff, JsonObject externals) throws FileNotFoundException, IOException {
    CompareUtilities self = new CompareUtilities();
    self.externals = externals;
    String result = self.compareJsonSrc(id, expectedString, actualString);
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
      builder.directory(ManagedFileAccess.csfile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }

  public static String checkJsonIsSame(String id, String expected, String actual) throws FileNotFoundException, IOException {
    CompareUtilities self = new CompareUtilities();
    String result = self.compareJson(id, expected, actual);
    if (result != null && SHOW_DIFF) {
      String diff = Utilities.path(System.getenv("ProgramFiles(X86)"), "WinMerge", "WinMergeU.exe");
      List<String> command = new ArrayList<String>();
      command.add("\"" + diff + "\" \"" + expected +  "\" \"" + actual + "\"");

      ProcessBuilder builder = new ProcessBuilder(command);
      builder.directory(ManagedFileAccess.csfile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }

  private String compareJsonSrc(String id, String expected, String actual) throws FileNotFoundException, IOException {
    JsonObject actualJsonObject = JsonParser.parseObject(actual);
    JsonObject expectedJsonObject = JsonParser.parseObject(expected);
    return compareObjects(id, "", expectedJsonObject, actualJsonObject);
  }

  private String compareJson(String id, String expected, String actual) throws FileNotFoundException, IOException {
    JsonObject actualJsonObject = JsonParser.parseObject(TextFile.fileToString(actual));
    JsonObject expectedJsonObject = JsonParser.parseObject(TextFile.fileToString(expected));
    return compareObjects(id, "", expectedJsonObject, actualJsonObject);
  }

  private String compareObjects(String id, String path, JsonObject expectedJsonObject, JsonObject actualJsonObject) {
    List<String> optionals = listOptionals(expectedJsonObject);
    List<String> countOnlys = listCountOnlys(expectedJsonObject);
    for (JsonProperty en : actualJsonObject.getProperties()) {
      String n = en.getName();
      if (!n.equals("fhir_comments")) {
        if (expectedJsonObject.has(n)) {
          String s = compareNodes(id, path + '.' + n, expectedJsonObject.get(n), en.getValue(), countOnlys.contains(n));
          if (!Utilities.noString(s))
            return s;
        } else
          return "properties differ at " + path + ": missing property " + n;
      }
    }
    for (JsonProperty en : expectedJsonObject.getProperties()) {
      String n = en.getName();
      if (!n.equals("fhir_comments") && !n.equals("$optional$") && !optionals.contains(n)) {
        if (!actualJsonObject.has(n))
          return "properties differ at " + path + ": missing property " + n;
      }
    }
    return null;
  }

  private List<String> listOptionals(JsonObject expectedJsonObject) {
    List<String> res = new ArrayList<>();
    if (expectedJsonObject.has("$optional-properties$")) {
      res.add("$optional-properties$");
      res.add("$count-arrays$");
      for (String s : expectedJsonObject.getStrings("$optional-properties$")) {
        res.add(s);
      }
    }
    return res;
  }

  private List<String> listCountOnlys(JsonObject expectedJsonObject) {
    List<String> res = new ArrayList<>();
    if (expectedJsonObject.has("$count-arrays$")) {
      for (String s : expectedJsonObject.getStrings("$count-arrays$")) {
        res.add(s);
      }
    }
    return res;
  }

  private String compareNodes(String id, String path, JsonElement expectedJsonElement, JsonElement actualJsonElement, boolean countOnly) {
    if (!(expectedJsonElement instanceof JsonPrimitive && actualJsonElement instanceof JsonPrimitive)) {
      if (actualJsonElement.getClass() != expectedJsonElement.getClass()) {
        return createNotEqualMessage(id, "properties differ at " + path, expectedJsonElement.getClass().getName(), actualJsonElement.getClass().getName());
      }
    }
    if (actualJsonElement instanceof JsonPrimitive) {
      JsonPrimitive actualJsonPrimitive = (JsonPrimitive) actualJsonElement;
      JsonPrimitive expectedJsonPrimitive = (JsonPrimitive) expectedJsonElement;
      if (actualJsonPrimitive.isJsonBoolean() && expectedJsonPrimitive.isJsonBoolean()) {
        if (actualJsonPrimitive.asBoolean() != expectedJsonPrimitive.asBoolean())
          return createNotEqualMessage(id, "boolean property values differ at " + path , expectedJsonPrimitive.asString(), actualJsonPrimitive.asString());
      } else if (actualJsonPrimitive.isJsonString() && expectedJsonPrimitive.isJsonString()) {
        String actualJsonString = actualJsonPrimitive.asString();
        String expectedJsonString = expectedJsonPrimitive.asString();
        if (!(actualJsonString.contains("<div") && expectedJsonString.contains("<div")))
          if (!matches(actualJsonString, expectedJsonString))
            if (!sameBytes(unBase64(actualJsonString), unBase64(expectedJsonString)))
              return createNotEqualMessage(id, "string property values differ at " + path, expectedJsonString, actualJsonString);
      } else if (actualJsonPrimitive.isJsonNumber() && expectedJsonPrimitive.isJsonNumber()) {
        if (!actualJsonPrimitive.asString().equals(expectedJsonPrimitive.asString()))
          return createNotEqualMessage(id, "number property values differ at " + path, expectedJsonPrimitive.asString(), actualJsonPrimitive.asString());
      } else if (expectedJsonElement instanceof JsonNull) {
        return actualJsonPrimitive instanceof JsonNull ? null : createNotEqualMessage(id, "null Properties differ at " + path, "null", actualJsonPrimitive.asString());
      } else {
        return createNotEqualMessage(id, "property types differ at " + path, expectedJsonPrimitive.asString(), actualJsonPrimitive.asString());
      }
    } else if (actualJsonElement instanceof JsonObject) {
      String s = compareObjects(id, path, (JsonObject) expectedJsonElement, (JsonObject) actualJsonElement);
      if (!Utilities.noString(s))
        return s;
    } else if (actualJsonElement instanceof JsonArray) {
      JsonArray actualArray = (JsonArray) actualJsonElement;
      JsonArray expectedArray = (JsonArray) expectedJsonElement;

      int as = actualArray.size();
      int es = expectedArray.size();
      if (countOnly) {
        if (as != es) {
          return createNotEqualMessage(id, "array item count differs at " + path, Integer.toString(es), Integer.toString(as));
        }
      } else {
        int expectedMin = countExpectedMin(expectedArray);
        int oc = optionalCount(expectedArray);

        if (as > es || as < expectedMin)
          return createNotEqualMessage(id, "array item count differs at " + path, Integer.toString(es), Integer.toString(as));
        int c = 0;
        for (int i = 0; i < es; i++) {
          if (c >= as) {
            if (i >= es - oc && isOptional(expectedArray.get(i))) {
              return null; // this is OK 
            } else {
              return "One or more array items did not match at "+path+" starting at index "+i;
            }
          }
          String s = compareNodes(id, path + "[" + Integer.toString(i) + "]", expectedArray.get(i), actualArray.get(c), false);
          if (!Utilities.noString(s) && !isOptional(expectedArray.get(i))) {
            return s;
          }
          if (Utilities.noString(s)) {
            c++;
          }
        }
        if (c < as) {
          return "Unexpected Node found in array at '"+path+"' at index "+c;
        }
      }
    } else
      return "unhandled property " + actualJsonElement.getClass().getName();
    return null;
  }

  private int optionalCount(JsonArray arr) {
    int c = 0;
    for (JsonElement e : arr) {
      if (e.isJsonObject()) {
        JsonObject j = e.asJsonObject();
        if (j.has("$optional$") && j.asBoolean("$optional$")) {
          c++;
        }
      }
    }
    return c;
  }

  private boolean isOptional(JsonElement e) {
    return e.isJsonObject() && e.asJsonObject().has("$optional$");
  }

  private int countExpectedMin(JsonArray array) {
    int count = array.size();
    for (JsonElement e : array) {
      if (isOptional(e)) {
        count--;
      }
    }
    return count;
  }

  private boolean matches(String actualJsonString, String expectedJsonString) {
    if (expectedJsonString.startsWith("$") && expectedJsonString.endsWith("$")) {
      if (expectedJsonString.startsWith("$choice:")) {
        return Utilities.existsInList(actualJsonString, readChoices(expectedJsonString.substring(8, expectedJsonString.length()-1)));

      } else if (expectedJsonString.startsWith("$fragments:")) {
        List<String> fragments = readChoices(expectedJsonString.substring(11, expectedJsonString.length()-1));
        for (String f : fragments) {
          if (!actualJsonString.toLowerCase().contains(f.toLowerCase())) {
            return false;
          }
        }
        return true;
      } else if (expectedJsonString.startsWith("$external:")) {
        String[] cmd = expectedJsonString.substring(1, expectedJsonString.length() - 1).split("\\:");
        if (externals != null) {
          String s = externals.asString(cmd[1]);
          return actualJsonString.equals(s);
        } else if (cmd.length <= 2) {
          return true;
        } else {
          List<String> fragments = readChoices(cmd[2]);
          for (String f : fragments) {
            if (!actualJsonString.toLowerCase().contains(f.toLowerCase())) {
              return false;
            }
          }
          return true;
        }
      } else {
        switch (expectedJsonString) {
        case "$$" : return true;
        case "$instant$": return actualJsonString.matches("([0-9]([0-9]([0-9][1-9]|[1-9]0)|[1-9]00)|[1-9]000)-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])T([01][0-9]|2[0-3]):[0-5][0-9]:([0-5][0-9]|60)(\\.[0-9]{1,9})?(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))");
        case "$uuid$": return actualJsonString.matches("urn:uuid:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");
        case "$id$": return actualJsonString.matches("[A-Za-z0-9\\-\\.]{1,64}");
        default: 
          throw new Error("Unhandled template: "+expectedJsonString);
        }
      }
    } else {
      return actualJsonString.equals(expectedJsonString);
    }
  }

  private List<String> readChoices(String s) {
    List<String> list = new ArrayList<>();
    for (String p : s.split("\\|")) {
      list.add(p);
    }
    return list;
  }

  public static String checkTextIsSame(String id, String expected, String actual) throws FileNotFoundException, IOException {
    return checkTextIsSame(id, expected, actual, true);
  }

  public static String checkTextIsSame(String id, String expectedString, String actualString, boolean showDiff) throws FileNotFoundException, IOException {
    CompareUtilities self = new CompareUtilities();
    String result = self.compareText(id, expectedString, actualString);
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
      builder.directory(ManagedFileAccess.csfile(Utilities.path("[tmp]")));
      builder.start();

    }
    return result;
  }


  private String compareText(String id, String expectedString, String actualString) {
    for (int i = 0; i < Integer.min(expectedString.length(), actualString.length()); i++) {
      if (expectedString.charAt(i) != actualString.charAt(i))
        return createNotEqualMessage(id, "Strings differ at character " + Integer.toString(i), charWithContext(expectedString, i), charWithContext(actualString, i));
    }
    if (expectedString.length() != actualString.length())
      return createNotEqualMessage(id, "Strings differ in length but match to the end of the shortest.", Integer.toString(expectedString.length()), Integer.toString(actualString.length()));
    return null;
  }

  private String charWithContext(String s, int i) {
    String result = s.substring(i, i+1);
    if (i > 7) {
      i = i - 7;
    }
    int e = i + 20;
    if (e > s.length()) {
      e = s.length();
    }
    if (e > i+1) {
      result = result + " with context '"+s.substring(i, e)+"'";
    }
    return result;
  }

}
