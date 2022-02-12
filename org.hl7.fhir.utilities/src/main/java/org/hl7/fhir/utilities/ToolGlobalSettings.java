package org.hl7.fhir.utilities;

import java.io.IOException;

public class ToolGlobalSettings {

  private static boolean inited = false;
  
  private static String npmPath;
  private static String rubyPath;
  private static String testsPath;
  private static String comparePath;
  private static String tempPath;
  
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
    return comparePath;
  }
  public static boolean hasComparePath() {
    return comparePath != null;
  }
  public static String getTempPath() {
    return tempPath;
  }
  public static boolean hasTempPath() {
    return tempPath != null;
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
        }
      } catch (IOException e) {
      }
    }
  }
}