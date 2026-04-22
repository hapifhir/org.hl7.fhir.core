package org.hl7.fhir.validation.instance;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.validation.BaseValidator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.apache.commons.lang3.StringUtils.trim;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BaseValidatorTests {
  @Mock
  private IWorkerContext context;

  @ParameterizedTest
  @CsvSource({
    // Good URLs
    "Patient?name=simpson                              , true",
    "Patient?name:exact=simpson                        , true",
    "Patient?name.chain=simpson                        , true",
    "Patient?family=simpson&given=homer                , true",
    "Patient?family=                                   , true",
    "Patient?param-name=param-value                    , true",
    "Patient?param-name=param-value&param-other=other  , true",
    "Patient?param=param+value                         , true",
    "Patient?param=param%20value                       , true",
    "Patient?family=&given=                            , true",
    // Bad URLs
    "?                                                 , false",
    "name=simpson                                      , false",
    "?name=simpson                                     , false",
    "Hello?name=simpson                                , false",
    "Patient?                                          , false",
    "Patient?=simpson                                  , false",
    "Patient?==simpson                                 , false",
    "Patient?==                                        , false",
    "Patient?family==simpson                           , false",
    "Patient?f&mily=simpson                            , false",
  })
  void testIsSearchUrl(String theInput, boolean theExpected) {
    if (theInput.contains("?")) {
      when(context.getResourceNamesAsSet()).thenReturn(Set.of("Patient"));
    }

    boolean actual = BaseValidator.isSearchUrl(context, trim(theInput));
    assertEquals(theExpected, actual);
  }
}
