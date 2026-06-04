package org.hl7.fhir.validation;

import org.hl7.fhir.exceptions.TimeoutException;

public class ValidationTimeTracker {
  private long overall = 0;
  private long txTime = 0;
  private long sdTime = 0;
  private long loadTime = 0;
  private long fpeTime = 0;
  private long specTime = 0;
  private long aiTime = 0;

  public long getOverall() {
    return overall;
  }
  public long getTxTime() {
    return txTime;
  }
  public long getSdTime() {
    return sdTime;
  }
  public long getLoadTime() {
    return loadTime;
  }
  public long getFpeTime() {
    return fpeTime;
  }

  public long getSpecTime() {
    return specTime;
  }
  
  public long getAiTime() {
    return aiTime;
  }
  public void load(long start) {
    loadTime = loadTime + (System.nanoTime() - start);
  }
  
  public void overall(long start) {  
    overall = overall + (System.nanoTime() - start);
  }
  public void ai(long start) {  
    aiTime = aiTime + (System.nanoTime() - start);
  }
  
  public void tx(long start, String s) {
    txTime = txTime + (System.nanoTime() - start);
  }
  
  public void sd(long start) {
    sdTime = sdTime + (System.nanoTime() - start);
  }
  
  public void fpe(long start) {
    fpeTime = fpeTime + (System.nanoTime() - start);
  }
  
  public void spec(long start) {
    specTime = specTime + (System.nanoTime() - start);
  }
  
  public void reset() {
    overall = 0;
    txTime = 0;
    sdTime = 0;
    loadTime = 0;
    fpeTime = 0;
    specTime = 0;
    aiTime = 0;
  }

  // Add support for validation time out tracking using milliseconds
  private long overallVal = 0;
  private long startVal = 0;
  private long timeout = 0;

  /**
   * Initialize validation time out value in milliseconds, (re)set overall recorded time to zero,
   * (re)set starting time value to current system time in milliseconds
   * @param timeout Milliseconds
   */
  public void initializeValidationTimeout(long timeout) {
    this.timeout = timeout;
    overallVal = 0;
    startVal = System.currentTimeMillis();
  }

  /**
   * Update overall recorded time and compare to current time out value. If recorded time
   * exceeds current time out value, throw TimeoutException to be caught in validate entry
   * point method.
   * If current time out value is less than or equal to zero, ignore and skip this check.
   * @throws TimeoutException
   */
  public void checkValidationTimeoutExceeded() throws TimeoutException {
    if (timeout > 0) {
      overallVal = System.currentTimeMillis() - startVal;
      if (overallVal > timeout) {
        throw new TimeoutException("Validation process exceeded maximum allowed time of " + timeout + "ms.", timeout);
      }
    }
  }
}