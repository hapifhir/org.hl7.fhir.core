package org.hl7.fhir.validation.cli.services;

import org.apache.commons.collections4.map.PassiveExpiringMap;
import org.hl7.fhir.validation.ValidationEngine;

import java.util.concurrent.TimeUnit;

public class SessionCache {

  private static final long TIME_TO_LIVE = 60;
  private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

  private PassiveExpiringMap<String, ValidationEngine> cachedSessions = new PassiveExpiringMap<>();


}
