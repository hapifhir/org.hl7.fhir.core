package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class PatientRenderer extends ResourceRenderer {



  public PatientRenderer(RenderingContext context) {
    super(context);
  }

  public void render(Patient pat) {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasExtensions = render(x, pat);
    inject(pat, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public boolean render(XhtmlNode x, Patient pat) {
    describe(x, pat);
    return false;
  }

  public void describe(XhtmlNode x, Patient pat) {
    x.tx(display(pat));
  }

  public String display(Patient pat) {
    return "Not done yet";
  }

}
