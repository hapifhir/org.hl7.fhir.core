package org.hl7.fhir.validation.instance.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueType;
import org.hl7.fhir.utilities.validation.ValidationMessage.Source;
import org.hl7.fhir.validation.BaseValidator;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.advisor.BasePolicyAdvisorForFullValidation;
import org.hl7.fhir.validation.instance.advisor.TextDrivenPolicyAdvisor;
import org.junit.jupiter.api.Test;

class StructureDefinitionValidatorTest {

  private static final String CLAIMED_PROFILE = "http://example.org/StructureDefinition/Claimed";

  @Test
  void suppressesOnlyMatchingCompliesWithReasons() throws Exception {
    // slices are not normalized, so the slice has to be named explicitly (consistent with messageId@path)
    StructureDefinitionValidator validator = validatorWithAdvisor("= " + CLAIMED_PROFILE + "@Patient.name:official.given\n");
    List<ValidationMessage> errors = new ArrayList<>();

    validator.reportCompliesWithMessages(errors, "StructureDefinition", CLAIMED_PROFILE, List.of(
      reason("Patient.name:official.given", "suppressed reason", IssueSeverity.ERROR),
      reason("Patient.birthDate", "reported reason", IssueSeverity.ERROR)));

    assertEquals(1, errors.size());
    assertEquals(I18nConstants.SD_EXTENSION_COMPLIES_WITH_ERROR, errors.get(0).getMessageId());
    assertTrue(errors.get(0).getMessage().contains("reported reason"), errors.get(0).getMessage());
    assertFalse(errors.get(0).getMessage().contains("suppressed reason"), errors.get(0).getMessage());
    assertNotNull(errors.get(0).getSliceInfo());
    assertEquals(1, errors.get(0).getSliceInfo().size());
    assertEquals("Patient.birthDate", errors.get(0).getSliceInfo().get(0).getLocation());
  }

  @Test
  void suppressesAggregateCompliesWithErrorWhenAllReasonsAreSuppressed() throws Exception {
    StructureDefinitionValidator validator = validatorWithAdvisor("= " + CLAIMED_PROFILE + "@*\n");
    List<ValidationMessage> errors = new ArrayList<>();

    validator.reportCompliesWithMessages(errors, "StructureDefinition", CLAIMED_PROFILE, List.of(
      reason("Patient.name", "suppressed reason", IssueSeverity.ERROR),
      reason("Patient.birthDate", "also suppressed", IssueSeverity.ERROR)));

    assertTrue(errors.isEmpty());
  }

  @Test
  void recalculatesCompliesWithSeverityAfterSuppression() throws Exception {
    StructureDefinitionValidator validator = validatorWithAdvisor("= " + CLAIMED_PROFILE + "@Patient.name\n");
    List<ValidationMessage> errors = new ArrayList<>();

    validator.reportCompliesWithMessages(errors, "StructureDefinition", CLAIMED_PROFILE, List.of(
      reason("Patient.name", "suppressed error", IssueSeverity.ERROR),
      reason("Patient.birthDate", "remaining warning", IssueSeverity.WARNING)));

    assertEquals(1, errors.size());
    assertEquals(IssueSeverity.WARNING, errors.get(0).getLevel());
    assertEquals(I18nConstants.SD_EXTENSION_COMPLIES_WITH_WARNING, errors.get(0).getMessageId());
    assertTrue(errors.get(0).getMessage().contains("remaining warning"), errors.get(0).getMessage());
    assertFalse(errors.get(0).getMessage().contains("suppressed error"), errors.get(0).getMessage());
  }

  @Test
  void includesLocationWithoutHardcodedEnglishPrefix() throws Exception {
    StructureDefinitionValidator validator = validatorWithAdvisor("");
    List<ValidationMessage> errors = new ArrayList<>();

    validator.reportCompliesWithMessages(errors, "StructureDefinition", CLAIMED_PROFILE, List.of(
      reason("Patient.birthDate", "reported reason", IssueSeverity.ERROR)));

    assertEquals(1, errors.size());
    assertTrue(errors.get(0).getMessage().contains("Patient.birthDate: reported reason"), errors.get(0).getMessage());
    assertFalse(errors.get(0).getMessage().contains("at Patient.birthDate"), errors.get(0).getMessage());
  }

  private static TestStructureDefinitionValidator validatorWithAdvisor(String advisorSource) throws Exception {
    IWorkerContext context = mock(IWorkerContext.class);
    when(context.getResourceNames()).thenReturn(List.of("Patient"));

    BaseValidator parent = new BaseValidator(context, new ValidatorSettings(), mock(XVerExtensionManager.class), null);
    parent.setPolicyAdvisor(new TextDrivenPolicyAdvisor(baseAdvisor(), "advisor.txt", advisorSource));
    return new TestStructureDefinitionValidator(parent);
  }

  private static BasePolicyAdvisorForFullValidation baseAdvisor() {
    return new BasePolicyAdvisorForFullValidation(ReferenceValidationPolicy.CHECK_VALID, null);
  }

  private static ValidationMessage reason(String location, String message, IssueSeverity severity) {
    return new ValidationMessage(Source.InstanceValidator, IssueType.BUSINESSRULE, location, message, severity);
  }

  private static class TestStructureDefinitionValidator extends StructureDefinitionValidator {

    private TestStructureDefinitionValidator(BaseValidator parent) {
      super(parent, null, false);
    }

    @Override
    protected boolean rule(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass,
        List<ValidationMessage> details, String theMessage, Object... theMessageArguments) {
      addMessage(errors, type, path, IssueSeverity.ERROR, details, theMessage, theMessageArguments);
      return thePass;
    }

    @Override
    protected boolean warning(List<ValidationMessage> errors, String ruleDate, IssueType type, String path, boolean thePass,
        List<ValidationMessage> details, String msg, Object... theMessageArguments) {
      addMessage(errors, type, path, IssueSeverity.WARNING, details, msg, theMessageArguments);
      return thePass;
    }

    private void addMessage(List<ValidationMessage> errors, IssueType type, String path, IssueSeverity severity,
        List<ValidationMessage> details, String messageId, Object... arguments) {
      ValidationMessage message = new ValidationMessage(Source.InstanceValidator, type, path,
        messageId + ": " + formatArguments(arguments), severity).setMessageId(messageId);
      message.setSliceInfo(details);
      errors.add(message);
    }

    private String formatArguments(Object... arguments) {
      List<String> values = new ArrayList<>();
      for (Object argument : arguments) {
        addArgument(values, argument);
      }
      return String.join("|", values);
    }

    private void addArgument(List<String> values, Object argument) {
      if (argument instanceof Object[] arguments) {
        for (Object value : arguments) {
          addArgument(values, value);
        }
      } else {
        values.add(String.valueOf(argument));
      }
    }
  }
}
