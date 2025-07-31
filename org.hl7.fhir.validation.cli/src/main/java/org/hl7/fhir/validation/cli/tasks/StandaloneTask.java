package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.service.model.ValidationContext;

public abstract class StandaloneTask extends CliTask{

  public abstract void executeTask(ValidationContext validationContext, String[] args) throws Exception;



}
