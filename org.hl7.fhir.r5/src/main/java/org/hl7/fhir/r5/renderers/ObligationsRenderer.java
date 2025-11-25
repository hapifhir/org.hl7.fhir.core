package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.renderers.CodeResolver.CodeResolution;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;

import org.hl7.fhir.r5.utils.UserDataNames;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlNodeList;

@MarkedToMoveToAdjunctPackage
public class ObligationsRenderer extends Renderer {
  public static class ObligationDetail {
    private List<String> codes = new ArrayList<>();
    private List<String> elementIds = new ArrayList<>();
    private List<CanonicalType> actors = new ArrayList<>();
    private String doco;
    private String docoShort;
    private String filter;
    private String filterDoco;
    private List<UsageContext> usage = new ArrayList<>();
    private boolean isUnchanged = false;
    private boolean matched = false;
    private boolean removed = false;
    private String source;
//    private ValueSet vs;
    
    private ObligationDetail compare;
    private int count = 1;
    
    public ObligationDetail(Extension ext) {
      for (Extension e: ext.getExtensionsByUrl("code")) {
        codes.add(e.getValueStringType().toString());
      }
      for (Extension e: ext.getExtensionsByUrl("actor")) {
        actors.add(e.getValueCanonicalType());
      }
      this.doco = ext.getExtensionString("documentation");
      this.docoShort =  ext.getExtensionString("shortDoco");
      this.filter =  ext.getExtensionString("filter");
      this.filterDoco =  ext.getExtensionString("filterDocumentation");
      if (this.filterDoco == null) {
        this.filterDoco =  ext.getExtensionString("filter-desc");
      }
      for (Extension usage : ext.getExtensionsByUrl("usage")) {
        this.usage.add(usage.getValueUsageContext());
      }
      for (Extension eid : ext.getExtensionsByUrl("elementId")) {
        this.elementIds.add(eid.getValue().primitiveValue());
      }
      this.isUnchanged = ext.hasUserData(UserDataNames.SNAPSHOT_DERIVATION_EQUALS);
      if (ext.hasExtension(ExtensionDefinitions.EXT_OBLIGATION_SOURCE, ExtensionDefinitions.EXT_OBLIGATION_SOURCE_SHORT)) {
        this.source = ext.getExtensionString(ExtensionDefinitions.EXT_OBLIGATION_SOURCE, ExtensionDefinitions.EXT_OBLIGATION_SOURCE_SHORT);
      } else if (ext.hasUserData(UserDataNames.SNAPSHOT_EXTENSION_SOURCE)) {
        this.source = ((StructureDefinition) ext.getUserData(UserDataNames.SNAPSHOT_EXTENSION_SOURCE)).getVersionedUrl();        
      }      
    }
    
    private String getKey() {
      // Todo: Consider extending this with content from usageContext if purpose isn't sufficiently differentiating
      return String.join(",", codes) + Integer.toString(count);
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
    public String getCodes() {
      return String.join(",", codes);
    }
    public List<String> getCodeList() {
      return new ArrayList<String>(codes);
    }
    public boolean unchanged() {
      if (!isUnchanged)
        return false;
      if (compare==null)
        return true;
      isUnchanged = true;
      isUnchanged = isUnchanged && ((codes.isEmpty() && compare.codes.isEmpty()) || codes.equals(compare.codes));
      isUnchanged = elementIds.equals(compare.elementIds);
      isUnchanged = isUnchanged && ((actors.isEmpty() && compare.actors.isEmpty()) || actors.equals(compare.actors));
      isUnchanged = isUnchanged && ((doco==null && compare.doco==null) || doco.equals(compare.doco));
      isUnchanged = isUnchanged && ((docoShort==null && compare.docoShort==null) || docoShort.equals(compare.docoShort));
      isUnchanged = isUnchanged && ((filter==null && compare.filter==null) || filter.equals(compare.filter));
      isUnchanged = isUnchanged && ((filterDoco==null && compare.filterDoco==null) || filterDoco.equals(compare.filterDoco));
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
      return filterDoco;
    }

    public String getFilter() {
      return filter;
    }

    public List<UsageContext> getUsage() {
      return usage;
    }

    public boolean hasActors() {
      return !actors.isEmpty();
    }

    public boolean hasActor(String id) {
      for (CanonicalType actor: actors) {
        if (actor.getValue().equals(id))
          return true;
      }
      return false;
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
  private boolean canDoNoList;

  public ObligationsRenderer(String corePath, StructureDefinition profile, String path, RenderingContext context, IMarkdownProcessor md, CodeResolver cr, boolean canDoNoList) {
    super(context);
    this.corePath = corePath;
    this.profile = profile;
    this.path = path;
    this.context = context;
    this.md = md;
    this.cr = cr;
    this.canDoNoList = canDoNoList;
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
          addObligation(obd);
          if (obd.compare!=null)
            compBindings.remove(obd.compare.getKey());
        } else {
          addObligation(obd);
        }
      }
    }
    for (ObligationDetail b: compBindings.values()) {
      b.removed = true;
      addObligation(b);
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
            addObligation(obd);
            if (obd.compare!=null)
              compBindings.remove(obd.compare.getKey());
          } else {
            addObligation(obd);
          }
        }
      }
    }
    for (ObligationDetail b: compBindings.values()) {
      b.removed = true;
      addObligation(b);
    }
  }


  private void addObligation(ObligationDetail obd) {
    boolean add = context.getActorWhiteList().isEmpty();
    if (!add) {
      for (CanonicalType a : obd.actors) { 
        ActorDefinition ad = context.getContext().fetchResource(ActorDefinition.class, a.getValue());
        add = add || (context.getActorWhiteList().contains(ad));
      }
    }
    if (add) {
      obligations.add(obd);
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

  public String render(RenderingStatus status, ResourceWrapper res, String defPath, String anchorPrefix, List<ElementDefinition> inScopeElements) throws IOException {
    if (obligations.isEmpty()) {
      return "";
    } else {
      XhtmlNode tbl = new XhtmlNode(NodeType.Element, "table");
      tbl.attribute("class", "grid");
      renderTable(status, res, tbl.getChildNodes(), true, defPath, anchorPrefix, inScopeElements);
      return new XhtmlComposer(false).compose(tbl);
    }
  }

  public void renderTable(RenderingStatus status, ResourceWrapper res, HierarchicalTableGenerator gen, Cell c, List<ElementDefinition> inScopeElements) throws FHIRFormatError, DefinitionException, IOException {
    if (obligations.isEmpty()) {
      return;
    } else {
      Piece piece = gen.new Piece("obligation", "table").setClass("grid");
      c.getPieces().add(piece);
      renderTable(status, res, piece.getChildren(), false, gen.getDefPath(), gen.getUniqueLocalPrefix(), inScopeElements);
    }
  }

  public void renderList(HierarchicalTableGenerator gen, Cell c) throws FHIRFormatError, DefinitionException, IOException {
    if (obligations.size() > 0) {
      Piece p = gen.new Piece(null);
      c.addPiece(p);
      if (obligations.size() == 1 && canDoNoList) {
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
    renderCodes(children, ob.getCodeList());
    if (ob.hasFilter() || ob.hasUsage() || !ob.elementIds.isEmpty()) {
      children.tx(" (");
      boolean ffirst = !ob.hasFilter();
      boolean firstEid = true;

      for (String eid: ob.elementIds) {
        if (firstEid) {
          children.span().i().tx("Elements: ");
          firstEid = false;
        } else
          children.tx(", ");
        String trimmedElement = eid.substring(eid.indexOf(".")+ 1);
        children.tx(trimmedElement);
      }
      if (ob.hasFilter()) {
        children.span(null, ob.getFilterDesc()).code().tx(ob.getFilter());
      }
      for (UsageContext uc : ob.getUsage()) {
        if (ffirst) ffirst = false; else children.tx(",");
        if (!uc.getCode().is("http://terminology.hl7.org/CodeSystem/usage-context-type", "jurisdiction")) {
          children.tx(displayForUsage(uc.getCode()));
          children.tx("=");
        }
        CodeResolution ccr = this.cr.resolveCode(uc.getValueCodeableConcept(), profile);
        children.ah(context.prefixLocalHref(ccr.getLink()), ccr.getHint()).tx(ccr.getDisplay());
      }
      children.tx(")");
    }
    if (ob.source != null && !ob.source.equals(profile.getVersionedUrl())) {
      children.tx(" ");
      StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, ob.source);
      String link = sd != null ? sd.getWebPath() : ob.source;
      String title = context.formatPhrase(RenderingContext.OBLIGATION_SOURCE, sd == null ? ob.source : sd.present()); 
      children.ah(link, title).attribute("data-no-external", "true").img("external.png", "source-link");
    }
    // usage
    // filter
    // process 
  }


  public void renderTable(RenderingStatus status, ResourceWrapper res, List<XhtmlNode> children, boolean fullDoco, String defPath, String anchorPrefix, List<ElementDefinition> inScopeElements) throws FHIRFormatError, DefinitionException, IOException {
    boolean hasDoco = false;
    boolean hasUsage = false;
    boolean hasActor = false;
    boolean hasFilter = false;
    boolean hasElementId = false;
    boolean hasSource = false;
    for (ObligationDetail ob : obligations) {
      hasActor = hasActor || !ob.actors.isEmpty()  || (ob.compare!=null && !ob.compare.actors.isEmpty());
      hasDoco = hasDoco || ob.getDoco(fullDoco)!=null  || (ob.compare!=null && ob.compare.getDoco(fullDoco)!=null);
      hasUsage = hasUsage || !ob.usage.isEmpty() || (ob.compare!=null && !ob.compare.usage.isEmpty());
      hasFilter = hasFilter || ob.filter != null || (ob.compare!=null && ob.compare.filter!=null);
      hasElementId = hasElementId || !ob.elementIds.isEmpty()  || (ob.compare!=null && !ob.compare.elementIds.isEmpty());
      hasSource = hasSource || ((ob.source != null || (ob.compare!=null && ob.compare.source!=null)) && !ob.source.equals(profile.getVersionedUrl()));
    }

    List<String> inScopePaths = new ArrayList<>();
    for (ElementDefinition e: inScopeElements) {
      inScopePaths.add(e.getPath());
    }

    XhtmlNode tr = new XhtmlNode(NodeType.Element, "tr");
    children.add(tr);
    tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.GENERAL_OBLIG));
    if (hasActor) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.OBLIG_ACT));
    }
    if (hasElementId) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.OBLIG_ELE));
    }
    if (hasUsage) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.GENERAL_USAGE));
    }
    if (hasDoco) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.GENERAL_DOCUMENTATION));
    }
    if (hasFilter) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.GENERAL_FILTER));
    }
    if (hasSource) {
      tr.td().style("font-size: 11px").b().tx(context.formatPhrase(RenderingContext.GENERAL_SOURCE));
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
      if (ob.compare!=null && ob.getCodes().equals(ob.compare.getCodes()))
        code.style("font-color: darkgray");
        renderCodes(code.getChildNodes(), ob.getCodeList());
      if (ob.compare!=null && !ob.compare.getCodeList().isEmpty() && !ob.getCodes().equals(ob.compare.getCodes())) {
        code.br();
        code = code.span(STYLE_UNCHANGED, null);
        renderCodes(code.getChildNodes(), ob.compare.getCodeList());
      }

      XhtmlNode actorId = tr.td().style("font-size: 11px");
      if (!ob.actors.isEmpty() ||  ob.compare == null || ob.compare.actors.isEmpty()) {
        boolean firstActor = true;
        for (CanonicalType anActor : ob.actors) {
          ActorDefinition ad = context.getContext().fetchResource(ActorDefinition.class, anActor.getCanonical());
          boolean existingActor = ob.compare != null && ob.compare.actors.contains(anActor);

          if (!firstActor) {
            actorId.br();
            firstActor = false;
          }

          if (!existingActor)
            actorId.style(STYLE_UNCHANGED);
          if (ad == null) {
            actorId.addText(anActor.getCanonical());
          } else {
            actorId.ah(ad.getWebPath()).tx(ad.present());
          }
        }

        if (ob.compare != null) {
          for (CanonicalType compActor : ob.compare.actors) {
            if (!ob.actors.contains(compActor)) {
              ActorDefinition compAd = context.getContext().fetchResource(ActorDefinition.class, compActor.toString());
              if (!firstActor) {
                actorId.br();
                firstActor = true;
              }
              actorId = actorId.span(STYLE_REMOVED, null);
              if (compAd == null) {
                actorId.ah(context.prefixLocalHref(compActor.toString()), compActor.toString()).tx(compActor.toString());
              } else if (compAd.hasWebPath()) {
                actorId.ah(context.prefixLocalHref(compAd.getWebPath()), compActor.toString()).tx(compAd.present());
              } else {
                actorId.span(null, compActor.toString()).tx(compAd.present());
              }
            }
          }
        }
      }


      if (hasElementId) {
        XhtmlNode elementIds = tr.td().style("font-size: 11px");
        if (ob.compare!=null && ob.elementIds.equals(ob.compare.elementIds))
          elementIds.style(STYLE_UNCHANGED);
        for (String eid : ob.elementIds) {
          elementIds.sep(", ");
          ElementDefinition ed = profile.getSnapshot().getElementById(eid);
          if (ed != null) {
            boolean inScope = inScopePaths.contains(ed.getPath());
            String name = eid.substring(eid.indexOf(".") + 1);
            if (ed != null && inScope) {
              String link = defPath + "#" + anchorPrefix + eid;
              elementIds.ah(context.prefixLocalHref(link)).tx(name);
            } else {
              elementIds.code().tx(name);
            }
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
      if (hasUsage) {
        if (ob.usage != null) {
          boolean first = true;
          XhtmlNode td = tr.td();
          for (UsageContext u : ob.usage) {
            if (first) first = false; else td.tx(", ");
            new DataRenderer(context).renderDataType(status, td, wrapWC(res, u));
          }
        } else {
          tr.td();          
        }
      }
      if (hasDoco) {
        if (ob.doco != null) {
          String d = fullDoco ? md.processMarkdown("Obligation.documentation", ob.doco) : ob.docoShort;
          String oldD = ob.compare==null ? null : fullDoco ? md.processMarkdown("Binding.description.compare", ob.compare.doco) : ob.compare.docoShort;
          tr.td().style("font-size: 11px").innerHTML(compareHtml(d, oldD));
        } else {
          tr.td().style("font-size: 11px");
        }
      }

      if (hasFilter) {
        if (ob.filter != null) {
          String d = "<code>"+ob.filter+"</code>" + (fullDoco ? md.processMarkdown("Binding.description", ob.filterDoco) : "");
          String oldD = ob.compare==null ? null : "<code>"+ob.compare.filter+"</code>" + (fullDoco ? md.processMarkdown("Binding.description", ob.compare.filterDoco) : "");
          tr.td().style("font-size: 11px").innerHTML(compareHtml(d, oldD));
        } else {
          tr.td().style("font-size: 11px");
        }
      }
      if (hasSource) {
        if (ob.source != null && !ob.source.equals(profile.getVersionedUrl())) {
          StructureDefinition sd = context.getContext().fetchResource(StructureDefinition.class, ob.source);
          var td = tr.td().style("font-size: 11px");
          td.tx("from ");
          if (sd != null) {
            td.ah(sd.getWebPath()).tx(sd.present());
          } else {
            td.code().tx(ob.source);            
          }
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

  private void renderCodes(XhtmlNodeList children, List<String> codes) {

    if (!codes.isEmpty()) {
      boolean first = true;
      for (String code : codes) {
        if (first) first = false; else children.tx(" & ");
        int i = code.indexOf(":");
        if (i > -1) {
          String c = code.substring(0, i);
          code = code.substring(i+1);
          children.b().tx(c.toUpperCase());
          children.tx(":");
        }
        CodeResolution cr = this.cr.resolveCode("http://hl7.org/fhir/CodeSystem/obligation", code, profile);
        if (cr == null) {
          cr = this.cr.resolveCode("http://hl7.org/fhir/tools/CodeSystem/obligation", code, profile);
        }
        code = code.replace("will-", "").replace("can-", "");
        if (cr.getLink() != null) {
          children.ah(context.prefixLocalHref(cr.getLink()), cr.getHint()).tx(code);
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
