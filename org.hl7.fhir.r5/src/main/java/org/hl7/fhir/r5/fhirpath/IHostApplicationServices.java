package org.hl7.fhir.r5.fhirpath;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;

import java.util.List;

/**
 * This interface allows the application making use of a FHIRPathEngine to provide
 * additional services that can be used in the FHIRPath statements. The services fall into
 * two categories: extending the FHIRPath engine with types, constants and functions, and
 * performing work that the FHIRPath engine doesn't know how to do itself
 *
 * Functionality:
 *  * resolveConstant()/resolveConstantType() - register constants
 *  * log() - do something when .log() is used in the FHIRPath statement
 *  * resolveFunction() / checkFunction() / executeFunction() - allow the application to define FHIRPath functions of it's own
 *  * resolveReference() - called when a FHIRPath statement uses 'resolve()' so the host application can attempt to resolve the reference
 *  * resolveValueSet() - called when memberOf() is used
 *  * conformsToProfile() - check that the content conforms to the stated profile. Used by the ValidationEngine - not generally suitable for applications to provide their own interface
 *  * paramIsType() - used when the FHIRPath statement
 *
 *  Note that his used to be called IEvaluationContext in the FHIRPathEngine class, but was renamed
 *  due to a broken interface - see comments at https://github.com/hapifhir/org.hl7.fhir.core/releases/tag/6.6.0
 */

public interface IHostApplicationServices {

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

  /**
   * when the .log() function is called
   *
   * @param argument
   * @param focus
   * @return
   */
  public boolean log(String argument, List<Base> focus);

  // extensibility for functions

  /**
   * @param functionName
   * @return null if the function is not known
   */
  public FHIRPathUtilityClasses.FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName);

  /**
   * Check the function parameters, and throw an error if they are incorrect, or return the type for the function
   *
   * @param functionName
   * @param parameters
   * @return
   */
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException;

  /**
   * @param appContext
   * @param functionName
   * @param parameters
   * @return
   */
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters);

  /**
   * Implementation of resolve() function. Passed a string, return matching resource, if one is known - else null
   *
   * @param url the reference (Reference.reference or the value of the canonical
   * @return
   * @throws FHIRException
   * @appContext - passed in by the host to the FHIRPathEngine
   */
  public Base resolveReference(FHIRPathEngine engine, Object appContext, String url, Base refContext) throws FHIRException;

  /**
   * given an item, return the resource that contains it.
   *
   * You can't tell this from the item itself
   *
   * @param appContext
   * @param item
   * @return
   */
  public Base findContainingResource(Object appContext, Base item);

  public boolean conformsToProfile(FHIRPathEngine engine, Object appContext, Base item, String url) throws FHIRException;

  /*
   * return the value set referenced by the url, which has been used in memberOf()
   */
  public ValueSet resolveValueSet(FHIRPathEngine engine, Object appContext, String url);

  /**
   * For the moment, there can only be one parameter if it's a type parameter
   *
   * @param name
   * @return true if it's a type parameter
   */
  public boolean paramIsType(String name, int index);
}
