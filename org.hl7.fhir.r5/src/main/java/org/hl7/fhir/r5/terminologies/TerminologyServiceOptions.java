package org.hl7.fhir.r5.terminologies;

import org.fhir.ucum.Utilities;
import org.hl7.fhir.r5.model.Parameters;

public class TerminologyServiceOptions {
  private String language;

  public TerminologyServiceOptions() {
    super();
  }

  public TerminologyServiceOptions(String language) {
    super();
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String toJson() {
    return "\"lang\":\""+language+"\"";
  }

  public void updateParameters(Parameters pIn) {
   if (!Utilities.noString(language))
     pIn.addParameter("displayLanguage", language);
    
  } 

}