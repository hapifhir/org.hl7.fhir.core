package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

@MarkedToMoveToAdjunctPackage
public class ImplementationGuideRenderer extends ResourceRenderer {

  public ImplementationGuideRenderer(RenderingContext context) { 
    super(context); 
  } 
 
  @Override
  public void buildNarrative(RenderingStatus status, XhtmlNode x, ResourceWrapper r) throws FHIRFormatError, DefinitionException, IOException, FHIRException, EOperationOutcome {
    if (r.isDirect()) {    
      renderResourceTechDetails(r, x);
      genSummaryTable(status, x, (ImplementationGuide) r.getBase());
      render(status, x, (ImplementationGuide) r.getBase());      
    } else {
      // the intention is to change this in the future
      x.para().tx("ImplementationGuideRenderer only renders native resources directly");
    }
  }
  
  @Override
  public String buildSummary(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
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
