package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.terminologies.client.ITerminologyClient;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class StandAloneValidatorFetcherTests
{
  @Test
  public void testGetTerminologyClient() throws URISyntaxException {
    StandAloneValidatorFetcher standAloneValidatorFetcher = new StandAloneValidatorFetcher(mock(FilesystemPackageCacheManager.class), mock(IWorkerContext.class), mock(IPackageInstaller.class));
    ITerminologyClient client = standAloneValidatorFetcher.getTerminologyClient("http://dummyserver/fhir");

    assertEquals("fhir/validator/" + VersionUtil.getVersion(), client.getUserAgent());
  }
}
