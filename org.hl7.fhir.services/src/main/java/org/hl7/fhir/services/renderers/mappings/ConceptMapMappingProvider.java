package org.hl7.fhir.services.renderers.mappings;

import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.model.core.ConceptMap.SourceElementComponent;
import org.hl7.fhir.model.core.ConceptMap.TargetElementComponent;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.services.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConceptMapMappingProvider extends ModelMappingProvider {

  private ConceptMap map;
  private ConceptMapGroupComponent grp;
  private Object eqpath;

  public ConceptMapMappingProvider(RenderingContext context, StructureDefinition dest, boolean reverse, ConceptMap map, ConceptMapGroupComponent grp) {
    super(context, dest, reverse);
    this.map = map;
    this.grp = grp;

    CodeSystem cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-relationship", VersionResolutionRules.defaultRule());
    if (cs == null)
      cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-equivalence", VersionResolutionRules.defaultRule());
    eqpath = cs == null ? null : cs.getWebPath();
  }

  @Override
  public Column makeColumn(String id) {
    return new Column(id, map.getName(), dest.present(), map.getWebPath());
  }

  @Override
  public void render(ElementDefinition element, XhtmlNode div) {
    List<TargetElementComponent> list = new ArrayList<>();
    for (SourceElementComponent t : grp.getElementList()) {
      if (t.hasCode() && t.getCode().equals(element.getId())) {
        if (t.getNoMap()) {
          list.add(null);
        } else {
          list.addAll(t.getTargetList());
        }
      }
    }
    if (!list.isEmpty()) {
      if (list.size() == 1) {
        renderMap(div, list.get(0));
      } else {
        XhtmlNode ul = div.ul();
        for (TargetElementComponent s : list) {
          renderMap(ul.li(), s);
        }
      }
    }
  }

  @Override
  public int valueCount() {
    // one row per distinct source code that will render something (a no-map note, or one or more targets)
    Set<String> codes = new HashSet<>();
    for (SourceElementComponent t : grp.getElementList()) {
      if (t.hasCode() && (t.getNoMap() || t.hasTarget())) {
        codes.add(t.getCode());
      }
    }
    return codes.size();
  }

  private void renderMap(XhtmlNode x, TargetElementComponent tgt) {
    if (tgt == null) {
      x.tx("No Equivalent");
    } else {
      x.ahOrNot(eqpath == null ? null : eqpath+"#"+tgt.getRelationship().toCode()).tx(rel(tgt.getRelationship()));
    }
    x.tx(" ");
    x.ah(ref()+"#"+tgt.getCode()).tx(tgt.getCode());
    if (tgt.hasComment()) {
      XhtmlNode i = x.i();
      i.tx(" (");
      i.tx(tgt.getComment());
      i.tx(")");
    }
  }

  private String rel(ConceptMapRelationship rel) {
    switch (rel) {
    case EQUIVALENT: return "Equivalent To";
    case NOTRELATEDTO: return "Not Related To";
    case RELATEDTO: return "Related To";
    case SOURCEISBROADERTHANTARGET: return "Broader than";
    case SOURCEISNARROWERTHANTARGET: return "Narrower than";
    default: return "??";
    }
  }


}