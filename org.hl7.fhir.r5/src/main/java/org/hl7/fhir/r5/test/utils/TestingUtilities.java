package org.hl7.fhir.r5.test.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.TerminologyCache;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.ToolGlobalSettings;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class TestingUtilities extends BaseTestingUtilities {
  private static final boolean SHOW_DIFF = true;

  static public Map<String, IWorkerContext> fcontexts;

  final static public String DEFAULT_CONTEXT_VERSION = "4.0.1";

  /** Get an existing instantiation of a WorkerContext if available
   *
   * This uses the DEFAULT_CONTEXT_VERSION
   * */
  public static IWorkerContext getSharedWorkerContext() {
    return getSharedWorkerContext(DEFAULT_CONTEXT_VERSION);
  }

  /**
   * Get an existing instantiation of a WorkerContext if available
   *
   * @param version FHIR Version to get context for
   * @return
   */
  public static IWorkerContext getSharedWorkerContext(String version) {
    if ("4.5.0".equals(version)) {
      version = "4.4.0"; // temporary work around
    }
    
    String v = VersionUtilities.getMajMin(version);
    if (fcontexts == null) {
      fcontexts = new HashMap<>();
    }
    if (!fcontexts.containsKey(v)) {
        IWorkerContext fcontext = getWorkerContext(version);
        fcontexts.put(v, fcontext);
    }
    return fcontexts.get(v);
  }

  public static IWorkerContext getWorkerContext(String version) {
    FilesystemPackageCacheManager pcm;
    try {
      pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      IWorkerContext fcontext = getWorkerContext(pcm.loadPackage(VersionUtilities.packageForVersion(version), version));
      fcontext.setUcumService(new UcumEssenceService(TestingUtilities.loadTestResourceStream("ucum", "ucum-essence.xml")));
      fcontext.setExpansionProfile(new Parameters());
      if (!fcontext.hasPackage("hl7.terminology", null)) {
        NpmPackage utg = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION).loadPackage("hl7.terminology");
        System.out.println("Loading THO: "+utg.name()+"#"+utg.version());
        fcontext.loadFromPackage(utg, new TestPackageLoader(new String[]{"CodeSystem", "ValueSet"}));
      }
      return fcontext;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Error(e);
    }
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT).withTerminologyCachePath(TestConstants.TX_CACHE).fromPackage(npmPackage);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage, IWorkerContext.IContextResourceLoader loader) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT).withTerminologyCachePath(TestConstants.TX_CACHE).fromPackage(npmPackage, loader);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  static public String fixedpath;
  static public String contentpath;

  public static String home() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir\\build";
    // FIXME: change this back
    s = "/Users/jamesagnew/git/fhir";
    if (new File(s).exists())
      return s;
    throw new Error("FHIR Home directory not configured");
  }


  public static String content() throws IOException {
    if (contentpath != null)
      return contentpath;
    String s = "R:\\fhir\\publish";
    if (new File(s).exists())
      return s;
    return Utilities.path(home(), "publish");
  }

  // diretory that contains all the US implementation guides
  public static String us() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir.us";
    if (new File(s).exists())
      return s;
    throw new Error("FHIR US directory not configured");
  }

  public static String checkXMLIsSame(InputStream expected, InputStream actual) throws Exception {
    String result = compareXml(expected, actual);
    return result;
  }

  public static String checkXMLIsSame(String expected, String actual) throws Exception {
    String result = compareXml(expected, actual);
    if (result != null && SHOW_DIFF) {
      String diff = ToolGlobalSettings.hasComparePath() ? ToolGlobalSettings.getComparePath() : Utilities.path(System.getenv("ProgramFiles"), "WinMerge", "WinMergeU.exe");
      if (new File(diff).exists() || Utilities.isToken(diff)) {
        List<String> command = new ArrayList<String>();
        Process p = Runtime.getRuntime().exec(new String[]{diff, actual, expected});
      }
    }
    return result;
  }

  private static String compareXml(InputStream actual, InputStream expected) throws Exception {
    return compareElements("", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private static String compareXml(String actual, String expected) throws Exception {
    return compareElements("", loadXml(expected).getDocumentElement(), loadXml(actual).getDocumentElement());
  }

  private static String compareElements(String path, Element expectedElement, Element actualElement) {
    if (!namespacesMatch(expectedElement.getNamespaceURI(), actualElement.getNamespaceURI()))
      return "Namespaces differ at " + path + ". Expected: " + expectedElement.getNamespaceURI() + " vs Actual: " + actualElement.getNamespaceURI();
    if (!expectedElement.getLocalName().equals(actualElement.getLocalName()))
      return "Names differ at " + path + ": Expected: " + expectedElement.getLocalName() + " vs Actual: " + actualElement.getLocalName();
    path = path + "/" + expectedElement.getLocalName();
    String s = compareAttributes(path, expectedElement.getAttributes(), actualElement.getAttributes());
    if (!Utilities.noString(s))
      return s;
    s = compareAttributes(path, actualElement.getAttributes(), expectedElement.getAttributes());
    if (!Utilities.noString(s))
      return s;

    Node expectedChild = expectedElement.getFirstChild();
    Node actualChild = actualElement.getFirstChild();
    expectedChild = skipBlankText(expectedChild);
    actualChild = skipBlankText(actualChild);
    while (expectedChild != null && actualChild != null) {
      if (expectedChild.getNodeType() != actualChild.getNodeType())
        return "node type mismatch in children of " + path + ": Expected: " + Integer.toString(expectedElement.getNodeType()) + " vs Actual: " + Integer.toString(actualElement.getNodeType());
      if (expectedChild.getNodeType() == Node.TEXT_NODE) {
        if (!normalise(expectedChild.getTextContent()).equals(normalise(actualChild.getTextContent())))
          return "Text differs at " + path + ": Expected: " + normalise(expectedChild.getTextContent()) + " vs Actual: " + normalise(actualChild.getTextContent());
      } else if (expectedChild.getNodeType() == Node.ELEMENT_NODE) {
        s = compareElements(path, (Element) expectedChild, (Element) actualChild);
        if (!Utilities.noString(s))
          return s;
      }

      expectedChild = skipBlankText(expectedChild.getNextSibling());
      actualChild = skipBlankText(actualChild.getNextSibling());
    }
    if (expectedChild != null)
      return "node mismatch - more nodes in source in children of " + path;
    if (actualChild != null)
      return "node mismatch - more nodes in target in children of " + path;
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
            return "Attributes differ at " + path + ": Expected " + normalise(expectedNode.getTextContent()) + " vs Actual: " + normalise(actualNode.getTextContent());
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
    while (node != null && (((node.getNodeType() == Node.TEXT_NODE) && Utilities.isWhitespace(node.getTextContent())) || (node.getNodeType() == Node.COMMENT_NODE)))
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

  public static String checkJsonSrcIsSame(String s1, String s2) throws JsonSyntaxException, FileNotFoundException, IOException {
    return checkJsonSrcIsSame(s1, s2, true);
  }

  public static String checkJsonSrcIsSame(String expectedString, String actualString, boolean showDiff) throws JsonSyntaxException, FileNotFoundException, IOException {
    String result = compareJsonSrc(expectedString, actualString);
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
      String actual = Utilities.path("[tmp]", "expected" + expectedString.hashCode() + ".json");
      String expected = Utilities.path("[tmp]", "actual" + actualString.hashCode() + ".json");
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
      builder.directory(new CSFile("c:\\temp"));
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
      if (!n.equals("fhir_comments")) {
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
      if (!n.equals("fhir_comments")) {
        if (!actualJsonObject.has(n))
          return "properties differ at " + path + ": missing property " + n;
      }
    }
    return null;
  }

  private static String compareNodes(String path, JsonElement expectedJsonElement, JsonElement actualJsonElement) {
    if (actualJsonElement.getClass() != expectedJsonElement.getClass())
      return "properties differ at " + path + ": type Expected: " + expectedJsonElement.getClass().getName() + "/ Actual: " + actualJsonElement.getClass().getName();
    else if (actualJsonElement instanceof JsonPrimitive) {
      JsonPrimitive actualJsonPrimitive = (JsonPrimitive) actualJsonElement;
      JsonPrimitive expectedJsonPrimitive = (JsonPrimitive) expectedJsonElement;
      if (actualJsonPrimitive.isBoolean() && expectedJsonPrimitive.isBoolean()) {
        if (actualJsonPrimitive.getAsBoolean() != expectedJsonPrimitive.getAsBoolean())
          return "boolean property values differ at " + path + ": type Expected: " + expectedJsonPrimitive.getAsString() + "/ Actual: " + actualJsonPrimitive.getAsString();
      } else if (actualJsonPrimitive.isString() && expectedJsonPrimitive.isString()) {
        String actualJsonString = actualJsonPrimitive.getAsString();
        String expectedJsonString = expectedJsonPrimitive.getAsString();
        if (!(actualJsonString.contains("<div") && expectedJsonString.contains("<div")))
          if (!actualJsonString.equals(expectedJsonString))
            if (!sameBytes(unBase64(actualJsonString), unBase64(expectedJsonString)))
              return "string property values differ at " + path + ": type Expected: " + expectedJsonString + "/ Actual: " + actualJsonString;
      } else if (actualJsonPrimitive.isNumber() && expectedJsonPrimitive.isNumber()) {
        if (!actualJsonPrimitive.getAsString().equals(expectedJsonPrimitive.getAsString()))
          return "number property values differ at " + path + ": type Expected: " + expectedJsonPrimitive.getAsString() + "/ Actual " + actualJsonPrimitive.getAsString();
      } else
        return "property types differ at " + path + ": type Expected" + expectedJsonPrimitive.getAsString() + "/ Actual " + actualJsonPrimitive.getAsString();
    } else if (actualJsonElement instanceof JsonObject) {
      String s = compareObjects(path, (JsonObject) actualJsonElement, (JsonObject) expectedJsonElement);
      if (!Utilities.noString(s))
        return s;
    } else if (actualJsonElement instanceof JsonArray) {
      JsonArray actualArray = (JsonArray) actualJsonElement;
      JsonArray expectedArray = (JsonArray) expectedJsonElement;

      if (actualArray.size() != expectedArray.size())
        return "array properties differ at " + path + ": count Expected " + Integer.toString(expectedArray.size()) + "/ Actual: " + Integer.toString(actualArray.size());
      for (int i = 0; i < actualArray.size(); i++) {
        String s = compareNodes(path + "[" + Integer.toString(i) + "]", expectedArray.get(i), actualArray.get(i));
        if (!Utilities.noString(s))
          return s;
      }
    } else if (actualJsonElement instanceof JsonNull) {

    } else
      return "unhandled property " + actualJsonElement.getClass().getName();
    return null;
  }

  public static String temp() {
    if (new File("c:\\temp").exists())
      return "c:\\temp";
    return System.getProperty("java.io.tmpdir");
  }

  public static String checkTextIsSame(String s1, String s2) throws JsonSyntaxException, FileNotFoundException, IOException {
    return checkTextIsSame(s1, s2, true);
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
        return "Strings differ at character " + Integer.toString(i) + ". Expected: '" + expectedString.charAt(i) + "' vs Actual:'" + actualString.charAt(i) + "'";
    }
    if (expectedString.length() != actualString.length())
      return "Strings differ in length. Expected: " + Integer.toString(expectedString.length()) + " vs Actual: " + Integer.toString(actualString.length()) + " but match to the end of the shortest";
    return null;
  }

  public static String tempFile(String folder, String name) throws IOException {
    String tmp = tempFolder(folder);
    return Utilities.path(tmp, name);
  }

  public static String tempFolder(String name) throws IOException {
    File tmp = new File("C:\\temp");
    if (tmp.exists() && tmp.isDirectory()) {
      String path = Utilities.path("C:\\temp", name);
      Utilities.createDirectory(path);
      return path;
    } else if (ToolGlobalSettings.hasTempPath()) {
      return ToolGlobalSettings.getTempPath();
    } else if (new File("/tmp").exists()) {
      String path = Utilities.path("/tmp", name);
      Utilities.createDirectory(path);
      return path;
    } else {
      String path = Utilities.path(System.getProperty("java.io.tmpdir"), name);
      Utilities.createDirectory(path);
      return path;
    }
  }
}