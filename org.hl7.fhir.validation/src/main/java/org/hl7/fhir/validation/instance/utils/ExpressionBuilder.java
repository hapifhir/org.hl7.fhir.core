package org.hl7.fhir.validation.instance.utils;

public class ExpressionBuilder {

  private final StringBuilder mBuilder;
  private boolean firstCoding = false;

  public ExpressionBuilder(String initial) {
    mBuilder = new StringBuilder(initial);
  }

  /**
   * Works similar to the {@link StringBuilder} class, with the exception that it will detect leading '(', closing
   * ')' characters, and will insert ' and ' keywords as required.
   * @param s {@link String} to append.
   */
  public ExpressionBuilder append(String s) {
    if (!firstCoding && (s.charAt(0) != ')')) {
      mBuilder.append(" and ");
    } else {
      firstCoding = false;
    }

    if (s.charAt(s.length() - 1) == '(') {
      firstCoding = true;
    }

    mBuilder.append(s);
    return this;
  }

  /**
   * Ignores any current tracked expression state, and appends the passed in {@link String} as is.
   * @param s {@link String} to append.
   */
  public void forceAppend(String s) {
    mBuilder.append(s);
  }

  /**
   * Returns {@link Boolean#TRUE} if the next appended {@link String} will be treated as a first coding.
   * @return
   */
  public Boolean isFirstCoding() {
    return firstCoding;
  }

  public String toString() {
    return mBuilder.toString();
  }
}
