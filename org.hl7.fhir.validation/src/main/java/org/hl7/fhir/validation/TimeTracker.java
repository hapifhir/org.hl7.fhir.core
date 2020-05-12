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
  
  public void load(long t, long nanoTime) {
    // TODO Auto-generated method stub
    
  }
  public void overall(long t, long nanoTime) {
    // TODO Auto-generated method stub
    
  }
  public void tx(long t, long nanoTime) {
    // TODO Auto-generated method stub
    
  }
  public void sd(long t, long nanoTime) {
    // TODO Auto-generated method stub
    
  }
  public void fpe(long t, long nanoTime) {
    // TODO Auto-generated method stub
    fpeTime = fpeTime + (System.nanoTime() - t);

  }
  public void reset() {
    overall = 0;
    txTime = 0;
    sdTime = 0;
    loadTime = 0;
    fpeTime = 0;
    
  }

}