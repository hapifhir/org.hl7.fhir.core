package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.services.conformance.profile.SnapshotGenerationPreProcessor;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name, covering
 * SnapshotGenerationPreProcessor.isExtensionSlicing.
 */
class SnapshotGenerationPreProcessorExtensionSlicingTest {

  @Test
  void extensionSlicingIsRecognised() throws Exception {
    assertTrue(isExtensionSlicing(slicedElement("Patient.extension")));
  }

  @Test
  void modifierExtensionSlicingIsRecognised() throws Exception {
    assertTrue(isExtensionSlicing(slicedElement("Patient.modifierExtension")));
  }

  @Test
  void slicingOnAnotherElementIsNotExtensionSlicing() throws Exception {
    assertFalse(isExtensionSlicing(slicedElement("Patient.identifier")));
  }

  /**
   * Standard extension slicing: open, one discriminator of type value on "url".
   * Ordered is set explicitly, since the predicate does not accept a slicing that
   * leaves it absent.
   */
  private ElementDefinition slicedElement(String path) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(path);
    ed.getSlicing().setRules(SlicingRules.OPEN).setOrdered(false);
    ed.getSlicing().addDiscriminator().setType(DiscriminatorType.VALUE).setPath("url");
    return ed;
  }

  private boolean isExtensionSlicing(ElementDefinition ed) throws Exception {
    SnapshotGenerationPreProcessor preProcessor =
        new SnapshotGenerationPreProcessor(new ProfileUtilities(null, new ArrayList<>(), null));
    Method method =
        SnapshotGenerationPreProcessor.class.getDeclaredMethod("isExtensionSlicing", ElementDefinition.class);
    method.setAccessible(true);
    return (boolean) method.invoke(preProcessor, ed);
  }
}
