package org.hl7.fhir.validation.cli.tasks;

import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.cli.param.parsers.CodeGenParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.OutputParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.PackageNameParametersParser;
import org.hl7.fhir.validation.cli.param.parsers.RePackageParametersParser;
import org.hl7.fhir.validation.service.model.CodeGenParameters;
import org.hl7.fhir.validation.service.model.OutputParameters;
import org.hl7.fhir.validation.service.model.PackageNameParameters;
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
  public boolean shouldExecuteTask(@Nonnull String[] args) {
    return Params.hasParam(args, CodeGenParametersParser.CODEGEN)
      || (Params.hasParam(args, PackageNameParametersParser.PACKAGE_NAME) && !Params.hasParam(args, RePackageParametersParser.RE_PACK));
  }

  @Override
  public void logHelp(Logger logger) {
    // Not written yet.
  }

  @Override
  protected CodeGenTaskInstance getValidationEngineTaskInstance(Arg[] args) {
    return new CodeGenTaskInstance(args);
  }

  @Override
  public boolean usesInstanceValidatorParameters() {
    return true;
  }

  protected class CodeGenTaskInstance extends ValidationEngineTaskInstance {

    CodeGenParameters codeGenParameters;
    PackageNameParameters packageNameParameters;
    OutputParameters outputParameters;

    CodeGenTaskInstance(Arg[] args) {
      super(args);
    }

    @Override
    protected void buildTaskSpecificParametersFromArgs(Arg[] args) {
      CodeGenParametersParser codeGenParametersParser = new CodeGenParametersParser();
      PackageNameParametersParser packageNameParametersParser = new PackageNameParametersParser();
      OutputParametersParser outputParametersParser = new OutputParametersParser();
      codeGenParametersParser.parseArgs(args);
      packageNameParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      codeGenParameters = codeGenParametersParser.getParameterObject();
      packageNameParameters = packageNameParametersParser.getParameterObject();
      outputParameters = outputParametersParser.getParameterObject();
    }

    @Override
    protected void executeTask(@Nonnull ValidationService validationService, @Nonnull ValidationEngine validationEngine) throws Exception {
      validationService.codeGen(validationEngine, new org.hl7.fhir.validation.service.CodeGenParameters(
        validationEngineParameters.getSv(),
        instanceValidatorParameters.getProfiles(),
        codeGenParameters.getOptions(),
        packageNameParameters.getPackageName(),
        outputParameters.getOutput()
      ));
    }
  }
}
