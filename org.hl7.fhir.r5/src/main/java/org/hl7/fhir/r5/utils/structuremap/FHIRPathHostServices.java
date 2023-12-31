package org.hl7.fhir.r5.utils.structuremap;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.util.ArrayList;
import java.util.List;

public class FHIRPathHostServices implements FHIRPathEngine.IEvaluationContext {

  private final StructureMapUtilities structureMapUtilities;

  public FHIRPathHostServices(StructureMapUtilities structureMapUtilities) {
    this.structureMapUtilities = structureMapUtilities;
  }

  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    Variables vars = (Variables) appContext;
    Base res = vars.get(VariableMode.INPUT, name);
    if (res == null)
      res = vars.get(VariableMode.OUTPUT, name);
    List<Base> result = new ArrayList<Base>();
    if (res != null)
      result.add(res);
    return result;
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
    if (!(appContext instanceof VariablesForProfiling))
      throw new Error("Internal Logic Error (wrong type '" + appContext.getClass().getName() + "' in resolveConstantType)");
    VariablesForProfiling vars = (VariablesForProfiling) appContext;
    VariableForProfiling v = vars.get(null, name);
    if (v == null)
      throw new PathEngineException("Unknown variable '" + name + "' from variables " + vars.summary());
    return v.getProperty().getTypes();
  }

  @Override
  public boolean log(String argument, List<Base> focus) {
    throw new Error("Not Implemented Yet");
  }

  @Override
  public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    return null; // throw new Error("Not Implemented Yet");
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    throw new Error("Not Implemented Yet");
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    throw new Error("Not Implemented Yet");
  }

  @Override
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) throws FHIRException {
    if (structureMapUtilities.getServices() == null)
      return null;
    return structureMapUtilities.getServices().resolveReference(appContext, url);
  }

  private boolean noErrorValidationMessages(List<ValidationMessage> valerrors) {
    boolean ok = true;
    for (ValidationMessage v : valerrors)
      ok = ok && !v.getLevel().isError();
    return ok;
  }

  @Override
  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = structureMapUtilities.getWorker().newValidator();
    List<ValidationMessage> valerrors = new ArrayList<ValidationMessage>();
    if (item instanceof Resource) {
      val.validate(appContext, valerrors, (Resource) item, url);
      return noErrorValidationMessages(valerrors);
    }
    if (item instanceof Element) {
      val.validate(appContext, valerrors, null, (Element) item, url);
      return noErrorValidationMessages(valerrors);
    }
    throw new NotImplementedException("Not done yet (FHIRPathHostServices.conformsToProfile), when item is not element or not resource");
  }

  @Override
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url) {
	return structureMapUtilities.getWorker().fetchResource(ValueSet.class, url);
  }

  @Override
  public boolean paramIsType(String name, int index) {
    return false;
  }
}
