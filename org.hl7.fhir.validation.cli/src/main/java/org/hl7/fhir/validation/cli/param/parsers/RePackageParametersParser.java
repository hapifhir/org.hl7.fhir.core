package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.RePackageParameters;
import org.hl7.fhir.validation.special.PackageReGenerator;

import java.util.List;
import java.util.Objects;

public class RePackageParametersParser implements IParamParser<RePackageParameters> {

  public static final String RE_PACK = "-re-package";
  public static final String PIN = "-pin";
  public static final String EXPAND = "-expand";
  public static final String FORMAT = "-format";
  public static final String TX_PACK = "-tx-pack";
  public static final String SCOPE = "-scope";
  public static final String MODE = "-mode";

  public static final String IGNORE_LIST = "-ignore-list";
  public static final String INCLUDE_LIST = "-include-list";
  public static final String INCLUDE_CONFORMS_TO = "-include-conforms-to";

  RePackageParameters rePackageParameters = new RePackageParameters();

  @Override
  public RePackageParameters getParameterObject() {
    return rePackageParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(MODE)) {
        if (i + 1 == args.length)
          throw new Error("Specified -mode without indicating mode");
        else {
          String mode = args[i + 1].getValue();
          rePackageParameters.addModeParam(mode);
        }
        Arg.setProcessed(args, i, 2, true);
      }
      else if (args[i].getValue().equals(TX_PACK)) {
        String packageArg = args[i + 1].getValue();
        if (packageArg != null) {
          if (packageArg.contains(",")) {
            for (String packageName : packageArg.split("\\,")) {
              rePackageParameters.addPackage(packageName);
            }
          } else {
            rePackageParameters.addPackage(packageArg);
          }
        }
        rePackageParameters.addModeParam("tx");
        rePackageParameters.addModeParam("expansions");
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(RE_PACK)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -re-package without indicating package");
        } else {
          String packageArg = args[i + 1].getValue();
          if (packageArg != null) {
            if (packageArg.contains(",")) {
              for (String packageName : packageArg.split("\\,")) {
                rePackageParameters.addPackage(packageName);
              }
            } else {
              rePackageParameters.addPackage(packageArg);
            }
          }
          rePackageParameters.addModeParam("tx");
          rePackageParameters.addModeParam("cnt");
          rePackageParameters.addModeParam("api");
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(PIN)) {
        rePackageParameters.addModeParam("pin");
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(EXPAND)) {
        rePackageParameters.addModeParam("expand");
        args[i].setProcessed(true);
      } else if (args[i].getValue().equals(FORMAT)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -format without indicating format value");
        } else {
          rePackageParameters.setFormat(Manager.FhirFormat.fromCode(args[i + 1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(IGNORE_LIST)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -ignore-list without a resource list");
        } else {
          rePackageParameters.setIgnoreList(List.of(args[i + 1].getValue().split(",")));
          Arg.setProcessed(args, i, 2, true);
        }
      }
      else if (args[i].getValue().equals(INCLUDE_LIST)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -include-list without a resource list");
        } else {
          rePackageParameters.setIncludeList(List.of(args[i + 1].getValue().split(",")));
          Arg.setProcessed(args, i, 2, true);
        }
      }
      else if (args[i].getValue().equals(INCLUDE_CONFORMS_TO)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -include-conforms-to without a value");
        } else {
          if (Boolean.parseBoolean(args[i + 1].getValue())) {
            rePackageParameters.setIncludeConformsTo(true);
          }
          Arg.setProcessed(args, i, 2, true);
        }
      }
      else if (args[i].getValue().equals(SCOPE)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -scope without a value");
        } else {
          rePackageParameters.setScope(getScopeFromString(args[i + 1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
  }

  private PackageReGenerator.ExpansionPackageGeneratorScope getScopeFromString(String scope) {
    return switch (Objects.requireNonNull(scope)) {
      case "ig" -> PackageReGenerator.ExpansionPackageGeneratorScope.IG_ONLY;
      case "igs" -> PackageReGenerator.ExpansionPackageGeneratorScope.ALL_IGS;
      case "core" -> PackageReGenerator.ExpansionPackageGeneratorScope.EVERYTHING;
      default -> null;
    };
  }
}