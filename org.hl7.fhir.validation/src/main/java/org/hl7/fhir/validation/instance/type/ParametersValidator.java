package org.hl7.fhir.validation.instance.type;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.hl7.fhir.validation.instance.utils.ValidationContext;

import java.util.List;
import java.util.Map;

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

  private enum ParamKind { VALUE, RESOURCE, MIXED, ANY_VALUE }

  private record ParamRule(ParamKind kind, String... types) {}

  private static final Map<String, ParamRule> PARAM_RULES = Map.ofEntries(
    Map.entry("_count", new ParamRule(ParamKind.VALUE, "integer")),
    Map.entry("_since", new ParamRule(ParamKind.VALUE, "instant")),
    Map.entry("_type", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("abstract", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("account", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("activeOnly", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("activityDefinition", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("additions", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("async", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("chargeItem", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("check-system-version", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("client", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("code", new ParamRule(ParamKind.VALUE, "code", "string", "Coding")),
    Map.entry("codeA", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("codeableConcept", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("codeB", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("codeSystem", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("coding", new ParamRule(ParamKind.VALUE, "Coding")),
    Map.entry("codingA", new ParamRule(ParamKind.VALUE, "Coding")),
    Map.entry("codingB", new ParamRule(ParamKind.VALUE, "Coding")),
    Map.entry("collector", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("compositional", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("concept", new ParamRule(ParamKind.VALUE, "Coding")),
    Map.entry("conceptMap", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("conceptMapVersion", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("content", new ParamRule(ParamKind.MIXED, "code")),
    Map.entry("context", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("contextDirection", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("count", new ParamRule(ParamKind.VALUE, "integer")),
    Map.entry("date", new ParamRule(ParamKind.VALUE, "dateTime")),
    Map.entry("default", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("definition", new ParamRule(ParamKind.MIXED, "string")),
    Map.entry("designation", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("display", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("displayLanguage", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("duration", new ParamRule(ParamKind.VALUE, "decimal")),
    Map.entry("encounter", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("end", new ParamRule(ParamKind.VALUE, "date", "dateTime")),
    Map.entry("eventsSinceNumber", new ParamRule(ParamKind.VALUE, "integer64")),
    Map.entry("eventsUntilNumber", new ParamRule(ParamKind.VALUE, "integer64")),
    Map.entry("exact", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("exclude-system", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("excludeNested", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("excludeNotForUI", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("excludePostCoordinated", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("expiration", new ParamRule(ParamKind.VALUE, "dateTime")),
    Map.entry("filter", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("force-system-version", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("graph", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("id", new ParamRule(ParamKind.VALUE, "id", "string")),
    Map.entry("identifier", new ParamRule(ParamKind.VALUE, "Identifier")),
    Map.entry("include", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("includeDefinition", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("includeDesignations", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("intersection", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("issues", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("lastReceivedOn", new ParamRule(ParamKind.VALUE, "dateTime")),
    Map.entry("left", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("limit", new ParamRule(ParamKind.VALUE, "positiveInt")),
    Map.entry("local", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("location", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("max", new ParamRule(ParamKind.VALUE, "positiveInt")),
    Map.entry("measure", new ParamRule(ParamKind.MIXED, "string")),
    Map.entry("measureReport", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("message", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("meta", new ParamRule(ParamKind.VALUE, "Meta")),
    Map.entry("mode", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("name", new ParamRule(ParamKind.VALUE, "code", "string")),
    Map.entry("offset", new ParamRule(ParamKind.VALUE, "integer")),
    Map.entry("on-demand", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("onlyCertainMatches", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("organization", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("outcome", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("parameters", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("patient", new ParamRule(ParamKind.VALUE, "id")),
    Map.entry("period", new ParamRule(ParamKind.VALUE, "Period")),
    Map.entry("periodEnd", new ParamRule(ParamKind.VALUE, "date")),
    Map.entry("periodStart", new ParamRule(ParamKind.VALUE, "date")),
    Map.entry("persist", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("planDefinition", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("practitioner", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("preferredOnly", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("preview", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("probes", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("profile", new ParamRule(ParamKind.MIXED, "canonical")),
    Map.entry("property", new ParamRule(ParamKind.VALUE, "code", "string")),
    Map.entry("provider", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("query", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("removals", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("reportType", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("resource", new ParamRule(ParamKind.MIXED, "code")),
    Map.entry("response-url", new ParamRule(ParamKind.VALUE, "url")),
    Map.entry("result", new ParamRule(ParamKind.MIXED, "boolean", "string")),
    Map.entry("result-patient", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("return", new ParamRule(ParamKind.MIXED, "Meta")),
    Map.entry("right", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("server", new ParamRule(ParamKind.VALUE, "canonical", "uri")),
    Map.entry("setting", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("settingContext", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("source", new ParamRule(ParamKind.MIXED, "uri")),
    Map.entry("source-patient", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("source-patient-identifier", new ParamRule(ParamKind.VALUE, "Identifier")),
    Map.entry("sourceCode", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("sourceCodeableConcept", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("sourceCoding", new ParamRule(ParamKind.VALUE, "Coding")),
    Map.entry("sourceMap", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("sourceScope", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("sourceType", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("specimenDefinition", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("srcMap", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("start", new ParamRule(ParamKind.VALUE, "date", "dateTime")),
    Map.entry("statistic", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("statistics", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("status", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("subject", new ParamRule(ParamKind.MIXED, "string", "uri")),
    Map.entry("subscription", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("supportedOnly", new ParamRule(ParamKind.VALUE, "boolean")),
    Map.entry("supportingMap", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("system", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("system-version", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("systemVersion", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("target", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("target-patient", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("target-patient-identifier", new ParamRule(ParamKind.VALUE, "Identifier")),
    Map.entry("targetCode", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("targetCodeableConcept", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("targetCoding", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("targetIdentifier", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("targetScope", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("targetSystem", new ParamRule(ParamKind.VALUE, "uri")),
    Map.entry("targetType", new ParamRule(ParamKind.VALUE, "code")),
    Map.entry("token", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("topic", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("type", new ParamRule(ParamKind.VALUE, "CodeableConcept", "code")),
    Map.entry("union", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("url", new ParamRule(ParamKind.VALUE, "canonical", "string", "uri")),
    Map.entry("usageContext", new ParamRule(ParamKind.VALUE, "UsageContext")),
    Map.entry("userLanguage", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("userTaskContext", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("userType", new ParamRule(ParamKind.VALUE, "CodeableConcept")),
    Map.entry("useSupplement", new ParamRule(ParamKind.VALUE, "canonical")),
    Map.entry("valueSet", new ParamRule(ParamKind.RESOURCE)),
    Map.entry("valueSetVersion", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("version", new ParamRule(ParamKind.VALUE, "code", "string")),
    Map.entry("ward", new ParamRule(ParamKind.VALUE, "string")),
    Map.entry("websocket-url", new ParamRule(ParamKind.VALUE, "url"))
  );

  private boolean validateParameter(ValidationContext valContext, List<ValidationMessage> errors, Element parameter, NodeStack stack) {
    String name = parameter.getNamedChildValue("name");
    String type = parameter.hasChild("value") ? parameter.getNamedChild("value").fhirType() : null;
    boolean res = parameter.hasChild("resource");

    ParamRule rule = PARAM_RULES.get(name);
    if (rule == null) {
      return true; // unknown parameter, nothing to validate
    }

    switch (rule.kind) {
      case VALUE:
        if (warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name)) {
          String typeList = CommaSeparatedStringBuilder.join2(", ", "or", rule.types);
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack,
            Utilities.existsInList(type, rule.types), rule.types.length,
            I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, typeList);
        }
        break;
      case RESOURCE:
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        break;
      case MIXED:
        if (type != null) {
          String typeList = CommaSeparatedStringBuilder.join2(", ", "or", rule.types);
          warningPlural(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack,
            Utilities.existsInList(type, rule.types), rule.types.length,
            I18nConstants.PARAMETERS_STD_WRONG_TYPE, name, type, typeList);
        } else {
          warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, res, I18nConstants.PARAMETERS_STD_NO_RESOURCE, name);
        }
        break;
      case ANY_VALUE:
        warning(errors, "2025-03-22", ValidationMessage.IssueType.BUSINESSRULE, stack, type != null, I18nConstants.PARAMETERS_STD_NO_VALUE, name);
        break;

    }
    return true;
  }


}
