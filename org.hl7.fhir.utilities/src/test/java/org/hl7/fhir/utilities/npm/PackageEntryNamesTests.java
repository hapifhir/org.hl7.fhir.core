package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

class PackageEntryNamesTests {

  @Test
  void testAdd() {
    PackageEntryNames names = new PackageEntryNames();
    assertTrue(names.add("package/ValueSet-abc.json"));
    assertTrue(names.add("package/ValueSet-abd.json"));
    // exactly the same again: a duplicate add, not an error
    assertFalse(names.add("package/ValueSet-abc.json"));
    // the same file to some systems: an error
    FHIRException e = assertThrows(FHIRException.class, () -> names.add("package/ValueSet-ABC.json"));
    assertTrue(e.getMessage().contains("package/ValueSet-abc.json and package/ValueSet-ABC.json"), e.getMessage());
    assertThrows(FHIRException.class, () -> names.add("./package//ValueSet-abd.json"));
  }

  @Test
  void testContains() {
    PackageEntryNames names = new PackageEntryNames();
    names.add("package/ValueSet-abc.json");
    assertTrue(names.contains("package/ValueSet-abc.json"));
    assertTrue(names.contains("package/ValueSet-ABC.json"));
    assertTrue(names.contains("./package//ValueSet-abc.json"));
    assertFalse(names.contains("package/ValueSet-abd.json"));
  }
}
