package org.hl7.fhir.r5.terminologies.expansion;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;

import java.util.List;

/**
 * A filter on one of the properties with a built-in meaning (notSelectable, status, inactive,
 * deprecated): see KnownProperties
 */
public class KnownPropertyFilter extends ConceptFilter {

  private ConceptSetFilterComponent filter;
  private String code;

  public KnownPropertyFilter(List<String> allErrors, ConceptSetFilterComponent fc, String code) {
    super (allErrors);
    this.filter = fc;
    this.code = code;
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    if (!KnownProperties.isSupportedOperation(filter.getOp())) {
      throw fail("not supported yet: "+filter.getOp().toCode());
    }
    return KnownProperties.selects(filter, KnownProperties.getValue(cs, def, code));
  }

}
