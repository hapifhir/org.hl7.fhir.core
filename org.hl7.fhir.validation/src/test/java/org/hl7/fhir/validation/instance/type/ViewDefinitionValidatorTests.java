package org.hl7.fhir.validation.instance.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.utilities.formats.FhirFormat;

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

  private static final String LOGICAL_MODEL_URL = "http://example.org/fhir/StructureDefinition/ExternalTable";
  private static final String PROFILE_URL = "http://example.org/fhir/StructureDefinition/my-patient";
  private static final String UNRESOLVED_URL = "http://hospital.test/fhir/StructureDefinition/ExternalTable";

  // A logical model with three primitive elements, standing in for a type defined by an IG.
  private static final String LOGICAL_MODEL = "{\"resourceType\":\"StructureDefinition\",\"id\":\"ExternalTable\","
      + "\"url\":\"" + LOGICAL_MODEL_URL + "\",\"name\":\"ExternalTable\",\"status\":\"active\","
      + "\"kind\":\"logical\",\"abstract\":false,\"type\":\"" + LOGICAL_MODEL_URL + "\","
      + "\"baseDefinition\":\"http://hl7.org/fhir/StructureDefinition/Base\",\"derivation\":\"specialization\","
      + "\"snapshot\":{\"element\":["
      + "{\"id\":\"ExternalTable\",\"path\":\"ExternalTable\",\"min\":0,\"max\":\"*\","
      + "\"base\":{\"path\":\"Base\",\"min\":0,\"max\":\"*\"}},"
      + "{\"id\":\"ExternalTable.code\",\"path\":\"ExternalTable.code\",\"min\":0,\"max\":\"1\","
      + "\"base\":{\"path\":\"ExternalTable.code\",\"min\":0,\"max\":\"1\"},\"type\":[{\"code\":\"string\"}]},"
      + "{\"id\":\"ExternalTable.amount\",\"path\":\"ExternalTable.amount\",\"min\":0,\"max\":\"1\","
      + "\"base\":{\"path\":\"ExternalTable.amount\",\"min\":0,\"max\":\"1\"},\"type\":[{\"code\":\"decimal\"}]},"
      + "{\"id\":\"ExternalTable.tag\",\"path\":\"ExternalTable.tag\",\"min\":0,\"max\":\"*\","
      + "\"base\":{\"path\":\"ExternalTable.tag\",\"min\":0,\"max\":\"*\"},\"type\":[{\"code\":\"string\"}]}"
      + "]}}";

  // A profile of Patient. It resolves, but a view is based upon a type, not upon a profile.
  private static final String PROFILE = "{\"resourceType\":\"StructureDefinition\",\"id\":\"my-patient\","
      + "\"url\":\"" + PROFILE_URL + "\",\"name\":\"MyPatient\",\"status\":\"active\","
      + "\"kind\":\"resource\",\"abstract\":false,\"type\":\"Patient\","
      + "\"baseDefinition\":\"http://hl7.org/fhir/StructureDefinition/Patient\",\"derivation\":\"constraint\"}";

  private static ValidationEngine engine;
  private static InstanceValidator validator;

  @BeforeAll
  static void setUpAll() throws Exception {
    engine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    NpmPackage npm = new FilesystemPackageCacheManager.Builder().build()
        .loadPackage("hl7.fhir.uv.sql-on-fhir#3.0.0-ballot");
    JsonParser parser = new JsonParser(ModelContext.fullCoreContext());
    StructureDefinition sd = (StructureDefinition) parser.parse(npm.loadResource("StructureDefinition-ViewDefinition.json"));
    widenResourceElement(sd);
    engine.getContext().cacheResource(sd);
    engine.getContext().cacheResource(parser.parse(LOGICAL_MODEL));
    engine.getContext().cacheResource(parser.parse(PROFILE));
    validator = engine.getValidator(FhirFormat.JSON);
  }

  // The published 3.0.0-ballot package defines ViewDefinition.resource as a code with a required
  // binding to the resource types of the version it was built against. HL7/sql-on-fhir#433 makes
  // it a uri with an extensible binding, which is what lets a view name any other type. The
  // binding is dropped here rather than replaced, because the value set it names is not in R5.
  private static void widenResourceElement(StructureDefinition sd) {
    List<ElementDefinition> elements = new ArrayList<>(sd.getSnapshot().getElementList());
    elements.addAll(sd.getDifferential().getElementList());
    for (ElementDefinition ed : elements) {
      if ("ViewDefinition.resource".equals(ed.getPath())) {
        ed.getTypeFirstRep().setCode("uri");
        ed.setBinding(null);
      }
    }
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

  private static String view(String resource, String selects) {
    return view(resource, "", selects);
  }

  // ViewDefinition is an R6 additional resource, so instances carry resourceDefinition alongside
  // resourceType; without it the instance validator reports an error before this validator runs.
  // The fhirVersions argument is a comma-separated list of quoted versions, or empty for none.
  private static String view(String resource, String fhirVersions, String selects) {
    return "{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"resourceDefinition\": \"http://hl7.org/fhir/StructureDefinition/ViewDefinition|3.0.0-ballot\",\n"
        + "  \"name\": \"vt_test\",\n"
        + "  \"status\": \"active\",\n"
        + (fhirVersions.isEmpty() ? "" : "  \"fhirVersion\": [" + fhirVersions + "],\n")
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

  // Branch columns of the same name but different types cannot be unioned.
  @Test
  void unionAllWithDifferentColumnTypesIsRejected() {
    List<ValidationMessage> messages = validate(view("Patient",
        "{ \"unionAll\": ["
        + "  { \"column\": [" + column("value", "id", "string") + "] },"
        + "  { \"column\": [" + column("value", "active", "boolean") + "] }"
        + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNION_MISMATCH);
    assertTrue(m.getMessage().contains("'string' vs 'boolean'"), m.getMessage());
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

  // ---- ViewDefinition.resource: types of the declared FHIR version ----

  // DeviceUseStatement is an R4 resource type that R5 renamed. A view that declares R4 is checked
  // against the R4 definitions, so both the type and its R4-only element recordedOn are valid even
  // though the validator itself is running on R5.
  @Test
  void resourceTypeOfDeclaredVersionIsAccepted() {
    List<ValidationMessage> messages = validate(view("DeviceUseStatement", "\"4.0.1\"",
        "{ \"column\": [" + column("id", "id", "id") + ", " + column("recorded", "recordedOn", "dateTime") + "] }"));
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
  }

  // The reverse case: DeviceUsage exists in the host version (R5) but not in the declared version
  // (R4), so it must not be borrowed from the host.
  @Test
  void resourceTypeAbsentFromDeclaredVersionIsRejected() {
    List<ValidationMessage> messages = validate(view("DeviceUsage", "\"4.0.1\"",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
    assertEquals(IssueSeverity.ERROR, m.getLevel());
  }

  // With more than one declared version, the type is checked for each, and the message says which
  // version it is missing from.
  @Test
  void unknownResourceMessageNamesTheVersion() {
    List<ValidationMessage> messages = validate(view("DeviceUseStatement", "\"4.0.1\", \"5.0.0\"",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
    assertEquals("The name 'DeviceUseStatement' is not a valid resource for version R5", m.getMessage());
  }

  // With no declared version there is nothing to add to the message, and no unfilled placeholder
  // may be left in it.
  @Test
  void unknownResourceMessageHasNoPlaceholder() {
    List<ValidationMessage> messages = validate(view("Foo",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
    assertEquals("The name 'Foo' is not a valid resource", m.getMessage());
  }

  // A name in the FHIR namespace that is not a resource type, here a data type, is not a valid
  // basis for a view.
  @Test
  void dataTypeNameIsRejected() {
    List<ValidationMessage> messages = validate(view("HumanName",
        "{ \"column\": [" + column("family", "family", "string") + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
  }

  // An abstract type such as DomainResource has no instances of its own, so it is not a valid
  // basis for a view.
  @Test
  void abstractTypeNameIsRejected() {
    List<ValidationMessage> messages = validate(view("DomainResource",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
    assertEquals(IssueSeverity.ERROR, m.getLevel());
  }

  // ---- ViewDefinition.resource: types named by canonical URL ----

  // A logical model is named by the canonical URL of its StructureDefinition. The where and select
  // paths are checked against it.
  @Test
  void logicalModelUrlIsAccepted() {
    List<ValidationMessage> messages = validate("{\n"
        + "  \"resourceType\": \"ViewDefinition\",\n"
        + "  \"resourceDefinition\": \"http://hl7.org/fhir/StructureDefinition/ViewDefinition|3.0.0-ballot\",\n"
        + "  \"name\": \"vt_test\",\n"
        + "  \"status\": \"active\",\n"
        + "  \"resource\": \"" + LOGICAL_MODEL_URL + "\",\n"
        + "  \"where\": [{ \"path\": \"code.exists()\" }],\n"
        + "  \"select\": [{ \"column\": [" + column("code", "code", "string") + ", "
        + column("amount", "amount", "decimal") + "] }]\n"
        + "}");
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_NOT_RESOLVED);
  }

  // A path that the logical model does not define is an error, which shows the paths are checked
  // against the logical model rather than skipped.
  @Test
  void logicalModelPathsAreChecked() {
    List<ValidationMessage> messages = validate(view(LOGICAL_MODEL_URL,
        "{ \"column\": [" + column("missing", "nonexistent", "string") + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_PATH_ERROR);
  }

  // The cardinality of the logical model's elements is used: a repeating element in a column that
  // is not declared as a collection draws the usual hint.
  @Test
  void logicalModelCardinalityIsUsed() {
    List<ValidationMessage> messages = validate(view(LOGICAL_MODEL_URL,
        "{ \"column\": [" + column("tag", "tag", "string") + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_COLLECTION_NEEDED1);
  }

  // A URL with no StructureDefinition loaded may be defined by an IG that is not in scope, so it
  // is a warning. The paths cannot be checked, so they produce no errors of their own. The URL is
  // not an example.org one, because the validator rejects those where it cannot resolve them.
  @Test
  void unresolvedUrlWarnsAndSkipsPathChecks() {
    List<ValidationMessage> messages = validate(view(UNRESOLVED_URL,
        "{ \"column\": [" + column("missing", "nonexistent", "string") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_NOT_RESOLVED);
    assertEquals(IssueSeverity.WARNING, m.getLevel());
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
  }

  // The unresolved warning is raised once, not once for each declared version.
  @Test
  void unresolvedUrlWarnsOnceAcrossVersions() {
    List<ValidationMessage> messages = validate(view(UNRESOLVED_URL,
        "\"4.0.1\", \"5.0.0\"", "{ \"column\": [" + column("id", "id", "id") + "] }"));
    assertOneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_NOT_RESOLVED);
  }

  // A type in the FHIR namespace has to be identified by its name, not by its canonical URL.
  @Test
  void fhirNamespaceUrlIsRejected() {
    List<ValidationMessage> messages = validate(view("http://hl7.org/fhir/StructureDefinition/Patient",
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_USE_NAME);
    assertEquals(IssueSeverity.ERROR, m.getLevel());
    assertTrue(m.getMessage().contains("its name 'Patient'"), m.getMessage());
  }

  // A URL that resolves to a profile is an error: ViewDefinition.profile is the place for those.
  @Test
  void profileUrlIsRejected() {
    List<ValidationMessage> messages = validate(view(PROFILE_URL,
        "{ \"column\": [" + column("id", "id", "id") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_WRONG_KIND);
    assertEquals(IssueSeverity.ERROR, m.getLevel());
  }

  // ---- ViewDefinition.resource: types that only the host context defines ----

  // Logical models come from IGs, which are loaded into the host context only. A view that
  // declares other versions still resolves the type there, and its paths are checked once against
  // the host context rather than once for each version - so one bad path is one error, and the
  // message carries no version.
  @Test
  void hostOnlyLogicalModelIsCheckedOnceAcrossVersions() {
    List<ValidationMessage> messages = validate(view(LOGICAL_MODEL_URL, "\"4.0.1\", \"5.0.0\"",
        "{ \"column\": [" + column("code", "code", "string") + ", " + column("missing", "nonexistent", "string") + "] }"));
    ValidationMessage m = assertOneWithId(messages, I18nConstants.VIEWDEFINITION_PATH_ERROR);
    assertFalse(m.getMessage().contains("for version"), m.getMessage());
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_RESOURCE_NOT_RESOLVED);
    assertNoneWithId(messages, I18nConstants.VIEWDEFINITION_UNKNOWN_RESOURCE);
  }

  // An additional resource is named by its type but, like a logical model, is defined by an IG.
  // ViewDefinition itself is one, so a view over ViewDefinition that declares R4 is valid.
  @Test
  void additionalResourceOfHostIsAcceptedForOtherVersion() {
    List<ValidationMessage> messages = validate(view("ViewDefinition", "\"4.0.1\"",
        "{ \"column\": [" + column("name", "name", "string") + "] }"));
    assertEquals(new ArrayList<>(), errors(messages), "expected no errors");
  }
}
