package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeSystem.PropertyType;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.utilities.CodeSystemHierarchy;
import org.hl7.fhir.model.utilities.CodeSystemUtilities.CodeSystemNavigator;
import org.junit.jupiter.api.Test;

/**
 * How CodeSystemHierarchy works out a code system's hierarchy from nesting and the parent and child
 * properties, and how it is cached
 */
class CodeSystemHierarchyTests {

  private static ConceptDefinitionComponent concept(CodeSystem cs, String code, String property, String... values) {
    ConceptDefinitionComponent cd = cs.addConcept().setCode(code);
    for (String v : values) {
      cd.addProperty().setCode(property).setValue(new CodeType(v));
    }
    return cd;
  }

  private static String codes(List<ConceptDefinitionComponent> list) {
    return list.stream().map(ConceptDefinitionComponent::getCode).collect(Collectors.joining(","));
  }

  @Test
  void parentPropertyIsFoundByUri() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("broader").setUri(CodeSystemHierarchy.PARENT_PROPERTY_URI).setType(PropertyType.CODE);
    concept(cs, "a", null);
    concept(cs, "b", "broader", "a");
    // once a property has the parent uri, subsumedBy is just another property
    concept(cs, "c", "subsumedBy", "a");

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertTrue(h.isRestructure());
    assertEquals("a,c", codes(h.getRoots()));
    assertEquals("b", codes(h.getStatedChildren("a")));
    assertTrue(h.hasAncestor("b", "a"));
    assertFalse(h.hasAncestor("c", "a"));
  }

  @Test
  void subsumedByDeclaredWithTheParentUri() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("subsumedBy").setUri(CodeSystemHierarchy.PARENT_PROPERTY_URI).setType(PropertyType.CODE);
    concept(cs, "a", null);
    concept(cs, "b", "subsumedBy", "a");
    // parent is not the parent property here: subsumedBy is
    concept(cs, "c", "parent", "a");

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertEquals("a,c", codes(h.getRoots()));
    assertEquals("b", codes(h.getStatedChildren("a")));
  }

  @Test
  void parentAndSubsumedByAreTheFallbackWithNoUri() {
    // older THO releases use subsumedBy without declaring it
    CodeSystem cs = new CodeSystem();
    concept(cs, "a", null);
    concept(cs, "b", "subsumedBy", "a");
    concept(cs, "c", "parent", "a");

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertEquals("a", codes(h.getRoots()));
    assertEquals("b,c", codes(h.getStatedChildren("a")));
  }

  @Test
  void childStatementsAreTheSameRelationshipAsParentStatements() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("parent").setUri(CodeSystemHierarchy.PARENT_PROPERTY_URI).setType(PropertyType.CODE);
    cs.addProperty().setCode("child").setUri(CodeSystemHierarchy.CHILD_PROPERTY_URI).setType(PropertyType.CODE);
    // a says b and c are its children; b also says a is its parent (the same relationship, stated twice)
    concept(cs, "a", "child", "b", "c");
    concept(cs, "b", "parent", "a");
    concept(cs, "c", null);
    concept(cs, "d", null);

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertEquals("a,d", codes(h.getRoots()));
    // b is listed once, not once for each statement
    assertEquals("b,c", codes(h.getStatedChildren("a")));
    assertTrue(h.hasAncestor("c", "a"));
    assertEquals(1, h.getParents("b").size());

    CodeSystemNavigator nav = new CodeSystemNavigator(cs, h);
    assertEquals("a,d", codes(nav.getConcepts(null)));
    assertEquals("b,c", codes(nav.getConcepts(cs.getConceptList().get(0))));
  }

  @Test
  void aConceptWithMoreThanOneParent() {
    CodeSystem cs = new CodeSystem();
    ConceptDefinitionComponent a = concept(cs, "a", null);
    ConceptDefinitionComponent b = concept(cs, "b", null);
    concept(cs, "ab", "subsumedBy", "a", "b");

    CodeSystemNavigator nav = new CodeSystemNavigator(cs);
    assertEquals("a,b", codes(nav.getConcepts(null)));
    assertEquals("", codes(nav.getOtherChildren(a)));
    assertEquals("ab", codes(nav.getConcepts(a)));
    // already shown under a
    assertEquals("ab", codes(nav.getOtherChildren(b)));
    assertEquals("", codes(nav.getConcepts(b)));
  }

  @Test
  void aParentThatIsNotInTheCodeSystemLeavesTheConceptAtTheTop() {
    CodeSystem cs = new CodeSystem();
    concept(cs, "a", null);
    concept(cs, "b", "subsumedBy", "missing");
    concept(cs, "c", "subsumedBy", "c"); // nor is a concept its own parent

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertFalse(h.isRestructure());
    assertEquals("a,b,c", codes(h.getRoots()));
    assertTrue(h.getParents("c").isEmpty());
  }

  @Test
  void nestingCountsForSubsumption() {
    CodeSystem cs = new CodeSystem();
    ConceptDefinitionComponent a = concept(cs, "a", null);
    a.addConcept().setCode("a1").addConcept().setCode("a11");
    concept(cs, "x", "subsumedBy", "a11");

    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertTrue(h.hasAncestor("x", "a"));
    assertFalse(h.hasAncestor("a", "x"));
    // nested concepts stay where they are: only top level concepts are moved
    assertEquals("a", codes(h.getRoots()));
    assertEquals("x", codes(h.getStatedChildren("a11")));
  }

  @Test
  void cycles() {
    CodeSystem cs = new CodeSystem();
    concept(cs, "a", "subsumedBy", "b");
    concept(cs, "b", "subsumedBy", "a");
    CodeSystemHierarchy h = new CodeSystemHierarchy(cs);
    assertTrue(h.hasAncestor("a", "b"));
    assertFalse(h.hasAncestor("a", "z"));
  }

  @Test
  void caching() {
    CodeSystem cs = new CodeSystem();
    concept(cs, "a", null);
    concept(cs, "b", "subsumedBy", "a");

    assertNotSame(CodeSystemHierarchy.forCodeSystem(cs, false), CodeSystemHierarchy.forCodeSystem(cs, false));
    CodeSystemHierarchy h = CodeSystemHierarchy.forCodeSystem(cs, true);
    assertSame(h, CodeSystemHierarchy.forCodeSystem(cs, true));
    assertSame(cs, h.getCodeSystem());

    // a copy can carry the original's user data, but not its analysis
    CodeSystem copy = cs.copy(Base.COPY_DATA);
    CodeSystemHierarchy hc = CodeSystemHierarchy.forCodeSystem(copy, true);
    assertNotSame(h, hc);
    assertSame(copy, hc.getCodeSystem());

    assertThrows(IllegalArgumentException.class, () -> new CodeSystemNavigator(copy, h));
  }

  @Test
  void eachRenderingGetsItsOwnNavigator() {
    CodeSystem cs = new CodeSystem();
    ConceptDefinitionComponent a = concept(cs, "a", null);
    concept(cs, "b", "subsumedBy", "a");
    CodeSystemHierarchy h = CodeSystemHierarchy.forCodeSystem(cs, true);
    for (int i = 0; i < 2; i++) {
      CodeSystemNavigator nav = new CodeSystemNavigator(cs, h);
      assertEquals("a", codes(nav.getConcepts(null)));
      assertEquals("", codes(nav.getOtherChildren(a)));
      assertEquals("b", codes(nav.getConcepts(a)));
    }
  }

  @Test
  void threadsShareOneCachedAnalysis() throws Exception {
    CodeSystem cs = new CodeSystem();
    for (int i = 0; i < 1000; i++) {
      concept(cs, "c" + i, "subsumedBy", "c" + (i / 2));
    }
    ExecutorService ex = Executors.newFixedThreadPool(8);
    try {
      List<Future<CodeSystemHierarchy>> results = new ArrayList<>();
      for (int i = 0; i < 32; i++) {
        results.add(ex.submit(() -> CodeSystemHierarchy.forCodeSystem(cs, true)));
      }
      CodeSystemHierarchy first = results.get(0).get();
      for (Future<CodeSystemHierarchy> f : results) {
        assertSame(first, f.get());
      }
      assertTrue(first.hasAncestor("c999", "c1"));
    } finally {
      ex.shutdown();
    }
  }
}
