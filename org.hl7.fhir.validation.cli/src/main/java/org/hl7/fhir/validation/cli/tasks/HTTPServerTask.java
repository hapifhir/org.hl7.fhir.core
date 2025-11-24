package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.FhirValidatorHttpService;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.WatchParametersParser;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

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
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, GlobalParametersParser.SERVER);
  }

  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/server.txt");
  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    checkForInvalidArgs(args);
    validationEngine.setLogValidationProgress(false);
    FhirValidatorHttpService service = new FhirValidatorHttpService(validationEngine, Integer.parseInt(Params.getParam(args, GlobalParametersParser.SERVER)));
    service.startServer();
    log.info("Press ctrl-c to stop the server, or use the client to ask the server to stop (-client -stop)");
    while (true) {
      Thread.sleep(100);
    }
    // service.stop();
  }

  private void checkForInvalidArgs(String[] args) {
    final String[] invalidParams = {
      WatchParametersParser.WATCH_MODE_PARAM,
      WatchParametersParser.WATCH_SCAN_DELAY,
      WatchParametersParser.WATCH_SETTLE_TIME
    };
    final String warningText = " is not supported in server mode and will be ignored.";
    for (String invalidParam : invalidParams) {
      if (Params.hasParam(args, invalidParam)) {
        log.warn(invalidParam + warningText);
      }
    }
  }
}
