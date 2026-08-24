package org.hl7.fhir.r5.terminologies.client;

import org.hl7.fhir.utilities.ToolingClientLogger;

import java.net.URISyntaxException;

public interface ITerminologyClientFactory {
  ITerminologyClient makeClient(String id, String url, String userAgent, ToolingClientLogger logger) throws URISyntaxException;

  String getVersion();
}
