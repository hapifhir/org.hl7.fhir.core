package org.hl7.fhir.utilities;

import java.util.UUID;

public class UUIDUtilities {
  private static final String UUID_REGEX = "[0-9a-f]{8}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{4}\\-[0-9a-f]{12}";

  public static String makeUuidLC() {
    return UUID.randomUUID().toString().toLowerCase();
  }

  public static String makeUuidUrn() {
    return "urn:uuid:" + UUID.randomUUID().toString().toLowerCase();
  }

  public static boolean isValidUUID(String uuid) {
    return uuid.matches(UUID_REGEX);
  }
}
