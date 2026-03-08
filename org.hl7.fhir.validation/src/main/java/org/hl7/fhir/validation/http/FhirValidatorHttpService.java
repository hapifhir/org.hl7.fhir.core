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
    server.createContext("/fhirpath", new FhirPathHTTPHandler(this));
    server.createContext("/matchetype", new MatchetypeHTTPHandler(this));
    server.createContext("/testdata", new TestDataHTTPHandler(this));
    server.createContext("/loadIG", new LoadIGHTTPHandler(this));
    server.createContext("/convert", new ConvertHTTPHandler(this));
    server.createContext("/snapshot", new SnapshotHTTPHandler(this));
    server.createContext("/narrative", new NarrativeHTTPHandler(this));
    server.createContext("/transform", new TransformHTTPHandler(this));
    server.createContext("/version", new VersionHTTPHandler(this));
    server.createContext("/compile", new CompileHTTPHandler(this));
    server.createContext("/openapi.json", new OpenApiHTTPHandler());
    server.createContext("/docs", new DocsHTTPHandler(DocsHTTPHandler.SWAGGER_HTML));
    server.createContext("/redoc", new DocsHTTPHandler(DocsHTTPHandler.REDOC_HTML));
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