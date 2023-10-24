package org.hl7.fhir.r5.terminologies;

import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.utilities.json.model.JsonObject;

public class TerminologyUtilities {

  public static Set<String> listOids(CanonicalResource cr) {
    Set<String> oids = new HashSet<>();
    
    if (cr.hasUrl() && cr.getUrl().startsWith("urn:oid:")) {
      oids.add(cr.getUrl().substring(8));
    }
      
    for (Identifier id : cr.getIdentifier()) {
      String v = id.getValue();
      if (v != null && v.startsWith("urn:oid:")) {
        oids.add(v.substring(8));
      }
    }
    return oids;
  }
}
