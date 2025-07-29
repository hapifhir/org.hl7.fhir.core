package org.hl7.fhir.validation.cli.picocli;

import org.hl7.fhir.validation.cli.picocli.options.DebugOptions;
import org.hl7.fhir.validation.cli.picocli.options.GlobalOptions;
import org.hl7.fhir.validation.cli.picocli.options.LocaleOptions;
import org.hl7.fhir.validation.cli.picocli.options.ProxyOptions;
import picocli.CommandLine;

import java.util.Map;

public class CLI {

  private final static GlobalOptions[] GLOBAL_OPTIONS =  {
    new LocaleOptions(),
    new DebugOptions(),
    new ProxyOptions()
  };

  private static String[] getBackwardCompatibleArgs(String[] args) {
      Map<String, String> argMap = Map.of(
          "-server", "server",
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
      String[] backwardCompatibleArgs = getBackwardCompatibleArgs(args);
      CommandLine commandLine = new CommandLine(new ValidateCommand());

      CommandLine.ParseResult parseResult = commandLine.parseArgs(backwardCompatibleArgs);

      for (GlobalOptions globalOption : GLOBAL_OPTIONS) {
        globalOption.apply(parseResult);
      }

      int exitCode = commandLine.execute(backwardCompatibleArgs);
      System.exit(exitCode);
    }
}
