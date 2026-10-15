package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.Property;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.XhtmlType;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Base.forEachChild() (the generated visitChildren()) visits the same values as listChildren()
 * lists, in the same order, at every node of every R6 example
 */
class VisitChildrenExamplesTests {

  private static NpmPackage npm;

  static Stream<Arguments> data() throws IOException {
    npm = NpmPackage.fromPackage(TestingUtilities.loadTestResourceStream("r6", "packages", "hl7.fhir.r6.examples.tgz"));
    List<Arguments> objects = new ArrayList<>();
    for (String n : npm.list("package")) {
      if (n.endsWith(".json") && !n.contains("manifest.json") && !n.contains("xver-") && !n.contains("uml.json") && !n.contains("package-min-ver.json") && !n.startsWith(".")) {
        objects.add(Arguments.of(n));
      }
    }
    return objects.stream();
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("data")
  void test(String name) throws Exception {
    byte[] b = FileUtilities.streamToBytes(npm.load("package", name));
    Resource r = new JsonParser(TestingUtilities.getSharedWorkerContext().getModelContext()).parse(b);
    checkTree(r);
    r.assertModelContext(TestingUtilities.getSharedWorkerContext().getModelContext());
  }

  private static void checkTree(Base node) {
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
}
