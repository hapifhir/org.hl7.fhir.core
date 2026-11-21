package org.hl7.fhir.utilities.graphql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** a query comes from whoever sends it: one nested too deeply is refused, not left to run the parser out of stack */
class ParserLimitsTest {

  private static String nestedSelections(int depth) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < depth; i++) {
      b.append("{ a ");
    }
    for (int i = 0; i < depth; i++) {
      b.append("}");
    }
    return b.toString();
  }

  private static String nestedValues(int depth) {
    StringBuilder b = new StringBuilder("{ a(x: ");
    for (int i = 0; i < depth; i++) {
      b.append("{y: ");
    }
    b.append("1");
    for (int i = 0; i < depth; i++) {
      b.append("}");
    }
    b.append(") { b } }");
    return b.toString();
  }

  @ParameterizedTest
  @ValueSource(ints = {Parser.MAX_DEPTH + 1, 100000})
  void deepSelectionsAreRefused(int depth) {
    EGraphQLException e = assertThrows(EGraphQLException.class, () -> Parser.parse(nestedSelections(depth)));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  @ParameterizedTest
  @ValueSource(ints = {Parser.MAX_DEPTH + 1, 100000})
  void deepValuesAreRefused(int depth) {
    EGraphQLException e = assertThrows(EGraphQLException.class, () -> Parser.parse(nestedValues(depth)));
    assertTrue(e.getMessage().contains("nested too deeply"), e.getMessage());
  }

  @Test
  void nestingWithinTheLimitIsFine() throws Exception {
    assertNotNull(Parser.parse(nestedSelections(50)));
    assertNotNull(Parser.parse(nestedValues(40)));
  }

  /** ... is punctuation after a name too (it was read as a name, unless what came before it was punctuation) */
  @Test
  void aFragmentSpreadAfterAField() throws Exception {
    Package p = Parser.parse("query q { id ...F } fragment F on Patient { id }");
    Selection spread = p.getDocument().getOperations().get(0).getSelectionSet().get(1);
    assertNotNull(spread.getFragmentSpread());
    assertEquals("F", spread.getFragmentSpread().getName());
  }
}
