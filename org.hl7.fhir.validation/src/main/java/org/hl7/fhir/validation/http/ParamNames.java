package org.hl7.fhir.validation.http;

/**
 * HTTP query parameter name constants for the {@code /validateResource} endpoint.
 * <p/>
 * Used by both the server-side handler and the HTTP client to ensure parameter
 * names are consistent and not duplicated as magic strings.
 */
public final class ParamNames  {
  private ParamNames() {
    /* This utility class should not be instantiated */
  }

  public static final String JURISDICTION = "jurisdiction";
  public static final String EXPANSION_PARAMETERS = "expansionParameters";
  public static final String HTML_OUTPUT = "htmlOutput";
  public static final String OUTPUT_STYLE = "outputStyle";
  public static final String R5_BUNDLE_RELATIVE_REFERENCE_POLICY = "r5BundleRelativeReferencePolicy";
  public static final String QUESTIONNAIRE_MODE = "questionnaire";
  public static final String LEVEL = "level";
  public static final String BEST_PRACTICE_LEVEL = "bestPractice";
  public static final String HTML_IN_MARKDOWN_CHECK = "htmlInMarkdown";
  public static final String CHECK_DISPLAY = "checkDisplay";
  public static final String RESOURCE_ID_RULE = "resourceIdRule";
  public static final String ASSUME_VALID_REST_REFERENCES = "assumeValidRestReferences";
  public static final String HINT_ABOUT_NON_MUST_SUPPORT = "hintAboutNonMustSupport";
  public static final String WANT_INVARIANTS_IN_MESSAGES = "wantInvariantsInMessages";
  public static final String NO_INVARIANTS = "noInvariants";
  public static final String UNKNOWN_CODE_SYSTEMS_CAUSE_ERRORS = "unknownCodeSystemsCauseErrors";
  public static final String FOR_PUBLICATION = "forPublication";
  public static final String NO_UNICODE_BI_DI_CONTROL_CHARS = "noUnicodeBidiControlChars";
  public static final String VERBOSE = "verbose";
  public static final String SHOW_MESSAGE_IDS = "showMessageIds";
  public static final String ALLOW_EXAMPLE_URLS = "allowExampleUrls";
  public static final String SHOW_MESSAGES_FROM_REFERENCES = "showReferenceMessages";
  public static final String SECURITY_CHECKS = "securityChecks";
  public static final String NO_EXPERIMENTAL_CONTENT = "noExperimentalContent";
  public static final String SHOW_TERMINOLOGY_ROUTING = "txRouting";
  public static final String DO_IMPLICIT_FHIR_PATH_STRING_CONVERSION = "implicitFhirpathStringConversions";
  public static final String ALLOW_DOUBLE_QUOTES_IN_FHIR_PATH = "allowDoubleQuotesInFhirpath";
  public static final String CHECK_IPS_CODES = "checkIpsCodes";
  public static final String MAX_VALIDATION_MESSAGES = "maxValidationMessages";
  public static final String VALIDATION_TIMEOUT = "validationTimeout";
  public static final String EXTENSION = "extension";
  public static final String PROFILE = "profile";
  public static final String BUNDLE_VALIDATION_RULE = "bundleValidationRule";
  public static final String BUNDLE_VALIDATION_PROFILE = "bundleValidationProfile";
}
