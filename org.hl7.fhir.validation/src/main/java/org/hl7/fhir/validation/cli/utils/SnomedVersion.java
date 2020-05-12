package org.hl7.fhir.validation.cli.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum SnomedVersion {
  INTL("intl", "900000000000207008"),
  US("us", "731000124108"),
  UK("uk", "999000041000000102"),
  AU("au", "32506021000036107"),
  CA("ca", "20611000087101"),
  NL("nl", "11000146104"),
  SE("se", "45991000052106"),
  ES("es", "449081005"),
  DK("dk", "554471000005108");

  private static final String DEFAULT_CODE = "900000000000207008";

  private final String lang;
  private final String code;

  SnomedVersion(String lang, String code) {
    this.lang = lang;
    this.code = code;
  }

  public String getLang() {
    return lang;
  }

  public String getCode() {
    return code;
  }

  public static SnomedVersion getFromCode(String code) {
    return lookup.get(code);
  }

  private static final Map<String, SnomedVersion> lookup = new HashMap<>();

  static {
    for (SnomedVersion s : SnomedVersion.values()) {
      lookup.put(s.getCode(), s);
    }
  }
}