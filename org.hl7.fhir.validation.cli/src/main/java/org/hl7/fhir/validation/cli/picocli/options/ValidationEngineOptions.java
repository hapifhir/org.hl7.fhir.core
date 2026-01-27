package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.With;
import org.apache.commons.lang3.ArrayUtils;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.settings.FhirSettings;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@CommandLine.Command
@AllArgsConstructor
public class ValidationEngineOptions {

  static class CLIFHIRVersions extends ArrayList<String> {
    CLIFHIRVersions() { super(
      Arrays.stream(ArrayUtils.addAll(VersionUtilities.SUPPORTED_MAJOR_VERSIONS, VersionUtilities.SUPPORTED_VERSIONS)).toList()
    );
    }
  }

  @CommandLine.Option(names = {"-version"},
    completionCandidates = CLIFHIRVersions.class,
    description = """
    Version of FHIR.
    Valid values are: ${COMPLETION-CANDIDATES}
    Default is 5.0
    """)
  @With
  public String fhirVersion = null;

  @CommandLine.Option(names = {"-native"},
    description = """
    Use native validation:
     * XML: W3C schema+schematron
     * JSON: json.schema
     * RDF: SHEX
    """)
  @With
  public boolean doNative = false;

  @CommandLine.Option(names = {"-recurse"},
    description = "Look in subfolders when -ig refers to a folder")
  @With
  public boolean recursive = false;

  @CommandLine.Option(names = {"-clear-tx-cache"},
    description = "Clear the terminology cache before validation")
  @With
  public boolean clearTxCache = false;

  @CommandLine.Option(names = {"-check-references"},
    description = "Check references to other resources when validating")
  @With
  public boolean checkReferences = false;

  @CommandLine.Option(names = {"-no-internal-caching"},
    description = "Do not use internal caching during validation")
  @With
  public boolean noInternalCaching = false;

  @CommandLine.Option(names = {"-disable-default-resource-fetcher"},
    description = "Disable the default resource fetcher")
  @With
  public boolean disableDefaultResourceFetcher = false;

  @CommandLine.Option(names = {"-display-issues-are-warnings"},
    description = "Treat display validation issues as warnings")
  @With
  public boolean displayWarnings = false;

  @CommandLine.Option(names = {"-no-extensible-binding-warnings"},
    description = "Do not show warnings for extensible binding validations")
  @With
  public boolean noExtensibleBindingMessages = false;

  @CommandLine.Option(names = {"-show-times"},
    description = "Show timing information for validation operations")
  @With
  public boolean showTimes = false;

  @CommandLine.Option(names = {"-do-debug"},
    description = "Enable debug mode")
  @With
  public boolean doDebug = false;

  @CommandLine.Option(names = {"-sct"},
    description = """
    Specify the edition of SNOMED CT to use. Valid choices: intl | us | uk | au | nl | ca | se | dk | es
    tx.fhir.org only supports a subset. To add to this list or tx.fhir.org, ask on https://chat.fhir.org/#narrow/stream/179202-terminology
    """)
  @With
  public String snomedCT = "900000000000207008";

  @CommandLine.Option(names = {"-resolution-context"},
    description = "Resolution context for package resolution")
  @With
  public String resolutionContext = null;

  @CommandLine.Option(names = {"-ai-service"},
    description = """
    An AI service to use to inspect code/text pairs. Available options: claude, chatgpt, and ollama
     * claude: Anthropic's Claude-AI. You need to provide your own API key sourced from anthropic in the fhir-settings.json file using a header with the name 'x-api-key'
     * chatgpt: OpenAI's ChatGPT. You need to provide your own API key sourced from anthropic in the fhir-settings.json file using a standard token
     * ollama: Open Source Ollama. With ollama, you can choose where you host the service. If it's running locally on the default port, just use 'ollama'. If you are running locally on a different port, use 'ollama:{port}'. If the service is anywhere else, use 'ollama:{url}'. You can append #{model} to any of those if the model is different to llama3.2
    """)
  @With
  public String aiService = null;

  @CommandLine.Option(names = {"-tx"},
    description = """
    Terminology server URL. To run without terminology, specify 'n/a' as the URL
    By default 'http://tx.fhir.org' will be used.
    """)
  @With
  public String txServer = null;

  @CommandLine.Option(names = {"-txLog"},
    description = """
     Produce a log of the terminology server operations in [file]
     If not set, no log will be produced.
     """)
  @With
  public String txLog = null;

  @CommandLine.Option(names = {"-txCache"},
    description = """
    Path to a directory to be used to cache terminology server responses. The validator will attempt to create the folder if it needs to.
    To run without a terminology case, specify 'n/a' as the value
    """)
  @With
  public String txCache = null;

  @CommandLine.Option(names = {"-advisor-file"},
    description = "Path to advisor file (.json or .txt)")
  @With
  public String advisorFile = null;

  @CommandLine.Option(names = {"-language"},
    description = """
    The language to use when validating coding displays - same value as for xml:lang
    Not used if the resource specifies language
    Default: no specified language
    """)
  @With
  public String lang = null;

  @CommandLine.Option(names = {"-log"},
    description = "File path for map transformation log")
  @With
  public String mapLog = null;

  @CommandLine.Option(names = {"-ig", "-defn"},
    description = """
    [package|file|folder|url]: an IG or profile definition to load.
    Can be the URL of an implementation guide or a package ([id]-[ver]) for a built implementation guide or a local folder that contains a set of conformance resources.
    If you would like to load the latest unreleased version of the implementation guide or package, please define the version as '#current'.
    If no version is provided, the latest version in the package cache will be used, or if no such cached package is available, the PackageCacheManager will load the latest from the the online package repo.
    If you want the implementation guide to be loaded for a specific version of FHIR, you can prefix the IG with the appropriate version in square brackets ([[fhirVer]][id]-[igVer]).
    """,
    arity = "0..*")
  @With
  public List<String> igs = new ArrayList<>();

  @CommandLine.Option(names = {"-cert"},
    description = """
    A file that contains a public key, or a folder full of public keys to be used for validating digital signatures.
    Supports the formats jwks, PEM, and der
    """,
    arity = "1")
  @With
  public List<String> certSources = new ArrayList<>();

  @CommandLine.Option(names = {"-matchetype"},
    description = "File path for match type configuration",
    arity = "1")
  @With
  public List<String> matchetypes = new ArrayList<>();

  public ValidationEngineOptions() {
    // All public fields should be set in their declaration for Picocli purposes, so we do nothing here.
  }
}
