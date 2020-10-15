package org.hl7.fhir.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.utilities.TimeTracker.Counter;

public class TimeTracker {

  public class Counter {
    private String name;
    private int count;
    private long length;
    public Counter(String name) {
      this.name = name;
    }
  }
  
  public class Session {
    private long start = System.nanoTime();
    private String name;
    public Session(String name) {
      this.name = name;
    }
    public void end() {
      endSession(this);
    }
  }
  
  private List<Session> sessions = new ArrayList<>();
  private List<Counter> records = new ArrayList<>();
  private long globalStart;
  private long milestone = 0;
  
  
  public TimeTracker() {
    super();
    globalStart = System.nanoTime();
  }

  public Session start(String name) {
    Counter c = null;
    for (Counter t : records) {
      if (t.name.equals(name)) {
        c = t;
      }
    }
    if (c == null) {
      c = new Counter(name);
      records.add(c);
    }
    Session session = new Session(name);
    sessions.add(session);
    return session;
  }

  private void endSession(Session session) {
    sessions.remove(session);
    Counter c = null;
    for (Counter t : records) {
      if (t.name.equals(session.name)) {
        c = t;
      }
    }
    c.count++;
    c.length = c.length + System.nanoTime() - session.start;
  }
  
  public String report() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
    for (Counter c : records) {
      if (c.count == 1) {
        b.append(c.name+": "+Utilities.presentDuration(c.length));
      }
    }
    for (Counter c : records) {
      if (c.count > 1) {
        b.append(c.name+": "+Utilities.presentDuration(c.length)+" (#"+c.count+")");
      }
    }
    return "Times: "+b.toString();
  }
  
  public String clock() {
    return Utilities.presentDuration(System.nanoTime() - globalStart);
  }

  public String instant() {
    return Utilities.presentDuration(System.nanoTime() - globalStart);
  }

  public String milestone() {
    long start = milestone == 0 ? globalStart : milestone ;
    milestone = System.nanoTime();
    return Utilities.presentDuration(milestone - start);
  }

}
