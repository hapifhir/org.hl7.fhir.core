package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;
import java.util.List;

import org.hl7.fhir.r5.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.junit.jupiter.api.Test;

/**
 * Covers MappingAssistant when a derived profile re-declares a mapping identity that the
 * base profile already uses for a different URI.
 *
 * <p>The base's declaration is renamed out of the way, and the rename has to reach the
 * element mappings that were inherited from the base — not the ones the differential
 * brought with it, which mean the derived profile's own mapping.
 */
class MappingAssistantIdentityCollisionTest {

  private static final String URI_A = "http://example.org/maps/A";
  private static final String URI_B = "http://example.org/maps/B";

  @Test
  void theRenamedBaseDeclarationGetsTheNewIdentity() throws Exception {
    List<StructureDefinitionMappingComponent> declarations = masterList(assistant());

    assertEquals(2, declarations.size());
    StructureDefinitionMappingComponent renamed = declarations.get(1);
    assertEquals("m1", renamed.getIdentity(),
        "the base's declaration should be renamed by identity; an element mapping that says m1 has to resolve to it");
    assertEquals(URI_A, renamed.getUri(), "the renamed declaration is still the base's map");
    assertEquals("m", declarations.get(0).getIdentity(), "the derived profile keeps m for its own map");
  }

  private MappingAssistant assistant() {
    StructureDefinition base = new StructureDefinition();
    base.addMapping().setIdentity("m").setUri(URI_A).setName("Map A (declared in the base profile)");
    StructureDefinition derived = new StructureDefinition();
    derived.addMapping().setIdentity("m").setUri(URI_B).setName("Map B (declared in the derived profile)");
    return new MappingAssistant(MappingMergeModeOption.DUPLICATE, base, derived, "5.0.0", null);
  }

  /** masterList is private, and update() cannot be used to observe it without a snapshot. */
  @SuppressWarnings("unchecked")
  private List<StructureDefinitionMappingComponent> masterList(MappingAssistant assistant) throws Exception {
    Field field = MappingAssistant.class.getDeclaredField("masterList");
    field.setAccessible(true);
    List<StructureDefinitionMappingComponent> list =
        (List<StructureDefinitionMappingComponent>) field.get(assistant);
    assertNotNull(list);
    return list;
  }
}
