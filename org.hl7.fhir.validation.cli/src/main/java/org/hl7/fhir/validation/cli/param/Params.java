package org.hl7.fhir.validation.cli.param;

import java.io.File;
import java.io.IOException;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.cli.param.parsers.*;
import org.hl7.fhir.validation.service.model.ValidationContext;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

@Slf4j
public class Params {

  public static final String TEST_VERSION = "-test-version";
  public static final String ALT_VERSION = "-alt-version";

  public static final String PROFILE = "-profile";
  public static final String PROFILES = "-profiles";
  public static final String CONFIG = "-config";
  public static final String OPTION = "-option";
  public static final String OPTIONS = "-options";
  public static final String RECURSE = "-recurse";
  public static final String SHOW_MESSAGES_FROM_REFERENCES = "-showReferenceMessages";
  public static final String TX_PACK = "-tx-pack";
  public static final String RE_PACK = "-re-package";
  public static final String PACKAGE_NAME = "-package-name";
  public static final String PIN = "-pin";
  public static final String EXPAND = "-expand";
  public static final String CODEGEN = "-codegen";
  public static final String FACTORY = "-factory";
  public static final String FORMAT = "-format";
  public static final String LANG_TRANSFORM = "-lang-transform";
  public static final String LANG_REGEN = "-lang-regen";
  public static final String EXP_PARAMS = "-expansion-parameters";
  public static final String NARRATIVE = "-narrative";
  public static final String SNAPSHOT = "-snapshot";
  public static final String INSTALL = "-install";
  public static final String SCAN = "-scan";
  public static final String TERMINOLOGY_ROUTING = "-tx-routing";
  public static final String LOG = "-log";
  public static final String IMPLEMENTATION_GUIDE = "-ig";
  public static final String DEFINITION = "-defn";
  public static final String X = "-x";
  public static final String CONVERT = "-convert";
  public static final String TEST = "-tests";
  public static final String TX_TESTS = "txTests";
  public static final String AI_TESTS = "-aiTests";
  public static final String HELP = "help";
  public static final String COMPARE = "-compare";
  public static final String SPREADSHEET = "-spreadsheet";
  public static final String DESTINATION = "-dest";
  public static final String LEFT = "-left";
  public static final String RIGHT = "-right";
  public static final String NO_INTERNAL_CACHING = "-no-internal-caching";

  public static final String PRELOAD_CACHE = "-preload-cache";
  public static final String SECURITY_CHECKS = "-security-checks";
  public static final String DISABLE_DEFAULT_RESOURCE_FETCHER = "-disable-default-resource-fetcher";
  public static final String NO_EXPERIMENTAL_CONTENT = "-no-experimental-content";

  public static final String RUN_TESTS = "-run-tests";

  public static final String TEST_MODULES = "-test-modules";

  public static final String TEST_NAME_FILTER = "-test-classname-filter";
  public static final String SPECIAL = "-special";
  public static final String TARGET = "-target";
  public static final String SOURCE = "-source";
  public static final String INPUT = "-input";
  public static final String FILTER = "-filter";
  public static final String EXTERNALS = "-externals";
  public static final String MODE = "-mode";
  public static final String MATCHETYPE = "-matchetype";

  /**
   * Checks the list of passed in params to see if it contains the passed in param.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param to search for.
   * @return {@link Boolean#TRUE} if the list contains the given param.
   */
  public static boolean hasParam(String[] args, String param) {
    return Arrays.asList(args).contains(param);
  }

  public static boolean hasParamAndValue(String[] args, String param) {
    int paramIndex = Arrays.asList(args).indexOf(param);
    if (paramIndex == -1) {
      return false;
    }
    checkIfParamValueInBounds(args, param, paramIndex);
    return true;
  }

  /**
   * Check if the value for the param is in bounds in the args array.
   */
  private static void checkIfParamValueInBounds(String[] args, String param, int paramIndex) {
    if (paramIndex + 1 >= args.length) {
      throw new Error("Used '"+ param +"' without providing a value");
    }
  }

  /**
   * Fetches the value for the passed in param from the provided list of params.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param keyword to search for.
   * @return {@link String} value for the provided param, or null if param is out of bounds
   */
  public static String getParam(String[] args, String param) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(param)) return args[i + 1];
    }
    return null;
  }

  public static Collection<String> getMultiValueParam(String[] args, String param) {
    final List<String> output = new LinkedList<>();
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(param)) {
        checkIfParamValueInBounds(args, param, i);
        output.add(args[i + 1]);
      }
    }
    return Collections.unmodifiableList(output);
  }
  /**
   * TODO Don't do this all in one for loop. Use the above methods.
   */
  public static ValidationContext loadValidationContext(String[] args) throws Exception {
    ValidationContext validationContext = new ValidationContext();

    // load the parameters - so order doesn't matter
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(ValidationEngineParametersParser.VERSION)) {
        validationContext.setSv(VersionUtilities.getCurrentPackageVersion(args[++i]));
      } else if (args[i].equals(OutputParametersParser.OUTPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -output without indicating output file");
        else
          validationContext.setOutput(args[++i]);
      } else if (args[i].equals(OutputParametersParser.OUTPUT_SUFFIX)) {
        if (i + 1 == args.length)
          throw new Error("Specified -outputSuffix without indicating output suffix");
        else
          validationContext.setOutputSuffix(args[++i]);
      }
      else if (args[i].equals(InstanceValidatorParametersParser.HTML_OUTPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -html-output without indicating output file");
        else
          validationContext.setHtmlOutput(args[++i]);
      } else if (args[i].equals(PROFILE)) {
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
      } else if (args[i].equals(ValidationEngineParametersParser.BUNDLE)) {
        String profile = null;
        String rule = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating bundle rule ");
        } else {
          rule = args[++i];
        }
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile source");
        } else {
          profile = args[++i];
        }
        validationContext.addBundleValidationRule(new BundleValidationRule().setRule(rule).setProfile(profile));
      } else if (args[i].equals(InstanceValidatorParametersParser.QUESTIONNAIRE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -questionnaire without indicating questionnaire mode");
        else {
          String questionnaireMode = args[++i];
          validationContext.setQuestionnaireMode(QuestionnaireMode.fromCode(questionnaireMode));
        }
      } else if (args[i].equals(InstanceValidatorParametersParser.LEVEL)) {
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
      } else if (args[i].equals(ValidationEngineParametersParser.NATIVE)) {
        validationContext.setDoNative(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.ASSUME_VALID_REST_REF)) {
        validationContext.setAssumeValidRestReferences(true);
      } else if (args[i].equals(ValidationEngineParametersParser.CHECK_REFERENCES)) {
        validationContext.setCheckReferences(true);
      } else if (args[i].equals(ValidationEngineParametersParser.RESOLUTION_CONTEXT)) {
        validationContext.setResolutionContext(args[++i]);
      } else if (args[i].equals(GlobalParametersParser.DEBUG)) {
        i++;
        log.warn("Debugging support is now provided through the -debug-log and -trace-log CLI parameters. Use the -help option for detailed instructions.");
      } else if (args[i].equals(ValidationEngineParametersParser.SCT)) {
        validationContext.setSnomedCT(args[++i]);
      } else if (args[i].equals(RECURSE)) {
        validationContext.setRecursive(true);
      } else if (args[i].equals(SHOW_MESSAGES_FROM_REFERENCES)) {
        validationContext.setShowMessagesFromReferences(true);
      } else if (args[i].equals(ValidationEngineParametersParser.DO_IMPLICIT_FHIRPATH_STRING_CONVERSION)) {
        validationContext.setDoImplicitFHIRPathStringConversion(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.HTML_IN_MARKDOWN)) {
        if (i + 1 == args.length)
          throw new Error("Specified "+InstanceValidatorParametersParser.HTML_IN_MARKDOWN+" without indicating mode");
        else {
          String q = args[++i];
          if (!HtmlInMarkdownCheck.isValidCode(q)) {
            throw new Error("Specified "+InstanceValidatorParametersParser.HTML_IN_MARKDOWN+" with na invalid code - must be ignore, warning, or error");
          } else {
            validationContext.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(q));
          }
        }
      } else if (args[i].equals(InstanceValidatorParametersParser.BEST_PRACTICE)) {
        if (i + 1 == args.length)
          throw new Error("Specified "+InstanceValidatorParametersParser.BEST_PRACTICE+" without indicating mode");
        else {
          String q = args[++i];
          validationContext.setBestPracticeLevel(readBestPractice(q));
        }
      } else if (args[i].equals(GlobalParametersParser.LOCALE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -locale without indicating locale");
        } else {
          validationContext.setLocale(Locale.forLanguageTag(args[++i]));
        }
      } else if (args[i].equals(InstanceValidatorParametersParser.EXTENSION)) {
        validationContext.getExtensions().add(args[++i]);
      } else if (args[i].equals(NO_INTERNAL_CACHING)) {
        validationContext.setNoInternalCaching(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.NO_EXTENSIBLE_BINDING_WARNINGS)) {
        validationContext.setNoExtensibleBindingMessages(true);
      } else if (args[i].equals(ValidationEngineParametersParser.ALLOW_DOUBLE_QUOTES)) {
        validationContext.setAllowDoubleQuotesInFHIRPath(true);
      } else if (args[i].equals(DISABLE_DEFAULT_RESOURCE_FETCHER)) {
        validationContext.setDisableDefaultResourceFetcher(true);
      } else if (args[i].equals(ValidationEngineParametersParser.CHECK_IPS_CODES)) {
        validationContext.setCheckIPSCodes(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.NO_UNICODE_BIDI_CONTROL_CHARS)) {
        validationContext.setNoUnicodeBiDiControlChars(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.NO_INVARIANTS)) {
        validationContext.setNoInvariants(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.DISPLAY_WARNINGS)) {
        validationContext.setDisplayWarnings(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.WANT_INVARIANTS_IN_MESSAGES)) {
        validationContext.setWantInvariantsInMessages(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.HINT_ABOUT_NON_MUST_SUPPORT)) {
        validationContext.setHintAboutNonMustSupport(true);
      } else if (args[i].equals(TransformVersionParametersParser.TO_VERSION)) {
        validationContext.setTargetVer(args[++i]);
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
      } else if (args[i].equals(TransformVersionParametersParser.DO_NATIVE)) {
        validationContext.setCanDoNative(true);
      } else if (args[i].equals(TransformVersionParametersParser.NO_NATIVE)) {
        validationContext.setCanDoNative(false);
      } else if (args[i].equals(MapParametersParser.TRANSFORM)) {
        validationContext.setMap(args[++i]);
      } else if (args[i].equals(FORMAT)) {
        validationContext.setFormat(FhirFormat.fromCode(args[++i]));
      } else if (args[i].equals(LANG_TRANSFORM)) {
        validationContext.setLangTransform(args[++i]);
      } else if (args[i].equals(LANG_REGEN)) {
        validationContext.addLangRegenParam(args[++i]);
        validationContext.addLangRegenParam(args[++i]);
        validationContext.addLangRegenParam(args[++i]);
      } else if (args[i].equals(EXP_PARAMS)) {
        validationContext.setExpansionParameters(args[++i]);
      } else if (args[i].equals(MapParametersParser.COMPILE)) {
        validationContext.setMap(args[++i]);
      } else if (args[i].equals(FACTORY)) {
        validationContext.setSource(args[++i]);
      } else if (args[i].equals(RUN_TESTS)) {
        // TODO setBaseTestingUtils test directory
        //This did nothing? RUN_TESTS has no corresponding shouldExecuteTask
        //validationContext.setMode(EngineMode.RUN_TESTS);
      } else if (args[i].equals(SECURITY_CHECKS)) {
        validationContext.setSecurityChecks(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.CRUMB_TRAIL)) {
        validationContext.setCrumbTrails(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.SHOW_MESSAGE_IDS)) {
        validationContext.setShowMessageIds(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.FOR_PUBLICATION)) {
        validationContext.setForPublication(true);
      } else if (args[i].equals(ValidationEngineParametersParser.AI_SERVICE)) {
        validationContext.setAIService(args[++i]);
      } else if (args[i].equals(InstanceValidatorParametersParser.R5_REF_POLICY)) {
        validationContext.setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.fromCode(args[++i]));
      } else if (args[i].equals(InstanceValidatorParametersParser.UNKNOWN_CODESYSTEMS_CAUSE_ERROR)) {
        validationContext.setUnknownCodeSystemsCauseErrors(true);
      } else if (args[i].equals(NO_EXPERIMENTAL_CONTENT)) {
        validationContext.setNoExperimentalContent(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.VERBOSE)) {
        validationContext.setCrumbTrails(true);
        validationContext.setShowMessageIds(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.ALLOW_EXAMPLE_URLS)) {
        String bl = args[++i]; 
        if ("true".equals(bl)) {
          validationContext.setAllowExampleUrls(true);
        } else if ("false".equals(bl)) {
          validationContext.setAllowExampleUrls(false);
        } else {
          throw new Error("Value for "+InstanceValidatorParametersParser.ALLOW_EXAMPLE_URLS+" not understood: "+bl);
        }          
      } else if (args[i].equals(TERMINOLOGY_ROUTING)) {
        validationContext.setShowTerminologyRouting(true);
      } else if (args[i].equals(ValidationEngineParametersParser.TERMINOLOGY_CACHE_CLEAR)) {
        validationContext.setClearTxCache(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.SHOW_TIMES)) {
        validationContext.setShowTimes(true);
      } else if (args[i].equals(InstanceValidatorParametersParser.OUTPUT_STYLE)) {
        validationContext.setOutputStyle(args[++i]);
      } else if (args[i].equals(ValidationEngineParametersParser.ADVISOR_FILE)) {
        validationContext.setAdvisorFile(args[++i]);
        File f = ManagedFileAccess.file(validationContext.getAdvisorFile());
        if (!f.exists()) {
          throw new Error("Cannot find advisor file "+ validationContext.getAdvisorFile());
        } else if (!Utilities.existsInList(Utilities.getFileExtension(f.getName()), "json", "txt")) {
          throw new Error("Advisor file "+ validationContext.getAdvisorFile()+" must be a .json or a .txt file");
        }
      } else if (args[i].equals(ValidationEngineParametersParser.TERMINOLOGY)) {
        if (i + 1 == args.length)
          throw new Error("Specified -tx without indicating terminology server");
        else {
          validationContext.setTxServer("n/a".equals(args[++i]) ? null : args[i]);
          validationContext.setNoEcosystem(true);
        }
      } else if (args[i].equals(ValidationEngineParametersParser.TERMINOLOGY_LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txLog without indicating file");
        else
          validationContext.setTxLog(args[++i]);
      } else if (args[i].equals(ValidationEngineParametersParser.TERMINOLOGY_CACHE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txCache without indicating file");
        else
          validationContext.setTxCache(args[++i]);
      } else if (args[i].equals(ValidationEngineParametersParser.CERT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txCache without indicating file");
        else {
          String s = args[++i];
          if (!(new File(s).exists())) {
            throw new Error("Certificate source '"+s+"'  not found");            
          } else {
            validationContext.addCertSource(s);
          }
        }
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
      } else if (args[i].equals(ValidationEngineParametersParser.LANGUAGE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -language without indicating language");
        else
          validationContext.setLang(args[++i]);
      } else if (args[i].equals(TransformLangParameterParser.SRC_LANG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -src-lang without indicating file");
        else
          validationContext.setSrcLang(args[++i]);
      } else if (args[i].equals(TransformLangParameterParser.TGT_LANG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -tgt-lang without indicating file");
        else
          validationContext.setTgtLang(args[++i]);
      } else if (args[i].equals(ValidationEngineParametersParser.JURISDICTION)) {
        if (i + 1 == args.length)
          throw new Error("Specified -jurisdiction without indicating jurisdiction");
        else
          validationContext.setJurisdiction(processJurisdiction(args[++i]));
      } else if (args[i].equals(IMPLEMENTATION_GUIDE) || args[i].equals(DEFINITION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating ig file");
        else {
          String s = args[++i];
          String version = getVersionFromIGName(null, s);
          if (version == null) {
            validationContext.addIg(s);
          } else {
            String v = getParam(args, ValidationEngineParametersParser.VERSION);
            if (v != null && !v.equals(version)) {
              throw new Error("Parameters are inconsistent: specified version is "+v+" but -ig parameter "+s+" implies a different version");
            } else if (validationContext.getSv() != null && !version.equals(validationContext.getSv())) {
              throw new Error("Parameters are inconsistent: multiple -ig parameters implying differetion versions ("+ validationContext.getSv()+","+version+")");
            } else {
              validationContext.setSv(version);
            }
          }
        }
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
      } else if (args[i].equals(MapParametersParser.MAP)) {
        if (validationContext.getMap() == null) {
          if (i + 1 == args.length)
            throw new Error("Specified -map without indicating map file");
          else
            validationContext.setMap(args[++i]);
        } else {
          throw new Exception("Can only nominate a single -map parameter");
        }
      } else if (args[i].equals(WatchParametersParser.WATCH_MODE_PARAM)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -watch-mode without indicating mode value");
        } else {
          validationContext.setWatchMode(readWatchMode(args[++i]));
        }
      } else if (args[i].equals(WatchParametersParser.WATCH_SCAN_DELAY)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -watch-scan-delay without indicating mode value");
        } else {
          validationContext.setWatchScanDelay(readInteger(WatchParametersParser.WATCH_SCAN_DELAY, args[++i]));
        }
      } else if (args[i].equals(WatchParametersParser.WATCH_SETTLE_TIME)) {
          if (i + 1 == args.length) {
            throw new Error("Specified -watch-mode without indicating mode value");
          } else {
            validationContext.setWatchSettleTime(readInteger(WatchParametersParser.WATCH_SETTLE_TIME, args[++i]));
          }      } else if (args[i].startsWith(X)) {
        i++;
      } else if (args[i].equals(FHIRPathParametersParser.FHIRPATH)) {
        if (validationContext.getFhirpath() == null)
          if (i + 1 == args.length)
            throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
          else
            validationContext.setFhirpath(args[++i]);
        else
          throw new Exception("Can only nominate a single -fhirpath parameter");
      } else if (Utilities.existsInList(args[i],
        GlobalParametersParser.DEBUG_LOG,
        GlobalParametersParser.TRACE_LOG,
        GlobalParametersParser.PROXY,
        GlobalParametersParser.PROXY_AUTH,
        GlobalParametersParser.HTTPS_PROXY,
        GlobalParametersParser.SERVER)) {
          //DO NOTHING Those params are handled outside this loop, so should be ignored along with their values.
          i++;
      } else if (Utilities.existsInList(args[i],
        GlobalParametersParser.AUTH_NONCONFORMANT_SERVERS,
        GlobalParametersParser.NO_HTTP_ACCESS,
        GlobalParametersParser.FHIR_SETTINGS_PARAM)) {
        //DO NOTHING Those params are handled outside this loop, so should be ignored.
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

  private static int readInteger(String name, String value) {
    if (!Utilities.isInteger(value)) {
      throw new Error("Unable to read "+value+" provided for '"+name+"' - must be an integer");
    }
    return Integer.parseInt(value);
  }

  private static ValidatorWatchMode readWatchMode(String s) {
    if (s == null) {
      return ValidatorWatchMode.NONE;
    }
    switch (s.toLowerCase()) {
    case "all" : return ValidatorWatchMode.ALL;
    case "none" : return ValidatorWatchMode.NONE;
    case "single" : return ValidatorWatchMode.SINGLE;
    case "a" : return ValidatorWatchMode.ALL;
    case "n" : return ValidatorWatchMode.NONE;
    case "s" : return ValidatorWatchMode.SINGLE;
    }
    throw new Error("The watch mode ''"+s+"'' is not valid");
  }

  private static String processJurisdiction(String s) {
    if (s.startsWith("urn:iso:std:iso:3166#") || s.startsWith("urn:iso:std:iso:3166:-2#") || s.startsWith("http://unstats.un.org/unsd/methods/m49/m49.htm#")) {
      return s;
    } else {
      String v = JurisdictionUtilities.getJurisdictionFromLocale(s);
      if (v != null) { 
        return v;        
      } else {
        throw new FHIRException("Unable to understand Jurisdiction '"+s+"'");
      }
    }
  }

  public static String getTerminologyServerLog(String[] args) throws IOException {
    String txLog = null;
    if (hasParam(args, "-txLog")) {
      txLog = getParam(args, "-txLog");
      ManagedFileAccess.file(txLog).delete();
    }
    return txLog;
  }

  public static void checkIGFileReferences(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (IMPLEMENTATION_GUIDE.equals(args[i])) {
        if (i + 1 == args.length)
          throw new Error("Specified -ig without indicating ig file");
        else {
          String s = args[++i];
          if (!s.startsWith("hl7.fhir.core-")) {
            log.info("Load Package: " + s);
          }
        }
      }
    }
  }

  public static String getVersion(String[] args) {
    String v = Params.getParam(args, "-version");
    if (v == null) {
      v = "5.0";
      for (int i = 0; i < args.length; i++) {
        if ("-ig".equals(args[i])) {
          if (i + 1 == args.length)
            throw new Error("Specified -ig without indicating ig file");
          else {
            String n = args[i + 1];
            v = getVersionFromIGName(v, n);
          }
        }
      }
    } else if (VersionUtilities.isR2Ver(v)) {
      v = "1.0";
    } else if (VersionUtilities.isR2BVer(v)) {
      v = "1.4";
    } else if (VersionUtilities.isR3Ver(v)) {
      v = "3.0";
    } else if (VersionUtilities.isR4Ver(v)) {
      v = "4.0";
    } else if (VersionUtilities.isR4BVer(v)) {
      v = "4.3";
    } else if (VersionUtilities.isR5Ver(v)) {
      v = "5.0";
    } else if (VersionUtilities.isR6Ver(v)) {
      v = "6.0";
    }
    return v;
  }

  /**
   * Evaluates the current implementation guide file name and sets the current version accordingly.
   * <p>
   * If igFileName is not one of the known patterns, will return whatever value is passed in as default.
   *
   * @param defaultValue Version to return if no associated version can be determined from passed in igFileName
   * @param igFileName   Name of the implementation guide
   * @return
   */
  public static String getVersionFromIGName(String defaultValue, String igFileName) {
    if (igFileName.equals("hl7.fhir.core")) {
      defaultValue = "5.0";
    } else if (igFileName.startsWith("hl7.fhir.core#")) {
      defaultValue = VersionUtilities.getCurrentPackageVersion(igFileName.substring(14));
    } else if (igFileName.startsWith("hl7.fhir.r2.core#") || igFileName.equals("hl7.fhir.r2.core")) {
      defaultValue = "1.0";
    } else if (igFileName.startsWith("hl7.fhir.r2b.core#") || igFileName.equals("hl7.fhir.r2b.core")) {
      defaultValue = "1.4";
    } else if (igFileName.startsWith("hl7.fhir.r3.core#") || igFileName.equals("hl7.fhir.r3.core")) {
      defaultValue = "3.0";
    } else if (igFileName.startsWith("hl7.fhir.r4.core#") || igFileName.equals("hl7.fhir.r4.core")) {
      defaultValue = "4.0";
    } else if (igFileName.startsWith("hl7.fhir.r5.core#") || igFileName.equals("hl7.fhir.r5.core")) {
      defaultValue = "5.0";
    } else if (igFileName.startsWith("hl7.fhir.r6.core#") || igFileName.equals("hl7.fhir.r6.core")) {
      defaultValue = "6.0";
    }
    return defaultValue;
  }
}
