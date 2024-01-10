package org.hl7.fhir.utilities;


public class FHIRBaseToolingClient {

  private static final int DEFAULT_TIMEOUT_NORMAL = 1500;
  private static final int DEFAULT_TIMEOUT_OPERATION = 30000;
  private static final int DEFAULT_TIMEOUT_ENTRY = 500;
  private static final int DEFAULT_TIMEOUT_OPERATION_LONG = 60000;
  private static final int DEFAULT_TIMEOUT_OPERATION_EXPAND = 120000;

  protected int timeoutNormal = DEFAULT_TIMEOUT_NORMAL;
  protected int timeoutOperation = DEFAULT_TIMEOUT_OPERATION;
  protected int timeoutEntry = DEFAULT_TIMEOUT_ENTRY;
  protected int timeoutLong = DEFAULT_TIMEOUT_OPERATION_LONG;
  protected int timeoutExpand = DEFAULT_TIMEOUT_OPERATION_EXPAND;

  protected boolean versionInMimeTypes;


  public long getTimeoutNormal() {
    return timeoutNormal;
  }

  public void setTimeoutNormal(int timeoutNormal) {
    this.timeoutNormal = timeoutNormal;
  }

  public long getTimeoutOperation() {
    return timeoutOperation;
  }

  public void setTimeoutOperation(int timeoutOperation) {
    this.timeoutOperation = timeoutOperation;
  }

  public long getTimeoutEntry() {
    return timeoutEntry;
  }

  public void setTimeoutEntry(int timeoutEntry) {
    this.timeoutEntry = timeoutEntry;
  }

  public long getTimeoutLong() {
    return timeoutLong;
  }

  public void setTimeoutLong(int timeoutLong) {
    this.timeoutLong = timeoutLong;
  }

  public long getTimeoutExpand() {
    return timeoutExpand;
  }

  public void setTimeoutExpand(int timeoutExpand) {
    this.timeoutExpand = timeoutExpand;
  }

  
  public void setTimeoutFactor(int i) {
    timeoutNormal = i * DEFAULT_TIMEOUT_NORMAL;
    timeoutOperation = i * DEFAULT_TIMEOUT_OPERATION;
    timeoutEntry = i * DEFAULT_TIMEOUT_ENTRY;
    timeoutLong = i * DEFAULT_TIMEOUT_OPERATION_LONG;
    timeoutExpand = i * DEFAULT_TIMEOUT_OPERATION_EXPAND;
  }

  protected String withVer(String header, String version) {
    return header+(versionInMimeTypes ? "; fhirVersion="+version : "");
  }

  public boolean isVersionInMimeTypes() {
    return versionInMimeTypes;
  }

  public void setVersionInMimeTypes(boolean versionInMimeTypes) {
    this.versionInMimeTypes = versionInMimeTypes;
  }

}
