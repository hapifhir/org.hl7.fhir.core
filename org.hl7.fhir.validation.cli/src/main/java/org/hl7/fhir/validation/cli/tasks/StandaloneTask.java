package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.service.model.ValidationContext;

public abstract class StandaloneTask extends CliTask{

  public abstract void executeTask(ValidationContext validationContext, String[] args, TimeTracker tt, TimeTracker.Session tts) throws Exception;



}
