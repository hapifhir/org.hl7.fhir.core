package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.sql.Validator.TrueFalseOrUnknown;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for the SQL on FHIR {@link Validator}. Covers two concerns:
 * <ul>
 *   <li>Property allow-lists accept the fields declared on the ViewDefinition logical model
 *       (including inherited Resource/DomainResource/CanonicalResource fields and backbone
 *       Element fields), while still rejecting genuinely unknown properties.</li>
 *   <li>Collection-status handling under {@code forEach} and {@code forEachOrNull} - a
 *       singleton column path under a forEach iteration must not warn about returning
 *       multiple values, while genuinely multi-valued paths still must.</li>
 * </ul>
 *
 * @author John Grimes
 */
class ValidatorTests {

  private static IWorkerContext context;
  private static FHIRPathEngine fpe;

  @BeforeAll
  static void setUpAll() {
    context = TestingUtilities.getSharedWorkerContext();
    fpe = new FHIRPathEngine(context);
    fpe.setEmitSQLonFHIRWarning(true);
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

  private static void assertNoIssueContains(Validator v, String substring) {
    for (ValidationMessage m : v.getIssues()) {
      assertFalse(m.getMessage() != null && m.getMessage().contains(substring),
          "Expected no issue containing '" + substring + "' but found: " + m.getMessage());
    }
  }

  private static void assertIssueContains(Validator v, String substring) {
    boolean found = false;
    for (ValidationMessage m : v.getIssues()) {
      if (m.getMessage() != null && m.getMessage().contains(substring)) {
        found = true;
        break;
      }
    }
    assertTrue(found, "Expected an issue containing '" + substring + "' but found none. All issues: "
        + v.getIssues());
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

  // A 0..1 column under forEach over a 0..* collection must not warn that the column
  // path "might return multiple values" - each iteration sees a single element.
  @Test
  void forEachWithSingletonColumnDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t1\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"use\",  \"path\": \"use\",  \"type\": \"code\" },\n"
        + "      { \"name\": \"city\", \"path\": \"city\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // Same as above but with forEachOrNull.
  @Test
  void forEachOrNullWithSingletonColumnDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t2\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEachOrNull\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"use\", \"path\": \"use\", \"type\": \"code\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // A nested select underneath a forEach should also see a singleton starting type.
  @Test
  void nestedSelectUnderForEachDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t3\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"select\": [{\n"
        + "      \"column\": [\n"
        + "        { \"name\": \"use\", \"path\": \"use\", \"type\": \"code\" }\n"
        + "      ]\n"
        + "    }]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
  }

  // A genuinely collection-valued column path (line is 0..* on Address) must still warn
  // when not marked collection: true. Regression guard.
  @Test
  void collectionColumnPathUnderForEachStillWarnsWhenNotMarked() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t4\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"line\", \"path\": \"line\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }

  // Same as above but with collection: true - no warning should fire.
  @Test
  void collectionColumnPathUnderForEachIsQuietWhenMarked() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t5\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"address\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"line\", \"path\": \"line\", \"type\": \"string\", \"collection\": true }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertNoIssueContains(v, "might return multiple values");
    assertNoIssueContains(v, "collection-is-true-but-path-is-singleton");
  }

  // A top-level multi-valued column path (no forEach) must still warn.
  @Test
  void topLevelMultiValuedColumnStillWarns() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t6\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"g\", \"path\": \"name.given\", \"type\": \"string\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }

  // A column path expression that is a union literal returns a collection regardless of
  // the starting type. The warning must still fire - proves the downgrade only changes
  // the starting type, not the column-path's own returned collection status.
  @Test
  void columnPathUnionLiteralUnderForEachStillWarns() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t7\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"forEach\": \"name.given\",\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"u\", \"path\": \"1 | 2 | 3\", \"type\": \"integer\" }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "might return multiple values");
  }
}
