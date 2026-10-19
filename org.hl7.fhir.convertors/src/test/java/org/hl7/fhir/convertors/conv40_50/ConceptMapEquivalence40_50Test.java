package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ConceptMapEquivalence40_50Test {

  static org.hl7.fhir.r4.model.ConceptMap mapWith(ConceptMapEquivalence equivalence) {
    org.hl7.fhir.r4.model.ConceptMap cm = new org.hl7.fhir.r4.model.ConceptMap();
    cm.addGroup().setSource("http://example.org/cs").setTarget("http://example.org/cs")
      .addElement().setCode("child")
      .addTarget().setCode("parent").setEquivalence(equivalence);
    return cm;
  }

  // unmatched is left out: it becomes element.noMap, not a target, so it never goes through the
  // relationship conversion
  @ParameterizedTest
  @EnumSource(value = ConceptMapEquivalence.class, names = {"NULL", "UNMATCHED"}, mode = EnumSource.Mode.EXCLUDE)
  public void theEquivalenceExtensionIsOnlyAddedWhenTheRelationshipLosesIt(ConceptMapEquivalence equivalence) {
    org.hl7.fhir.r4.model.ConceptMap r4 = mapWith(equivalence);
    org.hl7.fhir.r5.model.ConceptMap r5 = (org.hl7.fhir.r5.model.ConceptMap) VersionConvertorFactory_40_50.convertResource(r4.copy());

    org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent target = r5.getGroupFirstRep().getElementFirstRep().getTargetFirstRep();
    // the five the R5 relationship gives back unchanged; the rest need the extension
    boolean lossless = Set.of("relatedto", "equivalent", "wider", "narrower", "disjoint").contains(equivalence.toCode());
    assertEquals(!lossless, target.getModifierExtension().stream().anyMatch(e -> VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE.equals(e.getUrl())), equivalence.toCode());

    org.hl7.fhir.r4.model.ConceptMap back = (org.hl7.fhir.r4.model.ConceptMap) VersionConvertorFactory_40_50.convertResource(r5);
    assertTrue(r4.equalsDeep(back), equivalence.toCode() + " should round-trip");
  }
}
