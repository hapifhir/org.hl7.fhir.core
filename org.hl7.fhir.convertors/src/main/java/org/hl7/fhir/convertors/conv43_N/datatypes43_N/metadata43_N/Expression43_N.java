package org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Extension;
import org.hl7.fhir.r4b.model.ExtensionHelper;
import org.hl7.fhir.r4b.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.Expression;

public class Expression43_N {

  public static org.hl7.fhir.model.core.Expression convertExpression(org.hl7.fhir.r4b.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Expression tgt = new org.hl7.fhir.model.core.Expression();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id43_N.convertIdToCode(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Expression convertExpression(org.hl7.fhir.r4b.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Expression tgt = new org.hl7.fhir.model.core.Expression();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE);
    if (src.hasValue()) tgt.setExpression(src.getValue());
    if (src.hasExtension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE)) {
      org.hl7.fhir.r4b.model.CodeType code = (org.hl7.fhir.r4b.model.CodeType) ExtensionHelper.getExtension(src, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE).getValue();
      tgt.setLanguageElement(Code43_N.convertCode(code));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Expression convertExpression(org.hl7.fhir.model.core.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Expression tgt = new org.hl7.fhir.r4b.model.Expression();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String43_N.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertString(Expression src) {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.StringType tgt = new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasExpression()) tgt.setValue(src.getExpression());
    if (src.hasLanguage()) tgt.addExtension(new Extension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE,
      Code43_N.convertCode(src.getLanguageElement())));
    return tgt;
  }
}
