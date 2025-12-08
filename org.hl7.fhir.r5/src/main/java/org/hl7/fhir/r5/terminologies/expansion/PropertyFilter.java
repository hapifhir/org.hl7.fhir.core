package org.hl7.fhir.r5.terminologies.expansion;

import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyComponent;
import org.hl7.fhir.r5.model.CodeSystem.PropertyType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.r5.utils.CodingUtilities;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;

@MarkedToMoveToAdjunctPackage
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
      if (pc.hasValue() && pc.getValue().isPrimitive()) {
        String v = pc.getValue().primitiveValue();
        switch (filter.getOp()) {
          case DESCENDENTOF:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case EQUAL:
            return filter.getValue().equals(v);
          case EXISTS:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case GENERALIZES:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case IN:
            return Utilities.existsInListTrimmed(v, filter.getValue().split("\\,"));
          case ISA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case ISNOTA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case NOTIN:
            return !Utilities.existsInListTrimmed(v, filter.getValue().split("\\,"));
          case NULL:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case REGEX:
            return v != null && v.matches(filter.getValue());
          default:
            throw fail("Shouldn't get here");
        }
      } else if (pc.getValue() instanceof Coding) {
        Coding c = pc.getValueCoding();
        switch (filter.getOp()) {
          case DESCENDENTOF:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case EQUAL:
            return CodingUtilities.filterEquals(c, filter.getValue());
          case EXISTS:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case GENERALIZES:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case IN:
            return CodingUtilities.filterInList(c, filter.getValue().split("\\,"));
          case ISA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case ISNOTA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case NOTIN:
            return !CodingUtilities.filterInList(c, filter.getValue().split("\\,"));
          case NULL:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case REGEX:
            return CodingUtilities.filterMatches(c, filter.getValue());
          default:
            throw fail("Shouldn't get here");
        }
      } else {
        throw fail("not supported yet: " + pc.getValue().fhirType());
      }
    } else {
      return filter.getOp() == FilterOperator.NOTIN;
    }
  }

  private ConceptPropertyComponent getPropertyForConcept(ConceptDefinitionComponent def) {
    for (ConceptPropertyComponent pc : def.getProperty()) {
      if (pc.hasCode() && pc.getCode().equals(property.getCode())) {
        return pc;
      }
    }
    return null;
  }

}