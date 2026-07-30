package org.hl7.fhir.r5.utils.structuremap;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import java.util.List;

@MarkedToMoveToAdjunctPackage
public interface ITransformerServices {
  //    public boolean validateByValueSet(Coding code, String valuesetId);
  public void log(String message); // log internal progress

  public Base createType(Object appInfo, String name, ProfileUtilities profileUtilities) throws FHIRException;

  public Base createResource(Object appInfo, Base res, boolean atRootofTransform); // an already created resource is provided; this is to identify/store it

  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException;

  //    public Coding translate(Coding code)
  //    ValueSet validation operation
  //    Translation operation
  //    Lookup another tree of data
  //    Create an instance tree
  //    Return the correct string format to refer to a tree (input or output)
  public Base resolveReference(Object appContext, String url) throws FHIRException;

  public List<Base> performSearch(Object appContext, String url) throws FHIRException;

  // FHIRPath custom-function hooks (see IHostApplicationServices). Default implementations
  // preserve the previous hardcoded FHIRPathHostServices behavior for callers that don't
  // override them, so adding these methods is backward-compatible.
  default FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    return null;
  }

  default TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters)
      throws PathEngineException {
    throw new PathEngineException("Unknown function '" + functionName + "'");
  }

  default List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    throw new Error("Not Implemented Yet");
  }
}
