package org.hl7.fhir.r4.test;

import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.graphql.EGraphEngine;
import org.hl7.fhir.utilities.graphql.EGraphQLException;
import org.hl7.fhir.utilities.graphql.Package;
import org.hl7.fhir.utilities.graphql.Parser;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

@Disabled
public class GraphQLParserTests {

  public static Stream<Arguments> data() throws FileNotFoundException, IOException {
    String src = TextFile.fileToString(TestingUtilities.resourceNameToFile("graphql", "parser-tests.gql"));
    String[] tests = src.split("###");
    List<Arguments> objects = new ArrayList<>();
    for (String s : tests) {
      if (!Utilities.noString(s.trim())) {
        int l = s.indexOf('\r');
        objects.add(Arguments.of(s.substring(0, l), s.substring(l + 2).trim()));
      }
    }
    return objects.stream();
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void test(String name, String test) throws IOException, EGraphQLException, EGraphEngine {
    Package doc = Parser.parse(test);
    assertTrue(doc != null);
  }


}