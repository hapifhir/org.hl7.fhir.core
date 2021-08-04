package org.hl7.fhir.convertors.advisors.support;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Expression;

import javax.annotation.Nonnull;

public class ExpressionAdvisor50 extends BaseAdvisor_10_50 {

  public boolean useAdvisorForExtension(@Nonnull String path, @Nonnull org.hl7.fhir.r5.model.Extension ext) {
    return ext.hasValue() && ext.getValue() instanceof org.hl7.fhir.r5.model.Expression;
  }

  public void handleExtension(@Nonnull String path, @Nonnull org.hl7.fhir.r5.model.Extension src, @Nonnull org.hl7.fhir.dstu2.model.Extension tgt) {
    if (src.getValue() instanceof org.hl7.fhir.r5.model.Expression) {
      StringType type = new StringType();
      if (src.getValue() == null) {
        throw new NullPointerException("null cannot be cast to non-null type org.hl7.fhir.r5.model.Expression");
      } else {
        type.setValueAsString(((Expression) src.getValue()).getExpression());
        tgt.setValue(type);
        if (src.hasUrlElement()) {
          tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
        }
      }
    } else {
      throw new FHIRException("Unknown extension type passed in to custom convertor method.");
    }
  }
}