package org.hl7.fhir.utilities.npm;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("checkstyle:systemout")
public class NpmPackageReadLogger {
private final boolean logProgress;
private int entryCount = 0;
private int c = 12;


public NpmPackageReadLogger(boolean logProgress) {
  this.logProgress = logProgress;
}

public void entry(String entryName) {
  log.trace("processed npm entry: {}", entryName);
  entryCount++;
  if (logProgress && entryCount % 50 == 0) {
    c++;
    System.out.print(".");
    if (c == 120) {
      System.out.println();
      System.out.print("  ");
      c = 2;
    }
  }
}
}
