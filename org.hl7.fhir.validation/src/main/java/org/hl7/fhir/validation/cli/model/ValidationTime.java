package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hl7.fhir.validation.TimeTracker;

public class ValidationTime {


  @JsonProperty("overall")
  private long overall = 0;

  @JsonProperty("terminology")
  private long txTime = 0;

  @JsonProperty("structureDefinition")
  private long sdTime = 0;

  @JsonProperty("resourceParse")
  private long loadTime = 0;

  @JsonProperty("fhirPath")
  private long fpeTime = 0;

  @JsonProperty("checkingSpecials")
  private long specTime = 0;

  @JsonProperty("terminology")
  public long getTxTime() {
    return txTime;
  }

  @JsonProperty("terminology")
  public ValidationTime setTxTime(long txTime) {
    this.txTime = txTime;
    return this;
  }

  @JsonProperty("structureDefinition")
  public long getSdTime() {
    return sdTime;
  }

  @JsonProperty("structureDefinition")
  public ValidationTime setSdTime(long sdTime) {
    this.sdTime = sdTime;
    return this;
  }

  @JsonProperty("resourceParse")
  public long getLoadTime() {
    return loadTime;
  }

  @JsonProperty("resourceParse")
  public ValidationTime setLoadTime(long loadTime) {
    this.loadTime = loadTime;
    return this;
  }

  @JsonProperty("fhirPath")
  public long getFpeTime() {
    return fpeTime;
  }

  @JsonProperty("fhirPath")
  public ValidationTime setFpeTime(long fpeTime) {
    this.fpeTime = fpeTime;
    return this;
  }

  @JsonProperty("checkingSpecials")
  public long getSpecTime() {
    return specTime;
  }

  @JsonProperty("checkingSpecials")
  public ValidationTime setSpecTime(long specTime) {
    this.specTime = specTime;
    return this;
  }

  @JsonProperty("overall")
  public long getOverall() {
    return overall;
  }

  @JsonProperty("overall")
  public ValidationTime setOverall(long overall) {
    this.overall = overall;
    return this;
  }

  public static ValidationTime fromTimeTracker(TimeTracker timeTracker) {
    return new ValidationTime()
      .setSdTime(timeTracker.getSdTime())
      .setTxTime(timeTracker.getTxTime())
      .setSpecTime(timeTracker.getSpecTime())
      .setFpeTime(timeTracker.getFpeTime())
      .setOverall(timeTracker.getOverall())
      .setLoadTime(timeTracker.getLoadTime());
  }
}
