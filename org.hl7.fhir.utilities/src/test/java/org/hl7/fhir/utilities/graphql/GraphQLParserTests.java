package org.hl7.fhir.utilities.graphql;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GraphQLParserTests {
  final static Logger ourLog = LoggerFactory.getLogger(GraphQLParserTests.class);
  final static String multipleIdValues = "{Patient (id:[1,2,3]){id,name{family,given}}}";

  @Test
  public void testParseMultipleIdValuesAndSelectSetWithIdAndFamilyGivenNames() throws IOException, EGraphQLException, EGraphEngine {
    Parser parser = new Parser();
    parser.reader = new StringReader(multipleIdValues);
    parser.next();
    Document document = parser.parseDocument();
    assertNotNull(document);
    List<Operation> operations = document.getOperations();
    assertNotNull(operations);
    assertEquals(1, operations.size());
    Operation operation = operations.get(0);
    List<Selection> selections = operation.getSelectionSet();
    assertNotNull(selections);
    assertEquals(1, selections.size());
    Selection selection = selections.get(0);
    Field field = selection.getField();
    assertNotNull(field);
    assertEquals("Patient", field.getName());
    List<Selection> fieldSelections = field.getSelectionSet();
    assertNotNull(fieldSelections);
    assertEquals(2, fieldSelections.size());
    Selection fieldSelection1 = fieldSelections.get(0);
    assertEquals("id", fieldSelection1.getField().getName());
    Selection fieldSelection2 = fieldSelections.get(1);
    assertEquals("name", fieldSelection2.getField().getName());
    assertEquals(2, fieldSelection2.getField().getSelectionSet().size());
    Selection fieldSelectionSet1 = fieldSelection2.getField().getSelectionSet().get(0);
    assertEquals("family", fieldSelectionSet1.getField().getName());
    Selection fieldSelectionSet2 = fieldSelection2.getField().getSelectionSet().get(1);
    assertEquals("given", fieldSelectionSet2.getField().getName());
    List<Argument> fieldArguments = field.getArguments();
    assertNotNull(fieldArguments);
    assertEquals(1, fieldArguments.size());
    Argument fieldArgument = fieldArguments.get(0);
    assertEquals("id", fieldArgument.getName());
    assertEquals(3, fieldArgument.getValues().size());
    assertEquals("1", fieldArgument.getValues().get(0).getValue());
    assertEquals("2", fieldArgument.getValues().get(1).getValue());
    assertEquals("3", fieldArgument.getValues().get(2).getValue());
  }
}
