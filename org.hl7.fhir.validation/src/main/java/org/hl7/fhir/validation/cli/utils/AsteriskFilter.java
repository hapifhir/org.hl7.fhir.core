package org.hl7.fhir.validation.cli.utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class AsteriskFilter implements FilenameFilter {


  String dir;
  String regex;

  public AsteriskFilter(String filter) throws IOException {
    if (!filter.matches("(.*(\\\\|\\/))*(.*)\\*(.*)"))
      throw new IOException("Filter names must have the following syntax: [directorypath][prefix]?*[suffix]?   I.e. The asterisk must be in the filename, not the directory path");
    dir = filter.replaceAll("(.*(\\\\|\\/))*(.*)\\*(.*)", "$1");
    String expression = filter.replaceAll("(.*(\\\\|\\/))*(.*)", "$3");
    regex = "";
    for (int i = 0; i < expression.length(); i++) {
      if (Character.isAlphabetic(expression.codePointAt(i)) || Character.isDigit(expression.codePointAt(i)))
        regex = regex + expression.charAt(i);
      else if (expression.charAt(i) == '*')
        regex = regex + ".*";
      else
        regex = regex + "\\" + expression.charAt(i);
    }
    isDirValid();
  }

  protected void isDirValid() throws IOException {
    File f = new File(dir);
    if (!f.exists()) {
      throw new IOException("Directory " + dir + " does not exist");
    }
    if (!f.isDirectory()) {
      throw new IOException("Directory " + dir + " is not a directory");
    }
  }

  public boolean accept(File dir, String s) {
    return s.matches(regex);
  }

  public String getDir() {
    return dir;
  }
}