package org.hl7.fhir.r5.terminologies.utilities;

import java.util.*;

import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;

public class ValueSetProcessBase {

  public static class AlternateCodesProcessingRules {
    private boolean all;
    private List<String> uses = new ArrayList<>();
    
    public AlternateCodesProcessingRules(boolean b) {
      all = b;
    }

    private void seeParameter(DataType value) {
      if (value != null) {
        if (value instanceof BooleanType) {
          all = ((BooleanType) value).booleanValue();
          uses.clear();
        } else if (value.isPrimitive()) {
          String s = value.primitiveValue();
          if (!Utilities.noString(s)) {
            uses.add(s);
          }
        }
      }
    }

    public void seeParameters(Parameters pp) {
      for (ParametersParameterComponent p : pp.getParameter()) {
        String name = p.getName();
        if ("includeAlternateCodes".equals(name)) {
          DataType value = p.getValue();
          seeParameter(value);
        }
      }
    }

    public void seeValueSet(ValueSet vs) {
      for (Extension ext : vs.getCompose().getExtension()) {
        if ("http://hl7.org/fhir/tools/StructureDefinion/valueset-expansion-param".equals(ext.getUrl())) {
          String name = ext.getExtensionString("name");
          Extension value = ext.getExtensionByUrl("value");
          if ("includeAlternateCodes".equals(name) && value != null && value.hasValue()) {
            seeParameter(value.getValue());
          }
        }
      }
    }

    public boolean passes(List<Extension> extensions) {
      if (all) {
        return true;
      }

      for (Extension ext : extensions) {
        if (ToolingExtensions.EXT_CS_ALTERNATE_USE.equals(ext.getUrl())) {
          if (ext.hasValueCoding() && Utilities.existsInList(ext.getValueCoding().getCode(), uses)) {
            return true;
          }
        }
      }
      return false;
    }
  }

  protected AlternateCodesProcessingRules altCodeParams = new AlternateCodesProcessingRules(false);
  protected AlternateCodesProcessingRules allAltCodes = new AlternateCodesProcessingRules(true);
}
