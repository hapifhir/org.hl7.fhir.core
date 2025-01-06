package org.hl7.fhir.r5.testfactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.IEvaluationContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.liquid.GlobalObject;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.ValueSet;

public class TestDataHostServices implements IEvaluationContext  {

  private SimpleWorkerContext context;
  private DateTimeType dt;
  private StringType pathToSpec;
  private Map<String, FunctionDefinition> functions = new HashMap<>();
  
  public TestDataHostServices(SimpleWorkerContext context, DateTimeType dt, StringType pathToSpec) {
    super();
    this.context = context;
    this.dt = dt;
    this.pathToSpec = pathToSpec;
  }

  public TestDataHostServices registerFunction(FunctionDefinition function) {
    functions.put(function.name(), function);
    return this;
  }
  
  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    if ("Globals".equals(name)) {
      List<Base> list = new ArrayList<Base>();
      list.add(new GlobalObject(dt, pathToSpec));
      return list;
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
    if ("Globals".equals(name)) {
      return new TypeDetails(CollectionStatus.SINGLETON, "GlobalObject");
    } else {
      return null; // whatever it is, we don't know about it.
    }
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }
  
  @Override
  public boolean log(String argument, List<Base> focus) {
    return false;
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    FunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.details();
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    FunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.check(engine, appContext, focus, parameters);
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    FunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.execute(engine, appContext, focus, parameters);
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) {
    return null;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    throw new NotImplementedException("Not done yet (TestDataHostServices.conformsToProfile)");
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
    throw new NotImplementedException("Not done yet (TestDataHostServices.resolveValueSet)"); // cause I don't know when we 'd need to do this
  }

}
