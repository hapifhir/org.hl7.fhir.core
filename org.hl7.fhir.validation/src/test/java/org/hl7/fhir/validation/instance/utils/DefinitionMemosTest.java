package org.hl7.fhir.validation.instance.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.junit.jupiter.api.Test;

class DefinitionMemosTest {

  @Test
  void theFirstValueStoredIsKept() {
    DefinitionMemos<ElementDefinitionConstraintComponent, String> memos = new DefinitionMemos<>();
    ElementDefinitionConstraintComponent inv = constraint();

    assertNull(memos.peek(inv));
    assertEquals("first", memos.remember(inv, "first"));
    assertEquals("first", memos.remember(inv, "second"));
    assertEquals("first", memos.of(inv, d -> "third"));
    assertEquals("first", memos.peek(inv));
  }

  @Test
  void ofWorksTheValueOutOnce() {
    DefinitionMemos<ElementDefinitionConstraintComponent, String> memos = new DefinitionMemos<>();
    ElementDefinitionConstraintComponent inv = constraint();
    AtomicInteger made = new AtomicInteger();

    memos.of(inv, d -> "made " + made.incrementAndGet());
    memos.of(inv, d -> "made " + made.incrementAndGet());

    assertEquals(1, made.get());
  }

  @Test
  void definitionsAreComparedByIdentity() {
    DefinitionMemos<ElementDefinitionConstraintComponent, String> memos = new DefinitionMemos<>();
    ElementDefinitionConstraintComponent one = constraint();
    ElementDefinitionConstraintComponent same = constraint();

    memos.remember(one, "one");

    assertNull(memos.peek(same));
    // and the definition itself is left alone
    assertNull(one.getUserData("validator.expression.cache"));
  }

  @Test
  void threadsRememberingAtOnceAllGetOneValue() throws Exception {
    DefinitionMemos<ElementDefinitionConstraintComponent, String> memos = new DefinitionMemos<>();
    ElementDefinitionConstraintComponent inv = constraint();
    int threads = 16;
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService executor = Executors.newFixedThreadPool(threads);
    try {
      List<Future<String>> results = new ArrayList<>();
      for (int i = 0; i < threads; i++) {
        String mine = "thread " + i;
        results.add(executor.submit(() -> {
          start.await();
          return memos.remember(inv, mine);
        }));
      }
      start.countDown();

      Set<String> seen = new HashSet<>();
      for (Future<String> next : results) {
        seen.add(next.get());
      }
      assertEquals(1, seen.size());
      assertSame(memos.peek(inv), seen.iterator().next());
    } finally {
      executor.shutdownNow();
    }
  }

  private static ElementDefinitionConstraintComponent constraint() {
    return new ElementDefinitionConstraintComponent().setKey("inv-1").setExpression("name.exists()");
  }
}
