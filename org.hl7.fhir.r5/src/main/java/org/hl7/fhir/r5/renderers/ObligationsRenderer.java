package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.profile.BindingResolution;
import org.hl7.fhir.r5.conformance.profile.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.r5.model.ActorDefinition;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.CodeResolver.CodeResolution;
import org.hl7.fhir.r5.renderers.ObligationsRenderer.ObligationDetail;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.utils.PublicationHacker;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlNodeList;

public class ObligationsRenderer {
  public static class ObligationDetail {
    private String code;
    private List<String> elementIds = new ArrayList<>();
    private String actorId;
    private String doco;
    private String docoShort;
    private String filter;
    private String filterDesc;
    private List<UsageContext> usage = new ArrayList<>();
    private boolean isUnchanged = false;
    private boolean matched = false;
    private boolean removed = false;
    private ValueSet vs;
    
    private ObligationDetail compare;
    private int count = 1;
    
    public ObligationDetail(Extension ext) {
      this.code =  ext.getExtensionString("code");
      this.actorId =  ext.getExtensionString("actorId");
      this.doco =  ext.getExtensionString("documentation");
      this.docoShort =  ext.getExtensionString("shortDoco");
      this.filter =  ext.getExtensionString("filter");
      this.filterDesc =  ext.getExtensionString("filter-desc");
      for (Extension usage : ext.getExtensionsByUrl("usage")) {
        this.usage.add(usage.getValueUsageContext());
      }
      for (Extension eid : ext.getExtensionsByUrl("elementId")) {
        this.elementIds.add(eid.getValue().primitiveValue());
      }
      this.isUnchanged = ext.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS);
    }
    
    private String getKey() {
      // Todo: Consider extending this with content from usageContext if purpose isn't sufficiently differentiating
      return code + Integer.toString(count);
    }
    
    private void incrementCount() {
      count++;
    }
    private void setCompare(ObligationDetail match) {
      compare = match;
      match.matched = true;
    }
    private boolean alreadyMatched() {
      return matched;
    }
    public String getDoco(boolean full) {
      return full ? doco : docoShort;
    }
    public String getCode() {
      return code;
    }
    public boolean unchanged() {
      if (!isUnchanged)
        return false;
      if (compare==null)
        return true;
      isUnchanged = true;
      isUnchanged = isUnchanged && ((code==null && compare.code==null) || code.equals(compare.code));
      isUnchanged = elementIds.equals(compare.elementIds);
      isUnchanged = isUnchanged && ((actorId==null && compare.actorId==null) || actorId.equals(compare.actorId));
      isUnchanged = isUnchanged && ((doco==null && compare.doco==null) || doco.equals(compare.doco));
      isUnchanged = isUnchanged && ((docoShort==null && compare.docoShort==null) || docoShort.equals(compare.docoShort));
      isUnchanged = isUnchanged && ((filter==null && compare.filter==null) || filter.equals(compare.filter));
      isUnchanged = isUnchanged && ((filterDesc==null && compare.filterDesc==null) || filterDesc.equals(compare.filterDesc));
      isUnchanged = isUnchanged && ((usage==null && compare.usage==null) || usage.equals(compare.usage));
      return isUnchanged;
    }
    
    public boolean hasFilter() {
      return filter != null;
    }

    public boolean hasUsage() {
      return !usage.isEmpty();
    }

    public String getFilterDesc() {
      return filterDesc;
    }

    public String getFilter() {
      return filter;
    }

    public List<UsageContext> getUsage() {
      return usage;
    }

    public boolean hasActor() {
      return actorId != null;
    }

    public boolean hasActor(String id) {
      return id.equals(actorId);
    }
  }

  private static String STYLE_UNCHANGED = "opacity: 0.5;";
  private static String STYLE_REMOVED = STYLE_UNCHANGED + "text-decoration: line-through;";

  private List<ObligationDetail> obligations = new ArrayList<>();
  private String corePath;
  private StructureDefinition profile;
  private String path;
  private RenderingContext context;
  private IMarkdownProcessor md;
  private CodeResolver cr;

  public ObligationsRenderer(String corePath, StructureDefinition profile, String path, RenderingContext context, IMarkdownProcessor md, CodeResolver cr) {
    this.corePath = corePath;
    this.profile = profile;
    this.path = path;
    this.context = context;
    this.md = md;
    this.cr = cr;
  }


  public void seeObligations(ElementDefinition element, String id) {
    seeObligations(element.getExtension(), null, false, id);
  }

  public void seeObligations(List<Extension> list) {
    seeObligations(list, null, false, "$all");
  }

  public void seeRootObligations(String eid, List<Extension> list) {
    seeRootObligations(eid, list, null, false, "$all");
  }

  public void seeObligations(List<Extension> list, List<Extension> compList, boolean compare, String id) {
    HashMap<String, ObligationDetail> compBindings = new HashMap<String, ObligationDetail>();
    if (compare && compList!=null) {
      for (Extension ext : compList) {
        ObligationDetail abr = obligationDetail(ext);
        if (compBindings.containsKey(abr.getKey())) {
          abr.incrementCount();
        }
        compBindings.put(abr.getKey(), abr);
      }
    }

    for (Extension ext : list) {
      ObligationDetail obd = obligationDetail(ext);
      if ("$all".equals(id) || (obd.hasActor(id))) {
        if (compare && compList!=null) {
          ObligationDetail match = null;
          do {
            match = compBindings.get(obd.getKey());
            if (obd.alreadyMatched())
              obd.incrementCount();
          } while (match!=null && obd.alreadyMatched());
          if (match!=null)
            obd.setCompare(match);
          obligations.add(obd);
          if (obd.compare!=null)
            compBindings.remove(obd.compare.getKey());
        } else {
          obligations.add(obd);
        }
      }
    }
    for (ObligationDetail b: compBindings.values()) {
      b.removed = true;
      obligations.add(b);
    }
  }

  public void seeRootObligations(String eid, List<Extension> list, List<Extension> compList, boolean compare, String id) {
    HashMap<String, ObligationDetail> compBindings = new HashMap<String, ObligationDetail>();
    if (compare && compList!=null) {
      for (Extension ext : compList) {
        if (forElement(eid, ext)) {
          ObligationDetail abr = obligationDetail(ext);
          if (compBindings.containsKey(abr.getKey())) {
            abr.incrementCount();
          }
          compBindings.put(abr.getKey(), abr);
        }
      }
    }

    for (Extension ext : list) {
      if (forElement(eid, ext)) {
        ObligationDetail obd = obligationDetail(ext);
        obd.elementIds.clear();
        if ("$all".equals(id) || (obd.hasActor(id))) {
          if (compare && compList!=null) {
            ObligationDetail match = null;
            do {
              match = compBindings.get(obd.getKey());
              if (obd.alreadyMatched())
                obd.incrementCount();
            } while (match!=null && obd.alreadyMatched());
            if (match!=null)
              obd.setCompare(match);
            obligations.add(obd);
            if (obd.compare!=null)
              compBindings.remove(obd.compare.getKey());
          } else {
            obligations.add(obd);
          }
        }
      }
    }
    for (ObligationDetail b: compBindings.values()) {
      b.removed = true;
      obligations.add(b);
    }
  }


  private boolean forElement(String eid, Extension ext) {

    for (Extension exid : ext.getExtensionsByUrl("elementId")) {
      if (eid.equals(exid.getValue().primitiveValue())) {
        return true;
      }
    } 
    return false;
  }


  protected ObligationDetail obligationDetail(Extension ext) {
    ObligationDetail abr = new ObligationDetail(ext);
    return abr;
  }

  public String render() throws IOException {
    if (obligations.isEmpty()) {
      return "";
    } else {
      XhtmlNode tbl = new XhtmlNode(NodeType.Element, "table");
      tbl.attribute("class", "grid");
      renderTable(tbl.getChildNodes(), true);
      return new XhtmlComposer(false).compose(tbl);
    }
  }

  public void renderTable(HierarchicalTableGenerator gen, Cell c) throws FHIRFormatError, DefinitionException, IOException {
    if (obligations.isEmpty()) {
      return;
    } else {
      Piece piece = gen.new Piece("table").attr("class", "grid");
      c.getPieces().add(piece);
      renderTable(piece.getChildren(), false);
    }
  }

  public void renderList(HierarchicalTableGenerator gen, Cell c) throws FHIRFormatError, DefinitionException, IOException {
    if (obligations.size() > 0) {
      Piece p = gen.new Piece(null);
      c.addPiece(p);
      if (obligations.size() == 1) {
        renderObligationLI(p.getChildren(), obligations.get(0));
      } else {
        XhtmlNode ul = p.getChildren().ul();
        for (ObligationDetail ob : obligations) {
          renderObligationLI(ul.li().getChildNodes(), ob);
        }
      }
    }
  }

  private void renderObligationLI(XhtmlNodeList children, ObligationDetail ob) throws IOException {
    renderCode(children, ob.getCode());
    if (ob.hasFilter() || ob.hasUsage()) {
      children.tx(" (");
      boolean ffirst = !ob.hasFilter();
      if (ob.hasFilter()) {
        children.span(null, ob.getFilterDesc()).code().tx(ob.getFilter());
      }
      for (UsageContext uc : ob.getUsage()) {
        if (ffirst) ffirst = false; else children.tx(",");
        if (!uc.getCode().is("http://terminology.hl7.org/CodeSystem/usage-context-type", "jurisdiction")) {
          children.tx(displayForUsage(uc.getCode()));
          children.tx("=");
        }
        CodeResolution ccr = this.cr.resolveCode(uc.getValueCodeableConcept());
        children.ah(ccr.getLink(), ccr.getHint()).tx(ccr.getDisplay());
      }
      children.tx(")");
    }
    // usage
    // filter
    // process 
  }


  public void renderTable(List<XhtmlNode> children, boolean fullDoco) throws FHIRFormatError, DefinitionException, IOException {
    boolean doco = false;
    boolean usage = false;
    boolean actor = false;
    boolean filter = false;
    boolean elementId = false;
    for (ObligationDetail binding : obligations) {
      actor = actor || binding.actorId!=null  || (binding.compare!=null && binding.compare.actorId !=null);
      doco = doco || binding.getDoco(fullDoco)!=null  || (binding.compare!=null && binding.compare.getDoco(fullDoco)!=null);
      usage = usage || !binding.usage.isEmpty() || (binding.compare!=null && !binding.compare.usage.isEmpty());
      filter = filter || binding.filter != null || (binding.compare!=null && binding.compare.filter!=null);
      elementId = elementId || !binding.elementIds.isEmpty()  || (binding.compare!=null && !binding.compare.elementIds.isEmpty());
    }

    XhtmlNode tr = new XhtmlNode(NodeType.Element, "tr");
    children.add(tr);
    tr.td().style("font-size: 11px").b().tx("Obligations");
    if (actor) {
      tr.td().style("font-size: 11px").tx("Actor");
    }
    if (elementId) {
      tr.td().style("font-size: 11px").tx("Elements");
    }
    if (usage) {
      tr.td().style("font-size: 11px").tx("Usage");
    }
    if (doco) {
      tr.td().style("font-size: 11px").tx("Documentation");
    }
    if (filter) {
      tr.td().style("font-size: 11px").tx("Filter");
    }
    for (ObligationDetail ob : obligations) {
      tr =  new XhtmlNode(NodeType.Element, "tr");
      if (ob.unchanged()) {
        tr.style(STYLE_REMOVED);
      } else if (ob.removed) {
        tr.style(STYLE_REMOVED);
      }
      children.add(tr);

      XhtmlNode code = tr.td().style("font-size: 11px");
      if (ob.compare!=null && ob.code.equals(ob.compare.code))
        code.style("font-color: darkgray");
      renderCode(code.getChildNodes(), ob.code);
      if (ob.compare!=null && ob.compare.code != null && !ob.code.equals(ob.compare.code)) {
        code.br();
        code = code.span(STYLE_UNCHANGED, null);
        renderCode(code.getChildNodes(), ob.compare.code);
      }
      if (actor) {

        ActorDefinition ad = context.getContext().fetchResource(ActorDefinition.class, ob.actorId);
        ActorDefinition compAd = null;
        if (ob.compare!=null  && ob.compare.actorId!=null) {
          compAd = context.getContext().fetchResource(ActorDefinition.class, ob.compare.actorId);
        }

        XhtmlNode actorId = tr.td().style("font-size: 11px");
        if (ob.compare!=null && ob.actorId.equals(ob.compare.actorId))
          actorId.style(STYLE_UNCHANGED);
        if (ad != null && ad.hasWebPath()) {
          actorId.ah(ad.getWebPath(), ob.actorId).tx(ad.present());
        } else if (ad != null) {
          actorId.span(null, ob.actorId).tx(ad.present());
        }

        if (ob.compare!=null && ob.compare.actorId!=null && !ob.actorId.equals(ob.compare.actorId)) {
          actorId.br();
          actorId = actorId.span(STYLE_REMOVED, null);
          if (compAd != null) {
            if (compAd.hasWebPath()) {
              actorId.ah(compAd.getWebPath(), ob.compare.actorId).tx(compAd.present());
            } else {
              actorId.span(null, ob.compare.actorId).tx(compAd.present());
            }
          }
        }
      }
      if (elementId) {
        XhtmlNode elementIds = tr.td().style("font-size: 11px");
        if (ob.compare!=null && ob.elementIds.equals(ob.compare.elementIds))
          elementIds.style(STYLE_UNCHANGED);
        for (String eid : ob.elementIds) {
          elementIds.sep(", ");
          ElementDefinition ed = profile.getSnapshot().getElementById(eid);
          if (ed != null) {
            elementIds.ah("#"+eid).tx(ed.getName());
          } else {
            elementIds.code().tx(eid);
          }
        }

        if (ob.compare!=null && !ob.compare.elementIds.isEmpty()) {
          for (String eid : ob.compare.elementIds) {
            if (!ob.elementIds.contains(eid)) {
              elementIds.sep(", ");
              elementIds.span(STYLE_REMOVED, null).code().tx(eid);
            }
          }
        }
      }
      if (usage) {
        if (ob.usage != null) {
          boolean first = true;
          XhtmlNode td = tr.td();
          for (UsageContext u : ob.usage) {
            if (first) first = false; else td.tx(", ");
            new DataRenderer(context).render(td, u);
          }
        } else {
          tr.td();          
        }
      }
      if (doco) {
        if (ob.doco != null) {
          String d = fullDoco ? md.processMarkdown("Obligation.documentation", ob.doco) : ob.docoShort;
          String oldD = ob.compare==null ? null : fullDoco ? md.processMarkdown("Binding.description.compare", ob.compare.doco) : ob.compare.docoShort;
          tr.td().style("font-size: 11px").innerHTML(compareHtml(d, oldD));
        } else {
          tr.td().style("font-size: 11px");
        }
      }

      if (filter) {
        if (ob.filter != null) {
          String d = "<code>"+ob.filter+"</code>" + (fullDoco ? md.processMarkdown("Binding.description", ob.filterDesc) : "");
          String oldD = ob.compare==null ? null : "<code>"+ob.compare.filter+"</code>" + (fullDoco ? md.processMarkdown("Binding.description", ob.compare.filterDesc) : "");
          tr.td().style("font-size: 11px").innerHTML(compareHtml(d, oldD));
        } else {
          tr.td().style("font-size: 11px");
        }
      }
    }
  }

  private XhtmlNode compareString(XhtmlNode node, String newS, String oldS) {
    if (oldS==null)
      return node.tx(newS);
    if (newS.equals(oldS))
      return node.style(STYLE_UNCHANGED).tx(newS);
    node.tx(newS);
    node.br();
    return node.span(STYLE_REMOVED,null).tx(oldS);
  }

  private String compareHtml(String newS, String oldS) {
    if (oldS==null)
      return newS;
    if (newS.equals(oldS))
      return "<span style=\"" + STYLE_UNCHANGED + "\">" + newS + "</span>";
    return newS + "<br/><span style=\"" + STYLE_REMOVED + "\">" + oldS + "</span>";
  }

  private void renderCode(XhtmlNodeList children, String codeExpr) {
    if (codeExpr != null) {
      boolean first = true;
      String[] codes = codeExpr.split("\\+");
      for (String code : codes) {
        if (first) first = false; else children.tx(" & ");
        int i = code.indexOf(":");
        if (i > -1) {
          String c = code.substring(0, i);
          code = code.substring(i+1);
          children.b().tx(c.toUpperCase());
          children.tx(":");
        }
        CodeResolution cr = this.cr.resolveCode("http://hl7.org/fhir/tools/CodeSystem/obligation", code);
        code = code.replace("will-", "").replace("can-", "");
        if (cr.getLink() != null) {
          children.ah(cr.getLink(), cr.getHint()).tx(code);          
        } else {
          children.span(null, cr.getHint()).tx(code);
        }
      }
    } else {
      children.span(null, "No Obligation Code?").tx("??");
    }
  }

  public boolean hasObligations() {
    return !obligations.isEmpty();
  }

  private String displayForUsage(Coding c) {
    if (c.hasDisplay()) {
      return c.getDisplay();
    }
    if ("http://terminology.hl7.org/CodeSystem/usage-context-type".equals(c.getSystem())) {
      return c.getCode();
    }
    return c.getCode();
  }

}
