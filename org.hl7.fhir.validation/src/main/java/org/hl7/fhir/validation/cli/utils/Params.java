package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.validation.Validator;
import org.hl7.fhir.validation.cli.model.CliContext;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class Params {

  public static final String GUI = "-gui";
  public static final String VERSION = "-version";
  public static final String OUTPUT = "-output";
  public static final String PROXY = "-proxy";
  public static final String PROFILE = "-profile";
  public static final String QUESTIONNAIRE = "-questionnaire";
  public static final String NATIVE = "-native";
  public static final String ASSUME_VALID_REST_REF = "-assumeValidRestReferences";
  public static final String DEBUG = "-debug";
  public static final String SCT = "-sct";
  public static final String RECURSE = "-recurse";
  public static final String LOCALE = "-locale";
  public static final String STRICT_EXTENSIONS = "-strictExtensions";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "-hintAboutNonMustSupport";
  public static final String TO_VERSION = "-to-version";
  public static final String DO_NATIVE = "-do-native";
  public static final String NO_NATIVE = "-no-native";
  public static final String TRANSFORM = "-transform";
  public static final String NARRATIVE = "-narrative";
  public static final String SNAPSHOT = "-snapshot";
  public static final String SCAN = "-scan";
  public static final String TERMINOLOGY = "-tx";
  public static final String TERMINOLOGY_LOG = "-txLog";
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
  public static final String DESTINATION = "-dest";
  public static final String LEFT = "-left";
  public static final String RIGHT = "-right";
  public static final String NO_INTERNAL_CACHING = "-no-internal-caching";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";

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
    for (int i = 0; i < args.length - 1; i++)
      if (args[i].equals(param))
        return args[i + 1];
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
      } else if (args[i].equals(PROXY)) {
        i++; // ignore next parameter
      } else if (args[i].equals(PROFILE)) {
        String p = null;
        if (i + 1 == args.length) {
          throw new Error("Specified -profile without indicating profile source");
        } else {
          p = args[++i];
          cliContext.addProfile(args[i++]);
        }
        if (p != null && i + 1 < args.length && args[i + 1].equals("@")) {
          i++;
          if (i + 1 == args.length) {
            throw new Error("Specified -profile with @ without indicating profile location");
          } else {
            cliContext.addLocation(p, args[++i]);
          }
        }
      } else if (args[i].equals(QUESTIONNAIRE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -questionnaire without indicating questionnaire file");
        else
          cliContext.addQuestionnaire(args[++i]);
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
      } else if (args[i].equals(LOCALE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -locale without indicating locale");
        } else {
          cliContext.setLocale(new Locale(args[++i]));
        }
      } else if (args[i].equals(STRICT_EXTENSIONS)) {
        cliContext.setAnyExtensionsAllowed(false);
      } else if (args[i].equals(NO_INTERNAL_CACHING)) {
        cliContext.setNoInternalCaching(true);        
      } else if (args[i].equals(NO_EXTENSIBLE_BINDING_WARNINGS)) {
        cliContext.setNoExtensibleBindingMessages(true);        
      } else if (args[i].equals(HINT_ABOUT_NON_MUST_SUPPORT)) {
        cliContext.setHintAboutNonMustSupport(true);
      } else if (args[i].equals(TO_VERSION)) {
        cliContext.setTargetVer(args[++i]);
        cliContext.setMode(Validator.EngineMode.VERSION);
      } else if (args[i].equals(DO_NATIVE)) {
        cliContext.setCanDoNative(true);
      } else if (args[i].equals(NO_NATIVE)) {
        cliContext.setCanDoNative(false);
      } else if (args[i].equals(TRANSFORM)) {
        cliContext.setMap(args[++i]);
        cliContext.setMode(Validator.EngineMode.TRANSFORM);
      } else if (args[i].equals(NARRATIVE)) {
        cliContext.setMode(Validator.EngineMode.NARRATIVE);
      } else if (args[i].equals(SNAPSHOT)) {
        cliContext.setMode(Validator.EngineMode.SNAPSHOT);
      } else if (args[i].equals(SCAN)) {
        cliContext.setMode(Validator.EngineMode.SCAN);
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
      } else if (args[i].equals(LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -log without indicating file");
        else
          cliContext.setMapLog(args[++i]);
      } else if (args[i].equals(LANGUAGE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -language without indicating language");
        else
          cliContext.setLang(args[++i]);
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
        cliContext.setMode(Validator.EngineMode.CONVERT);
      } else if (args[i].equals(FHIRPATH)) {
        cliContext.setMode(Validator.EngineMode.FHIRPATH);
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
    if (cliContext.getSources().isEmpty())
      throw new Exception("Must provide at least one source file");
    return cliContext;
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