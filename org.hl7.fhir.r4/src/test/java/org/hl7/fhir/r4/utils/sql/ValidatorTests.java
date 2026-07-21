package org.hl7.fhir.r4.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hl7.fhir.r4.context.IWorkerContext;
import org.hl7.fhir.r4.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.sql.Validator.TrueFalseOrUnknown;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests that the SQL on FHIR Validator's property allow-lists accept the fields declared on the
 * ViewDefinition logical model in the spec (including inherited Resource/DomainResource/
 * CanonicalResource fields and backbone Element fields), while still rejecting genuinely unknown
 * properties.
 *
 * @author John Grimes
 */
class ValidatorTests {

  private static IWorkerContext context;
  private static FHIRPathEngine fpe;

  @BeforeAll
  static void setUpAll() {
    context = TestingUtilities.context();
    fpe = new FHIRPathEngine(context);
  }

  /**
   * Returns a fresh minimal-but-valid ViewDefinition with one select and one column, on which
   * individual tests can layer extra properties.
   */
  private static JsonObject minimalViewDefinition() {
    JsonObject vd = new JsonObject();
    vd.add("resourceType", "ViewDefinition");
    vd.add("name", "vt_test");
    vd.add("status", "active");
    vd.add("resource", "Patient");
    JsonObject select = vd.forceArray("select").addObject();
    JsonObject column = select.forceArray("column").addObject();
    column.add("name", "id");
    column.add("path", "id");
    return vd;
  }

  private static Validator newValidator() {
    return new Validator(context, fpe, new ArrayList<>(), TrueFalseOrUnknown.UNKNOWN, TrueFalseOrUnknown.UNKNOWN, TrueFalseOrUnknown.UNKNOWN);
  }

  /**
   * Round-trips the in-memory JsonObject through the JSON parser so each element carries the
   * source-location data that Validator.error() requires, then invokes the validator. Without this,
   * programmatically constructed JsonObjects produce a NullPointerException in error reporting
   * rather than the expected validation issues.
   */
  private static void check(Validator v, JsonObject vd) {
    JsonObject parsed;
    try {
      parsed = JsonParser.parseObject(JsonParser.compose(vd));
    } catch (Exception e) {
      throw new RuntimeException("Failed to round-trip ViewDefinition fixture", e);
    }
    v.checkViewDefinition("ViewDefinition", parsed);
  }

  /**
   * Filters validation issues down to the unknown-property errors emitted by checkProperties so the
   * test failure messages are pinpointed at this bug.
   */
  private static List<ValidationMessage> unknownPropertyIssues(Validator v) {
    return v.getIssues().stream()
        .filter(m -> m.getMessage() != null && m.getMessage().startsWith("Unknown JSON property "))
        .collect(Collectors.toList());
  }

  private static void assertNoUnknownPropertyIssues(Validator v) {
    List<ValidationMessage> unknown = unknownPropertyIssues(v);
    if (!unknown.isEmpty()) {
      String detail = unknown.stream()
          .map(m -> m.getLocation() + ": " + m.getMessage())
          .collect(Collectors.joining("\n  "));
      fail("Expected no 'Unknown JSON property' issues but got:\n  " + detail);
    }
  }

  // ViewDefinition logical-model fields and inherited Resource fields that SUSHI emits on
  // Instances generated from the logical model. The spec's edge build snapshot at
  // https://build.fhir.org/ig/FHIR/sql-on-fhir-v2/StructureDefinition-ViewDefinition.json
  // is the authoritative source for this list.
  static Stream<String> topLevelInheritedFields() {
    return Stream.of("id", "meta", "text", "language", "implicitRules", "contained",
        "modifierExtension", "profile", "fhirVersion", "jurisdiction", "purpose", "copyrightLabel",
        "versionAlgorithmString", "versionAlgorithmCoding");
  }

  @ParameterizedTest(name = "top-level field {0} is accepted")
  @MethodSource("topLevelInheritedFields")
  void topLevelInheritedPropertiesAreAccepted(String field) {
    JsonObject vd = minimalViewDefinition();
    // Use an array or object value where the model expects one, otherwise a simple string. The
    // specific value does not matter for property-name checking - we only care that the allow-list
    // accepts the property name.
    if ("contained".equals(field) || "jurisdiction".equals(field)
        || "modifierExtension".equals(field) || "profile".equals(field)
        || "fhirVersion".equals(field)) {
      vd.forceArray(field);
    } else if ("meta".equals(field) || "text".equals(field)
        || "versionAlgorithmCoding".equals(field)) {
      vd.forceObject(field);
    } else {
      vd.add(field, "x");
    }
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  @Test
  @DisplayName("select.repeat is accepted")
  void selectRepeatIsAccepted() {
    JsonObject vd = minimalViewDefinition();
    JsonObject select = vd.getJsonArray("select").asJsonObjects().get(0);
    select.forceArray("repeat").add("contained");
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  @Test
  @DisplayName("select backbone-inherited id/modifierExtension are accepted")
  void selectBackboneInheritedPropertiesAreAccepted() {
    JsonObject vd = minimalViewDefinition();
    JsonObject select = vd.getJsonArray("select").asJsonObjects().get(0);
    select.add("id", "s1");
    select.forceArray("modifierExtension");
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  @Test
  @DisplayName("column backbone-inherited id/modifierExtension are accepted")
  void columnBackboneInheritedPropertiesAreAccepted() {
    JsonObject vd = minimalViewDefinition();
    JsonObject column = vd.getJsonArray("select").asJsonObjects().get(0)
        .getJsonArray("column").asJsonObjects().get(0);
    column.add("id", "c1");
    column.forceArray("modifierExtension");
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  @Test
  @DisplayName("constant backbone-inherited id/modifierExtension are accepted")
  void constantBackboneInheritedPropertiesAreAccepted() {
    JsonObject vd = minimalViewDefinition();
    JsonObject constant = vd.forceArray("constant").addObject();
    constant.add("name", "k1");
    constant.add("valueString", "v");
    constant.add("id", "k1id");
    constant.forceArray("modifierExtension");
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  @Test
  @DisplayName("where backbone-inherited id/modifierExtension are accepted")
  void whereBackboneInheritedPropertiesAreAccepted() {
    JsonObject vd = minimalViewDefinition();
    JsonObject where = vd.forceArray("where").addObject();
    where.add("path", "active");
    where.add("id", "w1");
    where.forceArray("modifierExtension");
    Validator v = newValidator();
    check(v, vd);
    assertNoUnknownPropertyIssues(v);
  }

  // Negative case: the broader allow-lists must not weaken the spirit of checkProperties - a
  // genuinely unknown property should still be reported.
  @Test
  @DisplayName("genuinely unknown property is still rejected")
  void genuinelyUnknownPropertyIsStillRejected() {
    JsonObject vd = minimalViewDefinition();
    vd.add("foo", "bar");
    Validator v = newValidator();
    check(v, vd);
    List<ValidationMessage> unknown = unknownPropertyIssues(v);
    assertEquals(1, unknown.size(), "expected exactly one unknown-property issue");
    assertTrue(unknown.get(0).getMessage().contains("foo"),
        "expected the unknown-property issue to name 'foo' but was: " + unknown.get(0).getMessage());
  }

  // Column type-conformance tests.
  //
  // The validator infers a column's type from its FHIRPath expression and, when the ViewDefinition
  // also declares a type, checks the two are compatible. A declared type must be accepted when it
  // shares a primitive base family with an inferred type (for example declared 'id' against an
  // inferred 'string'), while a genuine cross-family mismatch must still be rejected.

  /**
   * Builds a minimal ViewDefinition on the given resource with a single column that has the given
   * path and, when non-null, the given declared type.
   */
  private static JsonObject viewWithColumn(String resource, String path, String declaredType) {
    JsonObject vd = new JsonObject();
    vd.add("resourceType", "ViewDefinition");
    vd.add("name", "vt_test");
    vd.add("status", "active");
    vd.add("resource", resource);
    JsonObject select = vd.forceArray("select").addObject();
    JsonObject column = select.forceArray("column").addObject();
    column.add("name", "c");
    column.add("path", path);
    if (declaredType != null) {
      column.add("type", declaredType);
    }
    return vd;
  }

  /**
   * Round-trips the ViewDefinition through the JSON parser (so elements carry source locations) and
   * validates it, returning the parsed object so tests can inspect the resolved column.
   */
  private static JsonObject checkAndParse(Validator v, JsonObject vd) {
    JsonObject parsed;
    try {
      parsed = JsonParser.parseObject(JsonParser.compose(vd));
    } catch (Exception e) {
      throw new RuntimeException("Failed to round-trip ViewDefinition fixture", e);
    }
    v.checkViewDefinition("ViewDefinition", parsed);
    return parsed;
  }

  /**
   * Filters validation issues down to the column type-conformance errors so test failures point
   * precisely at this check.
   */
  private static List<ValidationMessage> typeConformanceIssues(Validator v) {
    return v.getIssues().stream()
        .filter(m -> m.getMessage() != null
            && m.getMessage().contains("does not return a value of the type"))
        .collect(Collectors.toList());
  }

  private static void assertNoTypeConformanceIssues(Validator v) {
    List<ValidationMessage> issues = typeConformanceIssues(v);
    if (!issues.isEmpty()) {
      String detail = issues.stream()
          .map(m -> m.getLocation() + ": " + m.getMessage())
          .collect(Collectors.joining("\n  "));
      fail("Expected no type-conformance issues but got:\n  " + detail);
    }
  }

  /** Returns the resolved column recorded on the (single) column of a validated ViewDefinition. */
  private static Column resolvedColumn(JsonObject parsed) {
    JsonObject column = parsed.getJsonArray("select").asJsonObjects().get(0)
        .getJsonArray("column").asJsonObjects().get(0);
    Column col = (Column) column.getUserData("column");
    assertTrue(col != null, "expected a resolved column to be recorded");
    return col;
  }

  static Stream<org.junit.jupiter.params.provider.Arguments> sameFamilyDeclarations() {
    // resource, path, declared type, expected resolved storage kind. The declared type resolves the
    // column's type to its base family, so its storage kind is that of the family it belongs to.
    return Stream.of(
        // Declared 'id' where the engine types Resource.id as 'string'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "id", "id", ColumnKind.String),
        // Declared 'string' where the engine types Patient.gender as 'code'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "gender", "string",
            ColumnKind.String),
        // Declared 'positiveInt' where the engine types the integer choice as 'integer'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "multipleBirth.ofType(integer)",
            "positiveInt", ColumnKind.Integer),
        // Declared 'instant' where the engine types the dateTime choice as 'dateTime'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "deceased.ofType(dateTime)",
            "instant", ColumnKind.DateTime),
        // Declared 'date' where a FHIRPath function types the value as System.DateTime.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "birthDate.lowBoundary()", "date",
            ColumnKind.DateTime));
  }

  @ParameterizedTest(name = "same-family declared {2} on {0}.{1} is accepted")
  @MethodSource("sameFamilyDeclarations")
  void sameFamilyDeclarationIsAccepted(String resource, String path, String declaredType,
      ColumnKind expectedKind) {
    Validator v = newValidator();
    JsonObject parsed = checkAndParse(v, viewWithColumn(resource, path, declaredType));
    assertNoTypeConformanceIssues(v);
    // The declared type resolves the column to its base family, giving the expected storage kind.
    assertEquals(expectedKind, resolvedColumn(parsed).getKind(),
        "resolved column should carry the declared type's storage kind");
  }

  @Test
  @DisplayName("declared instant on a boolean|dateTime union matches the dateTime member")
  void multiTypeUnionAcceptsWhenOneFamilyMatches() {
    // Patient.deceased[x] is boolean|dateTime; declaring 'instant' must match the dateTime member.
    Validator v = newValidator();
    JsonObject parsed = checkAndParse(v, viewWithColumn("Patient", "deceased", "instant"));
    assertNoTypeConformanceIssues(v);
    assertEquals(ColumnKind.DateTime, resolvedColumn(parsed).getKind());
  }

  static Stream<org.junit.jupiter.params.provider.Arguments> crossFamilyDeclarations() {
    // resource, path, declared type from a different primitive family than the inferred type.
    return Stream.of(
        // Declared 'integer' where the engine types Resource.id as 'string'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "id", "integer"),
        // Declared 'boolean' where the engine types Resource.id as 'string'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "id", "boolean"),
        // Declared 'base64Binary' where the engine types the dateTime choice as 'dateTime'.
        org.junit.jupiter.params.provider.Arguments.of("Patient", "deceased.ofType(dateTime)",
            "base64Binary"));
  }

  @ParameterizedTest(name = "cross-family declared {2} on {0}.{1} is rejected")
  @MethodSource("crossFamilyDeclarations")
  void crossFamilyDeclarationIsRejected(String resource, String path, String declaredType) {
    Validator v = newValidator();
    check(v, viewWithColumn(resource, path, declaredType));
    List<ValidationMessage> issues = typeConformanceIssues(v);
    assertEquals(1, issues.size(),
        "expected exactly one type-conformance error for a cross-family declaration");
  }
}
