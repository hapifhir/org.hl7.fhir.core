package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Encounter;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.MarkDownProcessor;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class EncounterRenderer extends ResourceRenderer {


  public EncounterRenderer(RenderingContext context) {
    super(context);
  }

  public void render(Encounter enc) {  
    XhtmlNode x = new XhtmlNode(NodeType.Element, "div");
    boolean hasExtensions = render(x, enc);
    inject(enc, x, hasExtensions ? NarrativeStatus.EXTENSIONS :  NarrativeStatus.GENERATED);
  }

  public boolean render(XhtmlNode x, Encounter enc) {
    describe(x, enc);
    return false;
  }

  public void describe(XhtmlNode x, Encounter enc) {
    x.tx(display(enc));
  }

  public String display(Encounter enc) {
    return "Not done yet";
  }

}
