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
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.PrimitiveType;
import org.hl7.fhir.r5.model.Property;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.renderers.Renderer.RenderingStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceReferenceKind;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.renderers.utils.ResourceElement.ElementKind;
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
   * ResourceElement is a facade to either a org.hl7.fhir.r5.model Resource, or
   * to a org.hl7.fhir.r5.elementModel (which might a resource of any version). 
   * 
   * Note that some resource renderers - only canonical ones - only render native
   * resources, and not element model ones. These may be migrated in the future 
   * (only reason not to is the sheer size of the task, though performance might 
   * be a factor)
   *  
   * @param r - the domain resource in question
   * 
   * @throws IOException
   * @throws EOperationOutcome 
   * @throws FHIRException 
   */
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

//  public void inject(DomainResource r, XhtmlNode x, NarrativeStatus status) {
//    r.getText().setUserData("renderer.generated", true);
//    if (!r.hasText() || !r.getText().hasDiv()) {
//      r.setText(new Narrative());
//      r.getText().setStatus(status);      
//    }
//    if (multiLangMode) {
//      if (!r.getText().hasDiv()) { 
//        XhtmlNode div = new XhtmlNode(NodeType.Element, "div");
//        div.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
//        r.getText().setDiv(div);
//      } else {
//        r.getText().getDiv().getChildNodes().removeIf(c -> !"div".equals(c.getName()) || !c.hasAttribute("xml:lang"));
//      }
//      markLanguage(x);
//      r.getText().getDiv().getChildNodes().add(x);
//    } else {
//      if (!x.hasAttribute("xmlns"))
//        x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
//      if (r.hasLanguage()) {
//        // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
//        x.setAttribute("lang", r.getLanguage());
//        x.setAttribute("xml:lang", r.getLanguage());
//      }
//      r.getText().setDiv(x);
//    }
//  }

  public void markLanguage(XhtmlNode x) {
    x.setAttribute("lang", context.getLocale().toString());
    x.setAttribute("xml:lang", context.getLocale().toString());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(context.getLocale().getDisplayName());
    x.addTag(0, "hr");
  }
  
  public <T extends Resource> void renderCanonical(RenderingStatus status, XhtmlNode x, Class<T> class_, ResourceElement canonical) throws UnsupportedEncodingException, IOException {
    if (!renderPrimitiveWithNoValue(status, x, canonical)) {
      CanonicalResource target = (CanonicalResource) context.getWorker().fetchResource(class_, canonical.primitiveValue(), canonical.getResourceNative());
      if (target != null && target.hasWebPath()) {
        if (canonical.primitiveValue().contains("|")) {
          x.ah(target.getWebPath()).tx(target.present()+ context.formatPhrase(RenderingContext.RES_REND_VER) +target.getVersion()+")");
        } else {
          x.ah(target.getWebPath()).tx(target.present());
        }
        return;
      }
      // we can't resolve it as a canonical in the context. We'll try to do a local resolution instead
      ResourceWithReference rr = resolveReference(canonical);
      if (rr != null) {
        x.ah(rr.getWebPath()).tx(RendererFactory.factory(rr.getResource(), context).displayResource(rr.getResource()));        
      } else {
        x.code(canonical.primitiveValue());
      }
    }
  }
  
  /**
   * @param <T>
   * @param status
   * @param res
   * @param x
   * @param class_ - makes resolution faster, but can just be Resource.class
   * @param canonical
   * @throws UnsupportedEncodingException
   * @throws IOException
   */
  public <T extends Resource> void renderCanonical(RenderingStatus status, ResourceElement res, XhtmlNode x, Class<T> class_, CanonicalType canonical) throws UnsupportedEncodingException, IOException {
    if (canonical == null || !canonical.hasPrimitiveValue()) {
      return;
    }
    String url = canonical.asStringValue();
    Resource target = context.getWorker().fetchResource(Resource.class, url, res.getResourceNative());
    if (target == null || !(target instanceof CanonicalResource)) {
      x.code().tx(url);       
    } else {
      CanonicalResource cr = (CanonicalResource) target;
      if (!target.hasWebPath()) {
        x.code().tx(url);
        x.tx(" ("+cr.present()+")");
      } else {
        if (url.contains("|")) {
          x.ah(target.getWebPath()).tx(cr.present()+ context.formatPhrase(RenderingContext.RES_REND_VER) +cr.getVersion()+")");
        } else {
          x.ah(target.getWebPath()).tx(cr.present());
        }
      }
    }     
  }

  // todo: if (r.hasExtension(ToolingExtensions.EXT_TARGET_ID) || r.hasExtension(ToolingExtensions.EXT_TARGET_PATH)) {
  @Override
  public void renderReference(RenderingStatus status, XhtmlNode x, ResourceElement type) throws FHIRFormatError, DefinitionException, IOException {
    if (type == null) {
      return;
    }
    ResourceElement display = null;
    ResourceElement actual = null;
    ResourceElement id = null;
    if (type.fhirType().equals("CodeableReference")) {
      if (type.has("reference")) {
        type = type.child("reference");
      } else {
        renderCodeableConcept(status, x, type.child("concept"));
        return;
      }
    }
    if (type.fhirType().equals("Reference")) {
      display = type.child("display");
      actual = type.child("reference");
      id = type.child("identifier");
    } else {
      actual = type;
    }
    if (actual != null && actual.hasPrimitiveValue()) {
      ResourceWithReference rr = resolveReference(actual);
      if (rr == null) {
        String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : actual.primitiveValue();
        x.ah(actual.primitiveValue()).tx(disp);
      } else {
        String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : RendererFactory.factory(rr.getResource(), context).displayResource(rr.getResource());
        x.ah(rr.getWebPath()).tx(disp);
      }
    } else if (display != null && id != null) {
      renderDataType(status, x, display);
      x.tx(" (Identifier: ");
      renderIdentifier(status, x, id);
      x.tx(")");
    } else if (display != null) {
      renderDataType(status, x, display);
    } else if (id != null) {
      x.tx("Identifier: ");
      renderIdentifier(status, x, id);
    } else {
      x.tx("??");
    }
  }
  
  public void renderReference(ResourceElement res, HierarchicalTableGenerator gen, List<Piece> pieces, Reference r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) { 
      pieces.add(gen.new Piece(null, "null!", null));
      return;
    }
    ResourceWithReference tr = null;
    String link = null;
    StringBuilder text = new StringBuilder();
    if (r.hasReferenceElement() && allowLinks) {
      tr = resolveReference(res, r.getReference());

      if (!r.getReference().startsWith("#")) {
        if (tr != null && tr.getWebPath() != null) {
          link = tr.getWebPath();
        } else if (r.getReference().contains("?")) {
          text.append(context.formatPhrase(RenderingContext.RES_REND_COND_REF)+" ");
        } else {
          link = r.getReference();
        }
      } 
    }
    if (tr != null && tr.getWebPath() != null && tr.getWebPath().startsWith("#")) {
      text.append(context.formatPhrase(RenderingContext.RES_REND_SEE_ON_THIS_PAGE)+" ");
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the name, or the generated narrative
    String display = r.hasDisplayElement() ? r.getDisplay() : null;
    String name = tr != null && tr.getResource() != null ? getNameForResource(tr.getResource()) : null; 
    
    if (display == null && (tr == null || tr.getResource() == null)) {
      if (!Utilities.noString(r.getReference())) {
        text.append(r.getReference());
      } else if (r.hasIdentifier()) {
        text.append(displayIdentifier(wrapWC(res, r.getIdentifier())));
      } else {
        text.append("??");        
      }
    } else if (context.isTechnicalMode()) {
      text.append(r.getReference());
      if (display != null) {
        text.append(": "+display);
      }
      if ((tr == null || (tr.getWebPath() != null && !tr.getWebPath().startsWith("#"))) && name != null) {
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
    if (tr != null && tr.getWebPath() != null && tr.getWebPath().startsWith("#")) {
      text.append(")");
    }      
    pieces.add(gen.new Piece(link,text.toString(), null));
  }
  
  public void renderReference(ResourceElement res, HierarchicalTableGenerator gen, List<Piece> pieces, ResourceElement r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) { 
      pieces.add(gen.new Piece(null, "null!", null));
      return;
    }
    ResourceWithReference trt = null;
    String link = null;
    StringBuilder text = new StringBuilder();
    if (r.has("reference") && allowLinks) {
      trt = resolveReference(res, r.primitiveValue("reference"));

      if (!r.primitiveValue("reference").startsWith("#")) {
        if (trt != null && trt.getWebPath() != null) {
          link = trt.getWebPath();
        } else if (r.primitiveValue("reference").contains("?")) {
          text.append(context.formatPhrase(RenderingContext.RES_REND_COND_REF)+" ");
        } else {
          link = r.primitiveValue("reference");
        }
      } 
    }
    if (trt != null && trt.getWebPath() != null && trt.getWebPath().startsWith("#")) {
      text.append(context.formatPhrase(RenderingContext.RES_REND_SEE_ON_THIS_PAGE)+" ");
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the name, or the generated narrative
    String display = r.has("display") ? r.primitiveValue("display") : null;
    String name = trt != null && trt.getResource() != null ? getNameForResource(trt.getResource()) : null; 
    
    if (display == null && (trt == null || trt.getResource() == null)) {
      if (!Utilities.noString(r.primitiveValue("reference"))) {
        text.append(r.primitiveValue("reference"));
      } else if (r.has("identifier")) {
        text.append(displayIdentifier(r.child("identifier")));
      } else {
        text.append("??");        
      }
    } else if (context.isTechnicalMode()) {
      text.append(r.primitiveValue("reference"));
      if (display != null) {
        text.append(": "+display);
      }
      if ((trt == null || (trt.getWebPath() != null && !trt.getWebPath().startsWith("#"))) && name != null) {
        text.append(" \""+name+"\"");
      }
      if (r.hasExtension(ToolingExtensions.EXT_TARGET_ID) || r.hasExtension(ToolingExtensions.EXT_TARGET_PATH)) {
        text.append("(");
        for (ResourceElement ex : r.extensions(ToolingExtensions.EXT_TARGET_ID)) {
          if (ex.has("value")) {
            text.append(", ");
            text.append("#"+ex.primitiveValue("value"));
          }
        }
        for (ResourceElement ex : r.extensions(ToolingExtensions.EXT_TARGET_PATH)) {
          if (ex.has("value")) {
            text.append(", ");
            text.append("#"+ex.primitiveValue("value"));
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
    if (trt != null && trt.getWebPath() != null && trt.getWebPath().startsWith("#")) {
      text.append(")");
    }      
    pieces.add(gen.new Piece(link,text.toString(), null));
  }
  
  protected String getNameForResource(ResourceElement resource) {
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

  protected void renderUri(RenderingStatus status, ResourceElement resource, XhtmlNode x, UriType uri) throws FHIRFormatError, DefinitionException, IOException { 
    if (!renderPrimitiveWithNoValue(status, x, uri)) {
      String v = uri.primitiveValue();
      if (v.startsWith("mailto:")) { 
        x.ah(v).addText(v.substring(7)); 
      } else { 
        ResourceWithReference rr = resolveReference(resource, uri.primitiveValue());
        if (rr != null) {
          x.ah(rr.getWebPath()).addText(RendererFactory.factory(rr.getResource(), context).displayResource(rr.getResource()));           
        } else {
          Resource r = context.getContext().fetchResource(Resource.class, v); 
          if (r != null && r.getWebPath() != null) { 
              x.ah(r.getWebPath()).addText(RendererFactory.factory(r, context).displayResource(wrap(r)));           
          } else { 
            String url = context.getResolver() != null ? context.getResolver().resolveUri(context, v) : null; 
            if (url != null) {           
              x.ah(url).addText(v); 
            } else if (Utilities.isAbsoluteUrlLinkable(v) && !uri.fhirType().equals("id")) { 
              x.ah(v).addText(v); 
            } else { 
              x.addText(v); 
            } 
          } 
        }
      } 
    }
  } 
  
  @Override
  protected void renderUri(RenderingStatus status, XhtmlNode x, ResourceElement uri) throws FHIRFormatError, DefinitionException, IOException { 
    if (!renderPrimitiveWithNoValue(status, x, uri)) {
      String v = uri.primitiveValue();
      if (context.getContextUtilities().isResource(v)) {
        v = "http://hl7.org/fhir/StructureDefinition/"+v;
      }
      if (v.startsWith("mailto:")) { 
        x.ah(v).addText(v.substring(7)); 
      } else { 
        ResourceWithReference rr = resolveReference(uri);
        if (rr != null) {
          x.ah(rr.getWebPath()).addText(RendererFactory.factory(rr.getResource(), context).displayResource(rr.getResource()));           
        } else {
          Resource r = context.getContext().fetchResource(Resource.class, v); 
          if (r != null && r.getWebPath() != null) { 
              x.ah(r.getWebPath()).addText(RendererFactory.factory(r, context).displayResource(wrap(r)));           
          } else if (r != null) { 
            x.ah(v).addText(RendererFactory.factory(r, context).displayResource(wrap(r)));           
          } else { 
            String url = context.getResolver() != null ? context.getResolver().resolveUri(context, v) : null; 
            if (url != null) {           
              x.ah(url).addText(v); 
            } else if (Utilities.isAbsoluteUrlLinkable(v) && !uri.fhirType().equals("id")) { 
              x.ah(v).addText(v); 
            } else { 
              x.addText(v); 
            } 
          } 
        }
      } 
    }
  } 

  /**
   * Eventually this will be retired if and when there's no more direct renderers 
   * 
   * @param <T>
   */
  protected <T extends Resource> T findCanonical(Class<T> class_, UriType canonical, ResourceElement sourceOfReference) {
    return context.getContext().fetchResource(class_, canonical.asStringValue(), sourceOfReference.getResourceNative());
  }

  protected <T extends Resource> T findCanonical(Class<T> class_, String canonical, ResourceElement sourceOfReference) {
    return context.getContext().fetchResource(class_, canonical, sourceOfReference.getResourceNative());
  }


  private ResourceWithReference resolveContained(ResourceElement resource, String url) {
    ResourceElement container = findContainer(resource);
    if (container == null) {
      return null;
    } else if ("#".equals(url)) {
      return new ResourceWithReference(ResourceReferenceKind.CONTAINER, url, "#hc"+container.getScopedId(), container);
    } else {
      String tid = url.substring(1);
      for (ResourceElement c : container.children("contained")) {
        if (tid.equals(c.getId())) {
          return new ResourceWithReference(ResourceReferenceKind.CONTAINED, url, "#hc"+c.getScopedId(), c);
        }
      }
    }
    return null;
  }
  
  private ResourceElement findContainer(ResourceElement resource) {
    ResourceElement container = resource;
    while (container != null) {
      if (container.isResource() && container.kind() != ElementKind.ContainedResource) {
        break;
      }
      container = container.parent();
    }
    return container;
  }

  private ResourceWithReference resolveOutside(ResourceElement resource, String url, String version) {
    ResourceElement container = findContainer(resource);
    if (container != null) {
      while (container != null) {
        if (container.isResource() && container.fhirType().equals("Bundle")) {
          ResourceWithReference rr = findInBundle(resource, url);
          if (rr != null) {
            return null;
          }
        }
        container = container.parent();
      }
    }
//    } 
//    // ok, we didn't find it in the current instance, so we go look elsewhere 
//    if (context.getResolver() != null) {
//      ResourceWithReference rr = context.getResolver().resolve(context, url, version);
//      if (rr != null) {
//        return rr;
//      }
//    }
//    Resource r = context.getWorker().fetchResource(Resource.class, url, version);
//    if (r != null) {
//      return new ResourceWithReference(ResourceReferenceKind.EXTERNAL, url, r.getWebPath(), wrap(r));
//    }
    return null;
  }
  
  private ResourceWithReference findInBundle(ResourceElement resource, String url) {
    if (url.equals("Bundle/"+resource.getId())) {
      return new ResourceWithReference(ResourceReferenceKind.BUNDLE, url, "#"+resource.getScopedId(), resource);
    }
    for (ResourceElement entry : resource.children("entry")) {
      if (entry.has("resource")) {
        ResourceElement res = entry.child("resource");  
        if (entry.has("fullUrl")) { 
          String fu = entry.primitiveValue("fullUrl");
          if (url.equals(fu)) {
           return new ResourceWithReference(ResourceReferenceKind.BUNDLE, url, "#"+res.getScopedId(), res);
          }
        }
        if ("Bundle".equals(res.fhirType())) {
          ResourceWithReference rr = findInBundle(res, url);
          if (rr != null) {
            return rr;
          }
        }
      }
    }
    return null;
  }

  protected ResourceWithReference resolveReference(ResourceElement resource, String url) {
    if (url == null) {
      return null;
    }
    if (url.startsWith("#")) {
      return resolveContained(resource, url);
    } else {
      String version = null;
      if (url.contains("/_history/")) {
        version = url.substring(url.indexOf("/_history/")+10);
        url = url.substring(0, url.indexOf("/_history/"));
      }
      
      return resolveOutside(resource, url, version);
    }

  }

  protected ResourceWithReference resolveReference(ResourceElement reference) {
    if (reference.fhirType().equals("CodeableReference")) {
      if (reference.has("reference")) {
        return resolveReference(reference.child("reference"));
      } else {
        return null;
      }
    } else if (reference.fhirType().equals("Reference")) {
      return resolveReference(reference.getResourceWrapper(), reference.primitiveValue("reference"));
    } else {
      return resolveReference(reference.getResourceWrapper(), reference.primitiveValue());
    }
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

  protected void generateCopyright(XhtmlNode x, ResourceElement cs) {
    XhtmlNode p = x.para();
    p.b().tx(getContext().formatPhrase(RenderingContext.RESOURCE_COPYRIGHT));
    smartAddText(p, " " + cs.primitiveValue("copyright"));
  }

  public String displayReference(Resource res, Reference r) throws UnsupportedEncodingException, IOException {
    return (context.formatPhrase(RenderingContext.GENERAL_TODO)); 
   }
   

   public Base parseType(String string, String type) {
     return null;
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
          renderCanonical(status, p, StructureDefinition.class, bw);
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