package org.hl7.fhir.r5.utils.structuremap;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.FHIRPathEngine;
import org.hl7.fhir.r5.utils.IResourceValidator;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import java.util.ArrayList;
import java.util.List;

public class FFHIRPathHostServices implements FHIRPathEngine.IEvaluationContext {

  private final StructureMapUtilities structureMapUtilities;

  public FFHIRPathHostServices(StructureMapUtilities structureMapUtilities) {
    this.structureMapUtilities = structureMapUtilities;
  }

  public Base resolveConstant(Object appContext, String name, boolean beforeContext) throws PathEngineException {
    Variables vars = (Variables) appContext;
    Base res = vars.get(VariableMode.INPUT, name);
    if (res == null)
      res = vars.get(VariableMode.OUTPUT, name);
    return res;
  }

  @Override
  public TypeDetails resolveConstantType(Object appContext, String name) throws PathEngineException {
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
  public FunctionDetails resolveFunction(String functionName) {
    return null; // throw new Error("Not Implemented Yet");
  }

  @Override
  public TypeDetails checkFunction(Object appContext, String functionName, List<TypeDetails> parameters) throws PathEngineException {
    throw new Error("Not Implemented Yet");
  }

  @Override
  public List<Base> executeFunction(Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    throw new Error("Not Implemented Yet");
  }

  @Override
  public Base resolveReference(Object appContext, String url, Base refContext) throws FHIRException {
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
  public boolean conformsToProfile(Object appContext, Base item, String url) throws FHIRException {
    IResourceValidator val = structureMapUtilities.getWorker().newValidator();
    List<ValidationMessage> valerrors = new ArrayList<ValidationMessage>();
    if (item instanceof Resource) {
      val.validate(appContext, valerrors, (Resource) item, url);
      return noErrorValidationMessages(valerrors);
    }
    if (item instanceof Element) {
      val.validate(appContext, valerrors, (Element) item, url);
      return noErrorValidationMessages(valerrors);
    }
    throw new NotImplementedException("Not done yet (FFHIRPathHostServices.conformsToProfile), when item is not element or not resource");
  }

  @Override
  public ValueSet resolveValueSet(Object appContext, String url) {
    throw new Error("Not Implemented Yet");
  }

}
