package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.MapParameters;

public class MapParametersParser implements IParamParser<MapParameters> {

  public static final String MAP = "-map";
  public static final String COMPILE = "-compile";
  public static final String TRANSFORM = "-transform";

  MapParameters mapParameters = new MapParameters();

  @Override
  public MapParameters getParameterObject() {
    return mapParameters;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].isProcessed()) {
        continue;
      }
      if (args[i].getValue().equals(MAP)) {
        if (mapParameters.getMap() == null) {
          if (i + 1 == args.length) {
            throw new Error("Specified -map without indicating map file");
          } else {
            mapParameters.setMap(args[i + 1].getValue());
            Arg.setProcessed(args, i, 2, true);
          }
        } else {
          throw new RuntimeException("Can only nominate a single -map parameter");
        }
      } else if (args[i].getValue().equals(COMPILE)) {
        mapParameters.setMap(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      } else if (args[i].getValue().equals(TRANSFORM)) {
        mapParameters.setMap(args[i + 1].getValue());
        Arg.setProcessed(args, i, 2, true);
      }
    }
  }
}