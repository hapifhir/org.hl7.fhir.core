package org.hl7.fhir.r5.utils.structuremap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapConstComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.fhirpath.FHIRPathConstantEvaluationMode;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConstantResolverTests {

  private static SimpleWorkerContext context;

  @BeforeAll
  static void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  private static StructureMap mapWithConsts(String... pairs) {
    StructureMap map = new StructureMap();
    for (int i = 0; i + 1 < pairs.length; i += 2) {
      StructureMapConstComponent c = map.addConst();
      c.setName(pairs[i]);
      c.setValue(pairs[i + 1]);
    }
    return map;
  }

  @Test
  void resolvesLiteralConstant() {
    StructureMap map = mapWithConsts("greeting", "'hello'");
    StructureMapConstantResolver resolver = new StructureMapConstantResolver(map, new FHIRPathEngine(context));

    List<Base> result = resolver.resolve("greeting");
    assertEquals(1, result.size());
    assertEquals("hello", result.get(0).primitiveValue());
  }

  @Test
  void resolvesConstantReferencingAnotherConstant() {
    StructureMap map = mapWithConsts(
      "base", "'hello'",
      "decorated", "%base + ' world'");
    // to test the resolving with a fhirpath engine, the services needs to be setup to link back to the vars.
    // The ConstantResolve is not used by the FHIRPathEngine, it's a part of the StructureMap engine.
    var fpe = new FHIRPathEngine(context);
    fpe.setHostServices(new FHIRPathHostServices(new StructureMapUtilities(context)));
    StructureMapConstantResolver resolver = new StructureMapConstantResolver(map, fpe);

    List<Base> result = resolver.resolve("decorated");
    assertEquals(1, result.size());
    assertEquals("hello world", result.get(0).primitiveValue());
  }

  @Test
  void cachesEvaluatedConstant() {
    StructureMap map = mapWithConsts("answer", "1 + 2 + 3");
    StructureMapConstantResolver resolver = new StructureMapConstantResolver(map, new FHIRPathEngine(context));

    List<Base> first = resolver.resolve("answer");
    List<Base> second = resolver.resolve("answer");
    // Lazy-evaluated; once cached, subsequent calls return the very same list instance.
    assertSameList(first, second);
    assertEquals("6", first.get(0).primitiveValue());
  }

  @Test
  void detectsCircularReference() {
    StructureMap map = mapWithConsts(
      "a", "%b",
      "b", "%a");
    var fpe = new FHIRPathEngine(context);
    fpe.setHostServices(new FHIRPathHostServices(new StructureMapUtilities(context)));
    StructureMapConstantResolver resolver = new StructureMapConstantResolver(map, fpe);

    FHIRException ex = assertThrows(FHIRException.class, () -> resolver.resolve("a"));
    assertTrue(ex.getMessage().contains("Circular reference"), ex.getMessage());
  }

  @Test
  void unknownConstantReportsAsAbsent() {
    StructureMap map = mapWithConsts("a", "'x'");
    StructureMapConstantResolver resolver = new StructureMapConstantResolver(map, new FHIRPathEngine(context));

    assertTrue(resolver.has("a"));
    assertFalse(resolver.has("missing"));
    assertTrue(resolver.resolve("missing").isEmpty());
  }

  @Test
  void hostServicesResolvesConstantViaResolver() throws FHIRException {
    StructureMap map = mapWithConsts("hello", "'world'");
    StructureMapUtilities scu = new StructureMapUtilities(context);

    Variables vars = new Variables();
    vars.setConstants(new StructureMapConstantResolver(map, new FHIRPathEngine(context)));

    FHIRPathHostServices host = new FHIRPathHostServices(scu);
    List<Base> resolved = host.resolveConstant(null, vars, "hello", FHIRPathConstantEvaluationMode.NOVALUE);
    assertNotNull(resolved);
    assertEquals(1, resolved.size());
    assertEquals("world", resolved.get(0).primitiveValue());
  }

  @Test
  void localVariableShadowsConstant() throws FHIRException {
    StructureMap map = mapWithConsts("name", "'from-const'");
    StructureMapUtilities scu = new StructureMapUtilities(context);

    Variables vars = new Variables();
    vars.setConstants(new StructureMapConstantResolver(map, new FHIRPathEngine(context)));
    vars.add(VariableMode.INPUT, "name", new StringType("from-local"));

    FHIRPathHostServices host = new FHIRPathHostServices(scu);
    List<Base> resolved = host.resolveConstant(null, vars, "name", FHIRPathConstantEvaluationMode.NOVALUE);
    assertEquals(1, resolved.size());
    assertEquals("from-local", resolved.get(0).primitiveValue());
  }

  @Test
  void outputVariableShadowsConstant() throws FHIRException {
    StructureMap map = mapWithConsts("name", "'from-const'");
    StructureMapUtilities scu = new StructureMapUtilities(context);

    Variables vars = new Variables();
    vars.setConstants(new StructureMapConstantResolver(map, new FHIRPathEngine(context)));
    vars.add(VariableMode.OUTPUT, "name", new StringType("from-output"));

    FHIRPathHostServices host = new FHIRPathHostServices(scu);
    List<Base> resolved = host.resolveConstant(null, vars, "name", FHIRPathConstantEvaluationMode.NOVALUE);
    assertEquals(1, resolved.size());
    assertEquals("from-output", resolved.get(0).primitiveValue());
  }

  @Test
  void directVariableLookupStillFallsBackToConstant() {
    StructureMap map = mapWithConsts("name", "'from-const'");
    Variables vars = new Variables();
    vars.setConstants(new StructureMapConstantResolver(map, new FHIRPathEngine(context)));

    assertEquals("from-const", vars.get(VariableMode.INPUT, "name").primitiveValue());
  }

  private static void assertSameList(List<Base> a, List<Base> b) {
    assertTrue(a == b, "expected cached list identity");
  }
}
