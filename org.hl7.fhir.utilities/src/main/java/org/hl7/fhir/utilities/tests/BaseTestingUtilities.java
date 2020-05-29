package org.hl7.fhir.utilities.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class BaseTestingUtilities {

  static public boolean silent;

  public static String loadTestResource(String... paths) throws IOException {
    if (new File("../../fhir-test-cases").exists() && isTryToLoadFromFileSystem()) {
      String n = Utilities.path(System.getProperty("user.dir"), "..", "..", "fhir-test-cases", Utilities.path(paths));
      // ok, we'll resolve this locally
      return TextFile.fileToString(new File(n));
    } else {
      // resolve from the package 
      String contents;
      String classpath = ("/org/hl7/fhir/testcases/" + Utilities.pathURL(paths));
      try (InputStream inputStream = BaseTestingUtilities.class.getResourceAsStream(classpath)) {
        if (inputStream == null) {
          throw new IOException("Can't find file on classpath: " + classpath);
        }
        contents = IOUtils.toString(inputStream, java.nio.charset.StandardCharsets.UTF_8);
      }
      return contents;
    }
  }

  public static InputStream loadTestResourceStream(String... paths) throws IOException {
    if (new File("../../fhir-test-cases").exists() && isTryToLoadFromFileSystem()) {
      String n = Utilities.path(System.getProperty("user.dir"), "..", "..", "fhir-test-cases", Utilities.path(paths));
      return new FileInputStream(n);
    } else {
      String classpath = ("/org/hl7/fhir/testcases/" + Utilities.pathURL(paths));
      InputStream s = BaseTestingUtilities.class.getResourceAsStream(classpath);
      if (s == null) {
        throw new Error("unable to find resource " + classpath);
      }
      return s;
    }
  }

  public static byte[] loadTestResourceBytes(String... paths) throws IOException {
    if (new File("../../fhir-test-cases").exists() && isTryToLoadFromFileSystem()) {
      String n = Utilities.path(System.getProperty("user.dir"), "..", "..", "fhir-test-cases", Utilities.path(paths));
      return TextFile.fileToBytes(n);
    } else {
      String classpath = ("/org/hl7/fhir/testcases/" + Utilities.pathURL(paths));
      InputStream s = BaseTestingUtilities.class.getResourceAsStream(classpath);
      if (s == null) {
        throw new Error("unable to find resource " + classpath);
      }
      return TextFile.streamToBytes(s);
    }
  }

  public static boolean findTestResource(String... paths) throws IOException {
    if (new File("../../fhir-test-cases").exists() && isTryToLoadFromFileSystem()) {
      String n = Utilities.path(System.getProperty("user.dir"), "..", "..", "fhir-test-cases", Utilities.path(paths));
      return new File(n).exists();
    } else {
      String classpath = ("/org/hl7/fhir/testcases/" + Utilities.pathURL(paths));
      try {
        InputStream inputStream = BaseTestingUtilities.class.getResourceAsStream(classpath);
        return inputStream != null;
      } catch (Throwable t) {
        return false;
      }
    }
  }

  // TODO: JA need to figure out how to detect that we're running in maven
  public static boolean isTryToLoadFromFileSystem() {
    return !"true".equals(System.getProperty("dont_load_from_filesystem"));
  }


}
