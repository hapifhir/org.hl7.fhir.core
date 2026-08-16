package org.hl7.fhir.model.utilities;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.utilities.Utilities;

import java.util.*;

public class ConceptMapUtilities {

  public static class MappingTriple {
    private ConceptMapGroupComponent grp;
    private SourceElementComponent src;
    private TargetElementComponent tgt;

    public MappingTriple(ConceptMapGroupComponent grp, SourceElementComponent src, TargetElementComponent tgt) {
      this.grp = grp;
      this.src = src;
      this.tgt = tgt;
    }

    public ConceptMapGroupComponent getGrp() {
      return grp;
    }

    public SourceElementComponent getSrc() {
      return src;
    }

    public TargetElementComponent getTgt() {
      return tgt;
    }
  }

  public static class TargetSorter implements Comparator<TargetElementComponent> {

    @Override
    public int compare(TargetElementComponent o1, TargetElementComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }

  public static class ElementSorter implements Comparator<SourceElementComponent> {

    @Override
    public int compare(SourceElementComponent o1, SourceElementComponent o2) {
      return o1.getCode().compareTo(o2.getCode());
    }

  }

  public static class ElementMappingPair {

    private SourceElementComponent src;
    private TargetElementComponent tgt;

    public ElementMappingPair(SourceElementComponent src, TargetElementComponent tgt) {
      this.src = src;
      this.tgt = tgt;
    }

  }

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
    for (Identifier id : cm.getIdentifierList()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:"))
        return id.getValue().substring(8);
    }
    return null;
  }

  public static void setOID(ConceptMap cm, String oid) {
    if (!oid.startsWith("urn:oid:"))
      oid = "urn:oid:" + oid;
    for (Identifier id : cm.getIdentifierList()) {
      if ("urn:ietf:rfc:3986".equals(id.getSystem()) && id.hasValue() && id.getValue().startsWith("urn:oid:")) {
        id.setValue(oid);
        return;
      }
    }
    cm.addIdentifier().setSystem("urn:ietf:rfc:3986").setValue(oid);
  }

  public static boolean hasMappingForSource(ConceptMap cm, Coding code) {
    return hasMappingForSource(cm, code.getSystem(), code.getVersion(), code.getCode());
  }

  public static boolean hasMappingForSource(ConceptMap cm, String system, String version, String code) {
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      if (system.equals(grp.getSource())) { // to do: version
        for (SourceElementComponent e : grp.getElementList()) {
          if (code.equals(e.getCode())) {
            return true; // doesn't matter if it's actually unmapped
          }
        }
      }
    }
    return false;
  }

  public static boolean hasMappingForTarget(ConceptMap cm, Coding code) {
    return hasMappingForTarget(cm, code.getSystem(), code.getVersion(), code.getCode());
  }

  public static boolean hasMappingForTarget(ConceptMap cm, String system, String version, String code) {
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      if (system.equals(grp.getTarget())) { // to do: version
        for (SourceElementComponent e : grp.getElementList()) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (code.equals(t.getCode())) {
              return true; // doesn't matter if it's actually unmapped
            }
          }
        }
      }
    }
    return false;
  }

  public static List<Coding> listTargets(ConceptMap cm, List<String> systems) {
    List<Coding> list = new ArrayList<>();
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      if (systems.isEmpty() || systems.contains(grp.getSource())) { // to do: version
        for (SourceElementComponent e : grp.getElementList()) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.hasCode()) {
              list.add(new Coding(grp.getTarget(), t.getCode(), t.getDisplay()));
            }
          }
        }
      }
    }
    return list;
  }


  public static ConceptMap makeShareable(ConceptMap cm, boolean extension) {
    if (!cm.hasExperimental()) {
      cm.setExperimental(false);
    }

    if (extension) {
      if (!cm.hasMeta())
        cm.setMeta(new Meta());
      for (UriType t : cm.getMeta().getProfile())
        if ("http://hl7.org/fhir/StructureDefinition/shareableconceptmap".equals(t.getValue()))
          return cm;
      cm.getMeta().getProfile().add(new CanonicalType("http://hl7.org/fhir/StructureDefinition/shareableconceptmap"));
    }
    return cm;
  }

  public static ConceptMap invert(ConceptMap src, String id, String url, String name, boolean collate) {
    ConceptMap dst = src.copy(EnumSet.of(Base.CopyObjectOptions.USER_DATA));
    dst.setId(id);
    dst.setUrl(url);
    dst.setName(name);
    dst.getGroupList().clear();
    dst.setSourceScope(src.getTargetScope());
    dst.setTargetScope(src.getSourceScope());
    for (ConceptMapGroupComponent gs : src.getGroupList()) {
      ConceptMapGroupComponent gd = dst.addGroup();
      gd.setTargetElement(gs.getSourceElement());
      gd.setSourceElement(gs.getTargetElement());
      Map<String, SourceElementComponent> dstMap = new HashMap<>();
      for (SourceElementComponent es : gs.getElementList()) {
        for (TargetElementComponent ts : es.getTargetList()) {
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
    ConceptMap res = src.copy(EnumSet.of(Base.CopyObjectOptions.USER_DATA));
    res.setId(id);
    res.setUrl(url);

    for (ConceptMap cm : sequence) {
      if (res.hasTargetScope() && cm.hasTargetScope()) {
        if (!cm.getSourceScope().primitiveValue().equals(res.getTargetScope().primitiveValue())) {
          throw new Error("Mismatch between sequential concept maps: target was "+res.getTargetScope()+" and source is "+cm.getSourceScope());
        } else {
          res.setTargetScope(cm.getTargetScope());
        }
      } else {
        res.setTargetScope(null);
      }
    }

    for (ConceptMapGroupComponent gd : res.getGroupList()) {
      for (ConceptMap cm : sequence) {
        for (ConceptMapGroupComponent gt : cm.getGroupList()) {
          if (gt.getSource().equals(gd.getTarget())) {
            gd.setTarget(gt.getTarget());

            List<SourceElementComponent> processed = new ArrayList<ConceptMap.SourceElementComponent>();
            for (SourceElementComponent ed : gd.getElementList()) {
              List<TargetElementComponent> list = new ArrayList<>();  
              list.addAll(ed.getTargetList());
              ed.getTargetList().clear();
              for (TargetElementComponent ts : list) {
                for (SourceElementComponent et : gt.getElementList()) {
                  if (et.getCode().equals(ed.getCode())) {
                    processed.add(et);
                    for (TargetElementComponent tt : et.getTargetList()) {
                      ed.addTarget().setCode(tt.getCode()).setRelationship(combineRelationships(ts.getRelationship(), tt.getRelationship()));
                    }
                  }
                }
              }
              if (ed.getTargetList().isEmpty()) {
                if (cumulative) {
                  ed.getTargetList().addAll(list);
                } else {
                  ed.setNoMap(true);
                }
              }
            }
            if (cumulative) {
              for (SourceElementComponent et : gt.getElementList()) {
                if (!processed.contains(et)) {
                  gd.addElement(et.copy(EnumSet.of(Base.CopyObjectOptions.USER_DATA)));
                }
              }
            }
          }
          Collections.sort(gt.getElementList(), new ConceptMapElementSorter());
          for (SourceElementComponent e: gt.getElementList()) {
            Collections.sort(e.getTargetList(), new ConceptMapTargetElementSorter());
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

  public static boolean checkReciprocal(ConceptMap left, ConceptMap right, List<String> issues, boolean makeChanges) {
    boolean changed = false;
    if (!Base.compareDeep(left.getTargetScope(), right.getSourceScope(), true)) {
      issues.add("scopes are not reciprocal: "+left.getTargetScope()+" vs "+right.getSourceScope());
    }
    if (!Base.compareDeep(left.getSourceScope(), right.getTargetScope(), true)) {
      issues.add("scopes are not reciprocal: "+left.getSourceScope()+" vs "+right.getTargetScope());
    }
    for (ConceptMapGroupComponent gl : left.getGroupList()) {
      ConceptMapGroupComponent gr = findMatchingGroup(right.getGroupList(), gl.getTarget(), gl.getSource());
      if (gr == null) {
        for (SourceElementComponent e : gl.getElementList()) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.getRelationship() != ConceptMapRelationship.NOTRELATEDTO) {
              if (makeChanges) {
                changed = true;
                right.forceGroup(gl.getTarget(), gl.getSource()).getOrAddElement(t.getCode()).addTarget(e.getCode(), inverse(t.getRelationship()));
              } else {
                issues.add("left maps from "+gl.getSource()+"#"+e.getCode()+" to "+gl.getTarget()+"#"+t.getCode()+" but right has no matching reverse map");
              }
            } 
          }
        }
      } else {
        for (SourceElementComponent srcL : gl.getElementList()) {
          if (!srcL.getNoMap()) {
            for (TargetElementComponent tgtL : srcL.getTargetList()) {
              List<ElementMappingPair> pairs = getMappings(gr, tgtL.getCode(), srcL.getCode());
              if (tgtL.getRelationship() == null) {
                issues.add("Left map has relationship "+srcL.getCode()+" with no relationship");
              } else switch (tgtL.getRelationship()) {
              case EQUIVALENT:
                if (pairs.isEmpty()) {
                  if (makeChanges) {
                    changed = true;
                    gr.getOrAddElement(tgtL.getCode()).addTarget(srcL.getCode(), ConceptMapRelationship.EQUIVALENT);
                  } else {
                    issues.add("Left map says that "+srcL.getCode()+" is equivalent to "+tgtL.getCode()+" but there's no reverse relationship");
                  }
                } else for (ElementMappingPair pair : pairs) {
                  if (pair.tgt.getRelationship() != ConceptMapRelationship.EQUIVALENT) {
                    issues.add("Left map says that "+srcL.getCode()+" is equivalent to "+tgtL.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                  }
                }
                break;
              case RELATEDTO:
                if (pairs.isEmpty()) {
                  issues.add("Left map says that "+srcL.getCode()+" is related to "+tgtL.getCode()+" but there's no reverse relationship");
                } else for (ElementMappingPair pair : pairs) {
                  if (pair.tgt.getRelationship() != ConceptMapRelationship.EQUIVALENT && pair.tgt.getRelationship() != ConceptMapRelationship.RELATEDTO) {
                    issues.add("Left map says that "+srcL.getCode()+" is related to "+tgtL.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                  }
                }
                break;
              case SOURCEISBROADERTHANTARGET:
                if (pairs.isEmpty()) {
                  issues.add("Left map says that "+srcL.getCode()+" is broader than "+tgtL.getCode()+" but there's no reverse relationship");
                } else for (ElementMappingPair pair : pairs) {
                  if (pair.tgt.getRelationship() != ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
                    issues.add("Left map says that "+srcL.getCode()+" is broader than "+tgtL.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                  }
                }
                break;
              case SOURCEISNARROWERTHANTARGET:
                if (pairs.isEmpty()) {
                  issues.add("Left map says that "+srcL.getCode()+" is narrower than "+tgtL.getCode()+" but there's no reverse relationship");
                } else for (ElementMappingPair pair : pairs) {
                  if (pair.tgt.getRelationship() != ConceptMapRelationship.SOURCEISBROADERTHANTARGET) {
                    issues.add("Left map says that "+srcL.getCode()+" is narrower than "+tgtL.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                  }
                }
                break;
              case NOTRELATEDTO:
                for (ElementMappingPair pair : pairs) {
                  if (pair.tgt.getRelationship() != ConceptMapRelationship.NOTRELATEDTO) {
                    issues.add("Left map says that "+srcL.getCode()+" is not related to "+tgtL.getCode()+" but a reverse relationship exists with type "+pair.tgt.getRelationship().toCode());
                  }
                }
                break;
              }
            }
          } else {
            for (SourceElementComponent srcR : gr.getElementList()) {
              for (TargetElementComponent tgtR : srcR.getTargetList()) {
                if (srcL.getCode().equals(tgtR.getCode())) {
                  issues.add("Left map says that there is no relationship for "+srcL.getCode()+" but right map has a "+tgtR.getRelationship().toCode()+" mapping to it from "+srcR.getCode());
                }
              }
            }
          }
        }
      }
    }
    for (ConceptMapGroupComponent gr : right.getGroupList()) {
      ConceptMapGroupComponent gl = findMatchingGroup(left.getGroupList(), gr.getTarget(), gr.getSource());
      if (gl == null) {
        for (SourceElementComponent e : gr.getElementList()) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.getRelationship() != ConceptMapRelationship.NOTRELATEDTO) {
              if (makeChanges) {
                changed = true;
                left.forceGroup(gr.getTarget(), gr.getSource()).getOrAddElement(t.getCode()).addTarget(e.getCode(), inverse(t.getRelationship()));
              } else {
                issues.add("left maps from "+gr.getSource()+"#"+e.getCode()+" to "+gr.getTarget()+"#"+t.getCode()+" but right has no matching reverse map");
              }
            } 
          }
        }
      } else {
        for (SourceElementComponent srcR : gr.getElementList()) {
          if (!"CHECK!".equals(srcR.getCode())) {
            if (!srcR.getNoMap()) {
              for (TargetElementComponent tgtR : srcR.getTargetList()) {
                List<ElementMappingPair> pairs = getMappings(gl, tgtR.getCode(), srcR.getCode());
                if (tgtR.getRelationship() == null) {
                  issues.add("Right map has relationship "+srcR.getCode()+" with no relationship");
                } else switch (tgtR.getRelationship()) {
                case EQUIVALENT:
                  if (pairs.isEmpty()) {
                    if (makeChanges) {
                      changed = true;
                      gl.getOrAddElement(tgtR.getCode()).addTarget(srcR.getCode(), ConceptMapRelationship.EQUIVALENT);
                    } else {
                      issues.add("Right map says that "+srcR.getCode()+" is equivalent to "+tgtR.getCode()+" but there's no reverse relationship");
                    }
                  } else for (ElementMappingPair pair : pairs) {
                    if (pair.tgt.getRelationship() != ConceptMapRelationship.EQUIVALENT) {
                      issues.add("Right map says that "+srcR.getCode()+" is equivalent to "+tgtR.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                    }
                  }
                  break;
                case RELATEDTO:
                  if (pairs.isEmpty()) {
                    issues.add("Right map says that "+srcR.getCode()+" is related to "+tgtR.getCode()+" but there's no reverse relationship");
                  } else for (ElementMappingPair pair : pairs) {
                    if (pair.tgt.getRelationship() != ConceptMapRelationship.EQUIVALENT && pair.tgt.getRelationship() != ConceptMapRelationship.RELATEDTO) {
                      issues.add("Right map says that "+srcR.getCode()+" is equivalent to "+tgtR.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                    }
                  }
                  break;
                case SOURCEISBROADERTHANTARGET:
                  if (pairs.isEmpty()) {
                    issues.add("Right map says that "+srcR.getCode()+" is broader than "+tgtR.getCode()+" but there's no reverse relationship");
                  } else for (ElementMappingPair pair : pairs) {
                    if (pair.tgt.getRelationship() != ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
                      issues.add("Right map says that "+srcR.getCode()+" is broader than "+tgtR.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                    }
                  }
                  break;
                case SOURCEISNARROWERTHANTARGET:
                  if (pairs.isEmpty()) {
                    issues.add("Right map says that "+srcR.getCode()+" is narrower than "+tgtR.getCode()+" but there's no reverse relationship");
                  } else for (ElementMappingPair pair : pairs) {
                    if (pair.tgt.getRelationship() != ConceptMapRelationship.SOURCEISBROADERTHANTARGET) {
                      issues.add("Right map says that "+srcR.getCode()+" is narrower than "+tgtR.getCode()+" but the reverse relationship has type "+pair.tgt.getRelationship().toCode());
                    }
                  }
                  break;
                case NOTRELATEDTO:
                  for (ElementMappingPair pair : pairs) {
                    if (pair.tgt.getRelationship() != ConceptMapRelationship.NOTRELATEDTO) {
                      issues.add("Right map says that "+srcR.getCode()+" is not related to "+tgtR.getCode()+" but a reverse relationship exists with type "+pair.tgt.getRelationship().toCode());
                    }
                  }
                  break;
                }
              }
            } else {
              for (SourceElementComponent srcL : gr.getElementList()) {
                for (TargetElementComponent tgtL : srcL.getTargetList()) {
                  if (srcR.getCode().equals(tgtL.getCode())) {
                    issues.add("Right map says that there is no relationship for "+srcR.getCode()+" but right map has a "+tgtL.getRelationship().toCode()+" mapping to it from "+srcL.getCode());
                  }
                }
              }
            }
          }
        }
      }
    }
    return changed;
  }

  private static ConceptMapRelationship inverse(ConceptMapRelationship relationship) {
    switch (relationship) {
    case EQUIVALENT: return ConceptMapRelationship.EQUIVALENT;
    case RELATEDTO: return ConceptMapRelationship.RELATEDTO;
    case SOURCEISBROADERTHANTARGET: return ConceptMapRelationship.SOURCEISNARROWERTHANTARGET;
    case SOURCEISNARROWERTHANTARGET: return ConceptMapRelationship.SOURCEISBROADERTHANTARGET;
    default: return null;
    }
  }

  private static boolean hasActualMappings(ConceptMapGroupComponent gr) {
    for (SourceElementComponent e : gr.getElementList()) {
      for (TargetElementComponent tgt : e.getTargetList()) {
        if (tgt.getRelationship() != ConceptMapRelationship.NOTRELATEDTO) {
          return true;
        }
      }
    }
    return false;
  }

  private static List<ElementMappingPair> getMappings(ConceptMapGroupComponent g, String source, String target) {
    List<ElementMappingPair> res = new ArrayList<ElementMappingPair>();

    for (SourceElementComponent src : g.getElementList()) {
      for (TargetElementComponent tgt : src.getTargetList()) {
        if (source.equals(src.getCode()) && target.equals(tgt.getCode())) {
          res.add(new ElementMappingPair(src, tgt));
        }
      }
    }
    return res;
  }

  private static ConceptMapGroupComponent findMatchingGroup(List<ConceptMapGroupComponent> groups, String source, String target) {
    for (ConceptMapGroupComponent g : groups) {
      if (source.equals(g.getSource()) && target.equals(g.getTarget())) {
        return g;
      }
    }
    return null;
  }

  /** 
   * 
   * @param cmF
   * @return true if all the maps simply map to the same code
   */
  public static boolean isUnityMap(ConceptMap cm) {
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      for (SourceElementComponent src : grp.getElementList()) {
        if (src.hasNoMap()) {
          return false;
        }
        if (src.getTargetList().size() != 1) {
          return false;
        }
        if (src.getTargetFirstRep().getRelationship() != ConceptMapRelationship.EQUIVALENT && src.getTargetFirstRep().getRelationship() != ConceptMapRelationship.RELATEDTO) {
          return false;
        }
        if (!src.getCode().equals(src.getTargetFirstRep().getCode())) {
          return false;
        }
      }
    }
    return true;
  }

  public static int mapCount(ConceptMap cm) {
    int i = 0;
    for (ConceptMapGroupComponent grp : cm.getGroupList()) {
      for (SourceElementComponent src : grp.getElementList()) {
        i = i + src.getTargetList().size();
      }
    }
    return i;
  }

  public static Set<Coding> listCodesWithNoMappings(Set<Coding> codes, ConceptMap map) {
    Set<Coding> res = new HashSet<>();
    for (Coding c : codes) {
      if (c != null && c.hasCode()) {
        boolean found = false;
        for (ConceptMapGroupComponent grp : map.getGroupList()) {
          if (matchesCoding(grp, c)) {
            for (SourceElementComponent src : grp.getElementList()) {
              if (c.getCode().equals(src.getCode())) {
                for (TargetElementComponent tgt : src.getTargetList()) {
                  if (tgt.getRelationship() == ConceptMapRelationship.RELATEDTO || tgt.getRelationship() == ConceptMapRelationship.EQUIVALENT || tgt.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
                    found = true;                
                  }
                }
              }
            }
          }
        }
        if (!found) {
          res.add(c);
        }
      }
    }    
    return res;
  }

  private static boolean matchesCoding(ConceptMapGroupComponent grp, Coding code) {    
    return code.getSystem().equals(grp.getSource()) || (code.getSystem()+"|"+code.getVersion()).equals(grp.getSource());
  }

  public static List<String> translateCode(String name, String defaultValue, ConceptMap... cmList) {
    List<String> res = translateCode(name, cmList);
    if (res.isEmpty()) {
      res.add(defaultValue);
    }
    return res;
  }
  public static List<String> translateCode(String name, ConceptMap... cmList) {
    List<String> res = new ArrayList<>();
    res.add(name);
    for (ConceptMap cm : cmList) {
      res = translateCodes(res, cm);
    }
    return res;
  }

  private static List<String> translateCodes(List<String> codes, ConceptMap cm) {
    List<String> res = new ArrayList<>();
    for (ConceptMapGroupComponent g : cm.getGroupList()) {
      for (SourceElementComponent e : g.getElementList()) {
        if (Utilities.existsInList(e.getCode(), codes)) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.getRelationship() == ConceptMapRelationship.EQUIVALENT || t.getRelationship() == ConceptMapRelationship.RELATEDTO || 
                t.getRelationship() == ConceptMapRelationship.SOURCEISBROADERTHANTARGET ||t.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
              res.add(t.getCode());
            }
          }
        }
      }
    }
    return res;
  }

  public static List<Coding> translateCoding(Coding code, ConceptMap... cmList) {
    List<Coding> res = new ArrayList<>();
    for (ConceptMap cm : cmList) {
      res = translateCodings(res, cm);
    }
    return res;
  }

  private static List<Coding> translateCodings(List<Coding> codes, ConceptMap cm) {
    List<Coding> res = new ArrayList<>();
    for (ConceptMapGroupComponent g : cm.getGroupList()) {
      for (SourceElementComponent e : g.getElementList()) {
        if (hasCode(g.getSource(), e.getCode(), codes)) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.getRelationship() == ConceptMapRelationship.EQUIVALENT || t.getRelationship() == ConceptMapRelationship.RELATEDTO || 
                t.getRelationship() == ConceptMapRelationship.SOURCEISBROADERTHANTARGET ||t.getRelationship() == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET) {
              res.add(new Coding().setSystem(g.getTarget()).setCode((t.getCode())));
            }
          }
        }
      }
    }
    return res;
  }

  private static boolean hasCode(String system, String code, List<Coding> codes) {
    for (Coding c : codes) {
      if (system.equals(c.getSystem()) && code.equals(c.getCode())) {
        return true;
      }
    }
    return false;
  }

  public static List<MappingTriple> getBySource(ConceptMap map, Coding c) {
    List<MappingTriple> list = new ArrayList<>();
    for (ConceptMapGroupComponent g : map.getGroupList()) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean sourceMatches = CanonicalType.matches(g.getSource(), c.getSystem(), c.getVersion());
      if (sourceMatches) {
        for (SourceElementComponent e : g.getElementList()) {
          if (e.getCode().equals(c.getCode())) {
            if (e.getNoMap()) {
              list.add(new MappingTriple(g, e, null));
            } else {
              for (TargetElementComponent t : e.getTargetList()) {
                list.add(new MappingTriple(g, e, t));
              }
            }
          }
        }
      }
    }
    return list;
  }

  public static List<MappingTriple> getByTarget(ConceptMap map, Coding c) {
    List<MappingTriple> list = new ArrayList<>();
    for (ConceptMapGroupComponent g : map.getGroupList()) {
      @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
      //False positive: not using String.matches
      boolean targetMatches = CanonicalType.matches(g.getTarget(), c.getSystem(), c.getVersion());
      if (targetMatches) {
        for (SourceElementComponent e : g.getElementList()) {
          for (TargetElementComponent t : e.getTargetList()) {
            if (t.getCode().equals(c.getCode())) {
              list.add(new MappingTriple(g, e, t));
            }
          }
        }
      }
    }
    return list;
  }

}
