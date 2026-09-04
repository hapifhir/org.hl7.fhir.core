package org.hl7.fhir.model.utilities.formats;

public enum OutputStyle {
  /**
   * Produce normal output - no whitespace, except in HTML where whitespace is untouched
   */
  NORMAL,

  /**
   * Produce pretty output - human readable whitespace, HTML whitespace untouched
   */
  PRETTY,

  /**
   * Produce canonical output - no comments, no whitspace, HTML whitespace normlised, JSON attributes sorted alphabetically (slightly slower)
   */
  CANONICAL,
}
