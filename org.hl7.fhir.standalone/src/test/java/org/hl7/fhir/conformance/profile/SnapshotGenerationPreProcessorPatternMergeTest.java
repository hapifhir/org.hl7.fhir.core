package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.Quantity;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.conformance.profile.SnapshotGenerationPreProcessor;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 *
 * <p>Covers the additional-base merge in SnapshotGenerationPreProcessor: the pattern/pattern
 * branch of mergeElementDefinitions, and the two helpers it leans on, checkPatternValues
 * and isLower.
 *
 * <p>Both are private, and their callers need a fully navigable pair of profiles, so they
 * are invoked directly here rather than through a snapshot generation large enough to
 * reach them.
 */
class SnapshotGenerationPreProcessorPatternMergeTest {

  private static final String PATH = "Observation.value[x]";

  @Test
  void patternsAreMergedFromThePatternOperands() throws Exception {
    ElementDefinition base = element(new StringType("a value"));
    ElementDefinition source = element(new StringType("a value"));

    ElementDefinition merged = mergeElementDefinitions(base, source);

    assertFalse(merged.hasFixed(), "neither side had a fixed value");
    assertTrue(merged.hasPattern());
    assertEquals("a value", merged.getPattern().primitiveValue());
  }

  /**
   * checkPatternValues dereferences getValues().get(0) on both sides, so a repeating child
   * on either one is unsupported. The guard only ever tested the source side, so extra
   * values on the base were dropped without complaint.
   */
  @Test
  void aRepeatingChildOnTheBasePatternIsNotSilentlyTruncated() {
    CodeableConcept twoCodings = new CodeableConcept();
    twoCodings.addCoding().setSystem("http://example.org").setCode("a");
    twoCodings.addCoding().setSystem("http://example.org").setCode("b");
    CodeableConcept oneCoding = new CodeableConcept();
    oneCoding.addCoding().setSystem("http://example.org").setCode("a");

    ElementDefinition base = element(twoCodings);
    ElementDefinition source = element(oneCoding);

    assertThrows(Error.class, () -> mergeElementDefinitions(base, source));
  }

  @Test
  void quantitiesWithTheSameUnitAreCompared() throws Exception {
    assertTrue(isLower(quantity(1, "mg"), quantity(2, "mg")));
    assertFalse(isLower(quantity(2, "mg"), quantity(1, "mg")));
  }

  /**
   * Quantities in different units are not comparable and must be rejected. The exception
   * type is not asserted: the rejection path formats a message against the worker context,
   * which is null here, so only the fact that the pair is refused is pinned down.
   */
  @Test
  void quantitiesWithDifferentUnitsAreRejected() {
    assertThrows(Exception.class, () -> isLower(quantity(1, "mg"), quantity(2, "g")));
  }

  private Quantity quantity(long value, String unit) {
    return new Quantity().setValue(value).setUnit(unit);
  }

  private ElementDefinition element(DataType pattern) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    ed.setPattern(pattern);
    return ed;
  }

  private SnapshotGenerationPreProcessor preProcessor() {
    return new SnapshotGenerationPreProcessor(new ProfileUtilities(null, new ArrayList<>(), null));
  }

  private ElementDefinition mergeElementDefinitions(ElementDefinition base, ElementDefinition source)
      throws Exception {
    Method method = SnapshotGenerationPreProcessor.class.getDeclaredMethod(
        "mergeElementDefinitions", ElementDefinition.class, ElementDefinition.class, StructureDefinition.class);
    method.setAccessible(true);
    return (ElementDefinition) invoke(method, base, source, new StructureDefinition());
  }

  private boolean isLower(DataType v1, DataType v2) throws Exception {
    Method method = SnapshotGenerationPreProcessor.class.getDeclaredMethod(
        "isLower", String.class, String.class, String.class, DataType.class, DataType.class);
    method.setAccessible(true);
    return (boolean) invoke(method, "http://example.org/StructureDefinition/test|1.0.0", PATH, "minValue", v1, v2);
  }

  /** Unwraps the reflection wrapper so the tests see what the method itself threw. */
  private Object invoke(Method method, Object... args) throws Exception {
    try {
      return method.invoke(preProcessor(), args);
    } catch (InvocationTargetException e) {
      Throwable cause = e.getCause();
      if (cause instanceof Exception) {
        throw (Exception) cause;
      }
      throw (Error) cause;
    }
  }
}
