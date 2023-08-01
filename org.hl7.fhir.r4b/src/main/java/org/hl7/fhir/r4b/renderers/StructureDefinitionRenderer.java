package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r4b.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class StructureDefinitionRenderer extends ResourceRenderer {

  public StructureDefinitionRenderer(RenderingContext context) {
    super(context);
  }

  public StructureDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }

  public boolean render(XhtmlNode x, Resource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (StructureDefinition) dr);
  }

  public boolean render(XhtmlNode x, StructureDefinition sd) throws FHIRFormatError, DefinitionException, IOException {
    x.getChildNodes()
        .add(context.getProfileUtilities().generateTable(context.getDefinitionsTarget(), sd, true, context.getDestDir(),
            false, sd.getId(), false, context.getSpecificationLink(), "", false, false, null, false, false, context));
    return true;
  }

  public void describe(XhtmlNode x, StructureDefinition sd) {
    x.tx(display(sd));
  }

  public String display(StructureDefinition sd) {
    return sd.present();
  }

  @Override
  public String display(Resource r) throws UnsupportedEncodingException, IOException {
    return ((StructureDefinition) r).present();
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
