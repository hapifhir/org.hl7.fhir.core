package org.hl7.fhir.r5.liquid;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathFunctionDefinition;
import org.hl7.fhir.r5.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

@MarkedToMoveToAdjunctPackage
public class GlobalObject extends Base {

  private DateTimeType dt;
  private DateType dtD;
  private StringType pathToSpec;
  
  public GlobalObject(DateTimeType td, DateType dtD, StringType pathToSpec) {
    super();
    this.dt = td;
    this.dtD = dtD;
    this.pathToSpec = pathToSpec;
  }

  @Override
  public String fhirType() {
    return "GlobalObject";
  }

  @Override
  public String getIdBase() {
    return null;
  }

  @Override
  public void setIdBase(String value) {
    throw new Error("Read only"); 
  }

  @Override
  public Base copy() {
    return this;
  }

  @Override
  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }

  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    if ("dateTime".equals(name)) {
      return wrap(dt);
    } else if ("date".equals(name)) {
        return wrap(dtD);
    } else if ("path".equals(name)) {
      return wrap(pathToSpec);
    } else {
      return super.getProperty(hash, name, checkValid);
    }
  }

  private Base[] wrap(Base b) {
    Base[] l = new Base[1];
    l[0] = b;
    return l;
  }
  
  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    return null;
  }

  public static class GlobalObjectRandomFunction extends FHIRPathFunctionDefinition {

    @Override
    public String name() {
      return "random";
    }

    @Override
    public FunctionDetails details() {
      return new FunctionDetails("Generate a Random Number", 1, 1);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      if (focus.hasType("GlobalObject")) {
        return new TypeDetails(CollectionStatus.SINGLETON, "integer");
      } else {
        return null;
      }
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      List<Base> list = new ArrayList<>();
      int scale = Utilities.parseInt(parameters.get(0).get(0).primitiveValue(), 100)+ 1;
      list.add(new IntegerType((int)(Math.random() * scale)));
      return list;
    }
    
  }
}