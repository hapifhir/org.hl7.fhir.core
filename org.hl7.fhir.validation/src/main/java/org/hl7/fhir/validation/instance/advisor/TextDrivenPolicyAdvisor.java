package org.hl7.fhir.validation.instance.advisor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;

public class TextDrivenPolicyAdvisor extends RulesDrivenPolicyAdvisor {

  public TextDrivenPolicyAdvisor(IValidationPolicyAdvisor base, File source) throws JsonException, IOException {
    super(base);
    load(source);
  }

  public TextDrivenPolicyAdvisor(ReferenceValidationPolicy refpol, File source) throws JsonException, IOException {
    super(refpol);
    load(source);
  }

  private void load(File source) throws JsonException, IOException {
    BufferedReader reader = new BufferedReader(new FileReader(source));
    String line = reader.readLine();
    while (line != null) {
      processLine(line);  
      line = reader.readLine();
    }
    reader.close();
  }

  private void processLine(String line) {
    line = line.trim();
    if (Utilities.noString(line) || line.startsWith("#")) {
      return;
    }
    if (line.startsWith("-")) {
      String s = line.substring(1).trim();
      String id = s;
      String path = null;
      if (s.contains("@")) {
        id = s.substring(0, s.indexOf("@"));
        path = s.substring(s.indexOf("@")+1);
      }
      addSuppressMessageRule(id, path);
    } else {
      // ignore it for now
    }
    
  }
}
