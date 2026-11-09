package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.model.IModelContext;

import java.io.IOException;

/**
 * Registered at "/", so (by longest-prefix matching) it only gets requests that no other handler
 * matches. It exists so that those 404s go through a context like everything else, and so carry
 * the nonce header.
 */
class NotFoundHTTPHandler extends BaseHTTPHandler implements HttpHandler {

  public NotFoundHTTPHandler(IModelContext context) {
    super(context);
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    sendResponse(exchange, 404, "Not found", "text/plain");
  }
}
