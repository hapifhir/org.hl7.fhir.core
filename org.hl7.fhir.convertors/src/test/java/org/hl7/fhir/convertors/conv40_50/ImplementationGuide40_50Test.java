package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.junit.jupiter.api.Test;

public class ImplementationGuide40_50Test {

  public void testProduceIllegalParameters() throws IOException {
    ImplementationGuide r5_actual = getR5ImplementationGuide();

    org.hl7.fhir.r4.model.ImplementationGuide converted = (org.hl7.fhir.r4.model.ImplementationGuide) VersionConvertorFactory_40_50.convertResource(
      r5_actual,
      new BaseAdvisor_40_50(true, true));

    assertEquals(2, converted.getDefinition().getParameter().size());
    assertEquals("copyrightyear", converted.getDefinition().getParameter().get(1).getCode());
    assertEquals("2020+", converted.getDefinition().getParameter().get(1).getValue());
  }

  @Test
  public void testDefaultParameters() throws IOException {
    ImplementationGuide r5_actual = getR5ImplementationGuide();

    org.hl7.fhir.r4.model.ImplementationGuide converted = (org.hl7.fhir.r4.model.ImplementationGuide) VersionConvertorFactory_40_50.convertResource(r5_actual);

    assertEquals(1, converted.getDefinition().getParameter().size());
    assertEquals("copyrightyear", converted.getDefinition().getExtension().get(0).getExtension().get(0).getValue().primitiveValue());
    assertEquals("2020+", converted.getDefinition().getExtension().get(0).getExtension().get(1).getValue().primitiveValue());

  }

  private ImplementationGuide getR5ImplementationGuide() throws IOException {
    ImplementationGuide r5_actual;
    InputStream r5_stream = this.getClass().getResourceAsStream("/implementation_guide_50.json");
    r5_actual = (ImplementationGuide) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_stream);
    return r5_actual;
  }
}
