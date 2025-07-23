package org.hl7.fhir.r5.fhirpath;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.terminologies.TerminologyFunctions;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.i18n.I18nConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseHostServices implements IHostApplicationServices {

  protected IWorkerContext context;
  protected Map<String, FHIRPathFunctionDefinition> functions = new HashMap<>();

  public BaseHostServices(IWorkerContext context) {
    this.context = context;
  }

  @Override
  public FHIRPathUtilityClasses.FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
    FHIRPathFunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.details();
  }

  @Override
  public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus, List<TypeDetails> parameters) throws PathEngineException {
    FHIRPathFunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.check(engine, appContext, focus, parameters);
  }

  @Override
  public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName, List<List<Base>> parameters) {
    FHIRPathFunctionDefinition fd = functions.get(functionName);
    return fd == null ? null : fd.execute(engine, appContext, focus, parameters);
  }

  public BaseHostServices registerFunction(FHIRPathFunctionDefinition function) {
    functions.put(function.name(), function);
    return this;
  }

  public TypeDetails resolveConstantType(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    if (mode == FHIRPathConstantEvaluationMode.EXPLICIT && name.equals("terminologies")) {
      return new TypeDetails(ExpressionNode.CollectionStatus.SINGLETON, "TerminologyServices");
    } else {
      throw makeException(I18nConstants.FHIRPATH_UNKNOWN_CONSTANT, name);
    }
  }

  protected FHIRException makeException(String constName, Object... args) {
    String fmt = context.formatMessage(constName, args);
    return new PathEngineException(fmt, constName);
  }

  public List<Base> resolveConstant(FHIRPathEngine engine, Object appContext, String name, FHIRPathConstantEvaluationMode mode) throws PathEngineException {
    if (mode == FHIRPathConstantEvaluationMode.EXPLICIT && name.equals("terminologies")) {
      List<Base> res = new ArrayList<>();
      res.add(new TerminologyFunctions.TerminologiesObject());
      return res;
    } else {
      throw makeException(I18nConstants.FHIRPATH_UNKNOWN_CONSTANT, name);
    }
  }

}
