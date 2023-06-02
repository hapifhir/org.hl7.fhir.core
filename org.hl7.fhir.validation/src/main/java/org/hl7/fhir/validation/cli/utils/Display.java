package org.hl7.fhir.validation.cli.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

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
    System.out.println("  Paths:  Current = " + System.getProperty("user.dir") + ", Package Cache = " + new FilesystemPackageCacheManager(org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER).getFolder());
    System.out.print("  Params:");
    for (String s : args) {
      System.out.print(s.contains(" ") ? " \"" + s + "\"" : " " + s);
    }
    System.out.println();
  }

  final static String CURLY_START = "\\{\\{";
  final static String CURLY_END = "\\}\\}";

  final static String getMoustacheString(final String string) {
    return CURLY_START + string + CURLY_END;
  }

  final static String[][] PLACEHOLDERS = {
    { getMoustacheString("XML_AND_JSON_FHIR_VERSIONS"), "1.0, 1.4, 3.0, 4.0," + Constants.VERSION_MM },
    { getMoustacheString("TURTLE_FHIR_VERSIONS"), "3.0, 4.0, " + Constants.VERSION_MM },
  };

  final static String replacePlaceholders(final String input, final String[][] placeholders) {
    String output = input;
    for (String[] placeholder : placeholders) {
      output = output.replaceAll(placeholder[0], placeholder[1]);
    }
    return output;
  }

  /**
   * Loads the help details from resources/help.txt, and displays them on the command line to the user.
   * @param file
   */
  public static void displayHelpDetails(String file) {
    ClassLoader classLoader = Display.class.getClassLoader();
    InputStream help = classLoader.getResourceAsStream(file);
    try {
      String data = IOUtils.toString(help, "UTF-8");

      System.out.println(replacePlaceholders(data, PLACEHOLDERS));
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