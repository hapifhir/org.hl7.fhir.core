package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Narrative;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.DirectWrappers.ResourceWrapperDirect;
import org.hl7.fhir.r5.renderers.utils.ElementWrappers.ResourceWrapperMetaElement;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceWithReference;
import org.hl7.fhir.r5.utils.XVerExtensionManager;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public abstract class ResourceRenderer extends DataRenderer {

  protected ResourceContext rcontext;
  protected XVerExtensionManager xverManager;
  
  
  public ResourceRenderer(RenderingContext context) {
    super(context);
  }

  public ResourceRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context);
    this.rcontext = rcontext;
  }

  /**
   * given a resource, update it's narrative with the best rendering available
   * 
   * @param r - the domain resource in question
   * 
   * @throws FHIRFormatError
   * @throws DefinitionException
   * @throws IOException
   */
  
  public void render(DomainResource r) throws FHIRFormatError, DefinitionException, IOException {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasExtensions = render(x, r);
    inject(r, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public abstract boolean render(XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException;
  
  public void describe(XhtmlNode x, DomainResource r) throws UnsupportedEncodingException, IOException {
    x.tx(display(r));
  }

  public abstract String display(DomainResource r) throws UnsupportedEncodingException, IOException;

  
  protected void inject(DomainResource r, XhtmlNode x, NarrativeStatus status) {
    if (!x.hasAttribute("xmlns"))
      x.setAttribute("xmlns", "http://www.w3.org/1999/xhtml");
    if (r.hasLanguage()) {
      // use both - see https://www.w3.org/TR/i18n-html-tech-lang/#langvalues
      x.setAttribute("lang", r.getLanguage());
      x.setAttribute("xml:lang", r.getLanguage());
    }
    if (!r.hasText() || !r.getText().hasDiv() || r.getText().getDiv().getChildNodes().isEmpty()) {
      r.setText(new Narrative());
      r.getText().setDiv(x);
      r.getText().setStatus(status);
    } else {
      XhtmlNode n = r.getText().getDiv();
      n.hr();
      n.getChildNodes().addAll(x.getChildNodes());
    }
  }

  public void renderReference(Resource res, XhtmlNode x, Reference r) throws UnsupportedEncodingException, IOException {
    ResourceWrapper rw = new ResourceWrapperDirect(this, res);
    renderReference(rw, x, r);
  }

  public void renderReference(ResourceWrapper rw, XhtmlNode x, Reference r) throws UnsupportedEncodingException, IOException {
    XhtmlNode c = x;
    ResourceWithReference tr = null;
    if (r.hasReferenceElement()) {
      tr = resolveReference(rw, r.getReference());

      if (!r.getReference().startsWith("#")) {
        if (tr != null && tr.getReference() != null)
          c = x.ah(tr.getReference());
        else
          c = x.ah(r.getReference());
      }
    }
    // what to display: if text is provided, then that. if the reference was resolved, then show the generated narrative
    if (r.hasDisplayElement()) {
      c.addText(r.getDisplay());
      if (tr != null && tr.getResource() != null) {
        c.tx(". Generated Summary: ");
        new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), true, r.getReference().startsWith("#"));
      }
    } else if (tr != null && tr.getResource() != null) {
      new ProfileDrivenRenderer(context).generateResourceSummary(c, tr.getResource(), r.getReference().startsWith("#"), r.getReference().startsWith("#"));
    } else {
      c.addText(r.getReference());
    }
  }

  protected ResourceWithReference resolveReference(ResourceWrapper res, String url) {
    if (url == null)
      return null;
    if (url.startsWith("#")) {
      for (ResourceWrapper r : res.getContained()) {
        if (r.getId().equals(url.substring(1)))
          return new ResourceWithReference(null, r);
      }
      return null;
    }

    if (rcontext != null) {
      BundleEntryComponent bundleResource = rcontext.resolve(url);
      if (bundleResource != null) {
        String bundleUrl = "#" + bundleResource.getResource().getResourceType().name().toLowerCase() + "_" + bundleResource.getResource().getId(); 
        return new ResourceWithReference(bundleUrl, new ResourceWrapperDirect(this, bundleResource.getResource()));
      }
      org.hl7.fhir.r5.elementmodel.Element bundleElement = rcontext.resolveElement(url);
      if (bundleElement != null) {
        String bundleUrl = null;
        if (bundleElement.getNamedChild("resource").getChildValue("id") != null) {
          bundleUrl = "#" + bundleElement.fhirType().toLowerCase() + "_" + bundleElement.getNamedChild("resource").getChildValue("id");
        } else {
          bundleUrl = "#" +fullUrlToAnchor(bundleElement.getChildValue("fullUrl"));          
        }
        return new ResourceWithReference(bundleUrl, new ResourceWrapperMetaElement(this, bundleElement));
      }
    }

    Resource ae = getContext().getWorker().fetchResource(null, url);
    if (ae != null)
      return new ResourceWithReference(url, new ResourceWrapperDirect(this, ae));
    else if (context.getResolver() != null) {
      return context.getResolver().resolve(url);
    } else
      return null;
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


}