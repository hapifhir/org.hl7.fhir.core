package org.hl7.fhir.r5.utils.validation;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@MarkedToMoveToAdjunctPackage
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BundleValidationRule that = (BundleValidationRule) o;
    return Objects.equals(profile, that.profile) &&
           Objects.equals(rule, that.rule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profile, rule);
  }
}
