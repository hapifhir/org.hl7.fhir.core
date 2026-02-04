package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.service.renderers.*;
import org.hl7.fhir.validation.service.utils.Slf4JOutputStream;
import picocli.CommandLine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.Callable;

import org.hl7.fhir.r5.model.Resource;

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
        JsonParser jsonParser = new JsonParser();
        Resource resource = jsonParser.parse(response.body());
        renderValidationOutput(resource, null, null, false, false, "NOW!", 0);
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

  //FIXME belongs in ValidationOutputRenderer?
  //FIXME error counting seems like it shouldn't be a renderer concern. Maybe a more generic output summary?
  private int renderValidationOutput(Resource resource, String output, String outputStyle, boolean isCrumbTrails, boolean isShowMessageIds, String runDate, int errorCount) throws IOException {
    PrintStream outputStream = null;
    ValidationOutputRenderer renderer = makeValidationOutputRenderer(output, outputStyle);
    renderer.setCrumbTrails(isCrumbTrails);
    renderer.setShowMessageIds(isShowMessageIds);
    renderer.setRunDate(runDate);
    if (renderer.isSingleFile()) {
      if (output == null) {
        outputStream = new PrintStream(new Slf4JOutputStream());
      } else {
        outputStream = new PrintStream(ManagedFileAccess.outStream(Utilities.path(output)));
      }
      renderer.setOutput(outputStream);
    } else {
      File folder = ManagedFileAccess.file(output);
      if (!folder.isDirectory()) {
        throw new Error("The output location " + folder.getAbsolutePath() + " must be an existing directory for the output style " + renderer.getStyleCode());
      }
      renderer.setFolder(folder);
    }

    if (resource instanceof Bundle) {
      if (renderer.handlesBundleDirectly()) {
        renderer.render((Bundle) resource);
      } else {
        renderer.start(((Bundle) resource).getEntry().size() > 1);
        for (Bundle.BundleEntryComponent e : ((Bundle) resource).getEntry()) {
          OperationOutcome op = (OperationOutcome) e.getResource();
          errorCount = errorCount + countErrors(op);
          renderer.render(op);
        }
        renderer.finish();
      }
    } else if (resource == null) {
      errorCount = errorCount + 1;
      log.info("No output from validation - nothing to validate");
    } else {
      renderer.start(false);
      OperationOutcome op = (OperationOutcome) resource;
      errorCount = countErrors(op);
      renderer.render((OperationOutcome) resource);
      renderer.finish();
    }

    if (output != null && outputStream != null) {
      outputStream.close();
    }
    return errorCount;
  }

  private int countErrors(OperationOutcome oo) {
    int error = 0;
    for (OperationOutcome.OperationOutcomeIssueComponent issue : oo.getIssue()) {
      if (issue.getSeverity() == OperationOutcome.IssueSeverity.FATAL || issue.getSeverity() == OperationOutcome.IssueSeverity.ERROR)
        error++;
    }
    return error;
  }

  //FIXME Belongs in ValidationOutputRendererFactory?
  private ValidationOutputRenderer makeValidationOutputRenderer(String output, String style) {

    // adding to this list?
    // Must document the option at https://confluence.hl7.org/display/FHIR/Using+the+FHIR+Validator#UsingtheFHIRValidator-ManagingOutput
    // if you're going to make a PR, document the link where the outputstyle is documented, along with a sentence that describes it, in the PR notes
    if (Utilities.noString(style)) {
      if (output == null) {
        return new DefaultRenderer();
      } else if (output.endsWith(".json")) {
        return new NativeRenderer(Manager.FhirFormat.JSON);
      } else {
        return new NativeRenderer(Manager.FhirFormat.XML);
      }
    } else if (Utilities.existsInList(style, "eslint-compact")) {
      return new ESLintCompactRenderer();
    } else if (Utilities.existsInList(style, "compact-split")) {
      return new CompactRenderer(true);
    } else if (Utilities.existsInList(style, "compact")) {
      return new CompactRenderer(false);
    } else if (Utilities.existsInList(style, "csv")) {
      return new CSVRenderer();
    } else if (Utilities.existsInList(style, "xml")) {
      return new NativeRenderer(Manager.FhirFormat.XML);
    } else if (Utilities.existsInList(style, "json")) {
      return new NativeRenderer(Manager.FhirFormat.JSON);
    } else {
      log.info("Unknown output style '"+style+"'");
      return new DefaultRenderer();
    }
  }
}
