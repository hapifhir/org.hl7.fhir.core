package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.services.conformance.profile.MappingAssistant;
import org.hl7.fhir.services.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.model.core.StructureDefinition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 * A suppressed mapping in the differential names a mapping the derived profile declares. It removes the inherited
 * mapping that is the same mapping - the base's declaration of it may have another identity (it's renamed to the
 * derived profile's) - and not an inherited mapping that only has the same identity: when the base and the derived
 * profile both use an identity for different mappings, the base's is renamed (rim -> rim1), and isn't touched
 */
class MappingAssistantSuppressTests {

  private static StructureDefinition sd(String identity, String uri, String name) {
    StructureDefinition sd = new StructureDefinition();
    sd.addMapping().setIdentity(identity).setUri(uri).setName(name);
    return sd;
  }

  private static ElementDefinition element(String identity, String map, boolean suppress) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath("Patient.gender");
    ElementDefinitionMappingComponent m = ed.addMapping().setIdentity(identity).setMap(map);
    if (suppress) {
      m.addExtension(ExtensionDefinitions.EXT_ED_SUPPRESS, new BooleanType(true));
    }
    return ed;
  }

  /**
   * the maps the inherited element still has, after the differential suppresses its mapping 'A'
   */
  private static List<String> mapsLeft(StructureDefinition base, StructureDefinition derived, String diffIdentity) {
    MappingAssistant ma = new MappingAssistant(MappingMergeModeOption.APPEND, base, derived, "6.0.0", null);
    ElementDefinition inherited = element(base.getMappingFirstRep().getIdentity(), "A", false);
    ma.merge(element(diffIdentity, "A", true), inherited);
    List<String> res = new ArrayList<>();
    for (ElementDefinitionMappingComponent m : inherited.getMappingList()) {
      res.add(m.getMap());
    }
    return res;
  }

  @ParameterizedTest(name = "{0}")
  @CsvSource({
    // name, base identity, base uri, derived identity, derived uri, suppress identity, removed
    "same identity and mapping,       rim, http://hl7.org/v3, rim,    http://hl7.org/v3,   rim,    true",
    "the derived profile renames it,  rim, http://hl7.org/v3, hl7rim, http://hl7.org/v3,   hl7rim, true",
    "the base's identity for it,      rim, http://hl7.org/v3, hl7rim, http://hl7.org/v3,   rim,    false",
    "'same identity, another mapping', rim, http://hl7.org/v3, rim,    http://example.org/x, rim,   false",
  })
  void suppressRemovesOnlyTheSameMapping(String name, String baseId, String baseUri, String derivedId, String derivedUri, String suppress, boolean removed) {
    // different names, so that a shared identity is two different mappings unless the uris match
    List<String> left = mapsLeft(sd(baseId, baseUri, "Base " + baseId), sd(derivedId, derivedUri, "Derived " + derivedId), suppress);
    assertEquals(removed ? List.of() : List.of("A"), left);
  }
}
