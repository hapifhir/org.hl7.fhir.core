package org.hl7.fhir.dstu3.support.terminologies;

import org.hl7.fhir.dstu3.model.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.dstu3.context.IWorkerContext;
import org.hl7.fhir.dstu3.fhirpath.*;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import java.util.ArrayList;
import java.util.List;

public class TerminologyFunctions {


  public static abstract class TerminologyFunctionBase extends FHIRPathFunctionDefinition {

    protected FHIRException makeExceptionPlural(FHIRPathEngine engine, Integer num, String constName, Object... args) {
      String fmt = engine.getWorker().formatMessage(constName, args);
      return new PathEngineException(fmt, constName);
    }


    protected FHIRException makeException(FHIRPathEngine engine, ExpressionNode holder, String constName, Object... args) {
      String fmt = engine.getWorker().formatMessage(constName, args);
      return new PathEngineException(fmt, constName);
    }
  }


  public static class TerminologiesObject extends Base {
    @Override
    public String fhirType() {
      return "TerminologyServices";
    }

    @Override
    protected void listChildren(List<Property> result) {

    }

    @Override
    public String getIdBase() {
      return null;
    }

    @Override
    public void setIdBase(String value) {
    }

  }

  public static class ExpandFunction extends TerminologyFunctionBase {

    @Override
    public String name() {
      return "expand";
    }

    @Override
    public FHIRPathUtilityClasses.FunctionDetails details() {
      return new FHIRPathUtilityClasses.FunctionDetails("Perform a value set expansion", 1, 2);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      return new TypeDetails(ExpressionNode.CollectionStatus.SINGLETON, "Resource");
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      if (focus.size() == 0) {
        return new ArrayList<Base>();
      }
      if (focus.size() != 1) {
        throw makeExceptionPlural(engine, focus.size(), I18nConstants.FHIRPATH_FOCUS, "expand", focus.size());
      }
      Base base = focus.get(0);
      List<Base> result = new ArrayList<Base>();
      if (base.fhirType().equals("TerminologyServices") && parameters.size() > 0) {
        List<Base> param1 = parameters.get(0);
        if (param1.size() != 1) {
          throw makeExceptionPlural(engine, param1.size(), I18nConstants.FHIRPATH_PARAMETER_CARD, "valueSet", focus.size());
        }
        ValueSet vs = null;
        if (param1.get(0).isPrimitive()) {
          vs = engine.getWorker().fetchResource(ValueSet.class, param1.get(0).primitiveValue());
        } else {
          // nothing
        }
        if (vs != null) {
          IWorkerContext.ValueSetExpansionOutcome exp = engine.getWorker().expandVS(vs, true, false);
          if (exp.isOk() && exp.getValueset() != null) {
            result.add(exp.getValueset());
          }
        } else {
          throw new Error("Not supported yet");
        }
      }
      return result;
    }
  }

  public static class ValidateVSFunction extends TerminologyFunctionBase {

    @Override
    public String name() {
      return "validateVS";
    }

    @Override
    public FHIRPathUtilityClasses.FunctionDetails details() {
      return new FHIRPathUtilityClasses.FunctionDetails("Validate a code against a ValueSet", 2, 3);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      return new TypeDetails(ExpressionNode.CollectionStatus.SINGLETON, "Parameters");
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      if (focus.size() == 0) {
        return new ArrayList<Base>();
      }
      if (focus.size() != 1) {
        throw makeExceptionPlural(engine, focus.size(), I18nConstants.FHIRPATH_FOCUS, "expand", focus.size());
      }
      Base base = focus.get(0);
      List<Base> result = new ArrayList<Base>();
      if (base.fhirType().equals("TerminologyServices") && parameters.size() > 1) {
        List<Base> param1 = parameters.get(0);
        if (param1.size() != 1) {
          throw makeExceptionPlural(engine, param1.size(), I18nConstants.FHIRPATH_PARAMETER_CARD, "valueSet", focus.size());
        }
        ValueSet vs = null;
        if (param1.get(0).isPrimitive()) {
          vs = engine.getWorker().fetchResource(ValueSet.class, param1.get(0).primitiveValue());
        } else {
          // nothing
        }
        if (vs != null) {
          List<Base> param2 = parameters.get(1);
          if (param2.size() != 1) {
            throw makeExceptionPlural(engine, param1.size(), I18nConstants.FHIRPATH_PARAMETER_CARD, "coded", focus.size());
          }
          Base coded = param2.get(0);
          if (coded.isPrimitive()) {
            throw new Error("Not supported yet");
          } else if ("Coding".equals(coded.fhirType())) {
            Coding coding = (Coding) coded;
            IWorkerContext.ValidationResult vr = engine.getWorker().validateCode(coding, vs);
            result.add(vr.getOrMakeParameters());
          } else if ("CodeableConcept".equals(coded.fhirType())) {
            CodeableConcept cc = (CodeableConcept) coded;
            IWorkerContext.ValidationResult vr = engine.getWorker().validateCode(cc, vs);
            result.add(vr.getOrMakeParameters());
          }
        }
      }
      return result;
    }
  }


  public static class TranslateFunction extends TerminologyFunctionBase {

    @Override
    public String name() {
      return "translate";
    }

    @Override
    public FHIRPathUtilityClasses.FunctionDetails details() {
      return new FHIRPathUtilityClasses.FunctionDetails("Translate from terminology to another", 2, 3);
    }

    @Override
    public TypeDetails check(FHIRPathEngine engine, Object appContext, TypeDetails focus, List<TypeDetails> parameters) {
      return new TypeDetails(ExpressionNode.CollectionStatus.SINGLETON, "Parameters");
    }

    @Override
    public List<Base> execute(FHIRPathEngine engine, Object appContext, List<Base> focus, List<List<Base>> parameters) {
      throw new Error("Not supported yet");
    }
  }

}
