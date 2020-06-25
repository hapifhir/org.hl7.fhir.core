package org.hl7.fhir.validation.instance.type;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.TimeTracker;
import org.hl7.fhir.validation.instance.utils.NodeStack;

public class SearchParameterValidator extends BaseValidator {

  public SearchParameterValidator(IWorkerContext context, TimeTracker timeTracker) {
    super(context);
    source = Source.InstanceValidator;
    this.timeTracker = timeTracker;
  }
  
  public void validateSearchParameter(List<ValidationMessage> errors, Element cs, NodeStack stack) {
    String url = cs.getNamedChildValue("url");
    String master = cs.getNamedChildValue("derivedFrom");
    
    if (!Utilities.noString(master)) {
      SearchParameter sp = context.fetchResource(SearchParameter.class, master);
      if (warning(errors, IssueType.BUSINESSRULE,stack.getLiteralPath(), sp != null, I18nConstants.SEARCHPARAMETER_NOTFOUND, master)) {
        // base must be in the master list of base
        List<Element> bl = cs.getChildren("base");
        for (Element b : bl) {
          rule(errors, IssueType.BUSINESSRULE,stack.getLiteralPath(), sp.hasBase(b.primitiveValue()), I18nConstants.SEARCHPARAMETER_BASE_WRONG, master, b.primitiveValue());
        }
        rule(errors, IssueType.BUSINESSRULE,stack.getLiteralPath(), !cs.hasChild("type") || sp.getType().toCode().equals(cs.getNamedChildValue("type")), I18nConstants.SEARCHPARAMETER_TYPE_WRONG, master, sp.getType().toCode(), cs.getNamedChildValue("type"));
        warning(errors, IssueType.BUSINESSRULE,stack.getLiteralPath(), !cs.hasChild("expression") || sp.getExpression().equals(cs.getNamedChildValue("expression")), I18nConstants.SEARCHPARAMETER_EXP_WRONG, master, sp.getExpression(), cs.getNamedChildValue("expression"));
        // todo: cjeck compositions
      }
    }
  }

}
