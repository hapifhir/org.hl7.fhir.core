package org.hl7.fhir.validation.cli.param.parsers;

import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.cli.param.IParamParser;
import org.hl7.fhir.validation.service.model.MapParameters;

import java.util.ArrayList;
import java.util.List;

public class UnprocessedParametersParser implements IParamParser<List<String>> {
  List<String> unprocessedParams =  new ArrayList<>();

  @Override
  public List<String> getParameterObject() {
    return unprocessedParams;
  }

  @Override
  public void parseArgs(Arg[] args) {
    for (Arg arg : args) {
      if (!arg.isProcessed()) {
        unprocessedParams.add(arg.getValue());
        arg.setProcessed(true);
      }
    }
  }
}
