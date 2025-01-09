package org.hl7.fhir.r5.terminologies;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.Utilities;

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

  public static List<String> listSystems(ValueSet vs) {
    Set<String> res = new HashSet<>();
    for (ConceptSetComponent inc : vs.getCompose().getInclude()) {
      if (inc.hasSystem()) {
        if (inc.hasVersion()) {
          res.add(inc.getSystem()+"|"+inc.getVersion());
        } else {
          res.add(inc.getSystem());
        }
      }
    }
    for (ConceptSetComponent inc : vs.getCompose().getExclude()) {
      if (inc.hasSystem()) {
        if (inc.hasVersion()) {
          res.add(inc.getSystem()+"|"+inc.getVersion());
        } else {
          res.add(inc.getSystem());
        }
      }
    }
    return Utilities.sorted(res);
  }
}
