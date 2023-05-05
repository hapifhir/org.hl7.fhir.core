package org.hl7.fhir.r5.terminologies.providers;

import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionPropertyComponent;

public class ColorRGBProvider extends CodeSystemProvider {

  @Override
  public void includeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp,
      List<ValueSet> imports, Parameters expParams, List<Extension> extensions, boolean noInactive,
      List<ValueSetExpansionPropertyComponent> vsProps) throws CodeSystemProviderExtension {
    throw new CodeSystemProviderExtension("There are 16777216 colors, so the full list of colors is not displayed");
  }

  @Override
  public Boolean checkCode(String code) {
    return code.matches("^\\#[0-9a-fA-F]{6}$");
  }

}
