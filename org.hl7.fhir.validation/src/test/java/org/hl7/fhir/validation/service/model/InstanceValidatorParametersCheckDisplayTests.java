package org.hl7.fhir.validation.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.hl7.fhir.services.validation.constants.IdStatus;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * checkDisplay never had any effect, and is deprecated. Parameters that still carry it (e.g. from a
 * validator-wrapper client) are read, and it is ignored; it is never written
 */
class InstanceValidatorParametersCheckDisplayTests {

  private static final String JSON = "{\"checkDisplay\":\"CheckCase\",\"resourceIdRule\":\"REQUIRED\"}";

  @Test
  void jacksonReadsAndIgnoresCheckDisplay() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    InstanceValidatorParameters params = mapper.readValue(JSON, InstanceValidatorParameters.class);
    assertEquals(new InstanceValidatorParameters().setResourceIdRule(IdStatus.REQUIRED), params);
    String written = mapper.writeValueAsString(params);
    assertFalse(written.contains("checkDisplay"), written);
  }

  @Test
  void gsonReadsAndIgnoresCheckDisplay() {
    Gson gson = new Gson();
    InstanceValidatorParameters params = gson.fromJson(JSON, InstanceValidatorParameters.class);
    assertEquals(new InstanceValidatorParameters().setResourceIdRule(IdStatus.REQUIRED), params);
    String written = gson.toJson(params);
    assertFalse(written.contains("checkDisplay"), written);
  }
}
