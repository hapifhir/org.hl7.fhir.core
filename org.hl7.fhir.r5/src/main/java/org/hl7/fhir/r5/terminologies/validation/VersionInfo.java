package org.hl7.fhir.r5.terminologies.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;

public class VersionInfo {
  /**
   * 
   */
  private final ValueSetValidator valueSetCheckerSimple;

  /**
   * @param valueSetCheckerSimple
   */
  VersionInfo(ValueSetValidator valueSetCheckerSimple) {
    this.valueSetCheckerSimple = valueSetCheckerSimple;
  }

  private String expansionVersion;
  private String composeVersion;

  public String getExpansionVersion() {
    return expansionVersion;
  }

  public void setExpansionVersion(String expansionVersion) {
    this.expansionVersion = expansionVersion;
  }

  public String getComposeVersion() {
    return composeVersion;
  }

  public void setComposeVersion(String composeVersion) {
    this.composeVersion = composeVersion;
  }

  public String getVersion(String system, String version) {
    String fixedVersion = getVersionParameter("force-system-version", system);
    if (fixedVersion != null) {
      return fixedVersion;
    }
    String checkVersion = getVersionParameter("check-system-version", system);
    if (version != null) {
      if (checkVersion != null && !version.equals(checkVersion)) {
        throw new FHIRException("Attempt to use version "+version+" of "+system+", when the expansion parameters limit the use to "+checkVersion);
      }
      return version;
    }
    if (expansionVersion != null) {
      if (checkVersion != null && !expansionVersion.equals(checkVersion)) {
        throw new FHIRException("Attempt to use version "+expansionVersion+" of "+system+", when the expansion parameters limit the use to "+checkVersion);
      }
      return expansionVersion;
    }
    if (composeVersion != null) {
      if (checkVersion != null && !composeVersion.equals(checkVersion)) {
        throw new FHIRException("Attempt to use version "+composeVersion+" of "+system+", when the expansion parameters limit the use to "+checkVersion);
      }
      return composeVersion;
    }
    return getVersionParameter("system-version", system);
  }

  private String getVersionParameter(String name, String system) {
    if (this.valueSetCheckerSimple.expansionProfile != null) {
      for (ParametersParameterComponent pc : this.valueSetCheckerSimple.expansionProfile.getParameter()) {
        if (name.equals(pc.getName()) && pc.hasValue()) {
          String v = pc.getValue().primitiveValue();
          if (v != null && v.startsWith(system+"|")) {
            return v.substring(system.length()+1);
          }
        }
      }
    }
    return null;
  }

}