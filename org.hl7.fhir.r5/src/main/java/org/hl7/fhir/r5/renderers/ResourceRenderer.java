package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.ResourceWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.ElementWrappers.ResourceWrapperMetaElement;
import org.hl7.fhir.r5.renderers.ResourceRenderer.RendererType;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class ResourceRenderer extends DataRenderer {

  public enum RendererType {
    NATIVE, PROFILE, LIQUID

  }

  protected ResourceContext rcontext;
  protected XVerExtensionManager xverManager;
  protected boolean forResource;
  
  
  public ResourceRenderer(RenderingContext context) {
    super(context);
  }

  public ResourceRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context);
    this.rcontext = rcontext;
  }

  public ResourceContext getRcontext() {
    return rcontext;
  }

  public ResourceRenderer setRcontext(ResourceContext rcontext) {
    this.rcontext = rcontext;
    return this;
  }

  public XhtmlNode build(Resource dr) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    render(x, dr);
    return x;
  }
  /**
   * given a resource, update it's narrative with the best rendering available
   * 
   * @param r - the domain resource in question
   * 
   * @throws IOException
   * @throws EOperationOutcome 
   * @throws FHIRException 
   */
  
  public void render(DomainResource r) throws IOException, FHIRException, EOperationOutcome {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean ofr = forResource;
    boolean hasExtensions;
    try {
      forResource = true;
      hasExtensions = render(x, r);
    } finally {
      forResource = ofr;
    }
    inject(r, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public XhtmlNode render(ResourceWrapper r) throws IOException, FHIRException, EOperationOutcome { 
    assert r.getContext() == context;
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasExtensions = render(x, r);
    if (r.hasNarrative()) {
      r.injectNarrative(x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
    }
    return x;
  }

  public abstract boolean render(XhtmlNode x, Resource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome;
  
  public boolean render(XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    ProfileDrivenRenderer pr = new ProfileDrivenRenderer(context);
    return pr.render(x, r);
  }
  
  public void describe(XhtmlNode x, Resource r) throws UnsupportedEncodingException, IOException {
    x.tx(display(r));
  }

  public void describe(XhtmlNode x, ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    x.tx(display(r));
  }

  public abstract String display(Resource r) throws UnsupportedEncodingException, IOException;
  public abstract String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException;
  
  public static void inject(DomainResource r, XhtmlNode x, NarrativeStatus status) {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    if (r.hasLanguage()) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", r.getLanguage());
      x.setAttribute("xml:lang", r.getLanguage());
    }
    r.getText().setUserData("renderer.generated", true);
    if (!r.hasText() || !r.getText().hasDiv() || r.getText().getDiv().getChildNodes().isEmpty()) {
      r.setText(new Narrative());
      r.getText().setDiv(x);
      r.getText().setStatus(status);
    } else {
      XhtmlNode n = r.getText().getDiv();
      n.clear();
      n.getChildNodes().addAll(x.getChildNodes());
    }
  }

  public void renderCanonical(Resource res, XhtmlNode x, String url) throws UnsupportedEncodingException, IOException {
    ResourceWrapper rw = new ResourceWrapperDirect(this.context, res);
    renderCanonical(rw, x, url);
  }

  public void renderCanonical(ResourceWrapper rw, XhtmlNode x, String url) throws UnsupportedEncodingException, IOException {
    renderCanonical(rw, x, url, true); 
  }
  
  public void renderCanonical(ResourceWrapper rw, XhtmlNode x, String url, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (url == null) {
      return;
    }
    Resource target = context.getWorker().fetchResource(Resource.class, url);
    if (target == null || !(target instanceof CanonicalResource)) {
      x.code().tx(url);
    } else {
      CanonicalResource cr = (CanonicalResource) target;
      if (url.contains("|")) {
        if (target.hasUserData("path")) {
          x.ah(target.getUserString("path")).tx(cr.present()+" (version "+cr.getVersion()+")");
        } else {
          url = url.substring(0, url.indexOf("|"));
          x.code().tx(url);
          x.tx(": "+cr.present()+" (version "+cr.getVersion()+")");          
        }
      } else {
        if (target.hasUserData("path")) {
          x.ah(target.getUserString("path")).tx(cr.present());
        } else {
          x.code().tx(url);
          x.tx(" ("+cr.present()+")");          
        }
      }
    }
  }

  public void render(Resource res, XhtmlNode x, DataType type) throws FHIRFormatError, DefinitionException, IOException {
    if (type instanceof Reference) {
      renderReference(res, x, (Reference) type);
    } else if (type instanceof CodeableReference) {
      CodeableReference cr = (CodeableReference) type;
      if (cr.hasReference()) {
        renderReference(res, x, cr.getReference());
      } else {
        render(x, type);
      } 
    } else { 
      render(x, type);
    }
  }

  public void render(ResourceWrapper res, XhtmlNode x, DataType type) throws FHIRFormatError, DefinitionException, IOException {
    if (type instanceof Reference) {
      renderReference(res, x, (Reference) type);
    } else if (type instanceof CodeableReference) {
      CodeableReference cr = (CodeableReference) type;
      if (cr.hasReference()) {
        renderReference(res, x, cr.getReference());
      } else {
        render(x, type);
      } 
    } else { 
      render(x, type);
    }
  }

  public void renderReference(Resource res, XhtmlNode x, Reference r) throws UnsupportedEncodingException, IOException {
    ResourceWrapper rw = new ResourceWrapperDirect(this.context, res);
    renderReference(rw, x, r);
  }

  public void renderReference(ResourceWrapper rw, XhtmlNode x, Reference r) throws UnsupportedEncodingException, IOException {
    renderReference(rw, x, r, true); 
  }
  
  public void renderReference(ResourceWrapper rw, XhtmlNode x, Reference r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) {
      x.tx("null!");
      return;
    }
    XhtmlNode c = null;
    ResourceWithReference tr = null;
    if (r.hasReferenceElement() && allowLinks) {
      tr = resolveReference(rw, r.getReference());

      if (!r.getReference().startsWith("#")) {
        if (tr != null && tr.getReference() != null)
          c = x.ah(tr.getReference());
        else
          c = x.ah(r.getReference());
      } else {
        
        c = x.ah(r.getReference());
      }
    } else {
      c = x.span(null, null);
    }
    if (tr != null && tr.getReference() != null && tr.getReference().startsWith("#")) {
      c.tx("See above (");
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the name, or the generated narrative
    String display = r.hasDisplayElement() ? r.getDisplay() : null;
    String name = tr != null && tr.getResource() != null ? tr.getResource().getNameFromResource() : null; 
    
    if (display == null && (tr == null || tr.getResource() == null)) {
      c.addText(r.getReference());
    } else if (context.isTechnicalMode()) {
      c.addText(r.getReference());
      if (display != null) {
        c.addText(": "+display);
      }
      if ((tr == null || !tr.getReference().startsWith("#")) && name != null) {
        x.addText(" \""+name+"\"");
      }
      if (r.hasExtension(ToolingExtensions.EXT_TARGET_ID)) {
        x.addText("(#"+r.getExtensionString(ToolingExtensions.EXT_TARGET_ID)+")");
      } else if (r.hasExtension(ToolingExtensions.EXT_TARGET_PATH)) {
        x.addText("(#/"+r.getExtensionString(ToolingExtensions.EXT_TARGET_PATH)+")");
      }  
    } else {
      if (display != null) {
        c.addText(display);
      } else if (name != null) {
        c.addText(name);
      } else {
        c.tx(". Generated Summary: ");
        if (tr != null) {
          new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), true, r.getReference().startsWith("#"), true);
        }
      }
    }
    if (tr != null && tr.getReference() != null && tr.getReference().startsWith("#")) {
      c.tx(")");
    }
  }

  public void renderReference(ResourceWrapper rw, XhtmlNode x, BaseWrapper r) throws UnsupportedEncodingException, IOException {
    XhtmlNode c = x;
    ResourceWithReference tr = null;
    String v;
    if (r.has("reference")) {
      v = r.get("reference").primitiveValue();
      tr = resolveReference(rw, v);

      if (!v.startsWith("#")) {
        if (tr != null && tr.getReference() != null)
          c = x.ah(tr.getReference());
        else
          c = x.ah(v);
      }
    } else {
      v = "";
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the generated narrative
    if (r.has("display")) {
      c.addText(r.get("display").primitiveValue());
      if (tr != null && tr.getResource() != null) {
        c.tx(". Generated Summary: ");
        new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), true, v.startsWith("#"), false);
      }
    } else if (tr != null && tr.getResource() != null) {
      new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), v.startsWith("#"), v.startsWith("#"), false);
    } else {
      c.addText(v);
    }
  }
  
  protected ResourceWithReference resolveReference(ResourceWrapper res, String url) {
    if (url == null)
      return null;
    if (url.startsWith("#") && res != null) {
      for (ResourceWrapper r : res.getContained()) {
        if (r.getId().equals(url.substring(1)))
          return new ResourceWithReference(null, r);
      }
      return null;
    }
    String version = null;
    if (url.contains("/_history/")) {
      version = url.substring(url.indexOf("/_history/")+10);
      url = url.substring(0, url.indexOf("/_history/"));
    }

    if (rcontext != null) {
      BundleEntryComponent bundleResource = rcontext.resolve(url);
      if (bundleResource != null) {
        String id = bundleResource.getResource().getId();
        if (id == null) {
          id = makeIdFromBundleEntry(bundleResource.getFullUrl());
        }
        String bundleUrl = "#" + bundleResource.getResource().getResourceType().name() + "_" + id; 
        return new ResourceWithReference(bundleUrl, new ResourceWrapperDirect(this.context, bundleResource.getResource()));
      }
      org.hl7.fhir.r5.elementmodel.Element bundleElement = rcontext.resolveElement(url, version);
      if (bundleElement != null) {
        String bundleUrl = null;
        Element br = bundleElement.getNamedChild("resource");
        if (br.getChildValue("id") != null) {
          bundleUrl = "#" + br.fhirType() + "_" + br.getChildValue("id");
        } else {
          bundleUrl = "#" +fullUrlToAnchor(bundleElement.getChildValue("fullUrl"));          
        }
        return new ResourceWithReference(bundleUrl, new ResourceWrapperMetaElement(this.context, br));
      }
    }

    Resource ae = getContext().getWorker().fetchResource(null, url, version);
    if (ae != null)
      return new ResourceWithReference(url, new ResourceWrapperDirect(this.context, ae));
    else if (context.getResolver() != null) {
      return context.getResolver().resolve(context, url);
    } else
      return null;
  }
  
  
  protected String makeIdFromBundleEntry(String url) {
    if (url == null) {
      return null;
    }
    if (url.startsWith("urn:uuid:")) {
      return url.substring(9).toLowerCase();
    }
    return fullUrlToAnchor(url);    
  }

  private String fullUrlToAnchor(String url) {
    return url.replace(":", "").replace("/", "_");
  }

  protected void generateCopyright(XhtmlNode x, CanonicalResource cs) {
    XhtmlNode p = x.para();
    p.b().tx(getContext().getWorker().translator().translate("xhtml-gen-cs", "Copyright Statement:", context.getLang()));
    smartAddText(p, " " + cs.getCopyright());
  }

  public String displayReference(Resource res, Reference r) throws UnsupportedEncodingException, IOException {
    return "todo"; 
   }
   

   public Base parseType(String string, String type) {
     return null;
   }

   protected PropertyWrapper getProperty(ResourceWrapper res, String name) {
     for (PropertyWrapper t : res.children()) {
       if (t.getName().equals(name))
         return t;
     }
     return null;
   }

   protected PropertyWrapper getProperty(BaseWrapper res, String name) {
     for (PropertyWrapper t : res.children()) {
       if (t.getName().equals(name))
         return t;
     }
     return null;
   }

   protected boolean valued(PropertyWrapper pw) {
     return pw != null && pw.hasValues();
   }


   protected ResourceWrapper fetchResource(BaseWrapper subject) throws UnsupportedEncodingException, FHIRException, IOException {
     if (context.getResolver() == null)
       return null;

     PropertyWrapper ref = subject.getChildByName("reference");
     if (ref == null || !ref.hasValues()) {
       return null;
     }
     String url = ref.value().getBase().primitiveValue();
     ResourceWithReference rr = context.getResolver().resolve(context, url);
     return rr == null ? null : rr.getResource();
   }


   protected String describeStatus(PublicationStatus status, boolean experimental) {
     switch (status) {
     case ACTIVE: return experimental ? "Experimental" : "Active"; 
     case DRAFT: return "draft";
     case RETIRED: return "retired";
     default: return "Unknown";
     }
   }

   protected void renderCommitteeLink(XhtmlNode x, CanonicalResource cr) {
     String code = ToolingExtensions.readStringExtension(cr, ToolingExtensions.EXT_WORKGROUP);
     CodeSystem cs = context.getWorker().fetchCodeSystem("http://terminology.hl7.org/CodeSystem/hl7-work-group");
     if (cs == null || !cs.hasUserData("path"))
       x.tx(code);
     else {
       ConceptDefinitionComponent cd = CodeSystemUtilities.findCode(cs.getConcept(), code);
       if (cd == null) {
         x.tx(code);
       } else {
         x.ah(cs.getUserString("path")+"#"+cs.getId()+"-"+cd.getCode()).tx(cd.getDisplay());
       }
     }
   }

   public static String makeInternalBundleLink(String fullUrl) {
     return fullUrl.replace(":", "-");
   }

  public boolean canRender(Resource resource) {
    return true;
  }

  protected void renderResourceHeader(ResourceWrapper r, XhtmlNode x, boolean doId) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode div = x.div().style("display: inline-block").style("background-color: #d9e0e7").style("padding: 6px")
         .style("margin: 4px").style("border: 1px solid #8da1b4")
         .style("border-radius: 5px").style("line-height: 60%");

    String id = getPrimitiveValue(r, "id"); 
    if (doId) {
      div.an(id);
    }

    String lang = getPrimitiveValue(r, "language"); 
    String ir = getPrimitiveValue(r, "implicitRules"); 
    BaseWrapper meta = r.getChildByName("meta").hasValues() ? r.getChildByName("meta").getValues().get(0) : null;
    String versionId = getPrimitiveValue(meta, "versionId");
    String lastUpdated = getPrimitiveValue(meta, "lastUpdated");
    String source = getPrimitiveValue(meta, "source");
    
    if (id != null || lang != null || versionId != null || lastUpdated != null) {
      XhtmlNode p = plateStyle(div.para());
      p.tx("Resource ");
      p.tx(r.fhirType());
      p.tx(" ");
      if (id != null) {
        p.tx("\""+id+"\" ");
      }
      if (versionId != null) {
        p.tx("Version \""+versionId+"\" ");
      }
      if (lastUpdated != null) {
        p.tx("Updated \"");
        renderDateTime(p, lastUpdated);
        p.tx("\" ");
      }
      if (lang != null) {
        p.tx(" (Language \""+lang+"\") ");
      }
    }
    if (ir != null) {
      plateStyle(div.para()).b().tx("Special rules apply: "+ir+"!");     
    }
    if (source != null) {
      plateStyle(div.para()).tx("Information Source: "+source+"!");           
    }
    if (meta != null) {
      PropertyWrapper pl = meta.getChildByName("profile");
      if (pl.hasValues()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize("Profile", pl.getValues().size())+": ");
        boolean first = true;
        for (BaseWrapper bw : pl.getValues()) {
          if (first) first = false; else p.tx(", ");
          renderCanonical(r, p, bw.getBase().primitiveValue());
        }
      }
      PropertyWrapper tl = meta.getChildByName("tag");
      if (tl.hasValues()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize("Tag", tl.getValues().size())+": ");
        boolean first = true;
        for (BaseWrapper bw : tl.getValues()) {
          if (first) first = false; else p.tx(", ");
          String system = getPrimitiveValue(bw, "system");
          String version = getPrimitiveValue(bw, "version");
          String code = getPrimitiveValue(bw, "system");
          String display = getPrimitiveValue(bw, "system");
          renderCoding(p, new Coding(system, version, code, display));
        }        
      }
      PropertyWrapper sl = meta.getChildByName("security");
      if (sl.hasValues()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize("Security Label", tl.getValues().size())+": ");
        boolean first = true;
        for (BaseWrapper bw : sl.getValues()) {
          if (first) first = false; else p.tx(", ");
          String system = getPrimitiveValue(bw, "system");
          String version = getPrimitiveValue(bw, "version");
          String code = getPrimitiveValue(bw, "system");
          String display = getPrimitiveValue(bw, "system");
          renderCoding(p, new Coding(system, version, code, display));
        }        
      }
    }
      
  }

  private XhtmlNode plateStyle(XhtmlNode para) {
    return para.style("margin-bottom: 0px");
  }

  private String getPrimitiveValue(BaseWrapper b, String name) throws UnsupportedEncodingException, FHIRException, IOException {
    return b != null && b.has(name) && b.getChildByName(name).hasValues() ? b.getChildByName(name).getValues().get(0).getBase().primitiveValue() : null;
  }

  private String getPrimitiveValue(ResourceWrapper r, String name) throws UnsupportedEncodingException, FHIRException, IOException {
    return r.has(name) && r.getChildByName(name).hasValues() ? r.getChildByName(name).getValues().get(0).getBase().primitiveValue() : null;
  }

  public void renderOrError(DomainResource dr) {
    try {
      render(dr);
    } catch (Exception e) {
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      x.para().tx("Error rendering: "+e.getMessage());
      dr.setText(null);
      inject(dr, x, NarrativeStatus.GENERATED);   
    }
    
  }
  
  public RendererType getRendererType() {
    return RendererType.NATIVE;
  }
}