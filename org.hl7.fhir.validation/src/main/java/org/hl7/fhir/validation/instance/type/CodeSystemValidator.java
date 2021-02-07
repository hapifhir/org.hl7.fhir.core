package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

import ca.uhn.fhir.validation.ValidationResult;

public class CodeSystemValidator  extends BaseValidator {

  public CodeSystemValidator(IWorkerContext context, TimeTracker timeTracker, XVerExtensionManager xverManager) {
    super(context, xverManager);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
  }
  
  public void validateCodeSystem(List<ValidationMessage> errors, Element cs, NodeStack stack, ValidationOptions options) {
    String url = cs.getNamedChildValue("url");
    String content = cs.getNamedChildValue("content");
    
    String vsu = cs.getNamedChildValue("valueSet");
    if (!Utilities.noString(vsu)) {
      hint(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), "complete".equals(content), I18nConstants.CODESYSTEM_CS_NO_VS_NOTCOMPLETE);
      ValueSet vs;
      try {
        vs = context.fetchResourceWithException(ValueSet.class, vsu);
      } catch (FHIRException e) {
        vs = null;
      }
      if (vs != null) {
        if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.hasCompose(), I18nConstants.CODESYSTEM_CS_VS_INVALID, url, vsu)) { 
          if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().size() == 1, I18nConstants.CODESYSTEM_CS_VS_INVALID, url, vsu)) {
            if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().get(0).getSystem().equals(url), I18nConstants.CODESYSTEM_CS_VS_WRONGSYSTEM, url, vsu, vs.getCompose().getInclude().get(0).getSystem())) {
              rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !vs.getCompose().getInclude().get(0).hasValueSet()
                && !vs.getCompose().getInclude().get(0).hasConcept() && !vs.getCompose().getInclude().get(0).hasFilter(), I18nConstants.CODESYSTEM_CS_VS_INCLUDEDETAILS, url, vsu);
              if (vs.hasExpansion()) {
                int count = countConcepts(cs); 
                rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getExpansion().getContains().size() == count, I18nConstants.CODESYSTEM_CS_VS_EXP_MISMATCH, url, vsu, count, vs.getExpansion().getContains().size());
              }
            }
          }
        }
      }
    } // todo... try getting the value set the other way...
    
    String supp = cs.getNamedChildValue("supplements");
    if (supp != null) {
      if (context.supportsSystem(supp)) {
        List<Element> concepts = cs.getChildrenByName("concept");
        int ce = 0;
        for (Element concept : concepts) {
          validateSupplementConcept(errors, concept, stack.push(concept, ce, null, null), supp, options);
          ce++;
        }    
      } else {
        if (cs.hasChildren("concept")) {
          warning(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), false, I18nConstants.CODESYSTEM_CS_SUPP_CANT_CHECK, supp);
        }
      }
    }
  }

  private void validateSupplementConcept(List<ValidationMessage> errors, Element concept, NodeStack stack, String supp, ValidationOptions options) {
    String code = concept.getChildValue("code");
    if (!Utilities.noString(code)) {
      org.hl7.fhir.r5.context.IWorkerContext.ValidationResult res = context.validateCode(options, supp, code, null);
      rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), res.isOk(), I18nConstants.CODESYSTEM_CS_SUPP_INVALID_CODE, supp, code);
    }
    
  }

  private int countConcepts(Element cs) {
    List<Element> concepts = cs.getChildrenByName("concept");
    int res = concepts.size();
    for (Element concept : concepts) {
      res = res + countConcepts(concept);
    }
    return res;
  }


}