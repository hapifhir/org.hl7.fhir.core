package org.hl7.fhir.validation.service.utils;

import org.hl7.fhir.utilities.VersionUtil;

import javax.annotation.Nonnull;

public class Common {

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