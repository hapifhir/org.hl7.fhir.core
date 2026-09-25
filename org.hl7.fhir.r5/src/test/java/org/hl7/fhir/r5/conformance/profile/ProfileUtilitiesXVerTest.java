package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Covers the difference between getXver(), which returns the raw field, and makeXVer(),
 * which creates the manager on first use.
 *
 * <p>Nothing calls setXver on the ProfileUtilities instances the validator builds, so any
 * consumer reading the raw field sees null until some other code path has happened to
 * populate it — which makes the result depend on processing order.
 */
class ProfileUtilitiesXVerTest {

  @Test
  void makeXVerCreatesTheManagerThatTheRawGetterDoesNotHave() {
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);

    assertNull(profileUtilities.getXver(), "nothing has called setXver, so the raw field is empty");
    assertNotNull(profileUtilities.makeXVer(), "makeXVer has to produce a manager regardless");
    assertSame(profileUtilities.getXver(), profileUtilities.makeXVer(), "and cache it in the same field");
  }
}
