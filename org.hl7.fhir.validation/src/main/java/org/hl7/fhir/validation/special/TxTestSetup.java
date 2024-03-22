package org.hl7.fhir.validation.special;

import lombok.Getter;
import org.hl7.fhir.utilities.json.model.JsonObject;

public class TxTestSetup {
  public TxTestSetup(JsonObject suite, JsonObject test) {
    this.suite = suite;
    this.test = test;
  }

  @Getter
  private JsonObject suite;
  @Getter
  private JsonObject test;

}
