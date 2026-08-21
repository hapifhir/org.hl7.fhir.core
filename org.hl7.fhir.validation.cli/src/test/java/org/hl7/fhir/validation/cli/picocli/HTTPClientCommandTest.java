package org.hl7.fhir.validation.cli.picocli;

import com.sun.net.httpserver.HttpServer;
import org.hl7.fhir.validation.cli.picocli.commands.HTTPClientCommand;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for HTTPClientCommand.
 *
 * Tests verify that the command is properly configured with Picocli annotations, and that
 * -stop actually sends a POST to the server's /stop endpoint.
 */
public class HTTPClientCommandTest {

  @Test
  public void testCommandExists() {
    // Basic smoke test to verify command class is properly structured
    HTTPClientCommand command = new HTTPClientCommand();
    assertThat(command).isNotNull();
  }

  @Test
  public void testCommandName() {
    // Verify the command has the correct name
    CommandLine commandLine = new CommandLine(new HTTPClientCommand());
    assertThat(commandLine.getCommandName()).isEqualTo("client");
  }

  @Test
  public void testCommandIsNotHidden() {
    // Verify the command is not hidden (public command)
    CommandLine commandLine = new CommandLine(new HTTPClientCommand());
    assertThat(commandLine.getCommandSpec().usageMessage().hidden()).isFalse();
  }

  @Test
  public void testNoSourcesReturnsZero() {
    // Verify no validations return success (exit code 0)
    CommandLine cmd = new CommandLine(new HTTPClientCommand());
    Integer result = cmd.execute(new String[0]);
    assertThat(result).isEqualTo(0);
  }

  @Test
  public void testStopActuallyPostsToStopEndpoint() throws Exception {
    AtomicReference<String> method = new AtomicReference<>();
    AtomicReference<String> path = new AtomicReference<>();
    HttpServer server = startStubServer(200, method, path);
    try {
      CommandLine cmd = new CommandLine(new HTTPClientCommand());
      Integer result = cmd.execute("-stop", "-hostname", "localhost", "-port", Integer.toString(server.getAddress().getPort()));

      assertThat(result).isEqualTo(0);
      assertThat(method.get()).isEqualTo("POST");
      assertThat(path.get()).isEqualTo("/stop");
    } finally {
      server.stop(0);
    }
  }

  @Test
  public void testStopReturnsErrorWhenServerRefuses() throws Exception {
    AtomicReference<String> method = new AtomicReference<>();
    AtomicReference<String> path = new AtomicReference<>();
    HttpServer server = startStubServer(405, method, path);
    try {
      CommandLine cmd = new CommandLine(new HTTPClientCommand());
      Integer result = cmd.execute("-stop", "-hostname", "localhost", "-port", Integer.toString(server.getAddress().getPort()));

      assertThat(result).isEqualTo(1);
      assertThat(method.get()).isEqualTo("POST");
    } finally {
      server.stop(0);
    }
  }

  private HttpServer startStubServer(int statusCode, AtomicReference<String> method, AtomicReference<String> path) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(InetAddress.getLoopbackAddress(), 0), 0);
    server.createContext("/stop", exchange -> {
      method.set(exchange.getRequestMethod());
      path.set(exchange.getRequestURI().getPath());
      byte[] body = "{\"resourceType\":\"OperationOutcome\"}".getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/fhir+json");
      exchange.sendResponseHeaders(statusCode, body.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(body);
      }
    });
    server.start();
    return server;
  }
}
