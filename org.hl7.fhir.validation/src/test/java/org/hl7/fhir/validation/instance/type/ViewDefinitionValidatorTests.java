package org.hl7.fhir.validation.instance.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ViewDefinitionValidator}, the element-model validator used when a
 * ViewDefinition is parsed as a resource. The SQL on FHIR 3.0.0-ballot model declares
 * ViewDefinition as a resource (an R6 "additional resource"), so its StructureDefinition from the
 * published hl7.fhir.uv.sql-on-fhir package is cached into an R5 engine context, which is enough
 * for the instance to be typed as "ViewDefinition" and routed to this validator.
 *
 * @author John Grimes
 */
class ViewDefinitionValidatorTests {

  private static ValidationEngine engine;
  private static InstanceValidator validator;

  @BeforeAll
  static void setUpAll() throws Exception {
    engine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    NpmPackage npm = new FilesystemPackageCacheManager.Builder().build()
        .loadPackage("hl7.fhir.uv.sql-on-fhir#3.0.0-ballot");
    StructureDefinition sd = (StructureDefinition) new JsonParser()
        .parse(npm.loadResource("StructureDefinition-ViewDefinition.json"));
    engine.getContext().cacheResource(sd);
    validator = engine.getValidator(FhirFormat.JSON);
  }

  @AfterAll
  static void tearDownAll() {
    // Release the per-class engine so it does not stay resident for the rest of the module's test
    // JVM.
    validator = null;
    engine = null;
    System.gc();
  }

  private static List<ValidationMessage> validate(String json) {
    List<ValidationMessage> messages = new ArrayList<>();
    validator.validate(null, messages, new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)),
        FhirFormat.JSON);
    return messages;
  }

  private static List<ValidationMessage> withId(List<ValidationMessage> messages, String messageId) {
    return messages.stream().filter(m -> messageId.equals(m.getMessageId())).collect(Collectors.toList());
  }

  private static List<ValidationMessage> errors(List<ValidationMessage> messages) {
    return messages.stream()
        .filter(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL)
        .collect(Collectors.toList());
  }

  private static void assertNoneWithId(List<ValidationMessage> messages, String messageId) {
    List<ValidationMessage> found = withId(messages, messageId);
    assertTrue(found.isEmpty(), "Expected no " + messageId + " but found: " + found);
  }

  private static ValidationMessage assertOneWithId(List<ValidationMessage> messages, String messageId) {
    List<ValidationMessage> found = withId(messages, messageId);
    assertEquals(1, found.size(), "Expected exactly one " + messageId + " but found: " + messages);
    return found.get(0);
  }

  // ViewDefinition is an R6 additional resource, so instances carry resourceDefinition alongside
  // resourceType; without it the instance validator reports an error before this validator runs.
  private static String view(String resource, String selects) {
    return "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"resourceDefinition\": \"http://hl7.org/fhir/StructureDefinition/ViewDefinition|3.0.0-ballot\",\n"
        + "  \"name\": \"vt_test\",\n"
        + "  \"status\": \"active\",\n"
        + "  \"resource\": \"" + resource + "\",\n"
        + "  \"select\": [" + selects + "]\n"
        + "}";
  }

  private static String column(String name, String path, String type) {
    return "{ \"name\": \"" + name + "\", \"path\": \"" + path + "\""
        + (type == null ? "" : ", \"type\": \"" + type + "\"") + " }";
  }

  // repeat is 0..* on select. Reading it as a single child throws once a select lists more than one
  // path, so a two-path repeat must be validated rather than blow up the validator.
  @Test
  void repeatWithMultiplePathsIsValidated() {
    List<ValidationMessage> messages = validate(view("QuestionnaireResponse",
        "{ \"repeat\": [\"item\", \"answer.item\"], \"column\": [" + column("linkId", "linkId", "string") + "] }"));
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
  }

  // Each element yielded by repeat is processed as a single row, so a 0..1 column path under it
  // must not be flagged as possibly returning multiple values - the same contract as forEach.
  @Test
  void repeatSingletonColumnIsNotFlaggedAsCollection() {
    List<ValidationMessage> messages = validate(view("QuestionnaireResponse",
        "{ \"repeat\": [\"item\"], \"column\": [" + column("linkId", "linkId", "string") + "] }"));
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED1);
  }

  // Resource.id is typed as 'string' by the engine; declaring the column as 'id' is a valid
  // same-family declaration and must not be reported as a type mismatch.
  @Test
  void sameFamilyDeclaredTypeIsAccepted() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_TYPE_MISMATCH);
  }

  // A declared type from a different primitive family than the inferred type is still an error.
  @Test
  void crossFamilyDeclaredTypeIsRejected() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"column\": [" + column("id", "id", "integer") + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_TYPE_MISMATCH);
  }

  // unionAll branches whose columns agree in name, kind and collection status are accepted.
  @Test
  void unionAllWithMatchingColumnsIsAccepted() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": ["
        + "  { \"column\": [" + column("value", "id", "string") + "] },"
        + "  { \"column\": [" + column("value", "gender", "string") + "] }"
        + "] }"));
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_UNION_SINGLE);
  }

  // Branch columns with different names cannot be unioned.
  @Test
  void unionAllWithDifferentColumnNamesIsRejected() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": ["
        + "  { \"column\": [" + column("value", "id", "string") + "] },"
        + "  { \"column\": [" + column("other", "id", "string") + "] }"
        + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNION_MISMATCH);
    assertEquals(IssueSeverity.ERROR, m.getLevel());
    assertTrue(m.getMessage().contains("'value' vs 'other'"), m.getMessage());
  }

  // Branch columns of the same name but different storage kinds cannot be unioned.
  @Test
  void unionAllWithDifferentColumnKindsIsRejected() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": ["
        + "  { \"column\": [" + column("value", "id", "string") + "] },"
        + "  { \"column\": [" + column("value", "active", "boolean") + "] }"
        + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNION_MISMATCH);
    assertTrue(m.getMessage().contains("Kinds differ"), m.getMessage());
  }

  // A unionAll with a single branch is legal but pointless, so it is reported as a warning.
  @Test
  void unionAllWithSingleBranchWarns() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": [ { \"column\": [" + column("value", "id", "string") + "] } ] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNION_SINGLE);
    assertEquals(IssueSeverity.WARNING, m.getLevel());
  }

  // The union's columns are part of the enclosing select's output, so they take part in the
  // duplicate column name check alongside the select's own columns.
  @Test
  void unionColumnsTakePartInDuplicateNameCheck() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"column\": [" + column("id", "id", "string") + "],"
        + "  \"unionAll\": ["
        + "  { \"column\": [" + column("id", "id", "string") + "] },"
        + "  { \"column\": [" + column("id", "gender", "string") + "] }"
        + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_DUPL_COL_NAME);
  }

  // Matching branches on their own must not trip the duplicate check - the branches are
  // alternatives, not additional columns.
  @Test
  void matchingUnionBranchesAreNotDuplicates() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": ["
        + "  { \"column\": [" + column("id", "id", "string") + "] },"
        + "  { \"column\": [" + column("id", "gender", "string") + "] }"
        + "] }"));
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_DUPL_COL_NAME);
  }
}
