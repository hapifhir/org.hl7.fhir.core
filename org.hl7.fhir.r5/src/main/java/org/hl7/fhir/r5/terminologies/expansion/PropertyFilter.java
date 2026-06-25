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
    ConceptPropertyComponent propertyComponent = getPropertyForConcept(def);
    if (propertyComponent != null) {
      if (propertyComponent.hasValue() && propertyComponent.getValue().isPrimitive()) {
        String value = propertyComponent.getValue().primitiveValue();
        switch (filter.getOp()) {
          case DESCENDENTOF:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case EQUAL:
            return filter.getValue().equals(value);
          case EXISTS:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case GENERALIZES:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case IN:
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character split
            String[] primitiveInParts = filter.getValue().split("\\,");
            return Utilities.existsInListTrimmed(value, primitiveInParts);
          case ISA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case ISNOTA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case NOTIN:
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character split
            String[] primitiveNotInParts = filter.getValue().split("\\,");
            return !Utilities.existsInListTrimmed(value, primitiveNotInParts);
          case NULL:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case REGEX:
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //Regex sourced from FHIR ValueSet filter value; user-supplied at runtime
            boolean primitiveRegexMatch = value != null && value.matches(filter.getValue());
            return primitiveRegexMatch;
          default:
            throw fail("Shouldn't get here");
        }
      } else if (propertyComponent.getValue() instanceof Coding) {
        Coding c = propertyComponent.getValueCoding();
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
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character split
            String[] codingInParts = filter.getValue().split("\\,");
            return CodingUtilities.filterInList(c, codingInParts);
          case ISA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case ISNOTA:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case NOTIN:
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character split
            String[] codingNotInParts = filter.getValue().split("\\,");
            return !CodingUtilities.filterInList(c, codingNotInParts);
          case NULL:
            throw fail("not supported yet: " + filter.getOp().toCode());
          case REGEX:
            return CodingUtilities.filterMatches(c, filter.getValue());
          default:
            throw fail("Shouldn't get here");
        }
      } else {
        throw fail("not supported yet: " + propertyComponent.getValue().fhirType());
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