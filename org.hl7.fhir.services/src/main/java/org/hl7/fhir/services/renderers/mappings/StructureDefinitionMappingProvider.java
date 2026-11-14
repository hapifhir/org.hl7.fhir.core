package org.hl7.fhir.services.renderers.mappings;

import org.hl7.fhir.services.fhirpath.ExpressionNode;
import org.hl7.fhir.services.fhirpath.ExpressionNode.Kind;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.model.core.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.StructureDefinition.*;
import org.hl7.fhir.services.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.utilities.MappingSpace;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  /**
   * where to link for a mapping that isn't to a known StructureDefinition: the tools extension mapping-reference, 
   * then the link in the mapping space metadata, then the uri itself, if it's a URL. Null if there's nowhere to link
   */
  public static String mappingLink(RenderingContext context, StructureDefinitionMappingComponent map) {
    String ref = map.getExtensionString(ExtensionDefinitions.EXT_MAPPING_REFERENCE);
    if (Utilities.isAbsoluteUrlLinkable(ref)) {
      return ref;
    }
    MappingSpace ms = map.hasUri() ? context.getMappingSpaces().get(map.getUri()) : null;
    if (ms != null && ms.hasLink() && Utilities.isAbsoluteUrlLinkable(ms.getLink())) {
      return ms.getLink();
    }
    return map.hasUri() && Utilities.isAbsoluteUrlLinkable(map.getUri()) ? map.getUri() : null;
  }

  @Override
  public Column makeColumn(String id) {
    if (dest != null) {
      return new Column(id, map.getName(), dest.present(), dest.getWebPath()).setAnchor(map.getIdentity());
    } else {
      // no known StructureDefinition for this mapping - all we have is what's in the mapping declaration itself
      // the mapping uri is an identifier for the mapping target, and often doesn't resolve. The mapping can say
      // where to find out about it (the tools extension mapping-reference), and the mapping space metadata from
      // the core package says where to find out about the known ones (#1171)
      MappingSpace ms = map.hasUri() ? context.getMappingSpaces().get(map.getUri()) : null;
      // not the comment - that's shown in the Mapping Comments row
      String hint = ms != null && !Utilities.noString(ms.getTitle()) ? ms.getTitle() : map.hasUri() ? map.getUri() : map.getName();
      String link = mappingLink(context, map);
      return new Column(id, map.getName(), hint, link).setAnchor(map.getIdentity());
    }
  }

  @Override
  public String getColumnKey() {
    return map.hasIdentity() ? "map-"+map.getIdentity() : null;
  }

  @Override
  public String getComment() {
    return map.hasComment() ? map.getComment() : null;
  }

  @Override
  public void render(ElementDefinition element, XhtmlNode div) throws IOException {
    if (reverse) {
      List<ElementDefinition> sources = new ArrayList<>();
      for (ElementDefinition ed : dest.getSnapshot().getElementList()) {
        ElementDefinitionMappingComponent m = null;
        for (ElementDefinitionMappingComponent t : ed.getMappingList()) {
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
      for (ElementDefinitionMappingComponent t : element.getMappingList()) {
        if (t.hasIdentity() && t.getIdentity().equals(map.getIdentity())) {
          m = t;
        }
      }
      if (m != null) {
        // the map is just a string: a comma has no special meaning in it, so it's not split up (#1171). Line breaks are kept
        if (m.hasMap()) {
          renderMap(div, m.getMap().trim());
        }
        if (m.hasComment()) {
          if (m.hasMap()) {
            div.br();
          }
          // a very faint yellow behind the comment, to separate it from the map itself
          div.span().style("background-color: #fffde7").i().tx(m.getComment());
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
      for (ElementDefinition ed : dest.getSnapshot().getElementList()) {
        for (ElementDefinitionMappingComponent m : ed.getMappingList()) {
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
      for (ElementDefinition element : sd.getSnapshot().getElementList()) {
        if (targets.contains(element.getId()) || targets.contains(element.getPath())) {
          count++;
        }
      }
    } else {
      // a row has content if the element has a mapping for this identity with a map or a comment
      for (ElementDefinition element : sd.getSnapshot().getElementList()) {
        for (ElementDefinitionMappingComponent m : element.getMappingList()) {
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
    } else if ((s.startsWith("http:") || s.startsWith("https:")) && Utilities.isAbsoluteUrlLinkable(s) && !hasLineBreak(s)) {
      Resource res = context.getContext().fetchResource(Resource.class, s, VersionResolutionRules.PACKAGE);
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
        textWithBreaks(x.ah(ref()+"#"+l, l), r);
      } else {
        textWithBreaks(x, s); // the colon isn't the id: path syntax, so it's just part of the text
      }
    } else {
      // what's going on here is that if it happens to be FHIRPath, and we can strip this down to a path reference
      // we do, and make it a link, but it's not an error if we can't
      try {
        ExpressionNode exp = fpe.parse(s);
        stripFunctions(exp);
        String p = exp.toString();
        if (dest != null && dest.getSnapshot().getElementById(p) != null) {
          textWithBreaks(x.ah(ref()+"#"+p, p), s);
        } else {
          textWithBreaks(x, s);
        }
      } catch (Exception e) {
        textWithBreaks(x, s);
      }
    }
  }

  private boolean hasLineBreak(String s) {
    return s.contains("\n") || s.contains("\r");
  }

  /**
   * render the text, with a br for each line break in it
   */
  private void textWithBreaks(XhtmlNode x, String s) {
    boolean first = true;
    for (String line : Utilities.splitLines(s)) {
      if (first) {
        first = false;
      } else {
        x.br();
      }
      x.tx(line);
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