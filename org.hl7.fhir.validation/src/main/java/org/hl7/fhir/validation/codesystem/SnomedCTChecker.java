package org.hl7.fhir.validation.codesystem;

import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class SnomedCTChecker extends CodeSystemChecker {
  private boolean noTag = false;
  private boolean hasTag = false;
  
  public SnomedCTChecker(IWorkerContext context, XVerExtensionManager xverManager, boolean debug, List<ValidationMessage> errors) {
    super(context, xverManager, debug, errors);
  }
  
  public void checkConcept(String code, String display) {
    super.checkConcept(code, display);
    if (!Utilities.noString(display)) {
      boolean tagged = display.endsWith(")") && display.indexOf("(") > display.length() - 20;
      if (tagged) {
        hasTag = true;
      } else {
        noTag = true;
      }      
    }
  }
  public void finish(Element inc, NodeStack stack) {
    super.finish(inc, stack);
    hint(errors, "2023-07-21", IssueType.BUSINESSRULE, inc.line(), inc.col(), stack.getLiteralPath(), !(noTag && hasTag), I18nConstants.VALUESET_CONCEPT_DISPLAY_SCT_TAG_MIXED);           
  }
}
