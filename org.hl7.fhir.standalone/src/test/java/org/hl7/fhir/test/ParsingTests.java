package org.hl7.fhir.test;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParsingTests {

  private static NpmPackage npm;

  @BeforeAll
  public static void setUp() {
  }

  @AfterAll
  public static void tearDown() {
    npm = null;
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, IOException, FHIRFormatError, SAXException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    npm = NpmPackage.fromPackage(TestingUtilities.loadTestResourceStream("r6", "packages", "hl7.fhir.r6.examples.tgz"));
    List<Arguments> objects = new ArrayList<>();
    List<String> names = npm.list("package");
    for (String n : names) {
      if (!n.contains("manifest.json") && !n.contains("xver-") && !n.contains("uml.json")  && !n.contains("package-min-ver.json") && !n.startsWith(".")) {
        objects.add(Arguments.of(n));
      }
    }
    return objects.stream();
  }

  @SuppressWarnings("deprecation")
  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  public void test(String name) throws Exception {
    byte[] b = FileUtilities.streamToBytes(npm.load("package", name));
    String src = new String(b);
    Resource r = new JsonParser(TestingUtilities.getSharedWorkerContext()).parse(b);
    b = new XmlParser(TestingUtilities.getSharedWorkerContext()).composeBytes(r);
    r = new XmlParser(TestingUtilities.getSharedWorkerContext()).parse(b);
    b = new JsonParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).composeBytes(r);
    String output = new String(b);
    String msg = new CompareUtilities().checkJsonSrcIsSame(name, src, output);
    if (msg != null) {
      System.out.println(name);
    }
    Assertions.assertTrue(msg == null, msg);
  }

}