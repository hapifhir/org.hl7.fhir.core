package org.hl7.fhir.model;

import lombok.Getter;
import org.hl7.fhir.model.core.formats.ParserBase;

public class ModelResourceInformation {

  /**
   * The name of the resource e.g. TestPlan
   */
  @Getter
  private String name;

  /**
   *  The package name it came from e.g. hl7.fhir.uv.testing@0.1.0
   */
  @Getter private String packageName;

  /**
   * true if this is intended to override the core resource
   *
   * THis is sometimes needed if you want to support incubation versions of core resources
   */
  @Getter private boolean overrides = false;
  /**
   * The custom resource handler, which is responsible for creating and parsing, and serialising
   *
   * this is null for core resources
   */
  @Getter private ParserBase.CustomResourceHandler handler;

  public ModelResourceInformation(String name, String packageName, boolean overrides, ParserBase.CustomResourceHandler handler) {
    this.name = name;
    this.packageName = packageName;
    this.overrides = overrides;
    this.handler = handler;
  }
}
