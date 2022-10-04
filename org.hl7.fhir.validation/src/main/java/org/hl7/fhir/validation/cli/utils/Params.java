package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.HtmlInMarkdownCheck;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class Params {

  public static final String VERSION = "-version";
  public static final String OUTPUT = "-output";
  public static final String LEVEL = "-level";
  public static final String HTML_OUTPUT = "-html-output";
  public static final String PROXY = "-proxy";
  public static final String PROXY_AUTH = "-auth";
  public static final String PROFILE = "-profile";
  public static final String BUNDLE = "-bundle";
  public static final String QUESTIONNAIRE = "-questionnaire";
  public static final String NATIVE = "-native";
  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String DEBUG = "-debug";
  public static final String SCT = "-sct";
  public static final String RECURSE = "-recurse";
  public static final String SHOW_MESSAGES_FROM_REFERENCES = "-showReferenceMessages";
  public static final String LOCALE = "-locale";
  public static final String EXTENSION = "-extension";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";
  public static final String TO_VERSION = "-to-version";
  public static final String DO_NATIVE = "-do-native";
  public static final String NO_NATIVE = "-no-native";
  public static final String COMPILE = "-compile";
  public static final String TRANSFORM = "-transform";
  public static final String NARRATIVE = "-narrative";
  public static final String SNAPSHOT = "-snapshot";
  public static final String SCAN = "-scan";
  public static final String TERMINOLOGY = "-tx";
  public static final String TERMINOLOGY_LOG = "-txLog";
  public static final String TERMINOLOGY_CACHE = "-txCache";
  public static final String LOG = "-log";
  public static final String LANGUAGE = "-language";
  public static final String IMPLEMENTATION_GUIDE = "-ig";
  public static final String DEFINITION = "defn";
  public static final String MAP = "-map";
  public static final String X = "-x";
  public static final String CONVERT = "-convert";
  public static final String FHIRPATH = "-fhirpath";
  public static final String TEST = "-tests";
  public static final String HELP = "help";
  public static final String COMPARE = "-compare";
  public static final String SPREADSHEET = "-spreadsheet";
  public static final String DESTINATION = "-dest";
  public static final String LEFT = "-left";
  public static final String RIGHT = "-right";
  public static final String NO_INTERNAL_CACHING = "-no-internal-caching";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";
  public static final String NO_UNICODE_BIDI_CONTROL_CHARS = "-no_unicode_bidi_control_chars";
  public static final String NO_INVARIANTS = "-no-invariants";
  public static final String WANT_INVARIANTS_IN_MESSAGES = "-want-invariants-in-messages";
  public static final String SECURITY_CHECKS = "-security-checks";
  public static final String CRUMB_TRAIL = "-crumb-trails";
  public static final String FOR_PUBLICATION = "-forPublication";
  public static final String VERBOSE = "-verbose";
  public static final String SHOW_TIMES = "-show-times";
  public static final String ALLOW_EXAMPLE_URLS = "-allow-example-urls";
  public static final String OUTPUT_STYLE = "-output-style";
  public static final String DO_IMPLICIT_FHIRPATH_STRING_CONVERSION = "-implicit-fhirpath-string-conversions";
  public static final String JURISDICTION = "-jurisdiction";
  public static final String HTML_IN_MARKDOWN = "-html-in-markdown";

  public static final String RUN_TESTS = "-run-tests";

  public static final String TEST_MODULES = "-test-modules";

  public static final String TEST_NAME_FILTER = "-test-classname-filter";

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

  /**
   * Fetches the  value for the passed in param from the provided list of params.
   *
   * @param args  Array of params to search.
   * @param param {@link String} param keyword to search for.
   * @return {@link String} value for the provided param.
   */
  public static String getParam(String[] args, String param) {
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals(param)) return args[i + 1];
    }
    return null;
  }

  /**
   * TODO Don't do this all in one for loop. Use the above methods.
   */
  public static CliContext loadCliContext(String[] args) throws Exception {
    CliContext cliContext = new CliContext();

    // load the parameters - so order doesn't matter
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals(VERSION)) {
        cliContext.setSv(VersionUtilities.getCurrentPackageVersion(args[++i]));
      } else if (args[i].equals(OUTPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -output without indicating output file");
        else
          cliContext.setOutput(args[++i]);
      } else if (args[i].equals(HTML_OUTPUT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -html-output without indicating output file");
        else
          cliContext.setHtmlOutput(args[++i]);
      } else if (args[i].equals(PROXY)) {
        i++; // ignore next parameter
      } else if (args[i].equals(PROXY_AUTH)) {
        i++;
      } else if (args[i].equals(PROFILE)) {
        String p = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile source");
        } else {
          p = args[++i];
          cliContext.addProfile(p);
        }
      } else if (args[i].equals(BUNDLE)) {
        String p = null;
        String r = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating bundle rule ");
        } else {
          r = args[++i];
        }
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile source");
        } else {
          p = args[++i];
        }
        cliContext.getBundleValidationRules().add(new BundleValidationRule(r, p));
      } else if (args[i].equals(QUESTIONNAIRE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -questionnaire without indicating questionnaire mode");
        else {
          String q = args[++i];
          cliContext.setQuestionnaireMode(QuestionnaireMode.fromCode(q));
        }
      } else if (args[i].equals(LEVEL)) {
        if (i + 1 == args.length)
          throw new Error("Specified -level without indicating level mode");
        else {
          String q = args[++i];
          cliContext.setLevel(ValidationLevel.fromCode(q));
        }
      } else if (args[i].equals(NATIVE)) {
        cliContext.setDoNative(true);
      } else if (args[i].equals(ASSUME_VALID_REST_REF)) {
        cliContext.setAssumeValidRestReferences(true);
      } else if (args[i].equals(DEBUG)) {
        cliContext.setDoDebug(true);
      } else if (args[i].equals(SCT)) {
        cliContext.setSnomedCT(args[++i]);
      } else if (args[i].equals(RECURSE)) {
        cliContext.setRecursive(true);
      } else if (args[i].equals(SHOW_MESSAGES_FROM_REFERENCES)) {
        cliContext.setShowMessagesFromReferences(true);
      } else if (args[i].equals(DO_IMPLICIT_FHIRPATH_STRING_CONVERSION)) {
        cliContext.setDoImplicitFHIRPathStringConversion(true);
      } else if (args[i].equals(HTML_IN_MARKDOWN)) {
        if (i + 1 == args.length)
          throw new Error("Specified "+HTML_IN_MARKDOWN+" without indicating mode");
        else {
          String q = args[++i];
          if (!HtmlInMarkdownCheck.isValidCode(q)) {
            throw new Error("Specified "+HTML_IN_MARKDOWN+" with na invalid code - must be ignore, warning, or error");            
          } else {
            cliContext.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(q));
          }
        }
      } else if (args[i].equals(LOCALE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -locale without indicating locale");
        } else {
          cliContext.setLocale(new Locale(args[++i]));
        }
      } else if (args[i].equals(EXTENSION)) {
        cliContext.getExtensions().add(args[++i]);
      } else if (args[i].equals(NO_INTERNAL_CACHING)) {
        cliContext.setNoInternalCaching(true);
      } else if (args[i].equals(NO_EXTENSIBLE_BINDING_WARNINGS)) {
        cliContext.setNoExtensibleBindingMessages(true);
      } else if (args[i].equals(NO_UNICODE_BIDI_CONTROL_CHARS)) {
        cliContext.setNoUnicodeBiDiControlChars(true);
      } else if (args[i].equals(NO_INVARIANTS)) {
        cliContext.setNoInvariants(true);
      } else if (args[i].equals(WANT_INVARIANTS_IN_MESSAGES)) {
        cliContext.setWantInvariantsInMessages(true);
      } else if (args[i].equals(HINT_ABOUT_NON_MUST_SUPPORT)) {
        cliContext.setHintAboutNonMustSupport(true);
      } else if (args[i].equals(TO_VERSION)) {
        cliContext.setTargetVer(args[++i]);
        cliContext.setMode(EngineMode.VERSION);
      } else if (args[i].equals(DO_NATIVE)) {
        cliContext.setCanDoNative(true);
      } else if (args[i].equals(NO_NATIVE)) {
        cliContext.setCanDoNative(false);
      } else if (args[i].equals(TRANSFORM)) {
        cliContext.setMap(args[++i]);
        cliContext.setMode(EngineMode.TRANSFORM);
      } else if (args[i].equals(COMPILE)) {
        cliContext.setMap(args[++i]);
        cliContext.setMode(EngineMode.COMPILE);
      } else if (args[i].equals(NARRATIVE)) {
        cliContext.setMode(EngineMode.NARRATIVE);
      } else if (args[i].equals(SPREADSHEET)) {
        cliContext.setMode(EngineMode.SPREADSHEET);
      } else if (args[i].equals(SNAPSHOT)) {
        cliContext.setMode(EngineMode.SNAPSHOT);
      } else if (args[i].equals(RUN_TESTS)) {
        // TODO setBaseTestingUtils test directory
        cliContext.setMode(EngineMode.RUN_TESTS);
      } else if (args[i].equals(SECURITY_CHECKS)) {
        cliContext.setSecurityChecks(true);
      } else if (args[i].equals(CRUMB_TRAIL)) {
        cliContext.setCrumbTrails(true);
      } else if (args[i].equals(FOR_PUBLICATION)) {
        cliContext.setForPublication(true);
      } else if (args[i].equals(VERBOSE)) {
        cliContext.setCrumbTrails(true);
      } else if (args[i].equals(ALLOW_EXAMPLE_URLS)) {
        String bl = args[++i]; 
        if ("true".equals(bl)) {
          cliContext.setAllowExampleUrls(true);
        } else if ("false".equals(bl)) {
          cliContext.setAllowExampleUrls(false);
        } else {
          throw new Error("Value for "+ALLOW_EXAMPLE_URLS+" not understood: "+bl);          
        }          
      } else if (args[i].equals(SHOW_TIMES)) {
        cliContext.setShowTimes(true);
      } else if (args[i].equals(OUTPUT_STYLE)) {
        cliContext.setOutputStyle(args[++i]);
      } else if (args[i].equals(SCAN)) {
        cliContext.setMode(EngineMode.SCAN);
      } else if (args[i].equals(TERMINOLOGY)) {
        if (i + 1 == args.length)
          throw new Error("Specified -tx without indicating terminology server");
        else
          cliContext.setTxServer("n/a".equals(args[++i]) ? null : args[i]);
      } else if (args[i].equals(TERMINOLOGY_LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txLog without indicating file");
        else
          cliContext.setTxLog(args[++i]);
      } else if (args[i].equals(TERMINOLOGY_CACHE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txCache without indicating file");
        else
          cliContext.setTxCache(args[++i]);
      }
      else if (args[i].equals(LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -log without indicating file");
        else
          cliContext.setMapLog(args[++i]);
      } else if (args[i].equals(LANGUAGE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -language without indicating language");
        else
          cliContext.setLang(args[++i]);
      } else if (args[i].equals(JURISDICTION)) {
        if (i + 1 == args.length)
          throw new Error("Specified -jurisdiction without indicating jurisdiction");
        else
          cliContext.setJurisdiction(processJurisdiction(args[++i]));
      } else if (args[i].equals(IMPLEMENTATION_GUIDE) || args[i].equals(DEFINITION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating ig file");
        else {
          String s = args[++i];
          String version = Common.getVersionFromIGName(null, s);
          if (version == null) {
            cliContext.addIg(s);
          } else {
            cliContext.setSv(version);
          }
        }
      } else if (args[i].equals(MAP)) {
        if (cliContext.getMap() == null) {
          if (i + 1 == args.length)
            throw new Error("Specified -map without indicating map file");
          else
            cliContext.setMap(args[++i]);
        } else {
          throw new Exception("Can only nominate a single -map parameter");
        }
      } else if (args[i].startsWith(X)) {
        i++;
      } else if (args[i].equals(CONVERT)) {
        cliContext.setMode(EngineMode.CONVERT);
      } else if (args[i].equals(FHIRPATH)) {
        cliContext.setMode(EngineMode.FHIRPATH);
        if (cliContext.getFhirpath() == null)
          if (i + 1 == args.length)
            throw new Error("Specified -fhirpath without indicating a FHIRPath expression");
          else
            cliContext.setFhirpath(args[++i]);
        else
          throw new Exception("Can only nominate a single -fhirpath parameter");
      } else {
        cliContext.addSource(args[i]);
      }
    }
    return cliContext;
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

  public static String getTerminologyServerLog(String[] args) {
    String txLog = null;
    if (hasParam(args, "-txLog")) {
      txLog = getParam(args, "-txLog");
      new File(txLog).delete();
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
            System.out.println("Load Package: " + s);
          }
        }
      }
    }
  }
}