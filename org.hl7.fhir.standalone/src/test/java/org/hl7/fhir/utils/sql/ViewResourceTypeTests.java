package org.hl7.fhir.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.ParserBase;
import org.hl7.fhir.services.elementmodel.XmlParser;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.services.sql.Provider;
import org.hl7.fhir.services.sql.Runner;
import org.hl7.fhir.services.sql.Validator;
import org.hl7.fhir.services.sql.Validator.TrueFalseOrUnknown;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Tests for how the SQL on FHIR {@link Validator} and {@link Runner} interpret
 * ViewDefinition.resource. A type in the FHIR namespace is identified by its name, and any other
 * type, such as a logical model, by the canonical URL of its StructureDefinition.
 *
 * <p>The tests add a logical model and a profile to the context, so they use a context of their
 * own rather than the one shared with the other tests.
 *
 * @author John Grimes
 */
class ViewResourceTypeTests {

  private static final String LOGICAL_MODEL_URL = "http://example.org/fhir/StructureDefinition/ExternalTable";
  private static final String PROFILE_URL = "http://example.org/fhir/StructureDefinition/my-patient";

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

  private static SimpleWorkerContext context;
  private static StructureDefinition logicalModel;
  private static FHIRPathEngine fpe;

  @BeforeAll
  static void setUpAll() throws Exception {
    context = TestingUtilities.getWorkerContext(TestingUtilities.DEFAULT_CONTEXT_VERSION);
    org.hl7.fhir.model.core.formats.JsonParser parser = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext());
    logicalModel = (StructureDefinition) parser.parse(LOGICAL_MODEL);
    context.cacheResource(logicalModel);
    context.cacheResource(parser.parse(PROFILE));
    fpe = new FHIRPathEngine(context);
    fpe.setEmitSQLonFHIRWarning(true);
  }

  @AfterAll
  static void tearDownAll() {
    // Release the per-class context so it does not stay resident for the rest of the module's
    // test JVM.
    fpe = null;
    logicalModel = null;
    context = null;
  }

  private static String view(String resource, String columnPath) {
    return "{\"resourceType\":\"ViewDefinition\",\"name\":\"t\",\"status\":\"active\","
        + "\"resource\":\"" + resource + "\",\"select\":[{\"column\":[{\"name\":\"c\",\"path\":\"" + columnPath + "\"}]}]}";
  }

  // ---- Validator ----

  private static Validator validate(String viewJson) throws Exception {
    Validator v = new Validator(context, fpe, new ArrayList<>(), TrueFalseOrUnknown.UNKNOWN, TrueFalseOrUnknown.UNKNOWN,
        TrueFalseOrUnknown.UNKNOWN);
    v.checkViewDefinition("ViewDefinition", JsonParser.parseObject(viewJson));
    return v;
  }

  private static List<ValidationMessage> errors(Validator v) {
    return v.getIssues().stream()
        .filter(m -> m.getLevel() == IssueSeverity.ERROR || m.getLevel() == IssueSeverity.FATAL)
        .collect(Collectors.toList());
  }

  private static void assertOneErrorAtResource(Validator v, String substring) {
    List<ValidationMessage> errors = errors(v);
    assertEquals(1, errors.size(), "Expected exactly one error but found: " + errors);
    assertEquals("ViewDefinition.resource", errors.get(0).getLocation());
    assertTrue(errors.get(0).getMessage().contains(substring), errors.get(0).getMessage());
  }

  // A logical model is named by the canonical URL of its StructureDefinition, and the paths in the
  // view are checked against it.
  @Test
  void logicalModelUrlIsAccepted() throws Exception {
    Validator v = validate(view(LOGICAL_MODEL_URL, "code"));
    assertEquals(new ArrayList<>(), errors(v), "expected no errors");
    assertEquals(LOGICAL_MODEL_URL, v.getResourceName());
  }

  // A path that the logical model does not define is an error, which shows the paths are checked
  // against the logical model rather than skipped.
  @Test
  void logicalModelPathsAreChecked() throws Exception {
    Validator v = validate(view(LOGICAL_MODEL_URL, "nonexistent"));
    List<ValidationMessage> errors = errors(v);
    assertEquals(1, errors.size(), "Expected exactly one error but found: " + errors);
    assertEquals("ViewDefinition.select[0].column[0]", errors.get(0).getLocation());
  }

  // The runner cannot type the columns of a view without the definition of its type, so a URL that
  // does not resolve is an error here.
  @Test
  void unresolvedUrlIsRejected() throws Exception {
    Validator v = validate(view("http://hospital.test/fhir/StructureDefinition/ExternalTable", "code"));
    assertOneErrorAtResource(v, "could not be resolved to a StructureDefinition");
  }

  // A type in the FHIR namespace has to be identified by its name, not by its canonical URL.
  @Test
  void fhirNamespaceUrlIsRejected() throws Exception {
    Validator v = validate(view("http://hl7.org/fhir/StructureDefinition/Patient", "id"));
    assertOneErrorAtResource(v, "must be identified by its name 'Patient'");
  }

  // A URL that resolves to a profile is an error: ViewDefinition.profile is the place for those.
  @Test
  void profileUrlIsRejected() throws Exception {
    Validator v = validate(view(PROFILE_URL, "id"));
    assertOneErrorAtResource(v, "is not a resource type or a logical model");
  }

  // A name in the FHIR namespace that is not a resource type, here a data type, is not a valid
  // basis for a view.
  @Test
  void dataTypeNameIsRejected() throws Exception {
    Validator v = validate(view("HumanName", "family"));
    assertOneErrorAtResource(v, "'HumanName' is not a valid resource type");
  }

  // An abstract type such as DomainResource has no instances of its own, so it is not a valid
  // basis for a view.
  @Test
  void abstractTypeNameIsRejected() throws Exception {
    Validator v = validate(view("DomainResource", "id"));
    assertOneErrorAtResource(v, "'DomainResource' is not a valid resource type");
  }

  // The context resolves a canonical URL that carries a version, but a version is not part of the
  // name of a type.
  @Test
  void versionedNameIsRejected() throws Exception {
    String version = Validator.fetchType(context, "Patient").getVersion();
    Validator v = validate(view("Patient|" + version, "id"));
    assertOneErrorAtResource(v, "is not a valid resource type");
  }

  // ---- Runner ----

  /** A provider that serves the given data for one type, and records the type it was asked for. */
  private static class SingleTypeProvider implements Provider {
    private final List<Base> data;
    private String requested;

    SingleTypeProvider(Base... data) {
      this.data = Arrays.asList(data);
    }

    @Override
    public List<Base> fetch(String resourceType) {
      requested = resourceType;
      return data;
    }

    @Override
    public Base resolveReference(Base rootResource, String ref, String specifiedResourceType) {
      return null;
    }
  }

  private static Runner newRunner(Provider provider, TestStorage storage) {
    Runner runner = new Runner();
    runner.setContext(context);
    runner.setProvider(provider);
    runner.setStorage(storage);
    return runner;
  }

  private static Element parse(ParserBase parser, String source) throws Exception {
    return parser.parseSingle(new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)), new ArrayList<>());
  }

  private static Element logicalInstanceFromJson(String code) throws Exception {
    return parse(new org.hl7.fhir.services.elementmodel.JsonParser(context).setLogical(logicalModel),
        "{\"resourceType\":\"ExternalTable\",\"code\":\"" + code + "\",\"amount\":1.5}");
  }

  private static Element logicalInstanceFromXml(String code) throws Exception {
    return parse(new XmlParser(context).setLogical(logicalModel),
        "<ExternalTable><code value=\"" + code + "\"/><amount value=\"1.5\"/></ExternalTable>");
  }

  private static Element resourceFromJson(String json) throws Exception {
    return parse(new org.hl7.fhir.services.elementmodel.JsonParser(context), json);
  }

  // Batch mode: the provider is asked for the type exactly as the view names it, and the instances
  // of the logical model that it returns produce rows.
  @Test
  void logicalModelInstancesProduceRows() throws Exception {
    TestStorage storage = new TestStorage();
    SingleTypeProvider provider = new SingleTypeProvider(logicalInstanceFromJson("a"), logicalInstanceFromJson("b"));

    newRunner(provider, storage).execute(JsonParser.parseObject(view(LOGICAL_MODEL_URL, "code")));

    assertEquals(LOGICAL_MODEL_URL, provider.requested);
    assertEquals(2, storage.getResults().size());
    assertEquals("a", ((JsonObject) storage.getResults().get(0)).asString("c"));
    assertEquals("b", ((JsonObject) storage.getResults().get(1)).asString("c"));
  }

  // The type of an instance is taken from its definition, not from the name the parser gave its
  // root element, which is the type URL for JSON but the element name for XML. Both match.
  @Test
  void logicalModelInstanceMatchesWhateverItsFormat() throws Exception {
    TestStorage storage = new TestStorage();
    Runner runner = newRunner(new SingleTypeProvider(), storage);
    Runner.WorkContext wc = runner.prepare("VD", JsonParser.parseObject(view(LOGICAL_MODEL_URL, "code")));

    runner.processResource(wc, logicalInstanceFromJson("json"));
    runner.processResource(wc, logicalInstanceFromXml("xml"));
    runner.finish(wc);

    assertEquals(2, storage.getResults().size());
    assertEquals("json", ((JsonObject) storage.getResults().get(0)).asString("c"));
    assertEquals("xml", ((JsonObject) storage.getResults().get(1)).asString("c"));
  }

  // Spec, Process a Resource step 1, for a view over a logical model: a resource of another type
  // produces no rows.
  @Test
  void logicalModelViewIgnoresResourcesOfAnotherType() throws Exception {
    TestStorage storage = new TestStorage();
    Runner runner = newRunner(new SingleTypeProvider(), storage);
    Runner.WorkContext wc = runner.prepare("VD", JsonParser.parseObject(view(LOGICAL_MODEL_URL, "code")));

    runner.processResource(wc, resourceFromJson("{\"resourceType\":\"Patient\",\"id\":\"p1\"}"));
    runner.finish(wc);

    assertEquals(0, storage.getResults().size());
  }

  // The reverse: a view over a resource type named in the usual way matches element-model
  // instances of that type, and ignores instances of a logical model.
  @Test
  void namedViewMatchesElementModelResourcesOnly() throws Exception {
    TestStorage storage = new TestStorage();
    Runner runner = newRunner(new SingleTypeProvider(), storage);
    Runner.WorkContext wc = runner.prepare("VD", JsonParser.parseObject(view("Patient", "id")));

    runner.processResource(wc, logicalInstanceFromJson("a"));
    runner.processResource(wc, resourceFromJson("{\"resourceType\":\"Observation\",\"id\":\"o1\",\"status\":\"final\","
        + "\"code\":{\"text\":\"x\"}}"));
    runner.processResource(wc, resourceFromJson("{\"resourceType\":\"Patient\",\"id\":\"p1\"}"));
    runner.finish(wc);

    assertEquals(1, storage.getResults().size(), "only the Patient may produce a row");
    assertEquals("p1", ((JsonObject) storage.getResults().get(0)).asString("c"));
  }
}
