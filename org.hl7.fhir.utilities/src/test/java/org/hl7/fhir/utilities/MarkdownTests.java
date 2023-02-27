package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.utilities.MarkDownProcessor.Dialect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkdownTests {

  @Test
  void testMarkdownDetection() {
    testMarkdown("this is a test string", false);
    testMarkdown("this is a \r\ntest string", false);
    testMarkdown("this is a \r\ntest string", true, true);
    testMarkdown("this is a t*est strin*g", false);
    testMarkdown("this is a *test strin*g", false);
    testMarkdown("this is a *test string*", true);
    testMarkdown("this is a *test *string", false);
    testMarkdown("this is a *test* string", true);
    testMarkdown("this [is] a test string", false);
    testMarkdown("this [is](link) a test string", true);
    testMarkdown("this [is](link a test string", false);
    testMarkdown("this [is] (link) a test string", false);
    testMarkdown("this [is(link)] a test string", false);
    testMarkdown("this [is](link a test string", false);
    testMarkdown("this [i]s] (link) a test string", false);
    testMarkdown("## heading", true);
    testMarkdown("# heading", false);
    testMarkdown("##  heading", false);
    testMarkdown("###", false);
  }

  private void testMarkdown(String content, boolean isMD) {
    testMarkdown(content, isMD, false);
  }

  private void testMarkdown(String content, boolean isMD, boolean ifLines) {
    boolean test = new MarkDownProcessor(Dialect.COMMON_MARK).isProbablyMarkdown(content, ifLines);
    assertEquals(isMD, test);    
  }

  @Test
  void testStringToMarkdown() {
    // first, we test the need for replacing
    Assertions.assertEquals("<p>This is a string</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This is a string", null).trim());
    Assertions.assertEquals("<p>This is *a string</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This is *a string", null).trim());
    Assertions.assertNotEquals("<p>This is *a* string</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This is *a* string", null).trim());
    Assertions.assertEquals("<p>This is *a *string</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This is *a *string", null).trim());
    
    Assertions.assertNotEquals("<p>This genomic study analyzes CYP2D6*1 and CYP2D6*2</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This genomic study analyzes CYP2D6*1 and CYP2D6*2", null).trim());
    Assertions.assertEquals("<p>This genomic study analyzes CYP2D6*1 and CYP2D6*2</p>", new MarkDownProcessor(Dialect.COMMON_MARK).process("This genomic study analyzes CYP2D6*1 and CYP2D6\\*2", null).trim());
    
    
    Assertions.assertEquals("This is \\*a test\\*", MarkDownProcessor.makeStringSafeAsMarkdown("This is *a test*"));
    Assertions.assertEquals("This is *a test*", MarkDownProcessor.makeMarkdownForString("This is \\*a test\\*"));
  }

}
//
//case '*':
//case '&':
//case '#':
//case '[':
//case '>':
//case '<':
//case '`':
//  -
//  |
//  :
//  ~
//  ^
//  =