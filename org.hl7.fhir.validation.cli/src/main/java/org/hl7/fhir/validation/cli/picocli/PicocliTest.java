package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.Map;
import java.util.concurrent.Callable;

public class PicocliTest {

  private static String[] getBackwardCompatibleArgs(String[] args) {
      Map<String, String> argMap = Map.of(
          "-server", "server"
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
      CommandLine commandLine = new CommandLine(new DefaultCommand());
      int exitCode = commandLine.execute(backwardCompatibleArgs);
      System.exit(exitCode);
    }

}
