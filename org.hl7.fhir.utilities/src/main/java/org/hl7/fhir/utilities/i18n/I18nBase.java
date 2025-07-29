package org.hl7.fhir.utilities.i18n;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.ibm.icu.text.PluralRules;
import lombok.extern.slf4j.Slf4j;


/**
 * Handles the locale, ResourceBundle and String formatting for i18n
 * This abstract class should be extended when implementing a IWorkerContext Interface.
 */
@Slf4j
public abstract class I18nBase {

  public static final String KEY_DELIMITER = "_";

  public static final Map<Locale, Set<String>> uncontainedKeys = new HashMap<>();

  private Locale locale = null;
  private ResourceBundle messages = null;
  private PluralRules pluralRules = null;
  private boolean warnAboutMissingMessages = true;
  private static Set<String> warnedLocales;


  public Locale getLocale() {
    if (Objects.nonNull(locale)) {
      return locale;
    } else {
      setLocale(Locale.getDefault());
      return locale;
    }
  }

  public void setLocale(Locale locale) {
    this.locale = locale;
    // Set the following to null. They will lazy-load when needed.
    this.messages = null;
    this.pluralRules = null;
  }

  /**
   * Verifies if a {@link ResourceBundle} has been loaded for the current {@link Locale}. If not, it triggers a load.
   */
  private void checkResourceBundleIsLoaded() {
    if (messages == null) {
      Locale locale = getLocale();
      messages = ResourceBundle.getBundle(getMessagesSourceFileName(), locale);
      warnIfUnknownLocale(locale);
    }
  }

  private void warnIfUnknownLocale(@Nonnull Locale locale) {
    if (Locale.ROOT == messages.getLocale()) {
      if (!locale.getLanguage().equals("en")) {
        if (warnedLocales == null) {
          warnedLocales = new HashSet<String>();
        }
        if (!warnedLocales.contains(locale.toLanguageTag())) {
          logUncontainedMessage("The locale " + locale.toLanguageTag() + " is not supported. Messages will default to en-US.");
          warnedLocales.add(locale.toLanguageTag());
        }
      }
    }
  }

  protected ResourceBundle getMessages() {
    checkResourceBundleIsLoaded();

    return messages;
  }

  private void checkPluralRulesAreLoaded() {
    if (pluralRules == null) {
      setPluralRules(getMessages().getLocale());
    }
  }

  protected PluralRules getPluralRules() {
    checkPluralRulesAreLoaded();
    return pluralRules;
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
          Set<String> uncontainedKeys = I18nBase.uncontainedKeys.computeIfAbsent(getLocale(), k -> new HashSet<>());
          if (!uncontainedKeys.contains(message)) {
            logUncontainedMessage("Attempting to localize " + typeOfString() + " " + message + ", but no such equivalent message exists for" +
              " the locale " + getLocale());
            uncontainedKeys.add(message);
          }
        }
      }
    }
    return messageKeyExistsForLocale(message);
  }

  protected void logUncontainedMessage(String message) {
    log.warn(message);
  }

  protected String typeOfString() {
    return "message";
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
    return Collections.unmodifiableSet(getPluralRules().getKeywords());
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
        message = MessageFormat.format(messages.getString(theMessage).trim(), (Object) null);
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
  @Deprecated
  public void setValidationMessageLanguage(Locale locale) {
    messages = ResourceBundle.getBundle(getMessagesSourceFileName(), locale);
    this.pluralRules = null;
  }

  protected String getMessagesSourceFileName() {
    return "Messages";
  }

  private void setPluralRules(Locale locale) {
    if (Locale.ROOT == locale) {
      pluralRules = PluralRules.forLocale(Locale.US);
    } else {
      pluralRules = PluralRules.forLocale(locale);
    }
  }

  public boolean isWarnAboutMissingMessages() {
    return warnAboutMissingMessages;
  }

  public void setWarnAboutMissingMessages(boolean warnAboutMissingMessages) {
    this.warnAboutMissingMessages = warnAboutMissingMessages;
  }
  
  
}