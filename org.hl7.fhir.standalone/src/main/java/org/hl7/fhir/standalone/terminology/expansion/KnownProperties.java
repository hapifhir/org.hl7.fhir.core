package org.hl7.fhir.standalone.terminology.expansion;

import java.util.concurrent.TimeoutException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.model.core.Enumerations.FilterOperator;
import org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.model.utilities.CodeSystemUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.regex.RegexTimeout;

/**
 * Value set filters on the properties that can be used whether or not the code system declares
 * them - notSelectable, status, inactive and deprecated - and what a filter on them means. Shared by
 * the expander (KnownPropertyFilter) and the validator. The values come from CodeSystemUtilities, so
 * that the filters agree with what $expand and $validate-code say about the concept.
 *
 * FHIRsmith's CodeSystem provider (tx/cs/cs-cs.js) does the same: keep the two in step.
 *
 * - a filter on one of these properties has its built-in meaning unless the code system declares
 *   the code for a property of its own (with a uri other than the standard one); this is checked
 *   before the code system's own properties
 * - notSelectable: the value of the concept's notSelectable property, by whatever code the code
 *   system gives it. A concept without it has no value
 * - status: CodeSystemUtilities.getStatus. A concept that nothing gives a status for has no value
 * - inactive, deprecated: CodeSystemUtilities.isInactive / isDeprecated - always true or false
 * - =, in: the value is (one of) those given; not-in: it isn't - including a concept with no
 *   value; exists true / false: the concept has / doesn't have a value; regex: the value matches.
 *   No other operators
 */
public class KnownProperties {

  /**
   * @return whether a filter on this property has its built-in meaning in this code system
   */
  public static boolean isKnownProperty(CodeSystem cs, String property) {
    return Utilities.existsInList(property, "notSelectable", "status", "inactive", "deprecated") && !CodeSystemUtilities.redefinesStandardProperty(cs, property);
  }

  /**
   * @return whether the operator is one that a filter on these properties supports
   */
  public static boolean isSupportedOperation(FilterOperator op) {
    return op == FilterOperator.EQUAL || op == FilterOperator.IN || op == FilterOperator.NOTIN || op == FilterOperator.EXISTS || op == FilterOperator.REGEX;
  }

  /**
   * @return whether the filter (on one of these properties, with a supported operator) selects a
   * concept that has this value for the property (null: no value)
   */
  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //single literal character split
  public static boolean selects(ConceptSetFilterComponent filter, String value) {
    String fv = filter.getValue();
    switch (filter.getOp()) {
    case EQUAL:
      return value != null && value.equals(fv);
    case IN:
      return value != null && fv != null && Utilities.existsInListTrimmed(value, fv.split("\\,"));
    case NOTIN:
      return value == null || fv == null || !Utilities.existsInListTrimmed(value, fv.split("\\,"));
    case EXISTS:
      return PropertyFilter.existsFilterMatches(fv, value != null);
    case REGEX:
      if (value == null || fv == null) {
        return false;
      }
      try {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //False positive: RegexTimeout.matches is the approved timeout wrapper. The regex comes from the ValueSet filter value - user-supplied at runtime
        boolean matched = RegexTimeout.matches(value, fv);
        return matched;
      } catch (TimeoutException e) {
        throw new FHIRException("The regex filter '" + fv + "' took too long to evaluate");
      }
    default:
      throw new IllegalArgumentException("Unsupported operator for a filter on " + filter.getProperty() + ": " + filter.getOp().toCode());
    }
  }

  /**
   * @return the value of the property for the concept, as a string, or null if it has none
   */
  public static String getValue(CodeSystem cs, ConceptDefinitionComponent def, String property) {
    switch (property) {
    case "notSelectable":
      ConceptPropertyComponent pc = CodeSystemUtilities.getNotSelectableProperty(cs, def);
      return pc != null && pc.hasValue() && pc.getValue().isPrimitive() ? pc.getValue().primitiveValue() : null;
    case "status":
      return CodeSystemUtilities.getStatus(cs, def);
    case "inactive":
      return CodeSystemUtilities.isInactive(cs, def) ? "true" : "false";
    case "deprecated":
      return CodeSystemUtilities.isDeprecated(cs, def, false) ? "true" : "false";
    default:
      return null;
    }
  }
}
