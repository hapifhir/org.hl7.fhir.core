package org.hl7.fhir.validation.codegen;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Generates a JUnit test class for a generated model. The test class fetches the source
 * package(s) (same version as the code was generated from), loads all the examples from
 * them, and checks that each example round trips correctly json -> xml -> json
 */
public class JavaTestCasesGenerator extends JavaBaseGenerator {

  public JavaTestCasesGenerator(OutputStream out, Definitions definitions, Configuration configuration, String version, String genDate, String packageName) throws UnsupportedEncodingException {
    super(out, definitions, configuration, version, genDate, packageName);
  }

  public void generate(String jname, String modelPackageName, List<String> pids, List<String> resourceNames) throws IOException {
    String cn = jname+"RoundTripTests";

    write("package "+packageName+";\r\n");
    write("\r\n");
    startMark(version, genDate);
    write("import java.io.IOException;\r\n");
    write("import java.nio.charset.StandardCharsets;\r\n");
    write("import java.util.ArrayList;\r\n");
    write("import java.util.List;\r\n");
    write("import java.util.stream.Stream;\r\n");
    write("\r\n");
    write("import org.hl7.fhir.r5.model.Resource;\r\n");
    write("import org.hl7.fhir.utilities.FileUtilities;\r\n");
    write("import org.hl7.fhir.utilities.Utilities;\r\n");
    write("import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;\r\n");
    write("import org.hl7.fhir.utilities.npm.NpmPackage;\r\n");
    if (!packageName.equals(modelPackageName)) {
      write("import "+modelPackageName+".*;\r\n");
    }
    write("import org.junit.jupiter.params.ParameterizedTest;\r\n");
    write("import org.junit.jupiter.params.provider.Arguments;\r\n");
    write("import org.junit.jupiter.params.provider.MethodSource;\r\n");
    write("\r\n");
    write("import static org.junit.jupiter.api.Assertions.assertEquals;\r\n");
    write("import static org.junit.jupiter.api.Assertions.assertTrue;\r\n");
    write("\r\n");
    write("/**\r\n");
    write(" * Round trip tests for the "+jname+" model: each example in the source package(s) is\r\n");
    write(" * parsed from json, composed to xml, parsed back from the xml, composed back to json,\r\n");
    write(" * and then the two json representations are compared\r\n");
    write(" */\r\n");
    write("public class "+cn+" {\r\n");
    write("\r\n");
    write("  private static final String[] PACKAGES = {");
    boolean first = true;
    for (String pid : pids) {
      write((first ? "" : ", ")+"\""+pid+"\"");
      first = false;
    }
    write("};\r\n");
    write("  private static final String[] RESOURCE_TYPES = {");
    first = true;
    for (String n : resourceNames) {
      write((first ? "" : ", ")+"\""+n+"\"");
      first = false;
    }
    write("};\r\n");
    write("\r\n");
    write("  public static Stream<Arguments> data() throws IOException {\r\n");
    write("    List<Arguments> objects = new ArrayList<>();\r\n");
    write("    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();\r\n");
    write("    for (String pid : PACKAGES) {\r\n");
    write("      NpmPackage npm = pcm.loadPackage(pid);\r\n");
    write("      for (String fn : npm.list(\"example\")) {\r\n");
    write("        if (fn.endsWith(\".json\") && fn.contains(\"-\")) {\r\n");
    write("          String rt = fn.substring(0, fn.indexOf(\"-\"));\r\n");
    write("          if (Utilities.existsInList(rt, RESOURCE_TYPES)) {\r\n");
    write("            objects.add(Arguments.of(pid+\"/\"+fn, pid, fn));\r\n");
    write("          }\r\n");
    write("        }\r\n");
    write("      }\r\n");
    write("    }\r\n");
    write("    return objects.stream();\r\n");
    write("  }\r\n");
    write("\r\n");
    write("  @ParameterizedTest(name = \"{0}\")\r\n");
    write("  @MethodSource(\"data\")\r\n");
    write("  public void testRoundTrip(String name, String pid, String filename) throws IOException {\r\n");
    write("    NpmPackage npm = new FilesystemPackageCacheManager.Builder().build().loadPackage(pid);\r\n");
    write("    byte[] source = FileUtilities.streamToBytes(npm.load(\"example\", filename));\r\n");
    write("\r\n");
    write("    Resource r1 = new "+jname+"JsonParser(true, true).parse(source);\r\n");
    write("    String json1 = new "+jname+"JsonParser(true, true).composeString(r1);\r\n");
    write("\r\n");
    write("    String xml = new "+jname+"XmlParser(true).composeString(r1);\r\n");
    write("    Resource r2 = new "+jname+"XmlParser(true).parse(xml.getBytes(StandardCharsets.UTF_8));\r\n");
    write("\r\n");
    write("    String json2 = new "+jname+"JsonParser(true, true).composeString(r2);\r\n");
    write("    assertTrue(r1.equalsDeep(r2), \"resources differ after round trip json -> xml -> json:\\r\\n\"+json1+\"\\r\\n----\\r\\n\"+json2);\r\n");
    write("    assertEquals(json1, json2, \"json differs after round trip json -> xml -> json\");\r\n");
    write("  }\r\n");
    write("\r\n");
    write("}");
    flush();
    close();
  }

}
