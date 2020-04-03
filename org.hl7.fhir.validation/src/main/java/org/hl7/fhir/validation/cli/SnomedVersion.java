package org.hl7.fhir.validation.cli;

import java.util.Arrays;
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

  public static String resolveSnomedCTCode(String s) {
    String foundCode;
    Optional<SnomedVersion> opt = Arrays.stream(values())
      .filter(v -> v.lang.equals(s))
      .findFirst();
    if (opt.isPresent()) {
      return opt.get().code;
    } else {
      throw new Error("Snomed edition '" + s + "' not known");
    }
  }
}
