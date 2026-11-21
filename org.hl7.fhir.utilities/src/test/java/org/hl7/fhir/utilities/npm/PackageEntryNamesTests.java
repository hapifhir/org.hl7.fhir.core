package org.hl7.fhir.utilities.npm;

import java.util.List;
import java.util.ArrayList;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

  @Test
  void namesAreTheNamesAsAddedInTheOrderAdded() {
    PackageEntryNames names = new PackageEntryNames();
    names.add("package/b.json");
    names.add("package/a.json");
    names.add("package/b.json");
    assertEquals(List.of("package/b.json", "package/a.json"), new ArrayList<>(names.getNames()));
    assertTrue(names.contains("./package/a.json"));
    assertFalse(names.getNames().contains("./package/a.json"));
  }
}
