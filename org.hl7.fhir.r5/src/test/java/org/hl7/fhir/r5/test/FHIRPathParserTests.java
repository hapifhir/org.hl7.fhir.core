package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FHIRPathParserTests {

  private static FHIRPathEngine fp;
  private static SimpleWorkerContext context;

  @BeforeAll
  public static void setUp() throws FileNotFoundException, FHIRException, IOException {
    context = new SimpleWorkerContext((SimpleWorkerContext) TestingUtilities.getSharedWorkerContext());
    if (fp == null) {
      fp = new FHIRPathEngine(context);
    }
  }

  @Test
  void testFhirPathParserLexer1() {
      var parseTree = fp.parse("true");
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer2() {
      var parseTree = fp.parse(" true");
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(2, parseTree.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer3() {
      var parseTree = fp.parse("\ntrue");
      Assertions.assertEquals(2, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer4() {
      var parseTree = fp.parse("\n  true");
      Assertions.assertEquals(2, parseTree.getStart().getLine());
      Assertions.assertEquals(3, parseTree.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer5() {
      var parseTree = fp.parse("true and false");
      // the true
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());

      // the and
      Assertions.assertEquals(1, parseTree.getOpStart().getLine());
      Assertions.assertEquals(6, parseTree.getOpStart().getColumn());

      // the false
      var opFalse = parseTree.getOpNext();
      Assertions.assertEquals(1, opFalse.getStart().getLine());
      Assertions.assertEquals(10, opFalse.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer6() {
      var parseTree = fp.parse("true and where(true)");
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());

      Assertions.assertEquals(1, parseTree.getOpStart().getLine());
      Assertions.assertEquals(6, parseTree.getOpStart().getColumn());

      var opWhere = parseTree.getOpNext();
      Assertions.assertEquals(1, opWhere.getStart().getLine());
      Assertions.assertEquals(10, opWhere.getStart().getColumn());

      // Check the where parameters
      var opWhereArg = opWhere.getParameters().get(0);
      Assertions.assertEquals(1, opWhereArg.getStart().getLine());
      Assertions.assertEquals(16, opWhereArg.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer7() {
      var parseTree = fp.parse("true and where(  true)");
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());

      Assertions.assertEquals(1, parseTree.getOpStart().getLine());
      Assertions.assertEquals(6, parseTree.getOpStart().getColumn());

      var opWhere = parseTree.getOpNext();
      Assertions.assertEquals(1, opWhere.getStart().getLine());
      Assertions.assertEquals(10, opWhere.getStart().getColumn());

      // Check the where parameters
      var opWhereArg = opWhere.getParameters().get(0);
      Assertions.assertEquals(1, opWhereArg.getStart().getLine());
      Assertions.assertEquals(18, opWhereArg.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexer8() {
      var parseTree = fp.parse("true and where(\n  true)");
      Assertions.assertEquals(1, parseTree.getStart().getLine());
      Assertions.assertEquals(1, parseTree.getStart().getColumn());

      Assertions.assertEquals(1, parseTree.getOpStart().getLine());
      Assertions.assertEquals(6, parseTree.getOpStart().getColumn());

      var opWhere = parseTree.getOpNext();
      Assertions.assertEquals(1, opWhere.getStart().getLine());
      Assertions.assertEquals(10, opWhere.getStart().getColumn());

      // Check the where parameters
      var opWhereArg = opWhere.getParameters().get(0);
      Assertions.assertEquals(2, opWhereArg.getStart().getLine());
      Assertions.assertEquals(3, opWhereArg.getStart().getColumn());
  }

  @Test
  void testFhirPathParserLexerComplex() {
      var parseTree = fp.parse("\n numerator.where( code=  '[arb\\'U]' )");

      // Check all the line numbering from the parse tree
      // the numerator
      var opNumerator = parseTree;
      Assertions.assertEquals(2, opNumerator.getStart().getLine());
      Assertions.assertEquals(2, opNumerator.getStart().getColumn());

      // the where
      var opWhere = opNumerator.getInner();
      Assertions.assertEquals(2, opWhere.getStart().getLine());
      Assertions.assertEquals(12, opWhere.getStart().getColumn());

      // the code
      var opCode = opWhere.getParameters().get(0);
      Assertions.assertEquals(2, opCode.getStart().getLine());
      Assertions.assertEquals(19, opCode.getStart().getColumn());

      // the equality operator
      Assertions.assertEquals(2, opCode.getOpStart().getLine());
      Assertions.assertEquals(23, opCode.getOpStart().getColumn());

      // the string value
      var opString = opCode.getOpNext();
      Assertions.assertEquals(2, opString.getStart().getLine());
      Assertions.assertEquals(26, opString.getStart().getColumn());

  }

  @Test
  void testFhirPathParserLexerGroupedOr() {
      var parseTree = fp.parse("id='official' or id='example'");

      // Check all the line numbering from the parse tree
      // the or
      var opOr = parseTree;
      Assertions.assertEquals(1, opOr.getOpStart().getLine());
      Assertions.assertEquals(15, opOr.getOpStart().getColumn());
      Assertions.assertEquals("or", opOr.getOperation().toCode());

      var opLeftEquals = opOr.getGroup();
      var opRightEquals = opOr.getOpNext().getGroup();

      Assertions.assertEquals(1, opLeftEquals.getOpStart().getLine());
      Assertions.assertEquals(3, opLeftEquals.getOpStart().getColumn());
      Assertions.assertEquals("=", opLeftEquals.getOperation().toCode());

      Assertions.assertEquals(1, opRightEquals.getOpStart().getLine());
      Assertions.assertEquals(20, opRightEquals.getOpStart().getColumn());
      Assertions.assertEquals("=", opRightEquals.getOperation().toCode());

      // the left side "id='official'""
      Assertions.assertEquals("id", opLeftEquals.getName());
      var opLeftValue = opLeftEquals.getOpNext();
      Assertions.assertEquals(1, opLeftValue.getStart().getLine());
      Assertions.assertEquals(4, opLeftValue.getStart().getColumn());
      Assertions.assertEquals("official", opLeftValue.getConstant().toString());

      // the right side "id='example'"
      Assertions.assertEquals("id", opRightEquals.getName());
      var opRightValue = opRightEquals.getOpNext();
      Assertions.assertEquals(1, opRightValue.getStart().getLine());
      Assertions.assertEquals(21, opRightValue.getStart().getColumn());
      Assertions.assertEquals("example", opRightValue.getConstant().toString());
  }
}