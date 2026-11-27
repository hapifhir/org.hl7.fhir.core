package org.hl7.fhir.standalone.terminology.expansion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.model.core.CodeSystem.PropertyComponent;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.DateTimeType;
import org.hl7.fhir.model.core.Enumerations.FilterOperator;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.utilities.Utilities;

/**
 * The properties a value set filter can use whether or not the code system declares them -
 * notSelectable, status, inactive and deprecated - and what a filter on them means. Shared by
 * the expander (KnownPropertyFilter) and the validator, so that $expand and $validate-code agree.
 *
 * This is the same logic as FHIRsmith's CodeSystem provider (tx/cs/cs-cs.js), which is the
 * reference for it: keep the two in step.
 *
 * - a filter on one of these properties has its built-in meaning unless the code system declares
 *   the code for a property of its own (with a uri other than the standard one); this is checked
 *   before the code system's own properties
 * - notSelectable: the concept's notSelectable property, by whatever code the code system gives
 *   it. A concept without it has no value
 * - status: the concept's status property, or if it has none, what its other properties or the
 *   standards-status extension say. A concept with none of these has no value
 * - inactive, deprecated: always true or false
 * - =, in: the value is (one of) those given; not-in: it isn't - including a concept with no
 *   value; exists true / false: the concept has / doesn't have a value. No other operators
 */
public class KnownProperties {

  public static final String CONCEPT_PROPERTIES = "http://hl7.org/fhir/concept-properties#";
  private static final String STANDARDS_STATUS = "http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status";

  /**
   * @return whether a filter on this property has its built-in meaning in this code system
   */
  public static boolean isKnownProperty(CodeSystem cs, String property) {
    return Utilities.existsInList(property, "notSelectable", "status", "inactive", "deprecated") && !redefinesStandardProperty(cs, property);
  }

  /**
   * @return whether the operator is one that a filter on these properties supports
   */
  public static boolean isSupportedOperation(FilterOperator op) {
    return op == FilterOperator.EQUAL || op == FilterOperator.IN || op == FilterOperator.NOTIN || op == FilterOperator.EXISTS;
  }

  /**
   * @return whether the filter (on one of these properties, with a supported operator) selects a
   * concept that has this value for the property (null: no value)
   */
  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //single literal character split
  public static boolean matches(ConceptSetFilterComponent filter, String value) {
    switch (filter.getOp()) {
    case EQUAL:
      return value != null && value.equals(filter.getValue());
    case IN:
      return value != null && Utilities.existsInListTrimmed(value, filter.getValue().split("\\,"));
    case NOTIN:
      return value == null || !Utilities.existsInListTrimmed(value, filter.getValue().split("\\,"));
    case EXISTS:
      return PropertyFilter.existsFilterMatches(filter.getValue(), value != null);
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
      Set<String> codes = standardPropertyCodes(cs, "notSelectable", "abstract", "not-selectable");
      for (ConceptPropertyComponent pc : def.getPropertyList()) {
        if (pc.hasCode() && codes.contains(pc.getCode())) {
          return primitive(pc);
        }
      }
      return null;
    case "status":
      return getStatus(def);
    case "inactive":
      return isInactive(def) ? "true" : "false";
    case "deprecated":
      return isDeprecated(def) ? "true" : "false";
    default:
      return null;
    }
  }

  /**
   * The concept's status: its status property, or else what its deprecated, deprecationDate,
   * inactive or retired properties, or the standards-status extension, say. null if none of them
   */
  public static String getStatus(ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent pc : def.getPropertyList()) {
      if ("status".equals(pc.getCode())) {
        return primitive(pc);
      }
    }
    for (ConceptPropertyComponent pc : def.getPropertyList()) {
      String code = pc.getCode();
      if ("deprecated".equals(code) && "true".equals(primitive(pc))) {
        return "deprecated";
      }
      if ("deprecationDate".equals(code) && pc.getValue() instanceof DateTimeType) {
        Date d = ((DateTimeType) pc.getValue()).getValue();
        if (d != null && d.before(new Date())) {
          return "deprecated";
        }
      }
      if ("inactive".equals(code) && "true".equals(primitive(pc))) {
        return "inactive";
      }
      if ("retired".equals(code) && "true".equals(primitive(pc))) {
        return "retired";
      }
    }
    Extension ext = def.getExtensionByUrl(STANDARDS_STATUS);
    if (ext != null) {
      String v = ext.hasValue() && ext.getValue().isPrimitive() ? ext.getValue().primitiveValue() : null;
      return v == null ? "" : v;
    }
    return null;
  }

  /**
   * Whether the concept is inactive: its inactive property is true, its status is inactive or
   * retired, or its standards-status is withdrawn
   */
  public static boolean isInactive(ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent pc : def.getPropertyList()) {
      DataType v = pc.getValue();
      if ("inactive".equals(pc.getCode()) && (v instanceof BooleanType || v instanceof CodeType) && "true".equals(v.primitiveValue())) {
        return true;
      }
      if ("status".equals(pc.getCode())) {
        String s = primitive(pc);
        if ("inactive".equals(s) || "retired".equals(s)) {
          return true;
        }
      }
    }
    Extension ext = def.getExtensionByUrl(STANDARDS_STATUS);
    if (ext != null && ext.hasValue() && ext.getValue().isPrimitive()) {
      return "withdrawn".equalsIgnoreCase(ext.getValue().primitiveValue());
    }
    return false;
  }

  /**
   * Whether the concept is deprecated: its (first) deprecated property is true, or its (first)
   * status property is deprecated or retired
   */
  public static boolean isDeprecated(ConceptDefinitionComponent def) {
    ConceptPropertyComponent deprecated = null;
    ConceptPropertyComponent status = null;
    for (ConceptPropertyComponent pc : def.getPropertyList()) {
      if (deprecated == null && "deprecated".equals(pc.getCode())) {
        deprecated = pc;
      }
      if (status == null && "status".equals(pc.getCode())) {
        status = pc;
      }
    }
    if (deprecated != null && deprecated.getValue() instanceof BooleanType && "true".equals(deprecated.getValue().primitiveValue())) {
      return true;
    }
    if (status != null && status.getValue() instanceof CodeType) {
      String s = status.getValue().primitiveValue();
      return "deprecated".equals(s) || "retired".equals(s);
    }
    return false;
  }

  /**
   * The codes this code system uses for one of the standard concept properties: any code
   * declared with the standard uri, and the standard code and the aliases, unless the code
   * system declares one of those with a different uri
   */
  public static Set<String> standardPropertyCodes(CodeSystem cs, String name, String... aliases) {
    String uri = CONCEPT_PROPERTIES + name;
    Set<String> codes = new HashSet<>();
    for (PropertyComponent pd : cs.getPropertyList()) {
      if (uri.equals(pd.getUri())) {
        codes.add(pd.getCode());
      }
    }
    codes.add(name);
    for (String a : aliases) {
      codes.add(a);
    }
    for (PropertyComponent pd : cs.getPropertyList()) {
      if (pd.hasUri() && !uri.equals(pd.getUri())) {
        codes.remove(pd.getCode());
      }
    }
    return codes;
  }

  /**
   * @return whether the code system declares the code of a standard concept property for a
   * property of its own (with a different uri)
   */
  public static boolean redefinesStandardProperty(CodeSystem cs, String name) {
    String uri = CONCEPT_PROPERTIES + name;
    for (PropertyComponent pd : cs.getPropertyList()) {
      if (name.equals(pd.getCode()) && pd.hasUri() && !uri.equals(pd.getUri())) {
        return true;
      }
    }
    return false;
  }

  private static String primitive(ConceptPropertyComponent pc) {
    return pc.hasValue() && pc.getValue().isPrimitive() ? pc.getValue().primitiveValue() : null;
  }
}
