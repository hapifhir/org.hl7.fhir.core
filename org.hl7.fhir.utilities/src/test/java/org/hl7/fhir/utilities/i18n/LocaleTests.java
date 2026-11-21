package org.hl7.fhir.utilities.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LocaleTests {

  @Test
  public void testSimple() {
    Locale l = new Locale("en");
    Assertions.assertEquals("en", l.getLanguage());
  }

  @Test
  public void testSimple2() {
    Locale l = new Locale("*");
    Assertions.assertEquals("*", l.getLanguage());
  }

  @Test
  public void testSimpleX() {
    Locale l = new Locale("xx");
    Assertions.assertEquals("xx", l.getLanguage());
  }
}
