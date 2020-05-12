package org.hl7.fhir.utilities;

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
  
  
  public static final String CURRENT_VERSION = "4.4";
  public static final String CURRENT_FULL_VERSION = "4.4.0";

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
    if ("current".equals(v)) {
      return "hl7.fhir.r5.core";
    }
    if (v != null && v.startsWith(CURRENT_VERSION)) {
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
    if (v != null && v.startsWith(CURRENT_VERSION)) {
      return "current";
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
    if (v != null && v.startsWith(CURRENT_VERSION)) {
      return "current";
    }
    return v;
  }

  public static boolean isSupportedVersion(String version) {
    return Utilities.existsInList(version, "1.0.2", "1.4.0", "3.0.2", "4.0.1", CURRENT_FULL_VERSION);
  }

  public static String listSupportedVersions() {
    return "1.0.2, 1.4.0, 3.0.2, 4.0.1, "+CURRENT_FULL_VERSION;
  }

  public static boolean isR5Ver(String ver) {
    return ver != null && ver.startsWith(CURRENT_VERSION);
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
    String mm1 = getMajMin(v1);
    String mm2 = getMajMin(v2);
    if (mm1 == null || mm2 == null) {
      return false;
    } else {
      return mm1.equals(mm2);
    }
  }

  public static boolean isCorePackage(String s) {
    if (s.contains("#")) {
      s = s.substring(0, s.indexOf("#"));
    }
    return Utilities.existsInList(s, "hl7.fhir.core","hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core", "hl7.fhir.r4.core");
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
    } else {
      return null;
    }
  }

  public static boolean isSemVer(String version) {
    if (Utilities.charCount(version, '.') != 2) {
      return false;
    }
    String[] p = version.split("\\.");
    return Utilities.isInteger(p[0]) && Utilities.isInteger(p[1]) && Utilities.isInteger(p[2]);
  }

  /** 
   * return true if the current vresion equals test, or later 
   * 
   * so if a feature is defined in 4.0, if (VersionUtilities.isThisOrLater("4.0", version))...
   *  
   * @param test
   * @param current
   * @return
   */
  public static boolean isThisOrLater(String test, String current) {
    String t = getMajMin(test);
    String c = getMajMin(current);
    boolean ok = c.compareTo(t) >= 0;
    return ok;
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
    if ("r5".equals(version)) {
      return CURRENT_FULL_VERSION;
    }
    throw new FHIRException("Unknown version "+version);
  }

}