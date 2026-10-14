package org.hl7.fhir.model.utilities;

import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.CapabilityStatement;
import org.hl7.fhir.model.core.Identifier;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.core.ValueSet.ConceptSetComponent;
import org.hl7.fhir.utilities.Utilities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TerminologyUtilities {

  public static Set<String> listOids(CanonicalResource cr) {
    Set<String> oids = new HashSet<>();

    if (cr.hasUrl() && cr.getUrl().startsWith("urn:oid:")) {
      oids.add(cr.getUrl().substring(8));
    }

    for (Identifier id : cr.getIdentifierList()) {
      String v = id.getValue();
      if (v != null && v.startsWith("urn:oid:")) {
        oids.add(v.substring(8));
      }
    }
    return oids;
  }

  public static List<String> listSystems(ValueSet vs) {
    Set<String> res = new HashSet<>();
    for (ConceptSetComponent inc : vs.getCompose().getIncludeList()) {
      if (inc.hasSystem()) {
        if (inc.hasVersion()) {
          res.add(inc.getSystem() + "|" + inc.getVersion());
        } else {
          res.add(inc.getSystem());
        }
      }
    }
    for (ConceptSetComponent inc : vs.getCompose().getExcludeList()) {
      if (inc.hasSystem()) {
        if (inc.hasVersion()) {
          res.add(inc.getSystem() + "|" + inc.getVersion());
        } else {
          res.add(inc.getSystem());
        }
      }
    }
    return Utilities.sorted(res);
  }

  public static boolean supportsOperation(CapabilityStatement capabilitiesStatement, String resourceType, String opName) {
    for (var rest : capabilitiesStatement.getRestList()) {
      for (var resource : rest.getResourceList()) {
        if (resourceType.equals(resource.getType())) {
          for (var op : resource.getOperationList()) {
            if (opName.equals(op.getName())) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}
