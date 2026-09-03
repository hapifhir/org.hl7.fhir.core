package org.hl7.fhir.standalone.terminology.expansion;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.OperationOutcome.IssueType;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.services.terminology.TerminologyServiceErrorClass;
import org.hl7.fhir.services.terminology.OpIssueCode;

import java.util.List;


public abstract class ConceptFilter {

  private List<String> allErrors;
  

  protected FHIRException fail(String msg) {
    allErrors.add(msg);
    return new FHIRException(msg);
  }

  /**
   * A filter that could not be evaluated at all - a regex that never terminates, say. Without
   * a tx-issue-type the OperationOutcome says only "unknown", which tells a client nothing it
   * can act on; invalid-data is what the ecosystem test for this already expects, so that is
   * what it carries. TerminologyServiceProtectionException is the carrier because it is the
   * one exception the expander already unpacks into a coded outcome.
   */
  protected TerminologyServiceProtectionException failFilter(String msg) {
    allErrors.add(msg);
    return new TerminologyServiceProtectionException(msg, TerminologyServiceErrorClass.UNKNOWN, IssueType.UNKNOWN, null,
        OpIssueCode.InvalidData);
  }
  
  public ConceptFilter(List<String> allErrors) {
    super();
    this.allErrors = allErrors;
  }


  public abstract boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def);

}