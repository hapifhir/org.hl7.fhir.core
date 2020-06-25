package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.IWorkerContext.ValidationResult;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.TerminologyServiceErrorClass;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class ValueSetValidator extends BaseValidator {

  public ValueSetValidator(IWorkerContext context, TimeTracker timeTracker) {
    super(context);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
  }
  
  public void validateValueSet(List<ValidationMessage> errors, Element vs, NodeStack stack) {
    if (!VersionUtilities.isR2Ver(context.getVersion())) {
      List<Element> composes = vs.getChildrenByName("compose");
      int cc = 0;
      for (Element compose : composes) {
        validateValueSetCompose(errors, compose, stack.push(compose, cc, null, null));
        cc++;
      }
    }
  }

  private void validateValueSetCompose(List<ValidationMessage> errors, Element compose, NodeStack stack) {
    List<Element> includes = compose.getChildrenByName("include");
    int ci = 0;
    for (Element include : includes) {
      validateValueSetInclude(errors, include, stack.push(include, ci, null, null));
      ci++;
    }    
    List<Element> excludes = compose.getChildrenByName("exclude");
    int ce = 0;
    for (Element exclude : excludes) {
      validateValueSetInclude(errors, exclude, stack.push(exclude, ce, null, null));
      ce++;
    }    
  }
  
  private void validateValueSetInclude(List<ValidationMessage> errors, Element include, NodeStack stack) {
    String system = include.getChildValue("system");
    String version = include.getChildValue("version");
    boolean systemOk = true;
    List<Element> concepts = include.getChildrenByName("concept");
    List<Element> filters = include.getChildrenByName("filter");
    if (!Utilities.noString(system)) {
      int cc = 0;
      for (Element concept : concepts) {
        if (systemOk && !validateValueSetIncludeConcept(errors, concept, stack.push(concept, cc, null, null), system, version)) {
          systemOk = false;
        }
        cc++;
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

  private boolean validateValueSetIncludeFilter(List<ValidationMessage> errors, Element include, NodeStack push, String system, String version) {
    return true;
  }
}
