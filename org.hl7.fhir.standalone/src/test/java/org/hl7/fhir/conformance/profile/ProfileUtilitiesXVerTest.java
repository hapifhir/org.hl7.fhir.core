package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name, covering the difference
 * between getXver() (the raw field) and makeXVer() (creates the manager on first use).
 *
 * <p>makeXVer is package visible to org.hl7.fhir.services.conformance.profile, which this
 * test package is not, so it is reached by reflection.
 */
class ProfileUtilitiesXVerTest {

  @Test
  void makeXVerCreatesTheManagerThatTheRawGetterDoesNotHave() throws Exception {
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);

    assertNull(profileUtilities.getXver(), "nothing has called setXver, so the raw field is empty");
    assertNotNull(makeXVer(profileUtilities), "makeXVer has to produce a manager regardless");
    assertSame(profileUtilities.getXver(), makeXVer(profileUtilities), "and cache it in the same field");
  }

  private Object makeXVer(ProfileUtilities profileUtilities) throws Exception {
    Method method = ProfileUtilities.class.getDeclaredMethod("makeXVer");
    method.setAccessible(true);
    return method.invoke(profileUtilities);
  }
}
