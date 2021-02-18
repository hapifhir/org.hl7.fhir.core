package org.hl7.fhir.validation.cli.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.security.validator.ValidatorException;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SessionCacheTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  @DisplayName("Test session expiration works.")
  void expiredSession() {
    SessionCache cache = new SessionCache(5L, TimeUnit.SECONDS);
  }

  @Test
  void fetchSessionValidatorEngine() {
  }
}