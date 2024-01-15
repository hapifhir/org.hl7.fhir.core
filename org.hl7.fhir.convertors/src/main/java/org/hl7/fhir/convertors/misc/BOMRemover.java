package org.hl7.fhir.convertors.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class BOMRemover {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new BOMRemover().execute(new File(args[0]));

  }

  private void execute(File f) throws FileNotFoundException, IOException {
    if (f.isDirectory()) {
      for (File file : f.listFiles()) {
        execute(file);
      }
    } else if (f.getName().endsWith(".java")) {
      String src = fileToString(f);
      String s = Utilities.stripBOM(src);
      if (!s.equals(src)) {
        System.out.println("Remove BOM from "+f.getAbsolutePath());
        TextFile.stringToFile(s, f);
      }
    }
  }


  public static String fileToString(File f) throws FileNotFoundException, IOException {
    return streamToString(new FileInputStream(f));
  }
  
  public static String streamToString(InputStream input) throws IOException  {
    InputStreamReader sr = new InputStreamReader(input, "UTF-8");    
    StringBuilder b = new StringBuilder();
    //while (sr.ready()) { Commented out by Claude Nanjo (1/14/2014) - sr.ready() always returns false - please remove if change does not impact other areas of codebase
    int i = -1;
    while((i = sr.read()) > -1) {
      char c = (char) i;
      b.append(c);
    }
    sr.close();
    
    return  b.toString(); 
  }

}
