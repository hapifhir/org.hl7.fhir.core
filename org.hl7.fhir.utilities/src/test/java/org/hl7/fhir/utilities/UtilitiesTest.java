package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.commons.lang3.SystemUtils;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UtilitiesTest {

  public static final String OSX = "OS X";
  public static final String MAC = "MAC";
  public static final String WINDOWS = "WINDOWS";
  public static final String LINUX = "Linux";

  public static final String TEST_TXT = "test.txt";

  private static final String getNormalizedJavaHomeDir() {
    return System.getenv("JAVA_HOME") == null ? null : Paths.get(System.getenv("JAVA_HOME")).normalize().toString();
  }

  public static final String LINUX_TEMP_DIR = "/tmp/";
  public static final String LINUX_USER_DIR = System.getProperty("user.home") + "/";
  public static final String LINUX_JAVA_HOME = getNormalizedJavaHomeDir() + "/";

  public static final String WIN_USER_DIR = System.getProperty("user.home") + "\\";
  public static final String WIN_JAVA_HOME = getNormalizedJavaHomeDir() + "\\";

  public static final String OSX_USER_DIR = System.getProperty("user.home") + "/";
  public static final String OSX_JAVA_HOME = getNormalizedJavaHomeDir() + "/";
  @Test
  @DisplayName("Test Utilities.path maps temp directory correctly")
  public void testTempDirPath() throws IOException {
    if (FhirSettings.hasTempPath()) {
      assertEquals(Utilities.path("[tmp]", TEST_TXT), FhirSettings.getTempPath() +File.separator+ TEST_TXT);
    } else {
      assertEquals(Utilities.path("[tmp]", TEST_TXT), getTempDirectory() + TEST_TXT);
    }
  }

  @Test
  @DisplayName("Test Utilities.path maps user directory correctly")
  public void testUserDirPath() throws IOException {
    assertEquals(Utilities.path("[user]", TEST_TXT), getUserDirectory() + TEST_TXT);
  }

  private String getJavaHomeDirectory() {
    String os = SystemUtils.OS_NAME;
    if (os.contains(OSX) || os.contains(MAC)) {
      return OSX_JAVA_HOME;
    } else if (os.contains(LINUX)) {
      return LINUX_JAVA_HOME;
    } else if (os.toUpperCase().contains(WINDOWS)) {
      return WIN_JAVA_HOME;
    } else {
      throw new IllegalStateException("OS not recognized...cannot verify created directories.");
    }
  }

  private String getUserDirectory() {
    String os = SystemUtils.OS_NAME;
    if (os.contains(OSX) || os.contains(MAC)) {
      return OSX_USER_DIR;
    } else if (os.contains(LINUX)) {
      return LINUX_USER_DIR;
    } else if (os.toUpperCase().contains(WINDOWS)) {
      return WIN_USER_DIR;
    } else {
      throw new IllegalStateException("OS not recognized...cannot verify created directories.");
    }
  }

  private String getTempDirectory() throws IOException {
    String os = SystemUtils.OS_NAME;
    if (os.contains(OSX) || os.contains(MAC)) {
      return getOsxTempDir();
    } else if (os.contains(LINUX)) {
      return LINUX_TEMP_DIR;
    } else if (os.toUpperCase().contains(WINDOWS)) {
      File tmp = new File(Utilities.C_TEMP_DIR);
      if(tmp.exists()) {
        return Utilities.C_TEMP_DIR + '\\';
      } else {
        return System.getProperty("java.io.tmpdir");
      }
    } else {
      throw new IllegalStateException("OS not recognized...cannot verify created directories.");
    }
  }

  /**
   * Getting the temporary directory in OSX is a little different from Linux and Windows. We need to create a temporary
   * file and then extract the directory path from it.
   *
   * @return Full path to tmp directory on OSX machines.
   * @throws IOException
   */
  public static String getOsxTempDir() throws IOException {
    File file = File.createTempFile("throwaway", ".file");
    return file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('/')) + '/';
  }

  public static final int BOUND = 499;
  public static final Random RAND = new Random();

  public static int nextInt() {
    return 1 + RAND.nextInt(BOUND);
  }

  public static final int GB_MEASURE_JUST_OVER = (int) Math.pow(Utilities.ONE_MB, 3) + nextInt();
  public static final int GB_MEASURE_EXACT = (int) Math.pow(Utilities.ONE_MB, 3);
  public static final int GB_MEASURE_JUST_UNDER = (int) Math.pow(Utilities.ONE_MB, 3) - nextInt();

  public static final int MB_MEASURE_JUST_OVER = (int) Math.pow(Utilities.ONE_MB, 2) + nextInt();
  public static final int MB_MEASURE_EXACT = (int) Math.pow(Utilities.ONE_MB, 2);
  public static final int MB_MEASURE_JUST_UNDER = (int) Math.pow(Utilities.ONE_MB, 2) - nextInt();

  public static final int KB_MEASURE_JUST_OVER = Utilities.ONE_MB + nextInt();
  public static final int KB_MEASURE_EXACT = Utilities.ONE_MB;
  public static final int KB_MEASURE_JUST_UNDER = Utilities.ONE_MB - nextInt();

  public static final int BT_MEASURE = Utilities.ONE_MB + nextInt();
  public static final int EMPTY = 0;

  public static final int BIG_NEG = Utilities.ONE_MB * -1;

  private static final String buildMeasureLimitMessage(int size, String contains) {
    return MessageFormat.format("\"{0}\" should contain \"{1}\"", size, contains);
  }

  //TODO we've witnessed at least one intermittent failure of this test. It could be refactored to run several times to
  // trigger edge cases more often now that it provides better feedback.
  @Test
  @DisplayName("Test size bounds on file size utility.")
  void describeSizeTest() {
    Assertions.assertAll("GB Measure Limits",
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_JUST_OVER).contains(Utilities.GB), buildMeasureLimitMessage(GB_MEASURE_JUST_OVER, Utilities.GB)),
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_EXACT).contains(Utilities.MB), buildMeasureLimitMessage(GB_MEASURE_EXACT, Utilities.MB)),
      () -> assertTrue(Utilities.describeSize(GB_MEASURE_JUST_UNDER).contains(Utilities.MB), buildMeasureLimitMessage(GB_MEASURE_JUST_UNDER, Utilities.MB))
    );
    Assertions.assertAll("MB Measure Limits",
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_JUST_OVER).contains(Utilities.MB), buildMeasureLimitMessage(MB_MEASURE_JUST_OVER, Utilities.MB)),
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_EXACT).contains(Utilities.KB), buildMeasureLimitMessage(MB_MEASURE_EXACT, Utilities.KB)),
      () -> assertTrue(Utilities.describeSize(MB_MEASURE_JUST_UNDER).contains(Utilities.KB), buildMeasureLimitMessage(MB_MEASURE_JUST_UNDER, Utilities.KB))
    );
    Assertions.assertAll("KB Measure Limits",
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_JUST_OVER).contains(Utilities.KB), buildMeasureLimitMessage(KB_MEASURE_JUST_OVER, Utilities.KB)),
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_EXACT).contains(Utilities.BT), buildMeasureLimitMessage(KB_MEASURE_EXACT, Utilities.BT)),
      () -> assertTrue(Utilities.describeSize(KB_MEASURE_JUST_UNDER).contains(Utilities.BT), buildMeasureLimitMessage(KB_MEASURE_JUST_UNDER, Utilities.BT))
    );
    Assertions.assertAll("BT Measure Limits",
      () -> assertTrue(Utilities.describeSize(BT_MEASURE).contains(Utilities.BT), buildMeasureLimitMessage(BT_MEASURE, Utilities.BT)),
      () -> assertTrue(Utilities.describeSize(EMPTY).contains(Utilities.BT), buildMeasureLimitMessage(EMPTY,  Utilities.BT))
    );
    Assertions.assertThrows(IllegalArgumentException.class, () -> Utilities.describeSize(BIG_NEG));
  }
  
  @Test
  @DisplayName("Decimal Reasoning Tests")
  void testDecimalRoutines() {
    assertEquals("-0.500000", Utilities.lowBoundaryForDecimal("0", 6));
    assertEquals("0.50000000", Utilities.lowBoundaryForDecimal("1", 8));
    assertEquals("0.950000", Utilities.lowBoundaryForDecimal("1.0", 6));
    assertEquals("0.95", Utilities.lowBoundaryForDecimal("1.0", 2));
    assertEquals("-1.05000000", Utilities.lowBoundaryForDecimal("-1.0", 8));
    assertEquals("1.23", Utilities.lowBoundaryForDecimal("1.234", 2));
    assertEquals("1.57", Utilities.lowBoundaryForDecimal("1.567", 2));

    assertEquals("0.50000000", Utilities.highBoundaryForDecimal("0", 8));
    assertEquals("1.500000", Utilities.highBoundaryForDecimal("1", 6));
    assertEquals("1.0500000000", Utilities.highBoundaryForDecimal("1.0", 10));
    assertEquals("-0.9500", Utilities.highBoundaryForDecimal("-1.0", 4));

    assertEquals(0, Utilities.getDecimalPrecision("0"));
    assertEquals(0, Utilities.getDecimalPrecision("1"));
    assertEquals(1, Utilities.getDecimalPrecision("1.0"));
    assertEquals(1, Utilities.getDecimalPrecision("-1.0"));
    assertEquals(4, Utilities.getDecimalPrecision("-1.0200"));
  }
  
  @Test
  @DisplayName("Date Reasoning Tests")
  void testDateRoutines() {
//    Assertions.assertEquals("2021-01-01T00:00:00.000", Utilities.lowBoundaryForDate("2021"));
//    Assertions.assertEquals("2021-04-01T00:00:00.000", Utilities.lowBoundaryForDate("2021-04"));
//    Assertions.assertEquals("2020-02-01T00:00:00.000", Utilities.lowBoundaryForDate("2020-02"));
//    Assertions.assertEquals("2021-04-04T00:00:00.000", Utilities.lowBoundaryForDate("2021-04-04"));
//    Assertions.assertEquals("2021-04-04T21:22:23.000", Utilities.lowBoundaryForDate("2021-04-04T21:22:23"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245", Utilities.lowBoundaryForDate("2021-04-04T21:22:23.245"));
//    Assertions.assertEquals("2021-04-04T21:22:23.000Z", Utilities.lowBoundaryForDate("2021-04-04T21:22:23Z"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245+10:00", Utilities.lowBoundaryForDate("2021-04-04T21:22:23.245+10:00"));
//
//    Assertions.assertEquals("2021-12-31T23:23:59.999", Utilities.highBoundaryForDate("2021"));
//    Assertions.assertEquals("2021-04-30T23:23:59.999", Utilities.highBoundaryForDate("2021-04"));
//    Assertions.assertEquals("2020-02-29T23:23:59.999", Utilities.highBoundaryForDate("2020-02"));
//    Assertions.assertEquals("2021-04-04T23:23:59.999", Utilities.highBoundaryForDate("2021-04-04"));
//    Assertions.assertEquals("2021-04-04T21:22:23.999", Utilities.highBoundaryForDate("2021-04-04T21:22:23"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245", Utilities.highBoundaryForDate("2021-04-04T21:22:23.245"));
//    Assertions.assertEquals("2021-04-04T21:22:23.999Z", Utilities.highBoundaryForDate("2021-04-04T21:22:23Z"));
//    Assertions.assertEquals("2021-04-04T21:22:23.245+10:00", Utilities.highBoundaryForDate("2021-04-04T21:22:23.245+10:00"));
    
    assertEquals(8, Utilities.getDatePrecision("1900-01-01"));
    assertEquals(4, Utilities.getDatePrecision("1900"));
    assertEquals(6, Utilities.getDatePrecision("1900-06"));
    assertEquals(14, Utilities.getDatePrecision("1900-06-06T14:00:00"));
    assertEquals(17, Utilities.getDatePrecision("1900-06-06T14:00:00.000"));
    assertEquals(8, Utilities.getDatePrecision("1900-01-01Z"));
    assertEquals(4, Utilities.getDatePrecision("1900Z"));
    assertEquals(6, Utilities.getDatePrecision("1900-06Z"));
    assertEquals(14, Utilities.getDatePrecision("1900-06-06T14:00:00Z"));
    assertEquals(17, Utilities.getDatePrecision("1900-06-06T14:00:00.000Z"));
    assertEquals(8, Utilities.getDatePrecision("1900-01-01+10:00"));
    assertEquals(4, Utilities.getDatePrecision("1900+10:00"));
    assertEquals(6, Utilities.getDatePrecision("1900-06+10:00"));
    assertEquals(14, Utilities.getDatePrecision("1900-06-06T14:00:00+10:00"));
    assertEquals(17, Utilities.getDatePrecision("1900-06-06T14:00:00.000-10:00"));
  }
  
  public static Stream<Arguments> windowsRootPaths() {
    return Stream.of(
      Arguments.of((Object)new String[]{"C:"}),
      Arguments.of((Object)new String[]{"D:"}),
      Arguments.of((Object)new String[]{"C:", "anything"}),
      Arguments.of((Object)new String[]{"D:", "anything"}),
      Arguments.of((Object)new String[]{"C:/", "anything"}),
      Arguments.of((Object)new String[]{"C:/.", "anything"}),
      Arguments.of((Object)new String[]{"C:\\"}),
      Arguments.of((Object)new String[]{"D:\\"}),
      Arguments.of((Object)new String[]{"C:/child/.."}),
      Arguments.of((Object)new String[]{"C:/child/..", "anything"}),
      Arguments.of((Object)new String[]{"C:/child/../child/.."}),
      Arguments.of((Object)new String[]{"C:/child/../child/..", "anything"}),
      Arguments.of((Object)new String[]{"C:/child/second/../.."}),
      Arguments.of((Object)new String[]{"C:/child/second/../..", "anything"}),
      Arguments.of((Object)new String[]{"C:\\child\\.."}),
      Arguments.of((Object)new String[]{"C:\\child\\..", "anything"}),
      Arguments.of((Object)new String[]{"C:\\child\\..\\child/.."}),
      Arguments.of((Object)new String[]{"C:\\child\\..\\child\\..", "anything"}),
      Arguments.of((Object)new String[]{"C:\\child\\second\\..\\.."}),
      Arguments.of((Object)new String[]{"C:\\child\\second\\..\\..", "anything"})
    );
  }
  @ParameterizedTest
  @MethodSource("windowsRootPaths")
  @EnabledOnOs({OS.WINDOWS})
  public void testPathCantStartWithRootWindows(String[] pathStrings) {
    testCantStartWithRoot(pathStrings);
  }

  public static Stream<Arguments> macAndLinuxRootPaths() {
    return Stream.of(
      Arguments.of((Object)new String[]{"/"}),
      Arguments.of((Object)new String[]{"/", "anything"}),
      Arguments.of((Object)new String[]{"//"}),
      Arguments.of((Object)new String[]{"//", "anything"}),
      Arguments.of((Object)new String[]{"//child/.."}),
      Arguments.of((Object)new String[]{"//child/..", "anything"}),
      Arguments.of((Object)new String[]{"//child/../child/.."}),
      Arguments.of((Object)new String[]{"//child/../child/..", "anything"}),
      Arguments.of((Object)new String[]{"//child/second/../.."}),
      Arguments.of((Object)new String[]{"//child/second/../..", "anything"})
    );
  }
  @ParameterizedTest
  @MethodSource("macAndLinuxRootPaths")
  @EnabledOnOs({OS.MAC, OS.LINUX})
  public void testPathCantStartWithRootMacAndLinux(String[] pathStrings) {
    testCantStartWithRoot(pathStrings);
  }

  private static void testCantStartWithRoot(String[] pathStrings) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Utilities.path(pathStrings);
    });
    assertTrue(thrown.getMessage().endsWith(pathStrings[0]+", full path = "+String.join(", ", pathStrings)));
  }

  public static Stream<Arguments> macAndLinuxNonFirstElementStartPaths() {
    return Stream.of(
      Arguments.of((Object)new String[]{"/root", ".."}),
      Arguments.of((Object)new String[]{"/root", "child/../.."}),
      Arguments.of((Object)new String[]{"/root", "child", "/../.."}),
      Arguments.of((Object)new String[]{"/root", "child", "../.."}),
      Arguments.of((Object)new String[]{"/root/a", "../.."}),
      Arguments.of((Object)new String[]{"/root/a", "child/../.."}),
      Arguments.of((Object)new String[]{"/root/a", "child", "/../../.."}),
      Arguments.of((Object)new String[]{"/root/a", "child", "../../.."})
    );
  }

  @ParameterizedTest
  @MethodSource("macAndLinuxNonFirstElementStartPaths")
  @EnabledOnOs({OS.MAC, OS.LINUX})
  public void testPathMustStartWithFirstElementMacAndLinux(String[] pathStrings) {
    testPathMustStartWithFirstElement(pathStrings);
  }

  private static void testPathMustStartWithFirstElement(String[] pathStrings) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Utilities.path(pathStrings);
    });
    assertTrue(thrown.getMessage().startsWith("Computed path does not start with first element: " + pathStrings[0]));
  }

  public static Stream<Arguments> macAndLinuxValidPaths() {
    return Stream.of(
      Arguments.of((Object) new String[]{"/root"}, "/root"),
      Arguments.of( (Object) new String[]{"/root", "child"}, "/root/child"),
      Arguments.of((Object) new String[]{"/root", "../root/child"}, "/root/child"),
      Arguments.of((Object) new String[]{"/root", "child", "anotherchild"}, "/root/child/anotherchild")
    );
  }

  @ParameterizedTest
  @MethodSource("macAndLinuxValidPaths")
  @EnabledOnOs({OS.MAC, OS.LINUX})
  public void testValidPathsMacAndLinux(String[] pathStrings, String expectedPath) throws IOException {
    testValidPath(pathStrings,expectedPath);
  }

  public static Stream<Arguments> windowsValidPaths() {
    return Stream.of(
      Arguments.of((Object) new String[]{"C://root"}, "C:\\\\root"),
      Arguments.of( (Object) new String[]{"C://root", "child"}, "C:\\\\root\\child"),
      Arguments.of((Object) new String[]{"C://root", "../root/child"}, "C:\\\\root\\child"),
      Arguments.of((Object) new String[]{"C://root", "child", "anotherchild"}, "C:\\\\root\\child\\anotherchild"),
      Arguments.of((Object) new String[]{"C:\\\\root"}, "C:\\\\root"),
      Arguments.of( (Object) new String[]{"C:\\\\root", "child"}, "C:\\\\root\\child"),
      Arguments.of((Object) new String[]{"C:\\\\root", "..\\root\\child"}, "C:\\\\root\\child"),
      Arguments.of((Object) new String[]{"C:\\\\root", "child", "anotherchild"}, "C:\\\\root\\child\\anotherchild")
    );
  }

  @ParameterizedTest
  @MethodSource("windowsValidPaths")
  @EnabledOnOs({OS.WINDOWS})
  public void testValidPathsWindows(String[] pathStrings, String expectedPath) throws IOException {
    testValidPath(pathStrings,expectedPath);
  }

  private static void testValidPath(String[] pathsStrings, String expectedPath) throws IOException {
    String actualPath = Utilities.path(pathsStrings);
    assertEquals(expectedPath, actualPath);
  }

  public static Stream<Arguments> nullOrEmptyFirstEntryPaths() {
    return Stream.of(
      Arguments.of((Object)new String[]{null, "child"}),
      Arguments.of((Object)new String[]{null, "child/otherchild"}),
      Arguments.of((Object)new String[]{null, "child", "otherchild"}),
      Arguments.of((Object)new String[]{"", "child"}),
      Arguments.of((Object)new String[]{"", "child/otherchild"}),
      Arguments.of((Object)new String[]{"", "child", "otherchild"}),
      Arguments.of((Object)new String[]{"  ", "child"}),
      Arguments.of((Object)new String[]{"  ", "child/otherchild"}),
      Arguments.of((Object)new String[]{"  ", "child", "otherchild"})
    );
  }

  @ParameterizedTest
  @MethodSource("nullOrEmptyFirstEntryPaths")
  public void testNullOrEmptyFirstPathEntryFails(String[] pathsStrings) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Utilities.path(pathsStrings);
    });
    assertEquals("First entry in file path cannot be null or empty, full path = "+String.join(", ", pathsStrings),thrown.getMessage());
  }

  @Test
  @DisplayName("trimWS tests")
  void testTrimWS() {
    Assertions.assertEquals("", Utilities.trimWS(""));
    Assertions.assertEquals("", Utilities.trimWS(" "));
    Assertions.assertEquals("t", Utilities.trimWS(" t "));
    Assertions.assertEquals(".", Utilities.trimWS("\r."));
    Assertions.assertEquals("# %", Utilities.trimWS("# %"));
    Assertions.assertEquals("", Utilities.trimWS("\u0009\n\u000B\u000C\r\u0020\u0085\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u2028\u2029\u202F\u205F\u3000"));
  }

  @Test
  @DisplayName("regex tests")
  void testRegex() {
    Assertions.assertFalse("".matches(".+"));
    Assertions.assertTrue(".".matches(".+"));
    Assertions.assertTrue(" t ".matches(".+"));
    Assertions.assertTrue(" ".matches(".+"));
    Assertions.assertFalse("".matches("^.+$"));
    Assertions.assertTrue(".".matches("^.+$"));
    Assertions.assertTrue(" t ".matches("^.+$"));
    Assertions.assertTrue(" ".matches("^.+$"));
    Assertions.assertFalse("".matches("[\\s\\S]+"));
    Assertions.assertTrue(".".matches("[\\s\\S]+"));
    Assertions.assertTrue(" t ".matches("[\\s\\S]+"));
    Assertions.assertTrue(" ".matches("[\\s\\S]+"));
    Assertions.assertFalse("".matches("^[\\s\\S]+$"));
    Assertions.assertTrue(".".matches("^[\\s\\S]+$"));
    Assertions.assertTrue(" t ".matches("^[\\s\\S]+$"));
    Assertions.assertTrue(" ".matches("^[\\s\\S]+$"));
    Assertions.assertTrue("Example Requirements Set 2".matches("^[\\s\\S]+$"));
    Assertions.assertTrue("\u0009\n\u000B\u000C\r\u0020\u0085\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u2028\u2029\u202F\u205F\u3000".matches("^[\\s\\S]+$"));
    Assertions.assertFalse("\u0009\n\u000B\u000C\r\u0020\u0085\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u2028\u2029\u202F\u205F\u3000".matches(".+"));
    Assertions.assertFalse("\u0009\n\u000B\u000C\r\u0020\u0085\u00A0\u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006\u2007\u2008\u2009\u200A\u2028\u2029\u202F\u205F\u3000".matches("^.+$"));
  }

  @Test
  @DisplayName("directory copy case tests")
  void testFDirectoryCopy() throws IOException {
    String src = Utilities.path("[tmp]", "test", "copy-source");
    String dst = Utilities.path("[tmp]", "test", "copy-dest");
    makeDir (src);
    makeFile(Utilities.path(src, "Test.txt"), "source1");
    makeDir (Utilities.path(src, "SUB"));
    makeFile(Utilities.path(src, "SUB", "TEST.txt"), "source2");

    makeDir (dst);
    makeFile(Utilities.path(dst, "test.txt"), "dest1");
    makeDir (Utilities.path(dst, "sub"));
    makeFile(Utilities.path(dst, "sub", "test.txt"), "dest2");
    
    Utilities.copyDirectory(src, dst, null);
    
    checkDir (dst);
    checkFile(Utilities.path(dst, "Test.txt"), "source1");
    checkDir (Utilities.path(dst, "SUB"));
    checkFile(Utilities.path(dst, "SUB", "TEST.txt"), "source2");
  }

  private void checkFile(String path, String content) throws IOException {
    Assertions.assertTrue(new CSFile(path).exists());
    Assertions.assertEquals(content, TextFile.fileToString(path));
  }

  private void checkDir(String path) throws IOException {
    Assertions.assertTrue(new CSFile(path).exists());
  }

  private void makeFile(String path, String content) throws IOException {
    TextFile.stringToFile(content, path);
  }

  private void makeDir(String path) throws IOException {
    Utilities.createDirectory(path);
    Utilities.clearDirectory(path);
  }
}

