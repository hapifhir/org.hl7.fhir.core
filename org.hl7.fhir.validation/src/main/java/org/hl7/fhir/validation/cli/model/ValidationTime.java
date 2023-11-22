package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hl7.fhir.validation.ValidationTimeTracker;

public class ValidationTime {

  public ValidationTime() {}
  @JsonProperty("overall")
  private long overall = 0;

  @JsonProperty("terminology")
  private long terminology = 0;

  @JsonProperty("structureDefinition")
  private long structureDefinition = 0;

  @JsonProperty("resourceParse")
  private long resourceParse = 0;

  @JsonProperty("fhirPath")
  private long fhirPath = 0;

  @JsonProperty("checkingSpecials")
  private long checkingSpecials = 0;

  @JsonProperty("terminology")
  public long getTerminology() {
    return terminology;
  }

  @JsonProperty("terminology")
  public ValidationTime setTerminology(long terminology) {
    this.terminology = terminology;
    return this;
  }

  @JsonProperty("structureDefinition")
  public long getStructureDefinition() {
    return structureDefinition;
  }

  @JsonProperty("structureDefinition")
  public ValidationTime setStructureDefinition(long structureDefinition) {
    this.structureDefinition = structureDefinition;
    return this;
  }

  @JsonProperty("resourceParse")
  public long getResourceParse() {
    return resourceParse;
  }

  @JsonProperty("resourceParse")
  public ValidationTime setResourceParse(long resourceParse) {
    this.resourceParse = resourceParse;
    return this;
  }

  @JsonProperty("fhirPath")
  public long getFhirPath() {
    return fhirPath;
  }

  @JsonProperty("fhirPath")
  public ValidationTime setFhirPath(long fpeTime) {
    this.fhirPath = fpeTime;
    return this;
  }

  @JsonProperty("checkingSpecials")
  public long getCheckingSpecials() {
    return checkingSpecials;
  }

  @JsonProperty("checkingSpecials")
  public ValidationTime setCheckingSpecials(long checkingSpecials) {
    this.checkingSpecials = checkingSpecials;
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

  public static ValidationTime fromTimeTracker(ValidationTimeTracker timeTracker) {
    return new ValidationTime()
      .setStructureDefinition(timeTracker.getSdTime())
      .setTerminology(timeTracker.getTxTime())
      .setCheckingSpecials(timeTracker.getSpecTime())
      .setFhirPath(timeTracker.getFpeTime())
      .setOverall(timeTracker.getOverall())
      .setResourceParse(timeTracker.getLoadTime());
  }
}
