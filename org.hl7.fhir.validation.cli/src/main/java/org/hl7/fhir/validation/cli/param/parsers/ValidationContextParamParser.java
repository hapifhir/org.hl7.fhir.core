package org.hl7.fhir.validation.cli.param.parsers;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.model.ValidationContextUtilities;

import java.io.File;
import java.util.ArrayList;

import static org.hl7.fhir.validation.cli.param.Params.*;

@Slf4j
public class ValidationContextParamParser implements IParamParser<ValidationContext> {

  GlobalParametersParser globalParser = new GlobalParametersParser();
  ValidationEngineParametersParser validationEngineParametersParser = new ValidationEngineParametersParser();
  InstanceValidatorParametersParser instanceValidatorParametersParser = new InstanceValidatorParametersParser();
  OutputParametersParser outputParametersParser = new OutputParametersParser();
  WatchParametersParser watchParametersParser = new WatchParametersParser();
  TransformLangParameterParser transformLangParameterParser = new TransformLangParameterParser();
  TransformVersionParametersParser transformVersionParameterParser = new TransformVersionParametersParser();
  MapParametersParser mapParametersParser = new MapParametersParser();
  FHIRPathParametersParser fhirPathParametersParser = new FHIRPathParametersParser();
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
      watchParametersParser.parseArgs(args);
      transformLangParameterParser.parseArgs(args);
      transformVersionParameterParser.parseArgs(args);
      mapParametersParser.parseArgs(args);
      fhirPathParametersParser.parseArgs(args);
      String[] unprocessedArgs = filterProcessedArgs(args);
      this.validationContext = loadValidationContext(unprocessedArgs);
      ValidationContextUtilities.addValidationEngineParameters(this.validationContext, validationEngineParametersParser.getParameterObject());
      ValidationContextUtilities.addInstanceValidatorParameters(this.validationContext, this.instanceValidatorParametersParser.getParameterObject());
      ValidationContextUtilities.addOutputParameters(this.validationContext, this.outputParametersParser.getParameterObject());
      ValidationContextUtilities.addWatchParameters(this.validationContext, this.watchParametersParser.getParameterObject());
      ValidationContextUtilities.addTransformLangParameters(this.validationContext, this.transformLangParameterParser.getParameterObject());
      ValidationContextUtilities.addTransformVersionParameters(this.validationContext, this.transformVersionParameterParser.getParameterObject());
      ValidationContextUtilities.addMapParameters(this.validationContext, this.mapParametersParser.getParameterObject());
      ValidationContextUtilities.addFHIRPathParameters(this.validationContext, this.fhirPathParametersParser.getParameterObject());
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
       if (args[i].equals(PROFILE)) {
        String profile = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile url");
        } else {
          profile = args[++i];
          validationContext.addProfile(profile);
        }
      } else if (args[i].equals(PROFILES)) {
        String profiles = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profiles without indicating profile urls");
        } else {
          profiles = args[++i];
          for (String profile : profiles.split("\\,")) {
            validationContext.addProfile(profile);
          }
        }
      } else if (args[i].equals(OPTION)) {
        String p = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -option without indicating option value");
        } else {
          p = args[++i];
          validationContext.addOption(p);
        }
      } else if (args[i].equals(OPTIONS)) {
        String p = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -options without indicating option values");
        } else {
          p = args[++i];
          for (String s : p.split("\\,")) {
            validationContext.addOption(s);
          }
        }
      } else if (args[i].equals(MODE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -mode without indicating mode");
        else {
          String mode = args[++i];
          validationContext.addModeParam(mode);
        }
      } else if (args[i].equals(INPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -input without providing value");
        else {
          String input = args[++i];
          validationContext.addInput(input);
        }
      } else if (args[i].equals(GlobalParametersParser.DEBUG)) {
        i++;
        log.warn("Debugging support is now provided through the -debug-log and -trace-log CLI parameters. Use the -help option for detailed instructions.");
      } else if (args[i].equals(RECURSE)) {
        validationContext.setRecursive(true);
      } else if (args[i].equals(SHOW_MESSAGES_FROM_REFERENCES)) {
        validationContext.setShowMessagesFromReferences(true);
      } else if (args[i].equals(NO_INTERNAL_CACHING)) {
        validationContext.setNoInternalCaching(true);
      } else if (args[i].equals(DISABLE_DEFAULT_RESOURCE_FETCHER)) {
        validationContext.setDisableDefaultResourceFetcher(true);
      } else if (args[i].equals(PACKAGE_NAME)) {
        validationContext.setPackageName(args[++i]);
      } else if (args[i].equals(TX_PACK)) {
        String packageArg = args[++i];
        if (packageArg != null) {
          if (packageArg.contains(",")) {
            for (String packageName : packageArg.split("\\,")) {
              validationContext.getIgs().add(packageName);
            }
          } else {
            validationContext.getIgs().add(packageArg);
          }
        }
        validationContext.addModeParam("tx");
        validationContext.addModeParam("expansions");
      } else if (args[i].equals(RE_PACK)) {
        String packageArg = args[++i];
        if (packageArg != null) {
          if (packageArg.contains(",")) {
            for (String packageName : packageArg.split("\\,")) {
              validationContext.getIgs().add(packageName);
            }
          } else {
            validationContext.getIgs().add(packageArg);
          }
        }
        validationContext.addModeParam("tx");
        validationContext.addModeParam("cnt");
        validationContext.addModeParam("api");
      } else if (args[i].equals(PIN)) {
        validationContext.addModeParam("pin");
      } else if (args[i].equals(EXPAND)) {
        validationContext.addModeParam("expand");
      } else if (args[i].equals(FORMAT)) {
        validationContext.setFormat(Manager.FhirFormat.fromCode(args[++i]));
      } else if (args[i].equals(LANG_TRANSFORM)) {
        validationContext.setLangTransform(args[++i]);
      } else if (args[i].equals(LANG_REGEN)) {
        validationContext.addLangRegenParam(args[++i]);
        validationContext.addLangRegenParam(args[++i]);
        validationContext.addLangRegenParam(args[++i]);
      } else if (args[i].equals(EXP_PARAMS)) {
        validationContext.setExpansionParameters(args[++i]);
      } else if (args[i].equals(FACTORY)) {
        validationContext.setSource(args[++i]);
      } else if (args[i].equals(RUN_TESTS)) {
        // TODO setBaseTestingUtils test directory
        //This did nothing? RUN_TESTS has no corresponding shouldExecuteTask
        //validationContext.setMode(EngineMode.RUN_TESTS);
      } else if (args[i].equals(SECURITY_CHECKS)) {
        validationContext.setSecurityChecks(true);
      } else if (args[i].equals(NO_EXPERIMENTAL_CONTENT)) {
        validationContext.setNoExperimentalContent(true);
      } else if (args[i].equals(TERMINOLOGY_ROUTING)) {
        validationContext.setShowTerminologyRouting(true);
      } else if (args[i].equals(LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -log without indicating file");
        else
          validationContext.setMapLog(args[++i]);
      } else {
        //Any remaining unhandled args become sources
        validationContext.addSource(args[i]);
      }
    }

    return validationContext;
  }
}
