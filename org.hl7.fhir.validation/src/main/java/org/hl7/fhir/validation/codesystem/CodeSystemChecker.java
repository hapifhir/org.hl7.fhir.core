package org.hl7.fhir.validation.codesystem;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class CodeSystemChecker extends BaseValidator {

  private boolean noDisplay = false;
  private boolean hasDisplay = false;
  protected List<ValidationMessage> errors;
  
  protected CodeSystemChecker(IWorkerContext context, XVerExtensionManager xverManager, boolean debug, List<ValidationMessage> errors) {
    super(context, xverManager, debug);
    this.errors = errors;
  }
  
  public void checkConcept(String code, String display) {
    if (Utilities.noString(display)) {
      noDisplay = true;
    } else {
      hasDisplay = true;
    }      
  }
  
  public void finish(Element inc, NodeStack stack) {
    hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noDisplay && hasDisplay), I18nConstants.VALUESET_CONCEPT_DISPLAY_PRESENCE_MIXED);           
  } 
  
}