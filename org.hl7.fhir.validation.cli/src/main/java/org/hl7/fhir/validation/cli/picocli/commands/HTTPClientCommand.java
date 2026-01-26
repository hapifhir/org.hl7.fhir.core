package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * HTTP client command for interacting with the FHIR validator HTTP server.
 * <p/>
 * This command is intended to send commands to a running validator HTTP server,
 * such as stopping the server remotely or checking its status.
 * <p/>
 * Note: This command is not yet fully implemented. It currently serves as a
 * placeholder for future HTTP client functionality.
 * <p/>
 * Planned usage:
 * <pre>
 * java -jar validator_cli.jar client --stop -port 8080
 * java -jar validator_cli.jar client --status -host localhost -port 8080
 * </pre>
 */
@Slf4j
@CommandLine.Command(
  name = "client",
  description = """
    HTTP client for interacting with the FHIR validator HTTP server.

    This command is intended to send commands to a running validator
    HTTP server, such as stopping the server remotely.

    Note: This command is not yet fully implemented.

    Example (planned):
      java -jar validator_cli.jar client --stop -port 8080
    """,
  hidden = false
)
public class HTTPClientCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"--stop"},
    description = "Stop the running HTTP server (not yet implemented)"
  )
  private boolean stop;

  @CommandLine.Option(
    names = {"-hostname"},
    description = "Server host (default: localhost)",
    defaultValue = "localhost"
  )
  private String hostname;

  @CommandLine.Option(
    names = {"-port"},
    description = "Server port (default: 80)",
    defaultValue = "80"
  )
  private String port;

  @CommandLine.Parameters(
    index = "0",
    description = "Hostname and port combo (or default http port)"
  )
  private String host;

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  @Override
  public Integer call() {
    log.warn("This command is not implemented yet");

    // Future implementation would:
    // 1. Create HTTP client
    // 2. Connect to http://host:port
    // 3. Send appropriate command (stop, status, etc.)
    // 4. Handle response

    if (stop) {
      log.info("Would send stop command to {}. Or: {}:{}", host, hostname, port);
    }

    return 0;
  }
}
