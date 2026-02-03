package org.hl7.fhir.validation.instance.advisor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;

public class TextDrivenPolicyAdvisor extends RulesDrivenPolicyAdvisor {

  public TextDrivenPolicyAdvisor(IValidationPolicyAdvisor base, File source) throws JsonException, IOException {
    super(base);
    load(source);
  }

  public TextDrivenPolicyAdvisor(ReferenceValidationPolicy refpol, File source, Set<String> referencesTo) throws JsonException, IOException {
    super(refpol, referencesTo);
    load(source);
  }

  public TextDrivenPolicyAdvisor(IValidationPolicyAdvisor base, String filename, String source) throws JsonException, IOException {
    super(base);
    String[] lines= source.split("\\R");
    for (String line : lines) {
      processLine(line);  
    }
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
      @Nonnull String s = line.substring(1).trim();
      if (s.contains("@")) {
        String id = s.substring(0, s.indexOf("@"));
        String path = s.substring(s.indexOf("@")+1);
        boolean regex = false;
        if (path.startsWith("^")) {
          regex = true;
          path = path.substring(1);
        }
        addSuppressMessageRule(id, path, regex);
      } else {
        addSuppressMessageRule(s);
      }
    } else {
      // ignore it for now
    }
    
  }
}
