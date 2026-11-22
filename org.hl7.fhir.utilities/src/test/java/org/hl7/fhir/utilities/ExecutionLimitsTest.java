package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ExecutionLimitsTest {

  /** a huge time limit, or none, is never out of time (a huge one used to overflow, and was always out of time) */
  @ParameterizedTest
  @ValueSource(longs = {Long.MAX_VALUE, Long.MAX_VALUE - 1, 0, -1, Long.MIN_VALUE})
  void noTimeLimit(long maxMillis) {
    ExecutionLimits limits = new ExecutionLimits(maxMillis, 0, 0, 0);
    for (int i = 0; i < ExecutionLimits.CLOCK_EVERY * 3; i++) {
      assertFalse(limits.isOutOfTime());
    }
    assertFalse(limits.isOutOfTimeNow());
  }

  @Test
  void runningOutOfTime() throws InterruptedException {
    ExecutionLimits limits = new ExecutionLimits(1, 0, 0, 0);
    assertFalse(limits.isOutOfTimeNow()); // starts the clock
    Thread.sleep(20);
    assertTrue(limits.isOutOfTimeNow());
    assertEquals("0.001", limits.maxSeconds());
    assertEquals("60", new ExecutionLimits().maxSeconds());
  }

  /** isOutOfTime() reads the clock one call in CLOCK_EVERY: it says so within that many calls, and then stays out of time */
  @Test
  void runningOutOfTimeIsNoticedWithinAFewCalls() throws InterruptedException {
    ExecutionLimits limits = new ExecutionLimits(1, 0, 0, 0);
    assertFalse(limits.isOutOfTime()); // starts the clock
    Thread.sleep(20);
    int calls = 0;
    while (!limits.isOutOfTime()) {
      calls++;
      assertTrue(calls < ExecutionLimits.CLOCK_EVERY, "not noticed after " + calls + " calls");
    }
    assertTrue(calls < ExecutionLimits.CLOCK_EVERY);
    for (int i = 0; i < ExecutionLimits.CLOCK_EVERY * 3; i++) {
      assertTrue(limits.isOutOfTime());
    }
    assertTrue(limits.isOutOfTimeNow());
  }

  /** while there's time, it's never out of time, however often it's asked */
  @Test
  void notOutOfTimeWhileThereIsTime() {
    ExecutionLimits limits = new ExecutionLimits(60000, 0, 0, 0);
    for (int i = 0; i < ExecutionLimits.CLOCK_EVERY * 10; i++) {
      assertFalse(limits.isOutOfTime());
    }
    assertFalse(limits.isOutOfTimeNow());
  }

  @Test
  void depth() {
    ExecutionLimits limits = new ExecutionLimits(0, 2, 0, 0);
    assertTrue(limits.enter());
    assertTrue(limits.enter());
    assertFalse(limits.enter());
    assertEquals(2, limits.getDepth());
    limits.exit();
    assertTrue(limits.enter());
    // no limit
    ExecutionLimits none = new ExecutionLimits(0, 0, 0, 0);
    for (int i = 0; i < 1000; i++) {
      assertTrue(none.enter());
    }
  }

  @Test
  void sizes() {
    ExecutionLimits limits = new ExecutionLimits(0, 0, 10, 20);
    assertFalse(limits.isTooManyItems(10));
    assertTrue(limits.isTooManyItems(11));
    assertFalse(limits.isTooLong(20));
    assertTrue(limits.isTooLong(21));
    ExecutionLimits none = new ExecutionLimits(0, 0, 0, 0);
    assertFalse(none.isTooManyItems(Integer.MAX_VALUE));
    assertFalse(none.isTooLong(Long.MAX_VALUE));
  }

  @Test
  void steps() {
    ExecutionLimits limits = new ExecutionLimits(0, 0, 0, 0, 3);
    assertTrue(limits.step());
    assertTrue(limits.step());
    assertTrue(limits.step());
    assertFalse(limits.step());
    ExecutionLimits none = new ExecutionLimits();
    for (int i = 0; i < 1000; i++) {
      assertTrue(none.step());
    }
  }

  @Test
  void limitsOfAnAppContext() {
    ExecutionLimits limits = new ExecutionLimits();
    LimitedExecutionContext ctxt = new LimitedExecutionContext(limits) {};
    assertSame(limits, LimitedExecutionContext.limitsOf(ctxt));
    assertNull(LimitedExecutionContext.limitsOf("an app context"));
    assertNull(LimitedExecutionContext.limitsOf(null));
  }
}
