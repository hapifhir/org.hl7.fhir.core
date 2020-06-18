package org.hl7.fhir.utilities.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * Handles the locale, ResourceBundle and String formatting for i18n
 * This abstract class should be extended when implementing a IWorkerContext Interface.
 */
public abstract class I18nBase {

  private Locale locale;
  private ResourceBundle i18nMessages;

  public Locale getLocale() {
    if (Objects.nonNull(locale)) {
      return locale;
    } else {
      return Locale.US;
    }
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
    setValidationMessageLanguage(getLocale());
  }

  /**
   * Verifies if a {@link ResourceBundle} has been loaded for the current {@link Locale}. If not, it triggers a load.
   */
  private void checkResourceBundleIsLoaded() {
    if (i18nMessages == null) {
      setValidationMessageLanguage(getLocale());
    }
  }

  /**
   * Checks the loaded {@link ResourceBundle} to see if the passed in message exists with the current loaded {@link Locale}.
   * If no {@link Locale} is currently loaded, it will load the {@link Locale} (default {@link Locale#US} is none is
   * specified), and search.
   * @param message The {@link String} message to search for within the current {@link Locale}
   * @return {@link Boolean#TRUE} if the message exists within the loaded {@link Locale}.
   */
  private boolean messageExistsForLocale(String message) {
    checkResourceBundleIsLoaded();
    if (!i18nMessages.containsKey(message)) {
      System.out.println("Attempting to localize message " + message + ", but no such equivalent message exists for" +
        " the local " + getLocale());
    }
    return i18nMessages.containsKey(message);
  }

  /**
   * Formats the given message, if needed, with the passed in message arguments.
   * @param theMessage Base message to format.
   * @param theMessageArguments Placeholder arguments, if needed.
   * @return The formatted, internationalized, {@link String}
   */
  public String formatMessage(String theMessage, Object... theMessageArguments) {
    String message = theMessage;
    if (messageExistsForLocale(theMessage)) {
      if (Objects.nonNull(theMessageArguments) && theMessageArguments.length > 0) {
        message = MessageFormat.format(i18nMessages.getString(theMessage), theMessageArguments);
      } else {
        message = i18nMessages.getString(theMessage);
      }
    }
    return message;
  }

  /**
   * Loads the corresponding {@link ResourceBundle} for the passed in {@link Locale}.
   * @param locale {@link Locale} to load resources for.
   */
  public void setValidationMessageLanguage(Locale locale) {
    i18nMessages = ResourceBundle.getBundle("Messages", locale);
  }
}