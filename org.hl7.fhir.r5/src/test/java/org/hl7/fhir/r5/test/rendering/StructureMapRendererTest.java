package org.hl7.fhir.r5.test.rendering;

import java.util.ArrayList;

import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.FmlParser;
import org.hl7.fhir.r5.renderers.RendererFactory;
import org.hl7.fhir.r5.renderers.ResourceRenderer;
import org.hl7.fhir.r5.renderers.StructureMapRenderer;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.r5.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.r5.renderers.utils.ResourceWrapper;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StructureMapRendererTest {

  private static final String FML = """
      map "http://example.org/StructureMap/Test" = "Test"

      uses "http://hl7.org/fhir/StructureDefinition/Patient" alias Patient as source
      uses "http://hl7.org/fhir/StructureDefinition/Patient" alias Patient as target

      group Test(source src : Patient, target tgt : Patient) {
        src -> tgt "copy";
      }
      """;

  @Test
  public void testElementModelUsesStructureMapRenderer() throws Exception {
    IWorkerContext worker = TestingUtilities.getSharedWorkerContext("5.0.0");
    Element map = new FmlParser(worker, null).parse(new ArrayList<ValidationMessage>(), FML);
    RendererFactory rendererFactory = new RendererFactory();
    RenderingContext context = new RenderingContext(worker, rendererFactory, null, null, "http://hl7.org/fhir", "", null,
        ResourceRendererMode.TECHNICAL, GenerationRules.VALID_RESOURCE);
    ResourceWrapper wrapper = ResourceWrapper.forResource(context.getContextUtilities(), map);

    ResourceRenderer renderer = rendererFactory.factory(wrapper, context);
    XhtmlNode narrative = renderer.buildNarrative(wrapper);

    Assertions.assertInstanceOf(StructureMapRenderer.class, renderer);
    Assertions.assertTrue(rendererFactory.hasSpecificRenderer("StructureMap"));
    Assertions.assertTrue(narrative.allText().contains("http://example.org/StructureMap/Test"));
    Assertions.assertTrue(narrative.allText().contains("group Test"));
  }
}