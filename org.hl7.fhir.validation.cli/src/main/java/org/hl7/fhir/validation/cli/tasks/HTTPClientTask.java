package org.hl7.fhir.validation.cli.tasks;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.*;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.List;

@Slf4j
public class HTTPClientTask extends StandaloneTask{
  public static String CLIENT = "-client";
  @Override
  public String getName() {
    return "client";
  }

  @Override
  public String getDisplayName() {
    return "Client";
  }

  @Override
  public boolean isHidden() {
    return false;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, CLIENT);
  }

  @Override
  public void logHelp(Logger logger) {
    Display.displayHelpDetails(logger,"help/tests.txt");
  }


  @Override
  public void executeTask(@Nonnull String[] stringArgs) throws Exception {
    Arg[] args = Arg.of(stringArgs);
    Arg.setProcessed(args, CLIENT, true);
    GlobalParametersParser globalParametersParser = new GlobalParametersParser();
    globalParametersParser.parseArgs(args);
    InstanceValidatorParametersParser instanceValidatorParametersParser = new InstanceValidatorParametersParser();
    instanceValidatorParametersParser.parseArgs(args);
    InstanceValidatorParameters instanceValidatorParameters = instanceValidatorParametersParser.getParameterObject();
    UnprocessedParametersParser unprocessedParametersParser = new UnprocessedParametersParser();
    unprocessedParametersParser.parseArgs(args);
    List<String> sources = unprocessedParametersParser.getParameterObject();
    log.warn("This task is not implemented yet");
    log.info("InstanceValidatorParameters: " +instanceValidatorParameters);
    log.info("sources:" + sources);
  }
}
