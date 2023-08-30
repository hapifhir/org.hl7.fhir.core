package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;


public class PublicationHacker {

  // this routine fixes up broken binding descriptions from past FHIR publications. All of them will be or are fixed in a later version, 
  // but fixing old versions is procedurally very difficult. Hence, these work around fixes here
  
  public static StringType fixBindingDescriptions(IWorkerContext context, StringType s) {
      StringType res = s.copy();
      
      // ServiceRequest.code
      if (res.getValue().contains("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]")) {
        res.setValue(res.getValue().replace("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]", "LOINC is [preferred]("+Utilities.pathURL(VersionUtilities.getSpecUrl(context.getVersion()), "terminologies.html#preferred)")));
      }
      if (res.getValue().contains("[here](valueset-diagnostic-requests.html)")) {
        res.setValue(res.getValue().replace("[here](valueset-diagnostic-requests.html)", "here"));
      }       
      return res;
  }

}
