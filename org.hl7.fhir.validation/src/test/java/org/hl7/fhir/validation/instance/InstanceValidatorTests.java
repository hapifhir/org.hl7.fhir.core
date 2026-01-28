package org.hl7.fhir.validation.instance;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.utils.NodeStack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;
import static org.apache.commons.lang3.StringUtils.trim;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstanceValidatorTests {

  @Mock
  private IWorkerContext context;

  @Test
  void testCheckCodeOnServerNoStackLocale() throws InstanceValidator.CheckCodeOnServerException {
    when(context.getLocale()).thenReturn(Locale.KOREA);
    NodeStack stack =mock(NodeStack.class);
    testCheckCodeOnServer(stack, "ko-KR");
  }

  @Test
  void testCheckCodeOnServerStackLocale() throws InstanceValidator.CheckCodeOnServerException {
    NodeStack stack =mock(NodeStack.class);
    when(stack.getWorkingLang()).thenReturn("fr-CA");
    testCheckCodeOnServer(stack, "fr-CA");
  }

  private void testCheckCodeOnServer(NodeStack stack, String expectedLocale) throws InstanceValidator.CheckCodeOnServerException {
    when(context.getVersion()).thenReturn("5.0.1");
    InstanceValidator instanceValidator = new InstanceValidator(context, null, null, null, new ValidatorSettings());


    when(context.validateCode((ValidationOptions) any(ValidationOptions.class), (CodeableConcept) any(CodeableConcept.class), (ValueSet)any(ValueSet.class))).thenReturn(new ValidationResult(ValidationMessage.IssueSeverity.NULL, "Blah!", Collections.emptyList()));

    CodeableConcept codeableConcept = mock(CodeableConcept.class);
    ValueSet valueSet = mock(ValueSet.class);
    instanceValidator.checkCodeOnServer(stack, valueSet, codeableConcept);

    ArgumentCaptor<ValidationOptions> validationOptionsArgumentCaptor = ArgumentCaptor.forClass(ValidationOptions.class);
    verify(context).validateCode(validationOptionsArgumentCaptor.capture(), eq(codeableConcept), eq(valueSet));

    ValidationOptions options = validationOptionsArgumentCaptor.getValue();

    assertEquals(expectedLocale, options.getLanguages().getSource());
  }

  @Test
  void testElementDebug() throws IOException {
    when(context.getVersion()).thenReturn("5.0.1");
    InstanceValidator instanceValidator = new InstanceValidator(context, null, null, null, new ValidatorSettings());


    Element element = new Element("dummyName");
    Logger mockLogger = mock(Logger.class);
    instanceValidator.debugElement(element, mockLogger);
    verify(mockLogger, times(1)).debug("dummyName" + System.lineSeparator());
  }

  @ParameterizedTest
  @CsvSource({
    // Good URLs
    "Patient?name=simpson                              , true",
    "Patient?name:exact=simpson                        , true",
    "Patient?name.chain=simpson                        , true",
    "Patient?family=simpson&given=homer                , true",
    "Patient?family=                                   , true",
    "Patient?param-name=param-value                    , true",
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

  @Test
  void testTimeoutParameter() {
    when(context.getVersion()).thenReturn("5.0.1");
    final String dummyTimeoutSource = "Dummy Timeout Source";
    final String originalMessage = "Original Message";
    final String dummyTimeoutMessage = "Dummy Timeout Message";
    when(context.formatMessage(I18nConstants.VALIDATION_TIMEOUT_EXCEEDED, 500L, dummyTimeoutSource)).thenReturn(dummyTimeoutMessage);
    InstanceValidator instanceValidator = new InstanceValidator(context, null, null, null, new ValidatorSettings()){
      protected void clearInternalState(Element element, List<StructureDefinition> profiles) {
        super.clearInternalState(element, profiles);
        try {
          sleep(1000);
        } catch (InterruptedException e) {
          Assertions.fail();
        }
      }

    };

    instanceValidator.setTimeout(new ValidationTimeout(500, dummyTimeoutSource));
    List<ValidationMessage> messages = new ArrayList<>();

    messages.add(new ValidationMessage().setMessage(originalMessage));
    Element element = mock(Element.class);
    when(element.hasParentForValidator()).thenReturn(true);
    instanceValidator.validate(context, messages, null, element, Collections.emptyList());
    assertThat(messages.size()).isEqualTo(2);
    assertThat(messages.get(0).getMessage()).isEqualTo(originalMessage);
    assertThat(messages.get(1).getMessage()).contains(dummyTimeoutMessage);
  }
}