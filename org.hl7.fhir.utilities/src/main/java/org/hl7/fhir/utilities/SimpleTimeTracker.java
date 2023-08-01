package org.hl7.fhir.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SimpleTimeTracker {

  private long start;
  private String name;
  private String context;
  private int count;
  
  public static int level = 0;
  public static BufferedWriter bw;
  
  public SimpleTimeTracker(String name) {    
    level++;
    this.name = name;
    count = -1;
    start = System.currentTimeMillis();
    init();
    log(name);
  }
    
  public SimpleTimeTracker(String name, String context) {
    level++;
    this.name = name;
    this.context = context;
    start = System.currentTimeMillis();
    count = -1;
    init();
    log(name+" ["+context+"]");
  }
  
  private void init() {
    if (bw == null) {
      try {
        File fout = new File("/Users/grahamegrieve/temp/time.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        bw = new BufferedWriter(new OutputStreamWriter(fos));
      } catch (Exception e) {
        e.printStackTrace();
      }
     
    }
    
  }

  public void report()  {
    String s = count == -1 ? "" : " ("+count+")";
    if (context == null) {
      s = name+": "+(System.currentTimeMillis()-start)+"ms "+s;
    } else {
      s = name+": "+(System.currentTimeMillis()-start)+"ms "+s+" ["+context+"]";      
    }
    log(s);
    level--;
    if (level == 0) {
      try {
        bw.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private void log(String s) {
    System.out.println(Utilities.padLeft("", '#', level)+" "+s);
    try {
      bw.write(s);
      bw.newLine();
    } catch (Exception e) {
      System.out.println("e: " +e.getMessage());
    }
  }

  public void count() {
    if (count == -1) {
      count = 1;
    } else {
      count++;
    }
    
  }

}
