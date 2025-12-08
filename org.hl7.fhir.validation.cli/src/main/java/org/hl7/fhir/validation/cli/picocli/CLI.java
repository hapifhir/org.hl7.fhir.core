package org.hl7.fhir.validation.cli.picocli;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.FileFormat;
import org.hl7.fhir.validation.cli.Display;
import org.hl7.fhir.validation.cli.picocli.commands.ValidateCommand;
import org.hl7.fhir.validation.cli.picocli.commands.ValidationEngineCommand;
import org.hl7.fhir.validation.cli.picocli.commands.ValidationServiceCommand;
import org.hl7.fhir.validation.cli.picocli.options.DebugOptions;
import org.hl7.fhir.validation.cli.picocli.options.GlobalOptions;
import org.hl7.fhir.validation.cli.picocli.options.LocaleOptions;
import org.hl7.fhir.validation.cli.picocli.options.ProxyOptions;
import org.hl7.fhir.validation.service.ValidationService;
import org.slf4j.event.Level;
import picocli.CommandLine;

import java.io.PrintWriter;
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
    String[] backwardCompatibleArgs = getBackwardCompatibleArgs(args);
    ValidateCommand parentCommand = new ValidateCommand();
    parentCommand.setValidationService(myValidationService);


    CommandLine commandLine = new CommandLine(parentCommand);
    for (Map.Entry<String, CommandLine> subcommand : commandLine.getCommandSpec().subcommands().entrySet()) {
      Object subcommandObject = subcommand.getValue().getCommand();
      if (subcommandObject instanceof ValidationServiceCommand validationServiceCommand) {
        validationServiceCommand.setValidationService(myValidationService);
      }
    }

    CommandLine.ParseResult parseResult = commandLine.parseArgs(backwardCompatibleArgs);

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
    return commandLine.execute(backwardCompatibleArgs);
  }

  private static String[] getBackwardCompatibleArgs(String[] args) {
      Map<String, String> argMap = Map.of(
          "-server", "server",
          "-install", "install",
          "-?", "-help",
          "/?", "-help"
      );

      String[] newArgs = new String[args.length];
      for (int i = 0; i < args.length; i++) {
          if (argMap.containsKey(args[i])) {
              newArgs[i] = argMap.get(args[i]);
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
