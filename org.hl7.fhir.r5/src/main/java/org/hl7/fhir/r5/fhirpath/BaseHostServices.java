package org.hl7.fhir.r5.fhirpath;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.terminologies.TerminologyFunctions;
import org.hl7.fhir.r5.testfactory.TestDataHostServices;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseHostServices implements FHIRPathEngine.IEvaluationContext {

  protected IWorkerContext context;
  protected Map<String, FunctionDefinition> functions = new HashMap<>();

  public BaseHostServices(IWorkerContext context) {
    this.context = context;
  }

  @Override
  public FHIRPathUtilityClasses.FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
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

  public BaseHostServices registerFunction(FunctionDefinition function) {
    functions.put(function.name(), function);
    return this;
  }

  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, boolean explicitConstant) throws PathEngineException {
    if (name.equals("%terminologies")) {
      return new TypeDetails(ExpressionNode.CollectionStatus.SINGLETON, "TerminologyServices");
    } else {
      throw makeException(I18nConstants.FHIRPATH_UNKNOWN_CONSTANT, name);
    }
  }

  protected FHIRException makeException(String constName, Object... args) {
    String fmt = context.formatMessage(constName, args);
    return new PathEngineException(fmt, constName);
  }

  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, boolean beforeContext, boolean explicitConstant) throws PathEngineException {
    if (name.equals("terminologies")) {
      List<Base> res = new ArrayList<>();
      res.add(new TerminologyFunctions.TerminologiesObject());
      return res;
    } else {
      throw makeException(I18nConstants.FHIRPATH_UNKNOWN_CONSTANT, name);
    }
  }

}
