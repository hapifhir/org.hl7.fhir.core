package org.hl7.fhir.r5.terminologies.providers;

import java.util.List;

import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;

/**
 * For special code systems where the code system resource isn't enough, but we can support them internall
 * Usually, small grammar based code systems
 * 
 * @author grahamegrieve
 *
 */
public abstract class CodeSystemProvider {

  public static CodeSystemProvider factory(String system) {
    switch (system) {
    case "http://hl7.org/fhir/color-rgb" : return new ColorRGBProvider();
    default:
      return null;
    }
  }

  public abstract void includeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp,
      List<ValueSet> imports, Parameters expParams, List<Extension> extensions, boolean noInactive,
      List<ValueSetExpansionPropertyComponent> vsProps) throws CodeSystemProviderExtension;

  public abstract Boolean checkCode(String code);

}
