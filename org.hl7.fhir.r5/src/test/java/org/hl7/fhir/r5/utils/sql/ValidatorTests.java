package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hl7.fhir.utilities.UserDataNames;

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
import org.junit.jupiter.params.provider.Arguments;
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
    return newValidator(TrueFalseOrUnknown.UNKNOWN);
  }

  private static Validator newValidator(TrueFalseOrUnknown complexTypes) {
    return new Validator(context, fpe, new ArrayList<>(), TrueFalseOrUnknown.UNKNOWN, complexTypes, TrueFalseOrUnknown.UNKNOWN);
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

  // ViewDefinition logical-model fields and inherited Resource/MetadataResource fields that SUSHI
  // emits on Instances generated from the logical model. The spec's CI build snapshot at
  // https://build.fhir.org/ig/HL7/sql-on-fhir/en/StructureDefinition-ViewDefinition.html
  // is the authoritative source for this list.
  static Stream<String> topLevelInheritedFields() {
    return Stream.of("resourceDefinition", "id", "meta", "text", "language", "implicitRules", "contained",
        "modifierExtension", "profile", "fhirVersion", "jurisdiction", "purpose", "copyrightLabel",
        "versionAlgorithmString", "versionAlgorithmCoding", "approvalDate", "lastReviewDate",
        "effectivePeriod", "topic", "author", "editor", "reviewer", "endorser", "relatedArtifact");
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
        || "fhirVersion".equals(field) || "topic".equals(field) || "author".equals(field)
        || "editor".equals(field) || "reviewer".equals(field) || "endorser".equals(field)
        || "relatedArtifact".equals(field)) {
      vd.forceArray(field);
    } else if ("meta".equals(field) || "text".equals(field)
        || "versionAlgorithmCoding".equals(field) || "effectivePeriod".equals(field)) {
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

  // A 0..1 column under repeat over a recursive 0..* path must not warn that the column path
  // "might return multiple values" - each yielded element is processed as a single row.
  @Test
  void repeatWithSingletonColumnDoesNotWarn() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t8\",\n"
        + "  \"resource\": \"QuestionnaireResponse\",\n"
        + "  \"select\": [{\n"
        + "    \"repeat\": [\"item\", \"answer.item\"],\n"
        + "    \"column\": [\n"
        + "      { \"name\": \"linkId\", \"path\": \"linkId\", \"type\": \"string\" }\n"
        + "    ]\n"
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

  static Stream<Arguments> sameFamilyDeclarations() {
    // resource, path, declared type, expected resolved storage kind. The declared type resolves the
    // column's type to its base family, so its storage kind is that of the family it belongs to.
    return Stream.of(
        // Declared 'id' where the engine types Resource.id as 'string'.
        Arguments.of("Patient", "id", "id", ColumnKind.String),
        // Declared 'string' where the engine types Patient.gender as 'code'.
        Arguments.of("Patient", "gender", "string",
            ColumnKind.String),
        // Declared 'positiveInt' where the engine types the integer choice as 'integer'.
        Arguments.of("Patient", "multipleBirth.ofType(integer)",
            "positiveInt", ColumnKind.Integer),
        // Declared 'instant' where the engine types the dateTime choice as 'dateTime'.
        Arguments.of("Patient", "deceased.ofType(dateTime)",
            "instant", ColumnKind.DateTime),
        // Declared 'date' where a FHIRPath function types the value as System.DateTime.
        Arguments.of("Patient", "birthDate.lowBoundary()", "date",
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

  static Stream<Arguments> crossFamilyDeclarations() {
    // resource, path, declared type from a different primitive family than the inferred type.
    return Stream.of(
        // Declared 'integer' where the engine types Resource.id as 'string'.
        Arguments.of("Patient", "id", "integer"),
        // Declared 'boolean' where the engine types Resource.id as 'string'.
        Arguments.of("Patient", "id", "boolean"),
        // Declared 'base64Binary' where the engine types the dateTime choice as 'dateTime'.
        Arguments.of("Patient", "deceased.ofType(dateTime)",
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

  // A unionAll branch whose columns differ from the first branch is reported at that branch's
  // index, not at the branch count.
  @Test
  void unionMismatchIsReportedAtTheOffendingBranch() throws Exception {
    String vd = "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"name\": \"t9\",\n"
        + "  \"resource\": \"Patient\",\n"
        + "  \"select\": [{\n"
        + "    \"unionAll\": [\n"
        + "      { \"column\": [{ \"name\": \"a\", \"path\": \"id\", \"type\": \"id\" }] },\n"
        + "      { \"column\": [{ \"name\": \"a\", \"path\": \"id\", \"type\": \"id\" }] },\n"
        + "      { \"column\": [{ \"name\": \"b\", \"path\": \"id\", \"type\": \"id\" }] }\n"
        + "    ]\n"
        + "  }]\n"
        + "}";
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    assertIssueContains(v, "unionAll[2] column definitions do not match");
    assertNoIssueContains(v, "unionAll[3]");
  }

  // Malformed input must surface as validation issues, not as exceptions. A runner embedded in a
  // server reports issues to the caller; an escaping exception takes the request down instead.

  private static Validator validateJson(String vd) throws Exception {
    Validator v = newValidator();
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(vd));
    return v;
  }

  private static void assertIssueAt(Validator v, String location, String substring) {
    for (ValidationMessage m : v.getIssues()) {
      if (location.equals(m.getLocation()) && m.getMessage() != null && m.getMessage().contains(substring)) {
        return;
      }
    }
    fail("Expected an issue at '" + location + "' containing '" + substring + "'. All issues: " + v.getIssues());
  }

  // A one-branch unionAll is legal (the spec only asks for a warning). It must contribute its
  // columns to the enclosing select rather than blowing up.
  @Test
  void singleBranchUnionAllIsWarnedAndItsColumnsAreKept() throws Exception {
    String vd = "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"unionAll\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\",\"type\":\"id\"}]}]}]}";
    Validator v = newValidator();
    JsonObject parsed = JsonParser.parseObject(vd);
    v.checkViewDefinition("ViewDefinition", parsed);
    assertTrue(v.isOk(), "a single-branch union is not an error: " + v.getIssues());
    assertIssueContains(v, "unionAll should have more than one item");
    @SuppressWarnings("unchecked")
    List<Column> columns = (List<Column>) parsed.getUserData(UserDataNames.db_columns);
    assertEquals(1, columns.size(), "the union branch's column must reach the view");
    assertEquals("id", columns.get(0).getName());
  }

  @Test
  void unionAllThatIsNotAnArrayIsReported() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]},{\"unionAll\":\"x\"}]}");
    assertFalse(v.isOk());
    assertIssueAt(v, "ViewDefinition.select[1].unionAll", "union is not an array");
  }

  @Test
  void whereWithoutPathIsReported() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"where\":[{\"description\":\"no path\"}],\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertFalse(v.isOk());
    assertIssueAt(v, "ViewDefinition.where[0]", "No path provided");
  }

  @Test
  void whereWithNonStringPathIsReported() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"where\":[{\"path\":5}],\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertFalse(v.isOk());
    assertIssueAt(v, "ViewDefinition.where[0].path", "path must be a string");
  }

  // The resource-type error is about 'resource', so it has to be anchored there - and must not
  // depend on an unrelated 'name' being present.
  @Test
  void unknownResourceTypeWithoutNameIsReportedAtResource() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"resource\":\"Patinet\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertFalse(v.isOk());
    assertIssueAt(v, "ViewDefinition.resource", "'Patinet' is not a valid resource type");
  }

  static Stream<Arguments> malformedConstantValues() {
    // property, JSON value that is the right JSON kind but not a valid FHIR value of that type
    return Stream.of(
        Arguments.of("valueDate", "\"not-a-date\""),
        Arguments.of("valueDateTime", "\"not-a-datetime\""),
        Arguments.of("valueInteger", "1.5"),
        Arguments.of("valueInteger64", "1.5"));
  }

  @ParameterizedTest(name = "malformed {0} {1} is reported")
  @MethodSource("malformedConstantValues")
  void malformedConstantValueIsReported(String property, String json) throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"constant\":[{\"name\":\"k\"," + "\"" + property + "\":" + json + "}],"
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertFalse(v.isOk());
    assertIssueAt(v, "ViewDefinition.constant[0]." + property, "Invalid value for " + property);
  }

  // Column names must be unique across the whole view, not just within one select. Two sibling
  // top-level selects that both emit 'id' is the case the per-select check misses.
  @Test
  void duplicateColumnAcrossSiblingSelectsIsReported() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]},{\"column\":[{\"name\":\"id\",\"path\":\"gender\"}]}]}");
    assertFalse(v.isOk());
    assertIssueContains(v, "Duplicate Column Name 'id'");
  }

  // SQL identifiers are case-insensitive on most targets and the runner already merges cells by
  // name ignoring case, so the validator applies the same policy.
  @Test
  void columnNamesDifferingOnlyByCaseAreReported() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"},{\"name\":\"ID\",\"path\":\"gender\"}]}]}");
    assertFalse(v.isOk());
    assertIssueContains(v, "Duplicate Column Name 'ID'");
    assertIssueContains(v, "ignoring case");
  }

  // A duplicate between a parent select and its nested select is already caught at the parent;
  // the view-level pass must not report it a second time.
  @Test
  void duplicateColumnAcrossNestedSelectIsReportedOnce() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}],\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"gender\"}]}]}]}");
    long count = v.getIssues().stream()
        .filter(m -> m.getMessage().contains("Duplicate Column Name")).count();
    assertEquals(1, count, "expected exactly one duplicate report: " + v.getIssues());
  }

  // sql-name: ^[A-Za-z][A-Za-z0-9_]*$ - ASCII letters and digits only, and the first character must
  // be a letter.
  static Stream<String> invalidNames() {
    return Stream.of("1abc", "_a", "a-b", "a b", "caf\u00e9", "a.b", "\u0661x");
  }

  @ParameterizedTest(name = "column name '{0}' is rejected")
  @MethodSource("invalidNames")
  void invalidColumnNameIsRejected(String name) throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"" + name + "\",\"path\":\"id\"}]}]}");
    assertIssueAt(v, "ViewDefinition.select[0].column[0].name", "is not valid");
  }

  static Stream<String> validNames() {
    return Stream.of("a", "Z", "A_1", "abc123", "camelCase", "snake_case_9");
  }

  @ParameterizedTest(name = "column name '{0}' is accepted")
  @MethodSource("validNames")
  void validColumnNameIsAccepted(String name) throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"" + name + "\",\"path\":\"id\"}]}]}");
    assertNoIssueContains(v, "is not valid");
  }

  @Test
  void viewNameStartingWithDigitIsRejected() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"1view\",\"resource\":\"Patient\","
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertIssueAt(v, "ViewDefinition.name", "'1view' is not valid");
  }

  @Test
  void constantNameStartingWithDigitIsRejected() throws Exception {
    Validator v = validateJson("{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"constant\":[{\"name\":\"1k\",\"valueString\":\"x\"}],"
        + "\"select\":[{\"column\":[{\"name\":\"id\",\"path\":\"id\"}]}]}");
    assertIssueAt(v, "ViewDefinition.constant[0].name", "'1k' is not valid");
  }

  // unionAll branches must produce the same FHIR types, not merely the same storage family: a
  // 'code' and an 'id' both store as text but are different column types under the spec.
  private static String unionOfTwoTypedColumns(String path1, String type1, String path2, String type2) {
    return "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"resource\":\"Patient\","
        + "\"select\":[{\"unionAll\":["
        + "{\"column\":[{\"name\":\"v\",\"path\":\"" + path1 + "\"" + (type1 == null ? "" : ",\"type\":\"" + type1 + "\"") + "}]},"
        + "{\"column\":[{\"name\":\"v\",\"path\":\"" + path2 + "\"" + (type2 == null ? "" : ",\"type\":\"" + type2 + "\"") + "}]}"
        + "]}]}";
  }

  static Stream<Arguments> mismatchedUnionTypes() {
    return Stream.of(
        Arguments.of("gender", "code", "id", "id"),
        Arguments.of("birthDate", "date", "meta.lastUpdated", "instant"),
        Arguments.of("birthDate", "date", "deceased.ofType(dateTime)", "dateTime"));
  }

  @ParameterizedTest(name = "union of {1} and {3} is rejected")
  @MethodSource("mismatchedUnionTypes")
  void unionBranchesWithDifferentFhirTypesAreRejected(String path1, String type1, String path2, String type2) throws Exception {
    Validator v = validateJson(unionOfTwoTypedColumns(path1, type1, path2, type2));
    assertFalse(v.isOk());
    assertIssueContains(v, "unionAll[1] column definitions do not match");
    assertIssueContains(v, "Types differ: '" + type1 + "' vs '" + type2 + "'");
  }

  @Test
  void unionBranchesWithSameDeclaredTypeAreAccepted() throws Exception {
    Validator v = validateJson(unionOfTwoTypedColumns("gender", "code", "maritalStatus.coding.first().code", "code"));
    assertNoIssueContains(v, "column definitions do not match");
  }

  // The column type is the declared type when present, otherwise the inferred one; a branch
  // that infers 'code' matches a branch that declares it.
  @Test
  void unionBranchInferredTypeMatchesDeclaredType() throws Exception {
    Validator v = validateJson(unionOfTwoTypedColumns("gender", "code", "gender", null));
    assertNoIssueContains(v, "column definitions do not match");
  }

  // A branch whose column is the empty collection has no type of its own and takes the type of
  // the other branch, so the union's column is usable by storage.
  @Test
  void unionBranchWithEmptyCollectionAdoptsOtherBranchType() throws Exception {
    Validator v = newValidator();
    JsonObject parsed = JsonParser.parseObject(unionOfTwoTypedColumns("{}", null, "gender", "code"));
    v.checkViewDefinition("ViewDefinition", parsed);
    assertNoIssueContains(v, "column definitions do not match");
    @SuppressWarnings("unchecked")
    List<Column> columns = (List<Column>) parsed.getUserData(UserDataNames.db_columns);
    assertEquals("code", columns.get(0).getType());
    assertEquals(ColumnKind.String, columns.get(0).getKind());
  }

  // The resolved column keeps the FHIR type (used for union comparison and by storage layers),
  // while its storage kind is still the primitive family.
  @Test
  void resolvedColumnKeepsDeclaredFhirType() {
    Validator v = newValidator();
    Column col = resolvedColumn(checkAndParse(v, viewWithColumn("Patient", "birthDate", "date")));
    assertEquals("date", col.getType());
    assertEquals(ColumnKind.DateTime, col.getKind());
  }

  @Test
  void resolvedColumnKeepsInferredFhirType() {
    Validator v = newValidator();
    Column col = resolvedColumn(checkAndParse(v, viewWithColumn("Patient", "gender", null)));
    assertEquals("code", col.getType());
    assertEquals(ColumnKind.String, col.getKind());
  }

  // column.type may be a StructureDefinition URI, a bare type name, or element-id notation for a
  // backbone element (spec: "Element-id notation (e.g. Observation.referenceRange) is allowed").
  @Test
  void elementIdTypeNotationIsAccepted() {
    Validator v = newValidator(TrueFalseOrUnknown.TRUE);
    JsonObject vd = viewWithColumn("Observation", "referenceRange", "Observation.referenceRange");
    vd.getJsonArray("select").asJsonObjects().get(0).getJsonArray("column").asJsonObjects().get(0)
        .add("collection", true);
    JsonObject parsed = checkAndParse(v, vd);
    assertNoTypeConformanceIssues(v);
    Column col = resolvedColumn(parsed);
    assertEquals("Observation.referenceRange", col.getType());
    assertEquals(ColumnKind.Complex, col.getKind());
  }

  @Test
  void wrongElementIdTypeIsRejected() {
    Validator v = newValidator(TrueFalseOrUnknown.TRUE);
    JsonObject vd = viewWithColumn("Observation", "referenceRange", "Observation.component");
    vd.getJsonArray("select").asJsonObjects().get(0).getJsonArray("column").asJsonObjects().get(0)
        .add("collection", true);
    check(v, vd);
    assertEquals(1, typeConformanceIssues(v).size());
  }

  @Test
  void fullStructureDefinitionUriTypeIsAccepted() {
    Validator v = newValidator();
    Column col = resolvedColumn(checkAndParse(v,
        viewWithColumn("Observation", "status", "http://hl7.org/fhir/StructureDefinition/code")));
    assertNoTypeConformanceIssues(v);
    assertEquals("code", col.getType());
  }
}
