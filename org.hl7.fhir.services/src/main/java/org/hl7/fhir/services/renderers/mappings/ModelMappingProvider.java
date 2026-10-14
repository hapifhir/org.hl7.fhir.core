package org.hl7.fhir.services.renderers.mappings;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.IOException;

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

  public abstract void render(ElementDefinition element, XhtmlNode div) throws IOException;


  protected String ref() {
    return dest.getWebPath(); // context.getPkp().getDefinitionsName(dest);
  }

  /** return the number of rows that value values
   *
   * @return
   */
    public abstract int valueCount();
}
