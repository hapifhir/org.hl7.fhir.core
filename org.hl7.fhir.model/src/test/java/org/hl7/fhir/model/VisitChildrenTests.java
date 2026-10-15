package org.hl7.fhir.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Narrative;
import org.hl7.fhir.model.core.Narrative.NarrativeStatus;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.XhtmlType;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Test;

/**
 * Base.forEachChild() / the generated visitChildren() - the fast alternative to listChildren()
 */
class VisitChildrenTests {

  /**
   * Every class in the model that overrides listChildren() must override visitChildren() too, or
   * forEachChild() quietly falls back to the slow listChildren() walk for it
   */
  @Test
  void testAllModelClassesVisitAllChildren() throws Exception {
    List<String> missing = new ArrayList<>();
    int count = 0;
    for (String cn : modelClassNames()) {
      Class<?> c = Class.forName(cn, false, Base.class.getClassLoader());
      if (Base.class.isAssignableFrom(c)) {
        count++;
        if (!Base.visitsAllChildren(c)) {
          missing.add(cn);
        }
      }
    }
    assertTrue(count > 500, "only found "+count+" classes");
    assertTrue(missing.isEmpty(), "classes that override listChildren() but not visitChildren(): "+missing);
  }

  @Test
  void testFallbackForClassWithoutVisitChildren() {
    Base b = new StringType("x") {
      private static final long serialVersionUID = 1L;
      @Override
      protected void listChildren(List<Property> result) {
        super.listChildren(result);
        result.add(new Property("extra", "string", "", 0, 1, new StringType("y")));
      }
    };
    assertFalse(Base.visitsAllChildren(b.getClass()));
    List<String> names = new ArrayList<>();
    b.forEachChild((parent, name, index, child) -> names.add(name));
    assertEquals(List.of("extra"), names);
  }

  @Test
  void testForEachChildMatchesListChildren() {
    Patient p = makePatient();
    checkTree(p);
  }

  @Test
  void testGetChildValuesStar() {
    Patient p = makePatient();
    List<Base> values = p.getText().getChildValues("*", false);
    assertEquals(2, values.size());
    assertEquals("code", values.get(0).fhirType());
    assertTrue(values.get(1) instanceof XhtmlType);

    values = p.getNameFirstRep().getChildValues("*", false);
    assertEquals(3, values.size()); // family, 2 x given
    assertSame(p.getNameFirstRep().getGivenList().get(1), values.get(2));
  }

  @Test
  void testVisitDescendants() {
    Patient p = makePatient();
    List<String> all = new ArrayList<>();
    p.visitDescendants((parent, name, index, child) -> {
      all.add(name + (index == -1 ? "" : "[" + index + "]"));
      return true;
    });
    assertTrue(all.contains("given[1]"), all.toString());
    assertTrue(all.contains("div"), all.toString());

    List<String> top = new ArrayList<>();
    p.visitDescendants((parent, name, index, child) -> {
      top.add(name);
      return false; // don't descend
    });
    assertEquals(List.of("id", "text", "active", "name"), top);
  }

  @Test
  void testAssertModelContextAdopts() {
    Patient p = makePatient();
    p.assertModelContext(ModelContext.minimalContext());
    assertSame(ModelContext.minimalContext(), p.getModelContext());
    assertSame(ModelContext.minimalContext(), p.getNameFirstRep().getGivenList().get(1).getModelContext());
    assertSame(ModelContext.minimalContext(), p.getText().getStatusElement().getModelContext());
  }

  @Test
  void testAssertModelContextReportsThePath() {
    Patient p = makePatient();
    p.assertModelContext(ModelContext.minimalContext());
    assertFalse(ModelContext.fullCoreContext().isCompatibleModelContext(ModelContext.minimalContext()));
    p.getNameFirstRep().getGivenList().get(1).changeModelContext(ModelContext.fullCoreContext());

    FHIRException e = assertThrows(FHIRException.class, () -> p.assertModelContext(ModelContext.minimalContext()));
    assertTrue(e.getMessage().startsWith("Model context mismatch at Patient.name[0].given[1]: "), e.getMessage());

    p.getNameFirstRep().getGivenList().get(1).changeModelContext(ModelContext.minimalContext());
    p.getActiveElement().changeModelContext(ModelContext.fullCoreContext());
    e = assertThrows(FHIRException.class, () -> p.assertModelContext(ModelContext.minimalContext()));
    assertTrue(e.getMessage().startsWith("Model context mismatch at Patient.active: "), e.getMessage());
  }

  @Test
  void testChangeModelContextReachesEveryNode() {
    Patient p = makePatient();
    p.assertModelContext(ModelContext.minimalContext());
    p.changeModelContext(ModelContext.fullCoreContext());
    p.visitDescendants((parent, name, index, child) -> {
      assertSame(ModelContext.fullCoreContext(), child.getModelContext(), name);
      return true;
    });
  }

  private Patient makePatient() {
    Patient p = new Patient();
    p.setId("example");
    p.setActive(true);
    p.addName().setFamily("Muster").addGiven("Max").addGiven("Moritz");
    Narrative n = new Narrative();
    n.setStatus(NarrativeStatus.GENERATED);
    XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
    div.addText("Max Muster");
    n.setDiv(div);
    p.setText(n);
    return p;
  }

  /**
   * forEachChild() must visit the same values as listChildren() lists, in the same order - at
   * every node of the tree. (XhtmlType is a new wrapper object each time, so it's compared by
   * class)
   */
  public static void checkTree(Base node) {
    List<String> expected = new ArrayList<>();
    List<Base> expectedValues = new ArrayList<>();
    for (Property c : node.getChildren()) {
      int i = 0;
      for (Base b : c.getValues()) {
        if (b != null) {
          expected.add(c.getName() + "#" + (c.isList() ? i : -1));
          expectedValues.add(b);
        }
        i++;
      }
    }
    List<String> actual = new ArrayList<>();
    List<Base> actualValues = new ArrayList<>();
    node.forEachChild((parent, name, index, child) -> {
      assertSame(node, parent);
      actual.add(name + "#" + index);
      actualValues.add(child);
      return false;
    });
    assertEquals(expected, actual, "children of " + node.fhirType());
    for (int i = 0; i < expectedValues.size(); i++) {
      if (expectedValues.get(i) instanceof XhtmlType) {
        assertTrue(actualValues.get(i) instanceof XhtmlType);
      } else {
        assertSame(expectedValues.get(i), actualValues.get(i), "child " + expected.get(i) + " of " + node.fhirType());
        checkTree(actualValues.get(i));
      }
    }
  }

  private static List<String> modelClassNames() throws IOException, URISyntaxException {
    List<String> res = new ArrayList<>();
    File src = new File(Base.class.getProtectionDomain().getCodeSource().getLocation().toURI());
    if (src.isDirectory()) {
      Path root = src.toPath();
      try (Stream<Path> files = Files.walk(root.resolve("org/hl7/fhir/model"))) {
        files.filter(f -> f.toString().endsWith(".class")).forEach(f -> res.add(className(root.relativize(f).toString().replace(File.separatorChar, '/'))));
      }
    } else {
      try (JarFile jar = new JarFile(src)) {
        Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
          String n = entries.nextElement().getName();
          if (n.startsWith("org/hl7/fhir/model/") && n.endsWith(".class")) {
            res.add(className(n));
          }
        }
      }
    }
    return res;
  }

  private static String className(String path) {
    return path.substring(0, path.length() - ".class".length()).replace('/', '.');
  }
}
