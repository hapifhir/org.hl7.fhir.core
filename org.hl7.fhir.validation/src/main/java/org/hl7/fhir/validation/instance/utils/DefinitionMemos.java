package org.hl7.fhir.validation.instance.utils;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

import com.google.common.collect.MapMaker;

/**
 * What the validator works out from a definition (a profile, an element definition, a constraint) and keeps for as
 * long as the definition is alive: a parsed FHIRPath expression, or a fact about a profile. One table per kind of
 * value, with the definition as the key.
 * <p>
 * These used to be written into the definitions' user data the first time they were needed. Definitions are shared:
 * a server hands the same objects to every thread that validates, and user data is a plain HashMap, so two threads
 * filling it at once could lose writes, corrupt the map, or see a parsed expression before it was complete. This
 * table is a concurrent map, and it compares keys by identity and holds them weakly, as user data did: it doesn't
 * keep a definition alive after the context has dropped it.
 * <p>
 * If two threads work out the same value at once, both do the work and both get the value stored first. The values
 * depend only on the definition, so either would do. A value must not refer back to its definition, or the definition
 * would never be collected.
 */
public final class DefinitionMemos<D, M> {

  private final ConcurrentMap<D, M> memos = new MapMaker().weakKeys().makeMap();

  /**
   * The definition's value, worked out the first time it is asked for.
   */
  public M of(D definition, Function<? super D, ? extends M> maker) {
    M res = memos.get(definition);
    return res != null ? res : remember(definition, maker.apply(definition));
  }

  /**
   * The definition's value, or null if it hasn't been worked out yet.
   */
  public M peek(D definition) {
    return memos.get(definition);
  }

  /**
   * Stores a value worked out for the definition, unless another thread stored one first.
   *
   * @return the value now stored, which callers should use instead of their own
   */
  public M remember(D definition, M value) {
    M prior = memos.putIfAbsent(definition, value);
    return prior != null ? prior : value;
  }
}
