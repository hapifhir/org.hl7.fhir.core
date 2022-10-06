package org.hl7.fhir.r5.conformance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.conformance.AdditionalBindingsRenderer.AdditionalBindingDetail;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider;
import org.hl7.fhir.r5.conformance.ProfileUtilities.ProfileKnowledgeProvider.BindingResolution;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UsageContext;
import org.hl7.fhir.r5.renderers.DataRenderer;
import org.hl7.fhir.r5.renderers.IMarkdownProcessor;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.utils.PublicationHacker;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingComponent;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class AdditionalBindingsRenderer {
  public class AdditionalBindingDetail {
    private String purpose;
    private String valueSet;
    private String doco;
    private String docoShort;
    private UsageContext usage;
    private boolean any;
    private boolean unchanged;
  }

  private List<AdditionalBindingDetail> bindings = new ArrayList<>();
  private ProfileKnowledgeProvider pkp;
  private String corePath;
  private StructureDefinition profile;
  private String path;
  private RenderingContext context;
  private IMarkdownProcessor md;

  public AdditionalBindingsRenderer(ProfileKnowledgeProvider pkp, String corePath, StructureDefinition profile, String path, RenderingContext context, IMarkdownProcessor md) {
    this.pkp = pkp;
    this.corePath = corePath;
    this.profile = profile;
    this.path = path;
    this.context = context;
    this.md = md;
  }

  public void seeMaxBinding(Extension ext) {    
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  "maximum";
    abr.valueSet =  ext.getValue().primitiveValue();
    abr.unchanged = ext.hasUserData(ProfileUtilities.DERIVATION_EQUALS);
    bindings.add(abr);    
  }

  public void seeMinBinding(Extension ext) {
    AdditionalBindingDetail abr = new AdditionalBindingDetail();
    abr.purpose =  "minimum";
    abr.valueSet =  ext.getValue().primitiveValue();
    abr.unchanged = ext.hasUserData(ProfileUtilities.DERIVATION_EQUALS);
    bindings.add(abr);    
  }

  public void seeAdditionalBindings(List<Extension> list) {
    for (Extension ext : list) {
      AdditionalBindingDetail abr = new AdditionalBindingDetail();
      abr.purpose =  ext.getExtensionString("purpose");
      abr.valueSet =  ext.getExtensionString("valueSet");
      abr.doco =  ext.getExtensionString("documentation");
      abr.docoShort =  ext.getExtensionString("shortDoco");
      abr.usage =  (ext.hasExtension("usage")) && ext.getExtensionByUrl("usage").hasValueUsageContext() ? ext.getExtensionByUrl("usage").getValueUsageContext() : null;
      abr.any = "any".equals(ext.getExtensionString("scope"));
      abr.unchanged = ext.hasUserData(ProfileUtilities.DERIVATION_EQUALS);
      bindings.add(abr);
    }
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
      doco = doco || (fullDoco && binding.doco != null) || (!fullDoco && binding.docoShort != null) ;
      usage = usage || binding.usage != null;
      any = any || binding.any;
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
      if (binding.unchanged) {
        tr.style("opacity: 0.5");
      }
      children.add(tr);
      BindingResolution br = pkp == null ? makeNullBr(binding) : pkp.resolveBinding(profile, binding.valueSet, path);

      if (br.url != null) {
        tr.td().style("font-size: 11px").ah(Utilities.isAbsoluteUrl(br.url) || !pkp.prependLinks() ? br.url : corePath+br.url, binding.valueSet).tx(br.display);
      } else {
        tr.td().style("font-size: 11px").span(null, binding.valueSet).tx(br.display);        
      }
      renderPurpose(tr.td().style("font-size: 11px"), binding.purpose);
      if (usage) {
        if (binding.usage != null) {
          new DataRenderer(context).render(tr.td(), binding.usage);
        } else {
          tr.td();          
        }
      }
      if (any) {
        if (binding.any) {
          tr.td().style("font-size: 11px").tx("Any repeat");
        } else {
          tr.td().style("font-size: 11px").tx("All repeats");
        }
      }
      if (doco) {
        String ds = fullDoco ? binding.doco : binding.docoShort;
        if (ds != null) {
          String d = fullDoco ? md.processMarkdown("Binding.description", ds) : ds;          
          tr.td().style("font-size: 11px").innerHTML(d);
        } else {
          tr.td().style("font-size: 11px");
        }
      }
    }
  }

  private void renderPurpose(XhtmlNode td, String purpose) {
    switch (purpose) {
    case "maximum": 
      td.ah(corePath+"extension-elementdefinition-maxvalueset.html", "A required binding, for use when the binding strength is 'extensible' or 'preferred'").tx("Max Binding");
      break;
    case "minimum": 
      td.ah(corePath+"extension-elementdefinition-minvalueset.html", "The minimum allowable value set - any conformant system SHALL support all these codes").tx("Min Binding");
      break;
    case "conformance" :
      td.ah(corePath+"terminologies.html#strength", "Validators will check this binding (strength = required)").tx("Validation Binding");
      break;
    case "candidate" :
      td.ah(corePath+"terminologies.html#strength", "This is a candidate binding that constraints on this profile may consider (see doco)").tx("Candidate Validation Binding");
      break;
    case "current" :
      td.span(null, "New records are required to use this value set, but legacy records may use other codes").tx("Required");
      break;
    case "recommended" :
      td.span(null, "This is the value set that is recommended (documentation should explain why)").tx("Recommended");
      break;
    case "ui" :
      td.span(null, "This value set is provided to user look up in a given context").tx("UI");
      break;
    case "starter" :
      td.span(null, "This value set is a good set of codes to start with when designing your system").tx("Starter");
      break;
    case "component" :
      td.span(null, "This value set is a component of the base value set").tx("Component");
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


}
