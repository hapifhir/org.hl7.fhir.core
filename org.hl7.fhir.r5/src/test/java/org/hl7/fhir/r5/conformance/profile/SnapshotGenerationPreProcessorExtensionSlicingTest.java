package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.junit.jupiter.api.Test;

/**
 * Covers SnapshotGenerationPreProcessor.isExtensionSlicing, which exempts standard
 * extension slicing from being treated as a real slice.
 *
 * <p>The predicate is private and its callers work on accumulated slice state, so it is
 * invoked directly here rather than through a differential large enough to observe the
 * classification indirectly.
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
   * slicing.ordered is 0..1 and its absence means "not ordered", so an entry that simply
   * omits it is ordinary extension slicing. Tools that always write ordered=false never
   * hit this; hand-authored profiles do.
   */
  @Test
  void extensionSlicingWithoutAnExplicitOrderedIsRecognised() throws Exception {
    ElementDefinition ed = slicedElement("Patient.extension");
    ed.getSlicing().setOrderedElement(null);

    assertFalse(ed.getSlicing().hasOrdered(), "the fixture must leave ordered absent");
    assertTrue(isExtensionSlicing(ed));
  }

  @Test
  void orderedExtensionSlicingIsNotExtensionSlicing() throws Exception {
    ElementDefinition ed = slicedElement("Patient.extension");
    ed.getSlicing().setOrdered(true);

    assertFalse(isExtensionSlicing(ed));
  }

  /** Standard extension slicing: open, not ordered, one discriminator of type value on "url". */
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
