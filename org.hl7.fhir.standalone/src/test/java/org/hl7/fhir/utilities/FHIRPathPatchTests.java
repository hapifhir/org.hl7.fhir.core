package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.utilities.FHIRPathPatch;
import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.DateType;
import org.hl7.fhir.model.core.HumanName;
import org.hl7.fhir.model.core.Identifier;
import org.hl7.fhir.model.core.IntegerType;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Parameters.ParametersParameterComponent;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * FHIRPath Patch over the element model: the five operations of the specification, values given
 * as typed value[x] and as nested parts, and the errors a malformed patch produces.
 */
class FHIRPathPatchTests {

  private static final String PATIENT = "{\"resourceType\":\"Patient\",\"id\":\"p1\",\"active\":true,"
    + "\"name\":[{\"use\":\"official\",\"family\":\"Smith\",\"given\":[\"John\"]},{\"use\":\"nickname\",\"given\":[\"Johnny\"]}],"
    + "\"telecom\":[{\"system\":\"phone\",\"value\":\"1\"},{\"system\":\"email\",\"value\":\"a@b\"}],"
    + "\"gender\":\"male\",\"birthDate\":\"1970-01-01\"}";

  private static IWorkerContext context() throws Exception {
    return TestingUtilities.getSharedWorkerContext();
  }

  private static Element patient() throws Exception {
    return Manager.parseSingle(context(), new ByteArrayInputStream(PATIENT.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
  }

  private static Element apply(Element resource, Parameters patch) throws Exception {
    return new FHIRPathPatch(context()).apply(resource, patch);
  }

  private static String eval(Element resource, String expression) throws Exception {
    return new FHIRPathEngine(context()).evaluateToString(resource, expression);
  }

  /** Serialise and parse again, so a malformed tree (wrong child order, say) fails here. */
  private static Element roundTrip(Element resource) throws Exception {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    Manager.compose(context(), resource, bs, FhirFormat.JSON, OutputStyle.PRETTY, null);
    return Manager.parseSingle(context(), new ByteArrayInputStream(bs.toByteArray()), FhirFormat.JSON);
  }

  // -- building patches -----------------------------------------------------------------------

  private static ParametersParameterComponent op(Parameters patch, String type, String path) {
    ParametersParameterComponent op = patch.addParameter().setName("operation");
    op.addPart().setName("type").setValue(new CodeType(type));
    op.addPart().setName("path").setValue(new StringType(path));
    return op;
  }

  private static ParametersParameterComponent withValue(ParametersParameterComponent op, DataType value) {
    op.addPart().setName("value").setValue(value);
    return op;
  }

  private static ParametersParameterComponent withParts(ParametersParameterComponent op, String... nameValuePairs) {
    ParametersParameterComponent value = op.addPart().setName("value");
    for (int i = 0; i < nameValuePairs.length; i += 2) {
      value.addPart().setName(nameValuePairs[i]).setValue(new StringType(nameValuePairs[i + 1]));
    }
    return op;
  }

  private static ParametersParameterComponent withInt(ParametersParameterComponent op, String name, int value) {
    op.addPart().setName(name).setValue(new IntegerType(value));
    return op;
  }

  private static Parameters replacing(String path, DataType value) {
    Parameters p = new Parameters();
    withValue(op(p, "replace", path), value);
    return p;
  }

  private static Parameters deleting(String path) {
    Parameters p = new Parameters();
    op(p, "delete", path);
    return p;
  }

  // -- replace --------------------------------------------------------------------------------

  @Test
  @DisplayName("replace: a primitive takes the new value")
  void replacePrimitive() throws Exception {
    Element r = apply(patient(), replacing("Patient.birthDate", new DateType("2000-02-02")));
    assertEquals("2000-02-02", eval(r, "Patient.birthDate"));
  }

  @Test
  @DisplayName("replace: a complex element takes a typed value[x]")
  void replaceComplexWithTypedValue() throws Exception {
    HumanName jones = new HumanName().setFamily("Jones").addGiven("Jim");
    Element r = roundTrip(apply(patient(), replacing("Patient.name[0]", jones)));
    assertEquals("Jones", eval(r, "Patient.name[0].family"));
    assertEquals("Jim", eval(r, "Patient.name[0].given"));
    assertEquals("2", eval(r, "Patient.name.count()"));
  }

  @Test
  @DisplayName("replace: a complex element can be built from nested parts")
  void replaceComplexWithParts() throws Exception {
    Parameters p = new Parameters();
    withParts(op(p, "replace", "Patient.telecom[0]"), "system", "phone", "value", "999");
    Element r = roundTrip(apply(patient(), p));
    assertEquals("999", eval(r, "Patient.telecom[0].value"));
    assertEquals("a@b", eval(r, "Patient.telecom[1].value"));
  }

  @Test
  @DisplayName("replace: a path selecting nothing, or several elements, is an error")
  void replaceNeedsExactlyOne() throws Exception {
    FHIRException none = assertThrows(FHIRException.class, () -> apply(patient(), replacing("Patient.address", new StringType("x"))));
    assertTrue(none.getMessage().contains("selects 0 elements"), none.getMessage());
    FHIRException many = assertThrows(FHIRException.class, () -> apply(patient(), replacing("Patient.name", new StringType("x"))));
    assertTrue(many.getMessage().contains("selects 2 elements"), many.getMessage());
  }

  // -- add ------------------------------------------------------------------------------------

  @Test
  @DisplayName("add: a choice element by its concrete name, e.g. deceasedBoolean")
  void addChoiceElement() throws Exception {
    Parameters p = new Parameters();
    withValue(op(p, "add", "Patient"), new BooleanType(true)).addPart().setName("name").setValue(new StringType("deceasedBoolean"));
    Element r = roundTrip(apply(patient(), p));
    assertEquals("true", eval(r, "Patient.deceased"));
  }

  @Test
  @DisplayName("add: a complex element from a typed value[x]")
  void addComplexTypedValue() throws Exception {
    Parameters p = new Parameters();
    ParametersParameterComponent add = op(p, "add", "Patient");
    add.addPart().setName("name").setValue(new StringType("identifier"));
    withValue(add, new Identifier().setSystem("http://example.org/mrn").setValue("12345"));
    Element r = roundTrip(apply(patient(), p));
    assertEquals("12345", eval(r, "Patient.identifier.value"));
    assertEquals("http://example.org/mrn", eval(r, "Patient.identifier.system"));
  }

  @Test
  @DisplayName("add: a repeating complex element from nested parts goes on the end of the list")
  void addComplexFromParts() throws Exception {
    Parameters p = new Parameters();
    ParametersParameterComponent add = op(p, "add", "Patient");
    add.addPart().setName("name").setValue(new StringType("name"));
    withParts(add, "family", "Doe");
    Element r = roundTrip(apply(patient(), p));
    assertEquals("3", eval(r, "Patient.name.count()"));
    assertEquals("Doe", eval(r, "Patient.name[2].family"));
  }

  @Test
  @DisplayName("add: a singleton that is already present is refused, pointing at replace")
  void addExistingSingletonIsRefused() throws Exception {
    Parameters p = new Parameters();
    withValue(op(p, "add", "Patient"), new CodeType("female")).addPart().setName("name").setValue(new StringType("gender"));
    FHIRException e = assertThrows(FHIRException.class, () -> apply(patient(), p));
    assertTrue(e.getMessage().contains("already present"), e.getMessage());
    assertTrue(e.getMessage().contains("replace"), e.getMessage());
  }

  @Test
  @DisplayName("add: an element name the type does not have is refused")
  void addUnknownElementIsRefused() throws Exception {
    Parameters p = new Parameters();
    withValue(op(p, "add", "Patient"), new StringType("x")).addPart().setName("name").setValue(new StringType("nickname"));
    FHIRException e = assertThrows(FHIRException.class, () -> apply(patient(), p));
    assertTrue(e.getMessage().contains("no element named 'nickname'"), e.getMessage());
  }

  // -- insert ---------------------------------------------------------------------------------

  @Test
  @DisplayName("insert: at index 0 the new entry comes first, and the tree still serialises")
  void insertAtStart() throws Exception {
    Parameters p = new Parameters();
    withParts(withInt(op(p, "insert", "Patient.name"), "index", 0), "family", "First");
    Element r = roundTrip(apply(patient(), p));
    assertEquals("3", eval(r, "Patient.name.count()"));
    assertEquals("First", eval(r, "Patient.name[0].family"));
    assertEquals("Smith", eval(r, "Patient.name[1].family"));
  }

  @Test
  @DisplayName("insert: an index equal to the list size appends")
  void insertAtEnd() throws Exception {
    Parameters p = new Parameters();
    withParts(withInt(op(p, "insert", "Patient.name"), "index", 2), "family", "Last");
    Element r = roundTrip(apply(patient(), p));
    assertEquals("Last", eval(r, "Patient.name[2].family"));
  }

  @Test
  @DisplayName("insert: into a list that is still empty")
  void insertIntoEmptyList() throws Exception {
    Parameters p = new Parameters();
    withParts(withInt(op(p, "insert", "Patient.address"), "index", 0), "city", "Lisbon");
    Element r = roundTrip(apply(patient(), p));
    assertEquals("Lisbon", eval(r, "Patient.address[0].city"));
  }

  @Test
  @DisplayName("insert: an index past the end is an error")
  void insertOutOfRange() throws Exception {
    Parameters p = new Parameters();
    withParts(withInt(op(p, "insert", "Patient.name"), "index", 5), "family", "x");
    FHIRException e = assertThrows(FHIRException.class, () -> apply(patient(), p));
    assertTrue(e.getMessage().contains("out of range"), e.getMessage());
  }

  // -- delete ---------------------------------------------------------------------------------

  @Test
  @DisplayName("delete: a singleton, and one entry of a list")
  void deleteElements() throws Exception {
    Element r = apply(patient(), deleting("Patient.gender"));
    assertEquals("false", eval(r, "Patient.gender.exists()"));

    r = roundTrip(apply(patient(), deleting("Patient.name[1]")));
    assertEquals("1", eval(r, "Patient.name.count()"));
    assertEquals("Smith", eval(r, "Patient.name[0].family"));
  }

  @Test
  @DisplayName("delete: selecting nothing is a no-op; selecting several is an error")
  void deleteCardinality() throws Exception {
    Element r = apply(patient(), deleting("Patient.address"));
    assertEquals("2", eval(r, "Patient.name.count()"));
    FHIRException e = assertThrows(FHIRException.class, () -> apply(patient(), deleting("Patient.name")));
    assertTrue(e.getMessage().contains("selects 2 elements"), e.getMessage());
  }

  // -- move -----------------------------------------------------------------------------------

  @Test
  @DisplayName("move: reorders entries of a list")
  void moveWithinList() throws Exception {
    Parameters p = new Parameters();
    withInt(withInt(op(p, "move", "Patient.name"), "source", 1), "destination", 0);
    Element r = roundTrip(apply(patient(), p));
    assertEquals("nickname", eval(r, "Patient.name[0].use"));
    assertEquals("official", eval(r, "Patient.name[1].use"));
    assertEquals("2", eval(r, "Patient.name.count()"));
  }

  // -- the patch document ---------------------------------------------------------------------

  @Test
  @DisplayName("operations apply in order")
  void operationsApplyInOrder() throws Exception {
    Parameters p = new Parameters();
    withValue(op(p, "replace", "Patient.gender"), new CodeType("female"));
    op(p, "delete", "Patient.birthDate");
    Element r = apply(patient(), p);
    assertEquals("female", eval(r, "Patient.gender"));
    assertEquals("false", eval(r, "Patient.birthDate.exists()"));
  }

  @Test
  @DisplayName("a malformed patch is refused with a reason")
  void malformedPatchIsRefused() throws Exception {
    Parameters unknownType = new Parameters();
    op(unknownType, "upsert", "Patient.gender");
    assertTrue(assertThrows(FHIRException.class, () -> apply(patient(), unknownType)).getMessage().contains("unknown operation type"));

    Parameters notAnOperation = new Parameters();
    notAnOperation.addParameter().setName("something");
    assertTrue(assertThrows(FHIRException.class, () -> apply(patient(), notAnOperation)).getMessage().contains("'operation'"));

    Parameters noPath = new Parameters();
    noPath.addParameter().setName("operation").addPart().setName("type").setValue(new CodeType("delete"));
    assertTrue(assertThrows(FHIRException.class, () -> apply(patient(), noPath)).getMessage().contains("'path'"));

    Parameters noValue = new Parameters();
    op(noValue, "replace", "Patient.gender");
    assertTrue(assertThrows(FHIRException.class, () -> apply(patient(), noValue)).getMessage().contains("'value'"));
  }
}
