package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.Setter;

/*
	Preferred-Value
 */
public class RegionSubtag extends Subtag {
  @Getter @Setter
  private String preferredValue;

  protected RegionSubtag(String subtag) {
    super(subtag);
  }
}
