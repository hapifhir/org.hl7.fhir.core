package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.PathEngineException;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Property;
import org.hl7.fhir.services.fhirpath.ExpressionNode;
import org.hl7.fhir.services.fhirpath.FHIRLexer.FHIRLexerException;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.type.StructureMapValidator;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StructureMapConstantCheckTests {

  private static Map<String, SimpleWorkerContext> contexts;

  @BeforeAll
  static void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    contexts = Map.of(
        "5.0.0", TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r5.core", "5.0.0")),
        "6.0.0-snapshot1", TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r6.core", "6.0.0-snapshot1")));
  }

  static Stream<Arguments> invalidExpressions() {
    return Stream.of("5.0.0", "6.0.0-snapshot1").flatMap(version -> Stream.of(
        Arguments.of(version, "'unterminated", FHIRLexerException.class),
        Arguments.of(version, "'text'.substring(true)", PathEngineException.class),
        Arguments.of(version, "'text'.unknownProperty", PathEngineException.class)));
  }

  @ParameterizedTest
  @MethodSource("invalidExpressions")
  void testConstantExpressionFailuresAreReported(String version, String expression,
      Class<? extends FHIRException> exceptionType) {
    SimpleWorkerContext context = contexts.get(version);
    FHIRPathEngine engine = new FHIRPathEngine(context);
    StructureMapValidator validator = newValidator(context, engine);
    assertThrows(exceptionType, () -> engine.check(validator.new VariableSet(),
        (String) null, (String) null, null, engine.parse(expression)));

    Element map = constantMap(context, expression);
    List<ValidationMessage> errors = new ArrayList<>();
    assertFalse(assertDoesNotThrow(() -> validator.validateStructureMap(
        null, errors, map, new NodeStack(context))));

    assertEquals(2, errors.size(), errors.toString());
    for (ValidationMessage error : errors) {
      assertEquals(I18nConstants.SM_CONSTANT_TYPE_UNDETERMINED, error.getMessageId());
      assertEquals(IssueSeverity.INFORMATION, error.getLevel());
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0-snapshot1"})
  void testConstantDefinitionFailuresAreReported(String version) {
    SimpleWorkerContext context = contexts.get(version);
    FHIRPathEngine engine = spy(new FHIRPathEngine(context));
    doThrow(new DefinitionException("Invalid type definition")).when(engine).check(
        any(), isNull(String.class), isNull(String.class), isNull(String.class), any(ExpressionNode.class));
    StructureMapValidator validator = newValidator(context, engine);
    List<ValidationMessage> errors = new ArrayList<>();

    assertFalse(assertDoesNotThrow(() -> validator.validateStructureMap(
        null, errors, constantMap(context, "'text'"), new NodeStack(context))));

    assertEquals(2, errors.size(), errors.toString());
    for (ValidationMessage error : errors) {
      assertEquals(I18nConstants.SM_CONSTANT_TYPE_UNDETERMINED, error.getMessageId());
      assertEquals(IssueSeverity.INFORMATION, error.getLevel());
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0-snapshot1"})
  void testUnexpectedConstantCheckFailuresStillPropagate(String version) {
    SimpleWorkerContext context = contexts.get(version);
    FHIRPathEngine engine = spy(new FHIRPathEngine(context));
    IllegalStateException failure = new IllegalStateException("Unexpected engine failure");
    doThrow(failure).when(engine).check(
        any(), isNull(String.class), isNull(String.class), isNull(String.class), any(ExpressionNode.class));
    StructureMapValidator validator = newValidator(context, engine);

    assertSame(failure, assertThrows(IllegalStateException.class, () -> validator.validateStructureMap(
        null, new ArrayList<>(), constantMap(context, "'text'"), new NodeStack(context))));
  }

  private StructureMapValidator newValidator(SimpleWorkerContext context, FHIRPathEngine engine) {
    return new StructureMapValidator(new BaseValidator(context, new ValidatorSettings(), null, null), engine, null);
  }

  private Element constantMap(SimpleWorkerContext context, String expression) {
    Element map = new Element("StructureMap");
    Property property = new Property(context, new ElementDefinition().setPath("StructureMap.const"),
        context.fetchTypeDefinition("StructureMap"));
    for (String name : List.of("first", "second")) {
      Element constant = new Element("const", property, "BackboneElement", null);
      constant.getChildList().add(new Element("name", null, "id", name));
      constant.getChildList().add(new Element("value", null, "string", expression));
      map.getChildList().add(constant);
    }
    return map;
  }
}
