package org.hl7.fhir.r5.conformance.profile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.BaseDateTimeType;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.Integer64Type;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.TimeType;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;

/**
 * When an element in a profile is given a data type profile (type.profile), the constraints that the data type
 * profile makes on its root element also apply to the element. This class merges those constraints into the
 * snapshot element.
 * <p>
 * Only what the type profile adds over the root of the underlying type (e.g. CodeableConcept) is migrated.
 * The rules, property by property:
 * <ul>
 *   <li>slicing: an error if the type profile root has any</li>
 *   <li>code: merged (though sdf-9 doesn't allow code on a root anyway)</li>
 *   <li>label, short, definition, comment, requirements, alias, example, meaningWhenMissing, orderMeaning: never merged</li>
 *   <li>min: the highest; max: the lowest</li>
 *   <li>base, contentReference, type, condition, isModifier, isModifierReason, isSummary: ignored</li>
 *   <li>defaultValue, fixed, pattern: an error if both have values that do not agree</li>
 *   <li>minValue: the highest; maxValue: the lowest; maxLength: the lowest</li>
 *   <li>constraint: merged by key. Same key and expression: ignored; same key, different expression: an error</li>
 *   <li>mustHaveValue, mustSupport: true if either is true</li>
 *   <li>valueAlternatives: the intersection, if both have some</li>
 *   <li>mapping: merged by identity + map</li>
 *   <li>binding: the type profile's binding replaces the element's (and the differential can then replace that);
 *       additional bindings are merged by purpose + value set (R5 additional bindings have no key)</li>
 * </ul>
 * Extensions on the root are not migrated.
 * <p>
 * Problems are returned as messages, not thrown, so the caller decides how to report them
 */
public class TypeProfileRootMerger {

  private final IWorkerContext context;

  public TypeProfileRootMerger(IWorkerContext context) {
    this.context = context;
  }

  /**
   * Merge the root of the type profile into the element.
   *
   * @param element the snapshot element being generated - modified in place
   * @param typeProfile the data type profile named in the element's type.profile (with a snapshot)
   * @param path the path of the element, for messages
   * @return any problems found
   */
  public List<ValidationMessage> merge(ElementDefinition element, StructureDefinition typeProfile, String path) {
    ElementDefinition typeRoot = typeProfile.getSnapshot().getElement().isEmpty() ? null : typeProfile.getSnapshot().getElement().get(0);
    if (typeRoot == null) {
      return new ArrayList<>();
    }
    StructureDefinition core = context.fetchTypeDefinition(typeProfile.getType());
    ElementDefinition coreRoot = core == null || core.getSnapshot().getElement().isEmpty() ? new ElementDefinition() : core.getSnapshot().getElement().get(0);
    // unversioned, like the other constraint sources snapshot generation fills in
    return merge(element, typeRoot, coreRoot, typeProfile.getUrl(), path);
  }

  /**
   * Merge the root of the type profile into the element.
   *
   * @param element the snapshot element being generated - modified in place
   * @param typeRoot the root element of the type profile's snapshot
   * @param coreRoot the root element of the underlying type's snapshot - only what typeRoot adds over this is migrated
   * @param profileUrl the type profile's url, for messages and for constraint.source
   * @param path the path of the element, for messages
   * @return any problems found
   */
  public List<ValidationMessage> merge(ElementDefinition element, ElementDefinition typeRoot, ElementDefinition coreRoot, String profileUrl, String path) {
    List<ValidationMessage> issues = new ArrayList<>();

    if (typeRoot.hasSlicing()) {
      error(issues, path, I18nConstants.SNAPSHOT_TYPE_ROOT_SLICING, profileUrl, path);
    }

    for (Coding c : typeRoot.getCode()) {
      if (!element.hasCode(c)) {
        element.addCode(c.copy());
      }
    }

    // cardinality
    if (typeRoot.hasMin() && (!element.hasMin() || typeRoot.getMin() > element.getMin())) {
      element.setMin(typeRoot.getMin());
    }
    if (typeRoot.hasMax() && (!element.hasMax() || maxAsInt(typeRoot.getMax()) < maxAsInt(element.getMax()))) {
      element.setMax(typeRoot.getMax());
    }

    // values
    if (typeRoot.hasDefaultValue()) {
      if (!element.hasDefaultValue()) {
        element.setDefaultValue(typeRoot.getDefaultValue().copy());
      } else if (!Base.compareDeep(element.getDefaultValue(), typeRoot.getDefaultValue(), false)) {
        error(issues, path, I18nConstants.SNAPSHOT_TYPE_ROOT_DEFAULT_CONFLICT, profileUrl, path);
      }
    }
    mergeFixedOrPattern(element, typeRoot, profileUrl, path, issues);

    if (typeRoot.hasMinValue()) {
      if (!element.hasMinValue()) {
        element.setMinValue(typeRoot.getMinValue().copy());
      } else {
        Integer c = compareValues(typeRoot.getMinValue(), element.getMinValue());
        if (c == null) {
          uncomparable(issues, path, profileUrl, "minValue", typeRoot.getMinValue(), element.getMinValue());
        } else if (c > 0) {
          element.setMinValue(typeRoot.getMinValue().copy());
        }
      }
    }
    if (typeRoot.hasMaxValue()) {
      if (!element.hasMaxValue()) {
        element.setMaxValue(typeRoot.getMaxValue().copy());
      } else {
        Integer c = compareValues(typeRoot.getMaxValue(), element.getMaxValue());
        if (c == null) {
          uncomparable(issues, path, profileUrl, "maxValue", typeRoot.getMaxValue(), element.getMaxValue());
        } else if (c < 0) {
          element.setMaxValue(typeRoot.getMaxValue().copy());
        }
      }
    }
    if (typeRoot.hasMaxLength() && (!element.hasMaxLength() || typeRoot.getMaxLength() < element.getMaxLength())) {
      element.setMaxLength(typeRoot.getMaxLength());
    }

    // constraints
    for (ElementDefinitionConstraintComponent inv : typeRoot.getConstraint()) {
      if (coreRoot.hasConstraint(inv.getKey())) {
        continue; // not something the type profile added
      }
      ElementDefinitionConstraintComponent existing = getConstraint(element, inv.getKey());
      if (existing == null) {
        ElementDefinitionConstraintComponent ninv = inv.copy();
        if (!ninv.hasSource()) {
          ninv.setSource(profileUrl);
        }
        element.getConstraint().add(ninv);
      } else if (!Objects.equals(existing.getExpression(), inv.getExpression())) {
        error(issues, path, I18nConstants.SNAPSHOT_TYPE_ROOT_CONSTRAINT_CONFLICT, profileUrl, path, inv.getKey(), inv.getExpression(), existing.getExpression());
      }
    }

    // flags
    if (typeRoot.hasMustHaveValue() && typeRoot.getMustHaveValue()) {
      element.setMustHaveValue(true);
    }
    if (typeRoot.hasMustSupport() && typeRoot.getMustSupport()) {
      element.setMustSupport(true);
    }

    // value alternatives
    if (typeRoot.hasValueAlternatives()) {
      if (!element.hasValueAlternatives()) {
        for (CanonicalType ct : typeRoot.getValueAlternatives()) {
          element.getValueAlternatives().add(ct.copy());
        }
      } else {
        element.getValueAlternatives().removeIf(ct -> !typeRoot.hasValueAlternatives(ct.getValue()));
      }
    }

    // mappings
    for (ElementDefinitionMappingComponent m : typeRoot.getMapping()) {
      String map = mappingDelta(m, coreRoot);
      if (map != null && !hasMapping(element, m.getIdentity(), map)) {
        ElementDefinitionMappingComponent nm = m.copy();
        nm.setMap(map);
        element.getMapping().add(nm);
      }
    }

    // binding
    if (typeRoot.hasBinding() && !Base.compareDeep(typeRoot.getBinding(), coreRoot.getBinding(), false)) {
      mergeBinding(element, typeRoot.getBinding());
    }
    return issues;
  }

  private void mergeFixedOrPattern(ElementDefinition element, ElementDefinition typeRoot, String profileUrl, String path, List<ValidationMessage> issues) {
    if (!typeRoot.hasFixed() && !typeRoot.hasPattern()) {
      return;
    }
    DataType typeValue = typeRoot.hasFixed() ? typeRoot.getFixed() : typeRoot.getPattern();
    String typeKind = typeRoot.hasFixed() ? "fixed" : "pattern";
    if (!element.hasFixed() && !element.hasPattern()) {
      if (typeRoot.hasFixed()) {
        element.setFixed(typeValue.copy());
      } else {
        element.setPattern(typeValue.copy());
      }
    } else {
      DataType elementValue = element.hasFixed() ? element.getFixed() : element.getPattern();
      String elementKind = element.hasFixed() ? "fixed" : "pattern";
      if (!Base.compareDeep(elementValue, typeValue, false)) {
        error(issues, path, I18nConstants.SNAPSHOT_TYPE_ROOT_FIXED_CONFLICT, profileUrl, path, typeKind, elementKind);
      } else if (typeRoot.hasFixed() && !element.hasFixed()) {
        // they agree, but fixed is the stronger statement
        element.setPattern(null);
        element.setFixed(typeValue.copy());
      }
    }
  }

  private void mergeBinding(ElementDefinition element, ElementDefinitionBindingComponent typeBinding) {
    // the same approach snapshot generation uses when a differential replaces a binding: start from what's
    // there (for the additional bindings), and replace strength, valueSet and description
    ElementDefinitionBindingComponent nb = element.hasBinding() ? element.getBinding().copy() : new ElementDefinitionBindingComponent();
    nb.getExtension().clear();
    nb.setDescription(null);
    for (org.hl7.fhir.r5.model.Extension ext : typeBinding.getExtension()) {
      nb.getExtension().add(ext.copy());
    }
    if (typeBinding.hasStrength()) {
      nb.setStrength(typeBinding.getStrength());
    }
    if (typeBinding.hasDescription()) {
      nb.setDescription(typeBinding.getDescription());
    }
    if (typeBinding.hasValueSet()) {
      nb.setValueSetElement(typeBinding.getValueSetElement().copy());
    }
    for (ElementDefinitionBindingAdditionalComponent ab : typeBinding.getAdditional()) {
      int i = indexOfMatchingAdditional(nb, ab);
      if (i == -1) {
        nb.getAdditional().add(ab.copy());
      } else {
        nb.getAdditional().set(i, ab.copy());
      }
    }
    element.setBinding(nb);
  }

  private int indexOfMatchingAdditional(ElementDefinitionBindingComponent binding, ElementDefinitionBindingAdditionalComponent ab) {
    for (int i = 0; i < binding.getAdditional().size(); i++) {
      ElementDefinitionBindingAdditionalComponent t = binding.getAdditional().get(i);
      // R5 additional bindings have no key (that came in R6), so they match on purpose + value set, as elsewhere in snapshot generation
      if (Objects.equals(t.getValueSet(), ab.getValueSet()) && t.getPurpose() == ab.getPurpose()) {
        return i;
      }
    }
    return -1;
  }

  /**
   * @return the part of the mapping that the type profile added over the core type root, or null if it added nothing.
   * Snapshot generation appends maps with the same identity with ',', so a type profile's "n/a,Act,foo" over a core
   * "n/a,Act" adds "foo"
   */
  private String mappingDelta(ElementDefinitionMappingComponent m, ElementDefinition coreRoot) {
    for (ElementDefinitionMappingComponent cm : coreRoot.getMapping()) {
      if (Objects.equals(cm.getIdentity(), m.getIdentity()) && cm.hasMap()) {
        if (cm.getMap().equals(m.getMap())) {
          return null;
        }
        if (m.hasMap() && m.getMap().startsWith(cm.getMap() + ",")) {
          return m.getMap().substring(cm.getMap().length() + 1);
        }
      }
    }
    return m.getMap();
  }

  private boolean hasMapping(ElementDefinition element, String identity, String map) {
    for (ElementDefinitionMappingComponent m : element.getMapping()) {
      if (Objects.equals(m.getIdentity(), identity) && Objects.equals(m.getMap(), map)) {
        return true;
      }
    }
    return false;
  }

  private ElementDefinitionConstraintComponent getConstraint(ElementDefinition element, String key) {
    for (ElementDefinitionConstraintComponent inv : element.getConstraint()) {
      if (Objects.equals(inv.getKey(), key)) {
        return inv;
      }
    }
    return null;
  }

  private int maxAsInt(String max) {
    if (max == null || "*".equals(max)) {
      return Integer.MAX_VALUE;
    }
    try {
      return Integer.parseInt(max);
    } catch (NumberFormatException e) {
      return Integer.MAX_VALUE;
    }
  }

  /**
   * @return negative, zero or positive as v1 is less than, equal to or greater than v2, or null if they can't be compared
   */
  static Integer compareValues(DataType v1, DataType v2) {
    BigDecimal n1 = asNumber(v1);
    BigDecimal n2 = asNumber(v2);
    if (n1 != null && n2 != null) {
      return n1.compareTo(n2);
    }
    if (v1 instanceof Quantity && v2 instanceof Quantity) {
      Quantity q1 = (Quantity) v1;
      Quantity q2 = (Quantity) v2;
      boolean sameUnits = q1.hasCode() || q2.hasCode()
          ? Objects.equals(q1.getSystem(), q2.getSystem()) && Objects.equals(q1.getCode(), q2.getCode())
          : Objects.equals(q1.getUnit(), q2.getUnit());
      if (sameUnits && q1.hasValue() && q2.hasValue()) {
        return q1.getValue().compareTo(q2.getValue());
      }
      return null;
    }
    if (v1 instanceof BaseDateTimeType && v2 instanceof BaseDateTimeType && v1.fhirType().equals(v2.fhirType())) {
      Date d1 = ((BaseDateTimeType) v1).getValue();
      Date d2 = ((BaseDateTimeType) v2).getValue();
      return d1 == null || d2 == null ? null : d1.compareTo(d2);
    }
    if (v1 instanceof TimeType && v2 instanceof TimeType) {
      String t1 = v1.primitiveValue();
      String t2 = v2.primitiveValue();
      return t1 == null || t2 == null ? null : t1.compareTo(t2);
    }
    return null;
  }

  private static BigDecimal asNumber(DataType v) {
    if (v instanceof IntegerType || v instanceof Integer64Type || v instanceof DecimalType) {
      String s = v.primitiveValue();
      if (s != null) {
        try {
          return new BigDecimal(s);
        } catch (NumberFormatException e) {
          return null;
        }
      }
    }
    return null;
  }

  private void uncomparable(List<ValidationMessage> issues, String path, String profileUrl, String name, DataType typeValue, DataType elementValue) {
    issues.add(new ValidationMessage(Source.ProfileValidator, IssueType.BUSINESSRULE, path,
        context.formatMessage(I18nConstants.SNAPSHOT_TYPE_ROOT_VALUE_UNCOMPARABLE, profileUrl, path, name, describe(typeValue), describe(elementValue)), IssueSeverity.WARNING));
  }

  private String describe(DataType v) {
    if (v instanceof Quantity) {
      Quantity q = (Quantity) v;
      return q.getValue() + " " + (q.hasCode() ? q.getCode() : q.hasUnit() ? q.getUnit() : "");
    }
    return v.isPrimitive() ? v.primitiveValue() : v.fhirType();
  }

  private void error(List<ValidationMessage> issues, String path, String msgId, Object... args) {
    issues.add(new ValidationMessage(Source.ProfileValidator, IssueType.BUSINESSRULE, path, context.formatMessage(msgId, args), IssueSeverity.ERROR));
  }
}
