package org.hl7.fhir.r4b.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.r4b.fhirpath.FHIRLexer;

class FHIRLexerTest {
  @Test
  @DisplayName("Test that a 'null' current value returns 'false' when FHIRLexer.isConstant() is called, and not NPE.")
  void getCurrent() {
    FHIRLexer lexer = new FHIRLexer(null, null);
    String lexerCurrent = lexer.getCurrent();
    Assertions.assertNull(lexerCurrent);
    Assertions.assertFalse(lexer.isConstant());
  }
}