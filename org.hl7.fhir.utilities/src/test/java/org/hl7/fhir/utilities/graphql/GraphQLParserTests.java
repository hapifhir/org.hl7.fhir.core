package org.hl7.fhir.utilities.graphql;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;

public class GraphQLParserTests {
  final static Logger ourLog = LoggerFactory.getLogger(GraphQLParserTests.class);
  final static String multipleIdValues = "{Patient (id:1,2,3){id,name{family,given}}}";

  @Test
  public void testParseMultipleIdValues() throws IOException, EGraphQLException, EGraphEngine {
    Parser parser = new Parser();
    parser.reader = new StringReader(multipleIdValues);
    parser.next();
    Document doc = parser.parseDocument();
    ourLog.info(doc.toString());
  }
}
