package org.hl7.fhir.validation.cli.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.utilities.VersionUtilities;

public class VersionSourceInformation {

  private final List<String> report = new ArrayList<>();
  private final List<String> versions = new ArrayList<>();

  public void see(String version, String src) {
    version = VersionUtilities.getMajMin(version);
    report.add(src + ": " + version);
    if (!versions.contains(version)) {
      versions.add(version);
      Collections.sort(versions);
    }
  }

  public boolean isEmpty() {
    return versions.isEmpty();
  }

  public int size() {
    return versions.size();
  }

  public String version() {
    return versions.get(0);
  }

  public List<String> getReport() {
    if (report.isEmpty()) {
      report.add("(nothing found)");
    }
    return report;
  }
}