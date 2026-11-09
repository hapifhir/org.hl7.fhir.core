package org.hl7.fhir.r5.terminologies.expansion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;

/**
 * concept / code not-in: the concepts whose code is not one of the listed codes (comma separated).
 * Only the listed codes are left out - not their descendants, as is-not-a would.
 */
public class CodeListFilter extends ConceptFilter {

  private Set<String> codes = new HashSet<>();

  protected CodeListFilter(List<String> allErrors, String value) {
    super(allErrors);
    if (value != null) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //single literal character split
      String[] listed = value.split("\\,");
      for (String v : listed) {
        codes.add(v.trim());
      }
    }
  }

  @Override
  public boolean includeConcept(CodeSystem cs, ConceptDefinitionComponent def) {
    return !codes.contains(def.getCode());
  }
}
