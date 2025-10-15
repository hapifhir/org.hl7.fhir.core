package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.terminologies.JurisdictionUtilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.cli.param.Params;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;

import java.io.File;
import java.io.IOException;

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
