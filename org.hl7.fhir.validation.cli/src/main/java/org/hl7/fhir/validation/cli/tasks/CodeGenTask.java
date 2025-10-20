package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.RePackageParametersParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.Logger;

import javax.annotation.Nonnull;

public class CodeGenTask extends ValidationEngineTask {

  @Override
  public String getName() {
    return "codegen";
  }

  @Override
  public String getDisplayName() {
    return "Code Generation";
  }

  @Override
  public boolean isHidden() {
    return true;
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull ValidationContext validationContext, @Nonnull String[] args) {
    return shouldExecuteTask(args);
  }

  @Override
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, Params.CODEGEN)
      || (Params.hasParam(args, Params.PACKAGE_NAME) && !Params.hasParam(args, RePackageParametersParser.RE_PACK));
  }

  @Override
  public void logHelp(Logger logger) {

  }

  @Override
  public void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine, @Nonnull ValidationContext validationContext, @Nonnull String[] args) throws Exception {
    //FIXME replace ValidationContext
    validationService.codeGen(validationContext, validationEngine);
  }

}
