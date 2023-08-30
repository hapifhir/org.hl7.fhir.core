package org.hl7.fhir.r4b.test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.formats.JsonParser;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

public class ParsingTests {

  private static NpmPackage npm;

  @BeforeAll
  public static void setUp() {
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    npm = pcm.loadPackage("hl7.fhir.r4b.examples", "4.3.0");
    List<Arguments> objects = new ArrayList<>();
    List<String> names = npm.list("package");
    for (String n : names) {
      if (!n.contains("manifest.json") && !n.contains("xver-") && !n.contains("uml.json")  && !n.contains("package-min-ver.json")) {
        objects.add(Arguments.of(n));
      }
    }
    return objects.stream();
  }

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name) throws Exception {
//    System.out.println(name);
    byte[] b = TextFile.streamToBytes(npm.load("package", name));
    String src = new String(b);
    Resource r = new JsonParser().parse(b);
    b = new XmlParser().composeBytes(r);
    TextFile.bytesToFile(b, Utilities.path("[tmp]", "test.xml"));
    r = new XmlParser().parse(b);
    b = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeBytes(r);
    String output = new String(b);
    String msg = TestingUtilities.checkJsonSrcIsSame(src, output);
    Assertions.assertTrue(msg == null, msg);
  }

}