package org.hl7.fhir.r5.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FHIRLexerTest {
  @Test
  @DisplayName("Test that a 'null' current value returns 'false' when FHIRLexer.isConstant() is called, and not NPE.")
  void getCurrent() {
    FHIRLexer lexer = new FHIRLexer(null, null, false, true);
    String lexerCurrent = lexer.getCurrent();
    Assertions.assertNull(lexerCurrent);
    Assertions.assertFalse(lexer.isConstant());
  }
}