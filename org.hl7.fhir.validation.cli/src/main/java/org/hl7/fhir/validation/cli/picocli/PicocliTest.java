package org.hl7.fhir.validation.cli.picocli;

import org.apache.commons.lang3.ArrayUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Map;
import java.util.concurrent.Callable;

public class PicocliTest {
    @Command(mixinStandardHelpOptions = true,
    description = "Validates FHIR resources.",
    subcommands = {
      CommandLine.HelpCommand.class,
      ServerCommand.class
    })
    static class DefaultCommand implements Callable<Integer> {
      @CommandLine.Spec
      CommandLine.Model.CommandSpec spec;

      @Option(names = {"-a", "--arg"}, description = "An argument to the command")
      private String arg = null;

      @Override
      public Integer call() throws Exception { // your business logic goes here...
        System.out.println("You asked for " + arg + " and you got " + arg);
        return 0;
      }
    }

  @Command(name = "server",
    description = "Start a fhir server.")
  static class ServerCommand implements Callable<Integer> {

    @Option(names = {"-p", "--port"}, description = "The port to run the server on", required = true)
    private String port = null;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
      System.out.println("Running server on port " + port);
      return 0;
    }
  }

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
