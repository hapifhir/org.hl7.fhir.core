package org.hl7.fhir.validation.cli.param.parsers;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.model.ValidationContextUtilities;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

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
      String[] unprocessedArgs = filterProcessedArgs(args);
      this.validationContext = loadValidationContext(unprocessedArgs);
      ValidationContextUtilities.addValidationEngineParameters(this.validationContext, validationEngineParametersParser.getParameterObject());
      ValidationContextUtilities.addInstanceValidatorParameters(this.validationContext, this.instanceValidatorParametersParser.getParameterObject());
      ValidationContextUtilities.addOutputParameters(this.validationContext, this.outputParametersParser.getParameterObject());
      ValidationContextUtilities.addWatchParameters(this.validationContext, this.watchParametersParser.getParameterObject());
      ValidationContextUtilities.addTransformLangParameters(this.validationContext, this.transformLangParameterParser.getParameterObject());
      ValidationContextUtilities.addTransformVersionParameters(this.validationContext, this.transformVersionParameterParser.getParameterObject());
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
      } else if (args[i].equals(LEVEL)) {
        if (i + 1 == args.length)
          throw new Error("Specified -level without indicating level mode");
        else {
          String q = args[++i];
          validationContext.setLevel(ValidationLevel.fromCode(q));
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
      } else if (args[i].equals(HTML_IN_MARKDOWN)) {
        if (i + 1 == args.length)
          throw new Error("Specified "+HTML_IN_MARKDOWN+" without indicating mode");
        else {
          String q = args[++i];
          if (!HtmlInMarkdownCheck.isValidCode(q)) {
            throw new Error("Specified "+HTML_IN_MARKDOWN+" with na invalid code - must be ignore, warning, or error");
          } else {
            validationContext.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(q));
          }
        }
      } else if (args[i].equals(BEST_PRACTICE)) {
        if (i + 1 == args.length)
          throw new Error("Specified "+BEST_PRACTICE+" without indicating mode");
        else {
          String q = args[++i];
          validationContext.setBestPracticeLevel(readBestPractice(q));
        }
      } else if (args[i].equals(NO_INTERNAL_CACHING)) {
        validationContext.setNoInternalCaching(true);
      } else if (args[i].equals(DISABLE_DEFAULT_RESOURCE_FETCHER)) {
        validationContext.setDisableDefaultResourceFetcher(true);
      } else if (args[i].equals(NO_UNICODE_BIDI_CONTROL_CHARS)) {
        validationContext.setNoUnicodeBiDiControlChars(true);
      } else if (args[i].equals(DISPLAY_WARNINGS)) {
        validationContext.setDisplayWarnings(true);
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
      } else if (args[i].equals(TRANSFORM)) {
        validationContext.setMap(args[++i]);
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
      } else if (args[i].equals(COMPILE)) {
        validationContext.setMap(args[++i]);
      } else if (args[i].equals(FACTORY)) {
        validationContext.setSource(args[++i]);
      } else if (args[i].equals(RUN_TESTS)) {
        // TODO setBaseTestingUtils test directory
        //This did nothing? RUN_TESTS has no corresponding shouldExecuteTask
        //validationContext.setMode(EngineMode.RUN_TESTS);
      } else if (args[i].equals(SECURITY_CHECKS)) {
        validationContext.setSecurityChecks(true);
      } else if (args[i].equals(CRUMB_TRAIL)) {
        validationContext.setCrumbTrails(true);
      } else if (args[i].equals(SHOW_MESSAGE_IDS)) {
        validationContext.setShowMessageIds(true);
      } else if (args[i].equals(FOR_PUBLICATION)) {
        validationContext.setForPublication(true);
      } else if (args[i].equals(UNKNOWN_CODESYSTEMS_CAUSE_ERROR)) {
        validationContext.setUnknownCodeSystemsCauseErrors(true);
      } else if (args[i].equals(NO_EXPERIMENTAL_CONTENT)) {
        validationContext.setNoExperimentalContent(true);
      } else if (args[i].equals(VERBOSE)) {
        validationContext.setCrumbTrails(true);
        validationContext.setShowMessageIds(true);
      } else if (args[i].equals(ALLOW_EXAMPLE_URLS)) {
        String bl = args[++i];
        if ("true".equals(bl)) {
          validationContext.setAllowExampleUrls(true);
        } else if ("false".equals(bl)) {
          validationContext.setAllowExampleUrls(false);
        } else {
          throw new Error("Value for "+ALLOW_EXAMPLE_URLS+" not understood: "+bl);
        }
      } else if (args[i].equals(TERMINOLOGY_ROUTING)) {
        validationContext.setShowTerminologyRouting(true);
      } else if (args[i].equals(MATCHETYPE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -matchetype without indicating file");
        else {
          String s = args[++i];
          if (!(new File(s).exists())) {
            throw new Error("-matchetype source '"+s+"'  not found");
          } else {
            validationContext.addMatchetype(s);
          }
        }} else if (args[i].equals(LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -log without indicating file");
        else
          validationContext.setMapLog(args[++i]);
      } else if (args[i].equals(ALT_VERSION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating version");
        else {
          String s = args[++i];
          String v = VersionUtilities.getMajMin(s);
          if (v == null) {
            throw new Error("Unsupported FHIR Version "+s);
          }
          String pid = VersionUtilities.packageForVersion(v);
          pid = pid + "#"+VersionUtilities.getCurrentPackageVersion(v);
          validationContext.addIg(pid);
        }
      } else if (args[i].equals(MAP)) {
        if (validationContext.getMap() == null) {
          if (i + 1 == args.length)
            throw new Error("Specified -map without indicating map file");
          else
            validationContext.setMap(args[++i]);
        } else {
          throw new Exception("Can only nominate a single -map parameter");
        }
      } else if (args[i].equals(FHIRPATH)) {
        if (validationContext.getFhirpath() == null)
          if (i + 1 == args.length)
            throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
          else
            validationContext.setFhirpath(args[++i]);
        else
          throw new Exception("Can only nominate a single -fhirpath parameter");
      } else {
        //Any remaining unhandled args become sources
        validationContext.addSource(args[i]);
      }
    }

    return validationContext;
  }

  private static BestPracticeWarningLevel readBestPractice(String s) {
    if (s == null) {
      return BestPracticeWarningLevel.Warning;
    }
    switch (s.toLowerCase()) {
      case "warning" : return BestPracticeWarningLevel.Warning;
      case "error" : return BestPracticeWarningLevel.Error;
      case "hint" : return BestPracticeWarningLevel.Hint;
      case "ignore" : return BestPracticeWarningLevel.Ignore;
      case "w" : return BestPracticeWarningLevel.Warning;
      case "e" : return BestPracticeWarningLevel.Error;
      case "h" : return BestPracticeWarningLevel.Hint;
      case "i" : return BestPracticeWarningLevel.Ignore;
    }
    throw new Error("The best-practice level ''"+s+"'' is not valid");
  }
}
