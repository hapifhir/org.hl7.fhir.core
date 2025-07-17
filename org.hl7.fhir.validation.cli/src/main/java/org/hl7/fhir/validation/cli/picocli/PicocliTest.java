package org.hl7.fhir.validation.cli.picocli;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class PicocliTest {
    @Command(mixinStandardHelpOptions = true, version = "0.1",
    description = "Validates FHIR resources.")
    static class DefaultCommand implements Callable<Integer> {

      @Option(names = {"-a", "--arg"}, description = "An argument to the command")
      private String arg = null;

      @Override
      public Integer call() throws Exception { // your business logic goes here...
        System.out.println("You asked for " + arg + " and you got " + arg);
        return 0;
      }
    }

  @Command(name = "-server", mixinStandardHelpOptions = true, version = "0.1",
    description = "Start a fhir server.")
  static class ServerCommand implements Callable<Integer> {

    @Option(names = {"-p", "--port"}, description = "An argument to the command")
    private String port = null;

    @Override
    public Integer call() throws Exception { // your business logic goes here...
      System.out.println("Running server on port " + port);
      return 0;
    }
  }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new DefaultCommand()).addSubcommand(
          "-server", new ServerCommand())
          .execute(args);
        System.exit(exitCode);
    }
}
