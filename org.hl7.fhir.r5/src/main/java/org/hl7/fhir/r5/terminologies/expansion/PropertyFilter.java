package org.hl7.fhir.r5.terminologies.expansion;

import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;

public class PropertyFilter extends ConceptFilter {

  private ConceptSetFilterComponent filter;
  private PropertyComponent property;

  public PropertyFilter(List<String> allErrors, ConceptSetFilterComponent fc, PropertyComponent propertyDefinition) {
    super (allErrors);
    this.filter = fc;
    this.property = propertyDefinition;
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    ConceptPropertyComponent pc = getPropertyForConcept(def);
    if (pc != null) {
      String v = pc.getValue().isPrimitive() ? pc.getValue().primitiveValue() : null;
      switch (filter.getOp()) {
      case DESCENDENTOF: throw fail("not supported yet: "+filter.getOp().toCode());
      case EQUAL: return filter.getValue().equals(v);
      case EXISTS: throw fail("not supported yet: "+filter.getOp().toCode());
      case GENERALIZES: throw fail("not supported yet: "+filter.getOp().toCode());
      case IN: throw fail("not supported yet: "+filter.getOp().toCode());
      case ISA: throw fail("not supported yet: "+filter.getOp().toCode());
      case ISNOTA: throw fail("not supported yet: "+filter.getOp().toCode());
      case NOTIN: throw fail("not supported yet: "+filter.getOp().toCode());
      case NULL: throw fail("not supported yet: "+filter.getOp().toCode());
      case REGEX: throw fail("not supported yet: "+filter.getOp().toCode());
      default:
        throw fail("Shouldn't get here");        
      }            
    } else if (property.getType() == PropertyType.BOOLEAN && filter.getOp() == FilterOperator.EQUAL) {
      return "false".equals(filter.getValue()); 
    } else {
      return false;
    }
  }

  private ConceptPropertyComponent getPropertyForConcept(ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent pc : def.getProperty()) {
      if (pc.getCode().equals(property.getCode())) {
        return pc;
      }
    }
    return null;
  }

}