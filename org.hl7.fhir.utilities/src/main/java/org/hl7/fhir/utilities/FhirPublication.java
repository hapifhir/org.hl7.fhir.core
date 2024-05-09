package org.hl7.fhir.utilities;

/**
 * This enumeration is special, and hand crafted. It only supports a subset of the actual published FHIR versions, those that are still supported.
 * @author graha
 *
 */
public enum FhirPublication {
  NULL,
  DSTU1,
  DSTU2,
  DSTU2016May,
  STU3,
  R4,
  R4B,
  R5,
  R6;

  public static FhirPublication fromCode(String v) {
    if (VersionUtilities.isR2Ver(v))
      return FhirPublication.DSTU2;
    if (VersionUtilities.isR2BVer(v))
      return FhirPublication.DSTU2016May;
    if (VersionUtilities.isR3Ver(v))
      return FhirPublication.STU3;
    if (VersionUtilities.isR4Ver(v))
      return FhirPublication.R4;
    if (VersionUtilities.isR4BVer(v))
      return FhirPublication.R4B;
    if (VersionUtilities.isR5Ver(v))
      return FhirPublication.R5; 
    if (VersionUtilities.isR6Ver(v))
      return FhirPublication.R6; 
    return null;
  }

  public String toCode() {
    switch (this) {
    case DSTU1: return "0.01";
    case DSTU2: return "1.0.2";
    case DSTU2016May: return "1.4.0";
    case STU3: return "3.0.2";
    case R4: return "4.0.1";
    case R4B: return "4.3.0";
    case R5: return "5.0.0";
    case R6: return "6.0.0";
    default:
      return "??";
    }
  }


}