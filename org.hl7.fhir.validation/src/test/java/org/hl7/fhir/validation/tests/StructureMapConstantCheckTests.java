package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.hl7.fhir.services.fhirpath.TypeDetails;
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
import org.mockito.ArgumentCaptor;

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

  static Stream<Arguments> validExpressions() {
    return Stream.of("5.0.0", "6.0.0-snapshot1").flatMap(version -> Stream.of(
        Arguments.of(version, "'text'", "string"),
        Arguments.of(version, "true", "boolean"),
        Arguments.of(version, "42", "integer"),
        Arguments.of(version, "1.5", "decimal"),
        Arguments.of(version, "@2026-01-01T00:00:00Z", "dateTime"),
        Arguments.of(version, "@T12:00:00", "time"),
        Arguments.of(version, "1 'mg'", "Quantity")));
  }

  static Stream<Arguments> missingConstantFields() {
    return Stream.of("5.0.0", "6.0.0-snapshot1").flatMap(version -> Stream.of(
        Arguments.of(version, "name", null, I18nConstants.SM_CONSTANT_NAME_MISSING),
        Arguments.of(version, "name", "", I18nConstants.SM_CONSTANT_NAME_MISSING),
        Arguments.of(version, "value", null, I18nConstants.SM_CONSTANT_VALUE_MISSING),
        Arguments.of(version, "value", "", I18nConstants.SM_CONSTANT_VALUE_MISSING)));
  }

  @ParameterizedTest
  @MethodSource("missingConstantFields")
  void testMissingConstantFieldsAreErrors(String version, String field, String value, String messageId) {
    SimpleWorkerContext context = contexts.get(version);
    StructureMapValidator validator = newValidator(context, new FHIRPathEngine(context));
    Element map = constantMap(context, "'text'");
    for (Element constant : map.getChildrenByName("const")) {
      if (value == null) {
        constant.removeChild(field);
      } else {
        constant.getNamedChild(field).setValue(value);
      }
    }
    List<ValidationMessage> errors = new ArrayList<>();

    assertFalse(validator.validateStructureMap(null, errors, map, new NodeStack(context)));
    assertFalse(errors.isEmpty(), errors.toString());
    for (ValidationMessage error : errors) {
      assertEquals(messageId, error.getMessageId());
      assertEquals(IssueSeverity.ERROR, error.getLevel());
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0-snapshot1"})
  void testUndeterminedConstantTypeIsAdvisory(String version) {
    SimpleWorkerContext context = contexts.get(version);
    FHIRPathEngine engine = spy(new FHIRPathEngine(context));
    TypeDetails details = mock(TypeDetails.class);
    when(details.getTypes()).thenReturn(Set.of(TypeDetails.FP_String));
    when(details.getType()).thenReturn(null);
    doReturn(details).when(engine).check(
        any(), isNull(String.class), isNull(String.class), isNull(String.class), any(ExpressionNode.class));
    StructureMapValidator validator = newValidator(context, engine);
    List<ValidationMessage> errors = new ArrayList<>();

    assertTrue(validator.validateStructureMap(null, errors, constantMap(context, "'text'"), new NodeStack(context)));
    assertEquals(2, errors.size(), errors.toString());
    for (ValidationMessage error : errors) {
      assertEquals(I18nConstants.SM_CONSTANT_TYPE_UNDETERMINED, error.getMessageId());
      assertEquals(IssueSeverity.INFORMATION, error.getLevel());
    }
  }

  @ParameterizedTest
  @MethodSource("validExpressions")
  void testConstantFhirTypesAreResolved(String version, String expression, String expectedType) {
    SimpleWorkerContext context = contexts.get(version);
    FHIRPathEngine engine = spy(new FHIRPathEngine(context));
    StructureMapValidator validator = newValidator(context, engine);
    List<ValidationMessage> errors = new ArrayList<>();

    assertTrue(validator.validateStructureMap(null, errors, constantMap(context, expression), new NodeStack(context)));
    assertTrue(errors.isEmpty(), errors.toString());

    ArgumentCaptor<StructureMapValidator.VariableSet> variables =
        ArgumentCaptor.forClass(StructureMapValidator.VariableSet.class);
    verify(engine, times(2)).check(variables.capture(),
        isNull(String.class), isNull(String.class), isNull(String.class), any(ExpressionNode.class));
    for (String name : List.of("first", "second")) {
      StructureMapValidator.VariableDefn constant = variables.getValue().getVariable(name);
      assertTrue(constant.hasTypeInfo(), name + " has no resolved type for " + expression);
      assertEquals(expectedType, constant.getType());
      assertEquals(expectedType, constant.getSd().getType());
    }
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
      assertEquals(IssueSeverity.ERROR, error.getLevel());
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
      assertEquals(IssueSeverity.ERROR, error.getLevel());
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
    Property nameProperty = new Property(context, new ElementDefinition().setPath("StructureMap.const.name"),
        context.fetchTypeDefinition("StructureMap"));
    Property valueProperty = new Property(context, new ElementDefinition().setPath("StructureMap.const.value"),
        context.fetchTypeDefinition("StructureMap"));
    for (String name : List.of("first", "second")) {
      Element constant = new Element("const", property, "BackboneElement", null);
      constant.getChildList().add(new Element("name", nameProperty, "id", name));
      constant.getChildList().add(new Element("value", valueProperty, "string", expression));
      map.getChildList().add(constant);
    }
    return map;
  }
}
