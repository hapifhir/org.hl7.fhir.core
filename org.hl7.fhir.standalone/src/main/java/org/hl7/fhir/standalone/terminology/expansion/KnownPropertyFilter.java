package org.hl7.fhir.standalone.terminology.expansion;

import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.standalone.terminology.expansion.ConceptFilter;
import org.hl7.fhir.utilities.Utilities;

import java.util.List;


public class KnownPropertyFilter extends ConceptFilter {

  private ConceptSetFilterComponent filter;
  private String code;

  public KnownPropertyFilter(List<String> allErrors, ConceptSetFilterComponent fc, String code) {
    super (allErrors);
    this.filter = fc;
    this.code = code;
  }

  @Override
  @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
  //single literal character split
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    ConceptPropertyComponent pc = getPropertyForConcept(def);
    if (pc != null) {
      String v = pc.getValue().isPrimitive() ? pc.getValue().primitiveValue() : null;
      switch (filter.getOp()) {
      case DESCENDENTOF: throw fail("not supported yet: "+filter.getOp().toCode());
      case EQUAL: return filter.getValue().equals(v);
      case EXISTS: throw fail("not supported yet: "+filter.getOp().toCode());
      case GENERALIZES: throw fail("not supported yet: "+filter.getOp().toCode());
      case IN: return Utilities.existsInListTrimmed(v, filter.getValue().split("\\,"));
      case ISA: throw fail("not supported yet: "+filter.getOp().toCode());
      case ISNOTA: throw fail("not supported yet: "+filter.getOp().toCode());
      case NOTIN: return Utilities.existsInListTrimmed(v, filter.getValue().split("\\,"));
      case NULL: throw fail("not supported yet: "+filter.getOp().toCode());
      case REGEX: throw fail("not supported yet: "+filter.getOp().toCode());
      default:
        throw fail("Shouldn't get here");        
      }            
    } else {
      return false;
    }
  }

  private ConceptPropertyComponent getPropertyForConcept(ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent pc : def.getPropertyList()) {
      if (pc.hasCode() && pc.getCode().equals(code)) {
        return pc;
      }
    }
    return null;
  }

}