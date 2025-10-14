package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.ValidatorWatchMode;
import org.hl7.fhir.validation.service.model.WatchParameters;

public class WatchParametersParser implements IParamParser<WatchParameters> {

  public static final String WATCH_MODE_PARAM = "-watch-mode";
  public static final String WATCH_SCAN_DELAY = "-watch-scan-delay";
  public static final String WATCH_SETTLE_TIME = "-watch-settle-time";
  private final WatchParameters watchParameters = new WatchParameters();

  @Override
  public WatchParameters getParameterObject() {
    return watchParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].getValue().equals(WATCH_MODE_PARAM)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -watch-mode without indicating mode value");
        } else {
          watchParameters.setWatchMode(readWatchMode(args[i+1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(WATCH_SCAN_DELAY)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -watch-scan-delay without indicating mode value");
        } else {
          watchParameters.setWatchScanDelay(readInteger(WATCH_SCAN_DELAY, args[i+1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      } else if (args[i].getValue().equals(WATCH_SETTLE_TIME)) {
        if (i + 1 == args.length) {
          throw new Error("Specified -watch-mode without indicating mode value");
        } else {
          watchParameters.setWatchSettleTime(readInteger(WATCH_SETTLE_TIME, args[i+1].getValue()));
          Arg.setProcessed(args, i, 2, true);
        }
      }
    }
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

  private static int readInteger(String name, String value) {
    if (!Utilities.isInteger(value)) {
      throw new Error("Unable to read "+value+" provided for '"+name+"' - must be an integer");
    }
    return Integer.parseInt(value);
  }
}
