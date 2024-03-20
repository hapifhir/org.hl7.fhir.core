package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.Setter;

/*
  Preferred-Value
  Macrolanguage
  Prefix
 */
public class ExtLangSubtag extends Subtag {

  @Getter @Setter
  private String preferredValue;

  @Getter @Setter
  private String macrolanguage;

  @Getter @Setter
  private String prefix;
  protected ExtLangSubtag(String subtag) {
    super(subtag);
  }
}
