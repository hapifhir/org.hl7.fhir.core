package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.junit.jupiter.api.Test;

/**
 * Covers ProfileUtilities.chooseMatchingBaseSlice, which compares against a base slice's
 * type. findBaseSlices takes that type from getTypeFirstRep().getCode(), so it is null for
 * a base slice row that carries no type.
 */
class ProfileUtilitiesBaseSliceTest {

  @Test
  void aBaseSliceWithNoTypeDoesNotMatch() {
    BaseTypeSlice typeless = new BaseTypeSlice(new ElementDefinition(), null, 0, 0);

    assertNull(chooseMatchingBaseSlice(List.of(typeless), "Quantity"));
  }

  @Test
  void aBaseSliceWithNoTypeDoesNotHideALaterMatch() {
    BaseTypeSlice typeless = new BaseTypeSlice(new ElementDefinition(), null, 0, 0);
    BaseTypeSlice quantity = new BaseTypeSlice(new ElementDefinition(), "Quantity", 1, 1);

    assertSame(quantity, chooseMatchingBaseSlice(List.of(typeless, quantity), "Quantity"));
  }

  @Test
  void aMatchingBaseSliceIsStillReturned() {
    BaseTypeSlice quantity = new BaseTypeSlice(new ElementDefinition(), "Quantity", 0, 0);

    assertSame(quantity, chooseMatchingBaseSlice(List.of(quantity), "Quantity"));
  }

  private BaseTypeSlice chooseMatchingBaseSlice(List<BaseTypeSlice> slices, String type) {
    return new ProfileUtilities(null, new ArrayList<>(), null).chooseMatchingBaseSlice(slices, type);
  }
}
