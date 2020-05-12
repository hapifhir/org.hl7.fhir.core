package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.FhirPublication;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.ValidationEngine;

public class Common {

  public static String getVersion(String[] args) {
    String v = Params.getParam(args, "-version");
    if (v == null) {
      v = "current";
      for (int i = 0; i < args.length; i++) {
        if ("-ig".equals(args[i])) {
          if (i + 1 == args.length)
            throw new Error("Specified -ig without indicating ig file");
          else {
            String n = args[i + 1];
            v = Common.getVersionFromIGName(v, n);
          }
        }
      }
    } else if ("1.0".equals(v)) {
      v = "1.0";
    } else if ("1.4".equals(v)) {
      v = "1.4";
    } else if ("3.0".equals(v)) {
      v = "3.0";
    } else if ("4.0".equals(v)) {
      v = "4.0";
    } else if (v.startsWith(Constants.VERSION)) {
      v = "current";
    }
    return v;
  }

  /**
   * Evaluates the current implementation guide file name and sets the current version accordingly.
   * <p>
   * If igFileName is not one of the known patterns, will return whatever value is passed in as default.
   *
   * @param defaultValue Version to return if no associated version can be determined from passed in igFileName
   * @param igFileName   Name of the implementation guide
   * @return
   */
  public static String getVersionFromIGName(String defaultValue, String igFileName) {
    if (igFileName.equals("hl7.fhir.core")) {
      defaultValue = "current";
    } else if (igFileName.startsWith("hl7.fhir.core#")) {
      defaultValue = VersionUtilities.getCurrentPackageVersion(igFileName.substring(14));
    } else if (igFileName.startsWith("hl7.fhir.r2.core#") || igFileName.equals("hl7.fhir.r2.core")) {
      defaultValue = "1.0";
    } else if (igFileName.startsWith("hl7.fhir.r2b.core#") || igFileName.equals("hl7.fhir.r2b.core")) {
      defaultValue = "1.4";
    } else if (igFileName.startsWith("hl7.fhir.r3.core#") || igFileName.equals("hl7.fhir.r3.core")) {
      defaultValue = "3.0";
    } else if (igFileName.startsWith("hl7.fhir.r4.core#") || igFileName.equals("hl7.fhir.r4.core")) {
      defaultValue = "4.0";
    } else if (igFileName.startsWith("hl7.fhir.r5.core#") || igFileName.equals("hl7.fhir.r5.core")) {
      defaultValue = "current";
    }
    return defaultValue;
  }

  /**
   * Triggers the validation engine tests to run.
   */
  public static void runValidationEngineTests() {
    try {
      Class<?> clazz = Class.forName("org.hl7.fhir.validation.r5.tests.ValidationEngineTests");
      clazz.getMethod("execute").invoke(clazz);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ValidationEngine getValidationEngine(String version, String definitions, String txLog) throws Exception {
    System.out.println("Loading (v = " + version + ", tx server http://tx.fhir.org)");
    return new ValidationEngine(definitions, "http://tx.fhir.org", txLog, FhirPublication.fromCode(version), version);
  }

}