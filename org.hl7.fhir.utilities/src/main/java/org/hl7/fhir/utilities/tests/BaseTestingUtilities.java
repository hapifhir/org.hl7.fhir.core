package org.hl7.fhir.utilities.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.CSFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.settings.FhirSettings;

public class BaseTestingUtilities {

  static public boolean silent;


  public static String loadTestResource(String... paths) throws IOException {
    /**
     * This 'if' condition checks to see if the fhir-test-cases project (https://github.com/FHIR/fhir-test-cases) is
     * installed locally at the same directory level as the core library project is. If so, the test case data is read
     * directly from that project, instead of the imported maven dependency jar. It is important, that if you want to
     * test against the dependency imported from sonatype nexus, instead of your local copy, you need to either change
     * the name of the project directory to something other than 'fhir-test-cases', or move it to another location, not
     * at the same directory level as the core project.
     */

    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && new CSFile(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
      // ok, we'll resolve this locally
      return TextFile.fileToString(new CSFile(n));
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
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && new File(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
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
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && new File(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
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
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && new File(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
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

  public static String tempFile(String folder, String name) throws IOException {
    String tmp = tempFolder(folder);
    return Utilities.path(tmp, name);
  }

  public static String tempFolder(String name) throws IOException {
    String path = Utilities.path(FhirSettings.hasTempPath() ? FhirSettings.getTempPath() : "[tmp]", name);
    Utilities.createDirectory(path);
    return path;
  }

    public static void setFhirTestCasesDirectory(String s) {
    }

  public static void createParentDirIfNotExists(Path target) {
    Path parent = target.getParent();
    if (!parent.toFile().exists()) {
      parent.toFile().mkdirs();
    }
  }
}