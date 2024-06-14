package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceElement;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class ImplementationGuideRenderer extends ResourceRenderer {

  public ImplementationGuideRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, ResourceElement r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    throw new Error("ImplementationGuideRenderer only renders native resources directly");
  }
  
  @Override
  public void renderResource(RenderingStatus status, XhtmlNode x, DomainResource r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    render(status, x, (ImplementationGuide) r);
  }
  
  @Override
  public String displayResource(ResourceElement r) throws UnsupportedEncodingException, IOException {
    return canonicalTitle(r);
  }


  public void render(RenderingStatus status, XhtmlNode x, ImplementationGuide ig) throws FHIRFormatError, DefinitionException, IOException {
    x.h2().addText(ig.getName());
    x.para().tx(context.formatPhrase(RenderingContext.IMP_GUIDE_URL)+" ");
    x.pre().tx(ig.getUrl());
    addMarkdown(x, ig.getDescription());
  }

  public void describe(XhtmlNode x, ImplementationGuide ig) {
    x.tx(display(ig));
  }

  public String display(ImplementationGuide ig) {
    return ig.present();
  }


}
