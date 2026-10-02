package org.hl7.fhir.services.client;

import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.utilities.ToolingClientLogger;

import java.net.URISyntaxException;

public interface ITerminologyClientFactoryN {
  ITerminologyClientN makeClientN(IModelContext context, String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException;

  String getVersion();
}
