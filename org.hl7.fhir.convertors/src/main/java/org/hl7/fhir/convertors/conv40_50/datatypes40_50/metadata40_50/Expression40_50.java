package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.ExtensionHelper;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.Expression;

public class Expression40_50 {

  public static org.hl7.fhir.r5.model.Expression convertExpression(org.hl7.fhir.r4.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Expression tgt = new org.hl7.fhir.r5.model.Expression();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id40_50.convertIdToCode(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Expression convertExpression(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Expression tgt = new org.hl7.fhir.r5.model.Expression();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE);
    if (src.hasValue()) tgt.setExpression(src.getValue());
    if (src.hasExtension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE)) {
      org.hl7.fhir.r4.model.CodeType code = (org.hl7.fhir.r4.model.CodeType) ExtensionHelper.getExtension(src, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE).getValue();
      tgt.setLanguageElement(Code40_50.convertCode(code));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Expression convertExpression(org.hl7.fhir.r5.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Expression tgt = new org.hl7.fhir.r4.model.Expression();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id40_50.convertId(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertString(Expression src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasExpression()) tgt.setValue(src.getExpression());
    if (src.hasLanguage()) tgt.addExtension(new Extension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE,
      Code40_50.convertCode(src.getLanguageElement())));
    return tgt;
  }
}
