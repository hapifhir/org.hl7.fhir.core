package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/*
	Preferred-Value
	Prefix
 */
public class VariantSubtag extends Subtag {

  @Getter @Setter
  private String preferredValue;

  private List<String> prefixes = new ArrayList<>();
  protected VariantSubtag(String subtag) {
    super(subtag);
  }

  protected boolean addPrefix(String description) {
    return prefixes.add(description);
  }

  public List<String> getPrefixes() {
    return List.copyOf(prefixes);
  }
}
