package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.Setter;

/*
	Scope
	Preferred-Value
	Suppress-Script
	Macrolanguage
 */
public class LanguageSubtag extends Subtag {

  @Getter @Setter
  private String scope;

  @Getter @Setter
  private String preferredValue;

  @Getter @Setter
  private String suppressScript;

  @Getter @Setter
  private String macrolanguage;

  protected LanguageSubtag(String subtag) {
    super(subtag);
  }
}
