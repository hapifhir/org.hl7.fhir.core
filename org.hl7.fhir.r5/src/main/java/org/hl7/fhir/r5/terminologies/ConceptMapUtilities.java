package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.ValueSet;

public class ConceptMapUtilities {

  public static boolean hasOID(ConceptMap cm) {
    return getOID(cm) != null;
  }

  public static String getOID(ConceptMap cm) {
    for (Identifier id : cm.getIdentifier()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:"))
        return id.getValue().substring(8);
    }
    return null;
  }

  public static void setOID(ConceptMap cm, String oid) {
    if (!oid.startsWith("urn:oid:"))
      oid = "urn:oid:" + oid;
    for (Identifier id : cm.getIdentifier()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:")) {
        id.setValue(oid);
        return;
      }
    }
    cm.addIdentifier().setSystem("urn:ietf:rfc:3986").setValue(oid);
  }


}
