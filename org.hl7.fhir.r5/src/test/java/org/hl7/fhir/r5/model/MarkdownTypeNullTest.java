package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MarkdownTypeNullTest {

  @Test
  @DisplayName("Test null value toString()")
  void testToString() {
    MarkdownType nullMarkdown = new MarkdownType();
    System.out.println("Value -> " + nullMarkdown);
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
    MarkdownType copyMarkdown = nullMarkdown.copy();
    Assertions.assertNull(copyMarkdown.getValue());
  }

  @Test
  @DisplayName("Test null value typedCopy()")
  void typedCopy() {
    MarkdownType nullMarkdown = new MarkdownType();
    MarkdownType copyMarkdown = (MarkdownType) nullMarkdown.typedCopy();
    Assertions.assertNull(copyMarkdown.getValue());
  }
}