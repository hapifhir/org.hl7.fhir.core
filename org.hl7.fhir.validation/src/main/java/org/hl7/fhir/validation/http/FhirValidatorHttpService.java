package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpServer;
import org.hl7.fhir.model.IModelContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.instance.ResourcePercentageLogger;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.*;

/**
 * HTTP service wrapper for the FHIR validator using ValidationEngine and IGLoader directly
 */
@Slf4j
public class FhirValidatorHttpService {

  private final ValidationEngine validationEngine;
  private HttpServer server;
  /**
   * -- GETTER --
   *  Whether this server is bound to the loopback interface only, so that the only possible
   *  caller is a process on this machine. Handlers use this to decide what a caller may name.
   */
  @Getter
  private final boolean loopbackOnly;
  private final int port;

  private Map<String, TxTestHTTPHandler.ServerTxTester> txTesters = new HashMap<>();

  public FhirValidatorHttpService(ValidationEngine validationEngine, boolean loopBackOnly, int port) {
    this.validationEngine = validationEngine;
    this.loopbackOnly = loopBackOnly;
    this.port = port;
    ResourcePercentageLogger.setLoggingSuppressed(true);
  }

  public void startServer() throws IOException {
    InetSocketAddress inetSocketAddress;
    // Create HTTP server
    if (loopbackOnly) {
      // Uses 127.0.0.1 or ::1, which inherently restricts access to the local machine
      inetSocketAddress = new InetSocketAddress(InetAddress.getLoopbackAddress(), port);
    }
    else {
      // Uses 0.0.0.0 or ::0, which can be accessed outside the local machine (see java.net.InetAddress.anyLocalAddress)
      inetSocketAddress = new InetSocketAddress(port);
      log.warn("Server has been configured to be available on all available network interfaces (loopbackOnly=false). By running in this mode you are assuming responsibility for securing access to this application.");
    }
    server = HttpServer.create(inetSocketAddress, 0);

    IModelContext context = validationEngine.getContext().getModelContext();

    server.createContext("/validateResource", new ValidateResourceHTTPHandler(context, this));
    server.createContext("/fhirpath", new FhirPathHTTPHandler(context, this));
    server.createContext("/matchetype", new MatchetypeHTTPHandler(context, this));
    server.createContext("/testdata", new TestDataHTTPHandler(context, this));
    server.createContext("/loadIG", new LoadIGHTTPHandler(context, this));
    server.createContext("/convert", new ConvertHTTPHandler(context, this));
    server.createContext("/snapshot", new SnapshotHTTPHandler(context, this));
    server.createContext("/narrative", new NarrativeHTTPHandler(context, this));
    server.createContext("/transform", new TransformHTTPHandler(context, this));
    server.createContext("/version", new VersionHTTPHandler(context, this));
    server.createContext("/compile", new CompileHTTPHandler(context, this));
    server.createContext("/openapi.json", new OpenApiHTTPHandler());
    server.createContext("/docs", new DocsHTTPHandler(context, DocsHTTPHandler.SWAGGER_HTML));
    server.createContext("/redoc", new DocsHTTPHandler(context, DocsHTTPHandler.REDOC_HTML));
    server.createContext("/txTest", new TxTestHTTPHandler(context, this));
    server.createContext("/stop", new StopHTTPHandler(context, this));

    // GITB-faithful REST services for ITB integration (gitb_vs.xsd / gitb_ps.xsd).
    //   Validation services: GET <prefix>/getModuleDefinition + POST <prefix>/validate
    //   Processing services: GET <prefix>/getModuleDefinition + POST <prefix>/process
    //                        + POST <prefix>/beginTransaction + POST <prefix>/endTransaction
    server.createContext("/itb/fhir",              new GitbFhirHandler(this));               // VS
    server.createContext("/itb/matchetype",        new GitbMatchetypeHandler(this));         // VS
    server.createContext("/itb/fhirPathAssertion", new GitbFhirPathAssertionHandler(this));  // VS
    server.createContext("/itb/fhirPath",          new GitbFhirPathHandler(this));           // PS
    server.createContext("/itb/testdata",          new GitbTestDataHandler(this));           // PS
    server.createContext("/itb/validationResults", new GitbValidationResultsHandler(this));  // PS
    server.createContext("/itb/igManager",         new GitbIgManagerHandler(this));          // PS
    server.createContext("/itb/loadResource",      new GitbLoadResourceHandler(this));       // PS
    server.createContext("/itb/transform",         new GitbTransformHandler(this));          // PS
    server.createContext("/itb/questionnaire",     new GitbQuestionnaireHandler(this));      // PS
    server.createContext("/itb/package",           new GitbPackageHandler(this));            // PS

    // Start the server
    server.setExecutor(null); // Use default executor
    server.start();

    log.info("FHIR Validator HTTP Service started on  " + inetSocketAddress.getAddress() + ":" + inetSocketAddress.getPort());
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

  public InetSocketAddress getInetAddress() {
    return server.getAddress();
  }
}