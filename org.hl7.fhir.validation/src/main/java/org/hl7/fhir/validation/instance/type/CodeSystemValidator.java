package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class CodeSystemValidator  extends BaseValidator {

  public CodeSystemValidator(IWorkerContext context, TimeTracker timeTracker) {
    super(context);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
  }
  
  public void validateCodeSystem(List<ValidationMessage> errors, Element cs, NodeStack stack) {
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
        if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.hasCompose() && !vs.hasExpansion(), I18nConstants.CODESYSTEM_CS_VS_MISMATCH, url, vsu))
          if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().size() == 1, I18nConstants.CODESYSTEM_CS_VS_INVALID, url, vsu))
            if (rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), vs.getCompose().getInclude().get(0).getSystem().equals(url), I18nConstants.CODESYSTEM_CS_VS_WRONGSYSTEM, url, vsu, vs.getCompose().getInclude().get(0).getSystem())) {
              rule(errors, IssueType.BUSINESSRULE, stack.getLiteralPath(), !vs.getCompose().getInclude().get(0).hasValueSet()
                && !vs.getCompose().getInclude().get(0).hasConcept() && !vs.getCompose().getInclude().get(0).hasFilter(), I18nConstants.CODESYSTEM_CS_VS_INCLUDEDETAILS, url, vsu);
            }
      }
    } // todo... try getting the value set the other way...
  }


}