package org.hl7.fhir.validation.instance;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.validation.ValidatorSettings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Tests for severity capping in getTxIssueWithCalculatedSeverity.
 * <p/>
 * Verifies that for PREFERRED and EXTENSIBLE binding strengths, all tx issues
 * are capped at WARNING severity regardless of tx-issue-type, while REQUIRED
 * bindings preserve the original ERROR severity.
 *
 * @see <a href="https://github.com/hapifhir/org.hl7.fhir.core/issues/2269">#2269</a>
 */
@ExtendWith(MockitoExtension.class)
class InstanceValidatorTxIssueSeverityTests {

  @Mock
  private IWorkerContext context;

  private InstanceValidator validator;

  @BeforeEach
  void setUp() {
    when(context.getVersion()).thenReturn("5.0.1");
    validator = new InstanceValidator(context, null, null, null, new ValidatorSettings());
  }

  @ParameterizedTest(name = "binding={0}, txIssueType={1}, input={2} -> expected={3}")
  @CsvSource({
    // PREFERRED binding: all ERROR issues must be capped to WARNING
    "preferred, code-rule, error, warning",
    "preferred, invalid-code, error, warning",
    "preferred, not-found, error, warning",
    "preferred, status-check, error, warning",
    // EXTENSIBLE binding: all ERROR issues must be capped to WARNING
    "extensible, code-rule, error, warning",
    "extensible, invalid-code, error, warning",
    "extensible, not-found, error, warning",
    "extensible, status-check, error, warning",
    // REQUIRED binding: ERROR severity must be preserved
    "required, code-rule, error, error",
    "required, invalid-code, error, error",
    // REQUIRED + not-found with non-HL7 system: capped to WARNING by existing logic
    "required, not-found, error, warning",
    // WARNING input stays WARNING for all binding strengths
    "preferred, code-rule, warning, warning",
    "extensible, code-rule, warning, warning",
    "required, code-rule, warning, warning",
  })
  void getTxIssueWithCalculatedSeverity_capsBasedOnBindingStrength(
      String bindingStrengthCode,
      String txIssueType,
      String inputSeverity,
      String expectedSeverity) {

    OperationOutcomeIssueComponent issue = new OperationOutcomeIssueComponent();
    issue.setSeverity(IssueSeverity.fromCode(inputSeverity));
    issue.getDetails().addCoding()
        .setSystem("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type")
        .setCode(txIssueType);
    issue.getDetails().setText("Test issue text for " + txIssueType);

    BindingStrength strength = BindingStrength.fromCode(bindingStrengthCode);

    OperationOutcomeIssueComponent result = invokeGetTxIssueWithCalculatedSeverity(issue, strength);

    assertEquals(
        IssueSeverity.fromCode(expectedSeverity),
        result.getSeverity(),
        "For binding=" + bindingStrengthCode + " and tx-issue-type=" + txIssueType
            + ": expected severity " + expectedSeverity + " but got " + result.getSeverity().toCode()
    );
  }

  @ParameterizedTest(name = "binding={0}, txIssueType=not-found (HL7 system), input=error -> expected={1}")
  @CsvSource({
    // REQUIRED + not-found with HL7 system text: stays ERROR per existing logic
    "required, error",
    // PREFERRED + not-found with HL7 system text: still capped to WARNING by new fix
    "preferred, warning",
    // EXTENSIBLE + not-found with HL7 system text: still capped to WARNING by new fix
    "extensible, warning",
  })
  void getTxIssueWithCalculatedSeverity_notFoundWithHL7System(
      String bindingStrengthCode,
      String expectedSeverity) {

    OperationOutcomeIssueComponent issue = new OperationOutcomeIssueComponent();
    issue.setSeverity(IssueSeverity.ERROR);
    issue.getDetails().addCoding()
        .setSystem("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type")
        .setCode("not-found");
    // Text referencing an HL7 system triggers the "isHL7" path
    issue.getDetails().setText("Code system http://hl7.org/fhir/some-cs not found");

    BindingStrength strength = BindingStrength.fromCode(bindingStrengthCode);

    OperationOutcomeIssueComponent result = invokeGetTxIssueWithCalculatedSeverity(issue, strength);

    assertEquals(
        IssueSeverity.fromCode(expectedSeverity),
        result.getSeverity()
    );
  }

  /**
   * Invokes the private method getTxIssueWithCalculatedSeverity via reflection.
   * This pattern is used elsewhere in the project (e.g. CapabilityStatementUtilitiesTests).
   */
  private OperationOutcomeIssueComponent invokeGetTxIssueWithCalculatedSeverity(
      OperationOutcomeIssueComponent issue, BindingStrength bindingStrength) {
    try {
      Method method = InstanceValidator.class.getDeclaredMethod(
          "getTxIssueWithCalculatedSeverity",
          OperationOutcomeIssueComponent.class,
          BindingStrength.class);
      method.setAccessible(true);
      return (OperationOutcomeIssueComponent) method.invoke(validator, issue, bindingStrength);
    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new AssertionError("Reflection setup failed for getTxIssueWithCalculatedSeverity", e);
    } catch (InvocationTargetException e) {
      throw new AssertionError("getTxIssueWithCalculatedSeverity threw an exception", e.getTargetException());
    }
  }
}

