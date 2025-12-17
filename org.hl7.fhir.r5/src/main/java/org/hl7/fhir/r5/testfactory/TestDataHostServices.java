package org.hl7.fhir.r5.testfactory;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.BaseHostServices;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.liquid.GlobalObject;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;

@MarkedToMoveToAdjunctPackage
public class TestDataHostServices extends BaseHostServices {

  private DateTimeType dt;
  private DateType dtD;
  private StringType pathToSpec;
  
  public TestDataHostServices(SimpleWorkerContext context, DateTimeType dt, DateType dtD, StringType pathToSpec) {
    super(context);
    this.dt = dt;
    this.dtD = dtD;
    this.pathToSpec = pathToSpec;
  }

  
  @Override
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    if ("Globals".equals(name)) {
      List<Base> list = new ArrayList<Base>();
      list.add(new GlobalObject(dt, dtD, pathToSpec));
      return list;
    } else {
      return new ArrayList<>();
    }
  }

  @Override
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
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

  public Base findContainingResource(Object appContext, Base item) {
    return null;
  }
}
