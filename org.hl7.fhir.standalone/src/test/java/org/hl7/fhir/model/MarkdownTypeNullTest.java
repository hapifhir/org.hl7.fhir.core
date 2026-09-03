package org.hl7.fhir.model;

import org.hl7.fhir.model.core.MarkdownType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MarkdownTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    assertDoesNotThrow(() -> {
      MarkdownType nullMarkdown = new MarkdownType();
      System.out.println("Value -> " + nullMarkdown);
    });
  }

  @Test
  @DisplayName("Test null value equalsDeep()")
  void equalsDeep() {
    MarkdownType nullMarkdown = new MarkdownType();
    MarkdownType validMarkdown = new MarkdownType("__MARKDOWN__");
    Assertions.assertFalse(nullMarkdown.equalsDeep(validMarkdown));
  }

  @Test
  @DisplayName("Test null value equalsShallow()")
  void equalsShallow() {
    MarkdownType nullMarkdown = new MarkdownType();
    MarkdownType validMarkdown = new MarkdownType("__MARKDOWN__");
    Assertions.assertFalse(nullMarkdown.equalsShallow(validMarkdown));
  }

  @Test
  @DisplayName("Test null value copy()")
  void copy() {
    MarkdownType nullMarkdown = new MarkdownType();
    MarkdownType copyMarkdown = nullMarkdown.copy(Base.COPY_DATA);
    Assertions.assertNull(copyMarkdown.getValue());
  }

}