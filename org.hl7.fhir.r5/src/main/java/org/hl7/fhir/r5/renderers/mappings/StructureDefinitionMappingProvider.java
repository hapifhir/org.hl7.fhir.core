package org.hl7.fhir.r5.renderers.mappings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.fhirpath.ExpressionNode;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.fhirpath.TypeDetails;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Function;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Kind;
import org.hl7.fhir.r5.fhirpath.ExpressionNode.Operation;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
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
  public void render(ElementDefinition element, XhtmlNode div) throws IOException {
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
          @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
          //single literal character split
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
      boolean complex = false;
      if (m != null) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //single literal character split
        String[] maps = (m.getMap() == null ? "" : m.getMap()).split("\\,");
        if (maps.length == 1) {
          renderMap(div, maps[0]);
        } else {
          complex = true;
          XhtmlNode ul = div.ul();
          for (String s : maps) {
            renderMap(ul.li(), s);
          }
        }
        if (m.hasComment()) {
          if (!complex) {
            div.br();
          }
          div.i().tx(m.getComment());
        }
      }
    }
  }

  @Override
  public int valueCount() {
    int count = 0;
    if (reverse) {
      // a row has content if some element in dest maps to it, so collect all the targets
      // of the mappings in dest, and then count the elements in sd that match one of them
      Set<String> targets = new HashSet<>();
      for (ElementDefinition ed : dest.getSnapshot().getElement()) {
        for (ElementDefinitionMappingComponent m : ed.getMapping()) {
          if (m.hasIdentity() && m.getIdentity().equals(map.getIdentity())) {
            @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
            //single literal character split
            String[] maps = (m.getMap() == null ? "" : m.getMap()).split("\\,");
            for (String s : maps) {
              String tgt = processMap(s);
              if (tgt != null) {
                targets.add(tgt);
              }
            }
          }
        }
      }
      for (ElementDefinition element : sd.getSnapshot().getElement()) {
        if (targets.contains(element.getId()) || targets.contains(element.getPath())) {
          count++;
        }
      }
    } else {
      // a row has content if the element has a mapping for this identity with a map or a comment
      for (ElementDefinition element : sd.getSnapshot().getElement()) {
        for (ElementDefinitionMappingComponent m : element.getMapping()) {
          if (m.hasIdentity() && m.getIdentity().equals(map.getIdentity()) && (m.hasMap() || m.hasComment())) {
            count++;
            break;
          }
        }
      }
    }
    return count;
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

  private void renderMap(XhtmlNode x, String s) throws IOException {
    // the approved syntax is id: fhirPath, or it's just rendered directly
    if ("n/a".equals(s)) {
      x.tx(s);
    } else if (s.startsWith("http:") || s.startsWith("https:")) {
      Resource res = context.getContext().fetchResource(Resource.class, s, IWorkerContext.VersionResolutionRules.PACKAGE);
      if (res == null) {
        res = context.getResolveLinkResolver().findLinkableResource(Resource.class, s);
      }
      if (res != null) {
        if (res instanceof CanonicalResource) {
          x.ah(res.getWebPath() != null ? res.getWebPath() : s).tx(((CanonicalResource) res).present());
        } else {
          var a = x.ah(s);
          a.tx(s);
          a.tx("("+res.fhirType()+")");
        }
      } else {
        x.ah(s).tx(s);
      }
    } else if (s.contains(":")) {
      String l = s.substring(0, s.indexOf(":"));
      String r = s.substring(s.indexOf(":")+1);
      if (dest != null && dest.getSnapshot().getElementById(l) != null) {
        x.ah(ref()+"#"+l, l).tx(r);
      } else {
        x.tx(r);
      }
    } else {
      // what's going on here is that if it happens to be FHIRPath, and we can strip this down to a path reference
      // we do, and make it a link, but it's not an error if we can't
      try {
        ExpressionNode exp = fpe.parse(s);
        stripFunctions(exp);
        String p = exp.toString();
        if (dest != null && dest.getSnapshot().getElementById(p) != null) {
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