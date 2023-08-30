package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.ImplementationGuide;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ImplementationGuideRenderer extends ResourceRenderer {

  public ImplementationGuideRenderer(RenderingContext context) {
    super(context);
  }

  public ImplementationGuideRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (ImplementationGuide) dr);
  }

  public boolean render(XhtmlNode x, ImplementationGuide ig) throws FHIRFormatError, DefinitionException, IOException {
    x.h2().addText(ig.getName());
    x.para().tx("The official URL for this implementation guide is: ");
    x.pre().tx(ig.getUrl());
    addMarkdown(x, ig.getDescription());
    return true;
  }

  public void describe(XhtmlNode x, ImplementationGuide ig) {
    x.tx(display(ig));
  }

  public String display(ImplementationGuide ig) {
    return ig.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((ImplementationGuide) r).present();
  }

  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    if (r.has("title")) {
      return r.children("title").get(0).getBase().primitiveValue();
    }
    if (r.has("name")) {
      return r.children("name").get(0).getBase().primitiveValue();
    }
    return "??";
  }

}
