package org.hl7.fhir.validation.cli.utils;

import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;

import java.io.IOException;

/**
 * Class for displaying output to the cli user.
 *
 * TODO - Clean this up for localization
 */
public class Display {

  public static void printCliArgumentsAndInfo(String[] args) throws IOException {
    System.out.print("Arguments:");
    for (String s : args) {
      System.out.print(s.contains(" ") ? " \"" + s + "\"" : " " + s);
    }
    System.out.println();
    System.out.println("Directories: Current = " + System.getProperty("user.dir") + ", Package Cache = " + new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION).getFolder());
  }

  public static void displayHelpDetails() {
    System.out.println("");
    System.out.println("The FHIR validation tool validates a FHIR resource or bundle.");
    System.out.println("The validation tool compares a resource against the base definitions and any");
    System.out.println("profiles declared in the resource (Resource.meta.profile) or specified on the ");
    System.out.println("command line");
    System.out.println("");
    System.out.println("The FHIR validation tool validates a FHIR resource or bundle.");
    System.out.println("Schema and schematron checking is performed, then some additional checks are performed. ");
    System.out.println("* XML & Json (FHIR versions 1.0, 1.4, 3.0, 4.0, " + Constants.VERSION_MM + ")");
    System.out.println("* Turtle (FHIR versions 3.0, 4.0, " + Constants.VERSION_MM + ")");
    System.out.println("");
    System.out.println("If requested, instances will also be verified against the appropriate schema");
    System.out.println("W3C XML Schema, JSON schema or ShEx, as appropriate");
    System.out.println("");
    System.out.println("Usage: java -jar [validator].jar (parameters)");
    System.out.println("");
    System.out.println("The following parameters are supported:");
    System.out.println("[source]: a file, url, directory or pattern for resources to validate.  At");
    System.out.println("    least one source must be declared.  If there is more than one source or if");
    System.out.println("    the source is other than a single file or url and the output parameter is");
    System.out.println("    used, results will be provided as a Bundle.");
    System.out.println("    Patterns are limited to a directory followed by a filename with an embedded");
    System.out.println("    asterisk.  E.g. foo*-examples.xml or someresource.*, etc.");
    System.out.println("-version [ver]: The FHIR version to use. This can only appear once. ");
    System.out.println("    valid values 1.0 | 1.4 | 3.0 | " + VersionUtilities.CURRENT_VERSION + " or 1.0.2 | 1.4.0 | 3.0.2 | 4.0.1 | " + VersionUtilities.CURRENT_FULL_VERSION);
    System.out.println("    Default value is  " + VersionUtilities.CURRENT_VERSION);
    System.out.println("-ig [package|file|folder|url]: an IG or profile definition to load. Can be ");
    System.out.println("     the URL of an implementation guide or a package ([id]-[ver]) for");
    System.out.println("     a built implementation guide or a local folder that contains a");
    System.out.println("     set of conformance resources.");
    System.out.println("     No default value. This parameter can appear any number of times");
    System.out.println("-tx [url]: the [base] url of a FHIR terminology service");
    System.out.println("     Default value is http://tx.fhir.org. This parameter can appear once");
    System.out.println("     To run without terminology value, specific n/a as the URL");
    System.out.println("-txLog [file]: Produce a log of the terminology server operations in [file]");
    System.out.println("     Default value is not to produce a log");
    System.out.println("-profile [url]: the canonical URL to validate against (same as if it was ");
    System.out.println("     specified in Resource.meta.profile). If no profile is specified, the ");
    System.out.println("     resource is validated against the base specification. This parameter ");
    System.out.println("     can appear any number of times.");
    System.out.println("     Note: the profile (and it's dependencies) have to be made available ");
    System.out.println("     through one of the -ig parameters. Note that package dependencies will ");
    System.out.println("     automatically be resolved");
    System.out.println("-questionnaire [file|url}: the location of a questionnaire. If provided, then the validator will validate");
    System.out.println("     any QuestionnaireResponse that claims to match the Questionnaire against it");
    System.out.println("     no default value. This parameter can appear any number of times");
    System.out.println("-output [file]: a filename for the results (OperationOutcome)");
    System.out.println("     Default: results are sent to the std out.");
    System.out.println("-debug");
    System.out.println("     Produce additional information about the loading/validation process");
    System.out.println("-recurse");
    System.out.println("     Look in subfolders when -ig refers to a folder");
    System.out.println("-locale");
    System.out.println("     Specifies the locale/language of the validation result messages (eg.: de-DE");
    System.out.println("-sct");
    System.out.println("     Specify the edition of SNOMED CT to use. Valid Choices:");
    System.out.println("       intl | us | uk | au | nl | ca | se | dk | es");
    System.out.println("     tx.fhir.org only supports a subset. To add to this list or tx.fhir.org");
    System.out.println("     ask on https://chat.fhir.org/#narrow/stream/179202-terminology");
    System.out.println("-native: use schema for validation as well");
    System.out.println("     * XML: w3c schema+schematron");
    System.out.println("     * JSON: json.schema");
    System.out.println("     * RDF: SHEX");
    System.out.println("     Default: false");
    System.out.println("-language: [lang]");
    System.out.println("     The language to use when validating coding displays - same value as for xml:lang");
    System.out.println("     Not used if the resource specifies language");
    System.out.println("     Default: no specified language");
    System.out.println("-strictExtensions: If present, treat extensions not defined within the specified FHIR version and any");
    System.out.println("     referenced implementation guides or profiles as errors.  (Default is to only raise information messages.)");
    System.out.println("-hintAboutNonMustSupport: If present, raise hints if the instance contains data elements that are not");
    System.out.println("     marked as mustSupport=true.  Useful to identify elements included that may be ignored by recipients");
    System.out.println("-assumeValidRestReferences: If present, assume that URLs that reference resources follow the RESTful URI pattern");
    System.out.println("     and it is safe to infer the type from the URL");
    System.out.println("");
    System.out.println("The validator also supports the param -proxy=[address]:[port] for if you use a proxy");
    System.out.println("");
    System.out.println("Parameters can appear in any order");
    System.out.println("");
    System.out.println("Alternatively, you can use the validator to execute a transformation as described by a structure map.");
    System.out.println("To do this, you must provide some additional parameters:");
    System.out.println("");
    System.out.println(" -transform [map]");
    System.out.println("");
    System.out.println("* [map] the URI of the map that the transform starts with");
    System.out.println("");
    System.out.println("Any other dependency maps have to be loaded through an -ig reference ");
    System.out.println("");
    System.out.println("-transform uses the parameters -defn, -txserver, -ig (at least one with the map files), and -output");
    System.out.println("");
    System.out.println("Alternatively, you can use the validator to generate narrative for a resource.");
    System.out.println("To do this, you must provide a specific parameter:");
    System.out.println("");
    System.out.println(" -narrative");
    System.out.println("");
    System.out.println("-narrative requires the parameters -defn, -txserver, -source, and -output. ig and profile may be used");
    System.out.println("");
    System.out.println("Alternatively, you can use the validator to convert a resource or logical model.");
    System.out.println("To do this, you must provide a specific parameter:");
    System.out.println("");
    System.out.println(" -convert");
    System.out.println("");
    System.out.println("-convert requires the parameters -source and -output. ig may be used to provide a logical model");
    System.out.println("");
    System.out.println("Alternatively, you can use the validator to evaluate a FHIRPath expression on a resource or logical model.");
    System.out.println("To do this, you must provide a specific parameter:");
    System.out.println("");
    System.out.println(" -fhirpath [FHIRPath]");
    System.out.println("");
    System.out.println("* [FHIRPath] the FHIRPath expression to evaluate");
    System.out.println("");
    System.out.println("-fhirpath requires the parameters -source. ig may be used to provide a logical model");
    System.out.println("");
    System.out.println("Finally, you can use the validator to generate a snapshot for a profile.");
    System.out.println("To do this, you must provide a specific parameter:");
    System.out.println("");
    System.out.println(" -snapshot");
    System.out.println("");
    System.out.println("-snapshot requires the parameters -defn, -txserver, -source, and -output. ig may be used to provide necessary base profiles");
  }

}