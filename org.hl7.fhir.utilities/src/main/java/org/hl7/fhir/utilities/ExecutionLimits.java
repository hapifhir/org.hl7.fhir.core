package org.hl7.fhir.utilities;

import lombok.Getter;

/**
 * A budget for one run of an expression language or template engine (FHIRPath, Liquid) over content that can't be
 * trusted: an expression comes from content (an invariant, a template, a ViewDefinition), and can be written so that it
 * never ends, or so that it makes collections or strings too big for memory.
 * <p/>
 * One budget covers a whole run, however it's made up: when Liquid runs FHIRPath, the FHIRPath expressions spend the
 * template's budget (see {@link LimitedExecutionContext}), rather than each getting a fresh one.
 * <p/>
 * Not thread safe: a budget is for one run, on one thread.
 */
public class ExecutionLimits {

  /** the longest a run can take (ms) */
  public static final long DEFAULT_MAX_MILLIS = 60000;
  /** how deeply a template can nest (for, if, capture and include inside each other) */
  public static final int DEFAULT_MAX_DEPTH = 100;
  /** the biggest collection a run can make */
  public static final int DEFAULT_MAX_ITEMS = 10000000;
  /** the longest string a run can make (characters) */
  public static final int DEFAULT_MAX_STRING_LENGTH = 10000000;

  @Getter
  private final long maxMillis;
  @Getter
  private final int maxDepth;
  @Getter
  private final int maxItems;
  @Getter
  private final int maxStringLength;
  @Getter
  private final long maxSteps;

  /**
   * isOutOfTime() reads the clock once per this many units of work (a call is one unit, unless it says how many it is).
   * It's cheap (~25ns), but FHIRPath asks twice for every node it evaluates; a run goes over its time by no more than
   * this many units of work
   */
  static final int WORK_UNITS_PER_CLOCK_READ = 50;

  private boolean started; // whether the clock has started
  private long start; // System.nanoTime() when it did
  private boolean outOfTime; // once out of time, always out of time
  private long workUnitsSinceLastClockRead; // units of work since the clock was last read
  @Getter
  private int depth;
  private long steps;

  public ExecutionLimits() {
    this(DEFAULT_MAX_MILLIS, DEFAULT_MAX_DEPTH, DEFAULT_MAX_ITEMS, DEFAULT_MAX_STRING_LENGTH);
  }

  /**
   * Each limit that is 0 or less isn't a limit
   */
  public ExecutionLimits(long maxMillis, int maxDepth, int maxItems, int maxStringLength) {
    this(maxMillis, maxDepth, maxItems, maxStringLength, 0);
  }

  /**
   * Each limit that is 0 or less isn't a limit
   *
   * @param maxSteps how many steps of work the run can take, where an engine counts them (e.g. each rule a
   *   StructureMap transform runs)
   */
  public ExecutionLimits(long maxMillis, int maxDepth, int maxItems, int maxStringLength, long maxSteps) {
    this.maxMillis = maxMillis;
    this.maxDepth = maxDepth;
    this.maxItems = maxItems;
    this.maxStringLength = maxStringLength;
    this.maxSteps = maxSteps;
  }

  /**
   * Whether the run is out of time. The clock starts the first time this is asked. To keep this cheap, the clock is only
   * read once per CLOCK_EVERY units of work, so a run is found to be out of time up to that many units late. Once out of
   * time, the run stays out of time (so a caller can ask, after an engine has failed, whether that was why)
   * <p/>
   * This call counts as one unit of work: see isOutOfTime(long) for a step that does more
   */
  public boolean isOutOfTime() {
    return isOutOfTime(1);
  }

  /**
   * As isOutOfTime(), for a step that does this many units of work - e.g. one pass of the outer loop of a pair-wise
   * comparison (distinct(), ~, union()...), where the work is the number of items the inner loop compares against. Each
   * call by itself is one step, so without this the clock could go unread for a very long time while each step does
   * a lot of work
   */
  public boolean isOutOfTime(long workUnit) {
    if (maxMillis <= 0) {
      return false;
    }
    if (outOfTime) {
      return true;
    }
    if (!started) {
      return startClock();
    }
    workUnitsSinceLastClockRead += Math.max(workUnit, 1);
    if (workUnitsSinceLastClockRead < WORK_UNITS_PER_CLOCK_READ) {
      return false;
    }
    return readClock();
  }

  /**
   * As isOutOfTime(), but always reads the clock: for a check before a step that may itself take a while (a lookup or
   * search that the host does), where being up to CLOCK_EVERY steps late would be too late
   */
  public boolean isOutOfTimeNow() {
    if (maxMillis <= 0) {
      return false;
    }
    if (outOfTime) {
      return true;
    }
    if (!started) {
      return startClock();
    }
    return readClock();
  }

  private boolean startClock() {
    started = true;
    start = System.nanoTime();
    return false;
  }

  private boolean readClock() {
    workUnitsSinceLastClockRead = 0;
    // nanoTime (not currentTimeMillis): it's not changed when the system clock is set. Elapsed time is compared, not a
    // deadline, so a huge maxMillis can't overflow
    long elapsedMillis = (System.nanoTime() - start) / 1_000_000;
    outOfTime = elapsedMillis > maxMillis;
    return outOfTime;
  }

  /**
   * Going a level deeper. False (and still at the same level) if that's too deep: then don't call exit()
   */
  public boolean enter() {
    depth++;
    if (maxDepth > 0 && depth > maxDepth) {
      depth--;
      return false;
    }
    return true;
  }

  /** Coming back out of a level that enter() let in */
  public void exit() {
    depth--;
  }

  /** One more step of work: false if that's more than the run can take */
  public boolean step() {
    steps++;
    return maxSteps <= 0 || steps <= maxSteps;
  }

  /** whether a collection of this many items is too big */
  public boolean isTooManyItems(int count) {
    return maxItems > 0 && count > maxItems;
  }

  /** whether a string this long is too long */
  public boolean isTooLong(long length) {
    return maxStringLength > 0 && length > maxStringLength;
  }

  /** the time limit in seconds, as messages say it */
  public String maxSeconds() {
    return maxMillis % 1000 == 0 ? Long.toString(maxMillis / 1000) : Double.toString(maxMillis / 1000.0);
  }
}
