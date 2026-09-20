package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.hl7.fhir.utilities.UserDataNames;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 *
 * <p>Covers the slice min/max sum check in ProfileUtilities.
 *
 * <p>The check is driven by a counter that is opened when a sliced element is seen and
 * flushed when a later element of shallower-or-equal depth turns up. A slice group that
 * runs to the last element of the snapshot never meets that later element, so whether the
 * check happened used to depend on where the sliced element sat in the resource.
 */
class ProfileUtilitiesSliceSumTest {

  private static final String PATH = "Patient.identifier";

  @Test
  void slicesThatRunToTheEndOfTheSnapshotAreStillChecked() throws Exception {
    ProfileUtilities profileUtilities = profileUtilities();

    checkSliceCardinalitySums(profileUtilities, profile(0, 1, 1));

    assertTrue(messageAbout(profileUtilities, "add up to a minimum of 2"),
        "the slice group reaches the last element, and its sums still have to be checked");
  }

  @Test
  void aTrailingSliceGroupOnAnAutoAddedSlicerHasItsMinRaised() throws Exception {
    StructureDefinition sd = profile(0, 1, 1);
    sd.getSnapshot().getElementList().get(1).setUserData(UserDataNames.SNAPSHOT_auto_added_slicing, true);

    checkSliceCardinalitySums(profileUtilities(), sd);

    assertEquals(2, sd.getSnapshot().getElementList().get(1).getMin(),
        "an auto-added slicing entry takes the min of its slices rather than reporting it");
  }

  @Test
  void aSliceGroupFollowedByAnotherElementIsStillChecked() throws Exception {
    ProfileUtilities profileUtilities = profileUtilities();
    StructureDefinition sd = profile(0, 1, 1);
    // an element after the group, which is what used to be required to flush the counter
    sd.getSnapshot().addElement().setPath("Patient.active");

    checkSliceCardinalitySums(profileUtilities, sd);

    assertTrue(messageAbout(profileUtilities, "add up to a minimum of 2"),
        "the pre-existing path has to keep working");
  }

  /**
   * Patient, one sliced identifier declaring slicerMin, then one slice per min given.
   * checkMin only reports when the slices sum to MORE than the slicer's own min, so the
   * slicer is left at 0 and the two slices add up to 2.
   */
  private StructureDefinition profile(int slicerMin, int... sliceMins) {
    StructureDefinition sd = new StructureDefinition();
    sd.setType("Patient");
    sd.setUrl("http://example.org/StructureDefinition/test");
    sd.getSnapshot().addElement().setPath("Patient");
    ElementDefinition slicer = sd.getSnapshot().addElement();
    slicer.setPath(PATH).setMin(slicerMin).setMax("*");
    slicer.setId(PATH);
    slicer.getSlicing().setRules(ElementDefinition.SlicingRules.OPEN);
    slicer.getBase().setPath(PATH).setMin(0).setMax("*");
    int n = 0;
    for (int min : sliceMins) {
      ElementDefinition slice = sd.getSnapshot().addElement();
      slice.setPath(PATH).setSliceName("s" + n++).setMin(min).setMax("1");
      slice.getBase().setPath(PATH).setMin(0).setMax("*");
    }
    return sd;
  }

  /** protected, and this test package is not org.hl7.fhir.services.conformance.profile. */
  private void checkSliceCardinalitySums(ProfileUtilities profileUtilities, StructureDefinition sd)
      throws Exception {
    Method method = ProfileUtilities.class.getDeclaredMethod(
        "checkSliceCardinalitySums", StructureDefinition.class);
    method.setAccessible(true);
    method.invoke(profileUtilities, sd);
  }

  private ProfileUtilities profileUtilities() {
    return new ProfileUtilities(null, new ArrayList<>(), null);
  }

  private boolean messageAbout(ProfileUtilities profileUtilities, String fragment) {
    List<ValidationMessage> messages = profileUtilities.getMessages();
    return messages != null && messages.stream().anyMatch(m -> m.getMessage().contains(fragment));
  }
}
