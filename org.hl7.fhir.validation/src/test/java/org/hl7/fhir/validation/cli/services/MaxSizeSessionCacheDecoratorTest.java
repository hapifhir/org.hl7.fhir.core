package org.hl7.fhir.validation.cli.services;

import org.hl7.fhir.validation.ValidationEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;


import static org.mockito.Mockito.mock;

public class MaxSizeSessionCacheDecoratorTest {

  private List<ValidationEngine> getMockedEngines(int count) {
    List<ValidationEngine> engines = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      engines.add(mock(ValidationEngine.class));
    }
    return engines;
  }

  private LinkedHashMap<String, ValidationEngine> addMockedEngines(SessionCache cache, int count) {
    LinkedHashMap<String, ValidationEngine> engineMap = new LinkedHashMap<>();
    List<ValidationEngine> engines = getMockedEngines(count);
    for (ValidationEngine engine : engines) {
      String key = cache.cacheSession(engine);
      engineMap.put(key, engine);
    }
    return engineMap;
  }

  @Test
  public void trivialCase() {

    MaxSizeSessionCacheDecorator maxSizeSessionCacheDecorator = new MaxSizeSessionCacheDecorator(new PassiveExpiringSessionCache(), 4);

    LinkedHashMap<String, ValidationEngine> initialEngines = addMockedEngines(maxSizeSessionCacheDecorator, 3);

    Assertions.assertEquals(3, maxSizeSessionCacheDecorator.getSessionIds().size());

    List<ValidationEngine> newEngines = getMockedEngines(2);

    for (ValidationEngine engine : newEngines) {
      maxSizeSessionCacheDecorator.cacheSession(engine);
    }

    Assertions.assertEquals(4, maxSizeSessionCacheDecorator.getSessionIds().size());

    Assertions.assertTrue(maxSizeSessionCacheDecorator.getSessionIds().contains()
  }

}
