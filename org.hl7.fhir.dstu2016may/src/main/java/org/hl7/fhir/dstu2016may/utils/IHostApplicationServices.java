package org.hl7.fhir.dstu2016may.utils;

import org.hl7.fhir.dstu2016may.model.Base;
import org.hl7.fhir.dstu2016may.model.ExpressionNode;
import org.hl7.fhir.dstu2016may.model.ExpressionNode.TypeDetails;
import org.hl7.fhir.dstu2016may.model.Type;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;

import java.util.List;

// if the fhir path expressions are allowed to use constants beyond those
// defined in the specification
// the application can implement them by providing a constant resolver
public interface IHostApplicationServices {
  public class FunctionDetails {
    private String description;
    private int minParameters;
    private int maxParameters;

    public FunctionDetails(String description, int minParameters, int maxParameters) {
      super();
      this.description = description;
      this.minParameters = minParameters;
      this.maxParameters = maxParameters;
    }

    public String getDescription() {
      return description;
    }

    public int getMinParameters() {
      return minParameters;
    }

    public int getMaxParameters() {
      return maxParameters;
    }

  }


  /**
   * A constant reference - e.g. a reference to a name that must be resolved in context.
   *
   * resolveConstant is invoked under 3 different circumstances, which are reflected in the mode parameter:
   *  * an explicit constant of the form %{token}, where the token isn't a known internal constant
   *  * every evaluation of any expression to allow the Host Application to decide whether to interpret the expression as a constant even if it is not explicitly a constant
   *  * at the start of evaluating an expression if the focus provided by the application when invoking the expression is {}
   *
   * The return value is a List<Base> - a collection, though most constants are singleton values
   *
   * note that variables created using defineVariable() in the FHIRPath expressions will not be processed by resolveConstant (or resolveConstantType)
   *
   * @param appContext - application context passed into the FHIRPath engine when first executed
   * @param name - name reference to resolve. if mode = EXPLICIT, the % will NOT be in the name
   * @param mode - what situation the reference comes from - see the documentation for @FHIRPathConstantEvaluationMode
   * @return the value of the constant , or an empty list, though the host application can choose to throw an exception
   */
  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException;


  /**
   * Compile time support for a constant reference - e.g. a reference to a name that must be resolved in context.
   *
   * resolveConstant is invoked under 3 different circumstances, which are reflected in the mode parameter:
   *  * an explicit constant of the form %{token}, where the token isn't a known internal constant
   *  * every evaluation of any expression to allow the Host Application to decide whether to interpret the expression as a constant even if it is not explicitly a constant
   *  * at the start of evaluating an expression if the focus provided by the application when invoking the expression is {}
   *
   * The return value is a TypeDetails - a collection, though most constants are singleton values
   *
   * note that variables created using defineVariable() in the FHIRPath expressions will not be processed by resolveConstant (or resolveConstantType)
   *
   * @param appContext - application context passed into the FHIRPath engine when first executed
   * @param name - name reference to resolve. if mode = EXPLICIT, the % will NOT be in the name
   * @param mode - what situation the reference comes from - see the documentation for @FHIRPathConstantEvaluationMode
   * @return the type of the constant, or null, though the host application can choose to throw an exception
   */
  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException;

  public boolean Log(String argument, List<Base> focus);

  // extensibility for functions

  /**
   * @param functionName
   * @return null if the function is not known
   */
  public FunctionDetails resolveFunction(String functionName);

  /**
   * Check the function parameters, and throw an error if they are incorrect, or
   * return the type for the function
   *
   * @param functionName
   * @param parameters
   * @return
   */
  public ExpressionNode.TypeDetails checkFunction(Object appContext, String functionName, List<ExpressionNode.TypeDetails> parameters)
    throws PathEngineException;

  /**
   * @param appContext
   * @param functionName
   * @param parameters
   * @return
   */
  public List<Base> executeFunction(Object appContext, String functionName, List<List<Base>> parameters);
}
