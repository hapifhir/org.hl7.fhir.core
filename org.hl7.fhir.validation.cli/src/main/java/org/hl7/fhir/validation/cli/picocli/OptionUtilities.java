package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;

public class OptionUtilities {

  public static String getFirstNameForField(Class clazz, String fieldName) {
    try {
      return clazz.getField(fieldName).getAnnotation(CommandLine.Option.class).names()[0];
    } catch (NoSuchFieldException e) {
      return null;
    }
  }

}
