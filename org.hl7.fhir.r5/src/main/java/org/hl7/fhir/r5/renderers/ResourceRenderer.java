package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceReferenceKind;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper.ElementKind;
import org.hl7.fhir.r5.terminologies.CodeSystemUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;

import org.hl7.fhir.r5.utils.xver.XVerExtensionManager;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.i18n.RenderingI18nContext;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Piece;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public abstract class ResourceRenderer extends DataRenderer {

  private static final String EXT_NS_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.url";

  public enum RendererType {
    NATIVE, PROFILE, LIQUID

  }

  protected XVerExtensionManager xverManager;
  protected boolean multiLangMode;
  protected boolean inner;
  
  
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

  public boolean renderingUsesValidation() {
    return false;
  }
  
  public boolean isInner() {
    return inner;
  }

  public ResourceRenderer setInner(boolean inner) {
    this.inner = inner;
    return this;
  }

  /**
   * Just build the narrative that would go in the resource (per @renderResource()), but don't put it in the resource
   * @param dr
   * @return
   * @throws FHIRFormatError
   * @throws DefinitionException
   * @throws FHIRException
   * @throws IOException
   * @throws EOperationOutcome
   */
  public XhtmlNode buildNarrative(ResourceWrapper dr) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if (context.getRules() == RenderingContext.GenerationRules.IG_PUBLISHER) {
      x.attribute("data-fhir", "generated");
    }
    buildNarrative(new RenderingStatus(), x, dr);
    checkForDuplicateIds(x);
    return x;
  }
  
  private void checkForDuplicateIds(XhtmlNode x) {
    if (context.isTrackNarrativeSource()) {
      Set<String> ids = new HashSet<>();
      checkForDuplicateIds(ids, x);
    }
  }

  private void checkForDuplicateIds(Set<String> ids, XhtmlNode x) {
    if (x.hasAttribute("id")) {
      String id = x.getAttribute("id");
      if (ids.contains(id)) {
        throw new Error("Duplicate id '"+id+"' on "+x.allText());
      } else {
        ids.add(id);
      }
    }
    if (x.hasChildren()) {
      for (XhtmlNode c : x.getChildNodes()) {
        checkForDuplicateIds(ids, c);
      }
    }
    
  }

  /**
   * given a resource, update it's narrative with the best rendering available. 
   * 
   * ResourceWrapper is a facade to either a org.hl7.fhir.r5.model Resource, or
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
  public void renderResource(ResourceWrapper r) throws IOException, FHIRException, EOperationOutcome {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    if (context.getRules() == RenderingContext.GenerationRules.IG_PUBLISHER) {
      x.attribute("data-fhir", "generated");
    }
    RenderingStatus status = new RenderingStatus();
    buildNarrative(status, x, r);
    String an = r.fhirType()+"_"+r.getId();
    if (context.isAddName()) {
      if (!hasAnchorName(x, an)) {
        injectAnchorName(x, an);
      }
    }
    inject(r, x, status.getExtensions() ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public XhtmlNode checkNarrative(ResourceWrapper r) throws IOException, FHIRException, EOperationOutcome { 
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
  public abstract void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome;
  public abstract String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException;
    
  public void buildSummary(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    x.tx(buildSummary(r));
  }

  public String canonicalTitle(ResourceWrapper r) {
    if (r.has("title")) {
      return r.primitiveValue("title");
    }
    if (r.has("name")) {
      return r.primitiveValue("name");
    }
    if (r.has("id")) {
      return r.primitiveValue("id");
    }
    return "?title?";
  }
  
  public void describe(XhtmlNode x, ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    x.tx(displayDataType(r));
  }
  
  public void inject(ResourceWrapper r, XhtmlNode x, NarrativeStatus status) throws IOException {
    r.setNarrative(x, status.toCode(), multiLangMode, context.getLocale(), context.isPretty());
  }

  public void markLanguage(XhtmlNode x) {
    x.setAttribute("lang", context.getLocale().toLanguageTag());
    x.setAttribute("xml:lang", context.getLocale().toLanguageTag());
    x.addTag(0, "hr");
    x.addTag(0, "p").b().tx(context.getLocale().getDisplayName());
    x.addTag(0, "hr");
  }
  
  @Override
  protected void renderCanonical(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    renderCanonical(status, x, Resource.class, type);
  }

  public <T extends Resource> void renderCanonical(RenderingStatus status, XhtmlNode x, Class<T> class_, ResourceWrapper canonical) throws UnsupportedEncodingException, IOException {
    if (!renderPrimitiveWithNoValue(status, x, canonical)) {
      CanonicalResource target = (CanonicalResource) context.getWorker().fetchResource(class_, canonical.primitiveValue(), null, canonical.getResourceNative());
      if (target != null && target.hasWebPath()) {
        if (canonical.primitiveValue().contains("|")) {
          x.ah(context.prefixLocalHref(target.getWebPath())).tx(target.present()+ context.formatPhrase(RenderingContext.RES_REND_VER) +target.getVersion()+")");
        } else {
          x.ah(context.prefixLocalHref(target.getWebPath())).tx(target.present());
        }
        return;
      }
      // we can't resolve it as a canonical in the context. We'll try to do a local resolution instead
      ResourceWithReference rr = resolveReference(canonical);
      if (rr == null) {
        x.code(canonical.primitiveValue());
      } else if (rr.getResource() == null) {
        x.ah(context.prefixLocalHref(rr.getWebPath())).tx(canonical.primitiveValue());        
      } else {
        x.ah(context.prefixLocalHref(rr.getWebPath())).tx(RendererFactory.factory(rr.getResource(), context.forContained()).buildSummary(rr.getResource()));        
      }
    }
  }
  

  protected String displayCanonical(ResourceWrapper canonical) {
    if (canonical == null || !canonical.hasPrimitiveValue()) {
      return "";
    }
    String url = canonical.primitiveValue();
    Resource target = context.getWorker().fetchResource(Resource.class, url, null, canonical.getResourceNative());
    if (target == null || !(target instanceof CanonicalResource)) {
      return url;       
    } else {
      CanonicalResource cr = (CanonicalResource) target;
      return "->"+cr.present();
    }     
  }
  
  protected String displayReference(ResourceWrapper type) {
    if (type == null) {
      return "";
    }
    ResourceWrapper display = null;
    ResourceWrapper actual = null;
    ResourceWrapper id = null;
    if (type.fhirType().equals("CodeableReference")) {
      if (type.has("reference")) {
        type = type.child("reference");
      } else {
        return displayCodeableConcept(type.child("concept"));
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
      if ("#".equals(actual.primitiveValue())) {
        return "this resource";
      } else {
        ResourceWithReference rr = resolveReference(actual);
        if (rr == null) {
          String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : actual.primitiveValue();
          return "->"+disp;
        } else {
          String disp;
          try {
            disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : RendererFactory.factory(rr.getResource(), context.forContained()).buildSummary(rr.getResource());
          } catch (IOException e) {
            disp = e.getMessage();
          }
          return "->"+disp;
        }
      }
    } else if (display != null) {
      return "->"+display;
    } else if (id != null) {
      return "id: "+displayIdentifier(id);
    } else {
      return "?ref?";
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
  public <T extends Resource> void renderCanonical(RenderingStatus status, ResourceWrapper res, XhtmlNode x, Class<T> class_, CanonicalType canonical) throws UnsupportedEncodingException, IOException {
    if (canonical == null || !canonical.hasPrimitiveValue()) {
      return;
    }
    String url = canonical.asStringValue();
    Resource target = context.getWorker().fetchResource(Resource.class, url, null, res.getResourceNative());
    if (target == null || !(target instanceof CanonicalResource)) {
      NamingSystem ns = context.getContextUtilities().fetchNamingSystem(url);
      if (ns != null) {
        x.code().tx(url);
        x.tx(" ("+ns.present()+")");
      } else {
        x.code().tx(url);
      }
    } else {
      CanonicalResource cr = (CanonicalResource) target;
      if (!target.hasWebPath()) {
        if (url.contains("|")) {
          x.code().tx(cr.getUrl());
          x.tx(context.formatPhrase(RenderingContext.RES_REND_VER, cr.getVersion()));
          x.tx(" ("+cr.present()+")");
        } else {
          x.code().tx(url);
          x.tx(" ("+cr.present()+")");
        }
      } else {
        if (url.contains("|")) {
          x.ah(context.prefixLocalHref(target.getWebPath())).tx(cr.present()+ context.formatPhrase(RenderingContext.RES_REND_VER, cr.getVersion())+")");
        } else {
          x.ah(context.prefixLocalHref(target.getWebPath())).tx(cr.present());
        }
      }
    }     
  }

  // todo: if (r.hasExtension(ExtensionDefinitions.EXT_TARGET_ID) || r.hasExtension(ExtensionDefinitions.EXT_TARGET_PATH)) {
  @Override
  public void renderReference(RenderingStatus status, XhtmlNode x, ResourceWrapper type) throws FHIRFormatError, DefinitionException, IOException {
    if (type == null) {
      return;
    }
    xlinkNarrative(x, type);
    ResourceWrapper display = null;
    ResourceWrapper actual = null;
    ResourceWrapper id = null;
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
        if (Utilities.isAbsoluteUrlLinkable(actual.primitiveValue()) || (isLocalReference(actual.primitiveValue()) && !context.isUnknownLocalReferencesNotLinks())) {
          x.ah(context.prefixLocalHref(actual.primitiveValue())).tx(disp);
        } else {
          x.code().tx(disp);
        }
      } else if (rr.getResource() == null) {
        String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : rr.getUrlReference();
        x.ah(context.prefixLocalHref(rr.getWebPath())).tx(disp);
      } else if (rr.getResource() != null) {
        String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : RendererFactory.factory(rr.getResource(), context.forContained()).buildSummary(rr.getResource());
        x.ah(context.prefixLocalHref(rr.getWebPath())).tx(disp);
      } else {
        String disp = display != null && display.hasPrimitiveValue() ? displayDataType(display) : "?rref2?";
        x.ah(context.prefixLocalHref(rr.getWebPath())).tx(disp);
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
      x.tx("?rref?");
    }
    checkRenderExtensions(status, x, type);
  }
  
 
  private boolean isLocalReference(String url) {
    if (url == null) {
      return false;
    }
    if (url.contains("/_history")) {
      url = url.substring(0, url.indexOf("/_hist"));
    }
    
    if (url.matches(Constants.LOCAL_REF_REGEX)) {
      return true;
    } else {
      return false;
    }
  }

  public void renderReference(ResourceWrapper res, HierarchicalTableGenerator gen, List<Piece> pieces, Reference r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) { 
      pieces.add(gen.new Piece(null, "null!", null));
      return;
    }
    ResourceWithReference tr = null;
    String link = null;
    StringBuilder text = new StringBuilder();
    if (r.hasReferenceElement() && allowLinks) {
      tr = resolveReference(res, r.getReference(), true);

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
        text.append("?r-ref?");        
      }
    } else if (context.isTechnicalMode()) {
      text.append(r.getReference());
      if (display != null) {
        text.append(": "+display);
      }
      if ((tr == null || (tr.getWebPath() != null && !tr.getWebPath().startsWith("#"))) && name != null) {
        text.append(" \""+name+"\"");
      }
      if (r.hasExtension(ExtensionDefinitions.EXT_TARGET_ID) || r.hasExtension(ExtensionDefinitions.EXT_TARGET_PATH)) {
        text.append("(");
        for (Extension ex : r.getExtensionsByUrl(ExtensionDefinitions.EXT_TARGET_ID)) {
          if (ex.hasValue()) {
            text.append(", ");
            text.append("#"+ex.getValue().primitiveValue());
          }
        }
        for (Extension ex : r.getExtensionsByUrl(ExtensionDefinitions.EXT_TARGET_PATH)) {
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
  
  public void renderReference(ResourceWrapper res, HierarchicalTableGenerator gen, List<Piece> pieces, ResourceWrapper r, boolean allowLinks) throws UnsupportedEncodingException, IOException {
    if (r == null) { 
      pieces.add(gen.new Piece(null, "null!", null));
      return;
    }
    ResourceWithReference trt = null;
    String link = null;
    StringBuilder text = new StringBuilder();
    if (r.has("reference") && allowLinks) {
      trt = resolveReference(res, r.primitiveValue("reference"), true);

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
        text.append("?r-ref2?");        
      }
    } else if (context.isTechnicalMode()) {
      text.append(r.primitiveValue("reference"));
      if (display != null) {
        text.append(": "+display);
      }
      if ((trt == null || (trt.getWebPath() != null && !trt.getWebPath().startsWith("#"))) && name != null) {
        text.append(" \""+name+"\"");
      }
      if (r.hasExtension(ExtensionDefinitions.EXT_TARGET_ID) || r.hasExtension(ExtensionDefinitions.EXT_TARGET_PATH)) {
        text.append("(");
        for (ResourceWrapper ex : r.extensions(ExtensionDefinitions.EXT_TARGET_ID)) {
          if (ex.has("value")) {
            text.append(", ");
            text.append("#"+ex.primitiveValue("value"));
          }
        }
        for (ResourceWrapper ex : r.extensions(ExtensionDefinitions.EXT_TARGET_PATH)) {
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
  
  protected String getNameForResource(ResourceWrapper resource) {
    ResourceWrapper name = resource.firstChild("name");
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

  protected void renderUri(RenderingStatus status, ResourceWrapper resource, XhtmlNode x, UriType uri) throws FHIRFormatError, DefinitionException, IOException { 
    if (!renderPrimitiveWithNoValue(status, x, uri)) {
      String v = uri.primitiveValue();

      if (v.startsWith("mailto:")) { 
        x.ah(context.prefixLocalHref(v)).addText(v.substring(7)); 
      } else { 
        ResourceWithReference rr = resolveReference(resource, uri.primitiveValue(), false);
        if (rr != null) {
          x.ah(rr.getWebPath()).addText(RendererFactory.factory(rr.getResource(), context.forContained()).buildSummary(rr.getResource()));           
        } else {
          Resource r = context.getContext().fetchResource(Resource.class, v); 
          if (r != null && r.getWebPath() != null) { 
              x.ah(context.prefixLocalHref(r.getWebPath())).addText(RendererFactory.factory(r, context.forContained()).buildSummary(wrap(r)));           
          } else { 
            String url = context.getResolver() != null ? context.getResolver().resolveUri(context, v) : null; 
            if (url != null) {           
              x.ah(context.prefixLocalHref(url)).addText(v); 
            } else if (Utilities.isAbsoluteUrlLinkable(v) && !uri.fhirType().equals("id")) { 
              x.ah(context.prefixLocalHref(v)).addText(v); 
            } else { 
              x.addText(v); 
            } 
          } 
        }
      } 
    }
  } 
  
  @Override
  protected void renderUri(RenderingStatus status, XhtmlNode x, ResourceWrapper uri) throws FHIRFormatError, DefinitionException, IOException { 
    if (!renderPrimitiveWithNoValue(status, x, uri)) {
      String v = uri.primitiveValue();
      boolean local = false;

      if (context.getContextUtilities().isResource(v)) {
        v = "http://hl7.org/fhir/StructureDefinition/"+v;
        local = true;
      }
      if (v.startsWith("mailto:")) { 
        x.ah(v).addText(v.substring(7)); 
      } else { 
        String link = getLinkForCode(v, null, null, uri.getResourceNative());
        if (link != null) {  
          x.ah(context.prefixLocalHref(link)).addText(v);
        } else {
        ResourceWithReference rr = local ? resolveReference(uri.resource(), v, true) : resolveReference(uri);
        if (rr != null) {
          if (rr.getResource() == null) {
            x.ah(context.prefixLocalHref(rr.getWebPath())).addText(rr.getUrlReference());
          } else {
            x.ah(context.prefixLocalHref(rr.getWebPath())).addText(RendererFactory.factory(rr.getResource(), context.forContained()).buildSummary(rr.getResource()));
          }
        } else {
          Resource r = context.getContext().fetchResource(Resource.class, v); 
          if (r != null && r.getWebPath() != null) { 
              x.ah(context.prefixLocalHref(r.getWebPath())).addText(RendererFactory.factory(r, context.forContained()).buildSummary(wrap(r)));           
          } else if (r != null) { 
            x.ah(context.prefixLocalHref(v)).addText(RendererFactory.factory(r, context.forContained()).buildSummary(wrap(r)));           
          } else { 
            String url = context.getResolver() != null ? context.getResolver().resolveUri(context, v) : null; 
            if (url != null) {           
              x.ah(context.prefixLocalHref(url)).addText(v); 
            } else if (Utilities.isAbsoluteUrlLinkable(v) && !uri.fhirType().equals("id")) { 
              x.ah(context.prefixLocalHref(v)).addText(v); 
            } else { 
              x.addText(v); 
            } 
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
  protected <T extends Resource> T findCanonical(Class<T> class_, UriType canonical, ResourceWrapper sourceOfReference) {
    return context.getContext().fetchResource(class_, canonical.asStringValue(), null, sourceOfReference.getResourceNative());
  }

  protected <T extends Resource> T findCanonical(Class<T> class_, String canonical, ResourceWrapper sourceOfReference) {
    return context.getContext().fetchResource(class_, canonical, null, sourceOfReference.getResourceNative());
  }


  private ResourceWithReference resolveContained(ResourceWrapper resource, String url) {
    ResourceWrapper container = findContainer(resource);
    if (container == null) {
      return null;
    } else if ("#".equals(url)) {
      return new ResourceWithReference(ResourceReferenceKind.CONTAINER, url, "#hc"+container.getScopedId(), container);
    } else {
      String tid = url.substring(1);
      for (ResourceWrapper c : container.children("contained")) {
        if (tid.equals(c.getId())) {
          return new ResourceWithReference(ResourceReferenceKind.CONTAINED, url, "#hc"+c.getScopedId(), c);
        }
      }
    }
    return null;
  }
  
  private ResourceWrapper findContainer(ResourceWrapper resource) {
    ResourceWrapper container = resource;
    while (container != null) {
      if (container.isResource() && container.kind() != ElementKind.ContainedResource) {
        break;
      }
      container = container.parent();
    }
    return container;
  }

  private ResourceWithReference resolveOutside(ResourceWrapper resource, String url, String version, boolean followLinks) throws IOException {
    ResourceWrapper container = findContainer(resource);
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
    if (followLinks) {
      // ok, we didn't find it in the current instance, so we go look elsewhere 
      if (context.getResolver() != null) {
        ResourceWithReference rr = context.getResolver().resolve(context, url, version);
        if (rr != null) {
          return rr;
        }
      }
      Resource r = context.getWorker().fetchResource(Resource.class, url, version, resource == null ? null : resource.getResourceNative());
      if (r != null) {
        return new ResourceWithReference(ResourceReferenceKind.EXTERNAL, url, r.getWebPath(), wrap(r));
      }
    }
    return null;
  }
  
  private ResourceWithReference findInBundle(ResourceWrapper resource, String url) {
    if (url.equals("Bundle/"+resource.getId())) {
      return new ResourceWithReference(ResourceReferenceKind.BUNDLE, url, "#"+resource.getScopedId(), resource);
    }
    for (ResourceWrapper entry : resource.children("entry")) {
      if (entry.has("resource")) {
        ResourceWrapper res = entry.child("resource");  
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

  protected ResourceWithReference resolveReference(ResourceWrapper resource, String url, boolean followLinks) throws IOException {
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
      
      return resolveOutside(resource, url, version, followLinks);
    }

  }

  protected ResourceWithReference resolveReference(ResourceWrapper reference) {
    try {
      if (reference.fhirType().equals("CodeableReference")) {
        if (reference.has("reference")) {
          return resolveReference(reference.child("reference"));
        } else {
          return null;
        }
      } else if (reference.fhirType().equals("Reference")) {
        return resolveReference(reference.getResourceWrapper(), reference.primitiveValue("reference"), true);
      } else {
        return resolveReference(reference.getResourceWrapper(), reference.primitiveValue(), true);
      }
    } catch (IOException e) {
      if (context.isDebug()) {
        e.printStackTrace();        
      }
      return null;
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

  protected void generateCopyright(XhtmlNode x, ResourceWrapper cs) {
    XhtmlNode p = x.para();
    p.b().tx(getContext().formatPhrase(RenderingContext.RESOURCE_COPYRIGHT));
    p.addTextWithLineBreaks(" " + context.getTranslated(cs.child("copyright")));
  }
  
  protected void generateCopyrightTableRow(XhtmlNode tbl, ResourceWrapper cs) {
    XhtmlNode tr = tbl.tr();
    tr.td().b().tx(getContext().formatPhrase(RenderingContext.RESOURCE_COPYRIGHT));
    tr.td().addTextWithLineBreaks(" " + context.getTranslated(cs.child("copyright")));
  }

  public String displayReference(Resource res, Reference r) throws UnsupportedEncodingException, IOException {
    return (context.formatPhrase(RenderingContext.GENERAL_TODO)); 
   }

   public Base parseType(String string, String type) {
     return null;
   }

   protected String describeStatus(PublicationStatus status, boolean experimental) {
     switch (status) {
     case ACTIVE: return experimental ? (context.formatPhrase(RenderingContext.GENERAL_EXPER)) : (context.formatPhrase(RenderingContext.RES_REND_ACT)); 
     case DRAFT: return (context.formatPhrase(RenderingContext.RES_REND_DRAFT));
     case RETIRED: return (context.formatPhrase(RenderingContext.RES_REND_RET));
     default: return (context.formatPhrase(RenderingContext.RES_REND_UNKNOWN));
     }
   }

   protected void renderCommitteeLink(XhtmlNode x, CanonicalResource cr) {
     String code = ExtensionUtilities.readStringExtension(cr, ExtensionDefinitions.EXT_WORKGROUP);
     CodeSystem cs = context.getWorker().fetchCodeSystem("http://terminology.hl7.org/CodeSystem/hl7-work-group");
     if (cs == null || !cs.hasWebPath())
       x.tx(code);
     else {
       ConceptDefinitionComponent cd = CodeSystemUtilities.findCode(cs.getConcept(), code);
       if (cd == null) {
         x.tx(code);
       } else {
         x.ah(context.prefixLocalHref(cs.getWebPath()+"#"+cs.getId()+"-"+cd.getCode())).tx(cd.getDisplay());
       }
     }
   }

   public static String makeInternalBundleLink(ResourceWrapper bundle, String fullUrl) {
     // are we in a bundle in a bundle? Then the link is scoped
     boolean inBundle = false;
     ResourceWrapper rw = bundle.parent();
     while (rw != null) {
       if (rw.fhirType().equals("Bundle")) {
         inBundle = true;
       }
       rw = rw.parent();
      }
     if (inBundle) {
       return bundle.getScopedId()+"/"+fullUrl.replace(":", "-");
     } else {
       return fullUrl.replace(":", "-");
     }
   }

  public boolean canRender(Resource resource) {
    return true;
  }

  protected XhtmlNode renderResourceTechDetails(ResourceWrapper r, XhtmlNode x) throws UnsupportedEncodingException, FHIRException, IOException {
    return renderResourceTechDetails(r, x, (context.isContained() && r.getId() != null ? "#"+r.getId() : r.getId()));
  }
  
  protected XhtmlNode renderResourceTechDetails(ResourceWrapper r, XhtmlNode x, String id) throws UnsupportedEncodingException, FHIRException, IOException {
    XhtmlNode p = x.para().attribute("class", "res-header-id");
    markGenerated(p);
    if (!context.isNoHeader()) {
      String ft = context.getTranslatedCode(r.fhirType(), VersionUtilities.getResourceTypesUrl(context.getContext().getVersion()));
      if (id == null) { 
        p.b().tx(context.formatPhrase(context.isTechnicalMode() && !isInner() ? RenderingContext.PROF_DRIV_GEN_NARR_TECH : RenderingContext.PROF_DRIV_GEN_NARR, ft, ""));      
      } else {
        p.b().tx(context.formatPhrase(context.isTechnicalMode() && !isInner() ? RenderingContext.PROF_DRIV_GEN_NARR_TECH : RenderingContext.PROF_DRIV_GEN_NARR, ft, id));
      }
    }

    // first thing we do is lay down the resource anchors. 
    if (!Utilities.noString(r.getId())) {
      String sid = r.getScopedId();
      if (sid != null && !willRenderId(r)) {
        if (!context.hasAnchor(sid)) {
          context.addAnchor(sid);
          x.an(context.prefixAnchor(sid));
        }
        sid = "hc"+sid;
        if (!context.hasAnchor(sid)) {
          context.addAnchor(sid);
          x.an(context.prefixAnchor(sid));
        }
      }
    }

    if (context.isTechnicalMode()) {
      RenderingStatus status = new RenderingStatus();

      String lang = r.primitiveValue("language"); 
      String ir = r.primitiveValue("implicitRules"); 
      ResourceWrapper meta = r.has("meta") && !r.child("meta").isEmpty() ? r.child("meta") : null;
      ResourceWrapper versionId = meta == null ? null : meta.child("versionId");
      ResourceWrapper lastUpdated = meta == null ? null : meta.child("lastUpdated");
      ResourceWrapper source = meta == null ? null : meta.child("source");

      if (lang != null || versionId != null || lastUpdated != null || ir != null || source != null || meta != null) {
        XhtmlNode div = x.div().style("display: inline-block").style("background-color: #d9e0e7").style("padding: 6px")
            .style("margin: 4px").style("border: 1px solid #8da1b4")
            .style("border-radius: 5px").style("line-height: 60%");

        boolean sfirst = true;
        p = plateStyle(div.para());
        if (versionId != null) {
          p.tx(context.formatPhrase(RenderingContext.RES_REND_VER, versionId.primitiveValue()));
          sfirst = false;
        }
        if (lastUpdated != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          p.tx(context.formatPhrase(RenderingContext.RES_REND_UPDATED, displayDataType(lastUpdated)));
          sfirst = false;
        }
        if (lang != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          p.tx(context.formatPhrase(RenderingContext.RES_REND_LANGUAGE, lang));
          sfirst = false;
        }
        if (source != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          XhtmlNode pp = plateStyle(div.para());
          pp.startScript("source");
          renderDataType(status, pp.param("source"), source);
          pp.execScript(context.formatPhrase(RenderingContext.RES_REND_INFO_SOURCE));
          pp.closeScript();
          sfirst = false;
        }
        if (ir != null) {
          if (!sfirst) {
            p.tx("; ");
          }
          plateStyle(div.para()).b().tx(context.formatPhrase(RenderingContext.RES_REND_SPEC_RULES, ir));     
          sfirst = false;
        }
        if (meta != null) {
          List<ResourceWrapper> items = meta.children("profile");
          if (!items.isEmpty()) {
            p = plateStyle(div.para());
            p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_PROF), items.size())+": ");
            boolean first = true;
            for (ResourceWrapper bw : items) {
              if (first) first = false; else p.tx(", ");
              renderCanonical(status, p, StructureDefinition.class, bw);
            }
          }
          items = meta.children("tag");
          if (!items.isEmpty()) {
            p = plateStyle(div.para());
            p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.RES_REND_TAG), items.size())+": ");
            boolean first = true;
            for (ResourceWrapper bw : items) {
              if (first) first = false; else p.tx(", ");
              renderCoding(status, p, bw);
            }        
          }
          items = meta.children("security");
          if (!items.isEmpty()) {
            p = plateStyle(div.para());
            p.tx(Utilities.pluralize(context.formatPhrase(RenderingContext.GENERAL_SECURITY_LABEL), items.size())+": ");
            boolean first = true;
            for (ResourceWrapper bw : items) {
              if (first) first = false; else p.tx(", ");
              renderCoding(status, p, bw);
            }        
          }
        }
        return div;
      }
    }
    return null;
  }

  protected boolean willRenderId(ResourceWrapper r) {
    return false;
  }

  protected XhtmlNode plateStyle(XhtmlNode para) {
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
    private Map<String, List<ResourceWrapper>> cols = new HashMap<>();
    private TableData data;
    
    public void value(String name, ResourceWrapper value) {
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

    public List<ResourceWrapper> get(String name) {
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
      XhtmlNode table = x.table("grid", false).markGenerated(!context.forValidResource());
      
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
          List<ResourceWrapper> list = row.get(col);
          if (list != null) {
            for (ResourceWrapper value : list) {
              if (first) first = false; else td.tx(", ");
              renderDataType(status, td, value);
            }
          }
        }
      }      
    }
  }
  
  public void renderOrError(ResourceWrapper dr) throws IOException {
    try {
      renderResource(dr);
    } catch (Exception e) {
      XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
      x.para().tx("Error rendering: " + e.getMessage());
      inject(dr, x, NarrativeStatus.GENERATED);
    }
  }
  

  public boolean genSummaryTable(RenderingStatus status, XhtmlNode x, ResourceWrapper cr) throws IOException {
    if (context.isShowSummaryTable() && cr != null) {
      XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      genSummaryTableContent(status, tbl, cr);
      return true;
    } else {
      return false;
    }
  }
  

  protected void genSummaryTableContent(RenderingStatus status, XhtmlNode tbl, ResourceWrapper cr) throws IOException {
    XhtmlNode tr;
    if (cr.has("url")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL)+":");
      xlinkNarrative(tr.td(), cr.child("url")).code().tx(cr.primitiveValue("url"));
    } else if (cr.hasExtension(EXT_NS_URL)) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL)+":");
      xlinkNarrative(tr.td(), cr.extension(EXT_NS_URL)).code().tx(cr.extensionString(EXT_NS_URL));
    } else if (!context.isContained()) {                                          
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL));
      tr.td();      
    }
    if (cr.has("version")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_VER)+":");
      renderDataType(status, tr.td(), cr.child("version"));
    } else if (cr.hasExtension("http://terminology.hl7.org/StructureDefinition/ext-namingsystem-version")) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_VER)+":");
      renderDataType(status, tr.td(), cr.extensionValue("http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.version"));
    }

    String name = context.getTranslated(cr.child("name"));
    String title = context.getTranslated(cr.child("title"));
    
    if (name != null) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_NAME)+":");
      xlinkNarrative(tr.td(), cr.child("name")).tx(name);
    }
    
    if (title != null && !title.equalsIgnoreCase(name)) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_TITLE)+":");
      xlinkNarrative(tr.td(), cr.child("title")).tx(title);
    }

    if (cr.has("status") && !context.isContained()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_STATUS)+":");
      xlinkNarrative(tr.td(), cr.child("status")).tx(describeStatus(status, cr));
    }

    if (cr.has("description")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINITION)+":");
      xlinkNarrative(tr.td(), cr.child("description")).markdown(context.getTranslated(cr.child("description")), "description");
    }

    if (cr.has("publisher")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CANON_REND_PUBLISHER)+":");
      buildPublisherLinks( tr.td(), cr);
    }
    
    if (cr.hasExtension(ExtensionDefinitions.EXT_WORKGROUP)) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CANON_REND_COMMITTEE)+":");
      renderCommitteeLink(tr.td(), cr);
    }

    if (cr.has("copyright")) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_COPYRIGHT)+":");
      xlinkNarrative(tr.td(), cr.child("copyright")).markdown(context.getTranslated(cr.child("copyright")), "copyright");
    }
    
    if (cr.hasExtension(ExtensionDefinitions.EXT_FMM_LEVEL)) {
      status.setExtensions(true);
      // Use hard-coded spec link to point to current spec because DSTU2 had maturity listed on a different page
      tr = tbl.tr();
      markBoilerplate(tr.td()).ah("http://hl7.org/fhir/versions.html#maturity", "Maturity Level").attribute("class", "fmm").tx(context.formatPhrase(RenderingContext.CANON_REND_COMMITTEE)+":");
      renderDataType(status, tr.td(), cr.extensionValue(ExtensionDefinitions.EXT_FMM_LEVEL));
    }    
  }



  public void genSummaryTable(RenderingStatus status, XhtmlNode x, CanonicalResource cr) throws IOException {
    if (context.isShowSummaryTable() && cr != null) {
      XhtmlNode tbl = x.table("grid", false).markGenerated(!context.forValidResource());
      genSummaryTableContent(status, tbl, cr);
    }
  }

  
  protected void genSummaryTableContent(RenderingStatus status, XhtmlNode tbl, CanonicalResource cr) throws IOException {
    XhtmlNode tr;
    if (cr.hasUrl()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL)+":");
      tr.td().code().tx(cr.getUrl());
    } else if (cr.hasExtension(EXT_NS_URL)) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL));
      tr.td().code().tx(ExtensionUtilities.readStringExtension(cr, EXT_NS_URL)+":");
    } else if (!context.isContained()) {                                          
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINING_URL));
      tr.td();      
    }
    if (cr.hasVersion()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_VER)+":");
      tr.td().tx(cr.getVersion());
    } else if (cr.hasExtension("http://terminology.hl7.org/StructureDefinition/ext-namingsystem-version")) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_VER)+":");
      tr.td().tx(ExtensionUtilities.readStringExtension(cr, "http://hl7.org/fhir/5.0/StructureDefinition/extension-NamingSystem.version"));
    }

    String name = cr.hasName() ? context.getTranslated(cr.getNameElement()) : null;
    String title = cr.hasTitle() ? context.getTranslated(cr.getTitleElement()) : null;
    
    if (name != null) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_NAME)+":");
      tr.td().tx(name);
    }
    
    if (title != null && !title.equalsIgnoreCase(name)) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_TITLE)+":");
      tr.td().tx(title);
    }

    if (cr.hasStatus() && !context.isContained()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_STATUS)+":");
      tr.td().tx(describeStatus(status, cr));
    }

    if (cr.hasDescription()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_DEFINITION)+":");
      tr.td().markdown(cr.getDescription(), "description");
    }

    if (cr.hasPublisher()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CANON_REND_PUBLISHER)+":");
      buildPublisherLinks(tr.td(), cr);
    }
    
    if (cr.hasExtension(ExtensionDefinitions.EXT_WORKGROUP)) {
      status.setExtensions(true);
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.CANON_REND_COMMITTEE)+":");
      renderCommitteeLink(tr.td(), cr);
    }

    if (cr.hasCopyright()) {
      tr = tbl.tr();
      markBoilerplate(tr.td()).tx(context.formatPhrase(RenderingContext.GENERAL_COPYRIGHT)+":");
      tr.td().markdown(cr.getDescription(), "copyright");      
    }
    
    if (ExtensionUtilities.hasExtension(cr, ExtensionDefinitions.EXT_FMM_LEVEL)) {
      status.setExtensions(true);
      // Use hard-coded spec link to point to current spec because DSTU2 had maturity listed on a different page
      tr = tbl.tr();
      markBoilerplate(tr.td()).ah("http://hl7.org/fhir/versions.html#maturity", "Maturity Level").attribute("class", "fmm").tx(context.formatPhrase(RenderingContext.CANON_REND_COMMITTEE)+":");
      tr.td().tx(ExtensionUtilities.readStringExtension(cr, ExtensionDefinitions.EXT_FMM_LEVEL));
    }    
  }


  protected void renderCommitteeLink(XhtmlNode x, ResourceWrapper cr) {
    String code = cr.extensionString(ExtensionDefinitions.EXT_WORKGROUP);
    CodeSystem cs = context.getContext().fetchCodeSystem("http://terminology.hl7.org/CodeSystem/hl7-work-group");
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
  
  private void buildPublisherLinks(XhtmlNode x, CanonicalResource cr) {
    boolean useName = false;
    for (ContactDetail cd : cr.getContact()) {
      if (!cd.hasName()) {
        useName = true;
      }
    }
    boolean first = true;
    if (!useName) {
      x.tx(Utilities.escapeXml(cr.getPublisher())); 
      first = false;          
    }    
    for (ContactDetail cd : cr.getContact()) {
      String name = cd.hasName() ? cd.getName() : cr.getPublisher();
      if (cd.hasTelecom()) {
        if (first) first = false; else x.tx(". ");
        renderContact(x, name, cd.getTelecom());
      }
    }
  }

  private void buildPublisherLinks(XhtmlNode x, ResourceWrapper cr) {
    boolean useName = false;
    for (ResourceWrapper cd : cr.children("contact")) {
      if (!cd.has("name")) {
        useName = true;
      }
    }
    boolean first = true;
    if (!useName) {
      x.tx(Utilities.escapeXml(cr.primitiveValue("publisher")));
      first = false;          
    }    
    for (ResourceWrapper cd : cr.children("contact")) {
      String name = cd.has("name") ? cd.primitiveValue("name") : cr.primitiveValue("publisher");
      if (cd.has("telecom")) {
        if (first) first = false; else x.tx(". ");
        renderContactW(spanIfTracking(x, cd), name, cd.children("telecom"));
      }
    }
  }
  

  private void renderContactW(XhtmlNode x, String name, List<ResourceWrapper> telecom) {
    List<String> urls = new ArrayList<>();
    for (ResourceWrapper t : telecom) {
      if ("url".equals(t.primitiveValue()) && t.has("value")) {
        urls.add(t.primitiveValue("value"));
      }
    }
    if (urls.size() == 1) {
      x.ah(urls.get(0)).tx(name);
    } else { // if (urls.size() == 0) {
      x.tx(name);
    } 
    for (ResourceWrapper t : telecom) {
      String system = t.primitiveValue("system");
      String value = t.primitiveValue("value"); 
      if ("url".equals(system) && value != null && urls.size() != 1) {
        x.tx(", ");
        x.ah(t.primitiveValue("value")).tx("Link");
      }
      if ("email".equals(system) && value != null) {
        x.tx(", ");
        x.ah("mailto:"+t.primitiveValue("value")).tx("Email");
      }
      if ("phone".equals(system) && value != null) {
        x.tx(", ");
        x.tx(t.primitiveValue("value"));
      }
      if ("fax".equals(system) && value != null) {
        x.tx(", ");
        x.tx("Fax:"+t.primitiveValue("value"));
      }
    } 
  }

  private void renderContact(XhtmlNode x, String name, List<ContactPoint> telecom) {
    List<String> urls = new ArrayList<>();
    for (ContactPoint t : telecom) {
      if (t.getSystem() == ContactPointSystem.URL && t.hasValue()) {
        urls.add(t.getValue());
      }
    }
    if (urls.size() == 1) {
      x.ah(urls.get(0)).tx(name);
    } else { // if (urls.size() == 0) {
      x.tx(name);
    } 
    for (ContactPoint t : telecom) {
      if (t.getSystem() == ContactPointSystem.URL && t.hasValue() && urls.size() != 1) {
        x.tx(", ");
        x.ah(t.getValue()).tx("Link");
      }
      if (t.getSystem() == ContactPointSystem.EMAIL && t.hasValue()) {
        x.tx(", ");
        x.ah("mailto:"+t.getValue()).tx("Email");
      }
      if (t.getSystem() == ContactPointSystem.PHONE && t.hasValue()) {
        x.tx(", ");
        x.tx(t.getValue());
      }
      if (t.getSystem() == ContactPointSystem.FAX && t.hasValue()) {
        x.tx(", ");
        x.tx("Fax:"+t.getValue());
      }
    } 
  }

  protected String describeStatus(RenderingStatus status, ResourceWrapper cr) {
    String s = describeStatus(cr.primitiveValue("status"), cr.primitiveValue("experimental"), cr.child("date"), cr.extensionString("http://hl7.org/fhir/StructureDefinition/valueset-deprecated"));
    if (cr.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) {
      status.setExtensions(true);
      s = s + presentStandardsStatus(cr.extensionString(ExtensionDefinitions.EXT_STANDARDS_STATUS));
    }
    return s;
  }

  protected String describeStatus(RenderingStatus status, CanonicalResource cr) {
    String s = describeStatus(cr.getStatus(), cr.hasExperimental() ? cr.getExperimental() : false, cr.hasDate() ? cr.getDateElement() : null, ExtensionUtilities.readBooleanExtension(cr, "http://hl7.org/fhir/StructureDefinition/valueset-deprecated"));
    if (cr.hasExtension(ExtensionDefinitions.EXT_STANDARDS_STATUS)) {
      status.setExtensions(true);
      s = s + presentStandardsStatus(ExtensionUtilities.readStringExtension(cr, ExtensionDefinitions.EXT_STANDARDS_STATUS));
    }
    return s;
  }

  private String presentStandardsStatus(String code) {
    String pfx = " (<a href=\"http://hl7.org/fhir/codesystem-standards-status.html#"+code+"\">Standards Status</a>: ";
    switch (code) {
    case "draft" : return pfx+"Draft)"; 
    case "normative" : return pfx+"Normative)"; 
    case "trial-use" : return pfx+"Trial Use)"; 
    case "informative" : return pfx+"Informative)"; 
    case "deprecated" : return pfx+"<span style=\"color: maroon; font-weight: bold\">Deprecated</span>)"; 
    case "external" : return pfx+"External)"; 
    }
    return "";
  }

  protected String describeStatus(PublicationStatus status, boolean experimental, DateTimeType dt, Boolean deprecated) {
    String sfx = dt != null ? " as of "+displayDataType(dt) : "";
    if (deprecated != null && deprecated) {
      if (status == PublicationStatus.RETIRED) {
        return "Deprecated + Retired"+sfx;
      } else {
        return "Deprecated"+sfx; 
      }
    } else {
      switch (status) {
      case ACTIVE: return (experimental ? "Experimental" : "Active")+sfx; 
      case DRAFT: return "Draft"+sfx;
      case RETIRED: return "Retired"+sfx;
      default: return "Unknown"+sfx;
      }
    }
  }

  protected String describeStatus(String status, String experimental, ResourceWrapper dt, String deprecated) {
    String sfx = dt != null ? " as of "+displayDataType(dt) : "";
    if ("true".equals(deprecated)) {
      if ("retired".equals(status)) {
        return "Deprecated + Retired"+sfx;
      } else {
        return "Deprecated"+sfx; 
      }
    } else {
      switch (status) {
      case "active": return ("true".equals(experimental) ? "Experimental" : "Active")+sfx; 
      case "draft": return "Draft"+sfx;
      case "retired": return "Retired"+sfx;
      default: return "Unknown"+sfx;
      }
    }
  }
  protected void addContained(RenderingStatus status, XhtmlNode x, List<ResourceWrapper> list) throws FHIRFormatError, DefinitionException, FHIRException, IOException, EOperationOutcome {
    for (ResourceWrapper c : list) {
      x.hr();
      String id = c.getScopedId();
      if (!context.hasAnchor(id)) {
        context.addAnchor(id);
        x.an(context.prefixAnchor(id));
      }
      RendererFactory.factory(c, context.forContained()).setInner(true).buildNarrative(status, x, c);
    }
  }

  protected void selfLink(XhtmlNode node, String link) {
    XhtmlNode a = node.addTag("a");
    if (node.hasAttribute("class"))
      node.setAttribute("class", node.getAttribute("class")+" self-link-parent");
    else
      node.setAttribute("class", "self-link-parent");
    a.setAttribute("href", "#"+link);
    a.setAttribute("title", "link to here");
    a.setAttribute("class", "self-link");
    XhtmlNode svg = a.addTag("svg");
    XhtmlNode path = svg.addTag("path");
    String pathData = "M1520 1216q0-40-28-68l-208-208q-28-28-68-28-42 0-72 32 3 3 19 18.5t21.5 21.5 15 19 13 25.5 3.5 27.5q0 40-28 68t-68 28q-15 0-27.5-3.5t-25.5-13-19-15-21.5-21.5-18.5-19q-33 31-33 73 0 40 28 68l206 207q27 27 68 27 40 0 68-26l147-146q28-28 28-67zm-703-705q0-40-28-68l-206-207q-28-28-68-28-39 0-68 27l-147 146q-28 28-28 67 0 40 28 68l208 208q27 27 68 27 42 0 72-31-3-3-19-18.5t-21.5-21.5-15-19-13-25.5-3.5-27.5q0-40 28-68t68-28q15 0 27.5 3.5t25.5 13 19 15 21.5 21.5 18.5 19q33-31 33-73zm895 705q0 120-85 203l-147 146q-83 83-203 83-121 0-204-85l-206-207q-83-83-83-203 0-123 88-209l-88-88q-86 88-208 88-120 0-204-84l-208-208q-84-84-84-204t85-203l147-146q83-83 203-83 121 0 204 85l206 207q83 83 83 203 0 123-88 209l88 88q86-88 208-88 120 0 204 84l208 208q84 84 84 204z";
    svg.attribute("height", "20").attribute("width", "20").attribute("viewBox", "0 0 1792 1792").attribute("class", "self-link");
    path.attribute("d", pathData).attribute("fill", "navy");
  }


  public static void renderVersionReference(RenderingContext context, Resource tgt, String statedVersion, String actualVersion, boolean fromPackages, XhtmlNode x, boolean fromThisPackage, String type, String none_phrase) {
    if (statedVersion != null && actualVersion != null && !statedVersion.equals(actualVersion) && fromPackages) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_WILDCARD_BY_PACKAGE, statedVersion, actualVersion));
      x.tx("\uD83D\uDCCD");
      x.tx(actualVersion);
      x.tx(" → ");
      x.tx(statedVersion);
    } else if (statedVersion != null && actualVersion != null && !statedVersion.equals(actualVersion) && fromPackages) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_WILDCARD, statedVersion, actualVersion));
      x.tx("\uD83D\uDCCD");
      x.tx(actualVersion);
      XhtmlNode span = x.span();
      span.style("opacity: 0.5");
      span.tx(" → ");
      span.tx(statedVersion);
    } else if (statedVersion != null) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_STATED, statedVersion));
      x.tx("\uD83D\uDCCD");
      x.tx(actualVersion);
    } else if (fromThisPackage) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_THIS_PACKAGE));
      x.tx("\uD83D\uDCE6");
      x.tx(actualVersion);
    } else if (fromPackages) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_BY_PACKAGE, actualVersion));
      x.tx("\uD83D\uDCE6");
      x.tx(actualVersion);
    } else if (actualVersion != null) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_FOUND, actualVersion));
      x.style("opacity: 0.5");
      x.tx("\u23FF");
      x.tx(actualVersion);
    } else if (tgt != null) {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_NONE, type));
      x.tx("\u2205");
      x.tx(actualVersion);
    } else {
      x.attribute("title", context.formatPhrase(RenderingI18nContext.VS_VERSION_NOTHING, type));
      x.tx(none_phrase == null ? "?" : context.formatPhrase(none_phrase));
    }
  }

};