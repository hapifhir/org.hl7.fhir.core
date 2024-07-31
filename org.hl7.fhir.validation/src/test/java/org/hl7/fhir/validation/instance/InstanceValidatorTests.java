package org.hl7.fhir.validation.instance;

import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.validation.instance.utils.NodeStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InstanceValidatorTests {

  @Test
  public void testCheckCodeOnServerNoStackLocale() throws InstanceValidator.CheckCodeOnServerException {
      NodeStack stack =mock(NodeStack.class);
      testCheckCodeOnServer(stack, "ko-KR");
  }

  @Test
  public void testCheckCodeOnServerStackLocale() throws InstanceValidator.CheckCodeOnServerException {
      NodeStack stack =mock(NodeStack.class);
      when(stack.getWorkingLang()).thenReturn("fr-CA");
      testCheckCodeOnServer(stack, "fr-CA");
  }

  private void testCheckCodeOnServer(NodeStack stack, String expectedLocale) throws InstanceValidator.CheckCodeOnServerException {
    IWorkerContext context = mock(IWorkerContext.class);
    when(context.getLocale()).thenReturn(Locale.KOREA);
    when(context.getVersion()).thenReturn("5.0.1");
    InstanceValidator instanceValidator = new InstanceValidator(context, null, null);


    when(context.validateCode((ValidationOptions) any(ValidationOptions.class), (CodeableConcept) any(CodeableConcept.class), (ValueSet)any(ValueSet.class))).thenReturn(new ValidationResult(ValidationMessage.IssueSeverity.NULL, "Blah!", Collections.emptyList()));

    CodeableConcept codeableConcept = mock(CodeableConcept.class);
    ValueSet valueSet = mock(ValueSet.class);
    instanceValidator.checkCodeOnServer(stack, valueSet, codeableConcept);

    ArgumentCaptor<ValidationOptions> validationOptionsArgumentCaptor = ArgumentCaptor.forClass(ValidationOptions.class);
    verify(context).validateCode(validationOptionsArgumentCaptor.capture(), eq(codeableConcept), eq(valueSet));

    ValidationOptions options = validationOptionsArgumentCaptor.getValue();

    Assertions.assertEquals(expectedLocale, options.getLanguages().getSource());
  }

}