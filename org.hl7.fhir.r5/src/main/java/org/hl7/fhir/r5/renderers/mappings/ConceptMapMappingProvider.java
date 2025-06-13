package org.hl7.fhir.r5.renderers.mappings;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ConceptMapMappingProvider extends ModelMappingProvider {

  private ConceptMap map;
  private ConceptMapGroupComponent grp;
  private Object eqpath;

  public ConceptMapMappingProvider(RenderingContext context, StructureDefinition dest, boolean reverse, ConceptMap map, ConceptMapGroupComponent grp) {
    super(context, dest, reverse);
    this.map = map;
    this.grp = grp;

    CodeSystem cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-relationship");
    if (cs == null)
      cs = context.getWorker().fetchCodeSystem("http://hl7.org/fhir/concept-map-equivalence");
    eqpath = cs == null ? null : cs.getWebPath();
  }

  @Override
  public Column makeColumn(String id) {
    return new Column(id, map.getName(), dest.present(), map.getWebPath());
  }

  @Override
  public void render(ElementDefinition element, XhtmlNode div) {
    List<TargetElementComponent> list = new ArrayList<>();
    for (SourceElementComponent t : grp.getElement()) {
      if (t.hasCode() && t.getCode().equals(element.getId())) {
        if (t.getNoMap()) {
          list.add(null);
        } else {
          list.addAll(t.getTarget());
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
