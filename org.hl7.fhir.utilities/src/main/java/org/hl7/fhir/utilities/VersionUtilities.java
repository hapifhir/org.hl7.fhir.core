package org.hl7.fhir.utilities;

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
  
  
  public static final String CURRENT_VERSION = "4.1";
  public static final String CURRENT_FULL_VERSION = "4.1.0";

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
      return "Constants.VERSION";
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
    return v1.substring(0, 3).equals(v2.substring(0, 3));
  }

}
