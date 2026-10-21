package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.Test;

/**
 * The features a server declares in its CapabilityStatement, which decide which suites and tests
 * with a "feature" run
 */
class TxTesterFeaturesTests {

  private Extension feature(String definition, org.hl7.fhir.model.core.DataType value) {
    Extension ext = new Extension(TxTester.FEATURE_EXTENSION);
    ext.addExtension("definition", new CanonicalType(definition));
    ext.addExtension("value", value);
    return ext;
  }

  @Test
  void operationsDeclaredAnywhereByNameOrDefinition() {
    CapabilityStatement cs = new CapabilityStatement();
    CapabilityStatementRestComponent rest = cs.addRest();
    // system level, by name
    rest.addOperation().setName("expand").setDefinition("http://hl7.org/fhir/OperationDefinition/ValueSet-expand");
    // on a resource, by name
    CapabilityStatementRestResourceComponent cmr = rest.addResource().setType("ConceptMap");
    cmr.addOperation().setName("translate").setDefinition("http://hl7.org/fhir/OperationDefinition/ConceptMap-translate");
    // a name that isn't the standard one, but the standard definition
    CapabilityStatementRestResourceComponent csr = rest.addResource().setType("CodeSystem");
    csr.addOperation().setName("cs-validate").setDefinition("http://hl7.org/fhir/OperationDefinition/CodeSystem-validate-code|5.0.0");
    csr.addOperation().setName("lookup").setDefinition("http://hl7.org/fhir/OperationDefinition/CodeSystem-lookup");
    assertEquals(new TreeSet<>(Set.of("expand", "translate", "validate", "lookup")), TxTester.featuresFor(cs));
  }

  @Test
  void closureAndSubsumesAndRelated() {
    CapabilityStatement cs = new CapabilityStatement();
    CapabilityStatementRestComponent rest = cs.addRest();
    rest.addOperation().setName("closure").setDefinition("http://hl7.org/fhir/OperationDefinition/ConceptMap-closure");
    rest.addOperation().setName("subsumes").setDefinition("http://hl7.org/fhir/OperationDefinition/CodeSystem-subsumes");
    rest.addOperation().setName("related").setDefinition("http://hl7.org/fhir/OperationDefinition/ValueSet-related");
    // not a feature
    rest.addOperation().setName("compare").setDefinition("http://hl7.org/fhir/tools/OperationDefinition/ValueSet-compare");
    assertEquals(new TreeSet<>(Set.of("closure", "subsumes", "related")), TxTester.featuresFor(cs));
  }

  @Test
  void txResourceFromTheCodeSystemAsParameterFeature() {
    CapabilityStatement cs = new CapabilityStatement();
    cs.addExtension(feature("http://hl7.org/fhir/uv/tx-tests/FeatureDefinition/test-version", new CodeType("1.9.6")));
    cs.addExtension(feature(TxTester.CODESYSTEM_AS_PARAMETER, new BooleanType(true)));
    assertEquals(Set.of("tx-resource"), TxTester.featuresFor(cs));

    CapabilityStatement no = new CapabilityStatement();
    no.addExtension(feature(TxTester.CODESYSTEM_AS_PARAMETER, new BooleanType(false)));
    assertEquals(Set.of(), TxTester.featuresFor(no));
  }

  @Test
  void nothingDeclaredNoFeatures() {
    assertEquals(Set.of(), TxTester.featuresFor(new CapabilityStatement()));
    assertEquals(Set.of(), TxTester.featuresFor(null));
  }

  @Test
  void testNeededFeatures() {
    assertEquals(List.of(), TxTester.neededFeatures(null));
    assertEquals(List.of(), TxTester.neededFeatures(new JsonObject()));
    assertEquals(List.of(), TxTester.neededFeatures(new JsonObject().add("feature", "")));
    assertEquals(List.of("closure"), TxTester.neededFeatures(new JsonObject().add("feature", "closure")));
    assertEquals(List.of("expand", "tx-resource"), TxTester.neededFeatures(new JsonObject().add("feature", " expand , tx-resource ")));
    assertEquals(List.of("expand", "validate"), TxTester.neededFeatures(new JsonObject().add("feature", ",expand,,validate,")));
  }
}
