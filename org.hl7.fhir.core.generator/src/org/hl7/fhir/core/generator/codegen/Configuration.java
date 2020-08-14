package org.hl7.fhir.core.generator.codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;

public class Configuration {
  public static final SimpleDateFormat DATE_FORMAT() {
    return new SimpleDateFormat("EEE, MMM d, yyyy HH:mmZ", new Locale("en", "US"));
  }
  private String license;
  private IniFile ini;
  private Map<String, String> adornments = new HashMap<>();
  
  public Configuration(String path) throws FileNotFoundException, IOException {
    license = TextFile.fileToString(Utilities.path(path, "license.txt"));
    ini = new IniFile(Utilities.path(path, "configuration.ini"));
    for (File jfn : new File(path).listFiles()) {
      if (jfn.getName().endsWith(".java")) {
        adornments.put(Utilities.changeFileExt(jfn.getName(), ""), TextFile.fileToString(jfn));
      }
    }
  }
  

  public String getLicense() {
    return license;
  }
  
  public Map<String, String> getAdornments() {
    return adornments;
  }


  public IniFile getIni() {
    return ini;
  }
    
             
}