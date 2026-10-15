package org.hl7.fhir.test;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.utilities.CodeSystemUtilities;
import org.hl7.fhir.model.utilities.CodeSystemUtilities.CodeSystemNavigator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CodeSystemNavigator and mergeSupplements look concepts up through indexes rather than by searching the code
 * system each time; these check the lookups find the same concepts, in the same order
 */
class CodeSystemUtilitiesIndexTests {

  private static ConceptDefinitionComponent concept(CodeSystem cs, String code, String... subsumedBy) {
    ConceptDefinitionComponent cd = cs.addConcept().setCode(code);
    for (String s : subsumedBy) {
      cd.addProperty().setCode("subsumedBy").setValue(new CodeType(s));
    }
    return cd;
  }

  private static String codes(List<ConceptDefinitionComponent> list) {
    return list.stream().map(ConceptDefinitionComponent::getCode).collect(Collectors.joining(","));
  }

  @Test
  void navigatorFollowsSubsumedBy() {
    CodeSystem cs = new CodeSystem();
    ConceptDefinitionComponent a = concept(cs, "a");
    a.addConcept().setCode("a1");
    concept(cs, "b", "a");
    concept(cs, "c", "a", "a");
    ConceptDefinitionComponent d = concept(cs, "d", "a", "b");
    concept(cs, "e", "b");
    concept(cs, "f");

    CodeSystemNavigator nav = new CodeSystemNavigator(cs);
    Assertions.assertTrue(nav.isRestructure());
    Assertions.assertEquals("a,f", codes(nav.getConcepts(null)));
    Assertions.assertEquals("a1,b,c,d", codes(nav.getConcepts(a)));
    ConceptDefinitionComponent b = cs.getConceptList().get(1);
    Assertions.assertEquals("e", codes(nav.getConcepts(b)));
    // the concepts subsumedBy b that have already been listed
    Assertions.assertEquals("d,e", codes(nav.getOtherChildren(b)));
    Assertions.assertEquals("", codes(nav.getConcepts(d)));
  }

  @Test
  void mergeSupplementsUsesTheFirstConceptWithTheCode() {
    CodeSystem cs = new CodeSystem().setUrl("http://example.org/cs");
    ConceptDefinitionComponent a = cs.addConcept().setCode("a");
    a.addConcept().setCode("b");
    cs.addConcept().setCode("c");

    CodeSystem sup = new CodeSystem().setUrl("http://example.org/sup").setSupplements("http://example.org/cs");
    // the first "b" in the order findCode() searches is the one nested under "z"
    sup.addConcept().setCode("z").addConcept().setCode("b").addDesignation().setValue("first");
    sup.addConcept().setCode("b").addDesignation().setValue("second");
    sup.addConcept().setCode("a").addDesignation().setValue("for a");

    CodeSystem merged = CodeSystemUtilities.mergeSupplements(cs, List.of(sup));
    ConceptDefinitionComponent ma = merged.getConceptList().get(0);
    Assertions.assertEquals(1, ma.getDesignationList().size());
    Assertions.assertEquals("for a", ma.getDesignationList().get(0).getValue());
    ConceptDefinitionComponent mb = ma.getConceptList().get(0);
    Assertions.assertEquals(1, mb.getDesignationList().size());
    Assertions.assertEquals("first", mb.getDesignationList().get(0).getValue());
    Assertions.assertEquals(0, merged.getConceptList().get(1).getDesignationList().size());
  }
}
