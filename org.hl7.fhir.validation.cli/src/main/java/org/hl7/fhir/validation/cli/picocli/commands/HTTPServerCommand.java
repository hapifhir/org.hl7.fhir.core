package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.http.FhirValidatorHttpService;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptionsConvertor;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import picocli.CommandLine;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Command to run the FHIR validator as a lightweight HTTP server.
 * <p/>
 * The validator runs as an in-process HTTP validation service that allows
 * clients to submit FHIR resources for validation via HTTP POST requests.
 * You can configure the FHIR version, connect to a terminology server,
 * and load relevant Implementation Guides for validation.
 * <p/>
 * The server provides a /validateResource endpoint that accepts POST requests
 * with FHIR resources in JSON or XML format and returns validation results
 * as FHIR OperationOutcome resources.
 * <p/>
 * The server runs indefinitely until terminated with Ctrl-C.
 * <p/>
 * Example usage:
 * <pre>
 * java -jar validator_cli.jar server -port 8080 -version 4.0 \
 *   -ig hl7.fhir.us.carin-bb#1.1.0 -ig hl7.fhir.us.davinci-crd#1.0.0
 * </pre>
 */
@Slf4j
@CommandLine.Command(
  name = "server",
  description = """
    Run the validator as a lightweight HTTP server.

    The validator runs as an in-process HTTP validation service.
    You can configure the FHIR version, connect to a terminology server,
    and load relevant IGs for validation.

    The server provides a /validateResource endpoint for POST requests
    with FHIR resources in JSON or XML format.

    The server runs until terminated with Ctrl-C.

    Example:
      java -jar validator_cli.jar server -port 8080 -version 4.0 \\
        -ig hl7.fhir.us.carin-bb#1.1.0
    """,
  hidden = false
)
public class HTTPServerCommand extends ValidationEngineCommand implements Callable<Integer> {

  @CommandLine.Spec
  CommandLine.Model.CommandSpec spec;

  @CommandLine.Parameters(
    index = "0",
    description = "Port Number to use"
  )
  private int port;

  // The remaining parameters are processed as sources
  @CommandLine.Parameters(
    description = "Source file(s) to transform",
    index = "1..*"
  )
  private List<String> sources;

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  @Override
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    InstanceValidatorOptionsConvertor convertor = new InstanceValidatorOptionsConvertor();
    return convertor.convert(instanceValidatorOptions);
  }

  @Override
  public List<String> getSources() {
    return sources == null ? Collections.emptyList() : sources;
  }

  @Override
  protected Integer call(@Nonnull ValidationService validationService,
                        @Nonnull ValidationEngine validationEngine) {
    try {
      validateServerParameters();

      validationEngine.setLogValidationProgress(false);

      FhirValidatorHttpService service = new FhirValidatorHttpService(
        validationEngine,
        port
      );
      service.startServer();

      log.info("Press Ctrl-C to stop the server, or use the client to ask the server to stop (client -stop)");

      // Run indefinitely until interrupted
      while (true) {
        Thread.sleep(100);
      }

    } catch (InterruptedException e) {
      log.info("Server interrupted, shutting down...");
      Thread.currentThread().interrupt();
      return 0;
    } catch (Exception e) {
      log.error("Error starting HTTP server", e);
      return 1;
    }
  }

  private void validateServerParameters() {
    // Validate port number
    if (port <= 0 || port > 65535) {
      log.error("Invalid port number: {}. Port must be between 1 and 65535.", port);
      System.exit(1);
    }
  }
}
