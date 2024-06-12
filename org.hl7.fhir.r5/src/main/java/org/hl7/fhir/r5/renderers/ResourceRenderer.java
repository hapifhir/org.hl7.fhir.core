package org.hl7.fhir.r5.renderers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.BaseWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.PropertyWrapper;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.ResourceWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.ElementWrappers.ResourceWrapperMetaElement;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceReferenceKind;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;

public abstract class ResourceRenderer extends DataRenderer {

  public enum RendererType {
    NATIVE, PROFILE, LIQUID

  }

  protected XVerExtensionManager xverManager;
  protected boolean multiLangMode;
  
  
  public ResourceRenderer(RenderingContext context) {
    super(context);
  }
  
  public boolean isMultiLangMode() {
    return multiLangMode;
  }

  public ResourceRenderer setMultiLangMode(boolean multiLangMode) {
    this.multiLangMode = multiLangMode;
    return this;
  }

  public XhtmlNode build(ResourceElement dr) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    renderResource(new RenderingStatus(), x, dr);
    return x;
  }
  
  /**
   * given a resource, update it's narrative with the best rendering available. 
   * 
   * Explanation about native vs wrapped
   * 
   * @param r - the domain resource in question
   * 
   * @throws IOException
   * @throws EOperationOutcome 
   * @throws FHIRException 
   */
  public void renderResource(DomainResource r) throws IOException, FHIRException, EOperationOutcome {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    RenderingStatus status = new RenderingStatus();
    renderResource(status, x, r);
    String an = r.fhirType()+"_"+r.getId();
    if (context.isAddName()) {
      if (!hasAnchorName(x, an)) {
        injectAnchorName(x, an);
      }
    }
    inject(r, x, status.getExtensions() ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }
  
  public void renderResource(ResourceElement r) throws IOException, FHIRException, EOperationOutcome {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    RenderingStatus status = new RenderingStatus();
    renderResource(status, x, r);
    String an = r.fhirType()+"_"+r.getId();
    if (context.isAddName()) {
      if (!hasAnchorName(x, an)) {
        injectAnchorName(x, an);
      }
    }
    inject(r, x, status.getExtensions() ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public XhtmlNode checkNarrative(ResourceElement r) throws IOException, FHIRException, EOperationOutcome { 
    XhtmlNode x = r.getNarrative();
    String an = r.fhirType()+"_"+r.getId();
    if (context.isAddName()) {
      if (!hasAnchorName(x, an)) {
        injectAnchorName(x, an);
      }
    }
    return x;
  }

  private void injectAnchorName(XhtmlNode x, String an) {
    XhtmlNode ip = x;
    while (ip.hasChildren() && "div".equals(ip.getChildNodes().get(0).getName())) {
      ip = ip.getChildNodes().get(0);
    }
    ip.addTag(0, "a").setAttribute("name", an).tx(" ");    
  }

  protected boolean hasAnchorName(XhtmlNode x, String an) {
    if ("a".equals(x.getName()) && an.equals(x.getAttribute("name"))) {
      return true;
    }
    if (x.hasChildren()) {
      for (XhtmlNode c : x.getChildNodes()) {
        if (hasAnchorName(c, an)) {
          return true;
        }
      }
    }
    return false;
  }

  // these three are what the descendants of this class override
  public abstract void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome;
  public void renderResource(RenderingStatus status, XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    renderResource(status, x, new ResourceElement(context.getContextUtilities(), context.getProfileUtilities(), r));
  }
  public abstract String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException;
    

  public String canonicalTitle(ResourceElement r) {
    if (r.has("title")) {
      return r.primitiveValue("title");
    }
    if (r.has("name")) {
      return r.primitiveValue("name");
    }
    if (r.has("id")) {
      return r.primitiveValue("id");
    }
    return "??";
  }
  
  public void describe(XhtmlNode x, ResourceElement r) throws UnsupportedEncodingException, IOException {
    x.tx(displayDataType(r));
  }
  
  public void inject(ResourceElement r, XhtmlNode x, NarrativeStatus status) {
    r.setNarrative(x, status.toCode(), multiLangMode, context.getLocale());
  }

  public void inject(DomainResource r, XhtmlNode x, NarrativeStatus status) {
    r.getText().setUserData("renderer.generated", true);
    if (!r.hasText() || !r.getText().hasDiv()) {
      r.setText(new Narrative());
      r.getText().setStatus(status);      
    }
    if (multiLangMode) {
      if (!r.getText().hasDiv()) { 
        XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
        div.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
        r.getText().setDiv(div);
      } else {
        r.getText().getDiv().getChildNodes().removeIf(c -> !"div".equals(c.getName()) || !c.hasAttribute("xml:lang"));
      }
      markLanguage(x);
      r.getText().getDiv().getChildNodes().add(x);
    } else {
      if (!x.hasAttribute("xmlns"))
        x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
      if (r.hasLanguage()) {
        // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
        x.setAttribute("lang", r.getLanguage());
        x.setAttribute("xml:lang", r.getLanguage());
      }
      r.getText().setDiv(x);
    }
  }

  public void markLanguage(XhtmlNode x) {
    x.setAttribute("lang", context.getLocale().toString());
    x.setAttribute("xml:lang", context.getLocale().toString());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(context.getLocale().getDisplayName());
    x.addTag(0, "hr");
  }
  
  public void renderCanonical(ResourceElement res, XhtmlNode x, String url) throws UnsupportedEncodingException, IOException {
    renderCanonical(res, x, url, true, res); 
  }
  
  public void renderCanonical(ResourceElement rw, XhtmlNode x, String url, boolean allowLinks, ResourceElement src) throws UnsupportedEncodingException, IOException {
    if (url == null) {
      return;
    }
    Resource target = context.getWorker().fetchResource(Resource.class, url, src.getResource());
    if (target == null || !(target instanceof CanonicalResource)) {
      x.code().tx(url);
    } else {
      CanonicalResource cr = (CanonicalResource) target;
      if (url.contains("|")) {
        if (target.hasWebPath()) {
          x.ah(target.getWebPath()).tx(cr.present()+ context.formatPhrase(RenderingContext.RES_REND_VER) +cr.getVersion()+")");
        } else {
          url = url.substring(0, url.indexOf("|"));
          x.code().tx(url);
          x.tx(": "+cr.present()+ context.formatPhrase(RenderingContext.RES_REND_VER) +cr.getVersion()+")");          
        }
      } else {
        if (target.hasWebPath()) {
          x.ah(target.getWebPath()).tx(cr.present());
        } else {
          x.code().tx(url);
          x.tx(" ("+cr.present()+")");          
        }
      }
    }
  }

  public void renderReference(RenderingStatus status, ResourceElement res, XhtmlNode x, ResourceElement type) throws FHIRFormatError, DefinitionException, IOException {
    if (type.fhirType().equals("Reference")) {
      renderReference(status, res, x, type);
    } else if (type.fhirType().equals("CodeableReference")) {
      if (type.has("reference")) {
        renderReference(status, res, x, type, true);
      } else {
        renderDataType(status, x, type);
      } 
    } else { 
      renderDataType(status, x, type);
    }
  }

  /*
   * } else if (ew.fhirType().equals("Reference")) {
      Reference r = (Reference) e;
      if (r.getReference() != null && r.getReference().contains("#")) {
        if (containedIds.contains(r.getReference().substring(1))) {
          x.ah("#hc"+r.getReference().substring(1)).tx("See "+r.getReference());
        } else {          
          // in this case, we render the resource in line
          ResourceWrapper rw = null;
          for (ResourceWrapper t : res.getContained()) {
            if (r.getReference().substring(1).equals(t.getId())) {
              rw = t;
            }
          }
          if (rw == null) {
            renderReference(res, x, r);
          } else {
            String ref = context.getResolver() != null ?context.getResolver().urlForContained(context, res.fhirType(), res.getId(), rw.fhirType(), rw.getId()) : null;
            if (ref == null) {
              x.an("hc"+rw.getId());
              RenderingContext ctxtc = context.copy();
              ctxtc.setAddGeneratedNarrativeHeader(false);
              ctxtc.setContained(true);
              ResourceRenderer rr = RendererFactory.factory(rw, ctxtc);
              rr.setRcontext(new ResourceContext(rcontext, rw));
              rr.render(parent.blockquote(), rw);
            } else {
              x.ah(ref).tx("See "+rw.fhirType());              
            }
          }
        }
      } else {
        renderReference(res, x, r);
      }
   */
  public void renderReference(Resource res, HierarchicalTableGenerator gen, List<Piece> pieces, Reference r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) { 
      pieces.add(gen.new Piece(null, "null!", null));
      return;
    }
    ResourceWithReference tr = null;
    String link = null;
    StringBuilder text = new StringBuilder();
    if (r.hasReferenceElement() && allowLinks) {
      tr = resolveReference(new ResourceElement(context.getContextUtilities(), context.getProfileUtilities(), res), r.getReference());

      if (!r.getReference().startsWith("#")) {
        if (tr != null && tr.getReference() != null) {
          link = tr.getReference();
        } else if (r.getReference().contains("?")) {
          text.append(context.formatPhrase(RenderingContext.RES_REND_COND_REF)+" ");
        } else {
          link = r.getReference();
        }
      } 
    }
    if (tr != null && tr.getReference() != null && tr.getReference().startsWith("#")) {
      text.append(context.formatPhrase(RenderingContext.RES_REND_SEE_ON_THIS_PAGE)+" ");
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the name, or the generated narrative
    String display = r.hasDisplayElement() ? r.getDisplay() : null;
    String name = tr != null && tr.getResource() != null ? getNameForResource(tr.getResource()) : null; 
    
    if (display == null && (tr == null || tr.getResource() == null)) {
      if (!Utilities.noString(r.getReference())) {
        text.append(r.getReference());
      } else if (r.hasIdentifier()) {
        text.append(displayIdentifier(new ResourceElement(context.getContextUtilities(), context.getProfileUtilities(), r.getIdentifier())));
      } else {
        text.append("??");        
      }
    } else if (context.isTechnicalMode()) {
      text.append(r.getReference());
      if (display != null) {
        text.append(": "+display);
      }
      if ((tr == null || (tr.getReference() != null && !tr.getReference().startsWith("#"))) && name != null) {
        text.append(" \""+name+"\"");
      }
      if (r.hasExtension(ToolingExtensions.EXT_TARGET_ID) || r.hasExtension(ToolingExtensions.EXT_TARGET_PATH)) {
        text.append("(");
        for (Extension ex : r.getExtensionsByUrl(ToolingExtensions.EXT_TARGET_ID)) {
          if (ex.hasValue()) {
            text.append(", ");
            text.append("#"+ex.getValue().primitiveValue());
          }
        }
        for (Extension ex : r.getExtensionsByUrl(ToolingExtensions.EXT_TARGET_PATH)) {
          if (ex.hasValue()) {
            text.append(", ");
            text.append("/#"+ex.getValue().primitiveValue());
          }
        }
        text.append(")");
      }  
    } else {
      if (display != null) {
        text.append(display);
      } else if (name != null) {
        text.append(name);
      } else {
        text.append(context.formatPhrase(RenderingContext.RES_REND_DESC));
      }
    }
    if (tr != null && tr.getReference() != null && tr.getReference().startsWith("#")) {
      text.append(")");
    }      
    pieces.add(gen.new Piece(link,text.toString(), null));
  }
  
  private String getNameForResource(ResourceElement resource) {
    ResourceElement name = resource.firstChild("name");
    if (name != null && !name.isEmpty()) {
      if (name.isPrimitive()) {
        return name.primitiveValue();          
      } else if (name.fhirType().equals("HumanName")) {
        String family = name.primitiveValue("family");
        String given = name.firstPrimitiveValue("given");
        return (family == null) ? given : given == null ? family : family+" "+given;
      } else {
        String n = name.primitiveValueMN("name", "text", "value");
        if (n != null) {            
          return n;            
        }
      }
    }
    String n = resource.primitiveValue("productName");
    if (n == null) {            
      throw new Error("What to render for 'name'? Type is "+resource.fhirType());
    } else {
      return n;            
    }
  }

  public void renderReference(RenderingStatus status, ResourceElement rw, XhtmlNode x, ResourceElement r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) {
      x.tx("null!");
      return;
    }
    XhtmlNode c = null;
    ResourceWithReference tr = null;
    boolean onPage = false;
    String rref = r.primitiveValue("reference");
    if (r.has("reference") && allowLinks) {
      tr = resolveReference(rw, r.primitiveValue("reference"));

      if (!rref.startsWith("#")) {
        if (tr != null && tr.getReference() != null) {
          if (tr.getReference().startsWith("#")) {
            onPage = true;
            if (context.getRules() == GenerationRules.IG_PUBLISHER || (tr != null && tr.getKind() != ResourceReferenceKind.BUNDLE)) {
              c = x.ah("#hc"+tr.getReference().substring(1));
            } else {
              c = x;
            }
          } else {
            c = x.ah(tr.getReference());
          }
        } else if (rref.contains("?")) {
          x.tx(context.formatPhrase(RenderingContext.RES_REND_COND_REF)+" ");
          c = x.code("");
        } else {
          c = x.ah(rref);
        }
      } else if ("#".equals(rref)) {
        c = x.ah("#");
      } else if (context.getRules() == GenerationRules.IG_PUBLISHER || (tr != null && tr.getKind() != ResourceReferenceKind.BUNDLE)) {
        c = x.ah("#hc"+rref.substring(1));
        onPage = true;
      } else {
        c = x;
      }
    } else {
      c = x.span(null, null);
    }
    if (onPage) {
      c.tx(context.formatPhrase(RenderingContext.RES_REND_SEE_ON_THIS_PAGE)+" ");
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the name, or the generated narrative
    String display = r.has("display") ? r.primitiveValue("display") : null;
    String name = tr != null && tr.getResource() != null ? getNameForResource(tr.getResource()) : null; 
    
    if (display == null && (tr == null || tr.getResource() == null)) {
      if (!Utilities.noString(rref)) {
        c.addText(rref);
      } else if (r.has("identifier")) {
        renderIdentifier(status, c, r.child("identifier"));
      } else {
        c.addText("??");        
      }
    } else if (context.isTechnicalMode()) {
      c.addText(rref);
      if (display != null) {
        c.addText(": "+display);
      }
      if ((tr == null || (tr.getReference() != null && !tr.getReference().startsWith("#"))) && name != null) {
        x.addText(" \""+name+"\"");
      }
      if (r.hasExtension(ToolingExtensions.EXT_TARGET_ID) || r.hasExtension(ToolingExtensions.EXT_TARGET_PATH)) {
        x.addText("(");
        for (ResourceElement ex : r.extensions(ToolingExtensions.EXT_TARGET_ID)) {
          if (ex.has("value")) {
            x.sep(", ");
            x.addText("#"+ex.primitiveValue("value"));
          }
        }
        for (ResourceElement ex : r.extensions(ToolingExtensions.EXT_TARGET_PATH)) {
          if (ex.has("value")) {
            x.sep(", ");
            x.addText("/#"+ex.primitiveValue("value"));
          }
        }
        x.addText(")");
      }  
    } else {
      if (display != null) {
        c.addText(display);
      } else if (name != null) {
        c.addText(name);
      } else {
        c.tx(context.formatPhrase(RenderingContext.RES_REND_GEN_SUM)+" ");
        if (tr != null) {
          new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), true, rref.startsWith("#"), true);
        }
      }
    }
  }
//
//  public void renderReference(ResourceWrapper rw, XhtmlNode x, BaseWrapper r) throws UnsupportedEncodingException, IOException {
//    XhtmlNode c = x;
//    ResourceWithReference tr = null;
//    String v;
//    if (r.has("reference")) {
//      v = r.get("reference").primitiveValue();
//      tr = resolveReference(rw, v);
//
//      if (!v.startsWith("#")) {
//        if (tr != null && tr.getReference() != null)
//          c = x.ah(tr.getReference());
//        else
//          c = x.ah(v);
//      }
//    } else {
//      v = "";
//    }
//    // what to display: if text is provided, then that. if the reference was resolved, then show the generated narrative
//    if (r.has("display")) {
//      c.addText(r.get("display").primitiveValue());
//      if (tr != null && tr.getResource() != null) {
//        c.tx(context.formatPhrase(RenderingContext.RES_REND_GEN_SUM)+" ");
//        new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), true, v.startsWith("#"), false);
//      }
//    } else if (tr != null && tr.getResource() != null) {
//      new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), v.startsWith("#"), v.startsWith("#"), false);
//    } else {
//      c.addText(v);
//    }
//  }
  
  protected ResourceWithReference resolveReference(ResourceElement res, String url) {
    if (url == null)
      return null;
    if (url.startsWith("#") && res != null) {
      for (ResourceElement r : res.children("contained")) {
        if (r.getId().equals(url.substring(1)))
          return new ResourceWithReference(ResourceReferenceKind.CONTAINED, url, r);
      }
      return null;
    }
    String version = null;
    if (url.contains("/_history/")) {
      version = url.substring(url.indexOf("/_history/")+10);
      url = url.substring(0, url.indexOf("/_history/"));
    }
    /*
    if (rcontext != null) {
      BundleEntryComponent bundleResource = rcontext.resolve(url);
      if (bundleResource != null) {
        String id = bundleResource.getResource().getId();
        if (id == null) {
          id = makeIdFromBundleEntry(bundleResource.getFullUrl());
        }
        String bundleUrl = "#" + bundleResource.getResource().getResourceType().name() + "_" + id; 
        return new ResourceWithReference(ResourceReferenceKind.BUNDLE, bundleUrl, new ResourceElement(this.context.getContextUtilities(), bundleResource.getResource()));
      }
      org.hl7.fhir.r5.elementmodel.Element bundleElement = rcontext.resolveElement(url, version);
      if (bundleElement != null) {
        String bundleUrl = null;
        Element br = bundleElement.getNamedChild("resource", false);
        if (br.getChildValue("id") != null) {
          if ("Bundle".equals(br.fhirType())) {
            bundleUrl = "#";
          } else {
            bundleUrl = "#" + br.fhirType() + "_" + br.getChildValue("id");
          }
        } else {
          bundleUrl = "#" +fullUrlToAnchor(bundleElement.getChildValue("fullUrl"));          
        }
        return new ResourceWithReference(ResourceReferenceKind.BUNDLE, bundleUrl, new ResourceElement(this.context.getContextUtilities(), br));
      }
    }
*/
    Resource ae = getContext().getWorker().fetchResource(null, url, version);
    if (ae != null)
      return new ResourceWithReference(ResourceReferenceKind.EXTERNAL, url, new ResourceElement(this.context.getContextUtilities(), this.context.getProfileUtilities(), ae));
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
    p.b().tx(getContext().formatPhrase(RenderingContext.RESOURCE_COPYRIGHT));
    smartAddText(p, " " + cs.getCopyright());
  }

  public String displayReference(Resource res, Reference r) throws UnsupportedEncodingException, IOException {
    return (context.formatPhrase(RenderingContext.GENERAL_TODO)); 
   }
   

   public Base parseType(String string, String type) {
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


//   protected ResourceElement fetchResource(BaseWrapper subject) throws UnsupportedEncodingException, FHIRException, IOException {
//     if (context.getResolver() == null)
//       return null;
//
//     PropertyWrapper ref = subject.getChildByName("reference");
//     if (ref == null || !ref.hasValues()) {
//       return null;
//     }
//     String url = ref.value().getBase().primitiveValue();
//     ResourceWithReference rr = context.getResolver().resolve(context, url);
//     return rr == null ? null : rr.getResource();
//   }


   protected String describeStatus(PublicationStatus status, boolean experimental) {
     switch (status) {
     case ACTIVE: return experimental ? (context.formatPhrase(RenderingContext.GENERAL_EXPER)) : (context.formatPhrase(RenderingContext.RES_REND_ACT)); 
     case DRAFT: return (context.formatPhrase(RenderingContext.RES_REND_DRAFT));
     case RETIRED: return (context.formatPhrase(RenderingContext.RES_REND_RET));
     default: return (context.formatPhrase(RenderingContext.RES_REND_UNKNOWN));
     }
   }

   protected void renderCommitteeLink(XhtmlNode x, CanonicalResource cr) {
     String code = ToolingExtensions.readStringExtension(cr, ToolingExtensions.EXT_WORKGROUP);
     CodeSystem cs = context.getWorker().fetchCodeSystem("http://terminology.hl7.org/CodeSystem/hl7-work-group");
     if (cs == null || !cs.hasWebPath())
       x.tx(code);
     else {
       ConceptDefinitionComponent cd = CodeSystemUtilities.findCode(cs.getConcept(), code);
       if (cd == null) {
         x.tx(code);
       } else {
         x.ah(cs.getWebPath()+"#"+cs.getId()+"-"+cd.getCode()).tx(cd.getDisplay());
       }
     }
   }

   public static String makeInternalBundleLink(String fullUrl) {
     return fullUrl.replace(":", "-");
   }

  public boolean canRender(Resource resource) {
    return true;
  }

  protected void renderResourceHeader(ResourceElement r, XhtmlNode x, boolean doId) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode div = x.div().style("display: inline-block").style("background-color: #d9e0e7").style("padding: 6px")
         .style("margin: 4px").style("border: 1px solid #8da1b4")
         .style("border-radius: 5px").style("line-height: 60%");
    
    RenderingStatus status = new RenderingStatus();
    String id = r.primitiveValue("id"); 
    if (doId) {
      div.an("hc"+id);
    }

    String lang = r.primitiveValue("language"); 
    String ir = r.primitiveValue("implicitRules"); 
    ResourceElement meta = r.has("meta") && r.child("meta").isEmpty() ? r.child("meta") : null;
    ResourceElement versionId = meta == null ? null : meta.child("versionId");
    ResourceElement lastUpdated = meta == null ? null : meta.child("lastUpdated");
    ResourceElement source = meta == null ? null : meta.child("source");
    
    if (id != null || lang != null || versionId != null || lastUpdated != null) {
      XhtmlNode p = plateStyle(div.para());
      p.tx(context.formatPhrase(RenderingContext.GENERAL_RESOURCE));
      p.tx(r.fhirType());
      p.tx(" ");
      if (id != null) {
        p.tx("\""+id+"\" ");
      }
      if (versionId != null) {
        p.tx(context.formatPhrase(RenderingContext.GENERAL_VER) + "\""+versionId+"\" ");
      }
      if (lastUpdated != null) {
        p.tx(context.formatPhrase(RenderingContext.RES_REND_UPDATED) + "\"");
        renderDataType(status, p, lastUpdated);
        p.tx("\" ");
      }
      if (lang != null) {
        p.tx(" " + context.formatPhrase(RenderingContext.RES_REND_LANGUAGE) + "\""+lang+"\") ");
      }
    }
    if (ir != null) {
      plateStyle(div.para()).b().tx(context.formatPhrase(RenderingContext.RES_REND_SPEC_RULES) + " "+ir+"!");     
    }
    if (source != null) {
      plateStyle(div.para()).tx(context.formatPhrase(RenderingContext.RES_REND_INFO_SOURCE) + " "+source+"!");           
    }
    if (meta != null) {
      List<ResourceElement> items = meta.children("profile");
      if (!items.isEmpty()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_PROF), items.size())+": ");
        boolean first = true;
        for (ResourceElement bw : items) {
          if (first) first = false; else p.tx(", ");
          renderCanonical(r, p, bw.primitiveValue());
        }
      }
      items = meta.children("tag");
      if (!items.isEmpty()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.RES_REND_TAG), items.size())+": ");
        boolean first = true;
        for (ResourceElement bw : items) {
          if (first) first = false; else p.tx(", ");
          renderCoding(status, p, bw);
        }        
      }
      items = meta.children("security");
      if (!items.isEmpty()) {
        XhtmlNode p = plateStyle(div.para());
        p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_SECURITY_LABEL), items.size())+": ");
        boolean first = true;
        for (ResourceElement bw : items) {
          if (first) first = false; else p.tx(", ");
          renderCoding(status, p, bw);
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

//  public void renderOrError(DomainResource dr) {
//    try {
//      render(dr);
//    } catch (Exception e) {
//      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
//      x.para().tx(context.formatPhrase(RenderingContext.RES_REND_ERROR, e.getMessage())+" ");
//      dr.setText(null);
//      inject(dr, x, NarrativeStatus.GENERATED);   
//    }
//    
//  }
  
  public RendererType getRendererType() {
    return RendererType.NATIVE;
  }
  
  public class TableRowData {
    private Map<String, List<ResourceElement>> cols = new HashMap<>();
    private TableData data;
    
    public void value(String name, ResourceElement value) {
      if (!cols.containsKey(name)) {
        cols.put(name, new ArrayList<>());
      }
      if (!data.columns.contains(name)) {
        data.columns.add(name);
      }
      cols.get(name).add(value);
    }

    public boolean hasCol(String name) {
      return cols.containsKey(name);
    }

    public List<ResourceElement> get(String name) {
      return cols.get(name);
    }
    
  }
  public class TableData {
    private String title;
    private List<String> columns = new ArrayList<>();
    private List<TableRowData> rows = new ArrayList<>();
    public TableData(String title) {
      this.title = title;
    }
    public String getTitle() {
      return title;
    }
    public List<String> getColumns() {
      return columns;
    }
    public List<TableRowData> getRows() {
      return rows;
    }
    public void addColumn(String name) {
      columns.add(name);
    }
    public TableRowData addRow() {
      TableRowData res = new TableRowData();
      rows.add(res);
      res.data = this;
      return res;
    }
  }


  public void renderTable(RenderingStatus status, TableData provider, XhtmlNode x) throws FHIRFormatError, DefinitionException, IOException {
    List<String> columns = new ArrayList<>();
    for (String name : provider.getColumns()) {
      boolean hasData = false;
      for (TableRowData row : provider.getRows()) {
        if (row.hasCol(name)) {
          hasData = true;
        }
      }
      if (hasData) {
        columns.add(name);
      }
    }
    if (columns.size() > 0) {
      XhtmlNode table = x.table("grid");
      
      if (provider.getTitle() != null) {
        table.tr().td().colspan(columns.size()).b().tx(provider.getTitle());
      }
      XhtmlNode tr = table.tr();
      for (String col : columns) {
        tr.th().b().tx(col);
      }
      for (TableRowData row : provider.getRows()) {
        tr = table.tr();
        for (String col : columns) {
          XhtmlNode td = tr.td();
          boolean first = true;
          List<ResourceElement> list = row.get(col);
          if (list != null) {
            for (ResourceElement value : list) {
              if (first) first = false; else td.tx(", ");
              renderDataType(status, td, value);
            }
          }
        }
      }      
    }
  }

}