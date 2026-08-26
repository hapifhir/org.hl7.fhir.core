package org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.ExtensionHelper;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.Expression;

public class Expression40_N {

  public static org.hl7.fhir.model.core.Expression convertExpression(org.hl7.fhir.r4.model.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Expression tgt = new org.hl7.fhir.model.core.Expression();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id40_N.convertIdToCode(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Expression convertExpression(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Expression tgt = new org.hl7.fhir.model.core.Expression();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE);
    if (src.hasValue()) tgt.setExpression(src.getValue());
    if (src.hasExtension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE)) {
      org.hl7.fhir.r4.model.CodeType code = (org.hl7.fhir.r4.model.CodeType) ExtensionHelper.getExtension(src, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE).getValue();
      tgt.setLanguageElement(Code40_N.convertCode(code));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Expression convertExpression(org.hl7.fhir.model.core.Expression src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Expression tgt = new org.hl7.fhir.r4.model.Expression();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasDescription()) tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasName()) tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
    if (src.hasExpression()) tgt.setExpressionElement(String40_N.convertString(src.getExpressionElement()));
    if (src.hasReference()) tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertString(Expression src) {
    if (src == null) return null;
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasExpression()) tgt.setValue(src.getExpression());
    if (src.hasLanguage()) tgt.addExtension(new Extension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE,
      Code40_N.convertCode(src.getLanguageElement())));
    return tgt;
  }
}
