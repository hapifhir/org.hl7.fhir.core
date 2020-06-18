package org.hl7.fhir.utilities.i18n;

import org.hl7.fhir.exceptions.i18nException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

class I18nBaseTest {

  public static final String ARG_1 = "test arg";

  @Test
  @DisplayName("Test argument substitution with initializing Locale.")
  void testFormatMessageWithInitLocale() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.GERMAN);
    testClass.setLocale(Locale.GERMAN);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
    Object[] testArgs = {ARG_1};
    Assertions.assertEquals(form.format(testArgs), result);
  }

  @Test
  @DisplayName("Test argument substitution without initializing Locale.")
  void testFormatMessageWithoutInitLocale() {
    I18nTestClass testClass = new I18nTestClass();
    ResourceBundle loadedBundle = ResourceBundle.getBundle("Messages", Locale.US);
    String result = testClass.formatMessage(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES, ARG_1);
    MessageFormat form = new MessageFormat(loadedBundle.getString(I18nConstants.BUNDLE_BUNDLE_MULTIPLEMATCHES));
    Object[] testArgs = {ARG_1};
    Assertions.assertEquals(form.format(testArgs), result);
  }

  @Test
  @DisplayName("Assert i18nException is thrown for non-existent String.")
  void testFormatMessageForNonExistentMessage() {
    I18nTestClass testClass = new I18nTestClass();
    Assertions.assertThrows(i18nException.class, () -> testClass.formatMessage("THIS_DOES_NOT_EXIST", ARG_1));
  }

}