package org.hl7.fhir.validation.instance.advisor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Element.SpecialElement;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.utils.validation.IMessagingServices;
import org.hl7.fhir.r5.utils.validation.IResourceValidator;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.r5.utils.validation.constants.BindingKind;
import org.hl7.fhir.r5.utils.validation.constants.ContainedReferenceValidationPolicy;
import org.hl7.fhir.r5.utils.validation.constants.ReferenceValidationPolicy;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class JsonDrivenPolicyAdvisor extends RulesDrivenPolicyAdvisor {

  public JsonDrivenPolicyAdvisor(IValidationPolicyAdvisor base, File source) throws JsonException, IOException {
    super(base);
    load(source);
  }

  public JsonDrivenPolicyAdvisor(ReferenceValidationPolicy refpol, File source) throws JsonException, IOException {
    super(refpol);
    load(source);
  }

  private void load(File source) throws JsonException, IOException {
    JsonObject json = JsonParser.parseObject(source);
    for (JsonElement e : json.forceArray("suppress").getItems()) {
      String s = e.asString();
      String id = s;
      String path = null;
      if (s.contains("@")) {
        id = s.substring(0, s.indexOf("@"));
        path = s.substring(s.indexOf("@")+1);
      }
      addSuppressMessageRule(id, path);
    }
  }

}
