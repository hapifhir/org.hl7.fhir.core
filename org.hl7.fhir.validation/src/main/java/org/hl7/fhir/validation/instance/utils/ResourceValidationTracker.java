package org.hl7.fhir.validation.instance.utils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.utilities.validation.ValidationMessage;

/**
 * The validator keeps one of these for each validation, to track which resources it has validated against which
 * profiles (e.g. when chasing references)
 * <p>
 * A given resource may be validated against multiple profiles during a single validation, and it may be valid
 * against some, and invalid against others. We don't want to keep doing the same validation, so we remember the
 * outcomes for each combination of resource + profile
 * <p>
 * Additionally, profile validation may be circular - e.g. a Patient profile that applies the same profile
 * to linked patients, and 2 patient resources that link to each other. So this class also tracks validation
 * in process.
 * <p>
 * If the validator comes back to the same point, and validates the same instance against the same profile
 * while it's already validating, it assumes it's valid - it cannot have new errors that wouldn't already
 * be found in the first iteration - in other words, there's no errors
 * <p>
 * When the entries of a Bundle are validated concurrently, the threads share one tracker. The first thread to start
 * validating a resource against a profile does it, and the others wait for its outcome. A thread that would wait for
 * a validation that is itself waiting, directly or through other threads, for that thread is in the same position as
 * a circular reference on one thread, and gets the same answer: no errors.
 *
 * @author graha
 */
public class ResourceValidationTracker {

  private record Key(Element resource, String url) {
    @Override
    public boolean equals(Object other) {
      return other instanceof Key key && key.resource == resource && key.url.equals(url);
    }

    @Override
    public int hashCode() {
      return System.identityHashCode(resource) * 31 + url.hashCode();
    }
  }

  private record Validation(Thread owner, CompletableFuture<List<ValidationMessage>> outcome) {}

  private final ConcurrentHashMap<Key, Validation> validations = new ConcurrentHashMap<>();
  private final ConcurrentHashMap<Thread, Key> waitingFor = new ConcurrentHashMap<>();

  /**
   * Called before validating a resource against a profile.
   *
   * @return null if the caller should do the validation, and then call {@link #storeOutcomes} (or
   * {@link #abandon} if it throws). Otherwise, the outcome of the validation already done, or no errors if the
   * validation is in progress further up the caller's own path (a circular reference)
   */
  public List<ValidationMessage> startValidating(Element resource, StructureDefinition sd) {
    Key key = new Key(resource, sd.getUrl());
    Thread me = Thread.currentThread();
    Validation existing = validations.putIfAbsent(key, new Validation(me, new CompletableFuture<>()));
    if (existing == null) {
      return null;
    }
    if (existing.outcome().isDone() || existing.owner() == me) {
      return existing.outcome().getNow(List.of());
    }
    // register before looking for a cycle, so that of two threads about to wait for each other, at least one sees
    // the other's registration
    waitingFor.put(me, key);
    try {
      if (waitsFor(existing.owner(), me)) {
        return List.of();
      }
      return join(existing);
    } finally {
      waitingFor.remove(me);
    }
  }

  public void storeOutcomes(Element resource, StructureDefinition sd, List<ValidationMessage> errors) {
    validations.get(new Key(resource, sd.getUrl())).outcome().complete(errors);
  }

  /**
   * The validation the caller started didn't finish (it threw). As on a single thread, where the validation would
   * stay in progress, it is treated as having no errors from now on; the exception itself reaches the caller of the
   * validation through the thread that threw it.
   */
  public void abandon(Element resource, StructureDefinition sd) {
    Validation validation = validations.get(new Key(resource, sd.getUrl()));
    if (validation != null) {
      validation.outcome().complete(List.of());
    }
  }

  public void clear() {
    validations.clear();
    waitingFor.clear();
  }

  /**
   * Whether {@code thread} is waiting, directly or through other threads, for a validation owned by {@code target}.
   */
  private boolean waitsFor(Thread thread, Thread target) {
    Thread next = thread;
    for (int hops = 0; next != null && hops <= waitingFor.size() + 1; hops++) {
      if (next == target) {
        return true;
      }
      Key key = waitingFor.get(next);
      Validation validation = key == null ? null : validations.get(key);
      next = validation == null ? null : validation.owner();
    }
    return false;
  }

  private static List<ValidationMessage> join(Validation validation) {
    try {
      return validation.outcome().get();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new FHIRException(e);
    } catch (ExecutionException e) {
      // outcomes are only ever completed normally
      throw new FHIRException(e.getCause());
    }
  }
}
