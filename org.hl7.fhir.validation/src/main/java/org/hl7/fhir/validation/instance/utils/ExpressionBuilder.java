package org.hl7.fhir.validation.instance.utils;

public class ExpressionBuilder {

  private final StringBuilder mBuilder;
  private boolean firstCoding = false;

  public ExpressionBuilder(String initial) {
    mBuilder = new StringBuilder(initial);
  }

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

  public void forceAppend(String s) {
    mBuilder.append(s);
  }

  public Boolean isFirstCoding() {
    return firstCoding;
  }

  public String toString() {
    return mBuilder.toString();
  }
}
