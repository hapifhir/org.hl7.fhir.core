package org.hl7.fhir.validation.cli.param.parsers;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.model.ValidationContextUtilities;

import java.util.ArrayList;

import static org.hl7.fhir.validation.cli.param.Params.*;

@Slf4j
public class ValidationContextParamParser implements IParamParser<ValidationContext> {

  GlobalParametersParser globalParser = new GlobalParametersParser();
  ValidationEngineParametersParser validationEngineParametersParser = new ValidationEngineParametersParser();
  InstanceValidatorParametersParser instanceValidatorParametersParser = new InstanceValidatorParametersParser();
  OutputParametersParser outputParametersParser = new OutputParametersParser();
  CodeGenParametersParser codeGenParametersParser = new CodeGenParametersParser();
  WatchParametersParser watchParametersParser = new WatchParametersParser();
  TransformLangParameterParser transformLangParameterParser = new TransformLangParameterParser();
  TransformVersionParametersParser transformVersionParameterParser = new TransformVersionParametersParser();
  LangRegenParametersParser langRegenParametersParser = new LangRegenParametersParser();
  MapParametersParser mapParametersParser = new MapParametersParser();
  FHIRPathParametersParser fhirPathParametersParser = new FHIRPathParametersParser();
  RePackageParametersParser rePackageParametersParser = new RePackageParametersParser();
  ValidationContext validationContext = new ValidationContext();

  @Override
  public ValidationContext getParameterObject() {
    return validationContext;
  }

  @Override
  public void parseArgs(Arg[] args) {
    try {
      globalParser.parseArgs(args);
      validationEngineParametersParser.parseArgs(args);
      instanceValidatorParametersParser.parseArgs(args);
      outputParametersParser.parseArgs(args);
      codeGenParametersParser.parseArgs(args);
      watchParametersParser.parseArgs(args);
      transformLangParameterParser.parseArgs(args);
      transformVersionParameterParser.parseArgs(args);
      langRegenParametersParser.parseArgs(args);
      mapParametersParser.parseArgs(args);
      fhirPathParametersParser.parseArgs(args);
      rePackageParametersParser.parseArgs(args);
      String[] unprocessedArgs = filterProcessedArgs(args);
      this.validationContext = loadValidationContext(unprocessedArgs);
      ValidationContextUtilities.addValidationEngineParameters(this.validationContext, validationEngineParametersParser.getParameterObject());
      ValidationContextUtilities.addInstanceValidatorParameters(this.validationContext, this.instanceValidatorParametersParser.getParameterObject());
      ValidationContextUtilities.addOutputParameters(this.validationContext, this.outputParametersParser.getParameterObject());
      ValidationContextUtilities.addCodeGenParameters(this.validationContext, this.codeGenParametersParser.getParameterObject());
      ValidationContextUtilities.addWatchParameters(this.validationContext, this.watchParametersParser.getParameterObject());
      ValidationContextUtilities.addTransformLangParameters(this.validationContext, this.transformLangParameterParser.getParameterObject());
      ValidationContextUtilities.addTransformVersionParameters(this.validationContext, this.transformVersionParameterParser.getParameterObject());
      ValidationContextUtilities.addLangRegenParameters(this.validationContext, this.langRegenParametersParser.getParameterObject());
      ValidationContextUtilities.addMapParameters(this.validationContext, this.mapParametersParser.getParameterObject());
      ValidationContextUtilities.addFHIRPathParameters(this.validationContext, this.fhirPathParametersParser.getParameterObject());
      ValidationContextUtilities.addRePackageParameters(this.validationContext, this.rePackageParametersParser.getParameterObject());
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }

  private String[] filterProcessedArgs(Arg[] args) {
    ArrayList<String> unprocessedArgs = new ArrayList<>();
    for (Arg arg : args) {
      if (!arg.isProcessed()) {
        unprocessedArgs.add(arg.getValue());
      }
    }
    return unprocessedArgs.toArray(new String[0]);
  }

  public static ValidationContext loadValidationContext(String[] args) throws Exception {
    ValidationContext validationContext = new ValidationContext();

    // load the parameters - so order doesn't matter
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(RECURSE)) {
        validationContext.setRecursive(true);
      } else if (args[i].equals(PACKAGE_NAME)) {
        validationContext.setPackageName(args[++i]);
      } else if (args[i].equals(LANG_TRANSFORM)) {
        validationContext.setLangTransform(args[++i]);
      } else if (args[i].equals(FACTORY)) {
        validationContext.setSource(args[++i]);
      } else {
        //Any remaining unhandled args become sources
        validationContext.addSource(args[i]);
      }
    }

    return validationContext;
  }
}
