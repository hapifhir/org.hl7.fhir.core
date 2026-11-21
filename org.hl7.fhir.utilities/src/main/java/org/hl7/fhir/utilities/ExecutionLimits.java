package org.hl7.fhir.utilities;

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

  private final long maxMillis;
  private final int maxDepth;
  private final int maxItems;
  private final int maxStringLength;
  private final long maxSteps;

  private long deadline; // 0: the clock hasn't started
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
   * Whether the run is out of time. The clock starts the first time this is asked
   */
  public boolean isOutOfTime() {
    if (maxMillis <= 0) {
      return false;
    }
    long now = System.currentTimeMillis();
    if (deadline == 0) {
      // the sum can't overflow (a huge maxMillis is as good as no limit)
      deadline = now > Long.MAX_VALUE - maxMillis ? Long.MAX_VALUE : now + maxMillis;
      return false;
    }
    return now > deadline;
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

  public int getDepth() {
    return depth;
  }

  /** One more step of work: false if that's more than the run can take */
  public boolean step() {
    steps++;
    return maxSteps <= 0 || steps <= maxSteps;
  }

  public long getMaxSteps() {
    return maxSteps;
  }

  /** whether a collection of this many items is too big */
  public boolean isTooManyItems(int count) {
    return maxItems > 0 && count > maxItems;
  }

  /** whether a string this long is too long */
  public boolean isTooLong(long length) {
    return maxStringLength > 0 && length > maxStringLength;
  }

  public long getMaxMillis() {
    return maxMillis;
  }

  public int getMaxDepth() {
    return maxDepth;
  }

  public int getMaxItems() {
    return maxItems;
  }

  public int getMaxStringLength() {
    return maxStringLength;
  }

  /** the time limit in seconds, as messages say it */
  public String maxSeconds() {
    return maxMillis % 1000 == 0 ? Long.toString(maxMillis / 1000) : Double.toString(maxMillis / 1000.0);
  }
}
