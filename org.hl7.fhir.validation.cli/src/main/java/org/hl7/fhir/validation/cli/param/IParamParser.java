package org.hl7.fhir.validation.cli.param;


public interface IParamParser<T> {

  public T getParameterObject();

  public void parseArgs(Arg[] args);

}
