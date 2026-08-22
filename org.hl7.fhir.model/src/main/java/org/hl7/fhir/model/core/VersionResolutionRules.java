package org.hl7.fhir.model.core;

public enum VersionResolutionRules { PACKAGE, LATEST, MANIFEST;

  public static VersionResolutionRules defaultRule() {
    return null;
  }

  public static VersionResolutionRules fromCode(String rule) {
    if (rule == null) {
      return null;
    } else {
      switch (rule) {
        case "package": return PACKAGE;
        case "latest": return LATEST;
        case "manifest": return MANIFEST;
        default:
          throw new IllegalArgumentException("Unknown VersionResolutionRules code: "+rule);
      }
    }
  }
}
