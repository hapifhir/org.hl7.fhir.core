package org.hl7.fhir.validation.cli.picocli;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.picocli.commands.ValidateCommand;
import org.hl7.fhir.validation.cli.picocli.commands.ValidationServiceCommand;
import org.hl7.fhir.validation.cli.picocli.options.*;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.event.Level;
import picocli.CommandLine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hl7.fhir.validation.cli.JavaSystemProxyParamSetter.verifyProxySystemProperties;

@Slf4j
public class CLI {

  protected ValidationService myValidationService;

  public CLI(ValidationService validationService) {
    this.myValidationService = validationService;
  }

  public int parseArgsAndExecuteCommand(String[] args) throws IllegalArgumentException{
    Display.displayVersion(log);
    final String[] modifiedArgs = replaceDeprecatedArgs(args);
    ValidateCommand parentCommand = new ValidateCommand();
    parentCommand.setValidationService(myValidationService);

    CommandLine commandLine = new CommandLine(parentCommand);
    for (Map.Entry<String, CommandLine> subcommand : commandLine.getCommandSpec().subcommands().entrySet()) {
      Object subcommandObject = subcommand.getValue().getCommand();
      if (subcommandObject instanceof ValidationServiceCommand validationServiceCommand) {
        validationServiceCommand.setValidationService(myValidationService);
      }
    }

    CommandLine.ParseResult parseResult;
    try {
       parseResult = commandLine.parseArgs(modifiedArgs);
    } catch(CommandLine.PicocliException e) {
      log.error("Unable to parse command line arguments: " + e.getMessage());
      throw new IllegalArgumentException(e);
    }

    verifyProxySystemProperties();

    Display.displaySystemInfo(log);
    try {
      Display.printCliParamsAndInfo(log, modifiedArgs);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    checkCharsetAndWarnIfNotUTF8();

    commandLine
      .setOut(new PrintWriter(new CLIToSlf4jLoggerWriter(log, Level.INFO)))
      .setErr(new PrintWriter(new CLIToSlf4jLoggerWriter(log, Level.ERROR)));
    return commandLine.getExecutionStrategy().execute(parseResult);
  }

  private static String[] replaceDeprecatedArgs(String[] args) {
    Map<String, String> argMap = new HashMap<>();
    argMap.put("-install", "install");
    argMap.put("-compare", "compare");
    argMap.put("-compile", "compile");
    argMap.put("-fhirpath", "fhirpath");
    argMap.put("-convert", "convert");
    argMap.put("-to-version", "to-version");
    argMap.put("-crumb-trails", "-verbose");
    argMap.put("-show-message-ids", "-verbose");
    argMap.put("-lang-transform", "lang-transform");
    argMap.put("-lang-regen", "lang-regen");
    argMap.put("-narrative", "narrative");
    argMap.put("-codegen", "codegen");
    argMap.put("-preloadCache", "preloadCache");
    argMap.put("-scan", "scan");
    argMap.put("-snapshot", "snapshot");
    argMap.put("-special", "special");
    argMap.put("-spreadsheet", "spreadsheet");
    argMap.put("-tests", "tests");
    argMap.put("-txTests", "txTests");
    argMap.put("-transform", "transform");
    argMap.put("-aiTests", "aiTests");
    argMap.put("-factory", "factory");
    argMap.put("-server", "server");
    argMap.put("-re-package", "re-package");
    argMap.put("-tx-pack", "re-package");
    argMap.put("-?", "-help");
    argMap.put("/?", "-help");

    String[] newArgs = new String[args.length];
    for (int i = 0; i < args.length; i++) {
      if (argMap.containsKey(args[i])) {
        final String newArg = argMap.get(args[i]);
        log.warn("The option '{}' is no longer in use. Using '{}' ", args[i], newArg);
        newArgs[i] = newArg;
      } else {
        newArgs[i] = args[i];
      }
    }

    newArgs = insertCodeGenIfNecessary(newArgs);
    newArgs = addAdditionalParamsForIpsParam(newArgs);
    return newArgs;
  }

  private static String[] addAdditionalParamsForIpsParam(String[] args) {
    List<String> res = new ArrayList<>();
    for (String a : args) {
      if (a.equals("-ips")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#2.0.0-ballot");
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.equals("-ips:au")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.au.ps#current");
        res.add("-profile");
        res.add("http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-bundle");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org.au/fhir/ps/StructureDefinition/au-ps-composition");
      } else if (a.startsWith("-ips#")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#"+a.substring(5));
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.startsWith("-ips$")) {
        res.add("-version");
        res.add("4.0");
        res.add("-check-ips-codes");
        res.add("-ig");
        res.add("hl7.fhir.uv.ips#current$"+a.substring(5));
        res.add("-profile");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Bundle-uv-ips");
        res.add("-extension");
        res.add("any");
        res.add("-bundle");
        res.add("Composition:0");
        res.add("http://hl7.org/fhir/uv/ips/StructureDefinition/Composition-uv-ips");
      } else if (a.equals("-cda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.uv.core#2.0.1-sd");
      } else if (a.equals("-ccda")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("hl7.cda.us.ccda#4.0.0");
      } else if (a.equals("-view-definition")) {
        res.add("-version");
        res.add("5.0");
        res.add("-ig");
        res.add("org.sql-on-fhir.ig#current");
      } else {
        res.add(a);
      }
    }
    String[] r = new String[res.size()];
    for (int i = 0; i < res.size(); i++) {
      r[i] = res.get(i);
    }
    return r;
  }

  /**
   * This is a legacy behavior in which the presence of a -package-name and no explicit use of -re-package results in
   * the execution of the codegen command.
   * @param args Command-line args (with deprecated args already replaced with their Picocli versions)
   * @return new args with the codegen option included if necessary
   */
  protected static String[] insertCodeGenIfNecessary(String[] args) {
    boolean hasPackageParam = false;
    boolean hasRePackageParam = false;
    for (String arg : args) {
      if ("-package-name".equals(arg)) {
        hasPackageParam = true;
      }
      if ("re-package".equals(arg)) {
        hasRePackageParam = true;
      }
      if ("codegen".equals(arg)) {
        return args;
      }
    }

    if (hasPackageParam && !hasRePackageParam) {
      log.warn("Detected -package-name parameter use; switching to codegen command");
      String[] argsWithCodeGen = new String[args.length + 1];
      System.arraycopy(args, 0, argsWithCodeGen, 1, args.length);
      argsWithCodeGen[0] = "codegen";
      return argsWithCodeGen;
    }
    return args;
  }



  @SuppressWarnings("checkstyle:systemout")
  private static void checkCharsetAndWarnIfNotUTF8() {
    FileFormat.checkCharsetAndWarnIfNotUTF8(System.out);
  }

}
