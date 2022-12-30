package org.hl7.fhir.validation.cli.model;

import org.hl7.fhir.utilities.Utilities;

public enum HtmlInMarkdownCheck {
  NONE,
  WARNING, 
  ERROR;

  public static boolean isValidCode(String q) {
    return fromCode(q) != null;
  }

  public static HtmlInMarkdownCheck fromCode(String q) {
    if (Utilities.noString(q)) {
      return null;
    }
    q = q.toLowerCase();
    if (Utilities.existsInList(q, "n", "none", "ignore", "i")) {
      return NONE;
    }
    if (Utilities.existsInList(q, "w", "warning", "warnings", "warn")) {
      return WARNING;
    }
    if (Utilities.existsInList(q, "e", "error", "errors", "err")) {
      return ERROR;
    }
    return null;
  }
}
