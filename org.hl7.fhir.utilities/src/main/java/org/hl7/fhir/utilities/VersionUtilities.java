package org.hl7.fhir.utilities;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;

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
  
  public static String packageForVersion(String v) {
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
    if (isR5Ver(v)) {
      return "5.0.0";
    }
    if (isR6Ver(v)) {
      return "6.0.0";
    }
    return v;
  }

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

  public static boolean isSupportedVersion(String version) {
    if (version.contains("-")) {
      version = version.substring(0, version.indexOf("-"));
    }
    return Utilities.existsInList(version, SUPPORTED_VERSIONS);
  }

  public static String listSupportedVersions() {
    return listVersions(SUPPORTED_VERSIONS);
  }

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

  public static boolean isR6Ver(String ver) {
    return ver != null && (ver.startsWith("6.0"));
  }

  public static boolean isR5Ver(String ver) {
    return ver != null && (ver.startsWith("5.0"));
  }

  public static boolean isR4BVer(String ver) {
    return ver != null && (ver.startsWith("4.1") || ver.startsWith("4.3"));
  }

  public static boolean isR4Ver(String ver) {
    return ver != null && ver.startsWith("4.0");
  }

  public static boolean isR3Ver(String ver) {
    return ver != null && ver.startsWith("3.0");
  }

  public static boolean isR2BVer(String ver) {
    return ver != null && ver.startsWith("1.4");
  }

  public static boolean isR2Ver(String ver) {
    return ver != null && ver.startsWith("1.0");
  }

  public static boolean versionsCompatible(String v1, String v2) {
    if (v1 == null || v2 == null) {
      return false;
    }
    String[] v1l = v1.split("\\|"); 
    String[] v2l = v2.split("\\|");
    for (String vs1 : v1l) {
      for (String vs2 : v2l) {
        String mm1 = getMajMin(vs1);
        String mm2 = getMajMin(vs2);
        if (mm1 == null || mm2 == null) {
          return false;
        } else {
          if (mm1.equals(mm2)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean isCorePackage(String s) {
    if (s.contains("#")) {
      s = s.substring(0, s.indexOf("#"));
    }
    return Utilities.existsInList(s, "hl7.fhir.core","hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core", "hl7.fhir.r4.core", "hl7.fhir.r4b.core", "hl7.fhir.r5.core", "hl7.fhir.r6.core");
  }

  public static String getMajMin(String version) {
    if (version == null)
      return null;
    
    if (Utilities.charCount(version, '.') == 1) {
      String[] p = version.split("\\.");
      return p[0]+"."+p[1];
    } else if (Utilities.charCount(version, '.') == 2) {
      String[] p = version.split("\\.");
      return p[0]+"."+p[1];
    } else if (Utilities.existsInList(version, "R2", "R2B", "R3", "R4", "R4B", "R5", "R6")) {
      switch (version) {
      case "R2": return "1.0";
      case "R2B": return "1.4";
      case "R3": return "3.0";
      case "R4": return "4.0";
      case "R4B": return "4.3";
      case "R5": return "5.0";
      case "R6": return "6.0";
      }
    }  
    return null;
  }

  public static String getPatch(String version) {
    if (version == null)
      return null;
    if (Utilities.charCount(version, '.') == 2) {
      String[] p = version.split("\\.");
      return p[2];  
    }
    return null;
  }

  public static boolean isSemVer(String version) {
    if (Utilities.charCount(version, '.') != 2) {
      return false;
    }
    String[] p = version.split("\\.");
    if (p[2].contains("-")) {
      p[2] = p[2].substring(0, p[2].indexOf("-"));
    }
    return Utilities.isInteger(p[0]) && Utilities.isInteger(p[1]) && Utilities.isInteger(p[2]);
  }

  /** 
   * return true if the current version equals test, or later,
   * so if a feature is defined in 4.0, if (VersionUtilities.isThisOrLater("4.0", version))
   * <p>
   * This method tries to perform a numeric parse, so that <code>0.9</code> will be considered below <code>0.10</code>
   * in accordance with SemVer. If either side contains a non-numeric character in a version string, a simple text
   * compare will be done instead.
   * </p>
   *  
   * @param test The value to compare to
   * @param current The value being compared
   * @return Is {@literal current} later or equal to {@literal test}? For example, if <code>this = 0.5</code> and <code>current = 0.6</code> this method will return true
   */
  public static boolean isThisOrLater(String test, String current) {
    if (test == null || current == null) {
      return false;
    }
    String t = getMajMin(test);
    String c = getMajMin(current);
    if (t == null || c == null) {
      return false;
    }
    if (c.compareTo(t) == 0) {
      return isMajMinOrLaterPatch(test, current);
    }

    String[] testParts = t.split("\\.");
    String[] currentParts = c.split("\\.");

    for (int i = 0; i < Math.max(testParts.length, currentParts.length); i++) {
      if (i == testParts.length) {
        return true;
      } else if (i == currentParts.length) {
        return false;
      }
      String testPart = testParts[i];
      String currentPart = currentParts[i];
      if (testPart.equals(currentPart)) {
        continue;
      }
      return compareVersionPart(testPart, currentPart);
    }

    return true;
  }

  private static boolean compareVersionPart(String theTestPart, String theCurrentPart) {
    if (StringUtils.isNumeric(theTestPart) && StringUtils.isNumeric(theCurrentPart)) {
      return Integer.parseInt(theCurrentPart) - Integer.parseInt(theTestPart) >= 0;
    } else {
      return theCurrentPart.compareTo(theTestPart) >= 0;
    }
  }

  /** 
   * return true if the current version equals test for major and min, or later patch 
   * 
   * @param test
   * @param current
   * @return
   */
  public static boolean isMajMinOrLaterPatch(String test, String current) {
    String t = getMajMin(test);
    String c = getMajMin(current);
    if (c != null && t != null && c.compareTo(t) == 0) {
      String pt = getPatch(test);
      String pc = getPatch(current);
      if (pt==null || "x".equals(pt)) {
        return true;
      }
      if (pc!=null) {
        if (pt.contains("-") && !pc.contains("-")) {
          pt = pt.substring(0, pt.indexOf("-"));
          int res = pc.compareTo(pt);
          return res >= 0;
        } else {
          return compareVersionPart(pt, pc);          
        }
      }
    }
    return false;
  }

  public static String incMajorVersion(String v) {
    assert isSemVer(v);
    int[] parts = splitParts(v);
    return Integer.toString(parts[0]+1)+".0.0";
  }

  public static String incMinorVersion(String v) {
    assert isSemVer(v);
    int[] parts = splitParts(v);
    return Integer.toString(parts[0])+"."+Integer.toString(parts[1]+1)+".0";
  }

  public static String incPatchVersion(String v) {
    assert isSemVer(v);
    int[] parts = splitParts(v);
    return Integer.toString(parts[0])+"."+Integer.toString(parts[1])+"."+Integer.toString(parts[2]+1);
  }

  private static int[] splitParts(String v) {
    String[] p = v.split("\\.");
    int[] i = new int[] {Integer.parseInt(p[0]),Integer.parseInt(p[1]),Integer.parseInt(p[2])};
    return i;
  }

  public static String versionFromCode(String version) {
    if ("r2".equals(version)) {
      return "1.0.2";
    }
    if ("r2b".equals(version)) {
      return "1.4.0";
    }
    if ("r3".equals(version)) {
      return "3.0.2";
    }
    if ("r4".equals(version)) {
      return "4.0.1";
    }
    if ("r4".equals(version)) {
      return "4.0.1";
    }
    if ("r4b".equals(version)) {
      return "4.3.0";
    }
    if ("r5".equals(version)) {
      return "5.0.0";
    }
    if ("r6".equals(version)) {
      return "6.0.0-cibuild";
    }
    throw new FHIRException("Unknown version "+version);
  }

  public static VersionURLInfo parseVersionUrl(String url) {
    if (url.length() < 24) {
      return null;
    }
    String v = url.substring(20, 24);
    if (v.endsWith("/")) {
      v = v.substring(0, v.length()-1);
      if (Utilities.existsInList(v, "1.0", "1.4", "3.0", "4.0", "5.0", "6.0")) {
        return new VersionURLInfo(v, "http://hl7.org/fhir/"+url.substring(24));
      }
    }
    return null;
  }


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

    if (isR5Ver(version) || isR6Ver(version)) {
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
    return res;
  }

  public static String getVersionForPackage(String pid) {
    if (pid.startsWith("hl7.fhir.r")) {
      String[] p = pid.split("\\.");
      return versionFromCode(p[2]);
    }
    return null;
  }

  public static boolean versionsMatch(String v1, String v2) {
    String mm1 = getMajMin(v1);
    String mm2 = getMajMin(v2);
    return mm1 != null && mm2 != null && mm1.equals(mm2);
  }

  public static boolean isR5VerOrLater(String version) {
    if (version == null) {
      return false;
    }
    String v = getMajMin(version);
    return v.compareTo("4.5") >= 0; 
  }

  public static String removeVersionFromCanonical(String url) {
    if (url == null) {
      return null;
    }
    if (url.contains("|")) {
      return url.substring(0, url.indexOf("|"));
    } else {
      return url;
    }
  }

  public static boolean isR4Plus(String version) {
    return version != null && (version.startsWith("4.") || version.startsWith("5.") || "current".equals(version));
  }

  public static boolean refersTo(String refVer, String v) {
    if (v.length() > refVer.length()) {
      v = v.substring(0, refVer.length());
    }
    return refVer.equals(v);
  }

  public static String getSpecUrl(String v) {
    if (v.contains("-cibuild")) {
      return "http://build.fhir.org";
    }
    if (v.contains("-")) {
      return "http://hl7.org/fhir/"+v;
    }
    
    switch (getMajMin(v)) {
    case "1.0" : return "http://hl7.org/fhir/DSTU1";
    case "1.4" : return "http://hl7.org/fhir/DSTU2";
    case "3.0" : return "http://hl7.org/fhir/STU3";
    case "4.0" : return "http://hl7.org/fhir/R4";
    case "4.3" : return "http://hl7.org/fhir/R4B";
    case "5.0" : return "http://hl7.org/fhir/R5";
    case "6.0" : return "http://hl7.org/fhir/R6";
    default:
      return "http://hl7.org/fhir";
    }
  }

  public static String getNameForVersion(String v) {
    switch (getMajMin(v)) {
    case "1.0" : return "R2";
    case "1.4" : return "R2B";
    case "3.0" : return "R3";
    case "4.0" : return "R4";
    case "4.3" : return "R4B";
    case "5.0" : return "R5";
    case "6.0" : return "R6";
    default:
      return "R?";
    }
  }

  public static boolean isR5Plus(String version) {
    return version != null && (version.startsWith("5.") || version.startsWith("6.") || "current".equals(version));
  }

  public static boolean isR6Plus(String version) {
    return version != null && version.startsWith("6.");
  }


}