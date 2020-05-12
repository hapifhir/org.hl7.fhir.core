package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class PatientRenderer extends ResourceRenderer {



  public PatientRenderer(RenderingContext context) {
    super(context);
  }

  public boolean render(XhtmlNode x, DomainResource dr) throws UnsupportedEncodingException, IOException {
    describe(x, dr);
    return false;
  }

  public String display(DomainResource dr) {
    return "Not done yet";
  }

}