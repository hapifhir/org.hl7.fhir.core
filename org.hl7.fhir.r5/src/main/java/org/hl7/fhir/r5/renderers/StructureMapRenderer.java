package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.IdType;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.model.Enumerations.SearchComparator;
import org.hl7.fhir.r5.model.Enumerations.SearchModifierCode;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupInputComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleDependentComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleSourceComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetParameterComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapStructureComponent;
import org.hl7.fhir.r5.model.StructureMap.StructureMapTargetListMode;
import org.hl7.fhir.r5.model.StructureMap.StructureMapTransform;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.KnownLinkType;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.XhtmlFluent;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class StructureMapRenderer extends TerminologyRenderer {

  private static final String COLOR_COMMENT = "green";
  private static final String COLOR_METADATA = "#cc00cc";
  private static final String COLOR_CONST = "blue";
  private static final String COLOR_VARIABLE = "maroon";
  private static final String COLOR_SYNTAX = "navy";
  private static final boolean RENDER_MULTIPLE_TARGETS_ONELINE = true;
  private static final String COLOR_SPECIAL = "#b36b00";
  private static final String DEFAULT_COMMENT = "This element was not defined prior to R5";
  
  private String clauseComment = DEFAULT_COMMENT;

  public StructureMapRenderer(RenderingContext context) {
    super(context);
  }

  public StructureMapRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws IOException, FHIRException, EOperationOutcome {
    return render(x, (StructureMap) dr);
  }

  public boolean render(XhtmlNode x, StructureMap map) throws IOException, FHIRException, EOperationOutcome {
    renderMap(x.pre("fml"), map);
    return false;
  }

  public void renderMap(XhtmlNode x, StructureMap map) {
    x.tx("\r\n");
    if (VersionUtilities.isR5Plus(context.getContext().getVersion())) {
      renderMetadata(x, "url", map.getUrlElement());
      renderMetadata(x, "name", map.getNameElement());
      renderMetadata(x, "title", map.getTitleElement());
      renderMetadata(x, "status", map.getStatusElement());      
      x.tx("\r\n");
    } else {
      x.b().tx("map");
      x.color(COLOR_SYNTAX).tx(" \"");
      x.tx(map.getUrl());
      x.color(COLOR_SYNTAX).tx("\" = \"");
      x.tx(Utilities.escapeJson(map.getName()));
      x.color(COLOR_SYNTAX).tx("\"\r\n\r\n");
      if (map.getDescription() != null) {
        renderMultilineDoco(x, map.getDescription(), 0, null);
        x.tx("\r\n");
      }
    }
    renderConceptMaps(x, map);
    renderUses(x, map);
    renderImports(x, map);
    for (StructureMapGroupComponent g : map.getGroup())
      renderGroup(x, g);
  }

  private void renderMetadata(XhtmlNode x, String name, DataType value) {
    if (!value.isEmpty()) {
      renderMetadata(x, name, value, null);
    }
  }
  
  private void renderMetadata(XhtmlNode x, String name, DataType value, String def) {
    String v = value.primitiveValue();
    if (def == null || !def.equals(v)) {
      XhtmlNode c = x.color(COLOR_METADATA);
      c.tx("/// ");
      c.b().tx(name);
      c.tx(" = ");
      if (Utilities.existsInList(v, "true", "false") || Utilities.isDecimal(v, true)) {
        x.color(COLOR_CONST).tx(v);
      } else {
        x.color(COLOR_CONST).tx("'"+v+"'");
      }
      x.tx("\r\n");
    }
  }

  private void renderConceptMaps(XhtmlNode x,StructureMap map) {
    for (Resource r : map.getContained()) {
      if (r instanceof ConceptMap) {
        produceConceptMap(x, (ConceptMap) r);
      }
    }
  }

  private void produceConceptMap(XhtmlNode x,ConceptMap cm) {
    if (cm.hasFormatCommentPre()) {
      renderMultilineDoco(x, cm.getFormatCommentsPre(), 0, null);
    }
    x.b().tx("conceptmap");
    x.color(COLOR_SYNTAX).tx(" \"");
    x.tx(cm.getId());
    x.color(COLOR_SYNTAX).tx("\" {\r\n");
    Map<String, String> prefixesSrc = new HashMap<String, String>();
    Map<String, String> prefixesTgt = new HashMap<String, String>();
    char prefix = 's';
    for (ConceptMapGroupComponent cg : cm.getGroup()) {
      if (!prefixesSrc.containsKey(cg.getSource())) {
        prefixesSrc.put(cg.getSource(), String.valueOf(prefix));
        x.b().tx("  prefix ");
        x.tx(""+prefix);
        x.color(COLOR_SYNTAX).tx(" = \"");
        CodeSystem cs = context.getContext().fetchResource(CodeSystem.class, cg.getSource());
        if (cs != null && cs.hasUserData("path")) {
          x.ah(cs.getUserString("path"), cs.present()).tx(cg.getSource());
        } else {
          x.tx(cg.getSource());
        }
        x.color(COLOR_SYNTAX).tx("\"\r\n");
        prefix++;
      }
      if (!prefixesTgt.containsKey(cg.getTarget())) {
        prefixesTgt.put(cg.getTarget(), String.valueOf(prefix));
        x.b().tx("  prefix ");
        x.tx(""+prefix);
        x.color(COLOR_SYNTAX).tx(" = \"");
        CodeSystem cs = context.getContext().fetchResource(CodeSystem.class, cg.getTarget());
        if (cs != null && cs.hasUserData("path")) {
          x.ah(cs.getUserString("path"), cs.present()).tx(cg.getTarget());
        } else {
          x.tx(""+cg.getTarget());
        }
        x.color(COLOR_SYNTAX).tx("\"\r\n");
        prefix++;
      }
    }
    x.tx("\r\n");
    for (ConceptMapGroupComponent cg : cm.getGroup()) {
      if (cg.hasUnmapped()) {
        x.b().tx("  unmapped for ");
        x.tx(prefixesSrc.get(cg.getSource()));
        x.color(COLOR_SYNTAX).tx(" = ");
        x.tx(cg.getUnmapped().getMode().toCode());
        x.tx("\r\n");
      }
    }

    for (ConceptMapGroupComponent cg : cm.getGroup()) {
      if (cg.hasFormatCommentPre()) {
        renderMultilineDoco(x, cg.getFormatCommentsPre(), 2, prefixesSrc.values());
      }
      for (SourceElementComponent ce : cg.getElement()) {
        if (ce.hasFormatCommentPre()) {
          renderMultilineDoco(x, ce.getFormatCommentsPre(), 2, prefixesSrc.values());
        }

        x.tx("  ");
        x.tx(prefixesSrc.get(cg.getSource()));
        x.color(COLOR_SYNTAX).tx(":");
        if (Utilities.isToken(ce.getCode())) {
          x.tx(ce.getCode());
        } else {
          x.tx("\"");
          x.tx(ce.getCode());
          x.tx("\"");
        }
        x.tx(" ");
        x.b().tx(getChar(ce.getTargetFirstRep().getRelationship()));
        x.tx(" ");
        x.tx(prefixesTgt.get(cg.getTarget()));
        x.color(COLOR_SYNTAX).tx(":");
        if (Utilities.isToken(ce.getTargetFirstRep().getCode())) {
          x.tx(ce.getTargetFirstRep().getCode());
        } else {
          x.color(COLOR_SYNTAX).tx("\"");
          x.tx(ce.getTargetFirstRep().getCode());
          x.color(COLOR_SYNTAX).tx("\"");
        }
        x.tx("\r\n");
        if (ce.hasFormatCommentPost()) {
          renderMultilineDoco(x, ce.getFormatCommentsPost(), 2, prefixesSrc.values());
        }
      }
      if (cg.hasFormatCommentPost()) {
        renderMultilineDoco(x, cg.getFormatCommentsPost(), 2, prefixesSrc.values());
      }
    }
    if (cm.hasFormatCommentPost()) {
      renderMultilineDoco(x, cm.getFormatCommentsPost(), 2, prefixesSrc.values());
    }
    x.color(COLOR_SYNTAX).tx("}\r\n\r\n");
  }

  private String getChar(ConceptMapRelationship relationship) {
    switch (relationship) {
      case RELATEDTO:
        return "-";
      case EQUIVALENT:
        return "==";
      case NOTRELATEDTO:
        return "!=";
      case SOURCEISNARROWERTHANTARGET:
        return "<=";
      case SOURCEISBROADERTHANTARGET:
        return ">=";
      default:
        return "??";
    }
  }

  private void renderUses(XhtmlNode x,StructureMap map) {
    for (StructureMapStructureComponent s : map.getStructure()) {
      x.b().tx("uses");
      x.color(COLOR_SYNTAX).tx(" \"");
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, s.getUrl());
      if (sd != null && sd.hasUserData("path")) {
        x.ah(sd.getUserString("path"), sd.present()).tx(s.getUrl());
      } else {
        x.tx(s.getUrl());
      }
      x.color(COLOR_SYNTAX).tx("\" ");
      if (s.hasAlias()) {
        x.b().tx("alias ");
        x.tx(s.getAlias());
        x.tx(" ");
      }
      x.b().tx("as ");
      x.b().tx(s.getMode().toCode());
      renderDoco(x, s.getDocumentation(), false, null);
      x.tx("\r\n");
    }
    if (map.hasStructure())
      x.tx("\r\n");
  }

  private void renderImports(XhtmlNode x,StructureMap map) {
    for (UriType s : map.getImport()) {
      x.b().tx("imports");
      x.color(COLOR_SYNTAX).tx(" \"");
      StructureMap m = context.getContext().fetchResource(StructureMap.class, s.getValue());
      if (m != null) {
        x.ah(m.getUserString("path"), m.present()).tx(s.getValue());
      } else {
        x.tx(s.getValue());
      }
      x.color(COLOR_SYNTAX).tx("\"\r\n");
    }
    if (map.hasImport())
      x.tx("\r\n");
  }

  private void renderGroup(XhtmlNode x,StructureMapGroupComponent g) {
    Collection<String> tokens = scanVariables(g, null);
    if (g.hasFormatCommentPre()) {
      renderMultilineDoco(x, g.getFormatCommentsPre(), 0, tokens);
    }
    if (g.hasDocumentation()) {
      renderMultilineDoco(x, g.getDocumentation(), 0, tokens);
    }
    x.b().tx("group ");
    x.tx(g.getName());
    x.color(COLOR_SYNTAX).tx("(");
    boolean first = true;
    for (StructureMapGroupInputComponent gi : g.getInput()) {
      if (first)
        first = false;
      else
        x.tx(", ");
      x.b().tx(gi.getMode().toCode());
      x.tx(" ");
      x.color(COLOR_VARIABLE).tx(gi.getName());
      if (gi.hasType()) {
        x.color(COLOR_SYNTAX).tx(" : ");
        x.tx(gi.getType());
      }
    }
    x.color(COLOR_SYNTAX).tx(")");
    if (g.hasExtends()) {
      x.b().tx(" extends ");
      x.tx(g.getExtends());
    }

    if (g.hasTypeMode()) {
      switch (g.getTypeMode()) {
        case TYPES:
          x.b().tx(" <<types>>");
          break;
        case TYPEANDTYPES:
          x.b().tx(" <<type+>>");
          break;
        default: // NONE, NULL
      }
    }
    x.color(COLOR_SYNTAX).tx(" {\r\n");
    for (StructureMapGroupRuleComponent r : g.getRule()) {
      renderRule(x, g, r, 2);
    }
    if (g.hasFormatCommentPost()) {
      renderMultilineDoco(x, g.getFormatCommentsPost(), 0, scanVariables(g, null));
    }
    x.color(COLOR_SYNTAX).tx("}\r\n\r\n");
  }

  private void renderRule(XhtmlNode x, StructureMapGroupComponent g, StructureMapGroupRuleComponent r, int indent) {
    Collection<String> tokens = scanVariables(g, r);
    if (r.hasFormatCommentPre()) {
      renderMultilineDoco(x, r.getFormatCommentsPre(), indent, tokens);
    }
    for (int i = 0; i < indent; i++)
      x.tx(" ");
    boolean canBeAbbreviated = checkisSimple(r);
    {
      boolean first = true;
      for (StructureMapGroupRuleSourceComponent rs : r.getSource()) {
        if (first)
          first = false;
        else
          x.color(COLOR_SYNTAX).tx(", ");
        renderSource(x, rs, canBeAbbreviated);
      }
    }
    if (r.getTarget().size() > 1) {
      x.color(COLOR_SYNTAX).b().tx(" -> ");
      boolean first = true;
      for (StructureMapGroupRuleTargetComponent rt : r.getTarget()) {
        if (first)
          first = false;
        else
          x.color(COLOR_SYNTAX).tx(", ");
        if (RENDER_MULTIPLE_TARGETS_ONELINE)
          x.tx(" ");
        else {
          x.tx("\r\n");
          for (int i = 0; i < indent + 4; i++)
            x.tx(" ");
        }
        renderTarget(x, rt, false);
      }
    } else if (r.hasTarget()) {
      x.color(COLOR_SYNTAX).b().tx(" -> ");
      renderTarget(x, r.getTarget().get(0), canBeAbbreviated);
    }
    if (r.hasRule()) {
      x.b().tx(" then");
      x.color(COLOR_SYNTAX).tx(" {\r\n");
      for (StructureMapGroupRuleComponent ir : r.getRule()) {
        renderRule(x, g, ir, indent + 2);
      }
      for (int i = 0; i < indent; i++)
        x.tx(" ");
      x.color(COLOR_SYNTAX).tx("}");
    } else {
      if (r.hasDependent()) {
        x.b().tx(" then ");
        boolean first = true;
        for (StructureMapGroupRuleDependentComponent rd : r.getDependent()) {
          if (first)
            first = false;
          else
            x.color(COLOR_SYNTAX).tx(", ");
          x.tx(rd.getName());
          x.color(COLOR_SYNTAX).tx("(");
          boolean ifirst = true;
          for (StructureMapGroupRuleTargetParameterComponent rdp : rd.getParameter()) {
            if (ifirst)
              ifirst = false;
            else
              x.color(COLOR_SYNTAX).tx(", ");
            renderTransformParam(x, rdp);
          }
          x.color(COLOR_SYNTAX).tx(")");
        }
      }
    }
    if (r.hasName()) {
      String n = ntail(r.getName());
      if (!n.startsWith("\""))
        n = "\"" + n + "\"";
      if (!matchesName(n, r.getSource())) {
        x.tx(" ");
        x.i().tx(n);
      }
    }
    x.color(COLOR_SYNTAX).tx(";");
    if (r.hasDocumentation()) {
      renderDoco(x, r.getDocumentation(), false, null);
    }
    x.tx("\r\n");
    if (r.hasFormatCommentPost()) {
      renderMultilineDoco(x, r.getFormatCommentsPost(), indent, tokens);
    }
  }

  private Collection<String> scanVariables(StructureMapGroupComponent g, StructureMapGroupRuleComponent r) {
    Set<String> res = new HashSet<>();
    for (StructureMapGroupInputComponent input : g.getInput()) {
      res.add(input.getName());
    }
    if (r != null) {
      for (StructureMapGroupRuleSourceComponent src : r.getSource()) {
        if (src.hasVariable()) {
          res.add(src.getVariable());
        }
      }
    }
    return res;
  }

  private boolean matchesName(String n, List<StructureMapGroupRuleSourceComponent> source) {
    if (source.size() != 1)
      return false;
    if (!source.get(0).hasElement())
      return false;
    String s = source.get(0).getElement();
    if (n.equals(s) || n.equals("\"" + s + "\""))
      return true;
    if (source.get(0).hasType()) {
      s = source.get(0).getElement() + "-" + source.get(0).getType();
      return n.equals(s) || n.equals("\"" + s + "\"");
    }
    return false;
  }

  private String ntail(String name) {
    if (name == null)
      return null;
    if (name.startsWith("\"")) {
      name = name.substring(1);
      name = name.substring(0, name.length() - 1);
    }
    return "\"" + (name.contains(".") ? name.substring(name.lastIndexOf(".") + 1) : name) + "\"";
  }

  private boolean checkisSimple(StructureMapGroupRuleComponent r) {
    return
      (r.getSource().size() == 1 && r.getSourceFirstRep().hasElement() && r.getSourceFirstRep().hasVariable()) &&
        (r.getTarget().size() == 1 && r.getTargetFirstRep().hasVariable() && (r.getTargetFirstRep().getTransform() == null || r.getTargetFirstRep().getTransform() == StructureMapTransform.CREATE) && r.getTargetFirstRep().getParameter().size() == 0) &&
        (r.getDependent().size() == 0) && (r.getRule().size() == 0);
  }
  
  private void renderSource(XhtmlNode x,StructureMapGroupRuleSourceComponent rs, boolean abbreviate) {
    x.tx(rs.getContext());
    if (rs.getContext().equals("@search")) {
      x.color(COLOR_SYNTAX).tx("(");
      x.tx(rs.getElement());
      x.color(COLOR_SYNTAX).tx(")");
    } else if (rs.hasElement()) {
      x.tx(".");
      x.tx(rs.getElement());
    }
    if (rs.hasType()) {
      x.color(COLOR_SYNTAX).tx(" : ");
      x.tx(rs.getType());
      if (rs.hasMin()) {
        x.tx(" ");
        x.tx(rs.getMin());
        x.color(COLOR_SYNTAX).tx("..");
        x.tx(rs.getMax());
      }
    }

    if (rs.hasListMode()) {
      x.tx(" ");
      x.tx(rs.getListMode().toCode());
    }
    if (rs.hasDefaultValue()) {
      x.b().tx(" default ");
      x.tx("\"" + Utilities.escapeJson(rs.getDefaultValue()) + "\"");
    }
    if (!abbreviate && rs.hasVariable()) {
      x.b().tx(" as ");
      x.color(COLOR_VARIABLE).tx(rs.getVariable());
    }
    if (rs.hasCondition()) {
      x.b().tx(" where ");
      x.tx(rs.getCondition());
    }
    if (rs.hasCheck()) {
      x.b().tx(" check ");
      x.tx(rs.getCheck());
    }
    if (rs.hasLogMessage()) {
      x.b().tx(" log ");
      x.tx(rs.getLogMessage());
    }
  }
  
  private void renderTarget(XhtmlNode x,StructureMapGroupRuleTargetComponent rt, boolean abbreviate) {
    if (rt.hasContext()) {
      x.tx(rt.getContext());
      if (rt.hasElement()) {
        x.tx(".");
        x.tx(rt.getElement());
      }
    }
    if (!abbreviate && rt.hasTransform()) {
      if (rt.hasContext())
        x.tx(" = ");
      if (rt.getTransform() == StructureMapTransform.COPY && rt.getParameter().size() == 1) {
        renderTransformParam(x, rt.getParameter().get(0));
      } else if (rt.getTransform() == StructureMapTransform.EVALUATE && rt.getParameter().size() == 1) {
        x.color(COLOR_SYNTAX).tx("(");
        x.tx(((StringType) rt.getParameter().get(0).getValue()).asStringValue());
        x.color(COLOR_SYNTAX).tx(")");
      } else if (rt.getTransform() == StructureMapTransform.EVALUATE && rt.getParameter().size() == 2) {
        x.tx(rt.getTransform().toCode());
        x.color(COLOR_SYNTAX).tx("(");
        x.tx(((IdType) rt.getParameter().get(0).getValue()).asStringValue());
        x.color(COLOR_SYNTAX).tx(", ");
        x.tx(((StringType) rt.getParameter().get(1).getValue()).asStringValue());
        x.color(COLOR_SYNTAX).tx(")");
      } else {
        x.b().tx(rt.getTransform().toCode());
        x.color(COLOR_SYNTAX).tx("(");
        boolean first = true;
        for (StructureMapGroupRuleTargetParameterComponent rtp : rt.getParameter()) {
          if (first)
            first = false;
          else
            x.color(COLOR_SYNTAX).tx(", ");
          renderTransformParam(x, rtp);
        }
        x.color(COLOR_SYNTAX).tx(")");
      }
    }
    if (!abbreviate && rt.hasVariable()) {
      x.b().tx(" as ");
      x.color(COLOR_VARIABLE).tx(rt.getVariable());
    }
    for (Enumeration<StructureMapTargetListMode> lm : rt.getListMode()) {
      x.tx(" ");
      x.b().tx(lm.getValue().toCode());
      if (lm.getValue() == StructureMapTargetListMode.SHARE) {
        x.tx(" ");
        x.b().tx(rt.getListRuleId());
      }
    }
  }


  private void renderTransformParam(XhtmlNode x,StructureMapGroupRuleTargetParameterComponent rtp) {
    try {
      if (rtp.hasValueBooleanType())
        x.color(COLOR_CONST).tx(rtp.getValueBooleanType().asStringValue());
      else if (rtp.hasValueDecimalType())
        x.color(COLOR_CONST).tx(rtp.getValueDecimalType().asStringValue());
      else if (rtp.hasValueIdType())
        x.color(COLOR_VARIABLE).tx(rtp.getValueIdType().asStringValue());
      else if (rtp.hasValueIntegerType())
        x.color(COLOR_CONST).tx(rtp.getValueIntegerType().asStringValue());
      else
        x.color(COLOR_CONST).tx("'" + Utilities.escapeJava(rtp.getValueStringType().asStringValue()) + "'");
    } catch (FHIRException e) {
      e.printStackTrace();
      x.tx("error!");
    }
  }

  private void renderDoco(XhtmlNode x,String doco, boolean startLine, Collection<String> tokens) {
    if (Utilities.noString(doco))
      return;
    if (!startLine) {
      x.tx(" ");
    }
    boolean isClause = false;
    String t = doco.trim().replace(" ", "");
    if (tokens != null) {
      for (String s : tokens) {
        if (t.startsWith(s+":") || t.startsWith(s+".") || t.startsWith(s+"->")) {
          isClause = true;
          break;
        }
      }
    }
    if (isClause) {
      XhtmlNode s= x.color(COLOR_SPECIAL);
      s.setAttribute("title", clauseComment );
      s.tx("// ");
      s.tx(doco.replace("\r\n", " ").replace("\r", " ").replace("\n", " "));      
    } else {
      x.color(COLOR_SYNTAX).tx("// ");
      x.color(COLOR_COMMENT).tx(doco.replace("\r\n", " ").replace("\r", " ").replace("\n", " "));
    }
  }

  private void renderMultilineDoco(XhtmlNode x,String doco, int indent, Collection<String> tokens) {
    if (Utilities.noString(doco))
      return;
    String[] lines = doco.split("\\r?\\n");
    for (String line : lines) {
      for (int i = 0; i < indent; i++)
        x.tx(" ");
      renderDoco(x, line, true, tokens);
      x.tx("\r\n");
    }
  }

  private void renderMultilineDoco(XhtmlNode x, List<String> doco, int indent, Collection<String> tokens) {
    for (String line : doco) {
      for (int i = 0; i < indent; i++)
        x.tx(" ");
      renderDoco(x, line, true, tokens);
      x.tx("\r\n");
    }
  }


  public void describe(XhtmlNode x, OperationDefinition opd) {
    x.tx(display(opd));
  }

  public String display(OperationDefinition opd) {
    return opd.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((StructureMap) r).present();
  }

}
