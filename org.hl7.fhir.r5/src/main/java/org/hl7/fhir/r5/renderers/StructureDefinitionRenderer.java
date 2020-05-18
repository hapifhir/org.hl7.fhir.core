package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class StructureDefinitionRenderer extends ResourceRenderer {

  public StructureDefinitionRenderer(RenderingContext context) {
    super(context);
  }

  public StructureDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, DomainResource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (StructureDefinition) dr);
  }

  public boolean render(XhtmlNode x, StructureDefinition sd) throws FHIRFormatError, DefinitionException, IOException {
    x.getChildNodes().add(context.getProfileUtilities().generateTable(context.getDefinitionsTarget(), sd, true, context.getDestDir(), false, sd.getId(), false, context.getPrefix(), "", false, false, null, false));
    return true;
  }

  public void describe(XhtmlNode x, StructureDefinition sd) {
    x.tx(display(sd));
  }

  public String display(StructureDefinition sd) {
    return sd.present();
  }

  @Override
  public String display(DomainResource r) throws UnsupportedEncodingException, IOException {
    return ((StructureDefinition) r).present();
  }

}
