package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class EncounterRenderer extends ResourceRenderer {


  public EncounterRenderer(RenderingContext context) {
    super(context);
  }

  public boolean render(XhtmlNode x, DomainResource dr) throws UnsupportedEncodingException, IOException {
    describe(x, dr);
    return false;
  }

  public String display(Resource dr) {
    return "Not done yet";
  }

}