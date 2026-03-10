package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.ResourcePercentageLogger;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

/**
 * HTTP service wrapper for the FHIR validator using ValidationEngine and IGLoader directly
 */
@Slf4j
public class FhirValidatorHttpService {

  private final ValidationEngine validationEngine;
  private HttpServer server;
  private final int port;
  private Map<String, TxTestHTTPHandler.ServerTxTester> txTesters = new HashMap<>();

  public FhirValidatorHttpService(ValidationEngine validationEngine, int port) {
    this.validationEngine = validationEngine;
    this.port = port;
    ResourcePercentageLogger.setLoggingSuppressed(true);
  }

  public void startServer() throws IOException {
    // Create HTTP server
    server = HttpServer.create(new InetSocketAddress(port), 0);

    server.createContext("/validateResource", new ValidateResourceHTTPHandler(this));
    server.createContext("/loadIG", new LoadIGHTTPHandler(this));
    server.createContext("/txTest", new TxTestHTTPHandler(this));
    server.createContext("/stop", new StopHTTPHandler(this));

    // Start the server
    server.setExecutor(null); // Use default executor
    server.start();

    log.info("FHIR Validator HTTP Service started on port " + port);
  }

  /**
   * Stop the HTTP server
   */
  public void stop() {
    if (server != null) {
      server.stop(0);
      log.info("FHIR Validator HTTP Service stopped");
    }
  }

  public ValidationEngine getValidationEngine() {
    return validationEngine;
  }

  public Map<String, TxTestHTTPHandler.ServerTxTester> getTxTesters() {
    return txTesters;
  }
}