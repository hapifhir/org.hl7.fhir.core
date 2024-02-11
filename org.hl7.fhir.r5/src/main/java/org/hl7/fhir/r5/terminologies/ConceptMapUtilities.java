package org.hl7.fhir.r5.terminologies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.terminologies.ConceptMapUtilities.ConceptMapElementSorter;
import org.hl7.fhir.r5.model.Identifier;
import org.hl7.fhir.r5.model.Meta;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;

public class ConceptMapUtilities {

  public static class TranslatedCode {
    private String code;
    private ConceptMapRelationship relationship;
    public TranslatedCode(String code, ConceptMapRelationship relationship) {
      super();
      this.code = code;
      this.relationship = relationship;
    }
    public String getCode() {
      return code;
    }
    public ConceptMapRelationship getRelationship() {
      return relationship;
    }
    
  }

  public static class ConceptMapElementSorter implements Comparator<SourceElementComponent> {

    @Override
    public int compare(SourceElementComponent o1, SourceElementComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }

  public static class ConceptMapTargetElementSorter implements Comparator<TargetElementComponent> {

    @Override
    public int compare(TargetElementComponent o1, TargetElementComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }
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

  public static ConceptMap invert(ConceptMap src, String id, String url, String name, boolean collate) {
    ConceptMap dst = src.copy();
    dst.setId(id);
    dst.setUrl(url);
    dst.setName(name);
    dst.getGroup().clear();
    dst.setSourceScope(src.getTargetScope());
    dst.setTargetScope(src.getSourceScope());
    for (ConceptMapGroupComponent gs : src.getGroup()) {
      ConceptMapGroupComponent gd = dst.addGroup();
      gd.setTargetElement(gs.getSourceElement());
      gd.setSourceElement(gs.getTargetElement());
      Map<String, SourceElementComponent> dstMap = new HashMap<>();
      for (SourceElementComponent es : gs.getElement()) {
        for (TargetElementComponent ts : es.getTarget()) {
          SourceElementComponent ed = collate ? dstMap.get(ts.getCode()) : null;
          if (ed == null) {
            ed = gd.addElement();
            ed.setCodeElement(ts.getCodeElement());
            if (collate) {
              dstMap.put(ed.getCode(), ed);
            }
          }
          TargetElementComponent td = ed.addTarget();
          td.setCode(es.getCode());
          td.setComment(ts.getComment());
          td.setRelationship(invertRelationship(ts.getRelationship()));
        }
      }    
    }
    return dst;
  }

  private static ConceptMapRelationship invertRelationship(ConceptMapRelationship relationship) {
    if (relationship == null) {
      return null;
    }
    switch (relationship) {
    case EQUIVALENT:
      return ConceptMapRelationship.EQUIVALENT;
    case NOTRELATEDTO:
      return ConceptMapRelationship.NOTRELATEDTO;
    case NULL:
      return ConceptMapRelationship.NULL;
    case RELATEDTO:
      return ConceptMapRelationship.RELATEDTO;
    case SOURCEISBROADERTHANTARGET:
      return ConceptMapRelationship.SOURCEISNARROWERTHANTARGET;
    case SOURCEISNARROWERTHANTARGET:
      return ConceptMapRelationship.SOURCEISBROADERTHANTARGET;
    default:
      return null;    
    }
  }

  public static ConceptMap collapse(String id, String url, boolean cumulative, ConceptMap src, ConceptMap... sequence) {
    ConceptMap res = src.copy();
    res.setId(id);
    res.setUrl(url);

    for (ConceptMap cm : sequence) {
      if (res.hasTargetScope() && src.hasTargetScope()) {
        if (!cm.getSourceScope().equals(cm.getTargetScope())) {
          throw new Error("Mismatch between seqeuntial concept maps: ");
        } else {
          res.setTargetScope(cm.getTargetScope());
        }
      } else {
        res.setTargetScope(null);
      }
    }

    for (ConceptMapGroupComponent gd : res.getGroup()) {
      for (ConceptMap cm : sequence) {
        for (ConceptMapGroupComponent gt : cm.getGroup()) {
          if (gt.getSource().equals(gd.getTarget())) {
            gd.setTarget(gt.getTarget());

            List<SourceElementComponent> processed = new ArrayList<ConceptMap.SourceElementComponent>();
            for (SourceElementComponent ed : gd.getElement()) {
              List<TargetElementComponent> list = new ArrayList<>();  
              list.addAll(ed.getTarget());
              ed.getTarget().clear();
              for (TargetElementComponent ts : list) {
                for (SourceElementComponent et : gt.getElement()) {
                  if (et.getCode().equals(ed.getCode())) {
                    processed.add(et);
                    for (TargetElementComponent tt : et.getTarget()) {
                      ed.addTarget().setCode(tt.getCode()).setRelationship(combineRelationships(ts.getRelationship(), tt.getRelationship()));
                    }
                  }
                }
              }
              if (ed.getTarget().isEmpty()) {
                if (cumulative) {
                  ed.getTarget().addAll(list);
                } else {
                  ed.setNoMap(true);
                }
              }
            }
            if (cumulative) {
              for (SourceElementComponent et : gt.getElement()) {
                if (!processed.contains(et)) {
                  gd.addElement(et.copy());
                }
              }
            }
          }
          Collections.sort(gt.getElement(), new ConceptMapElementSorter());
          for (SourceElementComponent e: gt.getElement()) {
            Collections.sort(e.getTarget(), new ConceptMapTargetElementSorter());
          }
        }
      }
    }
    return res;
  }

  public static ConceptMapRelationship combineRelationships(ConceptMapRelationship rel1, ConceptMapRelationship rel2) {
    switch (rel1) {
    case EQUIVALENT:
      return rel2;
    case NOTRELATEDTO:
      return ConceptMapRelationship.NOTRELATEDTO;
    case NULL:
      return null;
    case RELATEDTO:
      return rel2;
    case SOURCEISBROADERTHANTARGET:
      switch (rel2) {
      case EQUIVALENT:
        return ConceptMapRelationship.SOURCEISBROADERTHANTARGET;
      case NOTRELATEDTO:
        return ConceptMapRelationship.NOTRELATEDTO;
      case NULL:
        return null;
      case RELATEDTO:
        return ConceptMapRelationship.RELATEDTO;
      case SOURCEISBROADERTHANTARGET:
        return ConceptMapRelationship.SOURCEISBROADERTHANTARGET;
      case SOURCEISNARROWERTHANTARGET:
        return ConceptMapRelationship.RELATEDTO;
      }
    case SOURCEISNARROWERTHANTARGET:
      switch (rel2) {
      case EQUIVALENT:
        return ConceptMapRelationship.SOURCEISNARROWERTHANTARGET;
      case NOTRELATEDTO:
        return ConceptMapRelationship.NOTRELATEDTO;
      case NULL:
        return null;
      case RELATEDTO:
        return ConceptMapRelationship.RELATEDTO;
      case SOURCEISBROADERTHANTARGET:
        return ConceptMapRelationship.RELATEDTO;
      case SOURCEISNARROWERTHANTARGET:
        return ConceptMapRelationship.SOURCEISNARROWERTHANTARGET;
      }
    }
    return null;
  }
  
}
