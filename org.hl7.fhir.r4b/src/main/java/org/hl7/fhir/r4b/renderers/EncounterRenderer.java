package org.hl7.fhir.r4b.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.r4b.model.DomainResource;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.renderers.utils.RenderingContext;
import org.hl7.fhir.r4b.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class EncounterRenderer extends ResourceRenderer {


  public EncounterRenderer(RenderingContext context) {
    super(context);
  }

  public boolean render(XhtmlNode x, Resource dr) throws UnsupportedEncodingException, IOException {
    describe(x, dr);
    return false;
  }

  public String display(Resource dr) {
    return "Not done yet";
  }

  @Override
  public String display(ResourceWrapper r) throws UnsupportedEncodingException, IOException {
    return "Not done yet";
  }


}