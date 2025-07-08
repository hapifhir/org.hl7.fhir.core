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
    var parseTree = fp.parse("true and where(\n  true\n)");
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
    Assertions.assertEquals(2, opWhereArg.getEnd().getLine());
    Assertions.assertEquals(7, opWhereArg.getEnd().getColumn());
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

  @Test
  void testFhirPathParserLexerIndexer() {
    var parseTree = fp.parse("name [0]  | smile ");

    // Check all the line numbering from the parse tree
    // the name
    var opName = parseTree;
    Assertions.assertEquals(1, opName.getStart().getLine());
    Assertions.assertEquals(1, opName.getStart().getColumn());
    Assertions.assertEquals("name", opName.getName());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Name, opName.getKind());
    Assertions.assertEquals(1, opName.getEnd().getLine());
    Assertions.assertEquals(5, opName.getEnd().getColumn());

    // the indexer
    var opIndexer = opName.getInner();
    Assertions.assertEquals(1, opIndexer.getStart().getLine());
    Assertions.assertEquals(6, opIndexer.getStart().getColumn());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Function.Item, opIndexer.getFunction());
    Assertions.assertEquals(1, opIndexer.getEnd().getLine());
    Assertions.assertEquals(9, opIndexer.getEnd().getColumn());

    // the pipe operator
    Assertions.assertEquals(1, opIndexer.getOpStart().getLine());
    Assertions.assertEquals(11, opIndexer.getOpStart().getColumn());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Operation.Union, opIndexer.getOperation());
    Assertions.assertEquals(1, opIndexer.getOpEnd().getLine());
    Assertions.assertEquals(12, opIndexer.getOpEnd().getColumn());

    // the right side
    var opRight = opIndexer.getOpNext();
    Assertions.assertEquals(1, opRight.getStart().getLine());
    Assertions.assertEquals(13, opRight.getStart().getColumn());
    Assertions.assertEquals("smile", opRight.getName());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Name, opRight.getKind());
    Assertions.assertEquals(1, opRight.getEnd().getLine());
    Assertions.assertEquals(18, opRight.getEnd().getColumn());
  }

  @Test
  void testFhirPathParserLexerOperator() {
    var parseTree = fp.parse("true in true   ");

    // Check all the line numbering from the parse tree
    // the name
    var opLeft = parseTree;
    Assertions.assertEquals(1, opLeft.getStart().getLine());
    Assertions.assertEquals(1, opLeft.getStart().getColumn());
    Assertions.assertEquals("true", opLeft.getConstant().primitiveValue());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, opLeft.getKind());
    Assertions.assertEquals(1, opLeft.getEnd().getLine());
    Assertions.assertEquals(5, opLeft.getEnd().getColumn());

    // the Operator itself
    Assertions.assertEquals(1, opLeft.getOpStart().getLine());
    Assertions.assertEquals(6, opLeft.getOpStart().getColumn());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Operation.In, opLeft.getOperation());
    Assertions.assertEquals(1, opLeft.getOpEnd().getLine());
    Assertions.assertEquals(8, opLeft.getOpEnd().getColumn());

    // the right side
    var opRight = opLeft.getOpNext();
    Assertions.assertEquals(1, opRight.getStart().getLine());
    Assertions.assertEquals(9, opRight.getStart().getColumn());
    Assertions.assertEquals("true", opRight.getConstant().primitiveValue());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, opRight.getKind());
    Assertions.assertEquals(1, opRight.getEnd().getLine());
    Assertions.assertEquals(13, opRight.getEnd().getColumn());
  }

  @Test
  void testFhirPathParserLexerConstantBoolean() {
    var parseTree = fp.parse(" true  ");

    // Check all the line numbering from the parse tree
    // the name
    var constantNode = parseTree;
    Assertions.assertEquals(1, constantNode.getStart().getLine());
    Assertions.assertEquals(2, constantNode.getStart().getColumn());
    Assertions.assertEquals("true", constantNode.getConstant().primitiveValue());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, constantNode.getKind());
    Assertions.assertEquals(1, constantNode.getEnd().getLine());
    Assertions.assertEquals(6, constantNode.getEnd().getColumn());
  }

  @Test
  void testFhirPathParserLexerConstantString() {
    var parseTree = fp.parse(" 'true'  ");

    // Check all the line numbering from the parse tree
    // the name
    var constantNode = parseTree;
    Assertions.assertEquals(1, constantNode.getStart().getLine());
    Assertions.assertEquals(2, constantNode.getStart().getColumn());
    Assertions.assertEquals("true", constantNode.getConstant().primitiveValue());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, constantNode.getKind());
    Assertions.assertEquals(1, constantNode.getEnd().getLine());
    Assertions.assertEquals(8, constantNode.getEnd().getColumn());
  }

  @Test
  void testFhirPathParserLexerConstantQuantity() {
    var parseTree = fp.parse(" 1 'a'  ");

    // Check all the line numbering from the parse tree
    // the name
    var constantNode = parseTree;
    Assertions.assertEquals(1, constantNode.getStart().getLine());
    Assertions.assertEquals(2, constantNode.getStart().getColumn());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, constantNode.getKind());
    Assertions.assertEquals(1, constantNode.getEnd().getLine());
    Assertions.assertEquals(7, constantNode.getEnd().getColumn());
    var quantity = (org.hl7.fhir.r5.model.Quantity) constantNode.getConstant();
    Assertions.assertNotNull(quantity);
    Assertions.assertEquals(1.0f, quantity.getValue().floatValue());
    Assertions.assertEquals("a", quantity.getCode());
  }

  @Test
  void testFhirPathParserLexerConstantBooleanInBrackets() {
    var parseTree = fp.parse(" ( true ) ");

    // Check all the line numbering from the parse tree

    // the group
    var groupNode = parseTree;
    Assertions.assertEquals(1, groupNode.getStart().getLine());
    Assertions.assertEquals(2, groupNode.getStart().getColumn());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Group, groupNode.getKind());
    Assertions.assertEquals(1, groupNode.getEnd().getLine());
    Assertions.assertEquals(10, groupNode.getEnd().getColumn());

    // the name
    var constantNode = groupNode.getGroup();
    Assertions.assertEquals(1, constantNode.getStart().getLine());
    Assertions.assertEquals(4, constantNode.getStart().getColumn());
    Assertions.assertEquals("true", constantNode.getConstant().primitiveValue());
    Assertions.assertEquals(org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind.Constant, constantNode.getKind());
    Assertions.assertEquals(1, constantNode.getEnd().getLine());
    Assertions.assertEquals(8, constantNode.getEnd().getColumn());
  }

}