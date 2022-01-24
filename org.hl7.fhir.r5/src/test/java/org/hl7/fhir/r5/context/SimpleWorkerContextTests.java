package org.hl7.fhir.r5.context;

import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.TerminologyClient;
import org.hl7.fhir.r5.terminologies.ValueSetCheckerSimple;
import org.hl7.fhir.r5.terminologies.ValueSetExpander;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.ToolingClientLogger;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class SimpleWorkerContextTests {

  @Spy
  SimpleWorkerContext context;

  @Mock
  TerminologyCache terminologyCache;

  @Mock
  ToolingClientLogger txLog;

  @Mock
  TerminologyClient terminologyClient;

  @Mock
  TerminologyCache.CacheToken cacheToken;

  @Mock
  IWorkerContext.ValidationResult expectedValidationResult;

  @Mock
  ValueSetExpander.ValueSetExpansionOutcome expectedExansionResult;

  @Mock
  ValueSetCheckerSimple valueSetCheckerSimple;

  @Mock
  Parameters pIn;

  @Mock
  Parameters expParameters;

  @BeforeEach
  public void beforeEach() {
    context.txCache = terminologyCache;
    context.expParameters = expParameters;
    context.txClient = terminologyClient;
    context.txLog = txLog;
  }

  public class ValueSetMatcher implements ArgumentMatcher<ValueSet> {

    private ValueSet left;

    ValueSetMatcher(ValueSet left) {
      this.left = left;
    }

    @Override
    public boolean matches(ValueSet right) {
      return left.getStatus().equals(right.getStatus())
        && left.getCompose().equalsDeep(right.getCompose());
    }
  }

  @Test
  public void testValidateCodingWithCache() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions().guessSystem().setVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet);
    Mockito.doReturn(expectedValidationResult).when(terminologyCache).getValidation(cacheToken);

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    IWorkerContext.ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode(coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodingWithValueSetChecker() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions().guessSystem().setVersionFlexible(false);
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet);

    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any(), any());
    Mockito.doReturn(expectedValidationResult).when(valueSetCheckerSimple).validateCode(any(Coding.class));

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    IWorkerContext.ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple).validateCode(coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult,false);
  }


  @Test
  public void testValidateCodingWithServer() throws IOException {
    ValidationOptions validationOptions = new ValidationOptions().guessSystem().setVersionFlexible(false).noClient();
    ValueSet valueSet = new ValueSet();
    Coding coding = new Coding();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, coding, valueSet);
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, coding);
    Mockito.doReturn(expectedValidationResult).when(context).validateOnServer(valueSet, pIn, validationOptions);

    ValidationContextCarrier ctxt = mock(ValidationContextCarrier.class);

    IWorkerContext.ValidationResult actualValidationResult = context.validateCode(validationOptions, coding, valueSet, ctxt);

    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode(coding);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult,true);
  }

  @Test
  public void testValidateCodableConceptWithCache() throws IOException {
    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    Mockito.doReturn(expectedValidationResult).when(terminologyCache).getValidation(cacheToken);

    IWorkerContext.ValidationResult actualValidationResult = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(expectedValidationResult, actualValidationResult);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode(codeableConcept);
    Mockito.verify(terminologyCache).getValidation(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheValidation(any(), any(), anyBoolean());
  }

  @Test
  public void testValidateCodableConceptWithValueSetChecker() throws IOException {
    Mockito.doReturn(valueSetCheckerSimple).when(context).constructValueSetCheckerSimple(any(), any());
    Mockito.doReturn(expectedValidationResult).when(valueSetCheckerSimple).validateCode(any(CodeableConcept.class));

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(CacheTestUtils.validationOptions, codeableConcept, valueSet);

    IWorkerContext.ValidationResult validationResultB = context.validateCode(CacheTestUtils.validationOptions, codeableConcept, valueSet);
    assertEquals(expectedValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple).validateCode(codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult, false);
    Mockito.verify(context, times(0)).validateOnServer(any(), any(), any());
  }


  @Test
  public void testValidateCodableConceptWithServer() throws IOException {

    CodeableConcept codeableConcept = new CodeableConcept();
    ValueSet valueSet = new ValueSet();

    ValidationOptions validationOptions = CacheTestUtils.validationOptions.noClient();
    Mockito.doReturn(pIn).when(context).constructParameters(validationOptions, codeableConcept);

    Mockito.doReturn(expectedValidationResult).when(context).validateOnServer(valueSet, pIn, validationOptions);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateValidationToken(validationOptions, codeableConcept, valueSet);

    IWorkerContext.ValidationResult validationResultB = context.validateCode(validationOptions, codeableConcept, valueSet);

    assertEquals(expectedValidationResult, validationResultB);

    Mockito.verify(valueSetCheckerSimple, times(0)).validateCode(codeableConcept);
    Mockito.verify(terminologyCache).cacheValidation(cacheToken, expectedValidationResult, true);
    Mockito.verify(context).validateOnServer(valueSet, pIn, validationOptions);
  }

  @Test
  public void testExpandValueSetWithCache() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().getInclude().add(inc);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)),eq(true));
    Mockito.doReturn(expectedExansionResult).when(terminologyCache).getExpansion(cacheToken);

    ValueSetExpander.ValueSetExpansionOutcome actualExpansionResult = context.expandVS(inc, true);

    assertEquals(expectedExansionResult, actualExpansionResult);

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache, times(0)).cacheExpansion(any(), any(), anyBoolean());
    Mockito.verify(terminologyClient, times(0)).expandValueset(any(), any(), any());
  }

  @Test
  public void testExpandValueSetWithClient() throws IOException {

    ValueSet.ConceptSetComponent inc = new ValueSet.ConceptSetComponent();

    ValueSet vs = new ValueSet();
    vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
    vs.setCompose(new ValueSet.ValueSetComposeComponent());
    vs.getCompose().getInclude().add(inc);

    Mockito.doReturn(cacheToken).when(terminologyCache).generateExpandToken(argThat(new ValueSetMatcher(vs)),eq(true));

    Mockito.doReturn(expParameters).when(context).constructParameters(argThat(new ValueSetMatcher(vs)), eq(true));

    ValueSet expectedValueSet = new ValueSet();

    Mockito.doReturn(expectedValueSet).when(terminologyClient).expandValueset(argThat(new ValueSetMatcher(vs)), any(), any());

    ValueSetExpander.ValueSetExpansionOutcome actualExpansionResult = context.expandVS(inc, true);

    assertEquals(expectedValueSet, actualExpansionResult.getValueset());

    Mockito.verify(terminologyCache).getExpansion(cacheToken);
    Mockito.verify(terminologyCache).cacheExpansion(cacheToken, actualExpansionResult,true);
  }
}
