package org.hl7.fhir.validation.instance.type;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.CodingValidationRequest;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class ValueSetValidator extends BaseValidator {

  public class VSCodingValidationRequest extends CodingValidationRequest {

    private NodeStack stack;

    public VSCodingValidationRequest(NodeStack stack, Coding code) {
      super(code);
      this.stack = stack;
    }

    public NodeStack getStack() {
      return stack;
    }
    
  }

  private InstanceValidator parent;

  public ValueSetValidator(IWorkerContext context, TimeTracker timeTracker, InstanceValidator parent, XVerExtensionManager xverManager) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
    this.parent = parent;
  }
  
  public void validateValueSet(List<ValidationMessage> errors, Element vs, NodeStack stack) {
    if (!VersionUtilities.isR2Ver(context.getVersion())) {
      List<Element> composes = vs.getChildrenByName("compose");
      int cc = 0;
      for (Element compose : composes) {
        validateValueSetCompose(errors, compose, stack.push(compose, cc, null, null), vs.getNamedChildValue("url"), "retired".equals(vs.getNamedChildValue("url")));
        cc++;
      }
    }
  }

  private void validateValueSetCompose(List<ValidationMessage> errors, Element compose, NodeStack stack, String vsid, boolean retired) {
    List<Element> includes = compose.getChildrenByName("include");
    int ci = 0;
    for (Element include : includes) {
      validateValueSetInclude(errors, include, stack.push(include, ci, null, null), vsid, retired);
      ci++;
    }    
    List<Element> excludes = compose.getChildrenByName("exclude");
    int ce = 0;
    for (Element exclude : excludes) {
      validateValueSetInclude(errors, exclude, stack.push(exclude, ce, null, null), vsid, retired);
      ce++;
    }    
  }
  
  private void validateValueSetInclude(List<ValidationMessage> errors, Element include, NodeStack stack, String vsid, boolean retired) {
    String system = include.getChildValue("system");
    String version = include.getChildValue("version");
    List<Element> valuesets = include.getChildrenByName("valueSet");
    int i = 0;
    for (Element ve : valuesets) {
      String v = ve.getValue();
      ValueSet vs = context.fetchResource(ValueSet.class, v);
      if (vs == null) {
        NodeStack ns = stack.push(ve, i, ve.getProperty().getDefinition(), ve.getProperty().getDefinition());

        Resource rs = context.fetchResource(Resource.class, v);
        if (rs != null) {
          warning(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), false, I18nConstants.VALUESET_REFERENCE_INVALID_TYPE, v, rs.fhirType());                      
        } else {
          warning(errors, IssueType.BUSINESSRULE, ns.getLiteralPath(), false, I18nConstants.VALUESET_REFERENCE_UNKNOWN, v);            
        }
      }
      i++;
    }
    List<Element> concepts = include.getChildrenByName("concept");
    List<Element> filters = include.getChildrenByName("filter");
    if (!Utilities.noString(system)) {
      boolean systemOk = true;
      int cc = 0;
      List<VSCodingValidationRequest> batch = new ArrayList<>();
      boolean first = true;
      for (Element concept : concepts) {
        // we treat the first differently because we want to know if tbe system is worth validating. if it is, then we batch the rest
        if (first) {
          systemOk = validateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version);
          first = false;
        } else if (systemOk) {
          batch.add(prepareValidateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version));
        }
        cc++;
      }    
      if (parent.isValidateValueSetCodesOnTxServer() && batch.size() > 0) {
        long t = System.currentTimeMillis();
        if (parent.isDebug()) {
          System.out.println("  : Validate "+batch.size()+" codes from "+system+" for "+vsid);
        }
        context.validateCodeBatch(ValidationOptions.defaults(), batch, null);
        if (parent.isDebug()) {
          System.out.println("  :   .. "+(System.currentTimeMillis()-t)+"ms");
        }
        for (VSCodingValidationRequest cv : batch) {
          if (version == null) {
            warningOrHint(errors, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, cv.getCoding().getCode());
          } else {
            warningOrHint(errors, IssueType.BUSINESSRULE, cv.getStack().getLiteralPath(), cv.getResult().isOk(), !retired, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, cv.getCoding().getCode());
          }
        }
      }
      
      int cf = 0;
      for (Element filter : filters) {
        if (systemOk && !validateValueSetIncludeFilter(errors, include, stack.push(filter, cf, null, null), system, version)) {
          systemOk = false;          
        }
        cf++;
      }    
      warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), systemOk, version == null ? I18nConstants.VALUESET_UNC_SYSTEM_WARNING :  I18nConstants.VALUESET_UNC_SYSTEM_WARNING_VER);            
    } else {
      warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), filters.size() == 0 && concepts.size() == 0, I18nConstants.VALUESET_NO_SYSTEM_WARNING);      
    }
  }

  private boolean validateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version) {
    String code = concept.getChildValue("code");
    if (version == null) {
      ValidationResult vv = context.validateCode(ValidationOptions.defaults(), new Coding(system, code, null), null);
      if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
        return false;
      } else {
        boolean ok = vv.isOk();
        warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE, system, code);
      }
    } else {
      ValidationResult vv = context.validateCode(ValidationOptions.defaults(), new Coding(system, code, null).setVersion(version), null);
      if (vv.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED) {
        return false;        
      } else {
        boolean ok = vv.isOk();
        warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), ok, I18nConstants.VALUESET_INCLUDE_INVALID_CONCEPT_CODE_VER, system, version, code);
      }
    }
    return true;
  }

  private VSCodingValidationRequest prepareValidateValueSetIncludeConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String system, String version) {
    String code = concept.getChildValue("code");
    Coding c = new Coding(system, code, null);
    if (version != null) {
       c.setVersion(version);
    }
    return new VSCodingValidationRequest(stack, c);
  }

  private boolean validateValueSetIncludeFilter(List<ValidationMessage> errors, Element include, NodeStack push, String system, String version) {
    return true;
  }
}
