package org.hl7.fhir.convertors.misc;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.RunAll;

import java.io.File;

public class VSACImporterCLI {
  @Command(name = "VSACCLI",
          mixinStandardHelpOptions = true,
          version = "VSACCLI 1.0",
          subcommands = { GetValueSetList.class,
                          GetCodeSystems.class,
                          CommandLine.HelpCommand.class },
           description = "Interact with the VSAC FHIR Terminology Service.")
  static class ParentCommand implements Runnable {
    @Override
    public void run() { }
  }

  @Command(name = "getValueSetList", mixinStandardHelpOptions = true, description = "Generates expansions of a provided list of VSAC value sets and writes details of the value set expansions (including the code systems used) to an output file.")
  static class GetValueSetList implements Runnable {

    @Option(names = { "-i", "--inputFile" }, required = true, paramLabel = "FILE", arity = "1..1", description = "The full path to a CSV file containing rows for each VSAC value set with the value set's OID in the first column.")
    private File inputFile;

    @Option(names = { "-a", "--apiKey" }, required = true, arity = "1..1", description = "The VSAC API key to use.")
    private String apiKey;

    @Option(names = { "-s", "--separator" }, arity = "0..1", defaultValue = "|||", description = "The text to separate different fields in the output file.")
    private String separator;

    @Option(names = { "-o", "--outputFile" }, required = true, arity = "1..1", paramLabel = "FILE", description = "The full path where output file will be written to.")
    private File outputFile;


    @Override
    public void run() {
      try {
        VSACImporter vsacImporter = new VSACImporter();
        vsacImporter.getValueSetList(inputFile, apiKey, separator, outputFile);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Command(name = "getCodeSystems", mixinStandardHelpOptions = true, description = "Download VSAC code systems as FHIR CodeSystem resources.")
  static class GetCodeSystems implements Runnable {
    enum FhirFormat { xml, json }

    @Option(names = { "-i", "--inputFile" }, required = true, paramLabel = "FILE", arity = "1..1", description = "The full path to a CSV file containing rows for each VSAC code system with the code system's FHIR Logical ID (id) in the first column, its Version ID (vid) in the second column, and the output filename to write the code system to.")
    private File inputFile;

    @Option(names = { "-a", "--apiKey" }, required = true, arity = "1..1", description = "The VSAC API key to use.")
    private String apiKey;

    @Option(names = { "-f", "--fhirFormat" }, required = false, defaultValue = "json", arity = "0..1", description = "The FHIR format for the output code systems. Valid values: ${COMPLETION-CANDIDATES}" )
    private FhirFormat fhirFormat;

    @Option(names = { "-d", "--destinationFolder" }, required = true, arity = "1..1", paramLabel = "FOLDER", description = "The full path to the folder where the FHIR resource files will be written to.")
    private File destinationFolder;

    @Option(names = { "-o", "--onlyNew" }, required = false, defaultValue = "true", arity = "0..1", description = "Whether only new code systems should be downloaded." )
    private boolean onlyNew;

    @Override
    public void run() {
      try {
        VSACImporter vsacImporter = new VSACImporter();
        vsacImporter.getCodeSystems(inputFile, apiKey, fhirFormat.toString(), destinationFolder, onlyNew);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    CommandLine cmd = new CommandLine(new ParentCommand());
    cmd.setExecutionStrategy(new RunAll()); // default is RunLast
    cmd.execute(args);

    if (args.length == 0) { cmd.usage(System.out); }
  }
}
