package org.hl7.fhir.convertors.advisors.support;

import kotlin.jvm.internal.Intrinsics;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseExtension;
import org.hl7.fhir.r4.model.Expression;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Type;
import org.jetbrains.annotations.NotNull;

public final class ExpressionAdvisor40 extends BaseAdvisor_10_40 {
  public boolean useAdvisorForExtension(@NotNull String path, @NotNull Extension ext) throws FHIRException {
    return ext.hasValue() && ext.getValue() instanceof Expression;
  }

  public void handleExtension(@NotNull String path, @NotNull Extension src, @NotNull org.hl7.fhir.dstu2.model.Extension tgt) throws FHIRException {
    if (src.getValue() instanceof Expression) {
      StringType type = new StringType();
      if (src.getValue() == null) {
        throw new NullPointerException("null cannot be cast to non-null type org.hl7.fhir.r4.model.Expression");
      } else {
        type.setValueAsString(((Expression)src.getValue()).getExpression());
        tgt.setValue((org.hl7.fhir.dstu2.model.Type)type);
        if (src.hasUrlElement()) {
          tgt.setUrlElement(VersionConvertor_10_40.convertUri(src.getUrlElement()));
        }
      }
    } else {
      throw new FHIRException("Unknown extension type passed in to custom convertor method.");
    }
  }
}