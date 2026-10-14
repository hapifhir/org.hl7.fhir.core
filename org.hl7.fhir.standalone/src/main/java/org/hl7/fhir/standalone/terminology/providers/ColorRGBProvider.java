package org.hl7.fhir.standalone.terminology.providers;

import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ConceptSetComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionPropertyComponent;
import org.hl7.fhir.standalone.terminology.providers.CodeSystemProvider;

import java.util.List;


public class ColorRGBProvider extends CodeSystemProvider {

  @Override
  public void includeCodes(ConceptSetComponent inc, boolean heirarchical, ValueSetExpansionComponent exp,
      List<ValueSet> imports, Parameters expParams, List<Extension> extensions, boolean noInactive,
      List<ValueSetExpansionPropertyComponent> vsProps) throws CodeSystemProviderExtension {
    throw new CodeSystemProviderExtension("There are 16777216 colors, so the full list of colors is not displayed");
  }

  @Override
  public Boolean checkCode(String code) {
    @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
    //anchored, fixed-width hex color, safe
    boolean matches = code.matches("^\\#[0-9a-fA-F]{6}$");
    return matches;
  }

}
