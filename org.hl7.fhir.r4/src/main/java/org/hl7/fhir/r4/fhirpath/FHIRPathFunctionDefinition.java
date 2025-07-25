package org.hl7.fhir.r4.fhirpath;

import org.hl7.fhir.r4.model.Base;

import java.util.List;

public abstract class FHIRPathFunctionDefinition {
  public abstract String name();

  public abstract FHIRPathUtilityClasses.FunctionDetails details();

  public abstract TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters);

  public abstract List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters);
}
