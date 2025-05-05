package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.validation.ValidationTimeTracker;

public class ValidationTime {

  public ValidationTime() {
  }

  @JsonProperty("overall")
  @SerializedName("overall")
  private
  long overall = 0;

  @JsonProperty("terminology")
  @SerializedName("terminology")
  private
  long terminology = 0;

  @JsonProperty("structureDefinition")
  @SerializedName("structureDefinition")
  private
  long structureDefinition = 0;

  @JsonProperty("resourceParse")
  @SerializedName("resourceParse")
  private
  long resourceParse = 0;

  @JsonProperty("fhirPath")
  @SerializedName("fhirPath")
  private
  long fhirPath = 0;

  @JsonProperty("checkingSpecials")
  @SerializedName("checkingSpecials")
  private
  long checkingSpecials = 0;

  @SerializedName("terminology")
  @JsonProperty("terminology")
  public long getTerminology() {
    return terminology;
  }

  @SerializedName("terminology")
  @JsonProperty("terminology")
  public ValidationTime setTerminology(long terminology) {
    this.terminology = terminology;
    return this;
  }

  @SerializedName("structureDefinition")
  @JsonProperty("structureDefinition")
  public long getStructureDefinition() {
    return structureDefinition;
  }

  @SerializedName("structureDefinition")
  @JsonProperty("structureDefinition")
  public ValidationTime setStructureDefinition(long structureDefinition) {
    this.structureDefinition = structureDefinition;
    return this;
  }

  @SerializedName("resourceParse")
  @JsonProperty("resourceParse")
  public long getResourceParse() {
    return resourceParse;
  }

  @SerializedName("resourceParse")
  @JsonProperty("resourceParse")
  public ValidationTime setResourceParse(long resourceParse) {
    this.resourceParse = resourceParse;
    return this;
  }

  @SerializedName("fhirPath")
  @JsonProperty("fhirPath")
  public long getFhirPath() {
    return fhirPath;
  }

  @SerializedName("fhirPath")
  @JsonProperty("fhirPath")
  public ValidationTime setFhirPath(long fpeTime) {
    this.fhirPath = fpeTime;
    return this;
  }

  @SerializedName("checkingSpecials")
  @JsonProperty("checkingSpecials")
  public long getCheckingSpecials() {
    return checkingSpecials;
  }

  @SerializedName("checkingSpecials")
  @JsonProperty("checkingSpecials")
  public ValidationTime setCheckingSpecials(long checkingSpecials) {
    this.checkingSpecials = checkingSpecials;
    return this;
  }

  @SerializedName("overall")
  @JsonProperty("overall")
  public long getOverall() {
    return overall;
  }

  @SerializedName("overall")
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
