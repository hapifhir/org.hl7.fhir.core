package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.Getter;
import org.hl7.fhir.validation.service.ValidationService;

import java.util.concurrent.Callable;

public abstract class ValidationServiceCommand implements Callable<Integer> {

  @Getter
  private ValidationService validationService;

  public void setValidationService(ValidationService validationService) {
    if (this.validationService != null) {
      throw new IllegalStateException("ValidationService already set");
    }
    this.validationService = validationService;
  }

}
