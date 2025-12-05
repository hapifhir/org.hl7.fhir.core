package org.hl7.fhir.validation.cli.picocli.commands;

import org.hl7.fhir.validation.service.ValidationService;

import java.util.concurrent.Callable;

public abstract class ValidationServiceCommand implements Callable<Integer> {
  final ValidationService validationService;
  public ValidationServiceCommand(ValidationService validationService) {
    this.validationService = validationService;
  }
}
