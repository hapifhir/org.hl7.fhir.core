package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.FhirValidatorHttpService;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.slf4j.Logger;

@Slf4j
public class HTTPServerTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "server";
  }

  @Override
  public String getDisplayName() {
    return "Server";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(ValidationContext validationContext, String[] args) {
    return Params.hasParam(args, Params.SERVER);
  }

  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/server.txt");
  }

  @Override
  public void executeTask(ValidationService validationService, ValidationEngine validationEngine, ValidationContext validationContext, String[] args) throws Exception {
    checkForInvalidArgs(args);
    validationEngine.setLogValidationProgress(false);
    FhirValidatorHttpService service = new FhirValidatorHttpService(validationEngine, Integer.parseInt(Params.getParam(args, Params.SERVER)));
    service.startServer();
    log.info("Press any key to stop the server...");
    System.in.read();
    service.stop();
  }

  private void checkForInvalidArgs(String[] args) {
    final String[] invalidParams = {
      Params.WATCH_MODE_PARAM,
      Params.WATCH_SCAN_DELAY,
      Params.WATCH_SETTLE_TIME
    };
    final String warningText = " is not supported in server mode and will be ignored.";
    for (String invalidParam : invalidParams) {
      if (Params.hasParam(args, invalidParam)) {
        log.warn(invalidParam + warningText);
      }
    }
  }
}
