package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.ContactPoint;
import org.hl7.fhir.model.core.Identifier;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.fml.StructureMap;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * R6 StructureMap transforms (StructureMapTools): the id, cp and qty transforms, map constants,
 * and working out the source and target types of a map.
 */
class StructureMapTransformTests {

  private static final String PATIENT_MAP = """
    map "http://example.org/StructureMap/Transforms" = "Transforms"

    uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
    uses "http://hl7.org/fhir/StructureDefinition/Patient" as target

    %s

    group Transforms(source src : Patient, target tgt : Patient) {
      %s
    }
    """;

  private static SimpleWorkerContext context;

  @BeforeAll
  static void setUp() throws Exception {
    var pcm = new FilesystemPackageCacheManager.Builder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r6.core", "6.0.0-snapshot1"));
  }

  private static Patient transform(String constants, String rules) {
    StructureMapTools utils = new StructureMapTools(context);
    StructureMap map = utils.parse(PATIENT_MAP.formatted(constants, rules), "test");
    Patient target = new Patient();
    utils.transform(null, new Patient(), map, target);
    return target;
  }

  private static FHIRException transformFails(String constants, String rules) {
    StructureMapTools utils = new StructureMapTools(context);
    StructureMap map = utils.parse(PATIENT_MAP.formatted(constants, rules), "test");
    return assertThrows(FHIRException.class, () -> utils.transform(null, new Patient(), map, new Patient()));
  }

  // --- id(), cp(), qty() ------------------------------------------------------------------------

  @Test
  void testIdWithType() {
    Patient patient = transform("", "src -> tgt.identifier = id('http://example.org/mrn', '12345', 'MR') \"id\";");
    Identifier id = patient.getIdentifierFirstRep();
    assertEquals("http://example.org/mrn", id.getSystem());
    assertEquals("12345", id.getValue());
    assertEquals("http://terminology.hl7.org/CodeSystem/v2-0203", id.getType().getCodingFirstRep().getSystem());
    assertEquals("MR", id.getType().getCodingFirstRep().getCode());
  }

  static Stream<Arguments> contactPoints() {
    return Stream.of(
      Arguments.of("cp('someone@example.org')", ContactPoint.ContactPointSystem.EMAIL, "someone@example.org"),
      Arguments.of("cp('https://example.org/contact')", ContactPoint.ContactPointSystem.URL, "https://example.org/contact"),
      Arguments.of("cp('555 1234')", null, "555 1234"),
      Arguments.of("cp('phone', '555 1234')", ContactPoint.ContactPointSystem.PHONE, "555 1234"));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("contactPoints")
  void testContactPoint(String transform, ContactPoint.ContactPointSystem system, String value) {
    Patient patient = transform("", "src -> tgt.telecom = " + transform + " \"cp\";");
    ContactPoint cp = patient.getTelecomFirstRep();
    assertEquals(system, cp.getSystem());
    assertEquals(value, cp.getValue());
  }

  static Stream<Arguments> badTransforms() {
    return Stream.of(
      Arguments.of("tgt.identifier = id('http://example.org/mrn')", "Transform id requires 2 or 3 parameters"),
      Arguments.of("tgt.telecom = cp('phone', '555', 'extra')", "Transform cp requires 1 or 2 parameters"),
      Arguments.of("tgt.telecom = cp('not-a-system', '555')", "not-a-system"),
      Arguments.of("tgt.extension as e, e.url = 'http://example.org/q', e.value = qty('forty-two', 'kg')", "is not a decimal number"));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("badTransforms")
  void testBadTransformParametersGiveAClearError(String target, String expectedMessage) {
    FHIRException e = transformFails("", "src -> " + target + " \"bad\";");
    assertTrue(e.getMessage().contains(expectedMessage), e.getMessage());
  }

  // --- constants --------------------------------------------------------------------------------

  @Test
  void testConstantInDependentGroup() {
    String fml = """
      map "http://example.org/StructureMap/DependentConstant" = "DependentConstant"

      uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as target

      let fam = 'Smith';

      group Main(source src : Patient, target tgt : Patient) {
        src -> tgt.name as n then Name(src, n) "name";
      }

      group Name(source src : Patient, target n : HumanName) {
        src -> n.family = fam "family";
      }
      """;
    StructureMapTools utils = new StructureMapTools(context);
    StructureMap map = utils.parse(fml, "dependent-constant");
    Patient target = new Patient();
    utils.transform(null, new Patient(), map, target);
    assertEquals("Smith", target.getNameFirstRep().getFamily());
  }

  @Test
  void testConstantIsNotATargetVariable() {
    FHIRException e = transformFails("let fam = 'Smith';", "src -> fam.value = 'Jones' \"write\";");
    assertTrue(e.getMessage().contains("fam"), e.getMessage());
  }

  @Test
  void testConstantChainTooDeep() {
    StringBuilder constants = new StringBuilder("let c0 = 1;\n");
    for (int i = 1; i <= 150; i++) {
      constants.append("let c").append(i).append(" = %c").append(i - 1).append(" + 1;\n");
    }
    FHIRException e = transformFails(constants.toString(), "src -> tgt.name as n, n.family = truncate('family', c150) \"deep\";");
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  @Test
  void testAnalyseConstantAsSource() {
    StructureMapTools utils = new StructureMapTools(context);
    StructureMap map = utils.parse(PATIENT_MAP.formatted("let c = 'x';", "c.length as l -> tgt.id = l \"r1\";"), "analyse-constant");
    FHIRException e = assertThrows(FHIRException.class, () -> utils.analyse(null, map));
    assertTrue(e.getMessage().contains("no known structure"), e.getMessage());
  }

  // --- source and target types ------------------------------------------------------------------

  private static StructureMap parse(String fml) {
    return new StructureMapTools(context).parse(fml, "types");
  }

  @Test
  void testTargetTypeWhenTargetInputHasNoType() {
    StructureMap map = parse("""
      map "http://example.org/StructureMap/Untyped" = "Untyped"
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
      uses "http://hl7.org/fhir/StructureDefinition/Observation" as target
      group Untyped(source src : Patient, target tgt) {
        src -> tgt.status = 'final' "status";
      }
      """);
    assertEquals("http://hl7.org/fhir/StructureDefinition/Observation", new StructureMapTools(context).getTargetType(map).getUrl());
  }

  @Test
  void testTargetTypeAliasIsCaseSensitive() {
    StructureMap map = parse("""
      map "http://example.org/StructureMap/Aliases" = "Aliases"
      uses "http://hl7.org/fhir/StructureDefinition/Patient" alias pat as source
      uses "http://hl7.org/fhir/StructureDefinition/Observation" alias Obs as target
      uses "http://hl7.org/fhir/StructureDefinition/Patient" alias obs as target
      group Aliases(source src : pat, target tgt : obs) {
        src -> tgt.active = true "active";
      }
      """);
    StructureMapTools utils = new StructureMapTools(context);
    assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", utils.getTargetType(map).getUrl());
    assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", utils.getSourceType(map).getUrl());
  }

  @Test
  void testTargetTypeByCoreTypeName() {
    StructureMap map = parse("""
      map "http://example.org/StructureMap/CoreName" = "CoreName"
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as target
      uses "http://hl7.org/fhir/StructureDefinition/Observation" as target
      group CoreName(source src : Patient, target tgt : Observation) {
        src -> tgt.status = 'final' "status";
      }
      """);
    assertEquals("http://hl7.org/fhir/StructureDefinition/Observation", new StructureMapTools(context).getTargetType(map).getUrl());
  }

  @Test
  void testTargetTypeAmbiguousWithoutType() {
    StructureMap map = parse("""
      map "http://example.org/StructureMap/Ambiguous" = "Ambiguous"
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
      uses "http://hl7.org/fhir/StructureDefinition/Patient" as target
      uses "http://hl7.org/fhir/StructureDefinition/Observation" as target
      group Ambiguous(source src : Patient, target tgt) {
        src -> tgt "copy";
      }
      """);
    FHIRException e = assertThrows(FHIRException.class, () -> new StructureMapTools(context).getTargetType(map));
    assertTrue(e.getMessage().contains("Multiple target types"), e.getMessage());
  }
}
