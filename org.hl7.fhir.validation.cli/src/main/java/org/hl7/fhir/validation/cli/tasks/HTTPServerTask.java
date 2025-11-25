package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.FhirValidatorHttpService;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.GlobalParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.WatchParametersParser;
import org.hl7.fhir.validation.service.ValidationService;
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
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, GlobalParametersParser.SERVER);
  }

  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/server.txt");
  }



  private void checkForInvalidArgs(Arg[] args) {
    final String[] invalidParams = {
      WatchParametersParser.WATCH_MODE_PARAM,
      WatchParametersParser.WATCH_SCAN_DELAY,
      WatchParametersParser.WATCH_SETTLE_TIME
    };
    final String warningText = " is not supported in server mode and will be ignored.";
    for (String invalidParam : invalidParams) {
      if (Arg.hasParam(args, invalidParam)) {
        log.warn(invalidParam + warningText);
      }
    }
  }

  @Override
  protected HTTPServerTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new HTTPServerTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return true;
  }

  protected class HTTPServerTaskInstance extends ValidationEngineTaskInstance {

    String port;

    HTTPServerTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      checkForInvalidArgs(args);
      port = Arg.getParam(args, GlobalParametersParser.SERVER);
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationEngine.setLogValidationProgress(false);
      FhirValidatorHttpService service = new FhirValidatorHttpService(validationEngine, Integer.parseInt(port));
      service.startServer();
      log.info("Press ctrl-c to stop the server, or use the client to ask the server to stop (-client -stop)");
      while (true) {
        Thread.sleep(100);
      }
      // service.stop();
    }
  }
}
