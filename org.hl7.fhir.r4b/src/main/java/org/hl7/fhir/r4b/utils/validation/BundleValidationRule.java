package org.hl7.fhir.r4b.utils.validation;

public class BundleValidationRule {
  private String rule;
  private String profile;
  private boolean checked;

  public BundleValidationRule(String rule, String profile) {
    super();
    this.rule = rule;
    this.profile = profile;
  }

  public String getRule() {
    return rule;
  }

  public String getProfile() {
    return profile;
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }
}
