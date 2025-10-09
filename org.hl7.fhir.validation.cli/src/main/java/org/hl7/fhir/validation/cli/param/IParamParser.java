package org.hl7.fhir.validation.cli.param;

import java.util.List;

public interface IParamParser<T> {

  public T getParameterObject();

  public void parseArgs(Arg[] args);

}
