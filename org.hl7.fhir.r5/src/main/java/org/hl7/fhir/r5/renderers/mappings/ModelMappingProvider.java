package org.hl7.fhir.r5.renderers.mappings;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.HierarchicalTableGenerator.Cell;

public abstract class ModelMappingProvider {
  protected RenderingContext context;
  protected StructureDefinition dest;
  protected boolean reverse;

  public ModelMappingProvider(RenderingContext context, StructureDefinition dest, boolean reverse) {
    super();
    this.context = context;
    this.dest = dest;
    this.reverse = reverse;
  }

  public abstract Column makeColumn(String id);

  public abstract void render(ElementDefinition element, XhtmlNode div);


  protected String ref() {
    return dest.getWebPath(); // context.getPkp().getDefinitionsName(dest);
  }
}
