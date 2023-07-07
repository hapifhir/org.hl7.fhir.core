package org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Utilities40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ParameterDefinition40_50 {
  public static org.hl7.fhir.r5.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r4.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ParameterDefinition tgt = new org.hl7.fhir.r5.model.ParameterDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code40_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String40_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities40_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ParameterDefinition convertParameterDefinition(org.hl7.fhir.r5.model.ParameterDefinition src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ParameterDefinition tgt = new org.hl7.fhir.r4.model.ParameterDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasName()) tgt.setNameElement(Code40_50.convertCode(src.getNameElement()));
    if (src.hasUse()) tgt.setUseElement(convertParameterUse(src.getUseElement()));
    if (src.hasMin()) tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
    if (src.hasMax()) tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation()) tgt.setDocumentationElement(String40_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities40_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    if (src.hasProfile()) tgt.setProfileElement(Canonical40_50.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> convertParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ParameterDefinition.ParameterUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.ParameterDefinition.ParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }
}
