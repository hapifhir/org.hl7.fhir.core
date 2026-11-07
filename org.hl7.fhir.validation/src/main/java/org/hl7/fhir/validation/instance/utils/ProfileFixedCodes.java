package org.hl7.fhir.validation.instance.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;

/**
 * The codes a profile fixes for an element (from its snapshot): a fixed or pattern
 * CodeableConcept (or CodeableReference) on the element, a fixed or pattern Coding on its coding
 * or a slice of it, or a fixed or pattern system and code inside one of those
 */
public class ProfileFixedCodes {

  private final List<ElementDefinition> list;
  private final Map<String, ElementDefinition> byId = new HashMap<>();

  public ProfileFixedCodes(StructureDefinition sd) {
    list = sd.getSnapshot().getElementList();
    for (ElementDefinition ed : list) {
      if (ed.hasId()) {
        byId.put(ed.getId(), ed);
      }
    }
  }

  public List<ElementDefinition> getList() {
    return list;
  }

  public ElementDefinition get(String id) {
    return byId.get(id);
  }

  public static DataType fixedOrPattern(ElementDefinition ed) {
    return ed == null ? null : ed.hasFixed() ? ed.getFixed() : ed.hasPattern() ? ed.getPattern() : null;
  }

  /** the fixed or pattern value of a primitive element */
  public String primitive(String id) {
    DataType v = fixedOrPattern(byId.get(id));
    return v != null && v.isPrimitive() ? v.primitiveValue() : null;
  }

  /**
   * The codes in the system that the profile fixes for the element with this id (a CodeableConcept,
   * or the concept of a CodeableReference).
   *
   * @param requiredSlicesOnly true: only a required slice of coding fixes the code (the element
   *   is that code); false: any slice (if the element has that coding, that's the code)
   */
  public List<Coding> fixedCodes(String elementId, String system, boolean requiredSlicesOnly) {
    Map<String, Coding> res = new LinkedHashMap<>();
    for (String id : new String[] { elementId, elementId + ".concept" }) {
      DataType v = fixedOrPattern(byId.get(id));
      if (v instanceof CodeableReference) {
        v = ((CodeableReference) v).getConcept();
      }
      if (v instanceof CodeableConcept) {
        for (Coding c : ((CodeableConcept) v).getCodingList()) {
          add(res, system, c.getSystem(), c.getCode(), c.getVersion(), c.getDisplay());
        }
      }
    }
    for (ElementDefinition ed : list) {
      String id = ed.getId();
      if (id == null) {
        continue;
      }
      for (String base : new String[] { elementId + ".coding", elementId + ".concept.coding" }) {
        boolean coding = id.equals(base);
        boolean slice = id.startsWith(base + ":") && !id.substring((base + ":").length()).contains(".");
        if (!(coding || (slice && (!requiredSlicesOnly || ed.getMin() > 0)))) {
          continue;
        }
        if (fixedOrPattern(ed) instanceof Coding) {
          Coding c = (Coding) fixedOrPattern(ed);
          add(res, system, c.getSystem(), c.getCode(), c.getVersion(), c.getDisplay());
        } else {
          add(res, system, primitive(id + ".system"), primitive(id + ".code"), primitive(id + ".version"), primitive(id + ".display"));
        }
      }
    }
    return new ArrayList<>(res.values());
  }

  private void add(Map<String, Coding> res, String want, String system, String code, String version, String display) {
    if (want.equals(system) && code != null && !res.containsKey(code)) {
      res.put(code, new Coding(system, code, display).setVersion(version));
    }
  }

  /** the ids of the slices of an element (e.g. Observation.component:systolic) */
  public List<ElementDefinition> slices(String path) {
    List<ElementDefinition> res = new ArrayList<>();
    for (ElementDefinition ed : list) {
      if (path.equals(ed.getPath()) && ed.hasSliceName() && ed.hasId() && !"0".equals(ed.getMax())) {
        res.add(ed);
      }
    }
    return res;
  }
}
