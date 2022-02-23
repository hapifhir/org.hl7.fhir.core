package org.hl7.fhir.utilities;

import java.io.IOException;

public class ToolGlobalSettings {

  private static boolean inited = false;
  
  private static String npmPath;
  private static String rubyPath;
  private static String testsPath;
  private static String comparePath;
  private static String tempPath;
  private static String testIgsPath;
  
  public static String getNpmPath() {
    init();
    return npmPath;
  }
  public static String getRubyPath() {
    init();
    return rubyPath;
  }
  public static String getTestsPath() {
    init();
    return testsPath;
  }
  
  public static boolean hasNpmPath() {
    init();
    return npmPath != null;
  }
  
  public static boolean hasRubyPath() {
    init();
    return rubyPath != null;
  }
  public static boolean hasTestsPath() {
    init();
    return testsPath != null;
  }
  
  public static String getComparePath() {
    init();
    return comparePath;
  }
  public static boolean hasComparePath() {
    init();
    return comparePath != null;
  }
  
  public static String getTempPath() {
    init();
    return tempPath;
  }
  public static boolean hasTempPath() {
    init();
    return tempPath != null;
  }
  
  public static String getTestIgsPath() {
    init();
    return testIgsPath;
  }
  public static boolean hasTestIgsPath() {
    init();
    return testIgsPath != null;
  }
  
  private static void init() {
    if (!inited) {
      inited = true;
      IniFile ini;
      try {
        ini = new IniFile(Utilities.path(Utilities.path(System.getProperty("user.home"), ".fhir", "fhir-tool-settings.conf")));
        if (ini.hasSection("paths")) {
          npmPath = ini.getStringProperty("paths", "npm");
          rubyPath = ini.getStringProperty("paths", "ruby");
          testsPath = ini.getStringProperty("paths", "tests");
          comparePath = ini.getStringProperty("paths", "compare");
          tempPath = ini.getStringProperty("paths", "temp");
          testIgsPath = ini.getStringProperty("paths", "test-igs");
        }
      } catch (IOException e) {
      }
    }
  }
}