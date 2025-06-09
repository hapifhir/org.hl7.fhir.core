package org.hl7.fhir.r5.renderers.mappings;

import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionMappingComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent;
import org.hl7.fhir.r5.renderers.StructureDefinitionRenderer.Column;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class StructureDefinitionMappingProvider extends ModelMappingProvider {

  private StructureDefinition sd;
  private StructureDefinitionMappingComponent map;

  public StructureDefinitionMappingProvider(RenderingContext context, StructureDefinition dest, boolean reverse, StructureDefinition sd, StructureDefinitionMappingComponent map) {
    super(context, dest, reverse);
    this.sd = sd;
    this.map = map;
  }

  @Override
  public Column makeColumn(String id) {
    return new Column(id, map.getName(), dest.present(), null);
  }

  @Override
  public void render(ElementDefinition element, XhtmlNode div) {
    ElementDefinitionMappingComponent m = null;
    for (ElementDefinitionMappingComponent t : element.getMapping()) {
      if (t.hasIdentity() && m.getIdentity().equals(map.getIdentity())) {
        m = t;
      }
    }
    if (m != null) {
      String[] maps = m.getMap().split("\\,");
      if (maps.length == 1) {
        renderMap(div, maps[0]);
      } else {
        XhtmlNode ul = div.ul();
        for (String s : maps) {
          renderMap(ul.li(), s);
        }
      }
    }
  }

  private void renderMap(XhtmlNode x, String s) {
    // the approved syntax is id: fhirPath, or it's just rendered directly
    if (s.contains(":")) {
      String l = s.substring(0, s.indexOf(":"));
      String r = s.substring(s.indexOf(":")+1);
      x.ah(ref()+"#"+l, l).tx(r);
    } else {
      x.tx(s);
    }
  }
}