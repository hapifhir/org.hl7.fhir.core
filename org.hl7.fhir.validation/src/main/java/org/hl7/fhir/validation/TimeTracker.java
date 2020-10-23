package org.hl7.fhir.validation;

public class TimeTracker {
  private long overall = 0;
  private long txTime = 0;
  private long sdTime = 0;
  private long loadTime = 0;
  private long fpeTime = 0;

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
  
  public void load(long start) {
    loadTime = loadTime + (System.nanoTime() - start);
  }
  
  public void overall(long start) {  
    overall = overall + (System.nanoTime() - start);
  }
  
  public void tx(long start) {
    txTime = txTime + (System.nanoTime() - start);
  }
  
  public void sd(long start) {
    sdTime = sdTime + (System.nanoTime() - start);
  }
  
  public void fpe(long start) {
    fpeTime = fpeTime + (System.nanoTime() - start);
  }
  
  public void reset() {
    overall = 0;
    txTime = 0;
    sdTime = 0;
    loadTime = 0;
    fpeTime = 0;
  }
}