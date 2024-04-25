package org.hl7.fhir.utilities.i18n;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.ibm.icu.text.PluralRules;


/**
 * Handles the locale, ResourceBundle and String formatting for i18n
 * This abstract class should be extended when implementing a IWorkerContext Interface.
 */
public abstract class I18nBase {

  public static final String PLURAL_SUFFIX = "PLURAL";
  public static final String KEY_DELIMITER = "_";
  protected Locale locale;
  private ResourceBundle messages;
  private PluralRules pluralRules;
  private boolean warnAboutMissingMessages = true;

  public Locale getLocale() {
    if (Objects.nonNull(locale)) {
      return locale;
    } else {
      return Locale.getDefault();
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
    if (messages == null) {
      setValidationMessageLanguage(getLocale());
    }
  }

  private void checkPluralRulesAreLoaded() {
    if (pluralRules == null) {
      setPluralRules(getLocale());
    }
  }

  /**
   * Checks the loaded {@link ResourceBundle} to see if the passed in message exists with the current loaded {@link Locale}.
   * If no {@link Locale} is currently loaded, it will load the {@link Locale} (default {@link Locale#US} is none is
   * specified), and search.
   * @param message The {@link String} message to search for within the current {@link Locale}
   * @return {@link Boolean#TRUE} if the message exists within the loaded {@link Locale}.
   */
  private boolean messageExistsForLocale(String message, boolean hasArgs) {
    checkResourceBundleIsLoaded();
    if (!messageKeyExistsForLocale(message)) {
      if (!message.contains(" ")) {
        if (warnAboutMissingMessages && (hasArgs || !message.contains(" "))) {
          System.out.println("Attempting to localize message " + message + ", but no such equivalent message exists for" +
              " the locale " + getLocale());
        }
      }
    }
    return messageKeyExistsForLocale(message);
  }

  protected boolean messageKeyExistsForLocale(String message) {
    return messages.containsKey(message);
  }


  /**
   * Formats the given message, if needed, with the passed in message arguments.
   * @param theMessage Base message to format.
   * @param theMessageArguments Placeholder arguments, if needed.
   * @return The formatted, internationalized, {@link String}
   */
  public String formatMessage(String theMessage, Object... theMessageArguments) {
    return formatMessageForLocale(theMessage, theMessageArguments);
  }

  protected String getPluralKey(Integer number, String baseKey) {
    return baseKey + KEY_DELIMITER + pluralRules.select(number);
  }

  protected Set<String> getPluralKeys(String baseKey) {
    return pluralRules
      .getKeywords().stream()
      .map(entry -> baseKey + KEY_DELIMITER + entry).collect(Collectors.toSet());
  }

  protected Set<String> getPluralSuffixes() {
    return Collections.unmodifiableSet(pluralRules.getKeywords());
  }
  
  protected String getRootKeyFromPlural(@Nonnull String pluralKey) {
    checkPluralRulesAreLoaded();
    for (String keyword : pluralRules
      .getKeywords()) {
        final String suffix = KEY_DELIMITER + keyword;
        if (pluralKey.endsWith(suffix)) {
          return pluralKey.substring(0, pluralKey.length() - suffix.length());
        }
    }
    return null;
  }
  private String formatMessageForLocale(String theMessage, Object... theMessageArguments) {
    String message = theMessage;
    if (messageExistsForLocale(theMessage, (theMessageArguments != null && theMessageArguments.length > 0))) {
      if (Objects.nonNull(theMessageArguments) && theMessageArguments.length > 0) {
        message = MessageFormat.format(messages.getString(theMessage).trim(), theMessageArguments);
      } else {
        message = messages.getString(theMessage).trim();
      }
    }
    return message;
  }

  /**
   * Formats the message with locale correct pluralization using the passed in
   * message arguments.
   *
   * In the message properties files, each plural specific message will have a
   * key consisting of a root key and a suffix denoting the plurality rule (_one
   * for singular, _other for multiple in English, for example). Suffixes are
   * provided by th ICU4J library from unicode.org
   *
   * @param plural The number that indicates the plurality of the phrase
   * @param theMessage the root key of the phrase.
   * @param theMessageArguments Placeholder arguments, if needed.
   * @return The formatted, internationalized, {@link String}
   */
  public String formatMessagePlural(Integer plural, String theMessage, Object... theMessageArguments) {

    Object[] args = new Object[theMessageArguments.length+1];
    args[0] = plural;
    for (int i = 0; i < theMessageArguments.length; i++) {
      args[i+1] = theMessageArguments[i];
    }
    checkPluralRulesAreLoaded();
    String pluralKey = getPluralKey(plural, theMessage);
    return formatMessageForLocale(pluralKey, args);
  }

  /**
   * Loads the corresponding {@link ResourceBundle} for the passed in {@link Locale}.
   * @param locale {@link Locale} to load resources for.
   */
  public void setValidationMessageLanguage(Locale locale) {
    messages = ResourceBundle.getBundle(getMessagesSourceFileName(), locale);
  }

  protected String getMessagesSourceFileName() {
    return "Messages";
  }

  public void setPluralRules(Locale locale) {
    pluralRules = PluralRules.forLocale(locale);
  }

  public boolean isWarnAboutMissingMessages() {
    return warnAboutMissingMessages;
  }

  public void setWarnAboutMissingMessages(boolean warnAboutMissingMessages) {
    this.warnAboutMissingMessages = warnAboutMissingMessages;
  }
  
  
}