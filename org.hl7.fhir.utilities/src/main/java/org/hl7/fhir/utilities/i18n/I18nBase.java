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
  private ResourceBundle i18Nmessages;

  public Locale getLocale() {
    if (Objects.nonNull(locale)){
      return locale;
    } else {
      return Locale.US;
    }
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
    setValidationMessageLanguage(getLocale());
  }

  public String formatMessage(String theMessage, Object... theMessageArguments) {
    String message = theMessage;
    if (Objects.nonNull(i18Nmessages) && i18Nmessages.containsKey(theMessage)) {
      if (Objects.nonNull(theMessageArguments) && theMessageArguments.length > 0) {
        message = MessageFormat.format(i18Nmessages.getString(theMessage), theMessageArguments);
      } else {
        message = i18Nmessages.getString(theMessage);
      }
    }
    return message;
  }

  public void setValidationMessageLanguage(Locale locale) {
    i18Nmessages = ResourceBundle.getBundle("Messages", locale);
  }
}