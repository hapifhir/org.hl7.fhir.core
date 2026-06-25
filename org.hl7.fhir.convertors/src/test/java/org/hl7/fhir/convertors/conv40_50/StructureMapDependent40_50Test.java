package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.conv40_50.resources40_50.StructureMap40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pins the conversion of {@code StructureMap.group.rule.dependent.variable} (R4) ↔
 * {@code StructureMap.group.rule.dependent.parameter} (R5). The renames are easy to
 * get wrong because R4 uses a flat list of strings ({@code variable: [String]}) while
 * R5 uses a list of typed parameters ({@code parameter: [{ value[x] }]}); a missing
 * translation here surfaces at transform time as the misleading
 * "Rule 'X' has N but the invocation has 0 variables" error from the R4 executor.
 */
class StructureMapDependent40_50Test {

  @Test
  @DisplayName("R5→R4: dependent.parameter[valueId] survives as dependent.variable")
  void r5ToR4PreservesVariableNames() {
    org.hl7.fhir.r5.model.StructureMap r5 = buildR5StructureMapWithDependent();
    org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(r5);
    assertNotNull(r4);
    assertTrue(r4 instanceof org.hl7.fhir.r4.model.StructureMap);
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent r4Dep =
        ((org.hl7.fhir.r4.model.StructureMap) r4)
            .getGroup().get(0).getRule().get(0).getDependent().get(0);
    assertEquals("copyName", r4Dep.getName());
    assertEquals(2, r4Dep.getVariable().size(),
      "dependent.parameter[].valueId must become R4 dependent.variable[]");
    assertEquals("src", r4Dep.getVariable().get(0).getValue());
    assertEquals("tgt", r4Dep.getVariable().get(1).getValue());
  }

  @Test
  @DisplayName("R4→R5: dependent.variable survives as dependent.parameter[valueId]")
  void r4ToR5PreservesVariableNames() {
    // Build an R4 SM with a 2-variable dependent.
    org.hl7.fhir.r4.model.StructureMap r4 = new org.hl7.fhir.r4.model.StructureMap();
    r4.setUrl("http://example.org/StructureMap/DepTest");
    r4.setName("DepTest");
    r4.setStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent g = r4.addGroup();
    g.setName("main");
    g.addInput().setName("src").setMode(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.SOURCE);
    g.addInput().setName("tgt").setMode(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.TARGET);
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent rule = g.addRule();
    rule.setName("r1");
    rule.addSource().setContext("src");
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent dep = rule.addDependent();
    dep.setName("copyName");
    dep.addVariable("src");
    dep.addVariable("tgt");

    org.hl7.fhir.r5.model.Resource r5 = VersionConvertorFactory_40_50.convertResource(r4);
    assertNotNull(r5);
    assertTrue(r5 instanceof org.hl7.fhir.r5.model.StructureMap);
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent r5Dep =
        ((org.hl7.fhir.r5.model.StructureMap) r5)
            .getGroup().get(0).getRule().get(0).getDependent().get(0);
    assertEquals("copyName", r5Dep.getName());
    assertEquals(2, r5Dep.getParameter().size(),
      "R4 dependent.variable[] must become R5 dependent.parameter[].valueId");
    assertTrue(r5Dep.getParameter().get(0).getValue() instanceof org.hl7.fhir.r5.model.IdType,
      "R4 variable strings come over as IdType in R5");
    assertEquals("src", ((org.hl7.fhir.r5.model.IdType) r5Dep.getParameter().get(0).getValue()).getValue());
    assertEquals("tgt", ((org.hl7.fhir.r5.model.IdType) r5Dep.getParameter().get(1).getValue()).getValue());
  }

  @Test
  @DisplayName("R5→R4→R5 round-trip preserves dependent.parameter values")
  void r5ToR4ToR5RoundTripPreservesVariables() {
    org.hl7.fhir.r5.model.StructureMap original = buildR5StructureMapWithDependent();

    org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_40_50.convertResource(original);
    assertTrue(r4 instanceof org.hl7.fhir.r4.model.StructureMap, "round-trip starts with an R4 StructureMap");
    org.hl7.fhir.r4.model.StructureMap r4Map = (org.hl7.fhir.r4.model.StructureMap) r4;

    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent r4Dep =
        r4Map.getGroup().get(0).getRule().get(0).getDependent().get(0);
    assertEquals(2, r4Dep.getVariable().size(),
      "After R5→R4 the dependent must have its 2 variables, not 0");
    assertEquals("src", r4Dep.getVariable().get(0).getValue());
    assertEquals("tgt", r4Dep.getVariable().get(1).getValue());

    org.hl7.fhir.r5.model.Resource r5Again = VersionConvertorFactory_40_50.convertResource(r4Map);
    assertTrue(r5Again instanceof org.hl7.fhir.r5.model.StructureMap);
    org.hl7.fhir.r5.model.StructureMap r5MapAgain = (org.hl7.fhir.r5.model.StructureMap) r5Again;
    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent r5DepAgain =
        r5MapAgain.getGroup().get(0).getRule().get(0).getDependent().get(0);
    assertEquals(2, r5DepAgain.getParameter().size(),
      "Round-trip R5→R4→R5 must preserve the parameter list");
  }

  /** Build a minimal R5 StructureMap whose single rule invokes a 2-arg dependent. */
  private static org.hl7.fhir.r5.model.StructureMap buildR5StructureMapWithDependent() {
    org.hl7.fhir.r5.model.StructureMap sm = new org.hl7.fhir.r5.model.StructureMap();
    sm.setUrl("http://example.org/StructureMap/DepTest");
    sm.setName("DepTest");
    sm.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);

    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent g = sm.addGroup();
    g.setName("main");
    g.addInput().setName("src").setMode(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.SOURCE);
    g.addInput().setName("tgt").setMode(org.hl7.fhir.r5.model.StructureMap.StructureMapInputMode.TARGET);

    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent rule = g.addRule();
    rule.setName("r1");
    rule.addSource().setContext("src");

    org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent dep = rule.addDependent();
    dep.setName("copyName");
    dep.addParameter().setValue(new org.hl7.fhir.r5.model.IdType("src"));
    dep.addParameter().setValue(new org.hl7.fhir.r5.model.IdType("tgt"));

    return sm;
  }
}
