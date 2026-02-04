package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import picocli.CommandLine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
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

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  @Override
  public Integer call() {

    HttpClient httpClient = HttpClient.newBuilder()
      .connectTimeout(Duration.ofSeconds(10))
      .build();

    final String BASE_URL = "http://localhost:" + port;

    for (String source : whatToValidate) {


      try {
        HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(BASE_URL + "/validateResource" +
            "&resourceIdRule=PROHIBITED" +
            "&anyExtensionsAllowed=false" +
            "&bpWarnings=Error" +
            "&displayOption=CheckCaseAndSpace"))
          .POST(HttpRequest.BodyPublishers.ofFile(Path.of(source)))
          .header("Content-Type", "application/fhir+json")
          .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
      } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
      } catch (IOException e) {
        throw new RuntimeException(e);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    return 0;
  }
}
