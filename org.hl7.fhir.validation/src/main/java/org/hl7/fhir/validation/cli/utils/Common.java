package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;

import javax.annotation.Nonnull;

public class Common {

  public static String getVersion(String[] args) {
    String v = Params.getParam(args, "-version");
    if (v == null) {
      v = "5.0";
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
    } else if (VersionUtilities.isR2Ver(v)) {
      v = "1.0";
    } else if (VersionUtilities.isR2BVer(v)) {
      v = "1.4";
    } else if (VersionUtilities.isR3Ver(v)) {
      v = "3.0";
    } else if (VersionUtilities.isR4Ver(v)) {
      v = "4.0";
    } else if (VersionUtilities.isR4BVer(v)) {
      v = "4.3";
    } else if (VersionUtilities.isR5Ver(v)) {
      v = "5.0";
    } else if (VersionUtilities.isR6Ver(v)) {
      v = "6.0";
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
      defaultValue = "5.0";
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
      defaultValue = "5.0";
    } else if (igFileName.startsWith("hl7.fhir.r6.core#") || igFileName.equals("hl7.fhir.r6.core")) {
      defaultValue = "6.0";
    }
    return defaultValue;
  }

  @Nonnull
  public static String getValidatorUserAgent() {
    return "fhir/validator/" + VersionUtil.getVersion();
  }

  public static boolean isNetworkPath(String path) {
    return path.startsWith("https:") || path.startsWith("http:");
  }

  public static boolean isWildcardPath(String name) {
    return name.contains("*");
  }

}