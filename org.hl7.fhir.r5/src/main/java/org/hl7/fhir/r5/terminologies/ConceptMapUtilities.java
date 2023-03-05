package org.hl7.fhir.r5.terminologies;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.UriType;
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

  public static boolean hasMappingForSource(ConceptMap cm, String system, String version, String code) {
    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      if (system.equals(grp.getSource())) { // to do: version
        for (SourceElementComponent e : grp.getElement()) {
          if (code.equals(e.getCode())) {
            return true; // doesn't matter if it's actually unmapped
          }
        }
      }
    }
    return false;
  }

  public static List<Coding> listTargets(ConceptMap cm, List<String> systems) {
    List<Coding> list = new ArrayList<>();
    for (ConceptMapGroupComponent grp : cm.getGroup()) {
      if (systems.isEmpty() || systems.contains(grp.getSource())) { // to do: version
        for (SourceElementComponent e : grp.getElement()) {
          for (TargetElementComponent t : e.getTarget()) {
            if (t.hasCode()) {
              list.add(new Coding(grp.getTarget(), t.getCode(), t.getDisplay()));
            }
          }
        }
      }
    }
    return list;
  }


  public static ConceptMap makeShareable(ConceptMap cm) {
    if (!cm.hasExperimental()) {
      cm.setExperimental(false);
    }

    if (!cm.hasMeta())
      cm.setMeta(new Meta());
    for (UriType t : cm.getMeta().getProfile()) 
      if ("http://hl7.org/fhir/StructureDefinition/shareableconceptmap".equals(t.getValue()))
        return cm;
    cm.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareableconceptmap"));
    return cm;
  }

}
