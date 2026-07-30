package org.hl7.fhir.r4.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.r4.elementmodel.Element;
import org.hl7.fhir.r4.elementmodel.Manager;
import org.hl7.fhir.r4.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4.fhirpath.ExpressionNode.CollectionStatus;
import org.hl7.fhir.r4.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r4.fhirpath.FHIRPathUtilityClasses.FunctionDetails;
import org.hl7.fhir.r4.fhirpath.TypeDetails;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.hl7.fhir.r4.model.StructureMap;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.r4.utils.StructureMapUtilities;
import org.hl7.fhir.r4.utils.StructureMapUtilities.ITransformerServices;
import org.junit.jupiter.api.Test;

/**
 * Proves that StructureMapUtilities' internal FHIRPathHostServices delegates the FHIRPath
 * custom-function hooks (resolveFunction/checkFunction/executeFunction) to the caller-supplied
 * ITransformerServices, exactly as it already does for resolveReference.
 *
 * Also proves that this is purely additive: an ITransformerServices implementation that does not
 * override the three new default methods sees the exact same "unknown function" failure that
 * FHIRPathHostServices hardcoded before this change.
 */
public class StructureMapUtilitiesFunctionDelegationTest {

  private static final String MAP_TEXT =
      "map \"http://github.com/hapifhir/tests/StructureMap/customfunction\" = \"CustomFunctionMap\"\r\n"
    + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
    + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as target\r\n"
    + "group Main(source src : Patient, target tgt : Patient) {\r\n"
    + "  src.active as v -> tgt.active = (v.negate());\r\n"
    + "}";

  private static final String PATIENT_JSON =
      "{\"resourceType\":\"Patient\",\"active\":true}";

  private Element parsePatient() throws IOException, FHIRException {
    return Manager.parse(TestingUtilities.context(),
        new ByteArrayInputStream(PATIENT_JSON.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
  }

  /**
   * A custom FHIRPath function ("negate") that flips a boolean, implemented entirely by the
   * calling application via ITransformerServices - not by the FHIR core library.
   */
  private static class NegatingTransformerServices implements ITransformerServices {
    @Override
    public void log(String message) {
    }

    @Override
    public Base createType(Object appInfo, String name) throws FHIRException {
      return null;
    }

    @Override
    public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
      return res;
    }

    @Override
    public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
      return null;
    }

    @Override
    public Base resolveReference(Object appContext, String url) throws FHIRException {
      return null;
    }

    @Override
    public List<Base> performSearch(Object appContext, String url) throws FHIRException {
      return null;
    }

    @Override
    public FunctionDetails resolveFunction(FHIRPathEngine engine, String functionName) {
      if ("negate".equals(functionName)) {
        return new FunctionDetails("negate a boolean value", 0, 0);
      }
      return null;
    }

    @Override
    public TypeDetails checkFunction(FHIRPathEngine engine, Object appContext, String functionName, TypeDetails focus,
        List<TypeDetails> parameters) throws PathEngineException {
      if ("negate".equals(functionName)) {
        return new TypeDetails(CollectionStatus.SINGLETON, "boolean");
      }
      throw new PathEngineException("Unknown function '" + functionName + "'");
    }

    @Override
    public List<Base> executeFunction(FHIRPathEngine engine, Object appContext, List<Base> focus, String functionName,
        List<List<Base>> parameters) {
      // The transform's source/target trees are generic elementmodel.Element instances (not the
      // typed model.BooleanType), so booleans must be read via isBooleanPrimitive()/primitiveValue(),
      // exactly as FHIRPathEngine.convertToBoolean() does for its own built-in functions.
      if ("negate".equals(functionName) && focus.size() == 1 && focus.get(0).isBooleanPrimitive()) {
        List<Base> result = new ArrayList<>();
        result.add(new BooleanType(!Boolean.parseBoolean(focus.get(0).primitiveValue())));
        return result;
      }
      throw new Error("Not Implemented Yet");
    }
  }

  /**
   * An ITransformerServices implementation that only implements the pre-existing (non-default)
   * methods, exactly like every ITransformerServices implementor that exists today. It does not
   * override resolveFunction/checkFunction/executeFunction, so it gets the new default bodies.
   */
  private static class PlainTransformerServices implements ITransformerServices {
    @Override
    public void log(String message) {
    }

    @Override
    public Base createType(Object appInfo, String name) throws FHIRException {
      return null;
    }

    @Override
    public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
      return res;
    }

    @Override
    public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
      return null;
    }

    @Override
    public Base resolveReference(Object appContext, String url) throws FHIRException {
      return null;
    }

    @Override
    public List<Base> performSearch(Object appContext, String url) throws FHIRException {
      return null;
    }
  }

  @Test
  public void testCustomFunctionIsDelegatedToTransformerServices() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(TestingUtilities.context(), new NegatingTransformerServices());
    StructureMap map = scu.parse(MAP_TEXT, "CustomFunctionMap");

    // exercises checkFunction (via the analysis/profiling pass) end to end - must not throw.
    assertDoesNotThrow(() -> scu.analyse(null, map));

    Element source = parsePatient();
    StructureDefinition targetType = scu.getTargetType(map);
    Element target = Manager.build(TestingUtilities.context(), targetType);

    // exercises resolveFunction (at parse time, above) and executeFunction (here, at runtime).
    scu.transform(null, source, map, target);

    FHIRPathEngine fp = new FHIRPathEngine(TestingUtilities.context());
    assertEquals("true", fp.evaluateToString(source, "active"));
    assertEquals("false", fp.evaluateToString(target, "active"));
  }

  @Test
  public void testUnknownCustomFunctionStillFailsTheSameWayWithoutOverride() {
    StructureMapUtilities scu = new StructureMapUtilities(TestingUtilities.context(), new PlainTransformerServices());

    // Before this change, FHIRPathHostServices hardcoded resolveFunction() to return null for
    // every function name; an ITransformerServices that does not override the new default
    // methods must observe that exact same "unrecognized function" failure, proving the fix is
    // purely additive rather than a behavior change for existing, non-overriding callers.
    FHIRException ex = assertThrows(FHIRException.class, () -> scu.parse(MAP_TEXT, "CustomFunctionMap"));
    assertEquals(true, ex.getMessage().contains("negate") && ex.getMessage().contains("not a valid function name"));
  }
}
