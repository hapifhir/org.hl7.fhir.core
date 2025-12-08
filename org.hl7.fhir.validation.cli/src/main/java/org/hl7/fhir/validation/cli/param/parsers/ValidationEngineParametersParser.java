package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ValidationEngineParametersParser implements IParamParser<ValidationEngineParameters> {

  public static final String NATIVE = "-native";
  public static final String RECURSE = "-recurse";
  public static final String SCT = "-sct";
  public static final String VERSION = "-version";
  public static final String IMPLEMENTATION_GUIDE = "-ig";
  public static final String DEFINITION = "-defn";
  public static final String RESOLUTION_CONTEXT = "-resolution-context";
  public static final String AI_SERVICE = "-ai-service";
  public static final String CERT = "-cert";
  public static final String TERMINOLOGY = "-tx";
  public static final String TERMINOLOGY_LOG = "-txLog";
  public static final String TERMINOLOGY_CACHE = "-txCache";
  public static final String TERMINOLOGY_CACHE_CLEAR = "-clear-tx-cache";
  public static final String ADVISOR_FILE = "-advisor-file";
  public static final String LOCALE = "-locale";
  public static final String LANGUAGE = "-language";
  public static final String CHECK_REFERENCES = "-check-references";
  public static final String CHECK_REFERENCES_TO = "-check-references-to";
  public static final String ALT_VERSION = "-alt-version";
  public static final String NO_INTERNAL_CACHING = "-no-internal-caching";
  public static final String DISABLE_DEFAULT_RESOURCE_FETCHER = "-disable-default-resource-fetcher";
  public static final String LOG = "-log";
  public static final String DISPLAY_WARNINGS = "-display-issues-are-warnings";
  public static final String NO_EXTENSIBLE_BINDING_WARNINGS = "-no-extensible-binding-warnings";
  public static final String SHOW_TIMES = "-show-times";
  public static final String MATCHETYPE = "-matchetype";

  ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
  @Override
  public ValidationEngineParameters getParameterObject() {
    return validationEngineParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(NATIVE)) {
        validationEngineParameters.setDoNative(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(RECURSE)) {
        validationEngineParameters.setRecursive(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SCT)) {
        validationEngineParameters.setSnomedCT(args[i + 1].getValue());
        Arg.setProcessed(args, i,  2, true);
      } else if (args[i].getValue().equals(VERSION)) {
        validationEngineParameters.setSv(VersionUtilities.getCurrentPackageVersion(args[i + 1].getValue()));
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(IMPLEMENTATION_GUIDE) || args[i].getValue().equals(DEFINITION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating ig file");
        else {
          String ig = args[i + 1].getValue();
          String igVersion = getVersionFromIGName(null, ig);
          if (igVersion == null) {
            validationEngineParameters.addIg(ig);
          } else {
            String explicitParamVersion = Arg.getParam(args, VERSION);
            if (explicitParamVersion != null && !explicitParamVersion.equals(igVersion)) {
              throw new Error("Parameters are inconsistent: specified version is "+explicitParamVersion+" but -ig parameter "+ig+" implies a different version");
            } else if (validationEngineParameters.getSv() != null && !igVersion.equals(validationEngineParameters.getSv())) {
              throw new Error("Parameters are inconsistent: multiple -ig parameters implying differetion versions ("+ validationEngineParameters.getSv()+","+igVersion+")");
            } else {
              validationEngineParameters.setSv(igVersion);
            }
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(RESOLUTION_CONTEXT)) {
        validationEngineParameters.setResolutionContext(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(AI_SERVICE)) {
        validationEngineParameters.setAIService(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(CERT)) {
        if (i + 1 == args.length)
          throw new Error("Specified -cert without indicating file");
        else {
          String s = args[i + 1].getValue();
          File file;
          try {
            file = ManagedFileAccess.file(s);
          } catch (IOException e) {
            throw new Error("Exception accessing certificate source '"+s+"'");
          }
          if (!file.exists()) {
            throw new Error("Certificate source '"+s+"' not found");
          } else {
            validationEngineParameters.addCertSource(s);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(TERMINOLOGY)) {
        if (i + 1 == args.length)
          throw new Error("Specified -tx without indicating terminology server");
        else {
          String txServer = args[i + 1].getValue();
          validationEngineParameters.setTxServer("n/a".equals(txServer) ? null : txServer);
          validationEngineParameters.setNoEcosystem(true);
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(TERMINOLOGY_LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txLog without indicating file");
        else {
          validationEngineParameters.setTxLog(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(TERMINOLOGY_CACHE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -txCache without indicating file");
        else {
          validationEngineParameters.setTxCache(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(TERMINOLOGY_CACHE_CLEAR)) {
        validationEngineParameters.setClearTxCache(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(ADVISOR_FILE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -advisor-file without indicating file");
        else {
          String advisorFile = args[i + 1].getValue();
          File f;
          try {
            f = ManagedFileAccess.file(advisorFile);
          } catch (IOException e) {
            throw new Error("Exception accessing advisor file '"+advisorFile+"'");
          }
          if (!f.exists()) {
            throw new Error("Cannot find advisor file "+ advisorFile);
          } else if (!Utilities.existsInList(Utilities.getFileExtension(f.getName()), "json", "txt")) {
            throw new Error("Advisor file "+ advisorFile +" must be a .json or a .txt file");
          } else {
            validationEngineParameters.setAdvisorFile(advisorFile);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(LOCALE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -locale without indicating locale");
        } else {
          validationEngineParameters.setLocale(Locale.forLanguageTag(args[i + 1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(LANGUAGE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -language without indicating language");
        else {
          validationEngineParameters.setLang(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(CHECK_REFERENCES)) {
        validationEngineParameters.setCheckReferences(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(CHECK_REFERENCES_TO)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating server");
        else {
          String s = args[i + 1].getValue();
          validationEngineParameters.getCheckReferencesTo().add(s.replace("https://", "http://"));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(ALT_VERSION)) {
        if (i + 1 == args.length)
          throw new Error("Specified " + args[i] + " without indicating version");
        else {
          String s = args[i + 1].getValue();
          String v = VersionUtilities.getMajMin(s);
          if (v == null) {
            throw new Error("Unsupported FHIR Version "+s);
          }
          String pid = VersionUtilities.packageForVersion(v);
          pid = pid + "#"+VersionUtilities.getCurrentPackageVersion(v);
          validationEngineParameters.addIg(pid);
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(NO_INTERNAL_CACHING)) {
        validationEngineParameters.setNoInternalCaching(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(DISABLE_DEFAULT_RESOURCE_FETCHER)) {
        validationEngineParameters.setDisableDefaultResourceFetcher(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(LOG)) {
        if (i + 1 == args.length)
          throw new Error("Specified -log without indicating file");
        else {
          validationEngineParameters.setMapLog(args[i + 1].getValue());
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(DISPLAY_WARNINGS)) {
        validationEngineParameters.setDisplayWarnings(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(NO_EXTENSIBLE_BINDING_WARNINGS)) {
        validationEngineParameters.setNoExtensibleBindingMessages(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(SHOW_TIMES)) {
        validationEngineParameters.setShowTimes(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(MATCHETYPE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -matchetype without indicating file");
        } else {
          String s = args[i + 1].getValue();
          if (!(new java.io.File(s).exists())) {
            throw new Error("-matchetype source '" + s + "'  not found");
          } else {
            validationEngineParameters.addMatchetype(s);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }

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
