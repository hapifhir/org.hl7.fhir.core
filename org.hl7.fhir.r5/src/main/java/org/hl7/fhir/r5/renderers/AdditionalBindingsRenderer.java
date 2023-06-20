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
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.CodeResolver.CodeResolution;
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

public class AdditionalBindingsRenderer {
  public class AdditionalBindingDetail {
    private String purpose;
    private String valueSet;
    private String doco;
    private String docoShort;
    private UsageContext usage;
    private boolean any = false;
    private boolean isUnchanged = false;
    private boolean matched = false;
    private boolean removed = false;
    private ValueSet vs;
    
    private AdditionalBindingDetail compare;
    private int count = 1;
    private String getKey() {
      // Todo: Consider extending this with content from usageContext if purpose isn't sufficiently differentiating
      return purpose + Integer.toString(count);
    }
    private void incrementCount() {
      count++;
    }
    private void setCompare(AdditionalBindingDetail match) {
      compare = match;
      match.matched = true;
    }
    private boolean alreadyMatched() {
      return matched;
    }
    public String getDoco(boolean full) {
      return full ? doco : docoShort;
    }
    public boolean unchanged() {
      if (!isUnchanged)
        return false;
      if (compare==null)
        return true;
      isUnchanged = true;
      isUnchanged = isUnchanged && ((purpose==null && compare.purpose==null) || purpose.equals(compare.purpose));
      isUnchanged = isUnchanged && ((valueSet==null && compare.valueSet==null) || valueSet.equals(compare.valueSet));
      isUnchanged = isUnchanged && ((doco==null && compare.doco==null) || doco.equals(compare.doco));
      isUnchanged = isUnchanged && ((docoShort==null && compare.docoShort==null) || docoShort.equals(compare.docoShort));
      isUnchanged = isUnchanged && ((usage==null && compare.usage==null) || usage.equals(compare.usage));
      return isUnchanged;
    }
  }

  private static String STYLE_UNCHANGED = "opacity: 0.5;";
  private static String STYLE_REMOVED = STYLE_UNCHANGED + "text-decoration: line-through;";

  private List<AdditionalBindingDetail> bindings = new ArrayList<>();
  private ProfileKnowledgeProvider pkp;
  private String corePath;
  private StructureDefinition profile;
  private String path;
  private RenderingContext context;
  private IMarkdownProcessor md;
  private CodeResolver cr;

  public AdditionalBindingsRenderer(ProfileKnowledgeProvider pkp, String corePath, StructureDefinition profile, String path, RenderingContext context, IMarkdownProcessor md, CodeResolver cr) {
    this.pkp = pkp;
    this.corePath = corePath;
    this.profile = profile;
    this.path = path;
    this.context = context;
    this.md = md;
    this.cr = cr;
  }

  public void seeMaxBinding(Extension ext) {
    seeMaxBinding(ext, null, false);
  }

  public void seeMaxBinding(Extension ext, Extension compExt, boolean compare) {
    seeBinding(ext, compExt, compare, "maximum");
  }

  protected void seeBinding(Extension ext, Extension compExt, boolean compare, String label) {
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  label;
    abr.valueSet =  ext.getValue().primitiveValue();
    if (compare) {
      abr.isUnchanged = compExt!=null && ext.getValue().primitiveValue().equals(compExt.getValue().primitiveValue());

      abr.compare = new AdditionalBindingDetail();
      abr.compare.valueSet = compExt==null ? null : compExt.getValue().primitiveValue();
    } else {
      abr.isUnchanged = ext.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS);
    }
    bindings.add(abr);
  }

  public void seeMinBinding(Extension ext) {
    seeMinBinding(ext, null, false);
  }

  public void seeMinBinding(Extension ext, Extension compExt, boolean compare) {
    seeBinding(ext, compExt, compare, "minimum");
  }

  public void seeAdditionalBindings(List<Extension> list) {
    seeAdditionalBindings(list, null, false);
  }

  public void seeAdditionalBindings(List<Extension> list, List<Extension> compList, boolean compare) {
    HashMap<String, AdditionalBindingDetail> compBindings = new HashMap<String, AdditionalBindingDetail>();
    if (compare && compList!=null) {
      for (Extension ext : compList) {
        AdditionalBindingDetail abr = additionalBinding(ext);
        if (compBindings.containsKey(abr.getKey())) {
          abr.incrementCount();
        }
        compBindings.put(abr.getKey(), abr);
      }
    }

    for (Extension ext : list) {
      AdditionalBindingDetail abr = additionalBinding(ext);
      if (compare && compList!=null) {
        AdditionalBindingDetail match = null;
        do {
          match = compBindings.get(abr.getKey());
          if (abr.alreadyMatched())
            abr.incrementCount();
        } while (match!=null && abr.alreadyMatched());
        if (match!=null)
          abr.setCompare(match);
        bindings.add(abr);
        if (abr.compare!=null)
          compBindings.remove(abr.compare.getKey());
      } else
        bindings.add(abr);
    }
    for (AdditionalBindingDetail b: compBindings.values()) {
      b.removed = true;
      bindings.add(b);
    }
  }

  protected AdditionalBindingDetail additionalBinding(Extension ext) {
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  ext.getExtensionString("purpose");
    abr.valueSet =  ext.getExtensionString("valueSet");
    abr.doco =  ext.getExtensionString("documentation");
      abr.docoShort =  ext.getExtensionString("shortDoco");
    abr.usage =  (ext.hasExtension("usage")) && ext.getExtensionByUrl("usage").hasValueUsageContext() ? ext.getExtensionByUrl("usage").getValueUsageContext() : null;
    abr.any = "any".equals(ext.getExtensionString("scope"));
    abr.isUnchanged = ext.hasUserData(ProfileUtilities.UD_DERIVATION_EQUALS);
    return abr;
  }

  public String render() throws IOException {
    if (bindings.isEmpty()) {
      return "";
    } else {
      XhtmlNode tbl = new XhtmlNode(NodeType.Element, "table");
      tbl.attribute("class", "grid");
      render(tbl.getChildNodes(), true);
      return new XhtmlComposer(false).compose(tbl);
    }
  }

  public void render(HierarchicalTableGenerator gen, Cell c) throws FHIRFormatError, DefinitionException, IOException {
    if (bindings.isEmpty()) {
      return;
    } else {
      Piece piece = gen.new Piece("table").attr("class", "grid");
      c.getPieces().add(piece);
      render(piece.getChildren(), false);
    }
  }
  
  public void render(List<XhtmlNode> children, boolean fullDoco) throws FHIRFormatError, DefinitionException, IOException {
    boolean doco = false;
    boolean usage = false;
    boolean any = false;
    for (AdditionalBindingDetail binding : bindings) {
      doco = doco || binding.getDoco(fullDoco)!=null  || (binding.compare!=null && binding.compare.getDoco(fullDoco)!=null);
      usage = usage || binding.usage != null || (binding.compare!=null && binding.compare.usage!=null);
      any = any || binding.any || (binding.compare!=null && binding.compare.any);
    }

    XhtmlNode tr = new XhtmlNode(NodeType.Element, "tr");
    children.add(tr);
    tr.td().style("font-size: 11px").b().tx("Additional Bindings");
    tr.td().style("font-size: 11px").tx("Purpose");
    if (usage) {
      tr.td().style("font-size: 11px").tx("Usage");
    }
    if (any) {
      tr.td().style("font-size: 11px").tx("Any");
    }
    if (doco) {
      tr.td().style("font-size: 11px").tx("Documentation");
    }
    for (AdditionalBindingDetail binding : bindings) {
      tr =  new XhtmlNode(NodeType.Element, "tr");
      if (binding.unchanged()) {
        tr.style(STYLE_REMOVED);
      } else if (binding.removed) {
        tr.style(STYLE_REMOVED);
      }
      children.add(tr);
      BindingResolution br = pkp == null ? makeNullBr(binding) : pkp.resolveBinding(profile, binding.valueSet, path);
      BindingResolution compBr = null;
      if (binding.compare!=null  && binding.compare.valueSet!=null)
        compBr = pkp == null ? makeNullBr(binding.compare) : pkp.resolveBinding(profile, binding.compare.valueSet, path);

      XhtmlNode valueset = tr.td().style("font-size: 11px");
      if (binding.compare!=null && binding.valueSet.equals(binding.compare.valueSet))
        valueset.style(STYLE_UNCHANGED);
      if (br.url != null) {
        valueset.ah(determineUrl(br.url), binding.valueSet).tx(br.display);
      } else {
        valueset.span(null, binding.valueSet).tx(br.display);
      }
      if (binding.compare!=null && binding.compare.valueSet!=null && !binding.valueSet.equals(binding.compare.valueSet)) {
        valueset.br();
        valueset = valueset.span(STYLE_REMOVED, null);
        if (compBr.url != null) {
          valueset.ah(determineUrl(compBr.url), binding.compare.valueSet).tx(compBr.display);
        } else {
          valueset.span(null, binding.compare.valueSet).tx(compBr.display);
        }
      }

      XhtmlNode purpose = tr.td().style("font-size: 11px");
      if (binding.compare!=null && binding.purpose.equals(binding.compare.purpose))
        purpose.style("font-color: darkgray");
      renderPurpose(purpose, binding.purpose);
      if (binding.compare!=null && binding.compare.purpose!=null && !binding.purpose.equals(binding.compare.purpose)) {
        purpose.br();
        purpose = purpose.span(STYLE_UNCHANGED, null);
        renderPurpose(purpose, binding.compare.purpose);
      }
      if (usage) {
        if (binding.usage != null) {
          // TODO: This isn't rendered at all yet.  Ideally, we want it to render with comparison...
          new DataRenderer(context).render(tr.td(), binding.usage);
        } else {
          tr.td();          
        }
      }
      if (any) {
        String newRepeat = binding.any ? "Any repeats" : "All repeats";
        String oldRepeat = binding.compare!=null && binding.compare.any ? "Any repeats" : "All repeats";
        compareString(tr.td().style("font-size: 11px"), newRepeat, oldRepeat);
      }
      if (doco) {
        if (binding.doco != null) {
          String d = fullDoco ? md.processMarkdown("Binding.description", binding.doco) : binding.docoShort;
          String oldD = binding.compare==null ? null : fullDoco ? md.processMarkdown("Binding.description.compare", binding.compare.doco) : binding.compare.docoShort;
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

  private String determineUrl(String url) {
    return Utilities.isAbsoluteUrl(url) || !pkp.prependLinks() ? url : corePath + url;
  }

  private void renderPurpose(XhtmlNode td, String purpose) {
    boolean r5 = context == null || context.getWorker() == null ? false : VersionUtilities.isR5Plus(context.getWorker().getVersion());
    switch (purpose) {
    case "maximum": 
      td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-maximum" : corePath+"extension-elementdefinition-maxvalueset.html", "A required binding, for use when the binding strength is 'extensible' or 'preferred'").tx("Max Binding");
      break;
    case "minimum": 
      td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-minimum" : corePath+"extension-elementdefinition-minvalueset.html", "The minimum allowable value set - any conformant system SHALL support all these codes").tx("Min Binding");
      break;
    case "required" :
      td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-required" : corePath+"terminologies.html#strength", "Validators will check this binding (strength = required)").tx("Required Binding");
      break;
    case "extensible" :
      td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-extensible" : corePath+"terminologies.html#strength", "Validators will check this binding (strength = extensible)").tx("Extensible Binding");
      break;
    case "current" :
      if (r5) {
        td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-current" : corePath+"terminologies.html#strength", "New records are required to use this value set, but legacy records may use other codes").tx("Current Binding");
      } else {
        td.span(null, "New records are required to use this value set, but legacy records may use other codes").tx("Required");
      }
      break;
    case "preferred" :
      if (r5) {
        td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-preferred" : corePath+"terminologies.html#strength", "This is the value set that is recommended (documentation should explain why)").tx("Preferred Binding");
      } else {
        td.span(null, "This is the value set that is recommended (documentation should explain why)").tx("Recommended");
      }
      break;
    case "ui" :
      if (r5) {
        td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-ui" : corePath+"terminologies.html#strength", "This value set is provided to user look up in a given context").tx("UI Binding");
      } else {
        td.span(null, "This value set is provided to user look up in a given context").tx("UI");        
      }
      break;
    case "starter" :
      if (r5) {
        td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-starter" : corePath+"terminologies.html#strength", "This value set is a good set of codes to start with when designing your system").tx("Starter Set");
      } else {
        td.span(null, "This value set is a good set of codes to start with when designing your system").tx("Starter");        
      }
      break;
    case "component" :
      if (r5) {
        td.ah(r5 ? corePath+"valueset-additional-binding-purpose.html#additional-binding-purpose-component" : corePath+"terminologies.html#strength", "This value set is a component of the base value set").tx("Component");
      } else {
        td.span(null, "This value set is a component of the base value set").tx("Component");        
      }
      break;
    default:  
      td.span(null, "Unknown code for purpose").tx(purpose);
    }
  }

  private BindingResolution makeNullBr(AdditionalBindingDetail binding) {
    BindingResolution br = new BindingResolution();
    br.url = "http://none.none/none";
    br.display = "todo";
    return br;
  }

  public boolean hasBindings() {
    return !bindings.isEmpty();
  }

  public void render(XhtmlNodeList children, List<ElementDefinitionBindingAdditionalComponent> list) {
    if (list.size() == 1) {
      render(children, list.get(0));
    } else {
      XhtmlNode ul = children.ul();
      for (ElementDefinitionBindingAdditionalComponent b : list) {
        render(ul.li().getChildNodes(), b);
      }
    }
  }

  private void render(XhtmlNodeList children, ElementDefinitionBindingAdditionalComponent b) {
    if (b.getValueSet() == null) {
      return; // what should happen?
    }
    BindingResolution br = pkp.resolveBinding(profile, b.getValueSet(), corePath);
    XhtmlNode a = children.ahOrCode(br.url == null ? null : Utilities.isAbsoluteUrl(br.url) || !context.getPkp().prependLinks() ? br.url : corePath+br.url, b.hasDocumentation() ? b.getDocumentation() : null);
    if (b.hasDocumentation()) {
      a.attribute("title", b.getDocumentation());
    } 
    a.tx(br.display);

    if (b.hasShortDoco()) {
      children.tx(": ");
      children.tx(b.getShortDoco());
    } 
    if (b.getAny() || b.hasUsage()) {
      children.tx(" (");
      boolean ffirst = !b.getAny();
      if (b.getAny()) {
        children.tx("any repeat");
      }
      for (UsageContext uc : b.getUsage()) {
        if (ffirst) ffirst = false; else children.tx(",");
        if (!uc.getCode().is("http://terminology.hl7.org/CodeSystem/usage-context-type", "jurisdiction")) {
          children.tx(displayForUsage(uc.getCode()));
          children.tx("=");
        }
        CodeResolution ccr = cr.resolveCode(uc.getValueCodeableConcept());
        children.ah(ccr.getLink(), ccr.getHint()).tx(ccr.getDisplay());
      }
      children.tx(")");
    }
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

  public void seeAdditionalBinding(String purpose, String doco, ValueSet valueSet) {
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  purpose;
    abr.valueSet =  valueSet.getUrl();
    abr.vs = valueSet;
    bindings.add(abr);
  }

  public void seeAdditionalBinding(String purpose, String doco, String ref) {
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  purpose;
    abr.valueSet =  ref;
    bindings.add(abr);
    
  }

}
