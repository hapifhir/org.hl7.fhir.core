package org.hl7.fhir.r5.terminologies.utilities;

import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.utilities.VersionUtilities;

import java.security.AlgorithmParameterGenerator;

public enum VersionAlgorithm {
  Unknown, SemVer, Integer, Alpha, Date, Natural;

  public static VersionAlgorithm fromType(DataType dt) {
    if (dt == null) {
      return Unknown;
    }
    if (dt instanceof Coding) {
      return VersionAlgorithm.fromString(((Coding) dt).getCode());
    } else if (dt.isPrimitive()) {
      return VersionAlgorithm.fromString(dt.primitiveValue());
    } else {
      return Unknown;
    }
  }

  private static VersionAlgorithm fromString(String code) {
    if (code == null) {
      return Unknown;
    }
    switch (code) {
      case "semver": return SemVer;
      case "integer": return Integer;
      case "alpha" : return Alpha;
      case "date": return Date;
      case "natural": return Natural;
      default: return Unknown;
    }
  }

  public static VersionAlgorithm guessFormat(String result) {
    if (VersionUtilities.isSemVerWithWildcards(result)) {
      return SemVer;
    }
    return Alpha;

  }
}
