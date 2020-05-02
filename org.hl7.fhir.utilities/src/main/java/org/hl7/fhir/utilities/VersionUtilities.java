package org.hl7.fhir.utilities;

import org.hl7.fhir.exceptions.FHIRException;

/*-
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
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
