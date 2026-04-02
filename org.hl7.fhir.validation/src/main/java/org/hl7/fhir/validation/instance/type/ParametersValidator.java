package org.hl7.fhir.validation.instance.type;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

import java.util.List;

public class ParametersValidator extends BaseValidator {


  public ParametersValidator(BaseValidator parent) {
    super(parent);
  }

  public boolean validateParameters(ValidationContext valContext, List<ValidationMessage> errors, Element element, NodeStack stack) {
    boolean ok = true;
    List<Element> ParameterList = element.getChildrenByName("parameter");
    int cc = 0;
    for (Element parameter : ParameterList) {
      ok = validateParameter(valContext, errors, parameter, stack.push(parameter, cc, null, null)) && ok;
      cc++;
    }
    return ok;
  }

  private boolean validateParameter(ValidationContext valContext, List<ValidationMessage> errors, Element parameter, NodeStack stack) {
    String name = parameter.getNamedChildValue("name");
    String type = parameter.hasChild("value") ? parameter.getNamedChild("value").fhirType() : null;
    boolean res = parameter.hasChild("resource");
    switch (name) {
      case "default-canonical-version":
      case "system-version":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"), 1, I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "_count":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "integer"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "integer");
        }
        break;
      case "_since":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "instant"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "instant");
        }
        break;
      case "_type":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "abstract":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "account":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "activeOnly":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "activityDefinition":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "additions":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "async":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "chargeItem":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "check-system-version":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "client":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "code":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code", "string", "Coding"),3,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code, string, Coding");
        }
        break;
      case "codeA":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "codeableConcept":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "codeB":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "codeSystem":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "coding":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "codingA":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "codingB":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "collector":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "compositional":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "concept":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "conceptMap":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "conceptMapVersion":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "content":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "context":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "contextDirection":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "count":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "integer"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "integer");
        }
        break;
      case "date":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "dateTime"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "dateTime");
        }
        break;
      case "default":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "definition":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "attribute":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "value":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
        }
        break;
      case "designation":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "additionalUse":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "language":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "use":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "display":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "displayLanguage":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "duration":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "decimal"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "decimal");
        }
        break;
      case "encounter":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "end":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "date", "dateTime"),3,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "date, dateTime");
        }
        break;
      case "eventsSinceNumber":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "integer64"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "integer64");
        }
        break;
      case "eventsUntilNumber":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "integer64"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "integer64");
        }
        break;
      case "exact":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "exclude-system":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type,  "canonical");
        }
        break;
      case "excludeNested":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "excludeNotForUI":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "excludePostCoordinated":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "expiration":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "dateTime"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "dateTime");
        }
        break;
      case "filter":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "force-system-version":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "graph":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "id":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "id", "string"),2,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "id", "string");
        }
        break;
      case "identifier":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Identifier"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Identifier");
        }
        break;
      case "include":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "includeDefinition":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "includeDesignations":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "intersection":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "issues":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "lastReceivedOn":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "dateTime"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "dateTime");
        }
        break;
      case "left":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "limit":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "positiveInt"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "positiveInt");
        }
        break;
      case "local":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "location":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "comment":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "originMap":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "uri":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "relationship":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "max":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "positiveInt"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "positiveInt");
        }
        break;
      case "measure":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "measureReport":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "message":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "meta":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Meta"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Meta");
        }
        break;
      case "mode":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "name":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code", "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "offset":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "integer"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "integer");
        }
        break;
      case "on-demand":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "onlyCertainMatches":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "organization":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "outcome":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "parameters":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "patient":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "id"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "id");
        }
        break;
      case "period":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Period"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Period");
        }
        break;
      case "periodEnd":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "date"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "date");
        }
        break;
      case "periodStart":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "date"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "date");
        }
        break;
      case "persist":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "planDefinition":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "practitioner":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "preferredOnly":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "preview":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "probes":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "profile":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "property":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code", "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code, string");
        }
        break;
      case "description":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "source":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri", "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri, canonical");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "provider":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "query":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "removals":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "reportType":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "resource":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "response-url":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "url"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "url");
        }
        break;
      case "result":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean", "string"),2,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean, string");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "result-patient":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "return":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Meta"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Meta");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "right":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "server":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical", "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "setting":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "settingContext":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "source-patient":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "source-patient-identifier":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Identifier"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Identifier");
        }
        break;
      case "sourceCode":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "sourceCodeableConcept":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "sourceCoding":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Coding"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Coding");
        }
        break;
      case "sourceMap":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "sourceScope":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "sourceType":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "specimenDefinition":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "srcMap":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "start":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "date", "dateTime"),2,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "date, dateTime");
        }
        break;
      case "statistic":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "statistics":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "status":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "subject":
        if (type != null) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string", "uri"),2,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string, uri");
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case "subscription":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "supportedOnly":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "supportingMap":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "system":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "systemVersion":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "target":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "target-patient":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "target-patient-identifier":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "Identifier"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "Identifier");
        }
        break;
      case "targetCode":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "targetCodeableConcept":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "targetCoding":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "targetIdentifer.preferred":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "boolean"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "boolean");
        }
        break;
      case "targetIdentifier":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "targetScope":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "targetSystem":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "uri"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "uri");
        }
        break;
      case "targetType":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code");
        }
        break;
      case "token":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "topic":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "type":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept", "code"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "union":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "url":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical", "string", "uri"),3,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical, string, uri");
        }
        break;
      case "usageContext":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "UsageContext"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "UsageContext");
        }
        break;
      case "userLanguage":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "userTaskContext":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "userType":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "CodeableConcept"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "CodeableConcept");
        }
        break;
      case "useSupplement":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "canonical"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "canonical");
        }
        break;
      case "valueSet":
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case "valueSetVersion":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "version":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "code", "string"),2,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "code, string");
        }
        break;
      case "ward":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "string"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "string");
        }
        break;
      case "websocket-url":
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, Utilities.existsInList(type, "url"),1,  I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, "url");
        }
        break;
    }
    return true;
  }


}
