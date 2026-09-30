package org.hl7.fhir.utilities.tests;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.settings.FhirSettings;

import static ca.uhn.fhir.util.TestUtil.stripWhitespace;

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
    if (dir != null && ManagedFileAccess.csfile(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
      // ok, we'll resolve this locally
      return FileUtilities.fileToString(ManagedFileAccess.csfile(n));
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
    if (dir != null && ManagedFileAccess.file(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
      return ManagedFileAccess.inStream(n);
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
    if (dir != null && ManagedFileAccess.file(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
      return FileUtilities.fileToBytes(n);
    } else {
      String classpath = ("/org/hl7/fhir/testcases/" + Utilities.pathURL(paths));
      InputStream s = BaseTestingUtilities.class.getResourceAsStream(classpath);
      if (s == null) {
        throw new Error("unable to find resource " + classpath);
      }
      return FileUtilities.streamToBytes(s);
    }
  }

  public static boolean findTestResource(String... paths) throws IOException {
    String dir = TestConfig.getInstance().getFhirTestCasesDirectory();
    if (dir == null && FhirSettings.hasFhirTestCasesPath()) {
      dir = FhirSettings.getFhirTestCasesPath();
    }
    if (dir != null && ManagedFileAccess.file(dir).exists()) {
      String n = Utilities.path(dir, Utilities.path(paths));
      return ManagedFileAccess.file(n).exists();
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
    FileUtilities.createDirectory(path);
    return path;
  }

    public static void setFhirTestCasesDirectory(String s) {
    }

  public static void createParentDirIfNotExists(Path target) throws IOException {
    Path parent = target.getParent();
    if (!ManagedFileAccess.fromPath(parent).exists()) {
      ManagedFileAccess.fromPath(parent).mkdirs();
    }
  }



  /**
   * The base64 comparison is a fallback for binary content, and must only be used when the
   * string really is base64. commons-codec decodes leniently: it skips every character outside
   * the base64 alphabet and stops at the first '=', so ordinary text "decodes" to the
   * alphanumeric prefix before its first '=' - and two messages that differ only after that
   * point would compare as equal. Anything that isn't canonical base64 decodes to nothing
   * here, which sameBytes() never treats as a match.
   */
  protected static byte[] unBase64(String text, boolean allowWhitespace, boolean mustRoundTrip) {
    String workingText = allowWhitespace ? stripWhitespace(text) : text;
    if (!isBase64Text(workingText)) {
      return new byte[0];
    }
    byte[] bytes = Base64.decodeBase64(text);
    // unused trailing bits are ignored by the decoder, so require the round trip as well
    return !mustRoundTrip || Base64.encodeBase64String(bytes).equals(text) ? bytes : new byte[0];
  }

  protected static boolean isBase64Text(String text) {
    if (text == null || text.isEmpty() || text.length() % 4 != 0) {
      return false;
    }
    int pad = 0;
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == '=') {
        pad++;
      } else if (pad > 0) {
        return false;
      } else if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '+' || c == '/')) {
        return false;
      }
    }
    return pad <= 2;
  }
}