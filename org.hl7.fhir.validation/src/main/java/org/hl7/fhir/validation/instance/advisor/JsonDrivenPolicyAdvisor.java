package org.hl7.fhir.validation.instance.advisor;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.Nonnull;

import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class JsonDrivenPolicyAdvisor extends RulesDrivenPolicyAdvisor {

  public JsonDrivenPolicyAdvisor(IValidationPolicyAdvisor base, File source) throws JsonException, IOException {
    super(base);
    load(JsonParser.parseObject(source, true));
  }

  public JsonDrivenPolicyAdvisor(ReferenceValidationPolicy refpol, File source, Set<String> referencesTo) throws JsonException, IOException {
    super(refpol, referencesTo);
    load(JsonParser.parseObject(source));
  }

  public JsonDrivenPolicyAdvisor(IValidationPolicyAdvisor base, String filename, String source) throws JsonException, IOException {
    super(base);
    load(JsonParser.parseObject(source));
  }

  private void load(JsonObject json) throws JsonException, IOException {
    for (JsonElement e : json.forceArray("suppress").getItems()) {
      @Nonnull String s = e.asString();
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
    }
  }

}
