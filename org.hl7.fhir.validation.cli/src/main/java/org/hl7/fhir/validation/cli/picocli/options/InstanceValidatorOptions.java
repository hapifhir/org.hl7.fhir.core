package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class InstanceValidatorOptions {
  @CommandLine.Option(names = {"-jurisdiction"},
    description = "Specifies the jurisdiction to validate in. If you want to use no specific jurisdiction, use the values 'uv' or 'global'")
  @With
  public String jurisdiction;

  @CommandLine.Option(names = {"-expansion-parameters"},
    description = "Specifies the expansion parameters to use - this can supply fixed versions for code systems and value sets")
  @With
  public String expansionParameters;

  @CommandLine.Option(names = {"-profile"},
    description = """
      A canonical URL to validate against (same as if it was specified in Resource.meta.profile). If no profile is specified, the resource is validated against the base specification. Multiple profiles can be used.
      Note: a profile (and it's dependencies) have to be made available through one of the -ig parameters. Package dependencies will automatically be resolved
      """,
    arity = "1")
  @With
  public List<String> profiles = new ArrayList<>();

  @CommandLine.Option(names = {"-profiles"},
    hidden = true,
    description = """
      Convenience argument for adding a comma-delimited list of profile URLs
      """,
    arity = "1")
  @With
  public List<String> compactProfiles = new ArrayList<>();

  // Boolean flags
  @CommandLine.Option(names = {"-assumeValidRestReferences"},
    description = "If present, assume that URLs that reference resources follow the RESTful URI pattern and it is safe to infer the type from the URL",
    arity = "0")
  @With
  public boolean assumeValidRestReferences = false;

  @CommandLine.Option(names = {"-hintAboutNonMustSupport"},
    description = "If present, raise hints if the instance contains data elements that are not marked as mustSupport=true. Useful to identify elements included that may be ignored by recipients",
    arity = "0")
  @With
  public boolean hintAboutNonMustSupport = false;

  @CommandLine.Option(names = {"-want-invariants-in-messages"},
    description = "Controls whether the FHIRPath for invariants is included in the message",
    arity = "0")
  @With
  public boolean wantInvariantsInMessages = false;

  @CommandLine.Option(names = {"-no-invariants"},
    description = "Tell the validator to ignore all invariants",
    arity = "0")
  @With
  public boolean noInvariants = false;

  @CommandLine.Option(names = {"-unknown-codesystems-cause-errors"},
    description = "If present, unknown code systems associated with required bindings will create an error not a warning",
    arity = "0")
  @With
  public boolean unknownCodeSystemsCauseErrors = false;

  @CommandLine.Option(names = {"-forPublication"},
    description = "Setting this flag means that the validator automatically checks conformance with the Shareable* profiles",
    arity = "0")
  @With
  public boolean forPublication = false;

  @CommandLine.Option(names = {"-no_unicode_bidi_control_chars"},
    description = "Make the validator produce an error for any BiDi control characters",
    arity = "0")
  @With
  public boolean noUnicodeBiDiControlChars = false;

  @CommandLine.Option(names = {"-verbose"},
    description = "When set, the validator will create hints against the resources to explain which profiles it has validated the resource against",
    arity = "0")
  @With
  public boolean verbose = false;

  @CommandLine.Option(names = {"-show-message-ids"},
    description = "Show message IDs in the validation output",
    arity = "0")
  @With
  public boolean showMessageIds = false;

  @CommandLine.Option(names = {"-allow-example-urls"},
    description = "Allow references to example.org URLs in resources to be treated as valid",
    arity = "0..1")
  @With
  public boolean allowExampleUrls = false;

  @CommandLine.Option(names = {"-showReferenceMessages"},
    description = """
    Includes validation messages resulting from validating target resources against profiles defined on a reference
    This increases the volume of validation messages, but may allow easier debugging.  If not specified, then only a high-level message indicating that the referenced item wasn't valid against the listed profile(s) will be provided.
    """,
    arity = "0")
  @With
  public boolean showMessagesFromReferences = false;

  @CommandLine.Option(names = {"-security-checks"},
    description = """
    If present, check that string content doesn't include any html-like tags that might create problems downstream
    Note that all external input must always be sanitized by escaping for either html or sql.
    """,
    arity = "0")
  @With
  public boolean securityChecks = false;

  @CommandLine.Option(names = {"-no-experimental-content"},
    description = "Reject experimental content in validation",
    arity = "0")
  @With
  public boolean noExperimentalContent = false;

  @CommandLine.Option(names = {"-tx-routing"},
    description = "Generate extra output that summarizes which terminology server was used for a particular validation",
    arity = "0")
  @With
  public boolean showTerminologyRouting = false;

  @CommandLine.Option(names = {"-implicit-fhirpath-string-conversions"},
    description = "Restore pre-5.6.48 FHIRPath behavior regarding automatic string conversions",
    arity = "0")
  @With
  public boolean doImplicitFHIRPathStringConversion = false;

  @CommandLine.Option(names = {"-allow-double-quotes-in-fhirpath"},
    description = "Support legacy FHIRPath statements that include double quotes: \"\"",
    arity = "0")
  @With
  public boolean allowDoubleQuotesInFHIRPath = false;

  @CommandLine.Option(names = {"-check-ips-codes"},
    description = "Report SNOMED CT codes not part of the IPS free set",
    arity = "0")
  @With
  public boolean checkIPSCodes = false;

  // String fields
  @CommandLine.Option(names = {"-html-output"},
    description = "A filename for the HTML presentation of the outcomes of the validation")
  @With
  public String htmlOutput;

  @CommandLine.Option(names = {"-output-style"},
    description = "Output style format (eslint-compact, csv, xml, json, compact, compact-split)")
  @With
  public String outputStyle;

  // Enum fields
  @CommandLine.Option(names = {"-r5-bundle-relative-reference-policy"},
    description = """
  Control R5 bundle resolution policy (always, never, default)
      * always - always apply the rule irrespective of version
      * never - never apply this rule irrespective of version
      * default - the default behaviour: apply this rule in R5 and later
  """)
  @With
  public String r5BundleRelativeReferencePolicy;

  @CommandLine.Option(names = {"-questionnaire"},
    description = """
    What to do when validating QuestionnaireResponse resources (none, check, required)
       * none (default): just ignore the questionnaire reference
       * required: check that the QuestionnaireResponse has a questionnaire and
         validate against it
       * check: if the QuestionnaireResponse has a questionnaire, validate
         against it
    The questionnaire must be loaded using the -ig parameter which specifies the location of a questionnaire. If provided, then the validator will validate any QuestionnaireResponse that claims to match the Questionnaire against it no default value.
    """,
    arity="1"
  )
  @With
  public String questionnaireMode = null;

  @CommandLine.Option(names = {"-level"},
    description = "Minimum level for validation messages (hints, warnings, errors)")
  @With
  public String level = null;

  @CommandLine.Option(names = {"-best-practice"},
    description = """
      How to treat best practice constraints (ignore, hint, warning, error)
      Default is warning
    """)
  @With
  public String bestPracticeLevel = null;

  @CommandLine.Option(names = {"-html-in-markdown"},
    description = "Issue level reported for embedded HTML in resource markdown (ignore, warning, error)")
  @With
  public String htmlInMarkdownCheck = null;

  // List fields
  @CommandLine.Option(names = {"-extension"},
    description = "URL domain from which extensions will be allowed, or 'any' for all. Can repeat multiple times.",
    arity = "1")
  @With
  public List<String> extensions = new ArrayList<>();

  @CommandLine.Option(names = {"-bundle"},
    description = """
      Validate a specific resource in a bundle against a profile. This option accepts two arguments: -bundle <rule> <profile>
      * <rule> either a Resource name, a integer index, or both
      * <profile> the canonical URL of the profile
      """,
    arity = "2")
  @With
  public List<String> bundleValidationRules = null;

  @CommandLine.Option(names = {"-validation-timeout"},
    description = "A value in milliseconds after which validation will be stopped. Any issues encountered at this point will be returned, but may not be completely accurate.",
    arity = "1")
  @With
  public Long validationTimeout = 0L;

  // Created by claude-sonnet-4-6
  @CommandLine.Option(names = {"-check-display"},
    description = """
      How to validate the display text on coded elements (Coding, CodeableConcept).
                 * Ignore (default): display text is not checked
                 * Check: display must exactly match the code system's canonical text
                 * CheckCase: match ignoring case differences
                 * CheckSpace: match ignoring whitespace differences
                 * CheckCaseAndSpace: match ignoring both case and whitespace differences
    """,
    arity = "1")
  @With
  public String checkDisplay = null;

  // Created by claude-sonnet-4-6
  @CommandLine.Option(names = {"-resource-id-rule"},
    description = """
      Whether the top-level resource being validated must have a Resource.id element (optional,
              required, prohibited).
                 * optional (default): id may be present or absent
                 * required: id must be present; an error is raised if missing
                 * prohibited: id must not be present; an error is raised if found
              Note: this rule applies to the outermost resource only. The validator independently enforces id
              rules for contained resources (always required) and bundle entries/parameters (always optional).
    """,
    arity = "1")
  @With
  public String resourceIdRule = null;
}
