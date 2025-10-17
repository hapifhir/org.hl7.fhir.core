package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class ValidationEngineParametersParser implements IParamParser<ValidationEngineParameters> {

  public static final String NATIVE = "-native";
  public static final String SCT = "-sct";
  public static final String VERSION = "-version";
  public static final String IMPLEMENTATION_GUIDE = "-ig";
  public static final String DEFINITION = "-defn";
  public static final String RESOLUTION_CONTEXT = "-resolution-context";
  public static final String JURISDICTION = "-jurisdiction";
  public static final String AI_SERVICE = "-ai-service";
  public static final String CERT = "-cert";
  public static final String TERMINOLOGY = "-tx";
  public static final String TERMINOLOGY_LOG = "-txLog";
  public static final String TERMINOLOGY_CACHE = "-txCache";
  public static final String TERMINOLOGY_CACHE_CLEAR = "-clear-tx-cache";
  public static final String CHECK_IPS_CODES = "-check-ips-codes";
  public static final String DO_IMPLICIT_FHIRPATH_STRING_CONVERSION = "-implicit-fhirpath-string-conversions";
  public static final String ALLOW_DOUBLE_QUOTES = "-allow-double-quotes-in-fhirpath";
  public static final String ADVISOR_FILE = "-advisor-file";
  public static final String BUNDLE = "-bundle";
  public static final String LOCALE = "-locale";
  public static final String LANGUAGE = "-language";
  public static final String CHECK_REFERENCES = "-check-references";
  public static final String ALT_VERSION = "-alt-version";

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
          String igVersion = Params.getVersionFromIGName(null, ig);
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
      } else if (args[i].getValue().equals(JURISDICTION)) {
        if (i + 1 == args.length)
          throw new Error("Specified -jurisdiction without indicating jurisdiction");
        else {
          validationEngineParameters.setJurisdiction(processJurisdiction(args[i + 1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
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
      } else if (args[i].getValue().equals(CHECK_IPS_CODES)) {
        validationEngineParameters.setCheckIPSCodes(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(DO_IMPLICIT_FHIRPATH_STRING_CONVERSION)) {
        validationEngineParameters.setDoImplicitFHIRPathStringConversion(true);
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(ALLOW_DOUBLE_QUOTES)) {
        validationEngineParameters.setAllowDoubleQuotesInFHIRPath(true);
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
      } else if (args[i].getValue().equals(BUNDLE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -bundle without indicating bundle rule");
        } else {
          String rule = args[i + 1].getValue();
          if (i + 2 == args.length) {
            throw new Error("Specified -bundle without indicating profile source");
          } else {
            String profile = args[i + 2].getValue();
            validationEngineParameters.addBundleValidationRule(new BundleValidationRule().setRule(rule).setProfile(profile));
            Arg.setProcessed(args, i, 3, true);
          }
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
      }
    }
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
}
