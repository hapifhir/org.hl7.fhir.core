package org.hl7.fhir.r4b.utils;

import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.model.ServiceRequest;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.utilities.Utilities;


public class PublicationHacker {

  // this routine fixes up broken binding descriptions from past FHIR publications. All of them will be or are fixed in a later version, 
  // but fixing old versions is procedurally very difficult. Hence, these work around fixes here
  
  public static StringType fixBindingDescriptions(IWorkerContext context, StringType s) {
      StringType res = s.copy();
      
      // ServiceRequest.code
      if (res.getValue().contains("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]")) {
        res.setValue(res.getValue().replace("LOINC is  (preferred)[http://build.fhir.org/terminologies.html#preferred]", "LOINC is [preferred]("+Utilities.pathURL(context.getSpecUrl(), "terminologies.html#preferred)")));
      }
      if (res.getValue().contains("[here](valueset-diagnostic-requests.html)")) {
        res.setValue(res.getValue().replace("[here](valueset-diagnostic-requests.html)", "here"));
      }       
      return res;
  }

}
