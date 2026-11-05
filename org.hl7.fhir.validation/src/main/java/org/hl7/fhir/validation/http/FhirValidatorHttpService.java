package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
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
import java.util.regex.Pattern;

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
  /**
   * -- GETTER --
   *  Whether the /txTest endpoints are on. They are for running the terminology ecosystem tests
   *  from a build pipeline: they connect to a server the caller names and write output files on
   *  this machine, so they are off unless asked for at start up.
   */
  @Getter
  private final boolean txTestsEnabled;
  private final int port;

  /** The response header that carries the nonce. */
  public static final String NONCE_HEADER = "X-Validator-Nonce";
  @SuppressWarnings("checkstyle:patternUsage")
  //a fixed literal reviewed here: a single bounded character class, no nesting; the nonce is what is matched, not the pattern
  private static final Pattern NONCE_PATTERN = Pattern.compile("[A-Za-z0-9._-]{1,128}");

  /**
   * -- GETTER --
   *  The nonce the server was started with, or null. When there is one, it is returned in an
   *  X-Validator-Nonce header on every response, so that whoever started the server (a wrapper
   *  such as fhir-validator-wrapper) can tell it from anything else that answers on the port -
   *  a server left running by an earlier process, say. It is not a secret, and not authentication.
   */
  @Getter
  private final String nonce;

  // the terminology test runs in progress (see TxTestHTTPHandler), by session id
  private final Map<String, TxTestHTTPHandler.ServerTxTester> txTesters = new java.util.concurrent.ConcurrentHashMap<>();

  public FhirValidatorHttpService(ValidationEngine validationEngine, boolean loopBackOnly, int port) {
    this(validationEngine, loopBackOnly, false, port);
  }

  public FhirValidatorHttpService(ValidationEngine validationEngine, boolean loopBackOnly, boolean txTestsEnabled, int port) {
    this(validationEngine, loopBackOnly, txTestsEnabled, port, null);
  }

  /**
   * Checks a nonce before anything expensive is done with it (the CLI calls this before it loads
   * the validation engine).
   *
   * @return null if the nonce is acceptable or absent, otherwise a message saying what is wrong with it
   */
  public static String checkNonce(String nonce) {
    if (nonce == null) {
      return null;
    }
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //False positive: Matcher.matches() on NONCE_PATTERN, which is reviewed above
    boolean nonceIsValid = NONCE_PATTERN.matcher(nonce).matches();
    if (!nonceIsValid) {
      return "The nonce may contain only letters, digits, '.', '-' and '_', and be up to 128 characters long";
    }
    return null;
  }

  public FhirValidatorHttpService(ValidationEngine validationEngine, boolean loopBackOnly, boolean txTestsEnabled, int port, String nonce) {
    String nonceProblem = checkNonce(nonce);
    if (nonceProblem != null) {
      throw new IllegalArgumentException(nonceProblem);
    }
    this.validationEngine = validationEngine;
    this.loopbackOnly = loopBackOnly;
    this.txTestsEnabled = txTestsEnabled;
    this.port = port;
    this.nonce = nonce;
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
    if (txTestsEnabled && !loopbackOnly) {
      log.warn("The terminology test endpoints (/txTest) are on, and the server is reachable from the network: callers can run tests against the servers configured in fhir-settings and write output files to this machine's temporary directory. They are intended for a build pipeline, not a public server.");
    }
    server = HttpServer.create(inetSocketAddress, 0);

    IModelContext context = validationEngine.getContext().getModelContext();

    addContext("/validateResource", new ValidateResourceHTTPHandler(context, this));
    addContext("/fhirpath", new FhirPathHTTPHandler(context, this));
    addContext("/fhirpath/check", new FhirPathCheckHTTPHandler(context, this));
    addContext("/canonical", new CanonicalHTTPHandler(context, this));
    addContext("/matchetype", new MatchetypeHTTPHandler(context, this));
    addContext("/testdata", new TestDataHTTPHandler(context, this));
    addContext("/loadIG", new LoadIGHTTPHandler(context, this));
    addContext("/convert", new ConvertHTTPHandler(context, this));
    addContext("/snapshot", new SnapshotHTTPHandler(context, this));
    addContext("/narrative", new NarrativeHTTPHandler(context, this));
    addContext("/transform", new TransformHTTPHandler(context, this));
    addContext("/version", new VersionHTTPHandler(context, this));
    addContext("/compile", new CompileHTTPHandler(context, this));
    addContext("/openapi.json", new OpenApiHTTPHandler());
    addContext("/docs", new DocsHTTPHandler(context, DocsHTTPHandler.SWAGGER_HTML));
    addContext("/redoc", new DocsHTTPHandler(context, DocsHTTPHandler.REDOC_HTML));
    addContext("/txTest", new TxTestHTTPHandler(context, this));
    addContext("/stop", new StopHTTPHandler(context, this));
    // anything that none of the above match: an explicit 404 rather than the server's default, so it gets the nonce too
    addContext("/", new NotFoundHTTPHandler(context));

    // Start the server
    server.setExecutor(null); // Use default executor
    server.start();

    log.info("FHIR Validator HTTP Service started on  " + inetSocketAddress.getAddress() + ":" + inetSocketAddress.getPort());
  }

  private void addContext(String path, HttpHandler handler) {
    HttpContext ctx = server.createContext(path, handler);
    if (nonce != null) {
      ctx.getFilters().add(new NonceFilter(nonce));
    }
  }

  /** Puts the nonce in the response headers, before the handler sends them. */
  private static class NonceFilter extends Filter {
    private final String nonce;

    NonceFilter(String nonce) {
      this.nonce = nonce;
    }

    @Override
    public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
      exchange.getResponseHeaders().set(NONCE_HEADER, nonce);
      chain.doFilter(exchange);
    }

    @Override
    public String description() {
      return "Returns the server's nonce in the " + NONCE_HEADER + " header";
    }
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