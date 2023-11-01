package org.hl7.fhir.r5.utils.validation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BundleValidationRule {
  @JsonProperty("rule")
  private String rule;

  @JsonProperty("profile")
  private String profile;
  private boolean checked;

  @JsonProperty("rule")
  public String getRule() {
    return rule;
  }

  @JsonProperty("rule")
  public BundleValidationRule setRule(String rule) {
    this.rule = rule;
    return this;
  }

  @JsonProperty("profile")
  public String getProfile() {
    return profile;
  }

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
