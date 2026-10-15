package org.hl7.fhir.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Factory.create must be able to create every concrete data type in the core package
 */
class FactoryTests {

  static Stream<String> dataTypes() {
    List<String> types = new ArrayList<>();
    for (StructureDefinition sd : TestingUtilities.getSharedWorkerContext().fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/") && !sd.getAbstract()
          && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE)
          && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        types.add(sd.getType());
      }
    }
    return types.stream().sorted();
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("dataTypes")
  void testCreate(String type) {
    DataType dt = new Factory().create(type);
    Assertions.assertNotNull(dt);
    Assertions.assertEquals(type, dt.fhirType());
  }
}
