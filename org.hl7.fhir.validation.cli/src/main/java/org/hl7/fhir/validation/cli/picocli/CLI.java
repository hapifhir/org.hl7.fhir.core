package org.hl7.fhir.validation.cli.picocli;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.picocli.commands.ValidateCommand;
import org.hl7.fhir.validation.cli.picocli.commands.ValidationServiceCommand;
import org.hl7.fhir.validation.cli.picocli.options.DebugOptions;
import org.hl7.fhir.validation.cli.picocli.options.GlobalOptions;
import org.hl7.fhir.validation.cli.picocli.options.LocaleOptions;
import org.hl7.fhir.validation.cli.picocli.options.ProxyOptions;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.event.Level;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CLI {

  protected ValidationService myValidationService;

  private static final GlobalOptions[] GLOBAL_OPTIONS =  {
    new LocaleOptions(),
    new DebugOptions(),
    new ProxyOptions()
  };

  protected CLI(ValidationService validationService) {
    this.myValidationService = validationService;
  }

  protected int parseArgsAndExecuteCommand(String[] args) {
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
    CommandLine.ParseResult parseResult = null;
    try {
      parseResult = commandLine.parseArgs(modifiedArgs);
    } catch(CommandLine.PicocliException e) {
      log.error("Unable to parse command line arguments: " + e.getMessage());
      log.debug("", e);
      System.exit(1);
    }
    for (GlobalOptions globalOption : GLOBAL_OPTIONS) {
      int exitCode = globalOption.apply(parseResult);
      if (exitCode != 0) {
        System.exit(exitCode);
      }
    }

    Display.displayVersion(log);
    Display.displaySystemInfo(log);

    checkCharsetAndWarnIfNotUTF8();

    commandLine
      .setOut(new PrintWriter(new CLIToSlf4jLoggerWriter(log, Level.INFO)))
      .setErr(new PrintWriter(new CLIToSlf4jLoggerWriter(log, Level.ERROR)));
    return commandLine.execute(modifiedArgs);
  }

  private static String[] replaceDeprecatedArgs(String[] args) {
    Map<String, String> argMap = new HashMap<>();
    argMap.put("-server", "server");
    argMap.put("-install", "install");
    argMap.put("-compare", "compare");
    argMap.put("-compile", "compile");
    argMap.put("-fhirpath", "fhirpath");
    argMap.put("-convert", "convert");
    argMap.put("-crumb-trails", "-verbose");
    argMap.put("-show-message-ids", "-verbose");
    argMap.put("-lang-transform", "lang-transform");
    argMap.put("-lang-regen", "lang-regen");
    argMap.put("-narrative", "narrative");
    argMap.put("-preloadCache", "preloadCache");
    argMap.put("-scan", "scan");
    argMap.put("-snapshot", "snapshot");
    argMap.put("-special", "special");
    argMap.put("-spreadsheet", "spreadsheet");
    argMap.put("-tests", "tests");
    argMap.put("-txTests", "txTests");
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

      return newArgs;
  }

    public static void main(String[] args) {
      CLI cli = new CLI(new ValidationService());
      int exitCode = cli.parseArgsAndExecuteCommand(args);
      System.exit(exitCode);
    }

  @SuppressWarnings("checkstyle:systemout")
  private static void checkCharsetAndWarnIfNotUTF8() {
    FileFormat.checkCharsetAndWarnIfNotUTF8(System.out);
  }

}
