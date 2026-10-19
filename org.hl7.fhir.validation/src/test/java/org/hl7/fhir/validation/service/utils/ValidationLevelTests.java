package org.hl7.fhir.validation.service.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidationLevelTests {

  static Stream<Arguments> codes() {
    return Stream.of(
      Arguments.of(null, ValidationLevel.HINTS),
      Arguments.of("", ValidationLevel.HINTS),
      Arguments.of("hints", ValidationLevel.HINTS),
      Arguments.of("info", ValidationLevel.HINTS),
      Arguments.of("w", ValidationLevel.WARNINGS),
      Arguments.of("warning", ValidationLevel.WARNINGS),
      Arguments.of("Warnings", ValidationLevel.WARNINGS),
      Arguments.of("e", ValidationLevel.ERRORS),
      Arguments.of("error", ValidationLevel.ERRORS),
      Arguments.of("ERRORS", ValidationLevel.ERRORS)
    );
  }

  @ParameterizedTest
  @MethodSource("codes")
  void testFromCode(String code, ValidationLevel expected) {
    assertEquals(expected, ValidationLevel.fromCode(code));
  }

  static Stream<Arguments> inclusions() {
    return Stream.of(
      Arguments.of(null, IssueSeverity.INFORMATION, true),
      Arguments.of(ValidationLevel.HINTS, IssueSeverity.INFORMATION, true),
      Arguments.of(ValidationLevel.HINTS, IssueSeverity.WARNING, true),
      Arguments.of(ValidationLevel.HINTS, IssueSeverity.ERROR, true),
      Arguments.of(ValidationLevel.WARNINGS, IssueSeverity.INFORMATION, false),
      Arguments.of(ValidationLevel.WARNINGS, IssueSeverity.WARNING, true),
      Arguments.of(ValidationLevel.WARNINGS, IssueSeverity.ERROR, true),
      Arguments.of(ValidationLevel.WARNINGS, IssueSeverity.FATAL, true),
      Arguments.of(ValidationLevel.ERRORS, IssueSeverity.INFORMATION, false),
      Arguments.of(ValidationLevel.ERRORS, IssueSeverity.WARNING, false),
      Arguments.of(ValidationLevel.ERRORS, IssueSeverity.ERROR, true),
      Arguments.of(ValidationLevel.ERRORS, IssueSeverity.FATAL, true),
      Arguments.of(ValidationLevel.ERRORS, IssueSeverity.NULL, true)
    );
  }

  @ParameterizedTest
  @MethodSource("inclusions")
  void testIncludes(ValidationLevel level, IssueSeverity severity, boolean expected) {
    assertEquals(expected, ValidationLevel.includes(level, severity));
  }

  private static List<ValidationMessage> messages() {
    List<ValidationMessage> list = new ArrayList<>();
    for (IssueSeverity s : new IssueSeverity[] {IssueSeverity.FATAL, IssueSeverity.ERROR, IssueSeverity.WARNING, IssueSeverity.INFORMATION}) {
      // terminology engine messages are the ones that used to bypass the level
      list.add(new ValidationMessage(Source.TerminologyEngine, IssueType.CODEINVALID, "Patient.gender", "msg " + s.toCode(), s));
    }
    return list;
  }

  @Test
  void testFilterErrors() {
    List<ValidationMessage> list = messages();
    ValidationLevel.removeMessagesBelowLevel(list, ValidationLevel.ERRORS);
    assertEquals(2, list.size());
    assertTrue(list.stream().allMatch(vm -> vm.getLevel().isError()));
  }

  @Test
  void testFilterWarnings() {
    List<ValidationMessage> list = messages();
    ValidationLevel.removeMessagesBelowLevel(list, ValidationLevel.WARNINGS);
    assertEquals(3, list.size());
    assertFalse(list.stream().anyMatch(vm -> vm.getLevel() == IssueSeverity.INFORMATION));
  }

  @Test
  void testFilterHintsAndNull() {
    List<ValidationMessage> list = messages();
    ValidationLevel.removeMessagesBelowLevel(list, ValidationLevel.HINTS);
    assertEquals(4, list.size());
    ValidationLevel.removeMessagesBelowLevel(list, null);
    assertEquals(4, list.size());
  }
}
