package org.hl7.fhir.r5.utils.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class BundleValidationRule {
  @JsonProperty("rule")
  @SerializedName("rule")
  private
  String rule;

  @JsonProperty("profile")
  @SerializedName("profile")
  private
  String profile;
  private boolean checked;

  @SerializedName("rule")
  @JsonProperty("rule")
  public String getRule() {
    return rule;
  }

  @SerializedName("rule")
  @JsonProperty("rule")
  public BundleValidationRule setRule(String rule) {
    this.rule = rule;
    return this;
  }

  @SerializedName("profile")
  @JsonProperty("profile")
  public String getProfile() {
    return profile;
  }

  @SerializedName("profile")
  @JsonProperty("profile")
  public BundleValidationRule setProfile(String profile) {
    this.profile = profile;
    return this;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }
}
