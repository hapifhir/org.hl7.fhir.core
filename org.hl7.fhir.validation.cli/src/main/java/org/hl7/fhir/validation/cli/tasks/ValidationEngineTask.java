package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;

public abstract class ValidationEngineTask extends CliTask{

  public abstract void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args, org.hl7.fhir.utilities.TimeTracker tt, TimeTracker.Session tts) throws Exception;



}
