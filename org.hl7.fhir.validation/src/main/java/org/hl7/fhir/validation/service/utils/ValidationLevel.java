package org.hl7.fhir.validation.service.utils;

import java.util.List;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;

public enum ValidationLevel {
  HINTS,
  WARNINGS,
  ERRORS;

  public static ValidationLevel fromCode(String v) {
    if (Utilities.noString(v)) {
      return HINTS;
    }
    v = v.toLowerCase();
    if (Utilities.existsInList(v, "h", "i", "hints", "info")) {
      return HINTS;
    }
    if (Utilities.existsInList(v, "w", "warning", "warnings")) {
      return WARNINGS;
    }
    if (Utilities.existsInList(v, "e", "error", "errors")) {
      return ERRORS;
    }
    return HINTS;
  }

  /**
   * @param level the minimum level wanted (null means everything)
   * @param severity the severity of a message
   * @return true if a message of the given severity should be reported at this level
   */
  public static boolean includes(ValidationLevel level, IssueSeverity severity) {
    if (level == null || level == HINTS || severity == null) {
      return true;
    }
    switch (severity) {
      case FATAL:
      case ERROR:
        return true;
      case WARNING:
        return level == WARNINGS;
      case INFORMATION:
        return false;
      default:
        return true;
    }
  }

  /**
   * Remove any messages below the requested level. Most rules check the level
   * before generating a message, but some messages (e.g. issues returned by the
   * terminology server) don't go through those checks, so this is applied to
   * the final list of messages.
   */
  public static void removeMessagesBelowLevel(List<ValidationMessage> messages, ValidationLevel level) {
    if (messages != null && level != null && level != HINTS) {
      messages.removeIf(vm -> !includes(level, vm.getLevel()));
    }
  }
}
