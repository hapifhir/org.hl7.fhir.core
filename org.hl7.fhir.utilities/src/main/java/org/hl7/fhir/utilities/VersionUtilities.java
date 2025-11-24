package org.hl7.fhir.utilities;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.

 */


public class VersionUtilities {

  public enum VersionPrecision { MAJOR, MINOR, PATCH, FULL}

  public static class SemVerSorter implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
      return compareVersions(s1, s2);
    }

  }

  public static class SemVer {
    private String major;
    private String minor;
    private String patch;
    private String label;

    public SemVer(String ver) {
      String[] p = ver.split("\\.");
      if (p.length > 0) {
        major = p[0];
      }
      if (p.length > 1) {
        minor = p[1];
      }
      if (p.length > 2) {
        patch = p[2];
        if (patch.contains("-")) {
          label = patch.substring(patch.indexOf("-") + 1);
          patch = patch.substring(0, patch.indexOf("-"));
        }
      }
    }

    private int compareString(String s1, String s2) {
      if (s1 == null) {
        return s2 == null ? 0 : 1;
      } else if (s2 == null) {
        return -1;
      } else {
        return s1.compareTo(s2);
      }
    }


    private int compareInteger(String s1, String s2) {
      if (s1 == null) {
        return s2 == null ? 0 : 1;
      } else if (s2 == null) {
        return -1;
      } else {
        return Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
      }
    }

    public int compareTo(SemVer sv2) {
      int c = compareInteger(major, sv2.major);
      if (c == 0) {
        c = compareInteger(minor, sv2.minor);
      }
      if (c == 0) {
        c = compareInteger(patch, sv2.patch);
      }
      if (c == 0) {
        c = compareString(label, sv2.label);
      }
      return c;
    }

  }

  public static final String[] SUPPORTED_MAJOR_VERSIONS = {"1.0", "1.4", "3.0", "4.0", "5.0", "6.0"};
  public static final String[] SUPPORTED_VERSIONS = {"1.0.2", "1.4.0", "3.0.2", "4.0.1", "4.1.0", "4.3.0", "5.0.0", "6.0.0"};

  public static class VersionURLInfo {
    private String version;
    private String url;

    public VersionURLInfo(String version, String url) {
      super();
      this.version = version;
      this.url = url;
    }

    public String getVersion() {
      return version;
    }

    public String getUrl() {
      return url;
    }
  }

  /**
   * Returns the package name for the given FHIR version.
   * @param v FHIR version string
   * @return package name (e.g., "hl7.fhir.r4.core") or null if version not recognized
   */
  public @Nonnull static String packageForVersion(@Nonnull String v) {
    if (isR2Ver(v)) {
      return "hl7.fhir.r2.core";
    }
    if (isR2BVer(v)) {
      return "hl7.fhir.r2b.core";
    }
    if (isR3Ver(v)) {
      return "hl7.fhir.r3.core";
    }
    if (isR4Ver(v)) {
      return "hl7.fhir.r4.core";
    }

    if (isR4BVer(v)) {
      return "hl7.fhir.r4b.core";
    }

    if (isR5Ver(v)) {
      return "hl7.fhir.r5.core";
    }

    if (isR6Ver(v)) {
      return "hl7.fhir.r6.core";
    }

    if ("current".equals(v)) {
      return "hl7.fhir.r5.core";
    }

    return null;
  }

  /**
   * Returns the current/latest version for a given FHIR version family.
   * @param v FHIR version string
   * @return current version string for that family
   */
  public static String getCurrentVersion(String v) {
    if (isR2Ver(v)) {
      return "1.0.2";
    }
    if (isR2BVer(v)) {
      return "1.4.0";
    }
    if (isR3Ver(v)) {
      return "3.0.2";
    }
    if (isR4Ver(v)) {
      return "4.0.1";
    }
    if (isR4BVer(v)) {
      return "4.3.0";
    }
    if (isR5Ver(v)) {
      return "5.0.0";
    }
    if (isR6Ver(v)) {
      return "6.0.0-ballot3";
    }
    return v;
  }

  /**
   * Returns the current package version for a given FHIR version family.
   * @param v FHIR version string
   * @return package version (major.minor format)
   */
  public static String getCurrentPackageVersion(String v) {
    if (isR2Ver(v)) {
      return "1.0";
    }
    if (isR2BVer(v)) {
      return "1.4";
    }
    if (isR3Ver(v)) {
      return "3.0";
    }
    if (isR4Ver(v)) {
      return "4.0";
    }
    if (isR5Ver(v)) {
      return "5.0";
    }
    if (isR6Ver(v)) {
      return "6.0";
    }
    return v;
  }

  /**
   * Checks if the given version is in the list of supported FHIR versions.
   * @param version version string to check
   * @return true if version is supported
   */
  public static boolean isSupportedVersion(@Nonnull String version) {
    version = checkVersionNotNullAndValid(removeLabels(fixForSpecialValue(version)));
    return Utilities.existsInList(version, SUPPORTED_VERSIONS);
  }

  /**
   * Returns a comma-separated list of all supported FHIR versions.
   * @return string listing supported versions
   */
  public static String listSupportedVersions() {
    return listVersions(SUPPORTED_VERSIONS);
  }

  /**
   * Returns a comma-separated list of all supported major FHIR versions.
   * @return string listing supported major versions
   */
  public static String listSupportedMajorVersions() {
    return listVersions(SUPPORTED_MAJOR_VERSIONS);
  }

  private static String listVersions(String[] versions) {
    StringJoiner stringJoiner = new StringJoiner(", ");
    for (String supportedVersion : versions) {
      stringJoiner.add(supportedVersion);
    }
    return stringJoiner.toString();
  }

  /**
   * returns true if version refers to any R6 release (including rX/RX variants)
   */
  public static boolean isR6Plus(String version) {
    return isR6Ver(version);
  }

  /**
   * Checks if version refers to any R6 release.
   * @param version version string to check
   * @return true if R6 version
   */
  public static boolean isR6Ver(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("6.0"));
  }

  /**
   * returns true if version refers to any R5 release (including pre-release versions starting from 4.5) (including rX/RX variants)
   */
  public static boolean isR5Plus(String version) {
    return isR5Ver(version) || isR6Plus(version);
  }

  /**
   * Checks if version refers to any R5 release (including 4.5+ pre-releases).
   * @param version version string to check
   * @return true if R5 version
   */
  public static boolean isR5Ver(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("4.5") || version.startsWith("5.0"));
  }

  /**
   * Checks if version refers to any R4B release.
   * @param version version string to check
   * @return true if R4B version
   */
  public static boolean isR4BVer(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("4.1") || version.startsWith("4.3"));
  }

  /**
   * Checks if version refers to any R4 release (including 3.2+ pre-releases).
   * @param version version string to check
   * @return true if R4 version
   */
  public static boolean isR4Ver(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("4.0")
      // pre-release versions
      || version.startsWith("3.2") || version.startsWith("3.3") || version.startsWith("3.5") || version.startsWith("3.5a")); // todo: 3.5a is not legal :-(
  }

  /**
   * returns true if version refers to any R4 release (including pre-release versions starting from 3.2) (including rX/RX variants)
   */
  public static boolean isR4Plus(String version) {
    return isR4Ver(version) || isR4BVer(version) || isR5Plus(version);
  }

  /**
   * Checks if version refers to any R3 release.
   * @param version version string to check
   * @return true if R3 version
   */
  public static boolean isR3Ver(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("3.0"));
  }

  /**
   * Checks if version refers to any R2B release.
   * @param version version string to check
   * @return true if R2B version
   */
  public static boolean isR2BVer(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("1.4"));
  }

  /**
   * Checks if version refers to any R2 release.
   * @param version version string to check
   * @return true if R2 version
   */
  public static boolean isR2Ver(@Nonnull String version) {
    version = removeLabels(checkVersionValidWildcards(fixForSpecialValue(version)));
    return version != null && (version.startsWith("1.0"));
  }

  /**
   * Checks if the given string is a FHIR core package name.
   * @param s package name to check
   * @return true if it's a core package
   */
  public static boolean isCorePackage(@Nonnull String s) {
    if (s == null) {
      return false;
    }
    if (s.contains("#")) {
      s = s.substring(0, s.indexOf("#"));
    }
    return Utilities.existsInList(s, "hl7.fhir.core", "hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core", "hl7.fhir.r4.core", "hl7.fhir.r4b.core", "hl7.fhir.r5.core", "hl7.fhir.r6.core");
  }

  /**
   * Returns version string with labels (pre-release/build info) removed.
   * @param version version string
   * @return version without labels, or null if invalid
   */
  public static @Nullable String versionWithoutLabels(@Nullable String version) {
    version = checkVersionNotNullAndValid(fixForSpecialValue(version));
    return removeLabels(version);
  }

  /**
   * given any valid semver string, returns major.minor. Also accepts the special values rX/RX where X is a major FHIR version (2,2B,3,4,4B,5,6)
   *
   * returns null if not a valid semver
   */
  public static @Nullable String getMajMin(@Nullable String version) {
    version = removeLabels(fixForSpecialValue(version));
    if (version == null) {
      return null;
    }
    if (!isSemVer(version)) {
      return null;
    }
    return getMajMinPriv(version);
  }

  private static String getMajMinPriv(String version) {
    String[] p = version.split("\\.");
    return p[0] + "." + p[1];
  }

  /**
   * given any valid semver string, returns major.minor.patch. Also accepts the special values rX/RX where X is a major FHIR version (2,2B,3,4,4B,5,6)
   *
   * if there's no patch, it will be assumed to be 0
   *
   * returns null if it's not a valid semver
   */
  public static String getMajMinPatch(@Nullable String version) {
    version = removeLabels(fixForSpecialValue(version));
    if (version == null) {
      return null;
    }
    if (!isSemVer(version)) {
      return null;
    }
    String[] p = version.split("\\.");
    return p[0] + "." + p[1] + (p.length >= 3 ? "." + p[2] : ".0");
  }

  /**
   * given any valid semver string, returns just the patch version, with no labels. Also accepts the special values rX/RX where X is a major FHIR version (2,2B,3,4,4B,5,6)
   */
  public static String getPatch(@Nullable String version) {
    version = removeLabels(checkVersionValid(fixForSpecialValue(version)));
    if (version == null)
      return null;
    return getPatchPriv(version);
  }

  private static String getPatchPriv(String version) {
    String[] p = version.split("\\.");
    return p.length >= 3 ? p[2] : "0";
  }


  /**
   * returns true if this is a valid semver.
   *
   * Note that we accept major.minor without a patch (but maybe with labels).
   *
   * This routine does not accept the codes such as RX
   */
  public static boolean isSemVer(@Nullable String version) {
    if (Utilities.noString(version)) {
      return false;
    }
    // this used to be done with a regex, but it's actually too complicated to handle the corner cases that way
    SemverParser.ParseResult pr = SemverParser.parseSemver(version, false, false);
    if (!pr.isSuccess()) {
      return false;
    }
    return Utilities.isInteger(pr.getMajor()) && Utilities.isInteger(pr.getMinor())
      && (pr.getPatch() == null || Utilities.isInteger(pr.getPatch()));
  }

  /**
   * Checks if version string is valid semver with wildcard support.
   * @param version version string to validate
   * @return true if valid semver with wildcards
   */
  public static boolean isSemVerWithWildcards(@Nullable String version) {
    if (Utilities.noString(version)) {
      return false;
    }
    SemverParser.ParseResult pr = SemverParser.parseSemver(version, true, false);
    if (!pr.isSuccess()) {
      return false;
    }
    return Utilities.isInteger(pr.getMajor()) && isIntegerOrX(pr.getMinor())
      && (pr.getPatch() == null || isIntegerOrX(pr.getPatch()));
  }

  private static boolean isIntegerOrX(String p) {
    return Utilities.existsInList(p, "x", "*", "X") || Utilities.isInteger(p);
  }

  /**
   * Returns true if the version string contains any wildcard characters.
   * Supported wildcards are: * (asterisk) anywhere, x/X (in major/minor/patch only), and ? (question mark suffix).
   * Note: x and X are only wildcards in version number parts, not in release labels (after -) or build labels (after +).
   *
   * @param version version string to check
   * @return true if version contains any wildcard characters, false otherwise
   */
  public static boolean versionHasWildcards(@Nullable String version) {
    if (Utilities.noString(version)) {
      return false;
    }

    // Check for ? suffix wildcard
    if (version.endsWith("?")) {
      return true;
    }

    // Check for * wildcard anywhere
    if (version.contains("*")) {
      return true;
    }

    // For x/X wildcards, we need to check only the version number parts (before any - or +)
    String versionPart = version;
    int dashIndex = version.indexOf('-');
    int plusIndex = version.indexOf('+');

    if (dashIndex >= 0 && plusIndex >= 0) {
      versionPart = version.substring(0, Math.min(dashIndex, plusIndex));
    } else if (dashIndex >= 0) {
      versionPart = version.substring(0, dashIndex);
    } else if (plusIndex >= 0) {
      versionPart = version.substring(0, plusIndex);
    }

    // Check for x/X wildcards only in the version number part
    return versionPart.contains("x") || versionPart.contains("X");
  }

  /**
   * return true if the current version equals criteria, or later, based on the degree of precision specified
   *
   * This can be used to check e.g. if a feature is defined in 4.0, if (VersionUtilities.isThisOrLater("4.0", version))
   *
   * this is only applicable to valid semver versions (though patch is optional)
   *
   * the criteria string can contain wildcards - see @versionMatches
   *
   * @param criteria    The value to compare to
   * @param candidate The value being compared
   * @param precision how far into the version string to consider (usually just set to full if there's wildcards in the test string)
   *
   * @return Is {@literal current} later or equal to {@literal criteria}? For example, if <code>this = 0.5</code> and <code>current = 0.6</code> this method will return true
   */
  public static boolean isThisOrLater(@Nonnull String criteria, @Nonnull String candidate, VersionPrecision precision) {
    criteria = checkVersionNotNullAndValidWildcards(fixForSpecialValue(criteria), "criteria");
    candidate = checkVersionNotNullAndValid(fixForSpecialValue(candidate), "candidate");

    boolean endsWithQ = false;
    if (criteria.endsWith("?")) {
      endsWithQ = true;
      criteria = criteria.substring(0, criteria.length() - 1);
    }
    SemverParser.ParseResult parsedCriteria = SemverParser.parseSemver(criteria, true, false);
    if (!parsedCriteria.isSuccess()) {
      throw new FHIRException("Invalid criteria: " + criteria+": ("+parsedCriteria.getError()+")");
    }
    SemverParser.ParseResult parsedCandidate = SemverParser.parseSemver(candidate, false, false);
    if (!parsedCandidate.isSuccess()) {
      throw new FHIRException("Invalid candidate: " + candidate+" ("+parsedCandidate.getError()+")");
    }
    int thisOrLater;
    thisOrLater = partIsThisOrLater(parsedCriteria.getMajor(), parsedCandidate.getMajor(), true);
    if (thisOrLater != 0) { return thisOrLater < 0 ?  true : false; }
    if (endsWithQ && parsedCriteria.getMinor() == null) { return true; }
    if (precision == VersionPrecision.MAJOR) { return true; }
    thisOrLater = partIsThisOrLater(parsedCriteria.getMinor(), parsedCandidate.getMinor(), true);
    if (thisOrLater != 0) { return thisOrLater < 0 ?  true : false; }
    if (endsWithQ && parsedCriteria.getPatch() == null) { return true; }
    if (precision == VersionPrecision.MINOR) { return true; }
    thisOrLater = partIsThisOrLater(parsedCriteria.getPatch(), parsedCandidate.getPatch(), true);
    if (thisOrLater != 0) { return thisOrLater < 0 ?  true : false; }
    if (precision == VersionPrecision.PATCH) { return true; }
    if (endsWithQ && parsedCriteria.getReleaseLabel() == null && parsedCriteria.getBuild() == null) { return true; }
    thisOrLater = partIsThisOrLater(parsedCriteria.getReleaseLabel(), parsedCandidate.getReleaseLabel(), false);
    if (thisOrLater != 0) { return thisOrLater < 0 ?  true : false; }
    thisOrLater = partIsThisOrLater(parsedCriteria.getBuild(), parsedCandidate.getBuild(), false);
    if (thisOrLater != 0) { return thisOrLater < 0 ?  true : false; }
    return true;
  }


  private static boolean compareVersionPart(String theTestPart, String theCurrentPart) {
    if (StringUtils.isNumeric(theTestPart) && StringUtils.isNumeric(theCurrentPart)) {
      return Integer.parseInt(theCurrentPart) - Integer.parseInt(theTestPart) >= 0;
    } else {
      return theCurrentPart.compareTo(theTestPart) >= 0;
    }
  }

  private static int compareVersionPartInt(String theTestPart, String theCurrentPart) {
    if (StringUtils.isNumeric(theTestPart) && StringUtils.isNumeric(theCurrentPart)) {
      return Integer.parseInt(theCurrentPart) - Integer.parseInt(theTestPart);
    } else {
      return theCurrentPart.compareTo(theTestPart);
    }
  }

  private static String getLabelPart(String s) {
    if (Utilities.noString(s)) {
      return null;
    }
    int p = s.indexOf("+");
    int m = s.indexOf("-");
    if (p >= 0 && m >= 0) {
      int e = Integer.min(p, m);
      return s.substring(e + 1);
    } else if (p >= 0) {
      return s.substring(p + 1);
    } else if (m >= 0) {
      return s.substring(m + 1);
    } else {
      return null;
    }
  }

  /**
   * given any semver, increment the major version and reset the minor and patch to .0.0, and remove any labels
   */
  public static String incMajorVersion(String v) {
    v = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(v)));
    int[] parts = splitParts(removeLabels(v));
    return Integer.toString(parts[0] + 1) + ".0.0";
  }

  /**
   * given any semver, increment the minor version and reset the patch to .0 and remove any labels
   */
  public static @Nonnull String incMinorVersion(@Nonnull String v) {
    v = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(v)));
    int[] parts = splitParts(removeLabels(v));
    return Integer.toString(parts[0]) + "." + (parts.length == 1 ? "0.0" : Integer.toString(parts[1] + 1) + ".0");
  }

  /**
   * given any semver, increment the patch and remove any labels
   */
  public static @Nonnull String incPatchVersion(@Nonnull String v) {
    v = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(v)));
    int[] parts = splitParts(v);
    return Integer.toString(parts[0]) + "." +
      (parts.length < 2 ? "0" : Integer.toString(parts[1])) + "." +
      (parts.length < 3 ? "1" : Integer.toString(parts[2] + 1));
  }

  private static int[] splitParts(String v) {
    String[] p = v.split("\\.");
    return Arrays.stream(p).mapToInt(Integer::parseInt).toArray();
  }

  /**
   * Converts version code to standard version string.
   * @param version version code or string
   * @return standardized version string
   */
  public static String versionFromCode(String version) {
    return checkVersionNotNullAndValid(fixForSpecialValue(version));
  }

  /**
   * Parses version information from a FHIR URL.
   * @param url FHIR URL to parse
   * @return VersionURLInfo object or null if not parseable
   */
  public static VersionURLInfo parseVersionUrl(String url) {
    if (url.length() < 24) {
      return null;
    }
    String v = url.substring(20, 24);
    if (v.endsWith("/")) {
      v = v.substring(0, v.length() - 1);
      if (Utilities.existsInList(v, "1.0", "1.4", "3.0", "4.0", "5.0", "6.0")) {
        return new VersionURLInfo(v, "http://hl7.org/fhir/" + url.substring(24));
      }
    }
    return null;
  }


  /**
   * same as getCanonicalResourceNames but add R5 supported types that are canonical too
   */
  public static Set<String> getExtendedCanonicalResourceNames(String version) {
    Set<String> res = getCanonicalResourceNames(version);
    if (isR4Ver(version)) {
      res.add("ActorDefinition");
      res.add("Requirements");
      res.add("SubscriptionTopic");
      res.add("TestPlan");
    }
    return res;
  }

  /**
   * Returns set of canonical resource names for the given FHIR version.
   * @param version FHIR version string
   * @return set of canonical resource type names
   */
  public static Set<String> getCanonicalResourceNames(String version) {

    Set<String> res = new HashSet<String>();
    if (isR2Ver(version) || isR2BVer(version)) {
      res.add("ValueSet");
      res.add("ConceptMap");
      res.add("NamingSystem");
      res.add("StructureDefinition");
      res.add("DataElement");
      res.add("Conformance");
      res.add("OperationDefinition");
      res.add("SearchParameter");
      res.add("ImplementationGuide");
      res.add("TestScript");
    }
    if (isR3Ver(version)) {
      res.add("CodeSystem");
      res.add("CapabilityStatement");
      res.add("StructureDefinition");
      res.add("ImplementationGuide");
      res.add("SearchParameter");
      res.add("MessageDefinition");
      res.add("OperationDefinition");
      res.add("CompartmentDefinition");
      res.add("StructureMap");
      res.add("GraphDefinition");
      res.add("DataElement");
      res.add("CodeSystem");
      res.add("ValueSet");
      res.add("ConceptMap");
      res.add("ExpansionProfile");
      res.add("Questionnaire");
      res.add("ActivityDefinition");
      res.add("ServiceDefinition");
      res.add("PlanDefinition");
      res.add("Measure");
      res.add("TestScript");

    }
    if (isR4Ver(version)) {
      res.add("CodeSystem");
      res.add("ActivityDefinition");
      res.add("CapabilityStatement");
      res.add("ChargeItemDefinition");
      res.add("CodeSystem");
      res.add("CompartmentDefinition");
      res.add("ConceptMap");
      res.add("EffectEvidenceSynthesis");
      res.add("EventDefinition");
      res.add("Evidence");
      res.add("EvidenceVariable");
      res.add("ExampleScenario");
      res.add("GraphDefinition");
      res.add("ImplementationGuide");
      res.add("Library");
      res.add("Measure");
      res.add("MessageDefinition");
      res.add("NamingSystem");
      res.add("OperationDefinition");
      res.add("PlanDefinition");
      res.add("Questionnaire");
      res.add("ResearchDefinition");
      res.add("ResearchElementDefinition");
      res.add("RiskEvidenceSynthesis");
      res.add("SearchParameter");
      res.add("StructureDefinition");
      res.add("StructureMap");
      res.add("TerminologyCapabilities");
      res.add("TestScript");
      res.add("ValueSet");
    }
    if (isR4BVer(version)) {
      res.add("ActivityDefinition");
      res.add("CapabilityStatement");
      res.add("ChargeItemDefinition");
      res.add("Citation");
      res.add("CodeSystem");
      res.add("CompartmentDefinition");
      res.add("ConceptMap");
      res.add("EventDefinition");
      res.add("Evidence");
      res.add("EvidenceReport");
      res.add("EvidenceVariable");
      res.add("ExampleScenario");
      res.add("GraphDefinition");
      res.add("ImplementationGuide");
      res.add("Library");
      res.add("Measure");
      res.add("MessageDefinition");
      res.add("NamingSystem");
      res.add("OperationDefinition");
      res.add("PlanDefinition");
      res.add("Questionnaire");
      res.add("ResearchDefinition");
      res.add("ResearchElementDefinition");
      res.add("SearchParameter");
      res.add("SpecimenDefinition");
      res.add("StructureDefinition");
      res.add("StructureMap");
      res.add("SubscriptionTopic");
      res.add("TerminologyCapabilities");
      res.add("TestScript");
      res.add("ValueSet");
    }

    if (isR5Ver(version)) {
      res.add("ActorDefinition");
      res.add("ActivityDefinition");
      res.add("CapabilityStatement");
      res.add("ChargeItemDefinition");
      res.add("Citation");
      res.add("ClinicalUseDefinition");
      res.add("CodeSystem");
      res.add("CompartmentDefinition");
      res.add("ConceptMap");
      res.add("ConditionDefinition");
      res.add("EventDefinition");
      res.add("Evidence");
      res.add("EvidenceReport");
      res.add("EvidenceVariable");
      res.add("ExampleScenario");
      res.add("GraphDefinition");
      res.add("ImplementationGuide");
      res.add("Library");
      res.add("Measure");
      res.add("MessageDefinition");
      res.add("NamingSystem");
      res.add("ObservationDefinition");
      res.add("OperationDefinition");
      res.add("PlanDefinition");
      res.add("Questionnaire");
      res.add("Requirements");
      res.add("SearchParameter");
      res.add("SpecimenDefinition");
      res.add("StructureDefinition");
      res.add("StructureMap");
      res.add("SubscriptionTopic");
      res.add("TerminologyCapabilities");
      res.add("TestPlan");
      res.add("TestScript");
      res.add("ValueSet");
    }
    if (isR6Ver(version)) {
      res.add("ActorDefinition");
      res.add("ActivityDefinition");
      res.add("CapabilityStatement");
      res.add("ChargeItemDefinition");
      res.add("Citation");
      res.add("ClinicalUseDefinition");
      res.add("CodeSystem");
      res.add("CompartmentDefinition");
      res.add("ConceptMap");
      res.add("ConditionDefinition");
      res.add("DeviceDefinition");
      res.add("EventDefinition");
      res.add("Evidence");
      res.add("EvidenceVariable");
      res.add("ExampleScenario");
      res.add("Group");
      res.add("ImplementationGuide");
      res.add("Library");
      res.add("Measure");
      res.add("MessageDefinition");
      res.add("NamingSystem");
      res.add("ObservationDefinition");
      res.add("OperationDefinition");
      res.add("PlanDefinition");
      res.add("Questionnaire");
      res.add("Requirements");
      res.add("SearchParameter");
      res.add("SpecimenDefinition");
      res.add("StructureDefinition");
      res.add("StructureMap");
      res.add("SubscriptionTopic");
      res.add("TerminologyCapabilities");
      res.add("ValueSet");
    }
    return res;
  }

  /**
   * Extracts FHIR version from package ID.
   * @param pid package ID string
   * @return version string or null if not extractable
   */
  public static String getVersionForPackage(@Nonnull String pid) {
    if (pid == null) {
      return null;
    }
    if (pid.startsWith("hl7.fhir.r")) {
      String[] p = pid.split("\\.");
      return versionFromCode(p[2]);
    }
    return null;
  }


  /**
   * returns true if v1 and v2 are both semver, and they 'match'
   *
   * matching means that the specific version provided in candidate is equal to the value
   * provided by criteria, or is in the set of values defined by the critteria using
   * applicable wildcards
   *
   * e.g.
   * 2.0 matches 2.0 and not 2.0.0, 2.0.1 etc
   * 2.0.0 matches 2.0.0 and not 2.0.1 or 2.0.0-something or 2.0.0+something
   * 2.* matches 2.0 and 2.1 but not 2.0.0 or 2.1-something
   * 2.x.x matches 2.0.1 and 2.1.0 etc but not 2.0
   * 2.0.* matches 2.0.0, 2.0.1, and not 2.0.0-something or 2.0.0+something
   * 2.0.0-* matches 2.0.0-prerelease or any other label but not 2.0.0+build
   * 2.0.0+* matches 2.0.0+build or any other build but not 2.0.0 or 2.0.0-prerelease
   * 2.0.x-* matches 2.0.1-prerelease or 2.0.1-prerelease but not 2.0.0 or 2.0.1
   * 2.0? matches 2.0, 2.0.1, 2.0.0-build etc - anything that starts with 2.0
   * 2.0.1? matches 2.0.1, 2.0.1-release, 2.0.1+build etc - anything that starts with 2.0.1
   * 2.x? matches 2.anything (weird thing to do)
   *
   * wildcard summary:
   *   * = anything that goes in this part. (x and X are also acceptable wildcards for minor and patch, but not for release or build labels, where x and X are valid values)
   *   ? = anything that goes in this part and ignore the rest of the version. Note that the ? does not follow the part separator.
   *
   */
  public static boolean versionMatches(@Nonnull String criteria, @Nonnull String candidate) {
    if (Utilities.noString(criteria)) {
      throw new FHIRException("Invalid criteria: null / empty");
    }
    if (Utilities.noString(candidate)) {
      throw new FHIRException("Invalid candidate: null / empty");
    }
    criteria = fixForSpecialValue(criteria);
    candidate = fixForSpecialValue(candidate);

    boolean endsWithQ = false;
    if (criteria.endsWith("?")) {
      endsWithQ = true;
      criteria = criteria.substring(0, criteria.length() - 1);
    }
    SemverParser.ParseResult parsedCriteria = SemverParser.parseSemver(criteria, true, false);
    if (!parsedCriteria.isSuccess()) {
      throw new FHIRException("Invalid criteria: " + criteria+": ("+parsedCriteria.getError()+")");
    }
    SemverParser.ParseResult parsedCandidate = SemverParser.parseSemver(candidate, false, false);
    if (!parsedCandidate.isSuccess()) {
      throw new FHIRException("Invalid candidate: " + candidate+" ("+parsedCandidate.getError()+")");
    }
    int pm;
    if (!partMatches(parsedCriteria.getMajor(), parsedCandidate.getMajor(), true)) { return false; }
    if (endsWithQ && parsedCriteria.getMinor() == null) { return true; }
    if (!partMatches(parsedCriteria.getMinor(), parsedCandidate.getMinor(), true)) { return false; }
    if (endsWithQ && parsedCriteria.getPatch() == null) { return true; }
    if (!partMatches(parsedCriteria.getPatch(), parsedCandidate.getPatch(), true)) { return false; }
    if (endsWithQ && parsedCriteria.getReleaseLabel() == null && parsedCriteria.getBuild() == null) { return true; }
    if (!partMatches(parsedCriteria.getReleaseLabel(), parsedCandidate.getReleaseLabel(), false)) { return false; }
    if (!partMatches(parsedCriteria.getBuild(), parsedCandidate.getBuild(), false)) { return false; }
    return true;
  }

  private static boolean partMatches(String criteria, String candidate, boolean allowX) {
    if (criteria == null) {
      return candidate == null;
    } else {
      if (allowX ? Utilities.existsInList(criteria, "*", "x", "X") : Utilities.existsInList(criteria, "*")) {
        return candidate != null;
      } else {
        return criteria.equals(candidate);
      }
    }
  }

  private static int partIsThisOrLater(String criteria, String candidate, boolean allowX) {
    if (criteria == null) {
      if (candidate == null) {
        return 0;
      } else {
        return allowX ? -1 : 1;
      }
    } else if (candidate == null) {
      return allowX ? 1 : -1;
    } else if (allowX ? Utilities.existsInList(criteria, "*", "x", "X") : Utilities.existsInList(criteria, "*")) {
      return -1;
    } else if (Utilities.isInteger(criteria) && Utilities.isInteger(candidate)) {
      return Integer.parseInt(criteria) - Integer.parseInt(candidate);
    } else {
      return criteria.compareTo(candidate);
    }
  }


  /**
   * returns true if v1 matches any v2 using the rules for @versionMatches()
   */
  public static boolean versionMatchesList(@Nonnull String v1, @Nonnull List<String> v2l) {
    for (String v2 : v2l) {
      if (versionMatches(v1, v2)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Given a canonical URL of format {url}|{version}, remove the version part
   */
  public static @Nullable String removeVersionFromCanonical(@Nullable String url) {
    if (url == null) {
      return null;
    }
    if (url.contains("|")) {
      return url.substring(0, url.indexOf("|"));
    } else {
      return url;
    }
  }

  /**
   * Returns the specification URL for the given FHIR version.
   * @param v FHIR version string
   * @return specification URL
   */
  public static String getSpecUrl(@Nonnull String v) {
    v = removeLabels(checkVersionNotNullAndValidWildcards(fixForSpecialValue(v)));
    switch (getMajMinPriv(v)) {
      case "0.0":
        return "http://hl7.org/fhir/DSTU1";
      case "1.0":
        return "http://hl7.org/fhir/DSTU2";
      case "1.4":
        return "http://hl7.org/fhir/2016May";
      case "3.0":
        return "http://hl7.org/fhir/STU3";
      case "4.0":
        return "http://hl7.org/fhir/R4";
      case "4.3":
        return "http://hl7.org/fhir/R4B";
      case "5.0":
        return "http://hl7.org/fhir/R5";
      case "6.0":
        return "http://build.fhir.org";
      default:
        return "http://hl7.org/fhir";
    }
  }

  /**
   * Returns the release name (R2, R3, etc.) for the given version.
   * @param v FHIR version string
   * @return release name (e.g., "R4", "R5")
   */
  public static @Nonnull String getNameForVersion(@Nonnull String v) {
    v = removeLabels(checkVersionNotNullAndValidWildcards(fixForSpecialValue(v)));
    switch (getMajMinPriv(v)) {
      case "1.0":
        return "R2";
      case "1.4":
        return "R2B";
      case "3.0":
        return "R3";
      case "4.0":
        return "R4";
      case "4.3":
        return "R4B";
      case "5.0":
        return "R5";
      case "6.0":
        return "R6";
      default:
        return "R?";
    }
  }

  /**
   * given version ver1 and ver2, compare them as semver strings (special values also accepted).
   * -1 means ver1 is earlier, 0 means they 'match' and 1 means ver2 is later (normal java sort order)
   */
  public static int compareVersions(@Nullable String ver1, @Nullable String ver2) {
    ver1 = checkVersionValid(fixForSpecialValue(ver1), "ver1");
    ver2 = checkVersionValid(fixForSpecialValue(ver2), "ver2");

    if (ver1 != null && ver2 != null) {
      SemverParser.ParseResult pr1 = SemverParser.parseSemver(ver1, false, false);
      SemverParser.ParseResult pr2 = SemverParser.parseSemver(ver2, false, false);
      int res = compareVersionStrings(pr1.getMajor(), pr2.getMajor(), true, false);
      if (res == 0) {
        res = compareVersionStrings(pr1.getMinor(), pr2.getMinor(), true, false);
      }
      if (res == 0) {
        res = compareVersionStrings(pr1.getPatch(), pr2.getPatch(), true, false);
      }
      if (res == 0) {
        res = compareVersionStrings(pr1.getReleaseLabel(), pr2.getReleaseLabel(), false, true);
      }
      if (res == 0) {
        res = compareVersionStrings(pr1.getBuild(), pr2.getBuild(), false, true);
      }
      return res;
    } else if (ver1 == null) {
      return ver2 == null ? 0 : -1;
    } else { // if (ver2 == null) {
      return 1;
    }
  }

  private static int compareVersionStrings(String v1, String v2, boolean asInteger, boolean inverted) {
    if (v1 == null) {
      if (v2 == null) {
        return 0;
      } else {
        return inverted ? 1 : -1;
      }
    } else if (v2 == null) {
      return inverted ? -1 : 1;
    } else if (asInteger || Utilities.isInteger(v2) && !Utilities.isInteger(v1)) {
      int r = Integer.compare(Integer.parseInt(v1), Integer.parseInt(v2));
      if (r == 0) {
        return 0;
      } else if (r < 0) {
        return -1;
      } else {
        return 1;
      }
    } else {
      int r = v1.compareTo(v2);
      if (r == 0) {
        return 0;
      } else if (r < 0) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  /**
   * true of ver is included in the range bounded by startVer and stopVer (or matches - bounds and inclusive)
   * <p>
   * Special values also accepted e.g. r3 is in r3 to r5
   *
   * @param ver
   * @return
   */
  public static boolean includedInRange(@Nonnull String startVer, @Nonnull String stopVer, @Nonnull String ver) {
    startVer = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(startVer), "startVer"));
    stopVer = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(stopVer), "stopVer"));
    ver = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(ver), "ver"));

    if (ver.equals(startVer)) {
      return true;
    }
    if (ver.equals(stopVer)) {
      return true;
    }
    return startVer.compareTo(ver) < 0 && stopVer.compareTo(ver) > 0;
  }

  /**
   * Returns the resource types URL for the given FHIR version.
   * @param version FHIR version string
   * @return resource types URL
   */
  public static String getResourceTypesUrl(@Nonnull String version) {
    if (isR5Plus(version)) {
      return "http://hl7.org/fhir/fhir-types";
    } else {
      return "http://hl7.org/fhir/resource-types";
    }
  }

  /**
   * given a range of core versions, list all the ones in the range (accepts either version of special values, returns actual versions)
   */
  public static List<String> iterateCorePublishedVersions(@Nonnull String startVer, @Nonnull String stopVer) {
    startVer = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(startVer), "startVer"));
    stopVer = removeLabels(checkVersionNotNullAndValid(fixForSpecialValue(stopVer), "stopVer"));
    List<String> result = new ArrayList<>();
    if (isThisOrLater(startVer, "1.0", VersionPrecision.MINOR) && isThisOrLater("1.0", stopVer, VersionPrecision.MINOR)) {
      result.add("1.0");
    }
    if (isThisOrLater(startVer, "3.0", VersionPrecision.MINOR) && isThisOrLater("3.0", stopVer, VersionPrecision.MINOR)) {
      result.add("3.0");
    }
    if (isThisOrLater(startVer, "4.0", VersionPrecision.MINOR) && isThisOrLater("4.0", stopVer, VersionPrecision.MINOR)) {
      result.add("4.0");
    }
    if (isThisOrLater(startVer, "4.3", VersionPrecision.MINOR) && isThisOrLater("4.3", stopVer, VersionPrecision.MINOR)) {
      result.add("4.3");
    }
    if (isThisOrLater(startVer, "5.0", VersionPrecision.MINOR) && isThisOrLater("5.0", stopVer, VersionPrecision.MINOR)) {
      result.add("5.0");
    }
    return result;
  }


  private static String removeLabels(String version) {
    if (Utilities.noString(version))
      return null;
    if (version.contains("+")) {
      version = version.substring(0, version.indexOf("+"));
    }
    if (version.contains("-")) {
      version = version.substring(0, version.indexOf("-"));
    }
    return version;
  }


  private static String checkVersionNotNullAndValid(String s) {
    if (s == null) {
      throw new FHIRException("Invalid version: null");
    } else if (!isSemVer(s)) {
      throw new FHIRException("Invalid version: '" + s + '"');
    } else {
      return s;
    }
  }

  public static String checkVersionNotNullAndValid(String s, String label) {
    if (s == null) {
      throw new FHIRException("Invalid " + label + " version: null");
    } else if (!isSemVer(s)) {
      throw new FHIRException("Invalid " + label + " version: '" + s + "'");
    } else {
      return s;
    }
  }

  private static String checkVersionNotNullAndValidWildcards(String s) {
    if (s == null) {
      throw new FHIRException("Invalid version: null");
    } else if (!isSemVerWithWildcards(s)) {
      throw new FHIRException("Invalid version: '" + s + '"');
    } else {
      return s;
    }
  }

  private static String checkVersionNotNullAndValidWildcards(String s, String label) {
    if (s == null) {
      throw new FHIRException("Invalid " + label + " version: null");
    } else if (!isSemVerWithWildcards(s)) {
      throw new FHIRException("Invalid " + label + " version: '" + s + '"');
    } else {
      return s;
    }
  }


  private static String checkVersionValid(String s) {
    if (s == null) {
      return null;
    } else if (!isSemVer(s)) {
      throw new FHIRException("Invalid version: '" + s + '"');
    } else {
      return s;
    }
  }

  private static String checkVersionValidWildcards(String s) {
    if (s == null) {
      return null;
    } else if (!isSemVerWithWildcards(s)) {
      throw new FHIRException("Invalid version: '" + s + '"');
    } else {
      return s;
    }
  }

  private static String checkVersionValid(String s, String label) {
    if (s == null) {
      return null;
    } else if (!isSemVer(s)) {
      throw new FHIRException("Invalid " + label + " version: '" + s + '"');
    } else {
      return s;
    }
  }

  private static String checkVersionNotNull(String s) {
    if (s == null) {
      throw new FHIRException("Invalid version: null");
    } else {
      return s;
    }
  }

  private static String checkVersionNotNull(String s, String label) {
    if (s == null) {
      throw new FHIRException("Invalid " + label + " version: null");
    } else {
      return s;
    }
  }

  public static String fixForSpecialValue(String version) {
    if (Utilities.noString(version)) {
      return null;
    }
    if (version.startsWith("http://hl7.org/fhir/")) {
      version = version.substring(20);
      if (version.contains("/")) {
        version = version.substring(0, version.indexOf("/"));
      }
    }

    switch (version.toUpperCase()) {
      case "R2":
        return "1.0.2";
      case "DSTU2":
        return "1.0.2";
      case "R2B":
        return "1.4.0";
      case "R3":
        return "3.0.2";
      case "STU3":
        return "3.0.2";
      case "R4":
        return "4.0.1";
      case "R4B":
        return "4.3.0";
      case "R5":
        return "5.0.0";
      case "R6":
        return "6.0.0-cibuild";
      default:
        return version;
    }
  }

}