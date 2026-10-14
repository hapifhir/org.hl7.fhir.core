package org.hl7.fhir.r5.terminologies.subsumption;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;

/**
 * Thrown when a subsumption test cannot be performed at all - typically because the 
 * code system is not known, or is not present with content = complete, or because one 
 * of the codes is not valid in the code system. 
 * <p>
 * Note that this is not the way to say 'no subsumption relationship exists' - that's 
 * {@link SubsumptionOutcome#NOTSUBSUMED}. This means 'the question cannot be answered'.
 */
public class SubsumptionException extends FHIRException {

  private static final long serialVersionUID = 7003348294517451296L;

  private final List<OperationOutcomeIssueComponent> issues;
  private final TerminologyServiceErrorClass type;

  public SubsumptionException(String message, List<OperationOutcomeIssueComponent> issues, TerminologyServiceErrorClass type) {
    super(message);
    this.issues = issues == null ? new ArrayList<>() : issues;
    this.type = type;
  }

  public List<OperationOutcomeIssueComponent> getIssues() {
    return issues;
  }

  public TerminologyServiceErrorClass getType() {
    return type;
  }
}
