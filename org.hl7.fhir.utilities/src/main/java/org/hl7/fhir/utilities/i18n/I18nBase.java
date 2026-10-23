package org.hl7.fhir.utilities.i18n;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
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

  public static final Map<Locale, Set<String>> uncontainedKeys = new ConcurrentHashMap<>();

  /**
   * The locale, and its messages and plural rules once a lookup has loaded them. An instance can be
   * shared across threads, so these are replaced together, and each lookup reads them once.
   */
  private record LocaleState(Locale locale, ResourceBundle messages, PluralRules pluralRules, long generation) {}

  private final AtomicReference<LocaleState> state = new AtomicReference<>();
  private boolean warnAboutMissingMessages = true;
  private static final Set<String> warnedLocales = ConcurrentHashMap.newKeySet();
  private static boolean useMessageIdsDirectly;

  /**
   * Optional override for resource-bundle lookup. When non-null, every bundle this
   * class loads goes through this Control. Used by {@code RuntimePOLoader} to inject
   * editor-supplied .po translations at runtime without rebuilding the jar. The Control
   * is responsible for falling back to default loading for bundles it doesn't override.
   * Its {@link ResourceBundle.Control#getFallbackLocale} is effectively ignored: a bundle
   * that isn't one of the requested locale's candidates (such as the JVM default locale's)
   * is replaced by the root bundle (see {@link #loadBundle(Locale)}).
   */
  private static volatile ResourceBundle.Control overlayControl;

  /**
   * Incremented every time {@link #setOverlayControl(ResourceBundle.Control)} is called.
   * Existing {@link I18nBase} instances compare the generation of their loaded state
   * against this on the next lookup and reload if it has changed — so the overlay
   * is picked up even by instances created before it was registered.
   */
  private static volatile long overlayGeneration = 0;

  private static final ResourceBundle.Control DEFAULT_CONTROL =
      ResourceBundle.Control.getControl(ResourceBundle.Control.FORMAT_DEFAULT);

  /**
   * Install (or clear, by passing null) a resource-bundle overlay. Clears the
   * JDK's ResourceBundle cache and bumps the generation counter so existing
   * I18nBase instances re-resolve their bundles on the next lookup.
   */
  public static void setOverlayControl(ResourceBundle.Control control) {
    overlayControl = control;
    overlayGeneration++;
    ResourceBundle.clearCache();
  }

  public static ResourceBundle.Control getOverlayControl() {
    return overlayControl;
  }


  public Locale getLocale() {
    return requestedState().locale();
  }

  public void setLocale(Locale locale) {
    // only the locale changes here: the next lookup loads what it needs
    LocaleState current = state.get();
    if (locale == null || current == null || !current.locale().equals(locale)) {
      state.set(locale == null ? null : new LocaleState(locale, null, null, 0));
    }
  }

  private LocaleState requestedState() {
    LocaleState current = state.get();
    if (current == null) {
      // through setLocale(), so that subclass overrides see the default locale, as they did before
      setLocale(Locale.getDefault());
      current = state.get();
    }
    return current != null ? current : new LocaleState(Locale.getDefault(), null, null, 0);
  }

  private LocaleState loadedState() {
    LocaleState current = requestedState();
    if (current.messages() != null && current.generation() == overlayGeneration) {
      return current;
    }
    LocaleState loaded = loadState(current.locale());
    warnIfUnknownLocale(loaded.locale(), loaded.messages());
    // if setLocale() ran during the load, the loaded state is still used for this lookup
    state.compareAndSet(current, loaded);
    return loaded;
  }

  private LocaleState loadState(Locale locale) {
    // read the generation first, so an overlay installed during the load causes another reload
    long generation = overlayGeneration;
    ResourceBundle messages = loadBundle(locale);
    Locale bundleLocale = messages.getLocale();
    PluralRules pluralRules = PluralRules.forLocale(Locale.ROOT.equals(bundleLocale) ? Locale.US : bundleLocale);
    return new LocaleState(locale, messages, pluralRules, generation);
  }

  private void warnIfUnknownLocale(@Nonnull Locale locale, @Nonnull ResourceBundle bundle) {
    if (Locale.ROOT.equals(bundle.getLocale())) {
      if (!locale.getLanguage().equals("en")) {
        if (warnedLocales.add(locale.toLanguageTag())) {
          logUncontainedMessage("The locale " + locale.toLanguageTag() + " is not supported. Messages will default to en-US.");
        }
      }
    }
  }

  protected ResourceBundle getMessages() {
    return loadedState().messages();
  }

  protected PluralRules getPluralRules() {
    return loadedState().pluralRules();
  }
  /**
   * Checks the loaded {@link ResourceBundle} to see if the passed in message exists for its {@link Locale}.
   * @param current The state to search, taken once by the caller so the check and the read use the same bundle
   * @param message The {@link String} message to search for within the current {@link Locale}
   * @return {@link Boolean#TRUE} if the message exists within the loaded {@link Locale}.
   */
  private boolean messageExistsForLocale(LocaleState current, String message, boolean hasArgs) {
    boolean exists = current.messages().containsKey(message);
    if (!exists) {
      if (!message.contains(" ")) {
        if (warnAboutMissingMessages && (hasArgs || !message.contains(" "))) {
          Set<String> uncontainedKeys = I18nBase.uncontainedKeys.computeIfAbsent(current.locale(), k -> ConcurrentHashMap.newKeySet());
          if (uncontainedKeys.add(message)) {
            logUncontainedMessage("Attempting to localize " + typeOfString() + " " + message + ", but no such equivalent message exists for" +
              " the locale " + current.locale());
          }
        }
      }
    }
    return exists;
  }

  protected void logUncontainedMessage(String message) {
    log.warn(message);
  }

  protected String typeOfString() {
    return "message";
  }

  protected boolean messageKeyExistsForLocale(String message) {
    return getMessages().containsKey(message);
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
    return baseKey + KEY_DELIMITER + getPluralRules().select(number);
  }

  protected Set<String> getPluralKeys(String baseKey) {
    return getPluralRules()
      .getKeywords().stream()
      .map(entry -> baseKey + KEY_DELIMITER + entry).collect(Collectors.toSet());
  }


  protected Set<String> getPluralSuffixes() {
    return Collections.unmodifiableSet(getPluralRules().getKeywords());
  }
  
  protected String getRootKeyFromPlural(@Nonnull String pluralKey) {
    for (String keyword : getPluralRules()
      .getKeywords()) {
        final String suffix = KEY_DELIMITER + keyword;
        if (pluralKey.endsWith(suffix)) {
          return pluralKey.substring(0, pluralKey.length() - suffix.length());
        }
    }
    return null;
  }
  private String formatMessageForLocale(String theMessage, Object... theMessageArguments) {
    if (useMessageIdsDirectly) {
      return theMessage;
    }
    String message = theMessage;
    LocaleState current = loadedState();
    ResourceBundle bundle = current.messages();
    if (messageExistsForLocale(current, theMessage, (theMessageArguments != null && theMessageArguments.length > 0))) {
      if (Objects.nonNull(theMessageArguments) && theMessageArguments.length > 0) {
        message = MessageFormat.format(bundle.getString(theMessage).trim(), theMessageArguments);
      } else {
        message = MessageFormat.format(bundle.getString(theMessage).trim(), (Object) null);
      }
    }
    return message;
  }

  /**
   * Formats the message with locale correct pluralization using the passed in
   * message arguments.
   * </br>
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
    if (useMessageIdsDirectly) {
      return theMessage;
    }
    Object[] args = new Object[theMessageArguments.length+1];
    args[0] = plural;
    for (int i = 0; i < theMessageArguments.length; i++) {
      args[i+1] = theMessageArguments[i];
    }
    String pluralKey = getPluralKey(plural, theMessage);
    return formatMessageForLocale(pluralKey, args);
  }

  /**
   * Loads the corresponding {@link ResourceBundle} for the passed in {@link Locale}, which
   * {@link #getLocale()} then returns. Unlike {@link #setLocale(Locale)}, subclass overrides of
   * that method (e.g. ones that also change the terminology display language) are not invoked.
   * @param locale {@link Locale} to load resources for.
   */
  @Deprecated
  public void setValidationMessageLanguage(Locale locale) {
    // load first, so a failed load leaves the current locale and messages in place
    state.set(loadState(locale));
  }

  /**
   * {@link ResourceBundle#getBundle} falls back to {@link Locale#getDefault()} before the root
   * bundle, so a locale without its own bundle (including "en", whose text lives in the root
   * bundle) would get the JVM default locale's translations instead of English. Detect that and
   * load the root bundle instead.
   * <p>
   * This doesn't use {@link ResourceBundle.Control#getNoFallbackControl} because
   * {@code getBundle(..., Control)} throws when called from a named module, including the
   * automatic module this jar becomes on the module path. (Installing an overlay Control
   * still requires that overload.)
   */
  private ResourceBundle loadBundle(Locale locale) {
    String baseName = getMessagesSourceFileName();
    ResourceBundle.Control control = overlayControl;
    ResourceBundle bundle = getBundle(baseName, locale, control);
    List<Locale> candidates = (control != null ? control : DEFAULT_CONTROL).getCandidateLocales(baseName, locale);
    if (!candidates.contains(bundle.getLocale())) {
      bundle = getBundle(baseName, Locale.ROOT, control);
    }
    return bundle;
  }

  private static ResourceBundle getBundle(String baseName, Locale locale, ResourceBundle.Control control) {
    return control != null
        ? ResourceBundle.getBundle(baseName, locale, control)
        : ResourceBundle.getBundle(baseName, locale);
  }

  protected String getMessagesSourceFileName() {
    return "Messages";
  }

  public boolean isWarnAboutMissingMessages() {
    return warnAboutMissingMessages;
  }

  public void setWarnAboutMissingMessages(boolean warnAboutMissingMessages) {
    this.warnAboutMissingMessages = warnAboutMissingMessages;
  }

  public static boolean isUseMessageIdsDirectly() {
    return useMessageIdsDirectly;
  }

  public static void setUseMessageIdsDirectly(boolean useMessageIdsDirectly) {
    I18nBase.useMessageIdsDirectly = useMessageIdsDirectly;
  }
}