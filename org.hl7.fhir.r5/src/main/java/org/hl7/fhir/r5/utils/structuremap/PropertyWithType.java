package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.r5.elementmodel.Property;
import org.hl7.fhir.r5.fhirpath.TypeDetails;

public class PropertyWithType {
  private String path;
  private Property baseProperty;
  private Property profileProperty;
  private TypeDetails types;

  public PropertyWithType(String path, Property baseProperty, Property profileProperty, TypeDetails types) {
    super();
    this.baseProperty = baseProperty;
    this.profileProperty = profileProperty;
    this.path = path;
    this.types = types;
  }

  public TypeDetails getTypes() {
    return types;
  }

  public String getPath() {
    return path;
  }

  public Property getBaseProperty() {
    return baseProperty;
  }

  public void setBaseProperty(Property baseProperty) {
    this.baseProperty = baseProperty;
  }

  public Property getProfileProperty() {
    return profileProperty;
  }

  public void setProfileProperty(Property profileProperty) {
    this.profileProperty = profileProperty;
  }

  public String summary() {
    return path;
  }

}
