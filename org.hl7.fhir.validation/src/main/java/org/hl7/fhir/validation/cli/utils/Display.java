package org.hl7.fhir.validation.cli.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.ToolsVersion;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class for displaying output to the cli user.
 * <p>
 * TODO - Clean this up for localization
 */
public class Display {

  private static String toMB(long maxMemory) {
    return Long.toString(maxMemory / (1024 * 1024));
  }

  public static void printCliArgumentsAndInfo(String[] args) throws IOException {
    System.out.println("  Paths:  Current = " + System.getProperty("user.dir") + ", Package Cache = " + new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION).getFolder());
    System.out.print("  Params:");
    for (String s : args) {
      System.out.print(s.contains(" ") ? " \"" + s + "\"" : " " + s);
    }
    System.out.println();
  }

  /**
   * Loads the help details from resources/help.txt, and displays them on the command line to the user.
   */
  public static void displayHelpDetails() {
    ClassLoader classLoader = Display.class.getClassLoader();
    InputStream help = classLoader.getResourceAsStream("help.txt");
    try {
      String data = IOUtils.toString(help, "UTF-8");
      System.out.println(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Prints out system info to the command line.
   */
  public static void displaySystemInfo() {
    System.out.println("  Java:   " + System.getProperty("java.version")
      + " from " + System.getProperty("java.home")
      + " on " + System.getProperty("os.arch")
      + " (" + System.getProperty("sun.arch.data.model") + "bit). "
      + toMB(Runtime.getRuntime().maxMemory()) + "MB available");
  }

  /**
   * Prints current version of the validator.
   */
  public static void displayVersion() {
    System.out.println("FHIR Validation tool " + VersionUtil.getVersionString());
  }
}