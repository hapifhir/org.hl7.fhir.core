package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ImplementationGuideRenderer extends ResourceRenderer {

  public ImplementationGuideRenderer(RenderingContext context) {
    super(context);
  }

  public ImplementationGuideRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, DomainResource dr) throws FHIRFormatError, DefinitionException, IOException {
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

}
