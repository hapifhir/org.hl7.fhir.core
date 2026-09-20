package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.services.conformance.profile.BaseTypeSlice;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name.
 */
class ProfileUtilitiesBaseSliceTest {

  @Test
  void aBaseSliceWithNoTypeDoesNotMatch() throws Exception {
    BaseTypeSlice typeless = new BaseTypeSlice(new ElementDefinition(), null, 0, 0);

    assertNull(chooseMatchingBaseSlice(List.of(typeless), "Quantity"));
  }

  @Test
  void aBaseSliceWithNoTypeDoesNotHideALaterMatch() throws Exception {
    BaseTypeSlice typeless = new BaseTypeSlice(new ElementDefinition(), null, 0, 0);
    BaseTypeSlice quantity = new BaseTypeSlice(new ElementDefinition(), "Quantity", 1, 1);

    assertSame(quantity, chooseMatchingBaseSlice(List.of(typeless, quantity), "Quantity"));
  }

  @Test
  void aMatchingBaseSliceIsStillReturned() throws Exception {
    BaseTypeSlice quantity = new BaseTypeSlice(new ElementDefinition(), "Quantity", 0, 0);

    assertSame(quantity, chooseMatchingBaseSlice(List.of(quantity), "Quantity"));
  }

  /** chooseMatchingBaseSlice is protected, and this test is in a different package. */
  private BaseTypeSlice chooseMatchingBaseSlice(List<BaseTypeSlice> slices, String type)
      throws Exception {
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);
    Method method = ProfileUtilities.class.getDeclaredMethod(
        "chooseMatchingBaseSlice", List.class, String.class);
    method.setAccessible(true);
    return (BaseTypeSlice) method.invoke(profileUtilities, slices, type);
  }
}
