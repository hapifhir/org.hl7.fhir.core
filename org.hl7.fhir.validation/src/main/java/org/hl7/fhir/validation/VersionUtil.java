package org.hl7.fhir.validation;

/*
 * #%L
 * org.hl7.fhir.utilities
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

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Properties;

import org.hl7.fhir.r5.model.InstantType;
import org.hl7.fhir.utilities.Utilities;

import static org.apache.commons.lang3.StringUtils.defaultIfBlank;
import static org.apache.commons.lang3.StringUtils.left;

/**
 * Used internally by HAPI to log the version of the HAPI FHIR framework
 * once, when the framework is first loaded by the classloader.
 */
public class VersionUtil {

  private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ca.uhn.fhir.util.VersionUtil.class);
  private static String ourVersion;
  private static String ourBuildNumber;
  private static String ourBuildTime;

  static {
    initialize();
  }

  public static String getBuildNumber() {
    return ourBuildNumber;
  }

  public static String getBuildTime() {
    return ourBuildTime;
  }

  public static String getVersion() {
    return ourVersion;
  }

  private static void initialize() {
    try (InputStream is = ca.uhn.fhir.util.VersionUtil.class.getResourceAsStream("/fhir-build.properties")) {

      Properties p = new Properties();
      if (is != null) {
        p.load(is);
      }

      ourVersion = p.getProperty("orgfhir.version");
      ourVersion = defaultIfBlank(ourVersion, "(unknown)");

      ourBuildNumber = p.getProperty("orgfhir.buildnumber");
      ourBuildTime = p.getProperty("orgfhir.timestamp");

    } catch (Exception e) {
      ourLog.warn("Unable to determine version information", e);
    }
  }

  public static String getVersionString() {
    return "Version " + getVersion() + " (Git# " + left(getBuildNumber(), 12)+"). Built " + getBuildTime() + " ("+getDurationSinceBuild()+")";
  }

  private static String getDurationSinceBuild() {
    try {
      InstantType dt = new InstantType(ourBuildTime);
      return Utilities.describeDuration(Duration.ofMillis(new Date().getTime() - dt.getValue().getTime()))+" old";
    } catch (Exception e) {
      return "??";
    }
  }


}
