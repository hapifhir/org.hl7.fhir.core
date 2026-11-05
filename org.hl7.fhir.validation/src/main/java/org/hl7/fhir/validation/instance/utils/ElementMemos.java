package org.hl7.fhir.validation.instance.utils;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import org.hl7.fhir.r5.elementmodel.Element;

/**
 * What the validator remembers about each element of the instance it is validating: indexes it built, outcomes it
 * can replay, and whether it has already reported something. There is one memo object per element, of a type the
 * validator defines ({@code M}), with a field for each thing remembered.
 * <p>
 * These used to be kept in the elements' user data, under one key each, tagged with the session or execution they
 * belonged to. Keeping them here instead means the validator never writes its working state into the caller's
 * element tree, and that the entries of a Bundle can be validated on several threads at once: finding or making an
 * element's memo is thread-safe, and the memo types make their own fields safe.
 * <p>
 * There are two lifetimes:
 * <ul>
 *   <li>{@link #forExecution}: one call to {@code validate()}. The validator drops it when the next validation starts.</li>
 *   <li>{@link #forSession}: a {@code ValidatorSession}, which may validate many instances. Elements are held weakly,
 *   so the memos don't keep the instances the session has finished with in memory.</li>
 * </ul>
 * Elements are compared by identity (Element does not override equals or hashCode).
 */
public abstract class ElementMemos<M> {

  private final Supplier<M> maker;

  private ElementMemos(Supplier<M> maker) {
    this.maker = maker;
  }

  public static <M> ElementMemos<M> forExecution(Supplier<M> maker) {
    return new ExecutionMemos<>(maker);
  }

  public static <M> ElementMemos<M> forSession(Supplier<M> maker) {
    return new SessionMemos<>(maker);
  }

  /**
   * The element's memo, made the first time it is asked for. If two threads ask at once, both get the same one.
   */
  public M of(Element element) {
    return memoOf(element, maker);
  }

  /**
   * The element's memo, or null if nothing has been remembered about it.
   */
  public M peek(Element element) {
    return memoOf(element, null);
  }

  protected abstract M memoOf(Element element, Supplier<M> maker);

  /**
   * A field of a memo that is worked out the first time it's needed. If two threads need it at once, it's worked out
   * once and both get it.
   */
  public static final class Once<T> {
    private volatile T value;

    public T get(Supplier<T> maker) {
      T res = value;
      if (res == null) {
        synchronized (this) {
          res = value;
          if (res == null) {
            res = maker.get();
            value = res;
          }
        }
      }
      return res;
    }

    public T peek() {
      return value;
    }

    public void set(T value) {
      this.value = value;
    }
  }

  private static class ExecutionMemos<M> extends ElementMemos<M> {
    private final Map<IdentityKey, M> memos = new ConcurrentHashMap<>();

    private ExecutionMemos(Supplier<M> maker) {
      super(maker);
    }

    @Override
    protected M memoOf(Element element, Supplier<M> maker) {
      IdentityKey key = new IdentityKey(element);
      return maker == null ? memos.get(key) : memos.computeIfAbsent(key, k -> maker.get());
    }
  }

  private static class SessionMemos<M> extends ElementMemos<M> {
    // a WeakHashMap compares keys with equals and hashCode, which Element leaves as identity
    private final Map<Element, M> memos = Collections.synchronizedMap(new WeakHashMap<>());

    private SessionMemos(Supplier<M> maker) {
      super(maker);
    }

    @Override
    protected M memoOf(Element element, Supplier<M> maker) {
      return maker == null ? memos.get(element) : memos.computeIfAbsent(element, k -> maker.get());
    }
  }

  private static final class IdentityKey {
    private final Element element;

    private IdentityKey(Element element) {
      this.element = element;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof IdentityKey key && key.element == element;
    }

    @Override
    public int hashCode() {
      return System.identityHashCode(element);
    }
  }
}
