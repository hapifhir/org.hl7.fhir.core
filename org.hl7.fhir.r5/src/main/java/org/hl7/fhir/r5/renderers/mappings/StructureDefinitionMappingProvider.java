package org.hl7.fhir.r5.renderers.mappings;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Function;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Operation;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.SourceLocation;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class StructureDefinitionMappingProvider extends ModelMappingProvider {

  private StructureDefinition sd;
  private StructureDefinitionMappingComponent map;
  private FHIRPathEngine fpe;

  public StructureDefinitionMappingProvider(RenderingContext context, StructureDefinition dest, boolean reverse, StructureDefinition sd, StructureDefinitionMappingComponent map, FHIRPathEngine fpe) {
    super(context, dest, reverse);
    this.sd = sd;
    this.map = map;
    this.fpe = fpe;
  }

  @Override
  public Column makeColumn(String id) {
    return new Column(id, map.getName(), dest == null ? "??" : dest.present(), null);
  }

  @Override
  public void render(ElementDefinition element, XhtmlNode div) {
    if (reverse) {
      List<ElementDefinition> sources = new ArrayList<>();
      for (ElementDefinition ed : dest.getSnapshot().getElement()) {
        ElementDefinitionMappingComponent m = null;
        for (ElementDefinitionMappingComponent t : ed.getMapping()) {
          if (t.hasIdentity() && t.getIdentity().equals(map.getIdentity())) {
            m = t;
          }
        }
        if (m != null) {
          String[] maps = (m.getMap() == null ? "" : m.getMap()).split("\\,");
          for (String s : maps) {
            String tgt = processMap(s);
            if (tgt != null && tgt.equals(element.getId()) ||  tgt.equals(element.getPath())) {
              sources.add(ed);
            }
          }
        }
      }
      if (sources.size() == 1) {
        renderElementLink(div, sources.get(0));
      } else {
        XhtmlNode ul = div.ul();
        for (ElementDefinition ed : sources) {
          renderElementLink(ul.li(), ed);
        }
      }
    } else {
      ElementDefinitionMappingComponent m = null;
      for (ElementDefinitionMappingComponent t : element.getMapping()) {
        if (t.hasIdentity() && t.getIdentity().equals(map.getIdentity())) {
          m = t;
        }
      }
      if (m != null) {
        String[] maps = (m.getMap() == null ? "" : m.getMap()).split("\\,");
        if (maps.length == 1) {
          renderMap(div, maps[0]);
        } else {
          XhtmlNode ul = div.ul();
          for (String s : maps) {
            renderMap(ul.li(), s);
          }
        }
        if (m.hasComment()) {
          div.i().tx(m.getComment());
        }
      }
    }
  }

  private String processMap(String s) {
    if (s.contains(":")) {
      String l = s.substring(0, s.indexOf(":"));
      return l;
    } else {
      try {
        ExpressionNode exp = fpe.parse(s);
        stripFunctions(exp);
        return exp.toString();
      } catch (Exception e) {
        return null;
      }
    }
  }

  private void renderElementLink(XhtmlNode div, ElementDefinition ed) {
    div.ah(ref()+"#"+ed.getId()).tx(ed.getPath());
  }

  private void renderMap(XhtmlNode x, String s) {
    // the approved syntax is id: fhirPath, or it's just rendered directly
    if (s.contains(":")) {
      String l = s.substring(0, s.indexOf(":"));
      String r = s.substring(s.indexOf(":")+1);
      if (dest != null && dest.getSnapshot().getElementById(l) != null) {
        x.ah(ref()+"#"+l, l).tx(r);
      } else {
        x.tx(r);        
      }
    } else {
      try {
        ExpressionNode exp = fpe.parse(s);
        stripFunctions(exp);
        String p = exp.toString();
        if (dest.getSnapshot().getElementById(p) != null) {
          x.ah(ref()+"#"+p, p).tx(s);
        } else {
          x.tx(s);        
        }
      } catch (Exception e) {
        x.tx(s);
      }
    }
  }

  private void stripFunctions(ExpressionNode exp) {
    while (exp.getInner() != null && exp.getInner().getKind() == Kind.Function) {
      exp.setInner(exp.getInner().getInner());
    }
    if (exp.getInner() != null) {
      stripFunctions(exp.getInner());
    }
  }
}