package org.hl7.fhir.validation.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.hl7.fhir.model.core.VersionResolutionRules;
import org.junit.jupiter.api.Test;

class StandAloneValidatorFetcherTests {

  private static final String URL = "http://hl7.org/fhir/us/core/StructureDefinition/us-core-race";

  /**
   * findResource is the context's ICanonicalResourceLocator: the callers are the worker context
   * (a code system it doesn't know) and the validator server's /canonical (-autoLoadPackages),
   * neither of which is a validator. It cast the caller to IResourceValidator, and swallowed the
   * ClassCastException, so it never looked for anything.
   */
  @Test
  void findResourceLooksWhoeverAsks() throws Exception {
    StandAloneValidatorFetcher fetcher = spy(new StandAloneValidatorFetcher(null, null, null));
    doReturn(true).when(fetcher).resolveURL(any(), any(), any(), anyString(), any(), any(), anyBoolean(), any());

    fetcher.findResource(new Object(), URL, VersionResolutionRules.defaultRule());

    verify(fetcher).resolveURL(isNull(), isNull(), isNull(), eq(URL), any(), isNull(), eq(false), isNull());
  }
}
