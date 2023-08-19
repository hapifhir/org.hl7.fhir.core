package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.MarkdownType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;


public class PublicationHacker {

  // this routine fixes up broken binding descriptions from past FHIR publications. All of them will be or are fixed in a later version, 
  // but fixing old versions is procedurally very difficult. Hence, these work around fixes here
  
  public static MarkdownType fixBindingDescriptions(IWorkerContext context, MarkdownType md) {
    MarkdownType ret = null;
  
    // ServiceRequest.code
    if (md.getValue().contains("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]")) {
      ret = md.copy();
      ret.setValue(md.getValue().replace("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]", "LOINC is [preferred]("+Utilities.pathURL(VersionUtilities.getSpecUrl(context.getVersion()), "terminologies.html#preferred)")));
    }
    if (md.getValue().contains("[here](valueset-diagnostic-requests.html)")) {
      if (ret == null) {
        ret = md.copy();
      }
      ret.setValue(md.getValue().replace("[here](valueset-diagnostic-requests.html)", "here"));
    }       
    return ret == null ? md : ret;
  }

}
