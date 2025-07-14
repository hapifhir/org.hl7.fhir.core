package org.hl7.fhir.r5.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.ResourceParser;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine.ExecutionContext;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FHIRPathDebugTracerTests {

  public class FHIRPathDebugTracer implements FHIRPathEngine.IDebugTracer {

    public FHIRPathDebugTracer(String completeExpression) {
      // Constructor
      this.expressionLines = completeExpression.split("\n");
    }

    private String[] expressionLines;
    public ArrayList<String> traceOutput = new ArrayList<>();

    public void clear() {
      traceOutput.clear();
    }

    @Override
    public void traceExpression(ExecutionContext context, List<Base> focus, List<Base> result, ExpressionNode exp) {
      logTraceExpression(getDebugTraceName(expressionLines, exp), context, focus, result, exp);
    }

    @Override
    public void traceOperationExpression(ExecutionContext context, List<Base> focus, List<Base> result,
        ExpressionNode exp) {
      logTraceExpression(getDebugTraceOpName(expressionLines, exp), context, focus, result, exp);
    }

    private void logTraceExpression(String expName, ExecutionContext context, List<Base> focus, List<Base> result,
        ExpressionNode exp) {
      System.out.println("Trace: " + expName + " - " + exp.getKind().toString());
      System.out.println("Expression: " + exp.toString());

      if (context.getThisItem() instanceof Element) {
        var element = (Element) context.getThisItem();
        System.out.printf("This: %s\n", element.getPath());
      }

      System.out.println("Focus: " + focus.size() + " items");
      for (Base base : focus) {
        if (base instanceof Element) {
          var element = (Element) base;
          if (element.getValue() != null)
            System.out.printf("   %s: %s\n", element.getPath(), element.getValue());
          else
            System.out.printf("   %s\n", element.getPath());
        } else {
          System.out.printf("   %s\n", base.toString());
        }
      }

      System.out.println("Result: " + result.size());
      for (Base base : result) {
        if (base instanceof Element) {
          var element = (Element) base;
          if (element.getValue() != null)
            System.out.printf("   %s: %s\n", element.getPath(), element.getValue());
          else
            System.out.printf("   %s\n", element.getPath());
        } else {
          System.out.printf("   %s\n", base.toString());
        }
      }
      System.out.println();
      traceOutput.add(String.format("%s: focus=%d result=%d", expName, focus.size(), result.size()));
    }

    private String getDebugTraceName(String[] lines, ExpressionNode node) {
      // compute the position and length of the node in the string using the data from
      // the getStart() method
      if (node.getStart() == null || node.getEnd() == null) {
        return "0,0,unknown";
      }
      int startPosition = node.getStart().getColumn() - 1;
      int line = node.getStart().getLine() - 1;
      while (line > 0)
        startPosition += lines[--line].length() + 1; // +1 for the newline character

      // evaluate the length using the getEnd() method
      int nodeLength = node.getEnd().getColumn() - 1;
      line = node.getEnd().getLine() - 1;
      do {
        if (node.getStart().getLine() - 1 == line) {
          nodeLength -= node.getStart().getColumn() - 1;
        } else if (line < lines.length) {
          nodeLength += lines[line].length() + 1; // +1 for the newline character
        }
        line--;
      } while (node.getStart().getLine() < line);

      return String.format("%d,%d,%s", startPosition, nodeLength,
          node.getKind() == ExpressionNode.Kind.Constant ? "constant" : node.getName());
    }

    private String getDebugTraceOpName(String[] lines, ExpressionNode node) {
      // compute the position and length of the node in the string using the data from
      // the getStart() method
      if (node.getOpStart() == null) {
        return "0,0,unknown";
      }
      int startPosition = node.getOpStart().getColumn() - 1;
      int line = node.getOpStart().getLine() - 1;
      while (line > 0)
        startPosition += lines[--line].length() + 1; // +1 for the newline character

      // evaluate the length using the getEnd() method
      int nodeLength = node.getOperation().toCode().length();

      return String.format("%d,%d,%s", startPosition, nodeLength, node.getOperation().toCode());
    }
  }

  private static FHIRPathEngine fp;

  @BeforeAll
  public static void setUp() throws FileNotFoundException, FHIRException, IOException {
    if (fp == null) {
      fp = new FHIRPathEngine(TestingUtilities.getSharedWorkerContext());
    }
  }

  private org.hl7.fhir.r5.elementmodel.Element loadTestResource(String filename)
      throws IOException, FileNotFoundException {

    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    ResourceParser p = new ResourceParser(ctxt);
    Resource res = (Resource) new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", filename));
    org.hl7.fhir.r5.elementmodel.Element e = p.parse(res);
    return e;
  }

  @Test
  public void testDebugTrace_PropertyWalking() throws FHIRException, IOException {
    System.out.println();
    var expression = "Patient.birthDate.toString().substring(0, 4)";
    var tracer = new FHIRPathDebugTracer(expression);
    fp.setTracer(tracer);

    var input = loadTestResource("patient-example.xml");
    List<Base> results = fp.evaluate(input, expression);
    fp.setTracer(null);

    assertEquals(1, results.size());
    assertEquals("1974", results.get(0).toString());

    assertEquals(6, tracer.traceOutput.size());
    assertEquals("0,7,Patient: focus=1 result=1", tracer.traceOutput.get(0));
    assertEquals("8,9,birthDate: focus=1 result=1", tracer.traceOutput.get(1));
    assertEquals("18,10,toString: focus=1 result=1", tracer.traceOutput.get(2));
    assertEquals("39,1,constant: focus=1 result=1", tracer.traceOutput.get(3));
    assertEquals("42,1,constant: focus=1 result=1", tracer.traceOutput.get(4));
    assertEquals("29,15,substring: focus=1 result=1", tracer.traceOutput.get(5));
  }

  @Test
  public void testDebugTrace_WhereClause() throws FHIRException, IOException {
    System.out.println();
    var expression = "name.where(use='official' or use='usual').given";
    var tracer = new FHIRPathDebugTracer(expression);
    fp.setTracer(tracer);

    var input = loadTestResource("patient-example.xml");
    List<Base> results = fp.evaluate(input, expression);
    fp.setTracer(null);

    assertEquals(3, results.size());
    assertEquals("Peter", ((Element) results.get(0)).getValue().toString());
    assertEquals("James", ((Element) results.get(1)).getValue().toString());
    assertEquals("Jim", ((Element) results.get(2)).getValue().toString());

    assertEquals("Patient.name[0].given[0]", ((Element) results.get(0)).getPath());
    assertEquals("Patient.name[0].given[1]", ((Element) results.get(1)).getPath());
    assertEquals("Patient.name[1].given[0]", ((Element) results.get(2)).getPath());

    assertEquals(20, tracer.traceOutput.size());
    assertEquals("0,4,name: focus=1 result=3", tracer.traceOutput.get(0));
    assertEquals("11,3,use: focus=1 result=1", tracer.traceOutput.get(1));
    assertEquals("15,10,constant: focus=1 result=1", tracer.traceOutput.get(2));
    assertEquals("15,10,constant: focus=1 result=1", tracer.traceOutput.get(2));
    assertEquals("14,1,=: focus=1 result=1", tracer.traceOutput.get(3));

    assertEquals("5,36,where: focus=3 result=2", tracer.traceOutput.get(18));
    assertEquals("42,5,given: focus=2 result=3", tracer.traceOutput.get(19));
  }

  @Test
  public void testDebugTrace_ConstantValues() throws FHIRException, IOException {
    System.out.println();
    var expression = "'42'";
    var tracer = new FHIRPathDebugTracer(expression);
    fp.setTracer(tracer);

    var input = loadTestResource("patient-example.xml");
    List<Base> results = fp.evaluate(input, expression);
    fp.setTracer(null);

    assertEquals(1, results.size());
    assertEquals("42", results.get(0).toString());

    assertEquals(1, tracer.traceOutput.size());
    assertEquals("0,4,constant: focus=1 result=1", tracer.traceOutput.get(0));
  }

  @Test
  public void testDebugTrace_GroupedOr() throws FHIRException, IOException {
    System.out.println();
    var expression = "id='official' or id='example'";
    var tracer = new FHIRPathDebugTracer(expression);
    fp.setTracer(tracer);

    var input = loadTestResource("patient-example.xml");
    List<Base> results = fp.evaluate(input, expression);
    fp.setTracer(null);

    assertEquals(1, results.size());
    assertEquals("BooleanType[true]", results.get(0).toString());

    assertEquals(7, tracer.traceOutput.size());
    assertEquals("0,2,id: focus=1 result=1", tracer.traceOutput.get(0));
    assertEquals("3,10,constant: focus=1 result=1", tracer.traceOutput.get(1));
    assertEquals("2,1,=: focus=1 result=1", tracer.traceOutput.get(2));
    assertEquals("17,2,id: focus=1 result=1", tracer.traceOutput.get(3));
    assertEquals("20,9,constant: focus=1 result=1", tracer.traceOutput.get(4));
    assertEquals("19,1,=: focus=1 result=1", tracer.traceOutput.get(5));
    assertEquals("14,2,or: focus=1 result=1", tracer.traceOutput.get(6));
  }
}