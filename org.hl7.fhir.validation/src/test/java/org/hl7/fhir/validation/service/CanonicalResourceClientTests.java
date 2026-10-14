package org.hl7.fhir.validation.service;

import org.hl7.fhir.services.client.ITerminologyClientN;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.utilities.VersionUtil;

import org.hl7.fhir.validation.instance.utils.CanonicalResourceClient;
import org.junit.jupiter.api.Test;


import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class CanonicalResourceClientTests
{
  @Test
  void testGetTerminologyClient() throws URISyntaxException {
    ITerminologyClientN client = new CanonicalResourceClient(mock(IWorkerContext.class)).getTerminologyClient("http://dummyserver/fhir");

    assertEquals("fhir/validator/" + VersionUtil.getVersion(), client.getUserAgent());
  }
}
