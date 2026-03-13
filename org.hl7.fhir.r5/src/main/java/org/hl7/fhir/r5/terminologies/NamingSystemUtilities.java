package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.utils.ResourceSorters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NamingSystemUtilities {
  private static Map<String, NamingSystem> systemUrlMap(IWorkerContext context) {
    Map<String, NamingSystem> result = (Map<String, NamingSystem>) context.retrieveAnalysis(NamingSystemUtilities.class);
    if (result == null) {
      result = new HashMap<>();
      List<NamingSystem> nsl = context.fetchResourcesByType(NamingSystem.class);
      nsl.sort(new ResourceSorters.CanonicalResourceSortByTypeId());
      for (NamingSystem ns : nsl) {
        for (NamingSystem.NamingSystemUniqueIdComponent uid : ns.getUniqueId()) {
          if (uid.getType() == NamingSystem.NamingSystemIdentifierType.URI && uid.hasValue()) {
            result.put(uid.getValue(), ns);
          }
        }
      }
    }
    return result;
  }

  public static NamingSystem getNamingSystem(IWorkerContext context, String system) {
    Map<String, NamingSystem> map = systemUrlMap(context);
    return map.get(system);
  }

  public static boolean hasNamingSystem(SimpleWorkerContext context, String system) {
    Map<String, NamingSystem> map = systemUrlMap(context);
    return map.containsKey(system);
  }
}
