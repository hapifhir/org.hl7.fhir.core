package org.hl7.fhir.r5.utils.validation;

import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.utilities.UUIDUtilities;

/**
 * Used by the validation infrastructure to cache internal infrastructure that
 * will be cast away when the session is closed by the application
 */
public class ValidatorSession {

  public static final String VIEW_DEFINITION_CONTEXT = "VIEW_DEFINITION_CONTEXT";
  
  private Map<String, Object> objects = new HashMap<>();
  protected String sessionId;
  
  public ValidatorSession() {
    super();
    sessionId = UUIDUtilities.makeUuidLC();
  }

  public String getSessionId() {
    return sessionId;
  }

  public Map<String, Object> getObjects() {
    return objects;
  }

  public void close() {
    objects.clear();
  }
}
