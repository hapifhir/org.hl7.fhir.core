package org.hl7.fhir.standalone.terminology.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Searching a server for a canonical: the url is what's before the first '|' (a url can't have a '|' in it), and the
 * version is everything after it, as everywhere else (CanonicalPair)
 */
class TerminologyClientManagerSearchCriteriaTest {

  @ParameterizedTest(name = "{0}")
  @CsvSource(delimiter = '!', value = {
    "http://example.org/vs                 ! ?_format=json&url=http%3A%2F%2Fexample.org%2Fvs",
    "http://example.org/vs|1.0.0           ! ?_format=json&url=http%3A%2F%2Fexample.org%2Fvs&version=1.0.0",
    "http://example.org/vs|1.0|draft       ! ?_format=json&url=http%3A%2F%2Fexample.org%2Fvs&version=1.0%7Cdraft",
    "http://example.org/vs|                ! ?_format=json&url=http%3A%2F%2Fexample.org%2Fvs&version=",
  })
  void searchCriteria(String canonical, String criteria) {
    assertEquals(criteria, TerminologyClientManager.searchCriteria(canonical));
  }
}
