package org.hl7.fhir.r5.terminologies.utilities;

import org.apache.commons.collections4.map.PassiveExpiringMap;

import java.util.concurrent.TimeUnit;


public class CommonsTerminologyCapabilitiesCache<V> implements TerminologyCapabilitiesCache<V>{

  PassiveExpiringMap<String, V> cache;

  public CommonsTerminologyCapabilitiesCache(long timeToLive, TimeUnit timeUnit) {
    cache = new PassiveExpiringMap<>(timeToLive, timeUnit);
  }

  @Override
  public boolean containsKey(String key) {
    return cache.containsKey(key);
  }

  @Override
  public V get(String key) {
    return cache.get(key);
  }

  @Override
  public V put(String key, V value) {
    return cache.put(key, value);
  }
}
