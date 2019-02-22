package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.graphql.EGraphEngine;
import org.hl7.fhir.utilities.graphql.EGraphQLException;
import org.hl7.fhir.utilities.graphql.Package;
import org.hl7.fhir.utilities.graphql.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GraphQLParserTests {

  @Parameters(name = "{index}: {0}")
  public static Iterable<Object[]> data() throws FileNotFoundException, IOException  {
    String src = TextFile.fileToString(TestingUtilities.resourceNameToFile("graphql", "parser-tests.gql"));
    String[] tests = src.split("###");
    int i = 0;
    for (String s : tests) 
      if (!Utilities.noString(s.trim()))
        i++;
    List<Object[]> objects = new ArrayList<Object[]>(i);
    i = 0;
    for (String s : tests) {
      if (!Utilities.noString(s.trim())) {
        int l = s.indexOf('\r');        
        objects.add(new Object[] { s.substring(0,  l), s.substring(l+2).trim()});
      }
    }
    return objects;
  }

  private final String test;
  private final String name;

  public GraphQLParserTests(String name, String test) {
    this.name = name;
    this.test = test;
  }

  @Test
  public void test() throws IOException, EGraphQLException, EGraphEngine {
    Package doc = Parser.parse(test);
    assertTrue(doc != null);
  }


}
